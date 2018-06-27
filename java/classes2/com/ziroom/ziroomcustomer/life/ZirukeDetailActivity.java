package com.ziroom.ziroomcustomer.life;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
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

public class ZirukeDetailActivity
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
        Log.e("QQ", "QQ");
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如这个活动不错。");
        paramAnonymousView.setTitleUrl(ZirukeDetailActivity.a(ZirukeDetailActivity.this));
        paramAnonymousView.setText(ZirukeDetailActivity.i(ZirukeDetailActivity.this));
        paramAnonymousView.setImageUrl(ZirukeDetailActivity.j(ZirukeDetailActivity.this) + "");
        localObject = ShareSDK.getPlatform(QQ.NAME);
        ((Platform)localObject).setPlatformActionListener(ZirukeDetailActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697536: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如这个活动不错。");
        paramAnonymousView.setTitleUrl(ZirukeDetailActivity.a(ZirukeDetailActivity.this));
        paramAnonymousView.setText(ZirukeDetailActivity.i(ZirukeDetailActivity.this));
        paramAnonymousView.setImageUrl(ZirukeDetailActivity.j(ZirukeDetailActivity.this) + "");
        paramAnonymousView.setSite("自如");
        paramAnonymousView.setSiteUrl("www.ziroom.com");
        localObject = ShareSDK.getPlatform(QZone.NAME);
        ((Platform)localObject).setPlatformActionListener(ZirukeDetailActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697537: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如这个房子不错。");
        paramAnonymousView.setText("自如这个活动不错. " + ZirukeDetailActivity.i(ZirukeDetailActivity.this) + " @自如客 " + ZirukeDetailActivity.a(ZirukeDetailActivity.this));
        u.e("---------", "--------------weibo-------------------");
        paramAnonymousView.setImageUrl(ZirukeDetailActivity.j(ZirukeDetailActivity.this) + "");
        localObject = ShareSDK.getPlatform(SinaWeibo.NAME);
        ((Platform)localObject).setPlatformActionListener(ZirukeDetailActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697538: 
        paramAnonymousView = new WXWebpageObject();
        paramAnonymousView.webpageUrl = ZirukeDetailActivity.a(ZirukeDetailActivity.this);
        paramAnonymousView = new WXMediaMessage(paramAnonymousView);
        paramAnonymousView.title = ("自如这个活动不错 " + ZirukeDetailActivity.i(ZirukeDetailActivity.this));
        paramAnonymousView.description = ZirukeDetailActivity.i(ZirukeDetailActivity.this);
        paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(ZirukeDetailActivity.this.getResources(), 2130838626), true);
        localObject = new SendMessageToWX.Req();
        ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
        ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
        ((SendMessageToWX.Req)localObject).scene = 1;
        ZirukeDetailActivity.b(ZirukeDetailActivity.this).sendReq((BaseReq)localObject);
        return;
      }
      paramAnonymousView = new WXWebpageObject();
      paramAnonymousView.webpageUrl = ZirukeDetailActivity.a(ZirukeDetailActivity.this);
      paramAnonymousView = new WXMediaMessage(paramAnonymousView);
      paramAnonymousView.title = "自如这个活动不错。";
      paramAnonymousView.description = ZirukeDetailActivity.i(ZirukeDetailActivity.this);
      paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(ZirukeDetailActivity.this.getResources(), 2130838626), true);
      Object localObject = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
      ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
      ZirukeDetailActivity.b(ZirukeDetailActivity.this).sendReq((BaseReq)localObject);
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
  
  private void a()
  {
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (BaseActivity.checkNet(ZirukeDetailActivity.this.getApplicationContext()))
        {
          if (ZirukeDetailActivity.a(ZirukeDetailActivity.this) != null)
          {
            ZirukeDetailActivity.a(ZirukeDetailActivity.this, WXAPIFactory.createWXAPI(ZirukeDetailActivity.this, "wxc2bae7e8ecb7d70b", true));
            ZirukeDetailActivity.b(ZirukeDetailActivity.this).registerApp("wxc2bae7e8ecb7d70b");
            paramAnonymousView = LayoutInflater.from(ZirukeDetailActivity.c(ZirukeDetailActivity.this)).inflate(2130905131, null);
            ZirukeDetailActivity.a(ZirukeDetailActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697535));
            ZirukeDetailActivity.b(ZirukeDetailActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697536));
            ZirukeDetailActivity.c(ZirukeDetailActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697537));
            ZirukeDetailActivity.d(ZirukeDetailActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697539));
            ZirukeDetailActivity.e(ZirukeDetailActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697538));
            ZirukeDetailActivity.d(ZirukeDetailActivity.this).setOnClickListener(ZirukeDetailActivity.this.a);
            ZirukeDetailActivity.e(ZirukeDetailActivity.this).setOnClickListener(ZirukeDetailActivity.this.a);
            ZirukeDetailActivity.f(ZirukeDetailActivity.this).setOnClickListener(ZirukeDetailActivity.this.a);
            ZirukeDetailActivity.g(ZirukeDetailActivity.this).setOnClickListener(ZirukeDetailActivity.this.a);
            ZirukeDetailActivity.h(ZirukeDetailActivity.this).setOnClickListener(ZirukeDetailActivity.this.a);
            Dialog localDialog = new Dialog(ZirukeDetailActivity.this, 2131427781);
            localDialog.setContentView(paramAnonymousView);
            if (!(localDialog instanceof Dialog))
            {
              localDialog.show();
              return;
            }
            VdsAgent.showDialog((Dialog)localDialog);
            return;
          }
          g.textToast(ZirukeDetailActivity.c(ZirukeDetailActivity.this), "房源尚未加载完成", 0);
          return;
        }
        g.textToast(ZirukeDetailActivity.c(ZirukeDetailActivity.this), "网络连接错误", 0);
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
    Intent localIntent = getIntent();
    this.u = localIntent.getStringExtra("url");
    this.v = localIntent.getStringExtra("title");
    this.w = localIntent.getStringExtra("pic");
    this.d = ((ImageView)findViewById(2131691042));
    this.b = ((MoreItemView)findViewById(2131692134));
    this.b.setTitle(this.v);
    this.b.setWeb(this.u);
    this.b.setBack(new MoreItemView.b()
    {
      public void backtoActivity()
      {
        ZirukeDetailActivity.this.finish();
      }
    });
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    showToast("分享取消");
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    showToast("分享成功");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905246);
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
    showToast("分享失败");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/life/ZirukeDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */