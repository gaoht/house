package com.megvii.zhimasdk.b.a.b.f;

import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.h;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Stack;

public class d
{
  public static URI a(URI paramURI)
  {
    a.a(paramURI, "URI");
    if (paramURI.isOpaque()) {
      return paramURI;
    }
    paramURI = new c(paramURI);
    if (paramURI.b() != null) {
      paramURI.b(null);
    }
    if (h.a(paramURI.d())) {
      paramURI.d("/");
    }
    if (paramURI.c() != null) {
      paramURI.c(paramURI.c().toLowerCase(Locale.ENGLISH));
    }
    paramURI.e(null);
    return paramURI.a();
  }
  
  public static URI a(URI paramURI, n paramn, boolean paramBoolean)
  {
    a.a(paramURI, "URI");
    if (paramURI.isOpaque()) {
      return paramURI;
    }
    paramURI = new c(paramURI);
    if (paramn != null)
    {
      paramURI.a(paramn.c());
      paramURI.c(paramn.a());
      paramURI.a(paramn.b());
    }
    for (;;)
    {
      if (paramBoolean) {
        paramURI.e(null);
      }
      if (h.a(paramURI.d())) {
        paramURI.d("/");
      }
      return paramURI.a();
      paramURI.a(null);
      paramURI.c(null);
      paramURI.a(-1);
    }
  }
  
  public static URI a(URI paramURI1, URI paramURI2)
  {
    a.a(paramURI1, "Base URI");
    a.a(paramURI2, "Reference URI");
    String str = paramURI2.toString();
    if (str.startsWith("?")) {
      return b(paramURI1, paramURI2);
    }
    if (str.length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramURI2 = URI.create("#");
      }
      paramURI2 = paramURI1.resolve(paramURI2);
      paramURI1 = paramURI2;
      if (i != 0)
      {
        paramURI1 = paramURI2.toString();
        paramURI1 = URI.create(paramURI1.substring(0, paramURI1.indexOf('#')));
      }
      return c(paramURI1);
    }
  }
  
  public static n b(URI paramURI)
  {
    if (paramURI == null) {
      return null;
    }
    int i;
    Object localObject;
    int j;
    if (paramURI.isAbsolute())
    {
      i = paramURI.getPort();
      String str = paramURI.getHost();
      localObject = str;
      j = i;
      if (str == null)
      {
        str = paramURI.getAuthority();
        localObject = str;
        j = i;
        if (str != null)
        {
          j = str.indexOf('@');
          if (j < 0) {
            break label231;
          }
          if (str.length() > j + 1) {
            localObject = str.substring(j + 1);
          }
        }
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        int n = ((String)localObject).indexOf(':');
        if (n >= 0)
        {
          int m = n + 1;
          j = m;
          int k = 0;
          for (;;)
          {
            if ((j < ((String)localObject).length()) && (Character.isDigit(((String)localObject).charAt(j))))
            {
              k += 1;
              j += 1;
              continue;
              localObject = null;
              break;
            }
          }
          if (k > 0)
          {
            try
            {
              j = Integer.parseInt(((String)localObject).substring(m, m + k));
              i = j;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;) {}
            }
            localObject = ((String)localObject).substring(0, n);
          }
        }
      }
      for (j = i;; j = i)
      {
        paramURI = paramURI.getScheme();
        if (!h.b((CharSequence)localObject)) {}
        for (paramURI = new n((String)localObject, j, paramURI);; paramURI = null) {
          return paramURI;
        }
        break;
      }
      label231:
      localObject = localNumberFormatException;
    }
  }
  
  private static URI b(URI paramURI1, URI paramURI2)
  {
    String str = paramURI1.toString();
    paramURI1 = str;
    if (str.indexOf('?') > -1) {
      paramURI1 = str.substring(0, str.indexOf('?'));
    }
    return URI.create(paramURI1 + paramURI2.toString());
  }
  
  private static URI c(URI paramURI)
  {
    Object localObject1;
    if ((paramURI.isOpaque()) || (paramURI.getAuthority() == null)) {
      localObject1 = paramURI;
    }
    for (;;)
    {
      return (URI)localObject1;
      a.a(paramURI.isAbsolute(), "Base URI must be absolute");
      int i;
      label60:
      Object localObject4;
      if (paramURI.getPath() == null)
      {
        localObject1 = "";
        localObject3 = ((String)localObject1).split("/");
        localObject2 = new Stack();
        int j = localObject3.length;
        i = 0;
        if (i >= j) {
          break label142;
        }
        localObject4 = localObject3[i];
        if ((((String)localObject4).length() != 0) && (!".".equals(localObject4))) {
          break label104;
        }
      }
      for (;;)
      {
        i += 1;
        break label60;
        localObject1 = paramURI.getPath();
        break;
        label104:
        if ("..".equals(localObject4))
        {
          if (!((Stack)localObject2).isEmpty()) {
            ((Stack)localObject2).pop();
          }
        }
        else {
          ((Stack)localObject2).push(localObject4);
        }
      }
      label142:
      Object localObject3 = new StringBuilder();
      Object localObject2 = ((Stack)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        ((StringBuilder)localObject3).append('/').append((String)localObject4);
      }
      if (((String)localObject1).lastIndexOf('/') == ((String)localObject1).length() - 1) {
        ((StringBuilder)localObject3).append('/');
      }
      try
      {
        localObject2 = new URI(paramURI.getScheme().toLowerCase(Locale.ENGLISH), paramURI.getAuthority().toLowerCase(Locale.ENGLISH), ((StringBuilder)localObject3).toString(), null, null);
        if (paramURI.getQuery() == null)
        {
          localObject1 = localObject2;
          if (paramURI.getFragment() == null) {
            continue;
          }
        }
        localObject1 = new StringBuilder(((URI)localObject2).toASCIIString());
        if (paramURI.getQuery() != null) {
          ((StringBuilder)localObject1).append('?').append(paramURI.getRawQuery());
        }
        if (paramURI.getFragment() != null) {
          ((StringBuilder)localObject1).append('#').append(paramURI.getRawFragment());
        }
        paramURI = URI.create(((StringBuilder)localObject1).toString());
        return paramURI;
      }
      catch (URISyntaxException paramURI)
      {
        throw new IllegalArgumentException(paramURI);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */