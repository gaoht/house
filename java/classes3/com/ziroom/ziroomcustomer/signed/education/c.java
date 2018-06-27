package com.ziroom.ziroomcustomer.signed.education;

import android.content.Context;
import com.ziroom.ziroomcustomer.signed.a.k;
import java.util.List;

public class c
{
  public static abstract interface a
  {
    public abstract void detachView();
    
    public abstract c.b getView();
    
    public abstract void initData(String paramString);
    
    public abstract void start();
  }
  
  public static abstract interface b
  {
    public abstract Context getViewContext();
    
    public abstract boolean isActive();
    
    public abstract void setNoResultVisiable(int paramInt);
    
    public abstract void setPresenter(c.a parama);
    
    public abstract void showSchoolList(List<k> paramList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/education/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */