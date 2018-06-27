package com.ziroom.ziroomcustomer.ziroomstation.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.j;
import com.freelxl.baselibrary.e.k;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c<T>
{
  public static final Handler d = new Handler(Looper.getMainLooper());
  public static final ExecutorService e = Executors.newFixedThreadPool(5);
  Map<String, Object> a;
  Map<String, Object> b;
  boolean c = false;
  private Context f;
  private byte[] g;
  private String h;
  private String i;
  private Class<T> j;
  private i.a<String> k;
  private final Executor l = new Executor()
  {
    public void execute(Runnable paramAnonymousRunnable)
    {
      c.d.post(paramAnonymousRunnable);
    }
  };
  
  public c(Context paramContext, boolean paramBoolean, Class<T> paramClass, i.a<String> parama, String paramString1, String paramString2, Map<String, Object> paramMap1, Map<String, Object> paramMap2, byte[] paramArrayOfByte)
  {
    this.f = paramContext;
    this.k = parama;
    this.j = paramClass;
    this.c = paramBoolean;
    this.h = paramString1;
    this.i = paramString2;
    this.a = paramMap1;
    this.b = paramMap2;
    this.g = paramArrayOfByte;
  }
  
  private k a(String paramString, Class<T> paramClass)
  {
    k localk = new k();
    localk.setUrl(this.h);
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        localk.setSuccess(Boolean.valueOf(false));
        localk.setMessage("返回数据为空");
        com.freelxl.baselibrary.f.d.e("HttpRequest", "autoParse - httpResponse --str is null");
        if (this.c)
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
      if (this.c) {
        dismissProgress();
      }
    }
    return localk;
  }
  
  private void a(String paramString)
  {
    if (this.j == null) {}
    for (paramString = b(paramString);; paramString = a(paramString, this.j))
    {
      this.l.execute(new j(paramString, this.k));
      if (this.c) {
        dismissProgress();
      }
      return;
    }
  }
  
  private k b(String paramString)
  {
    k localk = new k();
    localk.setUrl(this.h);
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
      if (this.c) {
        dismissProgress();
      }
      return localk;
    }
    this.k.onParse(paramString, localk);
    localk.setSuccess(Boolean.valueOf(true));
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
    if (this.c)
    {
      showProgress("");
      com.freelxl.baselibrary.f.d.i("HttpStationPicUpRequest", "显示Progressdialog");
    }
    e.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          String str = new d().httpUploadTo(c.a(c.this), c.b(c.this), c.c(c.this), c.this.a, c.this.b);
          c.a(c.this, str);
          return;
        }
        catch (Exception localException)
        {
          do
          {
            localException.printStackTrace();
            com.freelxl.baselibrary.f.d.e("HttpStationPicUpRequest", "request /ErrorMessage =  " + localException.getMessage());
          } while (!c.this.c);
          c.this.dismissProgress();
        }
      }
    });
  }
  
  public boolean showProgress(String paramString)
  {
    if ((com.freelxl.baselibrary.widget.a.getDialog() != null) && (com.freelxl.baselibrary.widget.a.isShowing()) && ((this.f instanceof Activity))) {
      return false;
    }
    com.freelxl.baselibrary.widget.a.show(this.f, paramString, false, true);
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */