package com.ziroom.credit.view.a;

import android.app.Activity;
import android.view.LayoutInflater;
import com.ziroom.credit.view.a.a.c;
import java.util.List;

public abstract class a<T>
  extends b<T>
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
    addItemViewDelegate(new com.ziroom.credit.view.a.a.a()
    {
      public void convert(c paramAnonymousc, T paramAnonymousT, int paramAnonymousInt)
      {
        a.this.a(paramAnonymousc, paramAnonymousT, paramAnonymousInt);
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
  
  protected abstract void a(c paramc, T paramT, int paramInt);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */