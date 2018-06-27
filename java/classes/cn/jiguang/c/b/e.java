package cn.jiguang.c.b;

import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import cn.jiguang.api.JResponse;
import cn.jiguang.c.d.b;
import cn.jiguang.c.e.a.a.c;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class e
{
  private static boolean e;
  private static Object k;
  private static e m;
  private static final String[] z;
  private ExecutorService a;
  private g b;
  private f c;
  private HandlerThread d;
  private int f = 0;
  private int g = 0;
  private long h;
  private Context i;
  private boolean j = false;
  private WeakReference<Service> l;
  private int n;
  private int o;
  
  static
  {
    String[] arrayOfString = new String[54];
    int i2 = 0;
    Object localObject2 = "waC6\036Ua\b\031\022I/Z=\000Wj[,Q\017/K5\025\030";
    int i1 = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int i3 = arrayOfChar.length;
    int i6 = 0;
    int i4 = 0;
    int i8 = i1;
    localObject2 = arrayOfChar;
    int i9 = i2;
    Object localObject3 = localObject1;
    int i5 = i3;
    Object localObject4;
    int i7;
    if (i3 <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i7 = i1;
      label68:
      i5 = i4;
      label71:
      localObject2 = localObject1;
      i6 = localObject2[i4];
      switch (i5 % 5)
      {
      default: 
        i1 = 113;
      }
    }
    for (;;)
    {
      localObject2[i4] = ((char)(i1 ^ i6));
      i5 += 1;
      if (i3 == 0)
      {
        i4 = i3;
        break label71;
      }
      i6 = i5;
      i5 = i3;
      localObject3 = localObject4;
      i9 = i2;
      localObject2 = localObject1;
      i8 = i7;
      i7 = i8;
      localObject1 = localObject2;
      i2 = i9;
      localObject4 = localObject3;
      i3 = i5;
      i4 = i6;
      if (i5 > i6) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i8)
      {
      default: 
        localObject3[i9] = localObject1;
        i2 = 1;
        localObject2 = "vnOx\020NfI+QClCx\002WlK=\024F.\b";
        i1 = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i9] = localObject1;
        i2 = 2;
        localObject2 = "hfO-\020Lh|;\001onF9\026G}";
        i1 = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i9] = localObject1;
        i2 = 3;
        localObject2 = "jjI*\005@jI,QClCx\002WlK=\024F.\b";
        i1 = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i9] = localObject1;
        i2 = 4;
        localObject2 = "vgMx\037G{_7\003IfF?QAcA=\037V/A+QA`F6\024A{M<_\002HA.\024\002zXv";
        i1 = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i9] = localObject1;
        i2 = 5;
        localObject2 = "cl\\1\036L/\005x\036LGM9\003VmM9\005qzK;\024Gk\buQA`F6\024A{A7\037\030";
        i1 = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i9] = localObject1;
        i2 = 6;
        localObject2 = "jjI*\005@jI,QQzK;\024Gk\b;\036LaM;\005K`Fx\030Q/I4\003GnL!QMz\\u\025C{M<_\002FO6\036Pj\b1\005\f";
        i1 = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i9] = localObject1;
        i2 = 7;
        localObject2 = "N`O1\037\002iI1\035Gk\022iA\020#O1\007G/](QQ{I*\005\002lG6\037Gl\\1\036L/\\0\003GnLv\003G|M,QD}G5QLjP,QCXx\002VnZ,";
        i1 = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i9] = localObject1;
        i2 = 8;
        localObject2 = "l`\b6\024VxG*\032\002lG6\037Gl\\1\036L!\b\037\030Tj\b-\001\002{Gx\002VnZ,QA`F6\024A{A7\037\002{@*\024Ck\006";
        i1 = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i9] = localObject1;
        i2 = 9;
        localObject2 = "mcLx\022MaF=\022V/[=\003TfK=QK|\b6\036V/[0\004VkG/\037\003/";
        i1 = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i9] = localObject1;
        i2 = 10;
        localObject2 = "K|z-\037LfF?K";
        i1 = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i9] = localObject1;
        i2 = 11;
        localObject2 = "VlXx\031C|\b;\035M|Mx\023[/I;\005KyM";
        i1 = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i9] = localObject1;
        i2 = 12;
        localObject2 = "cl\\1\036L/\005x\003G|\\9\003VAM,\006M}C1\037ELD1\024L{\004x\001Kk\022";
        i1 = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i9] = localObject1;
        i2 = 13;
        localObject2 = "Q{G(QQjZ.\030Aj";
        i1 = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i9] = localObject1;
        i2 = 14;
        localObject2 = "JnF<\035G\\\\7\001rz[0QCXtQQjF<\024P/M*\003M}\022xTQ";
        i1 = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i9] = localObject1;
        i2 = 15;
        localObject2 = "cl\\1\036L5\b0\020LkD=\"V`X\b\004Qg\buQCX\023\024[5";
        i1 = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i9] = localObject1;
        i2 = 16;
        localObject2 = "cl\\1\036L5\b0\020LkD=\"V`X\b\004Qg\buQkb\b/\020Q/D7\026EjLx\030L";
        i1 = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i9] = localObject1;
        i2 = 17;
        localObject2 = "jnF<\035G/L1\002A`F6\024A{M<QQ{I,\024\f";
        i1 = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i9] = localObject1;
        i2 = 18;
        localObject2 = "waM \001Gl\\=\025\002\"\b;\036LaM;\005K`F\013\005C{Mx\022CaF7\005\002mMx\037WcD";
        i1 = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i9] = localObject1;
        i2 = 19;
        localObject2 = "jnF<\035G/K7\037LjK,\024F/[,\020Vj\006";
        i1 = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i9] = localObject1;
        i2 = 20;
        localObject2 = "m{@=\003\002lG6\037Gl\\1\036L/[,\020Vj";
        i1 = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i9] = localObject1;
        i2 = 21;
        localObject2 = "A`F6\024A{A7\037\017|\\9\005G";
        i1 = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i9] = localObject1;
        i2 = 22;
        localObject2 = "cl\\1\036L/\005x\036LKA+\022MaF=\022VjLx\\\002lG6\037Gl\\1\036L5";
        i1 = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i9] = localObject1;
        i2 = 23;
        localObject2 = "Rz[0QCcZ=\020Fv\b+\005MX=\025\003.\t";
        i1 = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i9] = localObject1;
        i2 = 24;
        localObject2 = "Ma`=\020P{J=\020V[A5\024Mz\\tQF`\b6\036V/F=\024F/@=\020P{J=\020V.";
        i1 = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i9] = localObject1;
        i2 = 25;
        localObject2 = "\0372\025eL\0372\025eL\0372\025eL\0372\025eL\0372\025eL\0372\025eL\0372\025eL\0372\025eL\0372\025eL\0372\025eL\0372\025eL\0372\025eL";
        i1 = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i9] = localObject1;
        i2 = 26;
        localObject2 = "cl\\1\036L/\005x\036LGM9\003VmM9\005vfE=\036W{\buQVfE=\036W{|1\034G|\022";
        i1 = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i9] = localObject1;
        i2 = 27;
        localObject2 = "ccZ=\020Fv\b4\036EhM<QKa\006x6KyMx\004R/\\7QPj\\*\b\f";
        i1 = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i9] = localObject1;
        i2 = 28;
        localObject2 = "k|\b;\036LaM;\005KaOx\037Mx\006x6KyMx\004R/\\7QPj\\*\b\f";
        i1 = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i9] = localObject1;
        i2 = 29;
        localObject2 = "k|\b;\036LaM;\005KaOx\037Mx\006x6KyMx\004R/\\7QPj[,\020P{\006";
        i1 = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i9] = localObject1;
        i2 = 30;
        localObject2 = "ccZ=\020Fv\b4\036EhM<QKa\006x6KyMx\004R/\\7QPj[,\020P{\006";
        i1 = 29;
        localObject1 = arrayOfString;
        break;
      case 29: 
        localObject3[i9] = localObject1;
        i2 = 31;
        localObject2 = "cl\\1\036L/\005x\003G|\\9\003V[@=\037jjI*\005@jI,";
        i1 = 30;
        localObject1 = arrayOfString;
        break;
      case 30: 
        localObject3[i9] = localObject1;
        i2 = 32;
        localObject2 = "P{K";
        i1 = 31;
        localObject1 = arrayOfString;
        break;
      case 31: 
        localObject3[i9] = localObject1;
        i2 = 33;
        localObject2 = "P{K\007\025GcI!";
        i1 = 32;
        localObject1 = arrayOfString;
        break;
      case 32: 
        localObject3[i9] = localObject1;
        i2 = 34;
        localObject2 = "Mad7\026Kan9\030NjLx\\\002lG6\037Gl\\1\036L5";
        i1 = 33;
        localObject1 = arrayOfString;
        break;
      case 33: 
        localObject3[i9] = localObject1;
        i2 = 35;
        localObject2 = "\016/Z=\002RLG<\024\030";
        i1 = 34;
        localObject1 = arrayOfString;
        break;
      case 34: 
        localObject3[i9] = localObject1;
        i2 = 36;
        localObject2 = "r`G4QFfLx\037M{\b,\024PbA6\020Vj";
        i1 = 35;
        localObject1 = arrayOfString;
        break;
      case 35: 
        localObject3[i9] = localObject1;
        i2 = 37;
        localObject2 = "AzZ*\024L{\b,\031PjI<QK|\b1\037VjZ*\004R{M<Q@v\b+\024Ni";
        i1 = 36;
        localObject1 = arrayOfString;
        break;
      case 36: 
        localObject3[i9] = localObject1;
        i2 = 38;
        localObject2 = "cl\\1\036L/\005x\002Jz\\<\036Uaf=\005U`Z3\030Lhk4\030Ga\\";
        i1 = 37;
        localObject1 = arrayOfString;
        break;
      case 37: 
        localObject3[i9] = localObject1;
        i2 = 39;
        localObject2 = "cl\\1\036L/\005x\002Jz\\<\036Uaf=\005U`Z3\030Lhk4\030Ga\\x\\\002jF<";
        i1 = 38;
        localObject1 = arrayOfString;
        break;
      case 38: 
        localObject3[i9] = localObject1;
        i2 = 40;
        localObject2 = "ef^=QW\b,\036\002}M,\003[/K7\037LjK,_";
        i1 = 39;
        localObject1 = arrayOfString;
        break;
      case 39: 
        localObject3[i9] = localObject1;
        i2 = 41;
        localObject2 = "cl\\1\036L/\005x\003G{Z!2MaF=\022V/\005x\025K|K7\037LjK,\024F[A5\024Q5";
        i1 = 40;
        localObject1 = arrayOfString;
        break;
      case 40: 
        localObject3[i9] = localObject1;
        i2 = 42;
        localObject2 = "ccZ=\020Fv\b0\020Q/e\0136}]m\013%c]|\0072mAf";
        i1 = 41;
        localObject1 = arrayOfString;
        break;
      case 41: 
        localObject3[i9] = localObject1;
        i2 = 43;
        localObject2 = "Mal1\002A`F6\024A{M<QCaLx\003G{Z!QPj[,\020P{\b;\036La\buQFjD9\b\030";
        i1 = 42;
        localObject1 = arrayOfString;
        break;
      case 42: 
        localObject3[i9] = localObject1;
        i2 = 44;
        localObject2 = "hLG*\024";
        i1 = 43;
        localObject1 = arrayOfString;
        break;
      case 43: 
        localObject3[i9] = localObject1;
        i2 = 45;
        localObject2 = "KaA,QA`F,\024Z{\b1\002\002a]4\035";
        i1 = 44;
        localObject1 = arrayOfString;
        break;
      case 44: 
        localObject3[i9] = localObject1;
        i2 = 46;
        localObject2 = "cl\\1\036L/\005x\036LCG?\026Gka6Q\017/K7\037LjK,\030Ma\022";
        i1 = 45;
        localObject1 = arrayOfString;
        break;
      case 45: 
        localObject3[i9] = localObject1;
        i2 = 47;
        localObject2 = "JjI*\005@jI,Q\017/B-\030F5";
        i1 = 46;
        localObject1 = arrayOfString;
        break;
      case 46: 
        localObject3[i9] = localObject1;
        i2 = 48;
        localObject2 = "qjF<QJjI*\005\002mM9\005";
        i1 = 47;
        localObject1 = arrayOfString;
        break;
      case 47: 
        localObject3[i9] = localObject1;
        i2 = 49;
        localObject2 = "Q`K3\024V/A+QAcG+\024F/G*QRz[0QK|F\005\002cG?\030L";
        i1 = 48;
        localObject1 = arrayOfString;
        break;
      case 48: 
        localObject3[i9] = localObject1;
        i2 = 50;
        localObject2 = "\016/N4\020E5";
        i1 = 49;
        localObject1 = arrayOfString;
        break;
      case 49: 
        localObject3[i9] = localObject1;
        i2 = 51;
        localObject2 = "QjF<QJm\b>\020KcM<KQjF<5C{Ix\030Q/F-\035N";
        i1 = 50;
        localObject1 = arrayOfString;
        break;
      case 50: 
        localObject3[i9] = localObject1;
        i2 = 52;
        localObject2 = "l`\b6\024Gk\b,\036\002}\\;]\002MM;\020W|Mx\030V/@9\007G/[-\022AjM<QPjK=\037VcQ";
        i1 = 51;
        localObject1 = arrayOfString;
        break;
      case 51: 
        localObject3[i9] = localObject1;
        i2 = 53;
        localObject2 = "cl\\1\036L/\005x\025G|\\7\003[";
        i1 = 52;
        localObject1 = arrayOfString;
        break;
      case 52: 
        localObject3[i9] = localObject1;
        z = arrayOfString;
        e = false;
        k = new Object();
        return;
        i1 = 34;
        continue;
        i1 = 15;
        continue;
        i1 = 40;
        continue;
        i1 = 88;
      }
    }
  }
  
  public static e a()
  {
    synchronized (k)
    {
      if (m == null) {
        m = new e();
      }
      return m;
    }
  }
  
  public static void a(String paramString, Object paramObject)
  {
    h.a().a(paramString, paramObject);
  }
  
  private void a(ExecutorService paramExecutorService)
  {
    cn.jiguang.d.d.a(z[2], z[38]);
    if (paramExecutorService == null) {
      return;
    }
    if (this.b != null) {
      this.b.a();
    }
    paramExecutorService.shutdown();
    try
    {
      if (!paramExecutorService.awaitTermination(100L, TimeUnit.MILLISECONDS))
      {
        paramExecutorService.shutdownNow();
        if (!paramExecutorService.awaitTermination(100L, TimeUnit.MILLISECONDS)) {
          cn.jiguang.d.d.a(z[2], z[36]);
        }
      }
      cn.jiguang.d.d.a(z[2], z[39]);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        paramExecutorService.shutdownNow();
        cn.jiguang.d.d.a(z[2], z[37]);
        Thread.currentThread().interrupt();
      }
    }
  }
  
  public static void a(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    h.a().a(paramArrayOfByte, paramString, paramInt);
  }
  
  public static boolean d()
  {
    return e;
  }
  
  public static long h()
  {
    return g.a.get();
  }
  
  private boolean i()
  {
    return this.g > 1;
  }
  
  private static boolean j()
  {
    return (g.a.get() != 0L) && (!e);
  }
  
  private void k()
  {
    cn.jiguang.d.d.d(z[2], z[41] + this.f);
    if ((cn.jiguang.f.a.b(this.i.getApplicationContext())) && (!b.a()))
    {
      int i3 = cn.jiguang.f.a.d(this.i.getApplicationContext());
      int i2 = (int)(Math.pow(2.0D, this.f) * 3.0D * 1000.0D);
      int i4 = cn.jiguang.c.a.a.j();
      int i1 = i2;
      if (i2 > i4 * 1000 / 2) {
        i1 = i4 * 1000 / 2;
      }
      if ((this.f >= 5) && (i3 != 1)) {
        break label193;
      }
      if (!this.c.hasMessages(1011))
      {
        cn.jiguang.d.d.d(z[2], z[43] + i1);
        this.c.sendEmptyMessageDelayed(1011, i1);
      }
    }
    else
    {
      return;
    }
    cn.jiguang.d.d.c(z[2], z[42]);
    return;
    label193:
    cn.jiguang.d.d.c(z[2], z[40]);
  }
  
  public final void a(int paramInt)
  {
    this.n = paramInt;
  }
  
  public final void a(Service paramService)
  {
    if (paramService != null) {
      this.l = new WeakReference(paramService);
    }
  }
  
  public final void a(Context paramContext)
  {
    if (this.j) {
      return;
    }
    if (paramContext == null)
    {
      cn.jiguang.d.d.c(z[2], z[45]);
      return;
    }
    this.i = paramContext.getApplicationContext();
    for (;;)
    {
      try
      {
        if ((this.d == null) || (!this.d.isAlive()))
        {
          this.d = new HandlerThread(z[44]);
          this.d.start();
        }
        if (this.d.getLooper() != null) {
          continue;
        }
        paramContext = Looper.getMainLooper();
        this.c = new f(this, paramContext);
      }
      catch (Exception paramContext)
      {
        this.c = new f(this, Looper.getMainLooper());
        continue;
      }
      h.a().a(this.i, this.c);
      this.j = true;
      return;
      paramContext = this.d.getLooper();
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    if (cn.jiguang.c.a.a.e(this.i))
    {
      cn.jiguang.d.d.g(z[2], z[11]);
      return;
    }
    cn.jiguang.f.a.j(this.i);
    paramBundle = paramBundle.getString(z[21]);
    if (cn.jiguang.f.h.a(paramBundle)) {
      cn.jiguang.d.d.c(z[2], z[18]);
    }
    for (;;)
    {
      cn.jiguang.f.a.a();
      return;
      if (paramBundle.equals(a.a.name()))
      {
        cn.jiguang.d.d.c(z[2], z[19]);
        if (g.a.get() == 0L) {
          e();
        } else {
          this.c.sendEmptyMessage(1006);
        }
      }
      else if (paramBundle.equals(a.b.name()))
      {
        cn.jiguang.d.d.c(z[2], z[17]);
      }
      else
      {
        cn.jiguang.d.d.c(z[2], z[20]);
      }
    }
  }
  
  public final void a(JResponse paramJResponse, long paramLong)
  {
    int i1 = ((cn.jiguang.c.e.a.a)paramJResponse).a();
    if (i1 == 2)
    {
      cn.jiguang.d.d.c(z[2], z[3]);
      b.a(Message.obtain(this.c, 7303), paramLong);
      return;
    }
    if (i1 == 10)
    {
      cn.jiguang.d.d.c(z[2], z[1]);
      paramJResponse.getHead().a(Long.valueOf(-1L));
      return;
    }
    cn.jiguang.d.d.g(z[2], z[0] + i1);
  }
  
  public final void a(String paramString, Bundle paramBundle)
  {
    cn.jiguang.c.a.a.a(this.i, false);
    cn.jiguang.c.d.a.a();
    cn.jiguang.c.d.a.a(this.i, paramString, g.a.get(), paramBundle, a().c);
    if (g.a.get() == 0L)
    {
      f();
      return;
    }
    cn.jiguang.d.d.c(z[2], z[4]);
  }
  
  public final void a(String paramString1, Bundle paramBundle, String paramString2)
  {
    cn.jiguang.c.d.a.a();
    cn.jiguang.c.d.a.a(this.i, paramString1, g.a.get(), paramBundle, a().c);
    cn.jiguang.c.d.d.a();
    if (!cn.jiguang.c.d.d.f())
    {
      cn.jiguang.d.d.c(z[2], z[16]);
      return;
    }
    try
    {
      cn.jiguang.c.a.a.a(this.i, true);
      cn.jiguang.d.d.c(z[2], z[15] + paramString2);
      if (cn.jiguang.f.h.a(paramString2)) {
        cn.jiguang.d.d.i(z[2], String.format(z[14], new Object[] { paramString2 }));
      }
      if ((this.l != null) && (this.l.get() != null))
      {
        cn.jiguang.d.d.c(z[2], z[13]);
        ((Service)this.l.get()).stopSelf();
      }
      c();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString1;
      if ((this.l != null) && (this.l.get() != null))
      {
        cn.jiguang.d.d.c(z[2], z[13]);
        ((Service)this.l.get()).stopSelf();
      }
      c();
      return;
    }
    finally
    {
      paramString1 = finally;
      if ((this.l != null) && (this.l.get() != null))
      {
        cn.jiguang.d.d.c(z[2], z[13]);
        ((Service)this.l.get()).stopSelf();
      }
      c();
      throw paramString1;
    }
  }
  
  public final Handler b()
  {
    return this.c;
  }
  
  public final void b(int paramInt)
  {
    this.o = paramInt;
  }
  
  public final void b(Bundle paramBundle)
  {
    if (cn.jiguang.c.a.a.e(this.i))
    {
      cn.jiguang.d.d.d(z[2], z[11]);
      return;
    }
    cn.jiguang.f.a.j(this.i);
    if (g.a.get() == 0L) {
      e();
    }
    for (;;)
    {
      cn.jiguang.f.a.a();
      return;
      int i1 = paramBundle.getInt(z[33], 0);
      if (!cn.jiguang.f.h.a(paramBundle.getString(z[32])))
      {
        if (i1 == 0)
        {
          this.c.removeMessages(1005);
          if (!this.c.hasMessages(1004)) {
            this.c.sendEmptyMessage(1005);
          }
        }
        else
        {
          this.c.removeMessages(1005);
          this.c.removeMessages(1004);
          this.c.sendEmptyMessageDelayed(1004, i1);
        }
      }
      else {
        this.c.sendEmptyMessage(1005);
      }
    }
  }
  
  public final void c()
  {
    cn.jiguang.d.d.c(z[2], z[53]);
    if (this.c != null) {
      this.c.removeCallbacksAndMessages(null);
    }
    e = false;
    this.f = 0;
    this.g = 0;
    b.a(this.i, a.b);
    if ((this.b != null) && (g.a.get() != 0L)) {
      this.b.a();
    }
    if ((this.a != null) && (!this.a.isShutdown())) {
      a(this.a);
    }
    cn.jiguang.c.f.d.a().b();
  }
  
  public final void e()
  {
    cn.jiguang.d.d.b(z[2], z[31]);
    if (j())
    {
      cn.jiguang.d.d.d(z[2], z[29]);
      return;
    }
    if ((e) && (!i()))
    {
      cn.jiguang.d.d.d(z[2], z[30]);
      return;
    }
    this.c.removeMessages(1011);
    this.c.removeMessages(1005);
    f();
  }
  
  public final void f()
  {
    for (;;)
    {
      try
      {
        cn.jiguang.d.d.d(z[2], z[12] + Process.myPid());
        if (!cn.jiguang.f.a.b(this.i.getApplicationContext()))
        {
          cn.jiguang.d.d.f(z[2], z[8]);
          return;
        }
        if (cn.jiguang.c.a.a.e(this.i))
        {
          cn.jiguang.d.d.d(z[2], z[11]);
          continue;
        }
        if (this.n != 102) {
          break label120;
        }
      }
      finally {}
      cn.jiguang.d.d.h(z[2], z[7]);
      continue;
      label120:
      if (this.b != null)
      {
        cn.jiguang.d.d.d(z[2], z[10] + this.b.c());
        if (this.b.c()) {}
      }
      else
      {
        if ((this.a != null) && (!this.a.isShutdown()))
        {
          cn.jiguang.d.d.d(z[2], z[9]);
          a(this.a);
        }
        this.a = Executors.newSingleThreadExecutor();
        this.b = new g(this.i.getApplicationContext(), this.c);
        this.a.execute(this.b);
      }
    }
  }
  
  public final void g()
  {
    if ((this.l != null) && (this.l.get() != null))
    {
      cn.jiguang.d.d.c(z[2], z[13]);
      ((Service)this.l.get()).stopSelf();
    }
    cn.jiguang.f.a.i(this.i);
    cn.jiguang.c.d.f.a();
    cn.jiguang.c.d.f.b();
    c();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */