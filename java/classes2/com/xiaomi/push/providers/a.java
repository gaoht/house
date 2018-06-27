package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.channel.commonutils.logger.b;

public class a
  extends SQLiteOpenHelper
{
  public static final Object a = new Object();
  private static int b = 1;
  private static final String[] c = { "package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT" };
  
  public a(Context paramContext)
  {
    super(paramContext, "traffic.db", null, b);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
    int i = 0;
    while (i < c.length - 1)
    {
      if (i != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(c[i]).append(" ").append(c[(i + 1)]);
      i += 2;
    }
    localStringBuilder.append(");");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    synchronized (a)
    {
      try
      {
        a(paramSQLiteDatabase);
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        for (;;)
        {
          b.a(paramSQLiteDatabase);
        }
      }
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/providers/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */