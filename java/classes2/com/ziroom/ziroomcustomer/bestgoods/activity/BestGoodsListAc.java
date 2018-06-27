package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.k;
import com.ziroom.ziroomcustomer.bestgoods.model.d;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestGoodsListAc
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView A;
  private TextView B;
  private ImageView C;
  private ImageView D;
  private TextView E;
  private LinearLayout F;
  private boolean G = true;
  private boolean H = true;
  private ImageView a;
  private GridView b;
  private Context c;
  private UserInfo d;
  private String e;
  private com.ziroom.ziroomcustomer.bestgoods.model.b f;
  private ListView g;
  private RelativeLayout r;
  private ListView s;
  private RelativeLayout t;
  private View u;
  private k v;
  private com.ziroom.ziroomcustomer.bestgoods.a.j w;
  private List<d> x;
  private List<com.ziroom.ziroomcustomer.bestgoods.model.c> y;
  private Integer z = null;
  
  private void a()
  {
    this.c = this;
    this.a = ((ImageView)findViewById(2131689492));
    this.E = ((TextView)findViewById(2131690010));
    this.F = ((LinearLayout)findViewById(2131689998));
    this.b = ((GridView)findViewById(2131690019));
    this.b.setSelector(new ColorDrawable(0));
    this.t = ((RelativeLayout)findViewById(2131690011));
    this.A = ((TextView)findViewById(2131690013));
    this.A.setFocusable(true);
    this.A.setFocusableInTouchMode(true);
    this.A.requestFocus();
    this.s = ((ListView)findViewById(2131690022));
    this.C = ((ImageView)findViewById(2131690014));
    this.r = ((RelativeLayout)findViewById(2131690015));
    this.B = ((TextView)findViewById(2131690017));
    this.g = ((ListView)findViewById(2131690021));
    this.D = ((ImageView)findViewById(2131690018));
    this.u = findViewById(2131690020);
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.u.setOnClickListener(this);
  }
  
  private void d(String paramString)
  {
    showEmptyView(this.F, paramString).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (ah.isNetworkAvailable(BestGoodsListAc.d(BestGoodsListAc.this)))
        {
          BestGoodsListAc.j(BestGoodsListAc.this);
          return;
        }
        BestGoodsListAc.this.showToast("请检查网络连接");
      }
    });
  }
  
  private void e()
  {
    this.d = ((ApplicationEx)getApplication()).getUser();
    this.e = getIntent().getStringExtra("styleCode");
    Object localObject1 = getIntent().getStringExtra("styleName");
    this.A.setText((CharSequence)localObject1);
    this.B.setText("全部");
    g();
    this.x = new ArrayList();
    localObject1 = new d();
    ((d)localObject1).setName("全部");
    Object localObject2 = new d();
    ((d)localObject2).setName("优格");
    Object localObject3 = new d();
    ((d)localObject3).setName("清语");
    Object localObject4 = new d();
    ((d)localObject4).setName("友家");
    this.x.add(localObject1);
    this.x.add(localObject2);
    this.x.add(localObject3);
    this.x.add(localObject4);
    this.v = new k(this.c, this.x);
    this.s.setAdapter(this.v);
    this.y = new ArrayList();
    localObject1 = new com.ziroom.ziroomcustomer.bestgoods.model.c();
    ((com.ziroom.ziroomcustomer.bestgoods.model.c)localObject1).setName("全部");
    localObject2 = new com.ziroom.ziroomcustomer.bestgoods.model.c();
    ((com.ziroom.ziroomcustomer.bestgoods.model.c)localObject2).setName("客厅");
    localObject3 = new com.ziroom.ziroomcustomer.bestgoods.model.c();
    ((com.ziroom.ziroomcustomer.bestgoods.model.c)localObject3).setName("卧室");
    localObject4 = new com.ziroom.ziroomcustomer.bestgoods.model.c();
    ((com.ziroom.ziroomcustomer.bestgoods.model.c)localObject4).setName("书卧");
    this.y.add(localObject1);
    this.y.add(localObject2);
    this.y.add(localObject3);
    this.y.add(localObject4);
    this.w = new com.ziroom.ziroomcustomer.bestgoods.a.j(this.c, this.y);
    this.g.setAdapter(this.w);
    f();
  }
  
  private void f()
  {
    this.s.setChoiceMode(0);
    this.s.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        BestGoodsListAc.a(BestGoodsListAc.this).setSelectedPos(paramAnonymousInt);
        ((d)BestGoodsListAc.b(BestGoodsListAc.this).get(paramAnonymousInt)).setChecked(true);
        paramAnonymousAdapterView = ((d)BestGoodsListAc.b(BestGoodsListAc.this).get(paramAnonymousInt)).getName();
        BestGoodsListAc.c(BestGoodsListAc.this).setText(paramAnonymousAdapterView);
        BestGoodsListAc.c(BestGoodsListAc.this).setTextColor(BestGoodsListAc.d(BestGoodsListAc.this).getResources().getColor(2131624588));
        if (paramAnonymousInt == 0) {
          BestGoodsListAc.a(BestGoodsListAc.this, null);
        }
        for (;;)
        {
          BestGoodsListAc.e(BestGoodsListAc.this).setVisibility(8);
          BestGoodsListAc.f(BestGoodsListAc.this).setVisibility(8);
          BestGoodsListAc.g(BestGoodsListAc.this).setVisibility(8);
          BestGoodsListAc.h(BestGoodsListAc.this).setImageResource(2130838564);
          BestGoodsListAc.i(BestGoodsListAc.this).setImageResource(2130838564);
          BestGoodsListAc.j(BestGoodsListAc.this);
          return;
          if (paramAnonymousInt == 1) {
            BestGoodsListAc.a(BestGoodsListAc.this, "10000100001");
          } else if (paramAnonymousInt == 2) {
            BestGoodsListAc.a(BestGoodsListAc.this, "10000100002");
          } else if (paramAnonymousInt == 3) {
            BestGoodsListAc.a(BestGoodsListAc.this, "10000100003");
          }
        }
      }
    });
    this.g.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        BestGoodsListAc.k(BestGoodsListAc.this).setSelectedPos(paramAnonymousInt);
        ((com.ziroom.ziroomcustomer.bestgoods.model.c)BestGoodsListAc.l(BestGoodsListAc.this).get(paramAnonymousInt)).setChecked(true);
        paramAnonymousAdapterView = ((com.ziroom.ziroomcustomer.bestgoods.model.c)BestGoodsListAc.l(BestGoodsListAc.this).get(paramAnonymousInt)).getName();
        BestGoodsListAc.m(BestGoodsListAc.this).setText(paramAnonymousAdapterView);
        BestGoodsListAc.m(BestGoodsListAc.this).setTextColor(BestGoodsListAc.d(BestGoodsListAc.this).getResources().getColor(2131624588));
        if (paramAnonymousInt == 0) {
          BestGoodsListAc.a(BestGoodsListAc.this, null);
        }
        for (;;)
        {
          BestGoodsListAc.e(BestGoodsListAc.this).setVisibility(8);
          BestGoodsListAc.f(BestGoodsListAc.this).setVisibility(8);
          BestGoodsListAc.g(BestGoodsListAc.this).setVisibility(8);
          BestGoodsListAc.i(BestGoodsListAc.this).setImageResource(2130838564);
          BestGoodsListAc.h(BestGoodsListAc.this).setImageResource(2130838564);
          BestGoodsListAc.j(BestGoodsListAc.this);
          return;
          if (paramAnonymousInt == 1) {
            BestGoodsListAc.a(BestGoodsListAc.this, Integer.valueOf(2));
          } else if (paramAnonymousInt == 2) {
            BestGoodsListAc.a(BestGoodsListAc.this, Integer.valueOf(1));
          } else if (paramAnonymousInt == 3) {
            BestGoodsListAc.a(BestGoodsListAc.this, Integer.valueOf(3));
          }
        }
      }
    });
  }
  
  private void g()
  {
    if (ah.isNetworkAvailable(this.c))
    {
      showProgress("");
      HashMap localHashMap = new HashMap();
      if (this.e == null)
      {
        localHashMap.put("styleCode", "");
        if (this.z != null) {
          break label134;
        }
        localHashMap.put("roomRegion", "");
      }
      for (;;)
      {
        localHashMap.put("page", "1");
        localHashMap.put("pageSize", "1000");
        com.ziroom.ziroomcustomer.e.j.getYPBestGoodsList(this.c, localHashMap, new a(new com.ziroom.ziroomcustomer.newrepair.utils.b(com.ziroom.ziroomcustomer.bestgoods.model.b.class)));
        return;
        localHashMap.put("styleCode", this.e);
        break;
        label134:
        localHashMap.put("roomRegion", String.valueOf(this.z));
      }
    }
    dismissProgress();
    d("请检查网络连接");
  }
  
  private void h()
  {
    final List localList = this.f.getList();
    if ((localList == null) || (localList.size() <= 0)) {
      g.textToast(this.c, "没有符合条件的商品");
    }
    com.ziroom.ziroomcustomer.bestgoods.a.a locala = new com.ziroom.ziroomcustomer.bestgoods.a.a(this.c, localList);
    this.b.setAdapter(locala);
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = new Intent(BestGoodsListAc.d(BestGoodsListAc.this), GoodsDetailAc.class);
        paramAnonymousAdapterView.putExtra("productCode", ((com.ziroom.ziroomcustomer.bestgoods.model.a)localList.get(paramAnonymousInt)).getProductCode());
        paramAnonymousAdapterView.putExtra("skuCode", ((com.ziroom.ziroomcustomer.bestgoods.model.a)localList.get(paramAnonymousInt)).getSkuCode());
        BestGoodsListAc.this.startActivity(paramAnonymousAdapterView);
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
      finish();
      return;
    case 2131690011: 
      if (this.G)
      {
        this.G = false;
        this.C.setImageResource(2130838565);
        this.D.setImageResource(2130838564);
        this.u.setVisibility(0);
        this.s.setVisibility(0);
        this.g.setVisibility(8);
        return;
      }
      this.G = true;
      this.C.setImageResource(2130838564);
      this.D.setImageResource(2130838564);
      this.u.setVisibility(8);
      this.s.setVisibility(8);
      this.g.setVisibility(8);
      return;
    case 2131690015: 
      if (this.H)
      {
        this.D.setImageResource(2130838565);
        this.C.setImageResource(2130838564);
        this.u.setVisibility(0);
        this.g.setVisibility(0);
        this.s.setVisibility(8);
        this.H = false;
        return;
      }
      this.H = true;
      this.D.setImageResource(2130838564);
      this.C.setImageResource(2130838564);
      this.u.setVisibility(8);
      this.g.setVisibility(8);
      this.s.setVisibility(8);
      return;
    }
    this.u.setVisibility(8);
    this.s.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903109);
    a();
    b();
    e();
  }
  
  public class a
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public a()
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      BestGoodsListAc.this.dismissProgress();
      BestGoodsListAc.b(BestGoodsListAc.this, "请点击重试");
      g.textToast(BestGoodsListAc.d(BestGoodsListAc.this), "服务异常，请稍后重试");
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        BestGoodsListAc.this.closeEmpty(BestGoodsListAc.n(BestGoodsListAc.this));
        BestGoodsListAc.a(BestGoodsListAc.this, (com.ziroom.ziroomcustomer.bestgoods.model.b)paraml.getObject());
        if (BestGoodsListAc.o(BestGoodsListAc.this) == null) {
          break label64;
        }
        BestGoodsListAc.p(BestGoodsListAc.this);
      }
      for (;;)
      {
        BestGoodsListAc.this.dismissProgress();
        return;
        label64:
        paraml = paraml.getMessage();
        BestGoodsListAc.this.showToast(paraml);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/BestGoodsListAc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */