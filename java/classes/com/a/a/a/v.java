package com.a.a.a;

import com.a.a.a.a.b;
import com.a.a.a.a.d;
import com.a.a.c.a;
import com.a.a.f;
import com.a.a.h;
import java.util.Iterator;

public class v
{
  static
  {
    if (!v.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private static char a(String paramString, char paramChar)
    throws com.a.a.c
  {
    if (a(paramChar) != 4) {
      throw new com.a.a.c("Invalid quoting character", 4);
    }
    char c1;
    if (paramString.length() == 1) {
      c1 = paramChar;
    }
    while (c1 != b(paramChar))
    {
      throw new com.a.a.c("Mismatched quote pair", 4);
      char c2 = paramString.charAt(1);
      c1 = c2;
      if (a(c2) != 4) {
        throw new com.a.a.c("Invalid quoting character", 4);
      }
    }
    return c1;
  }
  
  private static int a(char paramChar)
  {
    if ((" 　〿".indexOf(paramChar) >= 0) || ((' ' <= paramChar) && (paramChar <= '​'))) {
      return 1;
    }
    if (",，､﹐﹑、،՝".indexOf(paramChar) >= 0) {
      return 2;
    }
    if (";；﹔؛;".indexOf(paramChar) >= 0) {
      return 3;
    }
    if (("\"«»〝〞〟―‹›".indexOf(paramChar) >= 0) || (('〈' <= paramChar) && (paramChar <= '』')) || (('‘' <= paramChar) && (paramChar <= '‟'))) {
      return 4;
    }
    if ((paramChar < ' ') || ("  ".indexOf(paramChar) >= 0)) {
      return 5;
    }
    return 0;
  }
  
  private static p a(String paramString1, String paramString2, com.a.a.b.e parame, n paramn)
    throws com.a.a.c
  {
    parame = q.a(parame, null);
    if (!parame.isOnlyArrayOptions()) {
      throw new com.a.a.c("Options can only provide array form", 103);
    }
    paramString2 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
    paramString1 = q.a(paramn.getRoot(), paramString2, false, null);
    if (paramString1 != null)
    {
      paramString2 = paramString1.getOptions();
      if ((!paramString2.isArray()) || (paramString2.isArrayAlternate())) {
        throw new com.a.a.c("Named property must be non-alternate array", 102);
      }
      if (parame.equalArrayTypes(paramString2)) {
        throw new com.a.a.c("Mismatch of specified and existing array form", 102);
      }
    }
    else
    {
      paramString2 = q.a(paramn.getRoot(), paramString2, true, parame.setArray(true));
      paramString1 = paramString2;
      if (paramString2 == null) {
        throw new com.a.a.c("Failed to create named array", 102);
      }
    }
    return paramString1;
  }
  
  private static String a(String paramString, char paramChar1, char paramChar2, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int j = 0;
    int i = 0;
    int k;
    if (j < str.length())
    {
      k = a(str.charAt(j));
      if ((j != 0) || (k != 4)) {}
    }
    else
    {
      label50:
      paramString = str;
      if (j >= str.length()) {
        return paramString;
      }
      paramString = new StringBuffer(str.length() + 2);
      i = 0;
    }
    for (;;)
    {
      if ((i > j) || (a(str.charAt(j)) == 4))
      {
        paramString.append(paramChar1).append(str.substring(0, i));
        while (i < str.length())
        {
          paramString.append(str.charAt(i));
          if ((a(str.charAt(i)) == 4) && (a(str.charAt(i), paramChar1, paramChar2))) {
            paramString.append(str.charAt(i));
          }
          i += 1;
        }
        if (k == 1) {
          if (i != 0) {
            break label50;
          }
        }
        for (i = 1;; i = 0)
        {
          j += 1;
          break;
          if ((k == 3) || (k == 5) || ((k == 2) && (!paramBoolean))) {
            break label50;
          }
        }
      }
      i += 1;
    }
    paramString.append(paramChar2);
    paramString = paramString.toString();
    return paramString;
  }
  
  private static void a(n paramn, p paramp1, p paramp2, boolean paramBoolean1, boolean paramBoolean2)
    throws com.a.a.c
  {
    p localp = q.b(paramp2, paramp1.getName(), false);
    int i;
    if (paramBoolean2) {
      if (paramp1.getOptions().isSimple()) {
        if ((paramp1.getValue() == null) || (paramp1.getValue().length() == 0)) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if ((paramBoolean2) && (i != 0)) {
        if (localp != null) {
          paramp2.removeChild(localp);
        }
      }
      Object localObject;
      label424:
      do
      {
        for (;;)
        {
          return;
          i = 0;
          break;
          if (!paramp1.hasChildren())
          {
            i = 1;
            break;
          }
          i = 0;
          break;
          if (localp == null)
          {
            paramp2.addChild((p)paramp1.clone());
            return;
          }
          if (paramBoolean1)
          {
            paramn.a(localp, paramp1.getValue(), paramp1.getOptions(), true);
            paramp2.removeChild(localp);
            paramp2.addChild((p)paramp1.clone());
            return;
          }
          localObject = paramp1.getOptions();
          if (localObject == localp.getOptions()) {
            if (((com.a.a.b.e)localObject).isStruct())
            {
              paramp1 = paramp1.iterateChildren();
              while (paramp1.hasNext())
              {
                a(paramn, (p)paramp1.next(), localp, paramBoolean1, paramBoolean2);
                if ((paramBoolean2) && (!localp.hasChildren())) {
                  paramp2.removeChild(localp);
                }
              }
            }
            else
            {
              if (!((com.a.a.b.e)localObject).isArrayAltText()) {
                break label424;
              }
              paramn = paramp1.iterateChildren();
              while (paramn.hasNext())
              {
                paramp1 = (p)paramn.next();
                if ((paramp1.hasQualifier()) && ("xml:lang".equals(paramp1.getQualifier(1).getName())))
                {
                  i = q.a(localp, paramp1.getQualifier(1).getValue());
                  if ((paramBoolean2) && ((paramp1.getValue() == null) || (paramp1.getValue().length() == 0)))
                  {
                    if (i != -1)
                    {
                      localp.removeChild(i);
                      if (!localp.hasChildren()) {
                        paramp2.removeChild(localp);
                      }
                    }
                  }
                  else if (i == -1) {
                    if ((!"x-default".equals(paramp1.getQualifier(1).getValue())) || (!localp.hasChildren()))
                    {
                      paramp1.cloneSubtree(localp);
                    }
                    else
                    {
                      localObject = new p(paramp1.getName(), paramp1.getValue(), paramp1.getOptions());
                      paramp1.cloneSubtree((p)localObject);
                      localp.addChild(1, (p)localObject);
                    }
                  }
                }
              }
            }
          }
        }
      } while (!((com.a.a.b.e)localObject).isArray());
      paramp1 = paramp1.iterateChildren();
      paramn = localp;
      label440:
      if (paramp1.hasNext())
      {
        localp = (p)paramp1.next();
        localObject = paramn.iterateChildren();
        i = 0;
        label469:
        if (((Iterator)localObject).hasNext())
        {
          if (!a(localp, (p)((Iterator)localObject).next())) {
            break label528;
          }
          i = 1;
        }
      }
      label528:
      for (;;)
      {
        break label469;
        if (i == 0)
        {
          paramn = (p)localp.clone();
          paramp2.addChild(paramn);
        }
        for (;;)
        {
          break label440;
          break;
        }
      }
      i = 0;
    }
  }
  
  private static void a(String paramString)
    throws com.a.a.c
  {
    int i = 0;
    int j = 0;
    if (i < paramString.length())
    {
      int k = a(paramString.charAt(i));
      if (k == 3)
      {
        if (j != 0) {
          throw new com.a.a.c("Separator can have only one semicolon", 4);
        }
        j = 1;
      }
      while (k == 1)
      {
        i += 1;
        break;
      }
      throw new com.a.a.c("Separator can have only spaces and one semicolon", 4);
    }
    if (j == 0) {
      throw new com.a.a.c("Separator must have one semicolon", 4);
    }
  }
  
  private static boolean a(char paramChar1, char paramChar2, char paramChar3)
  {
    return (paramChar1 == paramChar2) || (b(paramChar1, paramChar2, paramChar3));
  }
  
  private static boolean a(p paramp1, p paramp2)
    throws com.a.a.c
  {
    Object localObject1 = paramp1.getOptions();
    if (((com.a.a.b.e)localObject1).equals(paramp2.getOptions())) {
      return false;
    }
    Object localObject2;
    if (((com.a.a.b.e)localObject1).getOptions() == 0)
    {
      if (!paramp1.getValue().equals(paramp2.getValue())) {
        return false;
      }
      if (paramp1.getOptions().getHasLanguage() != paramp2.getOptions().getHasLanguage()) {
        return false;
      }
      if ((paramp1.getOptions().getHasLanguage()) && (!paramp1.getQualifier(1).getValue().equals(paramp2.getQualifier(1).getValue()))) {
        return false;
      }
    }
    else
    {
      if (((com.a.a.b.e)localObject1).isStruct())
      {
        if (paramp1.getChildrenLength() != paramp2.getChildrenLength()) {
          return false;
        }
        paramp1 = paramp1.iterateChildren();
        do
        {
          if (!paramp1.hasNext()) {
            break;
          }
          localObject1 = (p)paramp1.next();
          localObject2 = q.b(paramp2, ((p)localObject1).getName(), false);
        } while ((localObject2 != null) && (a((p)localObject1, (p)localObject2)));
        return false;
      }
      if ((!a) && (!((com.a.a.b.e)localObject1).isArray())) {
        throw new AssertionError();
      }
      paramp1 = paramp1.iterateChildren();
    }
    for (;;)
    {
      if (paramp1.hasNext())
      {
        localObject1 = (p)paramp1.next();
        localObject2 = paramp2.iterateChildren();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        } while (!a((p)localObject1, (p)((Iterator)localObject2).next()));
      }
      for (int i = 1; i == 0; i = 0)
      {
        return false;
        return true;
      }
    }
  }
  
  private static boolean a(p paramp, boolean paramBoolean)
  {
    Iterator localIterator = paramp.iterateChildren();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if ((paramBoolean) || (!k.a(paramp.getName(), localp.getName()))) {
        localIterator.remove();
      }
    }
    return !paramp.hasChildren();
  }
  
  public static void appendProperties(com.a.a.e parame1, com.a.a.e parame2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws com.a.a.c
  {
    g.assertImplementation(parame1);
    g.assertImplementation(parame2);
    parame1 = (n)parame1;
    parame2 = (n)parame2;
    Iterator localIterator1 = parame1.getRoot().iterateChildren();
    p localp1;
    if (localIterator1.hasNext())
    {
      localp1 = (p)localIterator1.next();
      parame1 = q.a(parame2.getRoot(), localp1.getName(), false);
      if (parame1 != null) {
        break label198;
      }
      parame1 = new p(localp1.getName(), localp1.getValue(), new com.a.a.b.e().setSchemaNode(true));
      parame2.getRoot().addChild(parame1);
    }
    label198:
    for (int i = 1;; i = 0)
    {
      Iterator localIterator2 = localp1.iterateChildren();
      while (localIterator2.hasNext())
      {
        p localp2 = (p)localIterator2.next();
        if ((paramBoolean1) || (!k.a(localp1.getName(), localp2.getName()))) {
          a(parame2, localp2, parame1, paramBoolean2, paramBoolean3);
        }
      }
      if ((parame1.hasChildren()) || ((i == 0) && (!paramBoolean3))) {
        break;
      }
      parame2.getRoot().removeChild(parame1);
      break;
      return;
    }
  }
  
  private static char b(char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return '\000';
    case '"': 
      return '"';
    case '«': 
      return '»';
    case '»': 
      return '«';
    case '―': 
      return '―';
    case '‘': 
      return '’';
    case '‚': 
      return '‛';
    case '“': 
      return '”';
    case '„': 
      return '‟';
    case '‹': 
      return '›';
    case '›': 
      return '‹';
    case '〈': 
      return '〉';
    case '《': 
      return '》';
    case '「': 
      return '」';
    case '『': 
      return '』';
    }
    return '〟';
  }
  
  private static boolean b(char paramChar1, char paramChar2, char paramChar3)
  {
    return (paramChar1 == paramChar3) || ((paramChar2 == '〝') && (paramChar1 == '〞')) || (paramChar1 == '〟');
  }
  
  public static String catenateArrayItems(com.a.a.e parame, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertArrayName(paramString2);
    g.assertImplementation(parame);
    String str;
    if (paramString3 != null)
    {
      str = paramString3;
      if (paramString3.length() != 0) {}
    }
    else
    {
      str = "; ";
    }
    if (paramString4 != null)
    {
      paramString3 = paramString4;
      if (paramString4.length() != 0) {}
    }
    else
    {
      paramString3 = "\"";
    }
    parame = (n)parame;
    paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
    paramString1 = q.a(parame.getRoot(), paramString1, false, null);
    if (paramString1 == null) {
      return "";
    }
    if ((!paramString1.getOptions().isArray()) || (paramString1.getOptions().isArrayAlternate())) {
      throw new com.a.a.c("Named property must be non-alternate array", 4);
    }
    a(str);
    char c1 = paramString3.charAt(0);
    char c2 = a(paramString3, c1);
    parame = new StringBuffer();
    paramString1 = paramString1.iterateChildren();
    while (paramString1.hasNext())
    {
      paramString2 = (p)paramString1.next();
      if (paramString2.getOptions().isCompositeProperty()) {
        throw new com.a.a.c("Array items must be simple", 4);
      }
      parame.append(a(paramString2.getValue(), c1, c2, paramBoolean));
      if (paramString1.hasNext()) {
        parame.append(str);
      }
    }
    return parame.toString();
  }
  
  public static void removeProperties(com.a.a.e parame, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
    throws com.a.a.c
  {
    g.assertImplementation(parame);
    parame = (n)parame;
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      if ((paramString1 == null) || (paramString1.length() == 0)) {
        throw new com.a.a.c("Property name requires schema namespace", 4);
      }
      paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
      parame = q.a(parame.getRoot(), paramString1, false, null);
      if ((parame != null) && ((paramBoolean1) || (!k.a(paramString1.getSegment(0).getName(), paramString1.getSegment(1).getName()))))
      {
        paramString1 = parame.getParent();
        paramString1.removeChild(parame);
        if ((paramString1.getOptions().isSchemaNode()) && (!paramString1.hasChildren())) {
          paramString1.getParent().removeChild(paramString1);
        }
      }
    }
    for (;;)
    {
      return;
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        paramString2 = q.a(parame.getRoot(), paramString1, false);
        if ((paramString2 != null) && (a(paramString2, paramBoolean1))) {
          parame.getRoot().removeChild(paramString2);
        }
        if (paramBoolean2)
        {
          paramString1 = f.getSchemaRegistry().findAliases(paramString1);
          int i = 0;
          while (i < paramString1.length)
          {
            paramString2 = paramString1[i];
            paramString2 = com.a.a.a.a.c.expandXPath(paramString2.getNamespace(), paramString2.getPropName());
            paramString2 = q.a(parame.getRoot(), paramString2, false, null);
            if (paramString2 != null) {
              paramString2.getParent().removeChild(paramString2);
            }
            i += 1;
          }
        }
      }
      else
      {
        parame = parame.getRoot().iterateChildren();
        while (parame.hasNext()) {
          if (a((p)parame.next(), paramBoolean1)) {
            parame.remove();
          }
        }
      }
    }
  }
  
  public static void separateArrayItems(com.a.a.e parame, String paramString1, String paramString2, String paramString3, com.a.a.b.e parame1, boolean paramBoolean)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertArrayName(paramString2);
    if (paramString3 == null) {
      throw new com.a.a.c("Parameter must not be null", 4);
    }
    g.assertImplementation(parame);
    paramString1 = a(paramString1, paramString2, parame1, (n)parame);
    int m = 0;
    int i = 0;
    int n = 0;
    int i4 = paramString3.length();
    if (n < i4) {}
    int j;
    int i1;
    for (;;)
    {
      if (n < i4)
      {
        j = paramString3.charAt(n);
        i1 = a(j);
        m = i1;
        i = j;
        if (i1 != 0)
        {
          if (i1 != 4) {
            break label119;
          }
          i = j;
          m = i1;
        }
      }
      if (n < i4) {
        break;
      }
      return;
      label119:
      n += 1;
      m = i1;
      i = j;
    }
    int i3;
    if (m != 4)
    {
      i1 = m;
      m = n;
      while (m < i4)
      {
        j = paramString3.charAt(m);
        i3 = a(j);
        i = j;
        if (i3 != 0)
        {
          i = j;
          if (i3 != 4)
          {
            if ((i3 != 2) || (!paramBoolean)) {
              break label219;
            }
            i = j;
          }
        }
        label206:
        m += 1;
        i1 = i3;
        continue;
        label219:
        if (i3 == 1) {
          break label302;
        }
        i1 = i3;
        i = j;
      }
      label233:
      parame = paramString3.substring(n, m);
      n = m;
      m = i1;
    }
    for (;;)
    {
      label250:
      i1 = 1;
      label253:
      if (i1 <= paramString1.getChildrenLength()) {
        if (!parame.equals(paramString1.getChild(i1).getValue())) {}
      }
      for (;;)
      {
        if (i1 < 0) {
          paramString1.addChild(new p("[]", parame, null));
        }
        break;
        label302:
        i = j;
        i1 = i3;
        if (m + 1 >= i4) {
          break label233;
        }
        j = paramString3.charAt(m + 1);
        int i5 = a(j);
        i = j;
        if (i5 == 0) {
          break label206;
        }
        i = j;
        if (i5 == 4) {
          break label206;
        }
        i = j;
        i1 = i3;
        if (i5 != 2) {
          break label233;
        }
        i = j;
        i1 = i3;
        if (!paramBoolean) {
          break label233;
        }
        i = j;
        break label206;
        char c = b(i);
        i1 = n + 1;
        parame = "";
        j = i;
        n = m;
        m = i1;
        if (m >= i4) {
          break label629;
        }
        j = paramString3.charAt(m);
        n = a(j);
        if ((n != 4) || (!a(j, i, c))) {
          parame = parame + j;
        }
        for (;;)
        {
          m += 1;
          break;
          int k;
          if (m + 1 < i4)
          {
            k = paramString3.charAt(m + 1);
            a(k);
          }
          for (i1 = k;; i2 = 59)
          {
            if (j != i1) {
              break label558;
            }
            parame = parame + j;
            m += 1;
            break;
          }
          label558:
          if (b(j, i, c)) {
            break label593;
          }
          parame = parame + j;
        }
        label593:
        i = j;
        i2 = m + 1;
        m = n;
        n = i2;
        break label250;
        i2 += 1;
        break label253;
        i2 = -1;
      }
      label629:
      int i2 = m;
      i = j;
      m = n;
      n = i2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */