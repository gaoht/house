package com.unionpay.mobile.android.pboctransaction.sdapdu;

import java.util.ArrayList;
import java.util.HashSet;

public final class b
{
  public static String[] a;
  public static int b = 0;
  private static ArrayList<String> c = new ArrayList();
  
  public static void a()
  {
    HashSet localHashSet = b();
    a = new String[localHashSet.size()];
    localHashSet.toArray(a);
  }
  
  /* Error */
  private static HashSet<String> b()
  {
    // Byte code:
    //   0: new 28	java/util/HashSet
    //   3: dup
    //   4: invokespecial 43	java/util/HashSet:<init>	()V
    //   7: astore 6
    //   9: new 45	java/lang/ProcessBuilder
    //   12: dup
    //   13: iconst_0
    //   14: anewarray 34	java/lang/String
    //   17: invokespecial 48	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   20: iconst_1
    //   21: anewarray 34	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc 50
    //   28: aastore
    //   29: invokevirtual 54	java/lang/ProcessBuilder:command	([Ljava/lang/String;)Ljava/lang/ProcessBuilder;
    //   32: iconst_1
    //   33: invokevirtual 58	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   36: invokevirtual 62	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 67	java/lang/Process:waitFor	()I
    //   46: pop
    //   47: aload 4
    //   49: invokevirtual 71	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   52: astore 7
    //   54: sipush 1024
    //   57: newarray <illegal type>
    //   59: astore 8
    //   61: ldc 73
    //   63: astore 4
    //   65: aload 7
    //   67: aload 8
    //   69: invokevirtual 79	java/io/InputStream:read	([B)I
    //   72: iconst_m1
    //   73: if_icmpeq +39 -> 112
    //   76: new 81	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   83: aload 4
    //   85: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: new 34	java/lang/String
    //   91: dup
    //   92: aload 8
    //   94: invokespecial 89	java/lang/String:<init>	([B)V
    //   97: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore 5
    //   105: aload 5
    //   107: astore 4
    //   109: goto -44 -> 65
    //   112: aload 7
    //   114: invokevirtual 96	java/io/InputStream:close	()V
    //   117: aload 4
    //   119: ldc 98
    //   121: invokevirtual 102	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   124: astore 4
    //   126: aload 4
    //   128: arraylength
    //   129: istore_2
    //   130: iconst_0
    //   131: istore_0
    //   132: iload_0
    //   133: iload_2
    //   134: if_icmpge +123 -> 257
    //   137: aload 4
    //   139: iload_0
    //   140: aaload
    //   141: astore 5
    //   143: aload 5
    //   145: getstatic 108	java/util/Locale:US	Ljava/util/Locale;
    //   148: invokevirtual 112	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   151: ldc 114
    //   153: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   156: ifne +94 -> 250
    //   159: aload 5
    //   161: ldc 120
    //   163: invokevirtual 124	java/lang/String:matches	(Ljava/lang/String;)Z
    //   166: ifeq +84 -> 250
    //   169: aload 5
    //   171: ldc 126
    //   173: invokevirtual 102	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   176: astore 5
    //   178: aload 5
    //   180: arraylength
    //   181: istore_3
    //   182: iconst_0
    //   183: istore_1
    //   184: iload_1
    //   185: iload_3
    //   186: if_icmpge +64 -> 250
    //   189: aload 5
    //   191: iload_1
    //   192: aaload
    //   193: astore 7
    //   195: aload 7
    //   197: ldc -128
    //   199: invokevirtual 131	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   202: ifeq +27 -> 229
    //   205: aload 7
    //   207: getstatic 108	java/util/Locale:US	Ljava/util/Locale;
    //   210: invokevirtual 112	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   213: ldc -123
    //   215: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   218: ifne +11 -> 229
    //   221: aload 6
    //   223: aload 7
    //   225: invokevirtual 137	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   228: pop
    //   229: iload_1
    //   230: iconst_1
    //   231: iadd
    //   232: istore_1
    //   233: goto -49 -> 184
    //   236: astore 5
    //   238: ldc 73
    //   240: astore 4
    //   242: aload 5
    //   244: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   247: goto -130 -> 117
    //   250: iload_0
    //   251: iconst_1
    //   252: iadd
    //   253: istore_0
    //   254: goto -122 -> 132
    //   257: aload 6
    //   259: areturn
    //   260: astore 5
    //   262: goto -20 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   131	123	0	i	int
    //   183	50	1	j	int
    //   129	6	2	k	int
    //   181	6	3	m	int
    //   39	202	4	localObject1	Object
    //   103	87	5	localObject2	Object
    //   236	7	5	localException1	Exception
    //   260	1	5	localException2	Exception
    //   7	251	6	localHashSet	HashSet
    //   52	172	7	localInputStream	java.io.InputStream
    //   59	34	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   9	61	236	java/lang/Exception
    //   65	105	260	java/lang/Exception
    //   112	117	260	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/sdapdu/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */