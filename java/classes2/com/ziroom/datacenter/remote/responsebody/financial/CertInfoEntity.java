package com.ziroom.datacenter.remote.responsebody.financial;

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
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public int k;
  public int l;
  public int m;
  public int n;
  public CreditsBean o;
  public NewsignCertListBean p;
  
  public CertInfoEntity() {}
  
  protected CertInfoEntity(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readInt();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readInt();
    this.o = ((CreditsBean)paramParcel.readParcelable(CreditsBean.class.getClassLoader()));
    this.p = ((NewsignCertListBean)paramParcel.readParcelable(NewsignCertListBean.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCert_id()
  {
    return this.a;
  }
  
  public int getCert_is_lock()
  {
    return this.n;
  }
  
  public String getCert_num()
  {
    return this.c;
  }
  
  public String getCert_type()
  {
    return this.b;
  }
  
  public String getCompany_type()
  {
    return this.i;
  }
  
  public CreditsBean getCredits()
  {
    return this.o;
  }
  
  public int getGender()
  {
    return this.l;
  }
  
  public String getIs_default()
  {
    return this.j;
  }
  
  public NewsignCertListBean getNewsign_cert_list()
  {
    return this.p;
  }
  
  public String getReal_name()
  {
    return this.g;
  }
  
  public int getSign_user_type()
  {
    return this.k;
  }
  
  public String getUser_cert1()
  {
    return this.d;
  }
  
  public String getUser_cert2()
  {
    return this.e;
  }
  
  public String getUser_cert3()
  {
    return this.f;
  }
  
  public int getUser_is_lock()
  {
    return this.m;
  }
  
  public String getUser_type()
  {
    return this.h;
  }
  
  public void setCert_id(String paramString)
  {
    this.a = paramString;
  }
  
  public void setCert_is_lock(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setCert_num(String paramString)
  {
    this.c = paramString;
  }
  
  public void setCert_type(String paramString)
  {
    this.b = paramString;
  }
  
  public void setCompany_type(String paramString)
  {
    this.i = paramString;
  }
  
  public void setCredits(CreditsBean paramCreditsBean)
  {
    this.o = paramCreditsBean;
  }
  
  public void setGender(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setIs_default(String paramString)
  {
    this.j = paramString;
  }
  
  public void setNewsign_cert_list(NewsignCertListBean paramNewsignCertListBean)
  {
    this.p = paramNewsignCertListBean;
  }
  
  public void setReal_name(String paramString)
  {
    this.g = paramString;
  }
  
  public void setSign_user_type(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setUser_cert1(String paramString)
  {
    this.d = paramString;
  }
  
  public void setUser_cert2(String paramString)
  {
    this.e = paramString;
  }
  
  public void setUser_cert3(String paramString)
  {
    this.f = paramString;
  }
  
  public void setUser_is_lock(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setUser_type(String paramString)
  {
    this.h = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeParcelable(this.o, paramInt);
    paramParcel.writeParcelable(this.p, paramInt);
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
    public int a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    
    public CreditsBean() {}
    
    protected CreditsBean(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
      this.b = paramParcel.readString();
      this.d = paramParcel.readString();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.g = paramParcel.readInt();
      this.h = paramParcel.readInt();
      this.i = paramParcel.readInt();
      this.j = paramParcel.readInt();
      this.k = paramParcel.readInt();
      this.c = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getAgreeUrl()
    {
      return this.d;
    }
    
    public int getAuthStatus()
    {
      return this.k;
    }
    
    public int getEducationStatus()
    {
      return this.e;
    }
    
    public int getLinkedinStatus()
    {
      return this.a;
    }
    
    public int getMmRelStatus()
    {
      return this.i;
    }
    
    public int getRealNameStatus()
    {
      return this.j;
    }
    
    public String getRealRejectReason()
    {
      return this.c;
    }
    
    public int getWorkStatus()
    {
      return this.f;
    }
    
    public int getZhimaScore()
    {
      return this.h;
    }
    
    public int getZiroomScore()
    {
      return this.g;
    }
    
    public void setAgreeUrl(String paramString)
    {
      this.d = paramString;
    }
    
    public void setAuthStatus(int paramInt)
    {
      this.k = paramInt;
    }
    
    public void setEducationStatus(int paramInt)
    {
      this.e = paramInt;
    }
    
    public void setLinkedinStatus(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void setMmRelStatus(int paramInt)
    {
      this.i = paramInt;
    }
    
    public void setRealNameStatus(int paramInt)
    {
      this.j = paramInt;
    }
    
    public void setRealRejectReason(String paramString)
    {
      this.c = paramString;
    }
    
    public void setWorkStatus(int paramInt)
    {
      this.f = paramInt;
    }
    
    public void setZhimaScore(int paramInt)
    {
      this.h = paramInt;
    }
    
    public void setZiroomScore(int paramInt)
    {
      this.g = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.a);
      paramParcel.writeString(this.b);
      paramParcel.writeString(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      paramParcel.writeInt(this.g);
      paramParcel.writeInt(this.h);
      paramParcel.writeInt(this.i);
      paramParcel.writeInt(this.j);
      paramParcel.writeInt(this.k);
      paramParcel.writeString(this.c);
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
    public List<PersonalBean> a;
    public AuthStatusTips b;
    public List<CompanyBean> c;
    public String d;
    public List<UserType> e;
    
    public NewsignCertListBean() {}
    
    protected NewsignCertListBean(Parcel paramParcel)
    {
      this.a = new ArrayList();
      paramParcel.readList(this.a, PersonalBean.class.getClassLoader());
      this.c = new ArrayList();
      paramParcel.readList(this.c, CompanyBean.class.getClassLoader());
      this.b = ((AuthStatusTips)paramParcel.readParcelable(AuthStatusTips.class.getClassLoader()));
      this.d = paramParcel.readString();
      this.e = new ArrayList();
      paramParcel.readList(this.e, UserType.class.getClassLoader());
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public AuthStatusTips getAuth_status_tips()
    {
      return this.b;
    }
    
    public String getChange_object()
    {
      return this.d;
    }
    
    public List<CompanyBean> getCompany()
    {
      return this.c;
    }
    
    public List<UserType> getCompany_sign_type()
    {
      return this.e;
    }
    
    public List<PersonalBean> getPersonal()
    {
      return this.a;
    }
    
    public void setAuth_status_tips(AuthStatusTips paramAuthStatusTips)
    {
      this.b = paramAuthStatusTips;
    }
    
    public void setChange_object(String paramString)
    {
      this.d = paramString;
    }
    
    public void setCompany(List<CompanyBean> paramList)
    {
      this.c = paramList;
    }
    
    public void setCompany_sign_type(List<UserType> paramList)
    {
      this.e = paramList;
    }
    
    public void setPersonal(List<PersonalBean> paramList)
    {
      this.a = paramList;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeList(this.a);
      paramParcel.writeList(this.c);
      paramParcel.writeParcelable(this.b, paramInt);
      paramParcel.writeString(this.d);
      paramParcel.writeList(this.e);
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
      public String a;
      public String b;
      public String c;
      
      public AuthStatusTips() {}
      
      protected AuthStatusTips(Parcel paramParcel)
      {
        this.a = paramParcel.readString();
        this.b = paramParcel.readString();
        this.c = paramParcel.readString();
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String getAuth_success()
      {
        return this.c;
      }
      
      public String getID_card_in_auth()
      {
        return this.a;
      }
      
      public String getIn_auth()
      {
        return this.b;
      }
      
      public void setAuth_success(String paramString)
      {
        this.c = paramString;
      }
      
      public void setID_card_in_auth(String paramString)
      {
        this.a = paramString;
      }
      
      public void setIn_auth(String paramString)
      {
        this.b = paramString;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeString(this.a);
        paramParcel.writeString(this.b);
        paramParcel.writeString(this.c);
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
      public String a;
      public String b;
      public int c;
      public String d;
      public String e;
      public int f;
      public String g;
      public List<String> h;
      
      public CompanyBean() {}
      
      protected CompanyBean(Parcel paramParcel)
      {
        this.a = paramParcel.readString();
        this.b = paramParcel.readString();
        this.c = paramParcel.readInt();
        this.d = paramParcel.readString();
        this.e = paramParcel.readString();
        this.f = paramParcel.readInt();
        this.g = paramParcel.readString();
        this.h = new ArrayList();
        paramParcel.readStringList(this.h);
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String getCert_name()
      {
        return this.b;
      }
      
      public int getCert_type()
      {
        return this.c;
      }
      
      public int getCompany_type()
      {
        return this.f;
      }
      
      public List<String> getDefault_pic()
      {
        return this.h;
      }
      
      public String getRemarks()
      {
        return this.g;
      }
      
      public String getStandards()
      {
        return this.e;
      }
      
      public String getTips()
      {
        return this.d;
      }
      
      public String getType()
      {
        return this.a;
      }
      
      public void setCert_name(String paramString)
      {
        this.b = paramString;
      }
      
      public void setCert_type(int paramInt)
      {
        this.c = paramInt;
      }
      
      public void setCompany_type(int paramInt)
      {
        this.f = paramInt;
      }
      
      public void setDefault_pic(List<String> paramList)
      {
        this.h = paramList;
      }
      
      public void setRemarks(String paramString)
      {
        this.g = paramString;
      }
      
      public void setStandards(String paramString)
      {
        this.e = paramString;
      }
      
      public void setTips(String paramString)
      {
        this.d = paramString;
      }
      
      public void setType(String paramString)
      {
        this.a = paramString;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeString(this.a);
        paramParcel.writeString(this.b);
        paramParcel.writeInt(this.c);
        paramParcel.writeString(this.d);
        paramParcel.writeString(this.e);
        paramParcel.writeInt(this.f);
        paramParcel.writeString(this.g);
        paramParcel.writeStringList(this.h);
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
      public String a;
      public String b;
      public int c;
      public String d;
      public String e;
      public String f;
      public int g;
      public List<String> h;
      
      public PersonalBean() {}
      
      protected PersonalBean(Parcel paramParcel)
      {
        this.a = paramParcel.readString();
        this.b = paramParcel.readString();
        this.c = paramParcel.readInt();
        this.d = paramParcel.readString();
        this.e = paramParcel.readString();
        this.f = paramParcel.readString();
        this.g = paramParcel.readInt();
        this.h = new ArrayList();
        paramParcel.readStringList(this.h);
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String getCert_name()
      {
        return this.b;
      }
      
      public int getCert_type()
      {
        return this.c;
      }
      
      public List<String> getDefault_pic()
      {
        return this.h;
      }
      
      public int getPic_count()
      {
        return this.g;
      }
      
      public String getRemarks()
      {
        return this.f;
      }
      
      public String getStandards()
      {
        return this.e;
      }
      
      public String getTips()
      {
        return this.d;
      }
      
      public String getType()
      {
        return this.a;
      }
      
      public void setCert_name(String paramString)
      {
        this.b = paramString;
      }
      
      public void setCert_type(int paramInt)
      {
        this.c = paramInt;
      }
      
      public void setDefault_pic(List<String> paramList)
      {
        this.h = paramList;
      }
      
      public void setPic_count(int paramInt)
      {
        this.g = paramInt;
      }
      
      public void setRemarks(String paramString)
      {
        this.f = paramString;
      }
      
      public void setStandards(String paramString)
      {
        this.e = paramString;
      }
      
      public void setTips(String paramString)
      {
        this.d = paramString;
      }
      
      public void setType(String paramString)
      {
        this.a = paramString;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeString(this.a);
        paramParcel.writeString(this.b);
        paramParcel.writeInt(this.c);
        paramParcel.writeString(this.d);
        paramParcel.writeString(this.e);
        paramParcel.writeString(this.f);
        paramParcel.writeInt(this.g);
        paramParcel.writeStringList(this.h);
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
      public int a;
      public String b;
      public int c;
      
      public UserType() {}
      
      protected UserType(Parcel paramParcel)
      {
        this.a = paramParcel.readInt();
        this.b = paramParcel.readString();
        this.c = paramParcel.readInt();
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String getName()
      {
        return this.b;
      }
      
      public int getPic_count()
      {
        return this.c;
      }
      
      public int getSign_user_type()
      {
        return this.a;
      }
      
      public void setName(String paramString)
      {
        this.b = paramString;
      }
      
      public void setPic_count(int paramInt)
      {
        this.c = paramInt;
      }
      
      public void setSign_user_type(int paramInt)
      {
        this.a = paramInt;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.a);
        paramParcel.writeString(this.b);
        paramParcel.writeInt(this.c);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/CertInfoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */