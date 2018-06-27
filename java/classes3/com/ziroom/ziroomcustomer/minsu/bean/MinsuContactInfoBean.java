package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuContactInfoBean
  extends MinsuBaseJson
{
  private DataBean data;
  
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
    private AreaListBean areaList;
    private String customerMobile;
    private boolean isEdit;
    private String nationCode;
    private String nationName;
    private String sendCertificateCode;
    
    public AreaListBean getAreaList()
    {
      return this.areaList;
    }
    
    public String getCustomerMobile()
    {
      return this.customerMobile;
    }
    
    public String getNationCode()
    {
      return this.nationCode;
    }
    
    public String getNationName()
    {
      return this.nationName;
    }
    
    public String getSendCertificateCode()
    {
      return this.sendCertificateCode;
    }
    
    public boolean isIsEdit()
    {
      return this.isEdit;
    }
    
    public void setAreaList(AreaListBean paramAreaListBean)
    {
      this.areaList = paramAreaListBean;
    }
    
    public void setCustomerMobile(String paramString)
    {
      this.customerMobile = paramString;
    }
    
    public void setIsEdit(boolean paramBoolean)
    {
      this.isEdit = paramBoolean;
    }
    
    public void setNationCode(String paramString)
    {
      this.nationCode = paramString;
    }
    
    public void setNationName(String paramString)
    {
      this.nationName = paramString;
    }
    
    public void setSendCertificateCode(String paramString)
    {
      this.sendCertificateCode = paramString;
    }
    
    public static class AreaListBean
    {
      private boolean isEdit;
      private List<ListBean> list;
      
      public List<ListBean> getList()
      {
        return this.list;
      }
      
      public boolean isIsEdit()
      {
        return this.isEdit;
      }
      
      public void setIsEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setList(List<ListBean> paramList)
      {
        this.list = paramList;
      }
      
      public static class ListBean
      {
        private String selected;
        private String text;
        private String value;
        
        public String getSelected()
        {
          return this.selected;
        }
        
        public String getText()
        {
          return this.text;
        }
        
        public String getValue()
        {
          return this.value;
        }
        
        public void setSelected(String paramString)
        {
          this.selected = paramString;
        }
        
        public void setText(String paramString)
        {
          this.text = paramString;
        }
        
        public void setValue(String paramString)
        {
          this.value = paramString;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuContactInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */