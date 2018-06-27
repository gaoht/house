package cn.sharesdk.sina.weibo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MultiImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WebpageObject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class a
  extends FakeActivity
  implements Handler.Callback
{
  private long a = 2097152L;
  private boolean b;
  private String c;
  private Platform.ShareParams d;
  private AuthorizeListener e;
  
  private Bitmap a(Bitmap paramBitmap, double paramDouble)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    paramDouble = Math.sqrt(paramDouble);
    return Bitmap.createScaledBitmap(paramBitmap, (int)(i / paramDouble), (int)(j / paramDouble), true);
  }
  
  private void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_weibo_command_type", 1);
    localBundle.putString("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
    localBundle.putLong("callbackId", 0L);
    if (!TextUtils.isEmpty(this.d.getText()))
    {
      localBundle.putParcelable("_weibo_message_text", c());
      localBundle.putString("_weibo_message_text_extra", "");
    }
    Object localObject;
    if (!TextUtils.isEmpty(this.d.getUrl()))
    {
      this.a = 32768L;
      WebpageObject localWebpageObject = d();
      if (localWebpageObject.checkArgs())
      {
        localBundle.putParcelable("_weibo_message_media", localWebpageObject);
        localObject = "";
        if (!TextUtils.isEmpty(localWebpageObject.defaultText))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("extra_key_defaulttext", localWebpageObject.defaultText);
          localObject = new Hashon().fromHashMap((HashMap)localObject);
        }
        localBundle.putString("_weibo_message_media_extra", (String)localObject);
      }
    }
    try
    {
      for (;;)
      {
        a(this.activity, g.a().b(), this.c, localBundle);
        return;
        if ((this.d.getImageArray() != null) && (this.d.getImageArray().length > 0))
        {
          localBundle.putParcelable("_weibo_message_multi_image", f());
        }
        else if (!TextUtils.isEmpty(this.d.getFilePath()))
        {
          localBundle.putParcelable("_weibo_message_video_source", g());
        }
        else if ((this.d.getImageData() != null) || (!TextUtils.isEmpty(this.d.getImagePath())))
        {
          this.a = 2097152L;
          localObject = e();
          if (((ImageObject)localObject).checkArgs())
          {
            localBundle.putParcelable("_weibo_message_image", (Parcelable)localObject);
            localBundle.putString("_weibo_message_image_extra", "");
          }
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      do
      {
        try
        {
          a(this.activity, "com.sina.weibog3", this.c, localBundle);
          return;
        }
        catch (Throwable localThrowable2) {}
      } while (this.e == null);
      this.e.onError(new Throwable(localThrowable2));
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      finish();
      return;
      if (this.e != null)
      {
        this.e.onComplete(null);
        continue;
        if (this.e != null)
        {
          this.e.onCancel();
          continue;
          if (this.e != null) {
            this.e.onError(new Throwable(paramString));
          }
        }
      }
    }
  }
  
  private boolean a(Activity paramActivity, String paramString1, String paramString2, Bundle paramBundle)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY")) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      e.b().e("launchWeiboActivity fail, invalid arguments", new Object[0]);
      return false;
    }
    String str = paramActivity.getPackageName();
    Intent localIntent = new Intent();
    localIntent.setPackage(paramString1);
    localIntent.setAction("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.putExtra("_weibo_sdkVersion", "0031405000");
    localIntent.putExtra("_weibo_appPackage", str);
    localIntent.putExtra("_weibo_appKey", paramString2);
    localIntent.putExtra("_weibo_flag", 538116905);
    localIntent.putExtra("_weibo_sign", cn.sharesdk.sina.weibo.sdk.a.a(paramActivity, str));
    localIntent.putExtra("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    try
    {
      e.b().d("launchWeiboActivity intent=" + localIntent + ", extra=" + localIntent.getExtras(), new Object[0]);
      startActivityForResult(localIntent, 765);
      return true;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      e.b().e(paramActivity.getMessage(), new Object[0]);
    }
    return false;
  }
  
  private byte[] a(Context paramContext, Bitmap paramBitmap)
    throws Throwable
  {
    if (paramBitmap == null) {
      throw new RuntimeException("checkArgs fail, thumbData is null");
    }
    if (paramBitmap.isRecycled()) {
      throw new RuntimeException("checkArgs fail, thumbData is recycled");
    }
    return b(paramContext, paramBitmap);
  }
  
  private byte[] a(Context paramContext, String paramString)
    throws Throwable
  {
    if (!new File(paramString).exists()) {
      throw new FileNotFoundException();
    }
    return b(paramContext, BitmapHelper.getBitmap(paramString));
  }
  
  private String b()
  {
    return UUID.randomUUID().toString().replace("-", "");
  }
  
  private byte[] b(Context paramContext, Bitmap paramBitmap)
    throws Throwable
  {
    if (paramBitmap == null) {
      throw new RuntimeException("checkArgs fail, thumbData is null");
    }
    if (paramBitmap.isRecycled()) {
      throw new RuntimeException("checkArgs fail, thumbData is recycled");
    }
    paramContext = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, paramContext);
    paramContext.flush();
    paramContext.close();
    paramContext = paramContext.toByteArray();
    for (int i = paramContext.length; i > this.a; i = paramContext.length)
    {
      paramBitmap = a(paramBitmap, i / this.a);
      paramContext = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, paramContext);
      paramContext.flush();
      paramContext.close();
      paramContext = paramContext.toByteArray();
    }
    return paramContext;
  }
  
  private TextObject c()
  {
    TextObject localTextObject = new TextObject();
    localTextObject.text = this.d.getText();
    return localTextObject;
  }
  
  private WebpageObject d()
  {
    WebpageObject localWebpageObject = new WebpageObject();
    localWebpageObject.identify = b();
    localWebpageObject.title = this.d.getTitle();
    localWebpageObject.description = this.d.getText();
    localWebpageObject.actionUrl = this.d.getUrl();
    localWebpageObject.defaultText = this.d.getText();
    try
    {
      if (this.d.getImageData() != null)
      {
        localWebpageObject.thumbData = a(this.activity, this.d.getImageData());
        return localWebpageObject;
      }
      if (!TextUtils.isEmpty(this.d.getImagePath()))
      {
        localWebpageObject.thumbData = a(this.activity, this.d.getImagePath());
        return localWebpageObject;
      }
    }
    catch (Throwable localThrowable)
    {
      e.b().d(localThrowable);
      localWebpageObject.setThumbImage(null);
    }
    return localWebpageObject;
  }
  
  private ImageObject e()
  {
    localImageObject = new ImageObject();
    try
    {
      if (this.d.getImageData() != null)
      {
        localImageObject.imageData = a(this.activity, this.d.getImageData());
        return localImageObject;
      }
      if (!TextUtils.isEmpty(this.d.getImagePath()))
      {
        Object localObject = DeviceHelper.getInstance(this.activity);
        try
        {
          if ((((DeviceHelper)localObject).getSdcardState()) && (this.d.getImagePath().startsWith(((DeviceHelper)localObject).getSdcardPath())))
          {
            localObject = new File(this.d.getImagePath());
            if ((((File)localObject).exists()) && (((File)localObject).length() != 0L) && (((File)localObject).length() < 10485760L))
            {
              localImageObject.imagePath = this.d.getImagePath();
              return localImageObject;
            }
          }
        }
        catch (Throwable localThrowable1)
        {
          e.b().d(localThrowable1);
          localImageObject.imageData = a(this.activity, this.d.getImagePath());
          return localImageObject;
        }
      }
      return localImageObject;
    }
    catch (Throwable localThrowable2)
    {
      e.b().d(localThrowable2);
    }
  }
  
  private MultiImageObject f()
  {
    MultiImageObject localMultiImageObject = new MultiImageObject();
    localMultiImageObject.identify = b();
    localMultiImageObject.title = this.d.getTitle();
    localMultiImageObject.description = this.d.getText();
    localMultiImageObject.actionUrl = this.d.getUrl();
    localMultiImageObject.defaultText = this.d.getText();
    for (;;)
    {
      File localFile;
      try
      {
        if (this.d.getImageData() != null)
        {
          localMultiImageObject.thumbData = a(this.activity, this.d.getImageData());
          Object localObject = Arrays.asList(this.d.getImageArray());
          ArrayList localArrayList = new ArrayList();
          localObject = ((List)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localFile = new File((String)((Iterator)localObject).next());
          if (!localFile.exists()) {
            continue;
          }
          if (Build.VERSION.SDK_INT < 24) {
            break label228;
          }
          localArrayList.add(ResHelper.pathToContentUri(MobSDK.getContext(), localFile.getAbsolutePath()));
          continue;
        }
        if (TextUtils.isEmpty(this.d.getImagePath())) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        e.b().d(localThrowable);
        localMultiImageObject.setThumbImage(null);
        return localMultiImageObject;
      }
      localMultiImageObject.thumbData = a(this.activity, this.d.getImagePath());
      continue;
      label228:
      localThrowable.add(Uri.fromFile(localFile));
    }
    localMultiImageObject.setImageList(localThrowable);
    return localMultiImageObject;
  }
  
  private VideoSourceObject g()
  {
    VideoSourceObject localVideoSourceObject = new VideoSourceObject();
    localVideoSourceObject.identify = b();
    localVideoSourceObject.title = this.d.getTitle();
    localVideoSourceObject.description = this.d.getText();
    localVideoSourceObject.actionUrl = this.d.getUrl();
    localVideoSourceObject.defaultText = this.d.getText();
    for (;;)
    {
      try
      {
        File localFile;
        if (this.d.getImageData() != null)
        {
          localVideoSourceObject.thumbData = a(this.activity, this.d.getImageData());
          Object localObject1 = null;
          String str1 = this.d.getFilePath();
          localFile = new File(str1);
          if (localFile.exists())
          {
            if (str1.startsWith("/data/"))
            {
              localObject1 = new File(ResHelper.getCachePath(MobSDK.getContext(), "videos"), System.currentTimeMillis() + localFile.getName());
              String str2 = ((File)localObject1).getAbsolutePath();
              ((File)localObject1).createNewFile();
              if (ResHelper.copyFile(str1, str2)) {
                localObject1 = Uri.fromFile((File)localObject1);
              }
            }
          }
          else
          {
            localVideoSourceObject.videoPath = ((Uri)localObject1);
            return localVideoSourceObject;
          }
        }
        else
        {
          if (TextUtils.isEmpty(this.d.getImagePath())) {
            continue;
          }
          localVideoSourceObject.thumbData = a(this.activity, this.d.getImagePath());
          continue;
        }
        Object localObject2 = localFile;
      }
      catch (Throwable localThrowable)
      {
        e.b().d(localThrowable);
        return localVideoSourceObject;
      }
    }
  }
  
  public void a(Platform.ShareParams paramShareParams)
  {
    this.d = paramShareParams;
  }
  
  public void a(AuthorizeListener paramAuthorizeListener)
  {
    this.e = paramAuthorizeListener;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if ((!this.b) && (this.e != null)) {
        this.e.onCancel();
      }
      finish();
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    e.b().d("sina activity requestCode = %s, resultCode = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt1) });
    finish();
  }
  
  public void onCreate()
  {
    UIHandler.sendEmptyMessageDelayed(1, 700L, new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        a.a(a.this);
        return true;
      }
    });
  }
  
  @Instrumented
  public void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    this.b = true;
    Bundle localBundle = paramIntent.getExtras();
    e.b().i("onNewIntent ==>>", new Object[] { localBundle.toString() });
    String str1 = paramIntent.getStringExtra("_weibo_appPackage");
    paramIntent = paramIntent.getStringExtra("_weibo_transaction");
    if (TextUtils.isEmpty(str1))
    {
      e.b().e("handleWeiboResponse faild appPackage is null", new Object[0]);
      return;
    }
    String str2 = this.activity.getCallingPackage();
    e.b().d("handleWeiboResponse getCallingPackage : " + str2, new Object[0]);
    if (TextUtils.isEmpty(paramIntent))
    {
      e.b().e("handleWeiboResponse faild intent _weibo_transaction is null", new Object[0]);
      return;
    }
    if ((!g.a(str1)) && (!str1.equals(this.activity.getPackageName())))
    {
      e.b().e("handleWeiboResponse faild appPackage validateSign faild", new Object[0]);
      return;
    }
    a(localBundle.getInt("_weibo_resp_errcode"), localBundle.getString("_weibo_resp_errstr"));
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/sina/weibo/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */