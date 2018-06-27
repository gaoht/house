package com.hyphenate.chat;

import java.util.List;

public class EMCursorResult<T>
  extends EMResult<List<T>>
{
  private String cursor = "";
  
  public String getCursor()
  {
    return this.cursor;
  }
  
  void setCursor(String paramString)
  {
    this.cursor = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMCursorResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */