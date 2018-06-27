package cn.jpush.android.a;

import cn.jpush.android.c.f;
import java.util.HashMap;

public final class j
{
  private static final HashMap<Integer, String> a;
  private static final String[] z;
  
  static
  {
    Object localObject3 = new String[2];
    int m = 0;
    Object localObject2 = "\033\r\0277n9\r\\+d>\f\016-!-\f\030<!cC";
    int i = -1;
    Object localObject6;
    int j;
    int i1;
    int k;
    int i4;
    Object localObject4;
    int n;
    Object localObject5;
    int i2;
    for (Object localObject1 = localObject3;; localObject1 = localObject3)
    {
      localObject6 = ((String)localObject2).toCharArray();
      j = localObject6.length;
      i1 = 0;
      k = 0;
      int i3 = i;
      localObject2 = localObject6;
      i4 = m;
      localObject4 = localObject1;
      n = j;
      if (j <= 1)
      {
        localObject5 = localObject1;
        localObject1 = localObject6;
        i2 = i;
      }
      label142:
      do
      {
        n = k;
        for (;;)
        {
          localObject2 = localObject1;
          i1 = localObject2[k];
          switch (n % 5)
          {
          default: 
            i = 1;
            localObject2[k] = ((char)(i ^ i1));
            n += 1;
            if (j != 0) {
              break label142;
            }
            k = j;
          }
        }
        i1 = n;
        n = j;
        localObject4 = localObject5;
        i4 = m;
        localObject2 = localObject1;
        i3 = i2;
        i2 = i3;
        localObject1 = localObject2;
        m = i4;
        localObject5 = localObject4;
        j = n;
        k = i1;
      } while (n > i1);
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject4[i4] = localObject1;
        m = 1;
        localObject2 = "\035\027\035-t= \023=d";
        i = 0;
      }
    }
    localObject4[i4] = localObject1;
    z = (String[])localObject3;
    localObject2 = new HashMap();
    a = (HashMap)localObject2;
    localObject1 = Integer.valueOf(995);
    localObject3 = "\003\006\017*`)\006\\\023R\001-\\)`<\020\0257fn\020\t:b+\006\030";
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
      label341:
      label456:
      do
      {
        m = k;
        localObject3 = localObject1;
        n = localObject3[k];
        switch (m % 5)
        {
        default: 
          i = 1;
        }
        for (;;)
        {
          localObject3[k] = ((char)(i ^ n));
          m += 1;
          if (j != 0) {
            break label456;
          }
          k = j;
          break label341;
          i = 78;
          break;
          i = 99;
          break;
          i = 124;
          break;
          i = 89;
          break;
          i = 78;
          continue;
          i = 99;
          continue;
          i = 124;
          continue;
          i = 89;
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
        localObject1 = Integer.valueOf(996);
        localObject3 = "\003\006\017*`)\006\\\023R\001-\\)`<\020\0257fn\005\0350m+\007";
        i = 0;
        break;
      case 0: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(997);
        localObject3 = "\003\006\017*`)\006\\8m<\006\035=xn\021\031:d'\025\031=-n\004\025/dn\026\f";
        i = 1;
        break;
      case 1: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(998);
        localObject3 = "\003\006\017*`)\006\\8m<\006\035=xn\021\031:d'\025\031=-n\020\b0m\"C\f+n-\006\017*";
        i = 2;
        break;
      case 2: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1000);
        localObject3 = "\033\020\031+!-\017\025:j+\007\\8o*C\023)d \006\030yu&\006\\\024d=\020\035>d";
        i = 3;
        break;
      case 3: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1001);
        localObject3 = "\003\006\017*`)\006\\=n9\r\0206`*C\017,b-\006\031=";
        i = 4;
        break;
      case 4: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1002);
        localObject3 = "\003\006\017*`)\006\\+d-\006\025/d*C\017,b-\006\031=";
        i = 5;
        break;
      case 5: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1003);
        localObject3 = "\003\006\017*`)\006\\*h\"\006\022:dn\007\023.o\"\f\035=!=\026\037:d+\007";
        i = 6;
        break;
      case 6: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1004);
        localObject3 = "\030\n\030<nn\020\0255d \000\031ye!\024\0225`!\007\\*t-\000\031<e";
        i = 7;
        break;
      case 7: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1005);
        localObject3 = "\033\020\031+!-\017\025:j+\007\\/h*\006\023y` \007\\3t#\023\031=!:\f\\,s\"C1<r=\002\033<!f\001\0166v=\006\016p";
        i = 8;
        break;
      case 8: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1008);
        localObject3 = "\030\n\030<nn\n\017yg!\021\037<!-\017\023*d*C\036 !;\020\031+";
        i = 9;
        break;
      case 9: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1007);
        localObject3 = "\033\020\031+!-\017\025:j+\007\\~N\005D";
        i = 10;
        break;
      case 10: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1006);
        localObject3 = "\033\020\031+!-\017\025:j+\007\\~B/\r\037<mi";
        i = 11;
        break;
      case 11: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1011);
        localObject3 = "\n\f\0137m!\002\030yg/\n\020<e";
        i = 12;
        break;
      case 12: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1012);
        localObject3 = "\033\020\031+!-\017\025:j+\007\\-nn\007\023.o\"\f\035=!/\004\0350o";
        i = 13;
        break;
      case 13: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1013);
        localObject3 = "\032\013\031yg'\017\031y`\"\021\0318e7C\031!h=\027\\8o*C\0178l+C\0170{+M\\\035n D\bye!\024\0225n/\007\\8f/\n\022w";
        i = 14;
        break;
      case 14: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1100);
        localObject3 = "\007\r\n8m'\007\\)`<\002\021yn<C\t7d6\023\031:u+\007\\+d=\026\020-/";
        i = 15;
        break;
      case 15: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1014);
        localObject3 = "\b\002\0255d*C\b6!>\021\0315n/\007\\+d?\026\025+d*C\016<r!\026\016:d";
        i = 16;
        break;
      case 16: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1015);
        localObject3 = "\033\020\031+!-\017\025:j+\007\\0o=\027\0355mn\002\020<s:C\0237!=\027\035-t=C\0368sn\002\032-d<C\0306v \017\0238e'\r\033yg'\r\025*i+\007R";
        i = 17;
        break;
      case 17: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1016);
        localObject3 = "\033\020\031+!-\017\025:j+\007\\-i+C\013<c8\n\031.&=C\t+m";
        i = 18;
        break;
      case 18: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1017);
        localObject3 = "\033\020\031+!-\017\025:j+\007\\:`\"\017\\8b:\n\0237";
        i = 19;
        break;
      case 19: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1018);
        localObject3 = "\032\013\031yL+\020\0178f+C\0171n9C\0257!:\013\031yr:\002\b,rn\001\035+";
        i = 20;
        break;
      case 20: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1019);
        localObject3 = "\r\017\025:jn\002\f)m'\020\by` \007\\*i!\024\\-i+C1<r=\002\033<";
        i = 21;
        break;
      case 21: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1020);
        localObject3 = "\n\f\0137!'\016\035>dn\005\0350m+\007";
        i = 22;
        break;
      case 22: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1021);
        localObject3 = "\n\f\0137!&\027\0215!(\002\0255d*";
        i = 23;
        break;
      case 23: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1022);
        localObject3 = "\n\f\0137!\003\006\017*`)\006\\?`'\017\031=";
        i = 24;
        break;
      case 24: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1030);
        localObject3 = "\n\n\017:`<\007\\-i+C\021<r=\002\033<!,\006\0378t=\006\\0un\n\017yo!\027\\0on\027\024<!>\026\0171!:\n\021<";
        i = 25;
        break;
      case 25: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1031);
        localObject3 = "\035\027\023)!>\026\0171!=\006\016/h-\006";
        i = 26;
        break;
      case 26: 
        ((HashMap)localObject5).put(localObject4, localObject1);
        localObject2 = a;
        localObject1 = Integer.valueOf(1032);
        localObject3 = "\034\006\017,l+C\f,r&C\017<s8\n\037<";
        i = 27;
      }
    }
    ((HashMap)localObject5).put(localObject4, localObject1);
  }
  
  public static String a(int paramInt)
  {
    if (!a.containsKey(Integer.valueOf(paramInt)))
    {
      f.c(z[1], z[0] + paramInt);
      return "";
    }
    return (String)a.get(Integer.valueOf(paramInt));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */