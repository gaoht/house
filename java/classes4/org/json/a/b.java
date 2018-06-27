package org.json.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class b
{
  public ArrayList a;
  
  public b()
  {
    this.a = new ArrayList();
  }
  
  public b(Object paramObject)
  {
    this();
    if (paramObject.getClass().isArray())
    {
      int j = Array.getLength(paramObject);
      int i = 0;
      while (i < j)
      {
        Object localObject = Array.get(paramObject, i);
        this.a.add(localObject);
        i += 1;
      }
    }
    throw new a("JSONArray initial value should be a string or collection or array.");
  }
  
  public b(String paramString)
  {
    this(new d(paramString));
  }
  
  public b(Collection paramCollection)
  {
    if (paramCollection == null) {}
    for (paramCollection = new ArrayList();; paramCollection = new ArrayList(paramCollection))
    {
      this.a = paramCollection;
      return;
    }
  }
  
  public b(d paramd)
  {
    this();
    int i = paramd.c();
    char c;
    if (i == 91)
    {
      c = ']';
      if (paramd.c() != ']') {
        break label47;
      }
    }
    label47:
    do
    {
      return;
      if (i == 40)
      {
        c = ')';
        break;
      }
      throw paramd.a("A JSONArray text must start with '['");
      paramd.a();
      for (;;)
      {
        if (paramd.c() == ',')
        {
          paramd.a();
          this.a.add(null);
        }
        for (;;)
        {
          i = paramd.c();
          switch (i)
          {
          default: 
            throw paramd.a("Expected a ',' or ']'");
            paramd.a();
            this.a.add(paramd.d());
          }
        }
        if (paramd.c() == ']') {
          break;
        }
        paramd.a();
      }
    } while (c == i);
    throw paramd.a("Expected a '" + new Character(c) + "'");
  }
  
  private String a(String paramString)
  {
    int j = this.a.size();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuffer.append(paramString);
      }
      localStringBuffer.append(c.a(this.a.get(i)));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public final Object a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a.size())) {}
    for (Object localObject = null; localObject == null; localObject = this.a.get(paramInt)) {
      throw new a("JSONArray[" + paramInt + "] not found.");
    }
    return localObject;
  }
  
  public String toString()
  {
    try
    {
      String str = "[" + a(",") + ']';
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/json/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */