package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class v
{
  public static String a(Context paramContext)
  {
    return "/data/data/" + paramContext.getPackageName() + "/databases/.ua/";
  }
  
  public static String a(List<String> paramList)
  {
    return TextUtils.join("!", paramList);
  }
  
  public static List<String> a(String paramString)
  {
    return new ArrayList(Arrays.asList(paramString.split("!")));
  }
  
  public static boolean a(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    String str2 = null;
    String str1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramString == null) {}
    for (;;)
    {
      return bool2;
      try
      {
        paramString = paramSQLiteDatabase.rawQuery("select count(*) as c from sqlite_master where type ='table' and name ='" + paramString.trim() + "' ", null);
        boolean bool1 = bool3;
        str1 = paramString;
        str2 = paramString;
        if (paramString.moveToNext())
        {
          str1 = paramString;
          str2 = paramString;
          int i = paramString.getInt(0);
          bool1 = bool3;
          if (i > 0) {
            bool1 = true;
          }
        }
        bool2 = bool1;
        return bool1;
      }
      catch (Exception paramString)
      {
        return false;
      }
      finally
      {
        if (str2 != null) {
          str2.close();
        }
      }
    }
  }
  
  public static List<String> b(List<String> paramList)
  {
    localArrayList = new ArrayList();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (Collections.frequency(localArrayList, str) < 1) {
          localArrayList.add(str);
        }
      }
      return localArrayList;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */