package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.util.List;

public class ZryuSignCotenantList
{
  private List<ZryuSignCertType> certTypeList;
  private List<ZryuSignCotenant> sharerList;
  
  public List<ZryuSignCertType> getCertTypeList()
  {
    return this.certTypeList;
  }
  
  public List<ZryuSignCotenant> getSharerList()
  {
    return this.sharerList;
  }
  
  public void setCertTypeList(List<ZryuSignCertType> paramList)
  {
    this.certTypeList = paramList;
  }
  
  public void setSharerList(List<ZryuSignCotenant> paramList)
  {
    this.sharerList = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignCotenantList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */