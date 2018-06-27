package com.megvii.zhimasdk.b;

import android.text.TextUtils;
import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.k.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class j
  implements com.megvii.zhimasdk.b.a.k
{
  private static final UnsupportedOperationException a = new UnsupportedOperationException("Unsupported operation in this implementation.");
  private static final byte[] b = "true".getBytes();
  private static final byte[] c = "false".getBytes();
  private static final byte[] d = "null".getBytes();
  private static final byte[] e = a("name");
  private static final byte[] f = a("type");
  private static final byte[] g = a("contents");
  private static final e h = new b("Content-Type", "application/json");
  private static final e i = new b("Content-Encoding", "gzip");
  private final byte[] j = new byte['က'];
  private final Map<String, Object> k = new HashMap();
  private final e l;
  private final byte[] m;
  private final r n;
  
  public j(r paramr, boolean paramBoolean, String paramString)
  {
    this.n = paramr;
    if (paramBoolean)
    {
      paramr = i;
      this.l = paramr;
      if (!TextUtils.isEmpty(paramString)) {
        break label66;
      }
    }
    label66:
    for (paramr = (r)localObject;; paramr = a(paramString))
    {
      this.m = paramr;
      return;
      paramr = null;
      break;
    }
  }
  
  private void a(OutputStream paramOutputStream, q.a parama)
  {
    a(paramOutputStream, parama.a.getName(), parama.b);
    long l1 = 0L;
    long l2 = parama.a.length();
    parama = new FileInputStream(parama.a);
    f localf = new f(paramOutputStream, 18);
    for (;;)
    {
      int i1 = parama.read(this.j);
      if (i1 == -1) {
        break;
      }
      localf.write(this.j, 0, i1);
      l1 += i1;
      this.n.b(l1, l2);
    }
    a.a(localf);
    b(paramOutputStream);
    a.a(parama);
  }
  
  private void a(OutputStream paramOutputStream, q.b paramb)
  {
    a(paramOutputStream, paramb.b, paramb.c);
    f localf = new f(paramOutputStream, 18);
    for (;;)
    {
      int i1 = paramb.a.read(this.j);
      if (i1 == -1) {
        break;
      }
      localf.write(this.j, 0, i1);
    }
    a.a(localf);
    b(paramOutputStream);
    if (paramb.d) {
      a.a(paramb.a);
    }
  }
  
  private void a(OutputStream paramOutputStream, String paramString1, String paramString2)
  {
    paramOutputStream.write(e);
    paramOutputStream.write(58);
    paramOutputStream.write(a(paramString1));
    paramOutputStream.write(44);
    paramOutputStream.write(f);
    paramOutputStream.write(58);
    paramOutputStream.write(a(paramString2));
    paramOutputStream.write(44);
    paramOutputStream.write(g);
    paramOutputStream.write(58);
    paramOutputStream.write(34);
  }
  
  static byte[] a(String paramString)
  {
    if (paramString == null) {
      return d;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append('"');
    int i3 = paramString.length();
    int i1 = -1;
    int i2 = i1 + 1;
    if (i2 < i3)
    {
      char c1 = paramString.charAt(i2);
      String str;
      int i4;
      switch (c1)
      {
      default: 
        if ((c1 <= '\037') || ((c1 >= '') && (c1 <= '')) || ((c1 >= ' ') && (c1 <= '⃿')))
        {
          str = Integer.toHexString(c1);
          localStringBuilder.append("\\u");
          i4 = str.length();
          i1 = 0;
        }
        break;
      case '"': 
        while (i1 < 4 - i4)
        {
          localStringBuilder.append('0');
          i1 += 1;
          continue;
          localStringBuilder.append("\\\"");
        }
      }
      for (;;)
      {
        i1 = i2;
        break;
        localStringBuilder.append("\\\\");
        continue;
        localStringBuilder.append("\\b");
        continue;
        localStringBuilder.append("\\f");
        continue;
        localStringBuilder.append("\\n");
        continue;
        localStringBuilder.append("\\r");
        continue;
        localStringBuilder.append("\\t");
        continue;
        localStringBuilder.append(str.toUpperCase(Locale.US));
        continue;
        localStringBuilder.append(c1);
      }
    }
    localStringBuilder.append('"');
    return localStringBuilder.toString().getBytes();
  }
  
  private void b(OutputStream paramOutputStream)
  {
    paramOutputStream.write(34);
  }
  
  public InputStream a()
  {
    throw a;
  }
  
  public void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      throw new IllegalStateException("Output stream cannot be null.");
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = paramOutputStream;
    if (this.l != null) {
      localObject1 = new GZIPOutputStream(paramOutputStream, 4096);
    }
    ((OutputStream)localObject1).write(123);
    paramOutputStream = this.k.keySet();
    int i2 = paramOutputStream.size();
    if (i2 > 0)
    {
      Iterator localIterator = paramOutputStream.iterator();
      int i1 = 0;
      if (localIterator.hasNext())
      {
        paramOutputStream = (String)localIterator.next();
        i1 += 1;
        for (;;)
        {
          Object localObject2;
          try
          {
            localObject2 = this.k.get(paramOutputStream);
            ((OutputStream)localObject1).write(a(paramOutputStream));
            ((OutputStream)localObject1).write(58);
            if (localObject2 == null)
            {
              ((OutputStream)localObject1).write(d);
              if ((this.m != null) || (i1 < i2)) {
                ((OutputStream)localObject1).write(44);
              }
              break;
            }
            boolean bool = localObject2 instanceof q.a;
            if ((!bool) && (!(localObject2 instanceof q.b))) {
              break label257;
            }
            ((OutputStream)localObject1).write(123);
            if (bool)
            {
              a((OutputStream)localObject1, (q.a)localObject2);
              ((OutputStream)localObject1).write(125);
              continue;
            }
            a((OutputStream)localObject1, (q.b)localObject2);
          }
          finally
          {
            if ((this.m != null) || (i1 < i2)) {
              ((OutputStream)localObject1).write(44);
            }
          }
          continue;
          label257:
          if ((localObject2 instanceof k))
          {
            ((OutputStream)localObject1).write(((k)localObject2).a());
          }
          else if ((localObject2 instanceof JSONObject))
          {
            ((OutputStream)localObject1).write(localObject2.toString().getBytes());
          }
          else if ((localObject2 instanceof JSONArray))
          {
            ((OutputStream)localObject1).write(localObject2.toString().getBytes());
          }
          else
          {
            if ((localObject2 instanceof Boolean))
            {
              if (((Boolean)localObject2).booleanValue()) {}
              for (paramOutputStream = b;; paramOutputStream = c)
              {
                ((OutputStream)localObject1).write(paramOutputStream);
                break;
              }
            }
            if ((localObject2 instanceof Long)) {
              ((OutputStream)localObject1).write((((Number)localObject2).longValue() + "").getBytes());
            } else if ((localObject2 instanceof Double)) {
              ((OutputStream)localObject1).write((((Number)localObject2).doubleValue() + "").getBytes());
            } else if ((localObject2 instanceof Float)) {
              ((OutputStream)localObject1).write((((Number)localObject2).floatValue() + "").getBytes());
            } else if ((localObject2 instanceof Integer)) {
              ((OutputStream)localObject1).write((((Number)localObject2).intValue() + "").getBytes());
            } else {
              ((OutputStream)localObject1).write(a(localObject2.toString()));
            }
          }
        }
      }
      l1 = System.currentTimeMillis() - l1;
      if (this.m != null)
      {
        ((OutputStream)localObject1).write(this.m);
        ((OutputStream)localObject1).write(58);
        ((OutputStream)localObject1).write((l1 + "").getBytes());
      }
      a.a.c("JsonStreamerEntity", "Uploaded JSON in " + Math.floor(l1 / 1000L) + " seconds");
    }
    ((OutputStream)localObject1).write(125);
    ((OutputStream)localObject1).flush();
    a.a((OutputStream)localObject1);
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.k.put(paramString, paramObject);
  }
  
  public long b()
  {
    return -1L;
  }
  
  public void c() {}
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public boolean f()
  {
    return false;
  }
  
  public e g()
  {
    return this.l;
  }
  
  public e h()
  {
    return h;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */