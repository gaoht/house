package com.ziroom.ziroomcustomer.main.find.stay;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ziroom.ziroomcustomer.base.BaseFragment;

public class FindStayFragment
  extends BaseFragment
  implements a.b
{
  private Context a;
  private LayoutInflater b;
  private a.a c;
  
  private void a(View paramView) {}
  
  public static FindStayFragment newInstance()
  {
    return new FindStayFragment();
  }
  
  public Context getViewContext()
  {
    return this.a;
  }
  
  public boolean isActive()
  {
    return isAdded();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = getActivity();
    this.b = paramLayoutInflater;
    paramLayoutInflater = paramLayoutInflater.inflate(2130903934, paramViewGroup, false);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.c.detachView();
  }
  
  public void onResume()
  {
    super.onResume();
    this.c.start();
  }
  
  public void setPresenter(a.a parama)
  {
    this.c = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/main/find/stay/FindStayFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */