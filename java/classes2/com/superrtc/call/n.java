package com.superrtc.call;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class n
{
  public final List<a> a = new LinkedList();
  public final List<a> b = new LinkedList();
  
  private static String a(List<a> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      if (localStringBuilder.length() > 1) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(locala.toString());
    }
    return "]";
  }
  
  public String toString()
  {
    return "mandatory: " + a(this.a) + ", optional: " + a(this.b);
  }
  
  public static class a
  {
    private final String a;
    private final String b;
    
    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (a)paramObject;
      } while ((this.a.equals(((a)paramObject).a)) && (this.b.equals(((a)paramObject).b)));
      return false;
    }
    
    public String getKey()
    {
      return this.a;
    }
    
    public String getValue()
    {
      return this.b;
    }
    
    public int hashCode()
    {
      return this.a.hashCode() + this.b.hashCode();
    }
    
    public String toString()
    {
      return this.a + ": " + this.b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */