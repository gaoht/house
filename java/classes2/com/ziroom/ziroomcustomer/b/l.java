package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.freelxl.baselibrary.c.b;
import com.ziroom.ziroomcustomer.model.MapBizcircle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class l
{
  public static void createTable(b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_map_bizcircle(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("city_id \t\tvarchar,");
    localStringBuffer.append("lng_lat \t\tvarchar,");
    localStringBuffer.append("district_name \tvarchar,");
    localStringBuffer.append("bizcircle_name \tvarchar,");
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
      localb.execSQL("DELETE FROM t_map_bizcircle", new String[0]);
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
      localb.execSQL("DELETE FROM t_map_bizcircleWHERE save_time < datetime('now','start of day')");
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
      localb.execSQL("drop table t_map_bizcircle");
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
  
  public static boolean exist(b paramb, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    paramb = paramb.rawQuery("SELECT * FROM t_map_bizcircle WHERE city_id=? AND district_name=? AND bizcircle_name=?", new String[] { paramString1, paramString2, paramString3 });
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
  
  public static List<MapBizcircle> query(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    localArrayList = new ArrayList();
    try
    {
      Cursor localCursor = localb.rawQuery("SELECT * FROM t_map_bizcircle WHERE city_id=?", new String[] { paramString });
      localCursor.moveToFirst();
      while (!localCursor.isAfterLast())
      {
        MapBizcircle localMapBizcircle = new MapBizcircle();
        localMapBizcircle.setCity_id(paramString);
        localMapBizcircle.setLng_lat(localCursor.getString(localCursor.getColumnIndex("lng_lat")));
        localMapBizcircle.setDistrict_name(localCursor.getString(localCursor.getColumnIndex("district_name")));
        localMapBizcircle.setBizcircle_name(localCursor.getString(localCursor.getColumnIndex("bizcircle_name")));
        localMapBizcircle.setHouse_counts(localCursor.getString(localCursor.getColumnIndex("house_counts")));
        localArrayList.add(localMapBizcircle);
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
  
  public static List<MapBizcircle> query(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    localArrayList = new ArrayList();
    try
    {
      paramString2 = localb.rawQuery("SELECT * FROM t_map_bizcircle WHERE city_id=? AND district_name=?", new String[] { paramString1, paramString2 });
      paramString2.moveToFirst();
      while (!paramString2.isAfterLast())
      {
        MapBizcircle localMapBizcircle = new MapBizcircle();
        localMapBizcircle.setCity_id(paramString1);
        localMapBizcircle.setLng_lat(paramString2.getString(paramString2.getColumnIndex("lng_lat")));
        localMapBizcircle.setDistrict_name(paramString2.getString(paramString2.getColumnIndex("district_name")));
        localMapBizcircle.setBizcircle_name(paramString2.getString(paramString2.getColumnIndex("bizcircle_name")));
        localMapBizcircle.setHouse_counts(paramString2.getString(paramString2.getColumnIndex("house_counts")));
        localArrayList.add(localMapBizcircle);
        paramString2.moveToNext();
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramContext.releaseSession(localb);
    }
  }
  
  public static void save(Context paramContext, List<MapBizcircle> paramList, String paramString1, String paramString2)
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
            MapBizcircle localMapBizcircle = (MapBizcircle)paramList.next();
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("city_id", paramString1);
            localContentValues.put("lng_lat", localMapBizcircle.getLng_lat());
            localContentValues.put("district_name", paramString2);
            localContentValues.put("bizcircle_name", localMapBizcircle.getBizcircle_name());
            localContentValues.put("house_counts", localMapBizcircle.getHouse_counts());
            if (!exist(localb, paramString1, paramString2, localMapBizcircle.getBizcircle_name())) {
              localb.insert("t_map_bizcircle", null, localContentValues);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */