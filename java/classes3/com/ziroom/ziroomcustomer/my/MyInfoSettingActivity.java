package com.ziroom.ziroomcustomer.my;

import android.annotation.TargetApi;
import android.app.Activity;
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
import android.text.format.Formatter;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.facebook.cache.disk.FileCache;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.login.a.a;
import com.ziroom.commonlibrary.login.a.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.CreditsBean;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.aboutus.AboutUsActivity;
import com.ziroom.ziroomcustomer.signed.CertInformationActivity;
import com.ziroom.ziroomcustomer.signed.CertificationInfoActivity;
import com.ziroom.ziroomcustomer.signed.SignerAptitudeActivity;
import com.ziroom.ziroomcustomer.signed.education.EducationActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import java.io.File;

public class MyInfoSettingActivity
  extends BaseActivity
{
  private Uri a;
  private int b = 200;
  private int c = 200;
  private String d;
  private Unbinder e;
  private String f;
  private f<e> g = new f(this, new o())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      dismissProgress();
      super.onFailure(paramAnonymousThrowable);
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      dismissProgress();
      paramAnonymouse = (CertInfoEntity)h.parseObject(paramAnonymouse.toJSONString(), CertInfoEntity.class);
      if ((paramAnonymouse != null) && (paramAnonymouse.credits != null) && (paramAnonymouse.credits.realNameStatus != 0)) {}
      switch (paramAnonymouse.credits.realNameStatus)
      {
      default: 
        return;
      case 2: 
        localIntent = new Intent(MyInfoSettingActivity.this, CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", MyInfoSettingActivity.a(MyInfoSettingActivity.this));
        localIntent.putExtra("type", 0);
        MyInfoSettingActivity.this.startActivity(localIntent);
        return;
      case 3: 
        localIntent = new Intent(MyInfoSettingActivity.this, CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", MyInfoSettingActivity.a(MyInfoSettingActivity.this));
        localIntent.putExtra("type", 0);
        MyInfoSettingActivity.this.startActivity(localIntent);
        return;
      case 4: 
        localIntent = new Intent(MyInfoSettingActivity.this, CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", MyInfoSettingActivity.a(MyInfoSettingActivity.this));
        localIntent.putExtra("type", 0);
        MyInfoSettingActivity.this.startActivity(localIntent);
        return;
      case 1: 
        if ("1".equals(paramAnonymouse.getCert_type()))
        {
          localIntent = new Intent(MyInfoSettingActivity.this, CertInformationActivity.class);
          localIntent.putExtra("cert_info", paramAnonymouse);
          localIntent.putExtra("phone", MyInfoSettingActivity.a(MyInfoSettingActivity.this));
          localIntent.putExtra("type", 0);
          MyInfoSettingActivity.this.startActivity(localIntent);
          return;
        }
        localIntent = new Intent(MyInfoSettingActivity.this, CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", MyInfoSettingActivity.a(MyInfoSettingActivity.this));
        localIntent.putExtra("type", 0);
        MyInfoSettingActivity.this.startActivity(localIntent);
        return;
      }
      Intent localIntent = new Intent(MyInfoSettingActivity.this, CertInformationActivity.class);
      localIntent.putExtra("cert_info", paramAnonymouse);
      localIntent.putExtra("phone", MyInfoSettingActivity.a(MyInfoSettingActivity.this));
      localIntent.putExtra("type", 0);
      MyInfoSettingActivity.this.startActivity(localIntent);
    }
  };
  @BindView(2131690070)
  SimpleDraweeView mSdvAvatar;
  @BindView(2131691849)
  TextView mTvDelete;
  @BindView(2131691304)
  TextView mTvNickName;
  private BroadcastReceiver r = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 7)
      {
        MyInfoSettingActivity.this.dismissProgress();
        MyInfoSettingActivity.this.finish();
      }
    }
  };
  
  private void a()
  {
    UserInfo localUserInfo = ((ApplicationEx)getApplication()).getUser();
    if (localUserInfo != null)
    {
      this.mSdvAvatar.setController(c.frescoController(localUserInfo.getHead_img()));
      if (TextUtils.isEmpty(localUserInfo.getNick_name())) {
        break label71;
      }
      this.d = localUserInfo.getNick_name();
    }
    while (TextUtils.isEmpty(this.d))
    {
      this.mTvNickName.setText(getString(2131297329));
      return;
      label71:
      if (!TextUtils.isEmpty(localUserInfo.getLogin_name_mobile())) {
        this.d = localUserInfo.getLogin_name_mobile();
      } else if (!TextUtils.isEmpty(localUserInfo.getLogin_name_email())) {
        this.d = localUserInfo.getLogin_name_email();
      }
    }
    this.mTvNickName.setText(this.d);
  }
  
  private static void a(Context paramContext)
  {
    com.ziroom.commonlibrary.login.a.showLogoutDialog(paramContext, new a.a()
    {
      public void onLogoutFinish(boolean paramAnonymousBoolean)
      {
        if ((this.a instanceof Activity)) {
          ((Activity)this.a).finish();
        }
      }
    });
  }
  
  private void a(Uri paramUri)
  {
    Intent localIntent = new Intent("com.android.camera.action.CROP");
    localIntent.setDataAndType(paramUri, "image/*");
    localIntent.putExtra("crop", "true");
    localIntent.putExtra("aspectX", 1);
    localIntent.putExtra("aspectY", 1);
    localIntent.putExtra("outputX", this.b);
    localIntent.putExtra("outputY", this.c);
    localIntent.putExtra("scale", true);
    localIntent.putExtra("scaleUpIfNeeded", true);
    localIntent.putExtra("return-data", false);
    localIntent.putExtra("output", this.a);
    localIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
    localIntent.putExtra("noFaceDetection", true);
    startActivityForResult(localIntent, 3021);
  }
  
  private void b()
  {
    ImagePipeline localImagePipeline = Fresco.getImagePipeline();
    localImagePipeline.clearMemoryCaches();
    localImagePipeline.clearDiskCaches();
    Fresco.getImagePipelineFactory().getMainFileCache().trimToMinimum();
    long l2 = Fresco.getImagePipelineFactory().getMainFileCache().getSize();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    this.mTvDelete.setText(Formatter.formatFileSize(this, Long.valueOf(l1).longValue()) + "");
    if (l1 > 0L) {
      b();
    }
    for (;;)
    {
      localImagePipeline.clearCaches();
      return;
      dismissProgress();
    }
  }
  
  /* Error */
  public static String getDataColumn(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 284	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: aload_1
    //   8: iconst_1
    //   9: anewarray 286	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc_w 288
    //   17: aastore
    //   18: aload_2
    //   19: aload_3
    //   20: aconst_null
    //   21: invokevirtual 294	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +40 -> 66
    //   29: aload_1
    //   30: invokeinterface 300 1 0
    //   35: ifeq +31 -> 66
    //   38: aload_1
    //   39: aload_1
    //   40: ldc_w 288
    //   43: invokeinterface 304 2 0
    //   48: invokeinterface 305 2 0
    //   53: astore_0
    //   54: aload_1
    //   55: ifnull +9 -> 64
    //   58: aload_1
    //   59: invokeinterface 308 1 0
    //   64: aload_0
    //   65: areturn
    //   66: aload_1
    //   67: ifnull +9 -> 76
    //   70: aload_1
    //   71: invokeinterface 308 1 0
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: aload 4
    //   81: astore_1
    //   82: aload_1
    //   83: ifnull +9 -> 92
    //   86: aload_1
    //   87: invokeinterface 308 1 0
    //   92: aload_0
    //   93: athrow
    //   94: astore_0
    //   95: goto -13 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramContext	Context
    //   0	98	1	paramUri	Uri
    //   0	98	2	paramString	String
    //   0	98	3	paramArrayOfString	String[]
    //   1	79	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	25	78	finally
    //   29	54	94	finally
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
        break label224;
      }
      if (!isExternalStorageDocument(paramUri)) {
        break label93;
      }
      paramContext = DocumentsContract.getDocumentId(paramUri).split(":");
      if ("primary".equalsIgnoreCase(paramContext[0])) {
        localObject1 = Environment.getExternalStorageDirectory() + "/" + paramContext[1];
      }
    }
    label93:
    label224:
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
            a(this.a);
            return;
          } while (paramInt2 != -1);
          paramIntent = com.ziroom.commonlibrary.login.a.getToken(this);
          com.freelxl.baselibrary.f.d.d("", "======head:" + this.a.getPath());
          j.headImgUpload(this, paramIntent, new File(this.a.getPath()), new f(this, new o())
          {
            public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
            {
              super.onSuccess(paramAnonymousInt, paramAnonymouse);
              if (MyInfoSettingActivity.d(MyInfoSettingActivity.this) != null)
              {
                File localFile = new File(MyInfoSettingActivity.d(MyInfoSettingActivity.this).getPath());
                if (localFile.exists()) {
                  localFile.delete();
                }
              }
              g.textToast(MyInfoSettingActivity.this, MyInfoSettingActivity.this.getString(2131297263));
              paramAnonymouse = paramAnonymouse.getString("url");
              ApplicationEx.c.getUser().setHeadImg(paramAnonymouse);
              MyInfoSettingActivity.e(MyInfoSettingActivity.this);
            }
          });
          return;
        } while ((paramInt2 != -1) || (paramIntent == null) || (paramIntent.getData() == null));
        a(Uri.fromFile(new File(getPath(getApplicationContext(), paramIntent.getData()))));
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      paramIntent = paramIntent.getStringExtra("path");
    } while (TextUtils.isEmpty(paramIntent));
    j.headImgUpload(this, com.ziroom.commonlibrary.login.a.getToken(this), new File(paramIntent), new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (MyInfoSettingActivity.d(MyInfoSettingActivity.this) != null)
        {
          File localFile = new File(MyInfoSettingActivity.d(MyInfoSettingActivity.this).getPath());
          if (localFile.exists()) {
            localFile.delete();
          }
        }
        g.textToast(MyInfoSettingActivity.this, MyInfoSettingActivity.this.getString(2131297263));
        paramAnonymouse = paramAnonymouse.getString("url");
        ApplicationEx.c.getUser().setHeadImg(paramAnonymouse);
        MyInfoSettingActivity.e(MyInfoSettingActivity.this);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    long l1 = 0L;
    super.onCreate(paramBundle);
    setContentView(2130903373);
    this.e = ButterKnife.bind(this);
    paramBundle = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.r, paramBundle);
    Fresco.getImagePipelineFactory().getMainFileCache().trimToMinimum();
    long l2 = Fresco.getImagePipelineFactory().getMainFileCache().getSize();
    if (l2 < 0L) {}
    for (;;)
    {
      this.mTvDelete.setText(Formatter.formatFileSize(this, Long.valueOf(l1).longValue()) + "");
      a();
      return;
      l1 = l2;
    }
  }
  
  protected void onDestroy()
  {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.r);
    this.e.unbind();
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    a();
  }
  
  @OnClick({2131691842, 2131691841, 2131691843, 2131691844, 2131691845, 2131691846, 2131691847, 2131691850, 2131689895, 2131691848})
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691848: 
      com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setContent("您确认要清除本地缓存吗？").setTitle("清除缓存").setButtonText("取消", "确认").setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          MyInfoSettingActivity.this.showProgress("");
          MyInfoSettingActivity.b(MyInfoSettingActivity.this);
        }
      }).show();
      return;
    case 2131689895: 
      finish();
      return;
    case 2131691842: 
      startActivityForResult(com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(this, false, 1, true, this.b, this.c), 1);
      return;
    case 2131691841: 
      b("nickname");
      paramView = new Intent();
      paramView.setClass(this, MyNickNameActivity.class);
      if (((ApplicationEx)getApplication()).getUser() != null) {
        paramView.putExtra("nickname", this.d);
      }
      startActivity(paramView);
      overridePendingTransition(2130968681, 2130968686);
      return;
    case 2131691843: 
      com.ziroom.commonlibrary.login.a.getUserInfo(this, new a.b()
      {
        public void onUserInfo(e paramAnonymouse)
        {
          if (paramAnonymouse == null) {
            return;
          }
          MyInfoSettingActivity.a(MyInfoSettingActivity.this, (String)paramAnonymouse.get("phone"));
          if (ae.notNull(MyInfoSettingActivity.a(MyInfoSettingActivity.this)))
          {
            j.getCertInfo(MyInfoSettingActivity.this, com.ziroom.commonlibrary.login.a.getToken(MyInfoSettingActivity.this), 0, MyInfoSettingActivity.c(MyInfoSettingActivity.this));
            return;
          }
          com.ziroom.commonlibrary.login.a.startBindPhoneActivity(MyInfoSettingActivity.this);
        }
      });
      return;
    case 2131691844: 
      paramView = new Intent(this, SignerAptitudeActivity.class);
      paramView.addFlags(335544320);
      paramView.putExtra("activityName", "AccountInfoActivity");
      startActivity(paramView);
      return;
    case 2131691845: 
      startActivity(new Intent(this, EducationActivity.class));
      return;
    case 2131691846: 
      startActivity(new Intent(this, MyAccountActivity.class));
      return;
    case 2131691847: 
      startActivity(new Intent(this, AboutUsActivity.class));
      return;
    }
    a(this);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyInfoSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */