package com.ziroom.ziroomcustomer.minsu.landlordrelease.qualification;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class PersonalActivity_ViewBinding<T extends PersonalActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public PersonalActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691055, "field 'head_pic' and method 'onClick'");
    paramT.head_pic = ((SimpleDraweeView)Utils.castView(localView, 2131691055, "field 'head_pic'", SimpleDraweeView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.et_nickname = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691057, "field 'et_nickname'", EditText.class));
    paramT.et_personal = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691058, "field 'et_personal'", EditText.class));
    localView = Utils.findRequiredView(paramView, 2131690401, "field 'tv_info_save' and method 'onClick'");
    paramT.tv_info_save = ((TextView)Utils.castView(localView, 2131690401, "field 'tv_info_save'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690637, "method 'onClick'");
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131689492, "method 'onClick'");
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
    PersonalActivity localPersonalActivity = this.a;
    if (localPersonalActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPersonalActivity.head_pic = null;
    localPersonalActivity.et_nickname = null;
    localPersonalActivity.et_personal = null;
    localPersonalActivity.tv_info_save = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/qualification/PersonalActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */