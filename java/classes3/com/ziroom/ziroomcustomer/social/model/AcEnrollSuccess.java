package com.ziroom.ziroomcustomer.social.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class AcEnrollSuccess
  implements Parcelable
{
  public static final Parcelable.Creator<AcEnrollSuccess> CREATOR = new Parcelable.Creator()
  {
    public AcEnrollSuccess createFromParcel(Parcel paramAnonymousParcel)
    {
      return new AcEnrollSuccess(paramAnonymousParcel);
    }
    
    public AcEnrollSuccess[] newArray(int paramAnonymousInt)
    {
      return new AcEnrollSuccess[paramAnonymousInt];
    }
  };
  private String a;
  private ShareBean b;
  private String c;
  private List<ButtonBean> d;
  
  public AcEnrollSuccess() {}
  
  protected AcEnrollSuccess(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ((ShareBean)paramParcel.readParcelable(ShareBean.class.getClassLoader()));
    this.c = paramParcel.readString();
    this.d = paramParcel.createTypedArrayList(ButtonBean.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<ButtonBean> getButton()
  {
    return this.d;
  }
  
  public String getMessage()
  {
    return this.c;
  }
  
  public ShareBean getShare()
  {
    return this.b;
  }
  
  public String getTitle()
  {
    return this.a;
  }
  
  public void setButton(List<ButtonBean> paramList)
  {
    this.d = paramList;
  }
  
  public void setMessage(String paramString)
  {
    this.c = paramString;
  }
  
  public void setShare(ShareBean paramShareBean)
  {
    this.b = paramShareBean;
  }
  
  public void setTitle(String paramString)
  {
    this.a = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeString(this.c);
    paramParcel.writeTypedList(this.d);
  }
  
  public static class ButtonBean
    implements Parcelable
  {
    public static final Parcelable.Creator<ButtonBean> CREATOR = new Parcelable.Creator()
    {
      public AcEnrollSuccess.ButtonBean createFromParcel(Parcel paramAnonymousParcel)
      {
        return new AcEnrollSuccess.ButtonBean(paramAnonymousParcel);
      }
      
      public AcEnrollSuccess.ButtonBean[] newArray(int paramAnonymousInt)
      {
        return new AcEnrollSuccess.ButtonBean[paramAnonymousInt];
      }
    };
    private String a;
    private int b;
    private String c;
    private String d;
    
    public ButtonBean() {}
    
    protected ButtonBean(Parcel paramParcel)
    {
      this.a = paramParcel.readString();
      this.b = paramParcel.readInt();
      this.c = paramParcel.readString();
      this.d = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getColor()
    {
      return this.c;
    }
    
    public String getContent()
    {
      return this.a;
    }
    
    public int getType()
    {
      return this.b;
    }
    
    public String getUrl()
    {
      return this.d;
    }
    
    public void setColor(String paramString)
    {
      this.c = paramString;
    }
    
    public void setContent(String paramString)
    {
      this.a = paramString;
    }
    
    public void setType(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void setUrl(String paramString)
    {
      this.d = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.a);
      paramParcel.writeInt(this.b);
      paramParcel.writeString(this.c);
      paramParcel.writeString(this.d);
    }
  }
  
  public static class ShareBean
    implements Parcelable
  {
    public static final Parcelable.Creator<ShareBean> CREATOR = new Parcelable.Creator()
    {
      public AcEnrollSuccess.ShareBean createFromParcel(Parcel paramAnonymousParcel)
      {
        return new AcEnrollSuccess.ShareBean(paramAnonymousParcel);
      }
      
      public AcEnrollSuccess.ShareBean[] newArray(int paramAnonymousInt)
      {
        return new AcEnrollSuccess.ShareBean[paramAnonymousInt];
      }
    };
    private String a;
    private int b;
    private String c;
    private String d;
    private String e;
    private String f;
    
    public ShareBean() {}
    
    protected ShareBean(Parcel paramParcel)
    {
      this.a = paramParcel.readString();
      this.b = paramParcel.readInt();
      this.c = paramParcel.readString();
      this.d = paramParcel.readString();
      this.e = paramParcel.readString();
      this.f = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public int getActive()
    {
      return this.b;
    }
    
    public String getButton_show()
    {
      return this.a;
    }
    
    public String getContent()
    {
      return this.d;
    }
    
    public String getImage()
    {
      return this.f;
    }
    
    public String getTitle()
    {
      return this.c;
    }
    
    public String getUrl()
    {
      return this.e;
    }
    
    public void setActive(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void setButton_show(String paramString)
    {
      this.a = paramString;
    }
    
    public void setContent(String paramString)
    {
      this.d = paramString;
    }
    
    public void setImage(String paramString)
    {
      this.f = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.c = paramString;
    }
    
    public void setUrl(String paramString)
    {
      this.e = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.a);
      paramParcel.writeInt(this.b);
      paramParcel.writeString(this.c);
      paramParcel.writeString(this.d);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.f);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/model/AcEnrollSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */