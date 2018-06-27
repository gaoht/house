package com.ziroom.ziroomcustomer.main.find.rent;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.BottomSheetCallback;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.model.rent.RentCondition;
import com.ziroom.ziroomcustomer.rent.list.RentHouseListFragment;
import com.ziroom.ziroomcustomer.rent.list.d;
import com.ziroom.ziroomcustomer.util.u;

public class FindRentFragment
  extends BaseFragment
  implements View.OnClickListener, a.b
{
  private Context a;
  private LayoutInflater b;
  private int c;
  private a.a d;
  private EditText e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private RelativeLayout j;
  private BottomSheetBehavior k;
  private RelativeLayout l;
  private RentHouseListFragment m;
  
  private void a(View paramView)
  {
    this.e = ((EditText)paramView.findViewById(2131690906));
    this.f = ((TextView)paramView.findViewById(2131690827));
    this.g = ((TextView)paramView.findViewById(2131694157));
    this.h = ((TextView)paramView.findViewById(2131694158));
    this.i = ((TextView)paramView.findViewById(2131694159));
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j = ((RelativeLayout)paramView.findViewById(2131691646));
    this.k = BottomSheetBehavior.from(this.j);
    this.k.setSkipCollapsed(true);
    this.k.setHideable(true);
    this.k.setState(5);
    this.k.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback()
    {
      public void onSlide(View paramAnonymousView, float paramAnonymousFloat) {}
      
      public void onStateChanged(View paramAnonymousView, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          u.d("tag", "====");
          return;
          continue;
          continue;
          continue;
        }
      }
    });
    this.l = ((RelativeLayout)paramView.findViewById(2131694156));
  }
  
  public static FindRentFragment newInstance()
  {
    return new FindRentFragment();
  }
  
  public Context getViewContext()
  {
    return this.a;
  }
  
  public boolean isActive()
  {
    return isAdded();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = getChildFragmentManager();
    this.m = ((RentHouseListFragment)paramView.findFragmentByTag("find_rent_list"));
    if (this.m == null)
    {
      this.m = RentHouseListFragment.newInstance(new RentCondition());
      new d(this.m);
      paramView = paramView.beginTransaction();
      paramView.add(2131691646, this.m, "find_rent_list");
      paramView.commit();
    }
    this.k.setPeekHeight(this.l.getMeasuredHeight() - this.c);
    this.k.setState(3);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = getActivity();
    this.b = paramLayoutInflater;
    this.c = ((int)(this.a.getResources().getDisplayMetrics().density * 60.0F));
    paramLayoutInflater = paramLayoutInflater.inflate(2130903933, paramViewGroup, false);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.d.detachView();
  }
  
  public void onResume()
  {
    super.onResume();
    this.d.start();
  }
  
  public void setPresenter(a.a parama)
  {
    this.d = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/main/find/rent/FindRentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */