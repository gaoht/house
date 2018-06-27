package cn.jiguang.c.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import cn.jiguang.c.d.b;
import cn.jiguang.service.Protocol;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class g
  implements Runnable
{
  public static AtomicLong a;
  public static AtomicBoolean b;
  private static final String[] z;
  private Context c;
  private Handler d;
  private volatile boolean e = false;
  private boolean f;
  
  static
  {
    String[] arrayOfString = new String[30];
    int j = 0;
    Object localObject2 = "-\003u\001\027\021\rh\030\037 \nh\023\026\027";
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
        i = 120;
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
        localObject2 = "\"\005u\037\027\rF,V\f\021\037R\002\027\023F,V\033\f\bo\023\033\027\017n\030B";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "%\007h\032\035\007Fu\031X\023\007s\005\035C\017q\005UQF,V\034\006\000`\003\024\027Fh\006V";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "OFb\031\026\r\003b\002\021\f\b;";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "!\003f\037\026C\022nV\n\026\b!\037\026C%n\030\026\006\005u\037\026\0042i\004\035\002\002![X\n\002;";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\026\bd\016\b\006\005u\023\034BFQ\003\013\0136s\031\f\f\005n\032V0\022n\006";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "0\017r?\026\005\t";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "-\003u\001\027\021\r!\032\021\020\022d\030\021\r\001/XV";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "&\036b\023\b\027\017n\030X\021\003b\023\021\025\003eXX-\tvV\032\021\003`\035XNFs\023\fY";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "1\003b\023\021\025\003eV\032\032\022d\005XNFm\023\026Y";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "!\024d\027\023C\024d\025\035\n\020h\030\037C\004xV\017\002\bu%\f\f\026![X\000\to\030\035\000\022h\031\026Y";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "7\017l\023\027\026\022!\037\026C,O?VC\"nV\026\f\022!\024\n\006\007jX";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "-\t!\004\035\023\ts\002X\001\007b\035\r\023Fh\006V";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "\016%n\030\026\006\005u\037\027\rFh\005X\021\003r\023\fC\022nVHC\021i\023\026C\bd\002\017\f\024jV\024\n\025u\023\026\n\bfXX!\024d\027\023C\bn\001V";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "锜辸掤奇赝OFk\006\r\020\016/\005\027勃輛弃幎";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = " \024d\027\f\006\002!\025\027\r\bd\025\f\n\toVUC";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "OFq\035\037Y";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = ",\bm\017X\016\007h\030X\n\026!\037\026C\025h\005V";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "1\003u\003\n\rFn\020X \nn\005\035C\fo\037X\000\to\030\035\000\022h\031\026CK!";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "6\bd\016\b\006\005u\023\034CK!8\027C\005n\030\026\006\005u\037\027\rFu\031X\000\nn\005\035MF";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "\"\005u\037\027\rF,V\033\017\tr\023;\f\bo\023\033\027\017n\030XNFb\031\026\r\003b\002\021\f\b;";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = " \nn\005\035C\005n\030\026\006\005u\037\027\rFd\004\n\f\024";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "\017\tf\037\026C\003s\004\027\021Js\023\f\021\037!\032\027\004\017oV\f\f\t!\033\031\r\037!\002\021\016\003r";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "1\003f\037\013\027\003!\020\031\n\nd\022TC\025u\031\bC\022i\023X\020\003s\000\021\000\003 ";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "\016%n\030\026\006\005u\037\027\rFh\005X\021\003r\023\fC\022nVHC\021i\023\026C\025u\027\f\006Fc\023\f\024\003d\030X\017\tf\037\026C\007o\022X\f\bM\031\037\004\003e9\026MFD\016\021\027Fe\037\n\006\005u\032\001M";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "1\003f\037\013\027\003!\020\031\n\nd\022TC\005m\031\013\006Fu\036\035C\005n\030\026\006\005u\037\027\rG";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "\017\tf\037\0267\017l\023\013Y";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "\r\003d\022X\r\tuV\023\006\003qV\f\000\026!\025\027\r\bd\025\fO\021h\032\024C\005m\031\013\006Fb\031\026\r\003b\002\021\f\b";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "\"\005u\037\027\rF,V\027\r*n\021\037\006\002H\030XNFb\031\026\r\003b\002\021\f\b;";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        j = 29;
        localObject2 = "\"\005u\037\027\rF,V\027\r*n\021\021\r `\037\024\006\002![X\021\003r\006;\f\002dL";
        i = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = new AtomicLong(0L);
        b = new AtomicBoolean(false);
        return;
        i = 99;
        continue;
        i = 102;
        continue;
        i = 1;
        continue;
        i = 118;
      }
    }
  }
  
  public g(Context paramContext, Handler paramHandler)
  {
    this.c = paramContext;
    this.d = paramHandler;
    this.f = true;
  }
  
  private boolean a(int paramInt)
  {
    if (this.e) {}
    label7:
    label113:
    int i;
    long l;
    label257:
    label259:
    do
    {
      for (;;)
      {
        return false;
        if (paramInt <= 0)
        {
          cn.jiguang.d.d.d(z[0], z[22]);
          return false;
        }
        cn.jiguang.d.d.c(z[0], z[26] + paramInt);
        if (!cn.jiguang.c.a.a.s()) {
          if (!b.a(this.c, a.get())) {
            if (cn.jiguang.c.a.a.m())
            {
              cn.jiguang.d.d.a(z[0], z[23]);
              this.d.sendEmptyMessageDelayed(1001, 100L);
              d();
            }
          }
        }
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label257;
          }
          i = b.b(this.c, a.get());
          if (i < 0) {
            break label7;
          }
          if (i <= 0) {
            break label284;
          }
          l = a.get();
          cn.jiguang.d.d.a(z[0], z[29] + i);
          b.a(Message.obtain(this.d, 7306), l);
          if (i != 108) {
            break label259;
          }
          cn.jiguang.f.a.m(this.c);
          paramInt -= 1;
          break;
          cn.jiguang.d.d.a(z[0], z[25]);
          break label113;
          if (b.a())
          {
            b.b();
            this.d.sendEmptyMessageDelayed(1031, 100L);
          }
        }
      }
    } while (i != 102);
    cn.jiguang.c.a.a.l();
    this.d.sendEmptyMessageDelayed(1003, 100L);
    return false;
    label284:
    if (0L != a.get())
    {
      l = a.get();
      cn.jiguang.d.d.b(z[0], z[28] + l);
      b.a(Message.obtain(this.d, 7304), l);
      if (!cn.jiguang.c.d.d.a().b(this.c))
      {
        cn.jiguang.d.d.d(z[0], z[27]);
        return false;
      }
    }
    else
    {
      cn.jiguang.d.d.g(z[0], z[24]);
      return false;
    }
    return true;
  }
  
  private void d()
  {
    cn.jiguang.d.d.d(z[0], z[20] + a.get());
    if (0L != a.get()) {
      try
      {
        b.set(true);
        a.set(Protocol.Close(a.get()));
        cn.jiguang.d.d.d(z[0], z[18] + a.get());
        b.set(false);
        this.f = false;
        if (cn.jiguang.c.d.d.a().i()) {
          b.a(Message.obtain(this.d, 7301), a.get());
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          cn.jiguang.d.d.c(z[0], z[21], localException);
        }
      }
    }
    cn.jiguang.d.d.c(z[0], z[19]);
  }
  
  public final void a()
  {
    cn.jiguang.d.d.d(z[0], z[1] + a.get());
    this.e = true;
    this.f = false;
    Protocol.Stop(a.get());
  }
  
  public final boolean b()
  {
    return this.e;
  }
  
  public final boolean c()
  {
    return this.f;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   3: iconst_0
    //   4: aaload
    //   5: new 131	java/lang/StringBuilder
    //   8: dup
    //   9: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   12: iconst_4
    //   13: aaload
    //   14: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: invokestatic 244	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   20: invokevirtual 247	java/lang/Thread:getId	()J
    //   23: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 249	cn/jiguang/d/d:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: invokestatic 254	cn/jiguang/c/f/b:e	()Lcn/jiguang/c/f/b;
    //   35: aload_0
    //   36: getfield 119	cn/jiguang/c/b/g:c	Landroid/content/Context;
    //   39: invokevirtual 256	cn/jiguang/c/f/b:a	(Landroid/content/Context;)V
    //   42: getstatic 104	cn/jiguang/c/b/g:a	Ljava/util/concurrent/atomic/AtomicLong;
    //   45: invokestatic 259	cn/jiguang/service/Protocol:InitConn	()J
    //   48: invokevirtual 226	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   51: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   54: iconst_0
    //   55: aaload
    //   56: new 131	java/lang/StringBuilder
    //   59: dup
    //   60: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   63: bipush 15
    //   65: aaload
    //   66: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: getstatic 104	cn/jiguang/c/b/g:a	Ljava/util/concurrent/atomic/AtomicLong;
    //   72: invokevirtual 153	java/util/concurrent/atomic/AtomicLong:get	()J
    //   75: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   78: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 143	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_0
    //   85: getfield 119	cn/jiguang/c/b/g:c	Landroid/content/Context;
    //   88: invokestatic 262	cn/jiguang/c/d/b:a	(Landroid/content/Context;)Lcn/jiguang/c/b/j;
    //   91: astore_2
    //   92: aload_2
    //   93: ifnull +116 -> 209
    //   96: aload_2
    //   97: getfield 267	cn/jiguang/c/b/j:a	Ljava/util/List;
    //   100: invokeinterface 273 1 0
    //   105: istore_1
    //   106: iload_1
    //   107: ifeq +102 -> 209
    //   110: aload_2
    //   111: getfield 277	cn/jiguang/c/b/j:h	Ljava/lang/String;
    //   114: invokestatic 279	cn/jiguang/c/a/a:f	(Ljava/lang/String;)V
    //   117: iload_1
    //   118: iconst_1
    //   119: if_icmple +151 -> 270
    //   122: new 281	cn/jiguang/c/b/k
    //   125: dup
    //   126: aload_2
    //   127: getfield 267	cn/jiguang/c/b/j:a	Ljava/util/List;
    //   130: iconst_1
    //   131: invokeinterface 284 2 0
    //   136: checkcast 23	java/lang/String
    //   139: invokespecial 285	cn/jiguang/c/b/k:<init>	(Ljava/lang/String;)V
    //   142: astore_3
    //   143: aload_3
    //   144: getfield 287	cn/jiguang/c/b/k:a	Ljava/lang/String;
    //   147: invokestatic 289	cn/jiguang/c/a/a:c	(Ljava/lang/String;)V
    //   150: aload_3
    //   151: getfield 292	cn/jiguang/c/b/k:b	I
    //   154: invokestatic 295	cn/jiguang/c/a/a:b	(I)V
    //   157: iload_1
    //   158: iconst_2
    //   159: if_icmple +129 -> 288
    //   162: aload_2
    //   163: getfield 267	cn/jiguang/c/b/j:a	Ljava/util/List;
    //   166: iconst_2
    //   167: invokeinterface 284 2 0
    //   172: checkcast 23	java/lang/String
    //   175: invokestatic 300	cn/jiguang/c/d/l:a	(Ljava/lang/String;)Ljava/lang/String;
    //   178: pop
    //   179: aload_2
    //   180: getfield 267	cn/jiguang/c/b/j:a	Ljava/util/List;
    //   183: iconst_2
    //   184: invokeinterface 284 2 0
    //   189: checkcast 23	java/lang/String
    //   192: invokestatic 302	cn/jiguang/c/a/a:d	(Ljava/lang/String;)V
    //   195: aload_2
    //   196: getfield 304	cn/jiguang/c/b/j:c	Ljava/lang/String;
    //   199: ifnull +10 -> 209
    //   202: aload_2
    //   203: getfield 304	cn/jiguang/c/b/j:c	Ljava/lang/String;
    //   206: invokestatic 306	cn/jiguang/c/a/a:e	(Ljava/lang/String;)V
    //   209: aload_0
    //   210: getfield 117	cn/jiguang/c/b/g:e	Z
    //   213: ifeq +93 -> 306
    //   216: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   219: iconst_0
    //   220: aaload
    //   221: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   224: iconst_5
    //   225: aaload
    //   226: invokestatic 213	cn/jiguang/d/d:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_0
    //   230: invokespecial 173	cn/jiguang/c/b/g:d	()V
    //   233: return
    //   234: astore_2
    //   235: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   238: iconst_0
    //   239: aaload
    //   240: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   243: bipush 14
    //   245: aaload
    //   246: aload_2
    //   247: invokestatic 308	cn/jiguang/d/d:f	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   250: return
    //   251: astore_3
    //   252: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   255: bipush 6
    //   257: aaload
    //   258: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   261: iconst_2
    //   262: aaload
    //   263: aload_3
    //   264: invokestatic 310	cn/jiguang/d/d:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   267: goto -110 -> 157
    //   270: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   273: bipush 6
    //   275: aaload
    //   276: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   279: bipush 17
    //   281: aaload
    //   282: invokestatic 312	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: goto -128 -> 157
    //   288: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   291: bipush 6
    //   293: aaload
    //   294: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   297: bipush 12
    //   299: aaload
    //   300: invokestatic 312	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: goto -108 -> 195
    //   306: aload_0
    //   307: getstatic 104	cn/jiguang/c/b/g:a	Ljava/util/concurrent/atomic/AtomicLong;
    //   310: invokevirtual 153	java/util/concurrent/atomic/AtomicLong:get	()J
    //   313: aload_2
    //   314: invokestatic 315	cn/jiguang/c/d/b:a	(Lcn/jiguang/c/b/g;JLcn/jiguang/c/b/j;)Z
    //   317: ifne +8 -> 325
    //   320: aload_0
    //   321: invokespecial 173	cn/jiguang/c/b/g:d	()V
    //   324: return
    //   325: aload_0
    //   326: iconst_2
    //   327: invokespecial 317	cn/jiguang/c/b/g:a	(I)Z
    //   330: ifne +8 -> 338
    //   333: aload_0
    //   334: invokespecial 173	cn/jiguang/c/b/g:d	()V
    //   337: return
    //   338: sipush 8192
    //   341: newarray <illegal type>
    //   343: astore_2
    //   344: aload_0
    //   345: getfield 117	cn/jiguang/c/b/g:e	Z
    //   348: ifne +197 -> 545
    //   351: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   354: iconst_0
    //   355: aaload
    //   356: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   359: bipush 7
    //   361: aaload
    //   362: invokestatic 129	cn/jiguang/d/d:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: getstatic 104	cn/jiguang/c/b/g:a	Ljava/util/concurrent/atomic/AtomicLong;
    //   368: invokevirtual 153	java/util/concurrent/atomic/AtomicLong:get	()J
    //   371: aload_2
    //   372: ldc_w 318
    //   375: invokestatic 322	cn/jiguang/service/Protocol:RecvPush	(J[BI)I
    //   378: istore_1
    //   379: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   382: iconst_0
    //   383: aaload
    //   384: new 131	java/lang/StringBuilder
    //   387: dup
    //   388: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   391: bipush 9
    //   393: aaload
    //   394: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   397: iload_1
    //   398: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   401: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   404: iconst_3
    //   405: aaload
    //   406: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: getstatic 104	cn/jiguang/c/b/g:a	Ljava/util/concurrent/atomic/AtomicLong;
    //   412: invokevirtual 153	java/util/concurrent/atomic/AtomicLong:get	()J
    //   415: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   418: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   421: bipush 16
    //   423: aaload
    //   424: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: getstatic 328	cn/jiguang/c/a:c	Ljava/lang/String;
    //   430: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 129	cn/jiguang/d/d:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: lconst_0
    //   440: getstatic 104	cn/jiguang/c/b/g:a	Ljava/util/concurrent/atomic/AtomicLong;
    //   443: invokevirtual 153	java/util/concurrent/atomic/AtomicLong:get	()J
    //   446: lcmp
    //   447: ifne +18 -> 465
    //   450: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   453: iconst_0
    //   454: aaload
    //   455: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   458: bipush 13
    //   460: aaload
    //   461: invokestatic 312	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: return
    //   465: iload_1
    //   466: ifle +27 -> 493
    //   469: iload_1
    //   470: newarray <illegal type>
    //   472: astore_3
    //   473: aload_2
    //   474: iconst_0
    //   475: aload_3
    //   476: iconst_0
    //   477: iload_1
    //   478: invokestatic 334	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   481: aload_0
    //   482: getfield 119	cn/jiguang/c/b/g:c	Landroid/content/Context;
    //   485: aload_3
    //   486: invokestatic 339	cn/jiguang/c/e/a/a/a:a	(Landroid/content/Context;[B)Z
    //   489: pop
    //   490: goto -146 -> 344
    //   493: iload_1
    //   494: sipush 64542
    //   497: if_icmpne +20 -> 517
    //   500: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   503: iconst_0
    //   504: aaload
    //   505: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   508: bipush 11
    //   510: aaload
    //   511: invokestatic 143	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: goto -170 -> 344
    //   517: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   520: iconst_0
    //   521: aaload
    //   522: new 131	java/lang/StringBuilder
    //   525: dup
    //   526: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   529: bipush 8
    //   531: aaload
    //   532: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   535: iload_1
    //   536: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   539: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 129	cn/jiguang/d/d:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: aload_0
    //   546: getfield 117	cn/jiguang/c/b/g:e	Z
    //   549: ifeq +36 -> 585
    //   552: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   555: iconst_0
    //   556: aaload
    //   557: new 131	java/lang/StringBuilder
    //   560: dup
    //   561: getstatic 97	cn/jiguang/c/b/g:z	[Ljava/lang/String;
    //   564: bipush 10
    //   566: aaload
    //   567: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   570: getstatic 104	cn/jiguang/c/b/g:a	Ljava/util/concurrent/atomic/AtomicLong;
    //   573: invokevirtual 153	java/util/concurrent/atomic/AtomicLong:get	()J
    //   576: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   579: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 129	cn/jiguang/d/d:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: aload_0
    //   586: invokespecial 173	cn/jiguang/c/b/g:d	()V
    //   589: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	this	g
    //   105	431	1	i	int
    //   91	112	2	localj	j
    //   234	80	2	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   343	131	2	arrayOfByte1	byte[]
    //   142	9	3	localk	k
    //   251	13	3	localException	Exception
    //   472	14	3	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   42	84	234	java/lang/UnsatisfiedLinkError
    //   122	157	251	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */