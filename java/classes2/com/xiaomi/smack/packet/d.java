package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class d
{
  protected static final String a = Locale.getDefault().getLanguage().toLowerCase();
  public static final DateFormat b;
  private static String c = null;
  private static String d = com.xiaomi.smack.util.d.a(5) + "-";
  private static long e = 0L;
  private String f = c;
  private String g = null;
  private String h = null;
  private String i = null;
  private String j = null;
  private String k = null;
  private List<a> l = new CopyOnWriteArrayList();
  private final Map<String, Object> m = new HashMap();
  private h n = null;
  
  static
  {
    b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    b.setTimeZone(TimeZone.getTimeZone("UTC"));
  }
  
  public d() {}
  
  public d(Bundle paramBundle)
  {
    this.h = paramBundle.getString("ext_to");
    this.i = paramBundle.getString("ext_from");
    this.j = paramBundle.getString("ext_chid");
    this.g = paramBundle.getString("ext_pkt_id");
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("ext_exts");
    if (arrayOfParcelable != null)
    {
      this.l = new ArrayList(arrayOfParcelable.length);
      int i2 = arrayOfParcelable.length;
      int i1 = 0;
      while (i1 < i2)
      {
        a locala = a.a((Bundle)arrayOfParcelable[i1]);
        if (locala != null) {
          this.l.add(locala);
        }
        i1 += 1;
      }
    }
    paramBundle = paramBundle.getBundle("ext_ERROR");
    if (paramBundle != null) {
      this.n = new h(paramBundle);
    }
  }
  
  public static String j()
  {
    try
    {
      Object localObject1 = new StringBuilder().append(d);
      long l1 = e;
      e = 1L + l1;
      localObject1 = Long.toString(l1);
      return (String)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public static String u()
  {
    return a;
  }
  
  public void a(a parama)
  {
    this.l.add(parama);
  }
  
  public void a(h paramh)
  {
    this.n = paramh;
  }
  
  public Bundle b()
  {
    Bundle localBundle1 = new Bundle();
    if (!TextUtils.isEmpty(this.f)) {
      localBundle1.putString("ext_ns", this.f);
    }
    if (!TextUtils.isEmpty(this.i)) {
      localBundle1.putString("ext_from", this.i);
    }
    if (!TextUtils.isEmpty(this.h)) {
      localBundle1.putString("ext_to", this.h);
    }
    if (!TextUtils.isEmpty(this.g)) {
      localBundle1.putString("ext_pkt_id", this.g);
    }
    if (!TextUtils.isEmpty(this.j)) {
      localBundle1.putString("ext_chid", this.j);
    }
    if (this.n != null) {
      localBundle1.putBundle("ext_ERROR", this.n.a());
    }
    Bundle[] arrayOfBundle;
    if (this.l != null)
    {
      arrayOfBundle = new Bundle[this.l.size()];
      Iterator localIterator = this.l.iterator();
      int i1 = 0;
      if (localIterator.hasNext())
      {
        Bundle localBundle2 = ((a)localIterator.next()).e();
        if (localBundle2 == null) {
          break label217;
        }
        int i2 = i1 + 1;
        arrayOfBundle[i1] = localBundle2;
        i1 = i2;
      }
    }
    label217:
    for (;;)
    {
      break;
      localBundle1.putParcelableArray("ext_exts", arrayOfBundle);
      return localBundle1;
    }
  }
  
  public a b(String paramString1, String paramString2)
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (((paramString2 == null) || (paramString2.equals(locala.b()))) && (paramString1.equals(locala.a()))) {
        return locala;
      }
    }
    return null;
  }
  
  public abstract String c();
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    label88:
    label131:
    label155:
    label181:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return bool1;
                      bool1 = bool3;
                    } while (paramObject == null);
                    bool1 = bool3;
                  } while (getClass() != paramObject.getClass());
                  paramObject = (d)paramObject;
                  if (this.n == null) {
                    break;
                  }
                  bool1 = bool3;
                } while (!this.n.equals(((d)paramObject).n));
                if (this.i == null) {
                  break label241;
                }
                bool1 = bool3;
              } while (!this.i.equals(((d)paramObject).i));
              bool1 = bool3;
            } while (!this.l.equals(((d)paramObject).l));
            if (this.g == null) {
              break label250;
            }
            bool1 = bool3;
          } while (!this.g.equals(((d)paramObject).g));
          if (this.j == null) {
            break label259;
          }
          bool1 = bool3;
        } while (!this.j.equals(((d)paramObject).j));
        if (this.m == null) {
          break label268;
        }
        bool1 = bool3;
      } while (!this.m.equals(((d)paramObject).m));
      if (this.h == null) {
        break label277;
      }
      bool1 = bool3;
    } while (!this.h.equals(((d)paramObject).h));
    label205:
    if (this.f != null)
    {
      bool1 = bool2;
      if (this.f.equals(((d)paramObject).f)) {}
    }
    label228:
    for (boolean bool1 = false;; bool1 = bool2)
    {
      return bool1;
      if (((d)paramObject).n == null) {
        break;
      }
      return false;
      label241:
      if (((d)paramObject).i == null) {
        break label88;
      }
      return false;
      label250:
      if (((d)paramObject).g == null) {
        break label131;
      }
      return false;
      label259:
      if (((d)paramObject).j == null) {
        break label155;
      }
      return false;
      label268:
      if (((d)paramObject).m == null) {
        break label181;
      }
      return false;
      label277:
      if (((d)paramObject).h == null) {
        break label205;
      }
      return false;
      if (((d)paramObject).f != null) {
        break label228;
      }
    }
  }
  
  public int hashCode()
  {
    int i6 = 0;
    int i1;
    int i2;
    label33:
    int i3;
    label48:
    int i4;
    if (this.f != null)
    {
      i1 = this.f.hashCode();
      if (this.g == null) {
        break label165;
      }
      i2 = this.g.hashCode();
      if (this.h == null) {
        break label170;
      }
      i3 = this.h.hashCode();
      if (this.i == null) {
        break label175;
      }
      i4 = this.i.hashCode();
      label64:
      if (this.j == null) {
        break label181;
      }
    }
    label165:
    label170:
    label175:
    label181:
    for (int i5 = this.j.hashCode();; i5 = 0)
    {
      int i7 = this.l.hashCode();
      int i8 = this.m.hashCode();
      if (this.n != null) {
        i6 = this.n.hashCode();
      }
      return (((i5 + (i4 + (i3 + (i2 + i1 * 31) * 31) * 31) * 31) * 31 + i7) * 31 + i8) * 31 + i6;
      i1 = 0;
      break;
      i2 = 0;
      break label33;
      i3 = 0;
      break label48;
      i4 = 0;
      break label64;
    }
  }
  
  public String k()
  {
    if ("ID_NOT_AVAILABLE".equals(this.g)) {
      return null;
    }
    if (this.g == null) {
      this.g = j();
    }
    return this.g;
  }
  
  public void k(String paramString)
  {
    this.g = paramString;
  }
  
  public String l()
  {
    return this.j;
  }
  
  public void l(String paramString)
  {
    this.j = paramString;
  }
  
  public String m()
  {
    return this.h;
  }
  
  public void m(String paramString)
  {
    this.h = paramString;
  }
  
  public String n()
  {
    return this.i;
  }
  
  public void n(String paramString)
  {
    this.i = paramString;
  }
  
  public String o()
  {
    return this.k;
  }
  
  public void o(String paramString)
  {
    this.k = paramString;
  }
  
  public a p(String paramString)
  {
    return b(paramString, null);
  }
  
  public h p()
  {
    return this.n;
  }
  
  /* Error */
  public Object q(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 117	com/xiaomi/smack/packet/d:m	Ljava/util/Map;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 117	com/xiaomi/smack/packet/d:m	Ljava/util/Map;
    //   21: aload_1
    //   22: invokeinterface 257 2 0
    //   27: astore_1
    //   28: goto -15 -> 13
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	d
    //   0	36	1	paramString	String
    //   6	2	2	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   17	28	31	finally
  }
  
  /* Error */
  public java.util.Collection<a> q()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 112	com/xiaomi/smack/packet/d:l	Ljava/util/List;
    //   6: ifnonnull +11 -> 17
    //   9: invokestatic 264	java/util/Collections:emptyList	()Ljava/util/List;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: new 142	java/util/ArrayList
    //   20: dup
    //   21: aload_0
    //   22: getfield 112	com/xiaomi/smack/packet/d:l	Ljava/util/List;
    //   25: invokespecial 267	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   28: invokestatic 271	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   31: astore_1
    //   32: goto -19 -> 13
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	d
    //   12	20	1	localList	List
    //   35	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	35	finally
    //   17	32	35	finally
  }
  
  /* Error */
  public java.util.Collection<String> r()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 117	com/xiaomi/smack/packet/d:m	Ljava/util/Map;
    //   6: ifnonnull +11 -> 17
    //   9: invokestatic 278	java/util/Collections:emptySet	()Ljava/util/Set;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: new 280	java/util/HashSet
    //   20: dup
    //   21: aload_0
    //   22: getfield 117	com/xiaomi/smack/packet/d:m	Ljava/util/Map;
    //   25: invokeinterface 283 1 0
    //   30: invokespecial 284	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   33: invokestatic 288	java/util/Collections:unmodifiableSet	(Ljava/util/Set;)Ljava/util/Set;
    //   36: astore_1
    //   37: goto -24 -> 13
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	d
    //   12	25	1	localSet	java.util.Set
    //   40	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	40	finally
    //   17	37	40	finally
  }
  
  /* Error */
  protected String s()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 73	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   9: astore 5
    //   11: aload_0
    //   12: invokevirtual 294	com/xiaomi/smack/packet/d:q	()Ljava/util/Collection;
    //   15: invokeinterface 297 1 0
    //   20: astore_1
    //   21: aload_1
    //   22: invokeinterface 208 1 0
    //   27: ifeq +31 -> 58
    //   30: aload 5
    //   32: aload_1
    //   33: invokeinterface 212 1 0
    //   38: checkcast 299	com/xiaomi/smack/packet/e
    //   41: invokeinterface 301 1 0
    //   46: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: goto -29 -> 21
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: aload_0
    //   59: getfield 117	com/xiaomi/smack/packet/d:m	Ljava/util/Map;
    //   62: ifnull +434 -> 496
    //   65: aload_0
    //   66: getfield 117	com/xiaomi/smack/packet/d:m	Ljava/util/Map;
    //   69: invokeinterface 303 1 0
    //   74: ifne +422 -> 496
    //   77: aload 5
    //   79: ldc_w 305
    //   82: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_0
    //   87: invokevirtual 307	com/xiaomi/smack/packet/d:r	()Ljava/util/Collection;
    //   90: invokeinterface 297 1 0
    //   95: astore 6
    //   97: aload 6
    //   99: invokeinterface 208 1 0
    //   104: ifeq +383 -> 487
    //   107: aload 6
    //   109: invokeinterface 212 1 0
    //   114: checkcast 40	java/lang/String
    //   117: astore_2
    //   118: aload_0
    //   119: aload_2
    //   120: invokevirtual 309	com/xiaomi/smack/packet/d:q	(Ljava/lang/String;)Ljava/lang/Object;
    //   123: astore_1
    //   124: aload 5
    //   126: ldc_w 311
    //   129: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: ldc_w 313
    //   138: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_2
    //   142: invokestatic 315	com/xiaomi/smack/util/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc_w 317
    //   151: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 5
    //   157: ldc_w 319
    //   160: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_1
    //   165: instanceof 321
    //   168: ifeq +34 -> 202
    //   171: aload 5
    //   173: ldc_w 323
    //   176: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_1
    //   180: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: ldc_w 328
    //   186: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 5
    //   192: ldc_w 330
    //   195: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: goto -102 -> 97
    //   202: aload_1
    //   203: instanceof 168
    //   206: ifeq +25 -> 231
    //   209: aload 5
    //   211: ldc_w 332
    //   214: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_1
    //   218: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   221: ldc_w 328
    //   224: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: goto -38 -> 190
    //   231: aload_1
    //   232: instanceof 334
    //   235: ifeq +25 -> 260
    //   238: aload 5
    //   240: ldc_w 336
    //   243: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_1
    //   247: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   250: ldc_w 328
    //   253: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: goto -67 -> 190
    //   260: aload_1
    //   261: instanceof 338
    //   264: ifeq +25 -> 289
    //   267: aload 5
    //   269: ldc_w 340
    //   272: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   279: ldc_w 328
    //   282: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: goto -96 -> 190
    //   289: aload_1
    //   290: instanceof 342
    //   293: ifeq +25 -> 318
    //   296: aload 5
    //   298: ldc_w 344
    //   301: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_1
    //   305: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   308: ldc_w 328
    //   311: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: goto -125 -> 190
    //   318: aload_1
    //   319: instanceof 40
    //   322: ifeq +37 -> 359
    //   325: aload 5
    //   327: ldc_w 346
    //   330: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 5
    //   336: aload_1
    //   337: checkcast 40	java/lang/String
    //   340: invokestatic 315	com/xiaomi/smack/util/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   343: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 5
    //   349: ldc_w 328
    //   352: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: goto -166 -> 190
    //   359: new 348	java/io/ByteArrayOutputStream
    //   362: dup
    //   363: invokespecial 349	java/io/ByteArrayOutputStream:<init>	()V
    //   366: astore_3
    //   367: new 351	java/io/ObjectOutputStream
    //   370: dup
    //   371: aload_3
    //   372: invokespecial 354	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   375: astore_2
    //   376: aload_2
    //   377: aload_1
    //   378: invokevirtual 358	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   381: aload 5
    //   383: ldc_w 360
    //   386: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 5
    //   392: aload_3
    //   393: invokevirtual 364	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   396: invokestatic 367	com/xiaomi/smack/util/d:a	([B)Ljava/lang/String;
    //   399: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc_w 328
    //   405: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload_2
    //   410: ifnull +7 -> 417
    //   413: aload_2
    //   414: invokevirtual 370	java/io/ObjectOutputStream:close	()V
    //   417: aload_3
    //   418: ifnull -228 -> 190
    //   421: aload_3
    //   422: invokevirtual 371	java/io/ByteArrayOutputStream:close	()V
    //   425: goto -235 -> 190
    //   428: astore_1
    //   429: goto -239 -> 190
    //   432: astore_3
    //   433: aconst_null
    //   434: astore_1
    //   435: aconst_null
    //   436: astore_2
    //   437: aload_3
    //   438: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   441: aload_1
    //   442: ifnull +7 -> 449
    //   445: aload_1
    //   446: invokevirtual 370	java/io/ObjectOutputStream:close	()V
    //   449: aload_2
    //   450: ifnull -260 -> 190
    //   453: aload_2
    //   454: invokevirtual 371	java/io/ByteArrayOutputStream:close	()V
    //   457: goto -267 -> 190
    //   460: astore_1
    //   461: goto -271 -> 190
    //   464: astore_1
    //   465: aconst_null
    //   466: astore_2
    //   467: aconst_null
    //   468: astore_3
    //   469: aload_2
    //   470: ifnull +7 -> 477
    //   473: aload_2
    //   474: invokevirtual 370	java/io/ObjectOutputStream:close	()V
    //   477: aload_3
    //   478: ifnull +7 -> 485
    //   481: aload_3
    //   482: invokevirtual 371	java/io/ByteArrayOutputStream:close	()V
    //   485: aload_1
    //   486: athrow
    //   487: aload 5
    //   489: ldc_w 376
    //   492: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 5
    //   498: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: astore_1
    //   502: aload_0
    //   503: monitorexit
    //   504: aload_1
    //   505: areturn
    //   506: astore_1
    //   507: goto -90 -> 417
    //   510: astore_1
    //   511: goto -62 -> 449
    //   514: astore_2
    //   515: goto -38 -> 477
    //   518: astore_2
    //   519: goto -34 -> 485
    //   522: astore_1
    //   523: aconst_null
    //   524: astore_2
    //   525: goto -56 -> 469
    //   528: astore_1
    //   529: goto -60 -> 469
    //   532: astore 4
    //   534: aload_2
    //   535: astore_3
    //   536: aload_1
    //   537: astore_2
    //   538: aload 4
    //   540: astore_1
    //   541: goto -72 -> 469
    //   544: astore 4
    //   546: aconst_null
    //   547: astore_1
    //   548: aload_3
    //   549: astore_2
    //   550: aload 4
    //   552: astore_3
    //   553: goto -116 -> 437
    //   556: astore 4
    //   558: aload_2
    //   559: astore_1
    //   560: aload_3
    //   561: astore_2
    //   562: aload 4
    //   564: astore_3
    //   565: goto -128 -> 437
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	this	d
    //   20	13	1	localIterator1	Iterator
    //   53	4	1	localObject1	Object
    //   123	255	1	localObject2	Object
    //   428	1	1	localException1	Exception
    //   434	12	1	localObject3	Object
    //   460	1	1	localException2	Exception
    //   464	22	1	localObject4	Object
    //   501	4	1	str	String
    //   506	1	1	localException3	Exception
    //   510	1	1	localException4	Exception
    //   522	1	1	localObject5	Object
    //   528	9	1	localObject6	Object
    //   540	20	1	localObject7	Object
    //   117	357	2	localObject8	Object
    //   514	1	2	localException5	Exception
    //   518	1	2	localException6	Exception
    //   524	38	2	localObject9	Object
    //   366	56	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   432	6	3	localException7	Exception
    //   468	97	3	localObject10	Object
    //   532	7	4	localObject11	Object
    //   544	7	4	localException8	Exception
    //   556	7	4	localException9	Exception
    //   9	488	5	localStringBuilder	StringBuilder
    //   95	13	6	localIterator2	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	21	53	finally
    //   21	50	53	finally
    //   58	97	53	finally
    //   97	190	53	finally
    //   190	199	53	finally
    //   202	228	53	finally
    //   231	257	53	finally
    //   260	286	53	finally
    //   289	315	53	finally
    //   318	356	53	finally
    //   413	417	53	finally
    //   421	425	53	finally
    //   445	449	53	finally
    //   453	457	53	finally
    //   473	477	53	finally
    //   481	485	53	finally
    //   485	487	53	finally
    //   487	496	53	finally
    //   496	502	53	finally
    //   421	425	428	java/lang/Exception
    //   359	367	432	java/lang/Exception
    //   453	457	460	java/lang/Exception
    //   359	367	464	finally
    //   413	417	506	java/lang/Exception
    //   445	449	510	java/lang/Exception
    //   473	477	514	java/lang/Exception
    //   481	485	518	java/lang/Exception
    //   367	376	522	finally
    //   376	409	528	finally
    //   437	441	532	finally
    //   367	376	544	java/lang/Exception
    //   376	409	556	java/lang/Exception
  }
  
  public String t()
  {
    return this.f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/packet/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */