package cn.jiguang.a.c;

import android.content.Context;
import cn.jiguang.a.a.a.i;
import cn.jiguang.a.a.b.b;
import cn.jiguang.a.a.b.g;
import cn.jiguang.api.MultiSpHelper;
import cn.jiguang.c.d.l;
import cn.jiguang.d.d;
import cn.jiguang.f.h;
import cn.jiguang.f.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private static int a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[29];
    int j = 0;
    Object localObject2 = "P5he\005X6l";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 105;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "R*vN\fI18^\000UevU\035\021,vS\035\035ej_\035D7v";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "d+}B\031T&l_\r\020eRj\034B-8R\bB+?NIS }TIC S\032E j\026IV,n_ID58N\001X68H\fA*jN";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "v*l\032#b\nV\021R hN\000^+8M\001T+8H\fA*jNIP5hV\000B16";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "A${Q\bV 8S\007W*8N\006E$t\032\007D(8\027I";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "c hU\033E\r}V\031T7";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\035e|[\035PekS\023T8\027I";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "c hU\033EeMI\fCeYJ\031BeKN\bE0k";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "w$qVIE*8I\035P7l\032\006E-}HIP5h\032\nP0k_\r\021'a\032&D1W\\$T(wH\020\037";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "P&lS\006_j_\031^7lu\031T7yN\000^+8\027IR*vN\f_1\"";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "\020TvIR*vN\fI1";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "P&lS\006_j_\031^7lj\fC(qI\032X*vs\007W*";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "r$v\032\007^18]\fEeyT\020\0215}W\000B6qU\007";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "JglU\035P):\000LUi:J\bV :\000LUi:I\f_!}H\000Ug\"\030LBg4\030\034X!:\000LBi:J\fC(qI\032X*ve\005X6l\030S\0246e";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "\035g";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "f\f^s";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "]$kN6C hU\033E\032|_\037X&}e\000_#w";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "]$kN6R-}Y\002n0k_\033P5he\032E$lO\032";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "]*{[\035X*ve\n^)t_\nE\032~H\f@0}T\nH";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "]$kN6R*tV\fR1qU\007n)wY\bE,wT";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "X6[U\005] {N\000^+TU\nP1qU\007 }^\fUet[\032E";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "{\004v[\005H1qY\032r*uW\006_\006wT\017X\"k";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "\035+wMS";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "_'GO\031]*y^";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "]'ke\033T5wH\035n v[\013] ";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "_'GV\bB1lS\004T";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "A jS\006U\021yI\002Bk6\024";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "A jS\006U\021yI\002Be~[\000] |\026\000B\023yV\000U\027}]\000B1}H\fU~[\005B ";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "c hU\033EeTU\nP1qU\007\021,v\\\006";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = 20480;
        return;
        i = 49;
        continue;
        i = 69;
        continue;
        i = 24;
        continue;
        i = 58;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    d.c(z[5], z[28]);
    i.a(paramContext);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    d.c(z[5], z[7]);
    new cn.jiguang.a.a.b.a(paramContext, paramString).start();
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject)
  {
    if (!cn.jiguang.c.a.a.s()) {}
    do
    {
      return;
      if (paramContext == null) {
        throw new IllegalArgumentException(z[10]);
      }
    } while ((paramJSONObject == null) || (paramJSONObject.length() <= 0));
    l.a(paramContext, paramJSONObject);
    d.c(z[5], z[9] + paramJSONObject.toString());
  }
  
  public static void b(Context paramContext)
  {
    if (!cn.jiguang.c.a.a.s()) {
      d.g(z[5], z[2]);
    }
    JSONArray localJSONArray;
    int j;
    do
    {
      do
      {
        return;
        if (paramContext == null)
        {
          d.g(z[5], z[1]);
          return;
        }
        localJSONArray = cn.jiguang.a.a.b.c.b(paramContext);
      } while ((localJSONArray == null) || (localJSONArray.length() == 0));
      j = localJSONArray.length();
      i = localJSONArray.toString().length();
      d.e(z[5], z[4] + j + z[6] + i);
      if (i > a) {
        break;
      }
      localObject1 = cn.jiguang.f.a.a(z[0], localJSONArray);
    } while ((localObject1 == null) || (((JSONObject)localObject1).length() <= 0));
    l.a(paramContext, (JSONObject)localObject1);
    return;
    Object localObject1 = new JSONArray();
    int i = 0;
    while (i < j) {
      try
      {
        ((JSONArray)localObject1).put(localJSONArray.getJSONObject(i));
        Object localObject2;
        if (((JSONArray)localObject1).toString().length() <= a)
        {
          localObject2 = localObject1;
          if (j - 1 != i) {}
        }
        else
        {
          localObject1 = cn.jiguang.f.a.a(z[0], (JSONArray)localObject1);
          if ((localObject1 != null) && (((JSONObject)localObject1).length() > 0)) {
            l.a(paramContext, (JSONObject)localObject1);
          }
          localObject2 = new JSONArray();
        }
        i += 1;
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          d.i(z[5], z[3]);
        }
      }
    }
  }
  
  public static void c(Context paramContext)
  {
    d.a(z[5], z[11]);
    String[] arrayOfString = cn.jiguang.a.a.b.c.a(paramContext);
    if ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      d.i(z[5], z[12]);
      return;
    }
    int n = arrayOfString.length;
    Object localObject = "[";
    int m = 0;
    int i = 0;
    int j = 0;
    label62:
    if (m < n)
    {
      str = arrayOfString[m];
      if (i != 0) {
        break label263;
      }
    }
    label263:
    for (String str = (String)localObject + "\"" + str + "\"";; str = (String)localObject + z[14] + str + "\"")
    {
      m += 1;
      i += 1;
      int k;
      if ((i < 50) && (str.length() <= 1000))
      {
        k = j;
        localObject = str;
        if (m != n) {}
      }
      else
      {
        str = str + "]";
        str = String.format(z[13], new Object[] { Integer.valueOf(n), Integer.valueOf(j), cn.jiguang.c.a.a.y(), Long.valueOf(cn.jiguang.c.a.a.r()), str });
        d.c(z[5], str);
        l.a(paramContext, cn.jiguang.f.a.a(z[0], str));
        localObject = "[";
        k = j + 1;
        i = 0;
      }
      j = k;
      break label62;
      break;
    }
  }
  
  public static void d(Context paramContext)
  {
    int j = 0;
    d.f(z[5], z[26]);
    if (!cn.jiguang.c.a.a.s()) {
      d.c(z[5], z[27]);
    }
    label197:
    label216:
    label218:
    label272:
    label316:
    label323:
    label350:
    label355:
    label410:
    for (;;)
    {
      return;
      long l1 = MultiSpHelper.getLong(cn.jiguang.c.a.e, z[16], 0L);
      long l2 = System.currentTimeMillis();
      int i;
      long l3;
      if (l2 - l1 > 86400000L)
      {
        MultiSpHelper.commitLong(cn.jiguang.c.a.e, z[16], l2);
        i = 1;
        if (i != 0) {
          b.c(paramContext);
        }
        if (cn.jiguang.c.a.a.a()) {
          cn.jiguang.c.f.c.a(paramContext);
        }
        if (MultiSpHelper.getBoolean(paramContext, z[24], true))
        {
          l2 = MultiSpHelper.getLong(paramContext, z[19], 0L);
          l3 = System.currentTimeMillis();
          d.c(z[21], z[20] + l2 + z[22] + l3);
          l1 = MultiSpHelper.getLong(paramContext, z[18], 900000L);
          if (l1 <= 0L) {
            break label316;
          }
          if (l2 > 0L) {
            break label323;
          }
          MultiSpHelper.commitLong(paramContext, z[19], l3);
          i = 0;
          if (i != 0) {
            a(paramContext);
          }
        }
        l1 = MultiSpHelper.getLong(cn.jiguang.c.a.e, z[17], 0L);
        l2 = System.currentTimeMillis();
        if (l2 - l1 <= 3600000L) {
          break label350;
        }
        MultiSpHelper.commitLong(cn.jiguang.c.a.e, z[17], l2);
        i = 1;
        if (i != 0) {
          a(paramContext, null);
        }
        if (!cn.jiguang.f.a.c(paramContext).toUpperCase().startsWith(z[15])) {
          break label355;
        }
        i = j;
      }
      for (;;)
      {
        if (i == 0) {
          break label410;
        }
        g.a(paramContext);
        return;
        i = 0;
        break;
        l1 = 900000L;
        break label197;
        if (l3 - l2 < l1) {
          break label216;
        }
        MultiSpHelper.commitLong(paramContext, z[19], l3);
        i = 1;
        break label218;
        i = 0;
        break label272;
        if (!MultiSpHelper.getBoolean(paramContext, z[23], false))
        {
          i = j;
          if (!h.a(cn.jiguang.a.b.a.b(paramContext))) {}
        }
        else
        {
          l1 = MultiSpHelper.getLong(paramContext, z[25], 0L);
          i = j;
          if (System.currentTimeMillis() - l1 > 3600000L) {
            i = 1;
          }
        }
      }
    }
  }
  
  public static void e(Context paramContext)
  {
    d(paramContext);
    try
    {
      k.a(paramContext, 1800L);
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      d.g(z[5], z[8]);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */