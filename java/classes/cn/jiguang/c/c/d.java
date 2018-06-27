package cn.jiguang.c.c;

import java.nio.ByteBuffer;

public final class d
{
  private static final String[] z;
  private ByteBuffer a;
  private int b;
  private int c;
  
  static
  {
    String[] arrayOfString = new String[4];
    Object localObject1 = "0'\f+\t'f\b0\013#f\022$\025'f\007+\002s)\004e\017=6\0271";
    int i = -1;
    int j = 0;
    Object localObject3 = arrayOfString;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int m;
    int n;
    int i1;
    label42:
    Object localObject2;
    int i2;
    label91:
    label113:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      n = j;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 102;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label113;
          }
          m = k;
        }
      }
      i = k;
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
      k = i;
      m = j;
      if (i > j) {
        break label42;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject1 = "0'\f+\t'f\021 \022s'\0011\017%#B7\0034/\r+F#'\0211F6(\006e\t5f\013+\026&2";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "6(\006e\t5f\013+\026&2";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        j = 3;
        localObject1 = "=)B5\02460\013*\023 f\0211\007'#";
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 83;
        break label91;
        i = 70;
        break label91;
        i = 98;
        break label91;
        i = 69;
        break label91;
        m = 0;
        i2 = i;
        localObject2 = localObject1;
        i3 = j;
        localObject4 = localObject3;
        i = k;
        j = m;
      }
    }
  }
  
  public d(byte[] paramArrayOfByte)
  {
    this.a = ByteBuffer.wrap(paramArrayOfByte);
    this.b = -1;
    this.c = -1;
  }
  
  private void c(int paramInt)
  {
    if (paramInt > this.a.remaining()) {
      throw new t(z[2]);
    }
  }
  
  public final int a()
  {
    return this.a.position();
  }
  
  public final void a(int paramInt)
  {
    if (paramInt > this.a.capacity() - this.a.position()) {
      throw new IllegalArgumentException(z[1]);
    }
    this.a.limit(this.a.position() + paramInt);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    c(paramInt2);
    this.a.get(paramArrayOfByte, 1, paramInt2);
  }
  
  public final int b()
  {
    return this.a.remaining();
  }
  
  public final void b(int paramInt)
  {
    if (paramInt >= this.a.capacity()) {
      throw new IllegalArgumentException(z[0]);
    }
    this.a.position(paramInt);
    this.a.limit(this.a.capacity());
  }
  
  public final void c()
  {
    this.a.limit(this.a.capacity());
  }
  
  public final void d()
  {
    this.b = this.a.position();
    this.c = this.a.limit();
  }
  
  public final void e()
  {
    if (this.b < 0) {
      throw new IllegalStateException(z[3]);
    }
    this.a.position(this.b);
    this.a.limit(this.c);
    this.b = -1;
    this.c = -1;
  }
  
  public final int f()
  {
    c(1);
    return this.a.get() & 0xFF;
  }
  
  public final int g()
  {
    c(2);
    return this.a.getShort() & 0xFFFF;
  }
  
  public final long h()
  {
    c(4);
    return this.a.getInt() & 0xFFFFFFFF;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */