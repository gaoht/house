package com.mato.sdk.e.b;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.proxy.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class h
{
  private static final String a = com.mato.sdk.b.g.b("");
  private static final int b = 10;
  private static final int c = 40;
  private static final int d = 90;
  private static final int e = 100;
  private static final int f = 200;
  private static final int g = 201;
  private static final int h = 202;
  private static final int i = 203;
  private static final int j = 204;
  private static final int k = 205;
  private static final int l = 206;
  private b m;
  private final Context n;
  private final ExecutorService o = Executors.newCachedThreadPool();
  private final WebView p;
  private k q;
  private g r;
  private f s;
  private final LinkedList<a> t = new LinkedList();
  private int u = 0;
  
  public h(Context paramContext, WebView paramWebView)
  {
    this.p = paramWebView;
    this.n = paramContext;
    paramContext = this.p.getSettings();
    paramContext.setAppCacheEnabled(true);
    paramContext.setCacheMode(1);
    paramContext.setDomStorageEnabled(true);
    paramContext.setJavaScriptEnabled(true);
    this.p.setWebViewClient(new WebViewClient()
    {
      public final void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        h.a(h.this).obtainMessage(206).sendToTarget();
      }
      
      public final boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        paramAnonymousWebView.loadUrl(paramAnonymousString);
        return true;
      }
    });
    this.m = new b(this);
  }
  
  private static String a(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    paramUri = paramContext.getContentResolver().query(paramUri, null, null, null, null);
    paramContext = (Context)localObject;
    if (paramUri != null)
    {
      paramUri.moveToFirst();
      paramContext = paramUri.getString(paramUri.getColumnIndex("_data"));
      paramUri.close();
    }
    return paramContext;
  }
  
  private static void a(Context paramContext, String paramString)
  {
    paramContext = com.mato.sdk.proxy.g.a(paramContext);
    String str = paramContext.b("picUris", "");
    if (str.equals("")) {}
    for (;;)
    {
      paramContext.d("picUris", paramString);
      return;
      paramString = str + ";" + paramString;
    }
  }
  
  private void a(final Bitmap paramBitmap, final String paramString)
  {
    this.o.execute(new Runnable()
    {
      public final void run()
      {
        try
        {
          h.a(h.b(h.this), paramBitmap, paramString);
          h.c();
          String str = paramString;
          paramBitmap.recycle();
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable = localThrowable;
          paramBitmap.recycle();
          return;
        }
        finally
        {
          localObject = finally;
          paramBitmap.recycle();
          throw ((Throwable)localObject);
        }
      }
    });
  }
  
  private void a(Message paramMessage)
  {
    int i3 = 0;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 10: 
      a((g)paramMessage.obj, 1);
      return;
    case 40: 
      a((g)paramMessage.obj, 2);
      return;
    case 90: 
      a((g)paramMessage.obj, 4);
      return;
    case 100: 
      a((g)paramMessage.obj, 15);
      return;
    }
    for (;;)
    {
      try
      {
        paramMessage = (a)this.t.removeFirst();
        i1 = paramMessage.b;
        if (paramMessage.b == 15)
        {
          paramMessage = Toast.makeText(this.n, "检测完成", 1);
          if (!(paramMessage instanceof Toast))
          {
            paramMessage.show();
            localObject1 = this.s;
            paramMessage = this.r;
            i1 = i3;
            if (paramMessage.u != null)
            {
              paramMessage = paramMessage.u.e;
              i1 = i3;
              if (paramMessage != null)
              {
                if (paramMessage.c()) {
                  continue;
                }
                i1 = i3;
              }
            }
            if (i1 != 0) {
              break;
            }
            this.m.obtainMessage(205).sendToTarget();
            g();
            return;
          }
          VdsAgent.showToast((Toast)paramMessage);
          continue;
          localObject1 = ((f)localObject1).b().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label667;
          }
          localObject2 = (Integer)((Iterator)localObject1).next();
          if ((((Integer)localObject2).intValue() <= 4999) || (((Integer)localObject2).intValue() >= 7000)) {
            continue;
          }
          i2 = 1;
          i1 = i3;
          if (i2 == 0) {
            continue;
          }
          this.m.obtainMessage(203).sendToTarget();
          a.b().a(paramMessage);
          this.m.sendEmptyMessageDelayed(204, 5000L);
          i1 = 1;
          continue;
        }
        e();
        return;
      }
      catch (Throwable paramMessage)
      {
        int i1;
        Object localObject1;
        Object localObject2;
        int i4;
        return;
      }
      paramMessage = Toast.makeText(this.n, "截屏成功，保存在手机相册", 1);
      if (!(paramMessage instanceof Toast))
      {
        paramMessage.show();
        return;
      }
      VdsAgent.showToast((Toast)paramMessage);
      return;
      j();
      i3 = this.p.getHeight();
      i4 = (int)Math.floor(this.p.getContentHeight() * this.p.getScale());
      paramMessage = com.mato.sdk.g.i.g(this.n);
      localObject1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
      i1 = 0;
      int i2 = 0;
      if (i1 < 10)
      {
        localObject2 = ((SimpleDateFormat)localObject1).format(new Date(System.currentTimeMillis()));
        a(String.format(Locale.US, "Maa-%s_%s_%d.jpg", new Object[] { localObject2, paramMessage, Integer.valueOf(i1) }));
        i2 += i3;
        if (i2 < i4)
        {
          this.p.scrollTo(0, i2);
          i1 += 1;
          continue;
        }
      }
      this.p.scrollTo(0, 0);
      this.m.obtainMessage(201).sendToTarget();
      return;
      paramMessage = Toast.makeText(this.n, "截屏失败", 1);
      if (!(paramMessage instanceof Toast))
      {
        paramMessage.show();
        this.p.loadUrl("javascript:showLoadRepairImg()");
        return;
      }
      VdsAgent.showToast((Toast)paramMessage);
      continue;
      this.p.loadUrl("javascript:showLoadRepairDoneImg()");
      g();
      return;
      this.p.loadUrl("javascript:removeLoadClass()");
      return;
      label667:
      i2 = 0;
    }
  }
  
  private void a(g paramg, int paramInt)
  {
    try
    {
      paramg = new a(paramg, paramInt);
      this.t.add(paramg);
      if (((a)this.t.getFirst()).c != 0) {
        e();
      }
      return;
    }
    catch (Throwable paramg) {}
  }
  
  private static boolean a(f paramf)
  {
    paramf = paramf.b().iterator();
    while (paramf.hasNext())
    {
      Integer localInteger = (Integer)paramf.next();
      if ((localInteger.intValue() > 4999) && (localInteger.intValue() < 7000)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(f paramf, g paramg)
  {
    if (paramg.u == null) {
      return false;
    }
    paramg = paramg.u.e;
    if ((paramg == null) || (!paramg.c())) {
      return false;
    }
    paramf = paramf.b().iterator();
    Integer localInteger;
    do
    {
      if (!paramf.hasNext()) {
        break;
      }
      localInteger = (Integer)paramf.next();
    } while ((localInteger.intValue() <= 4999) || (localInteger.intValue() >= 7000));
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      this.m.obtainMessage(203).sendToTarget();
      a.b().a(paramg);
      this.m.sendEmptyMessageDelayed(204, 5000L);
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    try
    {
      Bitmap localBitmap = i();
      if (localBitmap != null)
      {
        this.o.execute(new Runnable()
        {
          public final void run()
          {
            try
            {
              h.a(h.b(h.this), paramBitmap, paramString);
              h.c();
              String str = paramString;
              paramBitmap.recycle();
              return;
            }
            catch (Throwable localThrowable)
            {
              localThrowable = localThrowable;
              paramBitmap.recycle();
              return;
            }
            finally
            {
              localObject = finally;
              paramBitmap.recycle();
              throw ((Throwable)localObject);
            }
          }
        });
        return true;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static String b(Context paramContext, Bitmap paramBitmap, String paramString)
  {
    Object localObject1 = null;
    paramString = MediaStore.Images.Media.insertImage(paramContext.getContentResolver(), paramBitmap, paramString, "");
    if (paramString == null) {
      return null;
    }
    Object localObject2 = com.mato.sdk.proxy.g.a(paramContext);
    paramBitmap = ((com.mato.sdk.proxy.k)localObject2).b("picUris", "");
    if (paramBitmap.equals("")) {}
    for (paramBitmap = paramString;; paramBitmap = paramBitmap + ";" + paramString)
    {
      ((com.mato.sdk.proxy.k)localObject2).d("picUris", paramBitmap);
      paramBitmap = Uri.parse(paramString);
      localObject2 = paramContext.getContentResolver().query(paramBitmap, null, null, null, null);
      paramBitmap = (Bitmap)localObject1;
      if (localObject2 != null)
      {
        ((Cursor)localObject2).moveToFirst();
        paramBitmap = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("_data"));
        ((Cursor)localObject2).close();
      }
      if (paramBitmap != null) {
        paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(paramBitmap))));
      }
      return paramString;
    }
  }
  
  private boolean b(g paramg, int paramInt)
  {
    if (this.u == 0) {}
    for (this.u = paramInt; paramInt == 4; this.u |= paramInt)
    {
      if (paramg.q >= paramg.r) {
        break label168;
      }
      paramInt = paramg.q * 60 / paramg.r;
      this.p.loadUrl("javascript:showLoadHint('" + String.valueOf(paramInt + 10) + "')");
      do
      {
        return false;
      } while (this.u == 15);
    }
    if ((paramInt == 2) && (paramg.s < paramg.t))
    {
      paramInt = paramg.s * 30 / paramg.t;
      this.p.loadUrl("javascript:showLoadHint('" + String.valueOf(paramInt + 70) + "')");
      return false;
    }
    label168:
    this.r = paramg;
    this.s = new f(this.u, paramg);
    paramg = new m(this.n, this.s).a();
    this.p.loadDataWithBaseURL("file:///android_asset/diagnose_report.html", paramg, "text/html", "UTF-8", null);
    return true;
  }
  
  private void d()
  {
    WebSettings localWebSettings = this.p.getSettings();
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setCacheMode(1);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setJavaScriptEnabled(true);
    this.p.setWebViewClient(new WebViewClient()
    {
      public final void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        h.a(h.this).obtainMessage(206).sendToTarget();
      }
      
      public final boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        paramAnonymousWebView.loadUrl(paramAnonymousString);
        return true;
      }
    });
    this.m = new b(this);
  }
  
  private void e()
  {
    for (;;)
    {
      if (this.t.isEmpty()) {
        return;
      }
      a locala = (a)this.t.getFirst();
      Object localObject = locala.a;
      int i1 = locala.b;
      if (this.u == 0)
      {
        this.u = i1;
        if (i1 != 4) {
          break label158;
        }
        if (((g)localObject).q >= ((g)localObject).r) {
          break label232;
        }
        i1 = ((g)localObject).q * 60 / ((g)localObject).r;
        this.p.loadUrl("javascript:showLoadHint('" + String.valueOf(i1 + 10) + "')");
        i1 = 0;
      }
      for (;;)
      {
        int i2 = locala.b;
        if (i1 == 0) {
          break label299;
        }
        locala.c = 0;
        return;
        if (this.u == 15)
        {
          i1 = 0;
        }
        else
        {
          this.u |= i1;
          break;
          label158:
          if ((i1 == 2) && (((g)localObject).s < ((g)localObject).t))
          {
            i1 = ((g)localObject).s * 30 / ((g)localObject).t;
            this.p.loadUrl("javascript:showLoadHint('" + String.valueOf(i1 + 70) + "')");
            i1 = 0;
          }
          else
          {
            label232:
            this.r = ((g)localObject);
            this.s = new f(this.u, (g)localObject);
            localObject = new m(this.n, this.s).a();
            this.p.loadDataWithBaseURL("file:///android_asset/diagnose_report.html", (String)localObject, "text/html", "UTF-8", null);
            i1 = 1;
          }
        }
      }
      label299:
      this.t.removeFirst();
    }
  }
  
  private void f()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (a)this.t.removeFirst();
        i1 = ((a)localObject1).b;
        if (((a)localObject1).b == 15)
        {
          localObject1 = Toast.makeText(this.n, "检测完成", 1);
          if (!(localObject1 instanceof Toast))
          {
            ((Toast)localObject1).show();
            localObject2 = this.s;
            localObject1 = this.r;
            if (((g)localObject1).u == null) {
              break label234;
            }
            localObject1 = ((g)localObject1).u.e;
            if (localObject1 == null) {
              continue;
            }
            if (!((com.mato.sdk.b.f)localObject1).c())
            {
              continue;
              if (i1 != 0) {
                continue;
              }
              this.m.obtainMessage(205).sendToTarget();
              g();
            }
          }
          else
          {
            VdsAgent.showToast((Toast)localObject1);
            continue;
          }
          Object localObject2 = ((f)localObject2).b().iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label229;
          }
          Integer localInteger = (Integer)((Iterator)localObject2).next();
          if ((localInteger.intValue() <= 4999) || (localInteger.intValue() >= 7000)) {
            continue;
          }
          i1 = 1;
          if (i1 == 0) {
            break label234;
          }
          this.m.obtainMessage(203).sendToTarget();
          a.b().a((com.mato.sdk.b.f)localObject1);
          this.m.sendEmptyMessageDelayed(204, 5000L);
          i1 = 1;
          continue;
        }
        else
        {
          e();
          return;
        }
        i1 = 0;
        continue;
        return;
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      label229:
      int i1 = 0;
      continue;
      label234:
      i1 = 0;
    }
  }
  
  private void g()
  {
    this.m.postDelayed(new Runnable()
    {
      public final void run()
      {
        h.a(h.this).obtainMessage(200).sendToTarget();
      }
    }, 1000L);
  }
  
  private void h()
  {
    Object localObject1 = com.mato.sdk.proxy.g.a(this.n);
    String str = ((com.mato.sdk.proxy.k)localObject1).b("picUris", "");
    Object localObject2;
    int i2;
    int i1;
    if (!str.equals(""))
    {
      localObject2 = str.split(";");
      if (localObject2 != null)
      {
        i2 = localObject2.length;
        i1 = 0;
      }
    }
    for (;;)
    {
      if (i1 < i2) {
        str = localObject2[i1];
      }
      try
      {
        if (this.n.getContentResolver().delete(Uri.parse(str), null, null) == 1) {
          str = "success";
        } else {
          str = "fail";
        }
      }
      catch (Throwable localThrowable)
      {
        int i3;
        int i4;
        i1 += 1;
      }
      ((com.mato.sdk.proxy.k)localObject1).d("picUris", "");
      i3 = this.p.getHeight();
      i4 = (int)Math.floor(this.p.getContentHeight() * this.p.getScale());
      str = com.mato.sdk.g.i.g(this.n);
      localObject1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
      i1 = 0;
      i2 = 0;
      while (i1 < 10)
      {
        localObject2 = ((SimpleDateFormat)localObject1).format(new Date(System.currentTimeMillis()));
        a(String.format(Locale.US, "Maa-%s_%s_%d.jpg", new Object[] { localObject2, str, Integer.valueOf(i1) }));
        i2 += i3;
        if (i2 >= i4) {
          break;
        }
        this.p.scrollTo(0, i2);
        i1 += 1;
      }
      this.p.scrollTo(0, 0);
      this.m.obtainMessage(201).sendToTarget();
      return;
    }
  }
  
  private Bitmap i()
  {
    try
    {
      View localView = ((Activity)this.n).getWindow().getDecorView();
      localBitmap = Bitmap.createBitmap(localView.getWidth(), localView.getHeight(), Bitmap.Config.ARGB_8888);
      if (localBitmap == null) {
        return null;
      }
      try
      {
        localView.draw(new Canvas(localBitmap));
        return localBitmap;
      }
      catch (Exception localException2) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Bitmap localBitmap;
        Object localObject = null;
      }
    }
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    return null;
  }
  
  private void j()
  {
    com.mato.sdk.proxy.g localg = com.mato.sdk.proxy.g.a(this.n);
    String str = localg.b("picUris", "");
    if (str.equals("")) {}
    String[] arrayOfString;
    do
    {
      return;
      arrayOfString = str.split(";");
    } while (arrayOfString == null);
    int i2 = arrayOfString.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2) {
        str = arrayOfString[i1];
      }
      try
      {
        if (this.n.getContentResolver().delete(Uri.parse(str), null, null) == 1) {
          str = "success";
        } else {
          str = "fail";
        }
      }
      catch (Throwable localThrowable)
      {
        i1 += 1;
      }
      localg.d("picUris", "");
      return;
    }
  }
  
  public final void a()
  {
    this.q = d.a(this.n, new i()
    {
      public final void a(g paramAnonymousg)
      {
        h.a(h.this).obtainMessage(40, paramAnonymousg).sendToTarget();
      }
      
      public final void b(g paramAnonymousg)
      {
        h.a(h.this).obtainMessage(90, paramAnonymousg).sendToTarget();
      }
      
      public final void c(g paramAnonymousg)
      {
        h.a(h.this).obtainMessage(100, paramAnonymousg).sendToTarget();
      }
      
      public final void d(g paramAnonymousg)
      {
        h.a(h.this).obtainMessage(10, paramAnonymousg).sendToTarget();
      }
    });
  }
  
  public final void b()
  {
    if (this.q != null) {
      this.q.b();
    }
  }
  
  final class a
  {
    private static int d = 0;
    private static int e = 1;
    g a;
    int b;
    int c;
    
    a(g paramg, int paramInt)
    {
      this.a = paramg;
      this.b = paramInt;
      this.c = 1;
    }
    
    public final g a()
    {
      return this.a;
    }
    
    public final void a(int paramInt)
    {
      this.c = 0;
    }
    
    public final int b()
    {
      return this.b;
    }
    
    public final int c()
    {
      return this.c;
    }
  }
  
  static final class b
    extends Handler
  {
    private final WeakReference<h> a;
    
    public b(h paramh)
    {
      this.a = new WeakReference(paramh);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      h.a((h)this.a.get(), paramMessage);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */