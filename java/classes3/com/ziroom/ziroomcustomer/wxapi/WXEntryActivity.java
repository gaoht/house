package com.ziroom.ziroomcustomer.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import cn.sharesdk.wechat.utils.WXAppExtendObject;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WechatHandlerActivity;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.ziroom.commonlib.utils.l;
import com.ziroom.ziroomcustomer.base.ApplicationEx;

public class WXEntryActivity
  extends WechatHandlerActivity
  implements IWXAPIEventHandler
{
  private IWXAPI a;
  
  private void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("wx_share_result");
    localIntent.putExtra("type", paramInt1);
    localIntent.putExtra("code", paramInt2);
    paramActivity.sendBroadcast(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = WXAPIFactory.createWXAPI(this, "wx484d02e10be8f5c9", false);
    this.a.registerApp("wx484d02e10be8f5c9");
    try
    {
      this.a.handleIntent(getIntent(), this);
      l.d("#########handleIntent#######", Boolean.valueOf(this.a.handleIntent(getIntent(), this)));
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void onGetMessageFromWXReq(WXMediaMessage paramWXMediaMessage)
  {
    startActivity(getPackageManager().getLaunchIntentForPackage(getPackageName()));
    d.d("share", "=======" + paramWXMediaMessage.toString());
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp)
  {
    a(this, paramBaseResp.getType(), paramBaseResp.errCode);
    String str;
    if (paramBaseResp.getType() == 2)
    {
      str = null;
      switch (paramBaseResp.errCode)
      {
      case -3: 
      case -1: 
      default: 
        str = "未知错误";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        g.textToast(ApplicationEx.c, str + "");
      }
      finish();
      return;
      str = "分享成功";
      continue;
      str = "分享失败";
    }
  }
  
  public void onShowMessageFromWXReq(WXMediaMessage paramWXMediaMessage)
  {
    Log.d("share", "=======" + paramWXMediaMessage);
    if ((paramWXMediaMessage != null) && (paramWXMediaMessage.mediaObject != null) && ((paramWXMediaMessage.mediaObject instanceof WXAppExtendObject))) {
      g.textToast(this, ((WXAppExtendObject)paramWXMediaMessage.mediaObject).extInfo, 0);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/wxapi/WXEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */