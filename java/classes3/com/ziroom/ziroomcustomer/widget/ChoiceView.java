package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ChoiceView
  extends FrameLayout
  implements Checkable
{
  private TextView a;
  private RadioButton b;
  
  public ChoiceView(Context paramContext)
  {
    super(paramContext);
    View.inflate(paramContext, 2130904533, this);
    this.a = ((TextView)findViewById(2131695676));
    this.b = ((RadioButton)findViewById(2131695675));
  }
  
  public boolean isChecked()
  {
    return this.b.isChecked();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.b.setChecked(paramBoolean);
  }
  
  public void setText(String paramString)
  {
    this.a.setText(paramString);
  }
  
  public void toggle()
  {
    this.b.toggle();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ChoiceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */