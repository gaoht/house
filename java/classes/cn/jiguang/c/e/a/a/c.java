package cn.jiguang.c.e.a.a;

import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

public final class c
{
  private static final String[] z;
  int a;
  int b;
  int c;
  Long d;
  int e;
  long f;
  private boolean g = false;
  
  static
  {
    String[] arrayOfString = new String[7];
    int j = 0;
    Object localObject2 = "\034f4I[T|";
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
        i = 50;
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
        localObject2 = "\034f-UV\n";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\034f,UV\n";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "\034f(Y@C/1R\b";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "k\f\026YST\033~\021\022\\#0\006";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\034f=S_]'0X\b";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "d.;\034ZU':\034[Cf0SF\020/0UFY'2UHU\"~EWDh";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 48;
        continue;
        i = 70;
        continue;
        i = 94;
        continue;
        i = 60;
      }
    }
  }
  
  public c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2)
  {
    this.g = paramBoolean;
    this.a = 0;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = Long.valueOf(paramLong1);
    this.e = paramInt4;
    this.f = paramLong2;
  }
  
  public c(boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    this(paramBoolean, 0, paramInt1, paramInt2, paramLong, 0, 0L);
  }
  
  public c(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this.g = paramBoolean;
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    this.a = paramArrayOfByte.getShort();
    this.a &= 0x7FFF;
    this.b = paramArrayOfByte.get();
    this.c = paramArrayOfByte.get();
    this.d = Long.valueOf(paramArrayOfByte.getLong());
    if (paramBoolean) {
      this.e = paramArrayOfByte.getInt();
    }
    this.f = paramArrayOfByte.getLong();
  }
  
  public final int a()
  {
    return this.c;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public final void a(Long paramLong)
  {
    this.d = paramLong;
  }
  
  public final Long b()
  {
    return this.d;
  }
  
  public final void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final long c()
  {
    return this.f;
  }
  
  public final int d()
  {
    return this.e;
  }
  
  public final int e()
  {
    return this.b;
  }
  
  public final byte[] f()
  {
    if (this.a == 0) {
      throw new IllegalStateException(z[6]);
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(24);
    localByteBuffer.putShort((short)this.a);
    localByteBuffer.put((byte)this.b);
    localByteBuffer.put((byte)this.c);
    localByteBuffer.putLong(this.d.longValue());
    if (this.g) {
      localByteBuffer.putInt(this.e);
    }
    localByteBuffer.putLong(this.f);
    localByteBuffer.flip();
    return ProtocolUtil.getBytesConsumed(localByteBuffer);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(z[4]).append(this.a).append(z[3]).append(this.b).append(z[5]).append(this.c).append(z[2]).append(this.d);
    if (this.g) {}
    for (String str = z[1] + this.e;; str = "") {
      return str + z[0] + this.f;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/e/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */