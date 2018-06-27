package com.alipay.android.a.a.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

public final class z
  extends ae
{
  String a;
  byte[] b;
  String c;
  ArrayList<Header> d;
  boolean e;
  private Map<String, String> h;
  
  public z(String paramString)
  {
    this.a = paramString;
    this.d = new ArrayList();
    this.h = new HashMap();
    this.c = "application/x-www-form-urlencoded";
  }
  
  public final String a(String paramString)
  {
    if (this.h == null) {
      return null;
    }
    return (String)this.h.get(paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.h == null) {
      this.h = new HashMap();
    }
    this.h.put(paramString1, paramString2);
  }
  
  public final void a(Header paramHeader)
  {
    this.d.add(paramHeader);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (z)paramObject;
        if (this.b == null)
        {
          if (((z)paramObject).b != null) {
            return false;
          }
        }
        else if (!this.b.equals(((z)paramObject).b)) {
          return false;
        }
        if (this.a != null) {
          break;
        }
      } while (((z)paramObject).a == null);
      return false;
    } while (this.a.equals(((z)paramObject).a));
    return false;
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = j;
    if (this.h != null)
    {
      i = j;
      if (this.h.containsKey("id")) {
        i = ((String)this.h.get("id")).hashCode() + 31;
      }
    }
    if (this.a == null) {}
    for (j = 0;; j = this.a.hashCode()) {
      return j + i * 31;
    }
  }
  
  public final String toString()
  {
    return String.format("Url : %s,HttpHeader: %s", new Object[] { this.a, this.d });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/android/a/a/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */