package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class AptitudeEditActivity_ViewBinding<T extends AptitudeEditActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public AptitudeEditActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.aptitude_edit_search = ((EditText)Utils.findRequiredViewAsType(paramView, 2131689943, "field 'aptitude_edit_search'", EditText.class));
    paramT.aptitude_edit_list = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689942, "field 'aptitude_edit_list'", ListView.class));
    View localView = Utils.findRequiredView(paramView, 2131689946, "field 'aptitudeEdit_ll_search' and method 'onClick'");
    paramT.aptitudeEdit_ll_search = ((LinearLayout)Utils.castView(localView, 2131689946, "field 'aptitudeEdit_ll_search'", LinearLayout.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.aptitudeEdit_tv_keyWord = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689947, "field 'aptitudeEdit_tv_keyWord'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131689944, "field 'aptitude_edit_clean' and method 'onClick'");
    paramT.aptitude_edit_clean = ((ImageView)Utils.castView(localView, 2131689944, "field 'aptitude_edit_clean'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131689945, "method 'onClick'");
    this.d = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    AptitudeEditActivity localAptitudeEditActivity = this.a;
    if (localAptitudeEditActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localAptitudeEditActivity.aptitude_edit_search = null;
    localAptitudeEditActivity.aptitude_edit_list = null;
    localAptitudeEditActivity.aptitudeEdit_ll_search = null;
    localAptitudeEditActivity.aptitudeEdit_tv_keyWord = null;
    localAptitudeEditActivity.aptitude_edit_clean = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/AptitudeEditActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */