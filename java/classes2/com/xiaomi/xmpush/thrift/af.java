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
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class af
  implements Serializable, Cloneable, org.apache.thrift.a<af, a>
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
  private static final org.apache.thrift.protocol.b Q;
  private static final org.apache.thrift.protocol.b R;
  private static final org.apache.thrift.protocol.b S;
  private static final org.apache.thrift.protocol.b T;
  private static final org.apache.thrift.protocol.b U;
  private static final org.apache.thrift.protocol.b V;
  public static final Map<a, org.apache.thrift.meta_data.b> x;
  private static final j y = new j("XmPushActionRegistration");
  private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("debug", (byte)11, (short)1);
  private BitSet W = new BitSet(4);
  public String a;
  public u b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public int m;
  public int n;
  public String o;
  public String p;
  public String q;
  public String r;
  public int s;
  public t t;
  public Map<String, String> u;
  public boolean v = false;
  public String w;
  
  static
  {
    A = new org.apache.thrift.protocol.b("target", (byte)12, (short)2);
    B = new org.apache.thrift.protocol.b("id", (byte)11, (short)3);
    C = new org.apache.thrift.protocol.b("appId", (byte)11, (short)4);
    D = new org.apache.thrift.protocol.b("appVersion", (byte)11, (short)5);
    E = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)6);
    F = new org.apache.thrift.protocol.b("token", (byte)11, (short)7);
    G = new org.apache.thrift.protocol.b("deviceId", (byte)11, (short)8);
    H = new org.apache.thrift.protocol.b("aliasName", (byte)11, (short)9);
    I = new org.apache.thrift.protocol.b("sdkVersion", (byte)11, (short)10);
    J = new org.apache.thrift.protocol.b("regId", (byte)11, (short)11);
    K = new org.apache.thrift.protocol.b("pushSdkVersionName", (byte)11, (short)12);
    L = new org.apache.thrift.protocol.b("pushSdkVersionCode", (byte)8, (short)13);
    M = new org.apache.thrift.protocol.b("appVersionCode", (byte)8, (short)14);
    N = new org.apache.thrift.protocol.b("androidId", (byte)11, (short)15);
    O = new org.apache.thrift.protocol.b("imei", (byte)11, (short)16);
    P = new org.apache.thrift.protocol.b("serial", (byte)11, (short)17);
    Q = new org.apache.thrift.protocol.b("imeiMd5", (byte)11, (short)18);
    R = new org.apache.thrift.protocol.b("spaceId", (byte)8, (short)19);
    S = new org.apache.thrift.protocol.b("reason", (byte)8, (short)20);
    T = new org.apache.thrift.protocol.b("connectionAttrs", (byte)13, (short)100);
    U = new org.apache.thrift.protocol.b("cleanOldRegInfo", (byte)2, (short)101);
    V = new org.apache.thrift.protocol.b("oldRegId", (byte)11, (short)102);
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new g((byte)12, u.class)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("appVersion", (byte)2, new c((byte)11)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("packageName", (byte)2, new c((byte)11)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("token", (byte)1, new c((byte)11)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("deviceId", (byte)2, new c((byte)11)));
    localEnumMap.put(a.i, new org.apache.thrift.meta_data.b("aliasName", (byte)2, new c((byte)11)));
    localEnumMap.put(a.j, new org.apache.thrift.meta_data.b("sdkVersion", (byte)2, new c((byte)11)));
    localEnumMap.put(a.k, new org.apache.thrift.meta_data.b("regId", (byte)2, new c((byte)11)));
    localEnumMap.put(a.l, new org.apache.thrift.meta_data.b("pushSdkVersionName", (byte)2, new c((byte)11)));
    localEnumMap.put(a.m, new org.apache.thrift.meta_data.b("pushSdkVersionCode", (byte)2, new c((byte)8)));
    localEnumMap.put(a.n, new org.apache.thrift.meta_data.b("appVersionCode", (byte)2, new c((byte)8)));
    localEnumMap.put(a.o, new org.apache.thrift.meta_data.b("androidId", (byte)2, new c((byte)11)));
    localEnumMap.put(a.p, new org.apache.thrift.meta_data.b("imei", (byte)2, new c((byte)11)));
    localEnumMap.put(a.q, new org.apache.thrift.meta_data.b("serial", (byte)2, new c((byte)11)));
    localEnumMap.put(a.r, new org.apache.thrift.meta_data.b("imeiMd5", (byte)2, new c((byte)11)));
    localEnumMap.put(a.s, new org.apache.thrift.meta_data.b("spaceId", (byte)2, new c((byte)8)));
    localEnumMap.put(a.t, new org.apache.thrift.meta_data.b("reason", (byte)2, new org.apache.thrift.meta_data.a((byte)16, t.class)));
    localEnumMap.put(a.u, new org.apache.thrift.meta_data.b("connectionAttrs", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new c((byte)11), new c((byte)11))));
    localEnumMap.put(a.v, new org.apache.thrift.meta_data.b("cleanOldRegInfo", (byte)2, new c((byte)2)));
    localEnumMap.put(a.w, new org.apache.thrift.meta_data.b("oldRegId", (byte)2, new c((byte)11)));
    x = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(af.class, x);
  }
  
  public af a(int paramInt)
  {
    this.m = paramInt;
    a(true);
    return this;
  }
  
  public af a(t paramt)
  {
    this.t = paramt;
    return this;
  }
  
  public af a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void a(org.apache.thrift.protocol.e parame)
  {
    parame.g();
    Object localObject = parame.i();
    if (((org.apache.thrift.protocol.b)localObject).b == 0)
    {
      parame.h();
      z();
      return;
    }
    switch (((org.apache.thrift.protocol.b)localObject).c)
    {
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
              if (((org.apache.thrift.protocol.b)localObject).b == 11)
              {
                this.e = parame.w();
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
                    if (((org.apache.thrift.protocol.b)localObject).b == 11)
                    {
                      this.h = parame.w();
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
                          if (((org.apache.thrift.protocol.b)localObject).b == 11)
                          {
                            this.k = parame.w();
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
                              if (((org.apache.thrift.protocol.b)localObject).b == 8)
                              {
                                this.m = parame.t();
                                a(true);
                              }
                              else
                              {
                                h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                continue;
                                if (((org.apache.thrift.protocol.b)localObject).b == 8)
                                {
                                  this.n = parame.t();
                                  b(true);
                                }
                                else
                                {
                                  h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                  continue;
                                  if (((org.apache.thrift.protocol.b)localObject).b == 11)
                                  {
                                    this.o = parame.w();
                                  }
                                  else
                                  {
                                    h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                    continue;
                                    if (((org.apache.thrift.protocol.b)localObject).b == 11)
                                    {
                                      this.p = parame.w();
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
                                            c(true);
                                          }
                                          else
                                          {
                                            h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                            continue;
                                            if (((org.apache.thrift.protocol.b)localObject).b == 8)
                                            {
                                              this.t = t.a(parame.t());
                                            }
                                            else
                                            {
                                              h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                              continue;
                                              if (((org.apache.thrift.protocol.b)localObject).b == 13)
                                              {
                                                localObject = parame.k();
                                                this.u = new HashMap(((d)localObject).c * 2);
                                                int i1 = 0;
                                                while (i1 < ((d)localObject).c)
                                                {
                                                  String str1 = parame.w();
                                                  String str2 = parame.w();
                                                  this.u.put(str1, str2);
                                                  i1 += 1;
                                                }
                                                parame.l();
                                              }
                                              else
                                              {
                                                h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                                continue;
                                                if (((org.apache.thrift.protocol.b)localObject).b == 2)
                                                {
                                                  this.v = parame.q();
                                                  d(true);
                                                }
                                                else
                                                {
                                                  h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                                                  continue;
                                                  if (((org.apache.thrift.protocol.b)localObject).b == 11) {
                                                    this.w = parame.w();
                                                  } else {
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
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.W.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(af paramaf)
  {
    if (paramaf == null) {}
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
                                                  bool2 = paramaf.a();
                                                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramaf.a))));
                                                bool1 = b();
                                                bool2 = paramaf.b();
                                              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.a(paramaf.b))));
                                              bool1 = c();
                                              bool2 = paramaf.c();
                                            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramaf.c))));
                                            bool1 = e();
                                            bool2 = paramaf.e();
                                          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramaf.d))));
                                          bool1 = f();
                                          bool2 = paramaf.f();
                                        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(paramaf.e))));
                                        bool1 = g();
                                        bool2 = paramaf.g();
                                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.f.equals(paramaf.f))));
                                      bool1 = i();
                                      bool2 = paramaf.i();
                                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paramaf.g))));
                                    bool1 = j();
                                    bool2 = paramaf.j();
                                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.equals(paramaf.h))));
                                  bool1 = k();
                                  bool2 = paramaf.k();
                                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.i.equals(paramaf.i))));
                                bool1 = l();
                                bool2 = paramaf.l();
                              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramaf.j))));
                              bool1 = m();
                              bool2 = paramaf.m();
                            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.k.equals(paramaf.k))));
                            bool1 = n();
                            bool2 = paramaf.n();
                          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.l.equals(paramaf.l))));
                          bool1 = o();
                          bool2 = paramaf.o();
                        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.m != paramaf.m)));
                        bool1 = p();
                        bool2 = paramaf.p();
                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.n != paramaf.n)));
                      bool1 = q();
                      bool2 = paramaf.q();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.o.equals(paramaf.o))));
                    bool1 = r();
                    bool2 = paramaf.r();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.p.equals(paramaf.p))));
                  bool1 = s();
                  bool2 = paramaf.s();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.q.equals(paramaf.q))));
                bool1 = t();
                bool2 = paramaf.t();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.r.equals(paramaf.r))));
              bool1 = u();
              bool2 = paramaf.u();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.s != paramaf.s)));
            bool1 = v();
            bool2 = paramaf.v();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.t.equals(paramaf.t))));
          bool1 = w();
          bool2 = paramaf.w();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.u.equals(paramaf.u))));
        bool1 = x();
        bool2 = paramaf.x();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.v != paramaf.v)));
      bool1 = y();
      bool2 = paramaf.y();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.w.equals(paramaf.w))));
    return true;
  }
  
  public int b(af paramaf)
  {
    int i1;
    if (!getClass().equals(paramaf.getClass())) {
      i1 = getClass().getName().compareTo(paramaf.getClass().getName());
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
                                                                                                i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramaf.a()));
                                                                                                i1 = i2;
                                                                                              } while (i2 != 0);
                                                                                              if (!a()) {
                                                                                                break;
                                                                                              }
                                                                                              i2 = org.apache.thrift.b.a(this.a, paramaf.a);
                                                                                              i1 = i2;
                                                                                            } while (i2 != 0);
                                                                                            i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramaf.b()));
                                                                                            i1 = i2;
                                                                                          } while (i2 != 0);
                                                                                          if (!b()) {
                                                                                            break;
                                                                                          }
                                                                                          i2 = org.apache.thrift.b.a(this.b, paramaf.b);
                                                                                          i1 = i2;
                                                                                        } while (i2 != 0);
                                                                                        i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramaf.c()));
                                                                                        i1 = i2;
                                                                                      } while (i2 != 0);
                                                                                      if (!c()) {
                                                                                        break;
                                                                                      }
                                                                                      i2 = org.apache.thrift.b.a(this.c, paramaf.c);
                                                                                      i1 = i2;
                                                                                    } while (i2 != 0);
                                                                                    i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramaf.e()));
                                                                                    i1 = i2;
                                                                                  } while (i2 != 0);
                                                                                  if (!e()) {
                                                                                    break;
                                                                                  }
                                                                                  i2 = org.apache.thrift.b.a(this.d, paramaf.d);
                                                                                  i1 = i2;
                                                                                } while (i2 != 0);
                                                                                i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramaf.f()));
                                                                                i1 = i2;
                                                                              } while (i2 != 0);
                                                                              if (!f()) {
                                                                                break;
                                                                              }
                                                                              i2 = org.apache.thrift.b.a(this.e, paramaf.e);
                                                                              i1 = i2;
                                                                            } while (i2 != 0);
                                                                            i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramaf.g()));
                                                                            i1 = i2;
                                                                          } while (i2 != 0);
                                                                          if (!g()) {
                                                                            break;
                                                                          }
                                                                          i2 = org.apache.thrift.b.a(this.f, paramaf.f);
                                                                          i1 = i2;
                                                                        } while (i2 != 0);
                                                                        i2 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramaf.i()));
                                                                        i1 = i2;
                                                                      } while (i2 != 0);
                                                                      if (!i()) {
                                                                        break;
                                                                      }
                                                                      i2 = org.apache.thrift.b.a(this.g, paramaf.g);
                                                                      i1 = i2;
                                                                    } while (i2 != 0);
                                                                    i2 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramaf.j()));
                                                                    i1 = i2;
                                                                  } while (i2 != 0);
                                                                  if (!j()) {
                                                                    break;
                                                                  }
                                                                  i2 = org.apache.thrift.b.a(this.h, paramaf.h);
                                                                  i1 = i2;
                                                                } while (i2 != 0);
                                                                i2 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramaf.k()));
                                                                i1 = i2;
                                                              } while (i2 != 0);
                                                              if (!k()) {
                                                                break;
                                                              }
                                                              i2 = org.apache.thrift.b.a(this.i, paramaf.i);
                                                              i1 = i2;
                                                            } while (i2 != 0);
                                                            i2 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramaf.l()));
                                                            i1 = i2;
                                                          } while (i2 != 0);
                                                          if (!l()) {
                                                            break;
                                                          }
                                                          i2 = org.apache.thrift.b.a(this.j, paramaf.j);
                                                          i1 = i2;
                                                        } while (i2 != 0);
                                                        i2 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(paramaf.m()));
                                                        i1 = i2;
                                                      } while (i2 != 0);
                                                      if (!m()) {
                                                        break;
                                                      }
                                                      i2 = org.apache.thrift.b.a(this.k, paramaf.k);
                                                      i1 = i2;
                                                    } while (i2 != 0);
                                                    i2 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramaf.n()));
                                                    i1 = i2;
                                                  } while (i2 != 0);
                                                  if (!n()) {
                                                    break;
                                                  }
                                                  i2 = org.apache.thrift.b.a(this.l, paramaf.l);
                                                  i1 = i2;
                                                } while (i2 != 0);
                                                i2 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(paramaf.o()));
                                                i1 = i2;
                                              } while (i2 != 0);
                                              if (!o()) {
                                                break;
                                              }
                                              i2 = org.apache.thrift.b.a(this.m, paramaf.m);
                                              i1 = i2;
                                            } while (i2 != 0);
                                            i2 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(paramaf.p()));
                                            i1 = i2;
                                          } while (i2 != 0);
                                          if (!p()) {
                                            break;
                                          }
                                          i2 = org.apache.thrift.b.a(this.n, paramaf.n);
                                          i1 = i2;
                                        } while (i2 != 0);
                                        i2 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(paramaf.q()));
                                        i1 = i2;
                                      } while (i2 != 0);
                                      if (!q()) {
                                        break;
                                      }
                                      i2 = org.apache.thrift.b.a(this.o, paramaf.o);
                                      i1 = i2;
                                    } while (i2 != 0);
                                    i2 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(paramaf.r()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!r()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.p, paramaf.p);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(paramaf.s()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!s()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.q, paramaf.q);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(paramaf.t()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!t()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.r, paramaf.r);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(paramaf.u()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!u()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.s, paramaf.s);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(paramaf.v()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!v()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.t, paramaf.t);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(paramaf.w()));
                i1 = i2;
              } while (i2 != 0);
              if (!w()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.u, paramaf.u);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(paramaf.x()));
            i1 = i2;
          } while (i2 != 0);
          if (!x()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.v, paramaf.v);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(paramaf.y()));
        i1 = i2;
      } while (i2 != 0);
      if (!y()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.w, paramaf.w);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public af b(int paramInt)
  {
    this.n = paramInt;
    b(true);
    return this;
  }
  
  public af b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public void b(org.apache.thrift.protocol.e parame)
  {
    z();
    parame.a(y);
    if ((this.a != null) && (a()))
    {
      parame.a(z);
      parame.a(this.a);
      parame.b();
    }
    if ((this.b != null) && (b()))
    {
      parame.a(A);
      this.b.b(parame);
      parame.b();
    }
    if (this.c != null)
    {
      parame.a(B);
      parame.a(this.c);
      parame.b();
    }
    if (this.d != null)
    {
      parame.a(C);
      parame.a(this.d);
      parame.b();
    }
    if ((this.e != null) && (f()))
    {
      parame.a(D);
      parame.a(this.e);
      parame.b();
    }
    if ((this.f != null) && (g()))
    {
      parame.a(E);
      parame.a(this.f);
      parame.b();
    }
    if (this.g != null)
    {
      parame.a(F);
      parame.a(this.g);
      parame.b();
    }
    if ((this.h != null) && (j()))
    {
      parame.a(G);
      parame.a(this.h);
      parame.b();
    }
    if ((this.i != null) && (k()))
    {
      parame.a(H);
      parame.a(this.i);
      parame.b();
    }
    if ((this.j != null) && (l()))
    {
      parame.a(I);
      parame.a(this.j);
      parame.b();
    }
    if ((this.k != null) && (m()))
    {
      parame.a(J);
      parame.a(this.k);
      parame.b();
    }
    if ((this.l != null) && (n()))
    {
      parame.a(K);
      parame.a(this.l);
      parame.b();
    }
    if (o())
    {
      parame.a(L);
      parame.a(this.m);
      parame.b();
    }
    if (p())
    {
      parame.a(M);
      parame.a(this.n);
      parame.b();
    }
    if ((this.o != null) && (q()))
    {
      parame.a(N);
      parame.a(this.o);
      parame.b();
    }
    if ((this.p != null) && (r()))
    {
      parame.a(O);
      parame.a(this.p);
      parame.b();
    }
    if ((this.q != null) && (s()))
    {
      parame.a(P);
      parame.a(this.q);
      parame.b();
    }
    if ((this.r != null) && (t()))
    {
      parame.a(Q);
      parame.a(this.r);
      parame.b();
    }
    if (u())
    {
      parame.a(R);
      parame.a(this.s);
      parame.b();
    }
    if ((this.t != null) && (v()))
    {
      parame.a(S);
      parame.a(this.t.a());
      parame.b();
    }
    if ((this.u != null) && (w()))
    {
      parame.a(T);
      parame.a(new d((byte)11, (byte)11, this.u.size()));
      Iterator localIterator = this.u.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        parame.a((String)localEntry.getKey());
        parame.a((String)localEntry.getValue());
      }
      parame.d();
      parame.b();
    }
    if (x())
    {
      parame.a(U);
      parame.a(this.v);
      parame.b();
    }
    if ((this.w != null) && (y()))
    {
      parame.a(V);
      parame.a(this.w);
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.W.set(1, paramBoolean);
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public af c(int paramInt)
  {
    this.s = paramInt;
    c(true);
    return this;
  }
  
  public af c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public void c(boolean paramBoolean)
  {
    this.W.set(2, paramBoolean);
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public af d(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(boolean paramBoolean)
  {
    this.W.set(3, paramBoolean);
  }
  
  public af e(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public boolean e()
  {
    return this.d != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof af)) {
      return false;
    }
    return a((af)paramObject);
  }
  
  public af f(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public boolean f()
  {
    return this.e != null;
  }
  
  public af g(String paramString)
  {
    this.l = paramString;
    return this;
  }
  
  public boolean g()
  {
    return this.f != null;
  }
  
  public af h(String paramString)
  {
    this.o = paramString;
    return this;
  }
  
  public String h()
  {
    return this.g;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public af i(String paramString)
  {
    this.p = paramString;
    return this;
  }
  
  public boolean i()
  {
    return this.g != null;
  }
  
  public af j(String paramString)
  {
    this.q = paramString;
    return this;
  }
  
  public boolean j()
  {
    return this.h != null;
  }
  
  public af k(String paramString)
  {
    this.r = paramString;
    return this;
  }
  
  public boolean k()
  {
    return this.i != null;
  }
  
  public boolean l()
  {
    return this.j != null;
  }
  
  public boolean m()
  {
    return this.k != null;
  }
  
  public boolean n()
  {
    return this.l != null;
  }
  
  public boolean o()
  {
    return this.W.get(0);
  }
  
  public boolean p()
  {
    return this.W.get(1);
  }
  
  public boolean q()
  {
    return this.o != null;
  }
  
  public boolean r()
  {
    return this.p != null;
  }
  
  public boolean s()
  {
    return this.q != null;
  }
  
  public boolean t()
  {
    return this.r != null;
  }
  
  public String toString()
  {
    int i2 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionRegistration(");
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
        break label1091;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label873;
      }
      localStringBuilder.append("null");
      i1 = i2;
    }
    label91:
    label126:
    label157:
    label195:
    label233:
    label264:
    label302:
    label340:
    label378:
    label416:
    label454:
    label556:
    label594:
    label632:
    label670:
    label740:
    label778:
    label873:
    label899:
    label911:
    label923:
    label935:
    label947:
    label959:
    label971:
    label983:
    label995:
    label1007:
    label1019:
    label1031:
    label1043:
    label1055:
    label1067:
    label1079:
    label1091:
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
          break label899;
        }
        localStringBuilder.append("null");
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("appVersion:");
          if (this.e != null) {
            break label911;
          }
          localStringBuilder.append("null");
        }
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.f != null) {
            break label923;
          }
          localStringBuilder.append("null");
        }
        localStringBuilder.append(", ");
        localStringBuilder.append("token:");
        if (this.g != null) {
          break label935;
        }
        localStringBuilder.append("null");
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("deviceId:");
          if (this.h != null) {
            break label947;
          }
          localStringBuilder.append("null");
        }
        if (k())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("aliasName:");
          if (this.i != null) {
            break label959;
          }
          localStringBuilder.append("null");
        }
        if (l())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("sdkVersion:");
          if (this.j != null) {
            break label971;
          }
          localStringBuilder.append("null");
        }
        if (m())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("regId:");
          if (this.k != null) {
            break label983;
          }
          localStringBuilder.append("null");
        }
        if (n())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("pushSdkVersionName:");
          if (this.l != null) {
            break label995;
          }
          localStringBuilder.append("null");
        }
        if (o())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("pushSdkVersionCode:");
          localStringBuilder.append(this.m);
        }
        if (p())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("appVersionCode:");
          localStringBuilder.append(this.n);
        }
        if (q())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("androidId:");
          if (this.o != null) {
            break label1007;
          }
          localStringBuilder.append("null");
        }
        if (r())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("imei:");
          if (this.p != null) {
            break label1019;
          }
          localStringBuilder.append("null");
        }
        if (s())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("serial:");
          if (this.q != null) {
            break label1031;
          }
          localStringBuilder.append("null");
        }
        if (t())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("imeiMd5:");
          if (this.r != null) {
            break label1043;
          }
          localStringBuilder.append("null");
        }
        if (u())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("spaceId:");
          localStringBuilder.append(this.s);
        }
        if (v())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("reason:");
          if (this.t != null) {
            break label1055;
          }
          localStringBuilder.append("null");
        }
        if (w())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("connectionAttrs:");
          if (this.u != null) {
            break label1067;
          }
          localStringBuilder.append("null");
        }
        if (x())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("cleanOldRegInfo:");
          localStringBuilder.append(this.v);
        }
        if (y())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("oldRegId:");
          if (this.w != null) {
            break label1079;
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
        localStringBuilder.append(this.e);
        break label195;
        localStringBuilder.append(this.f);
        break label233;
        localStringBuilder.append(this.g);
        break label264;
        localStringBuilder.append(this.h);
        break label302;
        localStringBuilder.append(this.i);
        break label340;
        localStringBuilder.append(this.j);
        break label378;
        localStringBuilder.append(this.k);
        break label416;
        localStringBuilder.append(this.l);
        break label454;
        localStringBuilder.append(this.o);
        break label556;
        localStringBuilder.append(this.p);
        break label594;
        localStringBuilder.append(this.q);
        break label632;
        localStringBuilder.append(this.r);
        break label670;
        localStringBuilder.append(this.t);
        break label740;
        localStringBuilder.append(this.u);
        break label778;
        localStringBuilder.append(this.w);
      }
    }
  }
  
  public boolean u()
  {
    return this.W.get(2);
  }
  
  public boolean v()
  {
    return this.t != null;
  }
  
  public boolean w()
  {
    return this.u != null;
  }
  
  public boolean x()
  {
    return this.W.get(3);
  }
  
  public boolean y()
  {
    return this.w != null;
  }
  
  public void z()
  {
    if (this.c == null) {
      throw new f("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new f("Required field 'appId' was not present! Struct: " + toString());
    }
    if (this.g == null) {
      throw new f("Required field 'token' was not present! Struct: " + toString());
    }
  }
  
  public static enum a
  {
    private static final Map<String, a> x;
    private final short y;
    private final String z;
    
    static
    {
      A = new a[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w };
      x = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        x.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.y = paramShort;
      this.z = paramString;
    }
    
    public String a()
    {
      return this.z;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */