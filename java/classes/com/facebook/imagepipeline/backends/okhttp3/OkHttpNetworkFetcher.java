package com.facebook.imagepipeline.backends.okhttp3;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher.Callback;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.CacheControl.Builder;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpNetworkFetcher
  extends BaseNetworkFetcher<OkHttpNetworkFetchState>
{
  private static final String FETCH_TIME = "fetch_time";
  private static final String IMAGE_SIZE = "image_size";
  private static final String QUEUE_TIME = "queue_time";
  private static final String TAG = "OkHttpNetworkFetchProducer";
  private static final String TOTAL_TIME = "total_time";
  private final Call.Factory mCallFactory;
  private Executor mCancellationExecutor;
  
  public OkHttpNetworkFetcher(Call.Factory paramFactory, Executor paramExecutor)
  {
    this.mCallFactory = paramFactory;
    this.mCancellationExecutor = paramExecutor;
  }
  
  public OkHttpNetworkFetcher(OkHttpClient paramOkHttpClient)
  {
    this(paramOkHttpClient, paramOkHttpClient.dispatcher().executorService());
  }
  
  private void handleException(Call paramCall, Exception paramException, NetworkFetcher.Callback paramCallback)
  {
    if (paramCall.isCanceled())
    {
      paramCallback.onCancellation();
      return;
    }
    paramCallback.onFailure(paramException);
  }
  
  public OkHttpNetworkFetchState createFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    return new OkHttpNetworkFetchState(paramConsumer, paramProducerContext);
  }
  
  public void fetch(OkHttpNetworkFetchState paramOkHttpNetworkFetchState, NetworkFetcher.Callback paramCallback)
  {
    paramOkHttpNetworkFetchState.submitTime = SystemClock.elapsedRealtime();
    Uri localUri = paramOkHttpNetworkFetchState.getUri();
    try
    {
      fetchWithRequest(paramOkHttpNetworkFetchState, paramCallback, new Request.Builder().cacheControl(new CacheControl.Builder().noStore().build()).url(localUri.toString()).get().build());
      return;
    }
    catch (Exception paramOkHttpNetworkFetchState)
    {
      paramCallback.onFailure(paramOkHttpNetworkFetchState);
    }
  }
  
  protected void fetchWithRequest(final OkHttpNetworkFetchState paramOkHttpNetworkFetchState, final NetworkFetcher.Callback paramCallback, final Request paramRequest)
  {
    paramRequest = this.mCallFactory.newCall(paramRequest);
    paramOkHttpNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          paramRequest.cancel();
          return;
        }
        OkHttpNetworkFetcher.this.mCancellationExecutor.execute(new Runnable()
        {
          public void run()
          {
            OkHttpNetworkFetcher.1.this.val$call.cancel();
          }
        });
      }
    });
    paramRequest.enqueue(new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        OkHttpNetworkFetcher.this.handleException(paramAnonymousCall, paramAnonymousIOException, paramCallback);
      }
      
      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
        l1 = 0L;
        paramOkHttpNetworkFetchState.responseTime = SystemClock.elapsedRealtime();
        localResponseBody = paramAnonymousResponse.body();
        try
        {
          if (!paramAnonymousResponse.isSuccessful())
          {
            OkHttpNetworkFetcher.this.handleException(paramAnonymousCall, new IOException("Unexpected HTTP code " + paramAnonymousResponse), paramCallback);
            try
            {
              localResponseBody.close();
              return;
            }
            catch (Exception paramAnonymousCall)
            {
              FLog.w("OkHttpNetworkFetchProducer", "Exception when closing response body", paramAnonymousCall);
              return;
            }
          }
          l2 = localResponseBody.contentLength();
          if (l2 >= 0L) {
            break label175;
          }
        }
        catch (Exception paramAnonymousResponse)
        {
          OkHttpNetworkFetcher.this.handleException(paramAnonymousCall, paramAnonymousResponse, paramCallback);
          try
          {
            localResponseBody.close();
            return;
          }
          catch (Exception paramAnonymousCall)
          {
            FLog.w("OkHttpNetworkFetchProducer", "Exception when closing response body", paramAnonymousCall);
            return;
          }
        }
        finally
        {
          for (;;)
          {
            long l2;
            try
            {
              localResponseBody.close();
              throw paramAnonymousCall;
            }
            catch (Exception paramAnonymousResponse)
            {
              FLog.w("OkHttpNetworkFetchProducer", "Exception when closing response body", paramAnonymousResponse);
              continue;
            }
            l1 = l2;
          }
        }
        paramCallback.onResponse(localResponseBody.byteStream(), (int)l1);
        try
        {
          localResponseBody.close();
          return;
        }
        catch (Exception paramAnonymousCall)
        {
          FLog.w("OkHttpNetworkFetchProducer", "Exception when closing response body", paramAnonymousCall);
          return;
        }
      }
    });
  }
  
  public Map<String, String> getExtraMap(OkHttpNetworkFetchState paramOkHttpNetworkFetchState, int paramInt)
  {
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("queue_time", Long.toString(paramOkHttpNetworkFetchState.responseTime - paramOkHttpNetworkFetchState.submitTime));
    localHashMap.put("fetch_time", Long.toString(paramOkHttpNetworkFetchState.fetchCompleteTime - paramOkHttpNetworkFetchState.responseTime));
    localHashMap.put("total_time", Long.toString(paramOkHttpNetworkFetchState.fetchCompleteTime - paramOkHttpNetworkFetchState.submitTime));
    localHashMap.put("image_size", Integer.toString(paramInt));
    return localHashMap;
  }
  
  public void onFetchCompletion(OkHttpNetworkFetchState paramOkHttpNetworkFetchState, int paramInt)
  {
    paramOkHttpNetworkFetchState.fetchCompleteTime = SystemClock.elapsedRealtime();
  }
  
  public static class OkHttpNetworkFetchState
    extends FetchState
  {
    public long fetchCompleteTime;
    public long responseTime;
    public long submitTime;
    
    public OkHttpNetworkFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
    {
      super(paramProducerContext);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/backends/okhttp3/OkHttpNetworkFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */