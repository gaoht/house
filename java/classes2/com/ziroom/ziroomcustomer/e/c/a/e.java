package com.ziroom.ziroomcustomer.e.c.a;

public class e
  extends f
{
  private final String b = "BiweeklyCleanHandler";
  
  public void decode(String paramString)
  {
    super.decode(paramString);
  }
  
  public int getCode()
  {
    return 0;
  }
  
  public String getData()
  {
    if (this.a != null) {
      return this.a.getString("data");
    }
    return null;
  }
  
  public String getMessage()
  {
    if (this.a != null) {
      return this.a.getString("message");
    }
    return null;
  }
  
  public boolean isSuccess()
  {
    if (this.a != null) {
      return "0".equals(this.a.getString("status"));
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */