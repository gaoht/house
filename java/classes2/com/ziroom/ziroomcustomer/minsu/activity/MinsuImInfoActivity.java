package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.f;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.e.a;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class MinsuImInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView A;
  private EditText B;
  private FrameLayout C;
  private LinearLayout D;
  private ObservableScrollView E;
  private TextView F;
  private RelativeLayout G;
  private CommonTitle H;
  private String I;
  private String J;
  private int K;
  private String L;
  private String M;
  private String N;
  private int O;
  private View P;
  private int Q;
  private MinsuHouseDetailBean R;
  private SimpleDraweeView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private LinearLayout e;
  private LinearLayout f;
  private TextView g;
  private LinearLayout r;
  private TextView s;
  private LinearLayout t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private ImageButton y;
  private ImageButton z;
  
  private void a()
  {
    this.G = ((RelativeLayout)findViewById(2131691207));
    this.F = ((TextView)findViewById(2131691438));
    this.E = ((ObservableScrollView)findViewById(2131689506));
    this.D = ((LinearLayout)findViewById(2131691209));
    this.C = ((FrameLayout)findViewById(2131691231));
    this.B = ((EditText)findViewById(2131691232));
    this.A = ((TextView)findViewById(2131691230));
    this.z = ((ImageButton)findViewById(2131691436));
    this.d = ((TextView)findViewById(2131691435));
    this.y = ((ImageButton)findViewById(2131691434));
    this.x = ((TextView)findViewById(2131691433));
    this.w = ((TextView)findViewById(2131691432));
    this.v = ((TextView)findViewById(2131691431));
    this.u = ((TextView)findViewById(2131691430));
    this.t = ((LinearLayout)findViewById(2131691213));
    this.s = ((TextView)findViewById(2131691214));
    this.r = ((LinearLayout)findViewById(2131691211));
    this.g = ((TextView)findViewById(2131691212));
    this.f = ((LinearLayout)findViewById(2131691682));
    this.e = ((LinearLayout)findViewById(2131691427));
    this.c = ((TextView)findViewById(2131691429));
    this.b = ((TextView)findViewById(2131691210));
    this.a = ((SimpleDraweeView)findViewById(2131691428));
    this.P = findViewById(2131691437);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.y.setEnabled(false);
    if (ae.notNull(this.M)) {
      this.g.setText(this.M);
    }
    if (ae.notNull(this.N)) {
      this.s.setText(this.N);
    }
    if ((ae.notNull(this.M)) && (ae.notNull(this.N)) && (h()))
    {
      this.F.setBackgroundColor(getResources().getColor(2131624475));
      this.P.setVisibility(8);
    }
    for (;;)
    {
      this.B.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          MinsuImInfoActivity.a(MinsuImInfoActivity.this);
        }
      });
      this.F.setOnClickListener(this);
      return;
      this.F.setBackgroundColor(getResources().getColor(2131624045));
      this.P.setVisibility(0);
    }
  }
  
  private void a(MinsuHouseDetailBean paramMinsuHouseDetailBean)
  {
    this.a.setController(c.frescoController(paramMinsuHouseDetailBean.data.defaultPic));
    this.b.setText(paramMinsuHouseDetailBean.data.houseName);
    this.c.setText(paramMinsuHouseDetailBean.data.rentWayName);
    if (f.notNull(paramMinsuHouseDetailBean.data.msgInfo))
    {
      this.u.setText(paramMinsuHouseDetailBean.data.msgInfo);
      this.u.setVisibility(0);
      return;
    }
    this.u.setVisibility(8);
  }
  
  private void b()
  {
    a.getHouseListDetail(this, this.I, this.K, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuHouseDetailBean localMinsuHouseDetailBean = (MinsuHouseDetailBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseDetailBean != null) && (localMinsuHouseDetailBean.checkSuccess(MinsuImInfoActivity.this)))
        {
          MinsuImInfoActivity.a(MinsuImInfoActivity.this, localMinsuHouseDetailBean);
          MinsuImInfoActivity.b(MinsuImInfoActivity.this, localMinsuHouseDetailBean);
          paramAnonymousk = MinsuImInfoActivity.this;
          int i;
          if (localMinsuHouseDetailBean.data.checkInLimit == 0)
          {
            i = 10;
            MinsuImInfoActivity.a(paramAnonymousk, i);
            if (MinsuImInfoActivity.b(MinsuImInfoActivity.this) == 1) {
              MinsuImInfoActivity.c(MinsuImInfoActivity.this).setEnabled(false);
            }
            MinsuImInfoActivity.b(MinsuImInfoActivity.this, localMinsuHouseDetailBean.data.minDay);
            MinsuImInfoActivity.a(MinsuImInfoActivity.this, localMinsuHouseDetailBean.data.rentWayName);
            if (!ae.isNull(localMinsuHouseDetailBean.data.landlordName)) {
              break label204;
            }
            MinsuImInfoActivity.d(MinsuImInfoActivity.this).setHint(MinsuImInfoActivity.this.getString(2131297152).replace("landlord", "房东"));
          }
          for (;;)
          {
            d.e("lanzhihong", "ro======" + localMinsuHouseDetailBean.toString());
            return;
            i = localMinsuHouseDetailBean.data.checkInLimit;
            break;
            label204:
            MinsuImInfoActivity.d(MinsuImInfoActivity.this).setHint(MinsuImInfoActivity.this.getString(2131297152).replace("landlord", localMinsuHouseDetailBean.data.landlordName));
          }
        }
        if (localMinsuHouseDetailBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuHouseDetailBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void b(int paramInt)
  {
    int i = Integer.parseInt(this.d.getText().toString().replace("人", ""));
    this.d.setText(i + paramInt + "人");
    paramInt = i + paramInt;
    if (paramInt == 1)
    {
      this.y.setEnabled(false);
      if (this.O == 1)
      {
        this.z.setEnabled(false);
        return;
      }
      this.z.setEnabled(true);
      return;
    }
    if ((paramInt > 1) && (paramInt >= this.O))
    {
      this.z.setEnabled(false);
      this.y.setEnabled(true);
      return;
    }
    this.y.setEnabled(true);
    this.z.setEnabled(true);
  }
  
  private boolean d(String paramString)
  {
    int i = aa.getInt(ApplicationEx.c, "imConMax", 400);
    if (TextUtils.isEmpty(paramString))
    {
      showToast("出行目的不能为空");
      return true;
    }
    if (paramString.length() > i)
    {
      showToast("字数超出限制");
      return true;
    }
    return false;
  }
  
  private void e()
  {
    if ((this.R == null) || (this.R.data == null)) {}
    for (int i = 0;; i = this.R.data.minDay)
    {
      com.ziroom.ziroomcustomer.minsu.f.k.toMinsuTimeSelectingActivity(this, this.M, this.N, this.I, this.K, i);
      return;
    }
  }
  
  private void f()
  {
    if ((ae.notNull(this.M)) && (ae.notNull(this.N)) && (g()) && (h()))
    {
      this.F.setBackgroundColor(getResources().getColor(2131624475));
      return;
    }
    this.F.setBackgroundColor(getResources().getColor(2131624045));
  }
  
  private boolean g()
  {
    if (m.getDaysBetween(m.strToDate(this.M, m.b), m.strToDate(this.N, m.b)) < this.Q)
    {
      showToast("小于最小入住天数");
      return false;
    }
    return true;
  }
  
  private boolean h()
  {
    return !ae.isNull(VdsAgent.trackEditTextSilent(this.B).toString());
  }
  
  public void commit()
  {
    if (this.R == null) {}
    do
    {
      return;
      if ((ae.isNull(this.M)) || (ae.isNull(this.N)))
      {
        showToast("请选择入住时间段");
        return;
      }
    } while (d(VdsAgent.trackEditTextSilent(this.B).toString()));
    com.ziroom.ziroomcustomer.minsu.f.k.toImPage(this, this.R.data.landlordUid, this.I, this.J, this.K, this.L, this.R.data.defaultPic, this.R.data.houseName, this.R.data.landlordName, this.M, this.N, this.d.getText().toString().replace("人", ""), VdsAgent.trackEditTextSilent(this.B).toString(), 2, MinsuHouseDetailActivity.class.getSimpleName(), "send_housecard");
    finish();
  }
  
  public void initTitle()
  {
    this.H = ((CommonTitle)findViewById(2131691272));
    this.H.showRightText(false, null);
    this.H.setMiddleText("联系房东");
    this.H.setLeftTextMargin(-6);
    this.H.setLeftButtonType(0);
    this.H.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuImInfoActivity.this.finish();
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    this.M = paramIntent.getStringExtra("startDate");
    this.N = paramIntent.getStringExtra("endDate");
    this.g.setText(this.M);
    this.s.setText(this.N);
    f();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691438: 
      commit();
      return;
    case 2131691434: 
      b(-1);
      return;
    case 2131691436: 
      b(1);
      return;
    case 2131691213: 
      e();
      return;
    }
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903287);
    this.I = getIntent().getStringExtra("fid");
    this.J = getIntent().getStringExtra("isTop50Online");
    this.K = getIntent().getIntExtra("rentWay", 0);
    this.M = getIntent().getStringExtra("startTime");
    this.N = getIntent().getStringExtra("endTime");
    initTitle();
    a();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuImInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */