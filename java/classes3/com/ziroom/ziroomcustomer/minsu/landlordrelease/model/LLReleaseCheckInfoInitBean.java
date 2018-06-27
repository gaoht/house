package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import java.util.List;

public class LLReleaseCheckInfoInitBean
  extends MinsuBaseJson
{
  private LLReleaseCheckInfoInitDataBean data;
  
  public LLReleaseCheckInfoInitDataBean getData()
  {
    return this.data;
  }
  
  public void setData(LLReleaseCheckInfoInitDataBean paramLLReleaseCheckInfoInitDataBean)
  {
    this.data = paramLLReleaseCheckInfoInitDataBean;
  }
  
  public class LLReleaseCheckInfoInitDataBean
  {
    private CheckInTimeBean checkInTime;
    private CheckOutTimeBean checkOutTime;
    private MinDayBean minDay;
    
    public LLReleaseCheckInfoInitDataBean() {}
    
    public CheckInTimeBean getCheckInTime()
    {
      return this.checkInTime;
    }
    
    public CheckOutTimeBean getCheckOutTime()
    {
      return this.checkOutTime;
    }
    
    public MinDayBean getMinDay()
    {
      return this.minDay;
    }
    
    public void setCheckInTime(CheckInTimeBean paramCheckInTimeBean)
    {
      this.checkInTime = paramCheckInTimeBean;
    }
    
    public void setCheckOutTime(CheckOutTimeBean paramCheckOutTimeBean)
    {
      this.checkOutTime = paramCheckOutTimeBean;
    }
    
    public void setMinDay(MinDayBean paramMinDayBean)
    {
      this.minDay = paramMinDayBean;
    }
    
    public class CheckInTimeBean
    {
      private boolean isEdit;
      private List<CheckInTimListBean> list;
      
      public CheckInTimeBean() {}
      
      public List<CheckInTimListBean> getList()
      {
        return this.list;
      }
      
      public boolean isEdit()
      {
        return this.isEdit;
      }
      
      public void setEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setList(List<CheckInTimListBean> paramList)
      {
        this.list = paramList;
      }
      
      public class CheckInTimListBean
      {
        private Object explain;
        private boolean isSelect;
        private String text;
        private String value;
        
        public CheckInTimListBean() {}
        
        public Object getExplain()
        {
          return this.explain;
        }
        
        public String getText()
        {
          return this.text;
        }
        
        public String getValue()
        {
          return this.value;
        }
        
        public boolean isIsSelect()
        {
          return this.isSelect;
        }
        
        public void setExplain(Object paramObject)
        {
          this.explain = paramObject;
        }
        
        public void setIsSelect(boolean paramBoolean)
        {
          this.isSelect = paramBoolean;
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
    
    public class CheckOutTimeBean
    {
      private boolean isEdit;
      private List<CheckOutTimeListBean> list;
      
      public CheckOutTimeBean() {}
      
      public List<CheckOutTimeListBean> getList()
      {
        return this.list;
      }
      
      public boolean isEdit()
      {
        return this.isEdit;
      }
      
      public void setEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setList(List<CheckOutTimeListBean> paramList)
      {
        this.list = paramList;
      }
      
      public class CheckOutTimeListBean
      {
        private Object explain;
        private boolean isSelect;
        private String text;
        private String value;
        
        public CheckOutTimeListBean() {}
        
        public Object getExplain()
        {
          return this.explain;
        }
        
        public String getText()
        {
          return this.text;
        }
        
        public String getValue()
        {
          return this.value;
        }
        
        public boolean isIsSelect()
        {
          return this.isSelect;
        }
        
        public void setExplain(Object paramObject)
        {
          this.explain = paramObject;
        }
        
        public void setIsSelect(boolean paramBoolean)
        {
          this.isSelect = paramBoolean;
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
    
    public class MinDayBean
    {
      private boolean isEdit;
      private List<ListMinDayBean> list;
      
      public MinDayBean() {}
      
      public List<ListMinDayBean> getList()
      {
        return this.list;
      }
      
      public boolean isEdit()
      {
        return this.isEdit;
      }
      
      public void setEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setList(List<ListMinDayBean> paramList)
      {
        this.list = paramList;
      }
      
      public class ListMinDayBean
      {
        private Object explain;
        private boolean isSelect;
        private String text;
        private String value;
        
        public ListMinDayBean() {}
        
        public Object getExplain()
        {
          return this.explain;
        }
        
        public String getText()
        {
          return this.text;
        }
        
        public String getValue()
        {
          return this.value;
        }
        
        public boolean isIsSelect()
        {
          return this.isSelect;
        }
        
        public void setExplain(Object paramObject)
        {
          this.explain = paramObject;
        }
        
        public void setIsSelect(boolean paramBoolean)
        {
          this.isSelect = paramBoolean;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LLReleaseCheckInfoInitBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */