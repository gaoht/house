package com.baidu.location.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.storage.StorageManager;
import com.baidu.location.f;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class i
{
  public static String a = a().b() + "/baidu/tempdata";
  private static volatile i c = null;
  private final List<h> b = new ArrayList();
  private Context d;
  
  private i(Context paramContext)
  {
    this.d = paramContext;
  }
  
  public static i a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new i(f.getServiceContext());
      }
      return c;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 62	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: ldc 64
    //   7: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 71	java/io/File:exists	()Z
    //   15: ifeq +8 -> 23
    //   18: aload_1
    //   19: invokevirtual 74	java/io/File:delete	()Z
    //   22: pop
    //   23: aload_1
    //   24: invokevirtual 77	java/io/File:createNewFile	()Z
    //   27: istore_2
    //   28: aload_1
    //   29: invokevirtual 71	java/io/File:exists	()Z
    //   32: ifeq +8 -> 40
    //   35: aload_1
    //   36: invokevirtual 74	java/io/File:delete	()Z
    //   39: pop
    //   40: iload_2
    //   41: ireturn
    //   42: astore_1
    //   43: iconst_0
    //   44: istore_2
    //   45: aload_1
    //   46: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   49: iload_2
    //   50: ireturn
    //   51: astore_1
    //   52: goto -7 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	i
    //   0	55	1	paramString	String
    //   27	23	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	23	42	java/lang/Exception
    //   23	28	42	java/lang/Exception
    //   28	40	51	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(14)
  private List<h> d()
  {
    try
    {
      localObject2 = (StorageManager)this.d.getSystemService("storage");
      localObject1 = localObject2.getClass().getMethod("getVolumeList", new Class[0]);
      localObject3 = localObject2.getClass().getMethod("getVolumeState", new Class[] { String.class });
      localObject5 = Class.forName("android.os.storage.StorageVolume");
      localObject4 = ((Class)localObject5).getMethod("isRemovable", new Class[0]);
      localObject5 = ((Class)localObject5).getMethod("getPath", new Class[0]);
      arrayOfObject = (Object[])((Method)localObject1).invoke(localObject2, new Object[0]);
      if (arrayOfObject == null) {
        break label333;
      }
      k = arrayOfObject.length;
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject1;
        Object localObject3;
        Object localObject5;
        Object localObject4;
        Object[] arrayOfObject;
        int k;
        String str2;
        List localList;
        localException.printStackTrace();
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        int i;
        label200:
        boolean bool;
        label233:
        label333:
        localError.printStackTrace();
        continue;
        int j = 0;
        continue;
        for (;;)
        {
          label463:
          if (j == 0) {
            break label492;
          }
          str1 = "Internal Storage";
          break label233;
          label474:
          i += 1;
          break;
          label481:
          j = 0;
          break label200;
          label486:
          bool = false;
        }
        label492:
        String str1 = "External Storage";
      }
    }
    if (i < k)
    {
      localObject1 = arrayOfObject[i];
      str2 = (String)((Method)localObject5).invoke(localObject1, new Object[0]);
      if ((str2 == null) || (str2.length() <= 0)) {
        break label474;
      }
      if (!"mounted".equals(((Method)localObject3).invoke(localObject2, new Object[] { str2 }))) {
        break label474;
      }
      if (((Boolean)((Method)localObject4).invoke(localObject1, new Object[0])).booleanValue()) {
        break label481;
      }
      j = 1;
      if ((Build.VERSION.SDK_INT > 19) || (!a(str2))) {
        break label474;
      }
      localList = this.b;
      if (j != 0) {
        break label486;
      }
      bool = true;
      break label463;
      localList.add(new h(str2, bool, (String)localObject1));
      break label474;
    }
    else
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        localObject1 = this.d.getExternalFilesDirs(null);
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(this.b);
        i = 0;
      }
      for (;;)
      {
        if ((i >= localObject1.length) || (localObject1[i] == null))
        {
          this.b.clear();
          this.b.addAll((Collection)localObject2);
          return this.b;
        }
        localObject3 = localObject1[i].getAbsolutePath();
        localObject4 = this.b.iterator();
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
        } while (!((String)localObject3).startsWith(((h)((Iterator)localObject4).next()).a()));
        j = 1;
        if ((j == 0) && (((String)localObject3).indexOf(this.d.getPackageName()) != -1)) {
          ((List)localObject2).add(new h((String)localObject3, true, "External Storage"));
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  private List<h> e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 44	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 45	java/util/ArrayList:<init>	()V
    //   10: astore 7
    //   12: new 44	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 45	java/util/ArrayList:<init>	()V
    //   19: astore 6
    //   21: new 62	java/io/File
    //   24: dup
    //   25: ldc -41
    //   27: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 71	java/io/File:exists	()Z
    //   35: ifeq +106 -> 141
    //   38: new 220	java/util/Scanner
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 223	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   46: astore_2
    //   47: aload_2
    //   48: astore_1
    //   49: aload_2
    //   50: invokevirtual 224	java/util/Scanner:hasNext	()Z
    //   53: ifeq +82 -> 135
    //   56: aload_2
    //   57: astore_1
    //   58: aload_2
    //   59: invokevirtual 227	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   62: astore_3
    //   63: aload_2
    //   64: astore_1
    //   65: aload_3
    //   66: ldc -27
    //   68: invokevirtual 197	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   71: ifeq -24 -> 47
    //   74: aload_2
    //   75: astore_1
    //   76: aload_3
    //   77: bipush 9
    //   79: bipush 32
    //   81: invokevirtual 233	java/lang/String:replace	(CC)Ljava/lang/String;
    //   84: ldc -21
    //   86: invokevirtual 239	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   89: astore_3
    //   90: aload_3
    //   91: ifnull -44 -> 47
    //   94: aload_2
    //   95: astore_1
    //   96: aload_3
    //   97: arraylength
    //   98: ifle -51 -> 47
    //   101: aload_2
    //   102: astore_1
    //   103: aload 7
    //   105: aload_3
    //   106: iconst_1
    //   107: aaload
    //   108: invokeinterface 165 2 0
    //   113: pop
    //   114: goto -67 -> 47
    //   117: astore_2
    //   118: aload_2
    //   119: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 242	java/util/Scanner:close	()V
    //   130: aload_0
    //   131: getfield 47	com/baidu/location/d/i:b	Ljava/util/List;
    //   134: areturn
    //   135: aload_2
    //   136: astore_1
    //   137: aload_2
    //   138: invokevirtual 242	java/util/Scanner:close	()V
    //   141: new 62	java/io/File
    //   144: dup
    //   145: ldc -12
    //   147: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;)V
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 71	java/io/File:exists	()Z
    //   155: ifeq +133 -> 288
    //   158: new 220	java/util/Scanner
    //   161: dup
    //   162: aload_1
    //   163: invokespecial 223	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   166: astore_2
    //   167: aload_2
    //   168: astore_1
    //   169: aload_2
    //   170: invokevirtual 224	java/util/Scanner:hasNext	()Z
    //   173: ifeq +109 -> 282
    //   176: aload_2
    //   177: astore_1
    //   178: aload_2
    //   179: invokevirtual 227	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   182: astore_3
    //   183: aload_2
    //   184: astore_1
    //   185: aload_3
    //   186: ldc -10
    //   188: invokevirtual 197	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   191: ifeq -24 -> 167
    //   194: aload_2
    //   195: astore_1
    //   196: aload_3
    //   197: bipush 9
    //   199: bipush 32
    //   201: invokevirtual 233	java/lang/String:replace	(CC)Ljava/lang/String;
    //   204: ldc -21
    //   206: invokevirtual 239	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   209: astore_3
    //   210: aload_3
    //   211: ifnull -44 -> 167
    //   214: aload_2
    //   215: astore_1
    //   216: aload_3
    //   217: arraylength
    //   218: ifle -51 -> 167
    //   221: aload_3
    //   222: iconst_2
    //   223: aaload
    //   224: astore 5
    //   226: aload_2
    //   227: astore_1
    //   228: aload 5
    //   230: astore_3
    //   231: aload 5
    //   233: ldc -8
    //   235: invokevirtual 252	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   238: ifeq +19 -> 257
    //   241: aload_2
    //   242: astore_1
    //   243: aload 5
    //   245: iconst_0
    //   246: aload 5
    //   248: ldc -8
    //   250: invokevirtual 204	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   253: invokevirtual 256	java/lang/String:substring	(II)Ljava/lang/String;
    //   256: astore_3
    //   257: aload_2
    //   258: astore_1
    //   259: aload 6
    //   261: aload_3
    //   262: invokeinterface 165 2 0
    //   267: pop
    //   268: goto -101 -> 167
    //   271: astore_1
    //   272: aload_2
    //   273: ifnull +7 -> 280
    //   276: aload_2
    //   277: invokevirtual 242	java/util/Scanner:close	()V
    //   280: aload_1
    //   281: athrow
    //   282: aload_2
    //   283: astore_1
    //   284: aload_2
    //   285: invokevirtual 242	java/util/Scanner:close	()V
    //   288: invokestatic 262	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   291: invokevirtual 179	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   294: astore_1
    //   295: aload_0
    //   296: getfield 47	com/baidu/location/d/i:b	Ljava/util/List;
    //   299: new 157	com/baidu/location/d/h
    //   302: dup
    //   303: aload_1
    //   304: iconst_0
    //   305: ldc_w 264
    //   308: invokespecial 160	com/baidu/location/d/h:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   311: invokeinterface 165 2 0
    //   316: pop
    //   317: aload 7
    //   319: invokeinterface 183 1 0
    //   324: astore_2
    //   325: aload_2
    //   326: invokeinterface 188 1 0
    //   331: ifeq +97 -> 428
    //   334: aload_2
    //   335: invokeinterface 192 1 0
    //   340: checkcast 114	java/lang/String
    //   343: astore_3
    //   344: aload 6
    //   346: aload_3
    //   347: invokeinterface 266 2 0
    //   352: ifeq -27 -> 325
    //   355: aload_3
    //   356: aload_1
    //   357: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   360: ifne -35 -> 325
    //   363: new 62	java/io/File
    //   366: dup
    //   367: aload_3
    //   368: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;)V
    //   371: astore 5
    //   373: aload 5
    //   375: invokevirtual 71	java/io/File:exists	()Z
    //   378: ifeq -53 -> 325
    //   381: aload 5
    //   383: invokevirtual 269	java/io/File:isDirectory	()Z
    //   386: ifeq -61 -> 325
    //   389: aload 5
    //   391: invokevirtual 272	java/io/File:canWrite	()Z
    //   394: ifeq -69 -> 325
    //   397: aload_0
    //   398: getfield 47	com/baidu/location/d/i:b	Ljava/util/List;
    //   401: new 157	com/baidu/location/d/h
    //   404: dup
    //   405: aload_3
    //   406: iconst_0
    //   407: ldc_w 264
    //   410: invokespecial 160	com/baidu/location/d/h:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   413: invokeinterface 165 2 0
    //   418: pop
    //   419: goto -94 -> 325
    //   422: astore_2
    //   423: aconst_null
    //   424: astore_1
    //   425: goto -307 -> 118
    //   428: iconst_0
    //   429: ifeq -299 -> 130
    //   432: new 274	java/lang/NullPointerException
    //   435: dup
    //   436: invokespecial 275	java/lang/NullPointerException:<init>	()V
    //   439: athrow
    //   440: astore_1
    //   441: aload 4
    //   443: astore_2
    //   444: goto -172 -> 272
    //   447: astore_1
    //   448: goto -176 -> 272
    //   451: astore_3
    //   452: aload_1
    //   453: astore_2
    //   454: aload_3
    //   455: astore_1
    //   456: goto -184 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	this	i
    //   30	229	1	localObject1	Object
    //   271	10	1	localObject2	Object
    //   283	142	1	localObject3	Object
    //   440	1	1	localObject4	Object
    //   447	6	1	localObject5	Object
    //   455	1	1	localObject6	Object
    //   46	56	2	localScanner	java.util.Scanner
    //   117	21	2	localException1	Exception
    //   166	169	2	localObject7	Object
    //   422	1	2	localException2	Exception
    //   443	11	2	localObject8	Object
    //   62	344	3	localObject9	Object
    //   451	4	3	localObject10	Object
    //   1	441	4	localObject11	Object
    //   224	166	5	localFile	File
    //   19	326	6	localArrayList1	ArrayList
    //   10	308	7	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   49	56	117	java/lang/Exception
    //   58	63	117	java/lang/Exception
    //   65	74	117	java/lang/Exception
    //   76	90	117	java/lang/Exception
    //   96	101	117	java/lang/Exception
    //   103	114	117	java/lang/Exception
    //   137	141	117	java/lang/Exception
    //   169	176	117	java/lang/Exception
    //   178	183	117	java/lang/Exception
    //   185	194	117	java/lang/Exception
    //   196	210	117	java/lang/Exception
    //   216	221	117	java/lang/Exception
    //   231	241	117	java/lang/Exception
    //   243	257	117	java/lang/Exception
    //   259	268	117	java/lang/Exception
    //   284	288	117	java/lang/Exception
    //   169	176	271	finally
    //   178	183	271	finally
    //   185	194	271	finally
    //   196	210	271	finally
    //   216	221	271	finally
    //   231	241	271	finally
    //   243	257	271	finally
    //   259	268	271	finally
    //   284	288	271	finally
    //   21	47	422	java/lang/Exception
    //   141	167	422	java/lang/Exception
    //   288	325	422	java/lang/Exception
    //   325	419	422	java/lang/Exception
    //   21	47	440	finally
    //   141	167	440	finally
    //   288	325	440	finally
    //   325	419	440	finally
    //   49	56	447	finally
    //   58	63	447	finally
    //   65	74	447	finally
    //   76	90	447	finally
    //   96	101	447	finally
    //   103	114	447	finally
    //   137	141	447	finally
    //   118	122	451	finally
  }
  
  public String b()
  {
    List localList = c();
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    return ((h)localList.get(0)).a();
  }
  
  public List<h> c()
  {
    List localList = null;
    if (Build.VERSION.SDK_INT >= 14) {
      localList = d();
    }
    if ((localList != null) && (localList.size() > 0)) {
      return localList;
    }
    return e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */