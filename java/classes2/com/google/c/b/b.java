package com.google.c.b;

public class b
  extends n
{
  public b()
  {
    super(20);
  }
  
  public byte[] encode(String paramString)
  {
    char c = Character.toUpperCase(paramString.charAt(0));
    if (!a.a(new char[] { 65, 66, 67, 68 }, c)) {
      throw new IllegalArgumentException("Codabar should start with one of the following: 'A', 'B', 'C' or 'D'");
    }
    c = Character.toUpperCase(paramString.charAt(paramString.length() - 1));
    if (!a.a(new char[] { 84, 78, 42, 69 }, c)) {
      throw new IllegalArgumentException("Codabar should end with one of the following: 'T', 'N', '*' or 'E'");
    }
    int j = 20;
    int k = 1;
    if (k < paramString.length() - 1)
    {
      if ((Character.isDigit(paramString.charAt(k))) || (paramString.charAt(k) == '-') || (paramString.charAt(k) == '$')) {
        j += 9;
      }
      for (;;)
      {
        k += 1;
        break;
        c = paramString.charAt(k);
        if (!a.a(new char[] { 47, 58, 43, 46 }, c)) {
          break label218;
        }
        j += 10;
      }
      label218:
      throw new IllegalArgumentException("Cannot encode : '" + paramString.charAt(k) + '\'');
    }
    byte[] arrayOfByte = new byte[paramString.length() - 1 + j];
    int m = 0;
    j = 0;
    if (m < paramString.length())
    {
      n = Character.toUpperCase(paramString.charAt(m));
      k = n;
      if (m == paramString.length() - 1)
      {
        if (n == 42) {
          k = 67;
        }
      }
      else
      {
        n = 0;
        label323:
        if (n >= a.a.length) {
          break label493;
        }
        if (k != a.a[n]) {
          break label432;
        }
      }
    }
    label432:
    label450:
    label493:
    for (int n = a.b[n];; n = 0)
    {
      int i1 = 0;
      k = 0;
      int i = 1;
      for (;;)
      {
        if (i1 >= 7) {
          break label450;
        }
        arrayOfByte[j] = i;
        j += 1;
        if (((n >> 6 - i1 & 0x1) == 0) || (k == 1))
        {
          i = (byte)(i ^ 0x1);
          i1 += 1;
          k = 0;
          continue;
          k = n;
          if (n != 69) {
            break;
          }
          k = 68;
          break;
          n += 1;
          break label323;
        }
        k += 1;
      }
      k = j;
      if (m < paramString.length() - 1)
      {
        arrayOfByte[j] = 0;
        k = j + 1;
      }
      m += 1;
      j = k;
      break;
      return arrayOfByte;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */