package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.c.b;
import com.ziroom.ziroomcustomer.e.c.x;
import com.ziroom.ziroomcustomer.model.UserInfo;

public class u
{
  private static String a(Context paramContext, int paramInt, String paramString)
  {
    e locale = new e(paramContext);
    b localb = locale.getSession();
    try
    {
      localCursor = localb.rawQuery("SELECT * FROM t_ziroom WHERE type= ? and param= ?", new String[] { paramInt + "", paramString });
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
            paramString = localCursor.getString(localCursor.getColumnIndex("content"));
          }
        }
        catch (Exception paramString)
        {
          Cursor localCursor;
          continue;
        }
        try
        {
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
  
  private static void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("type", Integer.valueOf(paramInt));
      localContentValues.put("param", paramString1);
      localContentValues.put("content", paramString2);
      if (!a(localb, paramInt, paramString1)) {
        localb.insert("t_ziroom", null, localContentValues);
      }
      for (;;)
      {
        paramContext.releaseSession(localb);
        return;
        localb.update("t_ziroom", localContentValues, "type=? and param=?", new String[] { paramInt + "", paramString1 });
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  private static boolean a(b paramb, int paramInt, String paramString)
  {
    boolean bool = true;
    paramb = paramb.rawQuery("SELECT * FROM t_ziroom WHERE type=? and param=?", new String[] { paramInt + "", paramString });
    paramb.moveToFirst();
    if (!paramb.isAfterLast()) {}
    for (;;)
    {
      paramb.close();
      return bool;
      bool = false;
    }
  }
  
  public static void createTable(b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_ziroom(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("type \tinteger,");
    localStringBuffer.append("param \tvarchar,");
    localStringBuffer.append("content \tvarchar");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static UserInfo queryUserInfo(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, 1, paramString);
    if (!TextUtils.isEmpty(paramContext)) {
      return x.parse(a.parseObject(paramContext));
    }
    return null;
  }
  
  public static void saveUserInfo(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, 1, paramString1, paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/b/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */