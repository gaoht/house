package com.hyphenate.chat;

import java.util.List;

public class EMPageResult<T>
  extends EMResult<List<T>>
{
  private int pageCount;
  
  public int getPageCount()
  {
    return this.pageCount;
  }
  
  void setPageCount(int paramInt)
  {
    this.pageCount = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMPageResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */