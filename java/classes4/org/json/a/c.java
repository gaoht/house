package org.json.a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c
{
  public static final Object b = new a((byte)0);
  public Map a;
  
  public c()
  {
    this.a = new HashMap();
  }
  
  public c(String paramString)
  {
    this(new d(paramString));
  }
  
  public c(Map paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    this.a = ((Map)localObject);
  }
  
  public c(d paramd)
  {
    this();
    if (paramd.c() != '{') {
      throw paramd.a("A JSONObject text must begin with '{'");
    }
    do
    {
      paramd.a();
      String str;
      int i;
      switch (paramd.c())
      {
      default: 
        paramd.a();
        str = paramd.d().toString();
        i = paramd.c();
        if (i == 61) {
          if (paramd.b() != '>') {
            paramd.a();
          }
        }
      case '\000': 
        Object localObject;
        while (i == 58)
        {
          localObject = paramd.d();
          if (str != null) {
            break;
          }
          throw new a("Null key.");
          throw paramd.a("A JSONObject text must end with '}'");
        }
        throw paramd.a("Expected a ':' after a key");
        if (localObject != null)
        {
          b(localObject);
          this.a.put(str, localObject);
        }
        for (;;)
        {
          switch (paramd.c())
          {
          default: 
            throw paramd.a("Expected a ',' or '}'");
            this.a.remove(str);
          }
        }
      }
    } while (paramd.c() != '}');
  }
  
  static String a(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.equals(null))) {
      paramObject = "null";
    }
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return (String)paramObject;
            if (!(paramObject instanceof Number)) {
              break;
            }
            paramObject = (Number)paramObject;
            if (paramObject == null) {
              throw new a("Null pointer");
            }
            b(paramObject);
            str = paramObject.toString();
            paramObject = str;
          } while (str.indexOf('.') <= 0);
          paramObject = str;
        } while (str.indexOf('e') >= 0);
        paramObject = str;
      } while (str.indexOf('E') >= 0);
      while (str.endsWith("0")) {
        str = str.substring(0, str.length() - 1);
      }
      paramObject = str;
    } while (!str.endsWith("."));
    return str.substring(0, str.length() - 1);
    if (((paramObject instanceof Boolean)) || ((paramObject instanceof c)) || ((paramObject instanceof b))) {
      return paramObject.toString();
    }
    if ((paramObject instanceof Map)) {
      return new c((Map)paramObject).toString();
    }
    if ((paramObject instanceof Collection)) {
      return new b((Collection)paramObject).toString();
    }
    if (paramObject.getClass().isArray()) {
      return new b(paramObject).toString();
    }
    return b(paramObject.toString());
  }
  
  public static String b(String paramString)
  {
    int i = 0;
    if ((paramString == null) || (paramString.length() == 0)) {
      return "\"\"";
    }
    int k = paramString.length();
    StringBuffer localStringBuffer = new StringBuffer(k + 4);
    localStringBuffer.append('"');
    int j = 0;
    if (i < k)
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        if ((c < ' ') || ((c >= '') && (c < ' ')) || ((c >= ' ') && (c < '℀')))
        {
          String str = "000" + Integer.toHexString(c);
          localStringBuffer.append("\\u" + str.substring(str.length() - 4));
        }
        break;
      }
      for (;;)
      {
        i += 1;
        j = c;
        break;
        localStringBuffer.append('\\');
        localStringBuffer.append(c);
        continue;
        if (j == 60) {
          localStringBuffer.append('\\');
        }
        localStringBuffer.append(c);
        continue;
        localStringBuffer.append("\\b");
        continue;
        localStringBuffer.append("\\t");
        continue;
        localStringBuffer.append("\\n");
        continue;
        localStringBuffer.append("\\f");
        continue;
        localStringBuffer.append("\\r");
        continue;
        localStringBuffer.append(c);
      }
    }
    localStringBuffer.append('"');
    return localStringBuffer.toString();
  }
  
  private static void b(Object paramObject)
  {
    if (paramObject != null) {
      if ((paramObject instanceof Double))
      {
        if ((((Double)paramObject).isInfinite()) || (((Double)paramObject).isNaN())) {
          throw new a("JSON does not allow non-finite numbers.");
        }
      }
      else if (((paramObject instanceof Float)) && ((((Float)paramObject).isInfinite()) || (((Float)paramObject).isNaN()))) {
        throw new a("JSON does not allow non-finite numbers.");
      }
    }
  }
  
  public final Object a(String paramString)
  {
    if (paramString == null) {}
    for (Object localObject = null; localObject == null; localObject = this.a.get(paramString)) {
      throw new a("JSONObject[" + b(paramString) + "] not found.");
    }
    return localObject;
  }
  
  public final Iterator a()
  {
    return this.a.keySet().iterator();
  }
  
  public String toString()
  {
    try
    {
      Object localObject1 = a();
      StringBuffer localStringBuffer = new StringBuffer("{");
      while (((Iterator)localObject1).hasNext())
      {
        if (localStringBuffer.length() > 1) {
          localStringBuffer.append(',');
        }
        Object localObject2 = ((Iterator)localObject1).next();
        localStringBuffer.append(b(localObject2.toString()));
        localStringBuffer.append(':');
        localStringBuffer.append(a(this.a.get(localObject2)));
      }
      localStringBuffer.append('}');
      localObject1 = localStringBuffer.toString();
      return (String)localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static final class a
  {
    protected final Object clone()
    {
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      return (paramObject == null) || (paramObject == this);
    }
    
    public final String toString()
    {
      return "null";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/json/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */