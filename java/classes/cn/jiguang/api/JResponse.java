package cn.jiguang.api;

import cn.jiguang.api.utils.ByteBufferUtils;
import java.nio.ByteBuffer;

public abstract class JResponse
  extends JProtocol
{
  private static final String z;
  public int code;
  
  static
  {
    Object localObject1 = ",Oy#>\tso55\005rx5s".toCharArray();
    int j = localObject1.length;
    int m = 0;
    int i = 0;
    Object localObject2 = localObject1;
    int k = j;
    label30:
    int n;
    if (j <= 1)
    {
      m = i;
      k = i;
      localObject2 = localObject1;
      n = localObject2[k];
      switch (m % 5)
      {
      default: 
        i = 78;
      }
    }
    for (;;)
    {
      localObject2[k] = ((char)(i ^ n));
      m += 1;
      if (j == 0)
      {
        k = j;
        break label30;
      }
      k = j;
      localObject2 = localObject1;
      localObject1 = localObject2;
      j = k;
      i = m;
      if (k > m) {
        break;
      }
      z = new String((char[])localObject2).intern();
      return;
      i = 102;
      continue;
      i = 29;
      continue;
      i = 28;
      continue;
      i = 80;
    }
  }
  
  public JResponse(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, String paramString)
  {
    super(false, paramInt1, paramInt2, paramLong1, -1, paramLong2);
    this.code = paramInt3;
  }
  
  public JResponse(Object paramObject, ByteBuffer paramByteBuffer)
  {
    super(false, paramObject, paramByteBuffer);
  }
  
  public JResponse(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte)
  {
    super(false, paramByteBuffer, paramArrayOfByte);
  }
  
  protected void parseBody()
  {
    if (isNeedParseeErrorMsg()) {
      this.code = ByteBufferUtils.getShort(this.body, this);
    }
  }
  
  public String toString()
  {
    return z + this.code + '}';
  }
  
  protected void writeBody()
  {
    if (this.code >= 0) {
      writeInt2(this.code);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/api/JResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */