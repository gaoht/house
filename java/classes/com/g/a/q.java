package com.g.a;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class q
  extends File
{
  public final String a;
  
  protected q(String paramString)
  {
    super(paramString);
    this.a = a(paramString);
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 31	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: new 36	java/io/BufferedReader
    //   12: dup
    //   13: new 38	java/io/FileReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 39	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 42	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_1
    //   25: aload_1
    //   26: astore_0
    //   27: aload_1
    //   28: invokevirtual 46	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_3
    //   32: ldc 48
    //   34: astore_2
    //   35: aload_3
    //   36: ifnull +29 -> 65
    //   39: aload_1
    //   40: astore_0
    //   41: aload 4
    //   43: aload_2
    //   44: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_3
    //   48: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: ldc 54
    //   54: astore_2
    //   55: aload_1
    //   56: astore_0
    //   57: aload_1
    //   58: invokevirtual 46	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore_3
    //   62: goto -27 -> 35
    //   65: aload_1
    //   66: astore_0
    //   67: aload 4
    //   69: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_2
    //   73: aload_2
    //   74: astore_0
    //   75: aload_1
    //   76: ifnull +9 -> 85
    //   79: aload_1
    //   80: invokevirtual 60	java/io/BufferedReader:close	()V
    //   83: aload_2
    //   84: astore_0
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_1
    //   91: astore_0
    //   92: aload 4
    //   94: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore_2
    //   98: aload_2
    //   99: astore_0
    //   100: aload_1
    //   101: ifnull -16 -> 85
    //   104: aload_1
    //   105: invokevirtual 60	java/io/BufferedReader:close	()V
    //   108: aload_2
    //   109: areturn
    //   110: astore_0
    //   111: aload_2
    //   112: areturn
    //   113: astore_1
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull +7 -> 124
    //   120: aload_0
    //   121: invokevirtual 60	java/io/BufferedReader:close	()V
    //   124: aload_1
    //   125: athrow
    //   126: astore_0
    //   127: aload_2
    //   128: areturn
    //   129: astore_0
    //   130: goto -6 -> 124
    //   133: astore_1
    //   134: goto -18 -> 116
    //   137: astore_0
    //   138: goto -48 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   24	81	1	localBufferedReader	java.io.BufferedReader
    //   113	12	1	localObject1	Object
    //   133	1	1	localObject2	Object
    //   34	94	2	str1	String
    //   31	31	3	str2	String
    //   7	86	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   9	25	87	java/lang/Throwable
    //   104	108	110	java/lang/Throwable
    //   9	25	113	finally
    //   79	83	126	java/lang/Throwable
    //   120	124	129	java/lang/Throwable
    //   27	32	133	finally
    //   41	52	133	finally
    //   57	62	133	finally
    //   67	73	133	finally
    //   92	98	133	finally
    //   27	32	137	java/lang/Throwable
    //   41	52	137	java/lang/Throwable
    //   57	62	137	java/lang/Throwable
    //   67	73	137	java/lang/Throwable
  }
  
  public long length()
  {
    return this.a.length();
  }
  
  static class a
    extends q
  {
    public ArrayList b;
    
    /* Error */
    private a(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 13	com/g/a/q:<init>	(Ljava/lang/String;)V
      //   5: aload_0
      //   6: new 15	java/util/ArrayList
      //   9: dup
      //   10: invokespecial 18	java/util/ArrayList:<init>	()V
      //   13: putfield 20	com/g/a/q$a:b	Ljava/util/ArrayList;
      //   16: aload_0
      //   17: getfield 23	com/g/a/q$a:a	Ljava/lang/String;
      //   20: ldc 25
      //   22: invokevirtual 31	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   25: astore_1
      //   26: aload_1
      //   27: arraylength
      //   28: istore_3
      //   29: iconst_0
      //   30: istore_2
      //   31: iload_2
      //   32: iload_3
      //   33: if_icmpge +33 -> 66
      //   36: aload_1
      //   37: iload_2
      //   38: aaload
      //   39: astore 4
      //   41: aload_0
      //   42: getfield 20	com/g/a/q$a:b	Ljava/util/ArrayList;
      //   45: new 33	com/g/a/q$b
      //   48: dup
      //   49: aload 4
      //   51: invokespecial 34	com/g/a/q$b:<init>	(Ljava/lang/String;)V
      //   54: invokevirtual 38	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   57: pop
      //   58: iload_2
      //   59: iconst_1
      //   60: iadd
      //   61: istore_2
      //   62: goto -31 -> 31
      //   65: astore_1
      //   66: return
      //   67: astore 4
      //   69: goto -11 -> 58
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	72	0	this	a
      //   0	72	1	paramString	String
      //   30	32	2	i	int
      //   28	6	3	j	int
      //   39	11	4	str	String
      //   67	1	4	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   5	29	65	java/lang/Throwable
      //   41	58	67	java/lang/Throwable
    }
    
    public static a a(int paramInt)
    {
      try
      {
        a locala = new a(String.format("/proc/%d/cgroup", new Object[] { Integer.valueOf(paramInt) }));
        return locala;
      }
      catch (Throwable localThrowable) {}
      return null;
    }
    
    public q.b b(String paramString)
    {
      try
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          q.b localb = (q.b)localIterator.next();
          String[] arrayOfString = localb.b.split(",");
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = arrayOfString[i].equals(paramString);
            if (bool) {
              return localb;
            }
            i += 1;
          }
        }
        return null;
      }
      catch (Throwable paramString) {}
    }
  }
  
  static class b
  {
    protected int a;
    protected String b;
    protected String c;
    
    protected b(String paramString)
    {
      try
      {
        paramString = paramString.split(":");
        this.a = Integer.parseInt(paramString[0]);
        this.b = paramString[1];
        this.c = paramString[2];
        return;
      }
      catch (Throwable paramString) {}
    }
  }
  
  public static class c
    extends q
  {
    private String[] b = new String[0];
    
    private c(String paramString)
    {
      super();
      try
      {
        this.b = this.a.split("\\s+");
        return;
      }
      catch (Throwable paramString) {}
    }
    
    public static c a(int paramInt)
    {
      try
      {
        c localc = new c(String.format("/proc/%d/stat", new Object[] { Integer.valueOf(paramInt) }));
        return localc;
      }
      catch (Throwable localThrowable) {}
      return null;
    }
    
    public long a()
    {
      try
      {
        long l = Long.parseLong(this.b[21]);
        return l;
      }
      catch (Throwable localThrowable) {}
      return 0L;
    }
    
    public String b()
    {
      try
      {
        String str = this.b[1].replace("(", "").replace(")", "");
        return str;
      }
      catch (Throwable localThrowable) {}
      return "";
    }
    
    public char c()
    {
      try
      {
        char c = this.b[2].charAt(0);
        return c;
      }
      catch (Throwable localThrowable) {}
      return '\000';
    }
  }
  
  static class d
    extends q
  {
    private d(String paramString)
    {
      super();
    }
    
    public static d a(int paramInt)
    {
      try
      {
        d locald = new d(String.format("/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }));
        return locald;
      }
      catch (Throwable localThrowable) {}
      return null;
    }
    
    public int a()
    {
      try
      {
        int i = Integer.parseInt(b("Uid").split("\\s+")[0]);
        return i;
      }
      catch (Throwable localThrowable) {}
      return -1;
    }
    
    public int b()
    {
      try
      {
        int i = Integer.parseInt(b("Gid").split("\\s+")[0]);
        return i;
      }
      catch (Throwable localThrowable) {}
      return -1;
    }
    
    public String b(String paramString)
    {
      try
      {
        String[] arrayOfString = this.a.split("\n");
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (str.startsWith(paramString + ":"))
          {
            paramString = str.split(paramString + ":")[1].trim();
            return paramString;
          }
          i += 1;
        }
        return null;
      }
      catch (Throwable paramString) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */