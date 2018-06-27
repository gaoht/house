package cn.jiguang.c.e.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.c.e.a.a.c;
import java.nio.ByteBuffer;

public final class e
  extends JResponse
{
  private static final String z;
  
  static
  {
    Object localObject1 = "lj\022)hMk\033\tNJi\0305X\\".toCharArray();
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
        i = 43;
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
      i = 57;
      continue;
      i = 25;
      continue;
      i = 119;
      continue;
      i = 91;
    }
  }
  
  public e(c paramc, ByteBuffer paramByteBuffer)
  {
    super(paramc, paramByteBuffer);
  }
  
  public final String getName()
  {
    return z;
  }
  
  protected final boolean isNeedParseeErrorMsg()
  {
    return true;
  }
  
  public final void parseBody()
  {
    super.parseBody();
  }
  
  public final void writeBody()
  {
    super.writeBody();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/e/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */