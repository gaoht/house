package cn.jiguang.api.utils;

import java.math.BigInteger;

public class OutputDataUtil
{
  private static final BigInteger d;
  private static final String[] z;
  private byte[] a;
  private int b;
  private int c;
  
  static
  {
    String[] arrayOfString = new String[6];
    int j = 0;
    Object localObject2 = "XcU)EO\"L5COg\0337KHv\033\"D_\"T!\n_cO&";
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
        i = 42;
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
        localObject2 = "rlM&FRf\033$ENlO\"N\033qO5CUe";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\033`R3\nMcW2O\033oZ?\020";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "\033mN3\nTd\0335KUe^gLTp\033";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "Um\0337X^tR(_H\"H3KOg";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "XcU)EO\"Q2GK\"K&YO\"^)N\033m]gNZvZ";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        d = BigInteger.ONE.shiftLeft(64);
        return;
        i = 59;
        continue;
        i = 2;
        continue;
        i = 59;
        continue;
        i = 71;
      }
    }
  }
  
  public OutputDataUtil()
  {
    this(32);
  }
  
  public OutputDataUtil(int paramInt)
  {
    this.a = new byte[paramInt];
    this.b = 0;
    this.c = -1;
  }
  
  private void a(int paramInt)
  {
    if (this.a.length - this.b >= paramInt) {
      return;
    }
    int j = this.a.length * 2;
    int i = j;
    if (j < this.b + paramInt) {
      i = this.b + paramInt;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
    this.a = arrayOfByte;
  }
  
  private static void a(long paramLong, int paramInt)
  {
    long l = 1L << paramInt;
    if ((paramLong < 0L) || (paramLong > l)) {
      throw new IllegalArgumentException(paramLong + z[3] + paramInt + z[2] + l);
    }
  }
  
  public static int encodeZigZag32(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static long encodeZigZag64(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public int current()
  {
    return this.b;
  }
  
  public void jump(int paramInt)
  {
    if (paramInt > this.b) {
      throw new IllegalArgumentException(z[5]);
    }
    this.b = paramInt;
  }
  
  public void restore()
  {
    if (this.c < 0) {
      throw new IllegalStateException(z[4]);
    }
    this.b = this.c;
    this.c = -1;
  }
  
  public void save()
  {
    this.c = this.b;
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[this.b];
    System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
    return arrayOfByte;
  }
  
  public void writeByteArray(byte[] paramArrayOfByte)
  {
    writeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void writeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b, paramInt2);
    this.b += paramInt2;
  }
  
  public void writeByteArrayincludeLength(byte[] paramArrayOfByte)
  {
    writeU16(paramArrayOfByte.length);
    writeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void writeCountedString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 255) {
      throw new IllegalArgumentException(z[1]);
    }
    a(paramArrayOfByte.length + 1);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramArrayOfByte.length & 0xFF));
    writeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void writeRawLittleEndian16(int paramInt)
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >> 8 & 0xFF));
  }
  
  public void writeRawLittleEndian32(int paramInt)
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >> 8 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >> 16 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >> 24 & 0xFF));
  }
  
  public void writeRawLittleEndian64(long paramLong)
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)((int)paramLong & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)((int)(paramLong >> 8) & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)((int)(paramLong >> 16) & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)((int)(paramLong >> 24) & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)((int)(paramLong >> 32) & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)((int)(paramLong >> 40) & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)((int)(paramLong >> 48) & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)((int)(paramLong >> 56) & 0xFF));
  }
  
  public void writeU16(int paramInt)
  {
    a(paramInt, 16);
    a(2);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
  }
  
  public void writeU16At(int paramInt1, int paramInt2)
  {
    a(paramInt1, 16);
    if (paramInt2 > this.b - 2) {
      throw new IllegalArgumentException(z[0]);
    }
    this.a[paramInt2] = ((byte)(paramInt1 >>> 8 & 0xFF));
    this.a[(paramInt2 + 1)] = ((byte)(paramInt1 & 0xFF));
  }
  
  public void writeU32(long paramLong)
  {
    a(paramLong, 32);
    a(4);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 24 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
  }
  
  public void writeU32At(long paramLong, int paramInt)
  {
    a(paramLong, 32);
    if (paramInt > this.b - 4) {
      throw new IllegalArgumentException(z[0]);
    }
    byte[] arrayOfByte = this.a;
    int i = paramInt + 1;
    arrayOfByte[paramInt] = ((byte)(int)(paramLong >>> 24 & 0xFF));
    arrayOfByte = this.a;
    paramInt = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    this.a[paramInt] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    this.a[(paramInt + 1)] = ((byte)(int)(paramLong & 0xFF));
  }
  
  public void writeU64(long paramLong)
  {
    a(8);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 56 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 48 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 40 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 32 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 24 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
  }
  
  public void writeU8(int paramInt)
  {
    a(paramInt, 8);
    a(1);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/api/utils/OutputDataUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */