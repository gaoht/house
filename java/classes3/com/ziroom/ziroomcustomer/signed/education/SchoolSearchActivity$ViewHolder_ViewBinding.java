package com.ziroom.ziroomcustomer.signed.education;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class SchoolSearchActivity$ViewHolder_ViewBinding<T extends SchoolSearchActivity.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public SchoolSearchActivity$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tvName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690049, "field 'tvName'", TextView.class));
  }
  
  public void unbind()
  {
    SchoolSearchActivity.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.tvName = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/education/SchoolSearchActivity$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */