package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jpush.android.api.b;
import cn.jpush.android.c.g;
import cn.jpush.android.c.j;
import cn.jpush.android.data.c;
import cn.jpush.android.service.ServiceInterface;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;
import org.json.JSONObject;

public final class h
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[30];
    int j = 0;
    Object localObject2 = "z\031\027-T\n\025\0269rE\026\021;_^X\003?XF\035\001";
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
        i = 49;
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
        localObject2 = "y\035\027(XI\035E7B\n\013\0211AO\034I~VC\016\000~DZX\0042]\n\f\r;\021G\035\026-PM\035";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "g\035\026-PM\035E\030XO\024\001-\021\007X\004.Ac\034_";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "G\013\002\nHZ\035Ec\021";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "o\025\025*H\n\025\0269\037\n?\f(T\n\r\025~AK\n\026;C\004";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "Z\r\0266\021C\013E=]E\013\000:］c\026\021;CI\035\025*\021^\020\000~\\O\013\026?VO";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "z\r\0266|O\013\026?VO(\0271RO\013\0261C";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\006X\b-Vc\034Ec\021";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "d7E-TD\034\000,xN";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "\006X\b-Vi\027\013*TD\f_";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "Z\n\n=TY\013'?BC\033 0EC\f\034~_E\f\f8XI\031\0217^D";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "Z\n\n=TY\013'?BC\033 0EC\f\034~DY\035\027sUO\036\f0TNX\b;BY\031\002;\037";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "Z\n\n=TY\013'?BC\033 0EC\f\034~ES\b\000d";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "\026\0160^]\026E;CX\027\027";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "~\021\b;\021^\027E.CE\033\000-B\n\n\000=TC\016\000:\021G\013\002p";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "K\033\0217^DB\027;RO\021\023;Uz\r\0266|O\013\026?VOX\b-Vc\034Ec\021";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "d7E?AZ1\001";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "\006X\026;_N\035\027\027U\020";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "\035\036\0008\007KO\001i\007IO]lS\033\036U;UKLQhS\030\033S=\005\032\031";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "d\027E3BM;\n0EO\026\021";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "o\025\025*H\n\013\0000UO\n\f:\021E\nE?AZ\021\001p\021m\021\023;\021_\bE.PX\013\000,\037";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "Z\031\027-Td\027\0273PFXH~\021G\013\002\027U\020";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "G\013\002\035^D\f\0000E\020Xo";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "Y\035\024+TD\033\000";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "K\033\0217^DXH~^D*\000=G~\031\002\037]C\031\026\035PF\024'?RA";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "^\031\002?]C\031\026\001BO\t\f:";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "I\026K4A_\013\rpPD\034\0271XNV\f0EO\026\021pek?:\037}c96\001rk4)\034pi3";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "I\027\001;";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "^\031\002?]C\031\026~\\Y\037&1_^\035\013*\013";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        j = 29;
        localObject2 = "^\031\002?]C\031\026\001TX\n\n,RE\034\000";
        i = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 42;
        continue;
        i = 120;
        continue;
        i = 101;
        continue;
        i = 94;
      }
    }
  }
  
  public static long a(Context paramContext, long paramLong, JResponse paramJResponse)
  {
    Object localObject1 = (cn.jpush.a.a)paramJResponse;
    int i = ((cn.jpush.a.a)localObject1).a();
    paramLong = ((cn.jpush.a.a)localObject1).b();
    long l1 = ((cn.jpush.a.a)localObject1).getRid().longValue();
    long l2 = JCoreInterface.getUid();
    i = (byte)i;
    int j = JCoreInterface.getSid();
    Object localObject2 = new OutputDataUtil(20480);
    ((OutputDataUtil)localObject2).writeU16(0);
    ((OutputDataUtil)localObject2).writeU8(1);
    ((OutputDataUtil)localObject2).writeU8(4);
    ((OutputDataUtil)localObject2).writeU64(l1);
    ((OutputDataUtil)localObject2).writeU32(j);
    ((OutputDataUtil)localObject2).writeU64(l2);
    ((OutputDataUtil)localObject2).writeU16(0);
    ((OutputDataUtil)localObject2).writeU8(i);
    ((OutputDataUtil)localObject2).writeU64(paramLong);
    ((OutputDataUtil)localObject2).writeU16At(((OutputDataUtil)localObject2).current(), 0);
    localObject2 = ((OutputDataUtil)localObject2).toByteArray();
    JCoreInterface.sendData(cn.jpush.android.d.e, cn.jpush.android.d.a, 4, (byte[])localObject2);
    paramLong = ((cn.jpush.a.a)localObject1).b();
    i = ((cn.jpush.a.a)localObject1).a();
    localObject1 = ((cn.jpush.a.a)localObject1).c();
    cn.jpush.android.c.f.c(z[6], z[3] + i + z[7] + paramLong);
    cn.jpush.android.c.f.a(z[6], z[22] + (String)localObject1);
    Object localObject3 = new LineNumberReader(new StringReader((String)localObject1));
    try
    {
      localObject2 = ((LineNumberReader)localObject3).readLine();
      if (localObject2 == null)
      {
        cn.jpush.android.c.f.i(z[6], z[16]);
        return -1L;
      }
      localObject3 = ((LineNumberReader)localObject3).readLine();
      if (localObject3 == null)
      {
        cn.jpush.android.c.f.i(z[6], z[8]);
        return -1L;
      }
      j = ((String)localObject2).length() + ((String)localObject3).length() + 2;
      if (((String)localObject1).length() > j + 1)
      {
        localObject1 = ((String)localObject1).substring(j);
        cn.jpush.android.c.f.a(z[6], z[2] + (String)localObject2 + z[17] + (String)localObject3 + z[9] + (String)localObject1);
      }
      switch (i)
      {
      default: 
        JCoreInterface.processCtrlReport(i);
      case 0: 
      case 2: 
        for (;;)
        {
          return paramJResponse.getRid().longValue();
          cn.jpush.android.c.f.c(z[6], z[19]);
          localObject1 = "";
          break;
          try
          {
            cn.jpush.android.c.f.c(z[6], z[21] + paramLong);
            localj = new j(z[6], z[14]);
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
              break label924;
            }
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label907;
            }
            cn.jpush.android.c.f.c(z[6], z[15] + paramLong);
            localObject1 = f.a(paramContext, (String)localObject1, (String)localObject2, (String)localObject3, paramLong);
            if (localObject1 == null) {
              localj.a();
            }
          }
          catch (Exception paramContext)
          {
            cn.jpush.android.c.f.d(z[6], z[13], paramContext);
          }
        }
      }
    }
    catch (IOException paramContext)
    {
      cn.jpush.android.c.f.d(z[6], z[0], paramContext);
      return -1L;
    }
    do
    {
      j localj;
      break;
    } while (g.a(paramContext, new cn.jpush.android.data.d((c)localObject1)));
    i = 0;
    if (((String)localObject3).equalsIgnoreCase(z[18])) {
      f.a(paramContext, (cn.jpush.android.data.a)localObject1);
    }
    for (;;)
    {
      new StringBuilder().append(paramLong);
      cn.jpush.android.c.f.c(z[6], z[12] + i);
      if ((i & 0x1) != 0)
      {
        cn.jpush.android.c.f.c(z[6], z[10]);
        if (ServiceInterface.d(paramContext))
        {
          cn.jpush.android.c.f.e(z[6], z[1]);
          break;
          if (!((cn.jpush.android.data.a)localObject1).e) {
            break label949;
          }
          i = 1;
          if (((cn.jpush.android.data.a)localObject1).b != 4) {
            continue;
          }
          i = 3;
          continue;
        }
        if (!cn.jpush.android.c.a.c(paramContext))
        {
          cn.jpush.android.c.f.e(z[6], z[5]);
          break;
        }
        ((cn.jpush.android.data.a)localObject1).h = true;
        f.a(paramContext, (cn.jpush.android.data.a)localObject1);
      }
      if ((i & 0x2) == 0) {
        break;
      }
      cn.jpush.android.c.f.c(z[6], z[11]);
      if ((TextUtils.isEmpty(((cn.jpush.android.data.a)localObject1).i)) && (TextUtils.isEmpty(((cn.jpush.android.data.a)localObject1).l))) {
        break;
      }
      cn.jpush.android.c.a.b(paramContext, (c)localObject1);
      break;
      label907:
      cn.jpush.android.c.f.i(z[6], z[4]);
      break;
      label924:
      cn.jpush.android.c.f.g(z[6], z[20]);
      break;
      return a(paramContext, (String)localObject1);
      label949:
      i = 2;
    }
  }
  
  private static long a(Context paramContext, String paramString)
  {
    cn.jpush.android.c.f.c(z[6], z[24]);
    try
    {
      Object localObject = new JSONObject(paramString);
      int i = ((JSONObject)localObject).optInt(z[27], b.i);
      long l = ((JSONObject)localObject).optLong(z[23]);
      localObject = new Intent();
      ((Intent)localObject).addCategory(cn.jpush.android.d.c);
      ((Intent)localObject).setAction(z[26]);
      ((Intent)localObject).putExtra(z[29], i);
      ((Intent)localObject).putExtra(z[25], l);
      paramContext.sendBroadcast((Intent)localObject);
      return l;
    }
    catch (Throwable paramContext)
    {
      cn.jpush.android.c.f.g(z[6], z[28] + paramString);
    }
    return -1L;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */