package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.b.f.b;
import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.f.m;
import java.util.Date;

public class g
  extends a
{
  private final String[] a;
  
  public g(String[] paramArrayOfString)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramArrayOfString, "Array of date patterns");
    this.a = paramArrayOfString;
  }
  
  public void a(m paramm, String paramString)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramm, "Cookie");
    if (paramString == null) {
      throw new l("Missing value for expires attribute");
    }
    Date localDate = b.a(paramString, this.a);
    if (localDate == null) {
      throw new l("Unable to parse expires attribute: " + paramString);
    }
    paramm.b(localDate);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */