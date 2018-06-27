package cn.jiguang.a.a.a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import cn.jiguang.d.d;
import cn.jiguang.f.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k
{
  private static final String[] z;
  private WifiManager a;
  private Context b = null;
  
  static
  {
    String[] arrayOfString = new String[15];
    int j = 0;
    Object localObject2 = "YEa";
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
        i = 57;
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
        localObject2 = "YLo!\031ZM`;pCBirJLIcrNDPnrZBJh7ZY\004q;_Dmh4V";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "^Pt=WJAu&";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "LJb VD@(\"\\_Io!JDKh|xngC\001jrgI\023k~aY\036vneR\033vc";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "NQt \\CPQ;_D\036";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "ZM`;\003";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "NQt \\CPQ\033d\004o!\031CQj>";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "NKh<\\NP";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "ZM`;\031IQk\"";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "zM`;pCBi\037XCEa7K";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "XJc*IHGr7]\f";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "_Av=KY\004q;_D\004o<_B\036";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "ZM`;\031NKs<M\027";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "zM`;\031hVt=K";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "ZM`;";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 45;
        continue;
        i = 36;
        continue;
        i = 6;
        continue;
        i = 82;
      }
    }
  }
  
  public k(Context paramContext)
  {
    this.a = ((WifiManager)paramContext.getSystemService(z[14]));
    this.b = paramContext;
  }
  
  private List<l> a(JSONArray paramJSONArray)
  {
    d.a(z[9], z[8]);
    if (!a()) {
      return null;
    }
    Object localObject1 = this.a.getConnectionInfo();
    l locall;
    if (localObject1 != null)
    {
      locall = new l(this, ((WifiInfo)localObject1).getBSSID(), ((WifiInfo)localObject1).getRssi(), ((WifiInfo)localObject1).getSSID());
      d.a(z[9], z[4] + locall.toString());
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      if (locall != null)
      {
        localObject1 = locall.a();
        ((JSONObject)localObject1).put(z[0], z[7]);
        paramJSONArray.put(localObject1);
      }
      if (Build.VERSION.SDK_INT < 23) {
        localObject1 = this.a.getScanResults();
      }
      for (;;)
      {
        int i;
        Object localObject2;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          i = 65336;
          Iterator localIterator = ((List)localObject1).iterator();
          localObject1 = null;
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject2 = new l(this, (ScanResult)localIterator.next());
              d.a(z[9], z[5] + ((l)localObject2).toString());
              if (locall == null)
              {
                d.a(z[9], z[6]);
                continue;
                if ((this.b == null) || (!a.b(this.b, z[3]))) {
                  break label497;
                }
                localObject1 = this.a.getScanResults();
                break;
              }
              if (locall.equals(localObject2))
              {
                d.a(z[9], z[1]);
              }
              else
              {
                localArrayList.add(localObject2);
                if ((((l)localObject2).c.equals(locall.c)) || (((l)localObject2).b <= i)) {
                  break label494;
                }
                i = ((l)localObject2).b;
                localObject1 = localObject2;
              }
            }
          }
        }
        label494:
        for (;;)
        {
          break;
          Collections.sort(localArrayList);
          i = 10;
          if (localObject1 != null)
          {
            localObject2 = ((l)localObject1).a();
            ((JSONObject)localObject2).put(z[0], z[2]);
            paramJSONArray.put(localObject2);
            localArrayList.remove(localObject1);
            i = 9;
          }
          int j = i;
          if (locall != null)
          {
            localArrayList.remove(locall);
            j = i - 1;
          }
          if (localArrayList.size() > j)
          {
            localObject1 = localArrayList.subList(0, j);
            paramJSONArray = new ArrayList();
            paramJSONArray.addAll((Collection)localObject1);
          }
          for (;;)
          {
            return paramJSONArray;
            paramJSONArray = localArrayList;
          }
        }
        label497:
        localObject1 = null;
      }
      locall = null;
    }
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.a.isWifiEnabled();
      return bool;
    }
    catch (Exception localException)
    {
      d.e(z[9], z[13], localException);
    }
    return false;
  }
  
  public final JSONArray b()
  {
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      try
      {
        Object localObject = a(localJSONArray);
        if (localObject == null)
        {
          i = 0;
          d.a(z[9], z[12] + i);
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              localJSONArray.put(((l)((Iterator)localObject).next()).a());
              continue;
            }
          }
        }
        int i = localThrowable.size();
      }
      catch (Throwable localThrowable)
      {
        d.i(z[9], z[10] + localThrowable.getMessage());
        d.a(z[9], z[11] + localJSONArray.toString());
        return localJSONArray;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */