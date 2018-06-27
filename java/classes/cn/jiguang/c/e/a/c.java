package cn.jiguang.c.e.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.d.d;
import java.nio.ByteBuffer;

public final class c
  extends JResponse
{
  private static final String[] z;
  int a;
  int b;
  String c;
  int d;
  
  static
  {
    String[] arrayOfString = new String[7];
    int j = 0;
    Object localObject2 = "|vH?\006b|\\&\007^jJ";
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
        i = 104;
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
        localObject2 = "\0349\\3\032F|]\002\001]|\025";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\0349\\3\032F|]\000\rBjF9\006\n";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "\0204\017";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "kU@1\001^KJ%\030_w\\35\0204\017%\001T#";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\0349\\3\033Cp@8#U`\025";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "b|\\&\007^jJv\rBk@$H\0359L9\fU#";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 48;
        continue;
        i = 25;
        continue;
        i = 47;
        continue;
        i = 86;
      }
    }
  }
  
  public c(cn.jiguang.c.e.a.a.c paramc, ByteBuffer paramByteBuffer)
  {
    super(paramc, paramByteBuffer);
  }
  
  public final int a()
  {
    return this.d;
  }
  
  public final String getName()
  {
    return z[0];
  }
  
  public final int getSid()
  {
    return this.a;
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
      d.i(z[0], z[6] + this.code);
      return;
    }
    ByteBuffer localByteBuffer = this.body;
    this.a = ByteBufferUtils.getInt(localByteBuffer, this);
    this.b = ByteBufferUtils.getShort(localByteBuffer, this);
    this.c = ProtocolUtil.getTlv2(localByteBuffer, this);
    this.d = ByteBufferUtils.getInt(localByteBuffer, this);
  }
  
  public final String toString()
  {
    return z[4] + this.a + z[2] + this.b + z[5] + this.c + z[1] + this.d + z[3] + super.toString();
  }
  
  public final void writeBody()
  {
    super.writeBody();
    writeInt4(this.a);
    writeInt2(this.b);
    writeTlv2(this.c);
    writeInt4(this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/e/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */