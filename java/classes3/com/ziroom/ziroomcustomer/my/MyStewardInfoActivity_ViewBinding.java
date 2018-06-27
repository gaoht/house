package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.widget.StarBar;

public class MyStewardInfoActivity_ViewBinding<T extends MyStewardInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public MyStewardInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mBztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'mBztb'", BasicZiroomToolBar.class));
    paramT.my_steward_rb = ((StarBar)Utils.findRequiredViewAsType(paramView, 2131696992, "field 'my_steward_rb'", StarBar.class));
    paramT.my_steward_img = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131696990, "field 'my_steward_img'", SimpleDraweeView.class));
    paramT.my_steward_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696991, "field 'my_steward_name'", TextView.class));
    paramT.my_steward_score = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696993, "field 'my_steward_score'", TextView.class));
    paramT.my_steward_phone = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696995, "field 'my_steward_phone'", TextView.class));
    paramT.my_steward_introduction = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696996, "field 'my_steward_introduction'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131696997, "field 'my_steward_btn' and method 'onClic'");
    paramT.my_steward_btn = ((TextView)Utils.castView(localView, 2131696997, "field 'my_steward_btn'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131696998, "field 'btn_to_evaluate' and method 'onClic'");
    paramT.btn_to_evaluate = ((TextView)Utils.castView(paramView, 2131696998, "field 'btn_to_evaluate'", TextView.class));
    this.c = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    MyStewardInfoActivity localMyStewardInfoActivity = this.a;
    if (localMyStewardInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyStewardInfoActivity.mBztb = null;
    localMyStewardInfoActivity.my_steward_rb = null;
    localMyStewardInfoActivity.my_steward_img = null;
    localMyStewardInfoActivity.my_steward_name = null;
    localMyStewardInfoActivity.my_steward_score = null;
    localMyStewardInfoActivity.my_steward_phone = null;
    localMyStewardInfoActivity.my_steward_introduction = null;
    localMyStewardInfoActivity.my_steward_btn = null;
    localMyStewardInfoActivity.btn_to_evaluate = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyStewardInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */