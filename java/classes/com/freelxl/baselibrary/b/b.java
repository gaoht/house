package com.freelxl.baselibrary.b;

public class b
{
  public int error_code;
  public String error_message;
  public String msg;
  public String status;
  
  public b() {}
  
  public b(String paramString1, int paramInt, String paramString2)
  {
    this.status = paramString1;
    this.error_code = paramInt;
    this.error_message = paramString2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */