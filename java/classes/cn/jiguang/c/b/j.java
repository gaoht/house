package cn.jiguang.c.b;

import cn.jiguang.c.a.a;
import cn.jiguang.d.d;
import cn.jiguang.f.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  private static j j;
  private static Pattern k;
  private static final String[] z;
  List<String> a = new ArrayList();
  List<String> b = new ArrayList();
  String c;
  String d;
  int e;
  List<String> f = new ArrayList();
  List<Integer> g = new ArrayList();
  String h;
  boolean i = false;
  
  static
  {
    Object localObject2 = new String[13];
    int n = 0;
    Object localObject3 = "\016Z\007\n];\\";
    int m = -1;
    Object localObject1 = localObject2;
    int i7;
    Object localObject4;
    int i3;
    for (;;)
    {
      char[] arrayOfChar = ((String)localObject3).toCharArray();
      i1 = arrayOfChar.length;
      int i4 = 0;
      i2 = 0;
      int i6 = m;
      localObject3 = arrayOfChar;
      i7 = n;
      localObject4 = localObject1;
      i3 = i1;
      Object localObject5;
      int i5;
      if (i1 <= 1)
      {
        localObject5 = localObject1;
        localObject1 = arrayOfChar;
        i5 = m;
      }
      label143:
      do
      {
        i3 = i2;
        for (;;)
        {
          localObject3 = localObject1;
          i4 = localObject3[i2];
          switch (i3 % 5)
          {
          default: 
            m = 51;
            localObject3[i2] = ((char)(m ^ i4));
            i3 += 1;
            if (i1 != 0) {
              break label143;
            }
            i2 = i1;
          }
        }
        i4 = i3;
        i3 = i1;
        localObject4 = localObject5;
        i7 = n;
        localObject3 = localObject1;
        i6 = i5;
        i5 = i6;
        localObject1 = localObject3;
        n = i7;
        localObject5 = localObject4;
        i1 = i3;
        i2 = i4;
      } while (i3 > i4);
      localObject1 = new String((char[])localObject3).intern();
      switch (i6)
      {
      default: 
        localObject4[i7] = localObject1;
        n = 1;
        localObject3 = "\033R\035/V9\023\000,\023-R\0060V}\\\004\034P2]\032c\036}";
        m = 0;
        localObject1 = localObject2;
        break;
      case 0: 
        localObject4[i7] = localObject1;
        n = 2;
        localObject3 = "\023\\T,C}P\033-]s";
        m = 1;
        localObject1 = localObject2;
        break;
      case 1: 
        localObject4[i7] = localObject1;
        n = 3;
        localObject3 = "\033R\035/V9\023\000,\023-R\0060V}Z\0040\036l\023Yc^<Z\032cZ-\035";
        m = 2;
        localObject1 = localObject2;
        break;
      case 2: 
        localObject4[i7] = localObject1;
        n = 4;
        localObject3 = "\b]\021;C8P\000&W}\036T*]+R\030*W}@\0350\023p\023\0353@}R\0061R$\023\030&]}Z\007c\003";
        m = 3;
        localObject1 = localObject2;
        break;
      case 3: 
        localObject4[i7] = localObject1;
        n = 5;
        localObject3 = "\b]\021;C8P\000&W}\036T\n]+R\030*W}@\0350\023p\023\032,\0234C\007cX8JZ";
        m = 4;
        localObject1 = localObject2;
        break;
      case 4: 
        localObject4[i7] = localObject1;
        n = 6;
        localObject3 = "2C+ \\3]\007";
        m = 5;
        localObject1 = localObject2;
        break;
      case 5: 
        localObject4[i7] = localObject1;
        n = 7;
        localObject3 = "\b]\021;C8P\000&W|\022Ucy\016|:\006K>V\0047Z2]N";
        m = 6;
        localObject1 = localObject2;
        break;
      case 6: 
        localObject4[i7] = localObject1;
        n = 8;
        localObject3 = "2C+ \\3]\007cZ.\023\0326_1";
        m = 7;
        localObject1 = localObject2;
        break;
      case 7: 
        localObject4[i7] = localObject1;
        n = 9;
        localObject3 = "4C\007y";
        m = 8;
        localObject1 = localObject2;
        break;
      case 8: 
        localObject4[i7] = localObject1;
        n = 10;
        localObject3 = "4C\007";
        m = 9;
        localObject1 = localObject2;
        break;
      case 9: 
        localObject4[i7] = localObject1;
        n = 11;
        localObject3 = "4C\007cZ.\023\0326_1";
        m = 10;
        localObject1 = localObject2;
        break;
      case 10: 
        localObject4[i7] = localObject1;
        n = 12;
        localObject3 = "2C+ \\3]\007y";
        m = 11;
        localObject1 = localObject2;
      }
    }
    localObject4[i7] = localObject1;
    z = (String[])localObject2;
    j = null;
    localObject1 = "u\033/s\036lnK\030\003p\n)8\002q\001\t\037\035tO\\qhm\036@\036hm\036M\036os\032\bk\001hhDn\006\000oZj\032&\000\tk\033\006\003YrnbhDn\n\000HEo\001 \032\bk\001\006\003Ywn\006\003YzntO\\q\006\006\003Yvnt\032".toCharArray();
    n = localObject1.length;
    int i2 = 0;
    m = 0;
    localObject2 = localObject1;
    int i1 = n;
    if (n <= 1) {}
    label595:
    label713:
    do
    {
      i2 = m;
      i1 = m;
      localObject2 = localObject1;
      i3 = localObject2[i1];
      switch (i2 % 5)
      {
      default: 
        m = 51;
      }
      for (;;)
      {
        localObject2[i1] = ((char)(m ^ i3));
        i2 += 1;
        if (n != 0) {
          break label713;
        }
        i1 = n;
        break label595;
        m = 93;
        break;
        m = 51;
        break;
        m = 116;
        break;
        m = 67;
        break;
        m = 93;
        continue;
        m = 51;
        continue;
        m = 116;
        continue;
        m = 67;
      }
      i1 = n;
      localObject2 = localObject1;
      localObject1 = localObject2;
      n = i1;
      m = i2;
    } while (i1 > i2);
    k = Pattern.compile(new String((char[])localObject2).intern());
  }
  
  public static boolean c(String paramString)
  {
    return k.matcher(paramString).matches();
  }
  
  public final String a()
  {
    return this.d;
  }
  
  public final void a(String paramString)
  {
    Object localObject = paramString;
    if (h.a(paramString)) {
      localObject = a.q();
    }
    try
    {
      paramString = new JSONObject((String)localObject);
      localObject = paramString.getJSONArray(z[10]);
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        d.g(z[0], z[11]);
        return;
      }
      d.a(z[0], z[9] + ((JSONArray)localObject).toString());
      int m = 0;
      while (m < ((JSONArray)localObject).length())
      {
        this.a.add(((JSONArray)localObject).optString(m));
        m += 1;
      }
      paramString = paramString.getJSONArray(z[6]);
      if ((paramString == null) || (paramString.length() == 0)) {
        d.g(z[0], z[8]);
      }
      if (paramString != null)
      {
        d.a(z[0], z[12] + paramString.toString());
        m = 0;
        while (m < paramString.length())
        {
          this.b.add(paramString.optString(m));
          m += 1;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      d.c(z[0], z[7], paramString);
    }
  }
  
  public final int b()
  {
    return this.e;
  }
  
  public final void b(String paramString)
  {
    this.h = paramString;
    if (this.a == null)
    {
      d.j(z[0], z[5]);
      this.i = true;
    }
    for (;;)
    {
      return;
      if (this.a.size() == 0)
      {
        d.j(z[0], z[4]);
        this.i = true;
        return;
      }
      try
      {
        paramString = new k((String)this.a.get(0));
        this.d = paramString.a;
        this.e = paramString.b;
        if (this.b == null)
        {
          d.c(z[0], z[2]);
          return;
        }
      }
      catch (Exception paramString)
      {
        d.d(z[0], z[3], paramString);
        this.i = true;
        return;
      }
      paramString = this.b.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        try
        {
          k localk = new k(str);
          this.f.add(localk.a);
          this.g.add(Integer.valueOf(localk.b));
        }
        catch (Exception localException)
        {
          d.e(z[0], z[1] + str, localException);
        }
      }
    }
  }
  
  public final List<String> c()
  {
    return this.f;
  }
  
  public final List<Integer> d()
  {
    return this.g;
  }
  
  public final boolean e()
  {
    return this.i;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */