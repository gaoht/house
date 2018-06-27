package c.a.b.b;

import java.nio.ByteBuffer;

public class b
{
  public static int a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    if ((paramByteBuffer1 == null) || (paramByteBuffer2 == null)) {
      throw new IllegalArgumentException();
    }
    int i = paramByteBuffer1.remaining();
    int j = paramByteBuffer2.remaining();
    if (i > j)
    {
      i = Math.min(i, j);
      paramByteBuffer1.limit(i);
      paramByteBuffer2.put(paramByteBuffer1);
      return i;
    }
    paramByteBuffer2.put(paramByteBuffer1);
    return i;
  }
  
  public static ByteBuffer a()
  {
    return ByteBuffer.allocate(0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */