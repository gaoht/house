package com.b.a.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public enum f
{
  public static final Collection<f> I;
  public final byte J;
  public final boolean K;
  
  static
  {
    int i1 = 0;
    a = new f("APP0", 0, (byte)-32, true);
    b = new f("APP1", 1, (byte)-31, true);
    c = new f("APP2", 2, (byte)-30, true);
    d = new f("APP3", 3, (byte)-29, true);
    e = new f("APP4", 4, (byte)-28, true);
    f = new f("APP5", 5, (byte)-27, true);
    g = new f("APP6", 6, (byte)-26, true);
    h = new f("APP7", 7, (byte)-25, true);
    i = new f("APP8", 8, (byte)-24, true);
    j = new f("APP9", 9, (byte)-23, true);
    k = new f("APPA", 10, (byte)-22, true);
    l = new f("APPB", 11, (byte)-21, true);
    m = new f("APPC", 12, (byte)-20, true);
    n = new f("APPD", 13, (byte)-19, true);
    o = new f("APPE", 14, (byte)-18, true);
    p = new f("APPF", 15, (byte)-17, true);
    q = new f("SOI", 16, (byte)-40, false);
    r = new f("DQT", 17, (byte)-37, false);
    s = new f("DHT", 18, (byte)-60, false);
    t = new f("SOF0", 19, (byte)-64, true);
    u = new f("SOF1", 20, (byte)-63, true);
    v = new f("SOF2", 21, (byte)-62, true);
    w = new f("SOF3", 22, (byte)-61, true);
    x = new f("SOF5", 23, (byte)-59, true);
    y = new f("SOF6", 24, (byte)-58, true);
    z = new f("SOF7", 25, (byte)-57, true);
    A = new f("SOF8", 26, (byte)-56, true);
    B = new f("SOF9", 27, (byte)-55, true);
    C = new f("SOF10", 28, (byte)-54, true);
    D = new f("SOF11", 29, (byte)-53, true);
    E = new f("SOF13", 30, (byte)-51, true);
    F = new f("SOF14", 31, (byte)-50, true);
    G = new f("SOF15", 32, (byte)-49, true);
    H = new f("COM", 33, (byte)-2, true);
    L = new f[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H };
    ArrayList localArrayList = new ArrayList();
    f[] arrayOff = (f[])f.class.getEnumConstants();
    int i2 = arrayOff.length;
    while (i1 < i2)
    {
      f localf = arrayOff[i1];
      if (localf.K) {
        localArrayList.add(localf);
      }
      i1 += 1;
    }
    I = localArrayList;
  }
  
  private f(byte paramByte, boolean paramBoolean)
  {
    this.J = paramByte;
    this.K = paramBoolean;
  }
  
  public static f fromByte(byte paramByte)
  {
    f[] arrayOff = (f[])f.class.getEnumConstants();
    int i2 = arrayOff.length;
    int i1 = 0;
    while (i1 < i2)
    {
      f localf = arrayOff[i1];
      if (localf.J == paramByte) {
        return localf;
      }
      i1 += 1;
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */