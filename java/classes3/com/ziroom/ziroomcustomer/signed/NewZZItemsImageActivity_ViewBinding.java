package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class NewZZItemsImageActivity_ViewBinding<T extends NewZZItemsImageActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public NewZZItemsImageActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramView = Utils.findRequiredView(paramView, 2131697098, "field 'img' and method 'onClick'");
    paramT.img = ((SimpleDraweeView)Utils.castView(paramView, 2131697098, "field 'img'", SimpleDraweeView.class));
    this.b = paramView;
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
    NewZZItemsImageActivity localNewZZItemsImageActivity = this.a;
    if (localNewZZItemsImageActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localNewZZItemsImageActivity.img = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/NewZZItemsImageActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */