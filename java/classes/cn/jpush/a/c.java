package cn.jpush.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jpush.android.c.f;
import java.nio.ByteBuffer;

public final class c
  extends JResponse
{
  private static final String[] b;
  int a;
  
  static
  {
    String[] arrayOfString = new String[5];
    Object localObject1 = "\017Ns3I2Ng\000@(_{<V>";
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
          i = 37;
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
        localObject1 = "{\0024";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "\000{u5D7Fu!w>\\d=K(JIr\b{\\q#P>Aw7\037";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        localObject1 = "\tJg\"J5\\qr@)]{ \005v\017w=A>\025";
        j = 3;
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        j = 4;
        localObject1 = "\030@z&@5[B3I.Jg";
        i = 3;
        break;
      case 3: 
        localObject4[i3] = localObject1;
        b = arrayOfString;
        return;
        i = 91;
        break label91;
        i = 47;
        break label91;
        i = 20;
        break label91;
        i = 82;
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
  
  public c(Object paramObject, ByteBuffer paramByteBuffer)
  {
    super(paramObject, paramByteBuffer);
  }
  
  public final String getName()
  {
    return b[0];
  }
  
  protected final boolean isNeedParseeErrorMsg()
  {
    return true;
  }
  
  public final void parseBody()
  {
    super.parseBody();
    if (this.code > 0)
    {
      f.i(b[4], b[3] + this.code);
      return;
    }
    this.a = ByteBufferUtils.getShort(this.body, this);
  }
  
  public final String toString()
  {
    return b[2] + this.a + b[1] + super.toString();
  }
  
  public final void writeBody()
  {
    super.writeBody();
    writeInt4(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */