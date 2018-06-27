package cn.sharesdk.framework.utils;

public abstract interface Escaper
{
  public abstract Appendable escape(Appendable paramAppendable);
  
  public abstract String escape(String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/utils/Escaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */