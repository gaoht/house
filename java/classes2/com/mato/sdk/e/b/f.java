package com.mato.sdk.e.b;

import android.text.TextUtils;
import com.mato.sdk.e.b.c.a;
import com.mato.sdk.e.b.c.d;
import com.mato.sdk.e.b.c.e;
import java.util.ArrayList;
import java.util.List;

public final class f
{
  private static final String a = "127.0.0.1";
  private static final String b = "手机信息";
  private static final String c = "网络连接";
  private static final String d = "下载检测";
  private static String e = "正常";
  private static int f = 1;
  private static int g = 2;
  private static int h = 4;
  private static int i = 15;
  private final int j;
  private final g k;
  private a l;
  private final List<Integer> m = new ArrayList();
  
  public f(int paramInt, g paramg)
  {
    this.j = paramInt;
    this.k = paramg;
  }
  
  private a k()
  {
    if (this.l == null) {
      this.l = new a(this.k);
    }
    return this.l;
  }
  
  public final g a()
  {
    return this.k;
  }
  
  public final List<Integer> b()
  {
    return this.m;
  }
  
  final int c()
  {
    if (this.j == 15) {
      return 100;
    }
    if ((this.j & 0x1) == 1) {}
    for (int i1 = 10;; i1 = 0)
    {
      int n = i1;
      if ((this.j & 0x2) == 2) {
        n = i1 + this.k.s * 30 / this.k.t;
      }
      i1 = n;
      if ((this.j & 0x4) == 4) {
        i1 = n + this.k.q * 60 / this.k.r;
      }
      return i1;
    }
  }
  
  public final int d()
  {
    return this.j;
  }
  
  final a e()
  {
    boolean bool2 = false;
    boolean bool1 = true;
    ArrayList localArrayList = new ArrayList(2);
    if (!this.k.i.equalsIgnoreCase("127.0.0.1"))
    {
      localArrayList.add(e.a(2000));
      bool1 = false;
    }
    String str = this.k.h;
    if (str.equalsIgnoreCase("3gwap"))
    {
      localArrayList.add(e.a(2001));
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1) {
        localArrayList.add("正常");
      }
      return new a(bool1, "手机信息", localArrayList);
      if (str.equalsIgnoreCase("cmwap"))
      {
        localArrayList.add(e.a(2002));
        bool1 = bool2;
      }
      else if (str.equalsIgnoreCase("ctwap"))
      {
        localArrayList.add(e.a(2003));
        bool1 = bool2;
      }
    }
  }
  
  final a f()
  {
    d locald = new d(this.k, k());
    ArrayList localArrayList = new ArrayList();
    boolean bool = locald.b().isEmpty();
    if (bool) {
      localArrayList.add("正常");
    }
    for (;;)
    {
      return new a(bool, "网络连接", localArrayList);
      localArrayList.addAll(locald.b());
      this.m.addAll(locald.c());
    }
  }
  
  final a g()
  {
    a locala = k();
    ArrayList localArrayList = new ArrayList();
    boolean bool = locala.a();
    if (bool) {
      localArrayList.add("正常");
    }
    for (;;)
    {
      return new a(bool, "下载检测", localArrayList);
      localArrayList.addAll(locala.b());
      this.m.addAll(locala.c());
    }
  }
  
  public final String h()
  {
    if (!this.k.a) {
      return e.a(1000);
    }
    if (this.k.b) {
      return "网络检测启动成功，当前加速";
    }
    return "网络检测启动成功，当前未加速";
  }
  
  public final a i()
  {
    if (TextUtils.isEmpty(this.k.l)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(1);
    if (this.k.l.contains("3gwap")) {
      localArrayList.add(e.a(2001));
    }
    for (;;)
    {
      return new a(false, "手机信息", localArrayList);
      if (this.k.l.contains("localhost")) {
        localArrayList.add(e.a(2000));
      } else {
        localArrayList.add(this.k.l);
      }
    }
  }
  
  public final boolean j()
  {
    return this.k.a;
  }
  
  public static final class a
  {
    public boolean a;
    public String b;
    public List<String> c;
    
    public a(boolean paramBoolean, String paramString, List<String> paramList)
    {
      this.a = paramBoolean;
      this.b = paramString;
      this.c = paramList;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */