package com.ziroom.ziroomcustomer.my.selfsetting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.View;
import com.alibaba.fastjson.e;
import com.facebook.cache.disk.FileCache;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.CreditsBean;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.MyAccountActivity;
import com.ziroom.ziroomcustomer.my.MyNickNameActivity;
import com.ziroom.ziroomcustomer.my.aboutus.AboutUsActivity;
import com.ziroom.ziroomcustomer.signed.CertInformationActivity;
import com.ziroom.ziroomcustomer.signed.CertificationInfoActivity;
import com.ziroom.ziroomcustomer.signed.SignerAptitudeActivity;
import com.ziroom.ziroomcustomer.signed.education.EducationActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import java.io.File;
import java.lang.ref.WeakReference;

public class b
  implements a.a
{
  WeakReference<a.b> a;
  private String b;
  private String c;
  private int d = 200;
  private int e = 200;
  
  public b(a.b paramb)
  {
    this.a = new WeakReference(paramb);
    if (getView() != null) {
      getView().setPresenter(this);
    }
  }
  
  private void a()
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
    getView().showCacheSize(Formatter.formatFileSize(getView().getViewContext(), Long.valueOf(l1).longValue()) + "");
    if (l1 > 0L) {
      a();
    }
    for (;;)
    {
      localImagePipeline.clearCaches();
      return;
      ((SelfSettingActivity)getView().getViewContext()).dismissProgress();
    }
  }
  
  private static void a(Context paramContext)
  {
    com.ziroom.commonlibrary.login.a.showLogoutDialog(paramContext, new com.ziroom.commonlibrary.login.a.a()
    {
      public void onLogoutFinish(boolean paramAnonymousBoolean)
      {
        if ((this.a instanceof Activity)) {
          ((Activity)this.a).finish();
        }
      }
    });
  }
  
  public void clearCache()
  {
    d.newBuilder(getView().getViewContext()).setContent("您确认要清除本地缓存吗？").setTitle("清除缓存").setButtonText("取消", "确认").setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        ((SelfSettingActivity)b.this.getView().getViewContext()).showProgress("");
        b.b(b.this);
      }
    }).show();
  }
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public a.b getView()
  {
    if (this.a != null) {
      return (a.b)this.a.get();
    }
    return null;
  }
  
  public void initData()
  {
    long l1 = 0L;
    Fresco.getImagePipelineFactory().getMainFileCache().trimToMinimum();
    long l2 = Fresco.getImagePipelineFactory().getMainFileCache().getSize();
    if (l2 < 0L) {}
    for (;;)
    {
      getView().showCacheSize(Formatter.formatFileSize(getView().getViewContext(), Long.valueOf(l1).longValue()) + "");
      initNickname();
      return;
      l1 = l2;
    }
  }
  
  public void initNickname()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null)
    {
      getView().showHeadPic(localUserInfo.getHead_img());
      if (TextUtils.isEmpty(localUserInfo.getNick_name())) {
        break label79;
      }
      this.b = localUserInfo.getNick_name();
    }
    while (TextUtils.isEmpty(this.b))
    {
      getView().showNickname(getView().getViewContext().getResources().getString(2131297329));
      return;
      label79:
      if (!TextUtils.isEmpty(localUserInfo.getLogin_name_mobile())) {
        this.b = localUserInfo.getLogin_name_mobile();
      } else if (!TextUtils.isEmpty(localUserInfo.getLogin_name_email())) {
        this.b = localUserInfo.getLogin_name_email();
      }
    }
    getView().showNickname(this.b);
  }
  
  public void logOut()
  {
    a(getView().getViewContext());
  }
  
  public void start() {}
  
  public void toAboutUs()
  {
    Intent localIntent = new Intent(getView().getViewContext(), AboutUsActivity.class);
    getView().getViewContext().startActivity(localIntent);
  }
  
  public void toAccountInfoManage()
  {
    Intent localIntent = new Intent(getView().getViewContext(), MyAccountActivity.class);
    getView().getViewContext().startActivity(localIntent);
  }
  
  public void toAptitudeInfo()
  {
    Intent localIntent = new Intent(getView().getViewContext(), SignerAptitudeActivity.class);
    localIntent.addFlags(335544320);
    localIntent.putExtra("activityName", "AccountInfoActivity");
    getView().getViewContext().startActivity(localIntent);
  }
  
  public void toCertInfo()
  {
    com.ziroom.commonlibrary.login.a.getUserInfo(getView().getViewContext(), new com.ziroom.commonlibrary.login.a.b()
    {
      public void onUserInfo(e paramAnonymouse)
      {
        if (paramAnonymouse == null) {
          return;
        }
        b.a(b.this, (String)paramAnonymouse.get("phone"));
        if (ae.notNull(b.a(b.this)))
        {
          j.getCertInfo(b.this.getView().getViewContext(), com.ziroom.commonlibrary.login.a.getToken(b.this.getView().getViewContext()), 0, new f(b.this.getView().getViewContext(), new o())
          {
            public void onFailure(Throwable paramAnonymous2Throwable)
            {
              dismissProgress();
              super.onFailure(paramAnonymous2Throwable);
            }
            
            public void onSuccess(int paramAnonymous2Int, e paramAnonymous2e)
            {
              dismissProgress();
              paramAnonymous2e = (CertInfoEntity)h.parseObject(paramAnonymous2e.toJSONString(), CertInfoEntity.class);
              if ((paramAnonymous2e != null) && (paramAnonymous2e.credits != null) && (paramAnonymous2e.credits.realNameStatus != 0)) {}
              switch (paramAnonymous2e.credits.realNameStatus)
              {
              default: 
                return;
              case 2: 
                localIntent = new Intent(b.this.getView().getViewContext(), CertificationInfoActivity.class);
                localIntent.putExtra("cert_info", paramAnonymous2e);
                localIntent.putExtra("phone", b.a(b.this));
                localIntent.putExtra("type", 0);
                b.this.getView().getViewContext().startActivity(localIntent);
                return;
              case 3: 
                localIntent = new Intent(b.this.getView().getViewContext(), CertificationInfoActivity.class);
                localIntent.putExtra("cert_info", paramAnonymous2e);
                localIntent.putExtra("phone", b.a(b.this));
                localIntent.putExtra("type", 0);
                b.this.getView().getViewContext().startActivity(localIntent);
                return;
              case 4: 
                localIntent = new Intent(b.this.getView().getViewContext(), CertificationInfoActivity.class);
                localIntent.putExtra("cert_info", paramAnonymous2e);
                localIntent.putExtra("phone", b.a(b.this));
                localIntent.putExtra("type", 0);
                b.this.getView().getViewContext().startActivity(localIntent);
                return;
              case 1: 
                if ("1".equals(paramAnonymous2e.getCert_type()))
                {
                  localIntent = new Intent(b.this.getView().getViewContext(), CertInformationActivity.class);
                  localIntent.putExtra("cert_info", paramAnonymous2e);
                  localIntent.putExtra("phone", b.a(b.this));
                  localIntent.putExtra("type", 0);
                  b.this.getView().getViewContext().startActivity(localIntent);
                  return;
                }
                localIntent = new Intent(b.this.getView().getViewContext(), CertificationInfoActivity.class);
                localIntent.putExtra("cert_info", paramAnonymous2e);
                localIntent.putExtra("phone", b.a(b.this));
                localIntent.putExtra("type", 0);
                b.this.getView().getViewContext().startActivity(localIntent);
                return;
              }
              Intent localIntent = new Intent(b.this.getView().getViewContext(), CertInformationActivity.class);
              localIntent.putExtra("cert_info", paramAnonymous2e);
              localIntent.putExtra("phone", b.a(b.this));
              localIntent.putExtra("type", 0);
              b.this.getView().getViewContext().startActivity(localIntent);
            }
          });
          return;
        }
        com.ziroom.commonlibrary.login.a.startBindPhoneActivity(b.this.getView().getViewContext());
      }
    });
  }
  
  public void toSchoolInfo()
  {
    Intent localIntent = new Intent(getView().getViewContext(), EducationActivity.class);
    getView().getViewContext().startActivity(localIntent);
  }
  
  public void toSetNickname()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(getView().getViewContext(), MyNickNameActivity.class);
    if (ApplicationEx.c.getUser() != null) {
      localIntent.putExtra("nickname", this.b);
    }
    getView().getViewContext().startActivity(localIntent);
    if ((getView().getViewContext() instanceof SelfSettingActivity)) {
      ((SelfSettingActivity)getView().getViewContext()).overridePendingTransition(2130968681, 2130968686);
    }
  }
  
  public void uploadHeadPic(String paramString)
  {
    String str = com.ziroom.commonlibrary.login.a.getToken(getView().getViewContext());
    j.headImgUpload(getView().getViewContext(), str, new File(paramString), new f(getView().getViewContext(), new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        b.this.getView().deleteCacheFile();
        g.textToast(b.this.getView().getViewContext(), 2131297263);
        paramAnonymouse = paramAnonymouse.getString("url");
        ApplicationEx.c.getUser().setHeadImg(paramAnonymouse);
        b.this.initNickname();
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/selfsetting/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */