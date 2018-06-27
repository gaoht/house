package com.ziroom.ziroomcustomer.bestgoods.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.a.b;
import com.ziroom.ziroomcustomer.bestgoods.a.am;
import com.ziroom.ziroomcustomer.bestgoods.a.am.a;
import com.ziroom.ziroomcustomer.bestgoods.activity.GoodsDetailAc;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinCommitOrderActivity;
import com.ziroom.ziroomcustomer.bestgoods.model.SKUMo;
import com.ziroom.ziroomcustomer.bestgoods.model.ak;
import com.ziroom.ziroomcustomer.bestgoods.model.ak.a;
import com.ziroom.ziroomcustomer.bestgoods.model.ak.a.a;
import com.ziroom.ziroomcustomer.bestgoods.model.ak.a.a.a;
import com.ziroom.ziroomcustomer.bestgoods.model.ak.a.a.a.a;
import com.ziroom.ziroomcustomer.bestgoods.model.aw;
import com.ziroom.ziroomcustomer.bestgoods.model.ax;
import com.ziroom.ziroomcustomer.bestgoods.model.o;
import com.ziroom.ziroomcustomer.bestgoods.model.t;
import com.ziroom.ziroomcustomer.bestgoods.model.v;
import com.ziroom.ziroomcustomer.bestgoods.model.w;
import com.ziroom.ziroomcustomer.bestgoods.model.x;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.af;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class d
  extends Dialog
{
  private String A = "";
  private String B = " ";
  private Context a;
  private RecyclerView b;
  private ListView c;
  private TextView d;
  private TextView e;
  private int f = 1;
  private int g = 9;
  private String h;
  private String i;
  private ak j;
  private List<ak.a> k;
  private List<ax> l = new ArrayList();
  private TextView m;
  private TextView n;
  private final List<x> o = new ArrayList();
  private List<com.ziroom.ziroomcustomer.bestgoods.model.aa> p = new ArrayList();
  private ArrayList<w> q = new ArrayList();
  private List<v> r = new ArrayList();
  private List<t> s = new ArrayList();
  private Map<String, List<t>> t = new HashMap();
  private String u = "";
  private aw v;
  private Double w = Double.valueOf(0.0D);
  private DecimalFormat x = new DecimalFormat("0.00");
  private a y;
  private String z = "";
  
  public d(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, 2131427591);
    this.a = paramContext;
    this.h = paramString1;
    this.i = paramString2;
    setCanceledOnTouchOutside(true);
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903865, null);
    this.m = ((TextView)localView.findViewById(2131690739));
    this.n = ((TextView)localView.findViewById(2131690743));
    this.b = ((RecyclerView)localView.findViewById(2131693908));
    this.c = ((ListView)localView.findViewById(2131693909));
    this.d = ((TextView)localView.findViewById(2131693906));
    this.e = ((TextView)localView.findViewById(2131693907));
    b();
    setContentView(localView);
  }
  
  private void b()
  {
    c();
  }
  
  private void c()
  {
    com.ziroom.ziroomcustomer.e.n.requestYouPinGroupPropertyList(this.a, this.h, new com.ziroom.ziroomcustomer.e.a.a(this.a, new m(ak.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, ak paramAnonymousak)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousak);
        if (paramAnonymousak != null)
        {
          d.a(d.this, paramAnonymousak);
          d.a(d.this, d.a(d.this).getList());
          d.b(d.this);
        }
      }
    });
  }
  
  private void d()
  {
    int i1;
    if ((this.k != null) && (!this.k.isEmpty()))
    {
      i1 = 0;
      while (i1 < this.k.size())
      {
        ((ak.a)this.k.get(i1)).setSkuCount(((ak.a)this.k.get(i1)).getAmount().intValue());
        ((ak.a)this.k.get(i1)).setSelect(true);
        localObject1 = ((ak.a)this.k.get(i1)).getPropertyList();
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          int i2 = 0;
          while (i2 < ((List)localObject1).size())
          {
            localObject2 = ((ak.a.a)((List)localObject1).get(i2)).getProperty().getPropertyList();
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              int i3 = 0;
              if (i3 < ((List)localObject2).size())
              {
                int i4;
                if (((ak.a.a.a.a)((List)localObject2).get(i3)).getChecked() == 1)
                {
                  i4 = ((ak.a.a.a.a)((List)localObject2).get(i3)).getAmount();
                  if (i4 <= 0) {
                    break label314;
                  }
                  if (i4 <= 9) {
                    break label276;
                  }
                  ((ak.a)this.k.get(i1)).setMaxAmount(9);
                  ((ak.a)this.k.get(i1)).setAmontBig(true);
                }
                for (;;)
                {
                  i3 += 1;
                  break;
                  label276:
                  ((ak.a)this.k.get(i1)).setMaxAmount(i4);
                  ((ak.a)this.k.get(i1)).setAmontBig(false);
                  continue;
                  label314:
                  ((ak.a)this.k.get(i1)).setMaxAmount(0);
                }
              }
            }
            i2 += 1;
          }
        }
        i1 += 1;
      }
    }
    Object localObject1 = this.j.getList();
    this.m.setText(this.i);
    Object localObject3;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      i1 = 0;
      if (i1 < ((List)localObject1).size())
      {
        localObject2 = ((ak.a)((List)localObject1).get(i1)).getPrice();
        localObject3 = ((ak.a)((List)localObject1).get(i1)).getActivityPrice();
        Integer localInteger = ((ak.a)((List)localObject1).get(i1)).getAmount();
        double d1;
        if (localObject3 == null)
        {
          if (localObject2 == null)
          {
            g.textToast(this.a, "数据异常，请稍后重试");
            return;
          }
          if (localInteger == null)
          {
            g.textToast(this.a, "数据异常，请稍后重试");
            return;
          }
          d1 = this.w.doubleValue();
        }
        for (this.w = Double.valueOf(((Double)localObject2).doubleValue() * localInteger.intValue() + d1);; this.w = Double.valueOf(((Double)localObject3).doubleValue() * localInteger.intValue() + d1))
        {
          i1 += 1;
          break;
          if (localInteger == null)
          {
            g.textToast(this.a, "数据异常，请稍后重试");
            return;
          }
          d1 = this.w.doubleValue();
        }
      }
      this.n.setText("￥" + this.x.format(this.w));
    }
    this.o.clear();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      i1 = 0;
      while (i1 < ((List)localObject1).size())
      {
        localObject2 = ((ak.a)((List)localObject1).get(i1)).getProductName();
        localObject3 = new x();
        ((x)localObject3).setProductName((String)localObject2);
        ((x)localObject3).setChosen(false);
        this.o.add(localObject3);
        i1 += 1;
      }
    }
    localObject1 = new am(this.a, this.o);
    Object localObject2 = new LinearLayoutManager(this.a, 0, false);
    this.b.setLayoutManager((RecyclerView.h)localObject2);
    this.b.setAdapter((RecyclerView.a)localObject1);
    this.y = new a();
    this.c.setAdapter(this.y);
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        d.c(d.this);
      }
    });
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        d.d(d.this);
      }
    });
    ((am)localObject1).setOnItemClickListener(new am.a()
    {
      public void itemClick(int paramAnonymousInt)
      {
        if ((d.e(d.this) != null) && (!d.e(d.this).isEmpty()) && (d.a(d.this) != null))
        {
          List localList = d.a(d.this).getList();
          if ((localList != null) && (!localList.isEmpty()))
          {
            int i = 0;
            while (i < localList.size())
            {
              String str = ((ak.a)localList.get(i)).getProductName();
              if (((x)d.e(d.this).get(paramAnonymousInt)).getProductName().equals(str)) {
                d.f(d.this).setSelection(paramAnonymousInt);
              }
              i += 1;
            }
          }
        }
      }
    });
  }
  
  private void e()
  {
    int i3 = 0;
    int i1 = 0;
    if (i1 < this.k.size()) {
      if (!"101020".equals(((ak.a)this.k.get(i1)).getCategoryCode())) {}
    }
    for (i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        String str = com.ziroom.ziroomcustomer.minsu.f.aa.getString(this.a, "currentYouPinCityCode", "");
        i1 = 0;
        label64:
        if (i1 >= com.ziroom.ziroomcustomer.bestgoods.a.getCityList().size()) {
          break label221;
        }
        if (!((b)com.ziroom.ziroomcustomer.bestgoods.a.getCityList().get(i1)).getCode().equals(str)) {}
      }
      label221:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0)
        {
          f();
          return;
          i1 += 1;
          break;
          i1 += 1;
          break label64;
        }
        i1 = 0;
        for (;;)
        {
          int i2 = i3;
          if (i1 < this.k.size())
          {
            if ("101020".equals(((ak.a)this.k.get(i1)).getCategoryCode())) {
              i2 = 1;
            }
          }
          else
          {
            if (i2 == 0) {
              break;
            }
            com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setContent("当前城市无家具库存，是否继续？").setOnConfirmClickListener(new c.b()
            {
              public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
              {
                if (paramAnonymousBoolean)
                {
                  paramAnonymousView = Double.valueOf(0.0D);
                  Object localObject1 = paramAnonymousView;
                  Object localObject3;
                  Object localObject4;
                  if (d.g(d.this) != null)
                  {
                    localObject1 = paramAnonymousView;
                    if (!d.g(d.this).isEmpty())
                    {
                      int j = 0;
                      if (j < d.g(d.this).size())
                      {
                        String str1;
                        String str2;
                        int n;
                        Double localDouble1;
                        Double localDouble2;
                        Object localObject5;
                        int k;
                        if ("101030".equals(((ak.a)d.g(d.this).get(j)).getCategoryCode()))
                        {
                          localObject1 = ((ak.a)d.g(d.this).get(j)).getProviderName();
                          localObject2 = ((ak.a)d.g(d.this).get(j)).getSkuImg();
                          localObject3 = ((ak.a)d.g(d.this).get(j)).getSkuName();
                          localObject4 = ((ak.a)d.g(d.this).get(j)).getSkuCode();
                          str1 = ((ak.a)d.g(d.this).get(j)).getProductName();
                          str2 = ((ak.a)d.g(d.this).get(j)).getProductCode();
                          n = ((ak.a)d.g(d.this).get(j)).getSkuCount();
                          localDouble1 = ((ak.a)d.g(d.this).get(j)).getPrice();
                          localDouble2 = ((ak.a)d.g(d.this).get(j)).getActivityPrice();
                          String str3 = ((ak.a)d.g(d.this).get(j)).getDeliveryMode();
                          localObject5 = ((ak.a)d.g(d.this).get(j)).getPropertyList();
                          i = 0;
                          k = 0;
                          while (k < ((List)localObject5).size())
                          {
                            int m = i;
                            if (((ak.a.a)((List)localObject5).get(k)).getChecked() == 1)
                            {
                              List localList = ((ak.a.a)((List)localObject5).get(k)).getProperty().getPropertyList();
                              m = 0;
                              while (m < localList.size())
                              {
                                if (((ak.a.a.a.a)localList.get(m)).getChecked() == 1)
                                {
                                  d.a(d.this, ((ak.a.a.a.a)localList.get(m)).getPropertyValueName());
                                  i = ((ak.a.a.a.a)localList.get(m)).getAmount();
                                }
                                m += 1;
                              }
                              m = i;
                            }
                            k += 1;
                            i = m;
                          }
                          if (TextUtils.isEmpty(d.h(d.this))) {
                            af.showToast(d.i(d.this), "请选择商品规格");
                          }
                          localObject5 = new t();
                          if (TextUtils.isEmpty(str3)) {
                            return;
                          }
                          k = Integer.parseInt(str3);
                          if (i != 0) {
                            break label683;
                          }
                          af.showToast(d.i(d.this), "库存不足");
                          ((t)localObject5).setAmount(Integer.valueOf(i));
                        }
                        for (;;)
                        {
                          ((t)localObject5).setChildSelect(true);
                          ((t)localObject5).setProviderName((String)localObject1);
                          ((t)localObject5).setUrl((String)localObject2);
                          ((t)localObject5).setName((String)localObject3);
                          ((t)localObject5).setSkuCode((String)localObject4);
                          ((t)localObject5).setProductName(str1);
                          ((t)localObject5).setProductCode(str2);
                          ((t)localObject5).setPrice(localDouble1);
                          ((t)localObject5).setActivityPrice(localDouble2);
                          ((t)localObject5).setShoppingCartCode("");
                          ((t)localObject5).setDeliveryMode(Integer.valueOf(k));
                          ((t)localObject5).setSpecificationName(d.h(d.this));
                          d.j(d.this).add(localObject5);
                          j += 1;
                          break;
                          label683:
                          if (n > i) {
                            ((t)localObject5).setAmount(Integer.valueOf(i));
                          } else {
                            ((t)localObject5).setAmount(Integer.valueOf(n));
                          }
                        }
                      }
                      int i = 0;
                      if (i < d.j(d.this).size())
                      {
                        localObject1 = ((t)d.j(d.this).get(i)).getPrice();
                        localObject2 = ((t)d.j(d.this).get(i)).getActivityPrice();
                        localObject3 = ((t)d.j(d.this).get(i)).getAmount();
                        double d;
                        if (localObject2 == null) {
                          d = paramAnonymousView.doubleValue();
                        }
                        for (paramAnonymousView = Double.valueOf(((Double)localObject1).doubleValue() * ((Integer)localObject3).intValue() + d);; paramAnonymousView = Double.valueOf(paramAnonymousView.doubleValue() + ((Double)localObject2).doubleValue() * ((Integer)localObject3).intValue()))
                        {
                          i += 1;
                          break;
                        }
                      }
                      localObject1 = paramAnonymousView;
                    }
                  }
                  d.k(d.this).clear();
                  paramAnonymousView = d.j(d.this).iterator();
                  while (paramAnonymousView.hasNext())
                  {
                    localObject2 = (t)paramAnonymousView.next();
                    localObject3 = (List)d.k(d.this).get(((t)localObject2).getProviderName());
                    if (localObject3 == null)
                    {
                      localObject3 = new ArrayList();
                      ((List)localObject3).add(localObject2);
                      d.k(d.this).put(((t)localObject2).getProviderName(), localObject3);
                    }
                    else
                    {
                      ((List)localObject3).add(localObject2);
                    }
                  }
                  d.l(d.this).clear();
                  paramAnonymousView = d.k(d.this).entrySet().iterator();
                  while (paramAnonymousView.hasNext())
                  {
                    localObject3 = (Map.Entry)paramAnonymousView.next();
                    localObject2 = (String)((Map.Entry)localObject3).getKey();
                    localObject3 = (List)((Map.Entry)localObject3).getValue();
                    localObject4 = new v();
                    ((v)localObject4).setProviderName((String)localObject2);
                    ((v)localObject4).setGroupSelect(true);
                    ((v)localObject4).setShoppingCartEntityList((List)localObject3);
                    d.l(d.this).add(localObject4);
                  }
                  paramAnonymousView = com.alibaba.fastjson.a.toJSONString(d.l(d.this));
                  Object localObject2 = new Intent(d.i(d.this), YouPinCommitOrderActivity.class);
                  ((Intent)localObject2).putExtra("selectedGoods", paramAnonymousView);
                  ((Intent)localObject2).putExtra("totalPrice", (Serializable)localObject1);
                  d.i(d.this).startActivity((Intent)localObject2);
                  d.this.dismiss();
                  return;
                }
                d.this.dismiss();
              }
            }).build().show();
            return;
          }
          i1 += 1;
        }
        f();
        return;
      }
    }
  }
  
  private void f()
  {
    if ((this.k != null) && (!this.k.isEmpty()))
    {
      int i1 = 0;
      int i3 = 0;
      while (i1 < this.k.size())
      {
        localObject = ((ak.a)this.k.get(i1)).getPropertyList();
        int i2 = 0;
        while (i2 < ((List)localObject).size())
        {
          List localList = ((ak.a.a)((List)localObject).get(i2)).getProperty().getPropertyList();
          int i4 = 0;
          while (i4 < localList.size())
          {
            i3 += ((ak.a.a.a.a)localList.get(i4)).getAmount();
            i4 += 1;
          }
          i2 += 1;
        }
        i1 += 1;
      }
      if (i3 == 0) {
        af.showToast(this.a, "物品库存不足");
      }
    }
    else
    {
      return;
    }
    Object localObject = ((ak.a)this.k.get(0)).getProductCode();
    com.ziroom.ziroomcustomer.e.n.addYouPinShoppingCartCheck(this.a, (String)localObject, new com.ziroom.ziroomcustomer.e.a.a(this.a, new m(String.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        paramAnonymousString = Double.valueOf(0.0D);
        Object localObject1 = paramAnonymousString;
        Object localObject3;
        Object localObject4;
        if (d.g(d.this) != null)
        {
          localObject1 = paramAnonymousString;
          if (!d.g(d.this).isEmpty())
          {
            int i = 0;
            if (i < d.g(d.this).size())
            {
              localObject1 = ((ak.a)d.g(d.this).get(i)).getProviderName();
              localObject2 = ((ak.a)d.g(d.this).get(i)).getSkuImg();
              localObject3 = ((ak.a)d.g(d.this).get(i)).getSkuName();
              localObject4 = ((ak.a)d.g(d.this).get(i)).getSkuCode();
              String str1 = ((ak.a)d.g(d.this).get(i)).getProductName();
              String str2 = ((ak.a)d.g(d.this).get(i)).getProductCode();
              int m = ((ak.a)d.g(d.this).get(i)).getSkuCount();
              Double localDouble1 = ((ak.a)d.g(d.this).get(i)).getPrice();
              Double localDouble2 = ((ak.a)d.g(d.this).get(i)).getActivityPrice();
              String str3 = ((ak.a)d.g(d.this).get(i)).getDeliveryMode();
              Object localObject5 = ((ak.a)d.g(d.this).get(i)).getPropertyList();
              paramAnonymousInt = 0;
              int j = 0;
              while (j < ((List)localObject5).size())
              {
                int k = paramAnonymousInt;
                if (((ak.a.a)((List)localObject5).get(j)).getChecked() == 1)
                {
                  List localList = ((ak.a.a)((List)localObject5).get(j)).getProperty().getPropertyList();
                  k = 0;
                  while (k < localList.size())
                  {
                    if (((ak.a.a.a.a)localList.get(k)).getChecked() == 1)
                    {
                      d.a(d.this, ((ak.a.a.a.a)localList.get(k)).getPropertyValueName());
                      paramAnonymousInt = ((ak.a.a.a.a)localList.get(k)).getAmount();
                    }
                    k += 1;
                  }
                  k = paramAnonymousInt;
                }
                j += 1;
                paramAnonymousInt = k;
              }
              if (TextUtils.isEmpty(d.h(d.this))) {
                af.showToast(this.b, "请选择商品规格");
              }
              localObject5 = new t();
              if (TextUtils.isEmpty(str3)) {
                return;
              }
              j = Integer.parseInt(str3);
              if (paramAnonymousInt == 0)
              {
                af.showToast(this.b, "库存不足");
                ((t)localObject5).setAmount(Integer.valueOf(paramAnonymousInt));
              }
              for (;;)
              {
                ((t)localObject5).setChildSelect(true);
                ((t)localObject5).setProviderName((String)localObject1);
                ((t)localObject5).setUrl((String)localObject2);
                ((t)localObject5).setName((String)localObject3);
                ((t)localObject5).setSkuCode((String)localObject4);
                ((t)localObject5).setProductName(str1);
                ((t)localObject5).setProductCode(str2);
                ((t)localObject5).setPrice(localDouble1);
                ((t)localObject5).setActivityPrice(localDouble2);
                ((t)localObject5).setShoppingCartCode("");
                ((t)localObject5).setDeliveryMode(Integer.valueOf(j));
                ((t)localObject5).setSpecificationName(d.h(d.this));
                d.j(d.this).add(localObject5);
                i += 1;
                break;
                if (m > paramAnonymousInt) {
                  ((t)localObject5).setAmount(Integer.valueOf(paramAnonymousInt));
                } else {
                  ((t)localObject5).setAmount(Integer.valueOf(m));
                }
              }
            }
            paramAnonymousInt = 0;
            if (paramAnonymousInt < d.j(d.this).size())
            {
              localObject1 = ((t)d.j(d.this).get(paramAnonymousInt)).getAmount();
              localObject2 = ((t)d.j(d.this).get(paramAnonymousInt)).getPrice();
              localObject3 = ((t)d.j(d.this).get(paramAnonymousInt)).getActivityPrice();
              double d1;
              double d2;
              if (localObject3 == null)
              {
                d1 = paramAnonymousString.doubleValue();
                d2 = ((Double)localObject2).doubleValue();
              }
              for (paramAnonymousString = Double.valueOf(((Integer)localObject1).intValue() * d2 + d1);; paramAnonymousString = Double.valueOf(((Integer)localObject1).intValue() * d2 + d1))
              {
                paramAnonymousInt += 1;
                break;
                d1 = paramAnonymousString.doubleValue();
                d2 = ((Double)localObject3).doubleValue();
              }
            }
            localObject1 = paramAnonymousString;
          }
        }
        d.k(d.this).clear();
        paramAnonymousString = d.j(d.this).iterator();
        while (paramAnonymousString.hasNext())
        {
          localObject2 = (t)paramAnonymousString.next();
          localObject3 = (List)d.k(d.this).get(((t)localObject2).getProviderName());
          if (localObject3 == null)
          {
            localObject3 = new ArrayList();
            ((List)localObject3).add(localObject2);
            d.k(d.this).put(((t)localObject2).getProviderName(), localObject3);
          }
          else
          {
            ((List)localObject3).add(localObject2);
          }
        }
        d.l(d.this).clear();
        paramAnonymousString = d.k(d.this).entrySet().iterator();
        while (paramAnonymousString.hasNext())
        {
          localObject3 = (Map.Entry)paramAnonymousString.next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (List)((Map.Entry)localObject3).getValue();
          localObject4 = new v();
          ((v)localObject4).setProviderName((String)localObject2);
          ((v)localObject4).setGroupSelect(true);
          ((v)localObject4).setShoppingCartEntityList((List)localObject3);
          d.l(d.this).add(localObject4);
        }
        paramAnonymousString = com.alibaba.fastjson.a.toJSONString(d.l(d.this));
        Object localObject2 = new Intent(this.b, YouPinCommitOrderActivity.class);
        ((Intent)localObject2).putExtra("selectedGoods", paramAnonymousString);
        ((Intent)localObject2).putExtra("totalPrice", (Serializable)localObject1);
        this.b.startActivity((Intent)localObject2);
        d.this.dismiss();
      }
    });
  }
  
  private void g()
  {
    int i2 = 0;
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      return;
    }
    this.u = ((UserInfo)localObject).getUid();
    int i1 = 0;
    label31:
    if (i1 < this.k.size()) {
      if (!"101020".equals(((ak.a)this.k.get(i1)).getCategoryCode())) {}
    }
    for (i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        localObject = com.ziroom.ziroomcustomer.minsu.f.aa.getString(this.a, "currentYouPinCityCode", "");
        i1 = 0;
        label90:
        if (i1 >= com.ziroom.ziroomcustomer.bestgoods.a.getCityList().size()) {
          break label247;
        }
        if (!((b)com.ziroom.ziroomcustomer.bestgoods.a.getCityList().get(i1)).getCode().equals(localObject)) {}
      }
      label151:
      label244:
      label247:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0)
        {
          h();
          return;
          i1 += 1;
          break label31;
          i1 += 1;
          break label90;
        }
        i1 = 0;
        if (i2 < this.k.size())
        {
          if (!"101020".equals(((ak.a)this.k.get(i2)).getCategoryCode())) {
            break label244;
          }
          i1 = 1;
        }
        for (;;)
        {
          i2 += 1;
          break label151;
          if (i1 == 0) {
            break;
          }
          com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setContent("当前城市无家具库存，是否继续？").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
            {
              int j;
              String str1;
              String str2;
              int n;
              int i;
              Object localObject1;
              List localList;
              int k;
              label186:
              Object localObject2;
              int m;
              if (paramAnonymousBoolean)
              {
                d.m(d.this).clear();
                if ((d.g(d.this) != null) && (!d.g(d.this).isEmpty()))
                {
                  j = 0;
                  if (j < d.g(d.this).size()) {
                    if ("101030".equals(((ak.a)d.g(d.this).get(j)).getCategoryCode()))
                    {
                      str1 = ((ak.a)d.g(d.this).get(j)).getSkuCode();
                      str2 = ((ak.a)d.g(d.this).get(j)).getProductCode();
                      n = ((ak.a)d.g(d.this).get(j)).getSkuCount();
                      i = 0;
                      localObject1 = "";
                      localList = ((ak.a)d.g(d.this).get(j)).getPropertyList();
                      k = 0;
                      if (k < localList.size())
                      {
                        localObject2 = ((ak.a.a)localList.get(k)).getProperty().getPropertyList();
                        m = 0;
                        paramAnonymousView = (View)localObject1;
                        label224:
                        if (m < ((List)localObject2).size())
                        {
                          if (((ak.a.a.a.a)((List)localObject2).get(m)).getChecked() != 1) {
                            break label662;
                          }
                          i = ((ak.a.a.a.a)((List)localObject2).get(m)).getAmount();
                          paramAnonymousView = ((ak.a.a.a.a)((List)localObject2).get(m)).getPropertyValueName();
                        }
                      }
                    }
                  }
                }
              }
              label323:
              label659:
              label662:
              for (;;)
              {
                m += 1;
                break label224;
                k += 1;
                localObject1 = paramAnonymousView;
                break label186;
                localObject2 = new ax();
                k = 0;
                paramAnonymousView = "";
                if (k < localList.size())
                {
                  if (((ak.a.a)localList.get(k)).getChecked() != 1) {
                    break label659;
                  }
                  paramAnonymousView = ((ak.a.a)localList.get(k)).getPropertyValueName();
                }
                for (;;)
                {
                  k += 1;
                  break label323;
                  if (i == 0)
                  {
                    af.showToast(d.i(d.this), paramAnonymousView + "-" + (String)localObject1 + "库存不足");
                    ((ax)localObject2).setAmount(Integer.valueOf(i));
                  }
                  for (;;)
                  {
                    ((ax)localObject2).setUid(d.n(d.this));
                    ((ax)localObject2).setSkuCode(str1);
                    ((ax)localObject2).setProductCode(str2);
                    ((ax)localObject2).setShoopingCartCode("");
                    ((ax)localObject2).setCityCode(com.ziroom.ziroomcustomer.minsu.f.aa.getString(d.i(d.this), "currentYouPinCityCode", "000000"));
                    d.m(d.this).add(localObject2);
                    j += 1;
                    break;
                    if (n > i) {
                      ((ax)localObject2).setAmount(Integer.valueOf(i));
                    } else {
                      ((ax)localObject2).setAmount(Integer.valueOf(n));
                    }
                  }
                  i = 0;
                  while (i < d.m(d.this).size())
                  {
                    if (((ax)d.m(d.this).get(i)).getAmount().intValue() == 0) {
                      d.m(d.this).remove(i);
                    }
                    i += 1;
                  }
                  com.ziroom.ziroomcustomer.e.n.addYouPinShoppingCart(d.i(d.this), d.m(d.this), new com.ziroom.ziroomcustomer.e.a.a(d.i(d.this), new m(aw.class, new e()))
                  {
                    public void onSuccess(int paramAnonymous2Int, aw paramAnonymous2aw)
                    {
                      super.onSuccess(paramAnonymous2Int, paramAnonymous2aw);
                      d.a(d.this, paramAnonymous2aw);
                      if (d.o(d.this) != null)
                      {
                        if (!d.o(d.this).getStatus().booleanValue()) {
                          break label70;
                        }
                        af.showToast(this.b, "已成功加入购物车");
                      }
                      for (;;)
                      {
                        d.this.dismiss();
                        return;
                        label70:
                        af.showToast(this.b, "物品达到最大数量");
                      }
                    }
                  });
                  return;
                  d.this.dismiss();
                  return;
                }
              }
            }
          }).build().show();
          return;
          h();
          return;
        }
      }
    }
  }
  
  private void h()
  {
    this.l.clear();
    int i1 = 0;
    int i3 = 0;
    while (i1 < this.k.size())
    {
      localObject = ((ak.a)this.k.get(i1)).getPropertyList();
      int i2 = 0;
      while (i2 < ((List)localObject).size())
      {
        List localList = ((ak.a.a)((List)localObject).get(i2)).getProperty().getPropertyList();
        int i4 = 0;
        while (i4 < localList.size())
        {
          i3 += ((ak.a.a.a.a)localList.get(i4)).getAmount();
          i4 += 1;
        }
        i2 += 1;
      }
      i1 += 1;
    }
    if (i3 == 0) {
      af.showToast(this.a, "物品库存不足");
    }
    while ((this.k == null) || (this.k.isEmpty())) {
      return;
    }
    Object localObject = ((ak.a)this.k.get(0)).getProductCode();
    com.ziroom.ziroomcustomer.e.n.addYouPinShoppingCartCheck(this.a, (String)localObject, new com.ziroom.ziroomcustomer.e.a.a(this.a, new m(String.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        int i;
        String str2;
        String str3;
        int m;
        String str1;
        List localList;
        int j;
        label142:
        Object localObject;
        int k;
        if ((d.g(d.this) != null) && (!d.g(d.this).isEmpty()))
        {
          i = 0;
          if (i < d.g(d.this).size())
          {
            str2 = ((ak.a)d.g(d.this).get(i)).getSkuCode();
            str3 = ((ak.a)d.g(d.this).get(i)).getProductCode();
            m = ((ak.a)d.g(d.this).get(i)).getSkuCount();
            paramAnonymousInt = 0;
            str1 = "";
            localList = ((ak.a)d.g(d.this).get(i)).getPropertyList();
            j = 0;
            if (j < localList.size())
            {
              localObject = ((ak.a.a)localList.get(j)).getProperty().getPropertyList();
              k = 0;
              paramAnonymousString = str1;
              label180:
              if (k < ((List)localObject).size())
              {
                if (((ak.a.a.a.a)((List)localObject).get(k)).getChecked() != 1) {
                  break label596;
                }
                paramAnonymousInt = ((ak.a.a.a.a)((List)localObject).get(k)).getAmount();
                paramAnonymousString = ((ak.a.a.a.a)((List)localObject).get(k)).getPropertyValueName();
              }
            }
          }
        }
        label279:
        label593:
        label596:
        for (;;)
        {
          k += 1;
          break label180;
          j += 1;
          str1 = paramAnonymousString;
          break label142;
          localObject = new ax();
          j = 0;
          paramAnonymousString = "";
          if (j < localList.size())
          {
            if (((ak.a.a)localList.get(j)).getChecked() != 1) {
              break label593;
            }
            paramAnonymousString = ((ak.a.a)localList.get(j)).getPropertyValueName();
          }
          for (;;)
          {
            j += 1;
            break label279;
            if (paramAnonymousInt == 0)
            {
              af.showToast(this.b, paramAnonymousString + "-" + str1 + "库存不足");
              ((ax)localObject).setAmount(Integer.valueOf(paramAnonymousInt));
            }
            for (;;)
            {
              ((ax)localObject).setUid(d.n(d.this));
              ((ax)localObject).setSkuCode(str2);
              ((ax)localObject).setProductCode(str3);
              ((ax)localObject).setShoopingCartCode("");
              ((ax)localObject).setCityCode(com.ziroom.ziroomcustomer.minsu.f.aa.getString(this.b, "currentYouPinCityCode", "000000"));
              d.m(d.this).add(localObject);
              i += 1;
              break;
              if (m > paramAnonymousInt) {
                ((ax)localObject).setAmount(Integer.valueOf(paramAnonymousInt));
              } else {
                ((ax)localObject).setAmount(Integer.valueOf(m));
              }
            }
            paramAnonymousInt = 0;
            while (paramAnonymousInt < d.m(d.this).size())
            {
              if (((ax)d.m(d.this).get(paramAnonymousInt)).getAmount().intValue() == 0) {
                d.m(d.this).remove(paramAnonymousInt);
              }
              paramAnonymousInt += 1;
            }
            com.ziroom.ziroomcustomer.e.n.addYouPinShoppingCart(this.b, d.m(d.this), new com.ziroom.ziroomcustomer.e.a.a(this.b, new m(aw.class, new e()))
            {
              public void onSuccess(int paramAnonymous2Int, aw paramAnonymous2aw)
              {
                super.onSuccess(paramAnonymous2Int, paramAnonymous2aw);
                d.a(d.this, paramAnonymous2aw);
                if (d.o(d.this) != null)
                {
                  if (!d.o(d.this).getStatus().booleanValue()) {
                    break label70;
                  }
                  af.showToast(this.b, "已成功加入购物车");
                }
                for (;;)
                {
                  d.this.dismiss();
                  return;
                  label70:
                  af.showToast(this.b, "物品达到最大数量");
                }
              }
            });
            return;
          }
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDefaultSetting()
  {
    Window localWindow = getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    localWindow.setWindowAnimations(2131427962);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    int i1 = j.getDisplayHeight(this.a);
    localLayoutParams.width = -1;
    localLayoutParams.height = (i1 - com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 108.0F));
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
  }
  
  public class a
    extends BaseAdapter
  {
    private List<o> b = new ArrayList();
    
    public a() {}
    
    private void a(final int paramInt1, final int paramInt2, final int paramInt3)
    {
      this.b.clear();
      String str1 = ((ak.a)d.g(d.this).get(paramInt3)).getProductCode();
      String str2 = ((ak.a.a)((ak.a)d.g(d.this).get(paramInt3)).getPropertyList().get(paramInt1)).getProperty().getPropertyCode();
      String str3 = ((ak.a.a.a.a)((ak.a.a)((ak.a)d.g(d.this).get(paramInt3)).getPropertyList().get(paramInt1)).getProperty().getPropertyList().get(paramInt2)).getPropertyValueCode();
      String str4 = ((ak.a)d.g(d.this).get(paramInt3)).getPropertyCode();
      String str5 = ((ak.a.a)((ak.a)d.g(d.this).get(paramInt3)).getPropertyList().get(paramInt1)).getPropertyValueCode();
      this.b.add(new o(str2, str3));
      this.b.add(new o(str4, str5));
      com.ziroom.ziroomcustomer.e.n.getYoupinSkuInfo(d.i(d.this), str1, this.b, new com.ziroom.ziroomcustomer.e.a.a(d.i(d.this), new m(SKUMo.class, new e()))
      {
        public void onSuccess(int paramAnonymousInt, SKUMo paramAnonymousSKUMo)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousSKUMo);
          if (paramAnonymousSKUMo != null)
          {
            ((ak.a)d.g(d.this).get(paramInt3)).setAmount(Integer.valueOf(1));
            ((ak.a)d.g(d.this).get(paramInt3)).setSkuCount(1);
            ((ak.a)d.g(d.this).get(paramInt3)).setSkuCode(paramAnonymousSKUMo.getSkuCode());
            Double localDouble1 = paramAnonymousSKUMo.getPrice();
            Double localDouble2 = paramAnonymousSKUMo.getActivityPrice();
            ((ak.a)d.g(d.this).get(paramInt3)).setPrice(localDouble1);
            ((ak.a)d.g(d.this).get(paramInt3)).setActivityPrice(localDouble2);
            ((ak.a)d.g(d.this).get(paramInt3)).setSkuName(paramAnonymousSKUMo.getSkuName());
            ((ak.a)d.g(d.this).get(paramInt3)).setSkuCode(paramAnonymousSKUMo.getSkuCode());
            ((ak.a)d.g(d.this).get(paramInt3)).setSkuImg(paramAnonymousSKUMo.getSkuImg());
            paramAnonymousInt = paramAnonymousSKUMo.getAmount();
            ((ak.a.a.a.a)((ak.a.a)((ak.a)d.g(d.this).get(paramInt3)).getPropertyList().get(paramInt1)).getProperty().getPropertyList().get(paramInt2)).setAmount(paramAnonymousInt);
            if (paramAnonymousInt <= 0) {
              break label453;
            }
            if (paramAnonymousInt <= 9) {
              break label398;
            }
            ((ak.a)d.g(d.this).get(paramInt3)).setMaxAmount(9);
            ((ak.a)d.g(d.this).get(paramInt3)).setAmontBig(true);
          }
          for (;;)
          {
            d.a(d.this, Double.valueOf(0.0D));
            d.b(d.this);
            return;
            label398:
            ((ak.a)d.g(d.this).get(paramInt3)).setMaxAmount(paramAnonymousInt);
            ((ak.a)d.g(d.this).get(paramInt3)).setAmontBig(false);
            continue;
            label453:
            ((ak.a)d.g(d.this).get(paramInt3)).setMaxAmount(0);
          }
        }
      });
    }
    
    private void a(FlowLayout paramFlowLayout, int paramInt)
    {
      paramInt = 0;
      while (paramInt < paramFlowLayout.getChildCount())
      {
        TextView localTextView = (TextView)paramFlowLayout.getChildAt(paramInt);
        int i = 0;
        while (i < d.q(d.this).size())
        {
          if ((((com.ziroom.ziroomcustomer.bestgoods.model.aa)d.q(d.this).get(i)).getChecked() == 1) && (((com.ziroom.ziroomcustomer.bestgoods.model.aa)d.q(d.this).get(i)).getStyleName().equals(localTextView.getText().toString())))
          {
            localTextView.setBackgroundResource(2130840004);
            localTextView.setTextColor(40960);
          }
          i += 1;
        }
        paramInt += 1;
      }
    }
    
    private void a(String paramString, final FlowLayout paramFlowLayout, final int paramInt)
    {
      TextView localTextView = new TextView(d.i(d.this));
      localTextView.setText(paramString);
      localTextView.setTag(Boolean.valueOf(false));
      localTextView.setTextColor(-6710887);
      localTextView.setTextSize(12.0F);
      int i = com.ziroom.ziroomcustomer.util.n.dip2px(d.i(d.this), 12.0F);
      localTextView.setPadding(i, i, i, i);
      localTextView.setBackgroundResource(2130840000);
      paramString = new LinearLayout.LayoutParams(-2, -2);
      paramString.setMargins(0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(d.i(d.this), 10.0F), com.ziroom.ziroomcustomer.util.n.dip2px(d.i(d.this), 10.0F));
      localTextView.setLayoutParams(paramString);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = 0;
          if (i < paramFlowLayout.getChildCount())
          {
            TextView localTextView = (TextView)paramFlowLayout.getChildAt(i);
            List localList;
            int j;
            if (localTextView == paramAnonymousView)
            {
              localList = ((ak.a)d.g(d.this).get(paramInt)).getPropertyList();
              j = 0;
              while (j < localList.size())
              {
                if (((ak.a.a)localList.get(j)).getChecked() == 1)
                {
                  ((ak.a.a.a.a)((ak.a.a)localList.get(j)).getProperty().getPropertyList().get(i)).setChecked(1);
                  d.a.a(d.a.this, j, i, paramInt);
                }
                j += 1;
              }
              localTextView.setBackgroundResource(2130840004);
              localTextView.setTextColor(40960);
            }
            for (;;)
            {
              i += 1;
              break;
              localList = ((ak.a)d.g(d.this).get(paramInt)).getPropertyList();
              j = 0;
              while (j < localList.size())
              {
                if (((ak.a.a)localList.get(j)).getChecked() == 1) {
                  ((ak.a.a.a.a)((ak.a.a)localList.get(j)).getProperty().getPropertyList().get(i)).setChecked(0);
                }
                j += 1;
              }
              localTextView.setBackgroundResource(2130840000);
              localTextView.setTextColor(-6710887);
            }
          }
        }
      });
      paramFlowLayout.addView(localTextView);
    }
    
    private void a(String paramString, final FlowLayout paramFlowLayout1, FlowLayout paramFlowLayout2, final int paramInt)
    {
      paramFlowLayout2 = new TextView(d.i(d.this));
      paramFlowLayout2.setText(paramString);
      paramFlowLayout2.setTag(Boolean.valueOf(false));
      paramFlowLayout2.setTextColor(-6710887);
      paramFlowLayout2.setTextSize(12.0F);
      int i = com.ziroom.ziroomcustomer.util.n.dip2px(d.i(d.this), 12.0F);
      paramFlowLayout2.setPadding(i, i, i, i);
      paramFlowLayout2.setBackgroundResource(2130840000);
      paramString = new LinearLayout.LayoutParams(-2, -2);
      paramString.setMargins(0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(d.i(d.this), 10.0F), com.ziroom.ziroomcustomer.util.n.dip2px(d.i(d.this), 10.0F));
      paramFlowLayout2.setLayoutParams(paramString);
      paramFlowLayout2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ak.a locala = (ak.a)d.g(d.this).get(paramInt);
          int i = 0;
          while (i < paramFlowLayout1.getChildCount())
          {
            if ((TextView)paramFlowLayout1.getChildAt(i) == paramAnonymousView)
            {
              d.r(d.this).clear();
              ((ak.a.a)locala.getPropertyList().get(i)).setChecked(1);
              int j = 0;
              while (j < ((ak.a.a)locala.getPropertyList().get(i)).getProperty().getPropertyList().size())
              {
                w localw = new w();
                localw.setAmount(((ak.a.a.a.a)((ak.a.a)locala.getPropertyList().get(i)).getProperty().getPropertyList().get(j)).getAmount());
                localw.setPropertyValueName(((ak.a.a.a.a)((ak.a.a)locala.getPropertyList().get(i)).getProperty().getPropertyList().get(j)).getPropertyValueName());
                localw.setChecked(((ak.a.a.a.a)((ak.a.a)locala.getPropertyList().get(i)).getProperty().getPropertyList().get(j)).getChecked());
                localw.setPropertyValueCode(((ak.a.a.a.a)((ak.a.a)locala.getPropertyList().get(i)).getProperty().getPropertyList().get(j)).getPropertyValueCode());
                d.r(d.this).add(localw);
                j += 1;
              }
            }
            ((ak.a.a)locala.getPropertyList().get(i)).setChecked(0);
            d.t(d.this).notifyDataSetChanged();
            i += 1;
          }
        }
      });
      paramFlowLayout1.addView(paramFlowLayout2);
    }
    
    private void b(FlowLayout paramFlowLayout, int paramInt)
    {
      paramInt = 0;
      while (paramInt < paramFlowLayout.getChildCount())
      {
        TextView localTextView = (TextView)paramFlowLayout.getChildAt(paramInt);
        int i = 0;
        while (i < d.r(d.this).size())
        {
          if ((((w)d.r(d.this).get(i)).getChecked() == 1) && (((w)d.r(d.this).get(i)).getPropertyValueName().equals(localTextView.getText().toString())))
          {
            localTextView.setBackgroundResource(2130840004);
            localTextView.setTextColor(40960);
          }
          i += 1;
        }
        paramInt += 1;
      }
    }
    
    public int getCount()
    {
      if (d.g(d.this) == null) {
        return 0;
      }
      return d.g(d.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return d.g(d.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      label281:
      Object localObject2;
      if (paramView == null)
      {
        paramView = View.inflate(d.i(d.this), 2130904584, null);
        paramViewGroup = new a();
        paramViewGroup.l = ((RelativeLayout)paramView.findViewById(2131695823));
        paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131693911));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131693912));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131693913));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131693914));
        paramViewGroup.e = ((FlowLayout)paramView.findViewById(2131693915));
        paramViewGroup.f = ((FlowLayout)paramView.findViewById(2131690332));
        paramViewGroup.g = ((RelativeLayout)paramView.findViewById(2131693916));
        paramViewGroup.h = ((ImageView)paramView.findViewById(2131691434));
        paramViewGroup.i = ((RelativeLayout)paramView.findViewById(2131693917));
        paramViewGroup.j = ((ImageView)paramView.findViewById(2131691436));
        paramViewGroup.k = ((TextView)paramView.findViewById(2131693918));
        paramView.setTag(paramViewGroup);
        paramViewGroup.l.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(d.i(d.this), GoodsDetailAc.class);
            paramAnonymousView.putExtra("productCode", ((ak.a)d.g(d.this).get(paramInt)).getProductCode());
            paramAnonymousView.putExtra("skuCode", ((ak.a)d.g(d.this).get(paramInt)).getSkuCode());
            d.i(d.this).startActivity(paramAnonymousView);
          }
        });
        if (paramViewGroup.a.getTag() != null) {
          break label811;
        }
        paramViewGroup.a.setTag(((ak.a)d.g(d.this).get(paramInt)).getSkuImg());
        paramViewGroup.a.setController(com.freelxl.baselibrary.f.c.frescoController(((ak.a)d.g(d.this).get(paramInt)).getSkuImg()));
        paramViewGroup.b.setText(((ak.a)d.g(d.this).get(paramInt)).getSkuName());
        localObject1 = ((ak.a)d.g(d.this).get(paramInt)).getPrice();
        localObject2 = ((ak.a)d.g(d.this).get(paramInt)).getActivityPrice();
        if (localObject2 != null) {
          break label901;
        }
        paramViewGroup.c.setText("￥" + d.p(d.this).format(localObject1));
        label392:
        paramViewGroup.e.removeAllViews();
        paramViewGroup.f.removeAllViews();
        d.q(d.this).clear();
        d.r(d.this).clear();
        localObject1 = (ak.a)d.g(d.this).get(paramInt);
        i = 0;
      }
      for (;;)
      {
        if (i >= ((ak.a)localObject1).getPropertyList().size()) {
          break label951;
        }
        localObject2 = new com.ziroom.ziroomcustomer.bestgoods.model.aa();
        ((com.ziroom.ziroomcustomer.bestgoods.model.aa)localObject2).setStyleName(((ak.a.a)((ak.a)localObject1).getPropertyList().get(i)).getPropertyValueName());
        ((com.ziroom.ziroomcustomer.bestgoods.model.aa)localObject2).setChecked(((ak.a.a)((ak.a)localObject1).getPropertyList().get(i)).getChecked());
        ((com.ziroom.ziroomcustomer.bestgoods.model.aa)localObject2).setStyleCode(((ak.a.a)((ak.a)localObject1).getPropertyList().get(i)).getPropertyValueCode());
        d.q(d.this).add(localObject2);
        if (((ak.a.a)((ak.a)localObject1).getPropertyList().get(i)).getChecked() == 1)
        {
          j = 0;
          for (;;)
          {
            if (j < ((ak.a.a)((ak.a)localObject1).getPropertyList().get(i)).getProperty().getPropertyList().size())
            {
              localObject2 = new w();
              ((w)localObject2).setAmount(((ak.a.a.a.a)((ak.a.a)((ak.a)localObject1).getPropertyList().get(i)).getProperty().getPropertyList().get(j)).getAmount());
              ((w)localObject2).setPropertyValueName(((ak.a.a.a.a)((ak.a.a)((ak.a)localObject1).getPropertyList().get(i)).getProperty().getPropertyList().get(j)).getPropertyValueName());
              ((w)localObject2).setChecked(((ak.a.a.a.a)((ak.a.a)((ak.a)localObject1).getPropertyList().get(i)).getProperty().getPropertyList().get(j)).getChecked());
              ((w)localObject2).setPropertyValueCode(((ak.a.a.a.a)((ak.a.a)((ak.a)localObject1).getPropertyList().get(i)).getProperty().getPropertyList().get(j)).getPropertyValueCode());
              d.r(d.this).add(localObject2);
              j += 1;
              continue;
              paramViewGroup = (a)paramView.getTag();
              break;
              label811:
              if (paramViewGroup.a.getTag().equals(((ak.a)d.g(d.this).get(paramInt)).getSkuImg())) {
                break label281;
              }
              paramViewGroup.a.setTag(((ak.a)d.g(d.this).get(paramInt)).getSkuImg());
              paramViewGroup.a.setController(com.freelxl.baselibrary.f.c.frescoController(((ak.a)d.g(d.this).get(paramInt)).getSkuImg()));
              break label281;
              label901:
              paramViewGroup.c.setText("￥" + d.p(d.this).format(localObject2));
              break label392;
            }
          }
        }
        i += 1;
      }
      label951:
      Object localObject1 = d.q(d.this).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a(((com.ziroom.ziroomcustomer.bestgoods.model.aa)((Iterator)localObject1).next()).getStyleName(), paramViewGroup.e, paramViewGroup.f, paramInt);
      }
      a(paramViewGroup.e, paramInt);
      localObject1 = d.r(d.this).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a(((w)((Iterator)localObject1).next()).getPropertyValueName(), paramViewGroup.f, paramInt);
      }
      b(paramViewGroup.f, paramInt);
      int i = ((ak.a)d.g(d.this).get(paramInt)).getAmount().intValue();
      ((ak.a)d.g(d.this).get(paramInt)).setAmount(Integer.valueOf(i));
      final int j = ((ak.a)d.g(d.this).get(paramInt)).getMaxAmount();
      if (i < j) {
        if (i == 1)
        {
          paramViewGroup.h.setImageResource(2130840252);
          if (j == 1) {
            paramViewGroup.j.setImageResource(2130840246);
          }
        }
      }
      for (;;)
      {
        paramViewGroup.k.setText(i + "");
        paramViewGroup.g.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (j == 0)
            {
              g.textToast(d.i(d.this), "库存不足");
              return;
            }
            int i = ((ak.a)d.g(d.this).get(paramInt)).getAmount().intValue();
            if (i == 1)
            {
              ((ak.a)d.g(d.this).get(paramInt)).setAmount(Integer.valueOf(i));
              ((ak.a)d.g(d.this).get(paramInt)).setSkuCount(i);
              g.textToast(d.i(d.this), "最小数量为1");
              return;
            }
            label217:
            Double localDouble1;
            Double localDouble2;
            Integer localInteger;
            double d;
            if (i > j)
            {
              i = j;
              ((ak.a)d.g(d.this).get(paramInt)).setAmount(Integer.valueOf(i));
              ((ak.a)d.g(d.this).get(paramInt)).setSkuCount(i);
              paramAnonymousView = Double.valueOf(0.0D);
              i = 0;
              if (i >= d.g(d.this).size()) {
                break label439;
              }
              localDouble1 = ((ak.a)d.g(d.this).get(i)).getPrice();
              localDouble2 = ((ak.a)d.g(d.this).get(i)).getActivityPrice();
              localInteger = ((ak.a)d.g(d.this).get(i)).getAmount();
              if (localDouble2 != null) {
                break label415;
              }
              d = paramAnonymousView.doubleValue();
            }
            label415:
            for (paramAnonymousView = Double.valueOf(localDouble1.doubleValue() * localInteger.intValue() + d);; paramAnonymousView = Double.valueOf(paramAnonymousView.doubleValue() + localDouble2.doubleValue() * localInteger.intValue()))
            {
              i += 1;
              break label217;
              i -= 1;
              ((ak.a)d.g(d.this).get(paramInt)).setAmount(Integer.valueOf(i));
              ((ak.a)d.g(d.this).get(paramInt)).setSkuCount(i);
              break;
            }
            label439:
            d.s(d.this).setText("￥" + d.p(d.this).format(paramAnonymousView));
            d.a.this.notifyDataSetChanged();
          }
        });
        paramViewGroup.i.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (j == 0)
            {
              g.textToast(d.i(d.this), "库存不足");
              return;
            }
            int i = ((ak.a)d.g(d.this).get(paramInt)).getAmount().intValue();
            if (i == j)
            {
              ((ak.a)d.g(d.this).get(paramInt)).setAmount(Integer.valueOf(i));
              ((ak.a)d.g(d.this).get(paramInt)).setSkuCount(i);
              if (((ak.a)d.g(d.this).get(paramInt)).isAmontBig())
              {
                g.textToast(d.i(d.this), "已达物品最大数量");
                return;
              }
              g.textToast(d.i(d.this), "库存不足");
              return;
            }
            i += 1;
            ((ak.a)d.g(d.this).get(paramInt)).setAmount(Integer.valueOf(i));
            ((ak.a)d.g(d.this).get(paramInt)).setSkuCount(i);
            paramAnonymousView = Double.valueOf(0.0D);
            i = 0;
            if (i < d.g(d.this).size())
            {
              Double localDouble1 = ((ak.a)d.g(d.this).get(i)).getPrice();
              Double localDouble2 = ((ak.a)d.g(d.this).get(i)).getActivityPrice();
              Integer localInteger = ((ak.a)d.g(d.this).get(i)).getAmount();
              double d;
              if (localDouble2 == null) {
                d = paramAnonymousView.doubleValue();
              }
              for (paramAnonymousView = Double.valueOf(localDouble1.doubleValue() * localInteger.intValue() + d);; paramAnonymousView = Double.valueOf(paramAnonymousView.doubleValue() + localDouble2.doubleValue() * localInteger.intValue()))
              {
                i += 1;
                break;
              }
            }
            d.s(d.this).setText("￥" + d.p(d.this).format(paramAnonymousView));
            d.a.this.notifyDataSetChanged();
          }
        });
        return paramView;
        paramViewGroup.j.setImageResource(2130840245);
        continue;
        paramViewGroup.h.setImageResource(2130840251);
        paramViewGroup.j.setImageResource(2130840245);
        continue;
        paramViewGroup.h.setImageResource(2130840251);
        paramViewGroup.j.setImageResource(2130840246);
      }
    }
    
    public class a
    {
      public SimpleDraweeView a;
      public TextView b;
      public TextView c;
      public TextView d;
      public FlowLayout e;
      public FlowLayout f;
      public RelativeLayout g;
      public ImageView h;
      public RelativeLayout i;
      public ImageView j;
      public TextView k;
      public RelativeLayout l;
      
      public a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/dialog/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */