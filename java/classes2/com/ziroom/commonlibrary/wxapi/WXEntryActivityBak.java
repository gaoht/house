package com.ziroom.commonlibrary.wxapi;

import android.content.pm.PackageManager;
import cn.sharesdk.wechat.utils.WXAppExtendObject;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WechatHandlerActivity;
import com.freelxl.baselibrary.f.g;

public class WXEntryActivityBak
  extends WechatHandlerActivity
{
  public void onGetMessageFromWXReq(WXMediaMessage paramWXMediaMessage)
  {
    startActivity(getPackageManager().getLaunchIntentForPackage(getPackageName()));
  }
  
  public void onShowMessageFromWXReq(WXMediaMessage paramWXMediaMessage)
  {
    if ((paramWXMediaMessage != null) && (paramWXMediaMessage.mediaObject != null) && ((paramWXMediaMessage.mediaObject instanceof WXAppExtendObject))) {
      g.textToast(this, ((WXAppExtendObject)paramWXMediaMessage.mediaObject).extInfo, 0);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/wxapi/WXEntryActivityBak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */