package com.growingio.android.sdk.b;

final class e
{
  static final boolean a = b.a();
  private static b b = new b();
  
  static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return b.a(paramArrayOfByte, paramInt);
  }
  
  static String a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 < 0) {
      return String.format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("negative size: " + paramInt2);
    }
    return String.format("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt2 < paramInt1) || (paramInt2 > paramInt3)) {
      throw new IndexOutOfBoundsException(b(paramInt1, paramInt2, paramInt3));
    }
  }
  
  static void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    b.a(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
  }
  
  static boolean a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt1 + paramInt3, paramArrayOfByte1.length);
    a(paramInt2, paramInt2 + paramInt3, paramArrayOfByte2.length);
    int i = 0;
    while (i < paramInt3)
    {
      if (paramArrayOfByte1[(paramInt1 + i)] != paramArrayOfByte2[(paramInt2 + i)]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  static long b(byte[] paramArrayOfByte, int paramInt)
  {
    return b.b(paramArrayOfByte, paramInt);
  }
  
  static String b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramInt3)) {
      return a(paramInt1, paramInt3, "start index");
    }
    if ((paramInt2 < 0) || (paramInt2 > paramInt3)) {
      return a(paramInt2, paramInt3, "end index");
    }
    return String.format("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */