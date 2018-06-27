package cn.sharesdk.framework.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class f
{
  private String a;
  private String b;
  private boolean c = true;
  
  public void a(Platform.ShareParams paramShareParams, Platform paramPlatform)
    throws Throwable
  {
    Intent localIntent = new Intent();
    Object localObject2 = paramShareParams.getImagePath();
    Object localObject3 = paramShareParams.getImageUrl();
    Object localObject1 = new ArrayList();
    if (paramShareParams.getImageArray() == null)
    {
      String str = paramShareParams.getText();
      if (!TextUtils.isEmpty(str))
      {
        paramPlatform = paramPlatform.getShortLintk(str, false);
        paramShareParams.setText(paramPlatform);
        localIntent.putExtra("android.intent.extra.TEXT", paramPlatform);
        localIntent.putExtra("Kdescription", paramPlatform);
      }
      if ((localObject1 == null) || (((List)localObject1).size() <= 0))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramPlatform = (Platform)localObject2;
          if (new File((String)localObject2).exists()) {}
        }
        else
        {
          paramShareParams = paramShareParams.getImageData();
          if ((paramShareParams == null) || (paramShareParams.isRecycled())) {
            break label406;
          }
          paramPlatform = new File(ResHelper.getCachePath(MobSDK.getContext(), "images"), System.currentTimeMillis() + ".png");
          localObject2 = new FileOutputStream(paramPlatform);
          paramShareParams.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
          ((FileOutputStream)localObject2).flush();
          ((FileOutputStream)localObject2).close();
          paramPlatform = paramPlatform.getAbsolutePath();
        }
        label210:
        if (!TextUtils.isEmpty(paramPlatform)) {
          ((List)localObject1).add(paramPlatform);
        }
      }
      localObject2 = new ArrayList();
      localObject3 = ((List)localObject1).iterator();
      label242:
      while (((Iterator)localObject3).hasNext())
      {
        paramPlatform = (String)((Iterator)localObject3).next();
        paramShareParams = paramPlatform;
        if (paramPlatform.startsWith("http")) {
          paramShareParams = BitmapHelper.downloadBitmap(MobSDK.getContext(), paramPlatform);
        }
        paramPlatform = new File(paramShareParams);
        if (paramPlatform.exists())
        {
          if (!paramShareParams.startsWith("/data/")) {
            break label642;
          }
          localObject1 = new File(ResHelper.getCachePath(MobSDK.getContext(), "images"), System.currentTimeMillis() + paramPlatform.getName());
          str = ((File)localObject1).getAbsolutePath();
          ((File)localObject1).createNewFile();
          if (!ResHelper.copyFile(paramShareParams, str)) {
            break label642;
          }
        }
      }
    }
    label406:
    label625:
    label642:
    for (paramShareParams = (Platform.ShareParams)localObject1;; paramShareParams = paramPlatform)
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        ((ArrayList)localObject2).add(ResHelper.pathToContentUri(MobSDK.getContext(), paramShareParams.getAbsolutePath()));
        break label242;
        localObject1 = Arrays.asList(paramShareParams.getImageArray());
        break;
        paramPlatform = (Platform)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label210;
        }
        paramPlatform = BitmapHelper.downloadBitmap(MobSDK.getContext(), (String)localObject3);
        break label210;
      }
      ((ArrayList)localObject2).add(Uri.fromFile(paramShareParams));
      break label242;
      if (((ArrayList)localObject2).size() <= 0)
      {
        localIntent.setAction("android.intent.action.SEND");
        localIntent.setType("text/plain");
        if (!TextUtils.isEmpty(this.b)) {
          break label625;
        }
        localIntent.setPackage(this.a);
      }
      for (;;)
      {
        localIntent.addFlags(335544320);
        MobSDK.getContext().startActivity(localIntent);
        return;
        if ((((ArrayList)localObject2).size() == 1) && (((ArrayList)localObject2).get(0) != null))
        {
          localIntent.setAction("android.intent.action.SEND");
          localIntent.putExtra("android.intent.extra.STREAM", (Parcelable)((ArrayList)localObject2).get(0));
          paramPlatform = URLConnection.getFileNameMap().getContentTypeFor(((Uri)((ArrayList)localObject2).get(0)).toString());
          if (paramPlatform != null)
          {
            paramShareParams = paramPlatform;
            if (paramPlatform.length() > 0) {}
          }
          else
          {
            paramShareParams = "image/*";
          }
          localIntent.setType(paramShareParams);
          break;
        }
        localIntent.setAction("android.intent.action.SEND_MULTIPLE");
        localIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", (ArrayList)localObject2);
        localIntent.setType("image/*");
        break;
        localIntent.setClassName(this.a, this.b);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
    this.b = "";
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/utils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */