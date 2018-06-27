package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuAuthInfoBean
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
    private String idNo;
    private IdTypeListBean idTypeList;
    private boolean isEdit;
    private String realName;
    private String voucherBackPicUrl;
    private String voucherFrontPicUrl;
    private String voucherHandPicUrl;
    
    public String getIdNo()
    {
      return this.idNo;
    }
    
    public IdTypeListBean getIdTypeList()
    {
      return this.idTypeList;
    }
    
    public String getRealName()
    {
      return this.realName;
    }
    
    public String getVoucherBackPicUrl()
    {
      return this.voucherBackPicUrl;
    }
    
    public String getVoucherFrontPicUrl()
    {
      return this.voucherFrontPicUrl;
    }
    
    public String getVoucherHandPicUrl()
    {
      return this.voucherHandPicUrl;
    }
    
    public boolean isIsEdit()
    {
      return this.isEdit;
    }
    
    public void setIdNo(String paramString)
    {
      this.idNo = paramString;
    }
    
    public void setIdTypeList(IdTypeListBean paramIdTypeListBean)
    {
      this.idTypeList = paramIdTypeListBean;
    }
    
    public void setIsEdit(boolean paramBoolean)
    {
      this.isEdit = paramBoolean;
    }
    
    public void setRealName(String paramString)
    {
      this.realName = paramString;
    }
    
    public void setVoucherBackPicUrl(String paramString)
    {
      this.voucherBackPicUrl = paramString;
    }
    
    public void setVoucherFrontPicUrl(String paramString)
    {
      this.voucherFrontPicUrl = paramString;
    }
    
    public void setVoucherHandPicUrl(String paramString)
    {
      this.voucherHandPicUrl = paramString;
    }
    
    public static class IdTypeListBean
    {
      private List<ListBean> list;
      private String selectName;
      
      public List<ListBean> getList()
      {
        return this.list;
      }
      
      public String getSelectName()
      {
        return this.selectName;
      }
      
      public void setList(List<ListBean> paramList)
      {
        this.list = paramList;
      }
      
      public void setSelectName(String paramString)
      {
        this.selectName = paramString;
      }
      
      public static class ListBean
      {
        private String explain;
        private boolean isSelect;
        private String text;
        private int value;
        
        public String getExplain()
        {
          return this.explain;
        }
        
        public String getText()
        {
          return this.text;
        }
        
        public int getValue()
        {
          return this.value;
        }
        
        public boolean isIsSelect()
        {
          return this.isSelect;
        }
        
        public void setExplain(String paramString)
        {
          this.explain = paramString;
        }
        
        public void setIsSelect(boolean paramBoolean)
        {
          this.isSelect = paramBoolean;
        }
        
        public void setText(String paramString)
        {
          this.text = paramString;
        }
        
        public void setValue(int paramInt)
        {
          this.value = paramInt;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuAuthInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */