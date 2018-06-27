package cn.jiguang.c.e.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.c.e.a.a.c;
import java.nio.ByteBuffer;

public final class b
  extends JResponse
{
  private static final String[] z;
  long a;
  String b;
  
  static
  {
    String[] arrayOfString = new String[4];
    Object localObject1 = "#H\005!2\005O\007\"\016\023Y";
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
          i = 96;
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
        localObject1 = "@\021W";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = ";\003?\f2Y\004=\017\016O\022\020@M\034\004(\016\004Y\005\004\004Z";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        j = 3;
        localObject1 = "L\034\032>\007#S\0319\005\016HM";
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 96;
        break label91;
        i = 60;
        break label91;
        i = 119;
        break label91;
        i = 77;
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
  
  public b(c paramc, ByteBuffer paramByteBuffer)
  {
    super(paramc, paramByteBuffer);
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.b;
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
    this.a = ByteBufferUtils.getLong(localByteBuffer, this);
    this.b = ProtocolUtil.getTlv2(localByteBuffer, this);
  }
  
  public final String toString()
  {
    return z[2] + this.a + z[3] + this.b + z[1] + super.toString();
  }
  
  public final void writeBody()
  {
    super.writeBody();
    writeLong8(this.a);
    writeTlv2(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/e/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */