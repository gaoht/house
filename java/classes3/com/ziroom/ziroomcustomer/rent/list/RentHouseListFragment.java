package com.ziroom.ziroomcustomer.rent.list;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.widget.imgpicker.ui.view.a;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.findhouse.model.HouseListItem;
import com.ziroom.ziroomcustomer.model.rent.FilterCondition;
import com.ziroom.ziroomcustomer.model.rent.RentCheckInDateCondition;
import com.ziroom.ziroomcustomer.model.rent.RentCondition;
import com.ziroom.ziroomcustomer.model.rent.RentConditionItem;
import com.ziroom.ziroomcustomer.model.rent.RentTypeConditionItem;
import com.ziroom.ziroomcustomer.model.rent.RentTypeExtraConditionItem;
import com.ziroom.ziroomcustomer.rent.list.condition.RentConditionTypePop;
import com.ziroom.ziroomcustomer.rent.list.condition.RentConditionTypePop.a;
import com.ziroom.ziroomcustomer.widget.SearchBar;
import com.ziroom.ziroomcustomer.widget.SearchBar.a;
import java.util.ArrayList;
import java.util.List;

public class RentHouseListFragment
  extends BaseFragment
  implements c.b
{
  List<SearchBar.a> a = new ArrayList();
  SearchBar.a b = new SearchBar.a()
  {
    public void onSearchItemClick(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean) {
        RentHouseListFragment.b(RentHouseListFragment.this).popTypeCondition();
      }
      while ((RentHouseListFragment.c(RentHouseListFragment.this) == null) || (!RentHouseListFragment.c(RentHouseListFragment.this).isShowing())) {
        return;
      }
      RentHouseListFragment.c(RentHouseListFragment.this).dismiss();
    }
  };
  SearchBar.a c = new SearchBar.a()
  {
    public void onSearchItemClick(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      g.textToast(RentHouseListFragment.d(RentHouseListFragment.this), "位置" + paramAnonymousBoolean);
    }
  };
  SearchBar.a d = new SearchBar.a()
  {
    public void onSearchItemClick(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      g.textToast(RentHouseListFragment.d(RentHouseListFragment.this), "时间" + paramAnonymousBoolean);
    }
  };
  SearchBar.a e = new SearchBar.a()
  {
    public void onSearchItemClick(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      g.textToast(RentHouseListFragment.d(RentHouseListFragment.this), "筛选" + paramAnonymousBoolean);
    }
  };
  private Context f;
  private c.a g;
  private SearchBar h;
  private RentConditionTypePop i;
  private AppBarLayout j;
  private ImageView k;
  private TextView l;
  private RecyclerView m;
  private b n;
  
  private void a(View paramView)
  {
    this.h = ((SearchBar)paramView.findViewById(2131690840));
    this.j = ((AppBarLayout)paramView.findViewById(2131694343));
    this.k = ((ImageView)paramView.findViewById(2131694344));
    this.l = ((TextView)paramView.findViewById(2131690073));
    this.m = ((RecyclerView)paramView.findViewById(2131690100));
    paramView = new LinearLayoutManager(this.f);
    paramView.setOrientation(1);
    this.m.setLayoutManager(paramView);
    this.m.addItemDecoration(new a(this.f));
    this.m.setItemAnimator(new v());
    this.n = new b(this.f, null, null);
    this.m.setAdapter(this.n);
  }
  
  public static RentHouseListFragment newInstance(RentCondition paramRentCondition)
  {
    RentHouseListFragment localRentHouseListFragment = new RentHouseListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("rent_condition", paramRentCondition);
    localRentHouseListFragment.setArguments(localBundle);
    return localRentHouseListFragment;
  }
  
  public FilterCondition getFilterCondition()
  {
    return this.g.getAllCondition();
  }
  
  public Context getViewContext()
  {
    return this.f;
  }
  
  public boolean isActive()
  {
    return isAdded();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.f = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2130903979, paramViewGroup, false);
    a(paramLayoutInflater);
    this.a.add(this.b);
    this.a.add(this.c);
    this.a.add(this.d);
    this.a.add(this.e);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.g != null) {
      this.g.detachView();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.g.start();
  }
  
  public void setPresenter(c.a parama)
  {
    this.g = parama;
  }
  
  public void showAddList(HouseListItem paramHouseListItem)
  {
    if (paramHouseListItem != null) {
      this.n.addHouseItems(paramHouseListItem.getRooms());
    }
  }
  
  public void showFilterPanel(int paramInt, RentConditionItem paramRentConditionItem1, RentConditionItem paramRentConditionItem2, RentConditionItem paramRentConditionItem3, RentConditionItem paramRentConditionItem4, RentConditionItem paramRentConditionItem5, RentConditionItem paramRentConditionItem6, RentConditionItem paramRentConditionItem7) {}
  
  public void showList(HouseListItem paramHouseListItem)
  {
    if (paramHouseListItem != null) {
      this.n.setData(paramHouseListItem.getRooms(), paramHouseListItem.getOptions());
    }
  }
  
  public void showLocationPanel() {}
  
  public void showSearchBar(List<String> paramList, List<Boolean> paramList1)
  {
    this.h.setData(paramList, this.a, paramList1);
  }
  
  public void showSortPanel(RentConditionItem paramRentConditionItem) {}
  
  public void showTimePanel(RentCheckInDateCondition paramRentCheckInDateCondition) {}
  
  public void showTypePanel(List<RentTypeConditionItem> paramList, List<RentTypeExtraConditionItem> paramList1)
  {
    if (this.i == null)
    {
      this.i = new RentConditionTypePop(this.f);
      this.i.setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public void onDismiss()
        {
          RentHouseListFragment.a(RentHouseListFragment.this).setItemSelectStatus(0, false);
        }
      });
    }
    this.i.show(this.h, paramList, paramList1, new RentConditionTypePop.a()
    {
      public void select(List<RentTypeConditionItem> paramAnonymousList)
      {
        RentHouseListFragment.b(RentHouseListFragment.this).updateTypeCondition(paramAnonymousList);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/rent/list/RentHouseListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */