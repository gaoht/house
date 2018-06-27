package com.ziroom.ziroomcustomer.newclean.mvp;

import android.content.Intent;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.a;
import com.ziroom.ziroomcustomer.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.widget.HorizontalListView;

public abstract interface e
{
  public static abstract interface a
    extends a
  {
    public abstract void dataClick(int paramInt);
    
    public abstract void setCommit();
    
    public abstract void timeClick(int paramInt);
  }
  
  public static abstract interface b
    extends b<e.a>
  {
    public abstract BaseActivity getActivity();
    
    public abstract Intent getExtras();
    
    public abstract MyGridView getmGvHome();
    
    public abstract HorizontalListView getmHlData();
    
    public abstract TextView getmTvCommit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */