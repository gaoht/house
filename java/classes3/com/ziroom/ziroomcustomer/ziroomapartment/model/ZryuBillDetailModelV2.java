package com.ziroom.ziroomcustomer.ziroomapartment.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZryuBillDetailModelV2
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
    public int actualAmount;
    public String actualAmountStr;
    public String appVersionStr;
    public String billFid;
    public String billNum;
    public int billType;
    public List<CardCouponsBean> cardCoupons;
    public String cityCode;
    public String contractCode;
    public List<DetailsBean> details;
    public long gatherDate;
    public String gatherDateStr;
    public String imei;
    public String l;
    public String minPayAmount;
    public double oughtTotalAmount;
    public String oughtTotalAmountStr;
    public String payNum;
    public String paymentTime;
    public double pendingAmount;
    public String pendingAmountStr;
    public String phoneModel;
    public String source;
    public String state;
    public String sysVersionStr;
    public String timestamp;
    public String uid;
    
    public int getActualAmount()
    {
      return this.actualAmount;
    }
    
    public String getActualAmountStr()
    {
      return this.actualAmountStr;
    }
    
    public String getAppVersionStr()
    {
      return this.appVersionStr;
    }
    
    public String getBillFid()
    {
      return this.billFid;
    }
    
    public String getBillNum()
    {
      return this.billNum;
    }
    
    public int getBillType()
    {
      return this.billType;
    }
    
    public List<CardCouponsBean> getCardCoupons()
    {
      return this.cardCoupons;
    }
    
    public String getCityCode()
    {
      return this.cityCode;
    }
    
    public String getContractCode()
    {
      return this.contractCode;
    }
    
    public List<DetailsBean> getDetails()
    {
      return this.details;
    }
    
    public long getGatherDate()
    {
      return this.gatherDate;
    }
    
    public String getGatherDateStr()
    {
      return this.gatherDateStr;
    }
    
    public String getImei()
    {
      return this.imei;
    }
    
    public String getL()
    {
      return this.l;
    }
    
    public String getMinPayAmount()
    {
      return this.minPayAmount;
    }
    
    public double getOughtTotalAmount()
    {
      return this.oughtTotalAmount;
    }
    
    public String getOughtTotalAmountStr()
    {
      return this.oughtTotalAmountStr;
    }
    
    public String getPayNum()
    {
      return this.payNum;
    }
    
    public String getPaymentTime()
    {
      return this.paymentTime;
    }
    
    public String getPendingAmountStr()
    {
      return this.pendingAmountStr;
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
    
    public String getUid()
    {
      return this.uid;
    }
    
    public void setActualAmount(int paramInt)
    {
      this.actualAmount = paramInt;
    }
    
    public void setActualAmountStr(String paramString)
    {
      this.actualAmountStr = paramString;
    }
    
    public void setAppVersionStr(String paramString)
    {
      this.appVersionStr = paramString;
    }
    
    public void setBillFid(String paramString)
    {
      this.billFid = paramString;
    }
    
    public void setBillNum(String paramString)
    {
      this.billNum = paramString;
    }
    
    public void setBillType(int paramInt)
    {
      this.billType = paramInt;
    }
    
    public void setCardCoupons(List<CardCouponsBean> paramList)
    {
      this.cardCoupons = paramList;
    }
    
    public void setCityCode(String paramString)
    {
      this.cityCode = paramString;
    }
    
    public void setContractCode(String paramString)
    {
      this.contractCode = paramString;
    }
    
    public void setDetails(List<DetailsBean> paramList)
    {
      this.details = paramList;
    }
    
    public void setGatherDate(long paramLong)
    {
      this.gatherDate = paramLong;
    }
    
    public void setGatherDateStr(String paramString)
    {
      this.gatherDateStr = paramString;
    }
    
    public void setImei(String paramString)
    {
      this.imei = paramString;
    }
    
    public void setL(String paramString)
    {
      this.l = paramString;
    }
    
    public void setMinPayAmount(String paramString)
    {
      this.minPayAmount = paramString;
    }
    
    public void setOughtTotalAmount(double paramDouble)
    {
      this.oughtTotalAmount = paramDouble;
    }
    
    public void setOughtTotalAmountStr(String paramString)
    {
      this.oughtTotalAmountStr = paramString;
    }
    
    public void setPayNum(String paramString)
    {
      this.payNum = paramString;
    }
    
    public void setPaymentTime(String paramString)
    {
      this.paymentTime = paramString;
    }
    
    public void setPendingAmountStr(String paramString)
    {
      this.pendingAmountStr = paramString;
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
    
    public void setUid(String paramString)
    {
      this.uid = paramString;
    }
    
    public static class CardCouponsBean
      implements Parcelable
    {
      public static final Parcelable.Creator<CardCouponsBean> CREATOR = new Parcelable.Creator()
      {
        public ZryuBillDetailModelV2.DataBean.CardCouponsBean createFromParcel(Parcel paramAnonymousParcel)
        {
          return new ZryuBillDetailModelV2.DataBean.CardCouponsBean(paramAnonymousParcel);
        }
        
        public ZryuBillDetailModelV2.DataBean.CardCouponsBean[] newArray(int paramAnonymousInt)
        {
          return new ZryuBillDetailModelV2.DataBean.CardCouponsBean[paramAnonymousInt];
        }
      };
      public String code;
      public String desc;
      public String endTime;
      public int isChecked;
      public boolean isUsable;
      public String money;
      public String name;
      public String rule;
      public String serviceLineId;
      public String startTime;
      
      public CardCouponsBean() {}
      
      protected CardCouponsBean(Parcel paramParcel)
      {
        this.code = paramParcel.readString();
        this.name = paramParcel.readString();
        this.desc = paramParcel.readString();
        this.rule = paramParcel.readString();
        this.serviceLineId = paramParcel.readString();
        this.startTime = paramParcel.readString();
        this.endTime = paramParcel.readString();
        this.money = paramParcel.readString();
        this.isChecked = paramParcel.readInt();
        if (paramParcel.readByte() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.isUsable = bool;
          return;
        }
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeString(this.code);
        paramParcel.writeString(this.name);
        paramParcel.writeString(this.desc);
        paramParcel.writeString(this.rule);
        paramParcel.writeString(this.serviceLineId);
        paramParcel.writeString(this.startTime);
        paramParcel.writeString(this.endTime);
        paramParcel.writeString(this.money);
        paramParcel.writeInt(this.isChecked);
        if (this.isUsable) {}
        for (byte b = 1;; b = 0)
        {
          paramParcel.writeByte(b);
          return;
        }
      }
    }
    
    public static class DetailsBean
    {
      public String actualAmount;
      public int amount;
      public String appVersionStr;
      public String cityCode;
      public String imei;
      public String key;
      public String l;
      public String phoneModel;
      public String source;
      public String sysVersionStr;
      public String timestamp;
      public String value;
      
      public String getActualAmount()
      {
        return this.actualAmount;
      }
      
      public int getAmount()
      {
        return this.amount;
      }
      
      public String getAppVersionStr()
      {
        return this.appVersionStr;
      }
      
      public String getCityCode()
      {
        return this.cityCode;
      }
      
      public String getImei()
      {
        return this.imei;
      }
      
      public String getKey()
      {
        return this.key;
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
      
      public String getValue()
      {
        return this.value;
      }
      
      public void setActualAmount(String paramString)
      {
        this.actualAmount = paramString;
      }
      
      public void setAmount(int paramInt)
      {
        this.amount = paramInt;
      }
      
      public void setAppVersionStr(String paramString)
      {
        this.appVersionStr = paramString;
      }
      
      public void setCityCode(String paramString)
      {
        this.cityCode = paramString;
      }
      
      public void setImei(String paramString)
      {
        this.imei = paramString;
      }
      
      public void setKey(String paramString)
      {
        this.key = paramString;
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
      
      public void setValue(String paramString)
      {
        this.value = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuBillDetailModelV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */