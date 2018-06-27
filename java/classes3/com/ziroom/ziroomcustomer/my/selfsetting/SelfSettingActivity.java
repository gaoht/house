package com.ziroom.ziroomcustomer.my.selfsetting;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.widget.imgpicker.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import java.io.File;

public class SelfSettingActivity
  extends BaseActivity
  implements a.b
{
  private Unbinder a;
  private a.a b;
  @BindView(2131691850)
  Button btnLogout;
  private int c = 200;
  private int d = 200;
  private Uri e;
  private BroadcastReceiver f = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 7)
      {
        SelfSettingActivity.this.dismissProgress();
        SelfSettingActivity.this.finishAc();
      }
    }
  };
  @BindView(2131691847)
  LinearLayout llAbout;
  @BindView(2131691846)
  LinearLayout llAccount;
  @BindView(2131691842)
  LinearLayout llAvatar;
  @BindView(2131691843)
  LinearLayout llCard;
  @BindView(2131691844)
  LinearLayout llCredentials;
  @BindView(2131691848)
  LinearLayout llDelete;
  @BindView(2131691845)
  LinearLayout llEducation;
  @BindView(2131691841)
  LinearLayout llNickname;
  @BindView(2131690070)
  SimpleDraweeView sdvAvatar;
  @BindView(2131689895)
  ImageView tvBack;
  @BindView(2131691849)
  TextView tvDelete;
  @BindView(2131691304)
  TextView tvNickname;
  
  private void a(Uri paramUri)
  {
    Intent localIntent = new Intent("com.android.camera.action.CROP");
    localIntent.setDataAndType(paramUri, "image/*");
    localIntent.putExtra("crop", "true");
    localIntent.putExtra("aspectX", 1);
    localIntent.putExtra("aspectY", 1);
    localIntent.putExtra("outputX", this.c);
    localIntent.putExtra("outputY", this.d);
    localIntent.putExtra("scale", true);
    localIntent.putExtra("scaleUpIfNeeded", true);
    localIntent.putExtra("return-data", false);
    localIntent.putExtra("output", this.e);
    localIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
    localIntent.putExtra("noFaceDetection", true);
    startActivityForResult(localIntent, 3021);
  }
  
  /* Error */
  public static String getDataColumn(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: aload_1
    //   8: iconst_1
    //   9: anewarray 143	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc -111
    //   16: aastore
    //   17: aload_2
    //   18: aload_3
    //   19: aconst_null
    //   20: invokevirtual 151	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +39 -> 64
    //   28: aload_1
    //   29: invokeinterface 157 1 0
    //   34: ifeq +30 -> 64
    //   37: aload_1
    //   38: aload_1
    //   39: ldc -111
    //   41: invokeinterface 161 2 0
    //   46: invokeinterface 165 2 0
    //   51: astore_0
    //   52: aload_1
    //   53: ifnull +9 -> 62
    //   56: aload_1
    //   57: invokeinterface 168 1 0
    //   62: aload_0
    //   63: areturn
    //   64: aload_1
    //   65: ifnull +9 -> 74
    //   68: aload_1
    //   69: invokeinterface 168 1 0
    //   74: aconst_null
    //   75: areturn
    //   76: astore_0
    //   77: aload 4
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +9 -> 90
    //   84: aload_1
    //   85: invokeinterface 168 1 0
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: goto -13 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramContext	Context
    //   0	96	1	paramUri	Uri
    //   0	96	2	paramString	String
    //   0	96	3	paramArrayOfString	String[]
    //   1	77	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	24	76	finally
    //   28	52	92	finally
  }
  
  @TargetApi(19)
  public static String getPath(Context paramContext, Uri paramUri)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (Build.VERSION.SDK_INT >= 19)
    {
      i = 1;
      if ((i == 0) || (!DocumentsContract.isDocumentUri(paramContext, paramUri))) {
        break label219;
      }
      if (!isExternalStorageDocument(paramUri)) {
        break label90;
      }
      paramContext = DocumentsContract.getDocumentId(paramUri).split(":");
      if ("primary".equalsIgnoreCase(paramContext[0])) {
        localObject1 = Environment.getExternalStorageDirectory() + "/" + paramContext[1];
      }
    }
    label90:
    label219:
    do
    {
      do
      {
        return (String)localObject1;
        i = 0;
        break;
        if (isDownloadsDocument(paramUri))
        {
          paramUri = DocumentsContract.getDocumentId(paramUri);
          return getDataColumn(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
        }
      } while (!isMediaDocument(paramUri));
      localObject1 = DocumentsContract.getDocumentId(paramUri).split(":");
      Object localObject3 = localObject1[0];
      if ("image".equals(localObject3)) {
        paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
      }
      for (;;)
      {
        return getDataColumn(paramContext, paramUri, "_id=?", new String[] { localObject1[1] });
        if ("video".equals(localObject3))
        {
          paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        else
        {
          paramUri = (Uri)localObject2;
          if ("audio".equals(localObject3)) {
            paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
          }
        }
      }
      if ("content".equalsIgnoreCase(paramUri.getScheme()))
      {
        if (isGooglePhotosUri(paramUri)) {
          return paramUri.getLastPathSegment();
        }
        return getDataColumn(paramContext, paramUri, null, null);
      }
    } while (!"file".equalsIgnoreCase(paramUri.getScheme()));
    return paramUri.getPath();
  }
  
  public static boolean isDownloadsDocument(Uri paramUri)
  {
    return "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean isExternalStorageDocument(Uri paramUri)
  {
    return "com.android.externalstorage.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean isGooglePhotosUri(Uri paramUri)
  {
    return "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
  }
  
  public static boolean isMediaDocument(Uri paramUri)
  {
    return "com.android.providers.media.documents".equals(paramUri.getAuthority());
  }
  
  public void deleteCacheFile()
  {
    if (this.e != null)
    {
      File localFile = new File(this.e.getPath());
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
  
  public void finishAc()
  {
    finish();
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public void initView()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.f, localIntentFilter);
  }
  
  public boolean isActive()
  {
    return isActive();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (paramInt2 != -1);
            a(this.e);
            return;
          } while (paramInt2 != -1);
          this.b.uploadHeadPic(this.e.getPath());
          return;
        } while ((paramInt2 != -1) || (paramIntent == null) || (paramIntent.getData() == null));
        a(Uri.fromFile(new File(getPath(getApplicationContext(), paramIntent.getData()))));
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      paramIntent = paramIntent.getStringExtra("path");
    } while (TextUtils.isEmpty(paramIntent));
    this.b.uploadHeadPic(paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903373);
    this.a = ButterKnife.bind(this);
    initView();
    this.b = new b(this);
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.b.initData();
  }
  
  @OnClick({2131689895, 2131691841, 2131691842, 2131691843, 2131691844, 2131691845, 2131691846, 2131691847, 2131691848, 2131691850})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689895: 
      finish();
      return;
    case 2131691841: 
      b("nickname");
      this.b.toSetNickname();
      return;
    case 2131691842: 
      startActivityForResult(a.getPickerIntent(this, false, 1, true, this.c, this.d), 1);
      return;
    case 2131691843: 
      this.b.toCertInfo();
      return;
    case 2131691844: 
      this.b.toAptitudeInfo();
      return;
    case 2131691845: 
      this.b.toSchoolInfo();
      return;
    case 2131691846: 
      this.b.toAccountInfoManage();
      return;
    case 2131691847: 
      this.b.toAboutUs();
      return;
    case 2131691848: 
      this.b.clearCache();
      return;
    }
    this.b.logOut();
  }
  
  public void setPresenter(a.a parama)
  {
    this.b = parama;
  }
  
  public void showCacheSize(String paramString)
  {
    this.tvDelete.setText(paramString);
  }
  
  public void showHeadPic(String paramString)
  {
    this.sdvAvatar.setController(c.frescoController(paramString));
  }
  
  public void showNickname(String paramString)
  {
    this.tvNickname.setText(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/selfsetting/SelfSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */