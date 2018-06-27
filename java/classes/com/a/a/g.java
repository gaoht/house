package com.a.a;

import com.a.a.a.a.b;
import com.a.a.a.a.d;
import com.a.a.a.k;

public final class g
{
  private static void a(String paramString)
    throws c
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new c("Empty qualifier namespace URI", 101);
    }
  }
  
  private static void b(String paramString)
    throws c
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new c("Empty qualifier name", 102);
    }
  }
  
  private static void c(String paramString)
    throws c
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new c("Empty field namespace URI", 101);
    }
  }
  
  public static String composeArrayItemPath(String paramString, int paramInt)
    throws c
  {
    if (paramInt > 0) {
      return paramString + '[' + paramInt + ']';
    }
    if (paramInt == -1) {
      return paramString + "[last()]";
    }
    throw new c("Array index must be larger than zero", 104);
  }
  
  public static String composeFieldSelector(String paramString1, String paramString2, String paramString3, String paramString4)
    throws c
  {
    paramString2 = com.a.a.a.a.c.expandXPath(paramString2, paramString3);
    if (paramString2.size() != 2) {
      throw new c("The fieldName name must be simple", 102);
    }
    return paramString1 + '[' + paramString2.getSegment(1).getName() + "=\"" + paramString4 + "\"]";
  }
  
  public static String composeLangSelector(String paramString1, String paramString2)
  {
    return paramString1 + "[?xml:lang=\"" + k.normalizeLangValue(paramString2) + "\"]";
  }
  
  public static String composeQualifierPath(String paramString1, String paramString2)
    throws c
  {
    a(paramString1);
    b(paramString2);
    paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
    if (paramString1.size() != 2) {
      throw new c("The qualifier name must be simple", 102);
    }
    return "/?" + paramString1.getSegment(1).getName();
  }
  
  public static String composeStructFieldPath(String paramString1, String paramString2)
    throws c
  {
    c(paramString1);
    d(paramString2);
    paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
    if (paramString1.size() != 2) {
      throw new c("The field name must be simple", 102);
    }
    return '/' + paramString1.getSegment(1).getName();
  }
  
  private static void d(String paramString)
    throws c
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new c("Empty f name", 102);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */