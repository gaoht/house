package com.ziroom.ziroomcustomer.my.aboutus;

import android.content.Context;

public class a
{
  public static abstract interface a
  {
    public abstract void checkUpdate();
    
    public abstract void detachView();
    
    public abstract a.b getView();
    
    public abstract void initData();
    
    public abstract void start();
    
    public abstract void toServiceAndHelp();
  }
  
  public static abstract interface b
  {
    public abstract Context getViewContext();
    
    public abstract void initView();
    
    public abstract boolean isActive();
    
    public abstract void setPresenter(a.a parama);
    
    public abstract void showCurrVersion(String paramString);
    
    public abstract void showUpdate(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/aboutus/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */