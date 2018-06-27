package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.an;
import com.ziroom.ziroomcustomer.bestgoods.a.an.b;
import com.ziroom.ziroomcustomer.bestgoods.c.d;
import com.ziroom.ziroomcustomer.bestgoods.model.av;
import com.ziroom.ziroomcustomer.bestgoods.model.ax;
import com.ziroom.ziroomcustomer.bestgoods.model.t;
import com.ziroom.ziroomcustomer.bestgoods.model.v;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ad;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class YouPinShoppingCartActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private LinearLayout A;
  private boolean B;
  private String C = "";
  private List<Boolean> D = new ArrayList();
  private List<Boolean> E = new ArrayList();
  private int F = 888;
  private ExpandableListView a;
  private LinearLayout b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private Context g;
  private av r;
  private boolean s = true;
  private List<ax> t = new ArrayList();
  private int u = 0;
  private Double v = Double.valueOf(0.0D);
  private List<v> w;
  private an x;
  private DecimalFormat y = new DecimalFormat("0.00");
  private String z = "";
  
  private void a()
  {
    this.g = this;
    this.f = ((ImageView)findViewById(2131689492));
    this.A = ((LinearLayout)findViewById(2131692776));
    this.a = ((ExpandableListView)findViewById(2131692777));
    this.b = ((LinearLayout)findViewById(2131692403));
    this.c = ((ImageView)findViewById(2131692404));
    this.d = ((TextView)findViewById(2131689996));
    this.e = ((TextView)findViewById(2131692405));
  }
  
  private void b()
  {
    this.f.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    List localList = ((v)this.w.get(paramInt)).getShoppingCartEntityList();
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramInt = 0;
      while (paramInt < localList.size())
      {
        ((t)localList.get(paramInt)).setChildSelect(true);
        paramInt += 1;
      }
    }
  }
  
  private void c(int paramInt)
  {
    List localList = ((v)this.w.get(paramInt)).getShoppingCartEntityList();
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramInt = 0;
      while (paramInt < localList.size())
      {
        ((t)localList.get(paramInt)).setChildSelect(false);
        paramInt += 1;
      }
    }
  }
  
  private void e()
  {
    this.z = getIntent().getStringExtra("uid");
    if (ApplicationEx.c.isLoginState())
    {
      if (TextUtils.isEmpty(this.z)) {
        this.z = ApplicationEx.c.getUser().getUid();
      }
      this.C = getIntent().getStringExtra("cityCode");
      aa.putString(this.g, "currentYouPinCityCode", this.C);
      this.B = getIntent().getBooleanExtra("isYouPinGuidanceActivity", false);
      n.getYouPinShoppingCartInfo(this.g, this.z, new com.ziroom.ziroomcustomer.e.a.a(this.g, new m(av.class, new e()))
      {
        public void onSuccess(int paramAnonymousInt, av paramAnonymousav)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousav);
          YouPinShoppingCartActivity.a(YouPinShoppingCartActivity.this, paramAnonymousav);
          if (YouPinShoppingCartActivity.a(YouPinShoppingCartActivity.this) != null) {
            YouPinShoppingCartActivity.b(YouPinShoppingCartActivity.this);
          }
        }
      });
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this.g);
    g.textToast(this.g, "请先登录");
  }
  
  private void f()
  {
    int k = 0;
    this.u = 0;
    this.v = Double.valueOf(0.0D);
    this.w = this.r.getSkulist();
    if ((this.w == null) || (this.w.isEmpty()))
    {
      showEmpty(this.A, "购物车暂无商品，赶快去添加吧~");
      return;
    }
    if ((this.w != null) && (!this.w.isEmpty()))
    {
      i = 0;
      while (i < this.w.size())
      {
        ((v)this.w.get(i)).setGroupSelect(true);
        List localList = ((v)this.w.get(i)).getShoppingCartEntityList();
        if ((localList != null) && (!localList.isEmpty()))
        {
          j = 0;
          while (j < localList.size())
          {
            ((t)localList.get(j)).setChildSelect(true);
            if (((t)localList.get(j)).isChildSelect())
            {
              int m = ((t)localList.get(j)).getAmount().intValue();
              Double localDouble = ((t)localList.get(j)).getPrice();
              this.v = Double.valueOf(this.v.doubleValue() + localDouble.doubleValue() * m);
              this.u += m;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    this.d.setText(this.y.format(this.v) + "");
    this.e.setText("结算（" + this.u + "）");
    this.c.setImageResource(2130840187);
    this.x = new an(this.g, this.w, new a(null));
    this.a.setAdapter(this.x);
    this.a.setGroupIndicator(null);
    int j = this.a.getCount();
    int i = k;
    while (i < j)
    {
      this.a.expandGroup(i);
      i += 1;
    }
    this.a.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
    {
      @Instrumented
      public boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onGroupClick(this, paramAnonymousExpandableListView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        VdsAgent.handleClickResult(new Boolean(true));
        return true;
      }
    });
    this.a.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
    {
      @Instrumented
      public boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
      {
        VdsAgent.onChildClick(this, paramAnonymousExpandableListView, paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong);
        paramAnonymousExpandableListView = new Intent(YouPinShoppingCartActivity.c(YouPinShoppingCartActivity.this), GoodsDetailAc.class);
        paramAnonymousExpandableListView.putExtra("productCode", ((t)((v)YouPinShoppingCartActivity.d(YouPinShoppingCartActivity.this).get(paramAnonymousInt1)).getShoppingCartEntityList().get(paramAnonymousInt2)).getProductCode());
        paramAnonymousExpandableListView.putExtra("skuCode", ((t)((v)YouPinShoppingCartActivity.d(YouPinShoppingCartActivity.this).get(paramAnonymousInt1)).getShoppingCartEntityList().get(paramAnonymousInt2)).getLogicCode());
        YouPinShoppingCartActivity.this.startActivity(paramAnonymousExpandableListView);
        VdsAgent.handleClickResult(new Boolean(true));
        return true;
      }
    });
    this.a.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousView = ApplicationEx.c.getUser();
        if (paramAnonymousView != null) {
          YouPinShoppingCartActivity.a(YouPinShoppingCartActivity.this, paramAnonymousView.getUid());
        }
        if (ExpandableListView.getPackedPositionType(paramAnonymousLong) == 1)
        {
          paramAnonymousLong = ((ExpandableListView)paramAnonymousAdapterView).getExpandableListPosition(paramAnonymousInt);
          paramAnonymousInt = ExpandableListView.getPackedPositionGroup(paramAnonymousLong);
          final int i = ExpandableListView.getPackedPositionChild(paramAnonymousLong);
          c.newBuilder(YouPinShoppingCartActivity.c(YouPinShoppingCartActivity.this)).setTitle("提示").setContent("是否删除该商品？").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
            {
              if ((paramAnonymous2Boolean) && (YouPinShoppingCartActivity.d(YouPinShoppingCartActivity.this) != null) && (!YouPinShoppingCartActivity.d(YouPinShoppingCartActivity.this).isEmpty()))
              {
                Object localObject = (t)((v)YouPinShoppingCartActivity.d(YouPinShoppingCartActivity.this).get(paramAnonymousInt)).getShoppingCartEntityList().get(i);
                if (localObject != null)
                {
                  paramAnonymous2View = ((t)localObject).getProductCode();
                  String str = ((t)localObject).getLogicCode();
                  localObject = ((t)localObject).getShoppingCartCode();
                  ax localax = new ax();
                  localax.setSkuCode(str);
                  localax.setAmount(Integer.valueOf(0));
                  localax.setProductCode(paramAnonymous2View);
                  localax.setUid(YouPinShoppingCartActivity.e(YouPinShoppingCartActivity.this));
                  localax.setCityCode(aa.getString(YouPinShoppingCartActivity.c(YouPinShoppingCartActivity.this), "currentYouPinCityCode", "000000"));
                  localax.setShoopingCartCode((String)localObject);
                  if ((YouPinShoppingCartActivity.f(YouPinShoppingCartActivity.this) != null) && (!YouPinShoppingCartActivity.f(YouPinShoppingCartActivity.this).isEmpty())) {
                    YouPinShoppingCartActivity.f(YouPinShoppingCartActivity.this).clear();
                  }
                  YouPinShoppingCartActivity.f(YouPinShoppingCartActivity.this).add(localax);
                  n.addYouPinShoppingCart(YouPinShoppingCartActivity.c(YouPinShoppingCartActivity.this), YouPinShoppingCartActivity.f(YouPinShoppingCartActivity.this), new com.ziroom.ziroomcustomer.e.a.a(YouPinShoppingCartActivity.c(YouPinShoppingCartActivity.this), new m(String.class, new e()))
                  {
                    public void onSuccess(int paramAnonymous3Int, String paramAnonymous3String)
                    {
                      super.onSuccess(paramAnonymous3Int, paramAnonymous3String);
                      g.textToast(YouPinShoppingCartActivity.c(YouPinShoppingCartActivity.this), "删除成功");
                      YouPinShoppingCartActivity.g(YouPinShoppingCartActivity.this);
                    }
                  });
                }
              }
            }
          }).build().show();
          return true;
        }
        return false;
      }
    });
  }
  
  private void g()
  {
    this.v = Double.valueOf(0.0D);
    this.u = 0;
    if ((this.w != null) && (!this.w.isEmpty()))
    {
      int i = 0;
      while (i < this.w.size())
      {
        ((v)this.w.get(i)).setGroupSelect(true);
        List localList = ((v)this.w.get(i)).getShoppingCartEntityList();
        if ((localList != null) && (!localList.isEmpty()))
        {
          int j = 0;
          while (j < localList.size())
          {
            ((t)localList.get(j)).setChildSelect(true);
            if (((t)localList.get(j)).isChildSelect())
            {
              int k = ((t)localList.get(j)).getAmount().intValue();
              Double localDouble = ((t)localList.get(j)).getPrice();
              this.v = Double.valueOf(this.v.doubleValue() + localDouble.doubleValue() * k);
              this.u += k;
            }
            j += 1;
          }
        }
        this.d.setText(this.y.format(this.v) + "");
        this.e.setText("结算（" + this.u + "）");
        j();
        i += 1;
      }
    }
  }
  
  private void h()
  {
    if ((this.w == null) && (!this.w.isEmpty())) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.w.size())
      {
        ((v)this.w.get(i)).setGroupSelect(false);
        List localList = ((v)this.w.get(i)).getShoppingCartEntityList();
        if ((localList != null) && (!localList.isEmpty()))
        {
          int j = 0;
          while (j < localList.size())
          {
            ((t)localList.get(j)).setChildSelect(false);
            j += 1;
          }
          this.v = Double.valueOf(0.0D);
          this.u = 0;
          this.d.setText(this.y.format(0L) + "");
          this.e.setText("结算（0）");
          j();
        }
        i += 1;
      }
    }
  }
  
  private void i()
  {
    if ((this.E != null) && (!this.E.isEmpty())) {
      this.E.clear();
    }
    int i = 0;
    if (i < this.w.size())
    {
      if (((v)this.w.get(i)).isGroupSelect()) {
        this.E.add(Boolean.valueOf(true));
      }
      for (;;)
      {
        i += 1;
        break;
        this.E.add(Boolean.valueOf(false));
      }
    }
    if (d.isAllCheck(this.E))
    {
      this.c.setImageResource(2130840187);
      this.s = true;
      return;
    }
    this.c.setImageResource(2130840186);
    this.s = false;
  }
  
  private void j()
  {
    if (this.u > 0)
    {
      this.e.setText("结算（" + this.u + "）");
      this.e.setBackgroundResource(2131624516);
      this.e.setClickable(true);
      return;
    }
    this.e.setText("结算（" + this.u + "）");
    this.e.setBackgroundResource(2131624042);
    this.e.setClickable(false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == this.F) && (paramInt2 == -1)) {
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
      if (this.B) {
        startActivity(new Intent(this.g, YouPinGuidanceActivity.class));
      }
      finish();
      return;
    case 2131692403: 
      if (!this.s)
      {
        this.s = true;
        g();
        this.c.setImageResource(2130840187);
      }
      for (;;)
      {
        this.x.notifyDataSetChanged();
        return;
        this.s = false;
        h();
        this.c.setImageResource(2130840186);
      }
    }
    g.textToast(this.g, "去结算");
    if (ApplicationEx.c.isLoginState())
    {
      int i;
      int j;
      int k;
      if ((this.w != null) && (!this.w.isEmpty()))
      {
        i = 0;
        while (i < this.w.size())
        {
          paramView = ((v)this.w.get(i)).getShoppingCartEntityList();
          j = 0;
          if (j < paramView.size())
          {
            if (((t)paramView.get(j)).isChildSelect())
            {
              k = ((t)paramView.get(j)).getAmount().intValue();
              int m = ((t)paramView.get(j)).getAmounts().intValue();
              if (k <= m) {
                break label345;
              }
              ((t)paramView.get(j)).setAmount(Integer.valueOf(m));
              showToast(((t)paramView.get(j)).getProductName() + "达到最大数量");
            }
            for (;;)
            {
              j += 1;
              break;
              label345:
              ((t)paramView.get(j)).setAmount(Integer.valueOf(k));
            }
          }
          i += 1;
        }
      }
      Object localObject1 = Double.valueOf(0.0D);
      paramView = (View)localObject1;
      if (this.w != null)
      {
        paramView = (View)localObject1;
        if (!this.w.isEmpty())
        {
          i = 0;
          paramView = (View)localObject1;
          while (i < this.w.size())
          {
            localObject2 = ((v)this.w.get(i)).getShoppingCartEntityList();
            j = 0;
            while (j < ((List)localObject2).size())
            {
              localObject1 = paramView;
              if (((t)((List)localObject2).get(j)).isChildSelect())
              {
                k = ((t)((List)localObject2).get(j)).getAmount().intValue();
                localObject1 = ((t)((List)localObject2).get(j)).getPrice();
                double d1 = paramView.doubleValue();
                localObject1 = Double.valueOf(k * ((Double)localObject1).doubleValue() + d1);
              }
              j += 1;
              paramView = (View)localObject1;
            }
            i += 1;
          }
        }
      }
      localObject1 = com.alibaba.fastjson.a.toJSONString(this.w);
      Object localObject2 = new Intent(this.g, YouPinCommitOrderActivity.class);
      ((Intent)localObject2).putExtra("selectedGoods", (String)localObject1);
      ((Intent)localObject2).putExtra("totalPrice", paramView);
      startActivityForResult((Intent)localObject2, this.F);
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this.g);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903570);
    a();
    b();
    e();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.B) {
        startActivity(new Intent(this.g, YouPinGuidanceActivity.class));
      }
      for (;;)
      {
        finish();
        return true;
        if (!TextUtils.isEmpty(ad.getOther(this.g, "youpinH5url"))) {
          finish();
        } else {
          startActivity(new Intent(this.g, YouPinGuidanceActivity.class));
        }
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  private class a
    implements an.b
  {
    private a() {}
    
    public void setChildChanged(List<v> paramList, int paramInt1, int paramInt2)
    {
      if ((YouPinShoppingCartActivity.n(YouPinShoppingCartActivity.this) != null) && (!YouPinShoppingCartActivity.n(YouPinShoppingCartActivity.this).isEmpty())) {
        YouPinShoppingCartActivity.n(YouPinShoppingCartActivity.this).clear();
      }
      paramList = Double.valueOf(0.0D);
      int i = 0;
      paramInt2 = 0;
      while (paramInt2 < YouPinShoppingCartActivity.d(YouPinShoppingCartActivity.this).size())
      {
        List localList = ((v)YouPinShoppingCartActivity.d(YouPinShoppingCartActivity.this).get(paramInt2)).getShoppingCartEntityList();
        int j = 0;
        while (j < localList.size())
        {
          int k = i;
          localObject = paramList;
          if (((t)localList.get(j)).isChildSelect())
          {
            k = ((t)localList.get(j)).getAmount().intValue();
            localObject = ((t)localList.get(j)).getPrice();
            localObject = Double.valueOf(paramList.doubleValue() + ((Double)localObject).doubleValue() * k);
            k = i + k;
          }
          j += 1;
          i = k;
          paramList = (List<v>)localObject;
        }
        paramInt2 += 1;
      }
      Object localObject = ((v)YouPinShoppingCartActivity.d(YouPinShoppingCartActivity.this).get(paramInt1)).getShoppingCartEntityList();
      paramInt2 = 0;
      if (paramInt2 < ((List)localObject).size())
      {
        if (((t)((List)localObject).get(paramInt2)).isChildSelect()) {
          YouPinShoppingCartActivity.n(YouPinShoppingCartActivity.this).add(Boolean.valueOf(true));
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          YouPinShoppingCartActivity.n(YouPinShoppingCartActivity.this).add(Boolean.valueOf(false));
        }
      }
      if (d.isAllCheck(YouPinShoppingCartActivity.n(YouPinShoppingCartActivity.this))) {
        ((v)YouPinShoppingCartActivity.d(YouPinShoppingCartActivity.this).get(paramInt1)).setGroupSelect(true);
      }
      for (;;)
      {
        YouPinShoppingCartActivity.h(YouPinShoppingCartActivity.this);
        YouPinShoppingCartActivity.i(YouPinShoppingCartActivity.this).notifyDataSetChanged();
        YouPinShoppingCartActivity.a(YouPinShoppingCartActivity.this, paramList);
        YouPinShoppingCartActivity.c(YouPinShoppingCartActivity.this, i);
        YouPinShoppingCartActivity.l(YouPinShoppingCartActivity.this).setText(YouPinShoppingCartActivity.k(YouPinShoppingCartActivity.this).format(YouPinShoppingCartActivity.j(YouPinShoppingCartActivity.this)) + "");
        YouPinShoppingCartActivity.m(YouPinShoppingCartActivity.this);
        return;
        ((v)YouPinShoppingCartActivity.d(YouPinShoppingCartActivity.this).get(paramInt1)).setGroupSelect(false);
      }
    }
    
    public void setGroupChanged(List<v> paramList, int paramInt)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        YouPinShoppingCartActivity.a(YouPinShoppingCartActivity.this, paramList);
        int i;
        if (((v)YouPinShoppingCartActivity.d(YouPinShoppingCartActivity.this).get(paramInt)).isGroupSelect())
        {
          YouPinShoppingCartActivity.a(YouPinShoppingCartActivity.this, paramInt);
          paramList = Double.valueOf(0.0D);
          i = 0;
          paramInt = 0;
        }
        for (;;)
        {
          if (paramInt >= YouPinShoppingCartActivity.d(YouPinShoppingCartActivity.this).size()) {
            break label232;
          }
          List localList = ((v)YouPinShoppingCartActivity.d(YouPinShoppingCartActivity.this).get(paramInt)).getShoppingCartEntityList();
          int j = 0;
          for (;;)
          {
            if (j < localList.size())
            {
              int k = i;
              Object localObject = paramList;
              if (((t)localList.get(j)).isChildSelect())
              {
                k = ((t)localList.get(j)).getAmount().intValue();
                localObject = ((t)localList.get(j)).getPrice();
                localObject = Double.valueOf(paramList.doubleValue() + ((Double)localObject).doubleValue() * k);
                k = i + k;
              }
              j += 1;
              i = k;
              paramList = (List<v>)localObject;
              continue;
              YouPinShoppingCartActivity.b(YouPinShoppingCartActivity.this, paramInt);
              break;
            }
          }
          paramInt += 1;
        }
        label232:
        YouPinShoppingCartActivity.h(YouPinShoppingCartActivity.this);
        YouPinShoppingCartActivity.i(YouPinShoppingCartActivity.this).notifyDataSetChanged();
        YouPinShoppingCartActivity.a(YouPinShoppingCartActivity.this, paramList);
        YouPinShoppingCartActivity.c(YouPinShoppingCartActivity.this, i);
        YouPinShoppingCartActivity.l(YouPinShoppingCartActivity.this).setText(YouPinShoppingCartActivity.k(YouPinShoppingCartActivity.this).format(YouPinShoppingCartActivity.j(YouPinShoppingCartActivity.this)) + "");
        YouPinShoppingCartActivity.m(YouPinShoppingCartActivity.this);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinShoppingCartActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */