package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.a;

public class SymbolTable
{
  private final int indexMask;
  private final String[] symbols;
  
  public SymbolTable(int paramInt)
  {
    this.indexMask = (paramInt - 1);
    this.symbols = new String[paramInt];
    addSymbol("$ref", 0, 4, "$ref".hashCode());
    addSymbol(a.c, 0, a.c.length(), a.c.hashCode());
  }
  
  public static int hash(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int j = 0;
    int k = 0;
    int i = paramInt1;
    for (paramInt1 = k; j < paramInt2; paramInt1 = paramInt1 * 31 + k)
    {
      k = paramArrayOfChar[i];
      j += 1;
      i += 1;
    }
    return paramInt1;
  }
  
  private static String subString(String paramString, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    paramString.getChars(paramInt1, paramInt1 + paramInt2, arrayOfChar, 0);
    return new String(arrayOfChar);
  }
  
  public String addSymbol(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3 & this.indexMask;
    String str = this.symbols[i];
    if (str != null)
    {
      if ((paramInt3 == str.hashCode()) && (paramInt2 == str.length()) && (paramString.startsWith(str, paramInt1))) {
        return str;
      }
      return subString(paramString, paramInt1, paramInt2);
    }
    if (paramInt2 == paramString.length()) {}
    for (;;)
    {
      paramString = paramString.intern();
      this.symbols[i] = paramString;
      return paramString;
      paramString = subString(paramString, paramInt1, paramInt2);
    }
  }
  
  public String addSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return addSymbol(paramArrayOfChar, paramInt1, paramInt2, hash(paramArrayOfChar, paramInt1, paramInt2));
  }
  
  public String addSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = this.indexMask & paramInt3;
    String str = this.symbols[i];
    if (str != null)
    {
      i = j;
      if (paramInt3 == str.hashCode())
      {
        i = j;
        if (paramInt2 == str.length())
        {
          paramInt3 = 0;
          if (paramInt3 >= paramInt2) {
            break label134;
          }
          if (paramArrayOfChar[(paramInt1 + paramInt3)] == str.charAt(paramInt3)) {
            break label90;
          }
        }
      }
    }
    label90:
    label134:
    for (i = j;; i = 1)
    {
      if (i != 0)
      {
        return str;
        paramInt3 += 1;
        break;
      }
      return new String(paramArrayOfChar, paramInt1, paramInt2);
      paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2).intern();
      this.symbols[i] = paramArrayOfChar;
      return paramArrayOfChar;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/SymbolTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */