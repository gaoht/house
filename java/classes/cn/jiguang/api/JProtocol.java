package cn.jiguang.api;

import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.c.e.a.a.c;
import cn.jiguang.d.d;
import cn.jiguang.f.h;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public abstract class JProtocol
{
  public static final int DEFAULT_RESP_CODE = 0;
  public static final int DEFAULT_RID = 0;
  public static final int DEFAULT_SID = 0;
  public static final int NO_JUID = -1;
  public static final int NO_RESP_CODE = -1;
  public static final int NO_SID = -1;
  private static final int PACKET_SIZE = 7168;
  private static final String TAG;
  private static final String[] z;
  protected ByteBuffer body;
  protected c head;
  private boolean isRequest;
  
  static
  {
    String[] arrayOfString = new String[10];
    int j = 0;
    Object localObject2 = "\025Z3Ka0i.H";
    int i = 9;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i4 = i;
    localObject2 = arrayOfChar;
    int i3 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label69:
      n = m;
      label72:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 21;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label72;
        TAG = (String)localObject1;
        localObject2 = "*d*Jz(*\016F:i5";
        i = -1;
        j = i3;
        localObject1 = localObject3;
        break;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i3 = j;
      localObject2 = localObject1;
      i4 = i2;
      i2 = i4;
      localObject1 = localObject2;
      j = i3;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label69;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i4)
      {
      case 9: 
      default: 
        localObject3[i3] = localObject1;
        j = 1;
        localObject2 = "0h+Av+*6Efd4Hy";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i3] = localObject1;
        j = 2;
        localObject2 = "s*#]a:y{\004";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i3] = localObject1;
        j = 3;
        localObject2 = "\031c/Ey'aHp10";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i3] = localObject1;
        j = 4;
        localObject2 = "+e\003]a:yaFz;s\003]a:ya\004|,*aJ`3f";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i3] = localObject1;
        j = 5;
        localObject2 = "\021eaFz;saPzz Vf:$";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i3] = localObject1;
        j = 6;
        localObject2 = "'a";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i3] = localObject1;
        j = 7;
        localObject2 = "\004X$We0d2AH";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i3] = localObject1;
        j = 8;
        localObject2 = "\004X$U`:y5y";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i3] = localObject1;
        j = 9;
        localObject2 = "<x$Ea:*\013lp>naBt6f$@/";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 95;
        continue;
        i = 10;
        continue;
        i = 65;
        continue;
        i = 36;
      }
    }
  }
  
  public JProtocol(boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    this.isRequest = paramBoolean;
    this.head = new c(paramBoolean, paramInt1, paramInt2, paramLong);
    this.body = ByteBuffer.allocate(7168);
  }
  
  public JProtocol(boolean paramBoolean, int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2)
  {
    this.isRequest = paramBoolean;
    this.head = new c(paramBoolean, 0, paramInt1, paramInt2, paramLong1, paramInt3, paramLong2);
    this.body = ByteBuffer.allocate(7168);
  }
  
  public JProtocol(boolean paramBoolean, Object paramObject, ByteBuffer paramByteBuffer)
  {
    this.isRequest = paramBoolean;
    this.head = ((c)paramObject);
    if (paramByteBuffer != null)
    {
      this.body = paramByteBuffer;
      parseBody();
      return;
    }
    d.g(TAG, z[5]);
  }
  
  public JProtocol(boolean paramBoolean, ByteBuffer paramByteBuffer, byte[] paramArrayOfByte)
  {
    this.isRequest = paramBoolean;
    try
    {
      this.head = new c(paramBoolean, paramArrayOfByte);
      if (paramByteBuffer != null)
      {
        this.body = paramByteBuffer;
        parseBody();
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        d.g(TAG, z[9] + paramArrayOfByte.getMessage());
      }
      d.g(TAG, z[5]);
    }
  }
  
  public static byte[] parseHead(Object paramObject)
  {
    if (paramObject == null)
    {
      d.g(TAG, z[1]);
      return null;
    }
    if ((paramObject instanceof c)) {
      return ((c)paramObject).f();
    }
    d.g(TAG, z[0]);
    return null;
  }
  
  private final byte[] toBytes()
  {
    Object localObject = new ByteArrayOutputStream();
    byte[] arrayOfByte = ProtocolUtil.getBytes(this.body);
    if (arrayOfByte == null)
    {
      d.g(TAG, z[4]);
      return null;
    }
    c localc = this.head;
    int i;
    if (this.isRequest) {
      i = 24;
    }
    for (;;)
    {
      localc.a(i + arrayOfByte.length);
      try
      {
        ((ByteArrayOutputStream)localObject).write(this.head.f());
        ((ByteArrayOutputStream)localObject).write(arrayOfByte);
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        d.c(TAG, z[3] + localObject.length + z[2] + h.a((byte[])localObject));
        return (byte[])localObject;
        i = 20;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public ByteBuffer getBody()
  {
    return this.body;
  }
  
  public int getCommand()
  {
    return this.head.a();
  }
  
  public c getHead()
  {
    return this.head;
  }
  
  public long getJuid()
  {
    return this.head.c();
  }
  
  public abstract String getName();
  
  public Long getRid()
  {
    return this.head.b();
  }
  
  public int getSid()
  {
    return this.head.d();
  }
  
  public int getVersion()
  {
    return this.head.e();
  }
  
  protected abstract boolean isNeedParseeErrorMsg();
  
  protected abstract void parseBody();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.isRequest) {}
    for (String str = z[8];; str = z[7]) {
      return str + z[6] + this.head.toString();
    }
  }
  
  protected abstract void writeBody();
  
  public final byte[] writeBodyAndToBytes()
  {
    this.body.clear();
    writeBody();
    this.body.flip();
    return toBytes();
  }
  
  protected void writeBytes(byte[] paramArrayOfByte)
  {
    this.body.put(paramArrayOfByte);
  }
  
  protected void writeInt1(int paramInt)
  {
    this.body.put((byte)paramInt);
  }
  
  protected void writeInt2(int paramInt)
  {
    this.body.putShort((short)paramInt);
  }
  
  protected void writeInt4(int paramInt)
  {
    this.body.putInt(paramInt);
  }
  
  protected void writeLong8(long paramLong)
  {
    this.body.putLong(paramLong);
  }
  
  protected void writeTlv2(String paramString)
  {
    this.body.put(ProtocolUtil.tlv2ToByteArray(paramString));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/api/JProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */