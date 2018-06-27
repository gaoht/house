package com.ziroom.ziroomcustomer.my.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.my.model.InvoiceAvailableInfo.MonthInfo;

public class InvoiceRentMonthCheckBox
  extends LinearLayout
{
  private Context a;
  private float b;
  private CheckBox c;
  private TextView d;
  private TextView e;
  
  public InvoiceRentMonthCheckBox(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InvoiceRentMonthCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InvoiceRentMonthCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.b = this.a.getResources().getDisplayMetrics().density;
    setOrientation(0);
    setGravity(16);
    a();
  }
  
  private void a()
  {
    c();
    d();
    b();
    setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = InvoiceRentMonthCheckBox.a(InvoiceRentMonthCheckBox.this);
        if (!InvoiceRentMonthCheckBox.a(InvoiceRentMonthCheckBox.this).isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          return;
        }
      }
    });
  }
  
  private void b()
  {
    int i = (int)(18.0F * this.b);
    this.c = new CheckBox(this.a);
    this.c.setButtonDrawable(null);
    this.c.setBackgroundResource(2130839471);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    this.c.setLayoutParams(localLayoutParams);
    addView(this.c);
  }
  
  private void c()
  {
    this.d = new TextView(this.a);
    this.d.setTextColor(this.a.getResources().getColor(2131624416));
    this.d.setTextSize(2, 14.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = ((int)(10.0F * this.b));
    this.d.setLayoutParams(localLayoutParams);
    addView(this.d);
  }
  
  private void d()
  {
    this.e = new TextView(this.a);
    this.e.setTextColor(this.a.getResources().getColor(2131624417));
    this.e.setTextSize(2, 14.0F);
    this.e.setSingleLine(true);
    this.e.setEllipsize(TextUtils.TruncateAt.END);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams.weight = 1.0F;
    addView(this.e, localLayoutParams);
  }
  
  public InvoiceAvailableInfo.MonthInfo getMonthInfo()
  {
    return (InvoiceAvailableInfo.MonthInfo)getTag();
  }
  
  public boolean isChecked()
  {
    return this.c.isChecked();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.c.setChecked(paramBoolean);
  }
  
  public void setContent(InvoiceAvailableInfo.MonthInfo paramMonthInfo)
  {
    setTag(paramMonthInfo);
    this.d.setText(paramMonthInfo.getMonthNum());
    this.e.setText("(" + paramMonthInfo.getStartTime() + " - " + paramMonthInfo.getEndTime() + ")");
  }
  
  public void setOnCheckChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.c.setOnCheckedChangeListener(paramOnCheckedChangeListener);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/InvoiceRentMonthCheckBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */