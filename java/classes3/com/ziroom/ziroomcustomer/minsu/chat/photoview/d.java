package com.ziroom.ziroomcustomer.minsu.chat.photoview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.widget.OverScroller;
import android.widget.Scroller;

abstract class d
{
  public static d getScroller(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 9) {
      return new b(paramContext);
    }
    return new a(paramContext);
  }
  
  public abstract boolean computeScrollOffset();
  
  public abstract void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  public abstract void forceFinished(boolean paramBoolean);
  
  public abstract int getCurrX();
  
  public abstract int getCurrY();
  
  @TargetApi(9)
  private static class a
    extends d
  {
    private OverScroller a;
    
    public a(Context paramContext)
    {
      this.a = new OverScroller(paramContext);
    }
    
    public boolean computeScrollOffset()
    {
      return this.a.computeScrollOffset();
    }
    
    public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
    {
      this.a.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    }
    
    public void forceFinished(boolean paramBoolean)
    {
      this.a.forceFinished(paramBoolean);
    }
    
    public int getCurrX()
    {
      return this.a.getCurrX();
    }
    
    public int getCurrY()
    {
      return this.a.getCurrY();
    }
  }
  
  private static class b
    extends d
  {
    private Scroller a;
    
    public b(Context paramContext)
    {
      this.a = new Scroller(paramContext);
    }
    
    public boolean computeScrollOffset()
    {
      return this.a.computeScrollOffset();
    }
    
    public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
    {
      this.a.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    
    public void forceFinished(boolean paramBoolean)
    {
      this.a.forceFinished(paramBoolean);
    }
    
    public int getCurrX()
    {
      return this.a.getCurrX();
    }
    
    public int getCurrY()
    {
      return this.a.getCurrY();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/photoview/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */