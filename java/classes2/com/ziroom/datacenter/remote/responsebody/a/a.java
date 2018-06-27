package com.ziroom.datacenter.remote.responsebody.a;

public class a
  extends com.ziroom.datacenter.remote.responsebody.a
{
  private a e;
  
  public a getData()
  {
    return this.e;
  }
  
  public boolean isSuccessful()
  {
    return this.a.equals("success");
  }
  
  public void setData(a parama)
  {
    this.e = parama;
  }
  
  public static class a
  {
    private String a;
    
    public String getAppId()
    {
      return this.a;
    }
    
    public void setAppId(String paramString)
    {
      this.a = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */