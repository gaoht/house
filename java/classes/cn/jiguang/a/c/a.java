package cn.jiguang.a.c;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import cn.jiguang.a.a.b.g;
import cn.jiguang.a.a.b.i;
import cn.jiguang.api.JResponse;
import cn.jiguang.api.MultiSpHelper;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jiguang.c.b.e;
import cn.jiguang.d.d;
import cn.jiguang.f.h;
import cn.jiguang.service.Protocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[66];
    int j = 0;
    Object localObject2 = "-\013\020z.(\013\035D9.\b\037~95;\025i?0\021\026u98";
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
        i = 90;
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
        localObject2 = "+\027\034u\031.\n\007~45^";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = " \007\007r5/D^;*3\013\020~)2(\034x;5\r\034u\031.\b\037~95";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "4\n\026c*$\007\007~>`D\033z)a\023\001t4&D\004r.)D9H\025\017!\013x?1\020\032t4";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\002\020\001w\027$\027\000z=$4\001t9$\027\000t(";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\"\013\035o?/\020";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "4\n\026c*$\007\007~>`";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "(\n\007~(7\005\037";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "\013%\035z68\020\032x)\002\013\036v5/'\034u<(\003\000";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "-\006\000;>(\027\022y6$\000]5t";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "-\006\000;?/\005\021w?%J]5";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "'\026\026j/$\n\020b";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "-\006\000D($\024\034i.\036\001\035z8-\001";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "3\001\003t(5;\037t9 \020\032t4\036\002\001~+4\001\035x#";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "-\006\000D($\024\034i.\036\n\034l";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "%\r\000z8-\001";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "/\006,n*-\013\022";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "KD\001~*.\026\007u/,\006\026i`";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "7\001\001h3.\nI";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = " \007\007r5/D^;/1\000\022o?\005\001\007x2\021\f\034u?\017\021\036y?3'\034u<(\003";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "\026-5R";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "a\024\001t,(\000\026i3/\000\026c`";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "4\024\037t;%\n\006v8$\026";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "a\021\001w`";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "4\026\037";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "/\021\036y?3;\022k*(\000";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = " \024\003D3%";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = ")\020\007k`nK";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "7\001\001h3.\n";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        j = 29;
        localObject2 = "\"\005\001i3$\026";
        i = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i4] = localObject1;
        j = 30;
        localObject2 = "/\021\036y?3;\006i6";
        i = 29;
        localObject1 = arrayOfString;
        break;
      case 29: 
        localObject3[i4] = localObject1;
        j = 31;
        localObject2 = "KD\022k*\b I";
        i = 30;
        localObject1 = arrayOfString;
        break;
      case 30: 
        localObject3[i4] = localObject1;
        j = 32;
        localObject2 = "/\021\036y?3;\022k*2\001\020i?5";
        i = 31;
        localObject1 = arrayOfString;
        break;
      case 31: 
        localObject3[i4] = localObject1;
        j = 33;
        localObject2 = "\"\005\001i3$\026I";
        i = 32;
        localObject1 = arrayOfString;
        break;
      case 32: 
        localObject3[i4] = localObject1;
        j = 34;
        localObject2 = "KD\022k*\022\001\020i?5^";
        i = 33;
        localObject1 = arrayOfString;
        break;
      case 33: 
        localObject3[i4] = localObject1;
        j = 35;
        localObject2 = " \024\003D)$\007\001~.";
        i = 34;
        localObject1 = arrayOfString;
        break;
      case 34: 
        localObject3[i4] = localObject1;
        j = 36;
        localObject2 = "\"\005\001i3$\026\000";
        i = 35;
        localObject1 = arrayOfString;
        break;
      case 35: 
        localObject3[i4] = localObject1;
        j = 37;
        localObject2 = "/\021\036y?3;\005~(2\r\034u";
        i = 36;
        localObject1 = arrayOfString;
        break;
      case 36: 
        localObject3[i4] = localObject1;
        j = 38;
        localObject2 = "'\005\032w?%D\007tz2\020\022i.a\023\032o2a\r\035o?/\020I";
        i = 37;
        localObject1 = arrayOfString;
        break;
      case 37: 
        localObject3[i4] = localObject1;
        j = 39;
        localObject2 = "2\020\022i.a\024\006h2a\027\026i,(\007\0265to";
        i = 38;
        localObject1 = arrayOfString;
        break;
      case 38: 
        localObject3[i4] = localObject1;
        j = 40;
        localObject2 = "5\035\003~";
        i = 39;
        localObject1 = arrayOfString;
        break;
      case 39: 
        localObject3[i4] = localObject1;
        j = 41;
        localObject2 = "mD\020t71\013\035~45*\022v?{D\035n6-";
        i = 40;
        localObject1 = arrayOfString;
        break;
      case 40: 
        localObject3[i4] = localObject1;
        j = 42;
        localObject2 = "#\r\035z3\001\036t.$D\000~(7\r\020~";
        i = 41;
        localObject1 = arrayOfString;
        break;
      case 41: 
        localObject3[i4] = localObject1;
        j = 43;
        localObject2 = "2\001\001m3\"\001=z7$";
        i = 42;
        localObject1 = arrayOfString;
        break;
      case 42: 
        localObject3[i4] = localObject1;
        j = 44;
        localObject2 = "\002\005\035;4.\020Sh. \026\007;\n4\027\033H?3\022\032x?a\000\006~z5\013SH?\"\021\001r.8!\013x?1\020\032t4o";
        i = 43;
        localObject1 = arrayOfString;
        break;
      case 43: 
        localObject3[i4] = localObject1;
        j = 45;
        localObject2 = "\024\n\026c*$\007\007~>{D\006u1/\013\004uz5\035\003~`";
        i = 44;
        localObject1 = arrayOfString;
        break;
      case 44: 
        localObject3[i4] = localObject1;
        j = 46;
        localObject2 = "mD\020t71\013\035~45*\022v?{";
        i = 45;
        localObject1 = arrayOfString;
        break;
      case 45: 
        localObject3[i4] = localObject1;
        j = 47;
        localObject2 = "1\017\024U;,\001";
        i = 46;
        localObject1 = arrayOfString;
        break;
      case 46: 
        localObject3[i4] = localObject1;
        j = 48;
        localObject2 = "2\021\020x?$\000So5a\027\007z(5D\004r.)D\032u.$\n\007!";
        i = 47;
        localObject1 = arrayOfString;
        break;
      case 47: 
        localObject3[i4] = localObject1;
        j = 49;
        localObject2 = " \007\007r5/D^;*3\013\020~)27\007z(50\033r(%7\026i,(\007\026";
        i = 48;
        localObject1 = arrayOfString;
        break;
      case 48: 
        localObject3[i4] = localObject1;
        j = 50;
        localObject2 = "2\020\022i.\025\035\003~`";
        i = 49;
        localObject1 = arrayOfString;
        break;
      case 49: 
        localObject3[i4] = localObject1;
        j = 51;
        localObject2 = ",\027\024X5/\020\026u.a\r\000;44\b\037";
        i = 50;
        localObject1 = arrayOfString;
        break;
      case 50: 
        localObject3[i4] = localObject1;
        j = 52;
        localObject2 = "3\001\003t(5'\007i6\023\001\020~37\001\027;wa\026\026o`";
        i = 51;
        localObject1 = arrayOfString;
        break;
      case 51: 
        localObject3[i4] = localObject1;
        j = 53;
        localObject2 = "\024\n\026c*$\007\007~>{D\006u1/\013\004uz1\021\000sz\"\020\001wz\"\t\027!z";
        i = 52;
        localObject1 = arrayOfString;
        break;
      case 52: 
        localObject3[i4] = localObject1;
        j = 54;
        localObject2 = "\007\005\032w?%D\007tz3\001\003t(5D\001~9$\r\005~>aIS";
        i = 53;
        localObject1 = arrayOfString;
        break;
      case 53: 
        localObject3[i4] = localObject1;
        j = 55;
        localObject2 = "\"\t\027";
        i = 54;
        localObject1 = arrayOfString;
        break;
      case 54: 
        localObject3[i4] = localObject1;
        j = 56;
        localObject2 = " \007\007r5/D^;* \026\000~\0315\026\037I?2\024\034u)$";
        i = 55;
        localObject1 = arrayOfString;
        break;
      case 55: 
        localObject3[i4] = localObject1;
        j = 57;
        localObject2 = "\"\020\001wzlD\020v>{";
        i = 56;
        localObject1 = arrayOfString;
        break;
      case 56: 
        localObject3[i4] = localObject1;
        j = 58;
        localObject2 = " \007\007r5/D^;*3\013\020~)2(\034x;5\r\034uva\t\000|\031.\n\007~45^";
        i = 57;
        localObject1 = arrayOfString;
        break;
      case 57: 
        localObject3[i4] = localObject1;
        j = 59;
        localObject2 = "3\001\003t(5'\007i6\023\001\020~37\001\027;..D\001~*.\026\007;($\007\026r,$\000S};(\b\026zlD";
        i = 58;
        localObject1 = arrayOfString;
        break;
      case 58: 
        localObject3[i4] = localObject1;
        j = 60;
        localObject2 = "\022\021\020x?$\000So5a\026\026k53\020Si?\"\001\032m?%D^;";
        i = 59;
        localObject1 = arrayOfString;
        break;
      case 59: 
        localObject3[i4] = localObject1;
        j = 61;
        localObject2 = "+\027\034u\025#\016\026x.{";
        i = 60;
        localObject1 = arrayOfString;
        break;
      case 60: 
        localObject3[i4] = localObject1;
        j = 62;
        localObject2 = "\024\n\026c*$\007\007~>{D\006u1/\013\004uz1\021\000sz,\027\024;.8\024\026;w";
        i = 61;
        localObject1 = arrayOfString;
        break;
      case 61: 
        localObject3[i4] = localObject1;
        j = 63;
        localObject2 = "1\026\034x?2\0270o(-6\026k53\0201b\031,\000S};(\b\026z#\001\020z/2\001SQ\031.\026\02657\000\024\003w3\"\005\007r5/'\034u.$\034\007;32D\035n6-";
        i = 62;
        localObject1 = arrayOfString;
        break;
      case 62: 
        localObject3[i4] = localObject1;
        j = 64;
        localObject2 = "1\026\034x?2\0270o(-6\026k53\020S~\"\"\001\003o3.\nI";
        i = 63;
        localObject1 = arrayOfString;
        break;
      case 63: 
        localObject3[i4] = localObject1;
        j = 65;
        localObject2 = " \007\007r5/D^;*3\013\020~)2(\034x;5\r\034u";
        i = 64;
        localObject1 = arrayOfString;
        break;
      case 64: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 65;
        continue;
        i = 100;
        continue;
        i = 115;
        continue;
        i = 27;
      }
    }
  }
  
  private static JSONObject a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        paramString = new JSONObject(cn.jiguang.c.a.a.getDecryptString(paramString, ""));
        d.a(z[4], z[61] + paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          paramString = null;
        }
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (cn.jiguang.c.a.e != null) {
          break label118;
        }
        d.h(z[4], z[63]);
        return;
      }
      catch (Exception localException)
      {
        d.h(z[4], z[64] + localException.getMessage());
        return;
      }
      d.c(z[4], z[62] + paramInt);
      return;
      c.b(cn.jiguang.c.a.e);
      return;
      i.a(cn.jiguang.c.a.e);
      return;
      Context localContext = cn.jiguang.c.a.e;
      a(e.a().b());
      return;
      c.c(cn.jiguang.c.a.e);
      return;
      label118:
      switch (paramInt)
      {
      }
    }
  }
  
  public static void a(Context paramContext, Handler paramHandler, long paramLong, JResponse paramJResponse)
  {
    d.a(z[4], z[56]);
    paramJResponse = (cn.jiguang.c.e.a.b)paramJResponse;
    long l1 = paramJResponse.a();
    long l2 = cn.jiguang.c.a.a.r();
    long l3 = cn.jiguang.c.a.a.i();
    int i = cn.jiguang.c.a.a.D();
    Object localObject = new OutputDataUtil(20480);
    ((OutputDataUtil)localObject).writeU16(0);
    ((OutputDataUtil)localObject).writeU8(0);
    ((OutputDataUtil)localObject).writeU8(25);
    ((OutputDataUtil)localObject).writeU64(l3);
    ((OutputDataUtil)localObject).writeU32(i);
    ((OutputDataUtil)localObject).writeU64(l2);
    ((OutputDataUtil)localObject).writeU16(0);
    ((OutputDataUtil)localObject).writeU64(l1);
    ((OutputDataUtil)localObject).writeU16At(((OutputDataUtil)localObject).current(), 0);
    localObject = cn.jiguang.c.e.a.a.b.a(((OutputDataUtil)localObject).toByteArray(), 1);
    if (localObject == null)
    {
      d.h(z[4], z[59] + l1);
      i = -1;
      if (i == 0)
      {
        paramJResponse = paramJResponse.b();
        d.c(z[4], z[58] + paramJResponse);
        if (!h.a(paramJResponse)) {
          break label343;
        }
        d.g(z[4], z[51]);
      }
    }
    else
    {
      i = Protocol.SendData(paramLong, (byte[])localObject, 25);
      d.a(z[4], z[52] + i);
      if (i != 0) {
        d.h(z[4], z[54] + l1);
      }
      for (;;)
      {
        i = 0;
        break;
        d.c(z[4], z[60] + l1);
      }
    }
    for (;;)
    {
      try
      {
        label343:
        paramJResponse = a(paramJResponse);
        i = paramJResponse.optInt(z[55]);
        d.c(z[4], z[57] + i);
        switch (i)
        {
        case 6: 
        case 21: 
        case 22: 
          d.g(z[4], z[53] + i);
          return;
        }
      }
      catch (Exception paramContext)
      {
        d.f(z[4], z[6], paramContext);
        return;
      }
      a(paramContext, paramHandler, paramJResponse);
      return;
      c.b(paramContext);
      return;
      c.c(paramContext);
      return;
      i.a(paramContext);
      return;
      a(paramContext, paramJResponse);
      return;
      b(paramContext, paramJResponse);
      return;
      c(paramContext, paramJResponse);
      return;
    }
  }
  
  private static void a(Context paramContext, Handler paramHandler, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject(z[5]);
        d.c(z[4], z[1] + paramJSONObject);
        if (paramJSONObject.optBoolean(z[15]))
        {
          d.d(z[4], z[9]);
          MultiSpHelper.commitBoolean(paramContext, z[12], false);
          return;
        }
        d.d(z[4], z[10]);
        MultiSpHelper.commitBoolean(paramContext, z[12], true);
        MultiSpHelper.commitBoolean(paramContext, z[14], true);
        l = paramJSONObject.optLong(z[11], 0L);
        if (l > 0L)
        {
          l *= 1000L;
          MultiSpHelper.commitLong(paramContext, z[13], l);
          a(paramHandler);
          return;
        }
      }
      catch (JSONException paramContext)
      {
        d.d(z[4], z[3], paramContext);
        return;
      }
      long l = cn.jiguang.a.b.a.a();
    }
  }
  
  private static void a(Context paramContext, JSONObject paramJSONObject)
  {
    d.c(z[4], z[2]);
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject(z[5]);
      d.c(z[4], z[1] + paramJSONObject);
      long l = paramJSONObject.optLong(z[7], 0L);
      if ((l > 0L) && (l <= cn.jiguang.a.b.a.a() / 1000L))
      {
        MultiSpHelper.commitLong(paramContext, z[0], l * 1000L);
        return;
      }
      d.g(z[8], z[6]);
      return;
    }
    catch (JSONException paramContext)
    {
      d.d(z[4], z[3], paramContext);
    }
  }
  
  private static void a(Handler paramHandler)
  {
    d.a(z[4], z[65]);
    Message.obtain(paramHandler, 1002).sendToTarget();
  }
  
  private static void b(Context paramContext, JSONObject paramJSONObject)
  {
    d.c(z[4], z[49]);
    for (;;)
    {
      try
      {
        localObject = paramJSONObject.getJSONObject(z[5]);
        d.c(z[4], z[1] + localObject);
        int i = ((JSONObject)localObject).optInt(z[40]);
        d.a(z[4], z[50] + i);
        switch (i)
        {
        case 1: 
          d.c(z[4], z[45] + i);
          return;
        }
      }
      catch (SecurityException paramContext)
      {
        Object localObject;
        String str;
        d.h(z[4], z[44]);
        paramContext.printStackTrace();
        return;
        d.d(z[4], z[48] + localObject + z[46] + paramContext);
        return;
      }
      catch (JSONException paramContext)
      {
        d.f(z[4], z[3], paramContext);
        return;
        d.c(z[4], z[42]);
        return;
      }
      catch (Throwable paramContext)
      {
        d.f(z[4], z[6], paramContext);
        return;
      }
      paramJSONObject = ((JSONObject)localObject).optString(z[47]);
      str = ((JSONObject)localObject).optString(z[43]);
      localObject = new Intent();
      ((Intent)localObject).setClassName(paramJSONObject, str);
      paramContext = paramContext.startService((Intent)localObject);
      if (paramContext == null)
      {
        d.h(z[4], z[38] + localObject + z[41]);
        return;
      }
      d.c(z[4], z[39]);
      return;
    }
  }
  
  private static void c(Context paramContext, JSONObject paramJSONObject)
  {
    d.c(z[4], z[19]);
    for (;;)
    {
      boolean bool;
      String str1;
      String str2;
      String str3;
      int i;
      int j;
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject(z[5]);
        d.c(z[4], z[1] + paramJSONObject);
        bool = paramJSONObject.optBoolean(z[22], false);
        str1 = paramJSONObject.optString(z[28], "");
        str2 = paramJSONObject.optString(z[26], "");
        str3 = paramJSONObject.optString(z[35], "");
        JSONArray localJSONArray = paramJSONObject.optJSONArray(z[36]);
        if (localJSONArray == null) {
          break label377;
        }
        i = 0;
        if (i >= localJSONArray.length()) {
          break label377;
        }
        paramJSONObject = localJSONArray.getJSONObject(i);
        if (paramJSONObject == null) {
          break label565;
        }
        str4 = paramJSONObject.optString(z[29], "");
        localObject = paramJSONObject.optString(z[24], "");
        if ((h.a(str4)) || (h.a((String)localObject))) {
          break label565;
        }
        j = g.a(str4);
        paramJSONObject = (JSONObject)localObject;
        if (!((String)localObject).startsWith(z[27])) {
          paramJSONObject = z[27] + (String)localObject;
        }
        localObject = paramJSONObject;
        if (paramJSONObject.endsWith("/")) {
          break label548;
        }
        localObject = paramJSONObject + "/";
      }
      catch (Exception paramContext)
      {
        String str4;
        Object localObject;
        d.f(z[4], z[6], paramContext);
        return;
      }
      d.a(z[4], z[33] + str4 + z[23] + (String)localObject + z[21] + j);
      break label565;
      cn.jiguang.c.a.a.a(paramContext, z[30] + j, (String)localObject);
      continue;
      label377:
      if (!h.a(str1)) {
        cn.jiguang.c.a.a.a(paramContext, z[37], str1);
      }
      if (h.a(str2)) {
        cn.jiguang.c.a.a.a(paramContext, z[25], str2);
      }
      if (h.a(str3)) {
        cn.jiguang.c.a.a.a(paramContext, z[32], str3);
      }
      d.c(z[4], z[18] + str1 + z[31] + str2 + z[34] + str3 + z[17] + bool);
      if (bool)
      {
        MultiSpHelper.commitBoolean(paramContext, z[16], true);
        if (!cn.jiguang.f.a.c(paramContext).toUpperCase().startsWith(z[20]))
        {
          g.a(paramContext);
          return;
          label548:
          if ((j != -1) && (j >= 0)) {
            if (j >= 3)
            {
              continue;
              label565:
              i += 1;
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */