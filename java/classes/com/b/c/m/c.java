package com.b.c.m;

import com.b.b.b;
import com.b.b.j;
import com.b.c.g;
import java.io.IOException;
import java.text.DecimalFormat;

public class c
  extends g<d>
{
  public c(d paramd)
  {
    super(paramd);
  }
  
  private String h(int paramInt)
  {
    byte[] arrayOfByte = ((d)this.a).getByteArray(paramInt);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
      return null;
    }
    if (arrayOfByte[0] == 0) {
      return "No";
    }
    return "Yes";
  }
  
  private String i(int paramInt)
  {
    Object localObject = ((d)this.a).getByteArray(paramInt);
    if (localObject == null) {
      return null;
    }
    localObject = new b((byte[])localObject);
    try
    {
      localObject = String.format("%d", new Object[] { Integer.valueOf(((j)localObject).getInt32(0)) });
      return (String)localObject;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  private String j(int paramInt)
  {
    byte[] arrayOfByte = ((d)this.a).getByteArray(paramInt);
    if (arrayOfByte == null) {
      return null;
    }
    return new String(arrayOfByte);
  }
  
  private String k(int paramInt)
  {
    byte[] arrayOfByte = ((d)this.a).getByteArray(paramInt);
    if (arrayOfByte == null) {
      return null;
    }
    return String.format("%d bytes binary data", new Object[] { Integer.valueOf(arrayOfByte.length) });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 1033: 
    case 1036: 
      return getThumbnailDescription(paramInt);
    case 1002: 
    case 1035: 
      return j(paramInt);
    case 1028: 
      return k(paramInt);
    case 1050: 
      return getSlicesDescription();
    case 1057: 
      return getVersionDescription();
    case 1034: 
      return h(paramInt);
    case 1005: 
      return getResolutionInfoDescription();
    case 1037: 
    case 1044: 
    case 1049: 
    case 1054: 
      return i(paramInt);
    case 1030: 
      return getJpegQualityString();
    case 1062: 
      return getPrintScaleDescription();
    }
    return getPixelAspectRatioString();
  }
  
  public String getJpegQualityString()
  {
    int j;
    int k;
    int i;
    try
    {
      localObject = ((d)this.a).getByteArray(1030);
      if (localObject == null) {
        return ((d)this.a).getString(1030);
      }
      localObject = new b((byte[])localObject);
      j = ((j)localObject).getUInt16(0);
      k = ((j)localObject).getUInt16(2);
      m = ((j)localObject).getUInt16(4);
      if ((j > 65535) || (j < 65533)) {
        break label347;
      }
      i = j - 65532;
    }
    catch (IOException localIOException)
    {
      Object localObject;
      int m;
      label87:
      return null;
    }
    String str2 = String.format("Unknown 0x%04X", new Object[] { Integer.valueOf(k) });
    for (;;)
    {
      if ((m >= 1) && (m <= 3)) {}
      for (String str3 = String.format("%d", new Object[] { Integer.valueOf(m + 2) });; str3 = String.format("Unknown 0x%04X", new Object[] { Integer.valueOf(m) })) {
        return String.format("%d (%s), %s format, %s scans", new Object[] { Integer.valueOf(i), localObject, str2, str3 });
      }
      label196:
      String str1;
      switch (j)
      {
      default: 
        str1 = "Unknown";
      }
      for (;;)
      {
        switch (k)
        {
        default: 
          break label87;
          label347:
          if (j <= 8)
          {
            i = j + 4;
            break label196;
          }
          i = j;
          break label196;
          str1 = "Low";
          continue;
          str1 = "Medium";
          continue;
          str1 = "High";
          continue;
          str1 = "Maximum";
        }
      }
      str2 = "Standard";
      continue;
      str2 = "Optimised";
      continue;
      str2 = "Progressive";
    }
  }
  
  public String getPixelAspectRatioString()
  {
    try
    {
      Object localObject = ((d)this.a).getByteArray(1064);
      if (localObject == null) {
        return null;
      }
      localObject = Double.toString(new b((byte[])localObject).getDouble64(4));
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String getPrintScaleDescription()
  {
    for (;;)
    {
      try
      {
        localObject = ((d)this.a).getByteArray(1062);
        if (localObject == null) {
          return null;
        }
        localObject = new b((byte[])localObject);
        int i = ((j)localObject).getInt32(0);
        f1 = ((j)localObject).getFloat32(2);
        f2 = ((j)localObject).getFloat32(6);
        f3 = ((j)localObject).getFloat32(10);
        switch (i)
        {
        case 0: 
          return String.format("Unknown %04X, X:%s Y:%s, Scale:%s", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        float f1;
        float f2;
        float f3;
        return null;
      }
      return "Centered, Scale " + f3;
      localObject = String.format("User defined, X:%s Y:%s, Scale:%s", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      return (String)localObject;
    }
    return "Size to fit";
  }
  
  public String getResolutionInfoDescription()
  {
    try
    {
      Object localObject = ((d)this.a).getByteArray(1005);
      if (localObject == null) {
        return null;
      }
      localObject = new b((byte[])localObject);
      float f1 = ((j)localObject).getS15Fixed16(0);
      float f2 = ((j)localObject).getS15Fixed16(8);
      localObject = new DecimalFormat("0.##");
      localObject = ((DecimalFormat)localObject).format(f1) + "x" + ((DecimalFormat)localObject).format(f2) + " DPI";
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String getSlicesDescription()
  {
    try
    {
      Object localObject = ((d)this.a).getByteArray(1050);
      if (localObject == null) {
        return null;
      }
      localObject = new b((byte[])localObject);
      int i = ((j)localObject).getInt32(20);
      String str = ((j)localObject).getString(24, i * 2, "UTF-16");
      i = ((j)localObject).getInt32(i * 2 + 24);
      localObject = String.format("%s (%d,%d,%d,%d) %d Slices", new Object[] { str, Integer.valueOf(((j)localObject).getInt32(4)), Integer.valueOf(((j)localObject).getInt32(8)), Integer.valueOf(((j)localObject).getInt32(12)), Integer.valueOf(((j)localObject).getInt32(16)), Integer.valueOf(i) });
      return (String)localObject;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getThumbnailDescription(int paramInt)
  {
    try
    {
      Object localObject = ((d)this.a).getByteArray(paramInt);
      if (localObject == null) {
        return null;
      }
      localObject = new b((byte[])localObject);
      paramInt = ((j)localObject).getInt32(0);
      int i = ((j)localObject).getInt32(4);
      int j = ((j)localObject).getInt32(8);
      int k = ((j)localObject).getInt32(16);
      int m = ((j)localObject).getInt32(20);
      int n = ((j)localObject).getInt32(24);
      if (paramInt == 1) {}
      for (localObject = "JpegRGB";; localObject = "RawRGB") {
        return String.format("%s, %dx%d, Decomp %d bytes, %d bpp, %d bytes", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m) });
      }
      return null;
    }
    catch (IOException localIOException) {}
  }
  
  public String getVersionDescription()
  {
    try
    {
      Object localObject = ((d)this.a).getByteArray(1057);
      if (localObject == null) {
        return null;
      }
      localObject = new b((byte[])localObject);
      int i = ((j)localObject).getInt32(0);
      int j = ((j)localObject).getInt32(5);
      String str = ((j)localObject).getString(9, j * 2, "UTF-16");
      int k = j * 2 + 9;
      j = ((j)localObject).getInt32(k);
      k += 4;
      localObject = String.format("%d (%s, %s) %d", new Object[] { Integer.valueOf(i), str, ((j)localObject).getString(k, j * 2, "UTF-16"), Integer.valueOf(((j)localObject).getInt32(k + j * 2)) });
      return (String)localObject;
    }
    catch (IOException localIOException) {}
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/m/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */