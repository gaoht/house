package com.ziroom.ziroomcustomer.life;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.d.a.a;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.LifeDetails;
import com.ziroom.ziroomcustomer.model.LifeDetails.Life_Body;
import com.ziroom.ziroomcustomer.model.LifeDetails.Life_Body.Body_Content;
import com.ziroom.ziroomcustomer.model.LifeDetails.Life_Campaign;
import com.ziroom.ziroomcustomer.model.LifeDetails.Life_Header;
import com.ziroom.ziroomcustomer.square.ZiRuMyWebViewActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.wxapi.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LifeDetailsActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, PlatformActionListener
{
  private String A;
  private LinearLayout B;
  private String C;
  private Handler D = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (locall.getSuccess().booleanValue())
      {
        LifeDetailsActivity.a(LifeDetailsActivity.this, (LifeDetails)locall.getObject());
        if (LifeDetailsActivity.a(LifeDetailsActivity.this) != null)
        {
          LifeDetailsActivity.b(LifeDetailsActivity.this).setVisibility(0);
          LifeDetailsActivity.c(LifeDetailsActivity.this);
        }
      }
      for (;;)
      {
        LifeDetailsActivity.this.dismissProgress();
        return;
        LifeDetailsActivity.this.showEmpty(LifeDetailsActivity.d(LifeDetailsActivity.this), locall.getMessage());
        LifeDetailsActivity.b(LifeDetailsActivity.this).setVisibility(8);
        LifeDetailsActivity.this.showToast(locall.getMessage());
        continue;
        LifeDetailsActivity.this.showToast(locall.getMessage());
        LifeDetailsActivity.this.showEmpty(LifeDetailsActivity.d(LifeDetailsActivity.this), "活动已结束");
        LifeDetailsActivity.b(LifeDetailsActivity.this).setVisibility(8);
      }
    }
  };
  private Handler E = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        g.textToast(LifeDetailsActivity.h(LifeDetailsActivity.this), "授权失败", 0);
        return;
      case 2: 
        g.textToast(LifeDetailsActivity.h(LifeDetailsActivity.this), "授权成功", 0);
        return;
      }
      g.textToast(LifeDetailsActivity.h(LifeDetailsActivity.this), "授权取消", 0);
    }
  };
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
        paramAnonymousView.setTitleUrl(LifeDetailsActivity.e(LifeDetailsActivity.this));
        paramAnonymousView.setText(LifeDetailsActivity.f(LifeDetailsActivity.this));
        paramAnonymousView.setImageUrl(LifeDetailsActivity.g(LifeDetailsActivity.this));
        localObject = ShareSDK.getPlatform(QQ.NAME);
        ((Platform)localObject).setPlatformActionListener(LifeDetailsActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697536: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如这个房子不错。");
        paramAnonymousView.setTitleUrl(LifeDetailsActivity.e(LifeDetailsActivity.this));
        paramAnonymousView.setText(LifeDetailsActivity.f(LifeDetailsActivity.this));
        paramAnonymousView.setImageUrl(LifeDetailsActivity.g(LifeDetailsActivity.this));
        paramAnonymousView.setSite("自如");
        paramAnonymousView.setSiteUrl("www.ziroom.com");
        localObject = ShareSDK.getPlatform(QZone.NAME);
        ((Platform)localObject).setPlatformActionListener(LifeDetailsActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697537: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如这个房子不错。");
        paramAnonymousView.setTitleUrl(LifeDetailsActivity.e(LifeDetailsActivity.this));
        paramAnonymousView.setText(LifeDetailsActivity.f(LifeDetailsActivity.this));
        if (!ae.isNull(LifeDetailsActivity.g(LifeDetailsActivity.this))) {
          paramAnonymousView.setImageUrl(LifeDetailsActivity.g(LifeDetailsActivity.this));
        }
        localObject = ShareSDK.getPlatform(SinaWeibo.NAME);
        ((Platform)localObject).setPlatformActionListener(LifeDetailsActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697538: 
        paramAnonymousView = new WXWebpageObject();
        paramAnonymousView.webpageUrl = LifeDetailsActivity.e(LifeDetailsActivity.this);
        paramAnonymousView = new WXMediaMessage(paramAnonymousView);
        paramAnonymousView.title = ("自如这个活动不错   " + LifeDetailsActivity.f(LifeDetailsActivity.this));
        paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(LifeDetailsActivity.this.getResources(), 2130838626), true);
        localObject = new SendMessageToWX.Req();
        ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
        ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
        ((SendMessageToWX.Req)localObject).scene = 1;
        LifeDetailsActivity.i(LifeDetailsActivity.this).sendReq((BaseReq)localObject);
        return;
      }
      paramAnonymousView = new WXWebpageObject();
      paramAnonymousView.webpageUrl = LifeDetailsActivity.e(LifeDetailsActivity.this);
      paramAnonymousView = new WXMediaMessage(paramAnonymousView);
      paramAnonymousView.title = "自如这个活动不错。";
      paramAnonymousView.description = LifeDetailsActivity.f(LifeDetailsActivity.this);
      paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(LifeDetailsActivity.this.getResources(), 2130838626), true);
      Object localObject = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
      ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
      LifeDetailsActivity.i(LifeDetailsActivity.this).sendReq((BaseReq)localObject);
    }
  };
  private Context b;
  private IWXAPI c;
  private String d;
  private String e;
  private ImageView f;
  private TextView g;
  private SimpleDraweeView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private LifeDetails v;
  private ArrayList<LifeDetails.Life_Body> w = new ArrayList();
  private LinearLayout x;
  private String y;
  private LinearLayout z;
  
  private void a()
  {
    this.B = ((LinearLayout)findViewById(2131691083));
    this.f = ((ImageView)findViewById(2131691081));
    this.g = ((TextView)findViewById(2131691082));
    this.r = ((SimpleDraweeView)findViewById(2131690361));
    ((GenericDraweeHierarchy)this.r.getHierarchy()).setPlaceholderImage(2130839297);
    this.s = ((TextView)findViewById(2131691084));
    this.t = ((TextView)findViewById(2131691086));
    this.u = ((TextView)findViewById(2131691088));
    this.x = ((LinearLayout)findViewById(2131691091));
    this.z = ((LinearLayout)findViewById(2131691089));
    this.g.setText(this.A);
  }
  
  private void b()
  {
    showProgressNoCancel("", 30000L);
    if (!checkNet(getApplicationContext()))
    {
      g.textToast(getApplicationContext(), "网络请求失败，请检查您的网络设置", 1);
      showEmpty(this.B, "请检查您的网络设置");
      return;
    }
    this.r.setBackgroundResource(2130839297);
    if ((!"".equals(this.d)) && (this.d != null))
    {
      j.getLifeDetails(this.D, this.d, this.b);
      return;
    }
    showEmpty(this.B, "活动已结束");
  }
  
  private void e()
  {
    if (this.v != null)
    {
      this.y = this.v.getActivity().getUrl();
      this.C = this.v.getHeader().getTitle();
      u.e("wodeooo", "1111" + this.y);
      this.e = this.v.getHeader().getPic();
      this.r.setController(c.frescoController(this.e));
      this.s.setText(this.v.getHeader().getTitle());
      this.t.setText(this.v.getHeader().getActivity_time());
      this.u.setText(this.v.getHeader().getActivity_address());
      this.w = ((ArrayList)this.v.getBody());
      f();
    }
  }
  
  private void f()
  {
    int i = 0;
    while (i < this.w.size())
    {
      u.e("nide", this.w.toString());
      this.A = ((LifeDetails.Life_Body)this.w.get(i)).getTitle();
      List localList = ((LifeDetails.Life_Body)this.w.get(i)).getContent();
      LinearLayout localLinearLayout = new LinearLayout(this.b);
      localLinearLayout.setOrientation(1);
      Object localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(n.dip2px(this.b, 12.0F), 0, 0, 0);
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ImageView localImageView = new ImageView(this.b);
      Object localObject2 = new LinearLayout.LayoutParams(-1, n.dip2px(this.b, 16.0F));
      localImageView.setBackgroundColor(Color.parseColor("#F5F4F9"));
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new LinearLayout(this.b);
      ((LinearLayout)localObject2).setOrientation(0);
      Object localObject3 = new LinearLayout.LayoutParams(-1, n.dip2px(this.b, 44.0F));
      ((LinearLayout.LayoutParams)localObject3).setMargins(0, 0, 0, 0);
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((LinearLayout)localObject2).setVerticalGravity(17);
      localObject3 = new ImageView(this.b);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n.dip2px(this.b, 3.0F), n.dip2px(this.b, 14.0F));
      ((ImageView)localObject3).setBackgroundColor(Color.parseColor("#FF8500"));
      ((ImageView)localObject3).setLayoutParams(localLayoutParams);
      ((LinearLayout)localObject2).addView((View)localObject3);
      localObject3 = new TextView(this.b);
      ((TextView)localObject3).setText(this.A);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(n.dip2px(this.b, 5.0F), 0, 0, 0);
      ((TextView)localObject3).setTextSize(1, 14.0F);
      ((TextView)localObject3).setTextColor(Color.parseColor("#111111"));
      ((TextView)localObject3).setLayoutParams(localLayoutParams);
      ((LinearLayout)localObject2).addView((View)localObject3);
      localLinearLayout.addView((View)localObject2);
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (localList != null)
      {
        int j = 0;
        if (j < localList.size())
        {
          u.e("nide1", localList.toString());
          localObject1 = ((LifeDetails.Life_Body.Body_Content)localList.get(j)).getType();
          localObject2 = new ImageView(this.b);
          localObject3 = new LinearLayout.LayoutParams(-1, n.dip2px(this.b, 0.5F));
          ((ImageView)localObject2).setBackgroundColor(Color.parseColor("#E6E6E6"));
          ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localLinearLayout.addView((View)localObject2);
          if ("text".equals(localObject1))
          {
            localObject1 = new TextView(this.b);
            ((TextView)localObject1).setText(((LifeDetails.Life_Body.Body_Content)localList.get(j)).getValue());
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).rightMargin = n.dip2px(this.b, 12.0F);
            ((LinearLayout.LayoutParams)localObject2).topMargin = n.dip2px(this.b, 12.0F);
            ((LinearLayout.LayoutParams)localObject2).bottomMargin = n.dip2px(this.b, 12.0F);
            ((TextView)localObject1).setTextSize(1, 14.0F);
            ((TextView)localObject1).setTextColor(Color.parseColor("#111111"));
            ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localLinearLayout.addView((View)localObject1);
          }
          for (;;)
          {
            j += 1;
            break;
            if ("image".equals(localObject1))
            {
              localObject1 = new SimpleDraweeView(this.b);
              localObject2 = new LinearLayout.LayoutParams(-1, n.dip2px(this.b, Integer.parseInt(((LifeDetails.Life_Body.Body_Content)localList.get(j)).getHeight())));
              ((LinearLayout.LayoutParams)localObject2).rightMargin = n.dip2px(this.b, 12.0F);
              ((LinearLayout.LayoutParams)localObject2).topMargin = n.dip2px(this.b, 12.0F);
              ((LinearLayout.LayoutParams)localObject2).bottomMargin = n.dip2px(this.b, 12.0F);
              ((GenericDraweeHierarchy)((SimpleDraweeView)localObject1).getHierarchy()).setPlaceholderImage(a.a.b);
              ((SimpleDraweeView)localObject1).setController(c.frescoController(((LifeDetails.Life_Body.Body_Content)localList.get(j)).getValue()));
              ((SimpleDraweeView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              localLinearLayout.addView((View)localObject1);
            }
          }
        }
      }
      this.z.addView(localImageView);
      this.z.addView(localLinearLayout);
      i += 1;
    }
  }
  
  private void g()
  {
    this.f.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LifeDetailsActivity.this.finish();
      }
    });
    this.x.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (!"".equals(LifeDetailsActivity.e(LifeDetailsActivity.this)))
        {
          paramAnonymousView = new Intent(LifeDetailsActivity.this, ZiRuMyWebViewActivity.class);
          paramAnonymousView.putExtra("ziru", "zirujoin");
          paramAnonymousView.putExtra("title", LifeDetailsActivity.f(LifeDetailsActivity.this));
          paramAnonymousView.putExtra("pic", LifeDetailsActivity.g(LifeDetailsActivity.this));
          paramAnonymousView.putExtra("url", LifeDetailsActivity.e(LifeDetailsActivity.this));
          LifeDetailsActivity.this.startActivity(paramAnonymousView);
        }
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
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    showToast("分享取消");
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    showToast("分享成功");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903245);
    this.b = this;
    MobSDK.init(this.b);
    this.d = getIntent().getStringExtra("activity_id");
    this.A = getIntent().getStringExtra("title");
    a();
    g();
    b();
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    showToast("分享失败");
    paramThrowable.printStackTrace();
    if ("SinaWeibo".equals(paramPlatform.getName()))
    {
      ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
      ShareSDK.removeCookieOnAuthorize(true);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/life/LifeDetailsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */