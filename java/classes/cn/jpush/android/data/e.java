package cn.jpush.android.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public final class e
{
  public static final String[] a;
  private static final String[] z;
  private Context b;
  private f c;
  private SQLiteDatabase d;
  
  static
  {
    Object localObject1 = new String[19];
    int j = 0;
    Object localObject3 = "\013\000,\034\022\022\000\007AMG\017\035\033]\013\000,\013\017\016\t\024\032\0178\032\032\022\030[";
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
        i = 125;
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
        localObject3 = "\0231\037\020\036\006\002\035\020\t\016\b\032\034\034\023\007\034\021";
        i = 0;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 0: 
        localObject5[i4] = localObject1;
        j = 2;
        localObject3 = "G\017\035\033]\013\000,\013\017\016\t\024\032\0178\032\032\022\030";
        i = 1;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 1: 
        localObject5[i4] = localObject1;
        j = 3;
        localObject3 = "\013\000,\034\022\022\000\007B";
        i = 2;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 2: 
        localObject5[i4] = localObject1;
        j = 4;
        localObject3 = "\004\033\001\f\022\025N\032\f]\t\033\037\023";
        i = 3;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 3: 
        localObject5[i4] = localObject1;
        j = 5;
        localObject3 = "+\001\020\036\021)\001\007\026\033\016\r\022\013\024\b\0007=";
        i = 4;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 4: 
        localObject5[i4] = localObject1;
        j = 6;
        localObject3 = "\b\036\026\021]5\013\022\033\034\005\002\026;\034\023\0171\036\016\002N\025\036\024\013N\026E";
        i = 5;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 5: 
        localObject5[i4] = localObject1;
        j = 7;
        localObject3 = "Z^";
        i = 6;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 6: 
        localObject5[i4] = localObject1;
        j = 8;
        localObject3 = "\013\000,\026\031Z";
        i = 7;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 7: 
        localObject5[i4] = localObject1;
        j = 9;
        localObject3 = "G\017\035\033]\013\000,\013\004\027\013";
        i = 8;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 8: 
        localObject5[i4] = localObject1;
        j = 10;
        localObject3 = "\013\000,\013\017\016\t\024\032\0178\032\032\022\030";
        i = 9;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 9: 
        localObject5[i4] = localObject1;
        j = 11;
        localObject3 = "\013\000,\026\031";
        i = 10;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 10: 
        localObject5[i4] = localObject1;
        j = 12;
        localObject3 = "\013\000,\036\031\0031\007\026\020\002";
        i = 11;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 11: 
        localObject5[i4] = localObject1;
        j = 13;
        localObject3 = "\013\000,\032\005\023\034\022";
        i = 12;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 12: 
        localObject5[i4] = localObject1;
        j = 14;
        localObject3 = "\013\000,\013\004\027\013";
        i = 13;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 13: 
        localObject5[i4] = localObject1;
        j = 15;
        localObject3 = "\013\000,\r\030\n\001\005\032";
        i = 14;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 14: 
        localObject5[i4] = localObject1;
        j = 16;
        localObject3 = "\013\000,\034\022\022\000\007";
        i = 15;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 15: 
        localObject5[i4] = localObject1;
        j = 17;
        localObject3 = "\b\036\026\021]\b\036\026\021*\025\007\007\036\037\013\0137\036\t\006\f\022\f\030G\b\022\026\021G\013I";
        i = 16;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 16: 
        localObject5[i4] = localObject1;
        j = 18;
        localObject3 = "\013\000,\034\022\022\000\007AM";
        i = 17;
        localObject1 = localObject2;
        localObject4 = localObject2;
        break;
      case 17: 
        localObject5[i4] = localObject1;
        z = (String[])localObject2;
        localObject1 = new String[8];
        j = 0;
        localObject3 = "8\007\027";
        i = 18;
        localObject4 = localObject1;
        break;
        i = 103;
        continue;
        i = 110;
        continue;
        i = 115;
        continue;
        i = 127;
      }
    }
    localObject5[i4] = localObject1;
    localObject2[1] = z[11];
    localObject2[2] = z[16];
    localObject2[3] = z[15];
    localObject2[4] = z[14];
    localObject2[5] = z[13];
    localObject2[6] = z[10];
    localObject2[7] = z[12];
    a = (String[])localObject2;
  }
  
  public e(Context paramContext)
  {
    this.b = paramContext;
    this.c = new f(paramContext);
  }
  
  private boolean c()
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
        cn.jpush.android.c.f.i(z[5], z[17] + localException.getMessage());
      }
    }
    finally {}
    return bool;
  }
  
  private boolean d()
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
        cn.jpush.android.c.f.i(z[5], z[6] + localException.getMessage());
      }
    }
    finally {}
    return bool;
  }
  
  public final long a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong2, long paramLong3)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(z[11], Long.valueOf(paramLong1));
      localContentValues.put(z[16], Integer.valueOf(1));
      localContentValues.put(z[15], Integer.valueOf(0));
      localContentValues.put(z[14], Integer.valueOf(0));
      localContentValues.put(z[13], paramString);
      localContentValues.put(z[10], Long.valueOf(paramLong2));
      localContentValues.put(z[12], Long.valueOf(paramLong3));
      paramLong1 = 0L;
      try
      {
        paramLong2 = this.d.insert(z[1], null, localContentValues);
        paramLong1 = paramLong2;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      return paramLong1;
    }
    finally {}
  }
  
  /* Error */
  public final Cursor a(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 96	java/lang/StringBuilder
    //   5: dup
    //   6: getstatic 69	cn/jpush/android/data/e:z	[Ljava/lang/String;
    //   9: iconst_3
    //   10: aaload
    //   11: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: iconst_1
    //   15: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18: getstatic 69	cn/jpush/android/data/e:z	[Ljava/lang/String;
    //   21: iconst_2
    //   22: aaload
    //   23: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc -99
    //   28: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: lload_2
    //   32: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   35: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore 4
    //   40: aload_0
    //   41: getfield 94	cn/jpush/android/data/e:d	Landroid/database/sqlite/SQLiteDatabase;
    //   44: iconst_1
    //   45: getstatic 69	cn/jpush/android/data/e:z	[Ljava/lang/String;
    //   48: iconst_1
    //   49: aaload
    //   50: getstatic 73	cn/jpush/android/data/e:a	[Ljava/lang/String;
    //   53: aload 4
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 164	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 4
    //   65: aload 4
    //   67: astore 5
    //   69: aload 4
    //   71: ifnull +15 -> 86
    //   74: aload 4
    //   76: invokeinterface 169 1 0
    //   81: pop
    //   82: aload 4
    //   84: astore 5
    //   86: aload_0
    //   87: monitorexit
    //   88: aload 5
    //   90: areturn
    //   91: astore 5
    //   93: aconst_null
    //   94: astore 4
    //   96: aload 5
    //   98: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   101: aload 4
    //   103: astore 5
    //   105: goto -19 -> 86
    //   108: astore 4
    //   110: aload_0
    //   111: monitorexit
    //   112: aload 4
    //   114: athrow
    //   115: astore 5
    //   117: goto -21 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	e
    //   0	120	1	paramInt	int
    //   0	120	2	paramLong	long
    //   38	64	4	localObject1	Object
    //   108	5	4	localObject2	Object
    //   67	22	5	localObject3	Object
    //   91	6	5	localException1	Exception
    //   103	1	5	localObject4	Object
    //   115	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	65	91	java/lang/Exception
    //   2	65	108	finally
    //   74	82	108	finally
    //   96	101	108	finally
    //   74	82	115	java/lang/Exception
  }
  
  /* Error */
  public final Cursor a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 96	java/lang/StringBuilder
    //   5: dup
    //   6: getstatic 69	cn/jpush/android/data/e:z	[Ljava/lang/String;
    //   9: bipush 8
    //   11: aaload
    //   12: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: lload_1
    //   16: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: getstatic 69	cn/jpush/android/data/e:z	[Ljava/lang/String;
    //   22: bipush 9
    //   24: aaload
    //   25: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: getstatic 69	cn/jpush/android/data/e:z	[Ljava/lang/String;
    //   31: bipush 7
    //   33: aaload
    //   34: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore 4
    //   42: aload_0
    //   43: getfield 94	cn/jpush/android/data/e:d	Landroid/database/sqlite/SQLiteDatabase;
    //   46: iconst_1
    //   47: getstatic 69	cn/jpush/android/data/e:z	[Ljava/lang/String;
    //   50: iconst_1
    //   51: aaload
    //   52: getstatic 73	cn/jpush/android/data/e:a	[Ljava/lang/String;
    //   55: aload 4
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 164	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 4
    //   67: aload 4
    //   69: astore 5
    //   71: aload 4
    //   73: ifnull +15 -> 88
    //   76: aload 4
    //   78: invokeinterface 169 1 0
    //   83: pop
    //   84: aload 4
    //   86: astore 5
    //   88: aload_0
    //   89: monitorexit
    //   90: aload 5
    //   92: areturn
    //   93: astore 4
    //   95: aload_0
    //   96: monitorexit
    //   97: aload 4
    //   99: athrow
    //   100: astore 4
    //   102: aconst_null
    //   103: astore 5
    //   105: goto -17 -> 88
    //   108: astore 5
    //   110: aload 4
    //   112: astore 5
    //   114: goto -26 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	e
    //   0	117	1	paramLong	long
    //   0	117	3	paramInt	int
    //   40	45	4	localObject1	Object
    //   93	5	4	localObject2	Object
    //   100	11	4	localException1	Exception
    //   69	35	5	localObject3	Object
    //   108	1	5	localException2	Exception
    //   112	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   2	67	93	finally
    //   76	84	93	finally
    //   2	67	100	java/lang/Exception
    //   76	84	108	java/lang/Exception
  }
  
  public final Cursor a(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      label90:
      try
      {
        localObject1 = z[0] + (300000L + paramLong1) + z[2] + ">" + paramLong1;
      }
      finally {}
      try
      {
        localObject1 = this.d.query(true, z[1], a, (String)localObject1, null, null, null, null, null);
        localObject3 = localObject1;
        if (localObject1 == null) {}
      }
      catch (Exception localException1)
      {
        localObject3 = null;
      }
    }
    try
    {
      ((Cursor)localObject1).moveToFirst();
      localObject3 = localObject1;
    }
    catch (Exception localException2)
    {
      Exception localException3 = localException1;
      break label90;
    }
    return (Cursor)localObject3;
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
  public final void a(Cursor paramCursor, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +12 -> 15
    //   6: aload_1
    //   7: invokeinterface 183 1 0
    //   12: ifne +19 -> 31
    //   15: getstatic 69	cn/jpush/android/data/e:z	[Ljava/lang/String;
    //   18: iconst_5
    //   19: aaload
    //   20: getstatic 69	cn/jpush/android/data/e:z	[Ljava/lang/String;
    //   23: iconst_4
    //   24: aaload
    //   25: invokestatic 185	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_2
    //   32: astore_3
    //   33: aload_2
    //   34: ifnonnull +11 -> 45
    //   37: new 187	cn/jpush/android/data/g
    //   40: dup
    //   41: invokespecial 188	cn/jpush/android/data/g:<init>	()V
    //   44: astore_3
    //   45: aload_3
    //   46: aload_1
    //   47: iconst_1
    //   48: invokeinterface 192 2 0
    //   53: invokevirtual 195	cn/jpush/android/data/g:a	(J)V
    //   56: aload_3
    //   57: aload_1
    //   58: iconst_2
    //   59: invokeinterface 199 2 0
    //   64: invokevirtual 202	cn/jpush/android/data/g:a	(I)V
    //   67: aload_3
    //   68: aload_1
    //   69: iconst_3
    //   70: invokeinterface 199 2 0
    //   75: invokevirtual 204	cn/jpush/android/data/g:b	(I)V
    //   78: aload_3
    //   79: aload_1
    //   80: iconst_4
    //   81: invokeinterface 199 2 0
    //   86: invokevirtual 206	cn/jpush/android/data/g:c	(I)V
    //   89: aload_3
    //   90: aload_1
    //   91: iconst_5
    //   92: invokeinterface 210 2 0
    //   97: invokevirtual 212	cn/jpush/android/data/g:a	(Ljava/lang/String;)V
    //   100: aload_3
    //   101: aload_1
    //   102: bipush 6
    //   104: invokeinterface 192 2 0
    //   109: invokevirtual 214	cn/jpush/android/data/g:c	(J)V
    //   112: aload_3
    //   113: aload_1
    //   114: bipush 7
    //   116: invokeinterface 192 2 0
    //   121: invokevirtual 216	cn/jpush/android/data/g:b	(J)V
    //   124: getstatic 69	cn/jpush/android/data/e:z	[Ljava/lang/String;
    //   127: iconst_5
    //   128: aaload
    //   129: aload_3
    //   130: invokevirtual 217	cn/jpush/android/data/g:toString	()Ljava/lang/String;
    //   133: invokestatic 220	cn/jpush/android/c/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto -108 -> 28
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 224	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   149: pop
    //   150: goto -26 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	e
    //   0	153	1	paramCursor	Cursor
    //   0	153	2	paramg	g
    //   32	98	3	localg	g
    // Exception table:
    //   from	to	target	type
    //   6	15	139	finally
    //   15	28	139	finally
    //   37	45	139	finally
    //   45	124	139	finally
    //   124	136	139	finally
    //   145	150	139	finally
    //   45	124	144	java/lang/Exception
  }
  
  public final boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBoolean = c();
        return paramBoolean;
      }
      finally {}
      paramBoolean = d();
    }
  }
  
  public final boolean b()
  {
    bool = true;
    for (;;)
    {
      try
      {
        String str = z[18];
        ContentValues localContentValues = new ContentValues();
        localContentValues.put(z[16], Integer.valueOf(0));
        localContentValues.put(z[15], Integer.valueOf(1));
        localContentValues.put(z[14], Integer.valueOf(0));
        int i = this.d.update(z[1], localContentValues, str, null);
        if (i <= 0) {
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        bool = false;
        continue;
      }
      finally {}
      return bool;
      bool = false;
    }
  }
  
  public final boolean b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong2, long paramLong3)
  {
    for (;;)
    {
      try
      {
        String str = z[8] + paramLong1;
        ContentValues localContentValues = new ContentValues();
        localContentValues.put(z[11], Long.valueOf(paramLong1));
        localContentValues.put(z[16], Integer.valueOf(paramInt1));
        localContentValues.put(z[15], Integer.valueOf(paramInt2));
        localContentValues.put(z[14], Integer.valueOf(0));
        localContentValues.put(z[13], paramString);
        localContentValues.put(z[10], Long.valueOf(paramLong2));
        localContentValues.put(z[12], Long.valueOf(paramLong3));
        paramInt1 = this.d.update(z[1], localContentValues, str, null);
        if (paramInt1 <= 0) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        boolean bool = false;
        continue;
      }
      finally {}
      return bool;
      bool = false;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/data/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */