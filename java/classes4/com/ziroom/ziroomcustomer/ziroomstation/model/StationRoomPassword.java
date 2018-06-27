package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.ziroom.ziroomcustomer.ziroomstation.b.a;
import java.util.List;

public class StationRoomPassword
  extends a
{
  private List<DataEntity> data;
  
  public List<DataEntity> getData()
  {
    return this.data;
  }
  
  public void setData(List<DataEntity> paramList)
  {
    this.data = paramList;
  }
  
  public static class DataEntity
  {
    private String areCode;
    private String areId;
    private long endDate;
    private int is_past;
    private String passWord;
    private long startDate;
    
    public String getAreCode()
    {
      return this.areCode;
    }
    
    public String getAreId()
    {
      return this.areId;
    }
    
    public long getEndDate()
    {
      return this.endDate;
    }
    
    public int getIs_past()
    {
      return this.is_past;
    }
    
    public String getPassWord()
    {
      return this.passWord;
    }
    
    public long getStartDate()
    {
      return this.startDate;
    }
    
    public void setAreCode(String paramString)
    {
      this.areCode = paramString;
    }
    
    public void setAreId(String paramString)
    {
      this.areId = paramString;
    }
    
    public void setEndDate(long paramLong)
    {
      this.endDate = paramLong;
    }
    
    public void setIs_past(int paramInt)
    {
      this.is_past = paramInt;
    }
    
    public void setPassWord(String paramString)
    {
      this.passWord = paramString;
    }
    
    public void setStartDate(long paramLong)
    {
      this.startDate = paramLong;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationRoomPassword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */