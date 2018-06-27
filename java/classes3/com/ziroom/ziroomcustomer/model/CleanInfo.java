package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class CleanInfo
  implements Serializable
{
  private int DAYS;
  private String GDH;
  private int GYSZT;
  private int HFZT;
  private String ID;
  private int PASSDAY;
  private String PFR;
  private String PFRROOMNUM;
  private String SCORE;
  private int SERTYPE;
  private String SGRQ;
  private int SOURCE;
  private int SWXW;
  private String YSR;
  private String YSRFJH;
  private String YYR;
  private String YYSMSJ;
  private String expand;
  private CleanProgress progress;
  private List<CleanRecord> recordList;
  private List<CleanServiceDetail> valueAddedList;
  private String workBillId;
  
  public int getDAYS()
  {
    return this.DAYS;
  }
  
  public String getExpand()
  {
    return this.expand;
  }
  
  public String getGDH()
  {
    return this.GDH;
  }
  
  public int getGYSZT()
  {
    return this.GYSZT;
  }
  
  public int getHFZT()
  {
    return this.HFZT;
  }
  
  public String getID()
  {
    return this.ID;
  }
  
  public int getPASSDAY()
  {
    return this.PASSDAY;
  }
  
  public String getPFR()
  {
    return this.PFR;
  }
  
  public String getPFRROOMNUM()
  {
    return this.PFRROOMNUM;
  }
  
  public CleanProgress getProgress()
  {
    return this.progress;
  }
  
  public List<CleanRecord> getRecordList()
  {
    return this.recordList;
  }
  
  public String getSCORE()
  {
    return this.SCORE;
  }
  
  public int getSERTYPE()
  {
    return this.SERTYPE;
  }
  
  public String getSGRQ()
  {
    return this.SGRQ;
  }
  
  public int getSOURCE()
  {
    return this.SOURCE;
  }
  
  public int getSWXW()
  {
    return this.SWXW;
  }
  
  public List<CleanServiceDetail> getValueAddedList()
  {
    return this.valueAddedList;
  }
  
  public String getWorkBillId()
  {
    return this.workBillId;
  }
  
  public String getYSR()
  {
    return this.YSR;
  }
  
  public String getYSRFJH()
  {
    return this.YSRFJH;
  }
  
  public String getYYR()
  {
    return this.YYR;
  }
  
  public String getYYSMSJ()
  {
    return this.YYSMSJ;
  }
  
  public void setDAYS(int paramInt)
  {
    this.DAYS = paramInt;
  }
  
  public void setExpand(String paramString)
  {
    this.expand = paramString;
  }
  
  public void setGDH(String paramString)
  {
    this.GDH = paramString;
  }
  
  public void setGYSZT(int paramInt)
  {
    this.GYSZT = paramInt;
  }
  
  public void setHFZT(int paramInt)
  {
    this.HFZT = paramInt;
  }
  
  public void setID(String paramString)
  {
    this.ID = paramString;
  }
  
  public void setPASSDAY(int paramInt)
  {
    this.PASSDAY = paramInt;
  }
  
  public void setPFR(String paramString)
  {
    this.PFR = paramString;
  }
  
  public void setPFRROOMNUM(String paramString)
  {
    this.PFRROOMNUM = paramString;
  }
  
  public void setProgress(CleanProgress paramCleanProgress)
  {
    this.progress = paramCleanProgress;
  }
  
  public void setRecordList(List<CleanRecord> paramList)
  {
    this.recordList = paramList;
  }
  
  public void setSCORE(String paramString)
  {
    this.SCORE = paramString;
  }
  
  public void setSERTYPE(int paramInt)
  {
    this.SERTYPE = paramInt;
  }
  
  public void setSGRQ(String paramString)
  {
    this.SGRQ = paramString;
  }
  
  public void setSOURCE(int paramInt)
  {
    this.SOURCE = paramInt;
  }
  
  public void setSWXW(int paramInt)
  {
    this.SWXW = paramInt;
  }
  
  public void setValueAddedList(List<CleanServiceDetail> paramList)
  {
    this.valueAddedList = paramList;
  }
  
  public void setWorkBillId(String paramString)
  {
    this.workBillId = paramString;
  }
  
  public void setYSR(String paramString)
  {
    this.YSR = paramString;
  }
  
  public void setYSRFJH(String paramString)
  {
    this.YSRFJH = paramString;
  }
  
  public void setYYR(String paramString)
  {
    this.YYR = paramString;
  }
  
  public void setYYSMSJ(String paramString)
  {
    this.YYSMSJ = paramString;
  }
  
  public String toString()
  {
    return "CleanInfo [ID=" + this.ID + ", expand=" + this.expand + ", workBillId=" + this.workBillId + ", GDH=" + this.GDH + ", SERTYPE=" + this.SERTYPE + ", GYSZT=" + this.GYSZT + ", SWXW=" + this.SWXW + ", YYSMSJ=" + this.YYSMSJ + ", YSRFJH=" + this.YSRFJH + ", SOURCE=" + this.SOURCE + ", DAYS=" + this.DAYS + ", YYR=" + this.YYR + ", SGRQ=" + this.SGRQ + ", SCORE=" + this.SCORE + ", HFZT=" + this.HFZT + ", PASSDAY=" + this.PASSDAY + ", YSR=" + this.YSR + ", PFR=" + this.PFR + ", PFRROOMNUM=" + this.PFRROOMNUM + ", recordList=" + this.recordList + ", progress=" + this.progress + ", valueAddedList=" + this.valueAddedList + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */