package com.ziroom.ziroomcustomer.minsu.view.b.a;

import android.support.v4.util.SparseArrayCompat;

public class b<T>
{
  SparseArrayCompat<a<T>> a = new SparseArrayCompat();
  
  public b<T> addDelegate(int paramInt, a<T> parama)
  {
    if (this.a.get(paramInt) != null) {
      throw new IllegalArgumentException("An ItemViewDelegate is already registered for the viewType = " + paramInt + ". Already registered ItemViewDelegate is " + this.a.get(paramInt));
    }
    this.a.put(paramInt, parama);
    return this;
  }
  
  public b<T> addDelegate(a<T> parama)
  {
    int i = this.a.size();
    if (parama != null) {
      this.a.put(i, parama);
    }
    return this;
  }
  
  public void convert(c paramc, T paramT, int paramInt)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)this.a.valueAt(i);
      if (locala.isForViewType(paramT, paramInt))
      {
        locala.convert(paramc, paramT, paramInt);
        return;
      }
      i += 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + paramInt + " in data source");
  }
  
  public a getItemViewDelegate(int paramInt)
  {
    return (a)this.a.get(paramInt);
  }
  
  public int getItemViewDelegateCount()
  {
    return this.a.size();
  }
  
  public int getItemViewLayoutId(int paramInt)
  {
    return getItemViewDelegate(paramInt).getItemViewLayoutId();
  }
  
  public int getItemViewType(a parama)
  {
    return this.a.indexOfValue(parama);
  }
  
  public int getItemViewType(T paramT, int paramInt)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((a)this.a.valueAt(i)).isForViewType(paramT, paramInt)) {
        return this.a.keyAt(i);
      }
      i -= 1;
    }
    throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + paramInt + " in data source");
  }
  
  public b<T> removeDelegate(int paramInt)
  {
    paramInt = this.a.indexOfKey(paramInt);
    if (paramInt >= 0) {
      this.a.removeAt(paramInt);
    }
    return this;
  }
  
  public b<T> removeDelegate(a<T> parama)
  {
    if (parama == null) {
      throw new NullPointerException("ItemViewDelegate is null");
    }
    int i = this.a.indexOfValue(parama);
    if (i >= 0) {
      this.a.removeAt(i);
    }
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */