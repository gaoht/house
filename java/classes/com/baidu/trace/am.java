package com.baidu.trace;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.trace.api.fence.AlarmPoint;
import com.baidu.trace.api.fence.CircleFence;
import com.baidu.trace.api.fence.FenceAlarmInfo;
import com.baidu.trace.api.fence.FenceShape;
import com.baidu.trace.api.fence.HistoryAlarmRequest;
import com.baidu.trace.api.fence.MonitoredAction;
import com.baidu.trace.api.fence.MonitoredStatus;
import com.baidu.trace.api.fence.MonitoredStatusInfo;
import com.baidu.trace.api.track.CacheTrackInfo;
import com.baidu.trace.c.e;
import com.baidu.trace.model.CoordType;
import java.io.File;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;

public class am
  extends Thread
{
  private static u a = null;
  private static SQLiteDatabase b = null;
  private static boolean c = false;
  private static File d = null;
  private static int e = 0;
  private int f = 0;
  private String g = "";
  
  public am(int paramInt, String paramString)
  {
    this.f = paramInt;
    this.g = paramString;
  }
  
  protected static long a(Context paramContext, String paramString1, String paramString2, CoordType paramCoordType, int paramInt, FenceShape paramFenceShape, String paramString3)
  {
    long l2 = -1L;
    a(paramContext);
    if (b == null) {
      return -1L;
    }
    d();
    b.beginTransaction();
    long l1 = l2;
    try
    {
      paramContext = new ContentValues();
      l1 = l2;
      paramContext.put("fence_name", paramString1);
      l1 = l2;
      paramContext.put("monitored_person", paramString2);
      l1 = l2;
      paramContext.put("coord_type", paramCoordType.name());
      l1 = l2;
      paramContext.put("denoise", Integer.valueOf(paramInt));
      l1 = l2;
      paramContext.put("fence_shape", paramFenceShape.name());
      l1 = l2;
      paramContext.put("create_time", e.c());
      l1 = l2;
      paramContext.put("modify_time", e.c());
      l1 = l2;
      paramContext.put("monitored_status", MonitoredStatus.unknown.name());
      l1 = l2;
      paramContext.put("fence_extern_info", paramString3);
      l1 = l2;
      l2 = b.insert("trace_fence", null, paramContext);
      l1 = l2;
      b.setTransactionSuccessful();
      return l2;
    }
    catch (Exception paramContext)
    {
      return l1;
    }
    finally
    {
      b.endTransaction();
    }
  }
  
  protected static CircleFence a(Context paramContext, long paramLong)
  {
    String str1 = null;
    Object localObject2 = null;
    a(paramContext);
    Object localObject1;
    if (b == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (CircleFence)localObject1;
      localObject1 = new StringBuffer("fence_id");
      ((StringBuffer)localObject1).append(" = ? ");
      paramContext = b;
      localObject1 = ((StringBuffer)localObject1).toString();
      Cursor localCursor = paramContext.query("trace_fence", new String[] { "fence_id", "fence_name", "monitored_person", "coord_type", "denoise", "fence_shape", "fence_extern_info" }, (String)localObject1, new String[] { String.valueOf(paramLong) }, null, null, null);
      localObject1 = localObject2;
      if (localCursor == null) {
        continue;
      }
      paramContext = str1;
      if (localCursor.moveToNext())
      {
        paramLong = localCursor.getLong(0);
        paramContext = localCursor.getString(1);
        str1 = localCursor.getString(2);
        CoordType localCoordType = CoordType.valueOf(localCursor.getString(3));
        int i = localCursor.getInt(4);
        String str2 = localCursor.getString(5);
        localObject1 = localCursor.getString(6);
        if (!FenceShape.circle.name().equals(str2))
        {
          localObject1 = localObject2;
          if (localCursor == null) {
            continue;
          }
          localCursor.close();
          return null;
        }
        paramContext = CircleFence.buildLocalFence(paramLong, paramContext, str1, null, 0.0D, i, localCoordType);
      }
      try
      {
        a.a(new JSONObject((String)localObject1), paramContext);
        localObject1 = paramContext;
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        return paramContext;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
  
  protected static String a(String paramString, int paramInt, Deque<ar.a> paramDeque)
  {
    String str = null;
    if (b == null) {}
    Object localObject2;
    do
    {
      return null;
      localObject2 = new StringBuffer("select * from ");
      ((StringBuffer)localObject2).append("trace_location");
    } while (!com.baidu.trace.b.a.d());
    Object localObject1;
    if (bd.g)
    {
      ((StringBuffer)localObject2).append(" where entity_name").append(" like ?  limit 0,?;");
      localObject1 = new String[2];
      localObject1[0] = paramString;
      localObject1[1] = String.valueOf(10);
      paramString = (String)localObject1;
    }
    for (;;)
    {
      localObject1 = a;
      localObject1 = u.b(b, ((StringBuffer)localObject2).toString(), paramString);
      if (localObject1 == null) {
        break;
      }
      paramInt = ((Cursor)localObject1).getCount();
      aw.c = paramInt;
      paramString = str;
      if (paramInt == 0)
      {
        if (bd.g) {
          bd.g = false;
        }
        for (;;)
        {
          ((Cursor)localObject1).close();
          return null;
          if (!bd.h) {
            break label302;
          }
          ((StringBuffer)localObject2).append(" where entity_name").append(" like (select entity_name").append(" from trace_location").append(" limit 1) limit 0,?;");
          paramString = new String[1];
          paramString[0] = String.valueOf(10);
          break;
          if (bd.h) {
            bd.h = false;
          }
        }
      }
      while (((Cursor)localObject1).moveToNext())
      {
        long l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("loc_time"));
        str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("entity_name"));
        localObject2 = ((Cursor)localObject1).getBlob(((Cursor)localObject1).getColumnIndex("location_data"));
        paramString = str;
        if (paramDeque != null)
        {
          paramDeque.offer(new ar.a(str, (byte[])localObject2, l));
          paramString = str;
        }
      }
      ((Cursor)localObject1).close();
      return paramString;
      label302:
      paramString = null;
    }
  }
  
  protected static void a()
  {
    c = false;
    if ((a == null) && (b == null)) {
      return;
    }
    try
    {
      if (a != null)
      {
        a.close();
        a = null;
      }
      if (b != null)
      {
        b.close();
        b = null;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    d = null;
  }
  
  protected static void a(int paramInt)
  {
    if (paramInt < 50) {
      return;
    }
    e = paramInt;
  }
  
  protected static void a(long paramLong, MonitoredStatus paramMonitoredStatus)
  {
    if (b == null) {
      return;
    }
    b.beginTransaction();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("monitored_status", paramMonitoredStatus.name());
      paramMonitoredStatus = new StringBuffer("fence_id");
      paramMonitoredStatus.append(" = ? ");
      b.update("trace_fence", localContentValues, paramMonitoredStatus.toString(), new String[] { String.valueOf(paramLong) });
      b.setTransactionSuccessful();
      b.endTransaction();
      return;
    }
    catch (Exception paramMonitoredStatus)
    {
      paramMonitoredStatus = paramMonitoredStatus;
      b.endTransaction();
      return;
    }
    finally
    {
      paramMonitoredStatus = finally;
      b.endTransaction();
      throw paramMonitoredStatus;
    }
  }
  
  protected static void a(Context paramContext)
  {
    if ((paramContext == null) || ((a != null) && (b != null))) {
      return;
    }
    try
    {
      if (a == null) {
        a = new u(paramContext);
      }
      if ((b == null) && (!c))
      {
        c = true;
        new an().start();
      }
      return;
    }
    finally {}
  }
  
  protected static void a(Context paramContext, HistoryAlarmRequest paramHistoryAlarmRequest, List<FenceAlarmInfo> paramList)
  {
    a(paramContext);
    if (b == null) {}
    Object localObject1;
    Object localObject2;
    Object localObject3;
    do
    {
      return;
      localObject1 = new ArrayList();
      localObject2 = paramHistoryAlarmRequest.getMonitoredPerson();
      paramContext = new StringBuffer();
      if (e.a((String)localObject2))
      {
        paramContext.append("monitored_person like ? ");
        ((List)localObject1).add(localObject2);
      }
      localObject2 = paramHistoryAlarmRequest.getFenceIds();
      if (paramHistoryAlarmRequest.getStartTime() > 0L)
      {
        paramContext.append(" and create_time").append(" >= ? ");
        ((List)localObject1).add(String.valueOf(paramHistoryAlarmRequest.getStartTime()));
      }
      if (paramHistoryAlarmRequest.getEndTime() > 0L)
      {
        paramContext.append(" and create_time").append(" <= ? ");
        ((List)localObject1).add(String.valueOf(paramHistoryAlarmRequest.getEndTime()));
      }
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        localObject3 = new StringBuffer();
        int i = 0;
        while (i < ((List)localObject2).size())
        {
          ((StringBuffer)localObject3).append('?').append(',');
          ((List)localObject1).add(String.valueOf(((List)localObject2).get(i)));
          i += 1;
        }
        ((StringBuffer)localObject3).deleteCharAt(((StringBuffer)localObject3).length() - 1);
        paramContext.append(" and fence_id").append(" in( ").append(((StringBuffer)localObject3).toString()).append(")");
      }
      localObject2 = new String[((List)localObject1).size()];
      ((List)localObject1).toArray((Object[])localObject2);
      localObject1 = b;
      paramContext = paramContext.toString();
      paramContext = ((SQLiteDatabase)localObject1).query("trace_fence_alarm", new String[] { "fence_id", "fence_name", "monitored_person", "monitored_action", "cur_point", "pre_point" }, paramContext, (String[])localObject2, null, null, null);
    } while (paramContext == null);
    for (;;)
    {
      long l;
      String str1;
      String str2;
      AlarmPoint localAlarmPoint1;
      AlarmPoint localAlarmPoint2;
      if (paramContext.moveToNext())
      {
        l = paramContext.getLong(0);
        localObject1 = paramContext.getString(1);
        localObject2 = paramContext.getString(2);
        if (paramHistoryAlarmRequest.getMonitoredPerson().equals(localObject2))
        {
          localObject3 = MonitoredAction.valueOf(paramContext.getString(3));
          str1 = paramContext.getString(4);
          str2 = paramContext.getString(5);
          localAlarmPoint1 = new AlarmPoint();
          localAlarmPoint2 = new AlarmPoint();
        }
      }
      else
      {
        try
        {
          a.a(new JSONObject(str1), CoordType.bd09ll, localAlarmPoint1, String.class);
          a.a(new JSONObject(str2), CoordType.bd09ll, localAlarmPoint2, String.class);
          paramList.add(new FenceAlarmInfo(l, (String)localObject1, (String)localObject2, (MonitoredAction)localObject3, localAlarmPoint1, localAlarmPoint2));
        }
        catch (JSONException localJSONException) {}
        if (paramContext == null) {
          break;
        }
        paramContext.close();
        return;
      }
    }
  }
  
  /* Error */
  protected static void a(Context paramContext, String paramString, List<Long> paramList, List<com.baidu.trace.api.fence.FenceInfo> paramList1)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 48	com/baidu/trace/am:a	(Landroid/content/Context;)V
    //   4: getstatic 23	com/baidu/trace/am:b	Landroid/database/sqlite/SQLiteDatabase;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: new 127	java/lang/StringBuffer
    //   14: dup
    //   15: invokespecial 289	java/lang/StringBuffer:<init>	()V
    //   18: astore 7
    //   20: aconst_null
    //   21: astore_0
    //   22: aload_2
    //   23: ifnull +429 -> 452
    //   26: aload_2
    //   27: invokeinterface 319 1 0
    //   32: ifne +420 -> 452
    //   35: new 127	java/lang/StringBuffer
    //   38: dup
    //   39: invokespecial 289	java/lang/StringBuffer:<init>	()V
    //   42: astore 8
    //   44: aload_1
    //   45: invokestatic 292	com/baidu/trace/c/e:a	(Ljava/lang/String;)Z
    //   48: ifeq +66 -> 114
    //   51: aload_2
    //   52: invokeinterface 322 1 0
    //   57: iconst_1
    //   58: iadd
    //   59: anewarray 143	java/lang/String
    //   62: astore_0
    //   63: iconst_0
    //   64: istore 4
    //   66: iload 4
    //   68: aload_2
    //   69: invokeinterface 322 1 0
    //   74: if_icmpge +53 -> 127
    //   77: aload 8
    //   79: bipush 63
    //   81: invokevirtual 325	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   84: bipush 44
    //   86: invokevirtual 325	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   89: pop
    //   90: aload_0
    //   91: iload 4
    //   93: aload_2
    //   94: iload 4
    //   96: invokeinterface 329 2 0
    //   101: invokestatic 332	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   104: aastore
    //   105: iload 4
    //   107: iconst_1
    //   108: iadd
    //   109: istore 4
    //   111: goto -45 -> 66
    //   114: aload_2
    //   115: invokeinterface 322 1 0
    //   120: anewarray 143	java/lang/String
    //   123: astore_0
    //   124: goto -61 -> 63
    //   127: aload 8
    //   129: aload 8
    //   131: invokevirtual 335	java/lang/StringBuffer:length	()I
    //   134: iconst_1
    //   135: isub
    //   136: invokevirtual 339	java/lang/StringBuffer:deleteCharAt	(I)Ljava/lang/StringBuffer;
    //   139: pop
    //   140: aload 7
    //   142: ldc_w 381
    //   145: invokevirtual 138	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   148: aload 8
    //   150: invokevirtual 141	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   153: invokevirtual 138	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   156: ldc_w 345
    //   159: invokevirtual 138	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   162: pop
    //   163: aload_1
    //   164: invokestatic 292	com/baidu/trace/c/e:a	(Ljava/lang/String;)Z
    //   167: ifeq +28 -> 195
    //   170: aload 7
    //   172: ldc_w 383
    //   175: invokevirtual 138	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   178: pop
    //   179: aload 7
    //   181: ldc_w 294
    //   184: invokevirtual 138	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   187: pop
    //   188: aload_0
    //   189: aload_0
    //   190: arraylength
    //   191: iconst_1
    //   192: isub
    //   193: aload_1
    //   194: aastore
    //   195: getstatic 23	com/baidu/trace/am:b	Landroid/database/sqlite/SQLiteDatabase;
    //   198: astore_1
    //   199: aload 7
    //   201: invokevirtual 141	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   204: astore_2
    //   205: aload_1
    //   206: ldc 111
    //   208: bipush 9
    //   210: anewarray 143	java/lang/String
    //   213: dup
    //   214: iconst_0
    //   215: ldc -127
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: ldc 60
    //   222: aastore
    //   223: dup
    //   224: iconst_2
    //   225: ldc 66
    //   227: aastore
    //   228: dup
    //   229: iconst_3
    //   230: ldc 68
    //   232: aastore
    //   233: dup
    //   234: iconst_4
    //   235: ldc 76
    //   237: aastore
    //   238: dup
    //   239: iconst_5
    //   240: ldc 87
    //   242: aastore
    //   243: dup
    //   244: bipush 6
    //   246: ldc 92
    //   248: aastore
    //   249: dup
    //   250: bipush 7
    //   252: ldc 98
    //   254: aastore
    //   255: dup
    //   256: bipush 8
    //   258: ldc 109
    //   260: aastore
    //   261: aload_2
    //   262: aload_0
    //   263: aconst_null
    //   264: aconst_null
    //   265: aconst_null
    //   266: invokevirtual 150	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   269: astore_0
    //   270: aload_0
    //   271: ifnull -261 -> 10
    //   274: aload_0
    //   275: invokeinterface 156 1 0
    //   280: ifeq +200 -> 480
    //   283: aload_0
    //   284: iconst_0
    //   285: invokeinterface 160 2 0
    //   290: lstore 5
    //   292: aload_0
    //   293: iconst_1
    //   294: invokeinterface 164 2 0
    //   299: astore 8
    //   301: aload_0
    //   302: iconst_2
    //   303: invokeinterface 164 2 0
    //   308: astore 9
    //   310: aload_0
    //   311: iconst_3
    //   312: invokeinterface 164 2 0
    //   317: invokestatic 167	com/baidu/trace/model/CoordType:valueOf	(Ljava/lang/String;)Lcom/baidu/trace/model/CoordType;
    //   320: astore 10
    //   322: aload_0
    //   323: iconst_4
    //   324: invokeinterface 171 2 0
    //   329: istore 4
    //   331: aload_0
    //   332: iconst_5
    //   333: invokeinterface 164 2 0
    //   338: astore 11
    //   340: aload_0
    //   341: bipush 6
    //   343: invokeinterface 164 2 0
    //   348: astore_1
    //   349: aload_0
    //   350: bipush 7
    //   352: invokeinterface 164 2 0
    //   357: astore_2
    //   358: new 190	org/json/JSONObject
    //   361: dup
    //   362: aload_0
    //   363: bipush 8
    //   365: invokeinterface 164 2 0
    //   370: invokespecial 191	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   373: astore 7
    //   375: getstatic 175	com/baidu/trace/api/fence/FenceShape:circle	Lcom/baidu/trace/api/fence/FenceShape;
    //   378: invokevirtual 90	com/baidu/trace/api/fence/FenceShape:name	()Ljava/lang/String;
    //   381: aload 11
    //   383: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   386: ifeq -112 -> 274
    //   389: lload 5
    //   391: aload 8
    //   393: aload 9
    //   395: aconst_null
    //   396: dconst_0
    //   397: iload 4
    //   399: aload 10
    //   401: invokestatic 188	com/baidu/trace/api/fence/CircleFence:buildLocalFence	(JLjava/lang/String;Ljava/lang/String;Lcom/baidu/trace/model/LatLng;DILcom/baidu/trace/model/CoordType;)Lcom/baidu/trace/api/fence/CircleFence;
    //   404: astore 8
    //   406: aload 7
    //   408: aload 8
    //   410: invokestatic 196	com/baidu/trace/a:a	(Lorg/json/JSONObject;Lcom/baidu/trace/api/fence/CircleFence;)V
    //   413: aload_3
    //   414: new 385	com/baidu/trace/api/fence/FenceInfo
    //   417: dup
    //   418: getstatic 175	com/baidu/trace/api/fence/FenceShape:circle	Lcom/baidu/trace/api/fence/FenceShape;
    //   421: aload 8
    //   423: aconst_null
    //   424: aconst_null
    //   425: aconst_null
    //   426: aload_1
    //   427: aload_2
    //   428: invokespecial 388	com/baidu/trace/api/fence/FenceInfo:<init>	(Lcom/baidu/trace/api/fence/FenceShape;Lcom/baidu/trace/api/fence/CircleFence;Lcom/baidu/trace/api/fence/PolygonFence;Lcom/baidu/trace/api/fence/PolylineFence;Lcom/baidu/trace/api/fence/DistrictFence;Ljava/lang/String;Ljava/lang/String;)V
    //   431: invokeinterface 299 2 0
    //   436: pop
    //   437: goto -163 -> 274
    //   440: astore_1
    //   441: aload_0
    //   442: ifnull -432 -> 10
    //   445: aload_0
    //   446: invokeinterface 182 1 0
    //   451: return
    //   452: aload_1
    //   453: invokestatic 292	com/baidu/trace/c/e:a	(Ljava/lang/String;)Z
    //   456: ifeq -261 -> 195
    //   459: iconst_1
    //   460: anewarray 143	java/lang/String
    //   463: astore_0
    //   464: aload_0
    //   465: iconst_0
    //   466: aload_1
    //   467: aastore
    //   468: aload 7
    //   470: ldc_w 294
    //   473: invokevirtual 138	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   476: pop
    //   477: goto -282 -> 195
    //   480: aload_0
    //   481: ifnull -471 -> 10
    //   484: aload_0
    //   485: invokeinterface 182 1 0
    //   490: return
    //   491: astore_1
    //   492: aload_0
    //   493: ifnull +9 -> 502
    //   496: aload_0
    //   497: invokeinterface 182 1 0
    //   502: aload_1
    //   503: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	paramContext	Context
    //   0	504	1	paramString	String
    //   0	504	2	paramList	List<Long>
    //   0	504	3	paramList1	List<com.baidu.trace.api.fence.FenceInfo>
    //   64	334	4	i	int
    //   290	100	5	l	long
    //   18	451	7	localObject1	Object
    //   42	380	8	localObject2	Object
    //   308	86	9	str1	String
    //   320	80	10	localCoordType	CoordType
    //   338	44	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   274	437	440	java/lang/Exception
    //   274	437	491	finally
  }
  
  /* Error */
  protected static void a(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 48	com/baidu/trace/am:a	(Landroid/content/Context;)V
    //   4: getstatic 23	com/baidu/trace/am:b	Landroid/database/sqlite/SQLiteDatabase;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: getstatic 23	com/baidu/trace/am:b	Landroid/database/sqlite/SQLiteDatabase;
    //   14: ldc 111
    //   16: bipush 8
    //   18: anewarray 143	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: ldc -127
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: ldc 60
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: ldc 66
    //   35: aastore
    //   36: dup
    //   37: iconst_3
    //   38: ldc 68
    //   40: aastore
    //   41: dup
    //   42: iconst_4
    //   43: ldc 76
    //   45: aastore
    //   46: dup
    //   47: iconst_5
    //   48: ldc 87
    //   50: aastore
    //   51: dup
    //   52: bipush 6
    //   54: ldc 100
    //   56: aastore
    //   57: dup
    //   58: bipush 7
    //   60: ldc 109
    //   62: aastore
    //   63: aconst_null
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: invokevirtual 150	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore_0
    //   72: aload_0
    //   73: ifnull -63 -> 10
    //   76: aload_0
    //   77: invokeinterface 156 1 0
    //   82: ifeq +170 -> 252
    //   85: aload_0
    //   86: iconst_0
    //   87: invokeinterface 160 2 0
    //   92: lstore 4
    //   94: aload_0
    //   95: iconst_1
    //   96: invokeinterface 164 2 0
    //   101: astore_2
    //   102: aload_0
    //   103: iconst_2
    //   104: invokeinterface 164 2 0
    //   109: astore 6
    //   111: aload_0
    //   112: iconst_3
    //   113: invokeinterface 164 2 0
    //   118: invokestatic 167	com/baidu/trace/model/CoordType:valueOf	(Ljava/lang/String;)Lcom/baidu/trace/model/CoordType;
    //   121: astore 7
    //   123: aload_0
    //   124: iconst_4
    //   125: invokeinterface 171 2 0
    //   130: istore_3
    //   131: aload_0
    //   132: iconst_5
    //   133: invokeinterface 164 2 0
    //   138: astore 8
    //   140: aload_0
    //   141: bipush 6
    //   143: invokeinterface 164 2 0
    //   148: invokestatic 393	com/baidu/trace/api/fence/MonitoredStatus:valueOf	(Ljava/lang/String;)Lcom/baidu/trace/api/fence/MonitoredStatus;
    //   151: astore_1
    //   152: aload_0
    //   153: bipush 7
    //   155: invokeinterface 164 2 0
    //   160: astore 9
    //   162: getstatic 175	com/baidu/trace/api/fence/FenceShape:circle	Lcom/baidu/trace/api/fence/FenceShape;
    //   165: invokevirtual 90	com/baidu/trace/api/fence/FenceShape:name	()Ljava/lang/String;
    //   168: aload 8
    //   170: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifeq -97 -> 76
    //   176: new 190	org/json/JSONObject
    //   179: dup
    //   180: aload 9
    //   182: invokespecial 191	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   185: astore 8
    //   187: lload 4
    //   189: aload_2
    //   190: aload 6
    //   192: aconst_null
    //   193: dconst_0
    //   194: iload_3
    //   195: aload 7
    //   197: invokestatic 188	com/baidu/trace/api/fence/CircleFence:buildLocalFence	(JLjava/lang/String;Ljava/lang/String;Lcom/baidu/trace/model/LatLng;DILcom/baidu/trace/model/CoordType;)Lcom/baidu/trace/api/fence/CircleFence;
    //   200: astore_2
    //   201: aload 8
    //   203: aload_2
    //   204: invokestatic 196	com/baidu/trace/a:a	(Lorg/json/JSONObject;Lcom/baidu/trace/api/fence/CircleFence;)V
    //   207: getstatic 398	com/baidu/trace/ar:a	Lcom/baidu/trace/aj;
    //   210: lload 4
    //   212: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   215: invokevirtual 406	java/lang/Long:longValue	()J
    //   218: aload_2
    //   219: invokevirtual 411	com/baidu/trace/aj:a	(JLcom/baidu/trace/api/fence/Fence;)V
    //   222: getstatic 398	com/baidu/trace/ar:a	Lcom/baidu/trace/aj;
    //   225: lload 4
    //   227: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   230: invokevirtual 406	java/lang/Long:longValue	()J
    //   233: aload_1
    //   234: invokevirtual 413	com/baidu/trace/aj:a	(JLcom/baidu/trace/api/fence/MonitoredStatus;)V
    //   237: goto -161 -> 76
    //   240: astore_1
    //   241: aload_0
    //   242: ifnull -232 -> 10
    //   245: aload_0
    //   246: invokeinterface 182 1 0
    //   251: return
    //   252: aload_0
    //   253: ifnull -243 -> 10
    //   256: aload_0
    //   257: invokeinterface 182 1 0
    //   262: return
    //   263: astore_1
    //   264: aload_0
    //   265: ifnull +9 -> 274
    //   268: aload_0
    //   269: invokeinterface 182 1 0
    //   274: aload_1
    //   275: athrow
    //   276: astore_0
    //   277: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramContext	Context
    //   0	278	1	paramString	String
    //   0	278	2	paramArrayOfString	String[]
    //   130	65	3	i	int
    //   92	134	4	l	long
    //   109	82	6	str1	String
    //   121	75	7	localCoordType	CoordType
    //   138	64	8	localObject	Object
    //   160	21	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   76	237	240	java/lang/Exception
    //   76	237	263	finally
    //   11	72	276	java/lang/Exception
  }
  
  protected static void a(Context paramContext, List<Long> paramList, String paramString, List<MonitoredStatusInfo> paramList1)
  {
    a(paramContext);
    if (b == null) {}
    do
    {
      do
      {
        return;
        ArrayList localArrayList = new ArrayList();
        paramContext = new StringBuffer("monitored_person");
        paramContext.append(" like ? ");
        localArrayList.add(paramString);
        if ((paramList != null) && (!paramList.isEmpty()))
        {
          paramString = new StringBuffer();
          int i = 0;
          while (i < paramList.size())
          {
            paramString.append('?').append(',');
            localArrayList.add(String.valueOf(paramList.get(i)));
            i += 1;
          }
          paramString.deleteCharAt(paramString.length() - 1);
          paramContext.append(" and fence_id").append(" in( ").append(paramString.toString()).append(")");
        }
        paramList = new String[localArrayList.size()];
        localArrayList.toArray(paramList);
        paramString = b;
        paramContext = paramContext.toString();
        paramContext = paramString.query("trace_fence", new String[] { "fence_id", "monitored_status" }, paramContext, paramList, null, null, null);
      } while (paramContext == null);
      while (paramContext.moveToNext())
      {
        paramList = new MonitoredStatusInfo();
        paramList.setFenceId(paramContext.getLong(0));
        if (e.a(paramContext.getString(1))) {
          paramList.setMonitoredStatus(MonitoredStatus.valueOf(paramContext.getString(1)));
        }
        paramList1.add(paramList);
      }
    } while (paramContext == null);
    paramContext.close();
  }
  
  protected static void a(CircleFence paramCircleFence, MonitoredAction paramMonitoredAction, String paramString1, String paramString2)
  {
    if (b == null) {
      return;
    }
    d();
    b.beginTransaction();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("fence_id", Long.valueOf(paramCircleFence.getFenceId()));
      localContentValues.put("fence_name", paramCircleFence.getFenceName());
      localContentValues.put("monitored_person", paramCircleFence.getMonitoredPerson());
      localContentValues.put("monitored_action", paramMonitoredAction.name());
      localContentValues.put("create_time", Long.valueOf(e.b()));
      localContentValues.put("cur_point", paramString1);
      localContentValues.put("pre_point", paramString2);
      b.insert("trace_fence_alarm", null, localContentValues);
      b.setTransactionSuccessful();
      b.endTransaction();
      return;
    }
    catch (Exception paramCircleFence)
    {
      paramCircleFence = paramCircleFence;
      b.endTransaction();
      return;
    }
    finally
    {
      paramCircleFence = finally;
      b.endTransaction();
      throw paramCircleFence;
    }
  }
  
  private static void a(String paramString)
  {
    if (b == null) {}
    Object localObject;
    do
    {
      return;
      localObject = new StringBuilder("select distinct ");
      ((StringBuilder)localObject).append("entity_name from ").append("trace_location");
      u localu = a;
      localObject = u.b(b, ((StringBuilder)localObject).toString(), null);
    } while (localObject == null);
    if (((Cursor)localObject).getCount() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      bd.h = bool;
      while (((Cursor)localObject).moveToNext()) {
        if (paramString.equals(((Cursor)localObject).getString(0))) {
          bd.g = true;
        }
      }
      ((Cursor)localObject).close();
      return;
    }
  }
  
  protected static void a(String paramString, int paramInt)
  {
    if (b == null) {
      return;
    }
    b.beginTransaction();
    try
    {
      StringBuffer localStringBuffer = new StringBuffer("delete from ");
      localStringBuffer.append("trace_location where rowid in(select rowid from ").append("trace_location where ").append("entity_name like ? limit 0,?);");
      u localu = a;
      u.a(b, localStringBuffer.toString(), new String[] { paramString, String.valueOf(paramInt) });
      b.setTransactionSuccessful();
      b.endTransaction();
      return;
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      b.endTransaction();
      return;
    }
    finally
    {
      paramString = finally;
      b.endTransaction();
      throw paramString;
    }
  }
  
  /* Error */
  private static void a(Queue<ar.a> paramQueue)
  {
    // Byte code:
    //   0: getstatic 23	com/baidu/trace/am:b	Landroid/database/sqlite/SQLiteDatabase;
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: invokestatic 50	com/baidu/trace/am:d	()V
    //   10: getstatic 23	com/baidu/trace/am:b	Landroid/database/sqlite/SQLiteDatabase;
    //   13: invokevirtual 55	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   16: aload_0
    //   17: invokeinterface 472 1 0
    //   22: astore_0
    //   23: aload_0
    //   24: invokeinterface 477 1 0
    //   29: ifeq +119 -> 148
    //   32: aload_0
    //   33: invokeinterface 481 1 0
    //   38: checkcast 253	com/baidu/trace/ar$a
    //   41: astore 5
    //   43: new 127	java/lang/StringBuffer
    //   46: dup
    //   47: ldc_w 483
    //   50: invokespecial 132	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   53: astore_3
    //   54: aload_3
    //   55: ldc_w 485
    //   58: invokevirtual 138	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   61: ldc_w 487
    //   64: invokevirtual 138	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   67: ldc_w 489
    //   70: invokevirtual 138	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   73: ldc_w 491
    //   76: invokevirtual 138	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   79: pop
    //   80: aload 5
    //   82: getfield 494	com/baidu/trace/ar$a:c	J
    //   85: lstore_1
    //   86: aload 5
    //   88: getfield 496	com/baidu/trace/ar$a:a	Ljava/lang/String;
    //   91: astore 4
    //   93: aload 5
    //   95: getfield 499	com/baidu/trace/ar$a:b	[B
    //   98: astore 5
    //   100: getstatic 23	com/baidu/trace/am:b	Landroid/database/sqlite/SQLiteDatabase;
    //   103: aload_3
    //   104: invokevirtual 141	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   107: iconst_3
    //   108: anewarray 501	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: lload_1
    //   114: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload 4
    //   122: aastore
    //   123: dup
    //   124: iconst_2
    //   125: aload 5
    //   127: aastore
    //   128: invokevirtual 505	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_0
    //   132: invokeinterface 508 1 0
    //   137: goto -114 -> 23
    //   140: astore_0
    //   141: getstatic 23	com/baidu/trace/am:b	Landroid/database/sqlite/SQLiteDatabase;
    //   144: invokevirtual 121	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   147: return
    //   148: getstatic 23	com/baidu/trace/am:b	Landroid/database/sqlite/SQLiteDatabase;
    //   151: invokevirtual 118	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   154: getstatic 23	com/baidu/trace/am:b	Landroid/database/sqlite/SQLiteDatabase;
    //   157: invokevirtual 121	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   160: return
    //   161: astore_0
    //   162: getstatic 23	com/baidu/trace/am:b	Landroid/database/sqlite/SQLiteDatabase;
    //   165: invokevirtual 121	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   168: aload_0
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramQueue	Queue<ar.a>
    //   85	29	1	l	long
    //   53	51	3	localStringBuffer	StringBuffer
    //   91	30	4	str	String
    //   41	85	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	23	140	java/lang/Exception
    //   23	137	140	java/lang/Exception
    //   148	154	140	java/lang/Exception
    //   16	23	161	finally
    //   23	137	161	finally
    //   148	154	161	finally
  }
  
  protected static void a(boolean paramBoolean)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((!bd.g) && (aw.a != null) && (!aw.a.isEmpty()))
    {
      localLinkedList.addAll(aw.a);
      aw.a.removeAll(localLinkedList);
    }
    if (bd.c != null)
    {
      localLinkedList.addAll(bd.c);
      bd.c.removeAll(localLinkedList);
    }
    if ((localLinkedList != null) && (!localLinkedList.isEmpty())) {
      a(localLinkedList);
    }
    localLinkedList.clear();
    if (paramBoolean) {
      a();
    }
  }
  
  protected static boolean a(Context paramContext, long paramLong, String paramString)
  {
    a(paramContext);
    if (b == null) {}
    for (;;)
    {
      return false;
      b.beginTransaction();
      try
      {
        paramContext = new StringBuffer();
        paramContext.append("fence_id = ? ");
        paramContext.append(" and ");
        paramContext.append("monitored_person like ? ");
        i = b.delete("trace_fence", paramContext.toString(), new String[] { String.valueOf(paramLong), paramString });
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext = paramContext;
          int i = 0;
          b.endTransaction();
        }
      }
      finally
      {
        b.endTransaction();
      }
    }
  }
  
  protected static boolean a(Context paramContext, long paramLong, String paramString1, String paramString2, CoordType paramCoordType, int paramInt, FenceShape paramFenceShape, String paramString3)
  {
    a(paramContext);
    if (b == null) {}
    for (;;)
    {
      return false;
      b.beginTransaction();
      try
      {
        paramContext = new ContentValues();
        paramContext.put("fence_name", paramString1);
        paramContext.put("monitored_person", paramString2);
        paramContext.put("coord_type", paramCoordType.name());
        paramContext.put("denoise", Integer.valueOf(paramInt));
        paramContext.put("fence_shape", paramFenceShape.name());
        paramContext.put("fence_extern_info", paramString3);
        paramContext.put("modify_time", e.c());
        paramString1 = new StringBuffer("fence_id");
        paramString1.append(" = ? ");
        paramInt = b.update("trace_fence", paramContext, paramString1.toString(), new String[] { String.valueOf(paramLong) });
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext = paramContext;
          paramInt = 0;
          b.endTransaction();
        }
      }
      finally
      {
        b.endTransaction();
      }
    }
  }
  
  protected static boolean a(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer = null;
    a(paramContext);
    if (b == null) {
      return false;
    }
    b.beginTransaction();
    for (;;)
    {
      try
      {
        if (e.a(paramString))
        {
          localStringBuffer = new StringBuffer("monitored_person");
          localStringBuffer.append(" like ? ");
          paramContext = new String[1];
          paramContext[0] = paramString;
          paramString = localStringBuffer.toString();
          b.delete("trace_fence", paramString, paramContext);
          b.setTransactionSuccessful();
          return true;
        }
      }
      catch (Exception paramContext)
      {
        return false;
      }
      finally
      {
        b.endTransaction();
      }
      paramString = null;
      paramContext = localStringBuffer;
    }
  }
  
  protected static boolean a(Context paramContext, String paramString, List<CacheTrackInfo> paramList)
  {
    a(paramContext);
    if (b == null) {
      return false;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("select entity_name").append(", count(*), min(loc_time").append("), max(loc_time").append(") from trace_location");
    paramContext = null;
    if (e.a(paramString))
    {
      localStringBuffer.append(" where entity_name").append(" like ? ");
      paramContext = new String[1];
      paramContext[0] = paramString;
    }
    for (;;)
    {
      paramContext = b.rawQuery(localStringBuffer.toString(), paramContext);
      if (paramContext != null) {
        break;
      }
      return true;
      localStringBuffer.append(" group by entity_name");
    }
    while (paramContext.moveToNext()) {
      if (e.a(paramContext.getString(0))) {
        paramList.add(new CacheTrackInfo(paramContext.getString(0), paramContext.getInt(1), paramContext.getLong(2), paramContext.getLong(3)));
      } else if (e.a(paramString)) {
        paramList.add(new CacheTrackInfo(paramString, paramContext.getInt(1), paramContext.getLong(2), paramContext.getLong(3)));
      }
    }
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  protected static boolean a(Context paramContext, List<String> paramList, List<CacheTrackInfo> paramList1)
  {
    a(paramContext);
    if (b == null) {
      return false;
    }
    b.beginTransaction();
    if (paramList1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        int j;
        if (!paramList1.isEmpty())
        {
          paramContext = paramList1.iterator();
          if (!paramContext.hasNext()) {
            break label355;
          }
          paramList = (CacheTrackInfo)paramContext.next();
          paramList1 = new StringBuffer();
          Object localObject = paramList.getEntityName();
          long l1 = paramList.getStartTime();
          long l2 = paramList.getEndTime();
          paramList = new ArrayList();
          if (!e.a((String)localObject)) {
            continue;
          }
          i = 1;
          paramList1.append("entity_name like ? ");
          paramList.add(localObject);
          if (l1 > 0L)
          {
            i = 2;
            paramList1.append(" and loc_time").append(" >= ? ");
            paramList.add(String.valueOf(l1));
          }
          j = i;
          if (l2 > 0L)
          {
            j = i + 1;
            paramList1.append(" and loc_time").append(" <= ? ");
            paramList.add(String.valueOf(l2));
          }
          paramList1 = paramList1.toString();
          localObject = new String[j];
          paramList.toArray((Object[])localObject);
          b.delete("trace_location", paramList1, (String[])localObject);
          paramList.clear();
          continue;
        }
        paramContext = paramContext.toString();
      }
      catch (Exception paramContext)
      {
        return false;
        if ((paramList == null) || (paramList.isEmpty())) {
          break label369;
        }
        paramContext = new StringBuffer();
        j = paramList.size();
        i = 0;
        if (i < j) {
          if (i < j - 1) {
            paramContext.append("entity_name like ? or ");
          } else {
            paramContext.append("entity_name like ? ");
          }
        }
      }
      finally
      {
        b.endTransaction();
      }
      paramList1 = new String[paramList.size()];
      paramList.toArray(paramList1);
      b.delete("trace_location", paramContext, paramList1);
      for (;;)
      {
        label355:
        b.setTransactionSuccessful();
        b.endTransaction();
        return true;
        label369:
        b.delete("trace_location", null, null);
      }
      i += 1;
    }
  }
  
  private static void d()
  {
    if ((b == null) || (e < 50)) {}
    long l;
    do
    {
      return;
      if (d == null) {
        d = new File(b.getPath());
      }
      l = e();
    } while ((l <= 0L) || (l / 1048576L <= e) || (b == null));
    b.beginTransaction();
    try
    {
      StringBuffer localStringBuffer = new StringBuffer("delete from ");
      localStringBuffer.append("trace_location where rowid in(select rowid from ").append("trace_location limit 0,?);");
      u localu = a;
      u.a(b, localStringBuffer.toString(), new String[] { String.valueOf(1000) });
      b.setTransactionSuccessful();
      b.endTransaction();
      return;
    }
    catch (Exception localException)
    {
      localException = localException;
      b.endTransaction();
      return;
    }
    finally
    {
      localObject = finally;
      b.endTransaction();
      throw ((Throwable)localObject);
    }
  }
  
  private static long e()
  {
    if (b == null) {
      return 0L;
    }
    try
    {
      if (d == null) {
        d = new File(b.getPath());
      }
      long l = d.length();
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public void run()
  {
    switch (this.f)
    {
    default: 
      return;
    case 0: 
      Object localObject4 = this.g;
      if (b == null) {}
      for (;;)
      {
        a(this.g);
        if (b == null) {
          break;
        }
        b.beginTransaction();
        try
        {
          localObject1 = new StringBuffer("create_time");
          ((StringBuffer)localObject1).append(" < ? ");
          long l = e.b();
          b.delete("trace_fence_alarm", ((StringBuffer)localObject1).toString(), new String[] { String.valueOf(l - 604800L) });
          b.setTransactionSuccessful();
          b.endTransaction();
          return;
        }
        catch (Exception localException2)
        {
          Object localObject1;
          localException2 = localException2;
          b.endTransaction();
          return;
        }
        finally
        {
          localObject3 = finally;
          b.endTransaction();
          throw ((Throwable)localObject3);
        }
        b.beginTransaction();
        try
        {
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("entity_name", (String)localObject4);
          StringBuffer localStringBuffer = new StringBuffer("entity_name");
          localStringBuffer.append(" like ? ");
          localObject1 = new String[1];
          localObject1[0] = "";
          b.update("trace_location", localContentValues, localStringBuffer.toString(), (String[])localObject1);
          localContentValues = new ContentValues();
          localContentValues.put("monitored_person", (String)localObject4);
          localObject4 = new StringBuffer("monitored_person");
          ((StringBuffer)localObject4).append(" like ? ");
          b.update("trace_fence", localContentValues, ((StringBuffer)localObject4).toString(), (String[])localObject1);
          b.setTransactionSuccessful();
          b.endTransaction();
        }
        catch (Exception localException1)
        {
          b.endTransaction();
        }
        finally
        {
          b.endTransaction();
        }
      }
    }
    a(null, null, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */