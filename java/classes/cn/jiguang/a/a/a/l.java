package cn.jiguang.a.a.a;

import android.net.wifi.ScanResult;
import cn.jiguang.c.a.a;
import cn.jiguang.d.d;
import cn.jiguang.f.h;
import org.json.JSONObject;

public final class l
  implements Comparable<l>
{
  private static final String[] z;
  public final String a;
  public final int b;
  public final String c;
  
  static
  {
    String[] arrayOfString = new String[10];
    int j = 0;
    Object localObject2 = "Hj\037\000Y";
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
        i = 109;
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
        localObject2 = "Hjh.\004\000w<";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "3#}4$\n,t&\017\0279r9PC";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "\027#|3\f\b\025h)\037\001$|)\005";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\023#}42\020%l8\037^";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\005-~";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\r>r0\b";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\0279r9";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "3#}4$\n,t\020\f\n+|8\037";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "\t+x\002\f\000.i8\036\027";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 100;
        continue;
        i = 74;
        continue;
        i = 27;
        continue;
        i = 93;
      }
    }
  }
  
  public l(k paramk, ScanResult paramScanResult)
  {
    this.a = paramScanResult.BSSID;
    this.b = paramScanResult.level;
    this.c = h.c(paramScanResult.SSID);
  }
  
  public l(k paramk, String paramString1, int paramInt, String paramString2)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = h.c(paramString2);
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      String str = this.a;
      localJSONObject.put(z[9], str);
      int i = this.b;
      localJSONObject.put(z[3], i);
      str = this.c;
      localJSONObject.put(z[7], str);
      localJSONObject.put(z[5], 0);
      localJSONObject.put(z[6], a.g());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      d.e(z[8], z[4], localException);
    }
    return localJSONObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof l)) {
        break;
      }
      paramObject = (l)paramObject;
    } while ((this.c != null) && (this.c.equals(((l)paramObject).c)) && (this.a != null) && (this.a.equals(((l)paramObject).a)));
    return false;
  }
  
  public final int hashCode()
  {
    return this.c.hashCode() ^ this.a.hashCode();
  }
  
  public final String toString()
  {
    return z[2] + this.a + '\'' + z[0] + this.b + z[1] + this.c + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */