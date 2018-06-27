package com.ziroom.ziroomcustomer.findhouse.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.model.SelectCondition;
import com.ziroom.ziroomcustomer.findhouse.model.SelectCondition.SelectType;
import com.ziroom.ziroomcustomer.findhouse.model.SelectCondition.TypeExtra;
import com.ziroom.ziroomcustomer.findhouse.view.HouseTypeView;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HouseTypePop
  extends PopupWindow
  implements View.OnClickListener
{
  private Context a;
  private View b;
  private SelectCondition c;
  private SearchCondition d;
  private List<SelectCondition.SelectType> e;
  private HashSet<Integer> f = new HashSet();
  private float g;
  private HouseTypeView h;
  private HouseTypeView i;
  private HouseTypeView j;
  private HouseTypeView k;
  private List<HouseTypeView> l = new ArrayList();
  private TextView m;
  private TextView n;
  private HouseList_ConditionalView.c o;
  private a p;
  
  public HouseTypePop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HouseTypePop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HouseTypePop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    setSoftInputMode(16);
    setWidth(-1);
    if (Build.VERSION.SDK_INT >= 24) {
      setHeight(-2);
    }
    for (;;)
    {
      setAnimationStyle(2131427934);
      this.a = paramContext;
      this.b = LayoutInflater.from(paramContext).inflate(2130905048, null);
      a();
      return;
      setHeight(-1);
    }
  }
  
  private void a()
  {
    this.h = ((HouseTypeView)this.b.findViewById(2131697319));
    this.i = ((HouseTypeView)this.b.findViewById(2131697321));
    this.j = ((HouseTypeView)this.b.findViewById(2131697322));
    this.k = ((HouseTypeView)this.b.findViewById(2131697323));
    this.l.add(this.h);
    this.l.add(this.i);
    this.l.add(this.j);
    this.l.add(this.k);
    this.m = ((TextView)this.b.findViewById(2131693064));
    this.n = ((TextView)this.b.findViewById(2131691289));
    this.g = this.a.getResources().getDisplayMetrics().density;
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (HouseTypePop.a(HouseTypePop.this) != null) {
          HouseTypePop.a(HouseTypePop.this).onDismiss();
        }
      }
    });
    setContentView(this.b);
  }
  
  private void b()
  {
    this.h.clearSelect();
    this.i.clearSelect();
    this.j.clearSelect();
    this.k.clearSelect();
  }
  
  private void c()
  {
    String str1 = this.h.getTypeValue() + this.i.getTypeValue() + this.j.getTypeValue() + this.k.getTypeValue();
    if (TextUtils.isEmpty(str1))
    {
      this.f.clear();
      if (this.p != null) {
        this.p.select(str1, "", this.f);
      }
      dismiss();
      return;
    }
    String str2 = str1.substring(0, str1.length() - 1);
    this.d.setType(str2);
    this.f.clear();
    this.h.setTypeState(this.f);
    this.i.setTypeState(this.f);
    this.j.setTypeState(this.f);
    this.k.setTypeState(this.f);
    str1 = "";
    if (str2.indexOf("|") == -1) {
      str1 = this.h.getTypeShow() + this.i.getTypeShow() + this.j.getTypeShow() + this.k.getTypeShow();
    }
    if (this.p != null) {
      this.p.select(str2, str1, this.f);
    }
    dismiss();
  }
  
  private void d()
  {
    List localList = this.c.getType_extra();
    int i1 = 0;
    while (i1 < localList.size())
    {
      SelectCondition.TypeExtra localTypeExtra = (SelectCondition.TypeExtra)localList.get(i1);
      int i3 = localTypeExtra.getType();
      ArrayList localArrayList = new ArrayList();
      int i2 = 0;
      while (i2 < this.e.size())
      {
        if (((SelectCondition.SelectType)this.e.get(i2)).getType() == i3) {
          localArrayList.add(this.e.get(i2));
        }
        i2 += 1;
      }
      ((HouseTypeView)this.l.get(i1)).setContent(localTypeExtra, localArrayList);
      i1 += 1;
    }
  }
  
  private void e()
  {
    this.h.setViewSelect(this.d.getType());
    this.i.setViewSelect(this.d.getType());
    this.j.setViewSelect(this.d.getType());
    this.k.setViewSelect(this.d.getType());
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131693064: 
      b();
      return;
    }
    c();
  }
  
  public void setOnTypeSelectListener(a parama)
  {
    this.p = parama;
  }
  
  public void setPopDismisListener(HouseList_ConditionalView.c paramc)
  {
    this.o = paramc;
  }
  
  public void show(View paramView, SelectCondition paramSelectCondition, SearchCondition paramSearchCondition)
  {
    if ((paramSelectCondition == null) || (paramSearchCondition == null)) {
      return;
    }
    this.d = paramSearchCondition;
    this.c = paramSelectCondition;
    this.e = this.c.getType();
    d();
    e();
    if (!(this instanceof PopupWindow))
    {
      showAsDropDown(paramView, 0, 0);
      return;
    }
    VdsAgent.showAsDropDown((PopupWindow)this, paramView, 0, 0);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT == 24)
    {
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      paramInt2 = arrayOfInt[1] + paramView.getHeight() + paramInt2;
      if (!(this instanceof PopupWindow))
      {
        showAtLocation(paramView, 0, paramInt1, paramInt2);
        return;
      }
      VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, paramInt1, paramInt2);
      return;
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public static abstract interface a
  {
    public abstract void select(String paramString1, String paramString2, HashSet<Integer> paramHashSet);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/widget/HouseTypePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */