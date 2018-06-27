package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.ziroom.ziroomcustomer.util.u;

public class q
{
  public static void createTable(com.freelxl.baselibrary.c.b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_search_house_new(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("s_name varchar,");
    localStringBuffer.append("s_value varchar,");
    localStringBuffer.append("s_type integer,");
    localStringBuffer.append("flag integer,");
    localStringBuffer.append("icon varchar,");
    localStringBuffer.append("memo varchar,");
    localStringBuffer.append("house_num varchar,");
    localStringBuffer.append("city_code varchar,");
    localStringBuffer.append("timestamp varchar");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static void delete(Context paramContext)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_search_house_new", new Object[0]);
      if (paramContext != null) {
        paramContext.releaseSession(localb);
      }
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
  
  public static void delete(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    localb.delete("t_search_house_new", "city_code=?", new String[] { paramString });
    paramContext.releaseSession(localb);
  }
  
  public static com.alibaba.fastjson.b queryLatest(Context paramContext, int paramInt, String paramString)
  {
    if (paramInt <= 0) {
      return null;
    }
    e locale = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = locale.getSession();
    com.alibaba.fastjson.b localb1 = new com.alibaba.fastjson.b();
    try
    {
      paramContext = localb.rawQuery("SELECT * FROM t_search_house_new where city_code = ? order by timestamp desc limit 0," + paramInt, new String[] { paramString });
      paramString = paramContext;
      if (paramContext == null) {
        break label279;
      }
      for (;;)
      {
        paramString = paramContext;
        try
        {
          if (!paramContext.moveToNext()) {
            break label279;
          }
          paramString = new com.alibaba.fastjson.e();
          paramString.put("name", paramContext.getString(paramContext.getColumnIndex("s_name")));
          paramString.put("value", paramContext.getString(paramContext.getColumnIndex("s_value")));
          paramString.put("type", Integer.valueOf(paramContext.getInt(paramContext.getColumnIndex("s_type"))));
          paramString.put("flag", Integer.valueOf(paramContext.getInt(paramContext.getColumnIndex("flag"))));
          paramString.put("icon", paramContext.getString(paramContext.getColumnIndex("icon")));
          paramString.put("memo", paramContext.getString(paramContext.getColumnIndex("memo")));
          paramString.put("housenum", paramContext.getString(paramContext.getColumnIndex("house_num")));
          paramString.put("citycode", paramContext.getString(paramContext.getColumnIndex("city_code")));
          localb1.add(paramString);
        }
        catch (Exception paramString) {}
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label279:
        paramContext = null;
      }
    }
    paramString.printStackTrace();
    paramString = paramContext;
    if (locale != null) {
      locale.releaseSession(localb);
    }
    if (paramString != null) {
      paramString.close();
    }
    return localb1;
  }
  
  public static void save(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("s_name", paramString1);
      localContentValues.put("s_value", paramString2);
      localContentValues.put("s_type", Integer.valueOf(paramInt1));
      localContentValues.put("flag", Integer.valueOf(paramInt2));
      localContentValues.put("icon", paramString3);
      localContentValues.put("memo", paramString4);
      localContentValues.put("house_num", paramString5);
      localContentValues.put("city_code", paramString6);
      localContentValues.put("timestamp", System.currentTimeMillis() + "");
      localb.delete("t_search_house_new", "s_name=? and city_code=?", new String[] { paramString1, paramString6 });
      long l = localb.insert("t_search_house_new", null, localContentValues);
      u.d("db", "=====save:" + l);
      if (paramContext != null) {
        paramContext.releaseSession(localb);
      }
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void deleteTable(Context paramContext)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      localb.execSQL("drop table t_search_house_new");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */