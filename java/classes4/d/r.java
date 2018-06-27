package d;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class r
  extends f
{
  final transient byte[][] f;
  final transient int[] g;
  
  r(c paramc, int paramInt)
  {
    super(null);
    v.checkOffsetAndCount(paramc.b, 0L, paramInt);
    p localp = paramc.a;
    int i = 0;
    int j = 0;
    while (j < paramInt)
    {
      if (localp.c == localp.b) {
        throw new AssertionError("s.limit == s.pos");
      }
      j += localp.c - localp.b;
      i += 1;
      localp = localp.f;
    }
    this.f = new byte[i][];
    this.g = new int[i * 2];
    paramc = paramc.a;
    j = 0;
    i = k;
    while (i < paramInt)
    {
      this.f[j] = paramc.a;
      k = paramc.c - paramc.b + i;
      i = k;
      if (k > paramInt) {
        i = paramInt;
      }
      this.g[j] = i;
      this.g[(this.f.length + j)] = paramc.b;
      paramc.d = true;
      j += 1;
      paramc = paramc.f;
    }
  }
  
  private int a(int paramInt)
  {
    paramInt = Arrays.binarySearch(this.g, 0, this.f.length, paramInt + 1);
    if (paramInt >= 0) {
      return paramInt;
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  private f b()
  {
    return new f(toByteArray());
  }
  
  void a(c paramc)
  {
    int m = this.f.length;
    int j = 0;
    int i = 0;
    if (j < m)
    {
      int n = this.g[(m + j)];
      int k = this.g[j];
      p localp = new p(this.f[j], n, n + k - i, true, false);
      if (paramc.a == null)
      {
        localp.g = localp;
        localp.f = localp;
        paramc.a = localp;
      }
      for (;;)
      {
        j += 1;
        i = k;
        break;
        paramc.a.g.push(localp);
      }
    }
    paramc.b += i;
  }
  
  byte[] a()
  {
    return toByteArray();
  }
  
  public ByteBuffer asByteBuffer()
  {
    return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
  }
  
  public String base64()
  {
    return b().base64();
  }
  
  public String base64Url()
  {
    return b().base64Url();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof f)) && (((f)paramObject).size() == size()) && (rangeEquals(0, (f)paramObject, 0, size()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public byte getByte(int paramInt)
  {
    v.checkOffsetAndCount(this.g[(this.f.length - 1)], paramInt, 1L);
    int j = a(paramInt);
    if (j == 0) {}
    for (int i = 0;; i = this.g[(j - 1)])
    {
      int k = this.g[(this.f.length + j)];
      return this.f[j][(paramInt - i + k)];
    }
  }
  
  public int hashCode()
  {
    int i = this.d;
    if (i != 0) {
      return i;
    }
    i = 1;
    int i2 = this.f.length;
    int j = 0;
    int n;
    for (int k = 0; j < i2; k = n)
    {
      byte[] arrayOfByte = this.f[j];
      int i1 = this.g[(i2 + j)];
      n = this.g[j];
      int m = i1;
      while (m < n - k + i1)
      {
        i = i * 31 + arrayOfByte[m];
        m += 1;
      }
      j += 1;
    }
    this.d = i;
    return i;
  }
  
  public String hex()
  {
    return b().hex();
  }
  
  public f hmacSha1(f paramf)
  {
    return b().hmacSha1(paramf);
  }
  
  public f hmacSha256(f paramf)
  {
    return b().hmacSha256(paramf);
  }
  
  public int indexOf(byte[] paramArrayOfByte, int paramInt)
  {
    return b().indexOf(paramArrayOfByte, paramInt);
  }
  
  public int lastIndexOf(byte[] paramArrayOfByte, int paramInt)
  {
    return b().lastIndexOf(paramArrayOfByte, paramInt);
  }
  
  public f md5()
  {
    return b().md5();
  }
  
  public boolean rangeEquals(int paramInt1, f paramf, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > size() - paramInt3)) {
      return false;
    }
    int j = a(paramInt1);
    int i = paramInt1;
    paramInt1 = j;
    label30:
    if (paramInt3 > 0)
    {
      if (paramInt1 == 0) {}
      for (j = 0;; j = this.g[(paramInt1 - 1)])
      {
        int k = Math.min(paramInt3, this.g[paramInt1] - j + j - i);
        int m = this.g[(this.f.length + paramInt1)];
        if (!paramf.rangeEquals(paramInt2, this.f[paramInt1], i - j + m, k)) {
          break;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
        break label30;
      }
    }
    return true;
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > size() - paramInt3) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt3)) {
      return false;
    }
    int j = a(paramInt1);
    int i = paramInt1;
    paramInt1 = j;
    label43:
    if (paramInt3 > 0)
    {
      if (paramInt1 == 0) {}
      for (j = 0;; j = this.g[(paramInt1 - 1)])
      {
        int k = Math.min(paramInt3, this.g[paramInt1] - j + j - i);
        int m = this.g[(this.f.length + paramInt1)];
        if (!v.arrayRangeEquals(this.f[paramInt1], i - j + m, paramArrayOfByte, paramInt2, k)) {
          break;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
        break label43;
      }
    }
    return true;
  }
  
  public f sha1()
  {
    return b().sha1();
  }
  
  public f sha256()
  {
    return b().sha256();
  }
  
  public int size()
  {
    return this.g[(this.f.length - 1)];
  }
  
  public String string(Charset paramCharset)
  {
    return b().string(paramCharset);
  }
  
  public f substring(int paramInt)
  {
    return b().substring(paramInt);
  }
  
  public f substring(int paramInt1, int paramInt2)
  {
    return b().substring(paramInt1, paramInt2);
  }
  
  public f toAsciiLowercase()
  {
    return b().toAsciiLowercase();
  }
  
  public f toAsciiUppercase()
  {
    return b().toAsciiUppercase();
  }
  
  public byte[] toByteArray()
  {
    int i = 0;
    byte[] arrayOfByte = new byte[this.g[(this.f.length - 1)]];
    int m = this.f.length;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = this.g[(m + i)];
      k = this.g[i];
      System.arraycopy(this.f[i], n, arrayOfByte, j, k - j);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public String toString()
  {
    return b().toString();
  }
  
  public String utf8()
  {
    return b().utf8();
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    int m = this.f.length;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = this.g[(m + i)];
      k = this.g[i];
      paramOutputStream.write(this.f[i], n, k - j);
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/d/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */