package com.hyphenate.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.hyphenate.util.CryptoUtils;

class EMSessionManager
{
  private static final String PREF_KEY_LOGIN_PWD = "easemob.chat.loginpwd";
  private static final String PREF_KEY_LOGIN_TOKEN = "easemob.chat.login.token";
  private static final String PREF_KEY_LOGIN_USER = "easemob.chat.loginuser";
  private static final String PREF_KEY_LOGIN_WITH_TOKEN = "easemob.chat.login_with_token";
  private static final String TAG = "Session";
  private static EMSessionManager instance = new EMSessionManager();
  private Context appContext = null;
  public EMContact currentUser = null;
  private String lastLoginPwd = null;
  private String lastLoginToken = null;
  private String lastLoginUser = null;
  
  static EMSessionManager getInstance()
  {
    try
    {
      if (instance.appContext == null) {
        instance.appContext = EMClient.getInstance().getContext();
      }
      EMSessionManager localEMSessionManager = instance;
      return localEMSessionManager;
    }
    finally {}
  }
  
  void clearLastLoginPwd()
  {
    try
    {
      this.lastLoginPwd = "";
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.appContext).edit();
      localEditor.putString("easemob.chat.loginpwd", this.lastLoginPwd);
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  void clearLastLoginToken()
  {
    try
    {
      this.lastLoginToken = "";
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.appContext).edit();
      localEditor.putString("easemob.chat.login.token", this.lastLoginToken);
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  void clearLastLoginUser()
  {
    try
    {
      this.lastLoginUser = "";
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.appContext).edit();
      localEditor.putString("easemob.chat.loginuser", this.lastLoginUser);
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  String getLastLoginPwd()
  {
    String str;
    if (this.lastLoginPwd == null)
    {
      str = PreferenceManager.getDefaultSharedPreferences(this.appContext).getString("easemob.chat.loginpwd", "");
      if (str.equals(""))
      {
        this.lastLoginPwd = "";
        return this.lastLoginPwd;
      }
    }
    try
    {
      this.lastLoginPwd = EMClient.getInstance().getCryptoUtils().decryptBase64String(str);
      return this.lastLoginPwd;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  String getLastLoginToken()
  {
    String str;
    if (this.lastLoginToken == null)
    {
      str = PreferenceManager.getDefaultSharedPreferences(this.appContext).getString("easemob.chat.login.token", "");
      if (str.equals(""))
      {
        this.lastLoginToken = "";
        return this.lastLoginToken;
      }
    }
    try
    {
      this.lastLoginToken = EMClient.getInstance().getCryptoUtils().decryptBase64String(str);
      return this.lastLoginToken;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  String getLastLoginUser()
  {
    if (this.lastLoginUser == null)
    {
      this.lastLoginUser = PreferenceManager.getDefaultSharedPreferences(this.appContext).getString("easemob.chat.loginuser", "");
      this.currentUser = new EMContact(this.lastLoginUser);
    }
    return this.lastLoginUser;
  }
  
  public String getLoginUserName()
  {
    return this.currentUser.username;
  }
  
  boolean isLastLoginWithToken()
  {
    return PreferenceManager.getDefaultSharedPreferences(this.appContext).getBoolean("easemob.chat.login_with_token", false);
  }
  
  void setLastLoginPwd(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.lastLoginPwd = paramString;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.appContext).edit();
    try
    {
      localEditor.putString("easemob.chat.loginpwd", EMClient.getInstance().getCryptoUtils().encryptBase64String(paramString));
      localEditor.commit();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  void setLastLoginToken(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.lastLoginToken = paramString;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.appContext).edit();
    try
    {
      localEditor.putString("easemob.chat.login.token", EMClient.getInstance().getCryptoUtils().encryptBase64String(paramString));
      localEditor.commit();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  void setLastLoginUser(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.currentUser = new EMContact(paramString);
    this.lastLoginUser = paramString;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.appContext).edit();
    localEditor.putString("easemob.chat.loginuser", paramString);
    localEditor.commit();
  }
  
  void setLastLoginWithToken(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.appContext).edit();
    localEditor.putBoolean("easemob.chat.login_with_token", paramBoolean);
    localEditor.commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMSessionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */