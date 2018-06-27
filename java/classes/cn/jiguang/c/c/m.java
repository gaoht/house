package cn.jiguang.c.c;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class m
  implements Serializable, Cloneable, Comparable
{
  private static final DecimalFormat e;
  private static final String[] z;
  protected j a;
  protected int b;
  protected int c;
  protected long d;
  
  static
  {
    String[] arrayOfString = new String[2];
    Object localObject2 = "cDI\000RvBY\n\021eS_\001Cs";
    int k = -1;
    int m = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int j = localObject2.length;
    int i;
    Object localObject3;
    int n;
    int i1;
    label50:
    int i2;
    label99:
    label121:
    Object localObject4;
    int i3;
    if (j <= 1)
    {
      i = 0;
      localObject3 = localObject1;
      n = m;
      localObject1 = localObject2;
      i1 = k;
      m = i;
      for (k = i;; k = j)
      {
        localObject2 = localObject1;
        i2 = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 49;
          localObject2[k] = ((char)(i ^ i2));
          m += 1;
          if (j != 0) {
            break label121;
          }
        }
      }
      k = j;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      j = k;
      i = m;
      if (k > m) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject2 = "~XJ\017]~R\034\034TtYN\n\021{SR\tE";
        m = 1;
        k = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        localObject1 = new DecimalFormat();
        e = (DecimalFormat)localObject1;
        ((DecimalFormat)localObject1).setMinimumIntegerDigits(3);
        return;
        i = 23;
        break label99;
        i = 54;
        break label99;
        i = 60;
        break label99;
        i = 110;
        break label99;
        i = 0;
        i2 = k;
        i3 = m;
        localObject4 = localObject1;
        k = j;
        m = i;
      }
    }
  }
  
  static m a(d paramd, int paramInt)
  {
    Object localObject = new j(paramd);
    int i = paramd.g();
    int j = paramd.g();
    if (paramInt == 0) {
      localObject = a((j)localObject, i, j);
    }
    m localm;
    do
    {
      return (m)localObject;
      long l = paramd.h();
      paramInt = paramd.g();
      localm = a((j)localObject, i, j, l);
      localObject = localm;
    } while (paramd == null);
    if (paramd.b() < paramInt) {
      throw new t(z[0]);
    }
    paramd.a(paramInt);
    localm.a(paramd);
    if (paramd.b() > 0) {
      throw new t(z[1]);
    }
    paramd.c();
    return localm;
  }
  
  public static m a(j paramj, int paramInt1, int paramInt2)
  {
    if (!paramj.a()) {
      throw new n(paramj);
    }
    return a(paramj, paramInt1, paramInt2, 0L);
  }
  
  private static final m a(j paramj, int paramInt1, int paramInt2, long paramLong)
  {
    p localp = new p();
    localp.a = paramj;
    localp.b = paramInt1;
    localp.c = paramInt2;
    localp.d = paramLong;
    return localp;
  }
  
  private byte[] h()
  {
    e locale = new e();
    a(locale, true);
    return locale.b();
  }
  
  abstract String a();
  
  final void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  abstract void a(d paramd);
  
  final void a(e parame, b paramb)
  {
    this.a.a(parame, paramb);
    parame.c(this.b);
    parame.c(this.c);
  }
  
  abstract void a(e parame, boolean paramBoolean);
  
  public final boolean a(m paramm)
  {
    return (this.b == paramm.b) && (this.c == paramm.c) && (this.a.equals(paramm.a));
  }
  
  public final j b()
  {
    return this.a;
  }
  
  public final int c()
  {
    return this.b;
  }
  
  public int compareTo(Object paramObject)
  {
    int i = 0;
    Object localObject = (m)paramObject;
    if (this == localObject) {
      return 0;
    }
    int j = this.a.compareTo(((m)localObject).a);
    if (j != 0) {
      return j;
    }
    j = this.c - ((m)localObject).c;
    if (j != 0) {
      return j;
    }
    j = this.b - ((m)localObject).b;
    if (j != 0) {
      return j;
    }
    paramObject = h();
    localObject = ((m)localObject).h();
    while ((i < paramObject.length) && (i < localObject.length))
    {
      j = (paramObject[i] & 0xFF) - (localObject[i] & 0xFF);
      if (j != 0) {
        return j;
      }
      i += 1;
    }
    return paramObject.length - localObject.length;
  }
  
  public final int d()
  {
    return this.b;
  }
  
  public final int e()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof m))) {}
    do
    {
      return false;
      paramObject = (m)paramObject;
    } while ((this.b != ((m)paramObject).b) || (this.c != ((m)paramObject).c) || (!this.a.equals(((m)paramObject).a)));
    return Arrays.equals(h(), ((m)paramObject).h());
  }
  
  public final long f()
  {
    return this.d;
  }
  
  final m g()
  {
    try
    {
      m localm = (m)clone();
      return localm;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new IllegalStateException();
    }
  }
  
  public int hashCode()
  {
    int i = 0;
    Object localObject = new e();
    this.a.a((e)localObject);
    ((e)localObject).c(this.b);
    ((e)localObject).c(this.c);
    ((e)localObject).a(0L);
    int j = ((e)localObject).a();
    ((e)localObject).c(0);
    a((e)localObject, true);
    ((e)localObject).a(((e)localObject).a() - j - 2, j);
    localObject = ((e)localObject).b();
    j = 0;
    while (i < localObject.length)
    {
      j += (j << 3) + (localObject[i] & 0xFF);
      i += 1;
    }
    return j;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    if (localStringBuffer.length() < 8) {
      localStringBuffer.append("\t");
    }
    if (localStringBuffer.length() < 16) {
      localStringBuffer.append("\t");
    }
    localStringBuffer.append("\t");
    String str = a();
    if (!str.equals(""))
    {
      localStringBuffer.append("\t");
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */