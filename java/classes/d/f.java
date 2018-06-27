package d;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class f
  implements Serializable, Comparable<f>
{
  static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final f b = of(new byte[0]);
  final byte[] c;
  transient int d;
  transient String e;
  
  f(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  private static int a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    throw new IllegalArgumentException("Unexpected hex digit: " + paramChar);
  }
  
  static int a(String paramString, int paramInt)
  {
    int i = 0;
    int k = paramString.length();
    int j = 0;
    while (i < k)
    {
      if (j == paramInt) {
        return i;
      }
      int m = paramString.codePointAt(i);
      if (((Character.isISOControl(m)) && (m != 10) && (m != 13)) || (m == 65533)) {
        return -1;
      }
      j += 1;
      i += Character.charCount(m);
    }
    return paramString.length();
  }
  
  private f a(String paramString)
  {
    try
    {
      paramString = of(MessageDigest.getInstance(paramString).digest(this.c));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  private f a(String paramString, f paramf)
  {
    try
    {
      Mac localMac = Mac.getInstance(paramString);
      localMac.init(new SecretKeySpec(paramf.toByteArray(), paramString));
      paramString = of(localMac.doFinal(this.c));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvalidKeyException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  @Nullable
  public static f decodeBase64(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("base64 == null");
    }
    paramString = b.decode(paramString);
    if (paramString != null) {
      return new f(paramString);
    }
    return null;
  }
  
  public static f decodeHex(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("hex == null");
    }
    if (paramString.length() % 2 != 0) {
      throw new IllegalArgumentException("Unexpected hex string: " + paramString);
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)((a(paramString.charAt(i * 2)) << 4) + a(paramString.charAt(i * 2 + 1))));
      i += 1;
    }
    return of(arrayOfByte);
  }
  
  public static f encodeString(String paramString, Charset paramCharset)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("s == null");
    }
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    return new f(paramString.getBytes(paramCharset));
  }
  
  public static f encodeUtf8(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("s == null");
    }
    f localf = new f(paramString.getBytes(v.a));
    localf.e = paramString;
    return localf;
  }
  
  public static f of(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      throw new IllegalArgumentException("data == null");
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    return new f(arrayOfByte);
  }
  
  public static f of(byte... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("data == null");
    }
    return new f((byte[])paramVarArgs.clone());
  }
  
  public static f of(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("data == null");
    }
    v.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new f(arrayOfByte);
  }
  
  public static f read(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("byteCount < 0: " + paramInt);
    }
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1) {
        throw new EOFException();
      }
      i += j;
    }
    return new f(arrayOfByte);
  }
  
  void a(c paramc)
  {
    paramc.write(this.c, 0, this.c.length);
  }
  
  byte[] a()
  {
    return this.c;
  }
  
  public ByteBuffer asByteBuffer()
  {
    return ByteBuffer.wrap(this.c).asReadOnlyBuffer();
  }
  
  public String base64()
  {
    return b.encode(this.c);
  }
  
  public String base64Url()
  {
    return b.encodeUrl(this.c);
  }
  
  public int compareTo(f paramf)
  {
    int j = size();
    int k = paramf.size();
    int m = Math.min(j, k);
    int i = 0;
    for (;;)
    {
      if (i < m)
      {
        int n = getByte(i) & 0xFF;
        int i1 = paramf.getByte(i) & 0xFF;
        if (n == i1) {
          i += 1;
        } else {
          if (n >= i1) {
            break;
          }
        }
      }
    }
    do
    {
      return -1;
      return 1;
      if (j == k) {
        return 0;
      }
    } while (j < k);
    return 1;
  }
  
  public final boolean endsWith(f paramf)
  {
    return rangeEquals(size() - paramf.size(), paramf, 0, paramf.size());
  }
  
  public final boolean endsWith(byte[] paramArrayOfByte)
  {
    return rangeEquals(size() - paramArrayOfByte.length, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof f)) && (((f)paramObject).size() == this.c.length) && (((f)paramObject).rangeEquals(0, this.c, 0, this.c.length))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public byte getByte(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public int hashCode()
  {
    int i = this.d;
    if (i != 0) {
      return i;
    }
    i = Arrays.hashCode(this.c);
    this.d = i;
    return i;
  }
  
  public String hex()
  {
    int i = 0;
    char[] arrayOfChar = new char[this.c.length * 2];
    byte[] arrayOfByte = this.c;
    int k = arrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = arrayOfByte[i];
      int n = j + 1;
      arrayOfChar[j] = a[(m >> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = a[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public f hmacSha1(f paramf)
  {
    return a("HmacSHA1", paramf);
  }
  
  public f hmacSha256(f paramf)
  {
    return a("HmacSHA256", paramf);
  }
  
  public f hmacSha512(f paramf)
  {
    return a("HmacSHA512", paramf);
  }
  
  public final int indexOf(f paramf)
  {
    return indexOf(paramf.a(), 0);
  }
  
  public final int indexOf(f paramf, int paramInt)
  {
    return indexOf(paramf.a(), paramInt);
  }
  
  public final int indexOf(byte[] paramArrayOfByte)
  {
    return indexOf(paramArrayOfByte, 0);
  }
  
  public int indexOf(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = Math.max(paramInt, 0);
    int i = this.c.length;
    int j = paramArrayOfByte.length;
    while (paramInt <= i - j)
    {
      if (v.arrayRangeEquals(this.c, paramInt, paramArrayOfByte, 0, paramArrayOfByte.length)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  public final int lastIndexOf(f paramf)
  {
    return lastIndexOf(paramf.a(), size());
  }
  
  public final int lastIndexOf(f paramf, int paramInt)
  {
    return lastIndexOf(paramf.a(), paramInt);
  }
  
  public final int lastIndexOf(byte[] paramArrayOfByte)
  {
    return lastIndexOf(paramArrayOfByte, size());
  }
  
  public int lastIndexOf(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = Math.min(paramInt, this.c.length - paramArrayOfByte.length);
    while (paramInt >= 0)
    {
      if (v.arrayRangeEquals(this.c, paramInt, paramArrayOfByte, 0, paramArrayOfByte.length)) {
        return paramInt;
      }
      paramInt -= 1;
    }
    return -1;
  }
  
  public f md5()
  {
    return a("MD5");
  }
  
  public boolean rangeEquals(int paramInt1, f paramf, int paramInt2, int paramInt3)
  {
    return paramf.rangeEquals(paramInt2, this.c, paramInt1, paramInt3);
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= 0) && (paramInt1 <= this.c.length - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (v.arrayRangeEquals(this.c, paramInt1, paramArrayOfByte, paramInt2, paramInt3));
  }
  
  public f sha1()
  {
    return a("SHA-1");
  }
  
  public f sha256()
  {
    return a("SHA-256");
  }
  
  public f sha512()
  {
    return a("SHA-512");
  }
  
  public int size()
  {
    return this.c.length;
  }
  
  public final boolean startsWith(f paramf)
  {
    return rangeEquals(0, paramf, 0, paramf.size());
  }
  
  public final boolean startsWith(byte[] paramArrayOfByte)
  {
    return rangeEquals(0, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public String string(Charset paramCharset)
  {
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    return new String(this.c, paramCharset);
  }
  
  public f substring(int paramInt)
  {
    return substring(paramInt, this.c.length);
  }
  
  public f substring(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("beginIndex < 0");
    }
    if (paramInt2 > this.c.length) {
      throw new IllegalArgumentException("endIndex > length(" + this.c.length + ")");
    }
    int i = paramInt2 - paramInt1;
    if (i < 0) {
      throw new IllegalArgumentException("endIndex < beginIndex");
    }
    if ((paramInt1 == 0) && (paramInt2 == this.c.length)) {
      return this;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.c, paramInt1, arrayOfByte, 0, i);
    return new f(arrayOfByte);
  }
  
  public f toAsciiLowercase()
  {
    int i = 0;
    int j;
    for (;;)
    {
      localObject = this;
      if (i >= this.c.length) {
        return localObject;
      }
      j = this.c[i];
      if ((j >= 65) && (j <= 90)) {
        break;
      }
      i += 1;
    }
    Object localObject = (byte[])this.c.clone();
    localObject[i] = ((byte)(j + 32));
    i += 1;
    if (i < localObject.length)
    {
      j = localObject[i];
      if ((j < 65) || (j > 90)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject[i] = ((byte)(j + 32));
      }
    }
    localObject = new f((byte[])localObject);
    return (f)localObject;
  }
  
  public f toAsciiUppercase()
  {
    int i = 0;
    int j;
    for (;;)
    {
      localObject = this;
      if (i >= this.c.length) {
        return localObject;
      }
      j = this.c[i];
      if ((j >= 97) && (j <= 122)) {
        break;
      }
      i += 1;
    }
    Object localObject = (byte[])this.c.clone();
    localObject[i] = ((byte)(j - 32));
    i += 1;
    if (i < localObject.length)
    {
      j = localObject[i];
      if ((j < 97) || (j > 122)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject[i] = ((byte)(j - 32));
      }
    }
    localObject = new f((byte[])localObject);
    return (f)localObject;
  }
  
  public byte[] toByteArray()
  {
    return (byte[])this.c.clone();
  }
  
  public String toString()
  {
    if (this.c.length == 0) {
      return "[size=0]";
    }
    String str1 = utf8();
    int i = a(str1, 64);
    if (i == -1)
    {
      if (this.c.length <= 64) {
        return "[hex=" + hex() + "]";
      }
      return "[size=" + this.c.length + " hex=" + substring(0, 64).hex() + "…]";
    }
    String str2 = str1.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
    if (i < str1.length()) {
      return "[size=" + this.c.length + " text=" + str2 + "…]";
    }
    return "[text=" + str2 + "]";
  }
  
  public String utf8()
  {
    String str = this.e;
    if (str != null) {
      return str;
    }
    str = new String(this.c, v.a);
    this.e = str;
    return str;
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    paramOutputStream.write(this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */