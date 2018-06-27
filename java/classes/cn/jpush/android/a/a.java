package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JResponse;
import cn.jpush.android.service.ServiceInterface;
import java.nio.ByteBuffer;

public class a
  implements JAction
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[49];
    int j = 0;
    Object localObject2 = "~?Ma;h\"\013%*s5\021d\"y\ne?x?\027%\005R\005*M\002^\0207B\004S\016,[\016S\024'T\033O\036;R";
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
        i = 75;
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
        localObject2 = "O4\000n\"k4\007+%rq\002h?t>\r+\"s%\006e?=3\021d*y2\002x?3q$b=xq\026{km#\fh.n\"\ne,3";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "^=\nh =?\f\"{8\000j?t>\r+*~%\nd%=&\n#=4\0339|kC";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "s> d%s4\000\"k8\027r";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "W\001\026x#Y0\027j\n~%\nd%";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "^>\re.~%\nd%=\"\027j?xq\000c*s6\006oki>C&k";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "~?Ma;h\"\013%*s5\021d\"y\ne?x?\027%\005R\005*M\002^\0207B\004S\016 G\002^\032<J\bI\030,E";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "m0\000`*z4Y";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "~?Ma;h\"\013%*s5\021d\"y\ne?x?\027%\005R\005*M\002^\0207B\004S\0161N\bX\0305N\017B\0011D\023D";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "3!\006y&t\"\020b$s)[\036N\031<F\016N\002\"L\016";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "|?\007y$t5Me.i\000d%s D\005S\024 _\002K\0307R\024^\031\"E\fX";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "m$\020cku0\020+8i>\023n/";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "r%\013n9=?\006<r#\b+8i0\027nk0q";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "|!\023B/";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "s>\027b-t2\002b$s\016\027r;x";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "r?1n(x8\025nk0q";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "s4\027|$o:*e-r";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "Z4\027+<o>\rlky0\027jkn%\021b%zq\005y$pq\ne?x?\0271k";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "Z>\027+*sq\006f;i(Ce$i8\005b(|%\nd%1q\007d%:%Cx#r&Cb?<";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "p4\020x*z4";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "I#\002e8{>\021fks>\027b-t2\002\"r?Ch$s%\006e?=%\f+\t|\"\nh\016s%\n2=7\002b'x5B";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "^=\nh =?\f\"{8\000j?t>\r+8x?\007I9r0\007h*n%C1";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "S>Cj%dq\rn?j>\021`kt\"Ch$s?\006h?x5";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "p\"\004T\"y";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "S4\027|$o:Cb8=5\nx(r?\rn(i4\007%";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "u0\ro'x\034\006x8|6\006+>s:\rd<sq\fi!x2\027+";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "'q$n?=?\f+/|%\002+-o>\016+\"s%\006e?3";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "~?Ma;h\"\013%*s5\021d\"y-D\037T\027*J\b\\\005*D\005B\020 _\002R\037<N\023I\003\"";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "S4\027|$o:Cb8=2\fe%x2\027n/3";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        j = 29;
        localObject2 = "~?Ma;h\"\013%*s5\021d\"y\ne?x?\027%\005R\005*M\002^\0207B\004S\016 G\002^\032<J\bI\030,E\024M\003,S\022";
        i = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i4] = localObject1;
        j = 30;
        localObject2 = "S>\027+-r$\roks4\027|$o:*e-r";
        i = 29;
        localObject1 = arrayOfString;
        break;
      case 29: 
        localObject3[i4] = localObject1;
        j = 31;
        localObject2 = "\\\0227B\004S\016-D\037T\027*H\nI\030,E\024O\024 N\002K\024'T\033O\036;Rk=q\rd?t7\nh*i8\fe\024i(\023nk q";
        i = 30;
        localObject1 = arrayOfString;
        break;
      case 30: 
        localObject3[i4] = localObject1;
        j = 32;
        localObject2 = "M$\020c\031x2\006b=x# d9x";
        i = 31;
        localObject1 = arrayOfString;
        break;
      case 31: 
        localObject3[i4] = localObject1;
        j = 33;
        localObject2 = "|?\007y$t5Mb%i4\re|2\027b$s3J\bV\020$N\024\\\025'N\017";
        i = 32;
        localObject1 = arrayOfString;
        break;
      case 32: 
        localObject3[i4] = localObject1;
        j = 34;
        localObject2 = "3q'dks>\027c\"s6M";
        i = 33;
        localObject1 = arrayOfString;
        break;
      case 33: 
        localObject3[i4] = localObject1;
        j = 35;
        localObject2 = "P\0340+$oq0^\033Qq\rn?j>\021`kn%\002.=2\013j%z4O+?rq\007dks>\027c\"s6B";
        i = 34;
        localObject1 = arrayOfString;
        break;
      case 34: 
        localObject3[i4] = localObject1;
        j = 36;
        localObject2 = "n4\ro.o\030\007";
        i = 35;
        localObject1 = arrayOfString;
        break;
      case 35: 
        localObject3[i4] = localObject1;
        j = 37;
        localObject2 = "O4\000n\"k4\007+%h=\017+\"s%\006e?=3\021d*y2\002x?3q$b=xq\026{km#\fh.n\"\ne,3";
        i = 36;
        localObject1 = arrayOfString;
        break;
      case 36: 
        localObject3[i4] = localObject1;
        j = 38;
        localObject2 = "\\2\027b$sqN+$s\024\025n%iqO+!m$\020ckt?\nk{0\ng.y";
        i = 37;
        localObject1 = arrayOfString;
        break;
      case 37: 
        localObject3[i4] = localObject1;
        j = 39;
        localObject2 = "^>\r.s%5j'h4\020";
        i = 38;
        localObject1 = arrayOfString;
        break;
      case 38: 
        localObject3[i4] = localObject1;
        j = 40;
        localObject2 = "H?\013j%y=\006oko4\020{$s\"\006+(r<\016j%yqN+";
        i = 39;
        localObject1 = arrayOfString;
        break;
      case 39: 
        localObject3[i4] = localObject1;
        j = 41;
        localObject2 = "N9\f~'yq\rd?=4\033b8iqN+\"z?\fy.=%\002lk|=\nj8=#\006x;r?\020ne";
        i = 40;
        localObject1 = arrayOfString;
        break;
      case 40: 
        localObject3[i4] = localObject1;
        j = 42;
        localObject2 = "W\001\026x#=&\002xkn%\f{.y";
        i = 41;
        localObject1 = arrayOfString;
        break;
      case 41: 
        localObject3[i4] = localObject1;
        j = 43;
        localObject2 = "\\2\027b$sqN+$s\024\025n%iqO+\001M$\020ckt?\nk{0\ng.y";
        i = 42;
        localObject1 = arrayOfString;
        break;
      case 42: 
        localObject3[i4] = localObject1;
        j = 44;
        localObject2 = "o4\020{$s\"\0061";
        i = 43;
        localObject1 = arrayOfString;
        break;
      case 43: 
        localObject3[i4] = localObject1;
        j = 45;
        localObject2 = "H?\be$j?Ch$p<\002e/=7\fykm0\021x\"s6Cb%>\026e/3";
        i = 44;
        localObject1 = arrayOfString;
        break;
      case 44: 
        localObject3[i4] = localObject1;
        j = 46;
        localObject2 = "\\2\027b$sqN+/t\"\023j?~9.n8n0\004n";
        i = 45;
        localObject1 = arrayOfString;
        break;
      case 45: 
        localObject3[i4] = localObject1;
        j = 47;
        localObject2 = ".S%z";
        i = 46;
        localObject1 = arrayOfString;
        break;
      case 46: 
        localObject3[i4] = localObject1;
        j = 48;
        localObject2 = "\\2\027b$sqN+$s\020\000\"r?1~%";
        i = 47;
        localObject1 = arrayOfString;
        break;
      case 47: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 29;
        continue;
        i = 81;
        continue;
        i = 99;
        continue;
        i = 11;
      }
    }
  }
  
  public long dispatchMessage(Context paramContext, long paramLong, int paramInt, Object paramObject, ByteBuffer paramByteBuffer)
  {
    cn.jpush.android.c.f.c(z[4], z[46]);
    if (!cn.jpush.android.d.a(paramContext))
    {
      cn.jpush.android.c.f.g(z[4], z[43]);
      return -1L;
    }
    switch (paramInt)
    {
    default: 
      cn.jpush.android.c.f.g(z[39], z[45]);
      paramObject = null;
    }
    while (ServiceInterface.c(paramContext))
    {
      cn.jpush.android.c.f.c(z[4], z[42]);
      if ((paramObject == null) || (!(paramObject instanceof cn.jpush.a.a)) || (((cn.jpush.a.a)paramObject).a() == 20)) {
        break;
      }
      return -1L;
      paramObject = new cn.jpush.a.c(paramObject, paramByteBuffer);
      continue;
      paramObject = new cn.jpush.a.a(paramObject, paramByteBuffer);
    }
    if (paramObject != null)
    {
      cn.jpush.android.c.f.d(z[4], z[44] + ((JResponse)paramObject).toString());
      switch (((JResponse)paramObject).getCommand())
      {
      default: 
        cn.jpush.android.c.f.g(z[4], z[40] + ((JResponse)paramObject).getCommand());
      }
    }
    for (;;)
    {
      return ((JResponse)paramObject).getRid().longValue();
      return h.a(cn.jpush.android.d.e, paramLong, (JResponse)paramObject);
      cn.jpush.android.c.f.g(z[4], z[41]);
    }
  }
  
  public void dispatchTimeOutMessage(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramInt == 10) {
      c.a(paramContext).a(paramLong2);
    }
  }
  
  public IBinder getBinderByType(String paramString)
  {
    if (cn.jpush.android.service.e.a == null) {
      cn.jpush.android.service.e.a = new e();
    }
    return cn.jpush.android.service.e.a;
  }
  
  public String getSdkVersion()
  {
    return z[47];
  }
  
  public void handleMessage(Context paramContext, long paramLong, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof Bundle)) {
        break label27;
      }
      cn.jpush.android.service.e.a(paramContext);
      cn.jpush.android.service.e.a((Bundle)paramObject);
    }
    for (;;)
    {
      return;
      label27:
      if (!(paramObject instanceof Intent)) {
        break label975;
      }
      cn.jpush.android.service.d.a();
      paramObject = (Intent)paramObject;
      if (paramObject == null)
      {
        cn.jpush.android.c.f.h(z[32], z[37]);
        return;
      }
      try
      {
        localObject1 = ((Intent)paramObject).getAction();
        cn.jpush.android.c.f.d(z[32], z[15] + (String)localObject1);
        if ((cn.jpush.android.d.a(paramContext.getApplicationContext())) && (localObject1 != null))
        {
          if (!((String)localObject1).startsWith(z[8])) {
            break label332;
          }
          if (ServiceInterface.d(paramContext))
          {
            cn.jpush.android.c.f.g(z[32], z[11]);
            return;
          }
        }
      }
      catch (NullPointerException paramContext)
      {
        cn.jpush.android.c.f.h(z[32], z[1]);
        return;
      }
    }
    int i = ((Intent)paramObject).getIntExtra(z[14], 0);
    cn.jpush.android.c.f.c(z[32], z[31] + i);
    Object localObject1 = ((Intent)paramObject).getStringExtra(z[19]);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      cn.jpush.android.c.f.h(z[32], z[18]);
      return;
    }
    Object localObject2 = ((Intent)paramObject).getStringExtra(z[36]);
    paramObject = f.a(paramContext, (String)localObject1, ((Intent)paramObject).getStringExtra(z[13]), (String)localObject2, ((Intent)paramObject).getStringExtra(z[23]));
    if (paramObject == null)
    {
      cn.jpush.android.c.f.g(z[32], z[20]);
      return;
    }
    ((cn.jpush.android.data.a)paramObject).h = true;
    f.a(paramContext, (cn.jpush.android.data.a)paramObject);
    return;
    label332:
    if (((String)localObject1).equals(z[33]))
    {
      paramObject = ((Intent)paramObject).getDataString();
      if (paramObject != null) {
        if ((((String)paramObject).trim().length() <= 8) || (!((String)paramObject).startsWith(z[7]))) {}
      }
    }
    for (paramObject = cn.jpush.android.data.b.a(paramContext, ((String)paramObject).substring(8));; paramObject = localObject1)
    {
      try
      {
        if (TextUtils.isEmpty((CharSequence)paramObject)) {
          break;
        }
        localObject2 = ((String)paramObject).split(",");
        if (localObject2.length <= 0) {
          break;
        }
        localObject1 = localObject2[0];
        b.a((String)localObject1, 1002, paramContext);
        paramObject = "";
        if (localObject2.length >= 3) {
          paramObject = localObject2[2];
        }
        cn.jpush.android.c.f.i(z[32], (String)paramObject);
        if (TextUtils.isEmpty((CharSequence)paramObject)) {
          continue;
        }
        cn.jpush.android.api.c.a(paramContext, (String)paramObject);
        return;
      }
      catch (Exception paramContext)
      {
        cn.jpush.android.c.f.i(z[32], paramContext.getMessage());
        return;
      }
      cn.jpush.android.c.f.h(z[32], z[17] + (String)paramObject);
      return;
      cn.jpush.android.c.f.h(z[32], (String)localObject1 + z[26]);
      return;
      if (((String)localObject1).equalsIgnoreCase(z[10]))
      {
        paramContext = (NetworkInfo)((Intent)paramObject).getParcelableExtra(z[16]);
        if (paramContext == null)
        {
          cn.jpush.android.c.f.g(z[32], z[30]);
          return;
        }
        cn.jpush.android.c.f.c(z[32], z[5] + paramContext.toString());
        if ((2 == paramContext.getType()) || (3 == paramContext.getType()))
        {
          cn.jpush.android.c.f.c(z[32], z[35]);
          return;
        }
        if (((Intent)paramObject).getBooleanExtra(z[3], false))
        {
          cn.jpush.android.c.f.c(z[32], z[22]);
          return;
        }
        if (NetworkInfo.State.CONNECTED == paramContext.getState())
        {
          cn.jpush.android.c.f.c(z[32], z[28]);
          return;
        }
        if (NetworkInfo.State.DISCONNECTED == paramContext.getState())
        {
          cn.jpush.android.c.f.c(z[32], z[24]);
          return;
        }
        cn.jpush.android.c.f.c(z[32], z[12] + paramContext.getState() + z[34]);
        return;
      }
      if (((String)localObject1).startsWith(z[0]))
      {
        cn.jpush.android.service.d.a(paramContext, (Intent)paramObject);
        return;
      }
      if (!((String)localObject1).startsWith(z[29])) {
        break;
      }
      cn.jpush.android.c.f.e(z[32], z[2] + ((Intent)paramObject).getExtras().getString(z[27]));
      try
      {
        localObject1 = new Intent(z[6]);
        ((Intent)localObject1).putExtras(((Intent)paramObject).getExtras());
        ((Intent)localObject1).addCategory(paramContext.getPackageName());
        paramContext.sendBroadcast((Intent)localObject1, paramContext.getPackageName() + z[9]);
        return;
      }
      catch (Throwable paramContext)
      {
        cn.jpush.android.c.f.h(z[32], z[21] + paramContext.getMessage());
        return;
      }
      label975:
      cn.jpush.android.c.f.d(z[4], z[25]);
      return;
    }
  }
  
  public boolean isSupportedCMD(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 10);
  }
  
  public void onActionRun(Context paramContext, long paramLong, Bundle paramBundle, Object paramObject)
  {
    cn.jpush.android.c.f.d(z[4], z[48]);
    cn.jpush.android.service.e.a(paramContext).a(paramBundle, (Handler)paramObject);
  }
  
  public void onEvent(Context paramContext, long paramLong, int paramInt)
  {
    if (!cn.jpush.android.d.a(paramContext))
    {
      cn.jpush.android.c.f.g(z[4], z[38]);
      return;
    }
    switch (paramInt)
    {
    case 0: 
    case 1: 
    default: 
      return;
    }
    cn.jpush.android.service.e.a(paramContext).a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */