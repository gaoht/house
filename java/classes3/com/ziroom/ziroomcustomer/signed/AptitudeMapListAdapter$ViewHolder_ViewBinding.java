package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class AptitudeMapListAdapter$ViewHolder_ViewBinding<T extends AptitudeMapListAdapter.ViewHolder>
  implements Unbinder
{
  protected T a;
  
  public AptitudeMapListAdapter$ViewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.aptitude_address_check = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131693147, "field 'aptitude_address_check'", ImageView.class));
    paramT.aptitude_address_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693145, "field 'aptitude_address_title'", TextView.class));
    paramT.aptitude_address_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693146, "field 'aptitude_address_content'", TextView.class));
    paramT.aptitude_address_leftIcon = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131693144, "field 'aptitude_address_leftIcon'", ImageView.class));
  }
  
  public void unbind()
  {
    AptitudeMapListAdapter.ViewHolder localViewHolder = this.a;
    if (localViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localViewHolder.aptitude_address_check = null;
    localViewHolder.aptitude_address_title = null;
    localViewHolder.aptitude_address_content = null;
    localViewHolder.aptitude_address_leftIcon = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/AptitudeMapListAdapter$ViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */