package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Instrumented
public class HttpUrlConnectionNetworkFetcher
  extends BaseNetworkFetcher<FetchState>
{
  public static final int HTTP_PERMANENT_REDIRECT = 308;
  public static final int HTTP_TEMPORARY_REDIRECT = 307;
  private static final int MAX_REDIRECTS = 5;
  private static final int NUM_NETWORK_THREADS = 3;
  private final ExecutorService mExecutorService;
  
  public HttpUrlConnectionNetworkFetcher()
  {
    this(Executors.newFixedThreadPool(3));
  }
  
  @VisibleForTesting
  HttpUrlConnectionNetworkFetcher(ExecutorService paramExecutorService)
  {
    this.mExecutorService = paramExecutorService;
  }
  
  private HttpURLConnection downloadFrom(Uri paramUri, int paramInt)
    throws IOException
  {
    Object localObject = openConnectionTo(paramUri);
    int i = ((HttpURLConnection)localObject).getResponseCode();
    if (isHttpSuccess(i)) {
      return (HttpURLConnection)localObject;
    }
    if (isHttpRedirect(i))
    {
      String str = ((HttpURLConnection)localObject).getHeaderField("Location");
      ((HttpURLConnection)localObject).disconnect();
      if (str == null) {}
      for (localObject = null;; localObject = Uri.parse(str))
      {
        str = paramUri.getScheme();
        if ((paramInt <= 0) || (localObject == null) || (((Uri)localObject).getScheme().equals(str))) {
          break;
        }
        return downloadFrom((Uri)localObject, paramInt - 1);
      }
      if (paramInt == 0) {}
      for (paramUri = error("URL %s follows too many redirects", new Object[] { paramUri.toString() });; paramUri = error("URL %s returned %d without a valid redirect", new Object[] { paramUri.toString(), Integer.valueOf(i) })) {
        throw new IOException(paramUri);
      }
    }
    ((HttpURLConnection)localObject).disconnect();
    throw new IOException(String.format("Image URL %s returned HTTP code %d", new Object[] { paramUri.toString(), Integer.valueOf(i) }));
  }
  
  private static String error(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.getDefault(), paramString, paramVarArgs);
  }
  
  private static boolean isHttpRedirect(int paramInt)
  {
    switch (paramInt)
    {
    case 304: 
    case 305: 
    case 306: 
    default: 
      return false;
    }
    return true;
  }
  
  private static boolean isHttpSuccess(int paramInt)
  {
    return (paramInt >= 200) && (paramInt < 300);
  }
  
  @VisibleForTesting
  static HttpURLConnection openConnectionTo(Uri paramUri)
    throws IOException
  {
    paramUri = new URL(paramUri.toString());
    if (!(paramUri instanceof URL)) {}
    for (paramUri = paramUri.openConnection();; paramUri = HttpInstrumentation.openConnection((URL)paramUri)) {
      return (HttpURLConnection)paramUri;
    }
  }
  
  public FetchState createFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    return new FetchState(paramConsumer, paramProducerContext);
  }
  
  public void fetch(final FetchState paramFetchState, final NetworkFetcher.Callback paramCallback)
  {
    final Future localFuture = this.mExecutorService.submit(new Runnable()
    {
      public void run()
      {
        HttpUrlConnectionNetworkFetcher.this.fetchSync(paramFetchState, paramCallback);
      }
    });
    paramFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        if (localFuture.cancel(false)) {
          paramCallback.onCancellation();
        }
      }
    });
  }
  
  @VisibleForTesting
  void fetchSync(FetchState paramFetchState, NetworkFetcher.Callback paramCallback)
  {
    Object localObject = null;
    FetchState localFetchState = null;
    try
    {
      paramFetchState = downloadFrom(paramFetchState.getUri(), 5);
      if (paramFetchState != null)
      {
        localFetchState = paramFetchState;
        localObject = paramFetchState;
        paramCallback.onResponse(paramFetchState.getInputStream(), -1);
      }
      if (paramFetchState != null) {
        paramFetchState.disconnect();
      }
      return;
    }
    catch (IOException paramFetchState)
    {
      do
      {
        localObject = localFetchState;
        paramCallback.onFailure(paramFetchState);
      } while (localFetchState == null);
      localFetchState.disconnect();
      return;
    }
    finally
    {
      if (localObject != null) {
        ((HttpURLConnection)localObject).disconnect();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/HttpUrlConnectionNetworkFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */