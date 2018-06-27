package com.freelxl.baselibrary.d.e;

import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.ziroom.commonlib.utils.l;
import com.ziroom.ziroomcoloreggs.eggs.a;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
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
    Object localObject = paramChain.request();
    d.e("OKHttp", "===" + ((Request)localObject).url());
    paramChain = paramChain.proceed((Request)localObject);
    d.e("OKHttp", "===" + paramChain.code() + ":" + paramChain.message());
    d.e("OKHttp", "===" + paramChain.peekBody(1024L).string());
    if (a.a)
    {
      e locale = new e();
      locale.put("url", paramChain.request().url().toString() + "");
      if (localObject != null)
      {
        locale.put("webType", ((Request)localObject).method() + "");
        if ("POST".equals(((Request)localObject).method()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("{");
          if ((((Request)localObject).body() instanceof FormBody))
          {
            localObject = (FormBody)((Request)localObject).body();
            int i = 0;
            while (i < ((FormBody)localObject).size())
            {
              localStringBuilder.append("\"" + ((FormBody)localObject).encodedName(i) + "\":\"" + ((FormBody)localObject).encodedValue(i) + "\",");
              i += 1;
            }
            localStringBuilder.delete(localStringBuilder.length() - 1, localStringBuilder.length());
            localStringBuilder.append("}");
            locale.put("params", localStringBuilder.toString());
          }
        }
      }
      locale.put("code", paramChain.code() + "");
      locale.put("resp", paramChain.peekBody(1048576L).string() + "");
      localObject = locale.get("url").toString();
      if (((String)localObject).substring(((String)localObject).length() - 5, ((String)localObject).length()).equals(".webp")) {
        d.d("webp", (String)localObject);
      }
      if ((!((String)localObject).substring(((String)localObject).length() - 4, ((String)localObject).length()).equals(".jpg")) && (!((String)localObject).substring(((String)localObject).length() - 4, ((String)localObject).length()).equals(".png")) && (!((String)localObject).substring(((String)localObject).length() - 4, ((String)localObject).length()).equals(".JPG")) && (!((String)localObject).substring(((String)localObject).length() - 4, ((String)localObject).length()).equals(".PNG")) && (!((String)localObject).substring(((String)localObject).length() - 5, ((String)localObject).length()).equals(".jpeg")) && (!((String)localObject).substring(((String)localObject).length() - 5, ((String)localObject).length()).equals(".webp"))) {
        l.writeWebLog(locale);
      }
    }
    return paramChain;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */