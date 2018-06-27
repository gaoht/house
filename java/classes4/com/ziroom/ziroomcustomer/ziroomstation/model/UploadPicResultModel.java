package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.freelxl.baselibrary.b.b;

public class UploadPicResultModel
  extends b
{
  public DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public static class DataBean
  {
    public String appVersionStr;
    public String base64Content;
    public String cityCode;
    public String filename;
    public String imei;
    public String imgUrl;
    public String l;
    public String phoneModel;
    public String source;
    public String sysVersionStr;
    public String timestamp;
    
    public String getAppVersionStr()
    {
      return this.appVersionStr;
    }
    
    public String getBase64Content()
    {
      return this.base64Content;
    }
    
    public String getCityCode()
    {
      return this.cityCode;
    }
    
    public String getFilename()
    {
      return this.filename;
    }
    
    public String getImei()
    {
      return this.imei;
    }
    
    public String getImgUrl()
    {
      return this.imgUrl;
    }
    
    public String getL()
    {
      return this.l;
    }
    
    public String getPhoneModel()
    {
      return this.phoneModel;
    }
    
    public String getSource()
    {
      return this.source;
    }
    
    public String getSysVersionStr()
    {
      return this.sysVersionStr;
    }
    
    public String getTimestamp()
    {
      return this.timestamp;
    }
    
    public void setAppVersionStr(String paramString)
    {
      this.appVersionStr = paramString;
    }
    
    public void setBase64Content(String paramString)
    {
      this.base64Content = paramString;
    }
    
    public void setCityCode(String paramString)
    {
      this.cityCode = paramString;
    }
    
    public void setFilename(String paramString)
    {
      this.filename = paramString;
    }
    
    public void setImei(String paramString)
    {
      this.imei = paramString;
    }
    
    public void setImgUrl(String paramString)
    {
      this.imgUrl = paramString;
    }
    
    public void setL(String paramString)
    {
      this.l = paramString;
    }
    
    public void setPhoneModel(String paramString)
    {
      this.phoneModel = paramString;
    }
    
    public void setSource(String paramString)
    {
      this.source = paramString;
    }
    
    public void setSysVersionStr(String paramString)
    {
      this.sysVersionStr = paramString;
    }
    
    public void setTimestamp(String paramString)
    {
      this.timestamp = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/UploadPicResultModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */