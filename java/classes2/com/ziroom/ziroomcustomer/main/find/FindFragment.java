package com.ziroom.ziroomcustomer.main.find;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.base.BaseFragment;

public class FindFragment
  extends BaseFragment
  implements a.b
{
  private Context a;
  private a.a b;
  
  private void a(Fragment paramFragment, String paramString)
  {
    if (paramFragment != null)
    {
      FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
      localFragmentTransaction.add(2131694152, paramFragment, paramString);
      localFragmentTransaction.commit();
    }
  }
  
  private void b(String paramString)
  {
    paramString = getChildFragmentManager().findFragmentByTag(paramString);
    if (paramString != null)
    {
      FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
      localFragmentTransaction.remove(paramString);
      localFragmentTransaction.commit();
    }
  }
  
  public static FindFragment newInstance()
  {
    return new FindFragment();
  }
  
  public Context getViewContext()
  {
    return this.a;
  }
  
  public void hideNavigation()
  {
    b("find_navigation");
  }
  
  public boolean isActive()
  {
    return isAdded();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2130903931, paramViewGroup, false);
    paramViewGroup = FindNavigationFragment.newInstance();
    new c(paramViewGroup);
    a(paramViewGroup, "navigation");
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b.detachView();
  }
  
  public void onResume()
  {
    super.onResume();
    this.b.start();
  }
  
  public void setPresenter(a.a parama)
  {
    this.b = parama;
  }
  
  public void showNavigation()
  {
    b("find_navigation");
    FindNavigationFragment localFindNavigationFragment = FindNavigationFragment.newInstance();
    new c(localFindNavigationFragment);
    a(localFindNavigationFragment, "find_navigation");
  }
  
  public void showTestDialog()
  {
    g.textToast(getActivity(), "test Mvp");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/main/find/FindFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */