package cn.testin.analysis;

import java.nio.ByteBuffer;

public class em
  extends eq
  implements el
{
  static final ByteBuffer a = ByteBuffer.allocate(0);
  private int f;
  private String g;
  
  public em()
  {
    super(ep.f);
    a(true);
  }
  
  public em(int paramInt)
  {
    super(ep.f);
    a(true);
    a(paramInt, "");
  }
  
  public em(int paramInt, String paramString)
  {
    super(ep.f);
    a(true);
    a(paramInt, paramString);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 1015)
      {
        paramString = "";
        i = 1005;
      }
      if (i == 1005)
      {
        if (paramString.length() > 0) {
          throw new ef(1002, "A close frame must have a closecode if it has a reason");
        }
      }
      else
      {
        paramString = fc.a(paramString);
        ByteBuffer localByteBuffer1 = ByteBuffer.allocate(4);
        localByteBuffer1.putInt(i);
        localByteBuffer1.position(2);
        ByteBuffer localByteBuffer2 = ByteBuffer.allocate(paramString.length + 2);
        localByteBuffer2.put(localByteBuffer1);
        localByteBuffer2.put(paramString);
        localByteBuffer2.rewind();
        a(localByteBuffer2);
      }
      return;
    }
  }
  
  private void g()
  {
    this.f = 1005;
    ByteBuffer localByteBuffer1 = super.c();
    localByteBuffer1.mark();
    if (localByteBuffer1.remaining() >= 2)
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(4);
      localByteBuffer2.position(2);
      localByteBuffer2.putShort(localByteBuffer1.getShort());
      localByteBuffer2.position(0);
      this.f = localByteBuffer2.getInt();
      if ((this.f == 1006) || (this.f == 1015) || (this.f == 1005) || (this.f > 4999) || (this.f < 1000) || (this.f == 1004)) {
        throw new eg("closecode must not be sent over the wire: " + this.f);
      }
    }
    localByteBuffer1.reset();
  }
  
  private void h()
  {
    if (this.f == 1005)
    {
      this.g = fc.a(super.c());
      return;
    }
    ByteBuffer localByteBuffer = super.c();
    int i = localByteBuffer.position();
    try
    {
      localByteBuffer.position(localByteBuffer.position() + 2);
      this.g = fc.a(localByteBuffer);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new eg(localIllegalArgumentException);
    }
    finally
    {
      localByteBuffer.position(i);
    }
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    super.a(paramByteBuffer);
    g();
    h();
  }
  
  public String b()
  {
    return this.g;
  }
  
  public ByteBuffer c()
  {
    if (this.f == 1005) {
      return a;
    }
    return super.c();
  }
  
  public String toString()
  {
    return super.toString() + "code: " + this.f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */