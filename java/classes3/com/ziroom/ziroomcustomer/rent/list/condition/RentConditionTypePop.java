package com.ziroom.ziroomcustomer.rent.list.condition;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.model.rent.RentTypeConditionItem;
import com.ziroom.ziroomcustomer.model.rent.RentTypeExtraConditionItem;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.FourItemLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RentConditionTypePop
  extends PopupWindow
  implements View.OnClickListener
{
  float a;
  private Context b;
  private LayoutInflater c;
  private View d;
  private TextView e;
  private TextView f;
  private LinearLayout g;
  private List<RentTypeConditionItem> h;
  private List<RentTypeExtraConditionItem> i;
  private List<CheckBox> j = new ArrayList();
  private a k;
  
  public RentConditionTypePop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RentConditionTypePop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RentConditionTypePop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    this.c = LayoutInflater.from(this.b);
    this.a = this.b.getResources().getDisplayMetrics().density;
    setSoftInputMode(16);
    setWidth(-1);
    if (Build.VERSION.SDK_INT >= 24) {
      setHeight(-2);
    }
    for (;;)
    {
      setAnimationStyle(2131427934);
      this.b = paramContext;
      this.d = LayoutInflater.from(paramContext).inflate(2130905060, null);
      a();
      return;
      setHeight(-1);
    }
  }
  
  private void a()
  {
    this.g = ((LinearLayout)this.d.findViewById(2131691838));
    this.e = ((TextView)this.d.findViewById(2131693064));
    this.f = ((TextView)this.d.findViewById(2131691289));
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss() {}
    });
    setContentView(this.d);
  }
  
  private void b()
  {
    if ((this.j != null) && (this.j.size() > 0))
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext()) {
        ((CheckBox)localIterator.next()).setChecked(false);
      }
    }
  }
  
  private void c()
  {
    if (this.k != null) {
      this.k.select(this.h);
    }
    dismiss();
  }
  
  private void d()
  {
    this.j.clear();
    this.g.removeAllViews();
    if ((this.h != null) && (this.i != null))
    {
      int m = 0;
      while (m < this.i.size())
      {
        final RentTypeExtraConditionItem localRentTypeExtraConditionItem = (RentTypeExtraConditionItem)this.i.get(m);
        LinearLayout localLinearLayout = (LinearLayout)this.c.inflate(2130904768, this.g, false);
        Object localObject1 = (TextView)localLinearLayout.findViewById(2131689541);
        Object localObject2 = (TextView)localLinearLayout.findViewById(2131690073);
        final Object localObject3 = (TextView)localLinearLayout.findViewById(2131693772);
        ((TextView)localObject1).setText(localRentTypeExtraConditionItem.getTitle());
        ((TextView)localObject2).setText(localRentTypeExtraConditionItem.getDesc());
        if (TextUtils.isEmpty(localRentTypeExtraConditionItem.getLink_text())) {
          ((TextView)localObject3).setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (FourItemLayout)localLinearLayout.findViewById(2131696387);
          localObject2 = this.h.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (RentTypeConditionItem)((Iterator)localObject2).next();
            if ((((RentTypeConditionItem)localObject3).getType() != null) && (localRentTypeExtraConditionItem.getType() != null) && (((RentTypeConditionItem)localObject3).getType() == localRentTypeExtraConditionItem.getType()))
            {
              CheckBox localCheckBox = e();
              localCheckBox.setText(((RentTypeConditionItem)localObject3).getTitle());
              localCheckBox.setChecked(((RentTypeConditionItem)localObject3).isCheck());
              localCheckBox.setTag(localObject3);
              localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
              {
                @Instrumented
                public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
                {
                  VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
                  localObject3.setCheck(paramAnonymousBoolean);
                }
              });
              ((FourItemLayout)localObject1).addView(localCheckBox);
              this.j.add(localCheckBox);
            }
          }
          ((TextView)localObject3).setVisibility(0);
          ((TextView)localObject3).setText(localRentTypeExtraConditionItem.getLink_text());
          ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              JsBridgeWebActivity.start(RentConditionTypePop.a(RentConditionTypePop.this), localRentTypeExtraConditionItem.getLink_text(), localRentTypeExtraConditionItem.getLink());
            }
          });
        }
        this.g.addView(localLinearLayout);
        m += 1;
      }
    }
  }
  
  private CheckBox e()
  {
    return getCheckBox(2130839489, 2131624647);
  }
  
  public CheckBox getCheckBox(int paramInt1, int paramInt2)
  {
    CheckBox localCheckBox = new CheckBox(this.b);
    localCheckBox.setTextSize(2, 14.0F);
    localCheckBox.setButtonDrawable(2131624576);
    localCheckBox.setGravity(17);
    localCheckBox.setSingleLine(true);
    localCheckBox.setSingleLine(true);
    localCheckBox.setEllipsize(null);
    localCheckBox.setBackgroundResource(paramInt1);
    localCheckBox.setTextColor(this.b.getResources().getColorStateList(paramInt2));
    paramInt1 = (int)(8.0F * this.a);
    paramInt2 = (int)(this.a * 1.0F);
    localCheckBox.setPadding(paramInt2, paramInt1, paramInt2, paramInt1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.rightMargin = paramInt1;
    localCheckBox.setLayoutParams(localLayoutParams);
    localCheckBox.setIncludeFontPadding(false);
    return localCheckBox;
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
  
  public void setListener(a parama)
  {
    this.k = parama;
  }
  
  public void show(View paramView, List<RentTypeConditionItem> paramList, List<RentTypeExtraConditionItem> paramList1, a parama)
  {
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    setListener(parama);
    this.h = paramList;
    this.i = paramList1;
    d();
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
    public abstract void select(List<RentTypeConditionItem> paramList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/rent/list/condition/RentConditionTypePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */