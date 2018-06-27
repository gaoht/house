package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.support.v4.app.Fragment;
import com.ziroom.ziroomcustomer.a;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecResultRequestModel;
import java.util.List;

public class b
{
  static abstract interface a
    extends a
  {
    public abstract List<MoveRecResultRequestModel> getOptions(MoveRecResultRequestModel paramMoveRecResultRequestModel);
  }
  
  static abstract interface b
    extends com.ziroom.ziroomcustomer.b<b.a>
  {
    public abstract void currentPageSelected(int paramInt);
    
    public abstract void finishView();
    
    public abstract List<MoveRecResultRequestModel> getOptions(MoveRecResultRequestModel paramMoveRecResultRequestModel);
    
    public abstract void gotoLogin();
    
    public abstract void initViewPager(List<Fragment> paramList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */