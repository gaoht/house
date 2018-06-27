package com.freelxl.baselibrary.d.e;

import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.b;
import d.l;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;

public class c
  implements Interceptor
{
  private File a;
  
  public c(File paramFile)
  {
    this.a = paramFile;
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    int j = 200;
    Request localRequest = paramChain.request();
    Object localObject2 = null;
    localObject1 = localObject2;
    do
    {
      for (;;)
      {
        Object localObject4;
        int i;
        try
        {
          if (this.a != null)
          {
            localObject1 = localObject2;
            if (this.a.exists())
            {
              localObject1 = localObject2;
              if (this.a.isDirectory())
              {
                localHttpUrl = localRequest.url();
                localObject4 = localHttpUrl.encodedPath().substring(1).replace("/", "#");
                localObject1 = localObject4;
                if (TextUtils.isEmpty((CharSequence)localObject4)) {
                  localObject1 = "blank";
                }
                localObject4 = this.a.listFiles(new FilenameFilter()
                {
                  public boolean accept(File paramAnonymousFile, String paramAnonymousString)
                  {
                    return paramAnonymousString.equals(localObject1 + ".json");
                  }
                });
                localObject1 = localObject2;
                if (localObject4 != null)
                {
                  localObject1 = localObject2;
                  if (localObject4.length > 0)
                  {
                    localObject4 = a.parseArray(l.buffer(l.source(localObject4[0])).readUtf8());
                    localObject1 = localObject2;
                    if (localObject4 != null)
                    {
                      localObject1 = localObject2;
                      if (((b)localObject4).size() > 0)
                      {
                        localIterator1 = ((b)localObject4).iterator();
                        localObject2 = null;
                        localObject1 = localObject2;
                        localObject2 = localObject1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        catch (Exception localException1)
        {
          HttpUrl localHttpUrl;
          Iterator localIterator1;
          Iterator localIterator2;
          String str2;
          String str3;
          localObject1 = null;
          localException1.printStackTrace();
          Object localObject3 = localObject1;
          localObject1 = localObject3;
          continue;
        }
        try
        {
          if (!localIterator1.hasNext()) {
            continue;
          }
          localObject4 = (com.alibaba.fastjson.e)localIterator1.next();
          if (!((com.alibaba.fastjson.e)localObject4).containsKey("params")) {
            continue;
          }
          localObject2 = ((com.alibaba.fastjson.e)localObject4).getJSONObject("params");
          localIterator2 = ((com.alibaba.fastjson.e)localObject2).keySet().iterator();
          if (!localIterator2.hasNext()) {
            break label602;
          }
          str2 = (String)localIterator2.next();
          str3 = localHttpUrl.queryParameter(str2);
          if (str3 == null) {
            break label607;
          }
          if (str3.equals(((com.alibaba.fastjson.e)localObject2).getString(str2))) {}
        }
        catch (Exception localException2)
        {
          continue;
          i = 1;
          continue;
          i = 0;
          continue;
          localObject4 = "text/plain";
          continue;
          i = 200;
          continue;
          String str1 = "";
        }
      }
      localObject2 = localObject1;
    } while (i == 0);
    i = j;
    if (((com.alibaba.fastjson.e)localObject4).containsKey("code")) {
      i = ((com.alibaba.fastjson.e)localObject4).getInteger("code").intValue();
    }
    if (((com.alibaba.fastjson.e)localObject4).containsKey("resp")) {}
    for (localObject2 = ((com.alibaba.fastjson.e)localObject4).getString("resp"); ((com.alibaba.fastjson.e)localObject4).containsKey("mediaType"); localObject2 = "")
    {
      localObject4 = ((com.alibaba.fastjson.e)localObject4).getString("mediaType");
      localObject4 = MediaType.parse((String)localObject4);
      localObject2 = new Response.Builder().code(i).body(ResponseBody.create((MediaType)localObject4, (String)localObject2)).message("the response is from Mock-Data!").request(paramChain.request()).protocol(Protocol.HTTP_1_1).build();
      localObject1 = localObject2;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramChain.proceed(localRequest);
      }
      return (Response)localObject2;
    }
    if (((com.alibaba.fastjson.e)localObject4).containsKey("code"))
    {
      i = ((com.alibaba.fastjson.e)localObject4).getInteger("code").intValue();
      if (!((com.alibaba.fastjson.e)localObject4).containsKey("resp")) {
        break label626;
      }
      localObject2 = ((com.alibaba.fastjson.e)localObject4).getString("resp");
      if (((com.alibaba.fastjson.e)localObject4).containsKey("mediaType")) {}
      for (localObject4 = ((com.alibaba.fastjson.e)localObject4).getString("mediaType");; localObject4 = "text/plain")
      {
        localObject4 = MediaType.parse((String)localObject4);
        localObject2 = new Response.Builder().code(i).body(ResponseBody.create((MediaType)localObject4, (String)localObject2)).message("the response is from Mock-Data!").request(paramChain.request()).protocol(Protocol.HTTP_1_1).build();
        break;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */