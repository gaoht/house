package com.ziroom.ziroomcustomer.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.wxapi.a;

public class ShareAppDialog
  extends DialogFragment
{
  private IWXAPI a;
  
  @OnClick({2131693876, 2131693877, 2131693878, 2131693880, 2131693879})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    Object localObject = BitmapFactory.decodeResource(getContext().getResources(), 2130838626);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      dismiss();
      return;
      paramView = new Platform.ShareParams();
      paramView.setTitle("自如App");
      paramView.setTitleUrl("http://t.cn/RqOAHxW");
      paramView.setText("自如，创造品质租住生活");
      Platform localPlatform = ShareSDK.getPlatform(QQ.NAME);
      paramView.setImageData((Bitmap)localObject);
      localPlatform.share(paramView);
      w.onEvent("personalcenter_shareapp_QQ");
      continue;
      paramView = new Platform.ShareParams();
      paramView.setTitle("自如App");
      paramView.setTitleUrl("http://t.cn/RqOAHxW");
      paramView.setText("自如，创造品质租住生活");
      paramView.setImageData((Bitmap)localObject);
      ShareSDK.getPlatform(SinaWeibo.NAME).share(paramView);
      w.onEvent("personalcenter_shareapp_weibo");
      continue;
      paramView = new WXWebpageObject();
      paramView.webpageUrl = "http://t.cn/RqOAHxW";
      paramView = new WXMediaMessage(paramView);
      paramView.title = "自如App";
      paramView.description = "自如，创造品质租住生活";
      paramView.thumbData = a.bmpToByteArray((Bitmap)localObject, true);
      localObject = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
      ((SendMessageToWX.Req)localObject).message = paramView;
      this.a.sendReq((BaseReq)localObject);
      w.onEvent("personalcenter_shareapp_webchat");
      continue;
      paramView = new WXWebpageObject();
      paramView.webpageUrl = "http://t.cn/RqOAHxW";
      paramView = new WXMediaMessage(paramView);
      paramView.title = "自如App";
      paramView.description = "自如，创造品质租住生活";
      paramView.thumbData = a.bmpToByteArray((Bitmap)localObject, true);
      localObject = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
      ((SendMessageToWX.Req)localObject).message = paramView;
      ((SendMessageToWX.Req)localObject).scene = 1;
      this.a.sendReq((BaseReq)localObject);
      w.onEvent(getContext(), "personalcenter_shareapp_fcircle");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = WXAPIFactory.createWXAPI(getContext(), "wxc2bae7e8ecb7d70b", true);
    this.a.registerApp("wxc2bae7e8ecb7d70b");
    MobSDK.init(getContext());
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = super.onCreateDialog(paramBundle);
    paramBundle.getWindow().requestFeature(1);
    return paramBundle;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903849, paramViewGroup, false);
    ButterKnife.bind(this, paramLayoutInflater);
    paramViewGroup = getDialog().getWindow();
    paramViewGroup.setGravity(80);
    paramViewGroup.setWindowAnimations(2131427944);
    paramViewGroup.getDecorView().setPadding(0, 0, 0, 0);
    paramViewGroup.getDecorView().setBackgroundColor(Color.parseColor("#FFFFFFFF"));
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    int i = ac.getScreenWidth(getContext());
    getDialog().getWindow().setLayout(i, -2);
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/dialog/ShareAppDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */