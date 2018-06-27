package com.ziroom.commonlib.ziroomhttp.e;

import android.util.Log;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class a
  implements Interceptor
{
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Request localRequest = paramChain.request();
    Log.e("OKHttp", "===" + localRequest.url());
    paramChain = paramChain.proceed(localRequest);
    Log.e("OKHttp", "===" + paramChain.code() + ":" + paramChain.message());
    Log.e("OKHttp", "===" + paramChain.peekBody(1024L).string());
    return paramChain;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/ziroomhttp/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */