package com.ziroom.ziroomcustomer.findhouse.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.model.SelectCondition.SelectType;
import com.ziroom.ziroomcustomer.findhouse.model.SelectCondition.TypeExtra;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.FourItemLayout;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HouseTypeView
  extends LinearLayout
{
  private Context a;
  private TextView b;
  private TextView c;
  private TextView d;
  private FourItemLayout e;
  private float f;
  
  public HouseTypeView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HouseTypeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HouseTypeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    this.f = this.a.getResources().getDisplayMetrics().density;
    setOrientation(1);
    b();
    c();
    d();
    e();
  }
  
  private void b()
  {
    this.b = new TextView(this.a);
    this.b.setTextColor(this.a.getResources().getColor(2131624416));
    this.b.setTextSize(2, 14.0F);
    this.b.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = ((int)(8.0F * this.f));
    localLayoutParams.gravity = 17;
    this.b.setLayoutParams(localLayoutParams);
    addView(this.b);
  }
  
  private void c()
  {
    this.c = new TextView(this.a);
    this.c.setTextColor(Color.parseColor("#BEBEBE"));
    this.c.setTextSize(2, 12.0F);
    this.c.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = ((int)(8.0F * this.f));
    localLayoutParams.bottomMargin = ((int)(20.0F * this.f));
    localLayoutParams.gravity = 17;
    this.c.setLayoutParams(localLayoutParams);
    addView(this.c);
  }
  
  private void d()
  {
    this.e = new FourItemLayout(this.a);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 17;
    this.e.setLayoutParams(localLayoutParams);
    addView(this.e);
  }
  
  private void e()
  {
    this.d = new TextView(this.a);
    this.d.setTextColor(this.a.getResources().getColor(2131624417));
    this.d.setTextSize(2, 12.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = ((int)(20.0F * this.f));
    localLayoutParams.gravity = 17;
    this.d.setGravity(17);
    this.d.setLayoutParams(localLayoutParams);
    addView(this.d);
    this.d.setVisibility(8);
  }
  
  public void clearSelect()
  {
    b.clearSelect(this.e);
  }
  
  public String getTypeShow()
  {
    return b.getTypeShow(this.e);
  }
  
  public String getTypeTitle()
  {
    return b.getTypeTitle(this.e);
  }
  
  public String getTypeValue()
  {
    return b.joinTypeString(this.e);
  }
  
  public void setContent(final SelectCondition.TypeExtra paramTypeExtra, List<SelectCondition.SelectType> paramList)
  {
    if (paramTypeExtra == null) {}
    do
    {
      return;
      this.b.setText(paramTypeExtra.getTitle());
      this.c.setText(paramTypeExtra.getDesc());
      this.e.removeAllViews();
      if ((paramList == null) || (paramList.size() < 1)) {
        setVisibility(8);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SelectCondition.SelectType localSelectType = (SelectCondition.SelectType)paramList.next();
        if (localSelectType != null)
        {
          CheckBox localCheckBox = b.getCheckBox(this.a);
          localCheckBox.setText(localSelectType.getTitle());
          localCheckBox.setTag(localSelectType);
          this.e.addView(localCheckBox);
        }
      }
    } while (TextUtils.isEmpty(paramTypeExtra.getLink()));
    this.d.setVisibility(0);
    this.d.setText(paramTypeExtra.getLink_text() + "  >");
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        JsBridgeWebActivity.start(HouseTypeView.a(HouseTypeView.this), paramTypeExtra.getLink_title(), paramTypeExtra.getLink());
      }
    });
  }
  
  public void setTypeState(HashSet<Integer> paramHashSet)
  {
    b.setTypeState(this.e, paramHashSet);
  }
  
  public void setViewSelect(String paramString)
  {
    b.setViewSelecet(paramString, this.e);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/HouseTypeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */