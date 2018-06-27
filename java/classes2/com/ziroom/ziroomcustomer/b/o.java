package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.mapapi.model.LatLng;
import com.ziroom.ziroomcustomer.findhouse.model.MapPlanNode;
import com.ziroom.ziroomcustomer.findhouse.model.MapPlanNode.MapRoute;
import java.util.ArrayList;

public class o
{
  private static StringBuffer a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_resblockRouteHistory(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("cityCode varchar,");
    localStringBuffer.append("startName varchar,");
    localStringBuffer.append("endName varchar,");
    localStringBuffer.append("startLat varchar,");
    localStringBuffer.append("startLng varchar,");
    localStringBuffer.append("endLat varchar,");
    localStringBuffer.append("endLng varchar,");
    localStringBuffer.append("name varchar");
    localStringBuffer.append(")");
    return localStringBuffer;
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(a().toString());
  }
  
  public static void createTable(com.freelxl.baselibrary.c.b paramb)
  {
    paramb.execSQL(a().toString());
  }
  
  public static ArrayList<MapPlanNode.MapRoute> queryResblock(Context paramContext, int paramInt)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = localb.rawQuery("SELECT * FROM t_resblockRouteHistory WHERE cityCode=? GROUP BY name ORDER BY id DESC LIMIT " + paramInt, new String[] { com.ziroom.ziroomcustomer.base.b.d });
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        Object localObject2 = localCursor.getString(localCursor.getColumnIndex("startName"));
        String str3 = localCursor.getString(localCursor.getColumnIndex("startLat"));
        String str4 = localCursor.getString(localCursor.getColumnIndex("startLng"));
        Object localObject1 = localCursor.getString(localCursor.getColumnIndex("endName"));
        String str1 = localCursor.getString(localCursor.getColumnIndex("endLat"));
        String str2 = localCursor.getString(localCursor.getColumnIndex("endLng"));
        MapPlanNode localMapPlanNode = new MapPlanNode();
        localMapPlanNode.setName((String)localObject2);
        localMapPlanNode.setLatlng(new LatLng(Double.parseDouble(str3), Double.parseDouble(str4)));
        localObject2 = new MapPlanNode();
        ((MapPlanNode)localObject2).setName((String)localObject1);
        ((MapPlanNode)localObject2).setLatlng(new LatLng(Double.parseDouble(str1), Double.parseDouble(str2)));
        localObject1 = new MapPlanNode.MapRoute();
        ((MapPlanNode.MapRoute)localObject1).setStartNode(localMapPlanNode);
        ((MapPlanNode.MapRoute)localObject1).setEndNode((MapPlanNode)localObject2);
        localArrayList.add(localObject1);
      }
      localCursor.close();
    }
    paramContext.releaseSession(localb);
    return localArrayList;
  }
  
  public static void sava(Context paramContext, MapPlanNode paramMapPlanNode1, MapPlanNode paramMapPlanNode2)
  {
    if ((paramMapPlanNode1 == null) || (paramMapPlanNode1.getLatlng() == null) || (paramMapPlanNode2 == null) || (paramMapPlanNode2.getLatlng() == null)) {
      return;
    }
    paramContext = new e(paramContext).getSession();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("startName", paramMapPlanNode1.getName());
    localContentValues.put("startLat", paramMapPlanNode1.getLatlng().latitude + "");
    localContentValues.put("startLng", paramMapPlanNode1.getLatlng().longitude + "");
    localContentValues.put("endName", paramMapPlanNode2.getName());
    localContentValues.put("endLat", paramMapPlanNode2.getLatlng().latitude + "");
    localContentValues.put("endLng", paramMapPlanNode2.getLatlng().longitude + "");
    localContentValues.put("name", paramMapPlanNode1.getName() + " - " + paramMapPlanNode2.getName());
    localContentValues.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramContext.insert("t_resblockRouteHistory", null, localContentValues);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */