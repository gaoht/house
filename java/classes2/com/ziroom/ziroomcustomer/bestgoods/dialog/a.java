package com.ziroom.ziroomcustomer.bestgoods.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.b.r;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.f;
import com.ziroom.ziroomcustomer.bestgoods.a.f.a;
import com.ziroom.ziroomcustomer.bestgoods.activity.ConfirmOrderAc;
import com.ziroom.ziroomcustomer.bestgoods.model.SKUMo;
import com.ziroom.ziroomcustomer.bestgoods.model.ac;
import com.ziroom.ziroomcustomer.bestgoods.model.ad;
import com.ziroom.ziroomcustomer.bestgoods.model.o;
import com.ziroom.ziroomcustomer.bestgoods.model.p;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.newrepair.widget.ZiScroListView;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
  extends Dialog
  implements View.OnClickListener
{
  private WeakReference<BaseActivity> a;
  private Context b;
  private LayoutInflater c;
  private SimpleDraweeView d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private ZiScroListView h;
  private f i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private SKUMo p;
  private com.ziroom.ziroomcustomer.bestgoods.model.j q;
  private Map<Integer, Integer> r;
  private int s;
  private String t;
  private String u;
  private double v;
  private String w;
  private int x;
  private c y;
  
  public a(BaseActivity paramBaseActivity, com.ziroom.ziroomcustomer.bestgoods.model.j paramj, SKUMo paramSKUMo, Map<String, Object> paramMap)
  {
    super(paramBaseActivity, 2131427692);
    this.a = new WeakReference(paramBaseActivity);
    this.b = paramBaseActivity;
    this.q = paramj;
    this.w = ((String)paramMap.get("productCode"));
    this.t = ((String)paramMap.get("goodsName"));
    this.u = ((String)paramMap.get("img"));
    this.v = ((Double)paramMap.get("price")).doubleValue();
    this.s = ((Integer)paramMap.get("btnState")).intValue();
    if (paramSKUMo == null)
    {
      this.p = new SKUMo();
      this.p.setProductCode(this.w);
      this.p.setSkuCode((String)paramMap.get("skuCode"));
      this.p.setSkuName(this.t);
      this.p.setPrice(Double.valueOf(this.v));
      this.p.setFreight(0.0D);
      this.p.setSkuImg(this.u);
      this.p.setChecked(false);
      this.p.setCityCode(com.ziroom.ziroomcustomer.base.b.d);
      this.p.setCityName(com.ziroom.ziroomcustomer.base.b.c);
      return;
    }
    this.p = paramSKUMo;
  }
  
  public a(BaseActivity paramBaseActivity, com.ziroom.ziroomcustomer.bestgoods.model.j paramj, String paramString1, double paramDouble, String paramString2, SKUMo paramSKUMo, String paramString3, String paramString4, int paramInt)
  {
    super(paramBaseActivity, 2131427692);
    this.a = new WeakReference(paramBaseActivity);
    this.b = paramBaseActivity;
    this.w = paramString3;
    this.q = paramj;
    this.t = paramString1;
    this.v = paramDouble;
    this.s = paramInt;
    this.u = paramString2;
    if (paramSKUMo == null)
    {
      this.p = new SKUMo();
      this.p.setChecked(false);
      this.p.setCityCode(com.ziroom.ziroomcustomer.base.b.d);
      this.p.setCityName(com.ziroom.ziroomcustomer.base.b.c);
      this.p.setProductCode(paramString3);
      this.p.setSkuCode(paramString4);
      this.p.setSkuName(paramString1);
      this.p.setPrice(Double.valueOf(paramDouble));
      this.p.setFreight(0.0D);
      this.p.setSkuImg(paramString2);
      return;
    }
    this.p = paramSKUMo;
  }
  
  private void a()
  {
    this.c = LayoutInflater.from(this.b);
    View localView = this.c.inflate(2130903767, null);
    a(localView);
    b();
    c();
    setContentView(localView);
  }
  
  private void a(int paramInt)
  {
    if (this.s == 0)
    {
      this.m.setVisibility(0);
      this.n.setVisibility(0);
      if (((this.r == null) && (this.p == null)) || (paramInt <= 0)) {
        break label124;
      }
      this.m.setBackgroundResource(2131623955);
      this.n.setBackgroundResource(2131624516);
      this.m.setClickable(true);
      this.n.setClickable(true);
    }
    label124:
    do
    {
      return;
      if (this.s == 1)
      {
        this.m.setVisibility(0);
        this.n.setVisibility(8);
        break;
      }
      this.m.setVisibility(8);
      this.n.setVisibility(0);
      break;
      this.m.setBackgroundResource(2131624042);
      this.n.setBackgroundResource(2131624045);
    } while ((this.p != null) && (this.p.getAmount() != 0));
    this.m.setClickable(false);
    this.n.setClickable(false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.j.setText("" + paramInt1);
    if (paramInt1 <= 1)
    {
      this.k.setClickable(false);
      this.k.setTextColor(this.b.getResources().getColor(2131624042));
    }
    while ((paramInt1 < 9) && (paramInt1 < paramInt2) && (paramInt2 > 0))
    {
      this.l.setClickable(true);
      this.l.setTextColor(this.b.getResources().getColor(2131624516));
      return;
      this.k.setClickable(true);
      this.k.setTextColor(this.b.getResources().getColor(2131624516));
    }
    this.l.setClickable(false);
    this.l.setTextColor(this.b.getResources().getColor(2131624042));
  }
  
  private void a(View paramView)
  {
    this.d = ((SimpleDraweeView)paramView.findViewById(2131693685));
    this.e = ((ImageView)paramView.findViewById(2131690588));
    this.h = ((ZiScroListView)paramView.findViewById(2131693679));
    a locala = new a();
    if (this.i == null) {
      this.i = new f(this.b, this.q, this.r, locala);
    }
    this.h.setAdapter(this.i);
    this.f = ((TextView)paramView.findViewById(2131689912));
    this.o = ((TextView)paramView.findViewById(2131693678));
    this.g = ((TextView)paramView.findViewById(2131693677));
    this.l = ((TextView)paramView.findViewById(2131690041));
    this.k = ((TextView)paramView.findViewById(2131693681));
    this.j = ((TextView)paramView.findViewById(2131690003));
    this.m = ((TextView)paramView.findViewById(2131690699));
    this.n = ((TextView)paramView.findViewById(2131693684));
  }
  
  private void b()
  {
    this.e.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    int i2 = this.p.getAmount();
    if ((this.p != null) && (i2 > 0))
    {
      if ((!ApplicationEx.c.isLoginState()) && (paramInt == 1)) {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.b);
      }
      int i3;
      label303:
      do
      {
        return;
        this.p.setChecked(true);
        this.p.setCityCode(com.ziroom.ziroomcustomer.base.b.d);
        this.p.setCityName(com.ziroom.ziroomcustomer.base.b.c);
        this.p.setProductCode(this.w);
        int i1 = r.getSKUNum(this.b, this.p);
        i3 = this.p.getCount();
        i2 -= i1;
        int i4 = 9 - i1;
        i1 = 0;
        if ((i3 < i4) && (i3 < i2))
        {
          i2 = r.save(this.b, this.p);
          i1 = i2;
          if (paramInt == 0)
          {
            af.showToast(this.b, "已成功加入购物车");
            dismiss();
            i1 = i2;
          }
        }
        for (;;)
        {
          if (paramInt != 0) {
            break label303;
          }
          if (this.y == null) {
            break;
          }
          this.y.addGoods(i1);
          return;
          if ((i2 == 0) && (paramInt == 0))
          {
            af.showToast(this.b, "该商品库存不足");
          }
          else if ((i4 == 0) && (paramInt == 0))
          {
            af.showToast(this.b, "已达到物品最大数量");
          }
          else
          {
            i4 = Math.min(i2, i4);
            this.p.setCount(i4);
            i2 = r.save(this.b, this.p);
            i1 = i2;
            if (paramInt == 0)
            {
              af.showToast(this.b, "添加" + i4 + "件物品到购物车成功");
              dismiss();
              i1 = i2;
            }
          }
        }
      } while (paramInt != 1);
      this.p.setCount(i3);
      d();
      dismiss();
      return;
    }
    af.showToast(this.b, "请选择风格和规格");
  }
  
  private void c()
  {
    if (this.p != null)
    {
      a(this.p.getCount(), this.p.getAmount());
      this.g.setText(this.t);
      this.f.setText("¥" + String.format("%.2f", new Object[] { Double.valueOf(this.v) }));
      if (TextUtils.isEmpty(this.u)) {
        break label201;
      }
      this.d.setController(com.freelxl.baselibrary.f.c.frescoController(this.u));
    }
    for (;;)
    {
      if (this.p == null) {
        break label215;
      }
      a(this.p.getAmount());
      return;
      if (this.x > 0)
      {
        a(1, this.x);
        break;
      }
      this.l.setTextColor(this.b.getResources().getColor(2131624042));
      this.l.setClickable(false);
      this.k.setTextColor(this.b.getResources().getColor(2131624042));
      this.k.setClickable(false);
      break;
      label201:
      this.d.setController(com.freelxl.baselibrary.f.c.frescoController(null));
    }
    label215:
    a(this.x);
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this.b, ConfirmOrderAc.class);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.p);
    localIntent.putParcelableArrayListExtra("selectedGoods", localArrayList);
    localIntent.putExtra("totalPrice", this.p.getCount() * this.p.getPrice().doubleValue());
    localIntent.putExtra("freightCost", this.p.getFreight());
    this.b.startActivity(localIntent);
  }
  
  private void e()
  {
    if (h.checkNet(this.b))
    {
      if (this.a.get() != null) {
        ((BaseActivity)this.a.get()).showProgress("");
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("productCode", this.w);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.r.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        Integer localInteger = (Integer)((Map.Entry)localObject).getKey();
        localObject = (Integer)((Map.Entry)localObject).getValue();
        o localo = new o("", "");
        if (localInteger.intValue() == 0)
        {
          localo.setPropertyCode(this.q.getPropertyCode());
          localo.setPropertyValueCode(((p)this.q.getPropertyList().get(((Integer)localObject).intValue())).getPropertyValueCode());
        }
        for (;;)
        {
          Log.e("TAG", "key = " + localInteger + "and value = " + localObject);
          localArrayList.add(localo);
          break;
          if (localInteger.intValue() == 1)
          {
            ad localad = ((p)this.q.getPropertyList().get(((Integer)this.r.get(Integer.valueOf(0))).intValue())).getProperty();
            localo.setPropertyCode(localad.getPropertyCode());
            localo.setPropertyValueCode(((ac)localad.getPropertyList().get(((Integer)localObject).intValue())).getPropertyValueCode());
          }
        }
      }
      localHashMap.put("properties", com.alibaba.fastjson.a.toJSONString(localArrayList));
      u.d("dksjgkld ", "========   " + com.alibaba.fastjson.a.toJSONString(localHashMap));
      com.ziroom.ziroomcustomer.e.j.getSKUInfo((Activity)this.a.get(), localHashMap, new b(new com.ziroom.ziroomcustomer.newrepair.utils.b(SKUMo.class)));
      return;
    }
    f();
    af.showToast(this.b, "请保证网络畅通");
  }
  
  private void f()
  {
    this.p = null;
    if (this.r != null) {
      ((ac)((p)this.q.getPropertyList().get(((Integer)this.r.get(Integer.valueOf(0))).intValue())).getProperty().getPropertyList().get(((Integer)this.r.get(Integer.valueOf(1))).intValue())).setChecked(0);
    }
    this.r = null;
    this.x = 0;
    a();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690588: 
      dismiss();
      return;
    case 2131693681: 
      this.p.setCount(this.p.getCount() - 1);
      a(this.p.getCount(), this.p.getAmount());
      return;
    case 2131690041: 
      this.p.setCount(this.p.getCount() + 1);
      a(this.p.getCount(), this.p.getAmount());
      return;
    case 2131690699: 
      b(0);
      return;
    }
    b(1);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setData(SKUMo paramSKUMo, int paramInt)
  {
    this.s = paramInt;
    a();
  }
  
  public void setOnUpDateUIListener(c paramc)
  {
    this.y = paramc;
  }
  
  public class a
    implements f.a
  {
    public a() {}
    
    public void checkProperty(String paramString, Map<Integer, Integer> paramMap)
    {
      if ((paramMap == null) || ((a.a(a.this) != null) && (a.a(a.this).get(Integer.valueOf(0)) == paramMap.get(Integer.valueOf(0))) && (a.a(a.this).get(Integer.valueOf(1)) == paramMap.get(Integer.valueOf(1))))) {
        return;
      }
      a.a(a.this, new HashMap());
      a.a(a.this).put(Integer.valueOf(0), paramMap.get(Integer.valueOf(0)));
      a.a(a.this).put(Integer.valueOf(1), paramMap.get(Integer.valueOf(1)));
      a.b(a.this);
    }
    
    public void initData(int paramInt)
    {
      a.a(a.this, paramInt);
      if (a.c(a.this) <= 0) {
        af.showToast(a.d(a.this), "该商品暂时没有库存", 1);
      }
      if ((a.e(a.this) != null) && (a.c(a.this) > 0))
      {
        a.e(a.this).setCount(1);
        a.e(a.this).setAmount(a.c(a.this));
      }
      while (a.e(a.this) == null) {
        return;
      }
      a.e(a.this).setCount(0);
      a.e(a.this).setAmount(0);
    }
    
    public void propertyOneChange(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        a.a(a.this, 0, 0);
        a.b(a.this, 0);
      }
    }
    
    public void revertUI()
    {
      if (a.e(a.this) != null)
      {
        int i = a.e(a.this).getCount();
        int j = a.e(a.this).getAmount();
        a.a(a.this, i, j);
        a.b(a.this, j);
        return;
      }
      if (a.c(a.this) > 0)
      {
        a.a(a.this, 1, a.c(a.this));
        a.b(a.this, a.c(a.this));
        return;
      }
      a.a(a.this, 0, 0);
      a.b(a.this, 0);
    }
  }
  
  class b
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public b(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      if (a.r(a.this).get() != null) {
        ((BaseActivity)a.r(a.this).get()).dismissProgress();
      }
      a.q(a.this);
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      int i;
      if (paraml.getSuccess().booleanValue())
      {
        a.a(a.this, (SKUMo)paraml.getObject());
        if (a.e(a.this) != null)
        {
          a.e(a.this).setChecked(true);
          a.f(a.this).setClickable(false);
          a.f(a.this).setTextColor(a.d(a.this).getResources().getColor(2131624042));
          i = a.e(a.this).getAmount();
          if (i > 1)
          {
            a.e(a.this).setCount(1);
            a.g(a.this).setClickable(true);
            a.g(a.this).setTextColor(a.d(a.this).getResources().getColor(2131624516));
            a.a(a.this, a.e(a.this).getSkuName());
            a.a(a.this, a.e(a.this).getPrice().doubleValue());
            a.b(a.this, a.e(a.this).getSkuImg());
            if (TextUtils.isEmpty(a.h(a.this))) {
              break label571;
            }
            a.i(a.this).setController(com.freelxl.baselibrary.f.c.frescoController(a.h(a.this)));
            label235:
            a.k(a.this).setText("¥" + String.format("%.2f", new Object[] { Double.valueOf(a.j(a.this)) }));
            a.m(a.this).setText(a.l(a.this));
            a.n(a.this).setText(i + "");
            a.o(a.this).setText(a.e(a.this).getCount() + "");
            if (a.p(a.this) != null)
            {
              u.d("sdkjdg", "======  " + com.alibaba.fastjson.a.toJSONString(a.e(a.this)));
              a.p(a.this).upDateUi(a.e(a.this).getSkuCode(), a.e(a.this).getSkuName());
            }
            a.a(a.this, i);
            a.b(a.this, i);
          }
        }
      }
      for (;;)
      {
        if (a.r(a.this).get() != null) {
          ((BaseActivity)a.r(a.this).get()).dismissProgress();
        }
        return;
        if (i == 0) {
          af.showToast(a.d(a.this), "该商品暂时没有库存");
        }
        paraml = a.e(a.this);
        if (i < 0) {}
        for (paramInt = 0;; paramInt = i)
        {
          paraml.setCount(paramInt);
          a.g(a.this).setClickable(false);
          a.g(a.this).setTextColor(a.d(a.this).getResources().getColor(2131624042));
          break;
        }
        label571:
        a.i(a.this).setController(com.freelxl.baselibrary.f.c.frescoController(null));
        break label235;
        af.showToast(a.d(a.this), "没有符合条件的商品");
        a.q(a.this);
        continue;
        a.q(a.this);
        paraml = paraml.getMessage();
        if (paraml != null) {
          af.showToast(a.d(a.this), paraml);
        } else {
          af.showToast(a.d(a.this), "没有符合条件的商品");
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void addGoods(int paramInt);
    
    public abstract void upDateUi(String paramString1, String paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/dialog/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */