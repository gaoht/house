package com.ziroom.ziroomcustomer.newrepair.b;

import com.ziroom.ziroomcustomer.e.l;
import java.util.List;

public class j
  extends l
{
  private List<a> a;
  
  public List<a> getFileInfoList()
  {
    return this.a;
  }
  
  public void setFileInfoList(List<a> paramList)
  {
    this.a = paramList;
  }
  
  public class a
  {
    private String b;
    private String c;
    
    public a() {}
    
    public String getServiceFilePath()
    {
      return this.b;
    }
    
    public String getStorageFilePath()
    {
      return this.c;
    }
    
    public void setServiceFilePath(String paramString)
    {
      this.b = paramString;
    }
    
    public void setStorageFilePath(String paramString)
    {
      this.c = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */