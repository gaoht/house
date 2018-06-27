package com.b.c.c;

import com.b.a.j.e;
import com.b.b.m;
import com.b.c.c.a.ab;
import com.b.c.c.a.ad;
import com.b.c.c.a.af;
import com.b.c.c.a.ah;
import com.b.c.c.a.aj;
import com.b.c.c.a.al;
import com.b.c.c.a.h;
import com.b.c.c.a.p;
import com.b.c.c.a.r;
import com.b.c.c.a.t;
import com.b.c.c.a.v;
import com.b.c.c.a.x;
import com.b.c.c.a.z;
import com.b.c.o.a;
import java.io.IOException;
import java.util.Set;

public class l
  extends a
{
  private final boolean c;
  
  public l(com.b.c.d paramd, boolean paramBoolean, com.b.c.b paramb)
  {
    super(paramd, d.class);
    this.c = paramBoolean;
    if (paramb != null) {
      this.a.setParent(paramb);
    }
  }
  
  private static void a(com.b.c.c.a.j paramj, int paramInt, com.b.b.j paramj1)
  {
    paramInt += 8;
    try
    {
      paramj.setString(0, paramj1.getString(paramInt, 8));
      paramj.setInt(9, paramj1.getUInt8(paramInt + 9));
      paramj.setInt(10, paramj1.getUInt8(paramInt + 10));
      paramj.setInt(12, paramj1.getUInt16(paramInt + 12));
      paramj.setInt(14, paramj1.getUInt16(paramInt + 14));
      paramj.setInt(16, paramj1.getUInt16(paramInt + 16));
      paramj.setByteArray(18, paramj1.getBytes(paramInt + 18, 2));
      paramj.setByteArray(20, paramj1.getBytes(paramInt + 20, 4));
      paramj.setInt(24, paramj1.getUInt16(paramInt + 24));
      paramj.setInt(27, paramj1.getUInt8(paramInt + 27));
      paramj.setInt(28, paramj1.getUInt8(paramInt + 28));
      paramj.setInt(29, paramj1.getUInt8(paramInt + 29));
      paramj.setInt(30, paramj1.getUInt16(paramInt + 30));
      paramj.setLong(32, paramj1.getUInt32(paramInt + 32));
      paramj.setInt(36, paramj1.getInt16(paramInt + 36));
      paramj.setInt(56, paramj1.getUInt8(paramInt + 56));
      paramj.setInt(64, paramj1.getUInt8(paramInt + 64));
      paramj.setInt(92, paramj1.getUInt8(paramInt + 92));
      paramj.setInt(93, paramj1.getUInt8(paramInt + 93));
      paramj.setInt(94, paramj1.getUInt16(paramInt + 94));
      paramj.setInt(96, paramj1.getUInt16(paramInt + 96));
      paramj.setInt(98, paramj1.getUInt16(paramInt + 98));
      paramj.setInt(100, paramj1.getUInt16(paramInt + 100));
      paramj.setInt(102, paramj1.getUInt16(paramInt + 102));
      paramj.setInt(104, paramj1.getUInt16(paramInt + 104));
      paramj.setInt(107, paramj1.getInt8(paramInt + 107));
      return;
    }
    catch (IOException paramj1)
    {
      paramj.addError("Error processing Kodak makernote data: " + paramj1.getMessage());
    }
  }
  
  private boolean a(int paramInt1, Set<Integer> paramSet, int paramInt2, com.b.b.j paramj)
    throws IOException
  {
    com.b.c.b localb = this.b.getFirstDirectoryOfType(d.class);
    if (localb == null) {
      return false;
    }
    String str1 = localb.getString(271);
    String str2 = paramj.getString(paramInt1, 2);
    String str3 = paramj.getString(paramInt1, 3);
    String str4 = paramj.getString(paramInt1, 4);
    String str5 = paramj.getString(paramInt1, 5);
    String str6 = paramj.getString(paramInt1, 6);
    String str7 = paramj.getString(paramInt1, 7);
    String str8 = paramj.getString(paramInt1, 8);
    String str9 = paramj.getString(paramInt1, 10);
    String str10 = paramj.getString(paramInt1, 12);
    boolean bool = paramj.isMotorolaByteOrder();
    if (("OLYMP\000".equals(str6)) || ("EPSON".equals(str5)) || ("AGFA".equals(str4)))
    {
      a(x.class);
      e.processIfd(this, paramj, paramSet, paramInt1 + 8, paramInt2);
    }
    for (;;)
    {
      paramj.setMotorolaByteOrder(bool);
      return true;
      if ("OLYMPUS\000II".equals(str9))
      {
        a(x.class);
        e.processIfd(this, paramj, paramSet, paramInt1 + 12, paramInt1);
      }
      else if ((str1 != null) && (str1.toUpperCase().startsWith("MINOLTA")))
      {
        a(x.class);
        e.processIfd(this, paramj, paramSet, paramInt1, paramInt2);
      }
      else if ((str1 != null) && (str1.trim().toUpperCase().startsWith("NIKON")))
      {
        if ("Nikon".equals(str5))
        {
          switch (paramj.getUInt8(paramInt1 + 6))
          {
          default: 
            localb.addError("Unsupported Nikon makernote data ignored.");
            break;
          case 1: 
            a(p.class);
            e.processIfd(this, paramj, paramSet, paramInt1 + 8, paramInt2);
            break;
          case 2: 
            a(r.class);
            e.processIfd(this, paramj, paramSet, paramInt1 + 18, paramInt1 + 10);
            break;
          }
        }
        else
        {
          a(r.class);
          e.processIfd(this, paramj, paramSet, paramInt1, paramInt2);
        }
      }
      else if (("SONY CAM".equals(str8)) || ("SONY DSC".equals(str8)))
      {
        a(aj.class);
        e.processIfd(this, paramj, paramSet, paramInt1 + 12, paramInt2);
      }
      else if ("SEMC MS\000\000\000\000\000".equals(str10))
      {
        paramj.setMotorolaByteOrder(true);
        a(al.class);
        e.processIfd(this, paramj, paramSet, paramInt1 + 20, paramInt2);
      }
      else if (("SIGMA\000\000\000".equals(str8)) || ("FOVEON\000\000".equals(str8)))
      {
        a(ah.class);
        e.processIfd(this, paramj, paramSet, paramInt1 + 10, paramInt2);
      }
      else if ("KDK".equals(str3))
      {
        paramj.setMotorolaByteOrder(str7.equals("KDK INFO"));
        paramSet = new com.b.c.c.a.j();
        this.b.addDirectory(paramSet);
        a(paramSet, paramInt1, paramj);
      }
      else if ("Canon".equalsIgnoreCase(str1))
      {
        a(com.b.c.c.a.b.class);
        e.processIfd(this, paramj, paramSet, paramInt1, paramInt2);
      }
      else if ((str1 != null) && (str1.toUpperCase().startsWith("CASIO")))
      {
        if ("QVC\000\000\000".equals(str6))
        {
          a(com.b.c.c.a.f.class);
          e.processIfd(this, paramj, paramSet, paramInt1 + 6, paramInt2);
        }
        else
        {
          a(com.b.c.c.a.d.class);
          e.processIfd(this, paramj, paramSet, paramInt1, paramInt2);
        }
      }
      else if (("FUJIFILM".equals(str8)) || ("Fujifilm".equalsIgnoreCase(str1)))
      {
        paramj.setMotorolaByteOrder(false);
        paramInt2 = paramj.getInt32(paramInt1 + 8);
        a(h.class);
        e.processIfd(this, paramj, paramSet, paramInt2 + paramInt1, paramInt1);
      }
      else if ("KYOCERA".equals(str7))
      {
        a(com.b.c.c.a.l.class);
        e.processIfd(this, paramj, paramSet, paramInt1 + 22, paramInt2);
      }
      else if ("LEICA".equals(str5))
      {
        paramj.setMotorolaByteOrder(false);
        if ("Leica Camera AG".equals(str1))
        {
          a(com.b.c.c.a.n.class);
          e.processIfd(this, paramj, paramSet, paramInt1 + 8, paramInt2);
        }
        else if ("LEICA".equals(str1))
        {
          a(z.class);
          e.processIfd(this, paramj, paramSet, paramInt1 + 8, paramInt2);
        }
        else
        {
          return false;
        }
      }
      else if ("Panasonic\000\000\000".equals(paramj.getString(paramInt1, 12)))
      {
        a(z.class);
        e.processIfd(this, paramj, paramSet, paramInt1 + 12, paramInt2);
      }
      else if ("AOC\000".equals(str4))
      {
        a(com.b.c.c.a.f.class);
        e.processIfd(this, paramj, paramSet, paramInt1 + 6, paramInt1);
      }
      else if ((str1 != null) && ((str1.toUpperCase().startsWith("PENTAX")) || (str1.toUpperCase().startsWith("ASAHI"))))
      {
        a(ab.class);
        e.processIfd(this, paramj, paramSet, paramInt1, paramInt1);
      }
      else if ("SANYO\000\001\000".equals(str8))
      {
        a(af.class);
        e.processIfd(this, paramj, paramSet, paramInt1 + 8, paramInt1);
      }
      else
      {
        if ((str1 == null) || (!str1.toLowerCase().startsWith("ricoh"))) {
          break;
        }
        if ((str2.equals("Rv")) || (str3.equals("Rev"))) {
          return false;
        }
        if (str5.equalsIgnoreCase("Ricoh"))
        {
          paramj.setMotorolaByteOrder(true);
          a(ad.class);
          e.processIfd(this, paramj, paramSet, paramInt1 + 8, paramInt1);
        }
      }
    }
    return false;
  }
  
  public void completed(com.b.b.j paramj, int paramInt)
  {
    k localk;
    Integer localInteger1;
    Integer localInteger2;
    if (this.c)
    {
      localk = (k)this.b.getFirstDirectoryOfType(k.class);
      if ((localk != null) && (localk.containsTag(259)))
      {
        localInteger1 = localk.getInteger(513);
        localInteger2 = localk.getInteger(514);
        if ((localInteger1 == null) || (localInteger2 == null)) {}
      }
    }
    try
    {
      localk.setThumbnailData(paramj.getBytes(localInteger1.intValue() + paramInt, localInteger2.intValue()));
      return;
    }
    catch (IOException paramj)
    {
      localk.addError("Invalid thumbnail data specification: " + paramj.getMessage());
    }
  }
  
  public boolean customProcessTag(int paramInt1, Set<Integer> paramSet, int paramInt2, com.b.b.j paramj, int paramInt3, int paramInt4)
    throws IOException
  {
    if ((paramInt3 == 37500) && ((this.a instanceof i))) {
      return a(paramInt1, paramSet, paramInt2, paramj);
    }
    if ((paramInt3 == 33723) && ((this.a instanceof d)))
    {
      if (paramj.getInt8(paramInt1) == 28)
      {
        paramSet = paramj.getBytes(paramInt1, paramInt4);
        new com.b.c.h.c().extract(new m(paramSet), this.b, paramSet.length, this.a);
        return true;
      }
      return false;
    }
    if ((paramInt3 == 700) && ((this.a instanceof d)))
    {
      new com.b.c.q.c().extract(paramj.getNullTerminatedString(paramInt1, paramInt4), this.b, this.a);
      return true;
    }
    return false;
  }
  
  public boolean hasFollowerIfd()
  {
    if ((this.a instanceof d)) {
      a(k.class);
    }
    while ((this.a instanceof k)) {
      return true;
    }
    return false;
  }
  
  public void setTiffMarker(int paramInt)
    throws com.b.a.j.d
  {
    if ((paramInt != 42) && (paramInt != 20306) && (paramInt != 21330) && (paramInt != 85)) {
      throw new com.b.a.j.d("Unexpected TIFF marker: 0x" + Integer.toHexString(paramInt));
    }
  }
  
  public Long tryCustomProcessFormat(int paramInt1, int paramInt2, long paramLong)
  {
    if (paramInt2 == 13) {
      return Long.valueOf(4L * paramLong);
    }
    return null;
  }
  
  public boolean tryEnterSubIfd(int paramInt)
  {
    if (paramInt == 330)
    {
      a(i.class);
      return true;
    }
    if ((this.a instanceof d))
    {
      if (paramInt == 34665)
      {
        a(i.class);
        return true;
      }
      if (paramInt == 34853)
      {
        a(n.class);
        return true;
      }
    }
    if (((this.a instanceof i)) && (paramInt == 40965))
    {
      a(f.class);
      return true;
    }
    if ((this.a instanceof x))
    {
      if (paramInt == 8208)
      {
        a(v.class);
        return true;
      }
      if (paramInt == 8224)
      {
        a(t.class);
        return true;
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */