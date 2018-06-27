package com.f.a.b.a;

import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public final class d
{
  private static final Object c = new Object();
  private final Object a = new Object();
  private File b;
  private HashMap<File, a> d = new HashMap();
  
  public d(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.b = new File(paramString);
      return;
    }
    throw new RuntimeException("Directory can not be empty");
  }
  
  private File b()
  {
    synchronized (this.a)
    {
      File localFile = this.b;
      return localFile;
    }
  }
  
  private static File b(File paramFile)
  {
    return new File(paramFile.getPath() + ".bak");
  }
  
  public final b a(String arg1)
  {
    Object localObject1 = b();
    ??? = ??? + ".xml";
    File localFile;
    if (???.indexOf(File.separatorChar) < 0) {
      localFile = new File((File)localObject1, ???);
    }
    a locala;
    synchronized (c)
    {
      locala = (a)this.d.get(localFile);
      if ((locala != null) && (!locala.d()))
      {
        return locala;
        throw new IllegalArgumentException("File " + ??? + " contains a path separator");
      }
      ??? = b(localFile);
      if (???.exists())
      {
        localFile.delete();
        ???.renameTo(localFile);
      }
      if (localFile.exists()) {
        localFile.canRead();
      }
      if ((!localFile.exists()) || (!localFile.canRead())) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new FileInputStream(localFile);
        ??? = Xml.newPullParser();
        ???.setInput((InputStream)localObject1, null);
        ??? = (HashMap)e.a(???, new String[1]);
        Object localObject4;
        FileInputStream localFileInputStream;
        locala = (a)this.d.get(localFile);
      }
      catch (XmlPullParserException localObject2)
      {
        try
        {
          ((FileInputStream)localObject1).close();
          localObject4 = c;
          if (locala == null) {
            break label348;
          }
          localObject1 = locala;
          if (??? != null) {}
          try
          {
            localObject2 = finally;
          }
          finally
          {
            try
            {
              locala.a = ???;
              localObject1 = locala;
              return (b)localObject1;
            }
            finally {}
            ??? = finally;
          }
          throw ((Throwable)localObject2);
        }
        catch (Exception localException2)
        {
          Object localObject3;
          continue;
        }
        catch (IOException localIOException3)
        {
          continue;
        }
        catch (FileNotFoundException localFileNotFoundException3)
        {
          continue;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          continue;
        }
        ??? = ???;
        ??? = null;
        try
        {
          localFileInputStream = new FileInputStream(localFile);
          localObject4 = new byte[localFileInputStream.available()];
          localFileInputStream.read((byte[])localObject4);
          new String((byte[])localObject4, 0, localObject4.length, "UTF-8");
        }
        catch (FileNotFoundException localFileNotFoundException1)
        {
          localFileNotFoundException1.printStackTrace();
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
        }
        continue;
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        ??? = null;
        localFileNotFoundException2.printStackTrace();
        continue;
      }
      catch (IOException localIOException2)
      {
        ??? = null;
        localIOException2.printStackTrace();
        continue;
      }
      catch (Exception localException1)
      {
        ??? = null;
        localException1.printStackTrace();
        continue;
      }
      label348:
      localObject3 = locala;
      if (locala == null)
      {
        localObject3 = new a(localFile, ???);
        this.d.put(localFile, localObject3);
        continue;
        ??? = null;
      }
    }
  }
  
  private static final class a
    implements b
  {
    private static final Object f = new Object();
    Map a;
    boolean b = false;
    private final File c;
    private final File d;
    private final int e;
    private WeakHashMap<b.b, Object> g;
    
    a(File paramFile, Map paramMap)
    {
      this.c = paramFile;
      this.d = d.a(paramFile);
      this.e = 0;
      if (paramMap != null) {}
      for (;;)
      {
        this.a = paramMap;
        this.g = new WeakHashMap();
        return;
        paramMap = new HashMap();
      }
    }
    
    private static FileOutputStream a(File paramFile)
    {
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
        return localFileOutputStream;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        if (!paramFile.getParentFile().mkdir()) {
          return null;
        }
        try
        {
          paramFile = new FileOutputStream(paramFile);
          return paramFile;
        }
        catch (FileNotFoundException paramFile) {}
      }
      return null;
    }
    
    private boolean e()
    {
      if (this.c.exists()) {
        if (!this.d.exists()) {
          if (this.c.renameTo(this.d)) {
            break label44;
          }
        }
      }
      for (;;)
      {
        return false;
        this.c.delete();
        try
        {
          label44:
          FileOutputStream localFileOutputStream = a(this.c);
          if (localFileOutputStream == null) {
            continue;
          }
          Map localMap = this.a;
          a locala = new a();
          locala.setOutput(localFileOutputStream, "utf-8");
          locala.startDocument(null, Boolean.valueOf(true));
          locala.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
          e.a(localMap, null, locala);
          locala.endDocument();
          localFileOutputStream.close();
          this.d.delete();
          return true;
        }
        catch (IOException localIOException)
        {
          if (!this.c.exists()) {
            continue;
          }
          this.c.delete();
          return false;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          for (;;) {}
        }
      }
    }
    
    public final int a(String paramString)
    {
      for (;;)
      {
        try
        {
          paramString = (Integer)this.a.get(paramString);
          if (paramString != null)
          {
            i = paramString.intValue();
            return i;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final String a(String paramString1, String paramString2)
    {
      for (;;)
      {
        try
        {
          paramString1 = (String)this.a.get(paramString1);
          if (paramString1 != null) {
            return paramString1;
          }
        }
        finally {}
        paramString1 = paramString2;
      }
    }
    
    public final void a(b.b paramb)
    {
      try
      {
        this.g.put(paramb, f);
        return;
      }
      finally {}
    }
    
    public final boolean a()
    {
      return (this.c != null) && (new File(this.c.getAbsolutePath()).exists());
    }
    
    public final long b(String paramString)
    {
      for (;;)
      {
        try
        {
          paramString = (Long)this.a.get(paramString);
          if (paramString != null)
          {
            l = paramString.longValue();
            return l;
          }
        }
        finally {}
        long l = 0L;
      }
    }
    
    public final Map<String, ?> b()
    {
      try
      {
        HashMap localHashMap = new HashMap(this.a);
        return localHashMap;
      }
      finally {}
    }
    
    public final void b(b.b paramb)
    {
      try
      {
        this.g.remove(paramb);
        return;
      }
      finally {}
    }
    
    public final float c(String paramString)
    {
      for (;;)
      {
        try
        {
          paramString = (Float)this.a.get(paramString);
          if (paramString != null)
          {
            f1 = paramString.floatValue();
            return f1;
          }
        }
        finally {}
        float f1 = 0.0F;
      }
    }
    
    public final b.a c()
    {
      return new a();
    }
    
    public final boolean d()
    {
      try
      {
        boolean bool = this.b;
        return bool;
      }
      finally {}
    }
    
    public final boolean d(String paramString)
    {
      for (;;)
      {
        try
        {
          paramString = (Boolean)this.a.get(paramString);
          if (paramString != null)
          {
            bool = paramString.booleanValue();
            return bool;
          }
        }
        finally {}
        boolean bool = false;
      }
    }
    
    public final boolean e(String paramString)
    {
      try
      {
        boolean bool = this.a.containsKey(paramString);
        return bool;
      }
      finally {}
    }
    
    public final class a
      implements b.a
    {
      private final Map<String, Object> b = new HashMap();
      private boolean c = false;
      
      public a() {}
      
      public final b.a a()
      {
        try
        {
          this.c = true;
          return this;
        }
        finally {}
      }
      
      public final b.a a(String paramString)
      {
        try
        {
          this.b.put(paramString, this);
          return this;
        }
        finally {}
      }
      
      public final b.a a(String paramString, float paramFloat)
      {
        try
        {
          this.b.put(paramString, Float.valueOf(paramFloat));
          return this;
        }
        finally {}
      }
      
      public final b.a a(String paramString, int paramInt)
      {
        try
        {
          this.b.put(paramString, Integer.valueOf(paramInt));
          return this;
        }
        finally {}
      }
      
      public final b.a a(String paramString, long paramLong)
      {
        try
        {
          this.b.put(paramString, Long.valueOf(paramLong));
          return this;
        }
        finally {}
      }
      
      public final b.a a(String paramString1, String paramString2)
      {
        try
        {
          this.b.put(paramString1, paramString2);
          return this;
        }
        finally {}
      }
      
      public final b.a a(String paramString, boolean paramBoolean)
      {
        try
        {
          this.b.put(paramString, Boolean.valueOf(paramBoolean));
          return this;
        }
        finally {}
      }
      
      /* Error */
      public final boolean b()
      {
        // Byte code:
        //   0: invokestatic 70	com/f/a/b/a/d:a	()Ljava/lang/Object;
        //   3: astore 5
        //   5: aload 5
        //   7: monitorenter
        //   8: aload_0
        //   9: getfield 21	com/f/a/b/a/d$a$a:a	Lcom/f/a/b/a/d$a;
        //   12: invokestatic 73	com/f/a/b/a/d$a:a	(Lcom/f/a/b/a/d$a;)Ljava/util/WeakHashMap;
        //   15: invokevirtual 79	java/util/WeakHashMap:size	()I
        //   18: ifle +152 -> 170
        //   21: iconst_1
        //   22: istore_1
        //   23: iload_1
        //   24: ifeq +304 -> 328
        //   27: new 81	java/util/ArrayList
        //   30: dup
        //   31: invokespecial 82	java/util/ArrayList:<init>	()V
        //   34: astore 4
        //   36: new 84	java/util/HashSet
        //   39: dup
        //   40: aload_0
        //   41: getfield 21	com/f/a/b/a/d$a$a:a	Lcom/f/a/b/a/d$a;
        //   44: invokestatic 73	com/f/a/b/a/d$a:a	(Lcom/f/a/b/a/d$a;)Ljava/util/WeakHashMap;
        //   47: invokevirtual 88	java/util/WeakHashMap:keySet	()Ljava/util/Set;
        //   50: invokespecial 91	java/util/HashSet:<init>	(Ljava/util/Collection;)V
        //   53: astore_3
        //   54: aload_0
        //   55: monitorenter
        //   56: aload_0
        //   57: getfield 31	com/f/a/b/a/d$a$a:c	Z
        //   60: ifeq +20 -> 80
        //   63: aload_0
        //   64: getfield 21	com/f/a/b/a/d$a$a:a	Lcom/f/a/b/a/d$a;
        //   67: invokestatic 94	com/f/a/b/a/d$a:b	(Lcom/f/a/b/a/d$a;)Ljava/util/Map;
        //   70: invokeinterface 97 1 0
        //   75: aload_0
        //   76: iconst_0
        //   77: putfield 31	com/f/a/b/a/d$a$a:c	Z
        //   80: aload_0
        //   81: getfield 29	com/f/a/b/a/d$a$a:b	Ljava/util/Map;
        //   84: invokeinterface 100 1 0
        //   89: invokeinterface 106 1 0
        //   94: astore 6
        //   96: aload 6
        //   98: invokeinterface 111 1 0
        //   103: ifne +72 -> 175
        //   106: aload_0
        //   107: getfield 29	com/f/a/b/a/d$a$a:b	Ljava/util/Map;
        //   110: invokeinterface 97 1 0
        //   115: aload_0
        //   116: monitorexit
        //   117: aload_0
        //   118: getfield 21	com/f/a/b/a/d$a$a:a	Lcom/f/a/b/a/d$a;
        //   121: invokestatic 114	com/f/a/b/a/d$a:c	(Lcom/f/a/b/a/d$a;)Z
        //   124: istore_2
        //   125: iload_2
        //   126: ifeq +21 -> 147
        //   129: aload_0
        //   130: getfield 21	com/f/a/b/a/d$a$a:a	Lcom/f/a/b/a/d$a;
        //   133: astore 6
        //   135: aload 6
        //   137: monitorenter
        //   138: aload 6
        //   140: iconst_1
        //   141: putfield 116	com/f/a/b/a/d$a:b	Z
        //   144: aload 6
        //   146: monitorexit
        //   147: aload 5
        //   149: monitorexit
        //   150: iload_1
        //   151: ifeq +17 -> 168
        //   154: aload 4
        //   156: invokeinterface 119 1 0
        //   161: iconst_1
        //   162: isub
        //   163: istore_1
        //   164: iload_1
        //   165: ifge +118 -> 283
        //   168: iload_2
        //   169: ireturn
        //   170: iconst_0
        //   171: istore_1
        //   172: goto -149 -> 23
        //   175: aload 6
        //   177: invokeinterface 122 1 0
        //   182: checkcast 124	java/util/Map$Entry
        //   185: astore 8
        //   187: aload 8
        //   189: invokeinterface 127 1 0
        //   194: checkcast 129	java/lang/String
        //   197: astore 7
        //   199: aload 8
        //   201: invokeinterface 132 1 0
        //   206: astore 8
        //   208: aload 8
        //   210: aload_0
        //   211: if_acmpne +46 -> 257
        //   214: aload_0
        //   215: getfield 21	com/f/a/b/a/d$a$a:a	Lcom/f/a/b/a/d$a;
        //   218: invokestatic 94	com/f/a/b/a/d$a:b	(Lcom/f/a/b/a/d$a;)Ljava/util/Map;
        //   221: aload 7
        //   223: invokeinterface 136 2 0
        //   228: pop
        //   229: iload_1
        //   230: ifeq -134 -> 96
        //   233: aload 4
        //   235: aload 7
        //   237: invokeinterface 140 2 0
        //   242: pop
        //   243: goto -147 -> 96
        //   246: astore_3
        //   247: aload_0
        //   248: monitorexit
        //   249: aload_3
        //   250: athrow
        //   251: astore_3
        //   252: aload 5
        //   254: monitorexit
        //   255: aload_3
        //   256: athrow
        //   257: aload_0
        //   258: getfield 21	com/f/a/b/a/d$a$a:a	Lcom/f/a/b/a/d$a;
        //   261: invokestatic 94	com/f/a/b/a/d$a:b	(Lcom/f/a/b/a/d$a;)Ljava/util/Map;
        //   264: aload 7
        //   266: aload 8
        //   268: invokeinterface 40 3 0
        //   273: pop
        //   274: goto -45 -> 229
        //   277: astore_3
        //   278: aload 6
        //   280: monitorexit
        //   281: aload_3
        //   282: athrow
        //   283: aload 4
        //   285: iload_1
        //   286: invokeinterface 144 2 0
        //   291: pop
        //   292: aload_3
        //   293: invokeinterface 106 1 0
        //   298: astore 5
        //   300: aload 5
        //   302: invokeinterface 111 1 0
        //   307: ifne +10 -> 317
        //   310: iload_1
        //   311: iconst_1
        //   312: isub
        //   313: istore_1
        //   314: goto -150 -> 164
        //   317: aload 5
        //   319: invokeinterface 122 1 0
        //   324: pop
        //   325: goto -25 -> 300
        //   328: aconst_null
        //   329: astore_3
        //   330: aconst_null
        //   331: astore 4
        //   333: goto -279 -> 54
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	336	0	this	a
        //   22	292	1	i	int
        //   124	45	2	bool	boolean
        //   53	1	3	localHashSet	java.util.HashSet
        //   246	4	3	localObject1	Object
        //   251	5	3	localObject2	Object
        //   277	16	3	localObject3	Object
        //   329	1	3	localObject4	Object
        //   34	298	4	localArrayList	java.util.ArrayList
        //   3	315	5	localObject5	Object
        //   197	68	7	str	String
        //   185	82	8	localObject7	Object
        // Exception table:
        //   from	to	target	type
        //   56	80	246	finally
        //   80	96	246	finally
        //   96	117	246	finally
        //   175	208	246	finally
        //   214	229	246	finally
        //   233	243	246	finally
        //   247	249	246	finally
        //   257	274	246	finally
        //   8	21	251	finally
        //   27	54	251	finally
        //   54	56	251	finally
        //   117	125	251	finally
        //   129	138	251	finally
        //   147	150	251	finally
        //   249	251	251	finally
        //   252	255	251	finally
        //   281	283	251	finally
        //   138	147	277	finally
        //   278	281	277	finally
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/f/a/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */