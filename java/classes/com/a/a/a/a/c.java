package com.a.a.a.a;

import com.a.a.a.k;
import com.a.a.f;
import com.a.a.h;

public final class c
{
  private static d a(a parama)
    throws com.a.a.c
  {
    parama.b = parama.d;
    while ((parama.e < parama.a.length()) && ("/[*".indexOf(parama.a.charAt(parama.e)) < 0)) {
      parama.e += 1;
    }
    parama.c = parama.e;
    if (parama.e == parama.d) {
      throw new com.a.a.c("Empty XMPPath segment", 102);
    }
    return new d(parama.a.substring(parama.d, parama.e), 1);
  }
  
  private static String a(String paramString1, String paramString2)
    throws com.a.a.c
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      throw new com.a.a.c("Schema namespace URI is required", 101);
    }
    if ((paramString2.charAt(0) == '?') || (paramString2.charAt(0) == '@')) {
      throw new com.a.a.c("Top level name must not be a qualifier", 102);
    }
    if ((paramString2.indexOf('/') >= 0) || (paramString2.indexOf('[') >= 0)) {
      throw new com.a.a.c("Top level name must be simple", 102);
    }
    String str = f.getSchemaRegistry().getNamespacePrefix(paramString1);
    if (str == null) {
      throw new com.a.a.c("Unregistered schema namespace URI", 101);
    }
    int i = paramString2.indexOf(':');
    if (i < 0)
    {
      b(paramString2);
      paramString2 = str + paramString2;
    }
    do
    {
      return paramString2;
      b(paramString2.substring(0, i));
      b(paramString2.substring(i));
      str = paramString2.substring(0, i + 1);
      paramString1 = f.getSchemaRegistry().getNamespacePrefix(paramString1);
      if (paramString1 == null) {
        throw new com.a.a.c("Unknown schema namespace prefix", 101);
      }
    } while (str.equals(paramString1));
    throw new com.a.a.c("Schema namespace URI and prefix mismatch", 101);
  }
  
  private static void a(String paramString)
    throws com.a.a.c
  {
    int i = paramString.indexOf(':');
    if (i > 0)
    {
      paramString = paramString.substring(0, i);
      if (k.isXMLNameNS(paramString))
      {
        if (f.getSchemaRegistry().getNamespaceURI(paramString) != null) {
          return;
        }
        throw new com.a.a.c("Unknown namespace prefix for qualified name", 102);
      }
    }
    throw new com.a.a.c("Ill-formed qualified name", 102);
  }
  
  private static void a(String paramString, a parama)
    throws com.a.a.c
  {
    if (paramString.charAt(parama.d) == '/')
    {
      parama.d += 1;
      if (parama.d >= paramString.length()) {
        throw new com.a.a.c("Empty XMPPath segment", 102);
      }
    }
    if (paramString.charAt(parama.d) == '*')
    {
      parama.d += 1;
      if ((parama.d >= paramString.length()) || (paramString.charAt(parama.d) != '[')) {
        throw new com.a.a.c("Missing '[' after '*'", 102);
      }
    }
  }
  
  private static void a(String paramString, a parama, b paramb)
    throws com.a.a.c
  {
    while ((parama.e < parama.a.length()) && ("/[*".indexOf(parama.a.charAt(parama.e)) < 0)) {
      parama.e += 1;
    }
    if (parama.e == parama.d) {
      throw new com.a.a.c("Empty initial XMPPath step", 102);
    }
    String str = a(paramString, parama.a.substring(parama.d, parama.e));
    parama = f.getSchemaRegistry().findAlias(str);
    if (parama == null)
    {
      paramb.add(new d(paramString, Integer.MIN_VALUE));
      paramb.add(new d(str, 1));
    }
    do
    {
      return;
      paramb.add(new d(parama.getNamespace(), Integer.MIN_VALUE));
      paramString = new d(a(parama.getNamespace(), parama.getPropName()), 1);
      paramString.setAlias(true);
      paramString.setAliasForm(parama.getAliasForm().getOptions());
      paramb.add(paramString);
      if (parama.getAliasForm().isArrayAltText())
      {
        paramString = new d("[?xml:lang='x-default']", 5);
        paramString.setAlias(true);
        paramString.setAliasForm(parama.getAliasForm().getOptions());
        paramb.add(paramString);
        return;
      }
    } while (!parama.getAliasForm().isArray());
    paramString = new d("[1]", 3);
    paramString.setAlias(true);
    paramString.setAliasForm(parama.getAliasForm().getOptions());
    paramb.add(paramString);
  }
  
  private static d b(a parama)
    throws com.a.a.c
  {
    parama.e += 1;
    d locald;
    if (('0' <= parama.a.charAt(parama.e)) && (parama.a.charAt(parama.e) <= '9'))
    {
      while ((parama.e < parama.a.length()) && ('0' <= parama.a.charAt(parama.e)) && (parama.a.charAt(parama.e) <= '9')) {
        parama.e += 1;
      }
      locald = new d(null, 3);
    }
    while ((parama.e >= parama.a.length()) || (parama.a.charAt(parama.e) != ']'))
    {
      throw new com.a.a.c("Missing ']' for array index", 102);
      while ((parama.e < parama.a.length()) && (parama.a.charAt(parama.e) != ']') && (parama.a.charAt(parama.e) != '=')) {
        parama.e += 1;
      }
      if (parama.e >= parama.a.length()) {
        throw new com.a.a.c("Missing ']' or '=' for array index", 102);
      }
      if (parama.a.charAt(parama.e) == ']')
      {
        if (!"[last()".equals(parama.a.substring(parama.d, parama.e))) {
          throw new com.a.a.c("Invalid non-numeric array index", 102);
        }
        locald = new d(null, 4);
      }
      else
      {
        parama.b = (parama.d + 1);
        parama.c = parama.e;
        parama.e += 1;
        int i = parama.a.charAt(parama.e);
        if ((i != 39) && (i != 34)) {
          throw new com.a.a.c("Invalid quote in array selector", 102);
        }
        for (parama.e += 1;; parama.e += 1)
        {
          if (parama.e < parama.a.length())
          {
            if (parama.a.charAt(parama.e) != i) {
              continue;
            }
            if ((parama.e + 1 < parama.a.length()) && (parama.a.charAt(parama.e + 1) == i)) {}
          }
          else
          {
            if (parama.e < parama.a.length()) {
              break;
            }
            throw new com.a.a.c("No terminating quote for array selector", 102);
          }
          parama.e += 1;
        }
        parama.e += 1;
        locald = new d(null, 6);
      }
    }
    parama.e += 1;
    locald.setName(parama.a.substring(parama.d, parama.e));
    return locald;
  }
  
  private static void b(String paramString)
    throws com.a.a.c
  {
    if (!k.isXMLName(paramString)) {
      throw new com.a.a.c("Bad XML name", 102);
    }
  }
  
  public static b expandXPath(String paramString1, String paramString2)
    throws com.a.a.c
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new com.a.a.c("Parameter must not be null", 4);
    }
    b localb = new b();
    a locala = new a();
    locala.a = paramString2;
    a(paramString1, locala, localb);
    if (locala.e < paramString2.length())
    {
      locala.d = locala.e;
      a(paramString2, locala);
      locala.e = locala.d;
      if (paramString2.charAt(locala.d) != '[') {
        paramString1 = a(locala);
      }
      while (paramString1.getKind() == 1)
      {
        if (paramString1.getName().charAt(0) == '@')
        {
          paramString1.setName("?" + paramString1.getName().substring(1));
          if (!"?xml:lang".equals(paramString1.getName()))
          {
            throw new com.a.a.c("Only xml:lang allowed with '@'", 102);
            paramString1 = b(locala);
            continue;
          }
        }
        if (paramString1.getName().charAt(0) == '?')
        {
          locala.b += 1;
          paramString1.setKind(2);
        }
        a(locala.a.substring(locala.b, locala.c));
      }
      for (;;)
      {
        localb.add(paramString1);
        break;
        if (paramString1.getKind() == 6)
        {
          if (paramString1.getName().charAt(1) == '@')
          {
            paramString1.setName("[?" + paramString1.getName().substring(2));
            if (!paramString1.getName().startsWith("[?xml:lang=")) {
              throw new com.a.a.c("Only xml:lang allowed with '@'", 102);
            }
          }
          if (paramString1.getName().charAt(1) == '?')
          {
            locala.b += 1;
            paramString1.setKind(5);
            a(locala.a.substring(locala.b, locala.c));
          }
        }
      }
    }
    return localb;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */