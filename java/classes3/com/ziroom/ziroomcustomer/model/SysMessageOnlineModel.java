package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class SysMessageOnlineModel
{
  public int code;
  public List<DataBean> data;
  public Object messages;
  public String status;
  
  public int getCode()
  {
    return this.code;
  }
  
  public List<DataBean> getData()
  {
    return this.data;
  }
  
  public Object getMessages()
  {
    return this.messages;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setCode(int paramInt)
  {
    this.code = paramInt;
  }
  
  public void setData(List<DataBean> paramList)
  {
    this.data = paramList;
  }
  
  public void setMessages(Object paramObject)
  {
    this.messages = paramObject;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataBean
  {
    public String content;
    public String extras;
    public int isRead;
    public int isReceive;
    public String sendTime;
    public String sendType;
    public String title;
    
    public String getContent()
    {
      return this.content;
    }
    
    public int getIsRead()
    {
      return this.isRead;
    }
    
    public int getIsReceive()
    {
      return this.isReceive;
    }
    
    public String getSendTime()
    {
      return this.sendTime;
    }
    
    public String getSendType()
    {
      return this.sendType;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setContent(String paramString)
    {
      this.content = paramString;
    }
    
    public void setIsRead(int paramInt)
    {
      this.isRead = paramInt;
    }
    
    public void setIsReceive(int paramInt)
    {
      this.isReceive = paramInt;
    }
    
    public void setSendTime(String paramString)
    {
      this.sendTime = paramString;
    }
    
    public void setSendType(String paramString)
    {
      this.sendType = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/SysMessageOnlineModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */