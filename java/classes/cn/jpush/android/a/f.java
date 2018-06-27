package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.data.a;
import cn.jpush.android.data.c;
import cn.jpush.android.data.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[40];
    int j = 0;
    Object localObject2 = "RC\007VoS\007d\027eSTg\027pE\035y\021\"P\025~\032gRZ71k@\0217\003r\026\004e\031aS\007d\037lQZ";
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
        i = 118;
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
        localObject2 = "WX\037y\031uXTZ%E\026\004e\031vY\027x\032\"@\021e\005kY\0329VE_\002rVwFT:V";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "RD\033c\031aY\030_\023nF\021e";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "Lc8[VaY\032c\023zB";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "WX\037y\031u\026\031d\021\"B\rg\023\"W\020H\002\"\013T";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "cU\000~\031l\f\004v\004qS9d\021OS\007d\027eS";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "Q^\033`3lB\035c\017,F\006x\025gE\0077\031tS\0069";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "oi\027x\030vS\032c";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "cR+c";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "V^\0217\005gU\033y\022HE\033y9`\\\021t\002\"_\0077\030wZ\0306";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "GX\000~\002{\030\004v\004qSTc\036g\026\007r\025mX\0207\034qY\0327\031`\\\021t\002\"Y\002r\004,";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "Lc8[VhE\033yVmT\036r\025v";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "eS\0007\034qY\0327\031`\\\021t\002\"S\006e\031p";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "G[\004c\017\"\\\007x\030\"X\025z\023\"B\0337\021gB";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "G[\004c\017\"Y\006~\021kX\025{VhE\033yVvN\000";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "WX\037y\031u\026\031d\021\"B\rg\023\"\033T";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "LyTZ%E0";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "DW\035{\023f\026\000xVeS\0007\034qY\0327\020pY\0317\003pZTu\023aW\001d\023mPT~\030tW\030~\022\"C\006{V/\026";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "cR+~\022";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "q^\033`)vO\004r";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "cU\000~\031l\f\004v\004qS;e\037e_\032v\032OE\023Z\023qE\025p\023\"\033Tx\004kQ\035y\027n|\007x\0308<";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "cU\000~\031l\f\030x\027f{\007p<qY\032Q\004m[!e\032\"\033T";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "oE\023H\037f";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "RD\033t\023qETr\030f";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "RW\006d\023\"S\032s";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "rW\006d\023\"\\\007x\030\"S\006e\031p";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "KX\002v\032kRTb\004n\026Y7";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "\\m\034c\002rJ\034c\002rE)<L-\031Z=";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "oS\007d\027eS";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        j = 29;
        localObject2 = "aY\032c\023lB+c\017rS";
        i = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i4] = localObject1;
        j = 30;
        localObject2 = "gN\000e\027q";
        i = 29;
        localObject1 = arrayOfString;
        break;
      case 29: 
        localObject3[i4] = localObject1;
        j = 31;
        localObject2 = "cU\000~\031l\f\004e\023RW\006d\023MD\035p\037lW\030Z\005e{\021d\005cQ\0217[\"Y\006~\021kX\025{<qY\032-|";
        i = 30;
        localObject1 = arrayOfString;
        break;
      case 30: 
        localObject3[i4] = localObject1;
        j = 32;
        localObject2 = "Ly+Z%E0";
        i = 31;
        localObject1 = arrayOfString;
        break;
      case 31: 
        localObject3[i4] = localObject1;
        j = 33;
        localObject2 = "rD\021G\027pE\021X\004kQ\035y\027n{\007p;gE\007v\021g\026\031d\021KRT*V";
        i = 32;
        localObject1 = arrayOfString;
        break;
      case 32: 
        localObject3[i4] = localObject1;
        j = 34;
        localObject2 = "li\033y\032{";
        i = 33;
        localObject1 = arrayOfString;
        break;
      case 33: 
        localObject3[i4] = localObject1;
        j = 35;
        localObject2 = "lY\000~\020kU\025~\031li\000n\006g";
        i = 34;
        localObject1 = arrayOfString;
        break;
      case 34: 
        localObject3[i4] = localObject1;
        j = 36;
        localObject2 = "v_\000{\023";
        i = 35;
        localObject1 = arrayOfString;
        break;
      case 35: 
        localObject3[i4] = localObject1;
        j = 37;
        localObject2 = "li\026b\037nR\021e)kR";
        i = 36;
        localObject1 = arrayOfString;
        break;
      case 36: 
        localObject3[i4] = localObject1;
        j = 38;
        localObject2 = "vY\004]\005mX;u\034gU\0007K?\026\032b\032n";
        i = 37;
        localObject1 = arrayOfString;
        break;
      case 37: 
        localObject3[i4] = localObject1;
        j = 39;
        localObject2 = "m@\021e\004kR\021H\033qQ+~\022";
        i = 38;
        localObject1 = arrayOfString;
        break;
      case 38: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 2;
        continue;
        i = 54;
        continue;
        i = 116;
        continue;
        i = 23;
      }
    }
  }
  
  public static a a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    cn.jpush.android.c.f.c(z[2], z[31] + paramString1);
    if (paramContext == null) {
      throw new IllegalArgumentException(z[3]);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      cn.jpush.android.c.f.i(z[2], z[14]);
      b.a(z[16], 996, paramContext);
      return null;
    }
    paramString1 = a(paramContext, z[32], paramString1);
    if (paramString1 == null)
    {
      cn.jpush.android.c.f.c(z[2], z[38]);
      return null;
    }
    paramContext = paramString1.optString(z[22], "");
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      paramContext = paramString4;
      if (TextUtils.isEmpty(paramString4)) {
        paramContext = paramString1.optString(z[18], "");
      }
      cn.jpush.android.c.f.c(z[2], z[33] + paramContext);
      boolean bool;
      if (paramString1.optInt(z[34], 0) == 1)
      {
        bool = true;
        if (!bool) {
          break label394;
        }
      }
      label394:
      for (int i = paramString1.optInt(z[37], 0);; i = 0)
      {
        paramString4 = new a();
        paramString4.c = paramContext;
        paramString4.a = paramString1;
        paramString4.b = paramString1.optInt(z[19], 3);
        paramString4.e = bool;
        paramString4.f = i;
        paramString4.g = paramString1.optInt(z[35], 0);
        paramString4.i = paramString1.optString(z[28], "");
        paramString4.j = paramString1.optString(z[29], "");
        paramString4.k = paramString1.optString(z[36], "");
        paramString4.l = paramString1.optString(z[30], "");
        paramString4.m = paramString2;
        paramString4.n = paramString3;
        paramString4.d = paramString1.optString(z[39], "");
        return paramString4;
        bool = false;
        break;
      }
      paramString4 = paramContext;
    }
  }
  
  private static JSONObject a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      return paramString2;
    }
    catch (JSONException paramString2)
    {
      cn.jpush.android.c.f.d(z[2], z[25], paramString2);
      b.a(paramString1, 996, paramContext);
    }
    return null;
  }
  
  public static JSONObject a(Context paramContext, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (paramJSONObject == null)
    {
      cn.jpush.android.c.f.g(z[2], z[11]);
      b.a(paramString1, 996, paramContext);
    }
    for (;;)
    {
      return null;
      if (TextUtils.isEmpty(paramString2))
      {
        cn.jpush.android.c.f.g(z[2], z[13]);
        return null;
      }
      try
      {
        if (!paramJSONObject.isNull(paramString2))
        {
          paramJSONObject = paramJSONObject.getJSONObject(paramString2);
          return paramJSONObject;
        }
      }
      catch (JSONException paramJSONObject)
      {
        cn.jpush.android.c.f.d(z[2], z[12], paramJSONObject);
        b.a(paramString1, 996, paramContext);
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, a parama)
  {
    cn.jpush.android.c.f.a(z[2], z[5]);
    if (paramContext == null) {
      throw new IllegalArgumentException(z[3]);
    }
    int i = parama.b;
    JSONObject localJSONObject = parama.a;
    String str = parama.c;
    if ((i == 3) || (i == 4))
    {
      localJSONObject = a(paramContext, str, localJSONObject, z[7]);
      if (localJSONObject == null) {
        cn.jpush.android.c.f.g(z[2], z[9]);
      }
    }
    else
    {
      cn.jpush.android.c.f.c(z[2], z[1] + i);
      b.a(str, 996, paramContext);
      return;
    }
    int j = localJSONObject.optInt(z[8], -1);
    if (j == 0)
    {
      h localh = new h();
      localh.c = str;
      localh.b = i;
      localh.o = j;
      localh.h = parama.h;
      localh.e = parama.e;
      localh.f = parama.f;
      localh.m = parama.m;
      localh.d = parama.d;
      localh.g = parama.g;
      boolean bool = localh.a(paramContext, localJSONObject);
      cn.jpush.android.c.f.a(z[2], z[10]);
      if (bool)
      {
        localh.a(paramContext);
        cn.jpush.android.c.f.a(z[2], z[6]);
      }
    }
    else
    {
      cn.jpush.android.c.f.g(z[2], z[4] + j);
      b.a(str, 996, paramContext);
      return;
    }
    cn.jpush.android.c.f.g(z[2], z[0]);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    cn.jpush.android.c.f.a(z[2], z[20] + paramString);
    if (paramContext == null) {
      throw new IllegalArgumentException(z[3]);
    }
    if (TextUtils.isEmpty(paramString)) {
      cn.jpush.android.c.f.i(z[2], z[14]);
    }
    Object localObject1;
    int i;
    do
    {
      do
      {
        return;
        localObject2 = a(paramContext, z[16], paramString);
      } while (localObject2 == null);
      localObject1 = ((JSONObject)localObject2).optString(z[22], "");
      paramString = (String)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramString = ((JSONObject)localObject2).optString(z[18], "");
      }
      i = ((JSONObject)localObject2).optInt(z[19], -1);
      localObject1 = null;
      if (i == 2)
      {
        localObject1 = ((JSONObject)localObject2).optString(z[7], "").trim();
        if (a((String)localObject1))
        {
          cn.jpush.android.c.f.a(z[2], z[21] + (String)localObject1);
          if (paramContext == null) {
            throw new IllegalArgumentException(z[3]);
          }
          new g((String)localObject1, paramContext, paramString).start();
          return;
        }
        cn.jpush.android.c.f.c(z[2], z[17] + (String)localObject1);
        b.a(paramString, 996, paramContext);
        return;
      }
      if (i == 1) {
        localObject1 = a(paramContext, paramString, (JSONObject)localObject2, z[7]);
      }
    } while (localObject1 == null);
    int j = ((JSONObject)localObject1).optInt(z[8], -1);
    switch (j)
    {
    default: 
      cn.jpush.android.c.f.g(z[2], z[15] + j);
      b.a(paramString, 996, paramContext);
      return;
    }
    Object localObject2 = new h();
    boolean bool = ((c)localObject2).a(paramContext, (JSONObject)localObject1);
    cn.jpush.android.c.f.a(z[2], z[24]);
    ((c)localObject2).c = paramString;
    ((c)localObject2).b = i;
    ((c)localObject2).o = j;
    if (bool)
    {
      ((c)localObject2).a(paramContext);
      cn.jpush.android.c.f.a(z[2], z[23]);
      return;
    }
    cn.jpush.android.c.f.g(z[2], z[0]);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      paramString = paramString.trim();
      bool2 = paramString.matches(z[27]);
      bool1 = bool2;
    } while (bool2);
    cn.jpush.android.c.f.g(z[2], z[26] + paramString);
    return bool2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */