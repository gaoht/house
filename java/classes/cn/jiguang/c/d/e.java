package cn.jiguang.c.d;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import cn.jiguang.a.c.b;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JResponse;
import cn.jiguang.c.e.a.a.c;
import java.nio.ByteBuffer;

public class e
  implements JAction
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[15];
    int j = 0;
    Object localObject2 = "fx/`pi";
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
        i = 31;
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
        localObject2 = "T~)vd~{kji7l?*;";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "'k0n%";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "duucorh3'~i)fvc52gkbu/'MBK\024[K";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "hu\t|qFx/`pi;9|qcw>)vt;5|sk";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "en5msb!";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "u~+fms";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "FI.g^do2fq";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "u~+fms5>qkuzu`qat";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "65j'/";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "t~5mKhO3`mc;)llwt5zz'x4drfu?)2'";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "U~8lvq~?)zui4{?u~(ypih>)2'x4mz=";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "Fx/`pi;v)mbx>`ib\030frjz5m?ru>q|bk/l{'6{{ztk4glb;,hl'u.es";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "Fx/`pi;v)wfu?[ztk4glb;{{ztk4glb!";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "MX4{zFx/`pi";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 7;
        continue;
        i = 27;
        continue;
        i = 91;
        continue;
        i = 9;
      }
    }
  }
  
  public long dispatchMessage(Context paramContext, long paramLong, int paramInt, Object paramObject, ByteBuffer paramByteBuffer)
  {
    paramObject = cn.jiguang.c.e.a.a.a.a((c)paramObject, paramByteBuffer);
    if (paramObject == null) {
      cn.jiguang.d.d.g(z[14], z[12]);
    }
    for (;;)
    {
      return ((JResponse)paramObject).getHead().b().longValue();
      cn.jiguang.d.d.b(z[14], z[13] + ((JResponse)paramObject).toString());
      if (((JResponse)paramObject).code != 0) {
        cn.jiguang.d.d.h(z[14], z[11] + ((JResponse)paramObject).code);
      } else {
        switch (((JResponse)paramObject).getCommand())
        {
        default: 
          cn.jiguang.d.d.g(z[14], z[10] + ((JResponse)paramObject).getCommand());
          break;
        case 19: 
          cn.jiguang.c.b.e.a().a((JResponse)paramObject, paramLong);
          break;
        case 25: 
          cn.jiguang.a.c.a.a(paramContext, cn.jiguang.c.b.e.a().b(), paramLong, (JResponse)paramObject);
          break;
        case 26: 
          if (((JResponse)paramObject).code == 0) {
            d.a().a(paramContext, ((JResponse)paramObject).getRid().longValue());
          } else {
            d.a().a(paramContext, ((JResponse)paramObject).getRid().longValue(), ((JResponse)paramObject).code);
          }
          break;
        }
      }
    }
  }
  
  public void dispatchTimeOutMessage(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramInt == 26) {
      d.a().b(paramContext, paramLong2);
    }
  }
  
  public IBinder getBinderByType(String paramString)
  {
    return null;
  }
  
  public String getSdkVersion()
  {
    return z[9];
  }
  
  public void handleMessage(Context paramContext, long paramLong, Object paramObject) {}
  
  public boolean isSupportedCMD(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 19) || (paramInt == 25) || (paramInt == 26)) {
      bool = true;
    }
    return bool;
  }
  
  public void onActionRun(Context paramContext, long paramLong, Bundle paramBundle, Object paramObject)
  {
    b.a();
    cn.jiguang.d.d.d(z[7], z[2] + cn.jiguang.c.a.c);
    String str = z[7];
    if (z[5] + paramBundle != null) {}
    for (paramObject = paramBundle.toString();; paramObject = "")
    {
      cn.jiguang.d.d.d(str, (String)paramObject);
      if (paramBundle == null) {
        break;
      }
      cn.jiguang.d.d.a(z[7], z[1] + paramBundle.toString());
      paramObject = paramBundle.getString(z[0]);
      if (z[3].equals(paramObject))
      {
        paramObject = paramBundle.getString(z[6]);
        paramBundle = paramBundle.getString(z[8]);
        cn.jiguang.a.a.b.d.a();
        cn.jiguang.a.a.b.d.a(paramContext, (String)paramObject, paramBundle);
      }
      return;
    }
    cn.jiguang.d.d.c(z[7], z[4]);
  }
  
  public void onEvent(Context paramContext, long paramLong, int paramInt) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */