package com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a;

public class a
{
  private String a;
  private String b;
  private String c;
  private int d;
  
  public int getCount()
  {
    return this.d;
  }
  
  public String getDir()
  {
    return this.a;
  }
  
  public String getFirstImagePath()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.c;
  }
  
  public void setCount(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setDir(String paramString)
  {
    this.a = paramString;
    int i = this.a.lastIndexOf("/");
    this.c = this.a.substring(i);
  }
  
  public void setFirstImagePath(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */