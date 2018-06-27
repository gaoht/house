package cn.jiguang.a.c;

public final class b
{
  private static b a;
  
  public static b a()
  {
    if (a == null) {
      a = new b();
    }
    return a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */