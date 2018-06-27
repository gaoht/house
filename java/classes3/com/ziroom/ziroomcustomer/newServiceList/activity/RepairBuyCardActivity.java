package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.newServiceList.a.b;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CanBuyCard;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.Promotions;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.af;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RepairBuyCardActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ScrollView A;
  private int B;
  private int C;
  private ArrayList<Long> D;
  private long E;
  private LinearLayout F;
  private RelativeLayout G;
  private String H = "";
  private MyGridView I;
  private int J = 0;
  private com.ziroom.ziroomcustomer.newServiceList.a.a K;
  private b L;
  private String M;
  private Context a;
  private SimpleDraweeView b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private ListViewForScrollView f;
  private Button g;
  private ImageView r;
  private List<CanBuyCard> s;
  private List<String> t = new ArrayList();
  private List<Button> u = new ArrayList();
  private int v = 0;
  private List<Promotions> w = new ArrayList();
  private List<String> x;
  private String y;
  private String z = "";
  
  private void a()
  {
    String str = getIntent().getStringExtra("cardIndex");
    this.M = getIntent().getStringExtra("isBack");
    if (!TextUtils.isEmpty(str)) {
      this.J = Integer.parseInt(str);
    }
    j.getCanBuyRepairCard(this.a, new a());
  }
  
  private void b()
  {
    View localView = findViewById(2131689541);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    localView.requestFocus();
    localView.requestFocusFromTouch();
    this.b = ((SimpleDraweeView)findViewById(2131692130));
    this.c = ((ImageView)findViewById(2131690392));
    this.c.setVisibility(8);
    this.d = ((TextView)findViewById(2131692131));
    this.e = ((TextView)findViewById(2131692132));
    this.f = ((ListViewForScrollView)findViewById(2131690240));
    this.g = ((Button)findViewById(2131689816));
    this.r = ((ImageView)findViewById(2131689492));
    this.A = ((ScrollView)findViewById(2131689567));
    this.F = ((LinearLayout)findViewById(2131690206));
    this.G = ((RelativeLayout)findViewById(2131690202));
    this.I = ((MyGridView)findViewById(2131689973));
    this.b.setBackgroundResource(2130838531);
    this.r.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    if ((this.s == null) || (this.s.isEmpty())) {
      return;
    }
    CanBuyCard localCanBuyCard = (CanBuyCard)this.s.get(paramInt);
    this.y = localCanBuyCard.getShowName();
    this.d.setText(localCanBuyCard.getShowName());
    this.w = localCanBuyCard.getTypePromotions();
    if (this.L == null)
    {
      this.L = new b(this.a, this.w);
      this.f.setAdapter(this.L);
      return;
    }
    this.L.setData(this.w);
  }
  
  private void e()
  {
    if (TextUtils.isEmpty(this.z))
    {
      g.textToast(this.a, "请先选择一个储值卡");
      return;
    }
    Intent localIntent = new Intent(this.a, RepairCardPayActivity.class);
    localIntent.putExtra("cardName", this.y);
    localIntent.putExtra("promoList", (Serializable)this.w);
    localIntent.putExtra("tagPrice", this.z);
    localIntent.putExtra("tag_Price", this.E + "");
    localIntent.putExtra("c_id", this.B + "");
    localIntent.putExtra("time", this.C + "");
    localIntent.putExtra("card_index", this.J + "");
    startActivity(localIntent);
    finish();
  }
  
  private void f()
  {
    this.x = new ArrayList();
    this.D = new ArrayList();
    if ((this.s == null) || (this.s.isEmpty())) {
      return;
    }
    Iterator localIterator = this.s.iterator();
    while (localIterator.hasNext())
    {
      CanBuyCard localCanBuyCard = (CanBuyCard)localIterator.next();
      this.x.add(Long.parseLong(localCanBuyCard.getRechargeAmount()) / 100L + "元");
      this.D.add(Long.valueOf(Long.parseLong(localCanBuyCard.getRechargeAmount())));
    }
    this.K = new com.ziroom.ziroomcustomer.newServiceList.a.a(this.a, this.x, this.J);
    this.I.setAdapter(this.K);
    this.I.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (RepairBuyCardActivity.a(RepairBuyCardActivity.this) != paramAnonymousInt)
        {
          RepairBuyCardActivity.a(RepairBuyCardActivity.this, paramAnonymousInt);
          RepairBuyCardActivity.b(RepairBuyCardActivity.this).setCurrentPosition(RepairBuyCardActivity.a(RepairBuyCardActivity.this));
          RepairBuyCardActivity.c(RepairBuyCardActivity.this);
          RepairBuyCardActivity.b(RepairBuyCardActivity.this).notifyDataSetChanged();
        }
      }
    });
    if ((!TextUtils.isEmpty(this.M)) && ("is_Back".equals(this.M)))
    {
      g();
      this.g.setBackgroundResource(2130838044);
      return;
    }
    g();
    this.g.setBackgroundResource(2130838044);
  }
  
  private void g()
  {
    b(this.J);
    if ((this.D == null) || (this.D.isEmpty())) {}
    do
    {
      return;
      this.E = ((Long)this.D.get(this.J)).longValue();
      this.z = ((String)this.x.get(this.J));
    } while ((this.s == null) || (this.s.isEmpty()));
    this.B = ((CanBuyCard)this.s.get(this.J)).getCid();
    this.C = ((CanBuyCard)this.s.get(this.J)).getValidMonth();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
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
    }
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903441);
    this.a = this;
    b();
    a();
  }
  
  public void onResume()
  {
    super.onResume();
    int i = getWindowManager().getDefaultDisplay().getWidth() * 1 / 3;
    ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
    localLayoutParams.height = i;
    this.b.setLayoutParams(localLayoutParams);
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), CanBuyCard.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setMessage((String)paramString.get("message"));
      paramk.setSuccess(Boolean.valueOf(false));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        RepairBuyCardActivity.a(RepairBuyCardActivity.this, (List)paramk.getObject());
        if (RepairBuyCardActivity.d(RepairBuyCardActivity.this) != null)
        {
          RepairBuyCardActivity.e(RepairBuyCardActivity.this).setVisibility(0);
          RepairBuyCardActivity.f(RepairBuyCardActivity.this).setVisibility(8);
        }
        RepairBuyCardActivity.g(RepairBuyCardActivity.this);
        return;
      }
      RepairBuyCardActivity.e(RepairBuyCardActivity.this).setVisibility(8);
      RepairBuyCardActivity.f(RepairBuyCardActivity.this).setVisibility(0);
      af.showToast(RepairBuyCardActivity.h(RepairBuyCardActivity.this), paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairBuyCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */