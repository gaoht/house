package cn.jiguang.c.e.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.c.e.a.a.c;
import java.nio.ByteBuffer;

public final class a
  extends JResponse
{
  private static final String[] z;
  int a;
  int b;
  int c;
  long d;
  
  static
  {
    String[] arrayOfString = new String[6];
    int j = 0;
    Object localObject2 = "\031\007&M5=7\035\002\t+!";
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
        i = 103;
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
        localObject2 = "td\036\031\002(~";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "xiM";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "td\036\031\0165!W";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "td\036\031\006,1\036W";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\003\005\016\006)76\000\f\013\005d@M\025=5\030\b\024,\007\002\000\n9*\tW";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 88;
        continue;
        i = 68;
        continue;
        i = 109;
        continue;
        i = 109;
      }
    }
  }
  
  public a(c paramc, ByteBuffer paramByteBuffer)
  {
    super(paramc, paramByteBuffer);
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final String getName()
  {
    return z[0];
  }
  
  protected final boolean isNeedParseeErrorMsg()
  {
    return false;
  }
  
  public final void parseBody()
  {
    super.parseBody();
    ByteBuffer localByteBuffer = this.body;
    this.a = ByteBufferUtils.get(localByteBuffer, this).byteValue();
    this.b = ByteBufferUtils.get(localByteBuffer, this).byteValue();
    this.c = ByteBufferUtils.get(localByteBuffer, this).byteValue();
    this.d = ByteBufferUtils.getLong(localByteBuffer, this);
  }
  
  public final String toString()
  {
    return z[5] + this.a + z[1] + this.b + z[4] + this.c + z[3] + this.d + z[2] + super.toString();
  }
  
  public final void writeBody()
  {
    super.writeBody();
    writeInt1(this.a);
    writeInt1(this.b);
    writeInt1(this.c);
    writeLong8(this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/e/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */