package com.ziroom.ziroomcustomer.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class YezhuStoryListActivity_ViewBinding<T extends YezhuStoryListActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public YezhuStoryListActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tv_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tv_title'", TextView.class));
    paramT.ll_yezhu_story_list = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692666, "field 'll_yezhu_story_list'", LinearLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131691914, "method 'onClick'");
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
    YezhuStoryListActivity localYezhuStoryListActivity = this.a;
    if (localYezhuStoryListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localYezhuStoryListActivity.tv_title = null;
    localYezhuStoryListActivity.ll_yezhu_story_list = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/YezhuStoryListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */