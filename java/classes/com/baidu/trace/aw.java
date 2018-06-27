package com.baidu.trace;

import android.text.TextUtils;
import com.baidu.trace.c.g;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class aw
  implements g
{
  public static Deque<ar.a> a;
  protected static long b = 2L;
  protected static int c = 0;
  private static byte d = 1;
  private static Deque<ar.a> e = null;
  private static int f;
  private static String g = "";
  
  static
  {
    a = null;
    f = 0;
  }
  
  public static void a(int paramInt)
  {
    if (z.s == 1)
    {
      LinkedList localLinkedList = new LinkedList();
      while (e.size() > 0) {
        localLinkedList.offer((ar.a)e.poll());
      }
      bd.a(paramInt, localLinkedList);
    }
    f = 0;
  }
  
  private void a(Deque<ar.a> paramDeque)
  {
    if (d == 1) {}
    ar.a locala;
    for (int i = (z.r << 5) * 3;; i = z.r << 5)
    {
      int j = paramDeque.size();
      for (;;)
      {
        if ((f >= i) || (j <= 0) || (e.size() >= 10)) {
          return;
        }
        locala = (ar.a)paramDeque.poll();
        int k = j - 1;
        j = k;
        if (locala != null)
        {
          j = k;
          if (locala.b != null)
          {
            if (i - f < locala.b.length) {
              break;
            }
            e.offer(locala);
            j = f;
            f = locala.b.length + j;
            j = k;
          }
        }
      }
    }
    paramDeque.offerFirst(locala);
  }
  
  protected static void b()
  {
    if (e == null) {
      e = new LinkedList();
    }
    if (a == null) {
      a = new LinkedList();
    }
  }
  
  public static void b(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (((bd.g) || ((!bd.d) && (bd.h))) && (c > 0) && (!TextUtils.isEmpty(g))) {
      am.a(g, c);
    }
    bd.a(paramInt);
  }
  
  public static void c()
  {
    while (e.size() > 0)
    {
      ar.a locala = (ar.a)e.poll();
      a.offerLast(locala);
    }
    f = 0;
  }
  
  protected static void d()
  {
    if (e != null)
    {
      e.clear();
      e = null;
    }
    if (a != null)
    {
      a.clear();
      a = null;
    }
  }
  
  private static byte[] e()
  {
    byte[] arrayOfByte = new byte[f];
    int m = e.size();
    int j = 0;
    int i = 0;
    ar.a locala;
    if (j < m)
    {
      locala = (ar.a)e.poll();
      if (locala == null) {
        break label135;
      }
      if (locala.b != null) {}
    }
    label135:
    for (;;)
    {
      j += 1;
      break;
      if (locala.b.length + i > arrayOfByte.length) {
        return arrayOfByte;
      }
      int k = 0;
      while (k < locala.b.length)
      {
        arrayOfByte[(i + k)] = locala.b[k];
        k += 1;
      }
      k = locala.b.length;
      e.offer(locala);
      i = k + i;
      continue;
      return arrayOfByte;
    }
  }
  
  public final void a()
  {
    b();
    f = 0;
    if (a.size() > 0) {
      a(a);
    }
    for (;;)
    {
      TraceJniInterface.a().setPackData(d, e());
      return;
      if ((bd.g) || ((!bd.d) && (bd.h)))
      {
        LinkedList localLinkedList = new LinkedList();
        g = am.a(z.c, 10, localLinkedList);
        if (c > 0)
        {
          a(localLinkedList);
          continue;
        }
      }
      g = z.c;
      a(bd.c);
    }
  }
  
  /* Error */
  public final void a(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 143	com/baidu/trace/a/h
    //   3: dup
    //   4: invokespecial 144	com/baidu/trace/a/h:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: ldc -110
    //   12: invokevirtual 152	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15: putfield 154	com/baidu/trace/a/h:a	I
    //   18: invokestatic 159	com/baidu/trace/bc:a	()Lcom/baidu/trace/bc;
    //   21: pop
    //   22: aload_2
    //   23: invokestatic 162	com/baidu/trace/bc:a	(Lcom/baidu/trace/a/h;)V
    //   26: return
    //   27: astore_1
    //   28: aload_1
    //   29: athrow
    //   30: astore_1
    //   31: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	aw
    //   0	32	1	paramJSONObject	org.json.JSONObject
    //   7	16	2	localh	com.baidu.trace.a.h
    // Exception table:
    //   from	to	target	type
    //   8	26	27	finally
    //   8	26	30	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */