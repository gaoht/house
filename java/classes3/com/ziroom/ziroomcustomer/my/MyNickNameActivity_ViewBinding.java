package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MyNickNameActivity_ViewBinding<T extends MyNickNameActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public MyNickNameActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mEtNickName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691057, "field 'mEtNickName'", TextView.class));
    Object localObject = Utils.findRequiredView(paramView, 2131691837, "field 'mBtnSave' and method 'onViewClick'");
    paramT.mBtnSave = ((TextView)Utils.castView((View)localObject, 2131691837, "field 'mBtnSave'", TextView.class));
    this.b = ((View)localObject);
    ((View)localObject).setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localObject = Utils.findRequiredView(paramView, 2131689895, "field 'tvBack' and method 'onViewClick'");
    paramT.tvBack = ((ImageView)Utils.castView((View)localObject, 2131689895, "field 'tvBack'", ImageView.class));
    this.c = ((View)localObject);
    ((View)localObject).setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localObject = Utils.findRequiredView(paramView, 2131691648, "method 'onViewClick'");
    this.d = ((View)localObject);
    ((View)localObject).setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localObject = paramView.getContext();
    paramView = ((Context)localObject).getResources();
    localObject = ((Context)localObject).getTheme();
    paramT.mColorGray44 = Utils.getColor(paramView, (Resources.Theme)localObject, 2131624392);
    paramT.mColorOrangeFFA000 = Utils.getColor(paramView, (Resources.Theme)localObject, 2131624516);
    paramT.mColorGray99 = Utils.getColor(paramView, (Resources.Theme)localObject, 2131624393);
  }
  
  public void unbind()
  {
    MyNickNameActivity localMyNickNameActivity = this.a;
    if (localMyNickNameActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyNickNameActivity.mEtNickName = null;
    localMyNickNameActivity.mBtnSave = null;
    localMyNickNameActivity.tvBack = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyNickNameActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */