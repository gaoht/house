package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.alibaba.fastjson.a;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.List;

public class f
{
  private static StringBuffer a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_houseSearchHistory(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("cityCode varchar,");
    localStringBuffer.append("encode varchar,");
    localStringBuffer.append("searchCondition varchar,");
    localStringBuffer.append("timeStamp varchar");
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
  
  public static void delete(Context paramContext)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    localb.delete("t_houseSearchHistory", "cityCode = ?", new String[] { com.ziroom.ziroomcustomer.base.b.d });
    paramContext.releaseSession(localb);
  }
  
  public static List<SearchCondition> querySearchCondition(Context paramContext, int paramInt)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = localb.rawQuery("SELECT * FROM t_houseSearchHistory WHERE cityCode=? GROUP BY encode ORDER BY id DESC LIMIT " + paramInt, new String[] { com.ziroom.ziroomcustomer.base.b.d });
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        String str = localCursor.getString(localCursor.getColumnIndex("searchCondition"));
        localCursor.getString(localCursor.getColumnIndex("timeStamp"));
        localArrayList.add((SearchCondition)a.parseObject(str, SearchCondition.class));
      }
      localCursor.close();
    }
    paramContext.releaseSession(localb);
    return localArrayList;
  }
  
  public static void save(Context paramContext, SearchCondition paramSearchCondition)
  {
    if (paramSearchCondition == null) {
      return;
    }
    paramContext = new e(paramContext).getSession();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("searchCondition", a.toJSONString(paramSearchCondition));
    localContentValues.put("encode", ah.MD5Encode(a.toJSONString(paramSearchCondition)));
    localContentValues.put("timeStamp", System.currentTimeMillis() + "");
    localContentValues.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    paramContext.insert("t_houseSearchHistory", null, localContentValues);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */