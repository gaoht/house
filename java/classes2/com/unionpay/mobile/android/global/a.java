package com.unionpay.mobile.android.global;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.unionpay.mobile.android.utils.f;

public final class a
{
  public static int A;
  public static int B;
  public static int C;
  public static int D;
  public static int E;
  public static int F;
  public static int G;
  public static int H;
  public static int I;
  public static int J;
  public static int K;
  public static boolean L = true;
  public static int M = 0;
  public static int N = 0;
  private static boolean O;
  public static int a = 48;
  public static int b = 8;
  public static int c = 4;
  public static int d = 12;
  public static int e = 8;
  public static int f = 8;
  public static int g = 4;
  public static int h = 8;
  public static int i = 2;
  public static int j = 16;
  public static int k = 52;
  public static int l = 320;
  public static int m = 32;
  public static int n = 54;
  public static int o = 45;
  public static int p = 35;
  public static int q = 40;
  public static int r = 54;
  public static int s = 10;
  public static int t = 0;
  public static int u = 28;
  public static int v = 30;
  public static int w = 22;
  public static int x = 40;
  public static int y = n;
  public static int z = 46;
  
  static
  {
    A = 45;
    B = 32;
    C = 6;
    D = 25;
    E = 95;
    F = 25;
    G = 25;
    H = 1;
    I = 0;
    J = 5;
    K = 1;
    O = false;
  }
  
  public static void a(Context paramContext)
  {
    b.a(paramContext);
    if (!O)
    {
      a = f.a(paramContext, a);
      b = f.a(paramContext, b);
      c = f.a(paramContext, c);
      d = f.a(paramContext, d);
      e = f.a(paramContext, e);
      f = f.a(paramContext, f);
      g = f.a(paramContext, g);
      h = f.a(paramContext, h);
      i = f.a(paramContext, i);
      j = f.a(paramContext, j);
      k = f.a(paramContext, k);
      m = f.a(paramContext, m);
      n = f.a(paramContext, n);
      o = f.a(paramContext, o);
      p = f.a(paramContext, p);
      q = f.a(paramContext, q);
      r = f.a(paramContext, r);
      s = f.a(paramContext, s);
      u = f.a(paramContext, u);
      v = f.a(paramContext, v);
      w = f.a(paramContext, w);
      z = f.a(paramContext, z);
      x = f.a(paramContext, x);
      A = f.a(paramContext, A);
      B = f.a(paramContext, B);
      C = f.a(paramContext, C);
      y = f.a(paramContext, y);
      D = f.a(paramContext, D);
      E = f.a(paramContext, E);
      F = f.a(paramContext, F);
      G = f.a(paramContext, G);
      H = f.a(paramContext, H);
      K = (int)(paramContext.getResources().getDisplayMetrics().density + 0.5D);
      I = paramContext.getResources().getDisplayMetrics().widthPixels;
      t = paramContext.getResources().getDisplayMetrics().heightPixels;
      if (I > t)
      {
        int i1 = I + t;
        I = i1;
        t = i1 - t;
        I -= t;
      }
      J = f.a(paramContext, J);
      O = true;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/global/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */