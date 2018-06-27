package com.xiaomi.push.service;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.channel.commonutils.logger.b;

public class f
  extends SQLiteOpenHelper
{
  private static final String[] c = { "name", "TEXT NOT NULL", "appId", "INTEGER NOT NULL", "package_name", "TEXT NOT NULL", "create_time", "INTEGER NOT NULL", "type", "TEXT NOT NULL", "center_longtitude", "TEXT", "center_lantitude", "TEXT", "circle_radius", "REAL", "polygon_point", "TEXT", "coordinate_provider", "TEXT NOT NULL", "current_status", "TEXT NOT NULL" };
  private static final String[] d = { "message_id", "TEXT NOT NULL", "geo_id", "TEXT NOT NULL", "content", "BLOB NOT NULL", "action", "INTEGER NOT NULL", "deadline", "INTEGER NOT NULL" };
  public final Object a = new Object();
  private final String b = "GeoFenceDatabaseHelper.";
  
  public f(Context paramContext)
  {
    super(paramContext, "geofencing.db", null, 1);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE geofence(id TEXT PRIMARY KEY ,");
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
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      b.d(paramSQLiteDatabase.toString());
    }
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE geoMessage(");
      int i = 0;
      while (i < d.length - 1)
      {
        if (i != 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(d[i]).append(" ").append(c[(i + 1)]);
        i += 2;
      }
      localStringBuilder.append(",PRIMARY KEY(message_id,geo_id));");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      b.d(paramSQLiteDatabase.toString());
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    synchronized (this.a)
    {
      try
      {
        a(paramSQLiteDatabase);
        b(paramSQLiteDatabase);
        b.c("GeoFenceDatabaseHelper. create tables");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */