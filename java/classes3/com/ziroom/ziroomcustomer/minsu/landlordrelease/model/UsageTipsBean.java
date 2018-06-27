package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import java.util.List;

public class UsageTipsBean
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
    private TipMsgBean tipMsg;
    
    public TipMsgBean getTipMsg()
    {
      return this.tipMsg;
    }
    
    public void setTipMsg(TipMsgBean paramTipMsgBean)
    {
      this.tipMsg = paramTipMsgBean;
    }
    
    public static class TipMsgBean
    {
      private List<SubTitleContentsBean> subTitleContents;
      private String title;
      
      public List<SubTitleContentsBean> getSubTitleContents()
      {
        return this.subTitleContents;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setSubTitleContents(List<SubTitleContentsBean> paramList)
      {
        this.subTitleContents = paramList;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class SubTitleContentsBean
      {
        private String subContent;
        private String subTitle;
        
        public String getSubContent()
        {
          return this.subContent;
        }
        
        public String getSubTitle()
        {
          return this.subTitle;
        }
        
        public void setSubContent(String paramString)
        {
          this.subContent = paramString;
        }
        
        public void setSubTitle(String paramString)
        {
          this.subTitle = paramString;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/UsageTipsBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */