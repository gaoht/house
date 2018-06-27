package com.baidu.trace;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.trace.c.a;
import java.util.concurrent.ExecutorService;

public final class u
  extends SQLiteOpenHelper
{
  private SQLiteOpenHelper a = null;
  private Context b = null;
  
  public u(Context paramContext)
  {
    super(paramContext, "BAIDUTRACE.db", null, 3);
    String[] arrayOfString = paramContext.databaseList();
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return;
    }
    int m = arrayOfString.length;
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k = i;
      String str;
      if (j < m)
      {
        str = arrayOfString[j];
        if ("BAIDUTRACE.db".equals(str))
        {
          paramContext.deleteDatabase("LBSTRACE.db");
          k = 0;
        }
      }
      else
      {
        if (k == 0) {
          break;
        }
        this.b = paramContext;
        this.a = new x(this, paramContext, "LBSTRACE.db", null, 1);
        return;
      }
      if ("LBSTRACE.db".equals(str)) {
        i = 1;
      }
      j += 1;
    }
  }
  
  protected static void a(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    try
    {
      paramSQLiteDatabase.execSQL(paramString, paramArrayOfString);
      return;
    }
    catch (Exception paramSQLiteDatabase) {}
  }
  
  protected static Cursor b(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      return paramSQLiteDatabase;
    }
    catch (Exception paramSQLiteDatabase) {}
    return null;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuffer localStringBuffer1 = new StringBuffer("CREATE TABLE if not exists ");
    localStringBuffer1.append("trace_location (").append("loc_time INTEGER, ").append("entity_name VARCHAR(128), ").append("location_data BLOB);");
    StringBuffer localStringBuffer2 = new StringBuffer("CREATE TABLE if not exists ");
    localStringBuffer2.append("trace_fence (").append("fence_id INTEGER PRIMARY KEY AUTOINCREMENT, ").append("fence_name VARCHAR(128), ").append("monitored_person VARCHAR(128), ").append("coord_type VARCHAR(16), ").append("denoise INTEGER, ").append("fence_shape VARCHAR(16), ").append("create_time VARCHAR(32), ").append("modify_time VARCHAR(32), ").append("monitored_status VARCHAR(16), ").append("fence_extern_info TEXT);");
    StringBuffer localStringBuffer3 = new StringBuffer("CREATE TABLE if not exists ");
    localStringBuffer3.append("trace_fence_alarm (").append("fence_id INTEGER, ").append("fence_name VARCHAR(128), ").append("monitored_person VARCHAR(128), ").append("monitored_action VARCHAR(16), ").append("create_time INTEGER, ").append("cur_point TEXT, ").append("pre_point TEXT);");
    try
    {
      paramSQLiteDatabase.execSQL(localStringBuffer1.toString());
      paramSQLiteDatabase.execSQL(localStringBuffer2.toString());
      paramSQLiteDatabase.execSQL(localStringBuffer3.toString());
      if (this.a == null) {
        return;
      }
      a.a.execute(new v(this, paramSQLiteDatabase));
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    super.onDowngrade(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    a.a.execute(new w(this, paramInt1, paramInt2, paramSQLiteDatabase));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */