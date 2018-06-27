package com.ziroom.ziroomcustomer.findhouse.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import com.ziroom.ziroomcustomer.findhouse.model.ZZSelectCondition;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.util.w;
import java.util.List;

public class ZZ_ListMorePop
  extends PopupWindow
  implements View.OnClickListener
{
  private static ZZSelectCondition n;
  private Context a;
  private float b;
  private LinearLayout c;
  private TextView d;
  private TextView e;
  private LinearLayout f;
  private LinearLayout g;
  private LinearLayout h;
  private LinearLayout i;
  private LinearLayout j;
  private LinearLayout k;
  private LinearLayout l;
  private LinearLayout m;
  private String o;
  private String p;
  private String q;
  private String r;
  private SearchCondition s = new SearchCondition();
  private HouseList_ConditionalView.c t;
  private a u;
  
  public ZZ_ListMorePop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ZZ_ListMorePop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZZ_ListMorePop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.b = this.a.getResources().getDisplayMetrics().density;
    setHeight(-1);
    setWidth(-1);
    setSoftInputMode(16);
    setAnimationStyle(2131427934);
    a();
  }
  
  private CheckBox a(SelectBean paramSelectBean)
  {
    if (paramSelectBean == null) {
      return new CheckBox(this.a);
    }
    CheckBox localCheckBox = new CheckBox(this.a);
    localCheckBox.setTextSize(2, 14.0F);
    localCheckBox.setButtonDrawable(2131624576);
    localCheckBox.setGravity(17);
    localCheckBox.setSingleLine(true);
    localCheckBox.setSingleLine(true);
    localCheckBox.setEllipsize(null);
    localCheckBox.setBackgroundResource(2130839489);
    localCheckBox.setTextColor(this.a.getResources().getColorStateList(2131624647));
    int i1 = (int)(8.0F * this.b);
    int i2 = (int)(this.b * 1.0F);
    localCheckBox.setPadding(i2, i1, i2, i1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.leftMargin = i1;
    localLayoutParams.rightMargin = i1;
    localCheckBox.setLayoutParams(localLayoutParams);
    localCheckBox.setIncludeFontPadding(false);
    localCheckBox.setText(paramSelectBean.getTitle());
    localCheckBox.setTag(paramSelectBean.getValue());
    return localCheckBox;
  }
  
  private void a()
  {
    this.c = ((LinearLayout)LayoutInflater.from(this.a).inflate(2130905055, null));
    this.d = ((TextView)this.c.findViewById(2131693064));
    this.e = ((TextView)this.c.findViewById(2131691289));
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f = ((LinearLayout)this.c.findViewById(2131697327));
    this.g = ((LinearLayout)this.c.findViewById(2131696233));
    this.h = ((LinearLayout)this.c.findViewById(2131697328));
    this.i = ((LinearLayout)this.c.findViewById(2131697329));
    this.j = ((LinearLayout)this.c.findViewById(2131697330));
    this.k = ((LinearLayout)this.c.findViewById(2131696236));
    this.l = ((LinearLayout)this.c.findViewById(2131697331));
    this.m = ((LinearLayout)this.c.findViewById(2131691352));
    setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (ZZ_ListMorePop.a(ZZ_ListMorePop.this) != null) {
          ZZ_ListMorePop.a(ZZ_ListMorePop.this).onDismiss();
        }
      }
    });
    setContentView(this.c);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    int i1 = 0;
    while (i1 < paramViewGroup.getChildCount())
    {
      ((CheckBox)paramViewGroup.getChildAt(i1)).setChecked(false);
      i1 += 1;
    }
  }
  
  private void a(ViewGroup paramViewGroup, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramViewGroup == null) || (paramViewGroup.getChildCount() < 1)) {}
    for (;;)
    {
      return;
      paramString = paramString.split(",");
      int i1 = 0;
      while (i1 < paramViewGroup.getChildCount())
      {
        int i2 = 0;
        while (i2 < paramString.length)
        {
          if (paramString[i2].equals(paramViewGroup.getChildAt(i1).getTag())) {
            ((CheckBox)paramViewGroup.getChildAt(i1)).setChecked(true);
          }
          i2 += 1;
        }
        i1 += 1;
      }
    }
  }
  
  private String b(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      paramViewGroup = "";
    }
    Object localObject;
    do
    {
      do
      {
        return paramViewGroup;
        localObject = new StringBuilder();
        int i1 = 0;
        while (i1 < paramViewGroup.getChildCount())
        {
          CheckBox localCheckBox = (CheckBox)paramViewGroup.getChildAt(i1);
          if ((localCheckBox.isChecked()) && (localCheckBox.getTag() != null) && (!TextUtils.isEmpty(localCheckBox.getTag().toString()))) {
            ((StringBuilder)localObject).append(localCheckBox.getTag().toString() + ",");
          }
          i1 += 1;
        }
        localObject = ((StringBuilder)localObject).toString();
        paramViewGroup = (ViewGroup)localObject;
      } while (TextUtils.isEmpty((CharSequence)localObject));
      paramViewGroup = (ViewGroup)localObject;
    } while (!((String)localObject).endsWith(","));
    return ((String)localObject).substring(0, ((String)localObject).length() - 1);
  }
  
  private void b()
  {
    List localList = n.getConfig();
    if ((localList == null) || (localList.size() < 1)) {
      this.l.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.m.removeAllViews();
      int i1 = 0;
      while (i1 < localList.size())
      {
        CheckBox localCheckBox = a((SelectBean)localList.get(i1));
        this.m.addView(localCheckBox);
        i1 += 1;
      }
    }
  }
  
  private void c()
  {
    List localList = n.getFeature();
    if ((localList == null) || (localList.size() < 1)) {
      this.j.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.k.removeAllViews();
      int i1 = 0;
      while (i1 < localList.size())
      {
        CheckBox localCheckBox = a((SelectBean)localList.get(i1));
        this.k.addView(localCheckBox);
        i1 += 1;
      }
    }
  }
  
  private void d()
  {
    List localList = n.getStyle();
    if ((localList == null) || (localList.size() < 1)) {
      this.h.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.i.removeAllViews();
      int i1 = 0;
      while (i1 < localList.size())
      {
        CheckBox localCheckBox = a((SelectBean)localList.get(i1));
        this.i.addView(localCheckBox);
        i1 += 1;
      }
    }
  }
  
  private void e()
  {
    List localList = n.getFace();
    if ((localList == null) || (localList.size() < 1)) {
      this.f.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.g.removeAllViews();
      int i1 = 0;
      while (i1 < localList.size())
      {
        CheckBox localCheckBox = a((SelectBean)localList.get(i1));
        this.g.addView(localCheckBox);
        i1 += 1;
      }
    }
  }
  
  private void f()
  {
    a(this.g);
    a(this.i);
    a(this.k);
    a(this.m);
  }
  
  private void g()
  {
    this.o = b(this.g);
    this.p = b(this.i);
    this.r = b(this.k);
    this.q = b(this.m);
    if (this.u != null) {
      this.u.onSelect(this.o, this.p, this.r, this.q);
    }
    dismiss();
  }
  
  public void initSelect(SearchCondition paramSearchCondition)
  {
    if (paramSearchCondition == null) {
      return;
    }
    this.s = paramSearchCondition;
    paramSearchCondition = this.s.getFace();
    String str1 = this.s.getStyle();
    String str2 = this.s.getConfigs();
    String str3 = this.s.getTags();
    a(this.g, paramSearchCondition);
    a(this.m, str2);
    a(this.k, str3);
    a(this.i, str1);
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
      f();
      w.onEventToZiroomAndUmeng("entire_list_more_reset");
      return;
    }
    g();
    w.onEventToZiroomAndUmeng("entire_list_more_confirm");
  }
  
  public void setCondition(ZZSelectCondition paramZZSelectCondition)
  {
    n = paramZZSelectCondition;
    if (n != null)
    {
      e();
      d();
      c();
      b();
    }
  }
  
  public void setOnSureListener(a parama)
  {
    this.u = parama;
  }
  
  public void setPopDismisListener(HouseList_ConditionalView.c paramc)
  {
    this.t = paramc;
  }
  
  public void setSelectCondition(ZZSelectCondition paramZZSelectCondition)
  {
    n = paramZZSelectCondition;
  }
  
  public void showAsDropDown(View paramView, SearchCondition paramSearchCondition)
  {
    if (!(this instanceof PopupWindow)) {
      super.showAsDropDown(paramView);
    }
    for (;;)
    {
      if (paramSearchCondition != null) {
        initSelect(paramSearchCondition);
      }
      return;
      VdsAgent.showAsDropDown((PopupWindow)this, paramView);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onSelect(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/widget/ZZ_ListMorePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */