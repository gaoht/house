package com.ziroom.ziroomcustomer.minsu.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.minsu.f.ab;

public class e
{
  private TextView a;
  private TextView b;
  private ImageView c;
  
  public String getValue()
  {
    return this.b.getText() + "";
  }
  
  public e init(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131694588));
    this.b = ((TextView)paramView.findViewById(2131691546));
    this.c = ((ImageView)paramView.findViewById(2131694102));
    ab.widthHeight(this.c, this.a.getLineHeight() * 8 / 10);
    return this;
  }
  
  public e setArrowVisibility(int paramInt)
  {
    this.c.setVisibility(paramInt);
    return this;
  }
  
  public e setKeyLength(int paramInt)
  {
    ab.width(this.a, paramInt);
    return this;
  }
  
  public e setKeyText(String paramString)
  {
    this.a.setText(paramString);
    return this;
  }
  
  public e setValueGravity(int paramInt)
  {
    this.b.setGravity(paramInt);
    return this;
  }
  
  public e setValueHint(String paramString)
  {
    this.b.setHint(paramString);
    return this;
  }
  
  public e setValueText(String paramString)
  {
    this.b.setText(paramString);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */