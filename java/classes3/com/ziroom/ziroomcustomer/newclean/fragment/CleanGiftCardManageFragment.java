package com.ziroom.ziroomcustomer.newclean.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newclean.cardpay.adapter.f;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.GiftCardList;
import java.util.ArrayList;
import java.util.LinkedList;

public class CleanGiftCardManageFragment
  extends BaseFragment
{
  private RecyclerView a;
  private RelativeLayout b;
  private LinearLayout c;
  private TextView d;
  private TextView e;
  private f f;
  private int g = 1;
  private LinkedList<GiftCardList> h = new LinkedList();
  private BroadcastReceiver i = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17)
      {
        CleanGiftCardManageFragment.a(CleanGiftCardManageFragment.this);
        CleanGiftCardManageFragment.b(CleanGiftCardManageFragment.this);
      }
    }
  };
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.g += 1;
    }
    d();
  }
  
  private void c()
  {
    this.a.setOnScrollListener(new RecyclerView.l()
    {
      int a;
      
      public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt == 0) && (this.a + 1 == CleanGiftCardManageFragment.c(CleanGiftCardManageFragment.this).getItemCount())) {
          CleanGiftCardManageFragment.a(CleanGiftCardManageFragment.this, true);
        }
      }
      
      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        this.a = ((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
      }
    });
  }
  
  private void d()
  {
    n.getCleanGiftCardList(getActivity(), "2c9085f24af1d728014b004be6b50d3b", this.g, 10, new d(getActivity(), new e(GiftCardList.class))
    {
      public void onSuccess(int paramAnonymousInt, ArrayList<GiftCardList> paramAnonymousArrayList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousArrayList);
        CleanGiftCardManageFragment.d(CleanGiftCardManageFragment.this).setVisibility(8);
        if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0))
        {
          CleanGiftCardManageFragment.e(CleanGiftCardManageFragment.this).addAll(paramAnonymousArrayList);
          CleanGiftCardManageFragment.c(CleanGiftCardManageFragment.this).setData(CleanGiftCardManageFragment.e(CleanGiftCardManageFragment.this));
        }
        if (CleanGiftCardManageFragment.e(CleanGiftCardManageFragment.this).size() == 0)
        {
          CleanGiftCardManageFragment.f(CleanGiftCardManageFragment.this).setVisibility(0);
          CleanGiftCardManageFragment.g(CleanGiftCardManageFragment.this).setVisibility(8);
          CleanGiftCardManageFragment.h(CleanGiftCardManageFragment.this).setVisibility(0);
          return;
        }
        CleanGiftCardManageFragment.f(CleanGiftCardManageFragment.this).setVisibility(8);
        CleanGiftCardManageFragment.g(CleanGiftCardManageFragment.this).setVisibility(0);
      }
    });
  }
  
  public static CleanGiftCardManageFragment getInstance()
  {
    return new CleanGiftCardManageFragment();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903901, paramViewGroup, false);
    this.a = ((RecyclerView)paramLayoutInflater.findViewById(2131693974));
    this.b = ((RelativeLayout)paramLayoutInflater.findViewById(2131690081));
    this.c = ((LinearLayout)paramLayoutInflater.findViewById(2131693976));
    this.d = ((TextView)paramLayoutInflater.findViewById(2131690822));
    this.e = ((TextView)paramLayoutInflater.findViewById(2131693975));
    this.f = new f(getActivity());
    this.a.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.a.setAdapter(this.f);
    this.d.getPaint().setFlags(8);
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        com.ziroom.commonlibrary.login.a.startLoginActivity(CleanGiftCardManageFragment.this.getContext());
      }
    });
    paramViewGroup = new IntentFilter();
    paramViewGroup.addAction("com.ziroom.commonlibrary.login.broadcast");
    paramViewGroup.addAction("refresh_card");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.i, paramViewGroup);
    if (ApplicationEx.c.isLoginState()) {
      d();
    }
    c();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.i);
  }
  
  public void reLoadData()
  {
    this.h.clear();
    this.g = 1;
    d();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/CleanGiftCardManageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */