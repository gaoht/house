package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.c;
import com.megvii.zhimasdk.b.a.j.b;
import com.megvii.zhimasdk.b.a.j.e;
import com.megvii.zhimasdk.b.a.j.f;
import com.megvii.zhimasdk.b.a.o.d;
import java.nio.charset.Charset;

@Deprecated
public class m
  implements b, f
{
  private final f a;
  private final b b;
  private final r c;
  private final String d;
  
  public m(f paramf, r paramr, String paramString)
  {
    this.a = paramf;
    if ((paramf instanceof b))
    {
      paramf = (b)paramf;
      this.b = paramf;
      this.c = paramr;
      if (paramString == null) {
        break label46;
      }
    }
    for (;;)
    {
      this.d = paramString;
      return;
      paramf = null;
      break;
      label46:
      paramString = c.b.name();
    }
  }
  
  public int a()
  {
    int i = this.a.a();
    if ((this.c.a()) && (i != -1)) {
      this.c.b(i);
    }
    return i;
  }
  
  public int a(d paramd)
  {
    int i = this.a.a(paramd);
    if ((this.c.a()) && (i >= 0))
    {
      int j = paramd.c();
      paramd = new String(paramd.b(), j - i, i);
      paramd = paramd + "\r\n";
      this.c.b(paramd.getBytes(this.d));
    }
    return i;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = this.a.a(paramArrayOfByte, paramInt1, paramInt2);
    if ((this.c.a()) && (paramInt2 > 0)) {
      this.c.b(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public boolean a(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  public e b()
  {
    return this.a.b();
  }
  
  public boolean c()
  {
    if (this.b != null) {
      return this.b.c();
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */