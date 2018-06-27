package cn.testin.analysis;

import java.net.InetSocketAddress;

public abstract class dq
  implements ds
{
  public ez a(dn paramdn, dw paramdw, er paramer)
  {
    return new ev();
  }
  
  public String a(dn paramdn)
  {
    paramdn = paramdn.a();
    if (paramdn == null) {
      throw new eh("socket not bound");
    }
    StringBuffer localStringBuffer = new StringBuffer(90);
    localStringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
    localStringBuffer.append(paramdn.getPort());
    localStringBuffer.append("\" /></cross-domain-policy>\000");
    return localStringBuffer.toString();
  }
  
  public void a(dn paramdn, eo parameo) {}
  
  public void a(dn paramdn, er paramer) {}
  
  public void a(dn paramdn, er paramer, ey paramey) {}
  
  public void b(dn paramdn, eo parameo)
  {
    parameo = new eq(parameo);
    parameo.a(ep.e);
    paramdn.a(parameo);
  }
  
  public void c(dn paramdn, eo parameo) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */