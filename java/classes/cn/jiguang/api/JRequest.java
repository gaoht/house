package cn.jiguang.api;

import cn.jiguang.c.e.a.a.c;
import java.nio.ByteBuffer;

public abstract class JRequest
  extends JProtocol
{
  public JRequest(int paramInt1, int paramInt2, long paramLong)
  {
    super(true, paramInt1, paramInt2, paramLong);
  }
  
  public JRequest(Object paramObject, ByteBuffer paramByteBuffer)
  {
    super(true, paramObject, paramByteBuffer);
  }
  
  public void setJuid(long paramLong)
  {
    this.head.a(paramLong);
  }
  
  public void setSid(int paramInt)
  {
    this.head.b(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/api/JRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */