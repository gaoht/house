package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.freelxl.baselibrary.c.b;
import com.ziroom.ziroomcustomer.model.MapDistrict;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class m
{
  public static void createTable(b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_map_district(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("city_id \t\tvarchar,");
    localStringBuffer.append("lng_lat \t\tvarchar,");
    localStringBuffer.append("district_name \tvarchar,");
    localStringBuffer.append("house_counts \tvarchar,");
    localStringBuffer.append("save_time TIMESTAMP default (datetime('now', 'localtime'))");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static void deleteAll(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_map_district", new String[0]);
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
  
  public static void deleteBefore(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_map_district WHERE save_time < datetime('now','start of day')", new String[0]);
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
  
  public static void deleteTable(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("drop table t_map_district");
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
  
  public static boolean exist(b paramb, String paramString1, String paramString2)
  {
    boolean bool = true;
    paramb = paramb.rawQuery("SELECT * FROM t_map_district WHERE city_id=? AND district_name=?", new String[] { paramString1, paramString2 });
    paramb.moveToFirst();
    if (!paramb.isAfterLast()) {
      paramb.moveToNext();
    }
    for (;;)
    {
      paramb.close();
      return bool;
      bool = false;
    }
  }
  
  public static List<MapDistrict> query(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    localArrayList = new ArrayList();
    try
    {
      Cursor localCursor = localb.rawQuery("SELECT * FROM t_map_district WHERE city_id = ?", new String[] { paramString });
      localCursor.moveToFirst();
      while (!localCursor.isAfterLast())
      {
        MapDistrict localMapDistrict = new MapDistrict();
        localMapDistrict.setCity_id(paramString);
        localMapDistrict.setLng_lat(localCursor.getString(localCursor.getColumnIndex("lng_lat")));
        localMapDistrict.setDistrict_name(localCursor.getString(localCursor.getColumnIndex("district_name")));
        localMapDistrict.setHouse_counts(localCursor.getString(localCursor.getColumnIndex("house_counts")));
        localArrayList.add(localMapDistrict);
        localCursor.moveToNext();
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramContext.releaseSession(localb);
    }
  }
  
  public static void save(Context paramContext, List<MapDistrict> paramList, String paramString)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    if (paramList != null) {
      try
      {
        if (paramList.size() > 0)
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            MapDistrict localMapDistrict = (MapDistrict)paramList.next();
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("city_id", paramString);
            localContentValues.put("lng_lat", localMapDistrict.getLng_lat());
            localContentValues.put("district_name", localMapDistrict.getDistrict_name());
            localContentValues.put("house_counts", localMapDistrict.getHouse_counts());
            if (!exist(localb, paramString, localMapDistrict.getDistrict_name())) {
              localb.insert("t_map_district", null, localContentValues);
            }
          }
        }
        paramContext.releaseSession(localb);
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */