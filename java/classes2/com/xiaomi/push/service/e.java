package com.xiaomi.push.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.xmpush.thrift.h;
import com.xiaomi.xmpush.thrift.j;
import com.xiaomi.xmpush.thrift.l;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private static volatile e b;
  private static String c = "GeoFenceDao.";
  private f a;
  
  private e(Context paramContext)
  {
    this.a = new f(paramContext);
  }
  
  /* Error */
  private Cursor a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: iconst_0
    //   5: invokestatic 35	com/xiaomi/channel/commonutils/misc/k:a	(Z)V
    //   8: aload_1
    //   9: ldc 37
    //   11: aconst_null
    //   12: invokevirtual 43	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    //   25: astore_1
    //   26: aload_2
    //   27: astore_1
    //   28: goto -12 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	e
    //   0	31	1	paramSQLiteDatabase	SQLiteDatabase
    //   1	26	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	8	20	finally
    //   8	16	20	finally
    //   8	16	25	java/lang/Exception
  }
  
  public static e a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new e(paramContext);
      }
      return b;
    }
    finally {}
  }
  
  private com.xiaomi.xmpush.thrift.k a(Cursor paramCursor)
  {
    for (;;)
    {
      try
      {
        com.xiaomi.xmpush.thrift.k[] arrayOfk = com.xiaomi.xmpush.thrift.k.values();
        int j = arrayOfk.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        com.xiaomi.xmpush.thrift.k localk = arrayOfk[i];
        boolean bool = TextUtils.equals(paramCursor.getString(paramCursor.getColumnIndex("type")), localk.name());
        if (!bool) {
          continue;
        }
        paramCursor = localk;
      }
      catch (Exception paramCursor)
      {
        int i;
        b.d(paramCursor.toString());
        paramCursor = null;
        continue;
      }
      finally {}
      return paramCursor;
      i += 1;
      continue;
      paramCursor = null;
    }
  }
  
  /* Error */
  private String a(java.util.List<l> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +13 -> 16
    //   6: aload_1
    //   7: invokeinterface 94 1 0
    //   12: iconst_3
    //   13: if_icmpge +33 -> 46
    //   16: new 96	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   23: getstatic 16	com/xiaomi/push/service/e:c	Ljava/lang/String;
    //   26: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 103
    //   31: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 106	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   40: aconst_null
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: new 108	org/json/JSONArray
    //   49: dup
    //   50: invokespecial 109	org/json/JSONArray:<init>	()V
    //   53: astore_2
    //   54: aload_1
    //   55: invokeinterface 113 1 0
    //   60: astore_1
    //   61: aload_1
    //   62: invokeinterface 119 1 0
    //   67: ifeq +73 -> 140
    //   70: aload_1
    //   71: invokeinterface 123 1 0
    //   76: checkcast 125	com/xiaomi/xmpush/thrift/l
    //   79: astore_3
    //   80: aload_3
    //   81: ifnull -20 -> 61
    //   84: new 127	org/json/JSONObject
    //   87: dup
    //   88: invokespecial 128	org/json/JSONObject:<init>	()V
    //   91: astore 4
    //   93: aload 4
    //   95: ldc -126
    //   97: aload_3
    //   98: invokevirtual 133	com/xiaomi/xmpush/thrift/l:c	()D
    //   101: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   104: pop
    //   105: aload 4
    //   107: ldc -117
    //   109: aload_3
    //   110: invokevirtual 141	com/xiaomi/xmpush/thrift/l:a	()D
    //   113: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   116: pop
    //   117: aload_2
    //   118: aload 4
    //   120: invokevirtual 144	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   123: pop
    //   124: goto -63 -> 61
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 145	org/json/JSONException:toString	()Ljava/lang/String;
    //   132: invokestatic 85	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   135: aconst_null
    //   136: astore_1
    //   137: goto -95 -> 42
    //   140: aload_2
    //   141: invokevirtual 146	org/json/JSONArray:toString	()Ljava/lang/String;
    //   144: astore_1
    //   145: goto -103 -> 42
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	e
    //   0	153	1	paramList	java.util.List<l>
    //   53	88	2	localJSONArray	JSONArray
    //   79	31	3	locall	l
    //   91	28	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   54	61	127	org/json/JSONException
    //   61	80	127	org/json/JSONException
    //   84	124	127	org/json/JSONException
    //   140	145	127	org/json/JSONException
    //   6	16	148	finally
    //   16	40	148	finally
    //   46	54	148	finally
    //   54	61	148	finally
    //   61	80	148	finally
    //   84	124	148	finally
    //   128	135	148	finally
    //   140	145	148	finally
  }
  
  private l b(Cursor paramCursor)
  {
    try
    {
      l locall = new l();
      try
      {
        locall.b(Double.parseDouble(paramCursor.getString(paramCursor.getColumnIndex("center_lantitude"))));
        locall.a(Double.parseDouble(paramCursor.getString(paramCursor.getColumnIndex("center_longtitude"))));
        paramCursor = locall;
      }
      catch (Exception paramCursor)
      {
        for (;;)
        {
          b.d(paramCursor.toString());
          paramCursor = null;
        }
      }
      return paramCursor;
    }
    finally {}
  }
  
  private ArrayList<l> c(Cursor paramCursor)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        paramCursor = new JSONArray(paramCursor.getString(paramCursor.getColumnIndex("polygon_points")));
        int i = 0;
        while (i < paramCursor.length())
        {
          l locall = new l();
          JSONObject localJSONObject = (JSONObject)paramCursor.get(i);
          locall.b(localJSONObject.getDouble("point_lantitude"));
          locall.a(localJSONObject.getDouble("point_longtitude"));
          localArrayList.add(locall);
          i += 1;
        }
        paramCursor = localArrayList;
      }
      catch (JSONException paramCursor)
      {
        for (;;)
        {
          b.d(paramCursor.toString());
          paramCursor = null;
        }
      }
      return paramCursor;
    }
    finally {}
  }
  
  private h d(Cursor paramCursor)
  {
    try
    {
      paramCursor = h.valueOf(paramCursor.getString(paramCursor.getColumnIndex("coordinate_provider")));
      return paramCursor;
    }
    catch (IllegalArgumentException paramCursor)
    {
      for (;;)
      {
        b.d(paramCursor.toString());
        paramCursor = null;
      }
    }
    finally {}
  }
  
  public int a(String paramString1, String paramString2)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        com.xiaomi.channel.commonutils.misc.k.a(false);
        try
        {
          if (("Enter".equals(paramString2)) || ("Leave".equals(paramString2))) {
            continue;
          }
          boolean bool = "Unknown".equals(paramString2);
          if (bool) {
            continue;
          }
        }
        catch (Exception paramString1)
        {
          ContentValues localContentValues;
          int j;
          b.d(paramString1.toString());
          continue;
        }
        return i;
      }
      finally {}
      localContentValues = new ContentValues();
      localContentValues.put("current_status", paramString2);
      paramString2 = this.a.getWritableDatabase();
      j = paramString2.update("geofence", localContentValues, "id=?", new String[] { paramString1 });
      paramString2.close();
      i = j;
    }
  }
  
  /* Error */
  public long a(j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: invokestatic 35	com/xiaomi/channel/commonutils/misc/k:a	(Z)V
    //   6: new 213	android/content/ContentValues
    //   9: dup
    //   10: invokespecial 214	android/content/ContentValues:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc -19
    //   19: aload_1
    //   20: invokevirtual 241	com/xiaomi/xmpush/thrift/j:a	()Ljava/lang/String;
    //   23: invokevirtual 219	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload 4
    //   28: ldc -13
    //   30: aload_1
    //   31: invokevirtual 247	com/xiaomi/xmpush/thrift/j:e	()J
    //   34: invokestatic 252	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   37: invokevirtual 255	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   40: aload 4
    //   42: ldc_w 256
    //   45: aload_1
    //   46: invokevirtual 258	com/xiaomi/xmpush/thrift/j:c	()Ljava/lang/String;
    //   49: invokevirtual 219	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload 4
    //   54: ldc_w 260
    //   57: aload_1
    //   58: invokevirtual 263	com/xiaomi/xmpush/thrift/j:g	()Ljava/lang/String;
    //   61: invokevirtual 219	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload 4
    //   66: ldc_w 265
    //   69: aload_1
    //   70: invokevirtual 268	com/xiaomi/xmpush/thrift/j:i	()J
    //   73: invokestatic 252	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: invokevirtual 255	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   79: aload 4
    //   81: ldc 56
    //   83: aload_1
    //   84: invokevirtual 272	com/xiaomi/xmpush/thrift/j:k	()Lcom/xiaomi/xmpush/thrift/k;
    //   87: invokevirtual 70	com/xiaomi/xmpush/thrift/k:name	()Ljava/lang/String;
    //   90: invokevirtual 219	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload 4
    //   95: ldc -93
    //   97: aload_1
    //   98: invokevirtual 276	com/xiaomi/xmpush/thrift/j:m	()Lcom/xiaomi/xmpush/thrift/l;
    //   101: invokevirtual 141	com/xiaomi/xmpush/thrift/l:a	()D
    //   104: invokestatic 279	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   107: invokevirtual 219	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 4
    //   112: ldc -104
    //   114: aload_1
    //   115: invokevirtual 276	com/xiaomi/xmpush/thrift/j:m	()Lcom/xiaomi/xmpush/thrift/l;
    //   118: invokevirtual 133	com/xiaomi/xmpush/thrift/l:c	()D
    //   121: invokestatic 279	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   124: invokevirtual 219	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload 4
    //   129: ldc_w 281
    //   132: aload_1
    //   133: invokevirtual 284	com/xiaomi/xmpush/thrift/j:o	()D
    //   136: invokestatic 287	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   139: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Double;)V
    //   142: aload 4
    //   144: ldc_w 292
    //   147: aload_0
    //   148: aload_1
    //   149: invokevirtual 296	com/xiaomi/xmpush/thrift/j:q	()Ljava/util/List;
    //   152: invokespecial 298	com/xiaomi/push/service/e:a	(Ljava/util/List;)Ljava/lang/String;
    //   155: invokevirtual 219	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload 4
    //   160: ldc -63
    //   162: aload_1
    //   163: invokevirtual 302	com/xiaomi/xmpush/thrift/j:s	()Lcom/xiaomi/xmpush/thrift/h;
    //   166: invokevirtual 303	com/xiaomi/xmpush/thrift/h:name	()Ljava/lang/String;
    //   169: invokevirtual 219	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload 4
    //   174: ldc -40
    //   176: ldc -45
    //   178: invokevirtual 219	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_0
    //   182: getfield 27	com/xiaomi/push/service/e:a	Lcom/xiaomi/push/service/f;
    //   185: invokevirtual 223	com/xiaomi/push/service/f:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   188: astore_1
    //   189: aload_1
    //   190: ldc -31
    //   192: aconst_null
    //   193: aload 4
    //   195: invokevirtual 307	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   198: lstore_2
    //   199: aload_1
    //   200: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   203: aload_0
    //   204: monitorexit
    //   205: lload_2
    //   206: lreturn
    //   207: astore_1
    //   208: aload_1
    //   209: invokevirtual 79	java/lang/Exception:toString	()Ljava/lang/String;
    //   212: invokestatic 85	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   215: ldc2_w 308
    //   218: lstore_2
    //   219: goto -16 -> 203
    //   222: astore_1
    //   223: aload_0
    //   224: monitorexit
    //   225: aload_1
    //   226: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	e
    //   0	227	1	paramj	j
    //   198	21	2	l	long
    //   13	181	4	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   6	203	207	java/lang/Exception
    //   2	6	222	finally
    //   6	203	222	finally
    //   208	215	222	finally
  }
  
  public j a(String paramString)
  {
    try
    {
      com.xiaomi.channel.commonutils.misc.k.a(false);
      try
      {
        Iterator localIterator = a().iterator();
        j localj;
        boolean bool;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localj = (j)localIterator.next();
          bool = TextUtils.equals(localj.a(), paramString);
        } while (!bool);
        paramString = localj;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          b.d(paramString.toString());
          paramString = null;
          continue;
          paramString = null;
        }
      }
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public ArrayList<j> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: invokestatic 35	com/xiaomi/channel/commonutils/misc/k:a	(Z)V
    //   6: aload_0
    //   7: getfield 27	com/xiaomi/push/service/e:a	Lcom/xiaomi/push/service/f;
    //   10: invokevirtual 223	com/xiaomi/push/service/f:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: astore_3
    //   14: aload_0
    //   15: aload_3
    //   16: invokespecial 316	com/xiaomi/push/service/e:a	(Landroid/database/sqlite/SQLiteDatabase;)Landroid/database/Cursor;
    //   19: astore 4
    //   21: new 168	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 169	java/util/ArrayList:<init>	()V
    //   28: astore_2
    //   29: aload 4
    //   31: ifnull +410 -> 441
    //   34: aload 4
    //   36: invokeinterface 319 1 0
    //   41: istore_1
    //   42: iload_1
    //   43: ifeq +391 -> 434
    //   46: new 239	com/xiaomi/xmpush/thrift/j
    //   49: dup
    //   50: invokespecial 320	com/xiaomi/xmpush/thrift/j:<init>	()V
    //   53: astore 5
    //   55: aload 5
    //   57: aload 4
    //   59: aload 4
    //   61: ldc -19
    //   63: invokeinterface 62 2 0
    //   68: invokeinterface 66 2 0
    //   73: invokevirtual 322	com/xiaomi/xmpush/thrift/j:a	(Ljava/lang/String;)Lcom/xiaomi/xmpush/thrift/j;
    //   76: pop
    //   77: aload 5
    //   79: aload 4
    //   81: aload 4
    //   83: ldc_w 256
    //   86: invokeinterface 62 2 0
    //   91: invokeinterface 66 2 0
    //   96: invokevirtual 324	com/xiaomi/xmpush/thrift/j:b	(Ljava/lang/String;)Lcom/xiaomi/xmpush/thrift/j;
    //   99: pop
    //   100: aload 5
    //   102: aload 4
    //   104: aload 4
    //   106: ldc -13
    //   108: invokeinterface 62 2 0
    //   113: invokeinterface 328 2 0
    //   118: i2l
    //   119: invokevirtual 331	com/xiaomi/xmpush/thrift/j:a	(J)Lcom/xiaomi/xmpush/thrift/j;
    //   122: pop
    //   123: aload 5
    //   125: aload 4
    //   127: aload 4
    //   129: ldc_w 260
    //   132: invokeinterface 62 2 0
    //   137: invokeinterface 66 2 0
    //   142: invokevirtual 333	com/xiaomi/xmpush/thrift/j:c	(Ljava/lang/String;)Lcom/xiaomi/xmpush/thrift/j;
    //   145: pop
    //   146: aload 5
    //   148: aload 4
    //   150: aload 4
    //   152: ldc_w 265
    //   155: invokeinterface 62 2 0
    //   160: invokeinterface 328 2 0
    //   165: i2l
    //   166: invokevirtual 335	com/xiaomi/xmpush/thrift/j:b	(J)Lcom/xiaomi/xmpush/thrift/j;
    //   169: pop
    //   170: aload_0
    //   171: aload 4
    //   173: invokespecial 337	com/xiaomi/push/service/e:a	(Landroid/database/Cursor;)Lcom/xiaomi/xmpush/thrift/k;
    //   176: astore 6
    //   178: aload 6
    //   180: ifnonnull +63 -> 243
    //   183: new 96	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   190: getstatic 16	com/xiaomi/push/service/e:c	Ljava/lang/String;
    //   193: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 339
    //   199: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 341	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   208: goto -174 -> 34
    //   211: astore 5
    //   213: aload 5
    //   215: invokevirtual 79	java/lang/Exception:toString	()Ljava/lang/String;
    //   218: invokestatic 85	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   221: goto -187 -> 34
    //   224: astore_2
    //   225: aload_0
    //   226: monitorexit
    //   227: aload_2
    //   228: athrow
    //   229: astore_2
    //   230: aload_2
    //   231: invokevirtual 79	java/lang/Exception:toString	()Ljava/lang/String;
    //   234: invokestatic 85	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   237: aconst_null
    //   238: astore_2
    //   239: aload_0
    //   240: monitorexit
    //   241: aload_2
    //   242: areturn
    //   243: aload 5
    //   245: aload 6
    //   247: invokevirtual 344	com/xiaomi/xmpush/thrift/j:a	(Lcom/xiaomi/xmpush/thrift/k;)Lcom/xiaomi/xmpush/thrift/j;
    //   250: pop
    //   251: ldc_w 346
    //   254: aload 6
    //   256: invokevirtual 70	com/xiaomi/xmpush/thrift/k:name	()Ljava/lang/String;
    //   259: invokestatic 76	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   262: ifeq +79 -> 341
    //   265: aload 5
    //   267: aload_0
    //   268: aload 4
    //   270: invokespecial 348	com/xiaomi/push/service/e:b	(Landroid/database/Cursor;)Lcom/xiaomi/xmpush/thrift/l;
    //   273: invokevirtual 351	com/xiaomi/xmpush/thrift/j:a	(Lcom/xiaomi/xmpush/thrift/l;)Lcom/xiaomi/xmpush/thrift/j;
    //   276: pop
    //   277: aload 5
    //   279: aload 4
    //   281: aload 4
    //   283: ldc_w 281
    //   286: invokeinterface 62 2 0
    //   291: invokeinterface 354 2 0
    //   296: invokevirtual 357	com/xiaomi/xmpush/thrift/j:a	(D)Lcom/xiaomi/xmpush/thrift/j;
    //   299: pop
    //   300: aload_0
    //   301: aload 4
    //   303: invokespecial 359	com/xiaomi/push/service/e:d	(Landroid/database/Cursor;)Lcom/xiaomi/xmpush/thrift/h;
    //   306: astore 6
    //   308: aload 6
    //   310: ifnonnull +106 -> 416
    //   313: new 96	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   320: getstatic 16	com/xiaomi/push/service/e:c	Ljava/lang/String;
    //   323: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc_w 361
    //   329: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 341	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   338: goto -304 -> 34
    //   341: ldc_w 363
    //   344: aload 6
    //   346: invokevirtual 70	com/xiaomi/xmpush/thrift/k:name	()Ljava/lang/String;
    //   349: invokestatic 76	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   352: ifeq -52 -> 300
    //   355: aload_0
    //   356: aload 4
    //   358: invokespecial 365	com/xiaomi/push/service/e:c	(Landroid/database/Cursor;)Ljava/util/ArrayList;
    //   361: astore 6
    //   363: aload 6
    //   365: ifnull +12 -> 377
    //   368: aload 6
    //   370: invokevirtual 366	java/util/ArrayList:size	()I
    //   373: iconst_3
    //   374: if_icmpge +31 -> 405
    //   377: new 96	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   384: getstatic 16	com/xiaomi/push/service/e:c	Ljava/lang/String;
    //   387: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: ldc_w 368
    //   393: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 341	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   402: goto -368 -> 34
    //   405: aload 5
    //   407: aload 6
    //   409: invokevirtual 371	com/xiaomi/xmpush/thrift/j:a	(Ljava/util/List;)Lcom/xiaomi/xmpush/thrift/j;
    //   412: pop
    //   413: goto -113 -> 300
    //   416: aload 5
    //   418: aload 6
    //   420: invokevirtual 374	com/xiaomi/xmpush/thrift/j:a	(Lcom/xiaomi/xmpush/thrift/h;)Lcom/xiaomi/xmpush/thrift/j;
    //   423: pop
    //   424: aload_2
    //   425: aload 5
    //   427: invokevirtual 187	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   430: pop
    //   431: goto -397 -> 34
    //   434: aload 4
    //   436: invokeinterface 375 1 0
    //   441: aload_3
    //   442: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   445: goto -206 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	e
    //   41	2	1	bool	boolean
    //   28	1	2	localArrayList	ArrayList
    //   224	4	2	localObject1	Object
    //   229	2	2	localException1	Exception
    //   238	187	2	localArrayList1	ArrayList<j>
    //   13	429	3	localSQLiteDatabase	SQLiteDatabase
    //   19	416	4	localCursor	Cursor
    //   53	94	5	localj	j
    //   211	215	5	localException2	Exception
    //   176	243	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   46	178	211	java/lang/Exception
    //   183	208	211	java/lang/Exception
    //   243	300	211	java/lang/Exception
    //   341	363	211	java/lang/Exception
    //   368	377	211	java/lang/Exception
    //   377	402	211	java/lang/Exception
    //   405	413	211	java/lang/Exception
    //   2	6	224	finally
    //   6	21	224	finally
    //   21	29	224	finally
    //   34	42	224	finally
    //   46	178	224	finally
    //   183	208	224	finally
    //   213	221	224	finally
    //   230	237	224	finally
    //   243	300	224	finally
    //   300	308	224	finally
    //   313	338	224	finally
    //   341	363	224	finally
    //   368	377	224	finally
    //   377	402	224	finally
    //   405	413	224	finally
    //   416	431	224	finally
    //   434	441	224	finally
    //   441	445	224	finally
    //   6	21	229	java/lang/Exception
  }
  
  /* Error */
  public ArrayList<j> b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: invokestatic 35	com/xiaomi/channel/commonutils/misc/k:a	(Z)V
    //   6: aload_0
    //   7: invokevirtual 313	com/xiaomi/push/service/e:a	()Ljava/util/ArrayList;
    //   10: astore_3
    //   11: new 168	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 169	java/util/ArrayList:<init>	()V
    //   18: astore_2
    //   19: aload_3
    //   20: invokevirtual 314	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   23: astore_3
    //   24: aload_3
    //   25: invokeinterface 119 1 0
    //   30: ifeq +50 -> 80
    //   33: aload_3
    //   34: invokeinterface 123 1 0
    //   39: checkcast 239	com/xiaomi/xmpush/thrift/j
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 263	com/xiaomi/xmpush/thrift/j:g	()Ljava/lang/String;
    //   49: aload_1
    //   50: invokestatic 76	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   53: ifeq -29 -> 24
    //   56: aload_2
    //   57: aload 4
    //   59: invokevirtual 187	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   62: pop
    //   63: goto -39 -> 24
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 79	java/lang/Exception:toString	()Ljava/lang/String;
    //   71: invokestatic 85	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: areturn
    //   80: aload_2
    //   81: astore_1
    //   82: goto -6 -> 76
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	e
    //   0	90	1	paramString	String
    //   18	63	2	localArrayList	ArrayList
    //   10	24	3	localObject	Object
    //   42	16	4	localj	j
    // Exception table:
    //   from	to	target	type
    //   6	24	66	java/lang/Exception
    //   24	63	66	java/lang/Exception
    //   2	6	85	finally
    //   6	24	85	finally
    //   24	63	85	finally
    //   67	74	85	finally
  }
  
  public String c(String paramString)
  {
    for (;;)
    {
      try
      {
        com.xiaomi.channel.commonutils.misc.k.a(false);
        try
        {
          localCursor = a(this.a.getWritableDatabase());
          if (localCursor == null) {
            continue;
          }
          if (!localCursor.moveToNext()) {
            continue;
          }
          if (!TextUtils.equals(localCursor.getString(localCursor.getColumnIndex("id")), paramString)) {
            continue;
          }
          String str = localCursor.getString(localCursor.getColumnIndex("current_status"));
          b.c(c + "findGeoStatueByGeoId: geo current statue is " + str + " geoId:" + paramString);
          localCursor.close();
          paramString = str;
        }
        catch (Exception paramString)
        {
          Cursor localCursor;
          b.d(paramString.toString());
          paramString = "Unknown";
          continue;
        }
        return paramString;
      }
      finally {}
      localCursor.close();
      paramString = "Unknown";
    }
  }
  
  /* Error */
  public int d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: invokestatic 35	com/xiaomi/channel/commonutils/misc/k:a	(Z)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 384	com/xiaomi/push/service/e:a	(Ljava/lang/String;)Lcom/xiaomi/xmpush/thrift/j;
    //   11: ifnull +37 -> 48
    //   14: aload_0
    //   15: getfield 27	com/xiaomi/push/service/e:a	Lcom/xiaomi/push/service/f;
    //   18: invokevirtual 223	com/xiaomi/push/service/f:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore_3
    //   22: aload_3
    //   23: ldc -31
    //   25: ldc_w 386
    //   28: iconst_1
    //   29: anewarray 205	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: aload_1
    //   35: aastore
    //   36: invokevirtual 390	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   39: istore_2
    //   40: aload_3
    //   41: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   44: aload_0
    //   45: monitorexit
    //   46: iload_2
    //   47: ireturn
    //   48: iconst_0
    //   49: istore_2
    //   50: goto -6 -> 44
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 79	java/lang/Exception:toString	()Ljava/lang/String;
    //   58: invokestatic 85	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   61: iconst_0
    //   62: istore_2
    //   63: goto -19 -> 44
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	e
    //   0	71	1	paramString	String
    //   39	24	2	i	int
    //   21	20	3	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   6	44	53	java/lang/Exception
    //   2	6	66	finally
    //   6	44	66	finally
    //   54	61	66	finally
  }
  
  /* Error */
  public int e(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: invokestatic 35	com/xiaomi/channel/commonutils/misc/k:a	(Z)V
    //   6: aload_1
    //   7: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +37 -> 47
    //   13: aload_0
    //   14: getfield 27	com/xiaomi/push/service/e:a	Lcom/xiaomi/push/service/f;
    //   17: invokevirtual 223	com/xiaomi/push/service/f:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: astore_3
    //   21: aload_3
    //   22: ldc -31
    //   24: ldc_w 396
    //   27: iconst_1
    //   28: anewarray 205	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: aload_1
    //   34: aastore
    //   35: invokevirtual 390	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   38: istore_2
    //   39: aload_3
    //   40: invokevirtual 234	android/database/sqlite/SQLiteDatabase:close	()V
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_2
    //   46: ireturn
    //   47: iconst_0
    //   48: istore_2
    //   49: goto -6 -> 43
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 79	java/lang/Exception:toString	()Ljava/lang/String;
    //   57: invokestatic 85	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   60: iconst_0
    //   61: istore_2
    //   62: goto -19 -> 43
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	e
    //   0	70	1	paramString	String
    //   38	24	2	i	int
    //   20	20	3	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   6	43	52	java/lang/Exception
    //   2	6	65	finally
    //   6	43	65	finally
    //   53	60	65	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */