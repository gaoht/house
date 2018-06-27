package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

public class NetworkFetchProducer
  implements Producer<EncodedImage>
{
  public static final String INTERMEDIATE_RESULT_PRODUCER_EVENT = "intermediate_result";
  public static final String PRODUCER_NAME = "NetworkFetchProducer";
  private static final int READ_SIZE = 16384;
  @VisibleForTesting
  static final long TIME_BETWEEN_PARTIAL_RESULTS_MS = 100L;
  private final ByteArrayPool mByteArrayPool;
  private final NetworkFetcher mNetworkFetcher;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  
  public NetworkFetchProducer(PooledByteBufferFactory paramPooledByteBufferFactory, ByteArrayPool paramByteArrayPool, NetworkFetcher paramNetworkFetcher)
  {
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mByteArrayPool = paramByteArrayPool;
    this.mNetworkFetcher = paramNetworkFetcher;
  }
  
  private static float calculateProgress(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      return paramInt1 / paramInt2;
    }
    return 1.0F - (float)Math.exp(-paramInt1 / 50000.0D);
  }
  
  @Nullable
  private Map<String, String> getExtraMap(FetchState paramFetchState, int paramInt)
  {
    if (!paramFetchState.getListener().requiresExtraMap(paramFetchState.getId())) {
      return null;
    }
    return this.mNetworkFetcher.getExtraMap(paramFetchState, paramInt);
  }
  
  private void handleFinalResult(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, FetchState paramFetchState)
  {
    Map localMap = getExtraMap(paramFetchState, paramPooledByteBufferOutputStream.size());
    paramFetchState.getListener().onProducerFinishWithSuccess(paramFetchState.getId(), "NetworkFetchProducer", localMap);
    notifyConsumer(paramPooledByteBufferOutputStream, true, paramFetchState.getConsumer());
  }
  
  private void maybeHandleIntermediateResult(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, FetchState paramFetchState)
  {
    long l = SystemClock.uptimeMillis();
    if ((shouldPropagateIntermediateResults(paramFetchState)) && (l - paramFetchState.getLastIntermediateResultTimeMs() >= 100L))
    {
      paramFetchState.setLastIntermediateResultTimeMs(l);
      paramFetchState.getListener().onProducerEvent(paramFetchState.getId(), "NetworkFetchProducer", "intermediate_result");
      notifyConsumer(paramPooledByteBufferOutputStream, false, paramFetchState.getConsumer());
    }
  }
  
  private void notifyConsumer(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, boolean paramBoolean, Consumer<EncodedImage> paramConsumer)
  {
    CloseableReference localCloseableReference = CloseableReference.of(paramPooledByteBufferOutputStream.toByteBuffer());
    try
    {
      localEncodedImage = new EncodedImage(localCloseableReference);
      EncodedImage.closeSafely(paramConsumer);
    }
    finally
    {
      try
      {
        localEncodedImage.parseMetaData();
        paramConsumer.onNewResult(localEncodedImage, paramBoolean);
        EncodedImage.closeSafely(localEncodedImage);
        CloseableReference.closeSafely(localCloseableReference);
        return;
      }
      finally
      {
        EncodedImage localEncodedImage;
        paramConsumer = localEncodedImage;
      }
      paramPooledByteBufferOutputStream = finally;
      paramConsumer = null;
    }
    CloseableReference.closeSafely(localCloseableReference);
    throw paramPooledByteBufferOutputStream;
  }
  
  private void onCancellation(FetchState paramFetchState)
  {
    paramFetchState.getListener().onProducerFinishWithCancellation(paramFetchState.getId(), "NetworkFetchProducer", null);
    paramFetchState.getConsumer().onCancellation();
  }
  
  private void onFailure(FetchState paramFetchState, Throwable paramThrowable)
  {
    paramFetchState.getListener().onProducerFinishWithFailure(paramFetchState.getId(), "NetworkFetchProducer", paramThrowable, null);
    paramFetchState.getConsumer().onFailure(paramThrowable);
  }
  
  private void onResponse(FetchState paramFetchState, InputStream paramInputStream, int paramInt)
    throws IOException
  {
    PooledByteBufferOutputStream localPooledByteBufferOutputStream;
    if (paramInt > 0) {
      localPooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream(paramInt);
    }
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = (byte[])this.mByteArrayPool.get(16384);
      try
      {
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i < 0) {
            break;
          }
          if (i > 0)
          {
            localPooledByteBufferOutputStream.write(arrayOfByte, 0, i);
            maybeHandleIntermediateResult(localPooledByteBufferOutputStream, paramFetchState);
            float f = calculateProgress(localPooledByteBufferOutputStream.size(), paramInt);
            paramFetchState.getConsumer().onProgressUpdate(f);
          }
        }
        localPooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream();
      }
      finally
      {
        this.mByteArrayPool.release(arrayOfByte);
        localPooledByteBufferOutputStream.close();
      }
    }
    this.mNetworkFetcher.onFetchCompletion(paramFetchState, localPooledByteBufferOutputStream.size());
    handleFinalResult(localPooledByteBufferOutputStream, paramFetchState);
    this.mByteArrayPool.release(arrayOfByte);
    localPooledByteBufferOutputStream.close();
  }
  
  private boolean shouldPropagateIntermediateResults(FetchState paramFetchState)
  {
    if (!paramFetchState.getContext().getImageRequest().getProgressiveRenderingEnabled()) {
      return false;
    }
    return this.mNetworkFetcher.shouldPropagate(paramFetchState);
  }
  
  public void produceResults(final Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    paramProducerContext.getListener().onProducerStart(paramProducerContext.getId(), "NetworkFetchProducer");
    paramConsumer = this.mNetworkFetcher.createFetchState(paramConsumer, paramProducerContext);
    this.mNetworkFetcher.fetch(paramConsumer, new NetworkFetcher.Callback()
    {
      public void onCancellation()
      {
        NetworkFetchProducer.this.onCancellation(paramConsumer);
      }
      
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        NetworkFetchProducer.this.onFailure(paramConsumer, paramAnonymousThrowable);
      }
      
      public void onResponse(InputStream paramAnonymousInputStream, int paramAnonymousInt)
        throws IOException
      {
        NetworkFetchProducer.this.onResponse(paramConsumer, paramAnonymousInputStream, paramAnonymousInt);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/NetworkFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */