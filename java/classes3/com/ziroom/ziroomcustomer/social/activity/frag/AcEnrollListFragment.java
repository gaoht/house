package com.ziroom.ziroomcustomer.social.activity.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.social.activity.a.b.a;
import com.ziroom.ziroomcustomer.social.activity.a.b.b;
import com.ziroom.ziroomcustomer.social.activity.a.c;
import com.ziroom.ziroomcustomer.social.view.b;

public class AcEnrollListFragment
  extends BaseFragment
  implements View.OnClickListener, b.b
{
  private b.a a;
  private View b;
  private RecyclerView c;
  private LinearLayout d;
  private Button e;
  
  private void c()
  {
    this.c.addOnScrollListener(new RecyclerView.l()
    {
      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
        paramAnonymousInt1 = localLinearLayoutManager.findLastVisibleItemPosition();
        paramAnonymousInt2 = localLinearLayoutManager.getChildCount();
        int i = localLinearLayoutManager.getItemCount();
        paramAnonymousRecyclerView.getScrollState();
        if ((paramAnonymousInt2 > 0) && (paramAnonymousInt1 == i - 1)) {
          AcEnrollListFragment.a(AcEnrollListFragment.this).getData();
        }
      }
    });
  }
  
  public static AcEnrollListFragment getInstance(int paramInt)
  {
    AcEnrollListFragment localAcEnrollListFragment = new AcEnrollListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("state", paramInt);
    localAcEnrollListFragment.setArguments(localBundle);
    return localAcEnrollListFragment;
  }
  
  public Context getViewContext()
  {
    return getActivity();
  }
  
  public boolean isActive()
  {
    return !isDetached();
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
    this.a.enrollClick();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = getArguments().getInt("state");
    this.b = paramLayoutInflater.inflate(2130903886, null, false);
    this.c = ((RecyclerView)this.b.findViewById(2131690100));
    this.d = ((LinearLayout)this.b.findViewById(2131689818));
    this.e = ((Button)this.b.findViewById(2131689819));
    this.e.setOnClickListener(this);
    this.a = new c(this);
    this.a.setState(i);
    this.a.start();
    return this.b;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void setPresenter(b.a parama)
  {
    this.a = parama;
  }
  
  public void setReclyclerViewAdapter(RecyclerView.a parama)
  {
    this.c.setLayoutManager(new LinearLayoutManager(getViewContext()));
    b localb = new b(getViewContext());
    this.c.addItemDecoration(localb);
    this.c.setAdapter(parama);
    c();
  }
  
  public void showEmpty()
  {
    this.c.setVisibility(8);
    this.d.setVisibility(0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/frag/AcEnrollListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */