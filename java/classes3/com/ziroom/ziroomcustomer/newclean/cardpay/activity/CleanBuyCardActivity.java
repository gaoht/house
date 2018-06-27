package com.ziroom.ziroomcustomer.newclean.cardpay.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.home.bean.HomePageBannerInfo;
import com.ziroom.ziroomcustomer.home.bean.HomePageBannerInfo.DataBean;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceWebActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.BuyCard;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CanBuyCard;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.Promotions;
import com.ziroom.ziroomcustomer.newclean.d.bc;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CleanBuyCardActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private CheckBox A;
  private TextView B;
  private Button C;
  private int D;
  private int E;
  private List<CanBuyCard> F = new ArrayList();
  private b G = new b(null);
  private int H = 0;
  private CanBuyCard I;
  private List<Promotions> J = new ArrayList();
  private c K = new c();
  private com.ziroom.commonlibrary.e.d L = new com.ziroom.commonlibrary.e.d();
  private TextView M;
  private TextView N;
  private i.a O = new i.a()
  {
    public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk)
    {
      u.d("CleanBuyCardActivity", "====" + com.ziroom.ziroomcustomer.util.k.decrypt(paramAnonymousString));
      paramAnonymousString = com.alibaba.fastjson.a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramAnonymousString));
      String str = (String)paramAnonymousString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramAnonymousString.get("data") != null) {
          paramAnonymousk.setObject(com.alibaba.fastjson.a.parseArray(paramAnonymousString.get("data").toString(), CanBuyCard.class));
        }
        paramAnonymousk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramAnonymousk.setMessage((String)paramAnonymousString.get("message"));
      paramAnonymousk.setSuccess(Boolean.valueOf(false));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
    {
      if (paramAnonymousk.getSuccess().booleanValue())
      {
        CleanBuyCardActivity.a(CleanBuyCardActivity.this, (List)paramAnonymousk.getObject());
        if ((CleanBuyCardActivity.c(CleanBuyCardActivity.this) != null) && (CleanBuyCardActivity.c(CleanBuyCardActivity.this).size() > 0))
        {
          CleanBuyCardActivity.i(CleanBuyCardActivity.this).setVisibility(0);
          CleanBuyCardActivity.j(CleanBuyCardActivity.this).setVisibility(8);
          CleanBuyCardActivity.a(CleanBuyCardActivity.this, (CanBuyCard)CleanBuyCardActivity.c(CleanBuyCardActivity.this).get(0));
        }
        CleanBuyCardActivity.d(CleanBuyCardActivity.this).notifyDataSetChanged();
        CleanBuyCardActivity.e(CleanBuyCardActivity.this);
        return;
      }
      CleanBuyCardActivity.i(CleanBuyCardActivity.this).setVisibility(8);
      CleanBuyCardActivity.j(CleanBuyCardActivity.this).setVisibility(0);
      g.textToast(CleanBuyCardActivity.this, paramAnonymousk.getMessage());
    }
  };
  private com.freelxl.baselibrary.d.c.a P = new com.freelxl.baselibrary.d.c.a(new com.freelxl.baselibrary.d.f.d(HomePageBannerInfo.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable) {}
    
    public void onSuccess(int paramAnonymousInt, HomePageBannerInfo paramAnonymousHomePageBannerInfo)
    {
      if ((paramAnonymousInt == 200) && (paramAnonymousHomePageBannerInfo != null) && (paramAnonymousHomePageBannerInfo.getData() != null) && (paramAnonymousHomePageBannerInfo.getData().size() > 0))
      {
        CleanBuyCardActivity.a(CleanBuyCardActivity.this, paramAnonymousHomePageBannerInfo);
        CleanBuyCardActivity.k(CleanBuyCardActivity.this).clear();
        paramAnonymousInt = 0;
        while (paramAnonymousInt < paramAnonymousHomePageBannerInfo.getData().size())
        {
          CleanBuyCardActivity.k(CleanBuyCardActivity.this).add(((HomePageBannerInfo.DataBean)paramAnonymousHomePageBannerInfo.getData().get(paramAnonymousInt)).getPic());
          paramAnonymousInt += 1;
        }
        CleanBuyCardActivity.m(CleanBuyCardActivity.this).setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
        {
          public CleanBuyCardActivity.a createHolder()
          {
            return new CleanBuyCardActivity.a(CleanBuyCardActivity.this, null);
          }
        }, CleanBuyCardActivity.k(CleanBuyCardActivity.this)).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
        {
          public void onItemClick(int paramAnonymous2Int)
          {
            if ((CleanBuyCardActivity.l(CleanBuyCardActivity.this) != null) && (CleanBuyCardActivity.l(CleanBuyCardActivity.this).getData().size() > paramAnonymous2Int))
            {
              w.onEvent("giftcard_banner1");
              Intent localIntent = new Intent(CleanBuyCardActivity.this, HomeWebActivity.class);
              localIntent.putExtra("url", ((HomePageBannerInfo.DataBean)CleanBuyCardActivity.l(CleanBuyCardActivity.this).getData().get(paramAnonymous2Int)).getUrl());
              localIntent.putExtra("title", ((HomePageBannerInfo.DataBean)CleanBuyCardActivity.l(CleanBuyCardActivity.this).getData().get(paramAnonymous2Int)).getTitle());
              localIntent.putExtra("pic", ((HomePageBannerInfo.DataBean)CleanBuyCardActivity.l(CleanBuyCardActivity.this).getData().get(paramAnonymous2Int)).getPic());
              localIntent.putExtra("ziru", "homeService");
              CleanBuyCardActivity.this.startActivity(localIntent);
            }
          }
        }).setPointViewVisible(true);
        if ((CleanBuyCardActivity.k(CleanBuyCardActivity.this) != null) && (CleanBuyCardActivity.k(CleanBuyCardActivity.this).size() > 1)) {
          CleanBuyCardActivity.m(CleanBuyCardActivity.this).startTurning(5000L);
        }
      }
      else
      {
        return;
      }
      CleanBuyCardActivity.m(CleanBuyCardActivity.this).stopTurning();
    }
  };
  private BroadcastReceiver Q = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent != null) && (paramAnonymousIntent.getIntExtra("code", -1) == 1))
      {
        paramAnonymousContext = new Intent();
        paramAnonymousContext.setAction("refresh_card");
        ApplicationEx.c.sendBroadcast(paramAnonymousContext);
        CleanBuyCardActivity.this.finish();
      }
      while ((paramAnonymousIntent == null) || (paramAnonymousIntent.getStringExtra("message") == null)) {
        return;
      }
      g.textToast(CleanBuyCardActivity.this, paramAnonymousIntent.getStringExtra("message"));
    }
  };
  private final String a = "CleanBuyCardActivity";
  private String b = "";
  private LinearLayout c;
  private RelativeLayout d;
  private String e = "";
  private UserInfo f;
  private List<String> g = new ArrayList();
  private HomePageBannerInfo r;
  private ImageView s;
  private ConvenientBanner t;
  private MyGridView u;
  private LinearLayout v;
  private TextView w;
  private TextView x;
  private ListView y;
  private EditText z;
  
  private void a()
  {
    this.L.initWXAPI(this);
    registerReceiver(this.Q, new IntentFilter("com.ziroom.ziroomcustomer.payresult"));
    this.f = ApplicationEx.c.getUser();
    this.y.setAdapter(this.K);
    setCouponListViewHeight();
    this.G = new b(null);
    this.u.setAdapter(this.G);
    n.getServiceBanner(this, 3603, "110000", this.P);
    n.getCanBuyCleanCard(this, this.O, false);
  }
  
  private void a(SpannableString paramSpannableString, String paramString, int paramInt)
  {
    paramSpannableString.setSpan(new ClickableSpan()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        u.e("sdjgdk", "===== zhixingle  111");
        Intent localIntent = new Intent(CleanBuyCardActivity.this, ServiceWebActivity.class);
        localIntent.putExtra("title_name", "自如保洁卡会员协议");
        localIntent.putExtra("url", "http://www.ziroom.com/zhuanti/2016/czkxy/index.html");
        CleanBuyCardActivity.this.startActivity(localIntent);
        CleanBuyCardActivity.a(CleanBuyCardActivity.this, paramAnonymousView);
      }
      
      public void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        super.updateDrawState(paramAnonymousTextPaint);
        paramAnonymousTextPaint.setColor(-15822871);
        paramAnonymousTextPaint.setUnderlineText(false);
      }
    }, paramInt, paramString.length() + paramInt, 0);
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof TextView)) {
      ((TextView)paramView).setHighlightColor(getResources().getColor(17170445));
    }
  }
  
  private void b()
  {
    w.onEvent("giftcard_uv");
    Object localObject = findViewById(2131689541);
    ((View)localObject).setFocusable(true);
    ((View)localObject).setFocusableInTouchMode(true);
    ((View)localObject).requestFocus();
    ((View)localObject).requestFocusFromTouch();
    this.D = getResources().getColor(2131624516);
    this.E = getResources().getColor(2131624583);
    this.s = ((ImageView)findViewById(2131689492));
    this.t = ((ConvenientBanner)findViewById(2131690205));
    this.u = ((MyGridView)findViewById(2131690207));
    this.v = ((LinearLayout)findViewById(2131690208));
    this.w = ((TextView)findViewById(2131690210));
    this.x = ((TextView)findViewById(2131690211));
    this.y = ((ListView)findViewById(2131690212));
    this.z = ((EditText)findViewById(2131690213));
    this.A = ((CheckBox)findViewById(2131690215));
    this.B = ((TextView)findViewById(2131690216));
    this.C = ((Button)findViewById(2131689816));
    this.c = ((LinearLayout)findViewById(2131690206));
    this.d = ((RelativeLayout)findViewById(2131690202));
    this.M = ((TextView)findViewById(2131690217));
    this.N = ((TextView)findViewById(2131690214));
    this.s.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.A.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
        if ((CleanBuyCardActivity.a(CleanBuyCardActivity.this) != null) && (paramAnonymousBoolean))
        {
          CleanBuyCardActivity.b(CleanBuyCardActivity.this).setEnabled(true);
          return;
        }
        CleanBuyCardActivity.b(CleanBuyCardActivity.this).setEnabled(false);
      }
    });
    this.z.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        w.onEvent("giftcard_recommend");
      }
    });
    int i = getWindowManager().getDefaultDisplay().getWidth() * 1 / 3;
    localObject = this.t.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.t.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(int paramInt)
  {
    SpannableString localSpannableString = new SpannableString("点击支付表示您同意《自如保洁卡会员协议》，知悉自如保洁卡自购买日起" + paramInt + "个月内有效");
    a(localSpannableString, "《自如保洁卡会员协议》", 9);
    this.N.setText(localSpannableString);
    this.N.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void e()
  {
    if (this.I == null)
    {
      g.textToast(getApplicationContext(), "请先选择一个自如保洁卡");
      return;
    }
    String str = VdsAgent.trackEditTextSilent(this.z).toString();
    if ((!TextUtils.isEmpty(str)) && (!Pattern.compile("^[a-z0-9A-Z]{1,11}$").matcher(str).matches()))
    {
      g.textToast(getApplicationContext(), "请填写正确的推荐码");
      return;
    }
    this.f = ApplicationEx.c.getUser();
    if (this.f != null)
    {
      n.buyCleanCard(this, this.I.getCid(), this.f.getUid(), this.f.getPhone(), this.f.getRealName(), str, new d(), true);
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  private void f()
  {
    if (this.y.getVisibility() == 8)
    {
      this.y.setVisibility(0);
      this.x.setText("点击收起");
      localDrawable = ContextCompat.getDrawable(this, 2130838596);
      localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
      this.x.setCompoundDrawables(null, null, localDrawable, null);
      return;
    }
    this.y.setVisibility(8);
    this.x.setText("点击展开");
    Drawable localDrawable = ContextCompat.getDrawable(this, 2130838595);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.x.setCompoundDrawables(null, null, localDrawable, null);
  }
  
  private void g()
  {
    if (this.I == null) {
      return;
    }
    this.J = this.I.getTypePromotions();
    if (this.J.size() > 0) {
      if ((this.I.getPromotionCodeCount() != null) && (this.I.getPromotionCodeCount().longValue() > 0L))
      {
        long l = this.I.getPromotionCodeCount().longValue();
        this.w.setText("（价值" + l / 100L + "元）");
        this.v.setVisibility(0);
        this.K.notifyDataSetChanged();
        setCouponListViewHeight();
      }
    }
    for (;;)
    {
      b(this.I.getValidMonth());
      return;
      this.w.setText("");
      break;
      this.v.setVisibility(8);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.ziroom.ziroomcustomer.payment.a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("result", false))) {
      finish();
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131689816: 
      e();
      return;
    case 2131690208: 
      f();
      return;
    }
    paramView = new Intent(this, ServiceWebActivity.class);
    paramView.putExtra("title_name", "自如保洁卡会员协议");
    paramView.putExtra("url", "http://www.ziroom.com/zhuanti/2016/czkxy/index.html");
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903137);
    b();
    a();
  }
  
  public void setCouponListViewHeight()
  {
    if (this.K == null) {
      return;
    }
    int i = (int)(getResources().getDisplayMetrics().density * 26.0F);
    ViewGroup.LayoutParams localLayoutParams = this.y.getLayoutParams();
    localLayoutParams.height = (i * this.K.getCount());
    this.y.setLayoutParams(localLayoutParams);
  }
  
  private class a
    implements com.ziroom.commonlibrary.widget.convenientbanner.b.b<String>
  {
    private SimpleDraweeView b;
    
    private a() {}
    
    public void UpdateUI(Context paramContext, int paramInt, String paramString)
    {
      this.b.setController(c.frescoController(paramString));
    }
    
    public View createView(Context paramContext)
    {
      this.b = new SimpleDraweeView(paramContext);
      ((GenericDraweeHierarchy)this.b.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
      return this.b;
    }
  }
  
  private class b
    extends BaseAdapter
  {
    private b() {}
    
    public int getCount()
    {
      return CleanBuyCardActivity.c(CleanBuyCardActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return CleanBuyCardActivity.c(CleanBuyCardActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      CanBuyCard localCanBuyCard;
      if (paramView == null)
      {
        paramView = CleanBuyCardActivity.this.getLayoutInflater().inflate(2130904156, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131689912));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131694912));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131694913));
        paramView.setTag(paramViewGroup);
        localCanBuyCard = (CanBuyCard)CleanBuyCardActivity.c(CleanBuyCardActivity.this).get(paramInt);
        if (!TextUtils.isEmpty(localCanBuyCard.getRechargeAmount())) {
          paramViewGroup.a.setText(Long.parseLong(localCanBuyCard.getRechargeAmount()) / 100L + "元");
        }
        if (localCanBuyCard.getGiftCount() != null) {
          break label246;
        }
        paramViewGroup.b.setVisibility(8);
        label155:
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            CleanBuyCardActivity.a(CleanBuyCardActivity.this, paramInt);
            CleanBuyCardActivity.a(CleanBuyCardActivity.this, (CanBuyCard)CleanBuyCardActivity.c(CleanBuyCardActivity.this).get(paramInt));
            CleanBuyCardActivity.d(CleanBuyCardActivity.this).notifyDataSetChanged();
            CleanBuyCardActivity.e(CleanBuyCardActivity.this);
          }
        });
        if (CleanBuyCardActivity.f(CleanBuyCardActivity.this) != paramInt) {
          break label324;
        }
        paramView.setBackgroundResource(2130837733);
        paramViewGroup.a.setTextColor(CleanBuyCardActivity.g(CleanBuyCardActivity.this));
        paramViewGroup.b.setTextColor(CleanBuyCardActivity.g(CleanBuyCardActivity.this));
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localCanBuyCard.getLabel())) {
          break label361;
        }
        paramViewGroup.c.setVisibility(8);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label246:
        if (localCanBuyCard.getGiftCount().longValue() > 0L)
        {
          paramViewGroup.b.setVisibility(0);
          paramViewGroup.b.setText("赠送" + localCanBuyCard.getGiftCount().longValue() / 100L + "元");
          break label155;
        }
        paramViewGroup.b.setVisibility(8);
        break label155;
        label324:
        paramView.setBackgroundResource(2130837727);
        paramViewGroup.a.setTextColor(CleanBuyCardActivity.h(CleanBuyCardActivity.this));
        paramViewGroup.b.setTextColor(CleanBuyCardActivity.h(CleanBuyCardActivity.this));
      }
      label361:
      paramViewGroup.c.setVisibility(0);
      if (CleanBuyCardActivity.f(CleanBuyCardActivity.this) == paramInt)
      {
        paramViewGroup.c.setBackgroundResource(2130838594);
        paramViewGroup.c.setTextColor(CleanBuyCardActivity.h(CleanBuyCardActivity.this));
      }
      for (;;)
      {
        paramViewGroup.c.setText(localCanBuyCard.getLabel());
        return paramView;
        paramView.setBackgroundResource(2130837727);
        paramViewGroup.c.setBackgroundResource(2130838593);
        paramViewGroup.c.setTextColor(CleanBuyCardActivity.g(CleanBuyCardActivity.this));
      }
    }
    
    public class a
    {
      public TextView a;
      public TextView b;
      public TextView c;
      
      public a() {}
    }
  }
  
  public class c
    extends BaseAdapter
  {
    public c() {}
    
    public int getCount()
    {
      if ((CleanBuyCardActivity.a(CleanBuyCardActivity.this) == null) || (CleanBuyCardActivity.a(CleanBuyCardActivity.this).getTypePromotions() == null) || (CleanBuyCardActivity.a(CleanBuyCardActivity.this).getTypePromotions().size() <= 0)) {
        return 0;
      }
      return CleanBuyCardActivity.a(CleanBuyCardActivity.this).getTypePromotions().size();
    }
    
    public Object getItem(int paramInt)
    {
      return CleanBuyCardActivity.a(CleanBuyCardActivity.this).getTypePromotions().get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(CleanBuyCardActivity.this, 2130904154, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131690003));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Promotions localPromotions = (Promotions)((CanBuyCard)CleanBuyCardActivity.c(CleanBuyCardActivity.this).get(CleanBuyCardActivity.f(CleanBuyCardActivity.this))).getTypePromotions().get(paramInt);
        paramViewGroup.a.setText(localPromotions.getPromotionTypeName());
        paramViewGroup.b.setText("x" + localPromotions.getSendCount());
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    public class a
    {
      public TextView a;
      public TextView b;
      
      public a() {}
    }
  }
  
  class d
    implements i.a<String>
  {
    d() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      u.d("CleanBuyCardActivity", "====" + com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = com.alibaba.fastjson.a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject((BuyCard)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), BuyCard.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (BuyCard)paramk.getObject();
        if ((CleanBuyCardActivity.n(CleanBuyCardActivity.this) != null) && (paramk != null))
        {
          l = Long.parseLong(paramk.getPayAmount());
          n.requestServicePayment(CleanBuyCardActivity.this, CleanBuyCardActivity.n(CleanBuyCardActivity.this).getUid(), paramk.getOrderNumber(), 1, 3, l, null, null, new com.ziroom.ziroomcustomer.e.a.d(CleanBuyCardActivity.this, new f(bc.class))
          {
            public void onSuccess(int paramAnonymousInt, bc paramAnonymousbc)
            {
              super.onSuccess(paramAnonymousInt, paramAnonymousbc);
              com.ziroom.ziroomcustomer.payment.a.startPayActivty(CleanBuyCardActivity.this, paramAnonymousbc.getAmount(), "baojiepay", paramAnonymousbc.getOrderIds(), paramAnonymousbc.getSystemId(), paramAnonymousbc.getTimeInterval().toString());
            }
          });
        }
      }
      while (TextUtils.isEmpty(paramk.getMessage()))
      {
        long l;
        return;
      }
      g.textToast(CleanBuyCardActivity.this, paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/activity/CleanBuyCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */