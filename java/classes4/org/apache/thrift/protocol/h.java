package org.apache.thrift.protocol;

import org.apache.thrift.f;

public class h
{
  private static int a = Integer.MAX_VALUE;
  
  public static void a(e parame, byte paramByte)
  {
    a(parame, paramByte, a);
  }
  
  public static void a(e parame, byte paramByte, int paramInt)
  {
    byte b2 = 0;
    byte b3 = 0;
    byte b1 = 0;
    if (paramInt <= 0) {
      throw new f("Maximum skip depth exceeded");
    }
    switch (paramByte)
    {
    case 5: 
    case 7: 
    case 9: 
    default: 
      return;
    case 2: 
      parame.q();
      return;
    case 3: 
      parame.r();
      return;
    case 6: 
      parame.s();
      return;
    case 8: 
      parame.t();
      return;
    case 10: 
      parame.u();
      return;
    case 4: 
      parame.v();
      return;
    case 11: 
      parame.x();
      return;
    case 12: 
      parame.g();
      for (;;)
      {
        localObject = parame.i();
        if (((b)localObject).b == 0)
        {
          parame.h();
          return;
        }
        a(parame, ((b)localObject).b, paramInt - 1);
        parame.j();
      }
    case 13: 
      localObject = parame.k();
      paramByte = b1;
      while (paramByte < ((d)localObject).c)
      {
        a(parame, ((d)localObject).a, paramInt - 1);
        a(parame, ((d)localObject).b, paramInt - 1);
        paramByte += 1;
      }
      parame.l();
      return;
    case 14: 
      localObject = parame.o();
      paramByte = b2;
      while (paramByte < ((i)localObject).b)
      {
        a(parame, ((i)localObject).a, paramInt - 1);
        paramByte += 1;
      }
      parame.p();
      return;
    }
    Object localObject = parame.m();
    paramByte = b3;
    while (paramByte < ((c)localObject).b)
    {
      a(parame, ((c)localObject).a, paramInt - 1);
      paramByte += 1;
    }
    parame.n();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/apache/thrift/protocol/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */