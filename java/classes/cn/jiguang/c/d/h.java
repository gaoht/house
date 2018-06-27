package cn.jiguang.c.d;

import android.content.Context;
import android.webkit.URLUtil;
import cn.jiguang.d.d;
import cn.jiguang.f.a;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public final class h
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[27];
    int j = 0;
    Object localObject2 = "R\006mV60";
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
        i = 85;
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
        localObject2 = "E3X\022m";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "X\023jO\035u\013nZ'";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "w\002pZ'q\023{\0377q\024w\\uq\022jW:b\016d^!y\bp\0373q\016rZ1";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "Y([G6u\027jV:~]zZ7e\000";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "Q\004}Z%d";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "@\025qK:s\brz-s\002nK<\t$";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "S\bpK0~\0233z;s\bzV;w";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "w\002pZ'q\023{\0377q\024w\\c$GJ!x\blV/q\023wP;0\023qT0~Gx^<|\002z\0232y\021{\037 `GvK!`GlZ%\025j";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "b\002nP'dG}P;d\002pKuy\024>Q |\013>P'0\002sO!iKyV#uGkOux\023jOub\002nP'd";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "HJ_O%=,{F";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "Q\022jW:b\016d^!y\bp";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "U\037}Z%d\016qQu=G";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "S\bpK0~\0233s0~\000jW";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "q\027nS<s\006jV:~Ht^&\t";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "S\017M&u\023";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "w\002pZ'q\023{\037'u\027qM!0\023qT0~Gx^<|\002z";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "$W/\0054e\023vP'y\035K<\t>Y4y\013{[{";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "c\023K cG}P1u]";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "w\035wO";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "c\002p[\031\000m\037=q\024>M0d\025g\0377e\023>Y4y\013{[";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "Q\004}Z%dJ[Q6\003wQ2";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "S\006j\\=0&mL0b\023wP;U\025lP'0\023q\0374f\bw[ux\023jOus\013qL00\004l^&xG3\037";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "D\017{\037'u\027qM!02lSuy\024>V;f\006rV1<GyV#uGkOud\017wLux\023jOub\002nP'd";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "D\017{\037'u\027qM!02lSuy\024>V;f\006rV1<GyV#uGkOud\017wLux\023jO&0\025{O:b\023";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "Q\004jV:~G3\0376x\002}T\000B+wL\003q\013w[0";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "e\025r\005";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 16;
        continue;
        i = 103;
        continue;
        i = 30;
        continue;
        i = 63;
      }
    }
  }
  
  private static int a(Context paramContext, String paramString, JSONObject paramJSONObject, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    if (paramInt <= 0)
    {
      d.d(z[2], z[20]);
      return -1;
    }
    HttpRequest localHttpRequest = new HttpRequest(paramString);
    localHttpRequest.setConnectTimeout(30000);
    localHttpRequest.setReadTimeout(30000);
    localHttpRequest.setDoOutPut(true);
    localHttpRequest.setDoInPut(true);
    localHttpRequest.setUseCaches(false);
    Object localObject1;
    if (paramJSONObject != null) {
      for (;;)
      {
        try
        {
          localObject1 = paramJSONObject.toString();
          if (cn.jiguang.f.h.a((String)localObject1))
          {
            d.c(z[2], z[9]);
            return -2;
          }
          localHttpRequest.setRequestProperty(z[5], z[14]);
          localHttpRequest.setRequestProperty(z[21], z[19]);
          localHttpRequest.setRequestProperty(z[7], z[19]);
          localHttpRequest.setRequestProperty(z[10], a.k(paramContext));
          if (localObject1 != null) {
            continue;
          }
          localObject2 = l.a();
          if (!cn.jiguang.f.h.a((String)localObject2)) {
            continue;
          }
          d.c(z[2], z[16]);
        }
        catch (ProtocolException paramContext)
        {
          d.i(z[2], z[6] + paramContext.getMessage());
          return -1;
          localHttpRequest.setRequestProperty(z[11], z[0] + (String)localObject2);
          localHttpRequest.setRequestProperty(z[15], z[1]);
          i = 1;
          continue;
          if (!paramBoolean) {
            continue;
          }
          localObject1 = ((String)localObject1).getBytes(z[1]);
          Object localObject2 = new ByteArrayOutputStream();
          localGZIPOutputStream = new GZIPOutputStream((OutputStream)localObject2);
          localGZIPOutputStream.write((byte[])localObject1);
          localGZIPOutputStream.close();
          localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
          ((ByteArrayOutputStream)localObject2).close();
          localHttpRequest.setBody(localObject1);
          localHttpRequest.setRequestProperty(z[13], String.valueOf(localObject1.length));
          localHttpRequest.setHaveRspData(false);
          i = HttpUtils.httpPost(paramContext, localHttpRequest).getResponseCode();
          d.d(z[2], z[18] + i);
          switch (i)
          {
          case 401: 
            if (i / 100 != 5) {
              continue;
            }
            return 500;
            localObject1 = ((String)localObject1).getBytes();
            continue;
            d.g(z[2], z[17]);
            return 401;
          case 3005: 
            paramInt = a(paramContext, paramString, paramJSONObject, paramBoolean, paramInt - 1);
            return paramInt;
            return -5;
          }
        }
        catch (IOException paramContext)
        {
          d.i(z[2], z[4] + paramContext.getMessage());
          return -1;
        }
        catch (AssertionError paramContext)
        {
          d.i(z[2], z[22] + paramContext.toString());
          return -1;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          d.i(z[2], z[12] + paramContext.getStackTrace().toString());
          d.i(z[2], z[12] + paramContext.toString());
          return -1;
        }
        if (i != 0) {
          continue;
        }
        d.c(z[2], z[8]);
        return -3;
        localObject2 = l.a((String)localObject1, 2);
        continue;
        localObject2 = l.d((String)localObject2);
        if (!cn.jiguang.f.h.a((String)localObject2)) {
          continue;
        }
        d.c(z[2], z[3]);
      }
    }
    for (;;)
    {
      GZIPOutputStream localGZIPOutputStream;
      localObject1 = "";
      break;
    }
    return 200;
    return 404;
    return 429;
  }
  
  public static int a(Context paramContext, JSONObject paramJSONObject, boolean paramBoolean)
  {
    int i = 0;
    String str = l.a(2);
    d.a(z[2], z[26] + str);
    d.a(z[2], z[25]);
    if (cn.jiguang.f.h.a(str)) {}
    while (i == 0)
    {
      return -1;
      if (l.b(str))
      {
        if (!URLUtil.isHttpUrl(str)) {
          d.i(z[2], z[23]);
        } else {
          i = 1;
        }
      }
      else if (!URLUtil.isHttpsUrl(str)) {
        d.i(z[2], z[24]);
      } else {
        i = 1;
      }
    }
    return a(paramContext, str, paramJSONObject, true, 2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */