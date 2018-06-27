package cn.testin.analysis;

import java.util.EnumMap;
import java.util.Map;

public final class ga
{
  private final String a;
  private final byte[] b;
  private final int c;
  private gc[] d;
  private final fo e;
  private Map<gb, Object> f;
  private final long g;
  
  public ga(String paramString, byte[] paramArrayOfByte, int paramInt, gc[] paramArrayOfgc, fo paramfo, long paramLong)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.c = paramInt;
    this.d = paramArrayOfgc;
    this.e = paramfo;
    this.f = null;
    this.g = paramLong;
  }
  
  public ga(String paramString, byte[] paramArrayOfByte, gc[] paramArrayOfgc, fo paramfo)
  {
    this(paramString, paramArrayOfByte, paramArrayOfgc, paramfo, System.currentTimeMillis());
  }
  
  public ga(String paramString, byte[] paramArrayOfByte, gc[] paramArrayOfgc, fo paramfo, long paramLong) {}
  
  public String a()
  {
    return this.a;
  }
  
  public void a(gb paramgb, Object paramObject)
  {
    if (this.f == null) {
      this.f = new EnumMap(gb.class);
    }
    this.f.put(paramgb, paramObject);
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */