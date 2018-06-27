package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class LeaseCaseRecordEntity
  implements Serializable
{
  private String backUpNo;
  private String backUpText;
  private int backUpcode;
  private BackUpmsg backUpmsg;
  private int isViewCaseRecord;
  
  public String getBackUpNo()
  {
    return this.backUpNo;
  }
  
  public String getBackUpText()
  {
    return this.backUpText;
  }
  
  public int getBackUpcode()
  {
    return this.backUpcode;
  }
  
  public BackUpmsg getBackUpmsg()
  {
    return this.backUpmsg;
  }
  
  public int getIsViewCaseRecord()
  {
    return this.isViewCaseRecord;
  }
  
  public void setBackUpNo(String paramString)
  {
    this.backUpNo = paramString;
  }
  
  public void setBackUpText(String paramString)
  {
    this.backUpText = paramString;
  }
  
  public void setBackUpcode(int paramInt)
  {
    this.backUpcode = paramInt;
  }
  
  public void setBackUpmsg(BackUpmsg paramBackUpmsg)
  {
    this.backUpmsg = paramBackUpmsg;
  }
  
  public void setIsViewCaseRecord(int paramInt)
  {
    this.isViewCaseRecord = paramInt;
  }
  
  public class BackUpmsg
    implements Serializable
  {
    private String backUpmsgContext;
    private String backUpmsgTitle;
    
    public BackUpmsg() {}
    
    public String getBackUpmsgContext()
    {
      return this.backUpmsgContext;
    }
    
    public String getBackUpmsgTitle()
    {
      return this.backUpmsgTitle;
    }
    
    public void setBackUpmsgContext(String paramString)
    {
      this.backUpmsgContext = paramString;
    }
    
    public void setBackUpmsgTitle(String paramString)
    {
      this.backUpmsgTitle = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/LeaseCaseRecordEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */