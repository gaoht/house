package com.ziroom.ziroomcustomer.minsu.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MinsuChatMemberBaseInfoBean
  implements Parcelable
{
  public static final Parcelable.Creator<MinsuChatMemberBaseInfoBean> CREATOR = new Parcelable.Creator()
  {
    public MinsuChatMemberBaseInfoBean createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MinsuChatMemberBaseInfoBean(paramAnonymousParcel);
    }
    
    public MinsuChatMemberBaseInfoBean[] newArray(int paramAnonymousInt)
    {
      return new MinsuChatMemberBaseInfoBean[paramAnonymousInt];
    }
  };
  private String headImg;
  private String nickName;
  private String uid;
  
  public MinsuChatMemberBaseInfoBean() {}
  
  protected MinsuChatMemberBaseInfoBean(Parcel paramParcel)
  {
    this.uid = paramParcel.readString();
    this.nickName = paramParcel.readString();
    this.headImg = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getHeadImg()
  {
    return this.headImg;
  }
  
  public String getNickName()
  {
    return this.nickName;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public void setHeadImg(String paramString)
  {
    this.headImg = paramString;
  }
  
  public void setNickName(String paramString)
  {
    this.nickName = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uid);
    paramParcel.writeString(this.nickName);
    paramParcel.writeString(this.headImg);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuChatMemberBaseInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */