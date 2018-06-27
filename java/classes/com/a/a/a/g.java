package com.a.a.a;

import com.a.a.c;
import com.a.a.e;

class g
{
  public static void assertArrayName(String paramString)
    throws c
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new c("Empty array name", 4);
    }
  }
  
  public static void assertImplementation(e parame)
    throws c
  {
    if (parame == null) {
      throw new c("Parameter must not be null", 4);
    }
    if (!(parame instanceof n)) {
      throw new c("The XMPMeta-object is not compatible with this implementation", 4);
    }
  }
  
  public static void assertNotNull(Object paramObject)
    throws c
  {
    if (paramObject == null) {
      throw new c("Parameter must not be null", 4);
    }
    if (((paramObject instanceof String)) && (((String)paramObject).length() == 0)) {
      throw new c("Parameter must not be null or empty", 4);
    }
  }
  
  public static void assertPrefix(String paramString)
    throws c
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new c("Empty prefix", 4);
    }
  }
  
  public static void assertPropName(String paramString)
    throws c
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new c("Empty property name", 4);
    }
  }
  
  public static void assertSchemaNS(String paramString)
    throws c
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new c("Empty schema namespace URI", 4);
    }
  }
  
  public static void assertSpecificLang(String paramString)
    throws c
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new c("Empty specific language", 4);
    }
  }
  
  public static void assertStructName(String paramString)
    throws c
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new c("Empty array name", 4);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */