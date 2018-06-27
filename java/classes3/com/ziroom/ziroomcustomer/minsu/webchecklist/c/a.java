package com.ziroom.ziroomcustomer.minsu.webchecklist.c;

import java.util.List;

public class a
{
  private String a;
  private int b;
  private String c;
  private a d;
  
  public a getData()
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
  
  public void setData(a parama)
  {
    this.d = parama;
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
  
  public String toString()
  {
    return "CheckListBean{status='" + this.a + '\'' + ", error_code=" + this.b + ", error_message='" + this.c + '\'' + ", data=" + this.d + '}';
  }
  
  public static class a
  {
    private String a;
    private List<b> b;
    
    public String getDabiaoti()
    {
      return this.a;
    }
    
    public List<b> getLunbo()
    {
      return this.b;
    }
    
    public void setDabiaoti(String paramString)
    {
      this.a = paramString;
    }
    
    public void setLunbo(List<b> paramList)
    {
      this.b = paramList;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/webchecklist/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */