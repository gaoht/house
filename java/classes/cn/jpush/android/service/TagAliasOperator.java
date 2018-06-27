package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.api.a;
import cn.jpush.android.api.b;
import cn.jpush.android.c.f;
import cn.jpush.android.d;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class TagAliasOperator
  extends BroadcastReceiver
{
  private static TagAliasOperator a;
  private static Object c;
  private static final String[] z;
  private ConcurrentHashMap<Long, a> b = new ConcurrentHashMap();
  private AtomicBoolean d = new AtomicBoolean(false);
  
  static
  {
    String[] arrayOfString = new String[18];
    int j = 0;
    Object localObject2 = "N~\016nk\002c\016zi\017f\003kK\ra\034)\020";
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
        i = 42;
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
        localObject2 = "\032k\bhF\007k\034)I\017f\003kK\raO`YNd\032eFU*\035`NS";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "Nx\006m\020";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "=o\033HF\007k\034HD\n^\016nYNl\006gC\035bO3\n\013x\035fX-e\013l\020";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\rdAcZ\033y\007'K\000n\035fC\n$\006g^\013d\033'~/M0Hf'K<V~'G*F:";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\032k\bhF\007k\034VO\034x\000{I\001n\n";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = ":k\bHF\007k\034FZ\013x\016}E\034*\000gx\013i\n`\\\013*\035`NNc\034)C\000|\016eC\no";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = ":k\bHF\007k\034FZ\013x\016}E\034";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = ":k\bHF\007k\034FZ\013x\016}E\034*\000gx\013i\n`\\\013*\006g^\013d\033)C\035*\001|F\002";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "\032k\bhF\007k\034VY\013{\006m";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "=o\033HF\007k\034HD\n^\016nYN~\006dO\001\033)X\007nU";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "\035o\033]K\tK\001mk\002c\016z\n\0130";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "\rdAcZ\033y\007'K\000n\035fC\n$\006g^\013d\033'~/M0Hf'K<Vi/F#Kk-A";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "\032k\b)K\002c\016z\n\rk\003eH\017i\004)X\013m\006z^\013xO`YNi\016eF\013n";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "\001~\007lXNo\027jO\036~\006fD";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "\033d=lM\007y\033lXN~\016n\n\017f\006hYNi\016eF\fk\fb";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "<o\flC\030o\035)D\001~O{O\tc\034}O\034o\013%\n\rk\001gE\032*\fhF\002*\032gX\013m\006z^\013x=lI\013c\031lX";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "\032k\bHF\007k\034JK\002f\rhI\005yO`YNd\000}\n\013g\037}S";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        c = new Object();
        return;
        i = 110;
        continue;
        i = 10;
        continue;
        i = 111;
        continue;
        i = 9;
      }
    }
  }
  
  private a a(long paramLong)
  {
    return (a)this.b.get(Long.valueOf(paramLong));
  }
  
  public static TagAliasOperator a()
  {
    synchronized (c)
    {
      if (a == null) {
        a = new TagAliasOperator();
      }
      return a;
    }
  }
  
  private void b(long paramLong)
  {
    this.b.remove(Long.valueOf(paramLong));
  }
  
  /* Error */
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	cn/jpush/android/service/TagAliasOperator:d	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 118	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifeq +98 -> 107
    //   12: aload_0
    //   13: getfield 82	cn/jpush/android/service/TagAliasOperator:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   16: ifnull +91 -> 107
    //   19: aload_0
    //   20: getfield 82	cn/jpush/android/service/TagAliasOperator:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: invokevirtual 121	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   26: istore_2
    //   27: iload_2
    //   28: ifeq +79 -> 107
    //   31: aload_1
    //   32: aload_0
    //   33: invokevirtual 127	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   36: aload_0
    //   37: getfield 89	cn/jpush/android/service/TagAliasOperator:d	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   40: iconst_0
    //   41: invokevirtual 130	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   44: getstatic 69	cn/jpush/android/service/TagAliasOperator:z	[Ljava/lang/String;
    //   47: bipush 7
    //   49: aaload
    //   50: getstatic 69	cn/jpush/android/service/TagAliasOperator:z	[Ljava/lang/String;
    //   53: bipush 15
    //   55: aaload
    //   56: invokestatic 135	cn/jpush/android/c/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: astore_1
    //   63: getstatic 69	cn/jpush/android/service/TagAliasOperator:z	[Ljava/lang/String;
    //   66: bipush 7
    //   68: aaload
    //   69: getstatic 69	cn/jpush/android/service/TagAliasOperator:z	[Ljava/lang/String;
    //   72: bipush 16
    //   74: aaload
    //   75: aload_1
    //   76: invokestatic 138	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   79: goto -43 -> 36
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: astore_1
    //   88: getstatic 69	cn/jpush/android/service/TagAliasOperator:z	[Ljava/lang/String;
    //   91: bipush 7
    //   93: aaload
    //   94: getstatic 69	cn/jpush/android/service/TagAliasOperator:z	[Ljava/lang/String;
    //   97: bipush 14
    //   99: aaload
    //   100: aload_1
    //   101: invokestatic 138	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: goto -68 -> 36
    //   107: getstatic 69	cn/jpush/android/service/TagAliasOperator:z	[Ljava/lang/String;
    //   110: bipush 7
    //   112: aaload
    //   113: getstatic 69	cn/jpush/android/service/TagAliasOperator:z	[Ljava/lang/String;
    //   116: bipush 17
    //   118: aaload
    //   119: invokestatic 135	cn/jpush/android/c/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: goto -63 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	TagAliasOperator
    //   0	125	1	paramContext	Context
    //   26	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   31	36	62	java/lang/IllegalArgumentException
    //   2	27	82	finally
    //   31	36	82	finally
    //   36	59	82	finally
    //   63	79	82	finally
    //   88	104	82	finally
    //   107	122	82	finally
    //   31	36	87	java/lang/Exception
  }
  
  public final void a(Context paramContext)
  {
    if (!this.d.get()) {
      try
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addCategory(d.c);
        localIntentFilter.addAction(z[4]);
        localIntentFilter.addAction(z[12]);
        paramContext.registerReceiver(this, localIntentFilter);
        this.d.set(true);
        return;
      }
      catch (Exception paramContext)
      {
        f.i(z[7], z[11] + paramContext.getMessage());
        return;
      }
    }
    f.c(z[7], z[13]);
  }
  
  public final void a(Long paramLong, a parama)
  {
    this.b.put(paramLong, parama);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      f.h(z[7], z[8]);
      return;
    }
    long l = paramIntent.getLongExtra(z[9], -1L);
    int i = paramIntent.getIntExtra(z[5], 0);
    if (l == -1L)
    {
      f.g(z[7], z[6]);
      return;
    }
    f.a(z[7], z[2] + l + z[0] + this.b.toString());
    TagAliasCallback localTagAliasCallback;
    if (z[4].equals(paramIntent.getAction()))
    {
      f.a(z[7], z[10] + l);
      paramIntent = a(l);
      if (paramIntent != null)
      {
        localTagAliasCallback = paramIntent.c;
        b(l);
        if (localTagAliasCallback != null) {
          localTagAliasCallback.gotResult(b.b, paramIntent.a, paramIntent.b);
        }
      }
    }
    for (;;)
    {
      a().b(paramContext);
      return;
      f.g(z[7], z[1] + l);
      continue;
      f.a(z[7], z[3] + i + z[2] + l);
      paramIntent = a(l);
      if (paramIntent != null)
      {
        localTagAliasCallback = paramIntent.c;
        b(l);
        if (localTagAliasCallback != null) {
          localTagAliasCallback.gotResult(i, paramIntent.a, paramIntent.b);
        }
      }
      else
      {
        f.g(z[7], z[1] + l);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/service/TagAliasOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */