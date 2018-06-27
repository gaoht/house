package cn.jiguang.c.e.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.c.e.a.a.c;
import java.nio.ByteBuffer;

public final class d
  extends JResponse
{
  private static final String[] z;
  long a;
  String b;
  String c;
  String d;
  String e;
  
  static
  {
    String[] arrayOfString = new String[7];
    int j = 0;
    Object localObject2 = "\017\023!'#jWi";
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
        i = 68;
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
        localObject2 = "\017\023##7PD<0 \031";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\017\0237'2JP6\013 \031";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "xa6%-PG60\026F@#-*PV\016bi\003Y&+ \031";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\003\036s";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "qV 2+M@6b!QA<0d\016\0230- F\t";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "qV4+7WV!\020!PC<,7F";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 35;
        continue;
        i = 51;
        continue;
        i = 83;
        continue;
        i = 66;
      }
    }
  }
  
  public d(c paramc, ByteBuffer paramByteBuffer)
  {
    super(paramc, paramByteBuffer);
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final String b()
  {
    return this.c;
  }
  
  public final String c()
  {
    return this.d;
  }
  
  public final long getJuid()
  {
    return this.a;
  }
  
  public final String getName()
  {
    return z[6];
  }
  
  protected final boolean isNeedParseeErrorMsg()
  {
    return true;
  }
  
  protected final void parseBody()
  {
    super.parseBody();
    if (this.code > 0) {
      cn.jiguang.d.d.i(z[6], z[5] + this.code);
    }
    ByteBuffer localByteBuffer;
    do
    {
      return;
      localByteBuffer = this.body;
      if (this.code == 0)
      {
        this.a = ByteBufferUtils.getLong(localByteBuffer, this);
        this.b = ProtocolUtil.getTlv2(localByteBuffer, this);
        this.c = ProtocolUtil.getTlv2(localByteBuffer, this);
        return;
      }
    } while (this.code != 1007);
    this.e = ProtocolUtil.getTlv2(localByteBuffer, this);
  }
  
  public final String toString()
  {
    return z[3] + this.a + z[1] + this.b + z[0] + this.c + z[2] + this.d + z[4] + super.toString();
  }
  
  protected final void writeBody()
  {
    super.writeBody();
    writeLong8(this.a);
    writeTlv2(this.b);
    writeTlv2(this.c);
    writeTlv2(this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/e/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */