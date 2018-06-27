package com.unionpay.sdk;

import android.content.Context;
import android.location.Location;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;

final class ac
{
  private static w.d a = null;
  private static w.e b = null;
  
  static w.f a(bg parambg)
  {
    Object localObject1 = d.c;
    w.f localf = new w.f();
    localf.a = g.a((Context)localObject1);
    localf.b = d.g;
    localf.c = b();
    localf.d = c();
    int i = z.c(5);
    int j = z.b(localf.a);
    int k = z.b(localf.b);
    localObject1 = localf.c;
    int m = z.c(9);
    int n = z.b(((w.d)localObject1).a);
    int i1 = z.b(((w.d)localObject1).b);
    int i2 = z.b(((w.d)localObject1).c);
    int i3 = z.b(((w.d)localObject1).d);
    int i4 = z.b(((w.d)localObject1).e);
    int i5 = z.b(((w.d)localObject1).f);
    boolean bool = ((w.d)localObject1).g;
    int i6 = z.b(((w.d)localObject1).h);
    int i7 = z.b(((w.d)localObject1).i);
    localObject1 = localf.d;
    int i8 = z.c(24);
    int i9 = z.b(((w.e)localObject1).a);
    int i10 = z.b(((w.e)localObject1).b);
    Object localObject2 = ((w.e)localObject1).c;
    int i11 = z.c(2);
    double d = ((w.h)localObject2).a;
    d = ((w.h)localObject2).b;
    int i12 = z.b(((w.e)localObject1).d);
    int i13 = z.b(((w.e)localObject1).e);
    int i14 = z.b(((w.e)localObject1).f);
    int i15 = z.b(((w.e)localObject1).g);
    int i16 = z.b(((w.e)localObject1).h);
    int i17 = z.c(((w.e)localObject1).i);
    int i18 = z.b(((w.e)localObject1).j);
    int i19 = z.c(((w.e)localObject1).k);
    int i20 = z.b(((w.e)localObject1).l);
    bool = ((w.e)localObject1).m;
    int i21 = z.b(((w.e)localObject1).n);
    int i22 = z.b(((w.e)localObject1).o);
    int i23 = z.b(((w.e)localObject1).p);
    int i24 = z.b(((w.e)localObject1).q);
    int i25 = z.b(((w.e)localObject1).r);
    int i26 = z.b(((w.e)localObject1).s);
    int i27 = z.b(((w.e)localObject1).t);
    int i28 = z.b(((w.e)localObject1).u);
    int i29 = z.c(((w.e)localObject1).v);
    int i30 = z.c(((w.e)localObject1).w);
    i = i + j + k + (i7 + (m + n + i1 + i2 + i3 + i4 + i5 + 1 + i6)) + (z.b(((w.e)localObject1).x) + (i8 + i9 + i10 + (i11 + 9 + 9) + i12 + i13 + i14 + i15 + i16 + i17 + i18 + i19 + i20 + 1 + i21 + i22 + i23 + i24 + i25 + i26 + i27 + i28 + i29 + i30)) + 3 + 0;
    if (e())
    {
      if (ag.a) {
        k.b(new String[] { "Prepare init Device profile" });
      }
      localObject1 = new w.i();
      ((w.i)localObject1).a = 1;
      ((w.i)localObject1).c = a();
      localf.e.add(localObject1);
      j = z.c(((w.i)localObject1).a);
      localObject1 = ((w.i)localObject1).c;
      m = z.c(29);
      n = z.b(((w.g)localObject1).a);
      i1 = z.c(((w.g)localObject1).b);
      float f = ((w.g)localObject1).c;
      i2 = z.b(((w.g)localObject1).d);
      i3 = z.b(((w.g)localObject1).e);
      i4 = z.b(((w.g)localObject1).f);
      i5 = z.c(((w.g)localObject1).g);
      i6 = z.c(((w.g)localObject1).h);
      i7 = z.c(((w.g)localObject1).i);
      i8 = z.c(((w.g)localObject1).j);
      i9 = z.c(((w.g)localObject1).k);
      i10 = z.c(((w.g)localObject1).l);
      i11 = z.c(((w.g)localObject1).m);
      f = ((w.g)localObject1).n;
      f = ((w.g)localObject1).o;
      i12 = z.c(((w.g)localObject1).p);
      i13 = z.b(((w.g)localObject1).q);
      i14 = z.b(((w.g)localObject1).r);
      i15 = z.b(((w.g)localObject1).s);
      i16 = z.b(((w.g)localObject1).t);
      i17 = z.b(((w.g)localObject1).u);
      i18 = z.b(((w.g)localObject1).v);
      i19 = z.b(((w.g)localObject1).w);
      bool = ((w.g)localObject1).x;
      i20 = z.b(((w.g)localObject1).y);
      i21 = z.b(((w.g)localObject1).z);
      i22 = z.b(((w.g)localObject1).A);
      i23 = z.b(((w.g)localObject1).B);
      i24 = z.b(((w.g)localObject1).C);
      k = 1;
      i += i24 + (m + n + i1 + 5 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + 5 + 5 + i12 + i13 + i14 + i15 + i16 + i17 + i18 + i19 + 1 + i20 + i21 + i22 + i23) + j;
    }
    for (;;)
    {
      parambg.b();
      localf.h = parambg.g("error_report");
      localObject2 = parambg.d();
      localObject1 = new ArrayList();
      j = 0;
      localObject2 = ((List)localObject2).iterator();
      label1643:
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          w.j localj = (w.j)((Iterator)localObject2).next();
          j += 1;
          if (ag.a) {
            k.b(new String[] { "session", localj.toString() });
          }
          Object localObject3 = localj.a;
          long l = localf.f;
          localj.e = parambg.d((String)localObject3);
          if (ag.a)
          {
            k.b(new String[] { "Count of Pages = ", String.valueOf(localj.e.size()) });
            k.b(new String[] { "Pages: ", localj.e.toString() });
          }
          localObject3 = localj.a;
          l = localf.g;
          localj.f = parambg.f((String)localObject3);
          if (ag.a)
          {
            k.b(new String[] { "Count of Events = ", String.valueOf(localj.f.size()) });
            k.b(new String[] { "Events: ", localj.f.toString() });
          }
          n = 0;
          m = n;
          if (localj.f != null)
          {
            localObject3 = localj.f.iterator();
            do
            {
              m = n;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
            } while (((w.b)((Iterator)localObject3).next()).a.startsWith("__"));
            m = 1;
          }
          localObject3 = new w.i();
          ((w.i)localObject3).a = 2;
          ((w.i)localObject3).b = localj;
          n = localj.a();
          if ((n + i <= 20480) || (j == 1))
          {
            i = n + i;
            ((List)localObject1).add(localj);
            if ((SystemClock.elapsedRealtime() - d.f < 7200000L) && (localj.c == 2) && (localj.e.size() == 0) && ((localj.f.size() == 0) || ((m == 0) && (!ag.c)))) {
              break label1643;
            }
            localf.e.add(localObject3);
            continue;
          }
        }
        if (ag.a) {
          k.b(new String[] { "************ " + ((List)localObject1).size() + " Session*****************" });
        }
        localf.f = parambg.a((List)localObject1);
        localf.g = parambg.b((List)localObject1);
        if (localf.h > 0L)
        {
          localObject1 = parambg.d(localf.h).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (w.i)((Iterator)localObject1).next();
            localf.e.add(localObject2);
          }
        }
        parambg.c();
        if ((k == 0) && (localf.e.size() == 0)) {
          return null;
        }
        return localf;
      }
      k = 0;
    }
  }
  
  /* Error */
  private static w.g a()
  {
    // Byte code:
    //   0: getstatic 22	com/unionpay/sdk/d:c	Landroid/content/Context;
    //   3: astore_1
    //   4: new 193	com/unionpay/sdk/w$g
    //   7: dup
    //   8: invokespecial 373	com/unionpay/sdk/w$g:<init>	()V
    //   11: astore_0
    //   12: invokestatic 378	com/unionpay/sdk/h:k	()[Ljava/lang/String;
    //   15: astore_2
    //   16: aload_0
    //   17: aload_2
    //   18: iconst_0
    //   19: aaload
    //   20: putfield 194	com/unionpay/sdk/w$g:a	Ljava/lang/String;
    //   23: aload_0
    //   24: aload_2
    //   25: iconst_1
    //   26: aaload
    //   27: invokestatic 383	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   30: invokevirtual 386	java/lang/Integer:intValue	()I
    //   33: putfield 196	com/unionpay/sdk/w$g:b	I
    //   36: aload_0
    //   37: aload_2
    //   38: iconst_2
    //   39: aaload
    //   40: putfield 200	com/unionpay/sdk/w$g:d	Ljava/lang/String;
    //   43: aload_0
    //   44: aload_2
    //   45: iconst_3
    //   46: aaload
    //   47: invokestatic 391	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   50: invokevirtual 395	java/lang/Float:floatValue	()F
    //   53: putfield 199	com/unionpay/sdk/w$g:c	F
    //   56: getstatic 22	com/unionpay/sdk/d:c	Landroid/content/Context;
    //   59: invokestatic 398	com/unionpay/sdk/h:a	(Landroid/content/Context;)Lorg/json/JSONObject;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull +11 -> 75
    //   67: aload_0
    //   68: aload_2
    //   69: invokevirtual 401	org/json/JSONObject:toString	()Ljava/lang/String;
    //   72: putfield 247	com/unionpay/sdk/w$g:C	Ljava/lang/String;
    //   75: invokestatic 404	com/unionpay/sdk/h:m	()[I
    //   78: astore_2
    //   79: aload_0
    //   80: aload_2
    //   81: iconst_0
    //   82: iaload
    //   83: putfield 204	com/unionpay/sdk/w$g:g	I
    //   86: aload_0
    //   87: aload_2
    //   88: iconst_1
    //   89: iaload
    //   90: putfield 206	com/unionpay/sdk/w$g:h	I
    //   93: invokestatic 406	com/unionpay/sdk/h:n	()[I
    //   96: astore_2
    //   97: aload_0
    //   98: aload_2
    //   99: iconst_0
    //   100: iaload
    //   101: putfield 207	com/unionpay/sdk/w$g:i	I
    //   104: aload_0
    //   105: aload_2
    //   106: iconst_1
    //   107: iaload
    //   108: putfield 209	com/unionpay/sdk/w$g:j	I
    //   111: aload_0
    //   112: aload_2
    //   113: iconst_2
    //   114: iaload
    //   115: putfield 210	com/unionpay/sdk/w$g:k	I
    //   118: aload_0
    //   119: aload_2
    //   120: iconst_3
    //   121: iaload
    //   122: putfield 212	com/unionpay/sdk/w$g:l	I
    //   125: aload_0
    //   126: invokestatic 408	com/unionpay/sdk/h:o	()I
    //   129: putfield 214	com/unionpay/sdk/w$g:m	I
    //   132: new 410	android/util/DisplayMetrics
    //   135: dup
    //   136: invokespecial 411	android/util/DisplayMetrics:<init>	()V
    //   139: astore_2
    //   140: aload_1
    //   141: ldc_w 413
    //   144: invokevirtual 419	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   147: checkcast 421	android/view/WindowManager
    //   150: invokeinterface 425 1 0
    //   155: aload_2
    //   156: invokevirtual 431	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   159: aload_0
    //   160: aload_2
    //   161: getfield 434	android/util/DisplayMetrics:widthPixels	I
    //   164: i2f
    //   165: aload_2
    //   166: getfield 437	android/util/DisplayMetrics:xdpi	F
    //   169: fdiv
    //   170: putfield 216	com/unionpay/sdk/w$g:n	F
    //   173: aload_0
    //   174: aload_2
    //   175: getfield 440	android/util/DisplayMetrics:heightPixels	I
    //   178: i2f
    //   179: aload_2
    //   180: getfield 443	android/util/DisplayMetrics:ydpi	F
    //   183: fdiv
    //   184: putfield 218	com/unionpay/sdk/w$g:o	F
    //   187: aload_0
    //   188: aload_2
    //   189: getfield 446	android/util/DisplayMetrics:densityDpi	I
    //   192: putfield 220	com/unionpay/sdk/w$g:p	I
    //   195: aload_0
    //   196: getstatic 451	android/os/Build:DISPLAY	Ljava/lang/String;
    //   199: putfield 221	com/unionpay/sdk/w$g:q	Ljava/lang/String;
    //   202: aload_0
    //   203: ldc_w 453
    //   206: putfield 223	com/unionpay/sdk/w$g:r	Ljava/lang/String;
    //   209: aload_0
    //   210: ldc_w 455
    //   213: invokestatic 461	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   216: ldc_w 463
    //   219: iconst_1
    //   220: anewarray 457	java/lang/Class
    //   223: dup
    //   224: iconst_0
    //   225: ldc -92
    //   227: aastore
    //   228: invokevirtual 467	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   231: aconst_null
    //   232: iconst_1
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: ldc_w 469
    //   241: aastore
    //   242: invokevirtual 475	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   245: checkcast 164	java/lang/String
    //   248: putfield 223	com/unionpay/sdk/w$g:r	Ljava/lang/String;
    //   251: aload_1
    //   252: invokestatic 477	com/unionpay/sdk/g:c	(Landroid/content/Context;)Ljava/lang/String;
    //   255: astore_2
    //   256: aload_2
    //   257: ifnull +8 -> 265
    //   260: aload_0
    //   261: aload_2
    //   262: putfield 224	com/unionpay/sdk/w$g:s	Ljava/lang/String;
    //   265: aload_1
    //   266: invokestatic 479	com/unionpay/sdk/g:f	(Landroid/content/Context;)Ljava/lang/String;
    //   269: astore_2
    //   270: aload_2
    //   271: ifnull +8 -> 279
    //   274: aload_0
    //   275: aload_2
    //   276: putfield 225	com/unionpay/sdk/w$g:t	Ljava/lang/String;
    //   279: aload_0
    //   280: aload_1
    //   281: invokestatic 481	com/unionpay/sdk/g:e	(Landroid/content/Context;)Ljava/lang/String;
    //   284: putfield 235	com/unionpay/sdk/w$g:y	Ljava/lang/String;
    //   287: aload_0
    //   288: aload_1
    //   289: invokestatic 483	com/unionpay/sdk/g:d	(Landroid/content/Context;)Ljava/lang/String;
    //   292: putfield 241	com/unionpay/sdk/w$g:A	Ljava/lang/String;
    //   295: aload_0
    //   296: aload_1
    //   297: invokestatic 485	com/unionpay/sdk/g:b	(Landroid/content/Context;)Ljava/lang/String;
    //   300: putfield 244	com/unionpay/sdk/w$g:B	Ljava/lang/String;
    //   303: aload_0
    //   304: areturn
    //   305: astore_2
    //   306: aload_2
    //   307: invokestatic 488	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   310: goto -235 -> 75
    //   313: astore_2
    //   314: aload_2
    //   315: invokestatic 488	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   318: goto -193 -> 125
    //   321: astore_2
    //   322: getstatic 162	com/unionpay/sdk/ag:a	Z
    //   325: ifeq -74 -> 251
    //   328: iconst_1
    //   329: anewarray 164	java/lang/String
    //   332: dup
    //   333: iconst_0
    //   334: ldc_w 490
    //   337: aastore
    //   338: invokestatic 171	com/unionpay/sdk/k:b	([Ljava/lang/String;)V
    //   341: goto -90 -> 251
    //   344: astore_1
    //   345: getstatic 162	com/unionpay/sdk/ag:a	Z
    //   348: ifeq -45 -> 303
    //   351: iconst_1
    //   352: anewarray 164	java/lang/String
    //   355: dup
    //   356: iconst_0
    //   357: aload_1
    //   358: invokevirtual 493	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   361: aastore
    //   362: invokestatic 171	com/unionpay/sdk/k:b	([Ljava/lang/String;)V
    //   365: aload_0
    //   366: areturn
    //   367: astore_2
    //   368: goto -312 -> 56
    //   371: astore_3
    //   372: goto -336 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	355	0	localg	w.g
    //   3	294	1	localContext	Context
    //   344	14	1	localException1	Exception
    //   15	261	2	localObject	Object
    //   305	2	2	localException2	Exception
    //   313	2	2	localThrowable1	Throwable
    //   321	1	2	localException3	Exception
    //   367	1	2	localThrowable2	Throwable
    //   371	1	3	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   16	23	305	java/lang/Exception
    //   23	36	305	java/lang/Exception
    //   36	43	305	java/lang/Exception
    //   43	56	305	java/lang/Exception
    //   56	63	305	java/lang/Exception
    //   67	75	305	java/lang/Exception
    //   93	125	313	java/lang/Throwable
    //   209	251	321	java/lang/Exception
    //   279	303	344	java/lang/Exception
    //   43	56	367	java/lang/Throwable
    //   23	36	371	java/lang/Throwable
  }
  
  static void a(w.f paramf, bg parambg)
  {
    parambg.b();
    Object localObject = paramf.e;
    parambg.a(paramf.f);
    parambg.b(paramf.g);
    parambg.c(paramf.h);
    paramf = ((List)localObject).iterator();
    while (paramf.hasNext())
    {
      localObject = (w.i)paramf.next();
      switch (((w.i)localObject).a)
      {
      default: 
        break;
      case 1: 
        l.a(d.c, "UPpref_longtime", "UPpref.profile.key", 0L);
        break;
      case 2: 
        localObject = ((w.i)localObject).b;
        if (((w.j)localObject).c == 1)
        {
          parambg.a(((w.j)localObject).a);
        }
        else if (((w.j)localObject).c == 3)
        {
          parambg.b(((w.j)localObject).a);
          parambg.c(((w.j)localObject).a);
          parambg.e(((w.j)localObject).a);
        }
        break;
      }
    }
    parambg.c();
  }
  
  /* Error */
  private static w.d b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 12	com/unionpay/sdk/ac:a	Lcom/unionpay/sdk/w$d;
    //   6: ifnull +12 -> 18
    //   9: getstatic 12	com/unionpay/sdk/ac:a	Lcom/unionpay/sdk/w$d;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: getstatic 22	com/unionpay/sdk/d:c	Landroid/content/Context;
    //   21: ifnonnull +8 -> 29
    //   24: aconst_null
    //   25: astore_0
    //   26: goto -13 -> 13
    //   29: new 61	com/unionpay/sdk/w$d
    //   32: dup
    //   33: invokespecial 519	com/unionpay/sdk/w$d:<init>	()V
    //   36: astore_0
    //   37: aload_0
    //   38: putstatic 12	com/unionpay/sdk/ac:a	Lcom/unionpay/sdk/w$d;
    //   41: aload_0
    //   42: getstatic 22	com/unionpay/sdk/d:c	Landroid/content/Context;
    //   45: invokevirtual 522	android/content/Context:getPackageName	()Ljava/lang/String;
    //   48: putfield 62	com/unionpay/sdk/w$d:a	Ljava/lang/String;
    //   51: getstatic 12	com/unionpay/sdk/ac:a	Lcom/unionpay/sdk/w$d;
    //   54: invokestatic 526	com/unionpay/sdk/o:h	()Ljava/lang/String;
    //   57: putfield 63	com/unionpay/sdk/w$d:b	Ljava/lang/String;
    //   60: getstatic 12	com/unionpay/sdk/ac:a	Lcom/unionpay/sdk/w$d;
    //   63: invokestatic 528	com/unionpay/sdk/o:g	()I
    //   66: invokestatic 301	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   69: putfield 65	com/unionpay/sdk/w$d:c	Ljava/lang/String;
    //   72: getstatic 12	com/unionpay/sdk/ac:a	Lcom/unionpay/sdk/w$d;
    //   75: invokestatic 530	com/unionpay/sdk/o:d	()J
    //   78: putfield 68	com/unionpay/sdk/w$d:d	J
    //   81: getstatic 12	com/unionpay/sdk/ac:a	Lcom/unionpay/sdk/w$d;
    //   84: ldc_w 532
    //   87: putfield 74	com/unionpay/sdk/w$d:e	Ljava/lang/String;
    //   90: getstatic 12	com/unionpay/sdk/ac:a	Lcom/unionpay/sdk/w$d;
    //   93: getstatic 534	com/unionpay/sdk/d:i	Ljava/lang/String;
    //   96: putfield 77	com/unionpay/sdk/w$d:f	Ljava/lang/String;
    //   99: getstatic 12	com/unionpay/sdk/ac:a	Lcom/unionpay/sdk/w$d;
    //   102: invokestatic 539	com/unionpay/sdk/a:a	()Lcom/unionpay/sdk/a;
    //   105: getstatic 22	com/unionpay/sdk/d:c	Landroid/content/Context;
    //   108: invokevirtual 542	com/unionpay/sdk/a:d	(Landroid/content/Context;)J
    //   111: putfield 83	com/unionpay/sdk/w$d:h	J
    //   114: getstatic 12	com/unionpay/sdk/ac:a	Lcom/unionpay/sdk/w$d;
    //   117: invokestatic 539	com/unionpay/sdk/a:a	()Lcom/unionpay/sdk/a;
    //   120: getstatic 22	com/unionpay/sdk/d:c	Landroid/content/Context;
    //   123: invokevirtual 544	com/unionpay/sdk/a:e	(Landroid/content/Context;)J
    //   126: putfield 86	com/unionpay/sdk/w$d:i	J
    //   129: getstatic 12	com/unionpay/sdk/ac:a	Lcom/unionpay/sdk/w$d;
    //   132: astore_0
    //   133: goto -120 -> 13
    //   136: astore_0
    //   137: ldc 2
    //   139: monitorexit
    //   140: aload_0
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	121	0	locald	w.d
    //   136	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	136	finally
    //   18	24	136	finally
    //   29	133	136	finally
  }
  
  /* Error */
  private static w.e c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	com/unionpay/sdk/ac:b	Lcom/unionpay/sdk/w$e;
    //   6: ifnonnull +180 -> 186
    //   9: getstatic 22	com/unionpay/sdk/d:c	Landroid/content/Context;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +10 -> 24
    //   17: aconst_null
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: new 88	com/unionpay/sdk/w$e
    //   27: dup
    //   28: invokespecial 545	com/unionpay/sdk/w$e:<init>	()V
    //   31: astore_0
    //   32: aload_0
    //   33: putstatic 14	com/unionpay/sdk/ac:b	Lcom/unionpay/sdk/w$e;
    //   36: aload_0
    //   37: getstatic 22	com/unionpay/sdk/d:c	Landroid/content/Context;
    //   40: invokestatic 547	com/unionpay/sdk/g:h	(Landroid/content/Context;)Ljava/lang/String;
    //   43: putfield 140	com/unionpay/sdk/w$e:s	Ljava/lang/String;
    //   46: getstatic 14	com/unionpay/sdk/ac:b	Lcom/unionpay/sdk/w$e;
    //   49: invokestatic 549	com/unionpay/sdk/h:f	()Ljava/lang/String;
    //   52: putfield 89	com/unionpay/sdk/w$e:a	Ljava/lang/String;
    //   55: getstatic 14	com/unionpay/sdk/ac:b	Lcom/unionpay/sdk/w$e;
    //   58: invokestatic 550	com/unionpay/sdk/h:g	()I
    //   61: invokestatic 301	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   64: putfield 90	com/unionpay/sdk/w$e:b	Ljava/lang/String;
    //   67: getstatic 14	com/unionpay/sdk/ac:b	Lcom/unionpay/sdk/w$e;
    //   70: getstatic 553	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   73: putfield 102	com/unionpay/sdk/w$e:d	Ljava/lang/String;
    //   76: getstatic 14	com/unionpay/sdk/ac:b	Lcom/unionpay/sdk/w$e;
    //   79: getstatic 22	com/unionpay/sdk/d:c	Landroid/content/Context;
    //   82: invokestatic 554	com/unionpay/sdk/h:c	(Landroid/content/Context;)Ljava/lang/String;
    //   85: putfield 103	com/unionpay/sdk/w$e:e	Ljava/lang/String;
    //   88: getstatic 14	com/unionpay/sdk/ac:b	Lcom/unionpay/sdk/w$e;
    //   91: invokestatic 556	com/unionpay/sdk/h:j	()Ljava/lang/String;
    //   94: putfield 104	com/unionpay/sdk/w$e:f	Ljava/lang/String;
    //   97: getstatic 14	com/unionpay/sdk/ac:b	Lcom/unionpay/sdk/w$e;
    //   100: getstatic 22	com/unionpay/sdk/d:c	Landroid/content/Context;
    //   103: invokestatic 560	com/unionpay/sdk/j:p	(Landroid/content/Context;)Ljava/lang/String;
    //   106: putfield 105	com/unionpay/sdk/w$e:g	Ljava/lang/String;
    //   109: getstatic 14	com/unionpay/sdk/ac:b	Lcom/unionpay/sdk/w$e;
    //   112: invokestatic 562	com/unionpay/sdk/h:i	()Ljava/lang/String;
    //   115: putfield 107	com/unionpay/sdk/w$e:h	Ljava/lang/String;
    //   118: getstatic 14	com/unionpay/sdk/ac:b	Lcom/unionpay/sdk/w$e;
    //   121: invokestatic 568	java/util/TimeZone:getDefault	()Ljava/util/TimeZone;
    //   124: invokevirtual 571	java/util/TimeZone:getRawOffset	()I
    //   127: sipush 1000
    //   130: idiv
    //   131: bipush 60
    //   133: idiv
    //   134: bipush 60
    //   136: idiv
    //   137: putfield 110	com/unionpay/sdk/w$e:i	I
    //   140: getstatic 14	com/unionpay/sdk/ac:b	Lcom/unionpay/sdk/w$e;
    //   143: new 343	java/lang/StringBuilder
    //   146: dup
    //   147: ldc_w 573
    //   150: invokespecial 348	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   153: getstatic 578	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   156: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: putfield 113	com/unionpay/sdk/w$e:j	Ljava/lang/String;
    //   165: getstatic 22	com/unionpay/sdk/d:c	Landroid/content/Context;
    //   168: invokestatic 398	com/unionpay/sdk/h:a	(Landroid/content/Context;)Lorg/json/JSONObject;
    //   171: astore_0
    //   172: aload_0
    //   173: ifnull +13 -> 186
    //   176: getstatic 14	com/unionpay/sdk/ac:b	Lcom/unionpay/sdk/w$e;
    //   179: aload_0
    //   180: invokevirtual 401	org/json/JSONObject:toString	()Ljava/lang/String;
    //   183: putfield 155	com/unionpay/sdk/w$e:x	Ljava/lang/String;
    //   186: invokestatic 580	com/unionpay/sdk/ac:d	()V
    //   189: getstatic 14	com/unionpay/sdk/ac:b	Lcom/unionpay/sdk/w$e;
    //   192: astore_0
    //   193: goto -174 -> 19
    //   196: astore_0
    //   197: ldc 2
    //   199: monitorexit
    //   200: aload_0
    //   201: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	181	0	localObject1	Object
    //   196	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	196	finally
    //   24	172	196	finally
    //   176	186	196	finally
    //   186	193	196	finally
  }
  
  private static void d()
  {
    Object localObject2 = q.a(d.c);
    Object localObject1 = null;
    Iterator localIterator = ((List)localObject2).iterator();
    Location localLocation;
    if (localIterator.hasNext())
    {
      localLocation = (Location)localIterator.next();
      localObject2 = localLocation;
      if (localObject1 != null) {
        if (localLocation.getTime() <= ((Location)localObject1).getTime()) {
          break label242;
        }
      }
    }
    label234:
    label242:
    for (localObject2 = localLocation;; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      localObject2 = new w.h();
      if (localObject1 != null)
      {
        ((w.h)localObject2).b = ((Location)localObject1).getLatitude();
        ((w.h)localObject2).a = ((Location)localObject1).getLongitude();
      }
      b.c = ((w.h)localObject2);
      localObject1 = b;
      int i;
      if (j.g(d.c))
      {
        i = 0;
        ((w.e)localObject1).k = i;
        b.l = j.i(d.c);
        b.o = j.k(d.c);
        b.n = j.l(d.c);
        b.p = q.b(d.c);
        b.t = j.r(d.c).toString();
        localObject1 = q.d(d.c);
        if ((e()) || (new Random().nextInt(100) > 90))
        {
          localObject2 = b;
          if (localObject1 != null) {
            break label234;
          }
        }
      }
      for (localObject1 = "";; localObject1 = ((JSONArray)localObject1).toString())
      {
        ((w.e)localObject2).u = ((String)localObject1);
        return;
        i = 1;
        break;
      }
    }
  }
  
  /* Error */
  private static boolean e()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 22	com/unionpay/sdk/d:c	Landroid/content/Context;
    //   8: ldc_w 503
    //   11: ldc_w 505
    //   14: lconst_1
    //   15: invokestatic 627	com/unionpay/sdk/l:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J
    //   18: lstore_1
    //   19: getstatic 162	com/unionpay/sdk/ag:a	Z
    //   22: ifeq +30 -> 52
    //   25: iconst_1
    //   26: anewarray 164	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: new 343	java/lang/StringBuilder
    //   34: dup
    //   35: ldc_w 629
    //   38: invokespecial 348	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: lload_1
    //   42: invokevirtual 632	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   45: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: aastore
    //   49: invokestatic 171	com/unionpay/sdk/k:b	([Ljava/lang/String;)V
    //   52: lload_1
    //   53: lconst_0
    //   54: lcmp
    //   55: ifeq +8 -> 63
    //   58: ldc 2
    //   60: monitorexit
    //   61: iload_0
    //   62: ireturn
    //   63: iconst_0
    //   64: istore_0
    //   65: goto -7 -> 58
    //   68: astore_3
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	64	0	bool	boolean
    //   18	35	1	l	long
    //   68	5	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	52	68	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */