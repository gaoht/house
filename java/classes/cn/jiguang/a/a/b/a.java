package cn.jiguang.a.a.b;

import android.content.Context;
import cn.jiguang.api.MultiSpHelper;
import cn.jiguang.c.d.l;
import cn.jiguang.d.d;
import cn.jiguang.f.h;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

public final class a
  extends Thread
{
  private static Object c;
  private static Object d;
  private static final String[] z;
  private String a;
  private Context b;
  
  static
  {
    String[] arrayOfString = new String[27];
    int j = 0;
    Object localObject2 = "\022/";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 121;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "uyq\022,@`m";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "G}n\023\034\024hq\021YDhb\n\030Sl!\r\020G}!\022\fWjd\022\n";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "Uyq\022YX`r\025Y]z!\017\fXe-A\013Q}t\023\027";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "G}n\023\034\024hq\021)Ujj\000\036QG`\f\034G3";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "Uju\b\026Z)b\t\034Wb!\016\025P)`\021\t\024y`\002\022UndA\025]zu[";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "Wad\002\022azd\0238DyrA\034Llb\021\r]fo[";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "Xhr\025&Wad\002\022k|r\004\013Uyq>\n@hu\024\n";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "Wfo\025\034L}!\005\020P)o\016\r\024`o\b\r\030)s\004\rA{o";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "Agh\017\n@hm\r\034P)`\021\tdhb\n\030SlO\000\024Q3";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = ">)h\017\n@hm\r\034P)`\021\tdhb\n\030SlO\000\024Q3";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "[eeA\030Dym\b\n@)h\022YZ|m\rU\024{d\025\fFg";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "flq\016\013@\\r\004\013aye\000\rQHq\021\n\024fm\0058Dym\b\n@'r\b\003Q!([";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "wfo\027\034F}3)\030GaR\004\r\024hq\021\025]zuA\016Uz!\017\fXe-A\013Q}t\023\027";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "WhoF\r\024lo\002\026P`o\006YUyq1\030Wb`\006\034zhl\004\n\030)f\b\017Q)t\021YFl`\005Y\016";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "a]GLA";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "Uyq1\030Wb`\006\034zhl\004\n\024`rA\027AemMYFlu\024\013Z)o\024\025X";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "WhoF\r\024{d\000\035\024hq\021)Ujj\000\036QG`\f\034G%!\006\020Bl!\024\t\024{d\000\035\0243";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "WhoF\r\024fq\004\027\024hq\021)Ujj\000\036QG`\f\034G)h\017\tA}R\025\013QhlMYS`w\004YAy!\023\034Um!AC";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "Uyq1\030Wb`\006\034zhl\004\n";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "Uyq\r\020G}!\b\n\024gt\r\025";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "Ghw\004YXffA\020Z)v\023\020@lI\b\n@fs\0305[n";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "Ghw\004YXffA\020Z)v\023\020@lI\b\n@fs\0305[n;k";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "r`m\004\tU}iA\034F{n\023Y[o!:\030DyQ\000\032_hf\0047Udd\022$\024%!\006\020Bl!\024\t\024z`\027\034\0243";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "WhoF\r\024~s\b\rQ)`\021\tdhb\n\030SlO\000\024Qz!MYS`w\004YAy!\022\030Bl![";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "WhoF\r\024lo\002\026P`o\006YUyq1\030Wb`\006\034zhl\004\n\024%!\006\020Bl!\024\t\024z`\027\034\0243";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "WhoF\r\024fq\004\027\024hq\021)Ujj\000\036QG`\f\034G)n\024\rD|u2\rFl`\fU\024nh\027\034\024|qA\nUdAC";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        c = new Object();
        d = new Object();
        return;
        i = 52;
        continue;
        i = 9;
        continue;
        i = 1;
        continue;
        i = 97;
      }
    }
  }
  
  public a(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.a = paramString;
  }
  
  /* Error */
  private static String a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +19 -> 20
    //   4: getstatic 85	cn/jiguang/a/a/b/a:z	[Ljava/lang/String;
    //   7: iconst_1
    //   8: aaload
    //   9: getstatic 85	cn/jiguang/a/a/b/a:z	[Ljava/lang/String;
    //   12: bipush 8
    //   14: aaload
    //   15: invokestatic 113	cn/jiguang/d/d:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: aconst_null
    //   19: areturn
    //   20: aload_0
    //   21: getstatic 85	cn/jiguang/a/a/b/a:z	[Ljava/lang/String;
    //   24: bipush 19
    //   26: aaload
    //   27: invokevirtual 119	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   30: astore_1
    //   31: aload_1
    //   32: astore_0
    //   33: aload_1
    //   34: invokevirtual 125	java/io/FileInputStream:available	()I
    //   37: iconst_1
    //   38: iadd
    //   39: newarray <illegal type>
    //   41: astore_2
    //   42: aload_1
    //   43: astore_0
    //   44: aload_1
    //   45: aload_2
    //   46: invokevirtual 129	java/io/FileInputStream:read	([B)I
    //   49: pop
    //   50: aload_1
    //   51: invokestatic 134	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   54: new 17	java/lang/String
    //   57: dup
    //   58: aload_2
    //   59: getstatic 85	cn/jiguang/a/a/b/a:z	[Ljava/lang/String;
    //   62: bipush 15
    //   64: aaload
    //   65: invokespecial 137	java/lang/String:<init>	([BLjava/lang/String;)V
    //   68: astore_0
    //   69: aload_0
    //   70: invokestatic 142	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   73: ifeq +148 -> 221
    //   76: getstatic 85	cn/jiguang/a/a/b/a:z	[Ljava/lang/String;
    //   79: iconst_1
    //   80: aaload
    //   81: getstatic 85	cn/jiguang/a/a/b/a:z	[Ljava/lang/String;
    //   84: bipush 16
    //   86: aaload
    //   87: invokestatic 144	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_0
    //   93: getstatic 85	cn/jiguang/a/a/b/a:z	[Ljava/lang/String;
    //   96: iconst_1
    //   97: aaload
    //   98: new 146	java/lang/StringBuilder
    //   101: dup
    //   102: getstatic 85	cn/jiguang/a/a/b/a:z	[Ljava/lang/String;
    //   105: bipush 14
    //   107: aaload
    //   108: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: aload_0
    //   112: invokevirtual 152	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   115: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 144	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aconst_null
    //   125: areturn
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_1
    //   130: astore_0
    //   131: getstatic 85	cn/jiguang/a/a/b/a:z	[Ljava/lang/String;
    //   134: iconst_1
    //   135: aaload
    //   136: new 146	java/lang/StringBuilder
    //   139: dup
    //   140: getstatic 85	cn/jiguang/a/a/b/a:z	[Ljava/lang/String;
    //   143: bipush 18
    //   145: aaload
    //   146: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: aload_2
    //   150: invokevirtual 160	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   153: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 144	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_1
    //   163: invokestatic 134	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   166: aconst_null
    //   167: areturn
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_1
    //   171: aload_1
    //   172: astore_0
    //   173: getstatic 85	cn/jiguang/a/a/b/a:z	[Ljava/lang/String;
    //   176: iconst_1
    //   177: aaload
    //   178: new 146	java/lang/StringBuilder
    //   181: dup
    //   182: getstatic 85	cn/jiguang/a/a/b/a:z	[Ljava/lang/String;
    //   185: bipush 17
    //   187: aaload
    //   188: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: aload_2
    //   192: invokevirtual 161	java/io/IOException:getMessage	()Ljava/lang/String;
    //   195: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 144	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload_1
    //   205: invokestatic 134	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   208: aconst_null
    //   209: areturn
    //   210: astore_0
    //   211: aconst_null
    //   212: astore_2
    //   213: aload_0
    //   214: astore_1
    //   215: aload_2
    //   216: invokestatic 134	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   219: aload_1
    //   220: athrow
    //   221: aload_0
    //   222: areturn
    //   223: astore_1
    //   224: aload_0
    //   225: astore_2
    //   226: goto -11 -> 215
    //   229: astore_2
    //   230: goto -59 -> 171
    //   233: astore_2
    //   234: goto -105 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramContext	Context
    //   30	190	1	localObject1	Object
    //   223	1	1	localObject2	Object
    //   41	18	2	arrayOfByte	byte[]
    //   126	24	2	localFileNotFoundException1	FileNotFoundException
    //   168	24	2	localIOException1	IOException
    //   212	14	2	localObject3	Object
    //   229	1	2	localIOException2	IOException
    //   233	1	2	localFileNotFoundException2	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   54	90	92	java/io/UnsupportedEncodingException
    //   20	31	126	java/io/FileNotFoundException
    //   20	31	168	java/io/IOException
    //   20	31	210	finally
    //   33	42	223	finally
    //   44	50	223	finally
    //   131	162	223	finally
    //   173	204	223	finally
    //   33	42	229	java/io/IOException
    //   44	50	229	java/io/IOException
    //   33	42	233	java/io/FileNotFoundException
    //   44	50	233	java/io/FileNotFoundException
  }
  
  private static HashSet<String> a(String paramString)
  {
    int i = 0;
    if (paramString == null)
    {
      d.a(z[1], z[13]);
      paramString = null;
      return paramString;
    }
    String[] arrayOfString = paramString.replace("\000", "").split(z[0]);
    HashSet localHashSet = new HashSet();
    int j = arrayOfString.length;
    for (;;)
    {
      paramString = localHashSet;
      if (i >= j) {
        break;
      }
      localHashSet.add(arrayOfString[i]);
      i += 1;
    }
  }
  
  private void a(ArrayList<f> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      d.a(z[1], z[3]);
    }
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append(((f)paramArrayList.get(i)).b);
        if (i != paramArrayList.size() - 1) {
          localStringBuilder.append(z[0]);
        }
        i += 1;
      }
      d.c(z[1], z[4] + localStringBuilder.toString());
    } while (!a(this.b, localStringBuilder.toString()));
    d.c(z[1], z[2]);
  }
  
  private void a(HashSet<String> paramHashSet)
  {
    if (this.b == null) {
      d.g(z[1], z[8]);
    }
    JSONArray localJSONArray;
    ArrayList localArrayList;
    do
    {
      return;
      if ((paramHashSet == null) || (paramHashSet.isEmpty()))
      {
        d.g(z[1], z[11]);
        return;
      }
      d.c(z[1], z[12] + paramHashSet.size());
      localJSONArray = new JSONArray();
      localArrayList = c.a(this.b, true);
      Object localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(localArrayList);
      Object localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        f localf = (f)((Iterator)localObject2).next();
        if (paramHashSet.remove(localf.b)) {
          ((ArrayList)localObject1).remove(localf);
        }
        if ((!h.a(this.a)) && (localf.b.equals(this.a))) {
          ((ArrayList)localObject1).remove(localf);
        }
      }
      if (!h.a(this.a)) {
        paramHashSet.remove(this.a);
      }
      d.c(z[1], z[9] + paramHashSet.toString() + z[10] + ((ArrayList)localObject1).toString());
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext())
      {
        localObject2 = cn.jiguang.f.f.b((String)paramHashSet.next());
        if (localObject2 != null) {
          localJSONArray.put(localObject2);
        }
      }
      paramHashSet = ((ArrayList)localObject1).iterator();
      while (paramHashSet.hasNext())
      {
        localObject1 = cn.jiguang.f.f.a(((f)paramHashSet.next()).b);
        if (localObject1 != null) {
          localJSONArray.put(localObject1);
        }
      }
      if (localJSONArray.length() > 0) {
        l.a(this.b, localJSONArray);
      }
    } while ((localJSONArray.length() <= 0) && (h.a(this.a)));
    a(localArrayList);
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      d.g(z[1], z[8]);
      return false;
    }
    localObject2 = d;
    if (paramString != null)
    {
      try
      {
        d.a(z[1], z[22] + paramString);
        localContext3 = null;
        localContext4 = null;
        localContext5 = null;
        localContext1 = null;
        localContext2 = null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Context localContext1;
          localException = localException;
          d.c(z[1], z[21], localException);
        }
      }
      finally {}
    }
    else
    {
      d.c(z[1], z[20]);
      return false;
    }
  }
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        synchronized (c)
        {
          if (this.b == null)
          {
            d.g(z[1], z[8]);
            return;
          }
          String str1 = a(this.b);
          d.c(z[1], z[5] + str1);
          if (str1 == null)
          {
            a(c.a(this.b, true));
            return;
          }
        }
        if (cn.jiguang.c.a.a.s()) {
          break label135;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        d.c(z[1], z[6] + localException.getMessage());
        return;
      }
      return;
      label135:
      MultiSpHelper.commitLong(cn.jiguang.c.a.e, z[7], System.currentTimeMillis());
      a(a(str2));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */