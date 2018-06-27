package com.a.a.a;

import com.a.a.b.e;
import com.a.a.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class p
  implements Comparable
{
  private String b;
  private String c;
  private p d;
  private List e = null;
  private List f = null;
  private e g = null;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  static
  {
    if (!p.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public p(String paramString, e parame)
  {
    this(paramString, null, parame);
  }
  
  public p(String paramString1, String paramString2, e parame)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.g = parame;
  }
  
  private p a(List paramList, String paramString)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        p localp = (p)paramList.next();
        if (localp.getName().equals(paramString)) {
          return localp;
        }
      }
    }
    return null;
  }
  
  private void a(String paramString)
    throws c
  {
    if ((!"[]".equals(paramString)) && (findChildByName(paramString) != null)) {
      throw new c("Duplicate property or field node '" + paramString + "'", 203);
    }
  }
  
  private void a(StringBuffer paramStringBuffer, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int n = 0;
    int m = 0;
    while (m < paramInt1)
    {
      paramStringBuffer.append('\t');
      m += 1;
    }
    if (this.d != null) {
      if (getOptions().isQualifier())
      {
        paramStringBuffer.append('?');
        paramStringBuffer.append(this.b);
      }
    }
    p[] arrayOfp;
    for (;;)
    {
      if ((this.c != null) && (this.c.length() > 0))
      {
        paramStringBuffer.append(" = \"");
        paramStringBuffer.append(this.c);
        paramStringBuffer.append('"');
      }
      if (getOptions().containsOneOf(-1))
      {
        paramStringBuffer.append("\t(");
        paramStringBuffer.append(getOptions().toString());
        paramStringBuffer.append(" : ");
        paramStringBuffer.append(getOptions().getOptionsString());
        paramStringBuffer.append(')');
      }
      paramStringBuffer.append('\n');
      if ((!paramBoolean) || (!hasQualifier())) {
        break label397;
      }
      arrayOfp = (p[])e().toArray(new p[getQualifierLength()]);
      paramInt2 = 0;
      while ((arrayOfp.length > paramInt2) && (("xml:lang".equals(arrayOfp[paramInt2].getName())) || ("rdf:type".equals(arrayOfp[paramInt2].getName())))) {
        paramInt2 += 1;
      }
      if (getParent().getOptions().isArray())
      {
        paramStringBuffer.append('[');
        paramStringBuffer.append(paramInt2);
        paramStringBuffer.append(']');
      }
      else
      {
        paramStringBuffer.append(this.b);
        continue;
        paramStringBuffer.append("ROOT NODE");
        if ((this.b != null) && (this.b.length() > 0))
        {
          paramStringBuffer.append(" (");
          paramStringBuffer.append(this.b);
          paramStringBuffer.append(')');
        }
      }
    }
    Arrays.sort(arrayOfp, paramInt2, arrayOfp.length);
    paramInt2 = 0;
    while (paramInt2 < arrayOfp.length)
    {
      arrayOfp[paramInt2].a(paramStringBuffer, paramBoolean, paramInt1 + 2, paramInt2 + 1);
      paramInt2 += 1;
    }
    label397:
    if ((paramBoolean) && (hasChildren()))
    {
      arrayOfp = (p[])d().toArray(new p[getChildrenLength()]);
      paramInt2 = n;
      if (!getOptions().isArray())
      {
        Arrays.sort(arrayOfp);
        paramInt2 = n;
      }
      while (paramInt2 < arrayOfp.length)
      {
        arrayOfp[paramInt2].a(paramStringBuffer, paramBoolean, paramInt1 + 1, paramInt2 + 1);
        paramInt2 += 1;
      }
    }
  }
  
  private void b(String paramString)
    throws c
  {
    if ((!"[]".equals(paramString)) && (findQualifierByName(paramString) != null)) {
      throw new c("Duplicate '" + paramString + "' qualifier", 203);
    }
  }
  
  private boolean b()
  {
    return "xml:lang".equals(this.b);
  }
  
  private boolean c()
  {
    return "rdf:type".equals(this.b);
  }
  
  private List d()
  {
    if (this.e == null) {
      this.e = new ArrayList(0);
    }
    return this.e;
  }
  
  private List e()
  {
    if (this.f == null) {
      this.f = new ArrayList(0);
    }
    return this.f;
  }
  
  protected void a()
  {
    if (this.e.isEmpty()) {
      this.e = null;
    }
  }
  
  protected void a(p paramp)
  {
    this.d = paramp;
  }
  
  public void addChild(int paramInt, p paramp)
    throws c
  {
    a(paramp.getName());
    paramp.a(this);
    d().add(paramInt - 1, paramp);
  }
  
  public void addChild(p paramp)
    throws c
  {
    a(paramp.getName());
    paramp.a(this);
    d().add(paramp);
  }
  
  public void addQualifier(p paramp)
    throws c
  {
    int m = 0;
    b(paramp.getName());
    paramp.a(this);
    paramp.getOptions().setQualifier(true);
    getOptions().setHasQualifiers(true);
    if (paramp.b())
    {
      this.g.setHasLanguage(true);
      e().add(0, paramp);
      return;
    }
    if (paramp.c())
    {
      this.g.setHasType(true);
      List localList = e();
      if (!this.g.getHasLanguage()) {}
      for (;;)
      {
        localList.add(m, paramp);
        return;
        m = 1;
      }
    }
    e().add(paramp);
  }
  
  public void clear()
  {
    this.g = null;
    this.b = null;
    this.c = null;
    this.e = null;
    this.f = null;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = new e(getOptions().getOptions());
      localObject = new p(this.b, this.c, (e)localObject);
      cloneSubtree((p)localObject);
      return localObject;
    }
    catch (c localc)
    {
      for (;;)
      {
        e locale = new e();
      }
    }
  }
  
  public void cloneSubtree(p paramp)
  {
    try
    {
      Iterator localIterator = iterateChildren();
      while (localIterator.hasNext()) {
        paramp.addChild((p)((p)localIterator.next()).clone());
      }
      return;
    }
    catch (c paramp)
    {
      if (!a)
      {
        throw new AssertionError();
        localIterator = iterateQualifier();
        while (localIterator.hasNext()) {
          paramp.addQualifier((p)((p)localIterator.next()).clone());
        }
      }
    }
  }
  
  public int compareTo(Object paramObject)
  {
    if (getOptions().isSchemaNode()) {
      return this.c.compareTo(((p)paramObject).getValue());
    }
    return this.b.compareTo(((p)paramObject).getName());
  }
  
  public String dumpNode(boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer(512);
    a(localStringBuffer, paramBoolean, 0, 0);
    return localStringBuffer.toString();
  }
  
  public p findChildByName(String paramString)
  {
    return a(d(), paramString);
  }
  
  public p findQualifierByName(String paramString)
  {
    return a(this.f, paramString);
  }
  
  public p getChild(int paramInt)
  {
    return (p)d().get(paramInt - 1);
  }
  
  public int getChildrenLength()
  {
    if (this.e != null) {
      return this.e.size();
    }
    return 0;
  }
  
  public boolean getHasAliases()
  {
    return this.i;
  }
  
  public boolean getHasValueChild()
  {
    return this.k;
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public e getOptions()
  {
    if (this.g == null) {
      this.g = new e();
    }
    return this.g;
  }
  
  public p getParent()
  {
    return this.d;
  }
  
  public p getQualifier(int paramInt)
  {
    return (p)e().get(paramInt - 1);
  }
  
  public int getQualifierLength()
  {
    if (this.f != null) {
      return this.f.size();
    }
    return 0;
  }
  
  public List getUnmodifiableChildren()
  {
    return Collections.unmodifiableList(new ArrayList(d()));
  }
  
  public String getValue()
  {
    return this.c;
  }
  
  public boolean hasChildren()
  {
    return (this.e != null) && (this.e.size() > 0);
  }
  
  public boolean hasQualifier()
  {
    return (this.f != null) && (this.f.size() > 0);
  }
  
  public boolean isAlias()
  {
    return this.j;
  }
  
  public boolean isImplicit()
  {
    return this.h;
  }
  
  public Iterator iterateChildren()
  {
    if (this.e != null) {
      return d().iterator();
    }
    return Collections.EMPTY_LIST.listIterator();
  }
  
  public Iterator iterateQualifier()
  {
    if (this.f != null) {
      new Iterator()
      {
        public boolean hasNext()
        {
          return this.a.hasNext();
        }
        
        public Object next()
        {
          return this.a.next();
        }
        
        public void remove()
        {
          throw new UnsupportedOperationException("remove() is not allowed due to the internal contraints");
        }
      };
    }
    return Collections.EMPTY_LIST.iterator();
  }
  
  public void removeChild(int paramInt)
  {
    d().remove(paramInt - 1);
    a();
  }
  
  public void removeChild(p paramp)
  {
    d().remove(paramp);
    a();
  }
  
  public void removeChildren()
  {
    this.e = null;
  }
  
  public void removeQualifier(p paramp)
  {
    e locale = getOptions();
    if (paramp.b()) {
      locale.setHasLanguage(false);
    }
    for (;;)
    {
      e().remove(paramp);
      if (this.f.isEmpty())
      {
        locale.setHasQualifiers(false);
        this.f = null;
      }
      return;
      if (paramp.c()) {
        locale.setHasType(false);
      }
    }
  }
  
  public void removeQualifiers()
  {
    e locale = getOptions();
    locale.setHasQualifiers(false);
    locale.setHasLanguage(false);
    locale.setHasType(false);
    this.f = null;
  }
  
  public void replaceChild(int paramInt, p paramp)
  {
    paramp.a(this);
    d().set(paramInt - 1, paramp);
  }
  
  public void setAlias(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setHasAliases(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setHasValueChild(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setImplicit(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setOptions(e parame)
  {
    this.g = parame;
  }
  
  public void setValue(String paramString)
  {
    this.c = paramString;
  }
  
  public void sort()
  {
    int n = 0;
    Object localObject;
    if (hasQualifier())
    {
      localObject = (p[])e().toArray(new p[getQualifierLength()]);
      int m = 0;
      while ((localObject.length > m) && (("xml:lang".equals(localObject[m].getName())) || ("rdf:type".equals(localObject[m].getName()))))
      {
        localObject[m].sort();
        m += 1;
      }
      Arrays.sort((Object[])localObject, m, localObject.length);
      ListIterator localListIterator = this.f.listIterator();
      m = n;
      while (m < localObject.length)
      {
        localListIterator.next();
        localListIterator.set(localObject[m]);
        localObject[m].sort();
        m += 1;
      }
    }
    if (hasChildren())
    {
      if (!getOptions().isArray()) {
        Collections.sort(this.e);
      }
      localObject = iterateChildren();
      while (((Iterator)localObject).hasNext()) {
        ((p)((Iterator)localObject).next()).sort();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */