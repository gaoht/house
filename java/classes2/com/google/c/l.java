package com.google.c;

import java.util.EnumMap;
import java.util.Map;

public final class l
{
  private final String a;
  private final byte[] b;
  private n[] c;
  private final a d;
  private Map<m, Object> e;
  private final long f;
  
  public l(String paramString, byte[] paramArrayOfByte, n[] paramArrayOfn, a parama)
  {
    this(paramString, paramArrayOfByte, paramArrayOfn, parama, System.currentTimeMillis());
  }
  
  public l(String paramString, byte[] paramArrayOfByte, n[] paramArrayOfn, a parama, long paramLong)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.c = paramArrayOfn;
    this.d = parama;
    this.e = null;
    this.f = paramLong;
  }
  
  public void addResultPoints(n[] paramArrayOfn)
  {
    n[] arrayOfn1 = this.c;
    if (arrayOfn1 == null) {
      this.c = paramArrayOfn;
    }
    while ((paramArrayOfn == null) || (paramArrayOfn.length <= 0)) {
      return;
    }
    n[] arrayOfn2 = new n[arrayOfn1.length + paramArrayOfn.length];
    System.arraycopy(arrayOfn1, 0, arrayOfn2, 0, arrayOfn1.length);
    System.arraycopy(paramArrayOfn, 0, arrayOfn2, arrayOfn1.length, paramArrayOfn.length);
    this.c = arrayOfn2;
  }
  
  public a getBarcodeFormat()
  {
    return this.d;
  }
  
  public byte[] getRawBytes()
  {
    return this.b;
  }
  
  public Map<m, Object> getResultMetadata()
  {
    return this.e;
  }
  
  public n[] getResultPoints()
  {
    return this.c;
  }
  
  public String getText()
  {
    return this.a;
  }
  
  public long getTimestamp()
  {
    return this.f;
  }
  
  public void putAllMetadata(Map<m, Object> paramMap)
  {
    if (paramMap != null)
    {
      if (this.e == null) {
        this.e = paramMap;
      }
    }
    else {
      return;
    }
    this.e.putAll(paramMap);
  }
  
  public void putMetadata(m paramm, Object paramObject)
  {
    if (this.e == null) {
      this.e = new EnumMap(m.class);
    }
    this.e.put(paramm, paramObject);
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */