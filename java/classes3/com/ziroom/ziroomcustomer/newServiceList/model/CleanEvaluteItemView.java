package com.ziroom.ziroomcustomer.newServiceList.model;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CleanEvaluteItemView
  extends RelativeLayout
{
  private TextView a;
  private LinearLayout b;
  private RadioButton c;
  private RadioButton d;
  private RadioButton e;
  
  public CleanEvaluteItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CleanEvaluteItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    setItemName(paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/com.ziroom.ziroomcustomer", "title"));
  }
  
  public CleanEvaluteItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = View.inflate(paramContext, 2130904162, this);
    this.a = ((TextView)findViewById(2131694920));
    this.b = ((LinearLayout)findViewById(2131694919));
    this.c = ((RadioButton)paramContext.findViewById(2131694922));
    this.d = ((RadioButton)paramContext.findViewById(2131694923));
    this.e = ((RadioButton)paramContext.findViewById(2131694924));
  }
  
  public int getClickType()
  {
    if (this.c.isChecked()) {}
    do
    {
      return 1;
      if (this.d.isChecked()) {
        return 2;
      }
    } while (!this.e.isChecked());
    return 3;
  }
  
  public void setItemName(String paramString)
  {
    this.a.setText(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/model/CleanEvaluteItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */