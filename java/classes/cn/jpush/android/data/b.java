package cn.jpush.android.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.jpush.android.c.f;

public final class b
  extends SQLiteOpenHelper
{
  public static final String[] a;
  public static final String[] b;
  private static b c;
  private static final String[] z;
  
  static
  {
    Object localObject1 = new String[15];
    int j = 0;
    Object localObject2 = "3wO\001%}fP2`apN\013k3jTD?3";
    int i = -1;
    Object localObject4 = localObject1;
    int i4;
    Object localObject5;
    Object localObject3;
    for (;;)
    {
      char[] arrayOfChar = ((String)localObject2).toCharArray();
      int k = arrayOfChar.length;
      int i1 = 0;
      int m = 0;
      int i3 = i;
      localObject2 = arrayOfChar;
      i4 = j;
      localObject5 = localObject1;
      localObject3 = localObject4;
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
          i = 5;
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
        localObject3 = localObject4;
        localObject5 = localObject6;
        i4 = j;
        localObject2 = localObject1;
        i3 = i2;
        i2 = i3;
        localObject1 = localObject2;
        j = i4;
        localObject6 = localObject5;
        localObject4 = localObject3;
        k = n;
        m = i1;
        if (n > i1) {
          break label72;
        }
        localObject1 = new String((char[])localObject2).intern();
        switch (i3)
        {
        default: 
          localObject5[i4] = localObject1;
          j = 1;
          localObject2 = "Wao\001icfU";
          i = 0;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 0: 
          localObject5[i4] = localObject1;
          j = 2;
          localObject2 = "wqH\024%gbE\b`3vW\bl`w";
          i = 1;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 1: 
          localObject5[i4] = localObject1;
          j = 3;
          localObject2 = "wqH\024%gbE\b`3gH\023kjT\020";
          i = 2;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 2: 
          localObject5[i4] = localObject1;
          j = 4;
          localObject2 = "GkBDjgq\001w`jH\n%zp\035D";
          i = 3;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 3: 
          localObject5[i4] = localObject1;
          j = 5;
          localObject2 = "`fU\022lpf\t\000g";
          i = 4;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 4: 
          localObject5[i4] = localObject1;
          j = 6;
          localObject2 = "pqB\005qv#S\005gf\007\021ujT\020-LjCDl}wB\003`a#W\026l~bU\035%xf^DdfwH\rkpqB\t`}w\013\tvt\\N\000%gf_\020)rsW;lw#S\001}g/J\005l}\\N\000%gf_\020)3lQ\001wajC\001Zzg\007\020`kw\016";
          i = 5;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 5: 
          localObject5[i4] = localObject1;
          j = 7;
          localObject2 = "pqB\005qv#S\005gf\007\000jdmK\rvg+x\ra3jI\020`tfUDuajJ\005wj#L\001|3bR\020jzmD\026`~fI\020)~p@;lw#S\001}g/U\001uvbS;kfn\007\rkgf@\001w?pS\005wg\\W\013v3jI\020`tfUH`}gx\024j`#N\nqvdB\026)plI\020`}w\007\020`kw\016";
          i = 6;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 6: 
          localObject5[i4] = localObject1;
          j = 8;
          localObject2 = "|md\026`rwB";
          i = 7;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 7: 
          localObject5[i4] = localObject1;
          j = 9;
          localObject2 = "~bN\nZzg";
          i = 8;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 8: 
          localObject5[i4] = localObject1;
          j = 10;
          localObject2 = "|uB\026wzgB;lw";
          i = 9;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 9: 
          localObject5[i4] = localObject1;
          j = 11;
          localObject2 = "fsK\rvg";
          i = 10;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 10: 
          localObject5[i4] = localObject1;
          j = 12;
          localObject2 = "rsW;lw";
          i = 11;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 11: 
          localObject5[i4] = localObject1;
          j = 13;
          localObject2 = "~p@;lw";
          i = 12;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 12: 
          localObject5[i4] = localObject1;
          j = 14;
          localObject2 = "rsW;lw>\030";
          i = 13;
          localObject1 = localObject3;
          localObject4 = localObject3;
          break;
        case 13: 
          localObject5[i4] = localObject1;
          z = (String[])localObject3;
          localObject1 = new String[6];
          j = 0;
          localObject2 = "LjC";
          i = 14;
          localObject4 = localObject1;
          break;
          i = 19;
          continue;
          i = 3;
          continue;
          i = 39;
          continue;
          i = 100;
        }
      }
      localObject5[i4] = localObject1;
      localObject3[1] = z[13];
      j = 2;
      localObject2 = "afW\001dg\\I\021h";
      i = 15;
      localObject1 = localObject3;
      localObject4 = localObject3;
      continue;
      localObject5[i4] = localObject1;
      j = 3;
      localObject2 = "`wF\026qLsH\027";
      i = 16;
      localObject1 = localObject3;
      localObject4 = localObject3;
      continue;
      localObject5[i4] = localObject1;
      j = 4;
      localObject2 = "vmC;u|p";
      i = 17;
      localObject1 = localObject3;
      localObject4 = localObject3;
      continue;
      localObject5[i4] = localObject1;
      j = 5;
      localObject2 = "plI\020`}w";
      i = 18;
      localObject1 = localObject3;
      localObject4 = localObject3;
      continue;
      localObject5[i4] = localObject1;
      a = (String[])localObject3;
      localObject1 = new String[4];
      j = 0;
      localObject2 = "LjC";
      i = 19;
      localObject4 = localObject1;
    }
    localObject5[i4] = localObject1;
    localObject3[1] = z[13];
    localObject3[2] = z[12];
    localObject3[3] = z[9];
    b = (String[])localObject3;
  }
  
  private b(Context paramContext)
  {
    super(paramContext, z[5], null, 3);
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 82	cn/jpush/android/data/b:c	Lcn/jpush/android/data/b;
    //   6: ifnonnull +14 -> 20
    //   9: new 2	cn/jpush/android/data/b
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 84	cn/jpush/android/data/b:<init>	(Landroid/content/Context;)V
    //   17: putstatic 82	cn/jpush/android/data/b:c	Lcn/jpush/android/data/b;
    //   20: getstatic 82	cn/jpush/android/data/b:c	Lcn/jpush/android/data/b;
    //   23: invokevirtual 88	cn/jpush/android/data/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore 7
    //   28: aload 7
    //   30: getstatic 58	cn/jpush/android/data/b:z	[Ljava/lang/String;
    //   33: bipush 11
    //   35: aaload
    //   36: getstatic 72	cn/jpush/android/data/b:b	[Ljava/lang/String;
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: invokevirtual 94	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +255 -> 304
    //   52: aload_3
    //   53: invokeinterface 100 1 0
    //   58: iflt +246 -> 304
    //   61: aload_3
    //   62: invokeinterface 104 1 0
    //   67: ifeq +237 -> 304
    //   70: aload_3
    //   71: aload_3
    //   72: getstatic 58	cn/jpush/android/data/b:z	[Ljava/lang/String;
    //   75: bipush 12
    //   77: aaload
    //   78: invokeinterface 108 2 0
    //   83: invokeinterface 112 2 0
    //   88: astore 4
    //   90: aload_3
    //   91: aload_3
    //   92: getstatic 58	cn/jpush/android/data/b:z	[Ljava/lang/String;
    //   95: bipush 13
    //   97: aaload
    //   98: invokeinterface 108 2 0
    //   103: invokeinterface 112 2 0
    //   108: astore_0
    //   109: aload_3
    //   110: aload_3
    //   111: getstatic 58	cn/jpush/android/data/b:z	[Ljava/lang/String;
    //   114: bipush 9
    //   116: aaload
    //   117: invokeinterface 108 2 0
    //   122: invokeinterface 112 2 0
    //   127: astore 5
    //   129: aload_3
    //   130: aload_3
    //   131: getstatic 58	cn/jpush/android/data/b:z	[Ljava/lang/String;
    //   134: bipush 10
    //   136: aaload
    //   137: invokeinterface 108 2 0
    //   142: invokeinterface 112 2 0
    //   147: astore 6
    //   149: aload_1
    //   150: aload 4
    //   152: invokevirtual 116	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   155: istore_2
    //   156: iload_2
    //   157: ifeq -96 -> 61
    //   160: aload 6
    //   162: astore_1
    //   163: aload 7
    //   165: getstatic 58	cn/jpush/android/data/b:z	[Ljava/lang/String;
    //   168: bipush 11
    //   170: aaload
    //   171: getstatic 58	cn/jpush/android/data/b:z	[Ljava/lang/String;
    //   174: bipush 14
    //   176: aaload
    //   177: iconst_1
    //   178: anewarray 14	java/lang/String
    //   181: dup
    //   182: iconst_0
    //   183: aload 4
    //   185: aastore
    //   186: invokevirtual 120	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   189: pop
    //   190: new 122	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   197: aload_0
    //   198: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc -126
    //   203: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 5
    //   208: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc -126
    //   213: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_1
    //   217: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: astore_1
    //   224: aload_1
    //   225: astore_0
    //   226: aload_0
    //   227: astore_1
    //   228: aload_3
    //   229: ifnull +11 -> 240
    //   232: aload_3
    //   233: invokeinterface 136 1 0
    //   238: aload_0
    //   239: astore_1
    //   240: ldc 2
    //   242: monitorexit
    //   243: aload_1
    //   244: areturn
    //   245: astore_0
    //   246: aconst_null
    //   247: astore_3
    //   248: ldc -118
    //   250: astore_0
    //   251: aload_0
    //   252: astore_1
    //   253: aload_3
    //   254: ifnull -14 -> 240
    //   257: aload_3
    //   258: invokeinterface 136 1 0
    //   263: aload_0
    //   264: astore_1
    //   265: goto -25 -> 240
    //   268: astore_0
    //   269: ldc 2
    //   271: monitorexit
    //   272: aload_0
    //   273: athrow
    //   274: astore_0
    //   275: aconst_null
    //   276: astore_3
    //   277: aload_3
    //   278: ifnull +9 -> 287
    //   281: aload_3
    //   282: invokeinterface 136 1 0
    //   287: aload_0
    //   288: athrow
    //   289: astore_0
    //   290: goto -13 -> 277
    //   293: astore_0
    //   294: ldc -118
    //   296: astore_0
    //   297: goto -46 -> 251
    //   300: astore_1
    //   301: goto -50 -> 251
    //   304: ldc -118
    //   306: astore_1
    //   307: ldc -118
    //   309: astore 4
    //   311: ldc -118
    //   313: astore 5
    //   315: ldc -118
    //   317: astore_0
    //   318: goto -155 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	paramContext	Context
    //   0	321	1	paramString	String
    //   155	2	2	bool	boolean
    //   47	235	3	localCursor	android.database.Cursor
    //   88	222	4	str1	String
    //   127	187	5	str2	String
    //   147	14	6	str3	String
    //   26	138	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   3	20	245	java/lang/Exception
    //   20	48	245	java/lang/Exception
    //   232	238	268	finally
    //   257	263	268	finally
    //   281	287	268	finally
    //   287	289	268	finally
    //   3	20	274	finally
    //   20	48	274	finally
    //   52	61	289	finally
    //   61	156	289	finally
    //   163	224	289	finally
    //   52	61	293	java/lang/Exception
    //   61	156	293	java/lang/Exception
    //   163	224	300	java/lang/Exception
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    f.c(z[1], z[8]);
    paramSQLiteDatabase.execSQL(z[7]);
    paramSQLiteDatabase.execSQL(z[6]);
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    f.c(z[1], z[4] + paramInt1 + z[0] + paramInt2);
    paramSQLiteDatabase.execSQL(z[3]);
    paramSQLiteDatabase.execSQL(z[2]);
    onCreate(paramSQLiteDatabase);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    f.c(z[1], z[4] + paramInt1 + z[0] + paramInt2);
    paramSQLiteDatabase.execSQL(z[3]);
    paramSQLiteDatabase.execSQL(z[2]);
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/data/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */