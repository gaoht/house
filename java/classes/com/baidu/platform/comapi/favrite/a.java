package com.baidu.platform.comapi.favrite;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.inner.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static a b = null;
  private com.baidu.platform.comjni.map.favorite.a a = null;
  private boolean c = false;
  private boolean d = false;
  private Vector<String> e = null;
  private Vector<String> f = null;
  private boolean g = false;
  private c h = new c(null);
  private b i = new b(null);
  
  public static a a()
  {
    if (b == null) {}
    try
    {
      if (b == null)
      {
        b = new a();
        b.h();
      }
      return b;
    }
    finally {}
  }
  
  public static boolean g()
  {
    return (b != null) && (b.a != null) && (b.a.d());
  }
  
  private boolean h()
  {
    boolean bool = true;
    if (this.a == null)
    {
      this.a = new com.baidu.platform.comjni.map.favorite.a();
      if (this.a.a() == 0L)
      {
        this.a = null;
        bool = false;
      }
    }
    else
    {
      return bool;
    }
    j();
    i();
    return true;
  }
  
  private boolean i()
  {
    if (this.a == null) {
      return false;
    }
    String str = SysOSUtil.getModuleFileName() + "/";
    this.a.a(1);
    return this.a.a(str, "fav_poi", "fifo", 10, 501, -1);
  }
  
  private void j()
  {
    this.c = false;
    this.d = false;
  }
  
  /* Error */
  public int a(String paramString, FavSyncPoi paramFavSyncPoi)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/baidu/platform/comapi/favrite/a:a	Lcom/baidu/platform/comjni/map/favorite/a;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +9 -> 19
    //   13: iconst_0
    //   14: istore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_3
    //   18: ireturn
    //   19: aload_1
    //   20: ifnull +401 -> 421
    //   23: aload_1
    //   24: ldc 107
    //   26: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifne +392 -> 421
    //   32: aload_2
    //   33: ifnonnull +6 -> 39
    //   36: goto +385 -> 421
    //   39: aload_0
    //   40: invokespecial 72	com/baidu/platform/comapi/favrite/a:j	()V
    //   43: aload_0
    //   44: invokevirtual 116	com/baidu/platform/comapi/favrite/a:e	()Ljava/util/ArrayList;
    //   47: astore 4
    //   49: aload 4
    //   51: ifnull +365 -> 416
    //   54: aload 4
    //   56: invokevirtual 122	java/util/ArrayList:size	()I
    //   59: istore_3
    //   60: goto +366 -> 426
    //   63: aload 4
    //   65: ifnull +66 -> 131
    //   68: aload 4
    //   70: invokevirtual 122	java/util/ArrayList:size	()I
    //   73: ifle +58 -> 131
    //   76: aload 4
    //   78: invokevirtual 126	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   81: astore 4
    //   83: aload 4
    //   85: invokeinterface 131 1 0
    //   90: ifeq +41 -> 131
    //   93: aload_0
    //   94: aload 4
    //   96: invokeinterface 135 1 0
    //   101: checkcast 109	java/lang/String
    //   104: invokevirtual 138	com/baidu/platform/comapi/favrite/a:b	(Ljava/lang/String;)Lcom/baidu/platform/comapi/favrite/FavSyncPoi;
    //   107: astore 5
    //   109: aload 5
    //   111: ifnull -28 -> 83
    //   114: aload_1
    //   115: aload 5
    //   117: getfield 143	com/baidu/platform/comapi/favrite/FavSyncPoi:b	Ljava/lang/String;
    //   120: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifeq -40 -> 83
    //   126: iconst_m1
    //   127: istore_3
    //   128: goto -113 -> 15
    //   131: new 145	org/json/JSONObject
    //   134: dup
    //   135: invokespecial 146	org/json/JSONObject:<init>	()V
    //   138: astore 4
    //   140: aload_2
    //   141: aload_1
    //   142: putfield 143	com/baidu/platform/comapi/favrite/FavSyncPoi:b	Ljava/lang/String;
    //   145: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   148: invokestatic 155	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   151: astore 5
    //   153: new 76	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   160: aload 5
    //   162: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc -99
    //   167: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_2
    //   171: invokevirtual 160	java/lang/Object:hashCode	()I
    //   174: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore_1
    //   181: aload_2
    //   182: aload 5
    //   184: putfield 165	com/baidu/platform/comapi/favrite/FavSyncPoi:h	Ljava/lang/String;
    //   187: aload_2
    //   188: aload_1
    //   189: putfield 167	com/baidu/platform/comapi/favrite/FavSyncPoi:a	Ljava/lang/String;
    //   192: aload 4
    //   194: ldc -87
    //   196: aload_2
    //   197: getfield 171	com/baidu/platform/comapi/favrite/FavSyncPoi:i	Z
    //   200: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   203: pop
    //   204: aload 4
    //   206: ldc -79
    //   208: aload_2
    //   209: getfield 143	com/baidu/platform/comapi/favrite/FavSyncPoi:b	Ljava/lang/String;
    //   212: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   215: pop
    //   216: new 145	org/json/JSONObject
    //   219: dup
    //   220: invokespecial 146	org/json/JSONObject:<init>	()V
    //   223: astore 5
    //   225: aload 5
    //   227: ldc -74
    //   229: aload_2
    //   230: getfield 185	com/baidu/platform/comapi/favrite/FavSyncPoi:c	Lcom/baidu/mapapi/model/inner/Point;
    //   233: invokevirtual 190	com/baidu/mapapi/model/inner/Point:getmPtx	()I
    //   236: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   239: pop
    //   240: aload 5
    //   242: ldc -61
    //   244: aload_2
    //   245: getfield 185	com/baidu/platform/comapi/favrite/FavSyncPoi:c	Lcom/baidu/mapapi/model/inner/Point;
    //   248: invokevirtual 198	com/baidu/mapapi/model/inner/Point:getmPty	()I
    //   251: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   254: pop
    //   255: aload 4
    //   257: ldc -56
    //   259: aload 5
    //   261: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   264: pop
    //   265: aload 4
    //   267: ldc -54
    //   269: aload_2
    //   270: getfield 204	com/baidu/platform/comapi/favrite/FavSyncPoi:e	Ljava/lang/String;
    //   273: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   276: pop
    //   277: aload 4
    //   279: ldc -50
    //   281: aload_2
    //   282: getfield 209	com/baidu/platform/comapi/favrite/FavSyncPoi:g	I
    //   285: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   288: pop
    //   289: aload 4
    //   291: ldc -45
    //   293: aload_2
    //   294: getfield 213	com/baidu/platform/comapi/favrite/FavSyncPoi:f	Ljava/lang/String;
    //   297: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   300: pop
    //   301: aload 4
    //   303: ldc -41
    //   305: aload_2
    //   306: getfield 217	com/baidu/platform/comapi/favrite/FavSyncPoi:d	Ljava/lang/String;
    //   309: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   312: pop
    //   313: aload 4
    //   315: ldc -37
    //   317: aload_2
    //   318: getfield 165	com/baidu/platform/comapi/favrite/FavSyncPoi:h	Ljava/lang/String;
    //   321: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   324: pop
    //   325: new 145	org/json/JSONObject
    //   328: dup
    //   329: invokespecial 146	org/json/JSONObject:<init>	()V
    //   332: astore 5
    //   334: aload 5
    //   336: ldc -35
    //   338: aload 4
    //   340: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   343: pop
    //   344: aload 5
    //   346: ldc -33
    //   348: aload_2
    //   349: getfield 225	com/baidu/platform/comapi/favrite/FavSyncPoi:j	Ljava/lang/String;
    //   352: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   355: pop
    //   356: aload_0
    //   357: getfield 38	com/baidu/platform/comapi/favrite/a:a	Lcom/baidu/platform/comjni/map/favorite/a;
    //   360: aload_1
    //   361: aload 5
    //   363: invokevirtual 226	org/json/JSONObject:toString	()Ljava/lang/String;
    //   366: invokevirtual 229	com/baidu/platform/comjni/map/favorite/a:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   369: ifeq +21 -> 390
    //   372: aload_0
    //   373: invokespecial 72	com/baidu/platform/comapi/favrite/a:j	()V
    //   376: iconst_1
    //   377: istore_3
    //   378: invokestatic 231	com/baidu/platform/comapi/favrite/a:g	()Z
    //   381: pop
    //   382: goto -367 -> 15
    //   385: astore_1
    //   386: aload_0
    //   387: monitorexit
    //   388: aload_1
    //   389: athrow
    //   390: invokestatic 231	com/baidu/platform/comapi/favrite/a:g	()Z
    //   393: pop
    //   394: iconst_0
    //   395: istore_3
    //   396: goto -381 -> 15
    //   399: astore_1
    //   400: invokestatic 231	com/baidu/platform/comapi/favrite/a:g	()Z
    //   403: pop
    //   404: iconst_0
    //   405: istore_3
    //   406: goto -391 -> 15
    //   409: astore_1
    //   410: invokestatic 231	com/baidu/platform/comapi/favrite/a:g	()Z
    //   413: pop
    //   414: aload_1
    //   415: athrow
    //   416: iconst_0
    //   417: istore_3
    //   418: goto +8 -> 426
    //   421: iconst_m1
    //   422: istore_3
    //   423: goto -408 -> 15
    //   426: iload_3
    //   427: iconst_1
    //   428: iadd
    //   429: sipush 500
    //   432: if_icmple -369 -> 63
    //   435: bipush -2
    //   437: istore_3
    //   438: goto -423 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	a
    //   0	441	1	paramString	String
    //   0	441	2	paramFavSyncPoi	FavSyncPoi
    //   14	424	3	j	int
    //   6	333	4	localObject1	Object
    //   107	255	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	385	finally
    //   23	32	385	finally
    //   39	49	385	finally
    //   54	60	385	finally
    //   68	83	385	finally
    //   83	109	385	finally
    //   114	126	385	finally
    //   378	382	385	finally
    //   390	394	385	finally
    //   400	404	385	finally
    //   410	416	385	finally
    //   131	376	399	org/json/JSONException
    //   131	376	409	finally
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 38	com/baidu/platform/comapi/favrite/a:a	Lcom/baidu/platform/comjni/map/favorite/a;
    //   8: astore 4
    //   10: aload 4
    //   12: ifnonnull +9 -> 21
    //   15: iload_3
    //   16: istore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: iload_3
    //   22: istore_2
    //   23: aload_1
    //   24: ifnull -7 -> 17
    //   27: iload_3
    //   28: istore_2
    //   29: aload_1
    //   30: ldc 107
    //   32: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifne -18 -> 17
    //   38: iload_3
    //   39: istore_2
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 234	com/baidu/platform/comapi/favrite/a:c	(Ljava/lang/String;)Z
    //   45: ifeq -28 -> 17
    //   48: aload_0
    //   49: invokespecial 72	com/baidu/platform/comapi/favrite/a:j	()V
    //   52: aload_0
    //   53: getfield 38	com/baidu/platform/comapi/favrite/a:a	Lcom/baidu/platform/comjni/map/favorite/a;
    //   56: aload_1
    //   57: invokevirtual 236	com/baidu/platform/comjni/map/favorite/a:a	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: goto -44 -> 17
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	a
    //   0	69	1	paramString	String
    //   16	45	2	bool1	boolean
    //   1	38	3	bool2	boolean
    //   8	3	4	locala	com.baidu.platform.comjni.map.favorite.a
    // Exception table:
    //   from	to	target	type
    //   4	10	64	finally
    //   29	38	64	finally
    //   40	61	64	finally
  }
  
  public FavSyncPoi b(String paramString)
  {
    if ((this.a == null) || (paramString == null) || (paramString.equals(""))) {}
    for (;;)
    {
      return null;
      try
      {
        if (c(paramString))
        {
          FavSyncPoi localFavSyncPoi = new FavSyncPoi();
          Object localObject1 = this.a.b(paramString);
          if ((localObject1 != null) && (!((String)localObject1).equals("")))
          {
            Object localObject2 = new JSONObject((String)localObject1);
            localObject1 = ((JSONObject)localObject2).optJSONObject("Fav_Sync");
            localObject2 = ((JSONObject)localObject2).optString("Fav_Content");
            localFavSyncPoi.b = ((JSONObject)localObject1).optString("uspoiname");
            JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject("pt");
            localFavSyncPoi.c = new Point(localJSONObject.optInt("x"), localJSONObject.optInt("y"));
            localFavSyncPoi.e = ((JSONObject)localObject1).optString("ncityid");
            localFavSyncPoi.f = ((JSONObject)localObject1).optString("uspoiuid");
            localFavSyncPoi.g = ((JSONObject)localObject1).optInt("npoitype");
            localFavSyncPoi.d = ((JSONObject)localObject1).optString("addr");
            localFavSyncPoi.h = ((JSONObject)localObject1).optString("addtimesec");
            localFavSyncPoi.i = ((JSONObject)localObject1).optBoolean("bdetail");
            localFavSyncPoi.j = ((String)localObject2);
            localFavSyncPoi.a = paramString;
            return localFavSyncPoi;
          }
        }
      }
      catch (NullPointerException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public void b()
  {
    if (b != null)
    {
      if (b.a != null)
      {
        b.a.b();
        b.a = null;
      }
      b = null;
    }
  }
  
  public boolean b(String paramString, FavSyncPoi paramFavSyncPoi)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    for (;;)
    {
      try
      {
        if (this.a != null)
        {
          bool1 = bool2;
          if (paramString != null)
          {
            bool3 = paramString.equals("");
            bool1 = bool2;
            if (!bool3)
            {
              if (paramFavSyncPoi != null) {
                continue;
              }
              bool1 = bool2;
            }
          }
        }
      }
      finally
      {
        try
        {
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("uspoiname", paramFavSyncPoi.b);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("x", paramFavSyncPoi.c.getmPtx());
          localJSONObject2.put("y", paramFavSyncPoi.c.getmPty());
          localJSONObject1.put("pt", localJSONObject2);
          localJSONObject1.put("ncityid", paramFavSyncPoi.e);
          localJSONObject1.put("npoitype", paramFavSyncPoi.g);
          localJSONObject1.put("uspoiuid", paramFavSyncPoi.f);
          localJSONObject1.put("addr", paramFavSyncPoi.d);
          paramFavSyncPoi.h = String.valueOf(System.currentTimeMillis());
          localJSONObject1.put("addtimesec", paramFavSyncPoi.h);
          localJSONObject1.put("bdetail", false);
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("Fav_Sync", localJSONObject1);
          localJSONObject2.put("Fav_Content", paramFavSyncPoi.j);
          j();
          bool1 = bool2;
          if (this.a == null) {
            continue;
          }
          boolean bool3 = this.a.b(paramString, localJSONObject2.toString());
          bool1 = bool2;
          if (!bool3) {
            continue;
          }
          bool1 = true;
        }
        catch (JSONException paramString)
        {
          bool1 = bool2;
        }
        paramString = finally;
      }
      return bool1;
      bool3 = c(paramString);
      bool1 = bool2;
      if (!bool3) {}
    }
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/baidu/platform/comapi/favrite/a:a	Lcom/baidu/platform/comjni/map/favorite/a;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: invokespecial 72	com/baidu/platform/comapi/favrite/a:j	()V
    //   21: aload_0
    //   22: getfield 38	com/baidu/platform/comapi/favrite/a:a	Lcom/baidu/platform/comjni/map/favorite/a;
    //   25: invokevirtual 273	com/baidu/platform/comjni/map/favorite/a:c	()Z
    //   28: istore_1
    //   29: invokestatic 231	com/baidu/platform/comapi/favrite/a:g	()Z
    //   32: pop
    //   33: goto -20 -> 13
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	a
    //   12	17	1	bool	boolean
    //   6	2	2	locala	com.baidu.platform.comjni.map.favorite.a
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	36	finally
    //   17	33	36	finally
  }
  
  public boolean c(String paramString)
  {
    return (this.a != null) && (paramString != null) && (!paramString.equals("")) && (this.a.c(paramString));
  }
  
  public ArrayList<String> d()
  {
    if (this.a == null) {
      return null;
    }
    if ((this.d) && (this.f != null)) {
      return new ArrayList(this.f);
    }
    try
    {
      Object localObject = new Bundle();
      this.a.a((Bundle)localObject);
      localObject = ((Bundle)localObject).getStringArray("rstString");
      if (localObject != null) {
        if (this.f == null)
        {
          this.f = new Vector();
          break label251;
        }
      }
      for (;;)
      {
        if (j < localObject.length)
        {
          if (localObject[j].equals("data_version")) {
            break label256;
          }
          String str = this.a.b(localObject[j]);
          if (str == null) {
            break label256;
          }
          if (str.equals(""))
          {
            break label256;
            this.f.clear();
          }
          else
          {
            this.f.add(localObject[j]);
            break label256;
          }
        }
        else
        {
          j = this.f.size();
          if (j > 0) {}
          for (;;)
          {
            try
            {
              Collections.sort(this.f, new a());
              this.d = true;
              if (this.f == null) {
                break label266;
              }
              if (!this.f.isEmpty()) {
                break;
              }
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              continue;
            }
            if (this.f != null)
            {
              this.f.clear();
              this.f = null;
            }
          }
          ArrayList localArrayList = new ArrayList(this.f);
          return (ArrayList<String>)???;
        }
        label251:
        int j = 0;
        continue;
        label256:
        j += 1;
      }
      localArrayList1 = null;
    }
    catch (Exception localException2)
    {
      return null;
    }
    label266:
    ArrayList<String> localArrayList1;
    return localArrayList1;
  }
  
  public ArrayList<String> e()
  {
    if (this.a == null) {}
    for (;;)
    {
      return null;
      if ((this.c) && (this.e != null)) {
        return new ArrayList(this.e);
      }
      try
      {
        Object localObject1 = new Bundle();
        this.a.a((Bundle)localObject1);
        localObject1 = ((Bundle)localObject1).getStringArray("rstString");
        label82:
        int k;
        int j;
        if (localObject1 != null) {
          if (this.e == null)
          {
            this.e = new Vector();
            k = localObject1.length;
            j = 0;
          }
        }
        for (;;)
        {
          if (j < k)
          {
            Object localObject2 = localObject1[j];
            if (((String)localObject2).equals("data_version")) {
              break label222;
            }
            this.e.add(localObject2);
            break label222;
            this.e.clear();
            break label82;
          }
          j = this.e.size();
          if (j > 0) {}
          for (;;)
          {
            try
            {
              Collections.sort(this.e, new a());
              this.c = true;
              if ((this.e == null) || (this.e.size() == 0)) {
                break;
              }
              return new ArrayList(this.e);
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              continue;
            }
            if (this.e != null)
            {
              this.e.clear();
              this.e = null;
            }
          }
          label222:
          j += 1;
        }
        return null;
      }
      catch (Exception localException2) {}
    }
  }
  
  public String f()
  {
    if ((b.a(this.i)) && (!c.a(this.h)) && (!c.b(this.h))) {
      return c.c(this.h);
    }
    b.b(this.i);
    if (this.a == null) {
      return null;
    }
    Object localObject2 = d();
    Object localObject1 = new JSONObject();
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        int j = 0;
        localObject2 = ((ArrayList)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if ((str != null) && (!str.equals("data_version")))
          {
            Object localObject3 = this.a.b(str);
            if ((localObject3 != null) && (!((String)localObject3).equals("")))
            {
              localObject3 = new JSONObject((String)localObject3).optJSONObject("Fav_Sync");
              ((JSONObject)localObject3).put("key", str);
              localJSONArray.put(j, localObject3);
              j += 1;
            }
          }
        }
        else
        {
          if (j > 0)
          {
            ((JSONObject)localObject1).put("favcontents", localJSONArray);
            ((JSONObject)localObject1).put("favpoinum", j);
          }
          b.c(this.i);
          c.a(this.h, ((JSONObject)localObject1).toString());
          localObject1 = c.c(this.h);
          return (String)localObject1;
        }
      }
      catch (JSONException localJSONException)
      {
        return null;
      }
    }
  }
  
  class a
    implements Comparator<String>
  {
    a() {}
    
    public int a(String paramString1, String paramString2)
    {
      return paramString2.compareTo(paramString1);
    }
  }
  
  private class b
  {
    private long b;
    private long c;
    
    private b() {}
    
    private void a()
    {
      this.b = System.currentTimeMillis();
    }
    
    private void b()
    {
      this.c = System.currentTimeMillis();
    }
    
    private boolean c()
    {
      return this.c - this.b > 1000L;
    }
  }
  
  private class c
  {
    private String b;
    private long c = 5000L;
    private long d = 0L;
    
    private c() {}
    
    private String a()
    {
      return this.b;
    }
    
    private void a(String paramString)
    {
      this.b = paramString;
      this.d = System.currentTimeMillis();
    }
    
    private boolean b()
    {
      return TextUtils.isEmpty(this.b);
    }
    
    private boolean c()
    {
      return true;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/favrite/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */