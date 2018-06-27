package com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b;

import java.util.List;

public class a
{
  private String a;
  private String b;
  private String c;
  private a d;
  
  public a getData()
  {
    return this.d;
  }
  
  public String getError_code()
  {
    return this.a;
  }
  
  public String getError_message()
  {
    return this.b;
  }
  
  public String getStatus()
  {
    return this.c;
  }
  
  public void setData(a parama)
  {
    this.d = parama;
  }
  
  public void setError_code(String paramString)
  {
    this.a = paramString;
  }
  
  public void setError_message(String paramString)
  {
    this.b = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.c = paramString;
  }
  
  public static class a
  {
    private String a;
    private List<a> b;
    
    public String getHouseTypeBid()
    {
      return this.a;
    }
    
    public List<a> getListCalendarMonth()
    {
      return this.b;
    }
    
    public void setHouseTypeBid(String paramString)
    {
      this.a = paramString;
    }
    
    public void setListCalendarMonth(List<a> paramList)
    {
      this.b = paramList;
    }
    
    public static class a
    {
      private String a;
      private List<a> b;
      
      public List<a> getCalendarList()
      {
        return this.b;
      }
      
      public String getMonthStr()
      {
        return this.a;
      }
      
      public void setCalendarList(List<a> paramList)
      {
        this.b = paramList;
      }
      
      public void setMonthStr(String paramString)
      {
        this.a = paramString;
      }
      
      public static class a
      {
        private String a;
        private String b;
        private int c;
        private int d;
        
        public String getDayTime()
        {
          return this.a;
        }
        
        public int getInventory()
        {
          return this.d;
        }
        
        public String getShowDayTime()
        {
          return this.b;
        }
        
        public int getStatus()
        {
          return this.c;
        }
        
        public void setDayTime(String paramString)
        {
          this.a = paramString;
        }
        
        public void setInventory(int paramInt)
        {
          this.d = paramInt;
        }
        
        public void setShowDayTime(String paramString)
        {
          this.b = paramString;
        }
        
        public void setStatus(int paramInt)
        {
          this.c = paramInt;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/projectdetail/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */