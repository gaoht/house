package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import java.io.Serializable;
import java.util.List;

public class LandlordReleasePhotoBean
  implements Serializable
{
  private DataBean data;
  private String message;
  private String status;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataBean
    implements Serializable
  {
    private List<CoverPicListBean> coverPicList;
    private String defaultPicAuditMsg;
    private int houseAllPicCount;
    private String houseBaseFid;
    private String houseRoomFid;
    private Object houseStatus;
    private List<PicTypeListBean> picTypeList;
    private String remindMsg;
    private int rentWay;
    private int roomNum;
    private List<RoomPicListBean> roomPicList;
    
    public List<CoverPicListBean> getCoverPicList()
    {
      return this.coverPicList;
    }
    
    public String getDefaultPicAuditMsg()
    {
      return this.defaultPicAuditMsg;
    }
    
    public int getHouseAllPicCount()
    {
      return this.houseAllPicCount;
    }
    
    public String getHouseBaseFid()
    {
      return this.houseBaseFid;
    }
    
    public String getHouseRoomFid()
    {
      return this.houseRoomFid;
    }
    
    public Object getHouseStatus()
    {
      return this.houseStatus;
    }
    
    public List<PicTypeListBean> getPicTypeList()
    {
      return this.picTypeList;
    }
    
    public String getRemindMsg()
    {
      return this.remindMsg;
    }
    
    public int getRentWay()
    {
      return this.rentWay;
    }
    
    public int getRoomNum()
    {
      return this.roomNum;
    }
    
    public List<RoomPicListBean> getRoomPicList()
    {
      return this.roomPicList;
    }
    
    public void setCoverPicList(List<CoverPicListBean> paramList)
    {
      this.coverPicList = paramList;
    }
    
    public void setDefaultPicAuditMsg(String paramString)
    {
      this.defaultPicAuditMsg = paramString;
    }
    
    public void setHouseAllPicCount(int paramInt)
    {
      this.houseAllPicCount = paramInt;
    }
    
    public void setHouseBaseFid(String paramString)
    {
      this.houseBaseFid = paramString;
    }
    
    public void setHouseRoomFid(String paramString)
    {
      this.houseRoomFid = paramString;
    }
    
    public void setHouseStatus(Object paramObject)
    {
      this.houseStatus = paramObject;
    }
    
    public void setPicTypeList(List<PicTypeListBean> paramList)
    {
      this.picTypeList = paramList;
    }
    
    public void setRemindMsg(String paramString)
    {
      this.remindMsg = paramString;
    }
    
    public void setRentWay(int paramInt)
    {
      this.rentWay = paramInt;
    }
    
    public void setRoomNum(int paramInt)
    {
      this.roomNum = paramInt;
    }
    
    public void setRoomPicList(List<RoomPicListBean> paramList)
    {
      this.roomPicList = paramList;
    }
    
    public static class CoverPicListBean
      implements Serializable
    {
      private String defaultPicFid;
      private String houseFid;
      private String houseOrRoomName;
      private String maxPicUrl;
      private String minPicUrl;
      private String picBaseUrl;
      private String picSuffix;
      private int picType;
      private String roomFid;
      
      public String getDefaultPicFid()
      {
        return this.defaultPicFid;
      }
      
      public String getHouseFid()
      {
        return this.houseFid;
      }
      
      public String getHouseOrRoomName()
      {
        return this.houseOrRoomName;
      }
      
      public String getMaxPicUrl()
      {
        return this.maxPicUrl;
      }
      
      public String getMinPicUrl()
      {
        return this.minPicUrl;
      }
      
      public String getPicBaseUrl()
      {
        return this.picBaseUrl;
      }
      
      public String getPicSuffix()
      {
        return this.picSuffix;
      }
      
      public int getPicType()
      {
        return this.picType;
      }
      
      public String getRoomFid()
      {
        return this.roomFid;
      }
      
      public void setDefaultPicFid(String paramString)
      {
        this.defaultPicFid = paramString;
      }
      
      public void setHouseFid(String paramString)
      {
        this.houseFid = paramString;
      }
      
      public void setHouseOrRoomName(String paramString)
      {
        this.houseOrRoomName = paramString;
      }
      
      public void setMaxPicUrl(String paramString)
      {
        this.maxPicUrl = paramString;
      }
      
      public void setMinPicUrl(String paramString)
      {
        this.minPicUrl = paramString;
      }
      
      public void setPicBaseUrl(String paramString)
      {
        this.picBaseUrl = paramString;
      }
      
      public void setPicSuffix(String paramString)
      {
        this.picSuffix = paramString;
      }
      
      public void setPicType(int paramInt)
      {
        this.picType = paramInt;
      }
      
      public void setRoomFid(String paramString)
      {
        this.roomFid = paramString;
      }
    }
    
    public static class PicTypeListBean
      implements Serializable
    {
      private List<PicListBean> picList;
      private int picMaxNum;
      private int picMinNum;
      private int picType;
      private String picTypeName;
      private String roomFid;
      
      public List<PicListBean> getPicList()
      {
        return this.picList;
      }
      
      public int getPicMaxNum()
      {
        return this.picMaxNum;
      }
      
      public int getPicMinNum()
      {
        return this.picMinNum;
      }
      
      public int getPicType()
      {
        return this.picType;
      }
      
      public String getPicTypeName()
      {
        return this.picTypeName;
      }
      
      public String getRoomFid()
      {
        return this.roomFid;
      }
      
      public void setPicList(List<PicListBean> paramList)
      {
        this.picList = paramList;
      }
      
      public void setPicMaxNum(int paramInt)
      {
        this.picMaxNum = paramInt;
      }
      
      public void setPicMinNum(int paramInt)
      {
        this.picMinNum = paramInt;
      }
      
      public void setPicType(int paramInt)
      {
        this.picType = paramInt;
      }
      
      public void setPicTypeName(String paramString)
      {
        this.picTypeName = paramString;
      }
      
      public void setRoomFid(String paramString)
      {
        this.roomFid = paramString;
      }
      
      public static class PicListBean
        implements Serializable
      {
        private int auditStatus;
        private Object bedFid;
        private long createDate;
        private String createFid;
        private String fid;
        private int heightDpi;
        private int heightPixel;
        private String houseBaseFid;
        private int id;
        private int isDefault;
        private int isDel;
        private long lastModifyDate;
        private String maxPicUrl;
        private String minPicUrl;
        private int operateType;
        private String picAuditMsg;
        private String picBaseUrl;
        private String picName;
        private String picServerUuid;
        private double picSize;
        private Object picSort;
        private String picSuffix;
        private int picType;
        private Object replaceFid;
        private String roomFid;
        private int widthDpi;
        private int widthPixel;
        
        public int getAuditStatus()
        {
          return this.auditStatus;
        }
        
        public Object getBedFid()
        {
          return this.bedFid;
        }
        
        public long getCreateDate()
        {
          return this.createDate;
        }
        
        public String getCreateFid()
        {
          return this.createFid;
        }
        
        public String getFid()
        {
          return this.fid;
        }
        
        public int getHeightDpi()
        {
          return this.heightDpi;
        }
        
        public int getHeightPixel()
        {
          return this.heightPixel;
        }
        
        public String getHouseBaseFid()
        {
          return this.houseBaseFid;
        }
        
        public int getId()
        {
          return this.id;
        }
        
        public int getIsDefault()
        {
          return this.isDefault;
        }
        
        public int getIsDel()
        {
          return this.isDel;
        }
        
        public long getLastModifyDate()
        {
          return this.lastModifyDate;
        }
        
        public String getMaxPicUrl()
        {
          return this.maxPicUrl;
        }
        
        public String getMinPicUrl()
        {
          return this.minPicUrl;
        }
        
        public int getOperateType()
        {
          return this.operateType;
        }
        
        public String getPicAuditMsg()
        {
          return this.picAuditMsg;
        }
        
        public String getPicBaseUrl()
        {
          return this.picBaseUrl;
        }
        
        public String getPicName()
        {
          return this.picName;
        }
        
        public String getPicServerUuid()
        {
          return this.picServerUuid;
        }
        
        public double getPicSize()
        {
          return this.picSize;
        }
        
        public Object getPicSort()
        {
          return this.picSort;
        }
        
        public String getPicSuffix()
        {
          return this.picSuffix;
        }
        
        public int getPicType()
        {
          return this.picType;
        }
        
        public Object getReplaceFid()
        {
          return this.replaceFid;
        }
        
        public String getRoomFid()
        {
          return this.roomFid;
        }
        
        public int getWidthDpi()
        {
          return this.widthDpi;
        }
        
        public int getWidthPixel()
        {
          return this.widthPixel;
        }
        
        public void setAuditStatus(int paramInt)
        {
          this.auditStatus = paramInt;
        }
        
        public void setBedFid(Object paramObject)
        {
          this.bedFid = paramObject;
        }
        
        public void setCreateDate(long paramLong)
        {
          this.createDate = paramLong;
        }
        
        public void setCreateFid(String paramString)
        {
          this.createFid = paramString;
        }
        
        public void setFid(String paramString)
        {
          this.fid = paramString;
        }
        
        public void setHeightDpi(int paramInt)
        {
          this.heightDpi = paramInt;
        }
        
        public void setHeightPixel(int paramInt)
        {
          this.heightPixel = paramInt;
        }
        
        public void setHouseBaseFid(String paramString)
        {
          this.houseBaseFid = paramString;
        }
        
        public void setId(int paramInt)
        {
          this.id = paramInt;
        }
        
        public void setIsDefault(int paramInt)
        {
          this.isDefault = paramInt;
        }
        
        public void setIsDel(int paramInt)
        {
          this.isDel = paramInt;
        }
        
        public void setLastModifyDate(long paramLong)
        {
          this.lastModifyDate = paramLong;
        }
        
        public void setMaxPicUrl(String paramString)
        {
          this.maxPicUrl = paramString;
        }
        
        public void setMinPicUrl(String paramString)
        {
          this.minPicUrl = paramString;
        }
        
        public void setOperateType(int paramInt)
        {
          this.operateType = paramInt;
        }
        
        public void setPicAuditMsg(String paramString)
        {
          this.picAuditMsg = paramString;
        }
        
        public void setPicBaseUrl(String paramString)
        {
          this.picBaseUrl = paramString;
        }
        
        public void setPicName(String paramString)
        {
          this.picName = paramString;
        }
        
        public void setPicServerUuid(String paramString)
        {
          this.picServerUuid = paramString;
        }
        
        public void setPicSize(double paramDouble)
        {
          this.picSize = paramDouble;
        }
        
        public void setPicSort(Object paramObject)
        {
          this.picSort = paramObject;
        }
        
        public void setPicSuffix(String paramString)
        {
          this.picSuffix = paramString;
        }
        
        public void setPicType(int paramInt)
        {
          this.picType = paramInt;
        }
        
        public void setReplaceFid(Object paramObject)
        {
          this.replaceFid = paramObject;
        }
        
        public void setRoomFid(String paramString)
        {
          this.roomFid = paramString;
        }
        
        public void setWidthDpi(int paramInt)
        {
          this.widthDpi = paramInt;
        }
        
        public void setWidthPixel(int paramInt)
        {
          this.widthPixel = paramInt;
        }
      }
    }
    
    public static class RoomPicListBean
      implements Serializable, Comparable<RoomPicListBean>
    {
      private long createDate;
      private int id;
      private List<PicListBeanX> picList;
      private int picMaxNum;
      private int picMinNum;
      private int picType;
      private String picTypeName;
      private String roomFid;
      private String roomName;
      
      public int compareTo(RoomPicListBean paramRoomPicListBean)
      {
        long l = getId() - paramRoomPicListBean.getId();
        if (l > 0L) {
          return 1;
        }
        if (l < 0L) {
          return -1;
        }
        return 0;
      }
      
      public long getCreateDate()
      {
        return this.createDate;
      }
      
      public int getId()
      {
        return this.id;
      }
      
      public List<PicListBeanX> getPicList()
      {
        return this.picList;
      }
      
      public int getPicMaxNum()
      {
        return this.picMaxNum;
      }
      
      public int getPicMinNum()
      {
        return this.picMinNum;
      }
      
      public int getPicType()
      {
        return this.picType;
      }
      
      public String getPicTypeName()
      {
        return this.picTypeName;
      }
      
      public String getRoomFid()
      {
        return this.roomFid;
      }
      
      public String getRoomName()
      {
        return this.roomName;
      }
      
      public void setCreateDate(long paramLong)
      {
        this.createDate = paramLong;
      }
      
      public void setId(int paramInt)
      {
        this.id = paramInt;
      }
      
      public void setPicList(List<PicListBeanX> paramList)
      {
        this.picList = paramList;
      }
      
      public void setPicMaxNum(int paramInt)
      {
        this.picMaxNum = paramInt;
      }
      
      public void setPicMinNum(int paramInt)
      {
        this.picMinNum = paramInt;
      }
      
      public void setPicType(int paramInt)
      {
        this.picType = paramInt;
      }
      
      public void setPicTypeName(String paramString)
      {
        this.picTypeName = paramString;
      }
      
      public void setRoomFid(String paramString)
      {
        this.roomFid = paramString;
      }
      
      public void setRoomName(String paramString)
      {
        this.roomName = paramString;
      }
      
      public static class PicListBeanX
        implements Serializable
      {
        private int auditStatus;
        private Object bedFid;
        private long createDate;
        private String createFid;
        private String fid;
        private int heightDpi;
        private int heightPixel;
        private String houseBaseFid;
        private int id;
        private int isDefault;
        private int isDel;
        private long lastModifyDate;
        private String maxPicUrl;
        private String minPicUrl;
        private int operateType;
        private String picAuditMsg;
        private String picBaseUrl;
        private String picName;
        private String picServerUuid;
        private double picSize;
        private Object picSort;
        private String picSuffix;
        private int picType;
        private Object replaceFid;
        private String roomFid;
        private int widthDpi;
        private int widthPixel;
        
        public int getAuditStatus()
        {
          return this.auditStatus;
        }
        
        public Object getBedFid()
        {
          return this.bedFid;
        }
        
        public long getCreateDate()
        {
          return this.createDate;
        }
        
        public String getCreateFid()
        {
          return this.createFid;
        }
        
        public String getFid()
        {
          return this.fid;
        }
        
        public int getHeightDpi()
        {
          return this.heightDpi;
        }
        
        public int getHeightPixel()
        {
          return this.heightPixel;
        }
        
        public String getHouseBaseFid()
        {
          return this.houseBaseFid;
        }
        
        public int getId()
        {
          return this.id;
        }
        
        public int getIsDefault()
        {
          return this.isDefault;
        }
        
        public int getIsDel()
        {
          return this.isDel;
        }
        
        public long getLastModifyDate()
        {
          return this.lastModifyDate;
        }
        
        public String getMaxPicUrl()
        {
          return this.maxPicUrl;
        }
        
        public String getMinPicUrl()
        {
          return this.minPicUrl;
        }
        
        public int getOperateType()
        {
          return this.operateType;
        }
        
        public String getPicAuditMsg()
        {
          return this.picAuditMsg;
        }
        
        public String getPicBaseUrl()
        {
          return this.picBaseUrl;
        }
        
        public String getPicName()
        {
          return this.picName;
        }
        
        public String getPicServerUuid()
        {
          return this.picServerUuid;
        }
        
        public double getPicSize()
        {
          return this.picSize;
        }
        
        public Object getPicSort()
        {
          return this.picSort;
        }
        
        public String getPicSuffix()
        {
          return this.picSuffix;
        }
        
        public int getPicType()
        {
          return this.picType;
        }
        
        public Object getReplaceFid()
        {
          return this.replaceFid;
        }
        
        public String getRoomFid()
        {
          return this.roomFid;
        }
        
        public int getWidthDpi()
        {
          return this.widthDpi;
        }
        
        public int getWidthPixel()
        {
          return this.widthPixel;
        }
        
        public void setAuditStatus(int paramInt)
        {
          this.auditStatus = paramInt;
        }
        
        public void setBedFid(Object paramObject)
        {
          this.bedFid = paramObject;
        }
        
        public void setCreateDate(long paramLong)
        {
          this.createDate = paramLong;
        }
        
        public void setCreateFid(String paramString)
        {
          this.createFid = paramString;
        }
        
        public void setFid(String paramString)
        {
          this.fid = paramString;
        }
        
        public void setHeightDpi(int paramInt)
        {
          this.heightDpi = paramInt;
        }
        
        public void setHeightPixel(int paramInt)
        {
          this.heightPixel = paramInt;
        }
        
        public void setHouseBaseFid(String paramString)
        {
          this.houseBaseFid = paramString;
        }
        
        public void setId(int paramInt)
        {
          this.id = paramInt;
        }
        
        public void setIsDefault(int paramInt)
        {
          this.isDefault = paramInt;
        }
        
        public void setIsDel(int paramInt)
        {
          this.isDel = paramInt;
        }
        
        public void setLastModifyDate(long paramLong)
        {
          this.lastModifyDate = paramLong;
        }
        
        public void setMaxPicUrl(String paramString)
        {
          this.maxPicUrl = paramString;
        }
        
        public void setMinPicUrl(String paramString)
        {
          this.minPicUrl = paramString;
        }
        
        public void setOperateType(int paramInt)
        {
          this.operateType = paramInt;
        }
        
        public void setPicAuditMsg(String paramString)
        {
          this.picAuditMsg = paramString;
        }
        
        public void setPicBaseUrl(String paramString)
        {
          this.picBaseUrl = paramString;
        }
        
        public void setPicName(String paramString)
        {
          this.picName = paramString;
        }
        
        public void setPicServerUuid(String paramString)
        {
          this.picServerUuid = paramString;
        }
        
        public void setPicSize(double paramDouble)
        {
          this.picSize = paramDouble;
        }
        
        public void setPicSort(Object paramObject)
        {
          this.picSort = paramObject;
        }
        
        public void setPicSuffix(String paramString)
        {
          this.picSuffix = paramString;
        }
        
        public void setPicType(int paramInt)
        {
          this.picType = paramInt;
        }
        
        public void setReplaceFid(Object paramObject)
        {
          this.replaceFid = paramObject;
        }
        
        public void setRoomFid(String paramString)
        {
          this.roomFid = paramString;
        }
        
        public void setWidthDpi(int paramInt)
        {
          this.widthDpi = paramInt;
        }
        
        public void setWidthPixel(int paramInt)
        {
          this.widthPixel = paramInt;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LandlordReleasePhotoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */