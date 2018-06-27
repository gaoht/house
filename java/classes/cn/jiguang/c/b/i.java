package cn.jiguang.c.b;

import cn.jiguang.d.d;
import cn.jiguang.f.a;

public final class i
{
  private static final String[] z;
  int a;
  int b = 0;
  long c;
  byte[] d;
  int e;
  String f;
  
  static
  {
    String[] arrayOfString = new String[10];
    int j = 0;
    Object localObject2 = "NY=Gd6\000>F2E";
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
        i = 15;
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
        localObject2 = "0\034?Vj\021\r'Mh\031\r'Nj\r\f:\036";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "NY-Lb\017\030 G2";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "NY:Jb\007\ns";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "NY<Jk_";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "N\n*H{\033\t+\031";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\022\030<PjB\013+Rz\007\n:Ja\005Y(Bf\016\034*";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\020\034?Vj\021\r'MhB\032!Nb\003\027*\031";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "0\034?Vj\021\r\rBl\n\034\003Ba\003\036+Q";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "N\013'G5";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 98;
        continue;
        i = 121;
        continue;
        i = 78;
        continue;
        i = 35;
      }
    }
  }
  
  public i(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    this.d = paramArrayOfByte;
    this.a = paramInt;
    this.f = paramString;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 24))
    {
      d.h(z[8], z[6]);
      return;
    }
    this.e = a.a(paramArrayOfByte[3]);
    this.c = 0L;
    paramInt = i;
    while (paramInt < 8)
    {
      this.c = ((this.c << 8) + (paramArrayOfByte[(paramInt + 4)] & 0xFF));
      paramInt += 1;
    }
    d.a(z[8], z[7] + this.e + z[9] + this.c + z[5] + paramString);
  }
  
  public final String a()
  {
    return h.a(this.c, this.f);
  }
  
  public final String toString()
  {
    return z[1] + this.a + z[3] + this.b + z[4] + this.c + z[2] + this.e + z[0] + this.f + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */