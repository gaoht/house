package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class AptitudeCertifierNameActivity_ViewBinding<T extends AptitudeCertifierNameActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public AptitudeCertifierNameActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.edit_Search = ((EditText)Utils.findRequiredViewAsType(paramView, 2131689934, "field 'edit_Search'", EditText.class));
    paramT.aptitude_edit_delete = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689941, "field 'aptitude_edit_delete'", ImageView.class));
    View localView = Utils.findRequiredView(paramView, 2131689895, "field 'tv_back' and method 'onClick'");
    paramT.tv_back = ((TextView)Utils.castView(localView, 2131689895, "field 'tv_back'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.aptitude_edit_list = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689942, "field 'aptitude_edit_list'", ListView.class));
  }
  
  public void unbind()
  {
    AptitudeCertifierNameActivity localAptitudeCertifierNameActivity = this.a;
    if (localAptitudeCertifierNameActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localAptitudeCertifierNameActivity.edit_Search = null;
    localAptitudeCertifierNameActivity.aptitude_edit_delete = null;
    localAptitudeCertifierNameActivity.tv_back = null;
    localAptitudeCertifierNameActivity.aptitude_edit_list = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/AptitudeCertifierNameActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */