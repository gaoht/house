package com.ziroom.ziroomcustomer.main.find;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.main.find.rent.FindRentFragment;
import com.ziroom.ziroomcustomer.main.find.stay.FindStayFragment;
import com.ziroom.ziroomcustomer.main.find.zra.FindZraFragment;
import java.util.List;

public class FindNavigationFragment
  extends BaseFragment
  implements View.OnClickListener, b.b
{
  private Context a;
  private LayoutInflater b;
  private a c;
  private b.a d;
  private LinearLayout e;
  private TextView f;
  private TextView g;
  private TextView h;
  private FrameLayout i;
  
  private void a(Fragment paramFragment, String paramString)
  {
    if (paramFragment != null)
    {
      FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
      localFragmentTransaction.add(2131694152, paramFragment, paramString);
      localFragmentTransaction.commit();
    }
  }
  
  private void a(View paramView)
  {
    this.e = ((LinearLayout)paramView.findViewById(2131690709));
    this.f = ((TextView)paramView.findViewById(2131694153));
    this.g = ((TextView)paramView.findViewById(2131694154));
    this.h = ((TextView)paramView.findViewById(2131694155));
    this.i = ((FrameLayout)paramView.findViewById(2131694152));
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.c != null)) {
      this.c.onLineChanged(paramString);
    }
  }
  
  private void c(String paramString)
  {
    paramString = getChildFragmentManager().findFragmentByTag(paramString);
    if (paramString != null)
    {
      FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
      localFragmentTransaction.remove(paramString);
      localFragmentTransaction.commit();
    }
  }
  
  public static FindNavigationFragment newInstance()
  {
    return new FindNavigationFragment();
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
    case 2131694153: 
      showLineRent();
      return;
    case 2131694154: 
      showLineZra();
      return;
    }
    showLineStay();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = getActivity();
    this.b = paramLayoutInflater;
    paramLayoutInflater = paramLayoutInflater.inflate(2130903932, paramViewGroup, false);
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
    if (this.d == null) {
      return;
    }
    this.d.start();
    b("友家整租");
  }
  
  public void setLines(List<String> paramList) {}
  
  public void setNavigationListener(a parama)
  {
    this.c = parama;
  }
  
  public void setPresenter(b.a parama)
  {
    this.d = parama;
  }
  
  public void showLineRent()
  {
    c("find_line_content");
    FindRentFragment localFindRentFragment = FindRentFragment.newInstance();
    new com.ziroom.ziroomcustomer.main.find.rent.b(localFindRentFragment);
    a(localFindRentFragment, "find_line_content");
  }
  
  public void showLineStay()
  {
    c("find_line_content");
    FindStayFragment localFindStayFragment = FindStayFragment.newInstance();
    new com.ziroom.ziroomcustomer.main.find.stay.b(localFindStayFragment);
    a(localFindStayFragment, "find_line_content");
  }
  
  public void showLineZra()
  {
    c("find_line_content");
    FindZraFragment localFindZraFragment = FindZraFragment.newInstance();
    new com.ziroom.ziroomcustomer.main.find.zra.b(localFindZraFragment);
    a(localFindZraFragment, "find_line_content");
  }
  
  public static abstract interface a
  {
    public abstract void onLineChanged(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/main/find/FindNavigationFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */