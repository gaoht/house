package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class w
  implements Serializable, Cloneable, a<w, a>
{
  private static final org.apache.thrift.protocol.b A;
  private static final org.apache.thrift.protocol.b B;
  private static final org.apache.thrift.protocol.b C;
  private static final org.apache.thrift.protocol.b D;
  private static final org.apache.thrift.protocol.b E;
  private static final org.apache.thrift.protocol.b F;
  private static final org.apache.thrift.protocol.b G;
  private static final org.apache.thrift.protocol.b H;
  private static final org.apache.thrift.protocol.b I;
  private static final org.apache.thrift.protocol.b J;
  private static final org.apache.thrift.protocol.b K;
  private static final org.apache.thrift.protocol.b L;
  private static final org.apache.thrift.protocol.b M;
  private static final org.apache.thrift.protocol.b N;
  private static final org.apache.thrift.protocol.b O;
  private static final org.apache.thrift.protocol.b P;
  public static final Map<a, org.apache.thrift.meta_data.b> u;
  private static final j v = new j("XmPushActionAckMessage");
  private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("appId", (byte)11, (short)4);
  private BitSet Q = new BitSet(5);
  public String a;
  public u b;
  public String c;
  public String d;
  public long e;
  public String f;
  public String g;
  public aj h;
  public String i;
  public String j;
  public boolean k = false;
  public String l;
  public String m;
  public String n;
  public short o;
  public short p;
  public String q;
  public String r;
  public int s;
  public Map<String, String> t;
  
  static
  {
    A = new org.apache.thrift.protocol.b("messageTs", (byte)10, (short)5);
    B = new org.apache.thrift.protocol.b("topic", (byte)11, (short)6);
    C = new org.apache.thrift.protocol.b("aliasName", (byte)11, (short)7);
    D = new org.apache.thrift.protocol.b("request", (byte)12, (short)8);
    E = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)9);
    F = new org.apache.thrift.protocol.b("category", (byte)11, (short)10);
    G = new org.apache.thrift.protocol.b("isOnline", (byte)2, (short)11);
    H = new org.apache.thrift.protocol.b("regId", (byte)11, (short)12);
    I = new org.apache.thrift.protocol.b("callbackUrl", (byte)11, (short)13);
    J = new org.apache.thrift.protocol.b("userAccount", (byte)11, (short)14);
    K = new org.apache.thrift.protocol.b("deviceStatus", (byte)6, (short)15);
    L = new org.apache.thrift.protocol.b("geoMsgStatus", (byte)6, (short)16);
    M = new org.apache.thrift.protocol.b("imeiMd5", (byte)11, (short)20);
    N = new org.apache.thrift.protocol.b("deviceId", (byte)11, (short)21);
    O = new org.apache.thrift.protocol.b("passThrough", (byte)8, (short)22);
    P = new org.apache.thrift.protocol.b("extra", (byte)13, (short)23);
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new g((byte)12, u.class)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("messageTs", (byte)1, new c((byte)10)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("topic", (byte)2, new c((byte)11)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("aliasName", (byte)2, new c((byte)11)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("request", (byte)2, new g((byte)12, aj.class)));
    localEnumMap.put(a.i, new org.apache.thrift.meta_data.b("packageName", (byte)2, new c((byte)11)));
    localEnumMap.put(a.j, new org.apache.thrift.meta_data.b("category", (byte)2, new c((byte)11)));
    localEnumMap.put(a.k, new org.apache.thrift.meta_data.b("isOnline", (byte)2, new c((byte)2)));
    localEnumMap.put(a.l, new org.apache.thrift.meta_data.b("regId", (byte)2, new c((byte)11)));
    localEnumMap.put(a.m, new org.apache.thrift.meta_data.b("callbackUrl", (byte)2, new c((byte)11)));
    localEnumMap.put(a.n, new org.apache.thrift.meta_data.b("userAccount", (byte)2, new c((byte)11)));
    localEnumMap.put(a.o, new org.apache.thrift.meta_data.b("deviceStatus", (byte)2, new c((byte)6)));
    localEnumMap.put(a.p, new org.apache.thrift.meta_data.b("geoMsgStatus", (byte)2, new c((byte)6)));
    localEnumMap.put(a.q, new org.apache.thrift.meta_data.b("imeiMd5", (byte)2, new c((byte)11)));
    localEnumMap.put(a.r, new org.apache.thrift.meta_data.b("deviceId", (byte)2, new c((byte)11)));
    localEnumMap.put(a.s, new org.apache.thrift.meta_data.b("passThrough", (byte)2, new c((byte)8)));
    localEnumMap.put(a.t, new org.apache.thrift.meta_data.b("extra", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new c((byte)11), new c((byte)11))));
    u = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(w.class, u);
  }
  
  public w a(long paramLong)
  {
    this.e = paramLong;
    a(true);
    return this;
  }
  
  public w a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public w a(short paramShort)
  {
    this.o = paramShort;
    c(true);
    return this;
  }
  
  public void a(org.apache.thrift.protocol.e parame)
  {
    parame.g();
    Object localObject = parame.i();
    if (((org.apache.thrift.protocol.b)localObject).b == 0)
    {
      parame.h();
      if (!e()) {
        throw new f("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
      }
    }
    else
    {
      switch (((org.apache.thrift.protocol.b)localObject).c)
      {
      case 17: 
      case 18: 
      case 19: 
      default: 
        h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
      }
      for (;;)
      {
        parame.j();
        break;
        if (((org.apache.thrift.protocol.b)localObject).b == 11)
        {
          this.a = parame.w();
        }
        else
        {
          h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
          continue;
          if (((org.apache.thrift.protocol.b)localObject).b == 12)
          {
            this.b = new u();
            this.b.a(parame);
          }
          else
          {
            h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
            continue;
            if (((org.apache.thrift.protocol.b)localObject).b == 11)
            {
              this.c = parame.w();
            }
            else
            {
              h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
              continue;
              if (((org.apache.thrift.protocol.b)localObject).b == 11)
              {
                this.d = parame.w();
              }
              else
              {
                h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                continue;
                if (((org.apache.thrift.protocol.b)localObject).b == 10)
                {
                  this.e = parame.u();
                  a(true);
                }
                else
                {
                  h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                  continue;
                  if (((org.apache.thrift.protocol.b)localObject).b == 11)
                  {
                    this.f = parame.w();
                  }
                  else
                  {
                    h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                    continue;
                    if (((org.apache.thrift.protocol.b)localObject).b == 11)
                    {
                      this.g = parame.w();
                    }
                    else
                    {
                      h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                      continue;
                      if (((org.apache.thrift.protocol.b)localObject).b == 12)
                      {
                        this.h = new aj();
                        this.h.a(parame);
                      }
                      else
                      {
                        h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                        continue;
                        if (((org.apache.thrift.protocol.b)localObject).b == 11)
                        {
                          this.i = parame.w();
                        }
                        else
                        {
                          h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                          continue;
                          if (((org.apache.thrift.protocol.b)localObject).b == 11)
                          {
                            this.j = parame.w();
                          }
                          else
                          {
                            h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                            continue;
                            if (((org.apache.thrift.protocol.b)localObject).b == 2)
                            {
                              this.k = parame.q();
                              b(true);
                            }
                            else
                            {
                              h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                              continue;
                              if (((org.apache.thrift.protocol.b)localObject).b == 11)
                              {
                                this.l = parame.w();
                              }
                              else
                              {
                                h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                continue;
                                if (((org.apache.thrift.protocol.b)localObject).b == 11)
                                {
                                  this.m = parame.w();
                                }
                                else
                                {
                                  h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                  continue;
                                  if (((org.apache.thrift.protocol.b)localObject).b == 11)
                                  {
                                    this.n = parame.w();
                                  }
                                  else
                                  {
                                    h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                    continue;
                                    if (((org.apache.thrift.protocol.b)localObject).b == 6)
                                    {
                                      this.o = parame.s();
                                      c(true);
                                    }
                                    else
                                    {
                                      h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                      continue;
                                      if (((org.apache.thrift.protocol.b)localObject).b == 6)
                                      {
                                        this.p = parame.s();
                                        d(true);
                                      }
                                      else
                                      {
                                        h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                        continue;
                                        if (((org.apache.thrift.protocol.b)localObject).b == 11)
                                        {
                                          this.q = parame.w();
                                        }
                                        else
                                        {
                                          h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                          continue;
                                          if (((org.apache.thrift.protocol.b)localObject).b == 11)
                                          {
                                            this.r = parame.w();
                                          }
                                          else
                                          {
                                            h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                            continue;
                                            if (((org.apache.thrift.protocol.b)localObject).b == 8)
                                            {
                                              this.s = parame.t();
                                              e(true);
                                            }
                                            else
                                            {
                                              h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                              continue;
                                              if (((org.apache.thrift.protocol.b)localObject).b == 13)
                                              {
                                                localObject = parame.k();
                                                this.t = new HashMap(((d)localObject).c * 2);
                                                int i1 = 0;
                                                while (i1 < ((d)localObject).c)
                                                {
                                                  String str1 = parame.w();
                                                  String str2 = parame.w();
                                                  this.t.put(str1, str2);
                                                  i1 += 1;
                                                }
                                                parame.l();
                                              }
                                              else
                                              {
                                                h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
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
    u();
  }
  
  public void a(boolean paramBoolean)
  {
    this.Q.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(w paramw)
  {
    if (paramw == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          return false;
                                          bool1 = a();
                                          bool2 = paramw.a();
                                        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramw.a))));
                                        bool1 = b();
                                        bool2 = paramw.b();
                                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.a(paramw.b))));
                                      bool1 = c();
                                      bool2 = paramw.c();
                                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramw.c))));
                                    bool1 = d();
                                    bool2 = paramw.d();
                                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramw.d)) || (this.e != paramw.e)));
                                  bool1 = f();
                                  bool2 = paramw.f();
                                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.f.equals(paramw.f))));
                                bool1 = g();
                                bool2 = paramw.g();
                              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paramw.g))));
                              bool1 = h();
                              bool2 = paramw.h();
                            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.a(paramw.h))));
                            bool1 = i();
                            bool2 = paramw.i();
                          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.i.equals(paramw.i))));
                          bool1 = j();
                          bool2 = paramw.j();
                        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramw.j))));
                        bool1 = k();
                        bool2 = paramw.k();
                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.k != paramw.k)));
                      bool1 = l();
                      bool2 = paramw.l();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.l.equals(paramw.l))));
                    bool1 = m();
                    bool2 = paramw.m();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.m.equals(paramw.m))));
                  bool1 = n();
                  bool2 = paramw.n();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.n.equals(paramw.n))));
                bool1 = o();
                bool2 = paramw.o();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.o != paramw.o)));
              bool1 = p();
              bool2 = paramw.p();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.p != paramw.p)));
            bool1 = q();
            bool2 = paramw.q();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.q.equals(paramw.q))));
          bool1 = r();
          bool2 = paramw.r();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.r.equals(paramw.r))));
        bool1 = s();
        bool2 = paramw.s();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.s != paramw.s)));
      bool1 = t();
      bool2 = paramw.t();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.t.equals(paramw.t))));
    return true;
  }
  
  public int b(w paramw)
  {
    int i1;
    if (!getClass().equals(paramw.getClass())) {
      i1 = getClass().getName().compareTo(paramw.getClass().getName());
    }
    int i2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                do
                                                {
                                                  do
                                                  {
                                                    do
                                                    {
                                                      do
                                                      {
                                                        do
                                                        {
                                                          do
                                                          {
                                                            do
                                                            {
                                                              do
                                                              {
                                                                do
                                                                {
                                                                  do
                                                                  {
                                                                    do
                                                                    {
                                                                      do
                                                                      {
                                                                        do
                                                                        {
                                                                          do
                                                                          {
                                                                            do
                                                                            {
                                                                              do
                                                                              {
                                                                                do
                                                                                {
                                                                                  do
                                                                                  {
                                                                                    return i1;
                                                                                    i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramw.a()));
                                                                                    i1 = i2;
                                                                                  } while (i2 != 0);
                                                                                  if (!a()) {
                                                                                    break;
                                                                                  }
                                                                                  i2 = org.apache.thrift.b.a(this.a, paramw.a);
                                                                                  i1 = i2;
                                                                                } while (i2 != 0);
                                                                                i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramw.b()));
                                                                                i1 = i2;
                                                                              } while (i2 != 0);
                                                                              if (!b()) {
                                                                                break;
                                                                              }
                                                                              i2 = org.apache.thrift.b.a(this.b, paramw.b);
                                                                              i1 = i2;
                                                                            } while (i2 != 0);
                                                                            i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramw.c()));
                                                                            i1 = i2;
                                                                          } while (i2 != 0);
                                                                          if (!c()) {
                                                                            break;
                                                                          }
                                                                          i2 = org.apache.thrift.b.a(this.c, paramw.c);
                                                                          i1 = i2;
                                                                        } while (i2 != 0);
                                                                        i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramw.d()));
                                                                        i1 = i2;
                                                                      } while (i2 != 0);
                                                                      if (!d()) {
                                                                        break;
                                                                      }
                                                                      i2 = org.apache.thrift.b.a(this.d, paramw.d);
                                                                      i1 = i2;
                                                                    } while (i2 != 0);
                                                                    i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramw.e()));
                                                                    i1 = i2;
                                                                  } while (i2 != 0);
                                                                  if (!e()) {
                                                                    break;
                                                                  }
                                                                  i2 = org.apache.thrift.b.a(this.e, paramw.e);
                                                                  i1 = i2;
                                                                } while (i2 != 0);
                                                                i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramw.f()));
                                                                i1 = i2;
                                                              } while (i2 != 0);
                                                              if (!f()) {
                                                                break;
                                                              }
                                                              i2 = org.apache.thrift.b.a(this.f, paramw.f);
                                                              i1 = i2;
                                                            } while (i2 != 0);
                                                            i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramw.g()));
                                                            i1 = i2;
                                                          } while (i2 != 0);
                                                          if (!g()) {
                                                            break;
                                                          }
                                                          i2 = org.apache.thrift.b.a(this.g, paramw.g);
                                                          i1 = i2;
                                                        } while (i2 != 0);
                                                        i2 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramw.h()));
                                                        i1 = i2;
                                                      } while (i2 != 0);
                                                      if (!h()) {
                                                        break;
                                                      }
                                                      i2 = org.apache.thrift.b.a(this.h, paramw.h);
                                                      i1 = i2;
                                                    } while (i2 != 0);
                                                    i2 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramw.i()));
                                                    i1 = i2;
                                                  } while (i2 != 0);
                                                  if (!i()) {
                                                    break;
                                                  }
                                                  i2 = org.apache.thrift.b.a(this.i, paramw.i);
                                                  i1 = i2;
                                                } while (i2 != 0);
                                                i2 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramw.j()));
                                                i1 = i2;
                                              } while (i2 != 0);
                                              if (!j()) {
                                                break;
                                              }
                                              i2 = org.apache.thrift.b.a(this.j, paramw.j);
                                              i1 = i2;
                                            } while (i2 != 0);
                                            i2 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramw.k()));
                                            i1 = i2;
                                          } while (i2 != 0);
                                          if (!k()) {
                                            break;
                                          }
                                          i2 = org.apache.thrift.b.a(this.k, paramw.k);
                                          i1 = i2;
                                        } while (i2 != 0);
                                        i2 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramw.l()));
                                        i1 = i2;
                                      } while (i2 != 0);
                                      if (!l()) {
                                        break;
                                      }
                                      i2 = org.apache.thrift.b.a(this.l, paramw.l);
                                      i1 = i2;
                                    } while (i2 != 0);
                                    i2 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(paramw.m()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!m()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.m, paramw.m);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramw.n()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!n()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.n, paramw.n);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(paramw.o()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!o()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.o, paramw.o);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(paramw.p()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!p()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.p, paramw.p);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(paramw.q()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!q()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.q, paramw.q);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(paramw.r()));
                i1 = i2;
              } while (i2 != 0);
              if (!r()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.r, paramw.r);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(paramw.s()));
            i1 = i2;
          } while (i2 != 0);
          if (!s()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.s, paramw.s);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(paramw.t()));
        i1 = i2;
      } while (i2 != 0);
      if (!t()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.t, paramw.t);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public w b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public w b(short paramShort)
  {
    this.p = paramShort;
    d(true);
    return this;
  }
  
  public void b(org.apache.thrift.protocol.e parame)
  {
    u();
    parame.a(v);
    if ((this.a != null) && (a()))
    {
      parame.a(w);
      parame.a(this.a);
      parame.b();
    }
    if ((this.b != null) && (b()))
    {
      parame.a(x);
      this.b.b(parame);
      parame.b();
    }
    if (this.c != null)
    {
      parame.a(y);
      parame.a(this.c);
      parame.b();
    }
    if (this.d != null)
    {
      parame.a(z);
      parame.a(this.d);
      parame.b();
    }
    parame.a(A);
    parame.a(this.e);
    parame.b();
    if ((this.f != null) && (f()))
    {
      parame.a(B);
      parame.a(this.f);
      parame.b();
    }
    if ((this.g != null) && (g()))
    {
      parame.a(C);
      parame.a(this.g);
      parame.b();
    }
    if ((this.h != null) && (h()))
    {
      parame.a(D);
      this.h.b(parame);
      parame.b();
    }
    if ((this.i != null) && (i()))
    {
      parame.a(E);
      parame.a(this.i);
      parame.b();
    }
    if ((this.j != null) && (j()))
    {
      parame.a(F);
      parame.a(this.j);
      parame.b();
    }
    if (k())
    {
      parame.a(G);
      parame.a(this.k);
      parame.b();
    }
    if ((this.l != null) && (l()))
    {
      parame.a(H);
      parame.a(this.l);
      parame.b();
    }
    if ((this.m != null) && (m()))
    {
      parame.a(I);
      parame.a(this.m);
      parame.b();
    }
    if ((this.n != null) && (n()))
    {
      parame.a(J);
      parame.a(this.n);
      parame.b();
    }
    if (o())
    {
      parame.a(K);
      parame.a(this.o);
      parame.b();
    }
    if (p())
    {
      parame.a(L);
      parame.a(this.p);
      parame.b();
    }
    if ((this.q != null) && (q()))
    {
      parame.a(M);
      parame.a(this.q);
      parame.b();
    }
    if ((this.r != null) && (r()))
    {
      parame.a(N);
      parame.a(this.r);
      parame.b();
    }
    if (s())
    {
      parame.a(O);
      parame.a(this.s);
      parame.b();
    }
    if ((this.t != null) && (t()))
    {
      parame.a(P);
      parame.a(new d((byte)11, (byte)11, this.t.size()));
      Iterator localIterator = this.t.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        parame.a((String)localEntry.getKey());
        parame.a((String)localEntry.getValue());
      }
      parame.d();
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.Q.set(1, paramBoolean);
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public w c(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public void c(boolean paramBoolean)
  {
    this.Q.set(2, paramBoolean);
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public w d(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public void d(boolean paramBoolean)
  {
    this.Q.set(3, paramBoolean);
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public void e(boolean paramBoolean)
  {
    this.Q.set(4, paramBoolean);
  }
  
  public boolean e()
  {
    return this.Q.get(0);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof w)) {
      return false;
    }
    return a((w)paramObject);
  }
  
  public boolean f()
  {
    return this.f != null;
  }
  
  public boolean g()
  {
    return this.g != null;
  }
  
  public boolean h()
  {
    return this.h != null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.i != null;
  }
  
  public boolean j()
  {
    return this.j != null;
  }
  
  public boolean k()
  {
    return this.Q.get(1);
  }
  
  public boolean l()
  {
    return this.l != null;
  }
  
  public boolean m()
  {
    return this.m != null;
  }
  
  public boolean n()
  {
    return this.n != null;
  }
  
  public boolean o()
  {
    return this.Q.get(2);
  }
  
  public boolean p()
  {
    return this.Q.get(3);
  }
  
  public boolean q()
  {
    return this.q != null;
  }
  
  public boolean r()
  {
    return this.r != null;
  }
  
  public boolean s()
  {
    return this.Q.get(4);
  }
  
  public boolean t()
  {
    return this.t != null;
  }
  
  public String toString()
  {
    int i2 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionAckMessage(");
    int i1 = 1;
    if (a())
    {
      localStringBuilder.append("debug:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i1 = 0;
      }
    }
    else
    {
      if (!b()) {
        break label923;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label753;
      }
      localStringBuilder.append("null");
      i1 = i2;
    }
    label91:
    label126:
    label157:
    label220:
    label258:
    label296:
    label334:
    label372:
    label442:
    label480:
    label518:
    label620:
    label658:
    label753:
    label779:
    label791:
    label803:
    label815:
    label827:
    label839:
    label851:
    label863:
    label875:
    label887:
    label899:
    label911:
    label923:
    for (;;)
    {
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("id:");
      if (this.c == null)
      {
        localStringBuilder.append("null");
        localStringBuilder.append(", ");
        localStringBuilder.append("appId:");
        if (this.d != null) {
          break label779;
        }
        localStringBuilder.append("null");
        localStringBuilder.append(", ");
        localStringBuilder.append("messageTs:");
        localStringBuilder.append(this.e);
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("topic:");
          if (this.f != null) {
            break label791;
          }
          localStringBuilder.append("null");
        }
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("aliasName:");
          if (this.g != null) {
            break label803;
          }
          localStringBuilder.append("null");
        }
        if (h())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("request:");
          if (this.h != null) {
            break label815;
          }
          localStringBuilder.append("null");
        }
        if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.i != null) {
            break label827;
          }
          localStringBuilder.append("null");
        }
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.j != null) {
            break label839;
          }
          localStringBuilder.append("null");
        }
        if (k())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("isOnline:");
          localStringBuilder.append(this.k);
        }
        if (l())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("regId:");
          if (this.l != null) {
            break label851;
          }
          localStringBuilder.append("null");
        }
        if (m())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("callbackUrl:");
          if (this.m != null) {
            break label863;
          }
          localStringBuilder.append("null");
        }
        if (n())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("userAccount:");
          if (this.n != null) {
            break label875;
          }
          localStringBuilder.append("null");
        }
        if (o())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("deviceStatus:");
          localStringBuilder.append(this.o);
        }
        if (p())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("geoMsgStatus:");
          localStringBuilder.append(this.p);
        }
        if (q())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("imeiMd5:");
          if (this.q != null) {
            break label887;
          }
          localStringBuilder.append("null");
        }
        if (r())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("deviceId:");
          if (this.r != null) {
            break label899;
          }
          localStringBuilder.append("null");
        }
        if (s())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("passThrough:");
          localStringBuilder.append(this.s);
        }
        if (t())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("extra:");
          if (this.t != null) {
            break label911;
          }
          localStringBuilder.append("null");
        }
      }
      for (;;)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        localStringBuilder.append(this.b);
        i1 = i2;
        break label91;
        localStringBuilder.append(this.c);
        break label126;
        localStringBuilder.append(this.d);
        break label157;
        localStringBuilder.append(this.f);
        break label220;
        localStringBuilder.append(this.g);
        break label258;
        localStringBuilder.append(this.h);
        break label296;
        localStringBuilder.append(this.i);
        break label334;
        localStringBuilder.append(this.j);
        break label372;
        localStringBuilder.append(this.l);
        break label442;
        localStringBuilder.append(this.m);
        break label480;
        localStringBuilder.append(this.n);
        break label518;
        localStringBuilder.append(this.q);
        break label620;
        localStringBuilder.append(this.r);
        break label658;
        localStringBuilder.append(this.t);
      }
    }
  }
  
  public void u()
  {
    if (this.c == null) {
      throw new f("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new f("Required field 'appId' was not present! Struct: " + toString());
    }
  }
  
  public static enum a
  {
    private static final Map<String, a> u;
    private final short v;
    private final String w;
    
    static
    {
      u = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        u.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.v = paramShort;
      this.w = paramString;
    }
    
    public String a()
    {
      return this.w;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */