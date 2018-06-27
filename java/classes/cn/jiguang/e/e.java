package cn.jiguang.e;

final class e
{
  static void a(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */