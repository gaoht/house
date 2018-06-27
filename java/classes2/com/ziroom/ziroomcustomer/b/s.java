package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.freelxl.baselibrary.c.b;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.model.UserInfo;

public class s
{
  public static void createTable(b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_user(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("login_name \tvarchar,");
    localStringBuffer.append("password \tvarchar,");
    localStringBuffer.append("body \t\tvarchar,");
    localStringBuffer.append("login_type \tvarchar,");
    localStringBuffer.append("uid \t\tvarchar,");
    localStringBuffer.append("customer_flag integer,");
    localStringBuffer.append("user_status integer,");
    localStringBuffer.append("activation  integer,");
    localStringBuffer.append("secure_question varchar,");
    localStringBuffer.append("secure_answer varchar,");
    localStringBuffer.append("sys_cust_id integer,");
    localStringBuffer.append("customer_code integer,");
    localStringBuffer.append("user_name \tvarchar,");
    localStringBuffer.append("user_pinyin varchar,");
    localStringBuffer.append("mobile \t\tvarchar,");
    localStringBuffer.append("phone \t\tvarchar,");
    localStringBuffer.append("email \t\tvarchar,");
    localStringBuffer.append("birth \t\tvarchar,");
    localStringBuffer.append("gender \t\tinteger,");
    localStringBuffer.append("age \t\tinteger,");
    localStringBuffer.append("nation \t\tvarchar,");
    localStringBuffer.append("postal_code varchar,");
    localStringBuffer.append("nationality varchar,");
    localStringBuffer.append("location \tvarchar,");
    localStringBuffer.append("address_street varchar,");
    localStringBuffer.append("degree \t\tvarchar,");
    localStringBuffer.append("marriage \tinteger,");
    localStringBuffer.append("job \t\tvarchar,");
    localStringBuffer.append("position \tvarchar,");
    localStringBuffer.append("origin \t\tinteger,");
    localStringBuffer.append("company \tvarchar,");
    localStringBuffer.append("social_proof integer,");
    localStringBuffer.append("tos \t\tinteger,");
    localStringBuffer.append("nick_name \tvarchar,");
    localStringBuffer.append("head_img \tvarchar,");
    localStringBuffer.append("interest \tvarchar,");
    localStringBuffer.append("weibo \tvarchar,");
    localStringBuffer.append("comment \tvarchar,");
    localStringBuffer.append("professional \tvarchar,");
    localStringBuffer.append("token \tvarchar,");
    localStringBuffer.append("login_name_mobile \tvarchar,");
    localStringBuffer.append("login_name_email \tvarchar,");
    localStringBuffer.append("is_public \tvarchar,");
    localStringBuffer.append("is_customer_sign integer,");
    localStringBuffer.append("is_customer_reg integer,");
    localStringBuffer.append("is_customer_yz integer,");
    localStringBuffer.append("is_customer_zk integer");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static boolean exist(b paramb, String paramString)
  {
    boolean bool = true;
    paramb = paramb.rawQuery("SELECT * FROM t_user WHERE uid=?", new String[] { paramString });
    paramb.moveToFirst();
    if (!paramb.isAfterLast()) {}
    for (;;)
    {
      paramb.close();
      return bool;
      bool = false;
    }
  }
  
  public static UserInfo query(Context paramContext, String paramString)
  {
    e locale = new e(paramContext);
    b localb = locale.getSession();
    try
    {
      localCursor = localb.rawQuery("SELECT * FROM t_user WHERE uid= ?", new String[] { paramString });
      d.d("UserInfo", "======" + localCursor.getCount());
      localCursor.moveToFirst();
      paramContext = null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        try
        {
          if (!localCursor.isAfterLast()) {
            paramString = new UserInfo();
          }
        }
        catch (Exception paramString)
        {
          Cursor localCursor;
          continue;
        }
        try
        {
          paramString.setId(localCursor.getString(localCursor.getColumnIndex("id")));
          paramString.setLoginName(localCursor.getString(localCursor.getColumnIndex("login_name")));
          paramString.setUid(localCursor.getString(localCursor.getColumnIndex("uid")));
          paramString.setUser_name(localCursor.getString(localCursor.getColumnIndex("user_name")));
          paramString.setMobile(localCursor.getString(localCursor.getColumnIndex("mobile")));
          paramString.setPhone(localCursor.getString(localCursor.getColumnIndex("phone")));
          paramString.setEmail(localCursor.getString(localCursor.getColumnIndex("email")));
          paramString.setBirth(localCursor.getString(localCursor.getColumnIndex("birth")));
          paramString.setGender(localCursor.getInt(localCursor.getColumnIndex("gender")));
          paramString.setNation(localCursor.getString(localCursor.getColumnIndex("nation")));
          paramString.setNationality(localCursor.getString(localCursor.getColumnIndex("nationality")));
          paramString.setLocation(localCursor.getString(localCursor.getColumnIndex("location")));
          paramString.setMarriage(localCursor.getInt(localCursor.getColumnIndex("marriage")));
          paramString.setJob(localCursor.getString(localCursor.getColumnIndex("job")));
          paramString.setPosition(localCursor.getString(localCursor.getColumnIndex("position")));
          paramString.setOrigin(localCursor.getInt(localCursor.getColumnIndex("origin")));
          paramString.setCompany(localCursor.getString(localCursor.getColumnIndex("company")));
          paramString.setNick_name(localCursor.getString(localCursor.getColumnIndex("nick_name")));
          paramString.setHead_img(localCursor.getString(localCursor.getColumnIndex("head_img")));
          paramString.setProfessional(localCursor.getString(localCursor.getColumnIndex("professional")));
          paramString.setLogin_name_mobile(localCursor.getString(localCursor.getColumnIndex("login_name_mobile")));
          paramString.setLogin_name_email(localCursor.getString(localCursor.getColumnIndex("login_name_email")));
          localCursor.moveToNext();
          paramContext = paramString;
        }
        catch (Exception localException)
        {
          paramContext = paramString;
          paramString = localException;
        }
      }
      paramString = paramString;
      paramContext = null;
    }
    paramString = paramContext;
    paramString.printStackTrace();
    paramString = paramContext;
    locale.releaseSession(localb);
    return paramString;
  }
  
  public static void save(Context paramContext, UserInfo paramUserInfo)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("uid", paramUserInfo.getUid());
      localContentValues.put("login_name_mobile", paramUserInfo.getLogin_name_mobile());
      localContentValues.put("login_name_email", paramUserInfo.getLogin_name_email());
      localContentValues.put("user_name", paramUserInfo.getUser_name());
      localContentValues.put("mobile", paramUserInfo.getMobile());
      localContentValues.put("phone", paramUserInfo.getPhone());
      localContentValues.put("email", paramUserInfo.getEmail());
      localContentValues.put("birth", paramUserInfo.getBirth());
      localContentValues.put("gender", Integer.valueOf(paramUserInfo.getGender()));
      localContentValues.put("nation", paramUserInfo.getNation());
      localContentValues.put("nationality", paramUserInfo.getNationality());
      localContentValues.put("location", paramUserInfo.getLocation());
      localContentValues.put("marriage", Integer.valueOf(paramUserInfo.getMarriage()));
      localContentValues.put("job", paramUserInfo.getJob());
      localContentValues.put("position", paramUserInfo.getPosition());
      localContentValues.put("origin", Integer.valueOf(paramUserInfo.getOrigin()));
      localContentValues.put("company", paramUserInfo.getCompany());
      localContentValues.put("nick_name", paramUserInfo.getNick_name());
      localContentValues.put("head_img", paramUserInfo.getHead_img());
      localContentValues.put("professional", paramUserInfo.getProfessional());
      if (!exist(localb, paramUserInfo.getUid())) {
        localb.insert("t_user", null, localContentValues);
      }
      for (;;)
      {
        paramContext.releaseSession(localb);
        return;
        localb.update("t_user", localContentValues, "uid=?", new String[] { paramUserInfo.getUid() });
      }
    }
    catch (Exception paramUserInfo)
    {
      for (;;)
      {
        paramUserInfo.printStackTrace();
      }
    }
  }
  
  public static boolean signer(Context paramContext, String paramString)
  {
    boolean bool = true;
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    paramString = localb.rawQuery("SELECT is_customer_sign FROM t_user WHERE mobile=?", new String[] { paramString });
    paramString.moveToFirst();
    if (!paramString.isAfterLast()) {
      paramString.moveToNext();
    }
    for (;;)
    {
      paramContext.releaseSession(localb);
      paramString.close();
      return bool;
      bool = false;
    }
  }
  
  public void delete(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_user", new Object[0]);
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void deleteTable(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("drop table t_user");
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */