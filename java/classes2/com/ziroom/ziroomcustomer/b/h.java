package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ziroom.ziroomcustomer.findhouse.model.HouselistSuggestBean;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.ArrayList;

public class h
{
  private static StringBuffer a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_houstlistResblock(");
    localStringBuffer.append("id varchar PRIMARY KEY,");
    localStringBuffer.append("name \t\tvarchar,");
    localStringBuffer.append("count \t\tinteger,");
    localStringBuffer.append("lastTime \tinteger,");
    localStringBuffer.append("cityCode \tvarchar");
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
  
  public static int getResblockCount(Context paramContext)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    Cursor localCursor = localb.rawQuery("SELECT * FROM t_houstlistResblock WHERE cityCode=?", new String[] { com.ziroom.ziroomcustomer.base.b.d });
    int i = localCursor.getCount();
    localCursor.close();
    paramContext.releaseSession(localb);
    return i;
  }
  
  public static boolean isExist(com.freelxl.baselibrary.c.b paramb, String paramString)
  {
    paramb = paramb.rawQuery("SELECT * FROM t_houstlistResblock WHERE name =? AND cityCode=?", new String[] { paramString, com.ziroom.ziroomcustomer.base.b.d });
    return (paramb != null) && (paramb.moveToNext());
  }
  
  public static ArrayList<HouselistSuggestBean> queryResblock(Context paramContext, int paramInt)
  {
    int i = 0;
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = localb.rawQuery("SELECT * FROM t_houstlistResblock WHERE cityCode=? ORDER BY count DESC", new String[] { com.ziroom.ziroomcustomer.base.b.d });
    if (localCursor != null) {
      while ((localCursor.moveToNext()) && (i < paramInt))
      {
        i += 1;
        String str1 = localCursor.getString(localCursor.getColumnIndex("id"));
        String str2 = localCursor.getString(localCursor.getColumnIndex("name"));
        int j = localCursor.getInt(localCursor.getColumnIndex("count"));
        HouselistSuggestBean localHouselistSuggestBean = new HouselistSuggestBean();
        localHouselistSuggestBean.setId(str1);
        localHouselistSuggestBean.setName(str2);
        localHouselistSuggestBean.setCount(j);
        localHouselistSuggestBean.setType(2);
        localArrayList.add(localHouselistSuggestBean);
      }
    }
    localCursor.close();
    paramContext.releaseSession(localb);
    return localArrayList;
  }
  
  public static void sava(Context paramContext, String paramString1, String paramString2)
  {
    if ((ae.isNull(paramString1)) || (ae.isNull(paramString2))) {
      return;
    }
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    if (isExist(localb, paramString2))
    {
      paramString1 = new StringBuilder();
      paramString1.append("update ").append("t_houstlistResblock").append(" set count = count+1,lastTime=").append(System.currentTimeMillis()).append(" where name = '").append(paramString2).append("' and cityCode = '").append(com.ziroom.ziroomcustomer.base.b.d).append("'");
      localb.execSQL(paramString1.toString());
    }
    for (;;)
    {
      paramContext.releaseSession(localb);
      return;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("id", paramString1);
      localContentValues.put("name", paramString2);
      localContentValues.put("count", Integer.valueOf(1));
      localContentValues.put("lastTime", Long.valueOf(System.currentTimeMillis()));
      localContentValues.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
      localb.insert("t_houstlistResblock", null, localContentValues);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */