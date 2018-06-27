package com.a.a.a;

import com.a.a.b.e;
import com.a.a.d;
import com.a.a.f;
import com.a.a.h;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class m
  implements d
{
  protected boolean a = false;
  protected boolean b = false;
  private com.a.a.b.b c;
  private String d = null;
  private Iterator e = null;
  
  public m(n paramn, String paramString1, String paramString2, com.a.a.b.b paramb)
    throws com.a.a.c
  {
    int i;
    label49:
    int j;
    if (paramb != null)
    {
      this.c = paramb;
      if ((paramString1 == null) || (paramString1.length() <= 0)) {
        break label122;
      }
      i = 1;
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label128;
      }
      j = 1;
      label63:
      if ((i != 0) || (j != 0)) {
        break label134;
      }
      paramString1 = paramn.getRoot();
      paramn = null;
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        if (!this.c.isJustChildren())
        {
          this.e = new a(paramString1, paramn, 1);
          return;
          paramb = new com.a.a.b.b();
          break;
          label122:
          i = 0;
          break label49;
          label128:
          j = 0;
          break label63;
          label134:
          if ((i != 0) && (j != 0))
          {
            paramString2 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
            paramb = new com.a.a.a.a.b();
            i = 0;
            while (i < paramString2.size() - 1)
            {
              paramb.add(paramString2.getSegment(i));
              i += 1;
            }
            paramString2 = q.a(paramn.getRoot(), paramString2, false, null);
            this.d = paramString1;
            paramn = paramb.toString();
            paramString1 = paramString2;
            continue;
          }
          if ((i != 0) && (j == 0))
          {
            paramString1 = q.a(paramn.getRoot(), paramString1, false);
            paramn = null;
            continue;
          }
          throw new com.a.a.c("Schema namespace URI is required", 101);
        }
        this.e = new b(paramString1, paramn);
        return;
      }
    }
    this.e = Collections.EMPTY_LIST.iterator();
  }
  
  protected com.a.a.b.b a()
  {
    return this.c;
  }
  
  protected void a(String paramString)
  {
    this.d = paramString;
  }
  
  protected String b()
  {
    return this.d;
  }
  
  public boolean hasNext()
  {
    return this.e.hasNext();
  }
  
  public Object next()
  {
    return this.e.next();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("The XMPIterator does not support remove().");
  }
  
  public void skipSiblings()
  {
    skipSubtree();
    this.a = true;
  }
  
  public void skipSubtree()
  {
    this.b = true;
  }
  
  private class a
    implements Iterator
  {
    private int b = 0;
    private p c;
    private String d;
    private Iterator e = null;
    private int f = 0;
    private Iterator g = Collections.EMPTY_LIST.iterator();
    private com.a.a.c.c h = null;
    
    public a() {}
    
    public a(p paramp, String paramString, int paramInt)
    {
      this.c = paramp;
      this.b = 0;
      if (paramp.getOptions().isSchemaNode()) {
        m.this.a(paramp.getName());
      }
      this.d = a(paramp, paramString, paramInt);
    }
    
    private boolean a(Iterator paramIterator)
    {
      if (m.this.a)
      {
        m.this.a = false;
        this.g = Collections.EMPTY_LIST.iterator();
      }
      if ((!this.g.hasNext()) && (paramIterator.hasNext()))
      {
        paramIterator = (p)paramIterator.next();
        this.f += 1;
        this.g = new a(m.this, paramIterator, this.d, this.f);
      }
      if (this.g.hasNext())
      {
        this.h = ((com.a.a.c.c)this.g.next());
        return true;
      }
      return false;
    }
    
    protected com.a.a.c.c a(final p paramp, final String paramString1, final String paramString2)
    {
      if (paramp.getOptions().isSchemaNode()) {}
      for (final String str = null;; str = paramp.getValue()) {
        new com.a.a.c.c()
        {
          public String getLanguage()
          {
            return null;
          }
          
          public String getNamespace()
          {
            if (!paramp.getOptions().isSchemaNode())
            {
              j localj = new j(paramp.getName());
              return f.getSchemaRegistry().getNamespaceURI(localj.getPrefix());
            }
            return paramString1;
          }
          
          public e getOptions()
          {
            return paramp.getOptions();
          }
          
          public String getPath()
          {
            return paramString2;
          }
          
          public String getValue()
          {
            return str;
          }
        };
      }
    }
    
    protected String a(p paramp, String paramString, int paramInt)
    {
      Object localObject;
      if ((paramp.getParent() == null) || (paramp.getOptions().isSchemaNode()))
      {
        localObject = null;
        return (String)localObject;
      }
      String str;
      if (paramp.getParent().getOptions().isArray()) {
        str = "";
      }
      for (paramp = "[" + String.valueOf(paramInt) + "]";; paramp = paramp.getName())
      {
        localObject = paramp;
        if (paramString == null) {
          break;
        }
        localObject = paramp;
        if (paramString.length() == 0) {
          break;
        }
        if (!m.this.a().isJustLeafname()) {
          break label128;
        }
        localObject = paramp;
        if (!paramp.startsWith("?")) {
          break;
        }
        return paramp.substring(1);
        str = "/";
      }
      label128:
      return paramString + str + paramp;
    }
    
    protected void a(com.a.a.c.c paramc)
    {
      this.h = paramc;
    }
    
    protected boolean a()
    {
      this.b = 1;
      if ((this.c.getParent() != null) && ((!m.this.a().isJustLeafnodes()) || (!this.c.hasChildren())))
      {
        this.h = a(this.c, m.this.b(), this.d);
        return true;
      }
      return hasNext();
    }
    
    protected com.a.a.c.c b()
    {
      return this.h;
    }
    
    public boolean hasNext()
    {
      boolean bool1 = true;
      if (this.h != null) {}
      do
      {
        boolean bool2;
        do
        {
          do
          {
            return bool1;
            if (this.b == 0) {
              return a();
            }
            if (this.b != 1) {
              break;
            }
            if (this.e == null) {
              this.e = this.c.iterateChildren();
            }
            bool2 = a(this.e);
            bool1 = bool2;
          } while (bool2);
          bool1 = bool2;
        } while (!this.c.hasQualifier());
        bool1 = bool2;
      } while (m.this.a().isOmitQualifiers());
      this.b = 2;
      this.e = null;
      return hasNext();
      if (this.e == null) {
        this.e = this.c.iterateQualifier();
      }
      return a(this.e);
    }
    
    public Object next()
    {
      if (hasNext())
      {
        com.a.a.c.c localc = this.h;
        this.h = null;
        return localc;
      }
      throw new NoSuchElementException("There are no more nodes to return");
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private class b
    extends m.a
  {
    private String c;
    private Iterator d;
    private int e = 0;
    
    public b(p paramp, String paramString)
    {
      super();
      if (paramp.getOptions().isSchemaNode()) {
        m.this.a(paramp.getName());
      }
      this.c = a(paramp, paramString, 1);
      this.d = paramp.iterateChildren();
    }
    
    public boolean hasNext()
    {
      boolean bool2 = false;
      boolean bool1;
      if (b() != null) {
        bool1 = true;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (m.this.a);
        bool1 = bool2;
      } while (!this.d.hasNext());
      p localp = (p)this.d.next();
      this.e += 1;
      String str = null;
      if (localp.getOptions().isSchemaNode()) {
        m.this.a(localp.getName());
      }
      while ((!m.this.a().isJustLeafnodes()) || (!localp.hasChildren()))
      {
        a(a(localp, m.this.b(), str));
        return true;
        if (localp.getParent() != null) {
          str = a(localp, this.c, this.e);
        }
      }
      return hasNext();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */