package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class HeaderImgModel
  extends b
{
  public List<DataBean> data;
  
  public List<DataBean> getData()
  {
    return this.data;
  }
  
  public void setData(List<DataBean> paramList)
  {
    this.data = paramList;
  }
  
  public String toString()
  {
    return "HeaderImgModel{data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    public long createTime;
    public Object href;
    public int id;
    public String imgUrl;
    public int isDel;
    public long lastModifyTime;
    public int sort;
    public String systemCode;
    
    public long getCreateTime()
    {
      return this.createTime;
    }
    
    public Object getHref()
    {
      return this.href;
    }
    
    public int getId()
    {
      return this.id;
    }
    
    public String getImgUrl()
    {
      return this.imgUrl;
    }
    
    public int getIsDel()
    {
      return this.isDel;
    }
    
    public long getLastModifyTime()
    {
      return this.lastModifyTime;
    }
    
    public int getSort()
    {
      return this.sort;
    }
    
    public String getSystemCode()
    {
      return this.systemCode;
    }
    
    public void setCreateTime(long paramLong)
    {
      this.createTime = paramLong;
    }
    
    public void setHref(Object paramObject)
    {
      this.href = paramObject;
    }
    
    public void setId(int paramInt)
    {
      this.id = paramInt;
    }
    
    public void setImgUrl(String paramString)
    {
      this.imgUrl = paramString;
    }
    
    public void setIsDel(int paramInt)
    {
      this.isDel = paramInt;
    }
    
    public void setLastModifyTime(long paramLong)
    {
      this.lastModifyTime = paramLong;
    }
    
    public void setSort(int paramInt)
    {
      this.sort = paramInt;
    }
    
    public void setSystemCode(String paramString)
    {
      this.systemCode = paramString;
    }
    
    public String toString()
    {
      return "DataBean{id=" + this.id + ", createTime=" + this.createTime + ", lastModifyTime=" + this.lastModifyTime + ", isDel=" + this.isDel + ", sort=" + this.sort + ", systemCode='" + this.systemCode + '\'' + ", imgUrl='" + this.imgUrl + '\'' + ", href=" + this.href + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/HeaderImgModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */