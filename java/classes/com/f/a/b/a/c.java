package com.f.a.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.f.a.a.a.e;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  private String a = "";
  private String b = "";
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private SharedPreferences f = null;
  private b g = null;
  private SharedPreferences.Editor h = null;
  private b.a i = null;
  private Context j = null;
  private d k = null;
  private boolean l = false;
  
  public c(Context paramContext, String paramString1, String paramString2)
  {
    this.a = paramString2;
    this.b = paramString1;
    this.j = paramContext;
    if (paramContext != null) {
      this.f = paramContext.getSharedPreferences(paramString2, 0);
    }
    for (l1 = this.f.getLong("t", 0L);; l1 = 0L)
    {
      try
      {
        String str = Environment.getExternalStorageState();
        localObject = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            if (this.g != null)
            {
              paramContext = this.g.c();
              paramContext.a("t2", l1);
              paramContext.b();
            }
            return;
          }
          catch (Exception paramContext)
          {
            return;
          }
          localException = localException;
          localException.printStackTrace();
          continue;
          if (((String)localObject).equals("mounted_ro"))
          {
            this.d = true;
            this.e = false;
          }
          else
          {
            this.e = false;
            this.d = false;
            continue;
            if ((l1 > l3) && (l3 > 0L))
            {
              a(this.g, this.f);
              this.f = paramContext.getSharedPreferences(paramString2, 0);
              l2 = l3;
              l4 = l1;
            }
            else if ((l1 == 0L) && (l3 > 0L))
            {
              a(this.g, this.f);
              this.f = paramContext.getSharedPreferences(paramString2, 0);
              l2 = l3;
              l4 = l1;
            }
            else if ((l3 == 0L) && (l1 > 0L))
            {
              a(this.f, this.g);
              this.g = this.k.a(paramString2);
              l2 = l3;
              l4 = l1;
            }
            else
            {
              l2 = l3;
              l4 = l1;
              if (l1 == l3)
              {
                a(this.f, this.g);
                this.g = this.k.a(paramString2);
                l2 = l3;
                l4 = l1;
              }
            }
          }
        }
      }
      if (!e.a((String)localObject)) {
        if (((String)localObject).equals("mounted"))
        {
          this.e = true;
          this.d = true;
          if (((!this.d) && (!this.e)) || (paramContext == null) || (e.a(paramString1))) {
            break label710;
          }
          this.k = c(paramString1);
          if (this.k == null) {
            break label710;
          }
        }
      }
      for (;;)
      {
        try
        {
          this.g = this.k.a(paramString2);
          l2 = this.g.b("t");
        }
        catch (Exception paramContext)
        {
          l2 = l1;
          l1 = 0L;
        }
        try
        {
          l3 = this.f.getLong("t2", 0L);
          l1 = l3;
        }
        catch (Exception paramContext)
        {
          l3 = l1;
          l1 = l2;
          l2 = l3;
        }
        try
        {
          l3 = this.g.b("t2");
          if ((l1 >= l3) || (l1 <= 0L)) {}
        }
        catch (Exception paramContext)
        {
          l3 = l1;
          l1 = l2;
          l2 = l3;
        }
        try
        {
          a(this.f, this.g);
          this.g = this.k.a(paramString2);
          l4 = l1;
          l2 = l3;
        }
        catch (Exception paramContext)
        {
          label710:
          l2 = l1;
          l1 = l3;
          l4 = l2;
          l2 = l1;
          continue;
        }
        if ((l4 != l2) || ((l4 == 0L) && (l2 == 0L)))
        {
          l1 = System.currentTimeMillis();
          if ((!this.l) || ((this.l) && (l4 == 0L) && (l2 == 0L))) {
            if (this.f != null)
            {
              paramContext = this.f.edit();
              paramContext.putLong("t2", l1);
              paramContext.commit();
            }
          }
        }
        l2 = 0L;
        l4 = l1;
      }
    }
  }
  
  private static void a(SharedPreferences paramSharedPreferences, b paramb)
  {
    if ((paramSharedPreferences != null) && (paramb != null))
    {
      paramb = paramb.c();
      paramb.a();
      paramSharedPreferences = paramSharedPreferences.getAll().entrySet().iterator();
    }
    for (;;)
    {
      if (!paramSharedPreferences.hasNext())
      {
        paramb.b();
        return;
      }
      Object localObject = (Map.Entry)paramSharedPreferences.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject instanceof String)) {
        paramb.a(str, (String)localObject);
      } else if ((localObject instanceof Integer)) {
        paramb.a(str, ((Integer)localObject).intValue());
      } else if ((localObject instanceof Long)) {
        paramb.a(str, ((Long)localObject).longValue());
      } else if ((localObject instanceof Float)) {
        paramb.a(str, ((Float)localObject).floatValue());
      } else if ((localObject instanceof Boolean)) {
        paramb.a(str, ((Boolean)localObject).booleanValue());
      }
    }
  }
  
  private static void a(b paramb, SharedPreferences paramSharedPreferences)
  {
    if ((paramb != null) && (paramSharedPreferences != null))
    {
      paramSharedPreferences = paramSharedPreferences.edit();
      if (paramSharedPreferences != null)
      {
        paramSharedPreferences.clear();
        paramb = paramb.b().entrySet().iterator();
      }
    }
    for (;;)
    {
      if (!paramb.hasNext())
      {
        paramSharedPreferences.commit();
        return;
      }
      Object localObject = (Map.Entry)paramb.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject instanceof String)) {
        paramSharedPreferences.putString(str, (String)localObject);
      } else if ((localObject instanceof Integer)) {
        paramSharedPreferences.putInt(str, ((Integer)localObject).intValue());
      } else if ((localObject instanceof Long)) {
        paramSharedPreferences.putLong(str, ((Long)localObject).longValue());
      } else if ((localObject instanceof Float)) {
        paramSharedPreferences.putFloat(str, ((Float)localObject).floatValue());
      } else if ((localObject instanceof Boolean)) {
        paramSharedPreferences.putBoolean(str, ((Boolean)localObject).booleanValue());
      }
    }
  }
  
  private boolean b()
  {
    if (this.g != null)
    {
      boolean bool = this.g.a();
      if (!bool) {
        a();
      }
      return bool;
    }
    return false;
  }
  
  private d c(String paramString)
  {
    d locald = null;
    File localFile = Environment.getExternalStorageDirectory();
    if (localFile != null)
    {
      localFile = new File(String.format("%s%s%s", new Object[] { localFile.getAbsolutePath(), File.separator, paramString }));
      paramString = localFile;
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    for (paramString = localFile;; paramString = null)
    {
      if (paramString != null)
      {
        this.k = new d(paramString.getAbsolutePath());
        locald = this.k;
      }
      return locald;
    }
  }
  
  private void c()
  {
    if ((this.h == null) && (this.f != null)) {
      this.h = this.f.edit();
    }
    if ((this.e) && (this.i == null) && (this.g != null)) {
      this.i = this.g.c();
    }
    b();
  }
  
  public final void a(String paramString)
  {
    if ((!e.a(paramString)) && (!paramString.equals("t")))
    {
      c();
      if (this.h != null) {
        this.h.remove(paramString);
      }
      if (this.i != null) {
        this.i.a(paramString);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((!e.a(paramString1)) && (!paramString1.equals("t")))
    {
      c();
      if (this.h != null) {
        this.h.putString(paramString1, paramString2);
      }
      if (this.i != null) {
        this.i.a(paramString1, paramString2);
      }
    }
  }
  
  public final boolean a()
  {
    boolean bool2 = true;
    long l1 = System.currentTimeMillis();
    boolean bool1 = bool2;
    if (this.h != null)
    {
      if ((!this.l) && (this.f != null)) {
        this.h.putLong("t", l1);
      }
      bool1 = bool2;
      if (!this.h.commit()) {
        bool1 = false;
      }
    }
    if ((this.f != null) && (this.j != null)) {
      this.f = this.j.getSharedPreferences(this.a, 0);
    }
    Object localObject1 = null;
    try
    {
      localObject2 = Environment.getExternalStorageState();
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        try
        {
          Object localObject2;
          boolean bool3;
          if (this.k != null)
          {
            this.g = this.k.a(this.a);
            bool3 = bool2;
          }
          return bool3;
        }
        catch (Exception localException1) {}
        localException2 = localException2;
        localException2.printStackTrace();
        continue;
        a(this.g, this.f);
        continue;
        bool2 = bool1;
        if (this.i != null)
        {
          bool2 = bool1;
          if (!this.i.b()) {
            bool2 = false;
          }
        }
      }
    }
    bool3 = bool1;
    if (!e.a((String)localObject1))
    {
      bool2 = bool1;
      if (((String)localObject1).equals("mounted"))
      {
        if (this.g != null) {
          break label277;
        }
        localObject2 = c(this.b);
        bool2 = bool1;
        if (localObject2 != null)
        {
          this.g = ((d)localObject2).a(this.a);
          if (this.l) {
            break label263;
          }
          a(this.f, this.g);
          this.i = this.g.c();
          bool2 = bool1;
        }
      }
      if (!((String)localObject1).equals("mounted"))
      {
        bool3 = bool2;
        if (((String)localObject1).equals("mounted_ro"))
        {
          bool3 = bool2;
          if (this.g == null) {}
        }
      }
      else
      {
        bool3 = bool2;
      }
    }
    label263:
    label277:
    return bool2;
  }
  
  public final String b(String paramString)
  {
    b();
    if (this.f != null)
    {
      String str = this.f.getString(paramString, "");
      if (!e.a(str)) {
        return str;
      }
    }
    if (this.g != null) {
      return this.g.a(paramString, "");
    }
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/f/a/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */