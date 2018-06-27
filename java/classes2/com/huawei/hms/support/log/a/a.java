package com.huawei.hms.support.log.a;

public class a
{
  private StringBuilder a = new StringBuilder(64);
  
  public static a a()
  {
    return new a();
  }
  
  public <T> a a(T paramT)
  {
    if (this.a != null) {
      this.a.append(paramT);
    }
    return this;
  }
  
  public a b()
  {
    return a(Character.valueOf('\n'));
  }
  
  public String c()
  {
    if (this.a == null) {
      return "";
    }
    String str = this.a.toString();
    this.a = null;
    return str;
  }
  
  public String toString()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/log/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */