package cn.jpush.android.data;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.a.b;
import cn.jpush.android.d;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public abstract class c
  implements Serializable
{
  private static final String[] H;
  public boolean A = false;
  public boolean B = false;
  public boolean C = false;
  public boolean D = false;
  public int E = -1;
  public ArrayList<String> F = null;
  public String G;
  private boolean a = false;
  public int b;
  public String c;
  public String d;
  public boolean e;
  public int f;
  public int g = 0;
  public boolean h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public int o;
  public boolean p;
  public List<String> q = null;
  public int r;
  public String s;
  public String t;
  public int u;
  public String v;
  public String w;
  public String x;
  public int y;
  public String z;
  
  static
  {
    String[] arrayOfString = new String[25];
    int i2 = 0;
    Object localObject2 = "\007re(-1c&?'tki*,tnk*/1'+k";
    int i1 = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int i3 = arrayOfChar.length;
    int i6 = 0;
    int i4 = 0;
    int i8 = i1;
    localObject2 = arrayOfChar;
    int i9 = i2;
    Object localObject3 = localObject1;
    int i5 = i3;
    Object localObject4;
    int i7;
    if (i3 <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i7 = i1;
      label68:
      i5 = i4;
      label71:
      localObject2 = localObject1;
      i6 = localObject2[i4];
      switch (i5 % 5)
      {
      default: 
        i1 = 72;
      }
    }
    for (;;)
    {
      localObject2[i4] = ((char)(i1 ^ i6));
      i5 += 1;
      if (i3 == 0)
      {
        i4 = i3;
        break label71;
      }
      i6 = i5;
      i5 = i3;
      localObject3 = localObject4;
      i9 = i2;
      localObject2 = localObject1;
      i8 = i7;
      i7 = i8;
      localObject1 = localObject2;
      i2 = i9;
      localObject4 = localObject3;
      i3 = i5;
      i4 = i6;
      if (i5 > i6) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i8)
      {
      default: 
        localObject3[i9] = localObject1;
        i2 = 1;
        localObject2 = "\021ir\"<-";
        i1 = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i9] = localObject1;
        i2 = 2;
        localObject2 = "<sr;r{(";
        i1 = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i9] = localObject1;
        i2 = 3;
        localObject2 = "\003uo?-ttr$:5`ck-&ui9dt'e9-5sck!9`&-!8b&-)=k(";
        i1 = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i9] = localObject1;
        i2 = 4;
        localObject2 = "5dr\"':=j$)0Or&$\035jg,-\006bu$=&dc8hy's9$\004uc-!,=";
        i1 = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i9] = localObject1;
        i2 = 5;
        localObject2 = ":Xu?18b";
        i1 = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i9] = localObject1;
        i2 = 6;
        localObject2 = ":Xe*<1`i91";
        i1 = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i9] = localObject1;
        i2 = 7;
        localObject2 = ":Xc3<&fu";
        i1 = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i9] = localObject1;
        i2 = 8;
        localObject2 = ":Xd\"/\013sc3<";
        i1 = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i9] = localObject1;
        i2 = 9;
        localObject2 = "\032hrk.;rh/h:hr\".=dg\"<;i&?! kck.;u&/-\"bj$81u&&'0b(k\035'b&? 1'g;88ne*<=hhk&5jce";
        i1 = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i9] = localObject1;
        i2 = 10;
        localObject2 = ":X`')3";
        i1 = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i9] = localObject1;
        i2 = 11;
        localObject2 = "5cY(':sc%<";
        i1 = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i9] = localObject1;
        i2 = 12;
        localObject2 = ":Xo%*;";
        i1 = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i9] = localObject1;
        i2 = 13;
        localObject2 = ":Xr\"<8b";
        i1 = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i9] = localObject1;
        i2 = 14;
        localObject2 = ":Xe$& bh?";
        i1 = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i9] = localObject1;
        i2 = 15;
        localObject2 = "5dr\"':=&;)&tcketeg8-tbh?! ~";
        i1 = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i9] = localObject1;
        i2 = 16;
        localObject2 = "\035ip*$=c&fh1jv?1tii?!2ne*<=hhk<=sj.h2htk!:sc9&5k";
        i1 = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i9] = localObject1;
        i2 = 17;
        localObject2 = ":Xv9!;uo?1";
        i1 = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i9] = localObject1;
        i2 = 18;
        localObject2 = ":Xd\"/\013wo(\027$fr#";
        i1 = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i9] = localObject1;
        i2 = 19;
        localObject2 = "2rj'\027'dt.-:";
        i1 = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i9] = localObject1;
        i2 = 20;
        localObject2 = "\026nak8=dr>:1'h$<=ao() ni%h&bu$=&dck85snqh";
        i1 = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i9] = localObject1;
        i2 = 21;
        localObject2 = "\000ock=&k&\";tf&;!7ss9-tuc8'!ue.;z";
        i1 = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i9] = localObject1;
        i2 = 22;
        localObject2 = "zwh,";
        i1 = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i9] = localObject1;
        i2 = 23;
        localObject2 = "\000ock=&k&\";tii?h5'v\"+ rt.h&bu$=&dc8f";
        i1 = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i9] = localObject1;
        i2 = 24;
        localObject2 = "zmv,";
        i1 = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i9] = localObject1;
        H = arrayOfString;
        return;
        i1 = 84;
        continue;
        i1 = 7;
        continue;
        i1 = 6;
        continue;
        i1 = 75;
      }
    }
  }
  
  static String a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1.endsWith(H[24])) || (paramString1.endsWith(H[22])))
    {
      cn.jpush.android.c.f.e(H[1], H[21]);
      String str = paramString2 + paramString1.substring(paramString1.lastIndexOf("."));
      paramContext = cn.jpush.android.c.c.b(paramContext, paramString2) + str;
      cn.jpush.android.c.f.e(H[1], H[20] + paramContext);
      paramString1 = cn.jpush.android.b.a.a(paramString1, 5, 5000L, 4);
      if (paramString1 != null) {
        try
        {
          cn.jpush.android.c.c.a(paramContext, paramString1);
          return paramContext;
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
          return "";
        }
      }
      return "";
    }
    cn.jpush.android.c.f.e(H[1], H[23]);
    return "";
  }
  
  static boolean a(ArrayList<String> paramArrayList, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool2 = true;
    cn.jpush.android.c.f.a(H[1], H[4] + paramString1);
    boolean bool1 = bool2;
    if (cn.jpush.android.a.f.a(paramString1))
    {
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramArrayList.size() > 0)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString2))
          {
            Iterator localIterator = paramArrayList.iterator();
            bool1 = true;
            if (localIterator.hasNext())
            {
              paramArrayList = (String)localIterator.next();
              if ((paramArrayList == null) || (paramArrayList.startsWith(H[2]))) {
                break label312;
              }
            }
          }
        }
      }
    }
    label262:
    label312:
    for (Object localObject = paramString1 + paramArrayList;; localObject = paramArrayList)
    {
      byte[] arrayOfByte = cn.jpush.android.b.a.a((String)localObject, 5, 5000L, 4);
      if (arrayOfByte != null)
      {
        localObject = paramArrayList;
        for (;;)
        {
          try
          {
            if (paramArrayList.startsWith(H[2])) {
              localObject = cn.jpush.android.c.c.a(paramArrayList);
            }
            if (paramBoolean) {
              break label262;
            }
            paramArrayList = cn.jpush.android.c.c.a(paramContext, paramString2) + (String)localObject;
            cn.jpush.android.c.c.a(paramArrayList, arrayOfByte);
            cn.jpush.android.c.f.a(H[1], H[0] + paramArrayList);
          }
          catch (Exception paramArrayList)
          {
            cn.jpush.android.c.f.c(H[1], H[3], paramArrayList);
            bool1 = false;
          }
          break;
          paramArrayList = cn.jpush.android.c.c.b(paramContext, paramString2) + (String)localObject;
        }
      }
      b.a(paramString2, 1020, cn.jpush.android.c.a.a(paramContext, (String)localObject), paramContext);
      bool1 = false;
      break;
      return bool1;
    }
  }
  
  public abstract void a(Context paramContext);
  
  public final boolean a()
  {
    return this.a;
  }
  
  public final boolean a(Context paramContext, JSONObject paramJSONObject)
  {
    cn.jpush.android.c.f.a(H[1], H[15]);
    boolean bool;
    if (paramJSONObject.optInt(H[19], 0) > 0)
    {
      bool = true;
      this.p = bool;
      this.r = paramJSONObject.optInt(H[10], 0);
      this.s = paramJSONObject.optString(H[13], "");
      this.t = paramJSONObject.optString(H[14], "");
      this.u = paramJSONObject.optInt(H[5], 0);
      this.v = paramJSONObject.optString(H[8], "");
      this.w = paramJSONObject.optString(H[18], "");
      this.x = paramJSONObject.optString(H[12], "");
      this.l = paramJSONObject.optString(H[7], "");
      this.y = paramJSONObject.optInt(H[17], 0);
      this.z = paramJSONObject.optString(H[6], "");
      if (!TextUtils.isEmpty(this.s)) {
        break label261;
      }
      if (this.h) {
        break label240;
      }
      cn.jpush.android.c.f.c(H[1], H[16]);
      b.a(this.c, 996, paramContext);
    }
    label240:
    label261:
    do
    {
      return false;
      bool = false;
      break;
      cn.jpush.android.c.f.c(H[1], H[9]);
      this.s = d.d;
      paramContext = cn.jpush.android.a.f.a(paramContext, this.c, paramJSONObject, H[11]);
      if (paramContext != null) {
        break label297;
      }
    } while ((!this.h) || (!this.e));
    return true;
    label297:
    if ((this.h) && (this.e)) {
      this.a = true;
    }
    return a(paramContext);
  }
  
  protected abstract boolean a(JSONObject paramJSONObject);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/data/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */