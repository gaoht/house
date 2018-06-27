package com.ziroom.ziroomcustomer.minsu.landlordrelease.base;

import android.view.View;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxFragment;
import com.ziroom.ziroomcustomer.util.af;

public abstract class BaseLandlordReleaseFragment
  extends BaseFluxFragment
{
  protected void a(int paramInt)
  {
    if ((getActivity() instanceof b)) {
      ((b)getActivity()).setRoomType(paramInt);
    }
  }
  
  protected void a(String paramString, Object paramObject)
  {
    if ((getActivity() instanceof b)) {
      ((b)getActivity()).putDataCache(paramString, paramObject);
    }
  }
  
  protected void b(String paramString)
  {
    if ((getActivity() instanceof b)) {
      ((b)getActivity()).setHouseFid(paramString);
    }
  }
  
  protected abstract View c();
  
  protected Object c(String paramString)
  {
    if ((getActivity() instanceof b)) {
      return ((b)getActivity()).getDataCache(paramString);
    }
    return null;
  }
  
  protected void f()
  {
    if ((getActivity() instanceof b)) {
      ((b)getActivity()).next();
    }
  }
  
  protected void g()
  {
    if ((getActivity() instanceof b)) {
      ((b)getActivity()).prev();
    }
  }
  
  protected int h()
  {
    if ((getActivity() instanceof b)) {
      return ((b)getActivity()).getRentWay();
    }
    return -1;
  }
  
  protected int i()
  {
    if ((getActivity() instanceof b)) {
      return ((b)getActivity()).getRoomType();
    }
    return -1;
  }
  
  protected String j()
  {
    if ((getActivity() instanceof b)) {
      return ((b)getActivity()).getRoomFid();
    }
    return null;
  }
  
  protected String k()
  {
    if ((getActivity() instanceof b)) {
      return ((b)getActivity()).getHouseFid();
    }
    return null;
  }
  
  protected boolean l()
  {
    if (!ApplicationEx.c.isLoginState())
    {
      a.startLoginActivity(getActivity());
      af.showToast(getActivity(), "请先登录");
      return false;
    }
    return true;
  }
  
  public void onFragmentSwitch(boolean paramBoolean) {}
  
  public abstract void onLoginBack(boolean paramBoolean1, boolean paramBoolean2);
  
  protected void setRentWay(int paramInt)
  {
    if ((getActivity() instanceof b)) {
      ((b)getActivity()).setRentWay(paramInt);
    }
  }
  
  protected void setRoomFid(String paramString)
  {
    if ((getActivity() instanceof b)) {
      ((b)getActivity()).setRoomFid(paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/base/BaseLandlordReleaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */