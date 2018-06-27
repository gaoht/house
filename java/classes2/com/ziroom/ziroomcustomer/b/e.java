package com.ziroom.ziroomcustomer.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.freelxl.baselibrary.c.b.b;

public class e
{
  private static String a = "DatabaseHelper";
  private static String b = "ziruke.db";
  private static int c = 12;
  private Context d;
  private com.freelxl.baselibrary.c.b e = null;
  
  public e(Context paramContext)
  {
    this.d = paramContext;
    this.e = com.freelxl.baselibrary.c.b.create(paramContext, "", b, c, new b.b()
    {
      public void onUpgrade(com.freelxl.baselibrary.c.b paramAnonymousb, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        e.this.onUpgrade(paramAnonymousb.getDatabase(), paramAnonymousInt1, paramAnonymousInt2);
      }
    });
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE t_contract ADD is_ziroom varchar");
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE t_alternate_listing ADD room_status varchar");
    paramSQLiteDatabase.execSQL("ALTER TABLE t_alternate_listing ADD add_date varchar");
  }
  
  private void c(SQLiteDatabase paramSQLiteDatabase) {}
  
  private void d(SQLiteDatabase paramSQLiteDatabase)
  {
    g.createTable(paramSQLiteDatabase);
    h.createTable(paramSQLiteDatabase);
  }
  
  private void e(SQLiteDatabase paramSQLiteDatabase)
  {
    o.createTable(paramSQLiteDatabase);
    f.createTable(paramSQLiteDatabase);
  }
  
  private void f(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM t_alternate_listing");
    paramSQLiteDatabase.execSQL("ALTER TABLE t_alternate_listing ADD block_id varchar");
  }
  
  private void g(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE t_contract ADD city_code varchar");
  }
  
  public com.freelxl.baselibrary.c.b getSession()
  {
    this.e = com.freelxl.baselibrary.c.b.create(this.d, "", b, c, null);
    return this.e;
  }
  
  public void onCreate()
  {
    s.createTable(this.e);
    i.createTable(this.e);
    k.createTable(this.e);
    j.createTable(this.e);
    d.createTable(this.e);
    n.createTable(this.e);
    a.createTable(this.e);
    l.createTable(this.e);
    m.createTable(this.e);
    p.createTable(this.e);
    b.createTable(this.e);
    c.createTable(this.e);
    u.createTable(this.e);
    r.createTable(this.e);
    g.createTable(this.e);
    h.createTable(this.e);
    o.createTable(this.e);
    q.createTable(this.e);
    t.createTable(this.e);
    f.createTable(this.e);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_table");
      onCreate();
      return;
    case 2: 
    case 3: 
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_alternate_listing");
      f(paramSQLiteDatabase);
      g(paramSQLiteDatabase);
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
      c(paramSQLiteDatabase);
      d(paramSQLiteDatabase);
      e(paramSQLiteDatabase);
      return;
    case 4: 
      f(paramSQLiteDatabase);
      g(paramSQLiteDatabase);
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
      c(paramSQLiteDatabase);
      d(paramSQLiteDatabase);
      e(paramSQLiteDatabase);
      return;
    case 5: 
      f(paramSQLiteDatabase);
      g(paramSQLiteDatabase);
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
      c(paramSQLiteDatabase);
      d(paramSQLiteDatabase);
      e(paramSQLiteDatabase);
      return;
    case 6: 
      g(paramSQLiteDatabase);
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
      c(paramSQLiteDatabase);
      d(paramSQLiteDatabase);
      e(paramSQLiteDatabase);
      return;
    case 7: 
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
      c(paramSQLiteDatabase);
      d(paramSQLiteDatabase);
      e(paramSQLiteDatabase);
      return;
    case 8: 
      b(paramSQLiteDatabase);
      c(paramSQLiteDatabase);
      d(paramSQLiteDatabase);
      e(paramSQLiteDatabase);
      return;
    case 9: 
      c(paramSQLiteDatabase);
      d(paramSQLiteDatabase);
      e(paramSQLiteDatabase);
      return;
    case 10: 
      d(paramSQLiteDatabase);
      e(paramSQLiteDatabase);
    }
    e(paramSQLiteDatabase);
  }
  
  public void releaseSession(com.freelxl.baselibrary.c.b paramb)
  {
    if (this.e != null) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */