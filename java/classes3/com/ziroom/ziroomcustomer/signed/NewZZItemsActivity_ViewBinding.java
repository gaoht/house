package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;

public class NewZZItemsActivity_ViewBinding<T extends NewZZItemsActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public NewZZItemsActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.new_zz_items_list = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131697097, "field 'new_zz_items_list'", ListViewForScrollView.class));
    paramT.new_zz_items_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697096, "field 'new_zz_items_text'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131697095, "field 'new_zz_items_content' and method 'onClick'");
    paramT.new_zz_items_content = ((TextView)Utils.castView(localView, 2131697095, "field 'new_zz_items_content'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.new_zz_items_scroll = ((ScrollView)Utils.findRequiredViewAsType(paramView, 2131697093, "field 'new_zz_items_scroll'", ScrollView.class));
    paramT.new_zz_items_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697094, "field 'new_zz_items_title'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131697092, "field 'new_zz_items_btn' and method 'onClick'");
    paramT.new_zz_items_btn = ((Button)Utils.castView(localView, 2131697092, "field 'new_zz_items_btn'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
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
    NewZZItemsActivity localNewZZItemsActivity = this.a;
    if (localNewZZItemsActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localNewZZItemsActivity.new_zz_items_list = null;
    localNewZZItemsActivity.new_zz_items_text = null;
    localNewZZItemsActivity.new_zz_items_content = null;
    localNewZZItemsActivity.new_zz_items_scroll = null;
    localNewZZItemsActivity.new_zz_items_title = null;
    localNewZZItemsActivity.new_zz_items_btn = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/NewZZItemsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */