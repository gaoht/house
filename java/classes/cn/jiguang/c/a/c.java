package cn.jiguang.c.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public final class c
{
  public static final String[] a;
  private static c e;
  private static Object f = new Object();
  private static final String[] z;
  private Context b;
  private d c;
  private SQLiteDatabase d;
  
  static
  {
    Object localObject1 = new String[23];
    int j = 0;
    Object localObject3 = "e\rL\001Ib";
    int i = -1;
    Object localObject4 = localObject1;
    char[] arrayOfChar = ((String)localObject3).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject3 = arrayOfChar;
    int i4 = j;
    Object localObject5 = localObject1;
    Object localObject2 = localObject4;
    int n = k;
    Object localObject6;
    int i2;
    if (k <= 1)
    {
      localObject6 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label72:
      n = m;
      label75:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 44;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label75;
      }
      i1 = n;
      n = k;
      localObject2 = localObject4;
      localObject5 = localObject6;
      i4 = j;
      localObject3 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject3;
      j = i4;
      localObject6 = localObject5;
      localObject4 = localObject2;
      k = n;
      m = i1;
      if (n > i1) {
        break label72;
      }
      localObject1 = new String((char[])localObject3).intern();
      switch (i3)
      {
      default: 
        localObject5[i4] = localObject1;
        j = 1;
        localObject3 = "e\rL\fCc\027g0\035&";
        i = 0;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 0: 
        localObject5[i4] = localObject1;
        j = 2;
        localObject3 = "e\rL\fCc\027g0\035";
        i = 1;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 1: 
        localObject5[i4] = localObject1;
        j = 3;
        localObject3 = "|\tf\034DI\ng\016X\ng\006Oe";
        i = 2;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 2: 
        localObject5[i4] = localObject1;
        j = 4;
        localObject3 = "e\rL\fCc\027g0\035IJ";
        i = 3;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 3: 
        localObject5[i4] = localObject1;
        j = 5;
        localObject3 = "e\rL\003Cu\0300Hx\n";
        i = 4;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 4: 
        localObject5[i4] = localObject1;
        j = 6;
        localObject3 = "e\rL\033Cb\030";
        i = 5;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 5: 
        localObject5[i4] = localObject1;
        j = 7;
        localObject3 = "e\rL\fCx\027L\006\\";
        i = 6;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 6: 
        localObject5[i4] = localObject1;
        j = 8;
        localObject3 = "e\rL\034Cc\013p\n";
        i = 7;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 7: 
        localObject5[i4] = localObject1;
        j = 9;
        localObject3 = "e\rL\034Cd\rL\004Io";
        i = 8;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 8: 
        localObject5[i4] = localObject1;
        j = 10;
        localObject3 = "e\rL\fCc\027g0\037IH#";
        i = 9;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 9: 
        localObject5[i4] = localObject1;
        j = 11;
        localObject3 = "e\rL\tM\025v\013";
        i = 10;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 10: 
        localObject5[i4] = localObject1;
        j = 12;
        localObject3 = "e\rL\034Cd\rL\004IoD4";
        i = 11;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 11: 
        localObject5[i4] = localObject1;
        j = 13;
        localObject3 = "r\034\nXsYu\035C{Yy\037Ye\021L\034Xw\rz\034X\032`";
        i = 12;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 12: 
        localObject5[i4] = localObject1;
        j = 14;
        localObject3 = "e\034\nObYP yX-;\034XI\n|\035XI\022v\026\0056\037a\000A6\023c\032_~&`\033Mb\020`\033Eu\n3\030Ds\013vO_b&`\000^b&x\nU+^";
        i = 13;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 13: 
        localObject5[i4] = localObject1;
        j = 15;
        localObject3 = "E\rr\033Ee\rz\f_R;";
        i = 14;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 14: 
        localObject5[i4] = localObject1;
        j = 16;
        localObject3 = "y\tv\001\fD\034r\013Mt\025v+Mb\030Q\016_sYu\016EzYvU";
        i = 15;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 15: 
        localObject5[i4] = localObject1;
        j = 17;
        localObject3 = "e\034\nObY9OJd\026~OFf\f`\007se\rr\033Ee\rz\f_6\016{\n^sY`\033sp\030z\003IrY-O\0346Y|\035Hs\0133\rU6\ng0Jw\020\nH6\035v\034O6\025z\002EbY ";
        i = 16;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 16: 
        localObject5[i4] = localObject1;
        j = 18;
        localObject3 = "e\034\nObY@:a>";
        i = 17;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 17: 
        localObject5[i4] = localObject1;
        j = 19;
        localObject3 = "?Yu\035C{Yy\037Ye\021L\034Xw\rz\034X\032`";
        i = 18;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 18: 
        localObject5[i4] = localObject1;
        j = 20;
        localObject3 = "e\034\nObY9OJd\026~OFf\f`\007se\rr\033Ee\rz\f_6\016{\n^sY`\033sb\026g\016@6G3_\fw\027wO_b&u\016Ez\034wO\0216I3OCd\035v\035\ft\0003\034XI\r|\033MzYw\n_uY\006A\r3\\";
        i = 19;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 19: 
        localObject5[i4] = localObject1;
        j = 21;
        localObject3 = "u\fa\034CdYz\034\fx\f\003";
        i = 20;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 20: 
        localObject5[i4] = localObject1;
        j = 22;
        localObject3 = "y\tv\001\fy\tv\001{d\020g\016Nz\034W\016Xw\033r\034I6\037r\006@6\034)";
        i = 21;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 21: 
        localObject5[i4] = localObject1;
        z = (String[])localObject2;
        localObject1 = new String[12];
        localObject1[0] = z[9];
        j = 1;
        localObject3 = "I\020w";
        i = 22;
        localObject4 = localObject1;
        break;
        i = 22;
        continue;
        i = 121;
        continue;
        i = 19;
        continue;
        i = 111;
      }
    }
    localObject5[i4] = localObject1;
    localObject2[2] = z[0];
    localObject2[3] = z[7];
    localObject2[4] = z[5];
    localObject2[5] = z[8];
    localObject2[6] = z[11];
    localObject2[7] = z[6];
    localObject2[8] = z[2];
    localObject2[9] = z[4];
    localObject2[10] = z[10];
    localObject2[11] = z[1];
    a = (String[])localObject2;
  }
  
  private c(Context paramContext)
  {
    this.b = paramContext;
    this.c = new d(paramContext);
  }
  
  public static c a(Context paramContext)
  {
    synchronized (f)
    {
      if (e == null) {
        e = new c(paramContext);
      }
      return e;
    }
  }
  
  private boolean e()
  {
    boolean bool = false;
    try
    {
      this.d = this.c.getWritableDatabase();
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        cn.jiguang.d.d.i(z[15], z[22] + localException.getMessage());
      }
    }
    finally {}
    return bool;
  }
  
  private boolean f()
  {
    boolean bool = false;
    try
    {
      this.d = this.c.getReadableDatabase();
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        cn.jiguang.d.d.i(z[15], z[16] + localException.getMessage());
      }
    }
    finally {}
    return bool;
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    long l1 = 0L;
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(z[9], paramString1);
      localContentValues.put(z[0], paramString2);
      localContentValues.put(z[7], paramString3);
      localContentValues.put(z[5], paramString4);
      localContentValues.put(z[8], paramString5);
      localContentValues.put(z[11], Integer.valueOf(paramInt1));
      localContentValues.put(z[6], Integer.valueOf(1));
      localContentValues.put(z[2], Integer.valueOf(paramInt3));
      localContentValues.put(z[4], Integer.valueOf(paramInt4));
      localContentValues.put(z[10], Integer.valueOf(paramInt5));
      localContentValues.put(z[1], Integer.valueOf(0));
      try
      {
        long l2 = this.d.insert(z[3], null, localContentValues);
        l1 = l2;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
        }
      }
      return l1;
    }
    finally {}
  }
  
  /* Error */
  public final e a(android.database.Cursor paramCursor)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +12 -> 15
    //   6: aload_1
    //   7: invokeinterface 168 1 0
    //   12: ifne +24 -> 36
    //   15: getstatic 81	cn/jiguang/c/a/c:z	[Ljava/lang/String;
    //   18: bipush 15
    //   20: aaload
    //   21: getstatic 81	cn/jiguang/c/a/c:z	[Ljava/lang/String;
    //   24: bipush 21
    //   26: aaload
    //   27: invokestatic 170	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aconst_null
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: areturn
    //   36: new 172	cn/jiguang/c/a/e
    //   39: dup
    //   40: invokespecial 173	cn/jiguang/c/a/e:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: aload_1
    //   46: iconst_1
    //   47: invokeinterface 177 2 0
    //   52: invokevirtual 179	cn/jiguang/c/a/e:a	(Ljava/lang/String;)V
    //   55: aload_2
    //   56: aload_1
    //   57: iconst_2
    //   58: invokeinterface 177 2 0
    //   63: invokevirtual 181	cn/jiguang/c/a/e:b	(Ljava/lang/String;)V
    //   66: aload_2
    //   67: aload_1
    //   68: iconst_3
    //   69: invokeinterface 177 2 0
    //   74: invokevirtual 183	cn/jiguang/c/a/e:c	(Ljava/lang/String;)V
    //   77: aload_2
    //   78: aload_1
    //   79: iconst_4
    //   80: invokeinterface 177 2 0
    //   85: invokevirtual 185	cn/jiguang/c/a/e:d	(Ljava/lang/String;)V
    //   88: aload_2
    //   89: aload_1
    //   90: iconst_5
    //   91: invokeinterface 177 2 0
    //   96: invokevirtual 187	cn/jiguang/c/a/e:e	(Ljava/lang/String;)V
    //   99: aload_2
    //   100: aload_1
    //   101: bipush 6
    //   103: invokeinterface 191 2 0
    //   108: invokevirtual 194	cn/jiguang/c/a/e:a	(I)V
    //   111: aload_2
    //   112: aload_1
    //   113: bipush 7
    //   115: invokeinterface 191 2 0
    //   120: invokevirtual 196	cn/jiguang/c/a/e:b	(I)V
    //   123: aload_2
    //   124: aload_1
    //   125: bipush 8
    //   127: invokeinterface 191 2 0
    //   132: invokevirtual 198	cn/jiguang/c/a/e:c	(I)V
    //   135: aload_2
    //   136: aload_1
    //   137: bipush 9
    //   139: invokeinterface 191 2 0
    //   144: invokevirtual 200	cn/jiguang/c/a/e:d	(I)V
    //   147: aload_2
    //   148: aload_1
    //   149: bipush 10
    //   151: invokeinterface 191 2 0
    //   156: invokevirtual 202	cn/jiguang/c/a/e:e	(I)V
    //   159: aload_2
    //   160: aload_1
    //   161: bipush 11
    //   163: invokeinterface 191 2 0
    //   168: invokevirtual 204	cn/jiguang/c/a/e:f	(I)V
    //   171: getstatic 81	cn/jiguang/c/a/c:z	[Ljava/lang/String;
    //   174: bipush 15
    //   176: aaload
    //   177: aload_2
    //   178: invokevirtual 205	cn/jiguang/c/a/e:toString	()Ljava/lang/String;
    //   181: invokestatic 207	cn/jiguang/d/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload_2
    //   185: astore_1
    //   186: goto -154 -> 32
    //   189: astore_1
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: aload_1
    //   196: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   199: goto -28 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	c
    //   0	202	1	paramCursor	android.database.Cursor
    //   43	142	2	locale	e
    // Exception table:
    //   from	to	target	type
    //   6	15	189	finally
    //   15	30	189	finally
    //   36	44	189	finally
    //   44	171	189	finally
    //   171	184	189	finally
    //   195	199	189	finally
    //   44	171	194	java/lang/Exception
  }
  
  public final void a()
  {
    try
    {
      if (this.d != null) {
        this.d.close();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: iconst_0
    //   7: istore 5
    //   9: iconst_0
    //   10: istore 4
    //   12: aload_0
    //   13: monitorenter
    //   14: new 114	java/lang/StringBuilder
    //   17: dup
    //   18: getstatic 81	cn/jiguang/c/a/c:z	[Ljava/lang/String;
    //   21: bipush 14
    //   23: aaload
    //   24: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: aload_1
    //   28: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc -43
    //   33: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 8
    //   41: aload 7
    //   43: astore_1
    //   44: aload_0
    //   45: getfield 112	cn/jiguang/c/a/c:d	Landroid/database/sqlite/SQLiteDatabase;
    //   48: aload 8
    //   50: aconst_null
    //   51: invokevirtual 217	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore 7
    //   56: iload 4
    //   58: istore_3
    //   59: aload 7
    //   61: ifnull +41 -> 102
    //   64: aload 7
    //   66: astore_1
    //   67: aload 7
    //   69: astore 6
    //   71: aload 7
    //   73: invokeinterface 220 1 0
    //   78: pop
    //   79: aload 7
    //   81: astore_1
    //   82: aload 7
    //   84: astore 6
    //   86: aload 7
    //   88: iconst_0
    //   89: invokeinterface 191 2 0
    //   94: istore_2
    //   95: iload_2
    //   96: ifne +29 -> 125
    //   99: iload 4
    //   101: istore_3
    //   102: iload_3
    //   103: istore 4
    //   105: aload 7
    //   107: ifnull +13 -> 120
    //   110: aload 7
    //   112: invokeinterface 221 1 0
    //   117: iload_3
    //   118: istore 4
    //   120: aload_0
    //   121: monitorexit
    //   122: iload 4
    //   124: ireturn
    //   125: iconst_1
    //   126: istore_3
    //   127: goto -25 -> 102
    //   130: astore 7
    //   132: aload_1
    //   133: astore 6
    //   135: aload 7
    //   137: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   140: iload 5
    //   142: istore 4
    //   144: aload_1
    //   145: ifnull -25 -> 120
    //   148: aload_1
    //   149: invokeinterface 221 1 0
    //   154: iload 5
    //   156: istore 4
    //   158: goto -38 -> 120
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    //   166: astore_1
    //   167: aload 6
    //   169: ifnull +10 -> 179
    //   172: aload 6
    //   174: invokeinterface 221 1 0
    //   179: aload_1
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	c
    //   0	181	1	paramString	String
    //   94	2	2	i	int
    //   58	69	3	bool1	boolean
    //   10	147	4	bool2	boolean
    //   7	148	5	bool3	boolean
    //   1	172	6	localObject	Object
    //   4	107	7	localCursor	android.database.Cursor
    //   130	6	7	localException	Exception
    //   39	10	8	str	String
    // Exception table:
    //   from	to	target	type
    //   44	56	130	java/lang/Exception
    //   71	79	130	java/lang/Exception
    //   86	95	130	java/lang/Exception
    //   14	41	161	finally
    //   110	117	161	finally
    //   148	154	161	finally
    //   172	179	161	finally
    //   179	181	161	finally
    //   44	56	166	finally
    //   71	79	166	finally
    //   86	95	166	finally
    //   135	140	166	finally
  }
  
  public final boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBoolean = e();
        return paramBoolean;
      }
      finally {}
      paramBoolean = f();
    }
  }
  
  /* Error */
  public final int b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: iconst_0
    //   7: istore 4
    //   9: iconst_0
    //   10: istore_2
    //   11: aload_0
    //   12: monitorenter
    //   13: getstatic 81	cn/jiguang/c/a/c:z	[Ljava/lang/String;
    //   16: bipush 11
    //   18: aaload
    //   19: astore 5
    //   21: iload_1
    //   22: ifeq +11 -> 33
    //   25: getstatic 81	cn/jiguang/c/a/c:z	[Ljava/lang/String;
    //   28: bipush 6
    //   30: aaload
    //   31: astore 5
    //   33: new 114	java/lang/StringBuilder
    //   36: dup
    //   37: getstatic 81	cn/jiguang/c/a/c:z	[Ljava/lang/String;
    //   40: bipush 18
    //   42: aaload
    //   43: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload 5
    //   48: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 81	cn/jiguang/c/a/c:z	[Ljava/lang/String;
    //   54: bipush 19
    //   56: aaload
    //   57: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore 8
    //   65: aload 7
    //   67: astore 5
    //   69: aload_0
    //   70: getfield 112	cn/jiguang/c/a/c:d	Landroid/database/sqlite/SQLiteDatabase;
    //   73: aload 8
    //   75: aconst_null
    //   76: invokevirtual 217	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore 7
    //   81: aload 7
    //   83: ifnull +36 -> 119
    //   86: aload 7
    //   88: astore 5
    //   90: aload 7
    //   92: astore 6
    //   94: aload 7
    //   96: invokeinterface 220 1 0
    //   101: pop
    //   102: aload 7
    //   104: astore 5
    //   106: aload 7
    //   108: astore 6
    //   110: aload 7
    //   112: iconst_0
    //   113: invokeinterface 191 2 0
    //   118: istore_2
    //   119: iload_2
    //   120: istore_3
    //   121: aload 7
    //   123: ifnull +12 -> 135
    //   126: aload 7
    //   128: invokeinterface 221 1 0
    //   133: iload_2
    //   134: istore_3
    //   135: aload_0
    //   136: monitorexit
    //   137: iload_3
    //   138: ireturn
    //   139: astore 7
    //   141: aload 5
    //   143: astore 6
    //   145: aload 7
    //   147: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   150: iload 4
    //   152: istore_3
    //   153: aload 5
    //   155: ifnull -20 -> 135
    //   158: aload 5
    //   160: invokeinterface 221 1 0
    //   165: iload 4
    //   167: istore_3
    //   168: goto -33 -> 135
    //   171: astore 5
    //   173: aload_0
    //   174: monitorexit
    //   175: aload 5
    //   177: athrow
    //   178: astore 5
    //   180: aload 6
    //   182: ifnull +10 -> 192
    //   185: aload 6
    //   187: invokeinterface 221 1 0
    //   192: aload 5
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	c
    //   0	195	1	paramBoolean	boolean
    //   10	124	2	i	int
    //   120	48	3	j	int
    //   7	159	4	k	int
    //   19	140	5	localObject1	Object
    //   171	5	5	localObject2	Object
    //   178	15	5	localObject3	Object
    //   1	185	6	localObject4	Object
    //   4	123	7	localCursor	android.database.Cursor
    //   139	7	7	localException	Exception
    //   63	11	8	str	String
    // Exception table:
    //   from	to	target	type
    //   69	81	139	java/lang/Exception
    //   94	102	139	java/lang/Exception
    //   110	119	139	java/lang/Exception
    //   13	21	171	finally
    //   25	33	171	finally
    //   33	65	171	finally
    //   126	133	171	finally
    //   158	165	171	finally
    //   185	192	171	finally
    //   192	195	171	finally
    //   69	81	178	finally
    //   94	102	178	finally
    //   110	119	178	finally
    //   145	150	178	finally
  }
  
  /* Error */
  public final android.database.Cursor b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 114	java/lang/StringBuilder
    //   5: dup
    //   6: getstatic 81	cn/jiguang/c/a/c:z	[Ljava/lang/String;
    //   9: bipush 12
    //   11: aaload
    //   12: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc -43
    //   21: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 112	cn/jiguang/c/a/c:d	Landroid/database/sqlite/SQLiteDatabase;
    //   32: iconst_1
    //   33: getstatic 81	cn/jiguang/c/a/c:z	[Ljava/lang/String;
    //   36: iconst_3
    //   37: aaload
    //   38: getstatic 85	cn/jiguang/c/a/c:a	[Ljava/lang/String;
    //   41: aload_1
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: invokevirtual 232	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore_1
    //   51: aload_1
    //   52: astore_2
    //   53: aload_1
    //   54: ifnull +12 -> 66
    //   57: aload_1
    //   58: invokeinterface 220 1 0
    //   63: pop
    //   64: aload_1
    //   65: astore_2
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_2
    //   69: areturn
    //   70: astore_2
    //   71: aconst_null
    //   72: astore_1
    //   73: aload_2
    //   74: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   77: aload_1
    //   78: astore_2
    //   79: goto -13 -> 66
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: astore_2
    //   88: goto -15 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	c
    //   0	91	1	paramString	String
    //   52	17	2	str1	String
    //   70	4	2	localException1	Exception
    //   78	1	2	str2	String
    //   87	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	51	70	java/lang/Exception
    //   2	51	82	finally
    //   57	64	82	finally
    //   73	77	82	finally
    //   57	64	87	java/lang/Exception
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 81	cn/jiguang/c/a/c:z	[Ljava/lang/String;
    //   5: bipush 13
    //   7: aaload
    //   8: astore_1
    //   9: aload_0
    //   10: getfield 112	cn/jiguang/c/a/c:d	Landroid/database/sqlite/SQLiteDatabase;
    //   13: aload_1
    //   14: invokevirtual 235	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   25: goto -8 -> 17
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	c
    //   8	6	1	str	String
    //   20	2	1	localException	Exception
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	17	20	java/lang/Exception
    //   2	9	28	finally
    //   9	17	28	finally
    //   21	25	28	finally
  }
  
  public final boolean b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    for (;;)
    {
      try
      {
        String str = z[12] + paramString1 + "'";
        ContentValues localContentValues = new ContentValues();
        localContentValues.put(z[9], paramString1);
        localContentValues.put(z[0], paramString2);
        localContentValues.put(z[7], paramString3);
        localContentValues.put(z[5], paramString4);
        localContentValues.put(z[8], paramString5);
        localContentValues.put(z[11], Integer.valueOf(paramInt1));
        localContentValues.put(z[6], Integer.valueOf(paramInt2));
        localContentValues.put(z[2], Integer.valueOf(paramInt3));
        localContentValues.put(z[4], Integer.valueOf(paramInt4));
        localContentValues.put(z[10], Integer.valueOf(paramInt5));
        localContentValues.put(z[1], Integer.valueOf(paramInt6));
        bool = false;
        try
        {
          paramInt1 = this.d.update(z[3], localContentValues, str, null);
          if (paramInt1 <= 0) {
            continue;
          }
          bool = true;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          continue;
        }
        return bool;
      }
      finally {}
      boolean bool = false;
    }
  }
  
  /* Error */
  public final android.database.Cursor c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 81	cn/jiguang/c/a/c:z	[Ljava/lang/String;
    //   5: bipush 17
    //   7: aaload
    //   8: astore_1
    //   9: aload_0
    //   10: getfield 112	cn/jiguang/c/a/c:d	Landroid/database/sqlite/SQLiteDatabase;
    //   13: aload_1
    //   14: aconst_null
    //   15: invokevirtual 217	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore_1
    //   19: aload_1
    //   20: astore_2
    //   21: aload_1
    //   22: ifnull +12 -> 34
    //   25: aload_1
    //   26: invokeinterface 220 1 0
    //   31: pop
    //   32: aload_1
    //   33: astore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: areturn
    //   38: astore_2
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_2
    //   42: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   45: aload_1
    //   46: astore_2
    //   47: goto -13 -> 34
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: astore_2
    //   56: goto -15 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	c
    //   8	38	1	localObject1	Object
    //   50	4	1	localObject2	Object
    //   20	17	2	localObject3	Object
    //   38	4	2	localException1	Exception
    //   46	1	2	localObject4	Object
    //   55	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   9	19	38	java/lang/Exception
    //   2	9	50	finally
    //   9	19	50	finally
    //   25	32	50	finally
    //   41	45	50	finally
    //   25	32	55	java/lang/Exception
  }
  
  /* Error */
  public final android.database.Cursor d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 81	cn/jiguang/c/a/c:z	[Ljava/lang/String;
    //   5: bipush 20
    //   7: aaload
    //   8: astore_1
    //   9: aload_0
    //   10: getfield 112	cn/jiguang/c/a/c:d	Landroid/database/sqlite/SQLiteDatabase;
    //   13: aload_1
    //   14: aconst_null
    //   15: invokevirtual 217	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore_1
    //   19: aload_1
    //   20: astore_2
    //   21: aload_1
    //   22: ifnull +12 -> 34
    //   25: aload_1
    //   26: invokeinterface 220 1 0
    //   31: pop
    //   32: aload_1
    //   33: astore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: areturn
    //   38: astore_2
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_2
    //   42: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   45: aload_1
    //   46: astore_2
    //   47: goto -13 -> 34
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: astore_2
    //   56: goto -15 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	c
    //   8	38	1	localObject1	Object
    //   50	4	1	localObject2	Object
    //   20	17	2	localObject3	Object
    //   38	4	2	localException1	Exception
    //   46	1	2	localObject4	Object
    //   55	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   9	19	38	java/lang/Exception
    //   2	9	50	finally
    //   9	19	50	finally
    //   25	32	50	finally
    //   41	45	50	finally
    //   25	32	55	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */