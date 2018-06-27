package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.b.r;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.bestgoods.a.h;
import com.ziroom.ziroomcustomer.bestgoods.a.h.b;
import com.ziroom.ziroomcustomer.bestgoods.model.SKUMo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ShoppingCartAc
  extends BaseActivity
  implements View.OnClickListener, h.b
{
  private Context a;
  private int b = 888;
  private ImageView c;
  private ImageView d;
  private RecyclerView e;
  private h f;
  private LinearLayout g;
  private LinearLayout r;
  private TextView s;
  private TextView t;
  private List<SKUMo> u;
  private ArrayList<SKUMo> v;
  private double w;
  private double x;
  private boolean y = true;
  
  private void a()
  {
    this.c = ((ImageView)findViewById(2131689492));
    this.d = ((ImageView)findViewById(2131692404));
    this.e = ((RecyclerView)findViewById(2131692402));
    this.e.setLayoutManager(new LinearLayoutManager(this, 1, false));
    this.g = ((LinearLayout)findViewById(2131692403));
    this.r = ((LinearLayout)findViewById(2131689998));
    this.s = ((TextView)findViewById(2131692405));
    this.t = ((TextView)findViewById(2131689996));
    this.f = new h(this.a, null);
    this.e.setAdapter(this.f);
  }
  
  private void b()
  {
    this.f.setOnSelectGoodsListener(this);
    this.g.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.s.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    if (paramInt > 0)
    {
      this.s.setText("结算（" + paramInt + "）");
      this.s.setBackgroundResource(2131624516);
      this.s.setClickable(true);
      return;
    }
    this.s.setText("结算（" + paramInt + "）");
    this.s.setBackgroundResource(2131624042);
    this.s.setClickable(false);
  }
  
  private void c(final int paramInt)
  {
    c.newBuilder(this.a).setTitle("提示").setContent("您确定删除此物品么？").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          r.delete(ShoppingCartAc.a(ShoppingCartAc.this), (SKUMo)ShoppingCartAc.b(ShoppingCartAc.this).get(paramInt));
          ShoppingCartAc.b(ShoppingCartAc.this).remove(paramInt);
          if ((ShoppingCartAc.b(ShoppingCartAc.this) == null) || (ShoppingCartAc.b(ShoppingCartAc.this).size() == 0)) {
            ShoppingCartAc.this.showEmpty(ShoppingCartAc.c(ShoppingCartAc.this), "购物车暂无商品，赶快去添加吧~");
          }
          ShoppingCartAc.d(ShoppingCartAc.this).notifyDataSetChanged();
          ShoppingCartAc.d(ShoppingCartAc.this).getAllSelectedGoods(null, "");
        }
      }
    }).build().show();
  }
  
  private void e()
  {
    this.u = r.getSKUs(this.a, b.d);
    if ((this.u == null) || (this.u.size() == 0)) {
      showEmpty(this.r, "购物车暂无商品，赶快去添加吧~");
    }
    for (;;)
    {
      this.f.setData(this.u);
      this.f.getAllSelectedGoods(null, "");
      this.f.notifyDataSetChanged();
      return;
      Collections.reverse(this.u);
    }
  }
  
  public void getSelectedGoods(ArrayList<SKUMo> paramArrayList, double paramDouble1, double paramDouble2)
  {
    int i = paramArrayList.size();
    if (this.u.size() == i)
    {
      this.y = true;
      this.d.setImageResource(2130838895);
    }
    for (;;)
    {
      b(i);
      this.w = paramDouble1;
      this.x = paramDouble2;
      this.t.setText(String.format("%.2f", new Object[] { Double.valueOf(paramDouble1) }));
      this.v = paramArrayList;
      return;
      this.y = false;
      this.d.setImageResource(2130838169);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == this.b) && (paramInt2 == -1)) {
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
    case 2131689492: 
    case 2131692403: 
      do
      {
        return;
        finish();
        return;
      } while ((this.u == null) || (this.u.size() <= 0));
      boolean bool;
      if (!this.y)
      {
        bool = true;
        this.y = bool;
        if (!this.y) {
          break label142;
        }
        this.d.setImageResource(2130838895);
      }
      for (;;)
      {
        paramView = this.u.iterator();
        while (paramView.hasNext()) {
          ((SKUMo)paramView.next()).setChecked(this.y);
        }
        bool = false;
        break;
        label142:
        this.d.setImageResource(2130838169);
      }
      this.f.getAllSelectedGoods(null, "");
      return;
    }
    if (ApplicationEx.c.isLoginState())
    {
      paramView = new Intent(this.a, ConfirmOrderAc.class);
      paramView.putParcelableArrayListExtra("selectedGoods", this.v);
      paramView.putExtra("totalPrice", this.w);
      paramView.putExtra("freightCost", this.x);
      startActivityForResult(paramView, this.b);
      return;
    }
    a.startLoginActivity(this.a);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903494);
    this.a = this;
    a();
    b();
    e();
  }
  
  protected void onPause()
  {
    super.onPause();
    r.updataGoodsCount(this.a, this.u);
  }
  
  public void removeGoods(int paramInt)
  {
    c(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/ShoppingCartAc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */