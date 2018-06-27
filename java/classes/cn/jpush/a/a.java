package cn.jpush.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

public final class a
  extends JResponse
{
  private static final String[] d;
  int a;
  long b;
  String c;
  
  static
  {
    String[] arrayOfString = new String[5];
    Object localObject1 = "]|V`!w|uf3x";
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
          i = 64;
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
        localObject1 = "KT@`3q~@C5cqx3m0tVt\024ii@)";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "<9H`'SvKg%~m\037";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        localObject1 = "<9H`'Y}\037";
        j = 3;
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        j = 4;
        localObject1 = "04\005";
        i = 3;
        break;
      case 3: 
        localObject4[i3] = localObject1;
        d = arrayOfString;
        return;
        i = 16;
        break label91;
        i = 25;
        break label91;
        i = 37;
        break label91;
        i = 19;
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
  
  public a(Object paramObject, ByteBuffer paramByteBuffer)
  {
    super(paramObject, paramByteBuffer);
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public final String c()
  {
    return this.c;
  }
  
  public final String getName()
  {
    return d[0];
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
    this.b = ByteBufferUtils.getLong(localByteBuffer, this);
    this.c = ProtocolUtil.getTlv2(localByteBuffer, this);
  }
  
  public final String toString()
  {
    return d[1] + this.a + d[3] + this.b + d[2] + this.c + d[4] + super.toString();
  }
  
  public final void writeBody()
  {
    super.writeBody();
    writeInt1(this.a);
    writeLong8(this.b);
    writeTlv2(this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */