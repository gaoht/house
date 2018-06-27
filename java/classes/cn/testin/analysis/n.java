package cn.testin.analysis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

public class n
  extends SQLiteOpenHelper
{
  private static n a;
  
  public n(Context paramContext)
  {
    super(paramContext, al.k(paramContext) + "." + "abTestin.db", null, 1);
  }
  
  public static n a(Context paramContext)
  {
    if (a == null) {
      a = new n(paramContext);
    }
    return a;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + paramString);
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table if not exists track(_id integer primary key autoincrement,name VARCHAR,value double,expId VARCHAR,componentsKey VARCHAR,timestamp integer)");
  }
  
  public int a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      int i = paramSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
      return i;
    }
    catch (Exception paramSQLiteDatabase)
    {
      ar.a(paramSQLiteDatabase);
    }
    return -1;
  }
  
  public long a(SQLiteDatabase paramSQLiteDatabase, String paramString, ContentValues paramContentValues)
  {
    try
    {
      long l = paramSQLiteDatabase.insert(paramString, null, paramContentValues);
      return l;
    }
    catch (Exception paramSQLiteDatabase)
    {
      ar.a(paramSQLiteDatabase);
    }
    return -1L;
  }
  
  public Cursor a(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      return paramSQLiteDatabase;
    }
    catch (Exception paramSQLiteDatabase)
    {
      ar.a(paramSQLiteDatabase);
    }
    return null;
  }
  
  public Cursor a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
      return paramSQLiteDatabase;
    }
    catch (Exception paramSQLiteDatabase)
    {
      ar.a(paramSQLiteDatabase);
    }
    return null;
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase != null) {}
    try
    {
      if (paramSQLiteDatabase.isOpen()) {
        paramSQLiteDatabase.close();
      }
      if (a != null) {
        a.close();
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      ar.a(paramSQLiteDatabase);
    }
  }
  
  public int b(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = "";
      paramSQLiteDatabase = a.a(paramSQLiteDatabase, "select count(*) from " + paramString1 + paramString2, paramArrayOfString);
      if (paramSQLiteDatabase == null) {
        break label108;
      }
      paramSQLiteDatabase.moveToFirst();
    }
    label108:
    for (int i = paramSQLiteDatabase.getInt(0);; i = 0)
    {
      if ((paramSQLiteDatabase != null) && (!paramSQLiteDatabase.isClosed())) {
        paramSQLiteDatabase.close();
      }
      return i;
      paramString2 = " where " + paramString2;
      break;
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    b(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    a(paramSQLiteDatabase, "track");
    b(paramSQLiteDatabase);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */