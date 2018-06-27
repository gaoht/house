package cn.jpush.android.c;

import android.content.Context;
import cn.jpush.android.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g
{
  public static Queue<d> a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[14];
    int j = 0;
    Object localObject2 = "L~yCqp}eC2Kl/o\036zglC!Kv`HqZm}I#\005";
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
        i = 81;
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
        localObject2 = "Jqj^2Zo{C5\0373/E>Qkj^%\037v|\006?Jsc";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "~|{O>Q?\"\006\"^iji3UzlR\"";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "RPmL4\\kCO\"K?fUqQjcJ";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "L~yCqp}eC2Kl/`8SzAI%ypzH5zglC!Kv`HqZm}I#\005";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "rlhw$Zjjs%Vs|";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "Rlhy JzzC";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\034jaC)\\zR4[?\"\0064QkfR(tzv\006&^l/H$Ss";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "Rlh\006\"^ij\0068Q?|VqY~fJ4[%";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "{jJ8\\~{C5\037r|A\037XfP4\037j\006!MplC\"LvaAq\022?";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "VqfRqS~|R\034Lx^S4Jz/@0VsjBk";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "\034jaC)\\zR4[?\"\0062Pq{C)K?xG\"\037qzJ=";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "SpnBqP}eC2Kl/C#Mp}\034";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "vqS%lk}C0R?lJ>Lz/@0VsjBk";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = null;
        return;
        i = 63;
        continue;
        i = 31;
        continue;
        i = 15;
        continue;
        i = 38;
      }
    }
  }
  
  /* Error */
  private static <T> ArrayList<T> a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: ifnonnull +23 -> 29
    //   9: getstatic 55	cn/jpush/android/c/g:z	[Ljava/lang/String;
    //   12: iconst_5
    //   13: aaload
    //   14: getstatic 55	cn/jpush/android/c/g:z	[Ljava/lang/String;
    //   17: iconst_1
    //   18: aaload
    //   19: invokestatic 69	cn/jpush/android/c/f:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_2
    //   23: astore_0
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: new 71	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 73	java/util/ArrayList:<init>	()V
    //   36: astore_2
    //   37: new 75	java/io/ObjectInputStream
    //   40: dup
    //   41: aload_0
    //   42: aload_1
    //   43: invokevirtual 81	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   46: invokespecial 84	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore_1
    //   50: aload_1
    //   51: astore_0
    //   52: aload_1
    //   53: invokevirtual 88	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   56: checkcast 71	java/util/ArrayList
    //   59: astore_3
    //   60: aload_1
    //   61: invokevirtual 91	java/io/ObjectInputStream:close	()V
    //   64: aload_3
    //   65: astore_0
    //   66: goto -42 -> 24
    //   69: astore_0
    //   70: getstatic 55	cn/jpush/android/c/g:z	[Ljava/lang/String;
    //   73: iconst_5
    //   74: aaload
    //   75: new 93	java/lang/StringBuilder
    //   78: dup
    //   79: getstatic 55	cn/jpush/android/c/g:z	[Ljava/lang/String;
    //   82: bipush 13
    //   84: aaload
    //   85: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload_0
    //   89: invokevirtual 99	java/io/IOException:getMessage	()Ljava/lang/String;
    //   92: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 69	cn/jpush/android/c/f:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_3
    //   102: astore_0
    //   103: goto -79 -> 24
    //   106: astore_0
    //   107: ldc 2
    //   109: monitorexit
    //   110: aload_0
    //   111: athrow
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_1
    //   115: aload_1
    //   116: astore_0
    //   117: getstatic 55	cn/jpush/android/c/g:z	[Ljava/lang/String;
    //   120: iconst_5
    //   121: aaload
    //   122: new 93	java/lang/StringBuilder
    //   125: dup
    //   126: getstatic 55	cn/jpush/android/c/g:z	[Ljava/lang/String;
    //   129: bipush 12
    //   131: aaload
    //   132: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload_3
    //   136: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   139: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 69	cn/jpush/android/c/f:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_1
    //   149: ifnull +105 -> 254
    //   152: aload_1
    //   153: invokevirtual 91	java/io/ObjectInputStream:close	()V
    //   156: aload_2
    //   157: astore_0
    //   158: goto -134 -> 24
    //   161: astore_0
    //   162: getstatic 55	cn/jpush/android/c/g:z	[Ljava/lang/String;
    //   165: iconst_5
    //   166: aaload
    //   167: new 93	java/lang/StringBuilder
    //   170: dup
    //   171: getstatic 55	cn/jpush/android/c/g:z	[Ljava/lang/String;
    //   174: bipush 13
    //   176: aaload
    //   177: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: aload_0
    //   181: invokevirtual 99	java/io/IOException:getMessage	()Ljava/lang/String;
    //   184: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 69	cn/jpush/android/c/f:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_2
    //   194: astore_0
    //   195: goto -171 -> 24
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_0
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 91	java/io/ObjectInputStream:close	()V
    //   209: aload_1
    //   210: athrow
    //   211: astore_0
    //   212: getstatic 55	cn/jpush/android/c/g:z	[Ljava/lang/String;
    //   215: iconst_5
    //   216: aaload
    //   217: new 93	java/lang/StringBuilder
    //   220: dup
    //   221: getstatic 55	cn/jpush/android/c/g:z	[Ljava/lang/String;
    //   224: bipush 13
    //   226: aaload
    //   227: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: aload_0
    //   231: invokevirtual 99	java/io/IOException:getMessage	()Ljava/lang/String;
    //   234: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 69	cn/jpush/android/c/f:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto -34 -> 209
    //   246: astore_1
    //   247: goto -46 -> 201
    //   250: astore_3
    //   251: goto -136 -> 115
    //   254: aload_2
    //   255: astore_0
    //   256: goto -232 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramContext	Context
    //   0	259	1	paramString	String
    //   1	254	2	localArrayList1	ArrayList
    //   59	43	3	localArrayList2	ArrayList
    //   112	24	3	localException1	Exception
    //   250	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   60	64	69	java/io/IOException
    //   9	22	106	finally
    //   29	37	106	finally
    //   60	64	106	finally
    //   70	101	106	finally
    //   152	156	106	finally
    //   162	193	106	finally
    //   205	209	106	finally
    //   209	211	106	finally
    //   212	243	106	finally
    //   37	50	112	java/lang/Exception
    //   152	156	161	java/io/IOException
    //   37	50	198	finally
    //   205	209	211	java/io/IOException
    //   52	60	246	finally
    //   117	148	246	finally
    //   52	60	250	java/lang/Exception
  }
  
  private static <T> void a(Context paramContext, String paramString, ArrayList<T> paramArrayList)
  {
    for (;;)
    {
      try
      {
        f.a(z[5], z[2]);
        if (paramContext == null)
        {
          f.g(z[5], z[1]);
          return;
        }
        if (paramArrayList == null) {
          f.g(z[5], z[3]);
        } else {
          try
          {
            paramContext = new ObjectOutputStream(paramContext.openFileOutput(paramString, 0));
            paramContext.writeObject(paramArrayList);
            paramContext.close();
          }
          catch (FileNotFoundException paramContext)
          {
            f.h(z[5], z[4] + paramContext.getMessage());
          }
          catch (IOException paramContext)
          {
            f.h(z[5], z[0] + paramContext.getMessage());
          }
        }
      }
      finally {}
    }
  }
  
  public static boolean a(Context paramContext, d paramd)
  {
    Object localObject3;
    if (a == null)
    {
      a = new ConcurrentLinkedQueue();
      try
      {
        Object localObject1 = a(paramContext, z[6]);
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (d)((Iterator)localObject1).next();
            a.offer(localObject3);
          }
        }
        if (paramContext != null) {
          break label127;
        }
      }
      catch (Exception localException)
      {
        f.h(z[5], z[10] + localException.getMessage());
      }
    }
    f.h(z[5], z[11]);
    return false;
    label127:
    if (paramd == null) {
      f.h(z[5], z[7]);
    }
    if (a.contains(paramd))
    {
      f.i(z[5], z[9] + paramd);
      return true;
    }
    if (a.size() >= 200) {
      a.poll();
    }
    a.offer(paramd);
    try
    {
      localObject3 = a(paramContext, z[6]);
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new ArrayList();
      }
      if (((ArrayList)localObject2).size() >= 50) {
        ((ArrayList)localObject2).remove(0);
      }
      ((ArrayList)localObject2).add(paramd);
      a(paramContext, z[6], (ArrayList)localObject2);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        f.h(z[5], z[8] + paramContext.getMessage());
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */