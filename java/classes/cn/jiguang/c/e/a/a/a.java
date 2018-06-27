package cn.jiguang.c.e.a.a;

import android.content.Context;
import cn.jiguang.api.JResponse;
import cn.jiguang.c.e.a.b;
import cn.jiguang.c.e.a.e;
import cn.jiguang.f.h;
import java.nio.ByteBuffer;

public final class a
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[12];
    int j = 0;
    Object localObject2 = "\022bW,=\thb6";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 94;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "\017~f#2[sk6;\b1?b";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "1R}/3\032v1";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = ">c`-,A1f-*\032}P;*\036b2.;\025vf*~\036c`-,[f{66[}b;\025r`;.\017tvl";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = ">c`-,A1f-*\032}P;*\036b2.;\025vf*~\036c`-,[f{66[t|!,\002af':U";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\013p`1;)ta21\025bw\0130\031~g,:[<270\036iq'.\017tvb;A";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = ">c`-,A1`'=\036xd':[s}&'V}w,9\017y216\024cfb*\023p|b=\024|-0[yw#:V}w,9\017y<";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = ">c`-,A1f-*\032}P;*\036b2.;\025vf*~\036c`-,[f{66[t|!,\002af':W1`'*\016c|b0\016}~";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = ":rf+1\0251?b,\036rw+(\036uQ-3\026p|&~V1q/:A";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "\013p`1;\0371z'?\0371?b";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "\013p`1;)ta21\025bw\0130\031~g,:[<2*;\032u(";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = ".y,1\f2!1\026|s,:[w}0~\013p`17\025v2+0\031~g,:U";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 123;
        continue;
        i = 17;
        continue;
        i = 18;
        continue;
        i = 66;
      }
    }
  }
  
  public static JResponse a(c paramc, ByteBuffer paramByteBuffer)
  {
    if (paramc == null)
    {
      cn.jiguang.d.d.i(z[2], "");
      return null;
    }
    cn.jiguang.d.d.a(z[2], z[10] + paramc.toString());
    switch (paramc.c)
    {
    default: 
      cn.jiguang.d.d.g(z[2], z[11]);
      return null;
    case 0: 
      return new cn.jiguang.c.e.a.d(paramc, paramByteBuffer);
    case 1: 
      return new cn.jiguang.c.e.a.c(paramc, paramByteBuffer);
    case 19: 
      return new cn.jiguang.c.e.a.a(paramc, paramByteBuffer);
    case 25: 
      return new b(paramc, paramByteBuffer);
    }
    return new e(paramc, paramByteBuffer);
  }
  
  public static JResponse a(byte[] paramArrayOfByte)
  {
    cn.jiguang.d.d.c(z[2], z[1] + h.a(paramArrayOfByte));
    Object localObject2 = new byte[20];
    System.arraycopy(paramArrayOfByte, 0, localObject2, 0, 20);
    if ((localObject2[0] & 0x80) > 0) {}
    for (;;)
    {
      try
      {
        localObject1 = cn.jiguang.c.f.a.a.a();
        localObject2 = new c(false, (byte[])localObject2);
        int i = ((c)localObject2).a - 20;
        if (i < 0)
        {
          cn.jiguang.d.d.h(z[2], z[7]);
          return null;
        }
        byte[] arrayOfByte = new byte[i];
        System.arraycopy(paramArrayOfByte, 20, arrayOfByte, 0, i);
        localObject1 = ByteBuffer.wrap(cn.jiguang.c.f.a.a.a((String)localObject1, arrayOfByte));
        paramArrayOfByte = (byte[])localObject2;
        cn.jiguang.d.d.c(z[2], z[9] + paramArrayOfByte.toString());
        cn.jiguang.d.d.d(z[2], z[8] + paramArrayOfByte.c);
        return a(paramArrayOfByte, (ByteBuffer)localObject1);
      }
      catch (Exception paramArrayOfByte)
      {
        cn.jiguang.d.d.i(z[2], z[5] + paramArrayOfByte.getMessage());
        return null;
      }
      Object localObject1 = new c(false, (byte[])localObject2);
      localObject2 = new byte[108];
      System.arraycopy(paramArrayOfByte, 20, localObject2, 0, 108);
      localObject2 = ByteBuffer.wrap((byte[])localObject2);
      paramArrayOfByte = (byte[])localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static boolean a(Context paramContext, byte[] paramArrayOfByte)
  {
    cn.jiguang.d.d.c(z[2], z[1] + h.a(paramArrayOfByte));
    if (paramArrayOfByte.length < 20)
    {
      cn.jiguang.d.d.h(z[2], z[6]);
      return false;
    }
    Object localObject2 = new byte[20];
    System.arraycopy(paramArrayOfByte, 0, localObject2, 0, 20);
    int i = localObject2[0] & 0x80;
    cn.jiguang.d.d.c(z[2], z[0] + i);
    Object localObject1;
    if (i > 0)
    {
      try
      {
        localObject1 = cn.jiguang.c.f.a.a.a();
        localObject2 = new c(false, (byte[])localObject2);
        i = ((c)localObject2).a - 20;
        if ((i < 0) || (paramArrayOfByte.length < 20))
        {
          cn.jiguang.d.d.h(z[2], z[4]);
          return false;
        }
      }
      catch (Exception paramContext)
      {
        cn.jiguang.d.d.g(z[2], z[5] + paramContext.getMessage());
        return false;
      }
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, 20, arrayOfByte, 0, i);
      paramArrayOfByte = ByteBuffer.wrap(cn.jiguang.c.f.a.a.a((String)localObject1, arrayOfByte));
      cn.jiguang.c.d.a.a();
      cn.jiguang.c.d.a.a(paramContext, (c)localObject2, paramArrayOfByte);
    }
    for (;;)
    {
      return true;
      localObject1 = new c(false, (byte[])localObject2);
      i = paramArrayOfByte.length - 20;
      if ((i < 0) || (paramArrayOfByte.length < 20))
      {
        cn.jiguang.d.d.h(z[2], z[3]);
        return false;
      }
      localObject2 = new byte[i];
      System.arraycopy(paramArrayOfByte, 20, localObject2, 0, i);
      paramArrayOfByte = ByteBuffer.wrap((byte[])localObject2);
      cn.jiguang.c.d.a.a();
      cn.jiguang.c.d.a.a(paramContext, (c)localObject1, paramArrayOfByte);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/e/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */