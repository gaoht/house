package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;

public class NewZZLivingsActivity_ViewBinding<T extends NewZZLivingsActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public NewZZLivingsActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.new_zz_livings_list = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131697116, "field 'new_zz_livings_list'", ListViewForScrollView.class));
    View localView = Utils.findRequiredView(paramView, 2131697111, "field 'new_zz_livings_btn' and method 'onClick'");
    paramT.new_zz_livings_btn = ((Button)Utils.castView(localView, 2131697111, "field 'new_zz_livings_btn'", Button.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.new_zz_livings_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697115, "field 'new_zz_livings_text'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131697114, "field 'new_zz_livings_content' and method 'onClick'");
    paramT.new_zz_livings_content = ((TextView)Utils.castView(localView, 2131697114, "field 'new_zz_livings_content'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.new_zz_livings_scroll = ((ScrollView)Utils.findRequiredViewAsType(paramView, 2131697112, "field 'new_zz_livings_scroll'", ScrollView.class));
    paramT.new_zz_livings_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697113, "field 'new_zz_livings_title'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691914, "method 'onClick'");
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131690110, "method 'onClick'");
    this.e = paramView;
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
    NewZZLivingsActivity localNewZZLivingsActivity = this.a;
    if (localNewZZLivingsActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localNewZZLivingsActivity.new_zz_livings_list = null;
    localNewZZLivingsActivity.new_zz_livings_btn = null;
    localNewZZLivingsActivity.new_zz_livings_text = null;
    localNewZZLivingsActivity.new_zz_livings_content = null;
    localNewZZLivingsActivity.new_zz_livings_scroll = null;
    localNewZZLivingsActivity.new_zz_livings_title = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/NewZZLivingsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */