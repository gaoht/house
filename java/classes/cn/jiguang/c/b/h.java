package cn.jiguang.c.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jiguang.c.e.a.a.b;
import cn.jiguang.c.e.a.a.c;
import cn.jiguang.d.d;
import cn.jiguang.service.Protocol;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicLong;

public final class h
{
  private static h f;
  private static final String[] z;
  private Map<String, i> a = new ConcurrentHashMap();
  private Deque<i> b = new LinkedBlockingDeque();
  private Deque<i> c = new LinkedBlockingDeque();
  private Handler d;
  private Context e;
  
  static
  {
    String[] arrayOfString = new String[46];
    int j = 0;
    Object localObject2 = "X8\nh\034Y)$y\030^<";
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
        i = 121;
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
        localObject2 = "x8\nh\034Y)8|\032B86|\027K:\036o";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "X8\nh\034Y)$i\020G8\024h\r";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "Y8\025y+O,\016x\n^}\035|\020F8\0371\013O,\016x\n^}\037|\rK}\022nYD(\027q";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "X8\nh\034Y)$n\035A)\002m\034";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "k>\017t\026D}V=\035O,\016x*O3\017L\fO(\036";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\006}\017t\024O2\016iC";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "d2\017=\025E:\034x\035\n4\025=\032_/\tx\027^1\0023Ym4\rxY_-[i\026\n.\036s\035\n3\024jW";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "k>\017t\026D}V=\nO3\037O\034[(\036n\rc3\017x\013D<\027=T\n>\024s\027O>\017t\026Dg";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "Y8\025y+O,\016x\n^\024\025i\034X3\032qYL<\022q\034Nq\030|\032B8[t\n\n;\016q\025";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "\006}\017u\013O<\037T\035\020";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "k>\017t\026D}V=\n^<\ti+O,\016x\n^\t\022p\034E(\017";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "\006.\037v-S-\036'";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "Y8\025y+O,\016x\n^\024\025i\034X3\032qYL<\022q\034Nq\tx\b_8\biYN<\017|YC.[s\fF1";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "d2\017=\037E(\025yYX8\nh\034Y)\022s\036\n4\025=+O,\016x\n^4\025z:K>\023xY]5\036sYX8\bm\026D.\0363";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "O3\037N\034D)/t\024O2\016iYL<\022q\034Nq\tx\b_8\bi\020D:[t\n\n3\016q\025";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "\006}\tx\nZ2\025n\034\020";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "B<\025y\025O\017\036n\tE3\bx0D)\036o\027K1[r\033@}[t\n\n3\016q\025";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "k>\017t\026D}V=\021K3\037q\034x8\bm\026D.\036T\027^8\ts\030F}V=\032E3\025x\032^4\024sC";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "x8\bm\026D.\036=\032E3\025x\032^4\024sYC.[r\f^p\037|\rO9U=";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "B<\025y\025O\017\036n\tE3\bx0D)\036o\027K1[r\033@}[t\n\n3\024iY`\025\036|\035";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "k>\017t\026D}V=\034D9(x\027^\t\022p\034E(\017=T\n/\036l\fO.\017V\034Sg";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "\006.\037v\rS-\036'";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "d2\017=\037E(\025yY^5\036=\013O,\016x\n^}\022sYy8\025i(_8\016xY]5\036sYX8\bm\026D.\0363";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "I2\025s\034I)\022r\027";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "k>\017t\026D}V=\013O.\017r\013O\016\036s\r{(\036h\034\np[n\034D)*h\034_8(t\003Og";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "Y8\025y:E0\026|\027N\n\022i\021f2\034z\034N\024\025=\037K4\027x\035\006/\036l\fO.\017t\027M}\022nYD(\027q";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "k>\017t\026D}V=\n^<\ti*O3\017I\020G8\024h\r\ng";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "Y8\025y:E0\026|\027N\n\022i\021f2\034z\034N\024\025=\037K4\027x\035\020.\036s\035n<\017|YC.[s\fF1";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        j = 29;
        localObject2 = "Y)\032o\ry8\025i-C0\036r\f^}\035|\020F8\0371\013O,\016x\n^4\025zYC.[s\fF1";
        i = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i4] = localObject1;
        j = 30;
        localObject2 = "k>\017t\026D}V=\013O.\036s\035x8\nh\034Y)\022s\036{(\036h\034\np[n\020P8A";
        i = 29;
        localObject1 = arrayOfString;
        break;
      case 29: 
        localObject3[i4] = localObject1;
        j = 31;
        localObject2 = "E3(x\027^\t\022p\034E(\017=\013O,\016x\n^4\025zYC.[s\fF1";
        i = 30;
        localObject1 = arrayOfString;
        break;
      case 30: 
        localObject3[i4] = localObject1;
        j = 32;
        localObject2 = "k>\017t\026D}V=\026D\016\036s\r~4\026x\026_)[0Y";
        i = 31;
        localObject1 = arrayOfString;
        break;
      case 31: 
        localObject3[i4] = localObject1;
        j = 33;
        localObject2 = "}<\025iYX8\017o\000\n)\024=\nO3\037=\033_)[s\026^}\027r\036M8\037=\020Ds[N\034D)[p\026\\8[i\026\n\017\036l\fO.\017t\027M\f\016x\fO";
        i = 32;
        localObject1 = arrayOfString;
        break;
      case 32: 
        localObject3[i4] = localObject1;
        j = 34;
        localObject2 = "x8\017o\000\n)\024=\nO3\037=\013O,\016x\n^}V=";
        i = 33;
        localObject1 = arrayOfString;
        break;
      case 33: 
        localObject3[i4] = localObject1;
        j = 35;
        localObject2 = "k>\017t\026D}V=\034D9)x\b_8\bi-C0\036r\f^g";
        i = 34;
        localObject1 = arrayOfString;
        break;
      case 34: 
        localObject3[i4] = localObject1;
        j = 36;
        localObject2 = "O3\037O\034[(\036n\r~4\026x\026_)[o\034[(\036n\rC3\034=\020Y}\025h\025F";
        i = 35;
        localObject1 = arrayOfString;
        break;
      case 35: 
        localObject3[i4] = localObject1;
        j = 37;
        localObject2 = "3\036e\tO>\017x\035\np[{\030C1\036yY^2[o\034G2\rxYX8\nh\034Y)\022s\036\n;\tr\024\n>\032~\021Os";
        i = 36;
        localObject1 = arrayOfString;
        break;
      case 36: 
        localObject3[i4] = localObject1;
        j = 38;
        localObject2 = "O3\nh\034y8\025i(_8\016xYX8\nh\034Y)\022s\036\n4\b=\027_1\027";
        i = 37;
        localObject1 = arrayOfString;
        break;
      case 37: 
        localObject3[i4] = localObject1;
        j = 39;
        localObject2 = "k>\017t\026D}V=\034D,\016x*O3\017L\fO(\036";
        i = 38;
        localObject1 = arrayOfString;
        break;
      case 38: 
        localObject3[i4] = localObject1;
        j = 40;
        localObject2 = "k>\017t\026D}V=\026D\017\036l\fO.\017I\020G8\024h\r\np[";
        i = 39;
        localObject1 = arrayOfString;
        break;
      case 39: 
        localObject3[i4] = localObject1;
        j = 41;
        localObject2 = "Y9\020i\000Z8[t\n\n3\016q\025\006*\022q\025\n9\022n\tK)\030u-C0\036r\f^\017\036l\fO.\017=\rE}\024i\021O/\b";
        i = 40;
        localObject1 = arrayOfString;
        break;
      case 40: 
        localObject3[i4] = localObject1;
        j = 42;
        localObject2 = "\006*\022q\025\n9\022n\tK)\030u-C0\036r\f^\017\036l\fO.\017=\rE}\024i\021O/\b";
        i = 41;
        localObject1 = arrayOfString;
        break;
      case 41: 
        localObject3[i4] = localObject1;
        j = 43;
        localObject2 = "I<\025=\027E)[{\026_3\037=\030I)\022r\027\n*\022i\021";
        i = 42;
        localObject1 = arrayOfString;
        break;
      case 42: 
        localObject3[i4] = localObject1;
        j = 44;
        localObject2 = "k>\017t\026D\020\032s\030M8\t";
        i = 43;
        localObject1 = arrayOfString;
        break;
      case 43: 
        localObject3[i4] = localObject1;
        j = 45;
        localObject2 = "E3)x\b_8\bi-C0\036r\f^}\tx\b_8\bi\020D:[t\n\n3\016q\025";
        i = 44;
        localObject1 = arrayOfString;
        break;
      case 44: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 42;
        continue;
        i = 93;
        continue;
        i = 123;
        continue;
        i = 29;
      }
    }
  }
  
  public static h a()
  {
    if (f == null) {
      f = new h();
    }
    return f;
  }
  
  private i a(String paramString)
  {
    for (;;)
    {
      try
      {
        d.a(z[1], z[5]);
        Object localObject = null;
        Iterator localIterator = this.c.iterator();
        if (localIterator.hasNext())
        {
          i locali = (i)localIterator.next();
          if (paramString.equals(locali.a()))
          {
            this.c.remove(locali);
            localObject = locali;
          }
        }
        else
        {
          return (i)localObject;
        }
      }
      finally {}
    }
  }
  
  private static String b(long paramLong, String paramString)
  {
    return paramLong + "|" + paramString;
  }
  
  private void c(i parami)
  {
    for (;;)
    {
      try
      {
        d.a(z[1], z[39]);
        if (parami == null)
        {
          d.g(z[1], z[38]);
          return;
        }
        Iterator localIterator = this.c.iterator();
        int i;
        if (localIterator.hasNext())
        {
          if (((i)localIterator.next()).a().equals(parami.a()))
          {
            i = 1;
            if (i == 0) {
              this.c.offerLast(parami);
            }
          }
        }
        else {
          i = 0;
        }
      }
      finally {}
    }
  }
  
  private void d(i parami)
  {
    if (parami == null)
    {
      d.g(z[1], z[36]);
      return;
    }
    d.a(z[1], z[35] + parami.a());
    String str = parami.a();
    if ((i)this.a.remove(str) == null) {
      d.g(z[1], z[37]);
    }
    this.b.remove(parami);
    this.d.removeMessages(7403, str);
  }
  
  private void e(i parami)
  {
    if (parami == null)
    {
      d.c(z[1], z[26]);
      return;
    }
    int i = cn.jiguang.c.a.a.D();
    byte[] arrayOfByte = parami.d;
    OutputDataUtil localOutputDataUtil = new OutputDataUtil(20480);
    localOutputDataUtil.writeByteArray(arrayOfByte);
    localOutputDataUtil.writeU32At(i, 12);
    arrayOfByte = b.a(localOutputDataUtil.toByteArray(), 1);
    if (arrayOfByte != null) {
      Protocol.SendData(g.a.get(), arrayOfByte, parami.e);
    }
    for (;;)
    {
      c(parami);
      if (parami != null) {
        break;
      }
      d.g(z[1], z[29]);
      return;
      d.h(z[1], z[28]);
    }
    d.a(z[1], z[27] + parami.a());
    parami = Message.obtain(this.d, 7404, parami);
    this.d.sendMessageDelayed(parami, 9800L);
  }
  
  public final void a(long paramLong, String paramString, Object paramObject)
  {
    if (paramObject == null)
    {
      d.g(z[1], z[17]);
      return;
    }
    if (!(paramObject instanceof c))
    {
      d.g(z[1], z[20]);
      return;
    }
    paramObject = (c)paramObject;
    d.c(z[1], z[18] + paramLong + z[16] + ((c)paramObject).toString() + z[22] + paramString);
    if (paramLong != g.a.get()) {
      d.g(z[1], z[19]);
    }
    paramString = a(b(((c)paramObject).b().longValue(), paramString));
    if (paramString == null)
    {
      d.g(z[1], z[23]);
      return;
    }
    if (paramString == null) {
      d.g(z[1], z[15]);
    }
    for (;;)
    {
      paramString = (i)this.a.get(paramString.a());
      if (paramString == null) {
        break;
      }
      d(paramString);
      return;
      d.a(z[1], z[21] + paramString.a());
      this.d.removeMessages(7404, paramString);
    }
    d.g(z[1], z[14]);
  }
  
  public final void a(Context paramContext, Handler paramHandler)
  {
    this.e = paramContext;
    this.d = paramHandler;
  }
  
  public final void a(i parami)
  {
    if (parami == null) {
      d.g(z[1], z[31]);
    }
    for (;;)
    {
      return;
      d.a(z[1], z[32] + parami.toString());
      a(parami.a());
      if (parami.a <= 0) {
        break;
      }
      e.a();
      if (e.d())
      {
        d.a(z[1], z[34] + parami.toString());
        parami.a -= 10000;
        parami.b += 1;
        e(parami);
      }
      while (parami.b >= 2)
      {
        this.d.sendEmptyMessageDelayed(1005, 2000L);
        return;
        d.a(z[1], z[33]);
        this.b.offerFirst(parami);
      }
    }
    b(parami);
  }
  
  public final void a(String paramString, Object paramObject)
  {
    paramObject = Message.obtain(this.d, 7402, paramObject);
    Bundle localBundle = new Bundle();
    localBundle.putLong(z[24], g.a.get());
    localBundle.putString(z[4], paramString);
    ((Message)paramObject).setData(localBundle);
    ((Message)paramObject).sendToTarget();
  }
  
  public final void a(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    if (paramArrayOfByte == null)
    {
      d.g(z[1], z[3]);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(z[2], paramInt);
    localBundle.putByteArray(z[0], paramArrayOfByte);
    localBundle.putString(z[4], paramString);
    paramArrayOfByte = Message.obtain(this.d, 7401);
    paramArrayOfByte.setData(localBundle);
    paramArrayOfByte.sendToTarget();
  }
  
  public final void b()
  {
    d.c(z[1], z[25] + this.c.size());
    this.d.removeMessages(7404);
    for (;;)
    {
      i locali = (i)this.c.pollLast();
      if (locali == null) {
        break;
      }
      this.b.offerFirst(locali);
    }
  }
  
  public final void b(i parami)
  {
    if (parami == null)
    {
      d.g(z[1], z[45]);
      return;
    }
    d.a(z[1], z[40] + parami.toString());
    d(parami);
    cn.jiguang.c.d.a.a();
    Context localContext = this.e;
    String str = parami.f;
    long l = parami.c;
    int i = parami.e;
    if (TextUtils.isEmpty(str))
    {
      d.c(z[44], z[41]);
      cn.jiguang.c.d.a.b(localContext, l, i);
      return;
    }
    parami = (JAction)cn.jiguang.c.d.a.a.get(str);
    if (parami == null)
    {
      d.c(z[44], z[43] + str + z[42]);
      cn.jiguang.c.d.a.b(localContext, l, i);
      return;
    }
    parami.dispatchTimeOutMessage(localContext, g.a.get(), l, i);
  }
  
  public final void b(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    d.d(z[1], z[8] + g.a.get() + z[6] + paramInt + z[12] + paramString + z[10] + Thread.currentThread().getId());
    if (paramArrayOfByte == null)
    {
      d.g(z[1], z[13]);
      return;
    }
    if (this.a.size() > 200)
    {
      d.h(z[1], z[9]);
      return;
    }
    paramArrayOfByte = new i(paramArrayOfByte, paramString, paramInt);
    this.a.put(paramArrayOfByte.a(), paramArrayOfByte);
    e.a();
    if ((e.d()) && (cn.jiguang.f.a.b(this.e.getApplicationContext())))
    {
      if (paramInt > 10000)
      {
        d.a(z[1], z[11]);
        paramString = Message.obtain(this.d, 7403, paramArrayOfByte);
        this.d.sendMessageDelayed(paramString, paramArrayOfByte.a);
      }
      e(paramArrayOfByte);
      return;
    }
    d.e(z[1], z[7]);
    this.b.offerLast(paramArrayOfByte);
  }
  
  public final void c()
  {
    d.a(z[1], z[30] + this.b.size());
    for (;;)
    {
      i locali = (i)this.b.pollFirst();
      if (locali == null) {
        break;
      }
      if (locali.e == 2)
      {
        this.b.remove(locali);
        this.a.remove(locali.a());
      }
      else
      {
        e(locali);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */