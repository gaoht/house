package com.freelxl.baselibrary.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class b
{
  private static HashMap<String, b> a = new HashMap();
  private SQLiteDatabase b;
  private a c;
  private boolean d = false;
  private boolean e = false;
  private Lock f = new ReentrantLock();
  private volatile boolean g = false;
  private final c h = new c(null);
  
  private b(a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("daoConfig may not be null");
    }
    this.b = b(parama);
    this.c = parama;
  }
  
  /* Error */
  private static b a(a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 36	com/freelxl/baselibrary/c/b:a	Ljava/util/HashMap;
    //   6: aload_0
    //   7: invokevirtual 74	com/freelxl/baselibrary/c/b$a:getDbName	()Ljava/lang/String;
    //   10: invokevirtual 78	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 2	com/freelxl/baselibrary/c/b
    //   16: astore_3
    //   17: aload_3
    //   18: ifnonnull +79 -> 97
    //   21: new 2	com/freelxl/baselibrary/c/b
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 80	com/freelxl/baselibrary/c/b:<init>	(Lcom/freelxl/baselibrary/c/b$a;)V
    //   29: astore_3
    //   30: getstatic 36	com/freelxl/baselibrary/c/b:a	Ljava/util/HashMap;
    //   33: aload_0
    //   34: invokevirtual 74	com/freelxl/baselibrary/c/b$a:getDbName	()Ljava/lang/String;
    //   37: aload_3
    //   38: invokevirtual 84	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: aload_3
    //   43: getfield 67	com/freelxl/baselibrary/c/b:b	Landroid/database/sqlite/SQLiteDatabase;
    //   46: astore 4
    //   48: aload 4
    //   50: invokevirtual 90	android/database/sqlite/SQLiteDatabase:getVersion	()I
    //   53: istore_1
    //   54: aload_0
    //   55: invokevirtual 93	com/freelxl/baselibrary/c/b$a:getDbVersion	()I
    //   58: istore_2
    //   59: iload_1
    //   60: iload_2
    //   61: if_icmpeq +31 -> 92
    //   64: iload_1
    //   65: ifeq +21 -> 86
    //   68: aload_0
    //   69: invokevirtual 97	com/freelxl/baselibrary/c/b$a:getDbUpgradeListener	()Lcom/freelxl/baselibrary/c/b$b;
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull +12 -> 86
    //   77: aload_0
    //   78: aload_3
    //   79: iload_1
    //   80: iload_2
    //   81: invokeinterface 101 4 0
    //   86: aload 4
    //   88: iload_2
    //   89: invokevirtual 105	android/database/sqlite/SQLiteDatabase:setVersion	(I)V
    //   92: ldc 2
    //   94: monitorexit
    //   95: aload_3
    //   96: areturn
    //   97: aload_3
    //   98: aload_0
    //   99: putfield 69	com/freelxl/baselibrary/c/b:c	Lcom/freelxl/baselibrary/c/b$a;
    //   102: goto -60 -> 42
    //   105: astore_0
    //   106: ldc 2
    //   108: monitorexit
    //   109: aload_0
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	parama	a
    //   53	27	1	i	int
    //   58	31	2	j	int
    //   16	82	3	localb	b
    //   46	41	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   3	17	105	finally
    //   21	42	105	finally
    //   42	59	105	finally
    //   68	73	105	finally
    //   77	86	105	finally
    //   86	92	105	finally
    //   97	102	105	finally
  }
  
  private void a()
  {
    if (!this.b.isOpen()) {
      this.b = b(this.c);
    }
  }
  
  private void a(String paramString)
  {
    if (this.d) {
      a.d(paramString);
    }
  }
  
  private SQLiteDatabase b(a parama)
  {
    SQLiteDatabase localSQLiteDatabase = null;
    String str = parama.getDbDir();
    if (!TextUtils.isEmpty(str))
    {
      File localFile = new File(str);
      if ((localFile.exists()) || (localFile.mkdirs())) {
        localSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(new File(str, parama.getDbName()), null);
      }
      return localSQLiteDatabase;
    }
    return parama.getContext().openOrCreateDatabase(parama.getDbName(), 0, null);
  }
  
  public static b create(Context paramContext)
  {
    return a(new a(paramContext));
  }
  
  public static b create(Context paramContext, String paramString)
  {
    paramContext = new a(paramContext);
    paramContext.setDbName(paramString);
    return a(paramContext);
  }
  
  public static b create(Context paramContext, String paramString, int paramInt, b paramb)
  {
    paramContext = new a(paramContext);
    paramContext.setDbName(paramString);
    paramContext.setDbVersion(paramInt);
    paramContext.setDbUpgradeListener(paramb);
    return a(paramContext);
  }
  
  public static b create(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new a(paramContext);
    paramContext.setDbDir(paramString1);
    paramContext.setDbName(paramString2);
    return a(paramContext);
  }
  
  public static b create(Context paramContext, String paramString1, String paramString2, int paramInt, b paramb)
  {
    paramContext = new a(paramContext);
    paramContext.setDbDir(paramString1);
    paramContext.setDbName(paramString2);
    paramContext.setDbVersion(paramInt);
    paramContext.setDbUpgradeListener(paramb);
    return a(paramContext);
  }
  
  public static b create(a parama)
  {
    return a(parama);
  }
  
  public void close()
  {
    String str = this.c.getDbName();
    if (a.containsKey(str))
    {
      a.remove(str);
      this.b.close();
    }
  }
  
  public b configAllowTransaction(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public b configDebug(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    a();
    return this.b.delete(paramString1, paramString2, paramArrayOfString);
  }
  
  public void execSQL(String paramString)
  {
    a();
    a(paramString);
    try
    {
      this.b.execSQL(paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public void execSQL(String paramString, Object[] paramArrayOfObject)
  {
    a();
    a(paramString);
    try
    {
      this.b.execSQL(paramString, paramArrayOfObject);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public a getDaoConfig()
  {
    return this.c;
  }
  
  public SQLiteDatabase getDatabase()
  {
    if (!this.b.isOpen()) {
      this.b = b(this.c);
    }
    return this.b;
  }
  
  public long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    a();
    return this.b.insert(paramString1, paramString2, paramContentValues);
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    a();
    a(paramString);
    return this.b.rawQuery(paramString, paramArrayOfString);
  }
  
  public int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    a();
    return this.b.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
  }
  
  public static class a
  {
    private Context a;
    private String b = "homelink.db";
    private int c = 1;
    private b.b d;
    private String e;
    
    public a(Context paramContext)
    {
      this.a = paramContext.getApplicationContext();
    }
    
    public Context getContext()
    {
      return this.a;
    }
    
    public String getDbDir()
    {
      return this.e;
    }
    
    public String getDbName()
    {
      return this.b;
    }
    
    public b.b getDbUpgradeListener()
    {
      return this.d;
    }
    
    public int getDbVersion()
    {
      return this.c;
    }
    
    public void setDbDir(String paramString)
    {
      this.e = paramString;
    }
    
    public void setDbName(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.b = paramString;
      }
    }
    
    public void setDbUpgradeListener(b.b paramb)
    {
      this.d = paramb;
    }
    
    public void setDbVersion(int paramInt)
    {
      this.c = paramInt;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onUpgrade(b paramb, int paramInt1, int paramInt2);
  }
  
  private class c
  {
    private final ConcurrentHashMap<String, Object> b = new ConcurrentHashMap();
    private long c = 0L;
    
    private c() {}
    
    public Object get(String paramString)
    {
      return this.b.get(paramString);
    }
    
    public void put(String paramString, Object paramObject)
    {
      if ((paramString != null) && (paramObject != null)) {
        this.b.put(paramString, paramObject);
      }
    }
    
    public void setSeq(long paramLong)
    {
      if (this.c != paramLong)
      {
        this.b.clear();
        this.c = paramLong;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */