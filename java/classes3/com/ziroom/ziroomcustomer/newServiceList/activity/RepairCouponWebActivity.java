package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.morepage.MoreItemView;
import com.ziroom.ziroomcustomer.morepage.MoreItemView.b;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.wxapi.a;
import java.util.HashMap;

public class RepairCouponWebActivity
  extends BaseActivity
  implements Handler.Callback, PlatformActionListener
{
  View.OnClickListener a = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131697535: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle(RepairCouponWebActivity.i(RepairCouponWebActivity.this));
        paramAnonymousView.setTitleUrl(RepairCouponWebActivity.a(RepairCouponWebActivity.this));
        paramAnonymousView.setText(RepairCouponWebActivity.j(RepairCouponWebActivity.this));
        paramAnonymousView.setImageUrl(RepairCouponWebActivity.k(RepairCouponWebActivity.this) + "");
        localObject = ShareSDK.getPlatform(QQ.NAME);
        ((Platform)localObject).setPlatformActionListener(RepairCouponWebActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697536: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle(RepairCouponWebActivity.i(RepairCouponWebActivity.this));
        paramAnonymousView.setTitleUrl(RepairCouponWebActivity.a(RepairCouponWebActivity.this));
        paramAnonymousView.setText(RepairCouponWebActivity.j(RepairCouponWebActivity.this));
        paramAnonymousView.setImageUrl(RepairCouponWebActivity.k(RepairCouponWebActivity.this) + "");
        paramAnonymousView.setSite("自如");
        paramAnonymousView.setSiteUrl("www.ziroom.com");
        localObject = ShareSDK.getPlatform(QZone.NAME);
        ((Platform)localObject).setPlatformActionListener(RepairCouponWebActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697537: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle(RepairCouponWebActivity.i(RepairCouponWebActivity.this));
        paramAnonymousView.setText(RepairCouponWebActivity.i(RepairCouponWebActivity.this) + "  " + RepairCouponWebActivity.j(RepairCouponWebActivity.this) + " @自如客 " + RepairCouponWebActivity.a(RepairCouponWebActivity.this));
        u.e("---------", "--------------weibo-------------------");
        paramAnonymousView.setImageUrl(RepairCouponWebActivity.k(RepairCouponWebActivity.this) + "");
        localObject = ShareSDK.getPlatform(SinaWeibo.NAME);
        ((Platform)localObject).setPlatformActionListener(RepairCouponWebActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697538: 
        paramAnonymousView = new WXWebpageObject();
        paramAnonymousView.webpageUrl = RepairCouponWebActivity.a(RepairCouponWebActivity.this);
        paramAnonymousView = new WXMediaMessage(paramAnonymousView);
        paramAnonymousView.title = RepairCouponWebActivity.i(RepairCouponWebActivity.this);
        paramAnonymousView.description = RepairCouponWebActivity.j(RepairCouponWebActivity.this);
        paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(RepairCouponWebActivity.this.getResources(), 2130838626), true);
        localObject = new SendMessageToWX.Req();
        ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
        ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
        ((SendMessageToWX.Req)localObject).scene = 1;
        RepairCouponWebActivity.b(RepairCouponWebActivity.this).sendReq((BaseReq)localObject);
        return;
      }
      paramAnonymousView = new WXWebpageObject();
      paramAnonymousView.webpageUrl = RepairCouponWebActivity.a(RepairCouponWebActivity.this);
      paramAnonymousView = new WXMediaMessage(paramAnonymousView);
      paramAnonymousView.title = RepairCouponWebActivity.i(RepairCouponWebActivity.this);
      paramAnonymousView.description = RepairCouponWebActivity.j(RepairCouponWebActivity.this);
      paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(RepairCouponWebActivity.this.getResources(), 2130838626), true);
      Object localObject = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
      ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
      RepairCouponWebActivity.b(RepairCouponWebActivity.this).sendReq((BaseReq)localObject);
    }
  };
  private MoreItemView b;
  private Context c;
  private ImageView d;
  private LinearLayout e;
  private LinearLayout f;
  private LinearLayout g;
  private LinearLayout r;
  private LinearLayout s;
  private IWXAPI t;
  private String u;
  private String v;
  private String w;
  private String x;
  
  private void a()
  {
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (BaseActivity.checkNet(RepairCouponWebActivity.this.getApplicationContext()))
        {
          if (RepairCouponWebActivity.a(RepairCouponWebActivity.this) != null)
          {
            RepairCouponWebActivity.a(RepairCouponWebActivity.this, WXAPIFactory.createWXAPI(RepairCouponWebActivity.this, "wxc2bae7e8ecb7d70b", true));
            RepairCouponWebActivity.b(RepairCouponWebActivity.this).registerApp("wxc2bae7e8ecb7d70b");
            paramAnonymousView = LayoutInflater.from(RepairCouponWebActivity.c(RepairCouponWebActivity.this)).inflate(2130905131, null);
            RepairCouponWebActivity.a(RepairCouponWebActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697535));
            RepairCouponWebActivity.b(RepairCouponWebActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697536));
            RepairCouponWebActivity.c(RepairCouponWebActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697537));
            RepairCouponWebActivity.d(RepairCouponWebActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697539));
            RepairCouponWebActivity.e(RepairCouponWebActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697538));
            RepairCouponWebActivity.d(RepairCouponWebActivity.this).setOnClickListener(RepairCouponWebActivity.this.a);
            RepairCouponWebActivity.e(RepairCouponWebActivity.this).setOnClickListener(RepairCouponWebActivity.this.a);
            RepairCouponWebActivity.f(RepairCouponWebActivity.this).setOnClickListener(RepairCouponWebActivity.this.a);
            RepairCouponWebActivity.g(RepairCouponWebActivity.this).setOnClickListener(RepairCouponWebActivity.this.a);
            RepairCouponWebActivity.h(RepairCouponWebActivity.this).setOnClickListener(RepairCouponWebActivity.this.a);
            Dialog localDialog = new Dialog(RepairCouponWebActivity.this, 2131427781);
            localDialog.setContentView(paramAnonymousView);
            if (!(localDialog instanceof Dialog))
            {
              localDialog.show();
              return;
            }
            VdsAgent.showDialog((Dialog)localDialog);
            return;
          }
          g.textToast(RepairCouponWebActivity.c(RepairCouponWebActivity.this), "房源尚未加载完成");
          return;
        }
        g.textToast(RepairCouponWebActivity.c(RepairCouponWebActivity.this), "网络连接错误");
      }
    });
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.arg1)
    {
    }
    return false;
  }
  
  public void initView()
  {
    this.u = getIntent().getStringExtra("url");
    this.w = getIntent().getStringExtra("pic");
    this.v = getIntent().getStringExtra("title");
    this.x = getIntent().getStringExtra("subtitle");
    this.d = ((ImageView)findViewById(2131691042));
    this.b = ((MoreItemView)findViewById(2131692134));
    this.b.setTitle(this.v);
    this.b.setWeb(this.u);
    this.b.setBack(new MoreItemView.b()
    {
      public void backtoActivity()
      {
        RepairCouponWebActivity.this.finish();
      }
    });
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    g.textToast(this.c, "分享取消");
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    g.textToast(this.c, "分享成功");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903444);
    this.c = this;
    MobSDK.init(this.c);
    initView();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    g.textToast(this.c, "分享失败");
    if ("SinaWeibo".equals(paramPlatform.getName()))
    {
      ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
      ShareSDK.removeCookieOnAuthorize(true);
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairCouponWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */