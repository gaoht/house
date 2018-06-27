package com.ziroom.ziroomcustomer.minsu.webchecklist;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxFragment;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.b.e.a;
import com.ziroom.ziroomcustomer.minsu.view.b.f.a;
import com.ziroom.ziroomcustomer.minsu.webchecklist.c.a.a;
import java.util.ArrayList;
import java.util.List;

public class MinsuChecklistFragment
  extends BaseFluxFragment
{
  Unbinder b;
  private List<com.ziroom.ziroomcustomer.minsu.webchecklist.c.b> c;
  @BindView(2131691272)
  CommonTitle commonTitle;
  private com.ziroom.ziroomcustomer.minsu.webchecklist.d.a d;
  private com.ziroom.ziroomcustomer.minsu.webchecklist.a.a e;
  private com.ziroom.ziroomcustomer.minsu.webchecklist.c.a f;
  private com.ziroom.ziroomcustomer.minsu.webchecklist.b.a g;
  @BindView(2131694160)
  RecyclerView recyclerview;
  
  private void c()
  {
    d();
    f();
    g();
    initData();
  }
  
  private void d()
  {
    this.c = new ArrayList();
  }
  
  private void e()
  {
    this.d = new com.ziroom.ziroomcustomer.minsu.webchecklist.d.a(this);
    this.a.register(this.d);
    this.e = com.ziroom.ziroomcustomer.minsu.webchecklist.a.a.getInstance(this.a);
  }
  
  private void f()
  {
    this.commonTitle.setLeftButtonType(0);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuChecklistFragment.this.getActivity().finish();
      }
    });
    this.commonTitle.setMiddleText(getString(2131296636));
    this.commonTitle.showRightText(false, null);
  }
  
  private void g()
  {
    this.g = new com.ziroom.ziroomcustomer.minsu.webchecklist.b.a(getActivity(), this.c);
    this.g.setOnItemClickListener(new e.a()
    {
      public void onItemClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
      {
        ((com.ziroom.ziroomcustomer.minsu.webchecklist.c.b)MinsuChecklistFragment.a(MinsuChecklistFragment.this).get(paramAnonymousInt)).getTarget();
        k.CmsToWebActivity(MinsuChecklistFragment.this.getActivity(), (com.ziroom.ziroomcustomer.minsu.webchecklist.c.b)MinsuChecklistFragment.a(MinsuChecklistFragment.this).get(paramAnonymousInt));
      }
      
      public boolean onItemLongClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
      {
        return false;
      }
    });
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
    localLinearLayoutManager.setOrientation(1);
    this.recyclerview.setLayoutManager(localLinearLayoutManager);
    this.recyclerview.addItemDecoration(((f.a)((f.a)new f.a(getActivity()).color(getResources().getColor(2131624047))).sizeResId(2131231170)).build());
    this.recyclerview.setAdapter(this.g);
  }
  
  public static MinsuChecklistFragment newInstance()
  {
    MinsuChecklistFragment localMinsuChecklistFragment = new MinsuChecklistFragment();
    localMinsuChecklistFragment.setArguments(new Bundle());
    return localMinsuChecklistFragment;
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i = -1;
    switch (parama.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (parama.equals("checklist_getdata"))
        {
          i = 0;
          continue;
          if (parama.equals("checklist_getdata_error")) {
            i = 1;
          }
        }
        break;
      }
    }
    this.f = this.d.getCheckListBean();
    if ((this.f != null) && (this.f.getData() != null) && (this.f.getData().getLunbo() != null))
    {
      parama = this.f.getData().getDabiaoti();
      if (!TextUtils.isEmpty(parama)) {
        this.commonTitle.setMiddleText(parama);
      }
      this.c.clear();
      this.c.addAll(this.f.getData().getLunbo());
      this.g.notifyDataSetChanged();
      return;
    }
    g.textToast(getActivity(), getString(2131297292));
  }
  
  public void initData()
  {
    this.e.getCheckListData(this, getActivity());
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    c();
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null) {}
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    e();
    paramLayoutInflater = paramLayoutInflater.inflate(2130903938, paramViewGroup, false);
    this.b = ButterKnife.bind(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.d);
    super.onDestroyView();
    this.b.unbind();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/webchecklist/MinsuChecklistFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */