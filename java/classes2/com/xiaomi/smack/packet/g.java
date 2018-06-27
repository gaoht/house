package com.xiaomi.smack.packet;

public class g
{
  private String a;
  
  public g(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stream:error (").append(this.a).append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/packet/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */