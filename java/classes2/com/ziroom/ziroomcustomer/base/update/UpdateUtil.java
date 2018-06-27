package com.ziroom.ziroomcustomer.base.update;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.view.View;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.k;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.widget.a.a.a;
import com.ziroom.ziroomcustomer.widget.a.a.b;
import java.io.File;

public class UpdateUtil
{
  private static UpdateUtil sInstance;
  private String apkFileName = "ziroomcustomer.apk";
  private Context mContext;
  private NeedOtherCheckUpdate mNeedOtherCheckUpdate;
  private String url = q.o + "vcm/api/version/checkMostVersion";
  
  public static UpdateUtil getInstance()
  {
    if (sInstance != null) {
      return sInstance;
    }
    try
    {
      if (sInstance == null) {
        sInstance = new UpdateUtil();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void getNewApp(final String paramString)
  {
    try
    {
      if (("mounted".equals(Environment.getExternalStorageState())) && (this.mContext.getExternalFilesDir(null) != null))
      {
        final File localFile = new File(Environment.getExternalStorageDirectory() + "/" + this.mContext.getPackageName());
        if (!localFile.mkdir()) {
          localFile.mkdirs();
        }
        localFile = new File(localFile, this.apkFileName);
        DownloadAPKUtil.download(this.mContext, localFile, paramString, new Callback()
        {
          public void callback(Boolean paramAnonymousBoolean)
          {
            if (!paramAnonymousBoolean.booleanValue())
            {
              g.textToast(UpdateUtil.this.mContext, "下载失败,使用浏览器下载", 0);
              UpdateUtil.this.installByBrowser(paramString);
              return;
            }
            UpdateUtil.this.installByApp(localFile);
          }
        });
      }
      return;
    }
    catch (Exception paramString)
    {
      g.textToast(this.mContext, "安装出错，请向负责人索要地址，使用浏览器下载重试", 0);
      paramString.printStackTrace();
    }
  }
  
  private PackageInfo getPackageInfo()
  {
    Object localObject = this.mContext.getPackageManager();
    String str = this.mContext.getPackageName();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(str, 0);
      return (PackageInfo)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private Integer getPackageInfoVersion()
  {
    PackageManager localPackageManager = this.mContext.getPackageManager();
    String str = this.mContext.getPackageName();
    try
    {
      int i = localPackageManager.getPackageInfo(str, 0).versionCode;
      return Integer.valueOf(i);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private void getUpdateMessageInfo(Activity paramActivity, com.ziroom.commonlibrary.a.a parama)
  {
    e locale = new e();
    locale.put("uid", com.ziroom.commonlibrary.login.a.getUid(ApplicationEx.c));
    locale.put("source", "1");
    paramActivity = getPackageInfo();
    if (paramActivity == null) {}
    for (paramActivity = "";; paramActivity = paramActivity.versionCode + "")
    {
      locale.put("versionName", paramActivity);
      locale.put("citycode", com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
      locale.put("channel", com.mcxiaoke.packer.helper.a.getChannel(this.mContext));
      locale.put("phoneVersionSDK", Build.VERSION.SDK);
      locale.put("networkType", NetWork.getNetWorkStatus(this.mContext) + "");
      this.url = (q.o + "vcm/api/version/checkMostVersion");
      k.requestGateWayService(this.mContext, this.url, locale, parama, false);
      return;
    }
  }
  
  private void installByApp(File paramFile)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.android.package-archive");
    localIntent.setFlags(268435456);
    this.mContext.startActivity(localIntent);
  }
  
  private void installByBrowser(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString));
    this.mContext.startActivity(localIntent);
  }
  
  private void showUpdateDialog(final UpdateObject paramUpdateObject)
  {
    a.a locala = com.ziroom.ziroomcustomer.widget.a.a.newBuilder(this.mContext).setTitle(paramUpdateObject.getUpgradeTitle());
    boolean bool;
    if (paramUpdateObject.getUpgradeType() == 2)
    {
      localObject = "";
      localObject = locala.setBtnCancelText((String)localObject).setBtnConfirmText(paramUpdateObject.getConformText()).setContent(paramUpdateObject.getUpgradeFeature());
      if (paramUpdateObject.getUpgradeType() != 2) {
        break label118;
      }
      bool = false;
      label58:
      locala = ((a.a)localObject).setCanceledOnBack(bool);
      if (paramUpdateObject.getUpgradeStyle() != 1) {
        break label123;
      }
    }
    label118:
    label123:
    for (Object localObject = paramUpdateObject.getBannerImageUrl();; localObject = "")
    {
      locala.setImageUrl((String)localObject).setContentInfo(paramUpdateObject.getUpgradeInfo()).setOnConfirmClickListener(new a.b()
      {
        public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {
            UpdateUtil.this.getNewApp(paramUpdateObject.getUpgradeURl());
          }
        }
      }).build().show();
      return;
      localObject = paramUpdateObject.getCancelText();
      break;
      bool = true;
      break label58;
    }
  }
  
  public void checkUpdate(Context paramContext, final UpdateListener paramUpdateListener)
  {
    this.mContext = paramContext;
    if (getPackageInfo() != null) {
      getUpdateMessageInfo((Activity)this.mContext, new com.ziroom.commonlibrary.a.a(this.mContext, new UpdateParser(UpdateObject.class))
      {
        public void onSuccess(int paramAnonymousInt, UpdateObject paramAnonymousUpdateObject)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousUpdateObject);
          if (paramAnonymousUpdateObject == null) {
            return;
          }
          paramUpdateListener.onDealUpdate(paramAnonymousUpdateObject);
        }
      });
    }
  }
  
  public void checkUpdate(Context paramContext, final boolean paramBoolean)
  {
    this.mContext = paramContext;
    if (getPackageInfo() != null) {
      getUpdateMessageInfo((Activity)this.mContext, new com.ziroom.commonlibrary.a.a(this.mContext, new UpdateParser(UpdateObject.class))
      {
        public void onSuccess(int paramAnonymousInt, UpdateObject paramAnonymousUpdateObject)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousUpdateObject);
          if (paramAnonymousUpdateObject == null) {}
          do
          {
            do
            {
              do
              {
                return;
                if (paramAnonymousUpdateObject.getUpgradeType() != 0) {
                  break;
                }
              } while (!paramBoolean);
              g.textToast(UpdateUtil.this.mContext, paramAnonymousUpdateObject.getNoticeMessage());
              return;
              if (paramAnonymousUpdateObject.getCanDownload() == 0) {
                break;
              }
            } while (UpdateUtil.this.mNeedOtherCheckUpdate == null);
            UpdateUtil.this.mNeedOtherCheckUpdate.checkUpdate();
            return;
            if (paramAnonymousUpdateObject.getUpgradeType() == 2)
            {
              UpdateUtil.this.showUpdateDialog(paramAnonymousUpdateObject);
              return;
            }
            paramAnonymousInt = ad.getAppUpdateVersion(UpdateUtil.this.mContext);
            if (paramAnonymousUpdateObject.getVersionCode() - paramAnonymousInt > 1)
            {
              ad.saveAppUpdateNum(UpdateUtil.this.mContext, 0);
              ad.saveAppUpdateVersion(UpdateUtil.this.mContext, paramAnonymousUpdateObject.getVersionCode());
            }
            paramAnonymousInt = ad.getAppUpdateNum(UpdateUtil.this.mContext);
            long l = ad.getAppUpdateTime(UpdateUtil.this.mContext);
            if ((paramAnonymousInt <= paramAnonymousUpdateObject.getPopTimes()) && (System.currentTimeMillis() - l > paramAnonymousUpdateObject.getPopInterval() * 1000))
            {
              ad.saveAppUpdateNum(UpdateUtil.this.mContext, paramAnonymousInt + 1);
              ad.saveAppUpdateTime(UpdateUtil.this.mContext, System.currentTimeMillis());
              UpdateUtil.this.showUpdateDialog(paramAnonymousUpdateObject);
              return;
            }
          } while (!paramBoolean);
          UpdateUtil.this.showUpdateDialog(paramAnonymousUpdateObject);
        }
      });
    }
  }
  
  public void setNeedOtherCheckUpdate(NeedOtherCheckUpdate paramNeedOtherCheckUpdate)
  {
    this.mNeedOtherCheckUpdate = paramNeedOtherCheckUpdate;
  }
  
  public static abstract interface NeedOtherCheckUpdate
  {
    public abstract void checkUpdate();
  }
  
  public static abstract interface UpdateListener
  {
    public abstract void onDealUpdate(UpdateObject paramUpdateObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/base/update/UpdateUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */