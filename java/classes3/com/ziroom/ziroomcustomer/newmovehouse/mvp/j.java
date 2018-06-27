package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.content.Intent;
import android.widget.BaseAdapter;
import com.ziroom.ziroomcustomer.a;
import com.ziroom.ziroomcustomer.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public abstract interface j
{
  public static abstract interface a
    extends a
  {
    public abstract void getOrderState();
    
    public abstract void refresh();
    
    public abstract void toChat();
  }
  
  public static abstract interface b
    extends b<j.a>
  {
    public abstract BaseActivity getActivity();
    
    public abstract Intent getExtras();
    
    public abstract void onLoad();
    
    public abstract void setXLAdapter(BaseAdapter paramBaseAdapter);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */