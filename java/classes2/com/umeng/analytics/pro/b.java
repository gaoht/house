package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  private static b c;
  private static SQLiteOpenHelper d;
  private AtomicInteger a = new AtomicInteger();
  private AtomicInteger b = new AtomicInteger();
  private SQLiteDatabase e;
  
  public static b a(Context paramContext)
  {
    try
    {
      if (c == null) {
        b(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  private static void b(Context paramContext)
  {
    try
    {
      if (c == null)
      {
        c = new b();
        d = c.a(paramContext);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public SQLiteDatabase a()
  {
    try
    {
      if (this.a.incrementAndGet() == 1) {
        this.e = d.getReadableDatabase();
      }
      SQLiteDatabase localSQLiteDatabase = this.e;
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public SQLiteDatabase b()
  {
    try
    {
      if (this.a.incrementAndGet() == 1) {
        this.e = d.getWritableDatabase();
      }
      SQLiteDatabase localSQLiteDatabase = this.e;
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      if (this.a.decrementAndGet() == 0) {
        this.e.close();
      }
      if (this.b.decrementAndGet() == 0) {
        this.e.close();
      }
      return;
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */