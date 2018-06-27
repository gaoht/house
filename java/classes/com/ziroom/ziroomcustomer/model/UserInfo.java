package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class UserInfo
  implements Serializable
{
  private String birth;
  private String company;
  private long createTime;
  private String email;
  private int emailChecked;
  private int gender;
  private String headImg;
  private String id;
  private List<String> interest;
  private String job;
  private long lastOnlineTime;
  private String location;
  private int marriage;
  private String nation;
  private String nationality;
  private String nickName;
  private int origin;
  private String phone;
  private int phoneChecked;
  private String position;
  private String professional;
  private String realName;
  private int status;
  private String uid;
  private String username;
  
  public String getBirth()
  {
    return this.birth;
  }
  
  public String getCompany()
  {
    return this.company;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public int getEmailChecked()
  {
    return this.emailChecked;
  }
  
  public int getGender()
  {
    return this.gender;
  }
  
  public String getHeadImg()
  {
    return this.headImg;
  }
  
  @Deprecated
  public String getHead_img()
  {
    return this.headImg;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public List<String> getInterest()
  {
    return this.interest;
  }
  
  public String getJob()
  {
    return this.job;
  }
  
  public long getLastOnlineTime()
  {
    return this.lastOnlineTime;
  }
  
  public String getLocation()
  {
    return this.location;
  }
  
  @Deprecated
  public String getLoginName()
  {
    return this.phone;
  }
  
  @Deprecated
  public String getLogin_name_email()
  {
    return this.email;
  }
  
  @Deprecated
  public String getLogin_name_mobile()
  {
    return this.phone;
  }
  
  public int getMarriage()
  {
    return this.marriage;
  }
  
  @Deprecated
  public String getMobile()
  {
    return this.phone;
  }
  
  public String getNation()
  {
    return this.nation;
  }
  
  public String getNationality()
  {
    return this.nationality;
  }
  
  public String getNickName()
  {
    return this.nickName;
  }
  
  @Deprecated
  public String getNick_name()
  {
    return this.nickName;
  }
  
  public int getOrigin()
  {
    return this.origin;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public int getPhoneChecked()
  {
    return this.phoneChecked;
  }
  
  public String getPosition()
  {
    return this.position;
  }
  
  public String getProfessional()
  {
    return this.professional;
  }
  
  public String getRealName()
  {
    return this.realName;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  @Deprecated
  public String getUser_name()
  {
    return this.realName;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setBirth(String paramString)
  {
    this.birth = paramString;
  }
  
  public void setCompany(String paramString)
  {
    this.company = paramString;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setEmailChecked(int paramInt)
  {
    this.emailChecked = paramInt;
  }
  
  public void setGender(int paramInt)
  {
    this.gender = paramInt;
  }
  
  public void setHeadImg(String paramString)
  {
    this.headImg = paramString;
  }
  
  @Deprecated
  public void setHead_img(String paramString)
  {
    this.headImg = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setInterest(List<String> paramList)
  {
    this.interest = paramList;
  }
  
  public void setJob(String paramString)
  {
    this.job = paramString;
  }
  
  public void setLastOnlineTime(long paramLong)
  {
    this.lastOnlineTime = paramLong;
  }
  
  public void setLocation(String paramString)
  {
    this.location = paramString;
  }
  
  @Deprecated
  public void setLoginName(String paramString)
  {
    this.phone = paramString;
  }
  
  @Deprecated
  public void setLogin_name_email(String paramString)
  {
    this.email = paramString;
  }
  
  @Deprecated
  public void setLogin_name_mobile(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setMarriage(int paramInt)
  {
    this.marriage = paramInt;
  }
  
  @Deprecated
  public void setMobile(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setNation(String paramString)
  {
    this.nation = paramString;
  }
  
  public void setNationality(String paramString)
  {
    this.nationality = paramString;
  }
  
  public void setNickName(String paramString)
  {
    this.nickName = paramString;
  }
  
  @Deprecated
  public void setNick_name(String paramString)
  {
    this.nickName = paramString;
  }
  
  public void setOrigin(int paramInt)
  {
    this.origin = paramInt;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setPhoneChecked(int paramInt)
  {
    this.phoneChecked = paramInt;
  }
  
  public void setPosition(String paramString)
  {
    this.position = paramString;
  }
  
  public void setProfessional(String paramString)
  {
    this.professional = paramString;
  }
  
  public void setRealName(String paramString)
  {
    this.realName = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  @Deprecated
  public void setUser_name(String paramString)
  {
    this.realName = paramString;
  }
  
  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/model/UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */