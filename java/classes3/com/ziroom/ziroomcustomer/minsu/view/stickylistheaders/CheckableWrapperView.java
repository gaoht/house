package com.ziroom.ziroomcustomer.minsu.view.stickylistheaders;

import android.content.Context;
import android.widget.Checkable;

class CheckableWrapperView
  extends WrapperView
  implements Checkable
{
  public CheckableWrapperView(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean isChecked()
  {
    return ((Checkable)this.a).isChecked();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    ((Checkable)this.a).setChecked(paramBoolean);
  }
  
  public void toggle()
  {
    if (!isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/stickylistheaders/CheckableWrapperView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */