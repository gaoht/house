package com.ziroom.ziroomcustomer.ziroomstation.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.morepage.MoreItemView;
import com.ziroom.ziroomcustomer.morepage.MoreItemView.b;
import com.ziroom.ziroomcustomer.wxapi.a;
import java.util.HashMap;

public class ZiRuWebViewFragment
  extends BaseFragment
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
        paramAnonymousView.setTitleUrl(ZiRuWebViewFragment.b(ZiRuWebViewFragment.this));
        paramAnonymousView.setText(ZiRuWebViewFragment.d(ZiRuWebViewFragment.this));
        paramAnonymousView.setImageUrl(ZiRuWebViewFragment.e(ZiRuWebViewFragment.this) + "");
        localObject = ShareSDK.getPlatform(QQ.NAME);
        ((Platform)localObject).setPlatformActionListener(ZiRuWebViewFragment.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697536: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如这个活动不错。");
        paramAnonymousView.setTitleUrl(ZiRuWebViewFragment.b(ZiRuWebViewFragment.this));
        paramAnonymousView.setText(ZiRuWebViewFragment.d(ZiRuWebViewFragment.this));
        paramAnonymousView.setImageUrl(ZiRuWebViewFragment.e(ZiRuWebViewFragment.this) + "");
        paramAnonymousView.setSite("自如");
        paramAnonymousView.setSiteUrl("www.ziroom.com");
        localObject = ShareSDK.getPlatform(QZone.NAME);
        ((Platform)localObject).setPlatformActionListener(ZiRuWebViewFragment.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697537: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如这个房子不错。");
        paramAnonymousView.setTitleUrl(ZiRuWebViewFragment.b(ZiRuWebViewFragment.this));
        paramAnonymousView.setText("自如这个活动不错. " + ZiRuWebViewFragment.d(ZiRuWebViewFragment.this) + " @自如客 " + ZiRuWebViewFragment.b(ZiRuWebViewFragment.this));
        paramAnonymousView.setImageUrl(ZiRuWebViewFragment.e(ZiRuWebViewFragment.this) + "");
        localObject = ShareSDK.getPlatform(SinaWeibo.NAME);
        ((Platform)localObject).setPlatformActionListener(ZiRuWebViewFragment.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697538: 
        paramAnonymousView = new WXWebpageObject();
        paramAnonymousView.webpageUrl = ZiRuWebViewFragment.b(ZiRuWebViewFragment.this);
        paramAnonymousView = new WXMediaMessage(paramAnonymousView);
        paramAnonymousView.title = ("自如这个活动不错 " + ZiRuWebViewFragment.d(ZiRuWebViewFragment.this));
        paramAnonymousView.description = ZiRuWebViewFragment.d(ZiRuWebViewFragment.this);
        paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(ZiRuWebViewFragment.this.getResources(), 2130838626), true);
        localObject = new SendMessageToWX.Req();
        ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
        ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
        ((SendMessageToWX.Req)localObject).scene = 1;
        ZiRuWebViewFragment.c(ZiRuWebViewFragment.this).sendReq((BaseReq)localObject);
        return;
      }
      paramAnonymousView = new WXWebpageObject();
      paramAnonymousView.webpageUrl = ZiRuWebViewFragment.b(ZiRuWebViewFragment.this);
      paramAnonymousView = new WXMediaMessage(paramAnonymousView);
      paramAnonymousView.title = "自如这个活动不错。";
      paramAnonymousView.description = ZiRuWebViewFragment.d(ZiRuWebViewFragment.this);
      paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(ZiRuWebViewFragment.this.getResources(), 2130838626), true);
      Object localObject = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
      ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
      ZiRuWebViewFragment.c(ZiRuWebViewFragment.this).sendReq((BaseReq)localObject);
    }
  };
  private MoreItemView b;
  private Context c;
  private ImageView d;
  private IWXAPI e;
  private String f;
  private String g;
  private String h;
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.arg1)
    {
    }
    return false;
  }
  
  public void initView(View paramView)
  {
    Intent localIntent = ((Activity)this.c).getIntent();
    String str = ((Activity)this.c).getIntent().getStringExtra("ziru");
    if (str.equals("ziruApartment"))
    {
      this.f = "http://m.ziroomapartment.com/";
      this.g = "自如寓";
      this.h = localIntent.getStringExtra("pic");
      this.d = ((ImageView)paramView.findViewById(2131691042));
      this.b = ((MoreItemView)paramView.findViewById(2131692134));
      this.b.setTitle("自如寓");
      this.b.setWeb(this.f);
      this.b.setBack(new MoreItemView.b()
      {
        public void backtoActivity()
        {
          ((Activity)ZiRuWebViewFragment.a(ZiRuWebViewFragment.this)).finish();
        }
      });
    }
    do
    {
      return;
      if (str.equals("ziruke"))
      {
        this.f = "http://www.ziroom.com/zhuanti/zrzk/index.html";
        this.g = "自如客";
        this.h = localIntent.getStringExtra("pic");
        this.d = ((ImageView)paramView.findViewById(2131691042));
        this.b = ((MoreItemView)paramView.findViewById(2131692134));
        this.b.setTitle("自如客");
        this.b.setWeb(this.f);
        this.b.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ((Activity)ZiRuWebViewFragment.a(ZiRuWebViewFragment.this)).finish();
          }
        });
        return;
      }
      if (str.equals("ziruClub"))
      {
        this.f = "http://www.ziroom.com/zhuanti/pdhhuigu/";
        this.g = "自如俱乐部";
        this.h = localIntent.getStringExtra("pic");
        this.d = ((ImageView)paramView.findViewById(2131691042));
        this.b = ((MoreItemView)paramView.findViewById(2131692134));
        this.b.setTitle("自如俱乐部");
        this.b.setWeb(this.f);
        this.b.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ((Activity)ZiRuWebViewFragment.a(ZiRuWebViewFragment.this)).finish();
          }
        });
        return;
      }
      if (str.equals("ziruviewpager"))
      {
        this.f = "http://www.ziroom.com/zhuanti/pdhhuigu/";
        this.f = localIntent.getStringExtra("url");
        this.g = localIntent.getStringExtra("title");
        this.h = localIntent.getStringExtra("pic");
        this.d = ((ImageView)paramView.findViewById(2131691042));
        this.b = ((MoreItemView)paramView.findViewById(2131692134));
        this.b.setTitle(this.g);
        this.b.setWeb(this.f);
        this.b.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ((Activity)ZiRuWebViewFragment.a(ZiRuWebViewFragment.this)).finish();
          }
        });
        return;
      }
      if (str.equals("ziruNew"))
      {
        this.b = ((MoreItemView)paramView.findViewById(2131692134));
        this.f = "http://www.ziroom.com/ziroomer/news/";
        this.b.setTitle("自如NEWS");
        this.b.setWeb(this.f);
        this.b.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ((Activity)ZiRuWebViewFragment.a(ZiRuWebViewFragment.this)).finish();
          }
        });
        return;
      }
      if (str.equals("zirujoin"))
      {
        this.b = ((MoreItemView)paramView.findViewById(2131692134));
        this.b.setTitle("自如活动");
        if ((!"".equals(this.g)) && (this.g != null)) {
          this.g = localIntent.getStringExtra("title");
        }
        this.f = localIntent.getStringExtra("url");
        this.h = localIntent.getStringExtra("pic");
        this.b.setWeb(this.f);
        this.b.setBack(new MoreItemView.b()
        {
          public void backtoActivity()
          {
            ((Activity)ZiRuWebViewFragment.a(ZiRuWebViewFragment.this)).finish();
          }
        });
        return;
      }
    } while (!str.equals("howtocharge"));
    this.b = ((MoreItemView)paramView.findViewById(2131692134));
    this.b.setTitle("智能锁使用说明");
    this.f = localIntent.getStringExtra("url");
    this.d = ((ImageView)paramView.findViewById(2131691042));
    this.b.setWeb(this.f);
    this.b.setBack(new MoreItemView.b()
    {
      public void backtoActivity()
      {
        ((Activity)ZiRuWebViewFragment.a(ZiRuWebViewFragment.this)).finish();
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
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130905245, paramViewGroup, false);
    this.c = getActivity();
    MobSDK.init(this.c);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
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
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/fragment/ZiRuWebViewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */