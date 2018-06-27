package com.ziroom.commonlib.ziroomhttp.e;

import com.ziroom.commonlib.utils.l;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class b
  implements Interceptor
{
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Request localRequest = paramChain.request();
    l.e("OKHttp", "===" + localRequest.url());
    paramChain = paramChain.proceed(localRequest);
    l.e("OKHttp", "===" + paramChain.code() + ":" + paramChain.message());
    l.e("OKHttp", "===" + paramChain.peekBody(1024L).string());
    return paramChain;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/ziroomhttp/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */