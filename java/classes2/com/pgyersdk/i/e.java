package com.pgyersdk.i;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Instrumented
public class e
{
  private final String a;
  private String b;
  private String c;
  private j d;
  private int e = 120000;
  private final Map f;
  
  public e(String paramString)
  {
    this.a = paramString;
    this.f = new HashMap();
  }
  
  public e a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public e a(String paramString1, String paramString2)
  {
    this.f.put(paramString1, paramString2);
    return this;
  }
  
  public e a(Map paramMap, Context paramContext, File paramFile, List paramList)
  {
    try
    {
      this.d = new j();
      this.d.b();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.d.a(str, (String)paramMap.get(str));
      }
      if (paramFile == null) {
        break label241;
      }
    }
    catch (IOException paramMap)
    {
      throw new RuntimeException(paramMap);
    }
    paramMap = new FileInputStream(paramFile.getAbsolutePath());
    this.d.a("voice", paramFile.getName(), paramMap, "audio/wav", false);
    break label241;
    int i;
    if (i < paramList.size())
    {
      paramFile = (Uri)paramList.get(i);
      if (i != paramList.size() - 1) {
        break label252;
      }
    }
    label241:
    label252:
    for (boolean bool = true;; bool = false)
    {
      paramMap = paramContext.getContentResolver().openInputStream(paramFile);
      paramFile = paramFile.getLastPathSegment();
      this.d.a("image[]", paramFile, paramMap, bool);
      i += 1;
      break;
      do
      {
        this.d.c();
        a("Content-Type", "multipart/form-data; boundary=" + this.d.a());
        return this;
      } while (paramList == null);
      i = 0;
      break;
    }
  }
  
  public HttpURLConnection a()
  {
    try
    {
      Object localObject1 = new URL(this.a);
      if (!(localObject1 instanceof URL))
      {
        localObject1 = ((URL)localObject1).openConnection();
        localObject1 = (HttpURLConnection)localObject1;
        ((HttpURLConnection)localObject1).setConnectTimeout(this.e);
        ((HttpURLConnection)localObject1).setReadTimeout(this.e);
        if (Build.VERSION.SDK_INT <= 9) {
          ((HttpURLConnection)localObject1).setRequestProperty("Connection", "close");
        }
        if (!TextUtils.isEmpty(this.b))
        {
          ((HttpURLConnection)localObject1).setRequestMethod(this.b);
          if ((!TextUtils.isEmpty(this.c)) || (this.b.equalsIgnoreCase("POST")) || (this.b.equalsIgnoreCase("PUT"))) {
            ((HttpURLConnection)localObject1).setDoOutput(true);
          }
        }
        localObject2 = this.f.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          ((HttpURLConnection)localObject1).setRequestProperty(str, (String)this.f.get(str));
        }
      }
    }
    catch (IOException localIOException)
    {
      Object localObject2;
      URLConnection localURLConnection;
      for (;;)
      {
        throw new RuntimeException(localIOException);
        localURLConnection = HttpInstrumentation.openConnection((URL)localIOException);
      }
      if (!TextUtils.isEmpty(this.c))
      {
        localObject2 = new BufferedWriter(new OutputStreamWriter(localURLConnection.getOutputStream(), "UTF-8"));
        ((BufferedWriter)localObject2).write(this.c);
        ((BufferedWriter)localObject2).flush();
        ((BufferedWriter)localObject2).close();
      }
      if (this.d != null)
      {
        localURLConnection.setRequestProperty("Content-Length", String.valueOf(this.d.d()));
        localObject2 = new BufferedOutputStream(localURLConnection.getOutputStream());
        ((BufferedOutputStream)localObject2).write(this.d.e().toByteArray());
        ((BufferedOutputStream)localObject2).flush();
        ((BufferedOutputStream)localObject2).close();
      }
      return localURLConnection;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/i/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */