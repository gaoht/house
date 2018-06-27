package com.superrtc.call;

import java.util.ArrayList;
import java.util.List;

public class d
  implements c.c
{
  private List<List<c.a>> a;
  
  /* Error */
  private List<c.a> a(int paramInt)
  {
    // Byte code:
    //   0: ldc 21
    //   2: new 23	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   9: ldc 26
    //   11: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: iload_1
    //   15: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18: ldc 35
    //   20: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 45	com/superrtc/call/Logging:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: invokestatic 51	android/os/SystemClock:elapsedRealtime	()J
    //   32: lstore 4
    //   34: aconst_null
    //   35: astore 11
    //   37: aconst_null
    //   38: astore 10
    //   40: aload 10
    //   42: astore 8
    //   44: aload 11
    //   46: astore 9
    //   48: ldc 21
    //   50: new 23	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   57: ldc 53
    //   59: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: iload_1
    //   63: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 45	com/superrtc/call/Logging:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload 10
    //   74: astore 8
    //   76: aload 11
    //   78: astore 9
    //   80: iload_1
    //   81: invokestatic 59	android/hardware/Camera:open	(I)Landroid/hardware/Camera;
    //   84: astore 10
    //   86: aload 10
    //   88: astore 8
    //   90: aload 10
    //   92: astore 9
    //   94: aload 10
    //   96: invokevirtual 63	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   99: astore 11
    //   101: aload 10
    //   103: ifnull +8 -> 111
    //   106: aload 10
    //   108: invokevirtual 66	android/hardware/Camera:release	()V
    //   111: new 68	java/util/ArrayList
    //   114: dup
    //   115: invokespecial 69	java/util/ArrayList:<init>	()V
    //   118: astore 9
    //   120: aload 11
    //   122: invokevirtual 75	android/hardware/Camera$Parameters:getSupportedPreviewFpsRange	()Ljava/util/List;
    //   125: astore 8
    //   127: aload 8
    //   129: ifnull +253 -> 382
    //   132: aload 8
    //   134: aload 8
    //   136: invokeinterface 81 1 0
    //   141: iconst_1
    //   142: isub
    //   143: invokeinterface 85 2 0
    //   148: checkcast 87	[I
    //   151: astore 8
    //   153: aload 8
    //   155: iconst_0
    //   156: iaload
    //   157: istore_2
    //   158: aload 8
    //   160: iconst_1
    //   161: iaload
    //   162: istore_3
    //   163: aload 11
    //   165: invokevirtual 90	android/hardware/Camera$Parameters:getSupportedPreviewSizes	()Ljava/util/List;
    //   168: invokeinterface 94 1 0
    //   173: astore 8
    //   175: aload 8
    //   177: invokeinterface 100 1 0
    //   182: ifeq +73 -> 255
    //   185: aload 8
    //   187: invokeinterface 104 1 0
    //   192: checkcast 106	android/hardware/Camera$Size
    //   195: astore 10
    //   197: aload 9
    //   199: new 108	com/superrtc/call/c$a
    //   202: dup
    //   203: aload 10
    //   205: getfield 112	android/hardware/Camera$Size:width	I
    //   208: aload 10
    //   210: getfield 115	android/hardware/Camera$Size:height	I
    //   213: iload_2
    //   214: iload_3
    //   215: invokespecial 118	com/superrtc/call/c$a:<init>	(IIII)V
    //   218: invokeinterface 122 2 0
    //   223: pop
    //   224: goto -49 -> 175
    //   227: astore 8
    //   229: ldc 21
    //   231: new 23	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   238: ldc 124
    //   240: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: iload_1
    //   244: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: aload 8
    //   252: invokestatic 128	com/superrtc/call/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   255: invokestatic 51	android/os/SystemClock:elapsedRealtime	()J
    //   258: lstore 6
    //   260: ldc 21
    //   262: new 23	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   269: ldc 26
    //   271: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: iload_1
    //   275: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: ldc -126
    //   280: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: lload 6
    //   285: lload 4
    //   287: lsub
    //   288: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   291: ldc -121
    //   293: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 45	com/superrtc/call/Logging:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload 9
    //   304: areturn
    //   305: astore 10
    //   307: aload 8
    //   309: astore 9
    //   311: ldc 21
    //   313: new 23	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   320: ldc -119
    //   322: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: iload_1
    //   326: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: aload 10
    //   334: invokestatic 128	com/superrtc/call/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   337: aload 8
    //   339: astore 9
    //   341: new 68	java/util/ArrayList
    //   344: dup
    //   345: invokespecial 69	java/util/ArrayList:<init>	()V
    //   348: astore 10
    //   350: aload 10
    //   352: astore 9
    //   354: aload 8
    //   356: ifnull -54 -> 302
    //   359: aload 8
    //   361: invokevirtual 66	android/hardware/Camera:release	()V
    //   364: aload 10
    //   366: areturn
    //   367: astore 8
    //   369: aload 9
    //   371: ifnull +8 -> 379
    //   374: aload 9
    //   376: invokevirtual 66	android/hardware/Camera:release	()V
    //   379: aload 8
    //   381: athrow
    //   382: iconst_0
    //   383: istore_3
    //   384: iconst_0
    //   385: istore_2
    //   386: goto -223 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	d
    //   0	389	1	paramInt	int
    //   157	229	2	i	int
    //   162	222	3	j	int
    //   32	254	4	l1	long
    //   258	26	6	l2	long
    //   42	144	8	localObject1	Object
    //   227	133	8	localException	Exception
    //   367	13	8	localObject2	Object
    //   46	329	9	localObject3	Object
    //   38	171	10	localObject4	Object
    //   305	28	10	localRuntimeException	RuntimeException
    //   348	17	10	localArrayList	ArrayList
    //   35	129	11	localParameters	android.hardware.Camera.Parameters
    // Exception table:
    //   from	to	target	type
    //   120	127	227	java/lang/Exception
    //   132	153	227	java/lang/Exception
    //   163	175	227	java/lang/Exception
    //   175	224	227	java/lang/Exception
    //   48	72	305	java/lang/RuntimeException
    //   80	86	305	java/lang/RuntimeException
    //   94	101	305	java/lang/RuntimeException
    //   48	72	367	finally
    //   80	86	367	finally
    //   94	101	367	finally
    //   311	337	367	finally
    //   341	350	367	finally
  }
  
  public List<c.a> getSupportedFormats(int paramInt)
  {
    try
    {
      if (this.a == null)
      {
        this.a = new ArrayList();
        int i = 0;
        while (i < c.getDeviceCount())
        {
          this.a.add(a(i));
          i += 1;
        }
      }
      return (List)this.a.get(paramInt);
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */