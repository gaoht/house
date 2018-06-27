package com.ziroom.ziroomcustomer.bestgoods.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.a.b;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinCommitOrderActivity;
import com.ziroom.ziroomcustomer.bestgoods.model.SKUMo;
import com.ziroom.ziroomcustomer.bestgoods.model.ad;
import com.ziroom.ziroomcustomer.bestgoods.model.aw;
import com.ziroom.ziroomcustomer.bestgoods.model.ax;
import com.ziroom.ziroomcustomer.bestgoods.model.j;
import com.ziroom.ziroomcustomer.bestgoods.model.o;
import com.ziroom.ziroomcustomer.bestgoods.model.p;
import com.ziroom.ziroomcustomer.bestgoods.model.t;
import com.ziroom.ziroomcustomer.bestgoods.model.v;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.w;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.af;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
  extends Dialog
{
  private Double A;
  private aw B;
  private String C = "";
  private Double D;
  private FlowLayout E;
  private List<p> F;
  private String G;
  private String H;
  private String I = "";
  private boolean J = false;
  private String K;
  List<o> a = new ArrayList();
  private Context b;
  private SimpleDraweeView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private FlowLayout g;
  private RelativeLayout h;
  private ImageView i;
  private RelativeLayout j;
  private ImageView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private int o = 1;
  private int p = 0;
  private List<w> q = new ArrayList();
  private List<w> r = new ArrayList();
  private a s;
  private j t;
  private Map<String, Object> u = new HashMap();
  private String v;
  private String w;
  private List<ax> x = new ArrayList();
  private List<v> y = new ArrayList();
  private List<t> z = new ArrayList();
  
  public c(Context paramContext, j paramj, Map<String, Object> paramMap)
  {
    super(paramContext, 2131427591);
    this.b = paramContext;
    this.t = paramj;
    this.u = paramMap;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.b).inflate(2130903868, null);
    this.c = ((SimpleDraweeView)localView.findViewById(2131693911));
    this.d = ((TextView)localView.findViewById(2131693912));
    this.e = ((TextView)localView.findViewById(2131693913));
    this.f = ((TextView)localView.findViewById(2131693914));
    this.E = ((FlowLayout)localView.findViewById(2131693915));
    this.g = ((FlowLayout)localView.findViewById(2131690332));
    this.h = ((RelativeLayout)localView.findViewById(2131693916));
    this.i = ((ImageView)localView.findViewById(2131691434));
    this.j = ((RelativeLayout)localView.findViewById(2131693917));
    this.k = ((ImageView)localView.findViewById(2131691436));
    this.l = ((TextView)localView.findViewById(2131693918));
    this.m = ((TextView)localView.findViewById(2131693919));
    this.n = ((TextView)localView.findViewById(2131693907));
    b();
    setContentView(localView);
  }
  
  private void a(final int paramInt)
  {
    com.ziroom.ziroomcustomer.e.n.addYouPinShoppingCartCheck(this.b, this.v, new com.ziroom.ziroomcustomer.e.a.a(this.b, new m(String.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        if (paramInt > 0) {}
        for (paramAnonymousInt = c.n(c.this);; paramAnonymousInt = 0)
        {
          paramAnonymousString = new ax();
          paramAnonymousString.setSkuCode(c.m(c.this));
          paramAnonymousString.setAmount(Integer.valueOf(paramAnonymousInt));
          paramAnonymousString.setProductCode(c.l(c.this));
          paramAnonymousString.setUid(c.u(c.this));
          paramAnonymousString.setCityCode(aa.getString(c.t(c.this), "currentYouPinCityCode", "000000"));
          if ((c.v(c.this) != null) && (!c.v(c.this).isEmpty())) {
            c.v(c.this).clear();
          }
          if (paramAnonymousInt == 0) {
            break;
          }
          c.v(c.this).add(paramAnonymousString);
          com.ziroom.ziroomcustomer.e.n.addYouPinShoppingCart(c.t(c.this), c.v(c.this), new com.ziroom.ziroomcustomer.e.a.a(c.t(c.this), new m(aw.class, new e()))
          {
            public void onSuccess(int paramAnonymous2Int, aw paramAnonymous2aw)
            {
              super.onSuccess(paramAnonymous2Int, paramAnonymous2aw);
              c.a(c.this, paramAnonymous2aw);
              if (c.w(c.this) != null)
              {
                if (!c.w(c.this).getStatus().booleanValue()) {
                  break label76;
                }
                af.showToast(c.t(c.this), "已成功加入购物车");
              }
              for (;;)
              {
                c.this.dismiss();
                return;
                label76:
                af.showToast(c.t(c.this), "物品达到最大数量");
              }
            }
          });
          return;
        }
        af.showToast(c.t(c.this), "库存不足");
      }
    });
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.a.clear();
    String str1 = (String)this.u.get("productCode");
    String str2 = ((p)this.t.getPropertyList().get(paramInt1)).getProperty().getPropertyCode();
    String str3 = ((com.ziroom.ziroomcustomer.bestgoods.model.ac)((p)this.t.getPropertyList().get(paramInt1)).getProperty().getPropertyList().get(paramInt2)).getPropertyValueCode();
    String str4 = this.t.getPropertyCode();
    String str5 = ((p)this.t.getPropertyList().get(paramInt1)).getPropertyValueCode();
    this.a.add(new o(str2, str3));
    this.a.add(new o(str4, str5));
    com.ziroom.ziroomcustomer.e.n.getYoupinSkuInfo(this.b, str1, this.a, new com.ziroom.ziroomcustomer.e.a.a(this.b, new m(SKUMo.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, SKUMo paramAnonymousSKUMo)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousSKUMo);
        if (paramAnonymousSKUMo != null)
        {
          if (paramAnonymousSKUMo.getAmount() <= 9) {
            break label224;
          }
          c.a(c.this, 9);
          if (c.y(c.this) <= 0) {
            break label239;
          }
          c.c(c.this, 1);
          c.z(c.this).setText("1");
          c.A(c.this).setBackgroundResource(2130840252);
          c.B(c.this).setBackgroundResource(2130840245);
        }
        for (;;)
        {
          c.C(c.this).setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousSKUMo.getSkuImg()));
          c.a(c.this, paramAnonymousSKUMo.getSkuName());
          c.D(c.this).setText(paramAnonymousSKUMo.getSkuName());
          c.E(c.this).setText("¥" + String.format("%.2f", new Object[] { paramAnonymousSKUMo.getPrice() }));
          c.F(c.this).setText("");
          c.b(c.this, paramAnonymousSKUMo.getSkuCode());
          if (c.G(c.this) != null) {
            c.G(c.this).upDateUi(paramAnonymousSKUMo.getSkuCode(), "");
          }
          return;
          label224:
          c.a(c.this, paramAnonymousSKUMo.getAmount());
          break;
          label239:
          c.z(c.this).setText("0");
          c.A(c.this).setBackgroundResource(2130840252);
          c.B(c.this).setBackgroundResource(2130840246);
        }
      }
    });
  }
  
  private void a(int paramInt1, final int paramInt2, final String paramString)
  {
    this.a.clear();
    String str1 = (String)this.u.get("productCode");
    String str2 = ((p)this.t.getPropertyList().get(paramInt1)).getProperty().getPropertyCode();
    String str3 = ((com.ziroom.ziroomcustomer.bestgoods.model.ac)((p)this.t.getPropertyList().get(paramInt1)).getProperty().getPropertyList().get(paramInt2)).getPropertyValueCode();
    String str4 = this.t.getPropertyCode();
    String str5 = ((p)this.t.getPropertyList().get(paramInt1)).getPropertyValueCode();
    this.a.add(new o(str2, str3));
    this.a.add(new o(str4, str5));
    com.ziroom.ziroomcustomer.e.n.getYoupinSkuInfo(this.b, str1, this.a, new com.ziroom.ziroomcustomer.e.a.a(this.b, new m(SKUMo.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, SKUMo paramAnonymousSKUMo)
      {
        int k = 0;
        int j = 0;
        super.onSuccess(paramAnonymousInt, paramAnonymousSKUMo);
        int m;
        int i;
        if (paramAnonymousSKUMo != null)
        {
          m = paramAnonymousSKUMo.getAmount();
          if (!paramString.equals("toOrder")) {
            break label272;
          }
          if ("101020".equals(c.x(c.this)))
          {
            str = aa.getString(c.t(c.this), "currentYouPinCityCode", "");
            paramAnonymousInt = 0;
          }
        }
        else
        {
          for (;;)
          {
            i = j;
            if (paramAnonymousInt < com.ziroom.ziroomcustomer.bestgoods.a.getCityList().size())
            {
              if (((b)com.ziroom.ziroomcustomer.bestgoods.a.getCityList().get(paramAnonymousInt)).getCode().equals(str)) {
                i = 1;
              }
            }
            else
            {
              if (i == 0) {
                break label190;
              }
              if (m != 0) {
                break;
              }
              af.showToast(c.t(c.this), "库存不足");
              return;
            }
            paramAnonymousInt += 1;
          }
          str = ((w)c.e(c.this).get(paramInt2)).getTypeName();
          c.c(c.this, str);
          c.b(c.this, true);
          c.a(c.this, m, paramAnonymousSKUMo);
          return;
          label190:
          af.showToast(this.b, "当前城市无家具库存");
          return;
        }
        if (m == 0)
        {
          af.showToast(c.t(c.this), "库存不足");
          return;
        }
        String str = ((w)c.e(c.this).get(paramInt2)).getTypeName();
        c.c(c.this, str);
        c.b(c.this, true);
        c.a(c.this, m, paramAnonymousSKUMo);
        return;
        label272:
        if ("101020".equals(c.x(c.this)))
        {
          paramAnonymousSKUMo = aa.getString(c.t(c.this), "currentYouPinCityCode", "");
          paramAnonymousInt = 0;
          for (;;)
          {
            i = k;
            if (paramAnonymousInt < com.ziroom.ziroomcustomer.bestgoods.a.getCityList().size())
            {
              if (((b)com.ziroom.ziroomcustomer.bestgoods.a.getCityList().get(paramAnonymousInt)).getCode().equals(paramAnonymousSKUMo)) {
                i = 1;
              }
            }
            else
            {
              if (i == 0) {
                break label382;
              }
              if (m != 0) {
                break;
              }
              af.showToast(c.t(c.this), "库存不足");
              return;
            }
            paramAnonymousInt += 1;
          }
          c.b(c.this, m);
          return;
          label382:
          af.showToast(this.b, "当前城市无家具库存");
          return;
        }
        if (m == 0)
        {
          af.showToast(c.t(c.this), "库存不足");
          return;
        }
        c.b(c.this, m);
      }
    });
  }
  
  private void a(int paramInt, final SKUMo paramSKUMo)
  {
    if (paramInt == 0)
    {
      af.showToast(this.b, "库存不足");
      return;
    }
    com.ziroom.ziroomcustomer.e.n.addYouPinShoppingCartCheck(this.b, this.v, new com.ziroom.ziroomcustomer.e.a.a(this.b, new m(String.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        Object localObject;
        v localv;
        String str1;
        String str2;
        if (c.h(c.this) != null)
        {
          paramAnonymousInt = c.h(c.this).getDeliveryMode();
          paramAnonymousString = (String)c.i(c.this).get("providerName");
          localObject = (String)c.i(c.this).get("providerCode");
          localv = new v();
          str1 = (String)c.i(c.this).get("picUrl");
          if (TextUtils.isEmpty(c.j(c.this))) {
            c.a(c.this, (String)c.i(c.this).get("skuName"));
          }
          str2 = (String)c.i(c.this).get("productName");
          if (!c.k(c.this)) {
            break label461;
          }
          c.a(c.this, paramSKUMo.getPrice());
          c.b(c.this, paramSKUMo.getSkuCode());
        }
        for (;;)
        {
          t localt = new t();
          localt.setChildSelect(true);
          localt.setProductCode(c.l(c.this));
          localt.setSkuCode(c.m(c.this));
          localt.setUrl(str1);
          localt.setName(c.j(c.this));
          localt.setProductName(str2);
          localt.setAmount(Integer.valueOf(c.n(c.this)));
          localt.setPrice(c.o(c.this));
          localt.setActivityPrice(c.p(c.this));
          localt.setDeliveryMode(Integer.valueOf(paramAnonymousInt));
          localt.setShoppingCartCode("");
          localt.setSpecificationName(c.q(c.this));
          c.r(c.this).add(localt);
          localv.setProviderName(paramAnonymousString);
          localv.setProviderCode((String)localObject);
          localv.setGroupSelect(true);
          localv.setShoppingCartEntityList(c.r(c.this));
          c.s(c.this).add(localv);
          paramAnonymousString = com.alibaba.fastjson.a.toJSONString(c.s(c.this));
          localObject = new Intent(c.t(c.this), YouPinCommitOrderActivity.class);
          ((Intent)localObject).putExtra("selectedGoods", paramAnonymousString);
          ((Intent)localObject).putExtra("totalPrice", c.o(c.this).doubleValue() * c.n(c.this));
          c.t(c.this).startActivity((Intent)localObject);
          c.this.dismiss();
          return;
          label461:
          c.a(c.this, (Double)c.i(c.this).get("price"));
        }
      }
    });
  }
  
  private void a(String paramString, final FlowLayout paramFlowLayout)
  {
    Button localButton = new Button(this.b);
    localButton.setText(paramString);
    localButton.setTextColor(-6710887);
    localButton.setTextSize(12.0F);
    int i1 = com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 12.0F);
    localButton.setPadding(i1, i1, i1, i1);
    localButton.setBackgroundResource(2130840000);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 10.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 10.0F));
    localButton.setLayoutParams(paramString);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        int i = 0;
        if (i < paramFlowLayout.getChildCount())
        {
          Object localObject = (Button)paramFlowLayout.getChildAt(i);
          if (localObject == paramAnonymousView)
          {
            ((w)c.c(c.this).get(i)).setSelect(true);
            ((Button)localObject).setBackgroundResource(2130840004);
            ((Button)localObject).setTextColor(40960);
            localObject = ((p)c.d(c.this).get(i)).getProperty().getPropertyList();
            if (!c.e(c.this).isEmpty()) {
              c.e(c.this).clear();
            }
            int j = 0;
            if (j < ((List)localObject).size())
            {
              if (((com.ziroom.ziroomcustomer.bestgoods.model.ac)((List)localObject).get(j)).getChecked() == 1) {
                if (((com.ziroom.ziroomcustomer.bestgoods.model.ac)((List)localObject).get(j)).getAmount() > 9)
                {
                  c.a(c.this, 9);
                  label183:
                  c.e(c.this).add(new w(((com.ziroom.ziroomcustomer.bestgoods.model.ac)((List)localObject).get(j)).getPropertyValueName(), true));
                }
              }
              for (;;)
              {
                j += 1;
                break;
                c.a(c.this, ((com.ziroom.ziroomcustomer.bestgoods.model.ac)((List)localObject).get(j)).getAmount());
                break label183;
                c.e(c.this).add(new w(((com.ziroom.ziroomcustomer.bestgoods.model.ac)((List)localObject).get(j)).getPropertyValueName(), false));
              }
            }
            if ((c.f(c.this) != null) && (c.f(c.this).getChildCount() > 0)) {
              c.f(c.this).removeAllViews();
            }
            localObject = c.e(c.this).iterator();
            while (((Iterator)localObject).hasNext())
            {
              w localw = (w)((Iterator)localObject).next();
              c.a(c.this, localw.getTypeName(), c.f(c.this));
            }
            c.g(c.this);
          }
          for (;;)
          {
            i += 1;
            break;
            ((w)c.c(c.this).get(i)).setSelect(false);
            ((Button)localObject).setBackgroundResource(2130840000);
            ((Button)localObject).setTextColor(-6710887);
          }
        }
      }
    });
    paramFlowLayout.addView(localButton);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.p == 1) {
      return;
    }
    if (paramBoolean)
    {
      if (this.o >= this.p)
      {
        af.showToast(this.b, "商品已达最大数量");
        return;
      }
      this.i.setBackgroundResource(2130840251);
      this.o += 1;
      if (this.o >= this.p)
      {
        this.k.setBackgroundResource(2130840246);
        this.l.setText(this.o + "");
        af.showToast(this.b, "商品已达最大数量");
        return;
      }
      this.k.setBackgroundResource(2130840245);
    }
    for (;;)
    {
      this.l.setText(this.o + "");
      return;
      if (this.o <= 1)
      {
        af.showToast(this.b, "最小数量为1");
        return;
      }
      this.k.setBackgroundResource(2130840245);
      this.o -= 1;
      if (this.o <= 1)
      {
        this.i.setBackgroundResource(2130840252);
        this.l.setText(this.o + "");
        return;
      }
      this.i.setBackgroundResource(2130840251);
    }
  }
  
  private void b()
  {
    this.K = ((String)this.u.get("categoryCode"));
    this.v = ((String)this.u.get("productCode"));
    this.w = ((String)this.u.get("skuCode"));
    Object localObject = (String)this.u.get("picUrl");
    String str = (String)this.u.get("skuName");
    Double localDouble = (Double)this.u.get("price");
    int i3 = ((Integer)this.u.get("btnState")).intValue();
    this.D = ((Double)this.u.get("activityPrice"));
    this.H = ((String)this.u.get("specificationName"));
    this.G = ((String)this.u.get("specificationCode"));
    this.c.setController(com.freelxl.baselibrary.f.c.frescoController((String)localObject));
    this.d.setText(str);
    this.e.setText("¥" + String.format("%.2f", new Object[] { localDouble }));
    localObject = this.t.getPropertyList();
    if ((localObject == null) || (((List)localObject).isEmpty())) {}
    while ((p)((List)localObject).get(0) == null) {
      return;
    }
    if ((this.g != null) && (this.g.getChildCount() > 0)) {
      this.g.removeAllViews();
    }
    this.F = this.t.getPropertyList();
    int i1 = 0;
    while (i1 < this.F.size())
    {
      if (((p)this.F.get(i1)).getChecked() == 1)
      {
        this.r.add(new w(((p)this.F.get(i1)).getPropertyValueName(), true));
        localObject = ((p)this.F.get(i1)).getProperty().getPropertyList();
        int i2 = 0;
        if (i2 < ((List)localObject).size())
        {
          if (this.G.equals(((com.ziroom.ziroomcustomer.bestgoods.model.ac)((List)localObject).get(i2)).getPropertyValueCode())) {
            if (((com.ziroom.ziroomcustomer.bestgoods.model.ac)((List)localObject).get(i2)).getAmount() > 9)
            {
              this.p = 9;
              label471:
              this.q.add(new w(((com.ziroom.ziroomcustomer.bestgoods.model.ac)((List)localObject).get(i2)).getPropertyValueName(), true));
            }
          }
          for (;;)
          {
            i2 += 1;
            break;
            this.p = ((com.ziroom.ziroomcustomer.bestgoods.model.ac)((List)localObject).get(i2)).getAmount();
            break label471;
            this.q.add(new w(((com.ziroom.ziroomcustomer.bestgoods.model.ac)((List)localObject).get(i2)).getPropertyValueName(), false));
          }
        }
      }
      else
      {
        this.r.add(new w(((p)this.F.get(i1)).getPropertyValueName(), false));
      }
      i1 += 1;
    }
    localObject = this.r.iterator();
    while (((Iterator)localObject).hasNext()) {
      a(((w)((Iterator)localObject).next()).getTypeName(), this.E);
    }
    c();
    this.h.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        c.a(c.this, false);
      }
    });
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        c.a(c.this, true);
      }
    });
    localObject = this.q.iterator();
    while (((Iterator)localObject).hasNext()) {
      b(((w)((Iterator)localObject).next()).getTypeName(), this.g);
    }
    f();
    if (i3 == 0)
    {
      this.m.setVisibility(0);
      this.n.setVisibility(0);
    }
    for (;;)
    {
      this.m.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          c.a(c.this);
        }
      });
      this.n.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          c.b(c.this);
        }
      });
      return;
      if (i3 == 1)
      {
        this.m.setVisibility(0);
        this.n.setVisibility(8);
      }
      else if (i3 == 2)
      {
        this.m.setVisibility(8);
        this.n.setVisibility(0);
      }
    }
  }
  
  private void b(String paramString, final FlowLayout paramFlowLayout)
  {
    Button localButton = new Button(this.b);
    localButton.setText(paramString);
    localButton.setTextColor(-6710887);
    localButton.setTextSize(12.0F);
    int i1 = com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 12.0F);
    localButton.setPadding(i1, i1, i1, i1);
    localButton.setBackgroundResource(2130840000);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 10.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 10.0F));
    localButton.setLayoutParams(paramString);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        int i = 0;
        while (i < paramFlowLayout.getChildCount())
        {
          Button localButton = (Button)paramFlowLayout.getChildAt(i);
          if (localButton == paramAnonymousView)
          {
            ((w)c.e(c.this).get(i)).setSelect(true);
            localButton.setBackgroundResource(2130840004);
            localButton.setTextColor(40960);
            int j = 0;
            while (j < c.c(c.this).size())
            {
              if (((w)c.c(c.this).get(j)).isSelect()) {
                c.a(c.this, j, i);
              }
              j += 1;
            }
          }
          ((w)c.e(c.this).get(i)).setSelect(false);
          localButton.setBackgroundResource(2130840000);
          localButton.setTextColor(-6710887);
          i += 1;
        }
      }
    });
    paramFlowLayout.addView(localButton);
  }
  
  private void c()
  {
    int i1 = 0;
    while (i1 < this.E.getChildCount())
    {
      Button localButton = (Button)this.E.getChildAt(i1);
      int i2 = 0;
      while (i2 < this.r.size())
      {
        if ((((w)this.r.get(i2)).isSelect()) && (((w)this.r.get(i2)).getTypeName().equals(localButton.getText().toString())))
        {
          localButton.setBackgroundResource(2130840004);
          localButton.setTextColor(40960);
        }
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  private void d()
  {
    int i4 = 0;
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.b);
    }
    for (;;)
    {
      return;
      this.C = localUserInfo.getUid();
      int i1 = 0;
      int i2 = 0;
      int i3;
      for (;;)
      {
        i3 = i4;
        if (i1 >= this.r.size()) {
          break;
        }
        if (((w)this.r.get(i1)).isSelect()) {
          i2 = i1;
        }
        i1 += 1;
      }
      while (i3 < this.q.size())
      {
        if (((w)this.q.get(i3)).isSelect())
        {
          this.H = ((w)this.q.get(i3)).getTypeName();
          a(i2, i3, "toOrder");
        }
        i3 += 1;
      }
    }
  }
  
  private void e()
  {
    int i4 = 0;
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.b);
    }
    for (;;)
    {
      return;
      this.C = localUserInfo.getUid();
      int i1 = 0;
      int i2 = 0;
      int i3;
      for (;;)
      {
        i3 = i4;
        if (i1 >= this.r.size()) {
          break;
        }
        if (((w)this.r.get(i1)).isSelect()) {
          i2 = i1;
        }
        i1 += 1;
      }
      while (i3 < this.q.size())
      {
        if (((w)this.q.get(i3)).isSelect()) {
          a(i2, i3, "toShoppingCart");
        }
        i3 += 1;
      }
    }
  }
  
  private void f()
  {
    int i1 = 0;
    while (i1 < this.g.getChildCount())
    {
      Button localButton = (Button)this.g.getChildAt(i1);
      int i2 = 0;
      while (i2 < this.q.size())
      {
        if ((((w)this.q.get(i2)).isSelect()) && (((w)this.q.get(i2)).getTypeName().equals(localButton.getText().toString())))
        {
          localButton.setBackgroundResource(2130840004);
          localButton.setTextColor(40960);
        }
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDefaultSetting()
  {
    setCanceledOnTouchOutside(true);
    Window localWindow = getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    localWindow.setWindowAnimations(2131427962);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = (com.ziroom.ziroomcustomer.util.ac.getScreenHeight(this.b) - com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 150.0F));
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
  }
  
  public void setOnFlLikeItemClickListener(a parama)
  {
    this.s = parama;
  }
  
  public static abstract interface a
  {
    public abstract void addGoods(int paramInt);
    
    public abstract void upDateUi(String paramString1, String paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/dialog/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */