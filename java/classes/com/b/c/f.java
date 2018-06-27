package com.b.c;

public class f
{
  private final int a;
  private final b b;
  
  public f(int paramInt, b paramb)
  {
    this.a = paramInt;
    this.b = paramb;
  }
  
  public String getDescription()
  {
    return this.b.getDescription(this.a);
  }
  
  public String getDirectoryName()
  {
    return this.b.getName();
  }
  
  public String getTagName()
  {
    return this.b.getTagName(this.a);
  }
  
  public int getTagType()
  {
    return this.a;
  }
  
  public String getTagTypeHex()
  {
    return String.format("0x%04x", new Object[] { Integer.valueOf(this.a) });
  }
  
  public boolean hasTagName()
  {
    return this.b.hasTagName(this.a);
  }
  
  public String toString()
  {
    String str2 = getDescription();
    String str1 = str2;
    if (str2 == null) {
      str1 = this.b.getString(getTagType()) + " (unable to formulate description)";
    }
    return "[" + this.b.getName() + "] " + getTagName() + " - " + str1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */