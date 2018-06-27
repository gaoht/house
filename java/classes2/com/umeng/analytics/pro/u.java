package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

class u
{
  private static u c;
  private static SQLiteOpenHelper d;
  private AtomicInteger a = new AtomicInteger();
  private AtomicInteger b = new AtomicInteger();
  private SQLiteDatabase e;
  
  public static u a(Context paramContext)
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
        c = new u();
        d = t.a(paramContext);
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
        this.e = d.getWritableDatabase();
      }
      SQLiteDatabase localSQLiteDatabase = this.e;
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public void b()
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */