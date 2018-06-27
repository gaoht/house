package com.a.a.a;

import com.a.a.b.d;
import com.a.a.f;
import com.a.a.h;
import com.a.a.i;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class r
{
  private static Map a;
  
  static {}
  
  static com.a.a.e a(n paramn, d paramd)
    throws com.a.a.c
  {
    p localp = paramn.getRoot();
    a(paramn);
    a(localp, paramd);
    a(localp);
    e(localp);
    return paramn;
  }
  
  private static void a()
  {
    a = new HashMap();
    com.a.a.b.e locale = new com.a.a.b.e();
    locale.setArray(true);
    a.put("dc:contributor", locale);
    a.put("dc:language", locale);
    a.put("dc:publisher", locale);
    a.put("dc:relation", locale);
    a.put("dc:subject", locale);
    a.put("dc:type", locale);
    locale = new com.a.a.b.e();
    locale.setArray(true);
    locale.setArrayOrdered(true);
    a.put("dc:creator", locale);
    a.put("dc:date", locale);
    locale = new com.a.a.b.e();
    locale.setArray(true);
    locale.setArrayOrdered(true);
    locale.setArrayAlternate(true);
    locale.setArrayAltText(true);
    a.put("dc:description", locale);
    a.put("dc:rights", locale);
    a.put("dc:title", locale);
  }
  
  private static void a(n paramn)
    throws com.a.a.c
  {
    q.a(paramn.getRoot(), "http://purl.org/dc/elements/1.1/", true);
    Iterator localIterator = paramn.getRoot().iterateChildren();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if ("http://purl.org/dc/elements/1.1/".equals(localp.getName()))
      {
        b(localp);
      }
      else if ("http://ns.adobe.com/exif/1.0/".equals(localp.getName()))
      {
        d(localp);
        localp = q.b(localp, "exif:UserComment", false);
        if (localp != null) {
          c(localp);
        }
      }
      else if ("http://ns.adobe.com/xmp/1.0/DynamicMedia/".equals(localp.getName()))
      {
        localp = q.b(localp, "xmpDM:copyright", false);
        if (localp != null) {
          a(paramn, localp);
        }
      }
      else if ("http://ns.adobe.com/xap/1.0/rights/".equals(localp.getName()))
      {
        localp = q.b(localp, "xmpRights:UsageTerms", false);
        if (localp != null) {
          c(localp);
        }
      }
    }
  }
  
  private static void a(p paramp)
    throws com.a.a.c
  {
    if ((paramp.getName() != null) && (paramp.getName().length() >= 36))
    {
      Object localObject2 = paramp.getName().toLowerCase();
      Object localObject1 = localObject2;
      if (((String)localObject2).startsWith("uuid:")) {
        localObject1 = ((String)localObject2).substring(5);
      }
      if (k.b((String)localObject1))
      {
        localObject2 = q.a(paramp, com.a.a.a.a.c.expandXPath("http://ns.adobe.com/xap/1.0/mm/", "InstanceID"), true, null);
        if (localObject2 == null) {
          break label111;
        }
        ((p)localObject2).setOptions(null);
        ((p)localObject2).setValue("uuid:" + (String)localObject1);
        ((p)localObject2).removeChildren();
        ((p)localObject2).removeQualifiers();
        paramp.setName(null);
      }
    }
    return;
    label111:
    throw new com.a.a.c("Failure creating xmpMM:InstanceID", 9);
  }
  
  private static void a(p paramp1, p paramp2, boolean paramBoolean)
    throws com.a.a.c
  {
    if ((!paramp1.getValue().equals(paramp2.getValue())) || (paramp1.getChildrenLength() != paramp2.getChildrenLength())) {
      throw new com.a.a.c("Mismatch between alias and base nodes", 203);
    }
    if ((!paramBoolean) && ((!paramp1.getName().equals(paramp2.getName())) || (!paramp1.getOptions().equals(paramp2.getOptions())) || (paramp1.getQualifierLength() != paramp2.getQualifierLength()))) {
      throw new com.a.a.c("Mismatch between alias and base nodes", 203);
    }
    Iterator localIterator1 = paramp1.iterateChildren();
    Iterator localIterator2 = paramp2.iterateChildren();
    while ((localIterator1.hasNext()) && (localIterator2.hasNext())) {
      a((p)localIterator1.next(), (p)localIterator2.next(), false);
    }
    paramp1 = paramp1.iterateQualifier();
    paramp2 = paramp2.iterateQualifier();
    while ((paramp1.hasNext()) && (paramp2.hasNext())) {
      a((p)paramp1.next(), (p)paramp2.next(), false);
    }
  }
  
  private static void a(p paramp, d paramd)
    throws com.a.a.c
  {
    if (!paramp.getHasAliases()) {
      return;
    }
    paramp.setHasAliases(false);
    boolean bool = paramd.getStrictAliasing();
    Iterator localIterator1 = paramp.getUnmodifiableChildren().iterator();
    label29:
    p localp1;
    Iterator localIterator2;
    label66:
    p localp2;
    p localp3;
    while (localIterator1.hasNext())
    {
      localp1 = (p)localIterator1.next();
      if (localp1.getHasAliases())
      {
        localIterator2 = localp1.iterateChildren();
        for (;;)
        {
          if (localIterator2.hasNext())
          {
            localp2 = (p)localIterator2.next();
            if (localp2.isAlias())
            {
              localp2.setAlias(false);
              com.a.a.c.a locala = f.getSchemaRegistry().findAlias(localp2.getName());
              if (locala != null)
              {
                paramd = q.a(paramp, locala.getNamespace(), null, true);
                paramd.setImplicit(false);
                localp3 = q.b(paramd, locala.getPrefix() + locala.getPropName(), false);
                if (localp3 == null)
                {
                  if (locala.getAliasForm().isSimple())
                  {
                    localp2.setName(locala.getPrefix() + locala.getPropName());
                    paramd.addChild(localp2);
                    localIterator2.remove();
                  }
                  else
                  {
                    localp3 = new p(locala.getPrefix() + locala.getPropName(), locala.getAliasForm().toPropertyOptions());
                    paramd.addChild(localp3);
                    a(localIterator2, localp2, localp3);
                  }
                }
                else if (locala.getAliasForm().isSimple())
                {
                  if (bool) {
                    a(localp2, localp3, true);
                  }
                  localIterator2.remove();
                }
                else if (locala.getAliasForm().isArrayAltText())
                {
                  int i = q.a(localp3, "x-default");
                  if (i == -1) {
                    break label447;
                  }
                  paramd = localp3.getChild(i);
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramd == null)
      {
        a(localIterator2, localp2, localp3);
        break label66;
        if (!localp3.hasChildren()) {
          break label447;
        }
        paramd = localp3.getChild(1);
        continue;
      }
      if (bool) {
        a(localp2, paramd, true);
      }
      localIterator2.remove();
      break label66;
      localp1.setHasAliases(false);
      break label29;
      break;
      label447:
      paramd = null;
    }
  }
  
  private static void a(com.a.a.e parame, p paramp)
  {
    try
    {
      Object localObject = q.a(((n)parame).getRoot(), "http://purl.org/dc/elements/1.1/", true);
      String str = paramp.getValue();
      localObject = q.b((p)localObject, "dc:rights", false);
      if ((localObject == null) || (!((p)localObject).hasChildren())) {
        parame.setLocalizedText("http://purl.org/dc/elements/1.1/", "rights", "", "x-default", "\n\n" + str, null);
      }
      for (;;)
      {
        paramp.getParent().removeChild(paramp);
        return;
        int j = q.a((p)localObject, "x-default");
        int i = j;
        if (j < 0)
        {
          parame.setLocalizedText("http://purl.org/dc/elements/1.1/", "rights", "", "x-default", ((p)localObject).getChild(1).getValue(), null);
          i = q.a((p)localObject, "x-default");
        }
        parame = ((p)localObject).getChild(i);
        localObject = parame.getValue();
        i = ((String)localObject).indexOf("\n\n");
        if (i < 0)
        {
          if (!str.equals(localObject)) {
            parame.setValue((String)localObject + "\n\n" + str);
          }
        }
        else if (!((String)localObject).substring(i + 2).equals(str)) {
          parame.setValue(((String)localObject).substring(0, i + 2) + str);
        }
      }
      return;
    }
    catch (com.a.a.c parame) {}
  }
  
  private static void a(Iterator paramIterator, p paramp1, p paramp2)
    throws com.a.a.c
  {
    if (paramp2.getOptions().isArrayAltText())
    {
      if (paramp1.getOptions().getHasLanguage()) {
        throw new com.a.a.c("Alias to x-default already has a language qualifier", 203);
      }
      paramp1.addQualifier(new p("xml:lang", "x-default", null));
    }
    paramIterator.remove();
    paramp1.setName("[]");
    paramp2.addChild(paramp1);
  }
  
  private static void b(p paramp)
    throws com.a.a.c
  {
    int i = 1;
    if (i <= paramp.getChildrenLength())
    {
      p localp1 = paramp.getChild(i);
      com.a.a.b.e locale = (com.a.a.b.e)a.get(localp1.getName());
      if (locale == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localp1.getOptions().isSimple())
        {
          p localp2 = new p(localp1.getName(), locale);
          localp1.setName("[]");
          localp2.addChild(localp1);
          paramp.replaceChild(i, localp2);
          if ((locale.isArrayAltText()) && (!localp1.getOptions().getHasLanguage())) {
            localp1.addQualifier(new p("xml:lang", "x-default", null));
          }
        }
        else
        {
          localp1.getOptions().setOption(7680, false);
          localp1.getOptions().mergeWith(locale);
          if (locale.isArrayAltText()) {
            c(localp1);
          }
        }
      }
    }
  }
  
  private static void c(p paramp)
    throws com.a.a.c
  {
    if ((paramp == null) || (!paramp.getOptions().isArray())) {}
    for (;;)
    {
      return;
      paramp.getOptions().setArrayOrdered(true).setArrayAlternate(true).setArrayAltText(true);
      paramp = paramp.iterateChildren();
      while (paramp.hasNext())
      {
        p localp = (p)paramp.next();
        if (localp.getOptions().isCompositeProperty())
        {
          paramp.remove();
        }
        else if (!localp.getOptions().getHasLanguage())
        {
          String str = localp.getValue();
          if ((str == null) || (str.length() == 0)) {
            paramp.remove();
          } else {
            localp.addQualifier(new p("xml:lang", "x-repair", null));
          }
        }
      }
    }
  }
  
  private static void d(p paramp)
    throws com.a.a.c
  {
    p localp2 = q.b(paramp, "exif:GPSTimeStamp", false);
    if (localp2 == null) {}
    for (;;)
    {
      return;
      try
      {
        com.a.a.a locala = i.convertToDate(localp2.getValue());
        if ((locala.getYear() == 0) && (locala.getMonth() == 0) && (locala.getDay() == 0))
        {
          p localp1 = q.b(paramp, "exif:DateTimeOriginal", false);
          Object localObject = localp1;
          if (localp1 == null) {
            localObject = q.b(paramp, "exif:DateTimeDigitized", false);
          }
          paramp = i.convertToDate(((p)localObject).getValue());
          localObject = locala.getCalendar();
          ((Calendar)localObject).set(1, paramp.getYear());
          ((Calendar)localObject).set(2, paramp.getMonth());
          ((Calendar)localObject).set(5, paramp.getDay());
          localp2.setValue(i.convertFromDate(new l((Calendar)localObject)));
          return;
        }
      }
      catch (com.a.a.c paramp) {}
    }
  }
  
  private static void e(p paramp)
  {
    paramp = paramp.iterateChildren();
    while (paramp.hasNext()) {
      if (!((p)paramp.next()).hasChildren()) {
        paramp.remove();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */