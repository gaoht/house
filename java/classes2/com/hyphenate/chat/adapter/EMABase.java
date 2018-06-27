package com.hyphenate.chat.adapter;

public class EMABase
{
  long nativeHandler = 0L;
  
  native boolean _equals(EMABase paramEMABase);
  
  native int _hashCode();
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof EMABase)) && ((this.nativeHandler == ((EMABase)paramObject).nativeHandler) || (_equals((EMABase)paramObject)));
  }
  
  public int hashCode()
  {
    int j = _hashCode();
    int i = j;
    if (j == 0) {
      i = super.hashCode();
    }
    return i;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMABase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */