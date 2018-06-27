package com.b.c.q;

import com.a.a.e;
import com.b.b.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class c
  implements com.b.a.d.d
{
  private static void a(e parame, b paramb, int paramInt1, int paramInt2)
    throws com.a.a.c
  {
    int i = 1;
    String str2 = (String)b.g.get(Integer.valueOf(paramInt1));
    String str1 = (String)b.h.get(Integer.valueOf(paramInt1));
    Object localObject = parame.getPropertyString(str2, str1);
    if (localObject == null) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      paramb.addError(String.format("Unknown format code %d for tag %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
      return;
    case 2: 
      parame = ((String)localObject).split("/", 2);
      if (parame.length == 2) {
        try
        {
          paramb.setRational(paramInt1, new l(Float.parseFloat(parame[0]), Float.parseFloat(parame[1])));
          return;
        }
        catch (NumberFormatException parame)
        {
          paramb.addError(String.format("Unable to parse XMP property %s as a Rational.", new Object[] { str1 }));
          return;
        }
      }
      paramb.addError("Error in rational format for tag " + paramInt1);
      return;
    case 3: 
      try
      {
        paramb.setInt(paramInt1, Integer.valueOf((String)localObject).intValue());
        return;
      }
      catch (NumberFormatException parame)
      {
        paramb.addError(String.format("Unable to parse XMP property %s as an int.", new Object[] { str1 }));
        return;
      }
    case 4: 
      try
      {
        paramb.setDouble(paramInt1, Double.valueOf((String)localObject).doubleValue());
        return;
      }
      catch (NumberFormatException parame)
      {
        paramb.addError(String.format("Unable to parse XMP property %s as an double.", new Object[] { str1 }));
        return;
      }
    case 1: 
      paramb.setString(paramInt1, (String)localObject);
      return;
    }
    int j = parame.countArrayItems(str2, str1);
    localObject = new String[j];
    paramInt2 = i;
    while (paramInt2 <= j)
    {
      localObject[(paramInt2 - 1)] = parame.getArrayItem(str2, str1, paramInt2).getValue();
      paramInt2 += 1;
    }
    paramb.setStringArray(paramInt1, (String[])localObject);
  }
  
  private static void a(b paramb, e parame)
    throws com.a.a.c
  {
    paramb.setXMPMeta(parame);
    a(parame, paramb, 6, 1);
    a(parame, paramb, 7, 1);
    a(parame, paramb, 8, 1);
    a(parame, paramb, 9, 1);
    a(parame, paramb, 1, 1);
    a(parame, paramb, 2, 1);
    a(parame, paramb, 3, 1);
    a(parame, paramb, 12, 3);
    a(parame, paramb, 11, 2);
    a(parame, paramb, 5, 2);
    a(parame, paramb, 10, 2);
    a(parame, paramb, 4, 2);
    a(parame, paramb, 13, 1);
    a(parame, paramb, 14, 1);
    a(parame, paramb, 513, 1);
    a(parame, paramb, 514, 1);
    a(parame, paramb, 515, 1);
    a(parame, paramb, 516, 1);
    a(parame, paramb, 517, 1);
    a(parame, paramb, 518, 1);
    a(parame, paramb, 519, 1);
    a(parame, paramb, 4097, 4);
    a(parame, paramb, 8192, 1);
    a(parame, paramb, b.e, 5);
    parame = parame.iterator();
    while (parame.hasNext())
    {
      Object localObject = (com.a.a.c.c)parame.next();
      String str = ((com.a.a.c.c)localObject).getPath();
      localObject = ((com.a.a.c.c)localObject).getValue();
      if ((str != null) && (localObject != null)) {
        paramb.a(str, (String)localObject);
      }
    }
  }
  
  public void extract(String paramString, com.b.c.d paramd)
  {
    extract(paramString, paramd, null);
  }
  
  public void extract(String paramString, com.b.c.d paramd, com.b.c.b paramb)
  {
    b localb = new b();
    if (paramb != null) {
      localb.setParent(paramb);
    }
    try
    {
      a(localb, com.a.a.f.parseFromString(paramString));
      if (!localb.isEmpty()) {
        paramd.addDirectory(localb);
      }
      return;
    }
    catch (com.a.a.c paramString)
    {
      for (;;)
      {
        localb.addError("Error processing XMP data: " + paramString.getMessage());
      }
    }
  }
  
  public void extract(byte[] paramArrayOfByte, com.b.c.d paramd)
  {
    extract(paramArrayOfByte, paramd, null);
  }
  
  public void extract(byte[] paramArrayOfByte, com.b.c.d paramd, com.b.c.b paramb)
  {
    b localb = new b();
    if (paramb != null) {
      localb.setParent(paramb);
    }
    try
    {
      a(localb, com.a.a.f.parseFromBuffer(paramArrayOfByte));
      if (!localb.isEmpty()) {
        paramd.addDirectory(localb);
      }
      return;
    }
    catch (com.a.a.c paramArrayOfByte)
    {
      for (;;)
      {
        localb.addError("Error processing XMP data: " + paramArrayOfByte.getMessage());
      }
    }
  }
  
  public Iterable<com.b.a.d.f> getSegmentTypes()
  {
    return Collections.singletonList(com.b.a.d.f.b);
  }
  
  public void readJpegSegments(Iterable<byte[]> paramIterable, com.b.c.d paramd, com.b.a.d.f paramf)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramf = (byte[])paramIterable.next();
      int i = "http://ns.adobe.com/xap/1.0/\000".length();
      if ((paramf.length >= i) && (("http://ns.adobe.com/xap/1.0/\000".equalsIgnoreCase(new String(paramf, 0, i))) || ("XMP".equalsIgnoreCase(new String(paramf, 0, 3)))))
      {
        byte[] arrayOfByte = new byte[paramf.length - i];
        System.arraycopy(paramf, i, arrayOfByte, 0, arrayOfByte.length);
        extract(arrayOfByte, paramd);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/q/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */