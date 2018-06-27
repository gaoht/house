package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

public class MyChatEditText
  extends EditText
{
  private a a;
  
  public MyChatEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public MyChatEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MyChatEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public MyChatEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    if (this.a != null) {
      this.a.onDispatchKeyEventPreIme(paramKeyEvent);
    }
    return super.dispatchKeyEventPreIme(paramKeyEvent);
  }
  
  public void setOnDispatchKeyEventListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onDispatchKeyEventPreIme(KeyEvent paramKeyEvent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/MyChatEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */