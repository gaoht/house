package com.ziroom.ziroomcustomer.findhouse;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.findhouse.widget.HouseList_ConditionalView;
import com.ziroom.ziroomcustomer.widget.HouseListXListView;

public class HouseListActivity_ViewBinding<T extends HouseListActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public HouseListActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'mIvBack' and method 'onClick'");
    paramT.mIvBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'mIvBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689940, "field 'mEditSearch' and method 'onClick'");
    paramT.mEditSearch = ((TextView)Utils.castView(localView, 2131689940, "field 'mEditSearch'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690895, "field 'mIvMap' and method 'onClick'");
    paramT.mIvMap = ((ImageView)Utils.castView(localView, 2131690895, "field 'mIvMap'", ImageView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mConditionalView = ((HouseList_ConditionalView)Utils.findRequiredViewAsType(paramView, 2131690896, "field 'mConditionalView'", HouseList_ConditionalView.class));
    paramT.mRvRapid = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131690897, "field 'mRvRapid'", RecyclerView.class));
    paramT.mXListView = ((HouseListXListView)Utils.findRequiredViewAsType(paramView, 2131690898, "field 'mXListView'", HouseListXListView.class));
    localView = Utils.findRequiredView(paramView, 2131690900, "field 'mTv_sort' and method 'onClick'");
    paramT.mTv_sort = ((TextView)Utils.castView(localView, 2131690900, "field 'mTv_sort'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mIv_tips_zhuanzu = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690899, "field 'mIv_tips_zhuanzu'", ImageView.class));
    paramT.iv_collect_tips = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690901, "field 'iv_collect_tips'", ImageView.class));
  }
  
  public void unbind()
  {
    HouseListActivity localHouseListActivity = this.a;
    if (localHouseListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localHouseListActivity.mIvBack = null;
    localHouseListActivity.mEditSearch = null;
    localHouseListActivity.mIvMap = null;
    localHouseListActivity.mConditionalView = null;
    localHouseListActivity.mRvRapid = null;
    localHouseListActivity.mXListView = null;
    localHouseListActivity.mTv_sort = null;
    localHouseListActivity.mIv_tips_zhuanzu = null;
    localHouseListActivity.iv_collect_tips = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/HouseListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */