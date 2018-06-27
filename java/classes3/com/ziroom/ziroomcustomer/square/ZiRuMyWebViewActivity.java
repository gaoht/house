package com.ziroom.ziroomcustomer.square;

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
import com.ziroom.ziroomcustomer.wxapi.a;
import java.util.HashMap;

public class ZiRuMyWebViewActivity
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
        paramAnonymousView.setTitle("自如这个活动不错。");
        paramAnonymousView.setTitleUrl(ZiRuMyWebViewActivity.a(ZiRuMyWebViewActivity.this));
        paramAnonymousView.setText(ZiRuMyWebViewActivity.i(ZiRuMyWebViewActivity.this));
        paramAnonymousView.setImageUrl(ZiRuMyWebViewActivity.j(ZiRuMyWebViewActivity.this) + "");
        localObject = ShareSDK.getPlatform(QQ.NAME);
        ((Platform)localObject).setPlatformActionListener(ZiRuMyWebViewActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697536: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如这个活动不错。");
        paramAnonymousView.setTitleUrl(ZiRuMyWebViewActivity.a(ZiRuMyWebViewActivity.this));
        paramAnonymousView.setText(ZiRuMyWebViewActivity.i(ZiRuMyWebViewActivity.this));
        paramAnonymousView.setImageUrl(ZiRuMyWebViewActivity.j(ZiRuMyWebViewActivity.this) + "");
        paramAnonymousView.setSite("自如");
        paramAnonymousView.setSiteUrl("www.ziroom.com");
        localObject = ShareSDK.getPlatform(QZone.NAME);
        ((Platform)localObject).setPlatformActionListener(ZiRuMyWebViewActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697537: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如这个活动不错。");
        paramAnonymousView.setTitleUrl(ZiRuMyWebViewActivity.a(ZiRuMyWebViewActivity.this));
        paramAnonymousView.setText("自如这个活动不错. " + ZiRuMyWebViewActivity.i(ZiRuMyWebViewActivity.this) + " @自如客 " + ZiRuMyWebViewActivity.a(ZiRuMyWebViewActivity.this));
        paramAnonymousView.setImageUrl(ZiRuMyWebViewActivity.j(ZiRuMyWebViewActivity.this) + "");
        localObject = ShareSDK.getPlatform(SinaWeibo.NAME);
        ((Platform)localObject).setPlatformActionListener(ZiRuMyWebViewActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697538: 
        paramAnonymousView = new WXWebpageObject();
        paramAnonymousView.webpageUrl = ZiRuMyWebViewActivity.a(ZiRuMyWebViewActivity.this);
        paramAnonymousView = new WXMediaMessage(paramAnonymousView);
        paramAnonymousView.title = ("自如这个活动不错 " + ZiRuMyWebViewActivity.i(ZiRuMyWebViewActivity.this));
        paramAnonymousView.description = ZiRuMyWebViewActivity.i(ZiRuMyWebViewActivity.this);
        paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(ZiRuMyWebViewActivity.this.getResources(), 2130838626), true);
        localObject = new SendMessageToWX.Req();
        ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
        ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
        ((SendMessageToWX.Req)localObject).scene = 1;
        ZiRuMyWebViewActivity.b(ZiRuMyWebViewActivity.this).sendReq((BaseReq)localObject);
        return;
      }
      paramAnonymousView = new WXWebpageObject();
      paramAnonymousView.webpageUrl = ZiRuMyWebViewActivity.a(ZiRuMyWebViewActivity.this);
      paramAnonymousView = new WXMediaMessage(paramAnonymousView);
      paramAnonymousView.title = "自如这个活动不错。";
      paramAnonymousView.description = ZiRuMyWebViewActivity.i(ZiRuMyWebViewActivity.this);
      paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(ZiRuMyWebViewActivity.this.getResources(), 2130838626), true);
      Object localObject = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
      ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
      ZiRuMyWebViewActivity.b(ZiRuMyWebViewActivity.this).sendReq((BaseReq)localObject);
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
        if (ZiRuMyWebViewActivity.a(ZiRuMyWebViewActivity.this) != null)
        {
          ZiRuMyWebViewActivity.a(ZiRuMyWebViewActivity.this, WXAPIFactory.createWXAPI(ZiRuMyWebViewActivity.this, "wxc2bae7e8ecb7d70b", true));
          ZiRuMyWebViewActivity.b(ZiRuMyWebViewActivity.this).registerApp("wxc2bae7e8ecb7d70b");
          paramAnonymousView = LayoutInflater.from(ZiRuMyWebViewActivity.c(ZiRuMyWebViewActivity.this)).inflate(2130905131, null);
          ZiRuMyWebViewActivity.a(ZiRuMyWebViewActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697535));
          ZiRuMyWebViewActivity.b(ZiRuMyWebViewActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697536));
          ZiRuMyWebViewActivity.c(ZiRuMyWebViewActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697537));
          ZiRuMyWebViewActivity.d(ZiRuMyWebViewActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697539));
          ZiRuMyWebViewActivity.e(ZiRuMyWebViewActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697538));
          ZiRuMyWebViewActivity.d(ZiRuMyWebViewActivity.this).setOnClickListener(ZiRuMyWebViewActivity.this.a);
          ZiRuMyWebViewActivity.e(ZiRuMyWebViewActivity.this).setOnClickListener(ZiRuMyWebViewActivity.this.a);
          ZiRuMyWebViewActivity.f(ZiRuMyWebViewActivity.this).setOnClickListener(ZiRuMyWebViewActivity.this.a);
          ZiRuMyWebViewActivity.g(ZiRuMyWebViewActivity.this).setOnClickListener(ZiRuMyWebViewActivity.this.a);
          ZiRuMyWebViewActivity.h(ZiRuMyWebViewActivity.this).setOnClickListener(ZiRuMyWebViewActivity.this.a);
          Dialog localDialog = new Dialog(ZiRuMyWebViewActivity.this, 2131427824);
          localDialog.setContentView(paramAnonymousView);
          if (!(localDialog instanceof Dialog))
          {
            localDialog.show();
            return;
          }
          VdsAgent.showDialog((Dialog)localDialog);
          return;
        }
        g.textToast(ZiRuMyWebViewActivity.c(ZiRuMyWebViewActivity.this), "房源尚未加载完成", 0);
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
    String str = getIntent().getStringExtra("ziru");
    if (str.equals("ziruviewpager"))
    {
      this.u = "http://www.ziroom.com/zhuanti/pdhhuigu/";
      this.u = localIntent.getStringExtra("url");
      this.v = localIntent.getStringExtra("title");
      this.w = localIntent.getStringExtra("pic");
      this.d = ((ImageView)findViewById(2131691042));
      this.d.setVisibility(0);
      this.b = ((MoreItemView)findViewById(2131692134));
      this.b.setTitle(this.v);
      this.b.setWeb(this.u);
      this.b.setBack(new MoreItemView.b()
      {
        public void backtoActivity()
        {
          ZiRuMyWebViewActivity.this.finish();
        }
      });
    }
    do
    {
      return;
      if (str.equals("ziruNew"))
      {
        this.b = ((MoreItemView)findViewById(2131692134));
        this.d = ((ImageView)findViewById(2131691042));
        this.d.setVisibility(0);
        this.u = "http://www.ziroom.com/ziroomer/news/";
        this.b.setTitle("自如NEWS");
        this.b.setWeb(this.u);
        this.b.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuMyWebViewActivity.this.finish();
          }
        });
        return;
      }
      if (str.equals("zirujoin"))
      {
        this.b = ((MoreItemView)findViewById(2131692134));
        this.d = ((ImageView)findViewById(2131691042));
        this.d.setVisibility(8);
        this.v = "自如活动";
        if ((!"".equals(this.v)) && (this.v != null)) {
          this.v = localIntent.getStringExtra("title");
        }
        this.u = localIntent.getStringExtra("url");
        this.w = localIntent.getStringExtra("pic");
        this.b.setTitle(this.v);
        this.b.setWeb(this.u);
        this.b.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ZiRuMyWebViewActivity.this.finish();
          }
        });
        return;
      }
    } while (!str.equals("yezhu"));
    this.b = ((MoreItemView)findViewById(2131692134));
    this.d = ((ImageView)findViewById(2131691042));
    this.d.setVisibility(8);
    this.v = "长租委托";
    this.u = localIntent.getStringExtra("url");
    this.b.setTitle(this.v);
    this.b.setWeb(this.u);
    this.b.setBack(new MoreItemView.b()
    {
      public void backtoActivity()
      {
        ZiRuMyWebViewActivity.this.finish();
      }
    });
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    new Message();
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/square/ZiRuMyWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */