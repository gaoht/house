package cn.jpush.android.d.a;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import cn.jpush.android.c.f;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  private static final String[] z;
  private HashMap<String, Method> a;
  private String b;
  private String c;
  
  static
  {
    String[] arrayOfString = new String[35];
    int j = 0;
    Object localObject2 = "\\\0307g\025\001\030/a\003UO?p\020\034]-2\022\032\0308wF\023Q(a\022UH;`\007\030].w\024Y\030-{\n\031\0308wF\005Y)a";
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
        i = 102;
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
        localObject2 = "*v";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "*h";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "*w";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "?K\031s\n\031r;d\007";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "*k";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\030].z\t\021\020";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "*z";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = ")\032";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "U[;~\nUR)}\bO\030";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "\033M6~";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "\016\0329}\002\020\032`2C\021\024z0\024\020K/~\022W\002z7\025\b";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "UJ?a\023\031L`";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "\001A*w\025";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "\026Y6~F\021Y.sF\020U*f\037";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "\030].z\t\021\030?j\003\026M.wF\020J(}\024O";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "\032Z0w\005\001";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "\033W.2\000\032M4vF\030].z\t\021\020";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "\\\030-{\022\035\030,s\n\034\\zb\007\007Y7w\022\020J)";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "\024J=a";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "\027W5~\003\024V";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "\030].z\t\021";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "\033M7p\003\007";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "\006L({\b\022";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "\023M4q\022\034W4:O\016N;`F\023\005\033`\024\024Atb\024\032L5f\037\005]ta\n\034[?<\005\024T6:\007\007_/\003\033L)>V\\\0033tN\023\0266w\b\022L2.W\\C.z\024\032Ox";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "UQ4{\022\034Y6{\034\024L3}\bUZ?u\017\033\032s)\020\024Jzs[\016I/w\023\020\002\001OJ\026Y6~\004\024[1(\000\000V9f\017\032Vr;\035\003Y(2\002Hy(`\007\f\026*`\t\001W.k\026\020\026)~\017\026]tq\007\031Trs\024\022M7w\b\001Kv\"ONN;`F\026\005><\025\035Q<fN\\\003,s\024U]gvH\006P3t\022]\021af\016\034Ktc\023\020M?I\005(\026;b\026\031Arf\016\034KvvONQ<:G\020\021!v\003\031].wF\001P3aH\004M?g\003.[\007o\033\b\003";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "\024\026a[";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "\037Y,s\025\026J3b\022O\020<g\b\026L3}\b]Zsi\005\032V)}\n\020\0266}\001]\032";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "X\025w?KX\025w?K";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        j = 29;
        localObject2 = "U[;~\nU](`\t\007\024zq\t\021]`0M\022\0269}\002\020\023x>F\030])a\007\022]`0M\022\026(w\025\000T.o\024\020L/`\bU_t`\003\006M6f\033Nw8x\003\026Ltu\003\001w-|6\007W*w\024\001A\024s\013\020KrsO[^5`#\024[2:\000\000V9f\017\032VrvO\016N;`F\026\005;I\002(\0033tN\001A*w\t\023\0309/[H\032<g\b\026L3}\bW\036|vGH\005xq\007\031T8s\005\036\032si\007.\\\007/\000\000V9f\017\032Vr;\035\007].g\024\033\0309<\007\005H6kN\024\024\001v;[[5|\005\024LrS\024\007Y#<\026\007W.}\022\fH?<\025\031Q9wH\026Y6~N\024J=g\013\020V.aJE\021s;\033\bEs)\004[";
        i = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i4] = localObject1;
        j = 30;
        localObject2 = "U[;~\nU](`\t\007\024z\003\006K;u\003OU3a\025UU?f\016\032\\z|\007\030]xo\020\024Jzw[.eat\t\007\020,s\024UPg#]\035\004<<\n\020V=f\016NPq9O\016N;`F\026\005<I\016(\003,s\024URgf\037\005]5tF\026\003?I\003[T?|\001\001P\007/\fNQ<:\fH\005xt\023\033[.{\t\033\032si\020\024Jzv[\024\026+g\003\000]t~\003\033_.z]\024\026+g\003\000]\001v;H[at=\035egv\033\bN;`F\022\005\020A);\026*s\024\006]rb\024\032U*fN?k\025\\H\006L({\b\022Q<kN\016U?f\016\032\\`tH\006P3t\022]\021vf\037\005])(\003YY(u\025O^';O\\\0033tN\022\0269}\002\020\031g VE\021!f\016\007W-0";
        i = 29;
        localObject1 = arrayOfString;
        break;
      case 29: 
        localObject3[i4] = localObject1;
        j = 31;
        localObject2 = "UQ4{\022\034Y6{\034\024L3}\bU]4vD\\Es:\021\034V>}\021\\\003";
        i = 30;
        localObject1 = arrayOfString;
        break;
      case 30: 
        localObject3[i4] = localObject1;
        j = 32;
        localObject2 = "\034V0w\005\001]>2\b\024U?2\005\024Vz|\t\001\0308wF\033M6~";
        i = 31;
        localObject1 = arrayOfString;
        break;
      case 31: 
        localObject3[i4] = localObject1;
        j = 33;
        localObject2 = "HYaq\t\033K5~\003[T5uNW";
        i = 32;
        localObject1 = arrayOfString;
        break;
      case 32: 
        localObject3[i4] = localObject1;
        j = 34;
        localObject2 = "\034V3fF\037Kzw\024\007W((";
        i = 33;
        localObject1 = arrayOfString;
        break;
      case 33: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 117;
        continue;
        i = 56;
        continue;
        i = 90;
        continue;
        i = 18;
      }
    }
  }
  
  public d(String paramString, Class paramClass)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new Exception(z[32]);
      }
    }
    catch (Exception paramString)
    {
      Log.e(z[4], z[34] + paramString.getMessage());
      return;
    }
    this.b = paramString;
    this.a = new HashMap();
    paramString = paramClass.getDeclaredMethods();
    paramClass = new StringBuilder(z[27]);
    paramClass.append(this.b);
    paramClass.append(z[25]);
    int j = paramString.length;
    for (;;)
    {
      if (i < j)
      {
        Method localMethod = paramString[i];
        if (localMethod.getModifiers() == 9)
        {
          String str = a(localMethod);
          if (str != null)
          {
            this.a.put(str, localMethod);
            paramClass.append(String.format(z[26], new Object[] { localMethod.getName() }));
          }
        }
      }
      else
      {
        paramClass.append(z[24]);
        paramClass.append(this.b);
        paramClass.append(z[30]);
        paramClass.append(this.b);
        paramClass.append(z[29]);
        paramClass.append(this.b);
        paramClass.append(z[33]);
        paramClass.append(this.b);
        paramClass.append(z[31]);
        this.c = paramClass.toString();
        f.c(z[4], z[28] + paramClass.toString());
        return;
      }
      i += 1;
    }
  }
  
  private String a(String paramString, int paramInt, Object paramObject)
  {
    String str = "";
    if (paramObject == null) {
      str = z[10];
    }
    for (;;)
    {
      paramObject = String.format(z[11], new Object[] { Integer.valueOf(paramInt), str });
      Log.d(z[4], this.b + z[9] + paramString + z[12] + (String)paramObject);
      return (String)paramObject;
      if ((paramObject instanceof String))
      {
        paramObject = ((String)paramObject).replace("\"", z[8]);
        str = "\"" + paramObject + "\"";
      }
      else if (((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Float)) || ((paramObject instanceof Double)) || ((paramObject instanceof JSONObject)))
      {
        str = String.valueOf(paramObject);
      }
    }
  }
  
  private static String a(Method paramMethod)
  {
    Object localObject = paramMethod.getName();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int j = arrayOfClass.length;
    if ((j <= 0) || (arrayOfClass[0] != WebView.class))
    {
      Log.w(z[4], z[6] + (String)localObject + z[0]);
      localObject = null;
    }
    int i;
    do
    {
      return (String)localObject;
      i = 1;
      paramMethod = (Method)localObject;
      localObject = paramMethod;
    } while (i >= j);
    localObject = arrayOfClass[i];
    if (localObject == String.class) {
      paramMethod = paramMethod + z[5];
    }
    for (;;)
    {
      i += 1;
      break;
      if ((localObject == Integer.TYPE) || (localObject == Long.TYPE) || (localObject == Float.TYPE) || (localObject == Double.TYPE)) {
        paramMethod = paramMethod + z[1];
      } else if (localObject == Boolean.TYPE) {
        paramMethod = paramMethod + z[7];
      } else if (localObject == JSONObject.class) {
        paramMethod = paramMethod + z[3];
      } else {
        paramMethod = paramMethod + z[2];
      }
    }
  }
  
  public final String a()
  {
    return this.c;
  }
  
  public final String a(WebView paramWebView, String paramString)
  {
    Object localObject1;
    Object[] arrayOfObject;
    int j;
    if (!TextUtils.isEmpty(paramString)) {
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject(paramString);
          localObject1 = ((JSONObject)localObject2).getString(z[21]);
          localJSONArray = ((JSONObject)localObject2).getJSONArray(z[13]);
          localObject2 = ((JSONObject)localObject2).getJSONArray(z[19]);
          int k = localJSONArray.length();
          arrayOfObject = new Object[k + 1];
          i = 0;
          arrayOfObject[0] = paramWebView;
          j = 0;
          paramWebView = (WebView)localObject1;
          if (j < k)
          {
            localObject1 = localJSONArray.optString(j);
            if (z[23].equals(localObject1))
            {
              localObject1 = paramWebView + z[5];
              if (((JSONArray)localObject2).isNull(j))
              {
                paramWebView = null;
                break label643;
              }
              paramWebView = ((JSONArray)localObject2).getString(j);
              break label643;
            }
            if (z[22].equals(localObject1))
            {
              paramWebView = paramWebView + z[1];
              i = i * 10 + j + 1;
              break label654;
            }
            if (z[20].equals(localObject1))
            {
              paramWebView = paramWebView + z[7];
              arrayOfObject[(j + 1)] = Boolean.valueOf(((JSONArray)localObject2).getBoolean(j));
              break label654;
            }
            if (z[16].equals(localObject1))
            {
              localObject1 = paramWebView + z[3];
              if (((JSONArray)localObject2).isNull(j))
              {
                paramWebView = null;
                break label663;
              }
              paramWebView = ((JSONArray)localObject2).getJSONObject(j);
              break label663;
            }
            paramWebView = paramWebView + z[2];
            break label654;
          }
          localObject1 = (Method)this.a.get(paramWebView);
          if (localObject1 == null) {
            return a(paramString, 500, z[17] + paramWebView + z[18]);
          }
          if (i <= 0) {
            continue;
          }
          paramWebView = ((Method)localObject1).getParameterTypes();
          if (i <= 0) {
            continue;
          }
          j = i - i / 10 * 10;
          localJSONArray = paramWebView[j];
          if (localJSONArray != Integer.TYPE) {
            continue;
          }
          arrayOfObject[j] = Integer.valueOf(((JSONArray)localObject2).getInt(j - 1));
        }
        catch (Exception paramWebView)
        {
          Object localObject2;
          JSONArray localJSONArray;
          int i;
          if (paramWebView.getCause() == null) {
            continue;
          }
          return a(paramString, 500, z[15] + paramWebView.getCause().getMessage());
          arrayOfObject[j] = Double.valueOf(((JSONArray)localObject2).getDouble(j - 1));
          continue;
          paramWebView = a(paramString, 200, ((Method)localObject1).invoke(null, arrayOfObject));
          return paramWebView;
          return a(paramString, 500, z[15] + paramWebView.getMessage());
        }
        i /= 10;
        continue;
        if (localJSONArray != Long.TYPE) {
          continue;
        }
        arrayOfObject[j] = Long.valueOf(Long.parseLong(((JSONArray)localObject2).getString(j - 1)));
      }
    }
    return a(paramString, 500, z[14]);
    label643:
    arrayOfObject[(j + 1)] = paramWebView;
    for (paramWebView = (WebView)localObject1;; paramWebView = (WebView)localObject1)
    {
      label654:
      j += 1;
      break;
      label663:
      arrayOfObject[(j + 1)] = paramWebView;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/d/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */