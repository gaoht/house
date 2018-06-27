package com.b.a.j;

import com.b.b.j;
import com.b.b.l;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class e
{
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + 2 + paramInt2 * 12;
  }
  
  private static void a(b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, j paramj)
    throws IOException
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i = 0;
    switch (paramInt4)
    {
    default: 
      paramb.error(String.format("Invalid TIFF tag format code %d for tag 0x%04X", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt1) }));
    case 7: 
    case 2: 
    case 10: 
    case 5: 
      do
      {
        do
        {
          return;
          paramb.setByteArray(paramInt1, paramj.getBytes(paramInt2, paramInt3));
          return;
          paramb.setString(paramInt1, paramj.getNullTerminatedString(paramInt2, paramInt3));
          return;
          if (paramInt3 == 1)
          {
            paramb.setRational(paramInt1, new l(paramj.getInt32(paramInt2), paramj.getInt32(paramInt2 + 4)));
            return;
          }
        } while (paramInt3 <= 1);
        localObject = new l[paramInt3];
        paramInt4 = i;
        while (paramInt4 < paramInt3)
        {
          localObject[paramInt4] = new l(paramj.getInt32(paramInt4 * 8 + paramInt2), paramj.getInt32(paramInt2 + 4 + paramInt4 * 8));
          paramInt4 += 1;
        }
        paramb.setRationalArray(paramInt1, (l[])localObject);
        return;
        if (paramInt3 == 1)
        {
          paramb.setRational(paramInt1, new l(paramj.getUInt32(paramInt2), paramj.getUInt32(paramInt2 + 4)));
          return;
        }
      } while (paramInt3 <= 1);
      localObject = new l[paramInt3];
      paramInt4 = j;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = new l(paramj.getUInt32(paramInt4 * 8 + paramInt2), paramj.getUInt32(paramInt2 + 4 + paramInt4 * 8));
        paramInt4 += 1;
      }
      paramb.setRationalArray(paramInt1, (l[])localObject);
      return;
    case 11: 
      if (paramInt3 == 1)
      {
        paramb.setFloat(paramInt1, paramj.getFloat32(paramInt2));
        return;
      }
      localObject = new float[paramInt3];
      paramInt4 = k;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramj.getFloat32(paramInt4 * 4 + paramInt2);
        paramInt4 += 1;
      }
      paramb.setFloatArray(paramInt1, (float[])localObject);
      return;
    case 12: 
      if (paramInt3 == 1)
      {
        paramb.setDouble(paramInt1, paramj.getDouble64(paramInt2));
        return;
      }
      localObject = new double[paramInt3];
      paramInt4 = m;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramj.getDouble64(paramInt4 * 4 + paramInt2);
        paramInt4 += 1;
      }
      paramb.setDoubleArray(paramInt1, (double[])localObject);
      return;
    case 6: 
      if (paramInt3 == 1)
      {
        paramb.setInt8s(paramInt1, paramj.getInt8(paramInt2));
        return;
      }
      localObject = new byte[paramInt3];
      paramInt4 = n;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramj.getInt8(paramInt2 + paramInt4);
        paramInt4 += 1;
      }
      paramb.setInt8sArray(paramInt1, (byte[])localObject);
      return;
    case 1: 
      if (paramInt3 == 1)
      {
        paramb.setInt8u(paramInt1, paramj.getUInt8(paramInt2));
        return;
      }
      localObject = new short[paramInt3];
      paramInt4 = i1;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramj.getUInt8(paramInt2 + paramInt4);
        paramInt4 += 1;
      }
      paramb.setInt8uArray(paramInt1, (short[])localObject);
      return;
    case 8: 
      if (paramInt3 == 1)
      {
        paramb.setInt16s(paramInt1, paramj.getInt16(paramInt2));
        return;
      }
      localObject = new short[paramInt3];
      paramInt4 = i2;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramj.getInt16(paramInt4 * 2 + paramInt2);
        paramInt4 += 1;
      }
      paramb.setInt16sArray(paramInt1, (short[])localObject);
      return;
    case 3: 
      if (paramInt3 == 1)
      {
        paramb.setInt16u(paramInt1, paramj.getUInt16(paramInt2));
        return;
      }
      localObject = new int[paramInt3];
      paramInt4 = i3;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramj.getUInt16(paramInt4 * 2 + paramInt2);
        paramInt4 += 1;
      }
      paramb.setInt16uArray(paramInt1, (int[])localObject);
      return;
    case 9: 
      if (paramInt3 == 1)
      {
        paramb.setInt32s(paramInt1, paramj.getInt32(paramInt2));
        return;
      }
      localObject = new int[paramInt3];
      paramInt4 = i4;
      while (paramInt4 < paramInt3)
      {
        localObject[paramInt4] = paramj.getInt32(paramInt4 * 4 + paramInt2);
        paramInt4 += 1;
      }
      paramb.setInt32sArray(paramInt1, (int[])localObject);
      return;
    }
    if (paramInt3 == 1)
    {
      paramb.setInt32u(paramInt1, paramj.getUInt32(paramInt2));
      return;
    }
    Object localObject = new long[paramInt3];
    paramInt4 = i5;
    while (paramInt4 < paramInt3)
    {
      localObject[paramInt4] = paramj.getUInt32(paramInt4 * 4 + paramInt2);
      paramInt4 += 1;
    }
    paramb.setInt32uArray(paramInt1, (long[])localObject);
  }
  
  public static void processIfd(b paramb, j paramj, Set<Integer> paramSet, int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    label43:
    do
    {
      try
      {
        bool = paramSet.contains(Integer.valueOf(paramInt1));
        if (!bool) {
          break label43;
        }
        paramb.endingIFD();
        if (0 != 0) {
          throw new NullPointerException();
        }
      }
      finally
      {
        try
        {
          do
          {
            int i;
            do
            {
              do
              {
                int k;
                int i2;
                int i3;
                do
                {
                  boolean bool;
                  while (l1 > paramj.getLength())
                  {
                    paramb.error("Illegally sized IFD");
                    paramb.endingIFD();
                    if (localObject1 != null)
                    {
                      paramj.setMotorolaByteOrder(((Boolean)localObject1).booleanValue());
                      return;
                      bool = false;
                    }
                  }
                  i = 0;
                  m = 0;
                  if (m >= k) {
                    break label637;
                  }
                  j = a(paramInt1, m);
                  i2 = paramj.getUInt16(j);
                  i3 = paramj.getUInt16(j + 2);
                  localObject2 = a.fromTiffFormatCode(i3);
                  l3 = paramj.getUInt32(j + 4);
                  if (localObject2 != null) {
                    break label448;
                  }
                  localObject2 = paramb.tryCustomProcessFormat(i2, i3, l3);
                  if (localObject2 != null) {
                    break;
                  }
                  paramb.error(String.format("Invalid TIFF tag format code %d for tag 0x%04X", new Object[] { Integer.valueOf(i3), Integer.valueOf(i2) }));
                  j = i + 1;
                  i = j;
                  if (j <= 5) {
                    break label801;
                  }
                  paramb.error("Stopping processing as too many errors seen in TIFF IFD");
                  paramb.endingIFD();
                } while (localObject1 == null);
                paramj.setMotorolaByteOrder(((Boolean)localObject1).booleanValue());
                return;
                for (l1 = ((Long)localObject2).longValue();; l1 = ((a)localObject2).getComponentSizeBytes() * l3)
                {
                  if (l1 <= 4L) {
                    break label821;
                  }
                  l2 = paramj.getUInt32(j + 8);
                  if (l2 + l1 <= paramj.getLength()) {
                    break label810;
                  }
                  paramb.error("Illegal TIFF tag pointer offset");
                  break;
                }
                if ((l2 < 0L) || (l2 > paramj.getLength()))
                {
                  paramb.error("Illegal TIFF tag pointer offset");
                  break label801;
                }
                if ((l1 >= 0L) && (l2 + l1 <= paramj.getLength())) {
                  break label832;
                }
                paramb.error("Illegal number of bytes for TIFF tag data: " + l1);
                break label801;
                i1 = j;
                if (n < l3)
                {
                  if (!paramb.tryEnterSubIfd(i2)) {
                    break label856;
                  }
                  j = 1;
                  processIfd(paramb, paramj, paramSet, paramj.getInt32((int)(n * 4 + l2)) + paramInt2, paramInt2);
                  break label856;
                }
                if ((i1 != 0) || (paramb.customProcessTag((int)l2, paramSet, paramInt2, paramj, i2, (int)l1))) {
                  break label865;
                }
                a(paramb, i2, (int)l2, (int)l3, i3, paramj);
                break label865;
                i = paramj.getInt32(a(paramInt1, k));
                if (i == 0) {
                  break label747;
                }
                i += paramInt2;
                l2 = i;
                l1 = paramj.getLength();
                if (l2 < l1) {
                  break;
                }
                paramb.endingIFD();
              } while (localObject1 == null);
              paramj.setMotorolaByteOrder(((Boolean)localObject1).booleanValue());
              return;
              if (i >= paramInt1) {
                break;
              }
              paramb.endingIFD();
            } while (localObject1 == null);
            paramj.setMotorolaByteOrder(((Boolean)localObject1).booleanValue());
            return;
            if (paramb.hasFollowerIfd()) {
              processIfd(paramb, paramj, paramSet, i, paramInt2);
            }
            paramb.endingIFD();
          } while (localObject1 == null);
          paramj.setMotorolaByteOrder(((Boolean)localObject1).booleanValue());
          return;
        }
        finally
        {
          for (;;) {}
        }
        paramSet = finally;
        paramb.endingIFD();
        if (localObject1 == null) {
          break label789;
        }
        paramj.setMotorolaByteOrder(((Boolean)localObject1).booleanValue());
      }
      return;
      localObject1 = localObject2;
      paramSet.add(Integer.valueOf(paramInt1));
      localObject1 = localObject2;
      if ((paramInt1 < paramj.getLength()) && (paramInt1 >= 0)) {
        break;
      }
      localObject1 = localObject2;
      paramb.error("Ignored IFD marked to start outside data segment");
      paramb.endingIFD();
    } while (0 == 0);
    throw new NullPointerException();
    localObject1 = localObject2;
    k = paramj.getUInt16(paramInt1);
    if ((k > 255) && ((k & 0xFF) == 0))
    {
      localObject1 = localObject2;
      localObject2 = Boolean.valueOf(paramj.isMotorolaByteOrder());
      localObject1 = localObject2;
      if (!paramj.isMotorolaByteOrder())
      {
        bool = true;
        localObject1 = localObject2;
        paramj.setMotorolaByteOrder(bool);
        k >>= 8;
      }
    }
    long l1;
    int m;
    int j;
    long l3;
    long l2;
    label448:
    label462:
    label539:
    int i1;
    int n;
    label593:
    label637:
    label747:
    label789:
    for (localObject1 = localObject2;; localObject1 = null) {
      l1 = k * 12 + 2 + 4 + paramInt1;
    }
    label801:
    label810:
    label821:
    label832:
    label856:
    label865:
    for (;;)
    {
      m += 1;
      break;
      l2 += paramInt2;
      break label462;
      l2 = j + 8;
      break label462;
      i1 = 0;
      j = 0;
      if (l1 != 4L * l3) {
        break label593;
      }
      n = 0;
      break label539;
      n += 1;
      break label539;
    }
  }
  
  public void processTiff(j paramj, b paramb, int paramInt)
    throws d, IOException
  {
    int i = paramj.getInt16(paramInt);
    if (i == 19789) {
      paramj.setMotorolaByteOrder(true);
    }
    for (;;)
    {
      paramb.setTiffMarker(paramj.getUInt16(paramInt + 2));
      int j = paramj.getInt32(paramInt + 4) + paramInt;
      i = j;
      if (j >= paramj.getLength() - 1L)
      {
        paramb.warn("First IFD offset is beyond the end of the TIFF data segment -- trying default offset");
        i = paramInt + 2 + 2 + 4;
      }
      processIfd(paramb, paramj, new HashSet(), i, paramInt);
      paramb.completed(paramj, paramInt);
      return;
      if (i != 18761) {
        break;
      }
      paramj.setMotorolaByteOrder(false);
    }
    throw new d("Unclear distinction between Motorola/Intel byte ordering: " + i);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/j/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */