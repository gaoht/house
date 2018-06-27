package com.ziroom.ziroomcustomer.minsu.view.stickylistheaders;

import java.util.HashMap;

class c<TKey, TValue>
{
  HashMap<TKey, TValue> a = new HashMap();
  HashMap<TValue, TKey> b = new HashMap();
  
  public TValue get(TKey paramTKey)
  {
    return (TValue)this.a.get(paramTKey);
  }
  
  public TKey getKey(TValue paramTValue)
  {
    return (TKey)this.b.get(paramTValue);
  }
  
  public void put(TKey paramTKey, TValue paramTValue)
  {
    remove(paramTKey);
    removeByValue(paramTValue);
    this.a.put(paramTKey, paramTValue);
    this.b.put(paramTValue, paramTKey);
  }
  
  public void remove(TKey paramTKey)
  {
    if (get(paramTKey) != null) {
      this.b.remove(get(paramTKey));
    }
    this.a.remove(paramTKey);
  }
  
  public void removeByValue(TValue paramTValue)
  {
    if (getKey(paramTValue) != null) {
      this.a.remove(getKey(paramTValue));
    }
    this.b.remove(paramTValue);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/stickylistheaders/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */