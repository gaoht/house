package com.mob.commons.clt;

import android.os.Build.VERSION;
import android.os.Message;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.Strings;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RtClt
  extends a
  implements PublicMemberKeeper
{
  private static final String a;
  private Process b = null;
  private OutputStream c = null;
  private String d = null;
  private long e = 0L;
  private boolean f = true;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (String str = "^u\\d+_a\\d+";; str = "^app_\\d+")
    {
      a = str;
      return;
    }
  }
  
  private ArrayList<HashMap<String, Object>> a(HashMap<String, String>[][] paramArrayOfHashMap, ArrayList<long[]> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfHashMap.length);
    int i = 0;
    while (i < paramArrayOfHashMap.length)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("runtimes", Long.valueOf(0L));
      localHashMap.put("fg", Integer.valueOf(0));
      localHashMap.put("bg", Integer.valueOf(0));
      localHashMap.put("empty", Integer.valueOf(0));
      localArrayList.add(localHashMap);
      HashMap<String, String>[] arrayOfHashMap = paramArrayOfHashMap[i];
      int j = arrayOfHashMap.length - 1;
      if (j >= 0)
      {
        long l1;
        if (arrayOfHashMap[j] != null)
        {
          long l2 = ((Long)ResHelper.forceCast(localHashMap.get("runtimes"), Long.valueOf(0L))).longValue();
          if (j != 0) {
            break label269;
          }
          l1 = 0L;
          label139:
          localHashMap.put("runtimes", Long.valueOf(l1 + l2));
          if (!"fg".equals(arrayOfHashMap[j].get("pcy"))) {
            break label285;
          }
          localHashMap.put("fg", Integer.valueOf(((Integer)ResHelper.forceCast(localHashMap.get("fg"), Integer.valueOf(0))).intValue() + 1));
        }
        for (;;)
        {
          localHashMap.put("pkg", arrayOfHashMap[j].get("pkg"));
          localHashMap.put("name", arrayOfHashMap[j].get("name"));
          localHashMap.put("version", arrayOfHashMap[j].get("version"));
          j -= 1;
          break;
          label269:
          l1 = ((long[])paramArrayList.get(j))[1];
          break label139;
          label285:
          if ("bg".equals(arrayOfHashMap[j].get("pcy"))) {
            localHashMap.put("bg", Integer.valueOf(((Integer)ResHelper.forceCast(localHashMap.get("bg"), Integer.valueOf(0))).intValue() + 1));
          } else {
            localHashMap.put("empty", Integer.valueOf(((Integer)ResHelper.forceCast(localHashMap.get("empty"), Integer.valueOf(0))).intValue() + 1));
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private HashMap<String, Integer> a(ArrayList<ArrayList<HashMap<String, String>>> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      Iterator localIterator = ((ArrayList)paramArrayList.next()).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (HashMap)localIterator.next();
        localObject = (String)((HashMap)localObject).get("pkg") + ":" + (String)((HashMap)localObject).get("version");
        if (!localHashMap.containsKey(localObject))
        {
          localHashMap.put(localObject, Integer.valueOf(i));
          i += 1;
        }
      }
    }
    return localHashMap;
  }
  
  /* Error */
  private void a(String paramString, ArrayList<ArrayList<HashMap<String, String>>> paramArrayList, ArrayList<long[]> paramArrayList1)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 157	com/mob/commons/clt/RtClt:k	()Ljava/util/HashMap;
    //   4: astore 11
    //   6: new 159	java/io/BufferedReader
    //   9: dup
    //   10: new 161	java/io/InputStreamReader
    //   13: dup
    //   14: new 163	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 166	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: ldc -88
    //   24: invokespecial 171	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   27: invokespecial 174	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   30: astore 12
    //   32: aload 12
    //   34: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore_1
    //   38: iconst_0
    //   39: istore 4
    //   41: iload 4
    //   43: bipush 7
    //   45: if_icmpge +18 -> 63
    //   48: aload 12
    //   50: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore_1
    //   54: iload 4
    //   56: iconst_1
    //   57: iadd
    //   58: istore 4
    //   60: goto -19 -> 41
    //   63: new 48	java/util/ArrayList
    //   66: dup
    //   67: invokespecial 178	java/util/ArrayList:<init>	()V
    //   70: astore 9
    //   72: aload_1
    //   73: astore 10
    //   75: aload 9
    //   77: astore_1
    //   78: aload 10
    //   80: ifnull +149 -> 229
    //   83: ldc -76
    //   85: aload 10
    //   87: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifeq +103 -> 193
    //   93: aload 12
    //   95: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore 9
    //   100: aload 9
    //   102: ldc -74
    //   104: invokevirtual 186	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   107: astore 9
    //   109: aload 9
    //   111: iconst_0
    //   112: aaload
    //   113: invokestatic 189	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   116: invokevirtual 94	java/lang/Long:longValue	()J
    //   119: lstore 5
    //   121: aload 9
    //   123: iconst_1
    //   124: aaload
    //   125: invokestatic 189	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   128: invokevirtual 94	java/lang/Long:longValue	()J
    //   131: lstore 7
    //   133: aload_2
    //   134: aload_1
    //   135: invokevirtual 81	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   138: pop
    //   139: aload_3
    //   140: iconst_2
    //   141: newarray <illegal type>
    //   143: dup
    //   144: iconst_0
    //   145: lload 5
    //   147: lastore
    //   148: dup
    //   149: iconst_1
    //   150: lload 7
    //   152: lastore
    //   153: invokevirtual 81	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   156: pop
    //   157: new 48	java/util/ArrayList
    //   160: dup
    //   161: invokespecial 178	java/util/ArrayList:<init>	()V
    //   164: astore_1
    //   165: iconst_0
    //   166: istore 4
    //   168: aload_1
    //   169: astore 9
    //   171: iload 4
    //   173: bipush 7
    //   175: if_icmpge +41 -> 216
    //   178: aload 12
    //   180: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   183: pop
    //   184: iload 4
    //   186: iconst_1
    //   187: iadd
    //   188: istore 4
    //   190: goto -22 -> 168
    //   193: aload_1
    //   194: astore 9
    //   196: aload 10
    //   198: invokevirtual 192	java/lang/String:length	()I
    //   201: ifle +15 -> 216
    //   204: aload_0
    //   205: aload 10
    //   207: aload 11
    //   209: aload_1
    //   210: invokespecial 195	com/mob/commons/clt/RtClt:a	(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/ArrayList;)V
    //   213: aload_1
    //   214: astore 9
    //   216: aload 12
    //   218: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   221: astore 10
    //   223: aload 9
    //   225: astore_1
    //   226: goto -148 -> 78
    //   229: aload 12
    //   231: invokevirtual 198	java/io/BufferedReader:close	()V
    //   234: return
    //   235: astore_1
    //   236: invokestatic 204	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   239: aload_1
    //   240: invokevirtual 209	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   243: pop
    //   244: return
    //   245: astore_1
    //   246: goto -89 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	RtClt
    //   0	249	1	paramString	String
    //   0	249	2	paramArrayList	ArrayList<ArrayList<HashMap<String, String>>>
    //   0	249	3	paramArrayList1	ArrayList<long[]>
    //   39	150	4	i	int
    //   119	27	5	l1	long
    //   131	20	7	l2	long
    //   70	154	9	localObject	Object
    //   73	149	10	str	String
    //   4	204	11	localHashMap	HashMap
    //   30	200	12	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   0	38	235	java/lang/Throwable
    //   48	54	235	java/lang/Throwable
    //   63	72	235	java/lang/Throwable
    //   83	100	235	java/lang/Throwable
    //   157	165	235	java/lang/Throwable
    //   178	184	235	java/lang/Throwable
    //   196	213	235	java/lang/Throwable
    //   216	223	235	java/lang/Throwable
    //   229	234	235	java/lang/Throwable
    //   100	157	245	java/lang/Throwable
  }
  
  private void a(String paramString, HashMap<String, String[]> paramHashMap, ArrayList<HashMap<String, String>> paramArrayList)
  {
    paramString = paramString.replaceAll(" +", " ").split(" ");
    if ((paramString != null) && (paramString.length >= 10))
    {
      Object localObject = paramString[(paramString.length - 1)];
      if ((paramString[(paramString.length - 2)].matches(a)) && (!"top".equals(localObject)))
      {
        paramHashMap = (String[])paramHashMap.get(localObject);
        if (paramHashMap != null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("pkg", localObject);
          localHashMap.put("name", paramHashMap[0]);
          localHashMap.put("version", paramHashMap[1]);
          localHashMap.put("pcy", paramString[(paramString.length - 3)]);
          paramArrayList.add(localHashMap);
        }
      }
    }
  }
  
  private void a(ArrayList<HashMap<String, Object>> paramArrayList, ArrayList<long[]> paramArrayList1)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "APP_RUNTIMES");
    localHashMap.put("list", paramArrayList);
    localHashMap.put("datetime", Long.valueOf(com.mob.commons.a.a()));
    localHashMap.put("recordat", Long.valueOf(((long[])paramArrayList1.get(0))[0]));
    long l = 0L;
    int i = 1;
    while (i < paramArrayList1.size())
    {
      l += ((long[])paramArrayList1.get(i))[1];
      i += 1;
    }
    localHashMap.put("sdk_runtime_len", Long.valueOf(l));
    localHashMap.put("top_count", Integer.valueOf(paramArrayList1.size()));
    b.a().a(com.mob.commons.a.a(), localHashMap);
  }
  
  private boolean a(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(paramString, localArrayList1, localArrayList2);
    a(a(a(a(localArrayList1), localArrayList1), localArrayList2), localArrayList2);
    return b(paramString);
  }
  
  private HashMap<String, String>[][] a(HashMap<String, Integer> paramHashMap, ArrayList<ArrayList<HashMap<String, String>>> paramArrayList)
  {
    HashMap[][] arrayOfHashMap = (HashMap[][])Array.newInstance(HashMap.class, new int[] { paramHashMap.size(), paramArrayList.size() });
    int k = paramArrayList.size();
    int i = 0;
    while (i < k)
    {
      ArrayList localArrayList = (ArrayList)paramArrayList.get(i);
      int m = localArrayList.size();
      int j = 0;
      while (j < m)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(j);
        arrayOfHashMap[((Integer)paramHashMap.get((String)localHashMap.get("pkg") + ":" + (String)localHashMap.get("version"))).intValue()][i] = localHashMap;
        j += 1;
      }
      i += 1;
    }
    return arrayOfHashMap;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      paramString.delete();
      paramString.createNewFile();
      return true;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().d(paramString);
    }
    return false;
  }
  
  private void g()
    throws Throwable
  {
    if ((this.c != null) && (!TextUtils.isEmpty(this.d))) {}
    File localFile;
    do
    {
      return;
      localFile = ResHelper.getCacheRootFile(MobSDK.getContext(), "comm/dbs/.plst");
    } while (localFile == null);
    if (!localFile.exists()) {
      localFile.createNewFile();
    }
    this.d = localFile.getAbsolutePath();
    this.e = i();
    this.f = true;
    this.c = null;
    this.b = Runtime.getRuntime().exec(Strings.getString(46));
    this.c = this.b.getOutputStream();
  }
  
  private void h()
  {
    try
    {
      g();
      long l;
      String str;
      if (com.mob.commons.a.c())
      {
        l = com.mob.commons.a.a();
        str = Strings.getString(47) + " " + this.d + Strings.getString(48) + "\"" + "======================" + "\" >> " + this.d + "\n";
        this.c.write(str.getBytes("ascii"));
        if (!this.f) {
          break label312;
        }
        str = Strings.getString(49) + "\"" + l + "_0\" >> " + this.d + "\n";
        this.f = false;
      }
      for (;;)
      {
        this.c.write(str.getBytes("ascii"));
        this.c.flush();
        if (l >= this.e)
        {
          this.c.write((Strings.getString(50) + "\n").getBytes("ascii"));
          this.c.flush();
          this.c.close();
          this.b.waitFor();
          this.b.destroy();
          if (a(this.d))
          {
            l = j();
            if (l > 0L) {
              this.e = l;
            }
            this.f = true;
          }
        }
        try
        {
          this.b = Runtime.getRuntime().exec(Strings.getString(46));
          this.c = this.b.getOutputStream();
          return;
        }
        catch (Throwable localThrowable1)
        {
          label312:
          MobLog.getInstance().w(localThrowable1);
          return;
        }
        str = Strings.getString(49) + "\"" + l + "_" + com.mob.commons.a.d() + "\" >> " + this.d + "\n";
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      MobLog.getInstance().d(localThrowable2);
    }
  }
  
  private long i()
  {
    long l1 = com.mob.commons.a.a();
    try
    {
      Object localObject = ResHelper.getCacheRootFile(MobSDK.getContext(), "comm/dbs/.nulplt");
      if (((File)localObject).exists())
      {
        localObject = new DataInputStream(new FileInputStream((File)localObject));
        l2 = ((DataInputStream)localObject).readLong();
        ((DataInputStream)localObject).close();
        return l2;
      }
      ((File)localObject).createNewFile();
      j();
      long l2 = com.mob.commons.a.t();
      return l2 + l1;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return com.mob.commons.a.t() + l1;
  }
  
  private long j()
  {
    long l = com.mob.commons.a.a() + com.mob.commons.a.t();
    try
    {
      DataOutputStream localDataOutputStream = new DataOutputStream(new FileOutputStream(ResHelper.getCacheRootFile(MobSDK.getContext(), "comm/dbs/.nulplt")));
      localDataOutputStream.writeLong(l);
      localDataOutputStream.flush();
      localDataOutputStream.close();
      return l;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return 0L;
  }
  
  private HashMap<String, String[]> k()
  {
    Object localObject = l();
    HashMap localHashMap1 = new HashMap();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      HashMap localHashMap2 = (HashMap)((Iterator)localObject).next();
      localHashMap1.put((String)localHashMap2.get("pkg"), new String[] { (String)localHashMap2.get("name"), (String)localHashMap2.get("version") });
    }
    return localHashMap1;
  }
  
  /* Error */
  private ArrayList<HashMap<String, String>> l()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 303	com/mob/MobSDK:getContext	()Landroid/content/Context;
    //   5: invokestatic 433	com/mob/tools/utils/DeviceHelper:getInstance	(Landroid/content/Context;)Lcom/mob/tools/utils/DeviceHelper;
    //   8: iconst_0
    //   9: invokevirtual 437	com/mob/tools/utils/DeviceHelper:getInstalledApp	(Z)Ljava/util/ArrayList;
    //   12: astore_2
    //   13: aload_2
    //   14: astore_1
    //   15: aload_1
    //   16: ifnonnull +150 -> 166
    //   19: invokestatic 303	com/mob/MobSDK:getContext	()Landroid/content/Context;
    //   22: ldc_w 439
    //   25: invokestatic 309	com/mob/tools/utils/ResHelper:getCacheRootFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull +136 -> 166
    //   33: aload_2
    //   34: invokevirtual 312	java/io/File:exists	()Z
    //   37: ifeq +129 -> 166
    //   40: new 48	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 178	java/util/ArrayList:<init>	()V
    //   47: astore_3
    //   48: new 159	java/io/BufferedReader
    //   51: dup
    //   52: new 161	java/io/InputStreamReader
    //   55: dup
    //   56: new 441	java/util/zip/GZIPInputStream
    //   59: dup
    //   60: new 163	java/io/FileInputStream
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 399	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   68: invokespecial 442	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: ldc -88
    //   73: invokespecial 171	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   76: invokespecial 174	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   79: astore 4
    //   81: aload 4
    //   83: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   86: astore_2
    //   87: aload_2
    //   88: ifnull +46 -> 134
    //   91: new 444	com/mob/tools/utils/Hashon
    //   94: dup
    //   95: invokespecial 445	com/mob/tools/utils/Hashon:<init>	()V
    //   98: aload_2
    //   99: invokevirtual 449	com/mob/tools/utils/Hashon:fromJson	(Ljava/lang/String;)Ljava/util/HashMap;
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +9 -> 113
    //   107: aload_3
    //   108: aload_2
    //   109: invokevirtual 81	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   112: pop
    //   113: aload 4
    //   115: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   118: astore_2
    //   119: goto -32 -> 87
    //   122: astore_2
    //   123: invokestatic 204	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   126: aload_2
    //   127: invokevirtual 392	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   130: pop
    //   131: goto -116 -> 15
    //   134: aload 4
    //   136: invokevirtual 198	java/io/BufferedReader:close	()V
    //   139: aload_3
    //   140: astore_1
    //   141: aload_1
    //   142: astore_2
    //   143: aload_1
    //   144: ifnonnull +11 -> 155
    //   147: new 48	java/util/ArrayList
    //   150: dup
    //   151: invokespecial 178	java/util/ArrayList:<init>	()V
    //   154: astore_2
    //   155: aload_2
    //   156: areturn
    //   157: astore_2
    //   158: invokestatic 204	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   161: aload_2
    //   162: invokevirtual 209	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   165: pop
    //   166: goto -25 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	RtClt
    //   1	143	1	localObject1	Object
    //   12	107	2	localObject2	Object
    //   122	5	2	localThrowable1	Throwable
    //   142	14	2	localObject3	Object
    //   157	5	2	localThrowable2	Throwable
    //   47	93	3	localArrayList	ArrayList
    //   79	56	4	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   2	13	122	java/lang/Throwable
    //   40	87	157	java/lang/Throwable
    //   91	103	157	java/lang/Throwable
    //   107	113	157	java/lang/Throwable
    //   113	119	157	java/lang/Throwable
    //   134	139	157	java/lang/Throwable
  }
  
  protected File a()
  {
    if (Build.VERSION.SDK_INT > 24) {
      return null;
    }
    return c.a("comm/locks/.rc_lock");
  }
  
  protected void a(Message paramMessage)
  {
    h();
    a(0, com.mob.commons.a.d() * 1000);
  }
  
  protected boolean b()
  {
    return com.mob.commons.a.c();
  }
  
  protected void c()
  {
    b(0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/clt/RtClt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */