package com.b.a.j;

import com.b.b.j;
import com.b.b.l;
import java.io.IOException;
import java.util.Set;

public abstract interface b
{
  public abstract void completed(j paramj, int paramInt);
  
  public abstract boolean customProcessTag(int paramInt1, Set<Integer> paramSet, int paramInt2, j paramj, int paramInt3, int paramInt4)
    throws IOException;
  
  public abstract void endingIFD();
  
  public abstract void error(String paramString);
  
  public abstract boolean hasFollowerIfd();
  
  public abstract void setByteArray(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void setDouble(int paramInt, double paramDouble);
  
  public abstract void setDoubleArray(int paramInt, double[] paramArrayOfDouble);
  
  public abstract void setFloat(int paramInt, float paramFloat);
  
  public abstract void setFloatArray(int paramInt, float[] paramArrayOfFloat);
  
  public abstract void setInt16s(int paramInt1, int paramInt2);
  
  public abstract void setInt16sArray(int paramInt, short[] paramArrayOfShort);
  
  public abstract void setInt16u(int paramInt1, int paramInt2);
  
  public abstract void setInt16uArray(int paramInt, int[] paramArrayOfInt);
  
  public abstract void setInt32s(int paramInt1, int paramInt2);
  
  public abstract void setInt32sArray(int paramInt, int[] paramArrayOfInt);
  
  public abstract void setInt32u(int paramInt, long paramLong);
  
  public abstract void setInt32uArray(int paramInt, long[] paramArrayOfLong);
  
  public abstract void setInt8s(int paramInt, byte paramByte);
  
  public abstract void setInt8sArray(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void setInt8u(int paramInt, short paramShort);
  
  public abstract void setInt8uArray(int paramInt, short[] paramArrayOfShort);
  
  public abstract void setRational(int paramInt, l paraml);
  
  public abstract void setRationalArray(int paramInt, l[] paramArrayOfl);
  
  public abstract void setString(int paramInt, String paramString);
  
  public abstract void setTiffMarker(int paramInt)
    throws d;
  
  public abstract Long tryCustomProcessFormat(int paramInt1, int paramInt2, long paramLong);
  
  public abstract boolean tryEnterSubIfd(int paramInt);
  
  public abstract void warn(String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/j/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */