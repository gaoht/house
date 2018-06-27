package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.os.Bundle;
import com.ziroom.ziroomcustomer.a;
import com.ziroom.ziroomcustomer.b;
import com.ziroom.ziroomcustomer.newmovehouse.b.f;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecResultModel;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecResultRequestModel;
import java.util.List;

public class c
{
  static abstract interface a
    extends a
  {
    public abstract MoveRecResultModel getResult();
    
    public abstract void gotoMovingIndexActivity();
  }
  
  static abstract interface b
    extends b<c.a>
  {
    public abstract void currentPageSelected(int paramInt);
    
    public abstract Bundle getArgs();
    
    public abstract List<MoveRecResultRequestModel> getOptions(MoveRecResultRequestModel paramMoveRecResultRequestModel);
    
    public abstract void gotoLogin();
    
    public abstract void initImg(String paramString);
    
    public abstract void initIndex(String paramString);
    
    public abstract void initRecyclerView(int paramInt, f paramf);
    
    public abstract void initResultDesc(String paramString);
    
    public abstract void initResultImg(String paramString);
    
    public abstract void initResultMoney(String paramString);
    
    public abstract void initResultType(String paramString);
    
    public abstract void initSize(String paramString);
    
    public abstract void initStandard(String paramString);
    
    public abstract void intiResultTime(String paramString);
    
    public abstract void setResultVisible(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */