package cn.jpush.a;

import cn.jiguang.api.JRequest;
import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

public final class b
  extends JRequest
{
  private static final String[] c;
  String a;
  String b;
  
  static
  {
    String[] arrayOfString = new String[4];
    Object localObject1 = "<hw";
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
          i = 6;
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
        localObject1 = "G\0216\023gp,6\007Ty4\"\021uh\030wY&}5'?ce";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "0e6\027ru*9N";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        j = 3;
        localObject1 = "H$0\025ju$$&cm02\007r";
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        c = arrayOfString;
        return;
        i = 28;
        break label91;
        i = 69;
        break label91;
        i = 87;
        break label91;
        i = 116;
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
  
  public b(long paramLong, String paramString1, String paramString2)
  {
    super(2, 10, paramLong);
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final String getName()
  {
    return c[3];
  }
  
  protected final boolean isNeedParseeErrorMsg()
  {
    return true;
  }
  
  public final void parseBody()
  {
    ByteBuffer localByteBuffer = this.body;
    this.a = ProtocolUtil.getTlv2(localByteBuffer);
    this.b = ProtocolUtil.getTlv2(localByteBuffer);
  }
  
  public final String toString()
  {
    return c[1] + this.a + c[2] + this.b + c[0] + super.toString();
  }
  
  public final void writeBody()
  {
    writeTlv2(this.a);
    writeTlv2(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */