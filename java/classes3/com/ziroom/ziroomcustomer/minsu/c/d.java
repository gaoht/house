package com.ziroom.ziroomcustomer.minsu.c;

import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.ziroomcustomer.minsu.f.ab;

public class d
{
  private TextView a;
  private EditText b;
  private ImageView c;
  
  public EditText getEt()
  {
    return this.b;
  }
  
  public String getValue()
  {
    return VdsAgent.trackEditTextSilent(this.b) + "";
  }
  
  public d init(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131694588));
    this.b = ((EditText)paramView.findViewById(2131694589));
    this.c = ((ImageView)paramView.findViewById(2131694102));
    ab.widthHeight(this.c, this.a.getLineHeight());
    return this;
  }
  
  public d setArrowVisibility(int paramInt)
  {
    this.c.setVisibility(paramInt);
    return this;
  }
  
  public d setKeyLength(int paramInt)
  {
    ab.width(this.a, paramInt);
    return this;
  }
  
  public d setKeyText(String paramString)
  {
    this.a.setText(paramString);
    return this;
  }
  
  public d setValueEnable(boolean paramBoolean)
  {
    this.b.setEnabled(paramBoolean);
    return this;
  }
  
  public d setValueGravity(int paramInt)
  {
    this.b.setGravity(paramInt);
    return this;
  }
  
  public d setValueHint(String paramString)
  {
    this.b.setHint(paramString);
    return this;
  }
  
  public d setValueText(String paramString)
  {
    this.b.setText(paramString);
    return this;
  }
  
  public d textWatcher(TextWatcher paramTextWatcher)
  {
    this.b.addTextChangedListener(paramTextWatcher);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */