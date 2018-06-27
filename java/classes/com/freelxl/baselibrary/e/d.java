package com.freelxl.baselibrary.e;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class d<T>
{
  public static final Handler b = new Handler(Looper.getMainLooper());
  public static final ExecutorService c = Executors.newFixedThreadPool(4);
  boolean a = false;
  private Context d;
  private Class<T> e;
  private h f;
  private i.a<String> g;
  private final Executor h = new Executor()
  {
    public void execute(Runnable paramAnonymousRunnable)
    {
      d.b.post(paramAnonymousRunnable);
    }
  };
  
  public d(Context paramContext, h paramh, i.a<String> parama)
  {
    this(paramContext, paramh, false, null, parama);
  }
  
  public d(Context paramContext, h paramh, boolean paramBoolean, Class<T> paramClass, i.a<String> parama)
  {
    this.d = paramContext;
    this.f = paramh;
    this.g = parama;
    this.e = paramClass;
    this.a = paramBoolean;
  }
  
  private k a(String paramString, Class<T> paramClass)
  {
    k localk = new k();
    localk.setUrl(this.f.getUrl());
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        localk.setSuccess(Boolean.valueOf(false));
        localk.setMessage("返回数据为空");
        com.freelxl.baselibrary.f.d.e("HttpRequest", "autoParse - httpResponse --str is null");
        if (this.a)
        {
          dismissProgress();
          return localk;
        }
      }
      else
      {
        paramString = com.alibaba.fastjson.a.parseObject(paramString, paramClass);
        localk.setSuccess(Boolean.valueOf(true));
        localk.setObject(paramString);
        return localk;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      com.freelxl.baselibrary.f.d.e("HttpRequest", "gsonParse /ErrorMessage =  " + paramString.getMessage());
      localk.setSuccess(Boolean.valueOf(false));
      localk.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
      if (this.a) {
        dismissProgress();
      }
    }
    return localk;
  }
  
  private void a(String paramString)
  {
    if (this.e == null) {}
    for (paramString = b(paramString);; paramString = a(paramString, this.e))
    {
      this.h.execute(new j(paramString, this.g));
      if (this.a) {
        dismissProgress();
      }
      return;
    }
  }
  
  private k b(String paramString)
  {
    k localk = new k();
    localk.setUrl(this.f.getUrl());
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new Exception();
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      localk.setSuccess(Boolean.valueOf(false));
      localk.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
      if (this.a) {
        dismissProgress();
      }
      return localk;
    }
    this.g.onParse(paramString, localk);
    return localk;
  }
  
  public void dismissProgress()
  {
    if ((com.freelxl.baselibrary.widget.a.getDialog() != null) && (com.freelxl.baselibrary.widget.a.isShowing())) {
      com.freelxl.baselibrary.widget.a.dismiss();
    }
  }
  
  public void request()
  {
    if (this.a) {
      showProgress("");
    }
    c.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          String str = new f().request(d.a(d.this));
          com.freelxl.baselibrary.f.d.e("HttpResponse", "response  =  response" + str);
          d.a(d.this, str);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          com.freelxl.baselibrary.f.d.e("HttpRequest", "request /ErrorMessage =  " + localException.getMessage());
        }
      }
    });
  }
  
  public void requestHttps(final int paramInt)
  {
    if (this.a) {
      showProgress("");
    }
    c.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          Object localObject2 = CertificateFactory.getInstance("X.509");
          Object localObject1 = new BufferedInputStream(d.b(d.this).getResources().openRawResource(paramInt));
          try
          {
            localObject2 = ((CertificateFactory)localObject2).generateCertificate((InputStream)localObject1);
            System.out.println("ca=" + ((X509Certificate)localObject2).getSubjectDN());
            ((InputStream)localObject1).close();
            localObject1 = KeyStore.getInstance(KeyStore.getDefaultType());
            ((KeyStore)localObject1).load(null, null);
            ((KeyStore)localObject1).setCertificateEntry("ca", (Certificate)localObject2);
            localObject2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            ((TrustManagerFactory)localObject2).init((KeyStore)localObject1);
            localObject1 = SSLContext.getInstance("TLS");
            ((SSLContext)localObject1).init(null, ((TrustManagerFactory)localObject2).getTrustManagers(), null);
            d.a(d.this).setObj(localObject1);
            localObject1 = new f().request(d.a(d.this));
            d.a(d.this, (String)localObject1);
            return;
          }
          finally
          {
            ((InputStream)localObject1).close();
          }
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          com.freelxl.baselibrary.f.d.e("HttpRequest", "request /ErrorMessage =  " + localException.getMessage());
        }
      }
    });
  }
  
  public boolean showProgress(String paramString)
  {
    if ((com.freelxl.baselibrary.widget.a.getDialog() != null) && (com.freelxl.baselibrary.widget.a.isShowing()) && ((this.d instanceof Activity))) {
      return false;
    }
    com.freelxl.baselibrary.widget.a.show(this.d, paramString, false, true);
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */