package cn.sharesdk.framework.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.sharesdk.framework.utils.e;
import com.mob.tools.log.NLog;

public class b
{
  private static b b = null;
  private a a = new a();
  
  public static b a()
  {
    try
    {
      if (b == null) {
        b = new b();
      }
      b localb = b;
      return localb;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    Object localObject = null;
    String str = null;
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    try
    {
      paramString = localSQLiteDatabase.rawQuery("select count(*) from " + paramString, null);
      str = paramString;
      localObject = paramString;
      if (paramString.moveToNext())
      {
        str = paramString;
        localObject = paramString;
        i = paramString.getInt(0);
      }
      paramString.close();
      return i;
    }
    catch (Exception paramString)
    {
      localObject = str;
      e.b().w(paramString);
      str.close();
      return 0;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    try
    {
      i = localSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
    }
    catch (Exception paramString2)
    {
      try
      {
        e.b().d("Deleted %d rows from table: %s", new Object[] { Integer.valueOf(i), paramString1 });
        return i;
      }
      catch (Exception paramString2)
      {
        int i;
        for (;;) {}
      }
      paramString2 = paramString2;
      i = 0;
    }
    tmp61_58[0] = paramString1;
    e.b().w(paramString2, "when delete database occur error table:%s,", tmp61_58);
    return i;
  }
  
  public long a(String paramString, ContentValues paramContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    try
    {
      long l = localSQLiteDatabase.replace(paramString, null, paramContentValues);
      return l;
    }
    catch (Exception paramContentValues)
    {
      e.b().w(paramContentValues, "when insert database occur error table:%s,", new Object[] { paramString });
    }
    return -1L;
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    e.b().d("Query table: %s", new Object[] { paramString1 });
    try
    {
      paramArrayOfString1 = localSQLiteDatabase.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString3);
      return paramArrayOfString1;
    }
    catch (Exception paramArrayOfString1)
    {
      e.b().w(paramArrayOfString1, "when query database occur error table:%s,", new Object[] { paramString1 });
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */