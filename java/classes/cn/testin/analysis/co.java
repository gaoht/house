package cn.testin.analysis;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class co
  extends View.AccessibilityDelegate
{
  private View.AccessibilityDelegate b;
  
  public co(cn paramcn, View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    this.b = paramAccessibilityDelegate;
  }
  
  public View.AccessibilityDelegate a()
  {
    return this.b;
  }
  
  public void a(co paramco)
  {
    if (this.b == paramco) {
      this.b = paramco.a();
    }
    while (!(this.b instanceof co)) {
      return;
    }
    ((co)this.b).a(paramco);
  }
  
  public boolean a(String paramString)
  {
    if (this.a.c() == paramString) {
      return true;
    }
    if ((this.b instanceof co)) {
      return ((co)this.b).a(paramString);
    }
    return false;
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt == cn.a(this.a)) {
      this.a.b(paramView);
    }
    if (this.b != null) {
      this.b.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */