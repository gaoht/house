package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.b;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.GoodsDetailAc;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGoodsListActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGuidanceActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGuidanceH5Activity;
import com.ziroom.ziroomcustomer.e.c.c;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.newclean.mvp.CleanHomeActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MoveTypeActivity;
import com.ziroom.ziroomcustomer.newrepair.mvp.RepairHomeActivity;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyCouponActivity
  extends BaseActivity
{
  private final String A = SignKeyUtil.getKeyFromC();
  private final String B = SignKeyUtil.getIvKeyFromC();
  private boolean C;
  private int D;
  private final int E = 5;
  private b F;
  private b G;
  private b H;
  private b I;
  private b J;
  private b K;
  private b L;
  private a M;
  private Unbinder N;
  private com.ziroom.ziroomcustomer.e.a.e<b> O = new com.ziroom.ziroomcustomer.e.a.e(this, new c())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      MyCouponActivity.c(MyCouponActivity.this);
      MyCouponActivity.d(MyCouponActivity.this);
    }
    
    public void onSuccess(int paramAnonymousInt, b paramAnonymousb)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousb);
      if ((paramAnonymousb != null) && (paramAnonymousb.size() > 0))
      {
        MyCouponActivity.a(MyCouponActivity.this, new b());
        Iterator localIterator = paramAnonymousb.iterator();
        if (localIterator.hasNext())
        {
          com.alibaba.fastjson.e locale1 = (com.alibaba.fastjson.e)localIterator.next();
          com.alibaba.fastjson.e locale2 = new com.alibaba.fastjson.e();
          locale2.put("cardName", locale1.getString("name"));
          locale2.put("startDate", locale1.getString("start_time"));
          locale2.put("endDate", locale1.getString("end_time"));
          if (locale1.containsKey("money"))
          {
            paramAnonymousb = "¥";
            label124:
            locale2.put("unit", paramAnonymousb);
            if (!locale1.containsKey("show_money")) {
              break label262;
            }
            paramAnonymousb = locale1.getString("show_money");
            label151:
            locale2.put("price", paramAnonymousb);
            locale2.put("description", locale1.getString("desc"));
            if ((!locale1.containsKey("type")) || (!"10".equals(locale1.getString("type")))) {
              break label268;
            }
            locale2.put("businessLineType", "coupon_three");
          }
          for (;;)
          {
            locale2.put("code", locale1.getString("code"));
            locale2.put("rule", locale1.getString("rule"));
            MyCouponActivity.b(MyCouponActivity.this).add(locale2);
            break;
            paramAnonymousb = "";
            break label124;
            label262:
            paramAnonymousb = "";
            break label151;
            label268:
            locale2.put("businessLineType", "coupon");
          }
        }
      }
      MyCouponActivity.c(MyCouponActivity.this);
      MyCouponActivity.d(MyCouponActivity.this);
    }
  };
  private com.ziroom.ziroomcustomer.e.a.e<com.alibaba.fastjson.e> P = new com.ziroom.ziroomcustomer.e.a.e(this, new com.ziroom.ziroomcustomer.e.c.d())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      MyCouponActivity.c(MyCouponActivity.this);
      MyCouponActivity.d(MyCouponActivity.this);
    }
    
    public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if (paramAnonymouse != null)
      {
        paramAnonymouse = paramAnonymouse.getJSONArray("list");
        MyCouponActivity.b(MyCouponActivity.this, paramAnonymouse);
      }
      MyCouponActivity.c(MyCouponActivity.this);
      MyCouponActivity.d(MyCouponActivity.this);
    }
  };
  com.freelxl.baselibrary.f.a.a a = new com.freelxl.baselibrary.f.a.a();
  private final String b = "MyCouponActivity";
  private final String c = "ms";
  private final String d = "service_move";
  private final String e = "service_clean";
  private final String f = "service_repair";
  private final String g = "yi";
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  @BindColor(2131624393)
  int mColorGray99;
  @BindView(2131691788)
  FrameLayout mFlEmpty;
  @BindView(2131689817)
  ListView mLv;
  @BindDimen(2131231179)
  int mSize16;
  @BindDimen(2131231180)
  int mSize1_5;
  @BindDimen(2131231181)
  int mSize24;
  @BindDimen(2131231183)
  int mSize9_5;
  @BindDimen(2131231242)
  int mSizeText12;
  @BindDimen(2131231178)
  int mSizeText14_5;
  @BindView(2131691829)
  TextView mTvEmpty;
  @BindView(2131691830)
  TextView mTvGotoExpired;
  private final String r = "service_youpin";
  private final String s = "coupon";
  private final String t = "coupon_three";
  private final String u = "vpRZ1kmU";
  private final String v = "EbpU4WtY";
  private final String w = "ZiRuHore";
  private final String x = "vpRZ1kmU";
  private final String y = "ZiR00mYi";
  private final String z = "vpRZ1kmU";
  
  private void a()
  {
    this.C = getIntent().getBooleanExtra("isExpired", false);
    if (!this.C)
    {
      this.mBztb.setTitle(getString(2131297240));
      this.mTvEmpty.setText(getString(2131297235));
      this.mTvGotoExpired.setVisibility(0);
      this.mTvGotoExpired.getPaint().setFlags(8);
      this.mTvGotoExpired.getPaint().setAntiAlias(true);
      TextView localTextView = new TextView(this);
      localTextView.setText(getString(2131297239));
      localTextView.setTextColor(this.mColorGray99);
      localTextView.setTextSize(0, this.mSizeText12);
      localTextView.setGravity(17);
      localTextView.setLines(1);
      localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      localTextView.setPadding(0, this.mSize16, 0, this.mSize1_5);
      this.mLv.addHeaderView(localTextView);
      localTextView = new TextView(this);
      localTextView.setText(getString(2131297238));
      localTextView.setTextColor(this.mColorGray99);
      localTextView.setTextSize(0, this.mSizeText12);
      localTextView.setGravity(17);
      localTextView.getPaint().setFlags(8);
      localTextView.getPaint().setAntiAlias(true);
      localTextView.setLines(1);
      localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      localTextView.setPadding(this.mSize16, this.mSize9_5, this.mSize16, this.mSize24);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(MyCouponActivity.this, MyCouponActivity.class);
          paramAnonymousView.putExtra("isExpired", true);
          MyCouponActivity.this.startActivity(paramAnonymousView);
        }
      });
      this.mLv.addFooterView(localTextView);
      return;
    }
    this.mBztb.setTitle(getString(2131297237));
    this.mTvEmpty.setText(getString(2131297236));
    this.mTvGotoExpired.setVisibility(8);
    this.mLv.setPadding(this.mSizeText14_5, this.mSizeText14_5, this.mSizeText14_5, this.mSizeText14_5);
  }
  
  private void b()
  {
    String str = com.ziroom.commonlibrary.login.a.getUid(this);
    HashMap localHashMap = new HashMap();
    Object localObject2 = new com.alibaba.fastjson.e();
    ((com.alibaba.fastjson.e)localObject2).put("serviceTypeId", "");
    ((com.alibaba.fastjson.e)localObject2).put("uid", str);
    if (this.C)
    {
      localObject1 = "2";
      ((com.alibaba.fastjson.e)localObject2).put("status", localObject1);
      localHashMap.put("2y5QfvAy", this.a.encrypt(((com.alibaba.fastjson.e)localObject2).toJSONString(), "EbpU4WtY", "vpRZ1kmU"));
      localHashMap.put("hPtJ39Xs", h.toMd5(((com.alibaba.fastjson.e)localObject2).toJSONString().getBytes()));
      localObject2 = new HashMap();
      Object localObject3 = new com.alibaba.fastjson.e();
      ((com.alibaba.fastjson.e)localObject3).put("uid", str);
      if (!this.C) {
        break label694;
      }
      localObject1 = "2";
      label151:
      ((com.alibaba.fastjson.e)localObject3).put("status", localObject1);
      ((Map)localObject2).put("p", this.a.encrypt(((com.alibaba.fastjson.e)localObject3).toJSONString(), "vpRZ1kmU", "ZiRuHore"));
      ((Map)localObject2).put("sign", h.toMd5(((com.alibaba.fastjson.e)localObject3).toJSONString().getBytes()));
      localObject3 = new HashMap();
      Object localObject4 = new com.alibaba.fastjson.e();
      ((com.alibaba.fastjson.e)localObject4).put("uid", str);
      if (!this.C) {
        break label701;
      }
      localObject1 = "2";
      label249:
      ((com.alibaba.fastjson.e)localObject4).put("status", localObject1);
      ((Map)localObject3).put("p", this.a.encrypt(((com.alibaba.fastjson.e)localObject4).toJSONString(), "vpRZ1kmU", "ZiR00mYi"));
      ((Map)localObject3).put("sign", h.toMd5(((com.alibaba.fastjson.e)localObject4).toJSONString().getBytes()));
      localObject4 = new HashMap();
      com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
      locale.put("uid", str);
      if (!this.C) {
        break label708;
      }
      localObject1 = "2";
      label347:
      locale.put("status", localObject1);
      ((Map)localObject4).put("2y5QfvAy", this.a.encrypt(locale.toJSONString(), this.B, this.A));
      ((Map)localObject4).put("hPtJ39Xs", h.toMd5(locale.toJSONString().getBytes()));
      localObject1 = new HashMap();
      ((Map)localObject1).put("client-version", h.getVersion(getApplicationContext()));
      ((Map)localObject1).put("client-type", Integer.valueOf(1));
      ((Map)localObject1).put("user-agent", Build.MANUFACTURER + "#" + Build.MODEL + "#" + h.getDeviceId(getApplicationContext()));
      ((Map)localObject1).put("token", com.ziroom.commonlibrary.login.a.getToken(this));
      ((Map)localObject1).put("uid", str);
      com.freelxl.baselibrary.f.d.d("MyCouponActivity", "=====ms:" + localObject4);
      showProgress("");
      j.getCouponList(this, new b("service_move"), null, localHashMap, false, "service_move_cleaning");
      j.getCouponList(this, new b("service_repair"), null, (Map)localObject2, false, "service_repair");
      j.getCouponList(this, new b("yi"), null, (Map)localObject3, false, "yi");
      j.getCouponList(this, new b("ms"), (Map)localObject1, (Map)localObject4, false, "ms");
      if (!this.C) {
        break label715;
      }
      localObject1 = "1";
      label653:
      j.getRentCardList(this, str, "1", (String)localObject1, this.O);
      if (!this.C) {
        break label722;
      }
    }
    label694:
    label701:
    label708:
    label715:
    label722:
    for (Object localObject1 = "2";; localObject1 = "1")
    {
      j.getCouponListYp(this, (String)localObject1, this.P);
      return;
      localObject1 = "1";
      break;
      localObject1 = "1";
      break label151;
      localObject1 = "1";
      break label249;
      localObject1 = "1";
      break label347;
      localObject1 = "0";
      break label653;
    }
  }
  
  private void e()
  {
    if (this.D >= 5)
    {
      dismissProgress();
      this.L = new b();
      if (this.K != null) {
        this.L.addAll(this.K);
      }
      if (this.F != null) {
        this.L.addAll(this.F);
      }
      if (this.G != null) {
        this.L.addAll(this.G);
      }
      if (this.J != null) {
        this.L.addAll(this.J);
      }
      if (this.H != null) {
        this.L.addAll(this.H);
      }
      if (this.I != null) {
        this.L.addAll(this.I);
      }
      this.M = new a(this, this.L);
      if (this.mLv != null)
      {
        this.mLv.setAdapter(this.M);
        this.mLv.setEmptyView(this.mFlEmpty);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903367);
    this.N = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.N.unbind();
    super.onDestroy();
  }
  
  @OnClick({2131691830})
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent(this, MyCouponActivity.class);
    paramView.putExtra("isExpired", true);
    startActivity(paramView);
  }
  
  static class ViewHolder
  {
    @BindView(2131691574)
    ImageView mIv;
    @BindView(2131691571)
    TextView mTvInfo;
    @BindView(2131690049)
    TextView mTvName;
    @BindView(2131690003)
    TextView mTvNum;
    @BindView(2131695382)
    TextView mTvSkip;
    @BindView(2131694578)
    TextView mTvSubTitle;
    @BindView(2131689852)
    TextView mTvTime;
    @BindView(2131689541)
    TextView mTvTitle;
    @BindView(2131689840)
    TextView mTvUnit;
    
    public ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  private class a
    extends BaseAdapter
  {
    private Context b;
    private b c;
    private int d;
    
    public a(Context paramContext, b paramb)
    {
      this.b = paramContext;
      this.c = paramb;
      if (MyCouponActivity.a(MyCouponActivity.this))
      {
        this.d = 2130904382;
        return;
      }
      this.d = 2130904381;
    }
    
    public int getCount()
    {
      if (this.c == null) {
        return 0;
      }
      return this.c.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.c.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      label34:
      final com.alibaba.fastjson.e locale;
      if (paramView != null)
      {
        localObject1 = (MyCouponActivity.ViewHolder)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject1;
        if (!MyCouponActivity.a(MyCouponActivity.this)) {
          break label434;
        }
        paramViewGroup.setBackgroundResource(2130837741);
        locale = this.c.getJSONObject(paramInt);
        if (locale != null)
        {
          Object localObject2 = paramView.mTvName;
          if (!locale.containsKey("cardName")) {
            break label443;
          }
          localObject1 = locale.getString("cardName");
          label74:
          ((TextView)localObject2).setText((CharSequence)localObject1);
          localObject1 = new StringBuffer();
          if (locale.containsKey("startDate")) {
            ((StringBuffer)localObject1).append(locale.getString("startDate"));
          }
          ((StringBuffer)localObject1).append(" 至 ");
          if (locale.containsKey("endDate")) {
            ((StringBuffer)localObject1).append(locale.getString("endDate"));
          }
          if (locale.containsKey("unit"))
          {
            localObject2 = locale.getString("unit");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              paramView.mTvUnit.setText((CharSequence)localObject2);
            }
          }
          paramView.mTvTime.setText(((StringBuffer)localObject1).toString());
          localObject2 = paramView.mTvNum;
          if (!locale.containsKey("price")) {
            break label450;
          }
          localObject1 = locale.getString("price");
          label217:
          ((TextView)localObject2).setText((CharSequence)localObject1);
          if ((!locale.containsKey("description")) || (TextUtils.isEmpty(locale.getString("description")))) {
            break label457;
          }
          paramView.mTvTitle.setText(locale.getString("description"));
          paramView.mTvTitle.setVisibility(0);
          label269:
          if ((!locale.containsKey("subDescription")) || (TextUtils.isEmpty(locale.getString("subDescription")))) {
            break label469;
          }
          paramView.mTvSubTitle.setText(locale.getString("subDescription"));
          paramView.mTvSubTitle.setVisibility(0);
          label314:
          paramView.mTvSkip.setVisibility(8);
          paramViewGroup.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
            }
          });
          if (!locale.containsKey("businessLineType")) {
            break label1034;
          }
          localObject1 = locale.getString("businessLineType");
          if (!"ms".equals(localObject1)) {
            break label481;
          }
          paramView.mTvInfo.setVisibility(8);
          paramView.mIv.setImageResource(2130838605);
          if (!MyCouponActivity.a(MyCouponActivity.this)) {
            paramViewGroup.setBackgroundResource(2130839035);
          }
        }
      }
      label434:
      label443:
      label450:
      label457:
      label469:
      label481:
      label565:
      label649:
      label733:
      do
      {
        do
        {
          do
          {
            do
            {
              return paramViewGroup;
              paramViewGroup = LayoutInflater.from(this.b).inflate(this.d, paramViewGroup, false);
              paramView = new MyCouponActivity.ViewHolder(paramViewGroup);
              paramViewGroup.setTag(paramView);
              break;
              paramViewGroup.setBackgroundResource(2130837740);
              break label34;
              localObject1 = "";
              break label74;
              localObject1 = "";
              break label217;
              paramView.mTvTitle.setVisibility(8);
              break label269;
              paramView.mTvSubTitle.setVisibility(8);
              break label314;
              if (!"service_clean".equals(localObject1)) {
                break label565;
              }
              paramView.mTvInfo.setVisibility(8);
              paramView.mIv.setVisibility(8);
              paramView.mIv.setImageResource(2130838606);
            } while (MyCouponActivity.a(MyCouponActivity.this));
            paramView.mTvSkip.setVisibility(0);
            paramView.mTvSkip.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                MyCouponActivity.this.startActivity(new Intent(MyCouponActivity.a.a(MyCouponActivity.a.this), CleanHomeActivity.class));
              }
            });
            paramViewGroup.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                MyCouponActivity.this.startActivity(new Intent(MyCouponActivity.a.a(MyCouponActivity.a.this), CleanHomeActivity.class));
              }
            });
            return paramViewGroup;
            if (!"service_move".equals(localObject1)) {
              break label649;
            }
            paramView.mTvInfo.setVisibility(8);
            paramView.mIv.setVisibility(8);
            paramView.mIv.setImageResource(2130838607);
          } while (MyCouponActivity.a(MyCouponActivity.this));
          paramView.mTvSkip.setVisibility(0);
          paramView.mTvSkip.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              MyCouponActivity.this.startActivity(new Intent(MyCouponActivity.a.a(MyCouponActivity.a.this), MoveTypeActivity.class));
            }
          });
          paramViewGroup.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              MyCouponActivity.this.startActivity(new Intent(MyCouponActivity.a.a(MyCouponActivity.a.this), MoveTypeActivity.class));
            }
          });
          return paramViewGroup;
          if (!"service_repair".equals(localObject1)) {
            break label733;
          }
          paramView.mTvInfo.setVisibility(8);
          paramView.mIv.setVisibility(8);
          paramView.mIv.setImageResource(2130838608);
        } while (MyCouponActivity.a(MyCouponActivity.this));
        paramView.mTvSkip.setVisibility(0);
        paramView.mTvSkip.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            MyCouponActivity.this.startActivity(new Intent(MyCouponActivity.a.a(MyCouponActivity.a.this), RepairHomeActivity.class));
          }
        });
        paramViewGroup.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            MyCouponActivity.this.startActivity(new Intent(MyCouponActivity.a.a(MyCouponActivity.a.this), RepairHomeActivity.class));
          }
        });
        return paramViewGroup;
        if ("yi".equals(localObject1))
        {
          paramView.mTvInfo.setVisibility(8);
          paramView.mIv.setImageResource(2130838609);
          return paramViewGroup;
        }
        if (!"coupon_three".equals(localObject1)) {
          break label833;
        }
        paramView.mTvInfo.setVisibility(0);
        paramView.mTvInfo.setText("查看详情");
        paramView.mTvInfo.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            new CouponInfoPop(MyCouponActivity.this).show(paramAnonymousView, locale.getString("code"), locale.getString("rule"));
          }
        });
        paramView.mIv.setImageBitmap(null);
      } while (MyCouponActivity.a(MyCouponActivity.this));
      paramViewGroup.setBackgroundResource(2130839969);
      return paramViewGroup;
      label833:
      if ("coupon".equals(localObject1))
      {
        paramView.mTvInfo.setVisibility(0);
        paramView.mTvInfo.setText("查看详情");
        paramView.mTvInfo.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            new CouponInfoPop(MyCouponActivity.this).show(paramAnonymousView, null, locale.getString("rule"));
          }
        });
        paramView.mIv.setImageBitmap(null);
        return paramViewGroup;
      }
      if ("service_youpin".equals(localObject1))
      {
        paramInt = -1;
        if (locale.containsKey("howToUse")) {
          paramInt = locale.getIntValue("howToUse");
        }
        if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 5) || (paramInt == 6))
        {
          paramView.mTvInfo.setVisibility(0);
          paramView.mTvInfo.setText("去使用");
          paramView.mTvInfo.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              if ((paramInt == 1) && (locale.containsKey("jumpAddress")) && (!TextUtils.isEmpty(locale.getString("jumpAddress"))))
              {
                paramAnonymousView = new Intent(MyCouponActivity.a.a(MyCouponActivity.a.this), YouPinGuidanceH5Activity.class);
                paramAnonymousView.putExtra("youpinH5url", locale.getString("jumpAddress"));
                MyCouponActivity.this.startActivity(paramAnonymousView);
              }
              do
              {
                return;
                if (paramInt == 2)
                {
                  paramAnonymousView = new Intent(MyCouponActivity.a.a(MyCouponActivity.a.this), YouPinGuidanceH5Activity.class);
                  paramAnonymousView.putExtra("youpinH5url", locale.getString("jumpAddress"));
                  MyCouponActivity.this.startActivity(paramAnonymousView);
                  return;
                }
                if (paramInt == 3)
                {
                  paramAnonymousView = new Intent(MyCouponActivity.a.a(MyCouponActivity.a.this), YouPinGuidanceActivity.class);
                  MyCouponActivity.this.startActivity(paramAnonymousView);
                  return;
                }
                if ((paramInt == 4) && (locale.containsKey("categoryFirst")) && (!TextUtils.isEmpty(locale.getString("categoryFirst"))) && (locale.containsKey("categoryName")) && (!TextUtils.isEmpty(locale.getString("categoryName"))))
                {
                  paramAnonymousView = new Intent(MyCouponActivity.a.a(MyCouponActivity.a.this), YouPinGoodsListActivity.class);
                  paramAnonymousView.putExtra("typeCode", locale.getString("categoryFirst"));
                  paramAnonymousView.putExtra("typeName", locale.getString("categoryName"));
                  MyCouponActivity.this.startActivity(paramAnonymousView);
                  return;
                }
                if ((paramInt == 5) && (locale.containsKey("productCode")) && (!TextUtils.isEmpty(locale.getString("productCode"))) && (locale.containsKey("skuCode")) && (!TextUtils.isEmpty(locale.getString("skuCode"))))
                {
                  paramAnonymousView = new Intent(MyCouponActivity.a.a(MyCouponActivity.a.this), GoodsDetailAc.class);
                  paramAnonymousView.putExtra("productCode", locale.getString("productCode"));
                  paramAnonymousView.putExtra("skuCode", locale.getString("skuCode"));
                  MyCouponActivity.this.startActivity(paramAnonymousView);
                  return;
                }
              } while ((paramInt != 6) || (!locale.containsKey("jumpAddress")) || (TextUtils.isEmpty(locale.getString("jumpAddress"))));
              JsBridgeWebActivity.start(MyCouponActivity.this, locale.getString("h5Title"), locale.getString("jumpAddress"));
            }
          });
          paramView.mIv.setImageBitmap(null);
          return paramViewGroup;
        }
        paramView.mTvInfo.setVisibility(8);
        paramView.mIv.setImageResource(2130838610);
        return paramViewGroup;
      }
      paramView.mTvInfo.setVisibility(8);
      paramView.mIv.setImageBitmap(null);
      return paramViewGroup;
      label1034:
      paramView.mTvInfo.setVisibility(8);
      paramView.mIv.setImageBitmap(null);
      return paramViewGroup;
    }
  }
  
  class b
    implements i.a<String>
  {
    private String b;
    
    public b(String paramString)
    {
      this.b = paramString;
    }
    
    public void onParse(String paramString, k paramk)
    {
      com.freelxl.baselibrary.f.d.d("MyCouponActivity", "=====url:" + paramk.getUrl());
      com.freelxl.baselibrary.f.d.d("MyCouponActivity", "=====onParse:" + paramString);
      Object localObject;
      if ("service_move".equals(this.b)) {
        localObject = MyCouponActivity.this.a.decrypt(paramString, "EbpU4WtY", "vpRZ1kmU");
      }
      for (;;)
      {
        paramString = com.alibaba.fastjson.e.parseObject((String)localObject);
        com.freelxl.baselibrary.f.d.d("MyCouponActivity", "=====url:" + paramk.getUrl());
        com.freelxl.baselibrary.f.d.d("MyCouponActivity", "=====onParse:" + (String)localObject);
        if (paramString.getInteger("status").intValue() != 0) {
          break;
        }
        paramk.setSuccess(Boolean.valueOf(true));
        localObject = paramString.getJSONObject("data");
        if (localObject != null) {
          paramk.setObject(((com.alibaba.fastjson.e)localObject).getJSONArray("list"));
        }
        paramk.setMessage(paramString.getString("message"));
        return;
        if ("service_repair".equals(this.b))
        {
          localObject = MyCouponActivity.this.a.decrypt(paramString, "vpRZ1kmU", "ZiRuHore");
        }
        else if ("yi".equals(this.b))
        {
          localObject = MyCouponActivity.this.a.decrypt(paramString, "vpRZ1kmU", "ZiR00mYi");
        }
        else
        {
          localObject = paramString;
          if ("ms".equals(this.b)) {
            localObject = MyCouponActivity.this.a.decrypt(paramString, MyCouponActivity.e(MyCouponActivity.this), MyCouponActivity.f(MyCouponActivity.this));
          }
        }
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage(paramString.getString("message"));
    }
    
    public void onSuccess(k paramk)
    {
      com.freelxl.baselibrary.f.d.d("MyCouponActivity", "=====onSuccess:");
      MyCouponActivity.c(MyCouponActivity.this);
      if (paramk.getSuccess().booleanValue())
      {
        if (!"service_move".equals(this.b)) {
          break label60;
        }
        MyCouponActivity.c(MyCouponActivity.this, (b)paramk.getObject());
      }
      for (;;)
      {
        MyCouponActivity.d(MyCouponActivity.this);
        return;
        label60:
        if ("service_repair".equals(this.b)) {
          MyCouponActivity.d(MyCouponActivity.this, (b)paramk.getObject());
        } else if ("yi".equals(this.b)) {
          MyCouponActivity.e(MyCouponActivity.this, (b)paramk.getObject());
        } else if ("ms".equals(this.b)) {
          MyCouponActivity.f(MyCouponActivity.this, (b)paramk.getObject());
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyCouponActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */