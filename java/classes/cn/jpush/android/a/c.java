package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.JRequest;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jpush.android.c.f;
import cn.jpush.android.d;

public final class c
{
  private static c b;
  private static final String[] z;
  private Context a = null;
  
  static
  {
    String[] arrayOfString = new String[13];
    int j = 0;
    Object localObject2 = "\\/2]SJ";
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
        i = 55;
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
        localObject2 = "\"j0AR\003{aDV\002n,G\027]/\"YSJ";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = ":_4G_\"j0AR\003{\tQ[\000j3";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "%a1FX\023j2GR\024/3QF\005j2@\027\tj5\032";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\\}(P\r";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\\/5\\E\025n%}SJ";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "1l5]X\036/l\024D\025a%~g\005|)fR\001z$GC\\/5]Z\025`4@\r";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\\/+A^\0245";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "\004n&U[\031n2kD\025~(P";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "\023ao^G\005|)\032V\036k3[^\024!(ZC\025a5\032c1H\036u{9N\022kc9B\004{b$";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "1l5]X\036/l\024X\036[ SV\034f Gc\031b$[B\004";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "\004n&U[\031n2kR\002}.FT\037k$";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "\037a\025UP\021c(UD$f,QX\005{aQE\002`3\016";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        b = null;
        return;
        i = 112;
        continue;
        i = 15;
        continue;
        i = 65;
        continue;
        i = 52;
      }
    }
  }
  
  private c(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new c(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public final void a(long paramLong)
  {
    try
    {
      f.c(z[2], z[10]);
      Intent localIntent = new Intent();
      localIntent.addCategory(d.c);
      localIntent.setAction(z[9]);
      localIntent.putExtra(z[11], cn.jpush.android.api.b.b);
      localIntent.putExtra(z[8], paramLong);
      this.a.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      f.h(z[2], z[12] + localThrowable.getMessage());
    }
  }
  
  public final void a(JRequest paramJRequest, int paramInt)
  {
    f.d(z[2], z[6] + 20000 + z[5] + Thread.currentThread().getId());
    f.a(z[2], paramJRequest.toString());
    Object localObject = paramJRequest.getRid();
    paramInt = paramJRequest.getCommand();
    long l1 = JCoreInterface.getUid();
    int i = JCoreInterface.getSid();
    f.c(z[2], z[1] + paramInt + z[0] + i + z[7] + l1 + z[4] + localObject);
    switch (paramInt)
    {
    default: 
      f.g(z[2], z[3]);
      return;
    }
    long l2 = ((Long)localObject).longValue();
    localObject = JCoreInterface.getAppKey();
    paramJRequest = ((cn.jpush.a.b)paramJRequest).a();
    OutputDataUtil localOutputDataUtil = new OutputDataUtil(20480);
    localOutputDataUtil.writeU16(0);
    localOutputDataUtil.writeU8(4);
    localOutputDataUtil.writeU8(10);
    localOutputDataUtil.writeU64(l2);
    localOutputDataUtil.writeU32(i);
    localOutputDataUtil.writeU64(l1);
    localOutputDataUtil.writeByteArrayincludeLength(((String)localObject).getBytes());
    localOutputDataUtil.writeByteArrayincludeLength(paramJRequest.getBytes());
    localOutputDataUtil.writeU16At(localOutputDataUtil.current(), 0);
    paramJRequest = localOutputDataUtil.toByteArray();
    JCoreInterface.sendRequestData(this.a, d.a, 20000, paramJRequest);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */