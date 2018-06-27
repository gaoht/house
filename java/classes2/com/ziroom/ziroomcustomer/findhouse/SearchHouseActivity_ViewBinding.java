package com.ziroom.ziroomcustomer.findhouse;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.flexbox.FlexboxLayout;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;

public class SearchHouseActivity_ViewBinding<T extends SearchHouseActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public SearchHouseActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.etSearch = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690906, "field 'etSearch'", EditText.class));
    View localView = Utils.findRequiredView(paramView, 2131692259, "field 'ivSearchRemove' and method 'onViewClicked'");
    paramT.ivSearchRemove = ((ImageView)Utils.castView(localView, 2131692259, "field 'ivSearchRemove'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690169, "field 'tvCancel' and method 'onViewClicked'");
    paramT.tvCancel = ((TextView)Utils.castView(localView, 2131690169, "field 'tvCancel'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvHotSearch = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692264, "field 'tvHotSearch'", TextView.class));
    paramT.flexHotSearch = ((FlexboxLayout)Utils.findRequiredViewAsType(paramView, 2131692265, "field 'flexHotSearch'", FlexboxLayout.class));
    paramT.llHistory = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690323, "field 'llHistory'", LinearLayout.class));
    paramT.tvHistory = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692260, "field 'tvHistory'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692261, "field 'tvHistoryClear' and method 'onViewClicked'");
    paramT.tvHistoryClear = ((TextView)Utils.castView(localView, 2131692261, "field 'tvHistoryClear'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.lvHistory = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131692262, "field 'lvHistory'", ListViewForScrollView.class));
    paramT.vHistoryDivider = Utils.findRequiredView(paramView, 2131692263, "field 'vHistoryDivider'");
    paramT.tvNearby = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692266, "field 'tvNearby'", TextView.class));
    paramT.lvfsvNearby = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131692267, "field 'lvfsvNearby'", ListViewForScrollView.class));
    paramT.vDividerNearby = Utils.findRequiredView(paramView, 2131692268, "field 'vDividerNearby'");
    paramT.scrollView = ((ScrollView)Utils.findRequiredViewAsType(paramView, 2131689709, "field 'scrollView'", ScrollView.class));
    paramT.lvSuggestion = ((ListView)Utils.findRequiredViewAsType(paramView, 2131692269, "field 'lvSuggestion'", ListView.class));
  }
  
  public void unbind()
  {
    SearchHouseActivity localSearchHouseActivity = this.a;
    if (localSearchHouseActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSearchHouseActivity.etSearch = null;
    localSearchHouseActivity.ivSearchRemove = null;
    localSearchHouseActivity.tvCancel = null;
    localSearchHouseActivity.tvHotSearch = null;
    localSearchHouseActivity.flexHotSearch = null;
    localSearchHouseActivity.llHistory = null;
    localSearchHouseActivity.tvHistory = null;
    localSearchHouseActivity.tvHistoryClear = null;
    localSearchHouseActivity.lvHistory = null;
    localSearchHouseActivity.vHistoryDivider = null;
    localSearchHouseActivity.tvNearby = null;
    localSearchHouseActivity.lvfsvNearby = null;
    localSearchHouseActivity.vDividerNearby = null;
    localSearchHouseActivity.scrollView = null;
    localSearchHouseActivity.lvSuggestion = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/SearchHouseActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */