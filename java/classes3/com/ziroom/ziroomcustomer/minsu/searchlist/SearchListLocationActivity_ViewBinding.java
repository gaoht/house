package com.ziroom.ziroomcustomer.minsu.searchlist;

import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class SearchListLocationActivity_ViewBinding<T extends SearchListLocationActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public SearchListLocationActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.lv_level_1 = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691553, "field 'lv_level_1'", ListView.class));
    paramT.lv_level_2 = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691554, "field 'lv_level_2'", ListView.class));
    paramT.lv_level_3 = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691555, "field 'lv_level_3'", ListView.class));
    View localView = Utils.findRequiredView(paramView, 2131690460, "method 'OnClick'");
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131691673, "method 'OnClick'");
    this.c = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    SearchListLocationActivity localSearchListLocationActivity = this.a;
    if (localSearchListLocationActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSearchListLocationActivity.lv_level_1 = null;
    localSearchListLocationActivity.lv_level_2 = null;
    localSearchListLocationActivity.lv_level_3 = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/SearchListLocationActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */