package com.a.a;

import com.a.a.c.a;
import java.util.Map;

public abstract interface h
{
  public abstract void deleteNamespace(String paramString);
  
  public abstract a findAlias(String paramString);
  
  public abstract a[] findAliases(String paramString);
  
  public abstract Map getAliases();
  
  public abstract String getNamespacePrefix(String paramString);
  
  public abstract String getNamespaceURI(String paramString);
  
  public abstract Map getNamespaces();
  
  public abstract Map getPrefixes();
  
  public abstract String registerNamespace(String paramString1, String paramString2)
    throws c;
  
  public abstract a resolveAlias(String paramString1, String paramString2);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */