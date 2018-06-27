package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.AlternateListing;
import com.ziroom.ziroomcustomer.model.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  public static void bindData(Context paramContext, String paramString)
  {
    Object localObject = queryAll(paramContext, "");
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    for (;;)
    {
      AlternateListing localAlternateListing;
      try
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          localAlternateListing = (AlternateListing)((Iterator)localObject).next();
          if (isExist(localb, paramString, localAlternateListing.getHouse_id(), localAlternateListing.getId(), localAlternateListing.getHouse_type())) {
            break label149;
          }
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("uid", paramString);
          localb.update("t_alternate_listing", localContentValues, "uid=? AND house_id=? AND house_code=? AND house_type=?", new String[] { "", localAlternateListing.getHouse_id(), localAlternateListing.getId(), String.valueOf(localAlternateListing.getHouse_type()) });
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramContext.releaseSession(localb);
        return;
      }
      label149:
      tmp158_155[0] = "";
      String[] tmp163_158 = tmp158_155;
      tmp163_158[1] = localAlternateListing.getHouse_id();
      String[] tmp171_163 = tmp163_158;
      tmp171_163[2] = localAlternateListing.getId();
      String[] tmp179_171 = tmp171_163;
      tmp179_171[3] = String.valueOf(localAlternateListing.getHouse_type());
      localb.delete("t_alternate_listing", "uid=? AND house_id=? AND house_code=? AND house_type=?", tmp179_171);
    }
  }
  
  public static void createTable(com.freelxl.baselibrary.c.b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_alternate_listing(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("uid\t    varchar,");
    localStringBuffer.append("house_code\t    varchar,");
    localStringBuffer.append("house_id\t    varchar,");
    localStringBuffer.append("house_photos    varchar,");
    localStringBuffer.append("house_type      varchar,");
    localStringBuffer.append("house_price     varchar,");
    localStringBuffer.append("house_name      varchar,");
    localStringBuffer.append("block_id      varchar,");
    localStringBuffer.append("is_duanzu Integer,");
    localStringBuffer.append("to_see_state    varchar,");
    localStringBuffer.append("city_id    varchar,");
    localStringBuffer.append("room_status    varchar,");
    localStringBuffer.append("add_date    varchar");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static void createTableBySql(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_alternate_listing(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("uid\t    varchar,");
    localStringBuffer.append("house_code\t    varchar,");
    localStringBuffer.append("house_id\t    varchar,");
    localStringBuffer.append("house_photos    varchar,");
    localStringBuffer.append("house_type      varchar,");
    localStringBuffer.append("house_price     varchar,");
    localStringBuffer.append("house_name      varchar,");
    localStringBuffer.append("block_id      varchar,");
    localStringBuffer.append("is_duanzu Integer,");
    localStringBuffer.append("to_see_state    varchar,");
    localStringBuffer.append("city_id    varchar,");
    localStringBuffer.append("room_status    varchar,");
    localStringBuffer.append("add_date    varchar");
    localStringBuffer.append(")");
    paramSQLiteDatabase.execSQL(localStringBuffer.toString());
  }
  
  public static void delete(Context paramContext)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_alternate_listing", new Object[0]);
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
  
  public static void delete(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    paramContext = new e(paramContext);
    paramSQLiteDatabase = paramContext.getSession();
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM t_alternate_listing", new Object[0]);
      if (paramContext != null) {
        paramContext.releaseSession(paramSQLiteDatabase);
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
  
  public static void delete(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    localb.delete("t_alternate_listing", "uid=? AND house_id=? AND house_code=? AND house_type=?", new String[] { paramString1, paramString2, paramString3, String.valueOf(paramInt) });
    paramContext.releaseSession(localb);
  }
  
  public static void delete(Context paramContext, List<AlternateListing> paramList)
  {
    e locale = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = locale.getSession();
    String str = ApplicationEx.c.getUserId((BaseActivity)paramContext);
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      AlternateListing localAlternateListing = (AlternateListing)paramList.next();
      if (str == null) {}
      for (paramContext = str;; paramContext = localAlternateListing.getUid())
      {
        localb.delete("t_alternate_listing", "uid=? AND house_id=? AND house_code=? AND house_type=?", new String[] { paramContext, localAlternateListing.getHouse_id(), localAlternateListing.getId(), String.valueOf(localAlternateListing.getHouse_type()) });
        break;
      }
    }
    locale.releaseSession(localb);
  }
  
  /* Error */
  public static long getCount2(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 21	com/ziroom/ziroomcustomer/b/e
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 24	com/ziroom/ziroomcustomer/b/e:<init>	(Landroid/content/Context;)V
    //   8: astore 6
    //   10: aload 6
    //   12: invokevirtual 28	com/ziroom/ziroomcustomer/b/e:getSession	()Lcom/freelxl/baselibrary/c/b;
    //   15: astore 7
    //   17: aconst_null
    //   18: astore_0
    //   19: aconst_null
    //   20: astore 5
    //   22: aload 7
    //   24: ldc -78
    //   26: iconst_1
    //   27: anewarray 76	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: aastore
    //   34: invokevirtual 182	com/freelxl/baselibrary/c/b:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull +21 -> 60
    //   42: aload_1
    //   43: invokeinterface 187 1 0
    //   48: istore_2
    //   49: iload_2
    //   50: i2l
    //   51: lstore_3
    //   52: aload_1
    //   53: invokeinterface 190 1 0
    //   58: lload_3
    //   59: lreturn
    //   60: aload_1
    //   61: invokeinterface 190 1 0
    //   66: aload 6
    //   68: aload 7
    //   70: invokevirtual 93	com/ziroom/ziroomcustomer/b/e:releaseSession	(Lcom/freelxl/baselibrary/c/b;)V
    //   73: lconst_0
    //   74: lreturn
    //   75: astore_0
    //   76: aload 5
    //   78: astore_1
    //   79: aload_0
    //   80: astore 5
    //   82: aload_1
    //   83: astore_0
    //   84: aload 5
    //   86: invokevirtual 89	java/lang/Exception:printStackTrace	()V
    //   89: aload_1
    //   90: invokeinterface 190 1 0
    //   95: goto -29 -> 66
    //   98: astore 5
    //   100: aload_0
    //   101: astore_1
    //   102: aload 5
    //   104: astore_0
    //   105: aload_1
    //   106: invokeinterface 190 1 0
    //   111: aload_0
    //   112: athrow
    //   113: astore_0
    //   114: goto -9 -> 105
    //   117: astore 5
    //   119: goto -37 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramContext	Context
    //   0	122	1	paramString	String
    //   48	2	2	i	int
    //   51	8	3	l	long
    //   20	65	5	localContext	Context
    //   98	5	5	localObject	Object
    //   117	1	5	localException	Exception
    //   8	59	6	locale	e
    //   15	54	7	localb	com.freelxl.baselibrary.c.b
    // Exception table:
    //   from	to	target	type
    //   22	38	75	java/lang/Exception
    //   22	38	98	finally
    //   84	89	98	finally
    //   42	49	113	finally
    //   42	49	117	java/lang/Exception
  }
  
  public static boolean isExist(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    paramString1 = localb.rawQuery("SELECT * FROM t_alternate_listing WHERE uid=? AND house_id=? AND house_code=? AND house_type=?", new String[] { paramString1, paramString2, paramString3, String.valueOf(paramInt) });
    paramString1.moveToFirst();
    if (!paramString1.isAfterLast()) {
      paramString1.moveToNext();
    }
    for (;;)
    {
      paramString1.close();
      paramContext.releaseSession(localb);
      return bool;
      bool = false;
    }
  }
  
  public static boolean isExist(com.freelxl.baselibrary.c.b paramb, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = true;
    paramb = paramb.rawQuery("SELECT * FROM t_alternate_listing WHERE uid=? AND house_id=? AND house_code=? AND house_type=?", new String[] { paramString1, paramString2, paramString3, String.valueOf(paramInt) });
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
  
  public static List<AlternateListing> queryAll(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    paramContext = new e(paramContext);
    paramSQLiteDatabase = paramContext.getSession();
    ArrayList localArrayList = new ArrayList();
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM t_alternate_listing", new String[0]);
      localCursor.moveToFirst();
      for (;;)
      {
        if (!localCursor.isAfterLast())
        {
          AlternateListing localAlternateListing = new AlternateListing();
          localAlternateListing.setUid(localCursor.getString(localCursor.getColumnIndex("uid")));
          localAlternateListing.setRoom_name(localCursor.getString(localCursor.getColumnIndex("house_name")));
          localAlternateListing.setHouse_photos(localCursor.getString(localCursor.getColumnIndex("house_photos")));
          localAlternateListing.setSell_price(localCursor.getString(localCursor.getColumnIndex("house_price")));
          localAlternateListing.setShortDayRental(localCursor.getString(localCursor.getColumnIndex("house_price")));
          localAlternateListing.setId(localCursor.getString(localCursor.getColumnIndex("house_code")));
          localAlternateListing.setHouse_id(localCursor.getString(localCursor.getColumnIndex("house_id")));
          localAlternateListing.setHouse_type(localCursor.getInt(localCursor.getColumnIndex("house_type")));
          localAlternateListing.setTo_see_state(localCursor.getString(localCursor.getColumnIndex("to_see_state")));
          localAlternateListing.setDuanzuFlag(localCursor.getInt(localCursor.getColumnIndex("is_duanzu")));
          localAlternateListing.setResblock_id(localCursor.getString(localCursor.getColumnIndex("block_id")));
          localAlternateListing.setAdd_time(localCursor.getString(localCursor.getColumnIndex("add_date")));
          localAlternateListing.setRoom_status(localCursor.getString(localCursor.getColumnIndex("room_status")));
          localArrayList.add(localAlternateListing);
          localCursor.moveToNext();
          continue;
          if (paramContext == null) {
            break;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      paramContext.releaseSession(paramSQLiteDatabase);
      return localArrayList;
      localException.close();
    }
  }
  
  public static List<AlternateListing> queryAll(Context paramContext, String paramString)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = localb.rawQuery("SELECT * FROM t_alternate_listing WHERE uid=? AND city_id = ?", new String[] { paramString, com.ziroom.ziroomcustomer.base.b.d });
      paramString.moveToFirst();
      while (!paramString.isAfterLast())
      {
        AlternateListing localAlternateListing = new AlternateListing();
        localAlternateListing.setUid(paramString.getString(paramString.getColumnIndex("uid")));
        localAlternateListing.setRoom_name(paramString.getString(paramString.getColumnIndex("house_name")));
        localAlternateListing.setHouse_photos(paramString.getString(paramString.getColumnIndex("house_photos")));
        localAlternateListing.setSell_price(paramString.getString(paramString.getColumnIndex("house_price")));
        localAlternateListing.setShortDayRental(paramString.getString(paramString.getColumnIndex("house_price")));
        localAlternateListing.setId(paramString.getString(paramString.getColumnIndex("house_code")));
        localAlternateListing.setHouse_id(paramString.getString(paramString.getColumnIndex("house_id")));
        localAlternateListing.setHouse_type(paramString.getInt(paramString.getColumnIndex("house_type")));
        localAlternateListing.setTo_see_state(paramString.getString(paramString.getColumnIndex("to_see_state")));
        localAlternateListing.setDuanzuFlag(paramString.getInt(paramString.getColumnIndex("is_duanzu")));
        localAlternateListing.setResblock_id(paramString.getString(paramString.getColumnIndex("block_id")));
        localAlternateListing.setAdd_time(paramString.getString(paramString.getColumnIndex("add_date")));
        localAlternateListing.setRoom_status(paramString.getString(paramString.getColumnIndex("room_status")));
        localArrayList.add(localAlternateListing);
        paramString.moveToNext();
        continue;
        paramContext.releaseSession(localb);
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    for (;;)
    {
      return localArrayList;
      paramString.close();
    }
  }
  
  public static void save(Context paramContext, AlternateListing paramAlternateListing)
  {
    if (paramContext == null) {
      return;
    }
    paramAlternateListing.setCityCode(com.ziroom.ziroomcustomer.base.b.d);
    if (ApplicationEx.c.getUser() == null) {}
    for (String str = ""; isExist(paramContext, str, paramAlternateListing.getHouse_id(), paramAlternateListing.getId(), paramAlternateListing.getHouse_type()); str = ApplicationEx.c.getUser().getUid())
    {
      g.textToast(paramContext, "房子已经在备选清单!");
      return;
    }
    save(paramContext, paramAlternateListing, null);
  }
  
  public static void save(Context paramContext, AlternateListing paramAlternateListing, SQLiteDatabase paramSQLiteDatabase)
  {
    paramContext = new e(paramContext);
    paramSQLiteDatabase = paramContext.getSession();
    for (;;)
    {
      try
      {
        if (!isExist(paramSQLiteDatabase, paramAlternateListing.getUid(), paramAlternateListing.getHouse_id(), paramAlternateListing.getId(), paramAlternateListing.getHouse_type()))
        {
          localContentValues = new ContentValues();
          localContentValues.put("uid", paramAlternateListing.getUid());
          localContentValues.put("house_code", paramAlternateListing.getId());
          localContentValues.put("house_id", paramAlternateListing.getHouse_id());
          localContentValues.put("house_photos", paramAlternateListing.getHouse_photos());
          if (paramAlternateListing.getDuanzuFlag() != 0) {
            continue;
          }
          localContentValues.put("house_price", paramAlternateListing.getSell_price());
          localContentValues.put("house_name", paramAlternateListing.getRoom_name());
          localContentValues.put("house_type", Integer.valueOf(paramAlternateListing.getHouse_type()));
          localContentValues.put("to_see_state", paramAlternateListing.getTo_see_state());
          localContentValues.put("is_duanzu", Integer.valueOf(paramAlternateListing.getDuanzuFlag()));
          localContentValues.put("city_id", paramAlternateListing.getCityCode());
          localContentValues.put("block_id", paramAlternateListing.getResblock_id());
          localContentValues.put("add_date", paramAlternateListing.getAdd_time());
          localContentValues.put("room_status", paramAlternateListing.getRoom_status());
          paramSQLiteDatabase.insert("t_alternate_listing", null, localContentValues);
        }
      }
      catch (Exception paramAlternateListing)
      {
        ContentValues localContentValues;
        paramAlternateListing.printStackTrace();
        continue;
      }
      if (paramContext != null) {
        paramContext.releaseSession(paramSQLiteDatabase);
      }
      return;
      localContentValues.put("house_price", paramAlternateListing.getShortDayRental());
    }
  }
  
  public static void save(Context paramContext, List<AlternateListing> paramList)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    label269:
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        AlternateListing localAlternateListing;
        ContentValues localContentValues;
        if (paramList.hasNext())
        {
          localAlternateListing = (AlternateListing)paramList.next();
          if (isExist(localb, localAlternateListing.getUid(), localAlternateListing.getHouse_id(), localAlternateListing.getId(), localAlternateListing.getHouse_type())) {
            continue;
          }
          localContentValues = new ContentValues();
          localContentValues.put("uid", localAlternateListing.getUid());
          localContentValues.put("house_code", localAlternateListing.getId());
          localContentValues.put("house_id", localAlternateListing.getHouse_id());
          localContentValues.put("house_photos", localAlternateListing.getHouse_photos());
          if (localAlternateListing.getDuanzuFlag() != 0) {
            break label269;
          }
          localContentValues.put("house_price", localAlternateListing.getSell_price());
          localContentValues.put("house_name", localAlternateListing.getRoom_name());
          localContentValues.put("house_type", Integer.valueOf(localAlternateListing.getHouse_type()));
          localContentValues.put("to_see_state", localAlternateListing.getTo_see_state());
          localContentValues.put("is_duanzu", Integer.valueOf(localAlternateListing.getDuanzuFlag()));
          localContentValues.put("city_id", localAlternateListing.getCityCode());
          localContentValues.put("block_id", localAlternateListing.getResblock_id());
          localContentValues.put("city_id", com.ziroom.ziroomcustomer.base.b.d);
          localContentValues.put("add_date", localAlternateListing.getAdd_time());
          localContentValues.put("room_status", localAlternateListing.getRoom_status());
          localb.insert("t_alternate_listing", null, localContentValues);
        }
        localContentValues.put("house_price", localAlternateListing.getShortDayRental());
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        paramContext.releaseSession(localb);
        return;
      }
    }
  }
  
  public static void updata(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("to_see_state", paramString2);
      localb.update("t_alternate_listing", localContentValues, "house_code=?", new String[] { String.valueOf(paramString1) });
      paramContext.releaseSession(localb);
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
  
  public static void updatastatusandprice(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    for (;;)
    {
      try
      {
        localContentValues = new ContentValues();
        localContentValues.put("room_status", paramString2);
        if (paramInt != 0) {
          continue;
        }
        localContentValues.put("house_price", paramString3);
        localb.update("t_alternate_listing", localContentValues, "house_code=?", new String[] { String.valueOf(paramString1) });
      }
      catch (Exception paramString1)
      {
        ContentValues localContentValues;
        paramString1.printStackTrace();
        continue;
      }
      paramContext.releaseSession(localb);
      return;
      localContentValues.put("house_price", paramString3);
    }
  }
  
  public void deleteTable(Context paramContext)
  {
    paramContext = new e(paramContext);
    com.freelxl.baselibrary.c.b localb = paramContext.getSession();
    try
    {
      localb.execSQL("drop table t_alternate_listing");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */