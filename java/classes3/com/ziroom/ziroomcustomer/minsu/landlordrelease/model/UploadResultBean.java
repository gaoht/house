package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import java.util.List;

public class UploadResultBean
  extends MinsuBaseJson
{
  private List<DataBean> data;
  
  public List<DataBean> getData()
  {
    return this.data;
  }
  
  public void setData(List<DataBean> paramList)
  {
    this.data = paramList;
  }
  
  public static class DataBean
  {
    private String fid;
    private String heightPixel;
    private String isDefault;
    private String minPicUrl;
    private int picType;
    private String picUrl;
    private String widthPixel;
    
    public String getFid()
    {
      return this.fid;
    }
    
    public String getHeightPixel()
    {
      return this.heightPixel;
    }
    
    public String getIsDefault()
    {
      return this.isDefault;
    }
    
    public String getMinPicUrl()
    {
      return this.minPicUrl;
    }
    
    public int getPicType()
    {
      return this.picType;
    }
    
    public String getPicUrl()
    {
      return this.picUrl;
    }
    
    public String getWidthPixel()
    {
      return this.widthPixel;
    }
    
    public void setFid(String paramString)
    {
      this.fid = paramString;
    }
    
    public void setHeightPixel(String paramString)
    {
      this.heightPixel = paramString;
    }
    
    public void setIsDefault(String paramString)
    {
      this.isDefault = paramString;
    }
    
    public void setMinPicUrl(String paramString)
    {
      this.minPicUrl = paramString;
    }
    
    public void setPicType(int paramInt)
    {
      this.picType = paramInt;
    }
    
    public void setPicUrl(String paramString)
    {
      this.picUrl = paramString;
    }
    
    public void setWidthPixel(String paramString)
    {
      this.widthPixel = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/UploadResultBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */