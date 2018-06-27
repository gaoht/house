package com.a.a.a;

import com.a.a.a;
import com.a.a.a.a.d;
import com.a.a.b.e;
import com.a.a.c;
import com.a.a.f;
import com.a.a.h;
import com.a.a.i;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class q
{
  static
  {
    if (!q.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  static int a(p paramp, String paramString)
    throws c
  {
    if (!paramp.getOptions().isArray()) {
      throw new c("Language item must be used on array", 102);
    }
    int i = 1;
    if (i <= paramp.getChildrenLength())
    {
      p localp = paramp.getChild(i);
      if ((!localp.hasQualifier()) || (!"xml:lang".equals(localp.getQualifier(1).getName()))) {}
      while (!paramString.equals(localp.getQualifier(1).getValue()))
      {
        i += 1;
        break;
      }
      return i;
    }
    return -1;
  }
  
  private static int a(p paramp, String paramString1, String paramString2, int paramInt)
    throws c
  {
    if ("xml:lang".equals(paramString1))
    {
      int i = a(paramp, k.normalizeLangValue(paramString2));
      if ((i < 0) && ((paramInt & 0x1000) > 0))
      {
        paramString1 = new p("[]", null);
        paramString1.addQualifier(new p("xml:lang", "x-default", null));
        paramp.addChild(1, paramString1);
        return 1;
      }
      return i;
    }
    paramInt = 1;
    while (paramInt < paramp.getChildrenLength())
    {
      Iterator localIterator = paramp.getChild(paramInt).iterateQualifier();
      while (localIterator.hasNext())
      {
        p localp = (p)localIterator.next();
        if ((paramString1.equals(localp.getName())) && (paramString2.equals(localp.getValue()))) {
          return paramInt;
        }
      }
      paramInt += 1;
    }
    return -1;
  }
  
  static p a(p paramp, com.a.a.a.a.b paramb, boolean paramBoolean, e parame)
    throws c
  {
    if ((paramb == null) || (paramb.size() == 0)) {
      throw new c("Empty XMPPath", 102);
    }
    p localp1 = a(paramp, paramb.getSegment(0).getName(), paramBoolean);
    if (localp1 == null) {
      return null;
    }
    label62:
    int i;
    if (localp1.isImplicit())
    {
      localp1.setImplicit(false);
      paramp = localp1;
      i = 1;
    }
    for (;;)
    {
      try
      {
        if (i >= paramb.size()) {
          break label230;
        }
        localp1 = a(localp1, paramb.getSegment(i), paramBoolean);
        if (localp1 == null)
        {
          if (!paramBoolean) {
            break;
          }
          a(paramp);
          return null;
        }
      }
      catch (c paramb)
      {
        if (paramp != null) {
          a(paramp);
        }
        throw paramb;
      }
      p localp2 = paramp;
      if (localp1.isImplicit())
      {
        localp1.setImplicit(false);
        if ((i == 1) && (paramb.getSegment(i).isAlias()) && (paramb.getSegment(i).getAliasForm() != 0))
        {
          localp1.getOptions().setOption(paramb.getSegment(i).getAliasForm(), true);
        }
        else if ((i < paramb.size() - 1) && (paramb.getSegment(i).getKind() == 1) && (!localp1.getOptions().isCompositeProperty()))
        {
          localp1.getOptions().setStruct(true);
          break label261;
          label230:
          if (paramp != null)
          {
            localp1.getOptions().mergeWith(parame);
            localp1.setOptions(localp1.getOptions());
          }
          return localp1;
          paramp = null;
          break label62;
        }
        label261:
        localp2 = paramp;
        if (paramp == null) {
          localp2 = localp1;
        }
      }
      i += 1;
      paramp = localp2;
    }
  }
  
  private static p a(p paramp, d paramd, boolean paramBoolean)
    throws c
  {
    Object localObject = null;
    int i = paramd.getKind();
    if (i == 1)
    {
      paramd = b(paramp, paramd.getName(), paramBoolean);
      return paramd;
    }
    if (i == 2) {
      return c(paramp, paramd.getName().substring(1), paramBoolean);
    }
    if (!paramp.getOptions().isArray()) {
      throw new c("Indexing applied to non-array", 102);
    }
    if (i == 3) {
      i = d(paramp, paramd.getName(), paramBoolean);
    }
    for (;;)
    {
      paramd = (d)localObject;
      if (1 > i) {
        break;
      }
      paramd = (d)localObject;
      if (i > paramp.getChildrenLength()) {
        break;
      }
      return paramp.getChild(i);
      if (i == 4)
      {
        i = paramp.getChildrenLength();
      }
      else if (i == 6)
      {
        paramd = k.a(paramd.getName());
        i = c(paramp, paramd[0], paramd[1]);
      }
      else
      {
        if (i != 5) {
          break label181;
        }
        String[] arrayOfString = k.a(paramd.getName());
        i = a(paramp, arrayOfString[0], arrayOfString[1], paramd.getAliasForm());
      }
    }
    label181:
    throw new c("Unknown array indexing step in FollowXPathStep", 9);
  }
  
  static p a(p paramp, String paramString1, String paramString2, boolean paramBoolean)
    throws c
  {
    if ((!a) && (paramp.getParent() != null)) {
      throw new AssertionError();
    }
    p localp = paramp.findChildByName(paramString1);
    Object localObject = localp;
    if (localp == null)
    {
      localObject = localp;
      if (paramBoolean)
      {
        localp = new p(paramString1, new e().setSchemaNode(true));
        localp.setImplicit(true);
        String str = f.getSchemaRegistry().getNamespacePrefix(paramString1);
        localObject = str;
        if (str == null)
        {
          if ((paramString2 == null) || (paramString2.length() == 0)) {
            break label135;
          }
          localObject = f.getSchemaRegistry().registerNamespace(paramString1, paramString2);
        }
        localp.setValue((String)localObject);
        paramp.addChild(localp);
        localObject = localp;
      }
    }
    return (p)localObject;
    label135:
    throw new c("Unregistered schema namespace URI", 101);
  }
  
  static p a(p paramp, String paramString, boolean paramBoolean)
    throws c
  {
    return a(paramp, paramString, null, paramBoolean);
  }
  
  static e a(e parame, Object paramObject)
    throws c
  {
    e locale = parame;
    if (parame == null) {
      locale = new e();
    }
    if (locale.isArrayAltText()) {
      locale.setArrayAlternate(true);
    }
    if (locale.isArrayAlternate()) {
      locale.setArrayOrdered(true);
    }
    if (locale.isArrayOrdered()) {
      locale.setArray(true);
    }
    if ((locale.isCompositeProperty()) && (paramObject != null) && (paramObject.toString().length() > 0)) {
      throw new c("Structs and arrays can't have values", 103);
    }
    locale.assertConsistency(locale.getOptions());
    return locale;
  }
  
  static String a(Object paramObject)
  {
    String str = null;
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      if (paramObject != null) {
        str = k.c((String)paramObject);
      }
      return str;
      if ((paramObject instanceof Boolean)) {
        paramObject = i.convertFromBoolean(((Boolean)paramObject).booleanValue());
      } else if ((paramObject instanceof Integer)) {
        paramObject = i.convertFromInteger(((Integer)paramObject).intValue());
      } else if ((paramObject instanceof Long)) {
        paramObject = i.convertFromLong(((Long)paramObject).longValue());
      } else if ((paramObject instanceof Double)) {
        paramObject = i.convertFromDouble(((Double)paramObject).doubleValue());
      } else if ((paramObject instanceof a)) {
        paramObject = i.convertFromDate((a)paramObject);
      } else if ((paramObject instanceof GregorianCalendar)) {
        paramObject = i.convertFromDate(com.a.a.b.createFromCalendar((GregorianCalendar)paramObject));
      } else if ((paramObject instanceof byte[])) {
        paramObject = i.encodeBase64((byte[])paramObject);
      } else {
        paramObject = paramObject.toString();
      }
    }
  }
  
  static void a(p paramp)
  {
    p localp = paramp.getParent();
    if (paramp.getOptions().isQualifier()) {
      localp.removeQualifier(paramp);
    }
    for (;;)
    {
      if ((!localp.hasChildren()) && (localp.getOptions().isSchemaNode())) {
        localp.getParent().removeChild(localp);
      }
      return;
      localp.removeChild(paramp);
    }
  }
  
  static void a(p paramp, Object paramObject)
  {
    paramObject = a(paramObject);
    if ((!paramp.getOptions().isQualifier()) || (!"xml:lang".equals(paramp.getName())))
    {
      paramp.setValue((String)paramObject);
      return;
    }
    paramp.setValue(k.normalizeLangValue((String)paramObject));
  }
  
  static void a(p paramp, String paramString1, String paramString2)
    throws c
  {
    paramString2 = new p("[]", paramString2, null);
    paramString1 = new p("xml:lang", paramString1, null);
    paramString2.addQualifier(paramString1);
    if (!"x-default".equals(paramString1.getValue()))
    {
      paramp.addChild(paramString2);
      return;
    }
    paramp.addChild(1, paramString2);
  }
  
  static p b(p paramp, String paramString, boolean paramBoolean)
    throws c
  {
    if ((!paramp.getOptions().isSchemaNode()) && (!paramp.getOptions().isStruct()))
    {
      if (!paramp.isImplicit()) {
        throw new c("Named children only allowed for schemas and structs", 102);
      }
      if (paramp.getOptions().isArray()) {
        throw new c("Named children not allowed for arrays", 102);
      }
      if (paramBoolean) {
        paramp.getOptions().setStruct(true);
      }
    }
    p localp2 = paramp.findChildByName(paramString);
    p localp1 = localp2;
    if (localp2 == null)
    {
      localp1 = localp2;
      if (paramBoolean)
      {
        localp1 = new p(paramString, new e());
        localp1.setImplicit(true);
        paramp.addChild(localp1);
      }
    }
    if ((!a) && (localp1 == null) && (paramBoolean)) {
      throw new AssertionError();
    }
    return localp1;
  }
  
  static void b(p paramp)
  {
    if (!paramp.getOptions().isArrayAltText()) {}
    label99:
    for (;;)
    {
      return;
      int i = 2;
      for (;;)
      {
        if (i > paramp.getChildrenLength()) {
          break label99;
        }
        p localp = paramp.getChild(i);
        if ((localp.hasQualifier()) && ("x-default".equals(localp.getQualifier(1).getValue()))) {
          try
          {
            paramp.removeChild(i);
            paramp.addChild(1, localp);
            if (i != 2) {
              break;
            }
            paramp.getChild(2).setValue(localp.getValue());
            return;
          }
          catch (c localc)
          {
            while (a) {}
            throw new AssertionError();
          }
        }
        i += 1;
      }
    }
  }
  
  static Object[] b(p paramp, String paramString1, String paramString2)
    throws c
  {
    Object localObject2 = null;
    if (!paramp.getOptions().isArrayAltText()) {
      throw new c("Localized text array is not alt-text", 102);
    }
    if (!paramp.hasChildren()) {
      return new Object[] { new Integer(0), null };
    }
    Iterator localIterator = paramp.iterateChildren();
    Object localObject1 = null;
    int i = 0;
    Object localObject3;
    String str;
    if (localIterator.hasNext())
    {
      localObject3 = (p)localIterator.next();
      if (((p)localObject3).getOptions().isCompositeProperty()) {
        throw new c("Alt-text array item is not simple", 102);
      }
      if ((!((p)localObject3).hasQualifier()) || (!"xml:lang".equals(((p)localObject3).getQualifier(1).getName()))) {
        throw new c("Alt-text array item has no language qualifier", 102);
      }
      str = ((p)localObject3).getQualifier(1).getValue();
      if (paramString2.equals(str)) {
        return new Object[] { new Integer(1), localObject3 };
      }
      if ((paramString1 != null) && (str.startsWith(paramString1)))
      {
        if (localObject1 != null) {
          break label380;
        }
        localObject1 = localObject3;
      }
    }
    label380:
    for (;;)
    {
      i += 1;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        if ("x-default".equals(str))
        {
          localObject2 = localObject1;
          localObject1 = localObject3;
          continue;
          if (i == 1) {
            return new Object[] { new Integer(2), localObject1 };
          }
          if (i > 1) {
            return new Object[] { new Integer(3), localObject1 };
          }
          if (localObject2 != null) {
            return new Object[] { new Integer(4), localObject2 };
          }
          return new Object[] { new Integer(5), paramp.getChild(1) };
        }
        else
        {
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
    }
  }
  
  private static int c(p paramp, String paramString1, String paramString2)
    throws c
  {
    int j = -1;
    int i = 1;
    while ((i <= paramp.getChildrenLength()) && (j < 0))
    {
      p localp1 = paramp.getChild(i);
      if (!localp1.getOptions().isStruct()) {
        throw new c("Field selector must be used on array of struct", 102);
      }
      int m = 1;
      int k = j;
      if (m <= localp1.getChildrenLength())
      {
        p localp2 = localp1.getChild(m);
        if (!paramString1.equals(localp2.getName())) {}
        while (!paramString2.equals(localp2.getValue()))
        {
          m += 1;
          break;
        }
        k = i;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private static p c(p paramp, String paramString, boolean paramBoolean)
    throws c
  {
    if ((!a) && (paramString.startsWith("?"))) {
      throw new AssertionError();
    }
    p localp2 = paramp.findQualifierByName(paramString);
    p localp1 = localp2;
    if (localp2 == null)
    {
      localp1 = localp2;
      if (paramBoolean)
      {
        localp1 = new p(paramString, null);
        localp1.setImplicit(true);
        paramp.addQualifier(localp1);
      }
    }
    return localp1;
  }
  
  static void c(p paramp)
  {
    if ((paramp.getOptions().isArrayAlternate()) && (paramp.hasChildren()))
    {
      Iterator localIterator = paramp.iterateChildren();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((p)localIterator.next()).getOptions().getHasLanguage());
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramp.getOptions().setArrayAltText(true);
        b(paramp);
      }
      return;
    }
  }
  
  private static int d(p paramp, String paramString, boolean paramBoolean)
    throws c
  {
    int i;
    try
    {
      i = Integer.parseInt(paramString.substring(1, paramString.length() - 1));
      if (i < 1) {
        throw new c("Array index must be larger than zero", 102);
      }
    }
    catch (NumberFormatException paramp)
    {
      throw new c("Array index not digits.", 102);
    }
    if ((paramBoolean) && (i == paramp.getChildrenLength() + 1))
    {
      paramString = new p("[]", null);
      paramString.setImplicit(true);
      paramp.addChild(paramString);
    }
    return i;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */