package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

public class b
  extends cn.sharesdk.framework.authorize.b
{
  private boolean a;
  
  public b(cn.sharesdk.framework.authorize.e parame)
  {
    super(parame);
  }
  
  private Intent a(String paramString)
  {
    paramString = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString));
    paramString.putExtra("sms_body", "");
    paramString.setFlags(268435456);
    return paramString;
  }
  
  private void a(final Platform paramPlatform, final String paramString)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          Object localObject1 = f.a(paramPlatform);
          try
          {
            localObject1 = ((f)localObject1).b(paramString);
            if (localObject1 == null)
            {
              b.b(b.this).onError(new Throwable("Authorize token is empty"));
              return;
            }
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              b.a(b.this).onError(localThrowable1);
              localObject2 = null;
            }
            Object localObject2 = new Hashon().fromJson((String)localObject2);
            Bundle localBundle = new Bundle();
            localBundle.putString("uid", String.valueOf(((HashMap)localObject2).get("uid")));
            localBundle.putString("remind_in", String.valueOf(((HashMap)localObject2).get("remind_in")));
            localBundle.putString("expires_in", String.valueOf(((HashMap)localObject2).get("expires_in")));
            localBundle.putString("access_token", String.valueOf(((HashMap)localObject2).get("access_token")));
            b.c(b.this).onComplete(localBundle);
            return;
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          cn.sharesdk.framework.utils.e.b().d(localThrowable2);
        }
      }
    }.start();
  }
  
  protected void onComplete(String paramString)
  {
    if (this.a) {}
    Bundle localBundle;
    String str;
    do
    {
      return;
      this.a = true;
      localBundle = ResHelper.urlToBundle(paramString);
      paramString = localBundle.getString("error");
      str = localBundle.getString("error_code");
    } while (this.listener == null);
    if ((paramString == null) && (str == null))
    {
      paramString = localBundle.getString("code");
      if (TextUtils.isEmpty(paramString)) {
        this.listener.onError(new Throwable("Authorize code is empty"));
      }
      a(this.activity.a().getPlatform(), paramString);
      return;
    }
    if (paramString.equals("access_denied"))
    {
      this.listener.onCancel();
      return;
    }
    int i = 0;
    try
    {
      int j = ResHelper.parseInt(str);
      i = j;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.e.b().d(localThrowable);
      }
    }
    paramString = paramString + " (" + i + ")";
    this.listener.onError(new Throwable(paramString));
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(this.redirectUri)) && (paramString.startsWith(this.redirectUri)))
    {
      paramWebView.stopLoading();
      this.activity.finish();
      onComplete(paramString);
    }
    do
    {
      return;
      if (!paramString.startsWith("sms:")) {
        break;
      }
      paramString = paramString.substring(4);
      try
      {
        paramBitmap = a(paramString);
        paramBitmap.setPackage("com.android.mms");
        paramWebView.getContext().startActivity(paramBitmap);
        return;
      }
      catch (Throwable paramBitmap)
      {
        try
        {
          paramString = a(paramString);
          paramWebView.getContext().startActivity(paramString);
          return;
        }
        catch (Throwable paramWebView) {}
      }
    } while (this.listener == null);
    this.listener.onError(paramWebView);
    return;
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((!TextUtils.isEmpty(this.redirectUri)) && (paramString.startsWith(this.redirectUri)))
    {
      paramWebView.stopLoading();
      this.activity.finish();
      onComplete(paramString);
    }
    do
    {
      return true;
      if (!paramString.startsWith("sms:")) {
        break;
      }
      paramString = paramString.substring(4);
      try
      {
        Intent localIntent = a(paramString);
        localIntent.setPackage("com.android.mms");
        paramWebView.getContext().startActivity(localIntent);
        return true;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          paramString = a(paramString);
          paramWebView.getContext().startActivity(paramString);
          return true;
        }
        catch (Throwable paramWebView) {}
      }
    } while (this.listener == null);
    this.listener.onError(paramWebView);
    return true;
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/sina/weibo/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */