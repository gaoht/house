package com.ziroom.ziroomcustomer.minsu.homecolumn;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;

public class MinsuArticleColumnActivity_ViewBinding<T extends MinsuArticleColumnActivity>
  implements Unbinder
{
  protected T a;
  
  public MinsuArticleColumnActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.bztb_title = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131691043, "field 'bztb_title'", BasicZiroomToolBar.class));
    paramT.rv_list = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131691646, "field 'rv_list'", RecyclerView.class));
  }
  
  public void unbind()
  {
    MinsuArticleColumnActivity localMinsuArticleColumnActivity = this.a;
    if (localMinsuArticleColumnActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuArticleColumnActivity.bztb_title = null;
    localMinsuArticleColumnActivity.rv_list = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/homecolumn/MinsuArticleColumnActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */