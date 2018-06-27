package com.ziroom.ziroomcustomer.minsu.view.b;

import android.app.Activity;
import android.view.LayoutInflater;
import com.ziroom.ziroomcustomer.minsu.view.b.a.c;
import java.util.List;

public abstract class a<T>
  extends e<T>
{
  protected Activity b;
  protected int c;
  protected List<T> d;
  protected LayoutInflater e;
  
  public a(Activity paramActivity, final int paramInt, List<T> paramList)
  {
    super(paramActivity, paramList);
    this.b = paramActivity;
    this.e = LayoutInflater.from(paramActivity);
    this.c = paramInt;
    this.d = paramList;
    addItemViewDelegate(new com.ziroom.ziroomcustomer.minsu.view.b.a.a()
    {
      public void convert(c paramAnonymousc, T paramAnonymousT, int paramAnonymousInt)
      {
        a.this.convert(paramAnonymousc, paramAnonymousT, paramAnonymousInt);
      }
      
      public int getItemViewLayoutId()
      {
        return paramInt;
      }
      
      public boolean isForViewType(T paramAnonymousT, int paramAnonymousInt)
      {
        return true;
      }
    });
  }
  
  protected abstract void convert(c paramc, T paramT, int paramInt);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */