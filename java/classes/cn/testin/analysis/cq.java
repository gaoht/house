package cn.testin.analysis;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

class cq
  implements TextWatcher
{
  private final View b;
  
  public cq(cp paramcp, View paramView)
  {
    this.b = paramView;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    ar.f("textchange");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */