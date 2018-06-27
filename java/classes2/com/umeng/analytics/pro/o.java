package com.umeng.analytics.pro;

import android.content.Context;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class o
{
  private static Context a;
  
  private o()
  {
    if (a != null) {}
  }
  
  public static o a(Context paramContext)
  {
    a = paramContext;
    return a.a();
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = a.b(b.a(a).a());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      by.e("upload agg date error");
      return null;
    }
    finally
    {
      b.a(a).c();
    }
  }
  
  /* Error */
  public void a(f paramf)
  {
    // Byte code:
    //   0: getstatic 16	com/umeng/analytics/pro/o:a	Landroid/content/Context;
    //   3: invokestatic 31	com/umeng/analytics/pro/b:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/b;
    //   6: invokevirtual 34	com/umeng/analytics/pro/b:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: aload_2
    //   11: invokestatic 55	com/umeng/analytics/pro/a:a	(Landroid/database/sqlite/SQLiteDatabase;)Ljava/lang/String;
    //   14: astore_3
    //   15: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   18: invokestatic 66	com/umeng/analytics/pro/q:a	(J)Ljava/lang/String;
    //   21: astore 4
    //   23: aload_3
    //   24: ldc 68
    //   26: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifeq +20 -> 49
    //   32: aload_1
    //   33: ldc 76
    //   35: iconst_0
    //   36: invokevirtual 81	com/umeng/analytics/pro/f:a	(Ljava/lang/Object;Z)V
    //   39: getstatic 16	com/umeng/analytics/pro/o:a	Landroid/content/Context;
    //   42: invokestatic 31	com/umeng/analytics/pro/b:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/b;
    //   45: invokevirtual 43	com/umeng/analytics/pro/b:c	()V
    //   48: return
    //   49: aload_3
    //   50: aload 4
    //   52: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifne +19 -> 74
    //   58: aload_2
    //   59: aload_1
    //   60: invokestatic 84	com/umeng/analytics/pro/a:a	(Landroid/database/sqlite/SQLiteDatabase;Lcom/umeng/analytics/pro/f;)Z
    //   63: pop
    //   64: getstatic 16	com/umeng/analytics/pro/o:a	Landroid/content/Context;
    //   67: invokestatic 31	com/umeng/analytics/pro/b:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/b;
    //   70: invokevirtual 43	com/umeng/analytics/pro/b:c	()V
    //   73: return
    //   74: aload_2
    //   75: aload_1
    //   76: invokestatic 86	com/umeng/analytics/pro/a:b	(Landroid/database/sqlite/SQLiteDatabase;Lcom/umeng/analytics/pro/f;)Z
    //   79: pop
    //   80: goto -16 -> 64
    //   83: astore_2
    //   84: aload_1
    //   85: iconst_0
    //   86: invokestatic 92	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   89: iconst_0
    //   90: invokevirtual 81	com/umeng/analytics/pro/f:a	(Ljava/lang/Object;Z)V
    //   93: ldc 94
    //   95: invokestatic 51	com/umeng/analytics/pro/by:e	(Ljava/lang/String;)V
    //   98: getstatic 16	com/umeng/analytics/pro/o:a	Landroid/content/Context;
    //   101: invokestatic 31	com/umeng/analytics/pro/b:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/b;
    //   104: invokevirtual 43	com/umeng/analytics/pro/b:c	()V
    //   107: return
    //   108: astore_1
    //   109: getstatic 16	com/umeng/analytics/pro/o:a	Landroid/content/Context;
    //   112: invokestatic 31	com/umeng/analytics/pro/b:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/b;
    //   115: invokevirtual 43	com/umeng/analytics/pro/b:c	()V
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	o
    //   0	120	1	paramf	f
    //   9	66	2	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   83	1	2	localException	Exception
    //   14	36	3	str1	String
    //   21	30	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	39	83	java/lang/Exception
    //   49	64	83	java/lang/Exception
    //   74	80	83	java/lang/Exception
    //   0	39	108	finally
    //   49	64	108	finally
    //   74	80	108	finally
    //   84	98	108	finally
  }
  
  public void a(f paramf, String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      a.a(b.a(a).b(), paramString, paramLong1, paramLong2);
      paramf.a("success", false);
      return;
    }
    catch (Exception paramf)
    {
      by.e("package size to big or envelopeOverflowPackageCount exception");
      return;
    }
    finally
    {
      b.a(a).c();
    }
  }
  
  public void a(f paramf, List<String> paramList)
  {
    try
    {
      a.a(paramf, b.a(a).b(), paramList);
      return;
    }
    catch (Exception paramf)
    {
      by.e("saveToLimitCKTable exception");
      return;
    }
    finally
    {
      b.a(a).c();
    }
  }
  
  public void a(f paramf, Map<List<String>, i> paramMap)
  {
    try
    {
      a.a(b.a(a).b(), paramMap.values());
      paramf.a("success", false);
      return;
    }
    catch (Exception paramf)
    {
      by.e("save agg data error");
      return;
    }
    finally
    {
      b.a(a).c();
    }
  }
  
  public void a(f paramf, boolean paramBoolean)
  {
    try
    {
      a.a(b.a(a).b(), paramBoolean, paramf);
      return;
    }
    catch (Exception paramf)
    {
      by.e("notifyUploadSuccess error");
      return;
    }
    finally
    {
      b.a(a).c();
    }
  }
  
  public List<String> b()
  {
    try
    {
      List localList = a.c(b.a(a).a());
      return localList;
    }
    catch (Exception localException)
    {
      by.e("loadCKToMemory exception");
      return null;
    }
    finally
    {
      b.a(a).c();
    }
  }
  
  public JSONObject b(f paramf)
  {
    try
    {
      paramf = a.a(paramf, b.a(a).a());
      return paramf;
    }
    catch (Exception paramf)
    {
      paramf.printStackTrace();
      return null;
    }
    finally
    {
      b.a(a).c();
    }
  }
  
  public void b(f paramf, Map<String, k> paramMap)
  {
    try
    {
      a.a(b.a(a).b(), paramMap, paramf);
      return;
    }
    catch (Exception paramf)
    {
      by.e("arrgetated system buffer exception");
      return;
    }
    finally
    {
      b.a(a).c();
    }
  }
  
  public void c(f paramf, Map<List<String>, i> paramMap)
  {
    try
    {
      a.a(paramf, b.a(a).b(), paramMap.values());
      return;
    }
    catch (Exception paramf)
    {
      by.e("cacheToData error");
      return;
    }
    finally
    {
      b.a(a).c();
    }
  }
  
  private static final class a
  {
    private static final o a = new o(null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */