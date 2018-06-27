package com.ziroom.ziroomcustomer.social.activity.a;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.social.activity.frag.AcEnrollListFragment;

public class d
  implements a.a
{
  private a.b a;
  private final int b = 10;
  private boolean c = true;
  private final int d = 0;
  private final int e = 1;
  private int f = 0;
  private String[] g = { "进行中", "已完成" };
  
  public d(a.b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.a = paramb;
    this.a.setPresenter(this);
  }
  
  public void detachView()
  {
    this.a = null;
  }
  
  public a.b getView()
  {
    return this.a;
  }
  
  public void initFragment(int paramInt)
  {
    switchFragment(paramInt, 0);
  }
  
  public boolean isViewActivie()
  {
    return (this.a != null) && (!((BaseActivity)this.a).isFinishing());
  }
  
  public void start()
  {
    this.a.initNavi(this.g, this.f);
  }
  
  public void switchFragment(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt2 == 1) {
      i = 2;
    }
    AcEnrollListFragment localAcEnrollListFragment = AcEnrollListFragment.getInstance(i);
    ((BaseActivity)this.a).getSupportFragmentManager().beginTransaction().replace(paramInt1, localAcEnrollListFragment).commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */