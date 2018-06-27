package com.ziroom.ziroomcustomer.ziroomapartment.model.sd;

import java.util.List;

public class MeterDetail
{
  private Integer contractType;
  private Integer currentDialsNum;
  private Integer dialsTotal;
  private String intellectReadings;
  private Integer intellectType;
  private String jumpDesc;
  private Integer jumpType;
  private List<IntellectDialsVo> listIntellectDialsVo;
  private String panelTips;
  private String payTypeName;
  private String roomId;
  private String tips;
  private String updateInfo;
  
  public Integer getContractType()
  {
    return this.contractType;
  }
  
  public Integer getCurrentDialsNum()
  {
    return this.currentDialsNum;
  }
  
  public Integer getDialsTotal()
  {
    return this.dialsTotal;
  }
  
  public String getIntellectReadings()
  {
    return this.intellectReadings;
  }
  
  public Integer getIntellectType()
  {
    return this.intellectType;
  }
  
  public String getJumpDesc()
  {
    return this.jumpDesc;
  }
  
  public Integer getJumpType()
  {
    return this.jumpType;
  }
  
  public List<IntellectDialsVo> getListIntellectDialsVo()
  {
    return this.listIntellectDialsVo;
  }
  
  public String getPanelTips()
  {
    return this.panelTips;
  }
  
  public String getPayTypeName()
  {
    return this.payTypeName;
  }
  
  public String getRoomId()
  {
    return this.roomId;
  }
  
  public String getTips()
  {
    return this.tips;
  }
  
  public String getUpdateInfo()
  {
    return this.updateInfo;
  }
  
  public void setContractType(Integer paramInteger)
  {
    this.contractType = paramInteger;
  }
  
  public void setCurrentDialsNum(Integer paramInteger)
  {
    this.currentDialsNum = paramInteger;
  }
  
  public void setDialsTotal(Integer paramInteger)
  {
    this.dialsTotal = paramInteger;
  }
  
  public void setIntellectReadings(String paramString)
  {
    this.intellectReadings = paramString;
  }
  
  public void setIntellectType(Integer paramInteger)
  {
    this.intellectType = paramInteger;
  }
  
  public void setJumpDesc(String paramString)
  {
    this.jumpDesc = paramString;
  }
  
  public void setJumpType(Integer paramInteger)
  {
    this.jumpType = paramInteger;
  }
  
  public void setListIntellectDialsVo(List<IntellectDialsVo> paramList)
  {
    this.listIntellectDialsVo = paramList;
  }
  
  public void setPanelTips(String paramString)
  {
    this.panelTips = paramString;
  }
  
  public void setPayTypeName(String paramString)
  {
    this.payTypeName = paramString;
  }
  
  public void setRoomId(String paramString)
  {
    this.roomId = paramString;
  }
  
  public void setTips(String paramString)
  {
    this.tips = paramString;
  }
  
  public void setUpdateInfo(String paramString)
  {
    this.updateInfo = paramString;
  }
  
  public static class IntellectDialsVo
  {
    private Integer dialsNum;
    private String intellectReadings;
    
    public Integer getDialsNum()
    {
      return this.dialsNum;
    }
    
    public String getIntellectReadings()
    {
      return this.intellectReadings;
    }
    
    public void setDialsNum(Integer paramInteger)
    {
      this.dialsNum = paramInteger;
    }
    
    public void setIntellectReadings(String paramString)
    {
      this.intellectReadings = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sd/MeterDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */