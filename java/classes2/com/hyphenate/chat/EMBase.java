package com.hyphenate.chat;

import com.hyphenate.chat.adapter.EMABase;

public class EMBase<T>
{
  protected T emaObject;
  
  public boolean equals(Object paramObject)
  {
    if ((this.emaObject != null) && ((this.emaObject instanceof EMABase)) && (paramObject != null) && ((paramObject instanceof EMBase))) {
      return this.emaObject.equals(((EMBase)paramObject).emaObject);
    }
    if ((this.emaObject != null) && ((this.emaObject instanceof EMABase)) && (paramObject != null) && ((paramObject instanceof EMABase))) {
      return this.emaObject.equals(paramObject);
    }
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    if ((this.emaObject != null) && ((this.emaObject instanceof EMABase))) {
      return this.emaObject.hashCode();
    }
    return super.hashCode();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */