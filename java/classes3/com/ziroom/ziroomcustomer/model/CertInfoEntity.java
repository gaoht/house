package com.ziroom.ziroomcustomer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class CertInfoEntity
  implements Parcelable
{
  public static final Parcelable.Creator<CertInfoEntity> CREATOR = new Parcelable.Creator()
  {
    public CertInfoEntity createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CertInfoEntity(paramAnonymousParcel);
    }
    
    public CertInfoEntity[] newArray(int paramAnonymousInt)
    {
      return new CertInfoEntity[paramAnonymousInt];
    }
  };
  public String cert_id;
  public int cert_is_lock;
  public String cert_num;
  public String cert_type;
  public String company_type;
  public CreditsBean credits;
  public int gender;
  public String is_default;
  public NewsignCertListBean newsign_cert_list;
  public String real_name;
  public int sign_user_type;
  public String user_cert1;
  public String user_cert2;
  public String user_cert3;
  public int user_is_lock;
  public String user_type;
  
  public CertInfoEntity() {}
  
  protected CertInfoEntity(Parcel paramParcel)
  {
    this.cert_id = paramParcel.readString();
    this.cert_type = paramParcel.readString();
    this.cert_num = paramParcel.readString();
    this.user_cert1 = paramParcel.readString();
    this.user_cert2 = paramParcel.readString();
    this.user_cert3 = paramParcel.readString();
    this.real_name = paramParcel.readString();
    this.user_type = paramParcel.readString();
    this.company_type = paramParcel.readString();
    this.is_default = paramParcel.readString();
    this.sign_user_type = paramParcel.readInt();
    this.gender = paramParcel.readInt();
    this.user_is_lock = paramParcel.readInt();
    this.cert_is_lock = paramParcel.readInt();
    this.credits = ((CreditsBean)paramParcel.readParcelable(CreditsBean.class.getClassLoader()));
    this.newsign_cert_list = ((NewsignCertListBean)paramParcel.readParcelable(NewsignCertListBean.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCert_id()
  {
    return this.cert_id;
  }
  
  public int getCert_is_lock()
  {
    return this.cert_is_lock;
  }
  
  public String getCert_num()
  {
    return this.cert_num;
  }
  
  public String getCert_type()
  {
    return this.cert_type;
  }
  
  public String getCompany_type()
  {
    return this.company_type;
  }
  
  public CreditsBean getCredits()
  {
    return this.credits;
  }
  
  public int getGender()
  {
    return this.gender;
  }
  
  public String getIs_default()
  {
    return this.is_default;
  }
  
  public NewsignCertListBean getNewsign_cert_list()
  {
    return this.newsign_cert_list;
  }
  
  public String getReal_name()
  {
    return this.real_name;
  }
  
  public int getSign_user_type()
  {
    return this.sign_user_type;
  }
  
  public String getUser_cert1()
  {
    return this.user_cert1;
  }
  
  public String getUser_cert2()
  {
    return this.user_cert2;
  }
  
  public String getUser_cert3()
  {
    return this.user_cert3;
  }
  
  public int getUser_is_lock()
  {
    return this.user_is_lock;
  }
  
  public String getUser_type()
  {
    return this.user_type;
  }
  
  public void setCert_id(String paramString)
  {
    this.cert_id = paramString;
  }
  
  public void setCert_is_lock(int paramInt)
  {
    this.cert_is_lock = paramInt;
  }
  
  public void setCert_num(String paramString)
  {
    this.cert_num = paramString;
  }
  
  public void setCert_type(String paramString)
  {
    this.cert_type = paramString;
  }
  
  public void setCompany_type(String paramString)
  {
    this.company_type = paramString;
  }
  
  public void setCredits(CreditsBean paramCreditsBean)
  {
    this.credits = paramCreditsBean;
  }
  
  public void setGender(int paramInt)
  {
    this.gender = paramInt;
  }
  
  public void setIs_default(String paramString)
  {
    this.is_default = paramString;
  }
  
  public void setNewsign_cert_list(NewsignCertListBean paramNewsignCertListBean)
  {
    this.newsign_cert_list = paramNewsignCertListBean;
  }
  
  public void setReal_name(String paramString)
  {
    this.real_name = paramString;
  }
  
  public void setSign_user_type(int paramInt)
  {
    this.sign_user_type = paramInt;
  }
  
  public void setUser_cert1(String paramString)
  {
    this.user_cert1 = paramString;
  }
  
  public void setUser_cert2(String paramString)
  {
    this.user_cert2 = paramString;
  }
  
  public void setUser_cert3(String paramString)
  {
    this.user_cert3 = paramString;
  }
  
  public void setUser_is_lock(int paramInt)
  {
    this.user_is_lock = paramInt;
  }
  
  public void setUser_type(String paramString)
  {
    this.user_type = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.cert_id);
    paramParcel.writeString(this.cert_type);
    paramParcel.writeString(this.cert_num);
    paramParcel.writeString(this.user_cert1);
    paramParcel.writeString(this.user_cert2);
    paramParcel.writeString(this.user_cert3);
    paramParcel.writeString(this.real_name);
    paramParcel.writeString(this.user_type);
    paramParcel.writeString(this.company_type);
    paramParcel.writeString(this.is_default);
    paramParcel.writeInt(this.sign_user_type);
    paramParcel.writeInt(this.gender);
    paramParcel.writeInt(this.user_is_lock);
    paramParcel.writeInt(this.cert_is_lock);
    paramParcel.writeParcelable(this.credits, paramInt);
    paramParcel.writeParcelable(this.newsign_cert_list, paramInt);
  }
  
  public static class CreditsBean
    implements Parcelable
  {
    public static final Parcelable.Creator<CreditsBean> CREATOR = new Parcelable.Creator()
    {
      public CertInfoEntity.CreditsBean createFromParcel(Parcel paramAnonymousParcel)
      {
        return new CertInfoEntity.CreditsBean(paramAnonymousParcel);
      }
      
      public CertInfoEntity.CreditsBean[] newArray(int paramAnonymousInt)
      {
        return new CertInfoEntity.CreditsBean[paramAnonymousInt];
      }
    };
    public String agreeUrl;
    public int authStatus;
    public int educationStatus;
    public int linkedinStatus;
    public int mmRelStatus;
    public int realNameStatus;
    public String realRejectReason;
    public String rejectReason;
    public int workStatus;
    public int zhimaScore;
    public int ziroomScore;
    
    public CreditsBean() {}
    
    protected CreditsBean(Parcel paramParcel)
    {
      this.linkedinStatus = paramParcel.readInt();
      this.rejectReason = paramParcel.readString();
      this.agreeUrl = paramParcel.readString();
      this.educationStatus = paramParcel.readInt();
      this.workStatus = paramParcel.readInt();
      this.ziroomScore = paramParcel.readInt();
      this.zhimaScore = paramParcel.readInt();
      this.mmRelStatus = paramParcel.readInt();
      this.realNameStatus = paramParcel.readInt();
      this.authStatus = paramParcel.readInt();
      this.realRejectReason = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getAgreeUrl()
    {
      return this.agreeUrl;
    }
    
    public int getAuthStatus()
    {
      return this.authStatus;
    }
    
    public int getEducationStatus()
    {
      return this.educationStatus;
    }
    
    public int getLinkedinStatus()
    {
      return this.linkedinStatus;
    }
    
    public int getMmRelStatus()
    {
      return this.mmRelStatus;
    }
    
    public int getRealNameStatus()
    {
      return this.realNameStatus;
    }
    
    public String getRealRejectReason()
    {
      return this.realRejectReason;
    }
    
    public int getWorkStatus()
    {
      return this.workStatus;
    }
    
    public int getZhimaScore()
    {
      return this.zhimaScore;
    }
    
    public int getZiroomScore()
    {
      return this.ziroomScore;
    }
    
    public void setAgreeUrl(String paramString)
    {
      this.agreeUrl = paramString;
    }
    
    public void setAuthStatus(int paramInt)
    {
      this.authStatus = paramInt;
    }
    
    public void setEducationStatus(int paramInt)
    {
      this.educationStatus = paramInt;
    }
    
    public void setLinkedinStatus(int paramInt)
    {
      this.linkedinStatus = paramInt;
    }
    
    public void setMmRelStatus(int paramInt)
    {
      this.mmRelStatus = paramInt;
    }
    
    public void setRealNameStatus(int paramInt)
    {
      this.realNameStatus = paramInt;
    }
    
    public void setRealRejectReason(String paramString)
    {
      this.realRejectReason = paramString;
    }
    
    public void setWorkStatus(int paramInt)
    {
      this.workStatus = paramInt;
    }
    
    public void setZhimaScore(int paramInt)
    {
      this.zhimaScore = paramInt;
    }
    
    public void setZiroomScore(int paramInt)
    {
      this.ziroomScore = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.linkedinStatus);
      paramParcel.writeString(this.rejectReason);
      paramParcel.writeString(this.agreeUrl);
      paramParcel.writeInt(this.educationStatus);
      paramParcel.writeInt(this.workStatus);
      paramParcel.writeInt(this.ziroomScore);
      paramParcel.writeInt(this.zhimaScore);
      paramParcel.writeInt(this.mmRelStatus);
      paramParcel.writeInt(this.realNameStatus);
      paramParcel.writeInt(this.authStatus);
      paramParcel.writeString(this.realRejectReason);
    }
  }
  
  public static class NewsignCertListBean
    implements Parcelable
  {
    public static final Parcelable.Creator<NewsignCertListBean> CREATOR = new Parcelable.Creator()
    {
      public CertInfoEntity.NewsignCertListBean createFromParcel(Parcel paramAnonymousParcel)
      {
        return new CertInfoEntity.NewsignCertListBean(paramAnonymousParcel);
      }
      
      public CertInfoEntity.NewsignCertListBean[] newArray(int paramAnonymousInt)
      {
        return new CertInfoEntity.NewsignCertListBean[paramAnonymousInt];
      }
    };
    public AuthStatusTips auth_status_tips;
    public String change_object;
    public List<CompanyBean> company;
    public List<UserType> company_sign_type;
    public List<PersonalBean> personal;
    
    public NewsignCertListBean() {}
    
    protected NewsignCertListBean(Parcel paramParcel)
    {
      this.personal = new ArrayList();
      paramParcel.readList(this.personal, PersonalBean.class.getClassLoader());
      this.company = new ArrayList();
      paramParcel.readList(this.company, CompanyBean.class.getClassLoader());
      this.auth_status_tips = ((AuthStatusTips)paramParcel.readParcelable(AuthStatusTips.class.getClassLoader()));
      this.change_object = paramParcel.readString();
      this.company_sign_type = new ArrayList();
      paramParcel.readList(this.company_sign_type, UserType.class.getClassLoader());
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public AuthStatusTips getAuth_status_tips()
    {
      return this.auth_status_tips;
    }
    
    public String getChange_object()
    {
      return this.change_object;
    }
    
    public List<CompanyBean> getCompany()
    {
      return this.company;
    }
    
    public List<UserType> getCompany_sign_type()
    {
      return this.company_sign_type;
    }
    
    public List<PersonalBean> getPersonal()
    {
      return this.personal;
    }
    
    public void setAuth_status_tips(AuthStatusTips paramAuthStatusTips)
    {
      this.auth_status_tips = paramAuthStatusTips;
    }
    
    public void setChange_object(String paramString)
    {
      this.change_object = paramString;
    }
    
    public void setCompany(List<CompanyBean> paramList)
    {
      this.company = paramList;
    }
    
    public void setCompany_sign_type(List<UserType> paramList)
    {
      this.company_sign_type = paramList;
    }
    
    public void setPersonal(List<PersonalBean> paramList)
    {
      this.personal = paramList;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeList(this.personal);
      paramParcel.writeList(this.company);
      paramParcel.writeParcelable(this.auth_status_tips, paramInt);
      paramParcel.writeString(this.change_object);
      paramParcel.writeList(this.company_sign_type);
    }
    
    public static class AuthStatusTips
      implements Parcelable
    {
      public static final Parcelable.Creator<AuthStatusTips> CREATOR = new Parcelable.Creator()
      {
        public CertInfoEntity.NewsignCertListBean.AuthStatusTips createFromParcel(Parcel paramAnonymousParcel)
        {
          return new CertInfoEntity.NewsignCertListBean.AuthStatusTips(paramAnonymousParcel);
        }
        
        public CertInfoEntity.NewsignCertListBean.AuthStatusTips[] newArray(int paramAnonymousInt)
        {
          return new CertInfoEntity.NewsignCertListBean.AuthStatusTips[paramAnonymousInt];
        }
      };
      public String ID_card_in_auth;
      public String auth_success;
      public String in_auth;
      
      public AuthStatusTips() {}
      
      protected AuthStatusTips(Parcel paramParcel)
      {
        this.ID_card_in_auth = paramParcel.readString();
        this.in_auth = paramParcel.readString();
        this.auth_success = paramParcel.readString();
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String getAuth_success()
      {
        return this.auth_success;
      }
      
      public String getID_card_in_auth()
      {
        return this.ID_card_in_auth;
      }
      
      public String getIn_auth()
      {
        return this.in_auth;
      }
      
      public void setAuth_success(String paramString)
      {
        this.auth_success = paramString;
      }
      
      public void setID_card_in_auth(String paramString)
      {
        this.ID_card_in_auth = paramString;
      }
      
      public void setIn_auth(String paramString)
      {
        this.in_auth = paramString;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeString(this.ID_card_in_auth);
        paramParcel.writeString(this.in_auth);
        paramParcel.writeString(this.auth_success);
      }
    }
    
    public static class CompanyBean
      implements Parcelable
    {
      public static final Parcelable.Creator<CompanyBean> CREATOR = new Parcelable.Creator()
      {
        public CertInfoEntity.NewsignCertListBean.CompanyBean createFromParcel(Parcel paramAnonymousParcel)
        {
          return new CertInfoEntity.NewsignCertListBean.CompanyBean(paramAnonymousParcel);
        }
        
        public CertInfoEntity.NewsignCertListBean.CompanyBean[] newArray(int paramAnonymousInt)
        {
          return new CertInfoEntity.NewsignCertListBean.CompanyBean[paramAnonymousInt];
        }
      };
      public String cert_name;
      public int cert_type;
      public int company_type;
      public List<String> default_pic;
      public String remarks;
      public String standards;
      public String tips;
      public String type;
      
      public CompanyBean() {}
      
      protected CompanyBean(Parcel paramParcel)
      {
        this.type = paramParcel.readString();
        this.cert_name = paramParcel.readString();
        this.cert_type = paramParcel.readInt();
        this.tips = paramParcel.readString();
        this.standards = paramParcel.readString();
        this.company_type = paramParcel.readInt();
        this.remarks = paramParcel.readString();
        this.default_pic = new ArrayList();
        paramParcel.readStringList(this.default_pic);
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String getCert_name()
      {
        return this.cert_name;
      }
      
      public int getCert_type()
      {
        return this.cert_type;
      }
      
      public int getCompany_type()
      {
        return this.company_type;
      }
      
      public List<String> getDefault_pic()
      {
        return this.default_pic;
      }
      
      public String getRemarks()
      {
        return this.remarks;
      }
      
      public String getStandards()
      {
        return this.standards;
      }
      
      public String getTips()
      {
        return this.tips;
      }
      
      public String getType()
      {
        return this.type;
      }
      
      public void setCert_name(String paramString)
      {
        this.cert_name = paramString;
      }
      
      public void setCert_type(int paramInt)
      {
        this.cert_type = paramInt;
      }
      
      public void setCompany_type(int paramInt)
      {
        this.company_type = paramInt;
      }
      
      public void setDefault_pic(List<String> paramList)
      {
        this.default_pic = paramList;
      }
      
      public void setRemarks(String paramString)
      {
        this.remarks = paramString;
      }
      
      public void setStandards(String paramString)
      {
        this.standards = paramString;
      }
      
      public void setTips(String paramString)
      {
        this.tips = paramString;
      }
      
      public void setType(String paramString)
      {
        this.type = paramString;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeString(this.type);
        paramParcel.writeString(this.cert_name);
        paramParcel.writeInt(this.cert_type);
        paramParcel.writeString(this.tips);
        paramParcel.writeString(this.standards);
        paramParcel.writeInt(this.company_type);
        paramParcel.writeString(this.remarks);
        paramParcel.writeStringList(this.default_pic);
      }
    }
    
    public static class PersonalBean
      implements Parcelable
    {
      public static final Parcelable.Creator<PersonalBean> CREATOR = new Parcelable.Creator()
      {
        public CertInfoEntity.NewsignCertListBean.PersonalBean createFromParcel(Parcel paramAnonymousParcel)
        {
          return new CertInfoEntity.NewsignCertListBean.PersonalBean(paramAnonymousParcel);
        }
        
        public CertInfoEntity.NewsignCertListBean.PersonalBean[] newArray(int paramAnonymousInt)
        {
          return new CertInfoEntity.NewsignCertListBean.PersonalBean[paramAnonymousInt];
        }
      };
      public String cert_name;
      public int cert_type;
      public List<String> default_pic;
      public int pic_count;
      public String remarks;
      public String standards;
      public String tips;
      public String type;
      
      public PersonalBean() {}
      
      protected PersonalBean(Parcel paramParcel)
      {
        this.type = paramParcel.readString();
        this.cert_name = paramParcel.readString();
        this.cert_type = paramParcel.readInt();
        this.tips = paramParcel.readString();
        this.standards = paramParcel.readString();
        this.remarks = paramParcel.readString();
        this.pic_count = paramParcel.readInt();
        this.default_pic = new ArrayList();
        paramParcel.readStringList(this.default_pic);
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String getCert_name()
      {
        return this.cert_name;
      }
      
      public int getCert_type()
      {
        return this.cert_type;
      }
      
      public List<String> getDefault_pic()
      {
        return this.default_pic;
      }
      
      public int getPic_count()
      {
        return this.pic_count;
      }
      
      public String getRemarks()
      {
        return this.remarks;
      }
      
      public String getStandards()
      {
        return this.standards;
      }
      
      public String getTips()
      {
        return this.tips;
      }
      
      public String getType()
      {
        return this.type;
      }
      
      public void setCert_name(String paramString)
      {
        this.cert_name = paramString;
      }
      
      public void setCert_type(int paramInt)
      {
        this.cert_type = paramInt;
      }
      
      public void setDefault_pic(List<String> paramList)
      {
        this.default_pic = paramList;
      }
      
      public void setPic_count(int paramInt)
      {
        this.pic_count = paramInt;
      }
      
      public void setRemarks(String paramString)
      {
        this.remarks = paramString;
      }
      
      public void setStandards(String paramString)
      {
        this.standards = paramString;
      }
      
      public void setTips(String paramString)
      {
        this.tips = paramString;
      }
      
      public void setType(String paramString)
      {
        this.type = paramString;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeString(this.type);
        paramParcel.writeString(this.cert_name);
        paramParcel.writeInt(this.cert_type);
        paramParcel.writeString(this.tips);
        paramParcel.writeString(this.standards);
        paramParcel.writeString(this.remarks);
        paramParcel.writeInt(this.pic_count);
        paramParcel.writeStringList(this.default_pic);
      }
    }
    
    public static class UserType
      implements Parcelable
    {
      public static final Parcelable.Creator<UserType> CREATOR = new Parcelable.Creator()
      {
        public CertInfoEntity.NewsignCertListBean.UserType createFromParcel(Parcel paramAnonymousParcel)
        {
          return new CertInfoEntity.NewsignCertListBean.UserType(paramAnonymousParcel);
        }
        
        public CertInfoEntity.NewsignCertListBean.UserType[] newArray(int paramAnonymousInt)
        {
          return new CertInfoEntity.NewsignCertListBean.UserType[paramAnonymousInt];
        }
      };
      public String name;
      public int pic_count;
      public int sign_user_type;
      
      public UserType() {}
      
      protected UserType(Parcel paramParcel)
      {
        this.sign_user_type = paramParcel.readInt();
        this.name = paramParcel.readString();
        this.pic_count = paramParcel.readInt();
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String getName()
      {
        return this.name;
      }
      
      public int getPic_count()
      {
        return this.pic_count;
      }
      
      public int getSign_user_type()
      {
        return this.sign_user_type;
      }
      
      public void setName(String paramString)
      {
        this.name = paramString;
      }
      
      public void setPic_count(int paramInt)
      {
        this.pic_count = paramInt;
      }
      
      public void setSign_user_type(int paramInt)
      {
        this.sign_user_type = paramInt;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.sign_user_type);
        paramParcel.writeString(this.name);
        paramParcel.writeInt(this.pic_count);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CertInfoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */