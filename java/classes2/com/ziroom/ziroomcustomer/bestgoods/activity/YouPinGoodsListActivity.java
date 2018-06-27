package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.b.a;
import com.ziroom.ziroomcustomer.bestgoods.a.s;
import com.ziroom.ziroomcustomer.bestgoods.a.z;
import com.ziroom.ziroomcustomer.bestgoods.c.d;
import com.ziroom.ziroomcustomer.bestgoods.model.as;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import java.util.ArrayList;
import java.util.List;

public class YouPinGoodsListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private z A;
  private s B;
  private String C = "";
  private String D = "";
  private com.ziroom.ziroomcustomer.bestgoods.model.b E;
  private RecyclerView F;
  private boolean G = false;
  private Context a;
  private RelativeLayout b;
  private RelativeLayout c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private ImageView g;
  private ImageView r;
  private ImageView s;
  private ListView t;
  private ListView u;
  private View v;
  private boolean w = false;
  private boolean x = false;
  private List<as> y = new ArrayList();
  private List<as> z = new ArrayList();
  
  private void a()
  {
    this.r = ((ImageView)findViewById(2131689492));
    this.b = ((RelativeLayout)findViewById(2131692767));
    this.d = ((TextView)findViewById(2131692768));
    this.f = ((ImageView)findViewById(2131692769));
    this.c = ((RelativeLayout)findViewById(2131692770));
    this.e = ((TextView)findViewById(2131692771));
    this.g = ((ImageView)findViewById(2131692772));
    this.F = ((RecyclerView)findViewById(2131692773));
    this.t = ((ListView)findViewById(2131692774));
    this.u = ((ListView)findViewById(2131692775));
    this.v = findViewById(2131690020);
    this.s = ((ImageView)findViewById(2131692766));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.w)
      {
        this.w = true;
        this.f.setImageResource(2130838565);
        this.g.setImageResource(2130838564);
        if (this.x) {
          this.x = false;
        }
        this.v.setVisibility(0);
        this.t.setVisibility(0);
        this.u.setVisibility(8);
        return;
      }
      this.w = false;
      this.f.setImageResource(2130838564);
      this.g.setImageResource(2130838564);
      this.v.setVisibility(8);
      this.t.setVisibility(8);
      this.u.setVisibility(8);
      return;
    }
    if (!this.x)
    {
      this.x = true;
      this.f.setImageResource(2130838564);
      this.g.setImageResource(2130838565);
      if (this.w) {
        this.w = false;
      }
      this.v.setVisibility(0);
      this.t.setVisibility(8);
      this.u.setVisibility(0);
      return;
    }
    this.x = false;
    this.f.setImageResource(2130838564);
    this.g.setImageResource(2130838564);
    this.v.setVisibility(8);
    this.t.setVisibility(8);
    this.u.setVisibility(8);
  }
  
  private void b()
  {
    this.r.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.s.setOnClickListener(this);
  }
  
  private void d(final String paramString)
  {
    n.getYoupinProducType(this.a, paramString, new com.ziroom.ziroomcustomer.e.a.a(this.a, new l(as.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, List<as> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if (paramAnonymousList != null)
        {
          if ("2010".equals(paramString))
          {
            YouPinGoodsListActivity.b(YouPinGoodsListActivity.this).addAll(paramAnonymousList);
            YouPinGoodsListActivity.a(YouPinGoodsListActivity.this, new z(YouPinGoodsListActivity.e(YouPinGoodsListActivity.this), YouPinGoodsListActivity.b(YouPinGoodsListActivity.this)));
            YouPinGoodsListActivity.j(YouPinGoodsListActivity.this).setAdapter(YouPinGoodsListActivity.a(YouPinGoodsListActivity.this));
            paramAnonymousInt = 0;
            while (paramAnonymousInt < paramAnonymousList.size())
            {
              if (YouPinGoodsListActivity.c(YouPinGoodsListActivity.this).equals(((as)paramAnonymousList.get(paramAnonymousInt)).getLogicCode()))
              {
                YouPinGoodsListActivity.f(YouPinGoodsListActivity.this).setText(((as)paramAnonymousList.get(paramAnonymousInt)).getCategoryName());
                YouPinGoodsListActivity.a(YouPinGoodsListActivity.this).setSelectedPos(paramAnonymousInt);
              }
              paramAnonymousInt += 1;
            }
            YouPinGoodsListActivity.c(YouPinGoodsListActivity.this, YouPinGoodsListActivity.c(YouPinGoodsListActivity.this));
          }
        }
        else {
          return;
        }
        YouPinGoodsListActivity.l(YouPinGoodsListActivity.this).clear();
        as localas = new as();
        localas.setChecked(false);
        localas.setCategoryName("全部");
        localas.setLogicCode("");
        YouPinGoodsListActivity.l(YouPinGoodsListActivity.this).add(localas);
        YouPinGoodsListActivity.l(YouPinGoodsListActivity.this).addAll(paramAnonymousList);
        YouPinGoodsListActivity.a(YouPinGoodsListActivity.this, new s(YouPinGoodsListActivity.e(YouPinGoodsListActivity.this), YouPinGoodsListActivity.l(YouPinGoodsListActivity.this)));
        YouPinGoodsListActivity.i(YouPinGoodsListActivity.this).setAdapter(YouPinGoodsListActivity.k(YouPinGoodsListActivity.this));
      }
    });
  }
  
  private void e()
  {
    this.C = getIntent().getStringExtra("typeCode");
    String str = getIntent().getStringExtra("typeName");
    this.d.setText(str);
    d("2010");
    f();
    this.t.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (YouPinGoodsListActivity.a(YouPinGoodsListActivity.this) == null) {
          return;
        }
        YouPinGoodsListActivity.a(YouPinGoodsListActivity.this).setSelectedPos(paramAnonymousInt);
        YouPinGoodsListActivity.a(YouPinGoodsListActivity.this, ((as)YouPinGoodsListActivity.b(YouPinGoodsListActivity.this).get(paramAnonymousInt)).getLogicCode());
        YouPinGoodsListActivity.b(YouPinGoodsListActivity.this, "");
        if ("101020".equals(YouPinGoodsListActivity.c(YouPinGoodsListActivity.this))) {
          YouPinGoodsListActivity.a(YouPinGoodsListActivity.this, true);
        }
        for (;;)
        {
          YouPinGoodsListActivity.d(YouPinGoodsListActivity.this).setText("全部");
          YouPinGoodsListActivity.d(YouPinGoodsListActivity.this).setTextColor(YouPinGoodsListActivity.e(YouPinGoodsListActivity.this).getResources().getColor(2131624588));
          YouPinGoodsListActivity.f(YouPinGoodsListActivity.this).setText(((as)YouPinGoodsListActivity.b(YouPinGoodsListActivity.this).get(paramAnonymousInt)).getCategoryName());
          YouPinGoodsListActivity.c(YouPinGoodsListActivity.this, ((as)YouPinGoodsListActivity.b(YouPinGoodsListActivity.this).get(paramAnonymousInt)).getLogicCode());
          YouPinGoodsListActivity.g(YouPinGoodsListActivity.this);
          YouPinGoodsListActivity.b(YouPinGoodsListActivity.this, false);
          YouPinGoodsListActivity.h(YouPinGoodsListActivity.this).setVisibility(8);
          YouPinGoodsListActivity.i(YouPinGoodsListActivity.this).setVisibility(8);
          YouPinGoodsListActivity.j(YouPinGoodsListActivity.this).setVisibility(8);
          return;
          YouPinGoodsListActivity.a(YouPinGoodsListActivity.this, false);
        }
      }
    });
    this.u.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (YouPinGoodsListActivity.k(YouPinGoodsListActivity.this) == null) {
          return;
        }
        YouPinGoodsListActivity.k(YouPinGoodsListActivity.this).setSelectedPos(paramAnonymousInt);
        YouPinGoodsListActivity.b(YouPinGoodsListActivity.this, ((as)YouPinGoodsListActivity.l(YouPinGoodsListActivity.this).get(paramAnonymousInt)).getLogicCode());
        YouPinGoodsListActivity.d(YouPinGoodsListActivity.this).setText(((as)YouPinGoodsListActivity.l(YouPinGoodsListActivity.this).get(paramAnonymousInt)).getCategoryName());
        YouPinGoodsListActivity.g(YouPinGoodsListActivity.this);
        YouPinGoodsListActivity.c(YouPinGoodsListActivity.this, false);
        YouPinGoodsListActivity.h(YouPinGoodsListActivity.this).setVisibility(8);
        YouPinGoodsListActivity.i(YouPinGoodsListActivity.this).setVisibility(8);
        YouPinGoodsListActivity.j(YouPinGoodsListActivity.this).setVisibility(8);
      }
    });
  }
  
  private void f()
  {
    n.getYoupinGoodsList(this.a, this.C, this.D, new com.ziroom.ziroomcustomer.e.a.a(this.a, new m(com.ziroom.ziroomcustomer.bestgoods.model.b.class, new e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        paramAnonymousThrowable = new com.ziroom.ziroomcustomer.bestgoods.a.b(YouPinGoodsListActivity.e(YouPinGoodsListActivity.this), null);
        YouPinGoodsListActivity.n(YouPinGoodsListActivity.this).setLayoutManager(new GridLayoutManager(YouPinGoodsListActivity.e(YouPinGoodsListActivity.this), 2, 1, false));
        YouPinGoodsListActivity.n(YouPinGoodsListActivity.this).setAdapter(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.bestgoods.model.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        if (paramAnonymousb != null)
        {
          YouPinGoodsListActivity.a(YouPinGoodsListActivity.this, paramAnonymousb);
          YouPinGoodsListActivity.m(YouPinGoodsListActivity.this);
        }
      }
    });
  }
  
  private void g()
  {
    final List localList = this.E.getList();
    if ((localList == null) || (localList.size() <= 0))
    {
      g.textToast(this.a, "没有符合条件的商品");
      return;
    }
    com.ziroom.ziroomcustomer.bestgoods.a.b localb = new com.ziroom.ziroomcustomer.bestgoods.a.b(this.a, localList);
    this.F.setLayoutManager(new GridLayoutManager(this.a, 2, 1, false));
    this.F.setAdapter(localb);
    localb.setOnItemClickListener(new b.a()
    {
      public void onItemClick(View paramAnonymousView, int paramAnonymousInt)
      {
        paramAnonymousView = new Intent(YouPinGoodsListActivity.e(YouPinGoodsListActivity.this), GoodsDetailAc.class);
        paramAnonymousView.putExtra("typeCode", YouPinGoodsListActivity.c(YouPinGoodsListActivity.this));
        paramAnonymousView.putExtra("isShowSafeCheck", YouPinGoodsListActivity.o(YouPinGoodsListActivity.this));
        paramAnonymousView.putExtra("isGoodsListActivity", true);
        paramAnonymousView.putExtra("productCode", ((com.ziroom.ziroomcustomer.bestgoods.model.a)localList.get(paramAnonymousInt)).getProductCode());
        paramAnonymousView.putExtra("skuCode", ((com.ziroom.ziroomcustomer.bestgoods.model.a)localList.get(paramAnonymousInt)).getSkuCode());
        YouPinGoodsListActivity.this.startActivityAndFinish(paramAnonymousView);
      }
    });
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
      startActivityAndFinish(new Intent(this.a, YouPinGuidanceActivity.class));
      return;
    case 2131692767: 
      a(true);
      return;
    case 2131692770: 
      a(false);
      return;
    case 2131690020: 
      this.v.setVisibility(8);
      this.t.setVisibility(8);
      this.u.setVisibility(8);
      this.x = false;
      this.w = false;
      return;
    }
    d.toYouPinShoppingCart(this.a);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903569);
    this.a = this;
    a();
    b();
    e();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      startActivityAndFinish(new Intent(this.a, YouPinGuidanceActivity.class));
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinGoodsListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */