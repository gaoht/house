package com.ziroom.ziroomcustomer.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.freelxl.baselibrary.c.b;

public class t
{
  public static String a = "a1";
  public static String b = "a0";
  
  private static void a(Context paramContext, String paramString, long paramLong, com.alibaba.fastjson.e parame)
  {
    b localb;
    if (parame != null)
    {
      paramContext = new e(paramContext);
      localb = paramContext.getSession();
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("type", paramString);
      localContentValues.put("time", Long.valueOf(paramLong));
      localContentValues.put("content", parame.toJSONString());
      localContentValues.put("uploadFlag", Integer.valueOf(0));
      localb.insert("t_ziroom_bi", null, localContentValues);
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static void createTable(b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS t_ziroom_bi(");
    localStringBuffer.append("id INTEGER PRIMARY KEY autoincrement,");
    localStringBuffer.append("type \tvarchar,");
    localStringBuffer.append("time \tinteger,");
    localStringBuffer.append("content \tvarchar,");
    localStringBuffer.append("uploadFlag \tinteger");
    localStringBuffer.append(")");
    paramb.execSQL(localStringBuffer.toString());
  }
  
  public static void delete(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_ziroom_bi", new Object[0]);
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void deleteNew(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_ziroom_biwhere uploadFlag = 0", new Object[0]);
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void deleteOld(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("DELETE FROM t_ziroom_biwhere uploadFlag >= 2", new Object[0]);
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static com.alibaba.fastjson.b queryAll(Context paramContext)
  {
    // Byte code:
    //   0: new 26	com/ziroom/ziroomcustomer/b/e
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 29	com/ziroom/ziroomcustomer/b/e:<init>	(Landroid/content/Context;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 33	com/ziroom/ziroomcustomer/b/e:getSession	()Lcom/freelxl/baselibrary/c/b;
    //   13: astore 4
    //   15: aload 4
    //   17: ldc -125
    //   19: iconst_0
    //   20: anewarray 133	java/lang/String
    //   23: invokevirtual 137	com/freelxl/baselibrary/c/b:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +103 -> 131
    //   31: aload_2
    //   32: invokeinterface 143 1 0
    //   37: ifle +94 -> 131
    //   40: new 145	com/alibaba/fastjson/b
    //   43: dup
    //   44: invokespecial 146	com/alibaba/fastjson/b:<init>	()V
    //   47: astore_0
    //   48: aload_2
    //   49: invokeinterface 150 1 0
    //   54: pop
    //   55: aload_2
    //   56: invokeinterface 153 1 0
    //   61: istore_1
    //   62: iload_1
    //   63: ifne +48 -> 111
    //   66: aload_0
    //   67: aload_2
    //   68: aload_2
    //   69: ldc 55
    //   71: invokeinterface 157 2 0
    //   76: invokeinterface 161 2 0
    //   81: invokestatic 165	com/alibaba/fastjson/e:parseObject	(Ljava/lang/String;)Lcom/alibaba/fastjson/e;
    //   84: invokevirtual 169	com/alibaba/fastjson/b:add	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: aload_2
    //   89: invokeinterface 172 1 0
    //   94: pop
    //   95: goto -40 -> 55
    //   98: astore_2
    //   99: aload_2
    //   100: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   103: aload_3
    //   104: aload 4
    //   106: invokevirtual 83	com/ziroom/ziroomcustomer/b/e:releaseSession	(Lcom/freelxl/baselibrary/c/b;)V
    //   109: aload_0
    //   110: areturn
    //   111: aload_2
    //   112: invokeinterface 175 1 0
    //   117: goto -14 -> 103
    //   120: astore_2
    //   121: aconst_null
    //   122: astore_0
    //   123: goto -24 -> 99
    //   126: astore 5
    //   128: goto -40 -> 88
    //   131: aconst_null
    //   132: astore_0
    //   133: goto -30 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramContext	Context
    //   61	2	1	bool	boolean
    //   26	63	2	localCursor	Cursor
    //   98	14	2	localException1	Exception
    //   120	1	2	localException2	Exception
    //   8	96	3	locale	e
    //   13	92	4	localb	b
    //   126	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   48	55	98	java/lang/Exception
    //   55	62	98	java/lang/Exception
    //   88	95	98	java/lang/Exception
    //   111	117	98	java/lang/Exception
    //   15	27	120	java/lang/Exception
    //   31	48	120	java/lang/Exception
    //   66	88	126	java/lang/Exception
  }
  
  public static long queryFirstTime(Context paramContext)
  {
    e locale = new e(paramContext);
    b localb = locale.getSession();
    for (;;)
    {
      try
      {
        paramContext = localb.rawQuery("select time from t_ziroom_bi where uploadFlag < 2 order by time desc limit 0", new String[0]);
        paramContext.moveToFirst();
        long l = paramContext.getLong(paramContext.getColumnIndex("time"));
        paramContext.printStackTrace();
      }
      catch (Exception paramContext)
      {
        try
        {
          paramContext.close();
          locale.releaseSession(localb);
          return l;
        }
        catch (Exception paramContext)
        {
          for (;;) {}
        }
        paramContext = paramContext;
        l = 0L;
      }
    }
  }
  
  /* Error */
  public static com.alibaba.fastjson.b queryNew(Context paramContext)
  {
    // Byte code:
    //   0: new 26	com/ziroom/ziroomcustomer/b/e
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 29	com/ziroom/ziroomcustomer/b/e:<init>	(Landroid/content/Context;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 33	com/ziroom/ziroomcustomer/b/e:getSession	()Lcom/freelxl/baselibrary/c/b;
    //   13: astore 4
    //   15: aload 4
    //   17: ldc -70
    //   19: iconst_0
    //   20: anewarray 133	java/lang/String
    //   23: invokevirtual 137	com/freelxl/baselibrary/c/b:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +103 -> 131
    //   31: aload_2
    //   32: invokeinterface 143 1 0
    //   37: ifle +94 -> 131
    //   40: new 145	com/alibaba/fastjson/b
    //   43: dup
    //   44: invokespecial 146	com/alibaba/fastjson/b:<init>	()V
    //   47: astore_0
    //   48: aload_2
    //   49: invokeinterface 150 1 0
    //   54: pop
    //   55: aload_2
    //   56: invokeinterface 153 1 0
    //   61: istore_1
    //   62: iload_1
    //   63: ifne +48 -> 111
    //   66: aload_0
    //   67: aload_2
    //   68: aload_2
    //   69: ldc 55
    //   71: invokeinterface 157 2 0
    //   76: invokeinterface 161 2 0
    //   81: invokestatic 165	com/alibaba/fastjson/e:parseObject	(Ljava/lang/String;)Lcom/alibaba/fastjson/e;
    //   84: invokevirtual 169	com/alibaba/fastjson/b:add	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: aload_2
    //   89: invokeinterface 172 1 0
    //   94: pop
    //   95: goto -40 -> 55
    //   98: astore_2
    //   99: aload_2
    //   100: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   103: aload_3
    //   104: aload 4
    //   106: invokevirtual 83	com/ziroom/ziroomcustomer/b/e:releaseSession	(Lcom/freelxl/baselibrary/c/b;)V
    //   109: aload_0
    //   110: areturn
    //   111: aload_2
    //   112: invokeinterface 175 1 0
    //   117: goto -14 -> 103
    //   120: astore_2
    //   121: aconst_null
    //   122: astore_0
    //   123: goto -24 -> 99
    //   126: astore 5
    //   128: goto -40 -> 88
    //   131: aconst_null
    //   132: astore_0
    //   133: goto -30 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramContext	Context
    //   61	2	1	bool	boolean
    //   26	63	2	localCursor	Cursor
    //   98	14	2	localException1	Exception
    //   120	1	2	localException2	Exception
    //   8	96	3	locale	e
    //   13	92	4	localb	b
    //   126	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   48	55	98	java/lang/Exception
    //   55	62	98	java/lang/Exception
    //   88	95	98	java/lang/Exception
    //   111	117	98	java/lang/Exception
    //   15	27	120	java/lang/Exception
    //   31	48	120	java/lang/Exception
    //   66	88	126	java/lang/Exception
  }
  
  public static int queryNum(Context paramContext)
  {
    e locale = new e(paramContext);
    b localb = locale.getSession();
    for (;;)
    {
      try
      {
        paramContext = localb.rawQuery("SELECT COUNT(*) count FROM t_ziroom_bi WHERE uploadFlag < 1", new String[0]);
        paramContext.moveToFirst();
        int i = paramContext.getInt(paramContext.getColumnIndex("count"));
        paramContext.printStackTrace();
      }
      catch (Exception paramContext)
      {
        try
        {
          paramContext.close();
          locale.releaseSession(localb);
          return i;
        }
        catch (Exception paramContext)
        {
          for (;;) {}
        }
        paramContext = paramContext;
        i = 0;
      }
    }
  }
  
  public static void saveClickEvent(Context paramContext, long paramLong, com.alibaba.fastjson.e parame)
  {
    if (parame != null) {
      a(paramContext, a, paramLong, parame);
    }
  }
  
  public static void savePageEvent(Context paramContext, long paramLong, com.alibaba.fastjson.e parame)
  {
    if (parame != null) {
      a(paramContext, b, paramLong, parame);
    }
  }
  
  public static void updateUploadFlagAll(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("update t_ziroom_bi set uploadFlag = (case when uploadFlag=0 then 1 else 2 end) where uploadFlag<2", new Object[0]);
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void updateUploadFlagNew(Context paramContext)
  {
    paramContext = new e(paramContext);
    b localb = paramContext.getSession();
    try
    {
      localb.execSQL("update t_ziroom_bi set uploadFlag = 1 where uploadFlag = 0", new Object[0]);
      paramContext.releaseSession(localb);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */