package com.ziroom.ziroomcustomer.newclean.d;

import java.util.List;

public class bo
{
  private String a;
  private int b;
  private String c;
  private List<a> d;
  
  public List<a> getData()
  {
    return this.d;
  }
  
  public int getError_code()
  {
    return this.b;
  }
  
  public String getError_message()
  {
    return this.c;
  }
  
  public String getStatus()
  {
    return this.a;
  }
  
  public void setData(List<a> paramList)
  {
    this.d = paramList;
  }
  
  public void setError_code(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setError_message(String paramString)
  {
    this.c = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.a = paramString;
  }
  
  public static class a
  {
    private String a;
    private String b;
    private String c;
    
    public String getHead_img()
    {
      return this.c;
    }
    
    public String getNick_name()
    {
      return this.b;
    }
    
    public String getUid()
    {
      return this.a;
    }
    
    public void setHead_img(String paramString)
    {
      this.c = paramString;
    }
    
    public void setNick_name(String paramString)
    {
      this.b = paramString;
    }
    
    public void setUid(String paramString)
    {
      this.a = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/d/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */