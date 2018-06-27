package cn.jiguang.f;

import android.text.TextUtils;
import cn.jiguang.c.a.a;
import cn.jiguang.d.d;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static final HashMap<Integer, String> a;
  private static long b = 0L;
  private static final String[] z;
  
  static
  {
    Object localObject2 = new String[9];
    int j = 0;
    Object localObject3 = ">\017Z~h";
    int i = -1;
    Object localObject1 = localObject2;
    Object localObject6;
    int k;
    int i1;
    int m;
    int i4;
    Object localObject4;
    int n;
    Object localObject5;
    int i2;
    for (;;)
    {
      localObject6 = ((String)localObject3).toCharArray();
      k = localObject6.length;
      i1 = 0;
      m = 0;
      int i3 = i;
      localObject3 = localObject6;
      i4 = j;
      localObject4 = localObject1;
      n = k;
      if (k <= 1)
      {
        localObject5 = localObject1;
        localObject1 = localObject6;
        i2 = i;
      }
      label143:
      do
      {
        n = m;
        for (;;)
        {
          localObject3 = localObject1;
          i1 = localObject3[m];
          switch (n % 5)
          {
          default: 
            i = 12;
            localObject3[m] = ((char)(i ^ i1));
            n += 1;
            if (k != 0) {
              break label143;
            }
            m = k;
          }
        }
        i1 = n;
        n = k;
        localObject4 = localObject5;
        i4 = j;
        localObject3 = localObject1;
        i3 = i2;
        i2 = i3;
        localObject1 = localObject3;
        j = i4;
        localObject5 = localObject4;
        k = n;
        m = i1;
      } while (n > i1);
      localObject1 = new String((char[])localObject3).intern();
      switch (i3)
      {
      default: 
        localObject4[i4] = localObject1;
        j = 1;
        localObject3 = "+\006Zr";
        i = 0;
        localObject1 = localObject2;
        break;
      case 0: 
        localObject4[i4] = localObject1;
        j = 2;
        localObject3 = "6\013Czi";
        i = 1;
        localObject1 = localObject2;
        break;
      case 1: 
        localObject4[i4] = localObject1;
        j = 3;
        localObject3 = ">\033N";
        i = 2;
        localObject1 = localObject2;
        break;
      case 2: 
        localObject4[i4] = localObject1;
        j = 4;
        localObject3 = ">\034^~c1";
        i = 3;
        localObject1 = localObject2;
        break;
      case 3: 
        localObject4[i4] = localObject1;
        j = 5;
        localObject3 = ">\017ZHm;\033uea)";
        i = 4;
        localObject1 = localObject2;
        break;
      case 4: 
        localObject4[i4] = localObject1;
        j = 6;
        localObject3 = "-\022\\";
        i = 5;
        localObject1 = localObject2;
        break;
      case 5: 
        localObject4[i4] = localObject1;
        j = 7;
        localObject3 = "\n\021Ayc(\021\nr~-\020X7o0\033O7!";
        i = 6;
        localObject1 = localObject2;
        break;
      case 6: 
        localObject4[i4] = localObject1;
        j = 8;
        localObject3 = "\f\013Kcy,<Esi";
        i = 7;
        localObject1 = localObject2;
      }
    }
    localObject4[i4] = localObject1;
    z = (String[])localObject2;
    localObject2 = new HashMap();
    a = (HashMap)localObject2;
    localObject1 = Integer.valueOf(0);
    localObject3 = "\0204";
    i = -1;
    for (;;)
    {
      char[] arrayOfChar = ((String)localObject3).toCharArray();
      j = arrayOfChar.length;
      n = 0;
      k = 0;
      i2 = i;
      localObject3 = arrayOfChar;
      localObject4 = localObject1;
      localObject5 = localObject2;
      m = j;
      if (j <= 1)
      {
        localObject6 = localObject1;
        localObject1 = arrayOfChar;
        i1 = i;
      }
      label526:
      label641:
      do
      {
        m = k;
        localObject3 = localObject1;
        n = localObject3[k];
        switch (m % 5)
        {
        default: 
          i = 12;
        }
        for (;;)
        {
          localObject3[k] = ((char)(i ^ n));
          m += 1;
          if (j != 0) {
            break label641;
          }
          k = j;
          break label526;
          i = 95;
          break;
          i = 127;
          break;
          i = 42;
          break;
          i = 23;
          break;
          i = 95;
          continue;
          i = 127;
          continue;
          i = 42;
          continue;
          i = 23;
        }
        n = m;
        m = j;
        localObject5 = localObject2;
        localObject4 = localObject6;
        localObject3 = localObject1;
        i2 = i1;
        i1 = i2;
        localObject1 = localObject3;
        localObject6 = localObject4;
        localObject2 = localObject5;
        j = m;
        k = n;
      } while (m > n);
      localObject1 = new String((char[])localObject3).intern();
      switch (i2)
      {
      default: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(64535);
        localObject3 = "\032\007Iri;_Hbj9\032X76\005O9,\017\023Ov:_Ixb+\036Ic,,\nZgc-\013\004";
        i = 0;
        break;
      case 0: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(64536);
        localObject3 = "\034\020Dyi<\013Cxb\031K~`:\033\0047\\3\032Kdi\034Bro4_Sxy-_Ixb1\032Ice0\021\nvb;_Xrx-\006\n{m+\032X6";
        i = 1;
        break;
      case 1: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(64538);
        localObject3 = "\f\032Dse1\030\nqm6\023Os,0\r\nce2\032Ebxq_z{i>\fO7^:\013Xn,3\036^r~~";
        i = 2;
        break;
      case 2: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(64539);
        localObject3 = "\r\032Ire)\026Dp,9\036C{i;_Ee,+\026Grc*\013\0047\\3\032Kdi-Oc~&_Fvx:\r\013";
        i = 3;
        break;
      case 3: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(64540);
        localObject3 = "\034\020Dyi<\013Cxb\026Y7o3\020Yrhq_z{i>\fO7^:\013Xn,3\036^r~~";
        i = 4;
        break;
      case 4: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(64542);
        localObject3 = "\r\032Ygc1\fO7x6\022Oxy+Q\nG`:\036Yr,\r\032^eu\023Kci-^";
        i = 5;
        break;
      case 5: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(64543);
        localObject3 = "\026\021\\v`6\033\ndc<\024Oc\"/Frm,\032\nEi+\rS7`>\013Oe-";
        i = 6;
        break;
      case 6: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(11);
        localObject3 = "\031\036C{i;_^x,-\032M~+\032X6";
        i = 7;
        break;
      case 7: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1005);
        localObject3 = "\006\020_e,>\017Z\\i&_Kyh\036Ds~0\026N7|>\034Avk:_Dva:_Kei\021Ec,2\036^td:\033\0047\\3\032Kdi\033Ebn3\032\ntd:\034A7x7\032G7m<\034Eeh6\021M7x0_kg|3\026Ivx6\020D7u0\n\nt~:\036^rh\020D7\\0\r^v`q";
        i = 8;
        break;
      case 8: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1006);
        localObject3 = "\006\020_7m1\033Xxe;_Zvo4\036Mr,1\036Gr,6\f\nyc+_Ooe,\013\0067\\3\032Kdi\rOpe,\013Oe,&\020_e,/\036Ivg8\032\nym2\032\n~b/Eex>\023\004";
        i = 9;
        break;
      case 9: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1007);
        localObject3 = "\026\021\\v`6\033\n^a:\026\0067^:\030Cdx:\r\nvk>\026D9";
        i = 10;
        break;
      case 10: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1009);
        localObject3 = "\006\020_e,>\017Z\\i&_Cd,-\032Fvx:\033\ncc\036\nyc1Rkyh-\020Cs,\036\017Z9\\3\032Kdi\nYr,&\020_e,\036\021Nec6\033\nV|/XY7m/\017arus_Ee,>\033N7m1_kyh-\020Cs,>\017Z7j0\r\ncd6\f\nv|/4On\"";
        i = 11;
        break;
      case 11: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(10000);
        localObject3 = "\r\032Ire)\032X7h>\013K7|>\rYr,:\rXx~";
        i = 12;
        break;
      case 12: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(102);
        localObject3 = "nO\0307!6Dtc-\rOtx\017Kd(\020Xs";
        i = 13;
        break;
      case 13: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(108);
        localObject3 = "nO\0227!6Dtc-\rOtx\nCs";
        i = 14;
      }
    }
    ((HashMap)localObject5).put(localObject4, localObject1);
  }
  
  public static String a(int paramInt)
  {
    if (!a.containsKey(Integer.valueOf(paramInt)))
    {
      d.c(z[8], z[7] + paramInt);
      return null;
    }
    return (String)a.get(Integer.valueOf(paramInt));
  }
  
  public static JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(z[4], z[3]);
      localJSONObject.put(z[0], paramString);
      localJSONObject.put(z[2], a.g());
      localJSONObject.put(z[1], z[5]);
      return localJSONObject;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  public static JSONObject b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(z[4], z[6]);
      localJSONObject.put(z[0], paramString);
      localJSONObject.put(z[2], a.g());
      localJSONObject.put(z[1], z[5]);
      return localJSONObject;
    }
    catch (JSONException paramString) {}
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */