package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;

public class NewZZKeysActivity_ViewBinding<T extends NewZZKeysActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public NewZZKeysActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.new_zz_keys_list = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131697107, "field 'new_zz_keys_list'", ListViewForScrollView.class));
    View localView = Utils.findRequiredView(paramView, 2131697102, "field 'new_zz_keys_btn' and method 'onClick'");
    paramT.new_zz_keys_btn = ((Button)Utils.castView(localView, 2131697102, "field 'new_zz_keys_btn'", Button.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.new_zz_keys_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697106, "field 'new_zz_keys_text'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131697105, "field 'new_zz_keys_content' and method 'onClick'");
    paramT.new_zz_keys_content = ((TextView)Utils.castView(localView, 2131697105, "field 'new_zz_keys_content'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.new_zz_keys_scroll = ((ScrollView)Utils.findRequiredViewAsType(paramView, 2131697103, "field 'new_zz_keys_scroll'", ScrollView.class));
    paramT.new_zz_keys_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697104, "field 'new_zz_keys_title'", TextView.class));
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
    NewZZKeysActivity localNewZZKeysActivity = this.a;
    if (localNewZZKeysActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localNewZZKeysActivity.new_zz_keys_list = null;
    localNewZZKeysActivity.new_zz_keys_btn = null;
    localNewZZKeysActivity.new_zz_keys_text = null;
    localNewZZKeysActivity.new_zz_keys_content = null;
    localNewZZKeysActivity.new_zz_keys_scroll = null;
    localNewZZKeysActivity.new_zz_keys_title = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/NewZZKeysActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */