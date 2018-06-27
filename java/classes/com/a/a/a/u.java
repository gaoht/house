package com.a.a.a;

import com.a.a.h;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class u
{
  static final Set a = new HashSet(Arrays.asList(new String[] { "xml:lang", "rdf:resource", "rdf:ID", "rdf:bagID", "rdf:nodeID" }));
  private n b;
  private c c;
  private OutputStreamWriter d;
  private com.a.a.b.f e;
  private int f = 1;
  private int g;
  
  private void a(int paramInt)
    throws com.a.a.c, IOException
  {
    if (this.e.getExactPacketLength())
    {
      paramInt = this.c.getBytesWritten() + this.f * paramInt;
      if (paramInt > this.g) {
        throw new com.a.a.c("Can't fit into specified packet size", 107);
      }
      this.g -= paramInt;
    }
    this.g /= this.f;
    paramInt = this.e.getNewline().length();
    if (this.g >= paramInt)
    {
      for (this.g -= paramInt; this.g >= paramInt + 100; this.g -= paramInt + 100)
      {
        a(100, ' ');
        d();
      }
      a(this.g, ' ');
      d();
      return;
    }
    a(this.g, ' ');
  }
  
  private void a(int paramInt, char paramChar)
    throws IOException
  {
    while (paramInt > 0)
    {
      this.d.write(paramChar);
      paramInt -= 1;
    }
  }
  
  private void a(int paramInt, p paramp)
    throws IOException, com.a.a.c
  {
    a(" rdf:parseType=\"Resource\">");
    d();
    a(paramp, false, true, paramInt + 1);
    paramp = paramp.iterateQualifier();
    while (paramp.hasNext()) {
      a((p)paramp.next(), false, false, paramInt + 1);
    }
  }
  
  private void a(p paramp, Set paramSet, int paramInt)
    throws IOException
  {
    if (paramp.getOptions().isSchemaNode()) {
      a(paramp.getValue().substring(0, paramp.getValue().length() - 1), paramp.getName(), paramSet, paramInt);
    }
    Object localObject;
    for (;;)
    {
      localObject = paramp.iterateChildren();
      while (((Iterator)localObject).hasNext()) {
        a((p)((Iterator)localObject).next(), paramSet, paramInt);
      }
      if (paramp.getOptions().isStruct())
      {
        localObject = paramp.iterateChildren();
        while (((Iterator)localObject).hasNext()) {
          a(((p)((Iterator)localObject).next()).getName(), null, paramSet, paramInt);
        }
      }
    }
    paramp = paramp.iterateQualifier();
    while (paramp.hasNext())
    {
      localObject = (p)paramp.next();
      a(((p)localObject).getName(), null, paramSet, paramInt);
      a((p)localObject, paramSet, paramInt);
    }
  }
  
  private void a(p paramp, boolean paramBoolean, int paramInt)
    throws IOException
  {
    String str;
    if ((paramBoolean) || (paramp.hasChildren()))
    {
      e(paramInt);
      if (!paramBoolean) {
        break label68;
      }
      str = "<rdf:";
      a(str);
      if (!paramp.getOptions().isArrayAlternate()) {
        break label75;
      }
      a("Alt");
      label46:
      if ((!paramBoolean) || (paramp.hasChildren())) {
        break label103;
      }
      a("/>");
    }
    for (;;)
    {
      d();
      return;
      label68:
      str = "</rdf:";
      break;
      label75:
      if (paramp.getOptions().isArrayOrdered())
      {
        a("Seq");
        break label46;
      }
      a("Bag");
      break label46;
      label103:
      a(">");
    }
  }
  
  private void a(p paramp, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    throws IOException, com.a.a.c
  {
    int j = 1;
    String str = paramp.getName();
    if (paramBoolean2) {
      str = "rdf:value";
    }
    label47:
    label911:
    label917:
    for (;;)
    {
      e(paramInt);
      f(60);
      a(str);
      Object localObject = paramp.iterateQualifier();
      int i = 0;
      boolean bool = false;
      if (((Iterator)localObject).hasNext())
      {
        p localp = (p)((Iterator)localObject).next();
        if (!a.contains(localp.getName())) {
          i = 1;
        }
        for (;;)
        {
          break label47;
          if (!"[]".equals(str)) {
            break label917;
          }
          str = "rdf:li";
          break;
          bool = "rdf:resource".equals(localp.getName());
          if (!paramBoolean2)
          {
            f(32);
            a(localp.getName());
            a("=\"");
            a(localp.getValue(), true);
            f(34);
          }
        }
      }
      if ((i != 0) && (!paramBoolean2))
      {
        if (bool) {
          throw new com.a.a.c("Can't mix rdf:resource and general qualifiers", 202);
        }
        if (paramBoolean1)
        {
          a(">");
          d();
          i = paramInt + 1;
          e(i);
          a("<rdf:Description");
          a(">");
        }
        for (;;)
        {
          d();
          a(paramp, paramBoolean1, true, i + 1);
          paramp = paramp.iterateQualifier();
          while (paramp.hasNext())
          {
            localObject = (p)paramp.next();
            if (!a.contains(((p)localObject).getName())) {
              a((p)localObject, paramBoolean1, false, i + 1);
            }
          }
          a(" rdf:parseType=\"Resource\">");
          i = paramInt;
        }
        paramInt = i;
        if (!paramBoolean1) {
          break label911;
        }
        e(i);
        a("</rdf:Description>");
        d();
        paramInt = i - 1;
        i = 1;
      }
      for (;;)
      {
        if (j != 0)
        {
          if (i != 0) {
            e(paramInt);
          }
          a("</");
          a(str);
          f(62);
          d();
        }
        return;
        if (!paramp.getOptions().isCompositeProperty())
        {
          if (paramp.getOptions().isURI())
          {
            a(" rdf:resource=\"");
            a(paramp.getValue(), true);
            a("\"/>");
            d();
            j = 0;
            i = 1;
          }
          else if ((paramp.getValue() == null) || ("".equals(paramp.getValue())))
          {
            a("/>");
            d();
            j = 0;
            i = 1;
          }
          else
          {
            f(62);
            a(paramp.getValue(), false);
            i = 0;
          }
        }
        else if (paramp.getOptions().isArray())
        {
          f(62);
          d();
          a(paramp, true, paramInt + 1);
          if (paramp.getOptions().isArrayAltText()) {
            q.b(paramp);
          }
          localObject = paramp.iterateChildren();
          while (((Iterator)localObject).hasNext()) {
            a((p)((Iterator)localObject).next(), paramBoolean1, false, paramInt + 2);
          }
          a(paramp, false, paramInt + 1);
          i = 1;
        }
        else
        {
          if (!bool)
          {
            if (!paramp.hasChildren())
            {
              if (paramBoolean1)
              {
                a(">");
                d();
                e(paramInt + 1);
                a("<rdf:Description/>");
              }
              for (i = 1;; i = 0)
              {
                d();
                j = i;
                i = 1;
                break;
                a(" rdf:parseType=\"Resource\"/>");
              }
            }
            if (paramBoolean1)
            {
              a(">");
              d();
              i = paramInt + 1;
              e(i);
              a("<rdf:Description");
              a(">");
            }
            for (;;)
            {
              d();
              paramp = paramp.iterateChildren();
              while (paramp.hasNext()) {
                a((p)paramp.next(), paramBoolean1, false, i + 1);
              }
              a(" rdf:parseType=\"Resource\">");
              i = paramInt;
            }
            paramInt = i;
            if (paramBoolean1)
            {
              e(i);
              a("</rdf:Description>");
              d();
              paramInt = i - 1;
              i = 1;
            }
          }
          else
          {
            paramp = paramp.iterateChildren();
            while (paramp.hasNext())
            {
              localObject = (p)paramp.next();
              if (!b((p)localObject)) {
                throw new com.a.a.c("Can't mix rdf:resource and complex fields", 202);
              }
              d();
              e(paramInt + 1);
              f(32);
              a(((p)localObject).getName());
              a("=\"");
              a(((p)localObject).getValue(), true);
              f(34);
            }
            a("/>");
            d();
            j = 0;
            i = 1;
            continue;
          }
          i = 1;
        }
      }
    }
  }
  
  private void a(String paramString)
    throws IOException
  {
    this.d.write(paramString);
  }
  
  private void a(String paramString1, String paramString2, Set paramSet, int paramInt)
    throws IOException
  {
    String str2 = paramString1;
    String str1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = new j(paramString1);
      if (paramString1.hasPrefix())
      {
        str2 = paramString1.getPrefix();
        str1 = com.a.a.f.getSchemaRegistry().getNamespaceURI(str2 + ":");
        a(str2, str1, paramSet, paramInt);
      }
    }
    else if (!paramSet.contains(str2))
    {
      d();
      e(paramInt);
      a("xmlns:");
      a(str2);
      a("=\"");
      a(str1);
      f(34);
      paramSet.add(str2);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
    throws IOException
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    a(k.escapeXML(str, paramBoolean, true));
  }
  
  private boolean a(p paramp, int paramInt)
    throws IOException
  {
    paramp = paramp.iterateChildren();
    boolean bool = true;
    if (paramp.hasNext())
    {
      p localp = (p)paramp.next();
      if (b(localp))
      {
        d();
        e(paramInt);
        a(localp.getName());
        a("=\"");
        a(localp.getValue(), true);
        f(34);
      }
      for (;;)
      {
        break;
        bool = false;
      }
    }
    return bool;
  }
  
  private boolean a(p paramp, int paramInt, boolean paramBoolean)
    throws com.a.a.c, IOException
  {
    Iterator localIterator = paramp.iterateChildren();
    int j = 0;
    int i = 0;
    if (localIterator.hasNext()) {
      if (b((p)localIterator.next()))
      {
        i = j;
        j = 1;
        label46:
        if ((j == 0) || (i == 0)) {
          break label93;
        }
      }
    }
    for (;;)
    {
      if ((paramBoolean) && (i != 0))
      {
        throw new com.a.a.c("Can't mix rdf:resource qualifier and element fields", 202);
        k = 1;
        j = i;
        i = k;
        break label46;
        label93:
        k = j;
        j = i;
        i = k;
        break;
      }
      if (!paramp.hasChildren())
      {
        a(" rdf:parseType=\"Resource\"/>");
        d();
        return false;
      }
      if (i == 0)
      {
        a(paramp, paramInt + 1);
        a("/>");
        d();
        return false;
      }
      if (j == 0)
      {
        a(" rdf:parseType=\"Resource\">");
        d();
        b(paramp, paramInt + 1);
        return true;
      }
      f(62);
      d();
      e(paramInt + 1);
      a("<rdf:Description");
      a(paramp, paramInt + 2);
      a(">");
      d();
      b(paramp, paramInt + 1);
      e(paramInt + 1);
      a("</rdf:Description>");
      d();
      return true;
      int k = i;
      i = j;
      j = k;
    }
  }
  
  private Object[] a(p paramp)
    throws IOException
  {
    Boolean localBoolean2 = Boolean.TRUE;
    Boolean localBoolean1 = Boolean.TRUE;
    if (paramp.getOptions().isURI())
    {
      a(" rdf:resource=\"");
      a(paramp.getValue(), true);
      a("\"/>");
      d();
      paramp = Boolean.FALSE;
    }
    for (;;)
    {
      return new Object[] { paramp, localBoolean1 };
      if ((paramp.getValue() == null) || (paramp.getValue().length() == 0))
      {
        a("/>");
        d();
        paramp = Boolean.FALSE;
      }
      else
      {
        f(62);
        a(paramp.getValue(), false);
        localBoolean1 = Boolean.FALSE;
        paramp = localBoolean2;
      }
    }
  }
  
  private String b()
    throws IOException, com.a.a.c
  {
    int i = 0;
    if (!this.e.getOmitPacketWrapper())
    {
      e(0);
      a("<?xpacket begin=\"﻿\" id=\"W5M0MpCehiHzreSzNTczkc9d\"?>");
      d();
    }
    if (!this.e.getOmitXmpMetaElement())
    {
      e(0);
      a("<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"");
      if (!this.e.getOmitVersionAttribute()) {
        a(com.a.a.f.getVersionInfo().getMessage());
      }
      a("\">");
      d();
      i = 1;
    }
    e(i);
    a("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">");
    d();
    if (this.e.getUseCanonicalFormat()) {
      b(i);
    }
    Object localObject2;
    for (;;)
    {
      e(i);
      a("</rdf:RDF>");
      d();
      if (!this.e.getOmitXmpMetaElement())
      {
        e(i - 1);
        a("</x:xmpmeta>");
        d();
      }
      localObject1 = "";
      localObject2 = localObject1;
      if (this.e.getOmitPacketWrapper()) {
        break label305;
      }
      i = this.e.getBaseIndent();
      while (i > 0)
      {
        localObject1 = (String)localObject1 + this.e.getIndent();
        i -= 1;
      }
      c(i);
    }
    Object localObject1 = (String)localObject1 + "<?xpacket end=\"";
    localObject1 = new StringBuilder().append((String)localObject1);
    if (this.e.getReadOnlyPacket()) {}
    for (char c1 = 'r';; c1 = 'w')
    {
      localObject1 = c1;
      localObject2 = (String)localObject1 + "\"?>";
      label305:
      return (String)localObject2;
    }
  }
  
  private void b(int paramInt)
    throws IOException, com.a.a.c
  {
    if (this.b.getRoot().getChildrenLength() > 0)
    {
      e(this.b.getRoot(), paramInt);
      Iterator localIterator = this.b.getRoot().iterateChildren();
      while (localIterator.hasNext()) {
        d((p)localIterator.next(), paramInt);
      }
      d(paramInt);
      return;
    }
    e(paramInt + 1);
    a("<rdf:Description rdf:about=");
    c();
    a("/>");
    d();
  }
  
  private void b(p paramp, int paramInt)
    throws IOException, com.a.a.c
  {
    Iterator localIterator1 = paramp.iterateChildren();
    Object localObject;
    while (localIterator1.hasNext())
    {
      localObject = (p)localIterator1.next();
      if (!b((p)localObject))
      {
        paramp = ((p)localObject).getName();
        if (!"[]".equals(paramp)) {
          break label325;
        }
        paramp = "rdf:li";
      }
    }
    label322:
    label325:
    for (;;)
    {
      e(paramInt);
      f(60);
      a(paramp);
      Iterator localIterator2 = ((p)localObject).iterateQualifier();
      boolean bool1 = false;
      int i = 0;
      if (localIterator2.hasNext())
      {
        p localp = (p)localIterator2.next();
        if (!a.contains(localp.getName())) {
          i = 1;
        }
        for (;;)
        {
          break;
          bool1 = "rdf:resource".equals(localp.getName());
          f(32);
          a(localp.getName());
          a("=\"");
          a(localp.getValue(), true);
          f(34);
        }
      }
      boolean bool2;
      if (i != 0)
      {
        a(paramInt, (p)localObject);
        bool1 = true;
        bool2 = true;
      }
      for (;;)
      {
        if (!bool2) {
          break label322;
        }
        if (bool1) {
          e(paramInt);
        }
        a("</");
        a(paramp);
        f(62);
        d();
        break;
        if (!((p)localObject).getOptions().isCompositeProperty())
        {
          localObject = a((p)localObject);
          bool2 = ((Boolean)localObject[0]).booleanValue();
          bool1 = ((Boolean)localObject[1]).booleanValue();
        }
        else if (((p)localObject).getOptions().isArray())
        {
          c((p)localObject, paramInt);
          bool1 = true;
          bool2 = true;
        }
        else
        {
          bool2 = a((p)localObject, paramInt, bool1);
          bool1 = true;
        }
      }
      break;
      return;
    }
  }
  
  private boolean b(p paramp)
  {
    return (!paramp.hasQualifier()) && (!paramp.getOptions().isURI()) && (!paramp.getOptions().isCompositeProperty()) && (!"[]".equals(paramp.getName()));
  }
  
  private void c()
    throws IOException
  {
    f(34);
    String str = this.b.getRoot().getName();
    if (str != null) {
      a(str, true);
    }
    f(34);
  }
  
  private void c(int paramInt)
    throws IOException, com.a.a.c
  {
    e(paramInt + 1);
    a("<rdf:Description rdf:about=");
    c();
    Object localObject = new HashSet();
    ((Set)localObject).add("xml");
    ((Set)localObject).add("rdf");
    Iterator localIterator = this.b.getRoot().iterateChildren();
    while (localIterator.hasNext()) {
      a((p)localIterator.next(), (Set)localObject, paramInt + 3);
    }
    localObject = this.b.getRoot().iterateChildren();
    for (boolean bool = true; ((Iterator)localObject).hasNext(); bool = a((p)((Iterator)localObject).next(), paramInt + 2) & bool) {}
    if (!bool)
    {
      f(62);
      d();
      localObject = this.b.getRoot().iterateChildren();
      while (((Iterator)localObject).hasNext()) {
        b((p)((Iterator)localObject).next(), paramInt + 2);
      }
    }
    a("/>");
    d();
    return;
    e(paramInt + 1);
    a("</rdf:Description>");
    d();
  }
  
  private void c(p paramp, int paramInt)
    throws IOException, com.a.a.c
  {
    f(62);
    d();
    a(paramp, true, paramInt + 1);
    if (paramp.getOptions().isArrayAltText()) {
      q.b(paramp);
    }
    b(paramp, paramInt + 2);
    a(paramp, false, paramInt + 1);
  }
  
  private void d()
    throws IOException
  {
    this.d.write(this.e.getNewline());
  }
  
  private void d(int paramInt)
    throws IOException
  {
    e(paramInt + 1);
    a("</rdf:Description>");
    d();
  }
  
  private void d(p paramp, int paramInt)
    throws IOException, com.a.a.c
  {
    paramp = paramp.iterateChildren();
    while (paramp.hasNext()) {
      a((p)paramp.next(), this.e.getUseCanonicalFormat(), false, paramInt + 2);
    }
  }
  
  private void e(int paramInt)
    throws IOException
  {
    paramInt = this.e.getBaseIndent() + paramInt;
    while (paramInt > 0)
    {
      this.d.write(this.e.getIndent());
      paramInt -= 1;
    }
  }
  
  private void e(p paramp, int paramInt)
    throws IOException
  {
    e(paramInt + 1);
    a("<rdf:Description rdf:about=");
    c();
    HashSet localHashSet = new HashSet();
    localHashSet.add("xml");
    localHashSet.add("rdf");
    a(paramp, localHashSet, paramInt + 3);
    f(62);
    d();
  }
  
  private void f(int paramInt)
    throws IOException
  {
    this.d.write(paramInt);
  }
  
  protected void a()
    throws com.a.a.c
  {
    if ((this.e.getEncodeUTF16BE() | this.e.getEncodeUTF16LE())) {
      this.f = 2;
    }
    if (this.e.getExactPacketLength())
    {
      if ((this.e.getOmitPacketWrapper() | this.e.getIncludeThumbnailPad())) {
        throw new com.a.a.c("Inconsistent options for exact size serialize", 103);
      }
      if ((this.e.getPadding() & this.f - 1) != 0) {
        throw new com.a.a.c("Exact size must be a multiple of the Unicode element", 103);
      }
    }
    else
    {
      if (!this.e.getReadOnlyPacket()) {
        break label141;
      }
      if ((this.e.getOmitPacketWrapper() | this.e.getIncludeThumbnailPad())) {
        throw new com.a.a.c("Inconsistent options for read-only packet", 103);
      }
      this.g = 0;
    }
    label141:
    do
    {
      return;
      if (this.e.getOmitPacketWrapper())
      {
        if (this.e.getIncludeThumbnailPad()) {
          throw new com.a.a.c("Inconsistent options for non-packet serialize", 103);
        }
        this.g = 0;
        return;
      }
      if (this.g == 0) {
        this.g = (this.f * 2048);
      }
    } while ((!this.e.getIncludeThumbnailPad()) || (this.b.doesPropertyExist("http://ns.adobe.com/xap/1.0/", "Thumbnails")));
    this.g += this.f * 10000;
  }
  
  public void serialize(com.a.a.e parame, OutputStream paramOutputStream, com.a.a.b.f paramf)
    throws com.a.a.c
  {
    try
    {
      this.c = new c(paramOutputStream);
      this.d = new OutputStreamWriter(this.c, paramf.getEncoding());
      this.b = ((n)parame);
      this.e = paramf;
      this.g = paramf.getPadding();
      this.d = new OutputStreamWriter(this.c, paramf.getEncoding());
      a();
      parame = b();
      this.d.flush();
      a(parame.length());
      a(parame);
      this.d.flush();
      this.c.close();
      return;
    }
    catch (IOException parame)
    {
      throw new com.a.a.c("Error writing to the OutputStream", 0);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */