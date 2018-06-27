package com.a.a.a;

public class j
{
  private String a;
  private String b;
  
  public j(String paramString)
  {
    int i = paramString.indexOf(':');
    if (i >= 0)
    {
      this.a = paramString.substring(0, i);
      this.b = paramString.substring(i + 1);
      return;
    }
    this.a = "";
    this.b = paramString;
  }
  
  public j(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String getLocalName()
  {
    return this.b;
  }
  
  public String getPrefix()
  {
    return this.a;
  }
  
  public boolean hasPrefix()
  {
    return (this.a != null) && (this.a.length() > 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */