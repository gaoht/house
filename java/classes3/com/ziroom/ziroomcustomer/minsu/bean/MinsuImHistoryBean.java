package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuImHistoryBean
{
  public DataBean data;
  public String message;
  public String status;
  
  public String toString()
  {
    return "MinsuImHistoryBean{status='" + this.status + '\'' + ", message='" + this.message + '\'' + ", data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    public List<ListBean> list;
    public int total;
    
    public String toString()
    {
      return "DataBean{total=" + this.total + ", list=" + this.list + '}';
    }
    
    public static class ListBean
    {
      public AppChatRecordsExtBean appChatRecordsExt;
      public String changZuExt;
      public String chatType;
      public String fileLength;
      public String filename;
      public String fromUid;
      public String msgContent;
      public long msgSendTime;
      public int msgSenderType;
      public String secret;
      public String size;
      public String toUid;
      public String type;
      public String url;
      
      public String toString()
      {
        return "ListBean{fromUid='" + this.fromUid + '\'' + ", toUid='" + this.toUid + '\'' + ", msgSenderType=" + this.msgSenderType + ", msgContent='" + this.msgContent + '\'' + ", msgSendTime=" + this.msgSendTime + ", chatType='" + this.chatType + '\'' + ", type='" + this.type + '\'' + ", url='" + this.url + '\'' + ", filename='" + this.filename + '\'' + ", secret='" + this.secret + '\'' + ", fileLength='" + this.fileLength + '\'' + ", size='" + this.size + '\'' + ", changZuExt='" + this.changZuExt + '\'' + ", appChatRecordsExt=" + this.appChatRecordsExt + '}';
      }
      
      public static class AppChatRecordsExtBean
      {
        public String domainFlag;
        public String em_expr_big_name;
        public String endDate;
        public String fid;
        public String houseCard;
        public String houseName;
        public String housePicUrl;
        public String huanxinMsgId;
        public String msgType;
        public String nicName;
        public String personNum;
        public int rentWay;
        public String rentWayName;
        public int roleType;
        public String shareHouseMsg;
        public String startDate;
        public String userPic;
        public String ziroomFlag;
        
        public String toString()
        {
          return "AppChatRecordsExtBean{fid='" + this.fid + '\'' + ", rentWay=" + this.rentWay + ", rentWayName=" + this.rentWayName + ", startDate='" + this.startDate + '\'' + ", endDate='" + this.endDate + '\'' + ", ziroomFlag='" + this.ziroomFlag + '\'' + ", personNum='" + this.personNum + '\'' + ", houseName='" + this.houseName + '\'' + ", housePicUrl='" + this.housePicUrl + '\'' + ", houseCard='" + this.houseCard + '\'' + ", huanxinMsgId='" + this.huanxinMsgId + '\'' + ", domainFlag='" + this.domainFlag + '\'' + ", roleType=" + this.roleType + ", msgType='" + this.msgType + '\'' + ", shareHouseMsg='" + this.shareHouseMsg + '\'' + '}';
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuImHistoryBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */