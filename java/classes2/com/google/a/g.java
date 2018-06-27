package com.google.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public abstract class g
{
  private String a;
  private boolean b;
  private Hashtable c;
  
  protected g()
  {
    this.b = true;
  }
  
  public g(String paramString)
  {
    this.a = paramString;
  }
  
  private static int a(i parami, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return parami.a();
  }
  
  private Object a(f paramf, int paramInt)
  {
    paramf = d(paramf);
    if (paramf == null) {
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }
    return paramf.elementAt(paramInt);
  }
  
  private void a(b paramb)
    throws IOException
  {
    a(paramb.c());
  }
  
  private static void a(f paramf)
  {
    if (paramf.d()) {
      throw new RuntimeException("This is a repeated extension.");
    }
  }
  
  private void a(f paramf, int paramInt, Object paramObject)
  {
    a();
    e(paramf).setElementAt(paramObject, paramInt);
  }
  
  private void a(f paramf, Object paramObject)
  {
    a();
    f.a(this.a, paramf);
    a(paramf);
    this.c.put(paramf, paramObject);
  }
  
  private void a(InputStream paramInputStream)
    throws IOException
  {
    a(c.a(paramInputStream));
  }
  
  private void a(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = d.a(paramOutputStream);
    a(paramOutputStream);
    paramOutputStream.h();
  }
  
  protected static boolean a(c paramc, int paramInt)
    throws IOException
  {
    return paramc.a(paramInt);
  }
  
  private boolean a(g paramg)
  {
    if (!this.a.equals(paramg.a)) {
      throw new RuntimeException("Type mismtach.");
    }
    Enumeration localEnumeration = this.c.keys();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject2 = (f)localEnumeration.nextElement();
      Object localObject1 = this.c.get(localObject2);
      localObject2 = paramg.c.get(localObject2);
      if ((localObject1 != null) && (localObject2 != null))
      {
        if (!localObject1.equals(localObject2)) {
          return false;
        }
      }
      else if ((localObject1 != null) || (localObject2 != null)) {
        return false;
      }
    }
    return true;
  }
  
  private void b(d paramd)
    throws IOException
  {
    Enumeration localEnumeration = this.c.keys();
    while (localEnumeration.hasMoreElements())
    {
      f localf = (f)localEnumeration.nextElement();
      Object localObject = this.c.get(localf);
      if (localf.d()) {
        localf.a().a(localf, (Vector)localObject, paramd);
      } else {
        localf.a().a(true, localf, localObject, paramd);
      }
    }
  }
  
  private void b(f paramf, Object paramObject)
  {
    a();
    e(paramf).addElement(paramObject);
  }
  
  private boolean b(c paramc, int paramInt)
    throws IOException
  {
    int j = 0;
    int k = paramInt & 0x7;
    f localf = f.a(this.a, paramInt >>> 3);
    int i;
    if (localf != null) {
      if (k == a(localf.a(), false)) {
        i = 0;
      }
    }
    Object localObject1;
    while (i != 0)
    {
      return paramc.a(paramInt);
      if (localf.d())
      {
        localObject1 = localf.a();
        if ((localObject1 == i.i) || (localObject1 == i.b) || (localObject1 == i.e) || (localObject1 == i.f) || (localObject1 == i.g) || (localObject1 == i.h)) {}
        for (i = 1;; i = 0)
        {
          if ((i == 0) || (k != a(localf.a(), true))) {
            break label148;
          }
          i = 0;
          j = 1;
          break;
        }
      }
      label148:
      i = 1;
    }
    if (j != 0)
    {
      paramInt = paramc.b(paramc.r());
      if (localf.a() == i.b) {
        while (paramc.u() > 0)
        {
          i = paramc.m();
          localObject1 = ((e)localf.f()).a(i);
          if (localObject1 == null) {
            return true;
          }
          b(localf, localObject1);
        }
      }
      while (paramc.u() > 0) {
        b(localf, localf.a().a(paramc));
      }
      paramc.c(paramInt);
      return true;
    }
    if (localf.a() == i.d)
    {
      if (localf.d()) {
        break label482;
      }
      f.a(this.a, localf);
      a(localf);
      localObject1 = this.c.get(localf);
      if (localObject1 != null)
      {
        label303:
        localObject1 = (g)localObject1;
        if ((localObject1 == null) || (((g)localObject1).b)) {
          break label482;
        }
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ((g)localf.f()).d();
      }
      if (localf.a() == i.c)
      {
        return paramc.a(paramInt);
        localObject1 = localf.f();
        break label303;
      }
      paramc.a((g)localObject2);
      for (;;)
      {
        if (!localf.d()) {
          break label449;
        }
        b(localf, localObject2);
        break;
        if (localf.a() == i.b)
        {
          paramInt = paramc.m();
          paramc = ((e)localf.f()).a(paramInt);
          localObject2 = paramc;
          if (paramc == null) {
            return true;
          }
        }
        else
        {
          localObject2 = localf.a().a(paramc);
        }
      }
      label449:
      a();
      f.a(this.a, localf);
      a(localf);
      this.c.put(localf, localObject2);
      break;
      label482:
      localObject1 = null;
    }
  }
  
  private boolean b(f paramf)
  {
    f.a(this.a, paramf);
    a(paramf);
    return this.c.contains(paramf);
  }
  
  private Object c(f paramf)
  {
    f.a(this.a, paramf);
    a(paramf);
    Object localObject = this.c.get(paramf);
    if (localObject != null) {
      return localObject;
    }
    return paramf.f();
  }
  
  private Vector d(f paramf)
  {
    f.a(this.a, paramf);
    if (!paramf.d()) {
      throw new RuntimeException("Not a repeated extension.");
    }
    return (Vector)this.c.get(paramf);
  }
  
  private Vector e(f paramf)
  {
    Vector localVector2 = d(paramf);
    Vector localVector1 = localVector2;
    if (localVector2 == null)
    {
      localVector1 = new Vector(1);
      this.c.put(paramf, localVector1);
    }
    return localVector1;
  }
  
  private Enumeration f(f paramf)
  {
    paramf = d(paramf);
    if (paramf != null) {
      return paramf.elements();
    }
    return new Vector(0).elements();
  }
  
  private void f()
  {
    this.c = new Hashtable();
  }
  
  private int g(f paramf)
  {
    paramf = d(paramf);
    if (paramf != null) {
      return paramf.size();
    }
    return 0;
  }
  
  private String g()
  {
    return this.a;
  }
  
  private int h()
  {
    Enumeration localEnumeration = this.c.keys();
    int i = 0;
    while (localEnumeration.hasMoreElements())
    {
      Object localObject1 = (f)localEnumeration.nextElement();
      Object localObject2 = this.c.get(localObject1);
      if (((f)localObject1).d())
      {
        localObject1 = (Vector)localObject2;
        int j = 0;
        while (j < ((Vector)localObject1).size())
        {
          int k = ((Vector)localObject1).elementAt(j).hashCode();
          j += 1;
          i = k * 35 + i;
        }
      }
      else
      {
        i = localObject2.hashCode() * 35 + i;
      }
    }
    return i;
  }
  
  private void h(f paramf)
  {
    a();
    this.c.remove(paramf);
  }
  
  private boolean i()
  {
    Enumeration localEnumeration = this.c.keys();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject1 = (f)localEnumeration.nextElement();
      Object localObject2 = this.c.get(localObject1);
      if (((f)localObject1).c())
      {
        f.a(this.a, (f)localObject1);
        a((f)localObject1);
        if (!this.c.contains(localObject1)) {
          return false;
        }
      }
      if (((f)localObject1).a() == i.d) {
        if (((f)localObject1).d())
        {
          localObject1 = d((f)localObject1);
          if (localObject1 != null) {
            localObject1 = ((Vector)localObject1).elements();
          }
          while (((Enumeration)localObject1).hasMoreElements()) {
            if (!((g)((Enumeration)localObject1).nextElement()).b())
            {
              return false;
              localObject1 = new Vector(0).elements();
            }
          }
        }
        else if (!((g)localObject2).b())
        {
          return false;
        }
      }
    }
    return true;
  }
  
  private int j()
  {
    Enumeration localEnumeration = this.c.keys();
    int i = 0;
    while (localEnumeration.hasMoreElements())
    {
      f localf = (f)localEnumeration.nextElement();
      Object localObject = this.c.get(localf);
      if (localf.d()) {
        i = localf.a().a(localf, (Vector)localObject) + i;
      } else {
        i = localf.a().a(true, localf, localObject) + i;
      }
    }
    return i;
  }
  
  protected final void a()
  {
    if (this.b) {
      throw new RuntimeException("Read only message!");
    }
  }
  
  public abstract void a(c paramc)
    throws IOException;
  
  protected abstract void a(d paramd)
    throws IOException;
  
  public abstract boolean b();
  
  public abstract int c();
  
  public abstract g d();
  
  public final b e()
  {
    byte[] arrayOfByte = new byte[c()];
    d locald = d.a(arrayOfByte);
    try
    {
      a(locald);
      locald.h();
      return new b(arrayOfByte);
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException.getMessage());
    }
  }
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */