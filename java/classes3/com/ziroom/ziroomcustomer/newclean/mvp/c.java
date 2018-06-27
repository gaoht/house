package com.ziroom.ziroomcustomer.newclean.mvp;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.a;
import com.ziroom.ziroomcustomer.b;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;

public abstract interface c
{
  public static abstract interface a
    extends a
  {}
  
  public static abstract interface b
    extends b<c.a>
  {
    public abstract ImageView getmIvPull();
    
    public abstract LinearLayout getmLlCommend();
    
    public abstract LinearLayout getmLlHistory();
    
    public abstract LinearLayout getmLlMore();
    
    public abstract ListViewForScrollView getmLsvCommend();
    
    public abstract ListViewForScrollView getmLsvHistory();
    
    public abstract TextView getmTvMore();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */