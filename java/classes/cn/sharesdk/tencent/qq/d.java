package cn.sharesdk.tencent.qq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.e;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;

public class d
  extends FakeActivity
{
  private Platform a;
  private String b;
  private PlatformActionListener c;
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    paramString2 = b(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt);
    paramString1 = new Intent("android.intent.action.VIEW");
    paramString1.setData(Uri.parse(paramString2));
    try
    {
      paramString2 = a();
      ReceiveActivity.setUriScheme(this.b);
      ReceiveActivity.setPlatformActionListener(this.c);
      if ((paramString2.length <= 1) || ((paramString2[0] < 4) && (paramString2[1] < 6))) {
        paramString1.putExtra("key_request_code", 0);
      }
      paramString1.putExtra("pkg_name", this.activity.getPackageName());
      this.activity.startActivityForResult(paramString1, 256);
      return;
    }
    catch (Throwable paramString1)
    {
      do
      {
        this.activity.finish();
      } while (this.c == null);
      this.c.onError(this.a, 9, paramString1);
    }
  }
  
  private int[] a()
  {
    int[] arrayOfInt;
    try
    {
      localObject = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
      localObject = ((String)localObject).split("\\.");
      arrayOfInt = new int[localObject.length];
      i = 0;
      if (i >= arrayOfInt.length) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          Object localObject;
          arrayOfInt[i] = ResHelper.parseInt(localObject[i]);
          i += 1;
        }
        localThrowable1 = localThrowable1;
        e.b().d(localThrowable1);
        String str = "0";
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          int i;
          e.b().d(localThrowable2);
          arrayOfInt[i] = 0;
        }
      }
    }
    return arrayOfInt;
  }
  
  private String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    String str3 = "mqqapi://share/to_fri?src_type=app&version=1&file_type=news";
    String str2 = paramString4;
    String str1 = paramString5;
    if (!TextUtils.isEmpty(paramString4))
    {
      if (!TextUtils.isEmpty(paramString5))
      {
        str2 = "";
        str1 = paramString5;
      }
    }
    else
    {
      paramString4 = str3;
      if (!TextUtils.isEmpty(str2)) {
        paramString4 = "mqqapi://share/to_fri?src_type=app&version=1&file_type=news" + "&image_url=" + Base64.encodeToString(str2.getBytes(), 2);
      }
      paramString5 = paramString4;
      if (!TextUtils.isEmpty(str1)) {
        paramString5 = paramString4 + "&file_data=" + Base64.encodeToString(str1.getBytes(), 2);
      }
      str2 = paramString5;
      if (!TextUtils.isEmpty(paramString1)) {
        str2 = paramString5 + "&title=" + Base64.encodeToString(paramString1.getBytes(), 2);
      }
      paramString4 = str2;
      if (!TextUtils.isEmpty(paramString3)) {
        paramString4 = str2 + "&description=" + Base64.encodeToString(paramString3.getBytes(), 2);
      }
      paramString5 = paramString4;
      if (!TextUtils.isEmpty(paramString7))
      {
        paramString5 = paramString7;
        if (paramString7.length() > 20) {
          paramString5 = paramString7.substring(0, 20) + "...";
        }
        paramString5 = paramString4 + "&app_name=" + Base64.encodeToString(paramString5.getBytes(), 2);
      }
      paramString4 = paramString5;
      if (!TextUtils.isEmpty(paramString8)) {
        paramString4 = paramString5 + "&share_id=" + paramString8;
      }
      paramString5 = paramString4;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString5 = paramString4 + "&url=" + Base64.encodeToString(paramString2.getBytes(), 2);
      }
      paramString4 = paramString5;
      if (!TextUtils.isEmpty(paramString3)) {
        paramString4 = paramString5 + "&share_qq_ext_str=" + Base64.encodeToString(paramString3.getBytes(), 2);
      }
      if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString3)) || (!TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(str1))) {
        break label590;
      }
      paramString1 = paramString4 + "&req_type=" + Base64.encodeToString("5".getBytes(), 2);
      label493:
      if (paramInt != 1) {
        break label759;
      }
    }
    label590:
    label759:
    for (paramString2 = "10";; paramString2 = "00")
    {
      return paramString1 + "&cflag=" + Base64.encodeToString(paramString2.getBytes(), 2);
      str2 = paramString4;
      str1 = paramString5;
      if (!paramString4.startsWith("https")) {
        break;
      }
      try
      {
        str1 = BitmapHelper.downloadBitmap(this.activity, paramString4);
        str2 = "";
      }
      catch (Throwable paramString5)
      {
        e.b().d(paramString5);
        str1 = null;
        str2 = paramString4;
      }
      break;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (TextUtils.isEmpty(paramString2)))
      {
        paramString1 = paramString4 + "&req_type=" + Base64.encodeToString("6".getBytes(), 2);
        break label493;
      }
      if (!TextUtils.isEmpty(paramString6))
      {
        paramString1 = paramString4 + "&req_type=" + Base64.encodeToString("2".getBytes(), 2);
        paramString1 = paramString1 + "&audioUrl=" + Base64.encodeToString(paramString6.getBytes(), 2);
        break label493;
      }
      paramString1 = paramString4 + "&req_type=" + Base64.encodeToString("1".getBytes(), 2);
      break label493;
    }
  }
  
  public void a(Platform paramPlatform, PlatformActionListener paramPlatformActionListener)
  {
    this.a = paramPlatform;
    this.c = paramPlatformActionListener;
  }
  
  public void a(String paramString)
  {
    this.b = ("tencent" + paramString);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 256) && (paramInt2 == 0)) {
      this.c.onCancel(this.a, 9);
    }
    finish();
  }
  
  public void onCreate()
  {
    Object localObject = this.activity.getIntent().getExtras();
    final String str1 = ((Bundle)localObject).getString("title");
    final String str2 = ((Bundle)localObject).getString("titleUrl");
    final String str3 = ((Bundle)localObject).getString("summary");
    final String str4 = ((Bundle)localObject).getString("imageUrl");
    final String str5 = ((Bundle)localObject).getString("musicUrl");
    final String str6 = DeviceHelper.getInstance(this.activity).getAppName();
    final String str7 = ((Bundle)localObject).getString("appId");
    final int i = ((Bundle)localObject).getInt("hidden");
    localObject = ((Bundle)localObject).getString("imagePath");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str2)) && ((TextUtils.isEmpty((CharSequence)localObject)) || (!new File((String)localObject).exists())) && (!TextUtils.isEmpty(str4)))
    {
      new Thread()
      {
        public void run()
        {
          try
          {
            str = BitmapHelper.downloadBitmap(d.a(d.this), str4);
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              try
              {
                String str;
                d.a(d.this, str1, str2, str3, str4, str, str5, str6, str7, i);
                return;
              }
              catch (Throwable localThrowable2)
              {
                Object localObject;
                e.b().d(localThrowable2);
              }
              localThrowable1 = localThrowable1;
              e.b().d(localThrowable1);
              localObject = null;
            }
          }
        }
      }.start();
      return;
    }
    a(str1, str2, str3, str4, (String)localObject, str5, str6, str7, i);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/tencent/qq/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */