package com.ziroom.ziroomcustomer.model;

import com.ziroom.ziroomcustomer.newServiceList.model.LabelMo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RepairWorkItem
  implements Serializable
{
  private String cue = "";
  private String detailDescription = "";
  private String goodsId;
  private String[] image = { "", "", "" };
  private String kongJian = "";
  private String kongJianId = "";
  private ArrayList<LabelMo> lableCode = null;
  private String oject = "";
  private String ojectId = "";
  private String pic = "";
  private List<InternalFaultPic> picList;
  private String[] url = { "", "", "" };
  private String wxgz = "";
  private String wxgzId = "";
  private String zhuti = "";
  private String zhutiId = "";
  
  public String getCue()
  {
    return this.cue;
  }
  
  public String getDetailDescription()
  {
    return this.detailDescription;
  }
  
  public String getGoodsId()
  {
    return this.goodsId;
  }
  
  public String[] getImage()
  {
    return this.image;
  }
  
  public String getKongJian()
  {
    return this.kongJian;
  }
  
  public String getKongJianId()
  {
    return this.kongJianId;
  }
  
  public ArrayList<LabelMo> getLableCode()
  {
    return this.lableCode;
  }
  
  public String getOject()
  {
    return this.oject;
  }
  
  public String getOjectId()
  {
    return this.ojectId;
  }
  
  public String getPic()
  {
    return this.pic;
  }
  
  public List<InternalFaultPic> getPicList()
  {
    return this.picList;
  }
  
  public String[] getUrl()
  {
    return this.url;
  }
  
  public String getWxgz()
  {
    return this.wxgz;
  }
  
  public String getWxgzId()
  {
    return this.wxgzId;
  }
  
  public String getZhuti()
  {
    return this.zhuti;
  }
  
  public String getZhutiId()
  {
    return this.zhutiId;
  }
  
  public void setCue(String paramString)
  {
    this.cue = paramString;
  }
  
  public void setDetailDescription(String paramString)
  {
    this.detailDescription = paramString;
  }
  
  public void setGoodsId(String paramString)
  {
    this.goodsId = paramString;
  }
  
  public void setImage(String[] paramArrayOfString)
  {
    this.image = paramArrayOfString;
  }
  
  public void setKongJian(String paramString)
  {
    this.kongJian = paramString;
  }
  
  public void setKongJianId(String paramString)
  {
    this.kongJianId = paramString;
  }
  
  public void setLableCode(ArrayList<LabelMo> paramArrayList)
  {
    this.lableCode = paramArrayList;
  }
  
  public void setOject(String paramString)
  {
    this.oject = paramString;
  }
  
  public void setOjectId(String paramString)
  {
    this.ojectId = paramString;
  }
  
  public void setPic(String paramString)
  {
    this.pic = paramString;
  }
  
  public void setPicList(List<InternalFaultPic> paramList)
  {
    this.picList = paramList;
  }
  
  public void setUrl(String[] paramArrayOfString)
  {
    this.url = paramArrayOfString;
  }
  
  public void setWxgz(String paramString)
  {
    this.wxgz = paramString;
  }
  
  public void setWxgzId(String paramString)
  {
    this.wxgzId = paramString;
  }
  
  public void setZhuti(String paramString)
  {
    this.zhuti = paramString;
  }
  
  public void setZhutiId(String paramString)
  {
    this.zhutiId = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/RepairWorkItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */