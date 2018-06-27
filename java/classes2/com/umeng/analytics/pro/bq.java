package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class bq
  implements cg<bq, e>, Serializable, Cloneable
{
  private static final int A = 2;
  private static final int B = 3;
  public static final Map<e, cs> k;
  private static final long l = 420342210744516016L;
  private static final dk m = new dk("UMEnvelope");
  private static final da n = new da("version", (byte)11, (short)1);
  private static final da o = new da("address", (byte)11, (short)2);
  private static final da p = new da("signature", (byte)11, (short)3);
  private static final da q = new da("serial_num", (byte)8, (short)4);
  private static final da r = new da("ts_secs", (byte)8, (short)5);
  private static final da s = new da("length", (byte)8, (short)6);
  private static final da t = new da("entity", (byte)11, (short)7);
  private static final da u = new da("guid", (byte)11, (short)8);
  private static final da v = new da("checksum", (byte)11, (short)9);
  private static final da w = new da("codex", (byte)8, (short)10);
  private static final Map<Class<? extends dn>, do> x = new HashMap();
  private static final int y = 0;
  private static final int z = 1;
  private byte C = 0;
  private e[] D = { e.j };
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  public int f;
  public ByteBuffer g;
  public String h;
  public String i;
  public int j;
  
  static
  {
    x.put(dp.class, new b(null));
    x.put(dq.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cs("version", (byte)1, new ct((byte)11)));
    localEnumMap.put(e.b, new cs("address", (byte)1, new ct((byte)11)));
    localEnumMap.put(e.c, new cs("signature", (byte)1, new ct((byte)11)));
    localEnumMap.put(e.d, new cs("serial_num", (byte)1, new ct((byte)8)));
    localEnumMap.put(e.e, new cs("ts_secs", (byte)1, new ct((byte)8)));
    localEnumMap.put(e.f, new cs("length", (byte)1, new ct((byte)8)));
    localEnumMap.put(e.g, new cs("entity", (byte)1, new ct((byte)11, true)));
    localEnumMap.put(e.h, new cs("guid", (byte)1, new ct((byte)11)));
    localEnumMap.put(e.i, new cs("checksum", (byte)1, new ct((byte)11)));
    localEnumMap.put(e.j, new cs("codex", (byte)2, new ct((byte)8)));
    k = Collections.unmodifiableMap(localEnumMap);
    cs.a(bq.class, k);
  }
  
  public bq() {}
  
  public bq(bq parambq)
  {
    this.C = parambq.C;
    if (parambq.e()) {
      this.a = parambq.a;
    }
    if (parambq.h()) {
      this.b = parambq.b;
    }
    if (parambq.k()) {
      this.c = parambq.c;
    }
    this.d = parambq.d;
    this.e = parambq.e;
    this.f = parambq.f;
    if (parambq.y()) {
      this.g = ch.d(parambq.g);
    }
    if (parambq.B()) {
      this.h = parambq.h;
    }
    if (parambq.E()) {
      this.i = parambq.i;
    }
    this.j = parambq.j;
  }
  
  public bq(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer, String paramString4, String paramString5)
  {
    this();
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramInt1;
    d(true);
    this.e = paramInt2;
    e(true);
    this.f = paramInt3;
    f(true);
    this.g = paramByteBuffer;
    this.h = paramString4;
    this.i = paramString5;
  }
  
  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.C = 0;
      a(new cz(new dr(paramObjectInputStream)));
      return;
    }
    catch (cm paramObjectInputStream)
    {
      throw new IOException(paramObjectInputStream.getMessage());
    }
  }
  
  private void a(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    try
    {
      b(new cz(new dr(paramObjectOutputStream)));
      return;
    }
    catch (cm paramObjectOutputStream)
    {
      throw new IOException(paramObjectOutputStream.getMessage());
    }
  }
  
  public void A()
  {
    this.h = null;
  }
  
  public boolean B()
  {
    return this.h != null;
  }
  
  public String C()
  {
    return this.i;
  }
  
  public void D()
  {
    this.i = null;
  }
  
  public boolean E()
  {
    return this.i != null;
  }
  
  public int F()
  {
    return this.j;
  }
  
  public void G()
  {
    this.C = cd.b(this.C, 3);
  }
  
  public boolean H()
  {
    return cd.a(this.C, 3);
  }
  
  public void I()
    throws cm
  {
    if (this.a == null) {
      throw new dg("Required field 'version' was not present! Struct: " + toString());
    }
    if (this.b == null) {
      throw new dg("Required field 'address' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new dg("Required field 'signature' was not present! Struct: " + toString());
    }
    if (this.g == null) {
      throw new dg("Required field 'entity' was not present! Struct: " + toString());
    }
    if (this.h == null) {
      throw new dg("Required field 'guid' was not present! Struct: " + toString());
    }
    if (this.i == null) {
      throw new dg("Required field 'checksum' was not present! Struct: " + toString());
    }
  }
  
  public bq a()
  {
    return new bq(this);
  }
  
  public bq a(int paramInt)
  {
    this.d = paramInt;
    d(true);
    return this;
  }
  
  public bq a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public bq a(ByteBuffer paramByteBuffer)
  {
    this.g = paramByteBuffer;
    return this;
  }
  
  public bq a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (paramArrayOfByte = (ByteBuffer)null;; paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte))
    {
      a(paramArrayOfByte);
      return this;
    }
  }
  
  public void a(df paramdf)
    throws cm
  {
    ((do)x.get(paramdf.D())).b().b(paramdf, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public bq b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void b()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    d(false);
    this.d = 0;
    e(false);
    this.e = 0;
    f(false);
    this.f = 0;
    this.g = null;
    this.h = null;
    this.i = null;
    j(false);
    this.j = 0;
  }
  
  public void b(df paramdf)
    throws cm
  {
    ((do)x.get(paramdf.D())).b().a(paramdf, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public bq c(int paramInt)
  {
    this.e = paramInt;
    e(true);
    return this;
  }
  
  public bq c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public bq d(int paramInt)
  {
    this.f = paramInt;
    f(true);
    return this;
  }
  
  public bq d(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public void d()
  {
    this.a = null;
  }
  
  public void d(boolean paramBoolean)
  {
    this.C = cd.a(this.C, 0, paramBoolean);
  }
  
  public bq e(int paramInt)
  {
    this.j = paramInt;
    j(true);
    return this;
  }
  
  public bq e(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public void e(boolean paramBoolean)
  {
    this.C = cd.a(this.C, 1, paramBoolean);
  }
  
  public boolean e()
  {
    return this.a != null;
  }
  
  public e f(int paramInt)
  {
    return e.a(paramInt);
  }
  
  public String f()
  {
    return this.b;
  }
  
  public void f(boolean paramBoolean)
  {
    this.C = cd.a(this.C, 2, paramBoolean);
  }
  
  public void g()
  {
    this.b = null;
  }
  
  public void g(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.g = null;
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.h = null;
    }
  }
  
  public boolean h()
  {
    return this.b != null;
  }
  
  public String i()
  {
    return this.c;
  }
  
  public void i(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.i = null;
    }
  }
  
  public void j()
  {
    this.c = null;
  }
  
  public void j(boolean paramBoolean)
  {
    this.C = cd.a(this.C, 3, paramBoolean);
  }
  
  public boolean k()
  {
    return this.c != null;
  }
  
  public int l()
  {
    return this.d;
  }
  
  public void m()
  {
    this.C = cd.b(this.C, 0);
  }
  
  public boolean n()
  {
    return cd.a(this.C, 0);
  }
  
  public int o()
  {
    return this.e;
  }
  
  public void q()
  {
    this.C = cd.b(this.C, 1);
  }
  
  public boolean r()
  {
    return cd.a(this.C, 1);
  }
  
  public int s()
  {
    return this.f;
  }
  
  public void t()
  {
    this.C = cd.b(this.C, 2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("UMEnvelope(");
    localStringBuilder.append("version:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("address:");
      if (this.b != null) {
        break label321;
      }
      localStringBuilder.append("null");
      label65:
      localStringBuilder.append(", ");
      localStringBuilder.append("signature:");
      if (this.c != null) {
        break label333;
      }
      localStringBuilder.append("null");
      label96:
      localStringBuilder.append(", ");
      localStringBuilder.append("serial_num:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", ");
      localStringBuilder.append("ts_secs:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", ");
      localStringBuilder.append("length:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", ");
      localStringBuilder.append("entity:");
      if (this.g != null) {
        break label345;
      }
      localStringBuilder.append("null");
      label202:
      localStringBuilder.append(", ");
      localStringBuilder.append("guid:");
      if (this.h != null) {
        break label356;
      }
      localStringBuilder.append("null");
      label233:
      localStringBuilder.append(", ");
      localStringBuilder.append("checksum:");
      if (this.i != null) {
        break label368;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      if (H())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("codex:");
        localStringBuilder.append(this.j);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label321:
      localStringBuilder.append(this.b);
      break label65;
      label333:
      localStringBuilder.append(this.c);
      break label96;
      label345:
      ch.a(this.g, localStringBuilder);
      break label202;
      label356:
      localStringBuilder.append(this.h);
      break label233;
      label368:
      localStringBuilder.append(this.i);
    }
  }
  
  public boolean u()
  {
    return cd.a(this.C, 2);
  }
  
  public byte[] v()
  {
    a(ch.c(this.g));
    if (this.g == null) {
      return null;
    }
    return this.g.array();
  }
  
  public ByteBuffer w()
  {
    return this.g;
  }
  
  public void x()
  {
    this.g = null;
  }
  
  public boolean y()
  {
    return this.g != null;
  }
  
  public String z()
  {
    return this.h;
  }
  
  private static class a
    extends dp<bq>
  {
    public void a(df paramdf, bq parambq)
      throws cm
    {
      paramdf.j();
      da localda = paramdf.l();
      if (localda.b == 0)
      {
        paramdf.k();
        if (!parambq.n()) {
          throw new dg("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
        }
      }
      else
      {
        switch (localda.c)
        {
        default: 
          di.a(paramdf, localda.b);
        }
        for (;;)
        {
          paramdf.m();
          break;
          if (localda.b == 11)
          {
            parambq.a = paramdf.z();
            parambq.a(true);
          }
          else
          {
            di.a(paramdf, localda.b);
            continue;
            if (localda.b == 11)
            {
              parambq.b = paramdf.z();
              parambq.b(true);
            }
            else
            {
              di.a(paramdf, localda.b);
              continue;
              if (localda.b == 11)
              {
                parambq.c = paramdf.z();
                parambq.c(true);
              }
              else
              {
                di.a(paramdf, localda.b);
                continue;
                if (localda.b == 8)
                {
                  parambq.d = paramdf.w();
                  parambq.d(true);
                }
                else
                {
                  di.a(paramdf, localda.b);
                  continue;
                  if (localda.b == 8)
                  {
                    parambq.e = paramdf.w();
                    parambq.e(true);
                  }
                  else
                  {
                    di.a(paramdf, localda.b);
                    continue;
                    if (localda.b == 8)
                    {
                      parambq.f = paramdf.w();
                      parambq.f(true);
                    }
                    else
                    {
                      di.a(paramdf, localda.b);
                      continue;
                      if (localda.b == 11)
                      {
                        parambq.g = paramdf.A();
                        parambq.g(true);
                      }
                      else
                      {
                        di.a(paramdf, localda.b);
                        continue;
                        if (localda.b == 11)
                        {
                          parambq.h = paramdf.z();
                          parambq.h(true);
                        }
                        else
                        {
                          di.a(paramdf, localda.b);
                          continue;
                          if (localda.b == 11)
                          {
                            parambq.i = paramdf.z();
                            parambq.i(true);
                          }
                          else
                          {
                            di.a(paramdf, localda.b);
                            continue;
                            if (localda.b == 8)
                            {
                              parambq.j = paramdf.w();
                              parambq.j(true);
                            }
                            else
                            {
                              di.a(paramdf, localda.b);
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (!parambq.r()) {
        throw new dg("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
      }
      if (!parambq.u()) {
        throw new dg("Required field 'length' was not found in serialized data! Struct: " + toString());
      }
      parambq.I();
    }
    
    public void b(df paramdf, bq parambq)
      throws cm
    {
      parambq.I();
      paramdf.a(bq.J());
      if (parambq.a != null)
      {
        paramdf.a(bq.K());
        paramdf.a(parambq.a);
        paramdf.c();
      }
      if (parambq.b != null)
      {
        paramdf.a(bq.L());
        paramdf.a(parambq.b);
        paramdf.c();
      }
      if (parambq.c != null)
      {
        paramdf.a(bq.M());
        paramdf.a(parambq.c);
        paramdf.c();
      }
      paramdf.a(bq.N());
      paramdf.a(parambq.d);
      paramdf.c();
      paramdf.a(bq.O());
      paramdf.a(parambq.e);
      paramdf.c();
      paramdf.a(bq.P());
      paramdf.a(parambq.f);
      paramdf.c();
      if (parambq.g != null)
      {
        paramdf.a(bq.Q());
        paramdf.a(parambq.g);
        paramdf.c();
      }
      if (parambq.h != null)
      {
        paramdf.a(bq.R());
        paramdf.a(parambq.h);
        paramdf.c();
      }
      if (parambq.i != null)
      {
        paramdf.a(bq.S());
        paramdf.a(parambq.i);
        paramdf.c();
      }
      if (parambq.H())
      {
        paramdf.a(bq.T());
        paramdf.a(parambq.j);
        paramdf.c();
      }
      paramdf.d();
      paramdf.b();
    }
  }
  
  private static class b
    implements do
  {
    public bq.a a()
    {
      return new bq.a(null);
    }
  }
  
  private static class c
    extends dq<bq>
  {
    public void a(df paramdf, bq parambq)
      throws cm
    {
      paramdf = (dl)paramdf;
      paramdf.a(parambq.a);
      paramdf.a(parambq.b);
      paramdf.a(parambq.c);
      paramdf.a(parambq.d);
      paramdf.a(parambq.e);
      paramdf.a(parambq.f);
      paramdf.a(parambq.g);
      paramdf.a(parambq.h);
      paramdf.a(parambq.i);
      BitSet localBitSet = new BitSet();
      if (parambq.H()) {
        localBitSet.set(0);
      }
      paramdf.a(localBitSet, 1);
      if (parambq.H()) {
        paramdf.a(parambq.j);
      }
    }
    
    public void b(df paramdf, bq parambq)
      throws cm
    {
      paramdf = (dl)paramdf;
      parambq.a = paramdf.z();
      parambq.a(true);
      parambq.b = paramdf.z();
      parambq.b(true);
      parambq.c = paramdf.z();
      parambq.c(true);
      parambq.d = paramdf.w();
      parambq.d(true);
      parambq.e = paramdf.w();
      parambq.e(true);
      parambq.f = paramdf.w();
      parambq.f(true);
      parambq.g = paramdf.A();
      parambq.g(true);
      parambq.h = paramdf.z();
      parambq.h(true);
      parambq.i = paramdf.z();
      parambq.i(true);
      if (paramdf.b(1).get(0))
      {
        parambq.j = paramdf.w();
        parambq.j(true);
      }
    }
  }
  
  private static class d
    implements do
  {
    public bq.c a()
    {
      return new bq.c(null);
    }
  }
  
  public static enum e
    implements cn
  {
    private static final Map<String, e> k;
    private final short l;
    private final String m;
    
    static
    {
      k = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        k.put(locale.b(), locale);
      }
    }
    
    private e(short paramShort, String paramString)
    {
      this.l = paramShort;
      this.m = paramString;
    }
    
    public static e a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return a;
      case 2: 
        return b;
      case 3: 
        return c;
      case 4: 
        return d;
      case 5: 
        return e;
      case 6: 
        return f;
      case 7: 
        return g;
      case 8: 
        return h;
      case 9: 
        return i;
      }
      return j;
    }
    
    public static e a(String paramString)
    {
      return (e)k.get(paramString);
    }
    
    public static e b(int paramInt)
    {
      e locale = a(paramInt);
      if (locale == null) {
        throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
      }
      return locale;
    }
    
    public short a()
    {
      return this.l;
    }
    
    public String b()
    {
      return this.m;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */