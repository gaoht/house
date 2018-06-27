package cn.jiguang.c.d;

import android.content.Context;
import android.util.Base64;
import cn.jiguang.d.d;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l
{
  public static JSONObject a = null;
  private static final String b;
  private static String c;
  private static String d;
  private static String e;
  private static final String f;
  private static ExecutorService g;
  private static Object h = new Object();
  private static final String[] z;
  
  static
  {
    Object localObject2 = new String[65];
    int j = 0;
    Object localObject3 = "^!|\026\030Z# \001Q";
    int i = -1;
    Object localObject1 = localObject2;
    int i1;
    int m;
    int i4;
    Object localObject4;
    int n;
    for (;;)
    {
      char[] arrayOfChar = ((String)localObject3).toCharArray();
      k = arrayOfChar.length;
      i1 = 0;
      m = 0;
      int i3 = i;
      localObject3 = arrayOfChar;
      i4 = j;
      localObject4 = localObject1;
      n = k;
      Object localObject5;
      int i2;
      if (k <= 1)
      {
        localObject5 = localObject1;
        localObject1 = arrayOfChar;
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
            i = 110;
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
        localObject3 = "J8h";
        i = 0;
        localObject1 = localObject2;
        break;
      case 0: 
        localObject4[i4] = localObject1;
        j = 2;
        localObject3 = "R8:N\\9m'\000Z=,>\006Z?,>\034^!,*\001Q%m \000Z#, \000Y> +\033Kqo&\000K8b<\013\037#i9\001M%\"g@";
        i = 1;
        localObject1 = localObject2;
        break;
      case 1: 
        localObject4[i4] = localObject1;
        j = 3;
        localObject3 = "O=m=\bP#a";
        i = 2;
        localObject1 = localObject2;
        break;
      case 2: 
        localObject4[i4] = localObject1;
        j = 4;
        localObject3 = "\016=g^";
        i = 3;
        localObject1 = localObject2;
        break;
      case 3: 
        localObject4[i4] = localObject1;
        j = 5;
        localObject3 = "R8:N^!|\026\005Z(,>\006Z?,>\034^!,*\001Q%m \000Z#, \000Y>";
        i = 4;
        localObject1 = localObject2;
        break;
      case 4: 
        localObject4[i4] = localObject1;
        j = 6;
        localObject3 = "R8:NJ8hi\031W4bi\031M0|i\rP?x(\007Q4~i\007Q7c";
        i = 5;
        localObject1 = localObject2;
        break;
      case 5: 
        localObject4[i4] = localObject1;
        j = 7;
        localObject3 = "\\9m'\000Z=";
        i = 6;
        localObject1 = localObject2;
        break;
      case 6: 
        localObject4[i4] = localObject1;
        j = 8;
        localObject3 = "^!|\026\005Z(";
        i = 7;
        localObject1 = localObject2;
        break;
      case 7: 
        localObject4[i4] = localObject1;
        j = 9;
        localObject3 = "R8:N^!|i\030Z# \001Qq{!\013Qq{;\017Oqo&\000K0e'\013Mqe'\bP}n<\032\0372c'\032V?y,NM4|&\034K\"g";
        i = 8;
        localObject1 = localObject2;
        break;
      case 8: 
        localObject4[i4] = localObject1;
        j = 10;
        localObject3 = "\\>~,1L5g\026\030Z#";
        i = 9;
        localObject1 = localObject2;
        break;
      case 9: 
        localObject4[i4] = localObject1;
        j = 11;
        localObject3 = "U!y:\006`\"x(\032`2m*\006Z\016d \035K>~0@U\"c'";
        i = 10;
        localObject1 = localObject2;
        break;
      case 10: 
        localObject4[i4] = localObject1;
        j = 12;
        localObject3 = "\\>b=\013Q%";
        i = 11;
        localObject1 = localObject2;
        break;
      case 11: 
        localObject4[i4] = localObject1;
        j = 13;
        localObject3 = "J%jdV";
        i = 12;
        localObject1 = localObject2;
        break;
      case 12: 
        localObject4[i4] = localObject1;
        j = 14;
        localObject3 = "\037<e:\035\037$e-BX4b,\034^%ii\034Z!c;\032\037%c\"\013Qqj(\007S4h";
        i = 13;
        localObject1 = localObject2;
        break;
      case 13: 
        localObject4[i4] = localObject1;
        j = 15;
        localObject3 = "\0373c-\027\0378i\000J=`e\tZ?i;\017K4,;\013O>~=NK>g,\000\0377m \002Z5";
        i = 14;
        localObject1 = localObject2;
        break;
      case 14: 
        localObject4[i4] = localObject1;
        j = 16;
        localObject3 = "J?i1\036Z2x,\n\023q~,\036P#xi\007Oqe:NQ$`%";
        i = 15;
        localObject1 = localObject2;
        break;
      case 15: 
        localObject4[i4] = localObject1;
        j = 17;
        localObject3 = "W%x9T\020~";
        i = 16;
        localObject1 = localObject2;
        break;
      case 16: 
        localObject4[i4] = localObject1;
        j = 18;
        localObject3 = "L8i\034Z!c;\032\037$~%T";
        i = 17;
        localObject1 = localObject2;
        break;
      case 17: 
        localObject4[i4] = localObject1;
        j = 19;
        localObject3 = "\037!m;\032L";
        i = 18;
        localObject1 = localObject2;
        break;
      case 18: 
        localObject4[i4] = localObject1;
        j = 20;
        localObject3 = "S>ki\035V+is";
        i = 19;
        localObject1 = localObject2;
        break;
      case 19: 
        localObject4[i4] = localObject1;
        j = 21;
        localObject3 = "Y0e%\013[";
        i = 20;
        localObject1 = localObject2;
        break;
      case 20: 
        localObject4[i4] = localObject1;
        j = 22;
        localObject3 = "S>ki\nV'e-\013[qe'\032Pq";
        i = 21;
        localObject1 = localObject2;
        break;
      case 21: 
        localObject4[i4] = localObject1;
        j = 23;
        localObject3 = "L4b-NS>ki\035S8o,T";
        i = 22;
        localObject1 = localObject2;
        break;
      case 22: 
        localObject4[i4] = localObject1;
        j = 24;
        localObject3 = "O$xi\rP?x,\000Kqi1\rZ!x \001Q},.\007I4,<\036\037\"i'\n\037=c.T";
        i = 23;
        localObject1 = localObject2;
        break;
      case 23: 
        localObject4[i4] = localObject1;
        j = 25;
        localObject3 = "L$o*\013L\"";
        i = 24;
        localObject1 = localObject2;
        break;
      case 24: 
        localObject4[i4] = localObject1;
        j = 26;
        localObject3 = "\023#i9\001M%,";
        i = 25;
        localObject1 = localObject2;
        break;
      case 25: 
        localObject4[i4] = localObject1;
        j = 27;
        localObject3 = "H#m9N\\>b=\017V?i;NZ)o,\036K8c'B\0376e?\013\037$|i\035Z?hi\002P66";
        i = 26;
        localObject1 = localObject2;
        break;
      case 26: 
        localObject4[i4] = localObject1;
        j = 28;
        localObject3 = "]0 \r\0370y=\006P#e3\017K8c'NZ?o&\nZqj(\007S4h";
        i = 27;
        localObject1 = localObject2;
        break;
      case 27: 
        localObject4[i4] = localObject1;
        j = 29;
        localObject3 = "X4x\013\017L8o\b\033K9c;\007E0x \001Q";
        i = 28;
        localObject1 = localObject2;
        break;
      case 28: 
        localObject4[i4] = localObject1;
        j = 30;
        localObject3 = "\\0bn\032\0374b*\001[8b.N";
        i = 29;
        localObject1 = localObject2;
        break;
      case 29: 
        localObject4[i4] = localObject1;
        j = 31;
        localObject3 = "\\0bn\032\037&~ \032Zq";
        i = 30;
        localObject1 = localObject2;
        break;
      case 30: 
        localObject4[i4] = localObject1;
        j = 32;
        localObject3 = "j\005JdV";
        i = 31;
        localObject1 = localObject2;
        break;
      case 31: 
        localObject4[i4] = localObject1;
        j = 33;
        localObject3 = "L0z,NS>ki\007Qq{;\007K4D \035K>~0\"P6";
        i = 32;
        localObject1 = localObject2;
        break;
      case 32: 
        localObject4[i4] = localObject1;
        j = 34;
        localObject3 = "\\0bn\032\037>|,\000\037";
        i = 33;
        localObject1 = localObject2;
        break;
      case 33: 
        localObject4[i4] = localObject1;
        j = 35;
        localObject3 = "\\>b=\013G%, \035\037?y%\002\037},.\007I4,<\036\037\"m?\013\037";
        i = 34;
        localObject1 = localObject2;
        break;
      case 34: 
        localObject4[i4] = localObject1;
        j = 36;
        localObject3 = "Y8`,1Q0a,NV\",'\033S=,eNX8z,NJ!,:\017I4,";
        i = 35;
        localObject1 = localObject2;
        break;
      case 35: 
        localObject4[i4] = localObject1;
        j = 37;
        localObject3 = "bq i\tV'ii\033Oq(\030Zq6";
        i = 36;
        localObject1 = localObject2;
        break;
      case 36: 
        localObject4[i4] = localObject1;
        j = 38;
        localObject3 = "L0z,NS>ki\007Qq{;\007K4D \035K>~0\"P66C";
        i = 37;
        localObject1 = localObject2;
        break;
      case 37: 
        localObject4[i4] = localObject1;
        j = 39;
        localObject3 = "y8`,\036^%di\013M#c;NP7,\022";
        i = 38;
        localObject1 = localObject2;
        break;
      case 38: 
        localObject4[i4] = localObject1;
        j = 40;
        localObject3 = "\037},.\007I4,<\036\037\"m?\013\037k";
        i = 39;
        localObject1 = localObject2;
        break;
      case 39: 
        localObject4[i4] = localObject1;
        j = 41;
        localObject3 = "\037>y=\036J%_=\034Z0aeNX8z,NJ!,:\017I4,s";
        i = 40;
        localObject1 = localObject2;
        break;
      case 40: 
        localObject4[i4] = localObject1;
        j = 42;
        localObject3 = "L%m=\035\021;|<\035Wo'";
        i = 41;
        localObject1 = localObject2;
        break;
      case 41: 
        localObject4[i4] = localObject1;
        j = 43;
        localObject3 = "W%x9\035\005~#";
        i = 42;
        localObject1 = localObject2;
        break;
      case 42: 
        localObject4[i4] = localObject1;
        j = 44;
        localObject3 = "\\>b=\013G%, \035\037?y%\002\037},.\007I4,<\036\037\"i'\n\037=c.";
        i = 43;
        localObject1 = localObject2;
        break;
      case 43: 
        localObject4[i4] = localObject1;
        j = 45;
        localObject3 = "V%i$NV\",'\033S=,eNX8z,NJ!,:\013Q5,%\001X";
        i = 44;
        localObject1 = localObject2;
        break;
      case 44: 
        localObject4[i4] = localObject1;
        j = 46;
        localObject3 = "J?i1\036Z2x,\n\036";
        i = 45;
        localObject1 = localObject2;
        break;
      case 45: 
        localObject4[i4] = localObject1;
        j = 47;
        localObject3 = "U!y:\006`\"x(\032`2m*\006Zf:\001Q";
        i = 46;
        localObject1 = localObject2;
        break;
      case 46: 
        localObject4[i4] = localObject1;
        j = 48;
        localObject3 = "\\=i(\034m4|&\034K\035c.(V=ii\031V%di\017O!g,\027\0372d(\000X4hi";
        i = 47;
        localObject1 = localObject2;
        break;
      case 47: 
        localObject4[i4] = localObject1;
        j = 49;
        localObject3 = "\\0bn\032\0373y \002[q";
        i = 48;
        localObject1 = localObject2;
        break;
      case 48: 
        localObject4[i4] = localObject1;
        j = 50;
        localObject3 = "\\>b=\013G%, \035\037?y%\002\037},.\007I4,<\036\037#i(\n\037";
        i = 49;
        localObject1 = localObject2;
        break;
      case 49: 
        localObject4[i4] = localObject1;
        j = 51;
        localObject3 = "\0378b9\033K\002x;\013^< i\tV'ii\033Oq~,\017[q,s";
        i = 50;
        localObject1 = localObject2;
        break;
      case 50: 
        localObject4[i4] = localObject1;
        j = 52;
        localObject3 = "Y8`,1Q0a,NV\",'\033S=,eNX8z,NJ!,;\013^5,";
        i = 51;
        localObject1 = localObject2;
        break;
      case 51: 
        localObject4[i4] = localObject1;
        j = 53;
        localObject3 = "\0378i\000J=`eNM4x<\034Qqb<\002S";
        i = 52;
        localObject1 = localObject2;
        break;
      case 52: 
        localObject4[i4] = localObject1;
        j = 54;
        localObject3 = "\0378b=\001\037\033&\000p3f,\rK},.\007I4,<\036\037#i(\n\037k";
        i = 53;
        localObject1 = localObject2;
        break;
      case 53: 
        localObject4[i4] = localObject1;
        j = 55;
        localObject3 = "\\0bn\032\037#i(\n\037";
        i = 54;
        localObject1 = localObject2;
        break;
      case 54: 
        localObject4[i4] = localObject1;
        j = 56;
        localObject3 = "\023qk \030Zqy9NM4m-N\005";
        i = 55;
        localObject1 = localObject2;
        break;
      case 55: 
        localObject4[i4] = localObject1;
        j = 57;
        localObject3 = "\\>b=\013G%6";
        i = 56;
        localObject1 = localObject2;
        break;
      case 56: 
        localObject4[i4] = localObject1;
        j = 58;
        localObject3 = "\0378x,\003Lk";
        i = 57;
        localObject1 = localObject2;
        break;
      case 57: 
        localObject4[i4] = localObject1;
        j = 59;
        localObject3 = "~2x \001Qq!i\035Z?h\005\001X\003c<\032V?ii\031V%di\034Z!c;\032\037\022m%\002}0o\"";
        i = 58;
        localObject1 = localObject2;
        break;
      case 58: 
        localObject4[i4] = localObject1;
        j = 60;
        localObject3 = "[4`,\032Zqj \002Zq<\r\\4:NY8`,\000^<is";
        i = 59;
        localObject1 = localObject2;
        break;
      case 59: 
        localObject4[i4] = localObject1;
        j = 61;
        localObject3 = "\\=i(\034w8=\001K(J \002Z\022c'\032Z?xi\013\005";
        i = 60;
        localObject1 = localObject2;
        break;
      case 60: 
        localObject4[i4] = localObject1;
        j = 62;
        localObject3 = "\037<e:\035\037$e-B\0376i'\013M0x,NM4|&\034Kqx&\005Z?,/\017V=i-";
        i = 61;
        localObject1 = localObject2;
        break;
      case 61: 
        localObject4[i4] = localObject1;
        j = 63;
        localObject3 = "\\$~;\013Q%S:\013L\"e&\000`7e%\013";
        i = 62;
        localObject1 = localObject2;
        break;
      case 62: 
        localObject4[i4] = localObject1;
        j = 64;
        localObject3 = "W8=\001M(S/\007S4";
        i = 63;
        localObject1 = localObject2;
      }
    }
    localObject4[i4] = localObject1;
    z = (String[])localObject2;
    b = l.class.getSimpleName();
    c = "";
    localObject1 = "\020'=f\034Z!c;\032";
    for (int k = -1;; k = 0)
    {
      localObject1 = ((String)localObject1).toCharArray();
      j = localObject1.length;
      n = 0;
      i = 0;
      i1 = k;
      localObject2 = localObject1;
      m = j;
      if (j <= 1) {}
      label2071:
      label2191:
      do
      {
        n = i;
        m = i;
        localObject2 = localObject1;
        i1 = localObject2[m];
        switch (n % 5)
        {
        default: 
          i = 110;
        }
        for (;;)
        {
          localObject2[m] = ((char)(i ^ i1));
          n += 1;
          if (j != 0) {
            break label2191;
          }
          m = j;
          break label2071;
          i = 63;
          break;
          i = 81;
          break;
          i = 12;
          break;
          i = 73;
          break;
          i = 63;
          continue;
          i = 81;
          continue;
          i = 12;
          continue;
          i = 73;
        }
        m = j;
        localObject2 = localObject1;
        i1 = k;
        k = i1;
        localObject1 = localObject2;
        j = m;
        i = n;
      } while (m > n);
      localObject1 = new String((char[])localObject2).intern();
      switch (i1)
      {
      default: 
        d = (String)localObject1;
        localObject1 = "\020'>f\034Z!c;\032";
      }
    }
    e = (String)localObject1;
    f = z[42] + d;
    g = Executors.newSingleThreadExecutor();
  }
  
  public static String a()
  {
    long l = cn.jiguang.c.a.a.r();
    if (l == 0L) {
      d.c(b, z[62]);
    }
    String str;
    do
    {
      return null;
      str = cn.jiguang.f.a.b(cn.jiguang.c.a.a.u());
      str = cn.jiguang.f.a.b(l + str);
    } while (cn.jiguang.f.h.a(str));
    return l + ":" + str;
  }
  
  public static String a(int paramInt)
  {
    try
    {
      InetAddress.getByName(z[42]);
      return z[43] + z[42] + e;
    }
    catch (Exception localException)
    {
      d.c(b, z[46], localException);
    }
    return b();
  }
  
  public static String a(String paramString)
  {
    if (cn.jiguang.f.h.a(paramString))
    {
      d.g(b, z[16]);
      return "";
    }
    String str = paramString;
    if (!paramString.startsWith(z[17])) {
      str = z[17] + paramString;
    }
    paramString = str;
    if (!str.endsWith(e)) {
      paramString = str + e;
    }
    c = paramString;
    d.a(b, z[18] + c);
    return c;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (cn.jiguang.f.h.a(paramString)) {
      d.c(b, z[15]);
    }
    long l;
    do
    {
      return null;
      paramString = e(paramString);
      l = cn.jiguang.c.a.a.r();
      if (l == 0L)
      {
        d.c(b, z[14]);
        return null;
      }
      String str = cn.jiguang.f.a.b(cn.jiguang.c.a.a.u());
      paramString = cn.jiguang.f.a.b(l + str + paramString);
    } while (cn.jiguang.f.h.a(paramString));
    return l + ":" + paramString;
  }
  
  /* Error */
  private static ArrayList<JSONArray> a(JSONArray paramJSONArray, int paramInt)
  {
    // Byte code:
    //   0: new 276	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 277	java/util/ArrayList:<init>	()V
    //   7: astore 8
    //   9: new 279	org/json/JSONArray
    //   12: dup
    //   13: invokespecial 280	org/json/JSONArray:<init>	()V
    //   16: astore 5
    //   18: aload_0
    //   19: ifnull +203 -> 222
    //   22: aload_0
    //   23: invokevirtual 284	org/json/JSONArray:length	()I
    //   26: ifle +196 -> 222
    //   29: aload_0
    //   30: invokevirtual 284	org/json/JSONArray:length	()I
    //   33: iconst_1
    //   34: isub
    //   35: istore 4
    //   37: iconst_0
    //   38: istore_2
    //   39: iconst_0
    //   40: istore_1
    //   41: iload 4
    //   43: iflt +163 -> 206
    //   46: aload_0
    //   47: iload 4
    //   49: invokevirtual 288	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   52: astore 7
    //   54: aload 7
    //   56: ifnull +201 -> 257
    //   59: aload 7
    //   61: invokevirtual 291	org/json/JSONObject:toString	()Ljava/lang/String;
    //   64: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   67: bipush 32
    //   69: aaload
    //   70: invokevirtual 295	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   73: arraylength
    //   74: istore_3
    //   75: iload_1
    //   76: iload_3
    //   77: iadd
    //   78: istore_1
    //   79: iload_1
    //   80: ldc_w 296
    //   83: if_icmple +43 -> 126
    //   86: iload 4
    //   88: iconst_1
    //   89: if_icmple +37 -> 126
    //   92: iload 4
    //   94: iconst_1
    //   95: if_icmple +6 -> 101
    //   98: aload 8
    //   100: areturn
    //   101: iload 4
    //   103: iconst_1
    //   104: if_icmpne +22 -> 126
    //   107: aload 5
    //   109: aload 7
    //   111: invokevirtual 300	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   114: pop
    //   115: aload 8
    //   117: aload 5
    //   119: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   122: pop
    //   123: aload 8
    //   125: areturn
    //   126: iload_2
    //   127: iload_3
    //   128: iadd
    //   129: sipush 20480
    //   132: if_icmple +43 -> 175
    //   135: aload 8
    //   137: aload 5
    //   139: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   142: pop
    //   143: new 279	org/json/JSONArray
    //   146: dup
    //   147: invokespecial 280	org/json/JSONArray:<init>	()V
    //   150: astore 6
    //   152: aload 6
    //   154: aload 7
    //   156: invokevirtual 300	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   159: pop
    //   160: iload_3
    //   161: istore_2
    //   162: aload 6
    //   164: astore 5
    //   166: iload 4
    //   168: iconst_1
    //   169: isub
    //   170: istore 4
    //   172: goto -131 -> 41
    //   175: iload_2
    //   176: iload_3
    //   177: iadd
    //   178: istore_2
    //   179: aload 5
    //   181: aload 7
    //   183: invokevirtual 300	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   186: pop
    //   187: goto -21 -> 166
    //   190: astore 6
    //   192: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   195: aload 6
    //   197: invokevirtual 307	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   200: invokestatic 310	cn/jiguang/d/d:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: goto -37 -> 166
    //   206: aload 5
    //   208: invokevirtual 284	org/json/JSONArray:length	()I
    //   211: ifle +11 -> 222
    //   214: aload 8
    //   216: aload 5
    //   218: invokevirtual 304	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   221: pop
    //   222: aload 8
    //   224: areturn
    //   225: astore 6
    //   227: goto -35 -> 192
    //   230: astore 6
    //   232: iload_3
    //   233: istore_2
    //   234: goto -42 -> 192
    //   237: astore 7
    //   239: iload_3
    //   240: istore_2
    //   241: aload 6
    //   243: astore 5
    //   245: aload 7
    //   247: astore 6
    //   249: goto -57 -> 192
    //   252: astore 6
    //   254: goto -62 -> 192
    //   257: goto -91 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramJSONArray	JSONArray
    //   0	260	1	paramInt	int
    //   38	203	2	i	int
    //   74	166	3	j	int
    //   35	136	4	k	int
    //   16	228	5	localObject	Object
    //   150	13	6	localJSONArray	JSONArray
    //   190	6	6	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   225	1	6	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   230	12	6	localUnsupportedEncodingException3	UnsupportedEncodingException
    //   247	1	6	localUnsupportedEncodingException4	UnsupportedEncodingException
    //   252	1	6	localUnsupportedEncodingException5	UnsupportedEncodingException
    //   52	130	7	localJSONObject	JSONObject
    //   237	9	7	localUnsupportedEncodingException6	UnsupportedEncodingException
    //   7	216	8	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   59	75	190	java/io/UnsupportedEncodingException
    //   107	123	225	java/io/UnsupportedEncodingException
    //   135	152	230	java/io/UnsupportedEncodingException
    //   152	160	237	java/io/UnsupportedEncodingException
    //   179	187	252	java/io/UnsupportedEncodingException
  }
  
  /* Error */
  public static JSONObject a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 320	java/lang/String:length	()I
    //   8: ifgt +17 -> 25
    //   11: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   14: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   17: bipush 52
    //   19: aaload
    //   20: invokestatic 225	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aconst_null
    //   24: areturn
    //   25: aload_1
    //   26: invokestatic 322	cn/jiguang/c/d/l:f	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_3
    //   30: aload_0
    //   31: ifnonnull +31 -> 62
    //   34: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   37: new 187	java/lang/StringBuilder
    //   40: dup
    //   41: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   44: bipush 50
    //   46: aaload
    //   47: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_3
    //   51: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 225	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aconst_null
    //   61: areturn
    //   62: aload_0
    //   63: aload_1
    //   64: invokevirtual 328	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   67: astore_1
    //   68: aload_1
    //   69: astore_0
    //   70: aload_1
    //   71: invokevirtual 333	java/io/FileInputStream:available	()I
    //   74: iconst_1
    //   75: iadd
    //   76: newarray <illegal type>
    //   78: astore_2
    //   79: aload_1
    //   80: astore_0
    //   81: aload_1
    //   82: aload_2
    //   83: invokevirtual 337	java/io/FileInputStream:read	([B)I
    //   86: pop
    //   87: aload_1
    //   88: invokestatic 340	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   91: new 22	java/lang/String
    //   94: dup
    //   95: aload_2
    //   96: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   99: bipush 32
    //   101: aaload
    //   102: invokespecial 343	java/lang/String:<init>	([BLjava/lang/String;)V
    //   105: astore_0
    //   106: aload_0
    //   107: invokestatic 242	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   110: ifeq +196 -> 306
    //   113: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   116: new 187	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   123: aload_3
    //   124: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   130: bipush 53
    //   132: aaload
    //   133: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 225	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_0
    //   145: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   148: new 187	java/lang/StringBuilder
    //   151: dup
    //   152: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   155: bipush 30
    //   157: aaload
    //   158: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_3
    //   162: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   168: bipush 56
    //   170: aaload
    //   171: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: invokevirtual 307	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   178: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 225	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aconst_null
    //   188: areturn
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: astore_0
    //   194: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   197: new 187	java/lang/StringBuilder
    //   200: dup
    //   201: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   204: bipush 34
    //   206: aaload
    //   207: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   210: aload_3
    //   211: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   217: bipush 51
    //   219: aaload
    //   220: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_2
    //   224: invokevirtual 344	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   227: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 225	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_1
    //   237: invokestatic 340	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   240: aconst_null
    //   241: areturn
    //   242: astore_2
    //   243: aconst_null
    //   244: astore_1
    //   245: aload_1
    //   246: astore_0
    //   247: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   250: new 187	java/lang/StringBuilder
    //   253: dup
    //   254: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   257: bipush 55
    //   259: aaload
    //   260: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   263: aload_3
    //   264: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   270: bipush 56
    //   272: aaload
    //   273: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_2
    //   277: invokevirtual 345	java/io/IOException:getMessage	()Ljava/lang/String;
    //   280: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 225	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload_1
    //   290: invokestatic 340	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   293: aconst_null
    //   294: areturn
    //   295: astore_0
    //   296: aconst_null
    //   297: astore_2
    //   298: aload_0
    //   299: astore_1
    //   300: aload_2
    //   301: invokestatic 340	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   304: aload_1
    //   305: athrow
    //   306: new 290	org/json/JSONObject
    //   309: dup
    //   310: aload_0
    //   311: invokespecial 346	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   314: astore_0
    //   315: aload_0
    //   316: areturn
    //   317: astore_0
    //   318: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   321: new 187	java/lang/StringBuilder
    //   324: dup
    //   325: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   328: bipush 49
    //   330: aaload
    //   331: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: aload_3
    //   335: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   341: bipush 54
    //   343: aaload
    //   344: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_0
    //   348: invokevirtual 347	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   351: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 225	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aconst_null
    //   361: areturn
    //   362: astore_1
    //   363: aload_0
    //   364: astore_2
    //   365: goto -65 -> 300
    //   368: astore_2
    //   369: goto -124 -> 245
    //   372: astore_2
    //   373: goto -181 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	paramContext	Context
    //   0	376	1	paramString	String
    //   78	18	2	arrayOfByte	byte[]
    //   189	35	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   242	35	2	localIOException1	IOException
    //   297	68	2	localObject	Object
    //   368	1	2	localIOException2	IOException
    //   372	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   29	306	3	str	String
    // Exception table:
    //   from	to	target	type
    //   91	142	144	java/io/UnsupportedEncodingException
    //   306	315	144	java/io/UnsupportedEncodingException
    //   62	68	189	java/io/FileNotFoundException
    //   62	68	242	java/io/IOException
    //   62	68	295	finally
    //   91	142	317	org/json/JSONException
    //   306	315	317	org/json/JSONException
    //   70	79	362	finally
    //   81	87	362	finally
    //   194	236	362	finally
    //   247	289	362	finally
    //   70	79	368	java/io/IOException
    //   81	87	368	java/io/IOException
    //   70	79	372	java/io/FileNotFoundException
    //   81	87	372	java/io/FileNotFoundException
  }
  
  public static void a(Context paramContext)
  {
    d.c(b, z[48]);
    a(paramContext, z[47], null);
    b(paramContext);
    a(paramContext, z[11], null);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    int j = 0;
    if (a == null) {}
    for (;;)
    {
      return;
      JSONObject localJSONObject1 = a;
      if (paramInt >= 204800)
      {
        b(paramContext);
        return;
      }
      try
      {
        i = localJSONObject1.toString().getBytes(z[13]).length;
        int k = i + paramInt - 204800;
        if (k <= 0) {
          continue;
        }
        JSONArray localJSONArray1 = localJSONObject1.optJSONArray(z[12]);
        if ((localJSONArray1 == null) || (localJSONArray1.length() <= 0)) {
          continue;
        }
        for (;;)
        {
          try
          {
            JSONArray localJSONArray2 = new JSONArray();
            paramInt = 0;
            i = j;
            if (paramInt < localJSONArray1.length())
            {
              JSONObject localJSONObject2 = localJSONArray1.getJSONObject(paramInt);
              j = i;
              if (localJSONObject2 == null) {
                break label205;
              }
              if (i >= k) {
                localJSONArray2.put(localJSONObject2);
              }
              j = i + localJSONObject2.toString().getBytes(z[13]).length;
              break label205;
            }
            if (localJSONArray2.length() <= 0) {
              continue;
            }
            localJSONObject1.put(z[12], localJSONArray2);
          }
          catch (JSONException paramContext)
          {
            return;
            localJSONObject1 = null;
            continue;
          }
          catch (UnsupportedEncodingException paramContext)
          {
            return;
          }
          a = localJSONObject1;
          a(paramContext, z[11], localJSONObject1);
          return;
          label205:
          paramInt += 1;
          i = j;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
  }
  
  public static void a(Context paramContext, JSONArray paramJSONArray)
  {
    a(paramContext, paramJSONArray, "");
  }
  
  public static void a(Context paramContext, JSONArray paramJSONArray, m paramm)
  {
    int i = -1;
    d.a(b, z[59]);
    JSONObject localJSONObject = new JSONObject();
    if ((paramContext == null) || (paramJSONArray == null) || (paramJSONArray.length() <= 0))
    {
      d.g(b, z[57] + paramContext + z[58] + paramJSONArray);
      if (paramm != null) {
        paramm.a(-1);
      }
    }
    for (;;)
    {
      return;
      try
      {
        d.c(b, z[20] + paramJSONArray.toString().getBytes(z[13]).length);
        try
        {
          localJSONObject.put(z[12], paramJSONArray);
          try
          {
            if (a(localJSONObject, paramContext)) {
              break label240;
            }
            if (paramm == null) {
              continue;
            }
            paramm.a(-1);
            return;
          }
          catch (Exception paramContext)
          {
            d.c(b, z[27] + paramContext);
          }
          if (paramm == null) {
            continue;
          }
          paramm.a(-1);
          return;
        }
        catch (JSONException paramContext)
        {
          d.c(b, z[24] + paramContext);
        }
        if (paramm == null) {
          continue;
        }
        paramm.a(-1);
        return;
        try
        {
          label240:
          d.e(b, z[23] + localJSONObject.toString(1));
          int j = h.a(paramContext, localJSONObject, true);
          if (paramm == null) {
            continue;
          }
          if (j == 200) {
            i = 0;
          }
          paramm.a(i);
          return;
        }
        catch (JSONException paramJSONArray)
        {
          for (;;)
          {
            d.e(b, z[23] + localJSONObject.toString());
          }
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;) {}
      }
    }
  }
  
  public static void a(Context paramContext, JSONArray paramJSONArray, String paramString)
  {
    if (paramContext == null)
    {
      d.c(b, z[44]);
      return;
    }
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0))
    {
      d.c(b, z[45]);
      return;
    }
    g.execute(new n(paramContext, paramJSONArray, paramString));
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject)
  {
    a(paramContext, new JSONArray().put(paramJSONObject), "");
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject, String paramString)
  {
    a(paramContext, new JSONArray().put(paramJSONObject), paramString);
  }
  
  private static void a(Context paramContext, JSONObject paramJSONObject, ArrayList<JSONArray> paramArrayList)
  {
    JSONArray localJSONArray1 = new JSONArray();
    if (paramArrayList.size() <= 0) {
      b(paramContext);
    }
    try
    {
      paramJSONObject.put(z[12], localJSONArray1);
      a = paramJSONObject;
      a(paramContext, z[11], paramJSONObject);
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        JSONArray localJSONArray2 = (JSONArray)paramArrayList.get(i);
        int j = 0;
        while (j < localJSONArray2.length())
        {
          if (localJSONArray2.optJSONObject(j) != null) {
            localJSONArray1.put(localJSONArray2.optJSONObject(j));
          }
          j += 1;
        }
        i += 1;
      }
    }
    catch (JSONException paramArrayList)
    {
      for (;;) {}
    }
  }
  
  private static void a(Context paramContext, JSONObject paramJSONObject, JSONArray paramJSONArray, ArrayList<JSONArray> paramArrayList)
  {
    if (paramArrayList.size() == 1) {
      b(paramContext);
    }
    while ((paramJSONArray == null) || (paramArrayList.size() <= 1)) {
      return;
    }
    paramArrayList.remove(paramJSONArray);
    paramJSONArray = new JSONArray();
    int i = 0;
    while (i < paramArrayList.size())
    {
      JSONArray localJSONArray = (JSONArray)paramArrayList.get(i);
      int j = 0;
      while (j < localJSONArray.length())
      {
        if (localJSONArray.optJSONObject(j) != null) {
          paramJSONArray.put(localJSONArray.optJSONObject(j));
        }
        j += 1;
      }
      i += 1;
    }
    try
    {
      paramJSONObject.put(z[12], paramJSONArray);
      a = paramJSONObject;
      a(paramContext, z[11], paramJSONObject);
      return;
    }
    catch (JSONException paramJSONArray)
    {
      for (;;) {}
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 242	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   4: ifeq +17 -> 21
    //   7: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   10: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   13: bipush 36
    //   15: aaload
    //   16: invokestatic 225	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_1
    //   22: invokestatic 322	cn/jiguang/c/d/l:f	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 9
    //   27: aload_0
    //   28: ifnonnull +32 -> 60
    //   31: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   34: new 187	java/lang/StringBuilder
    //   37: dup
    //   38: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   41: bipush 35
    //   43: aaload
    //   44: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: aload 9
    //   49: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 225	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: iconst_0
    //   59: ireturn
    //   60: getstatic 213	cn/jiguang/c/d/l:h	Ljava/lang/Object;
    //   63: astore 8
    //   65: aload 8
    //   67: monitorenter
    //   68: ldc -81
    //   70: astore 7
    //   72: aload_2
    //   73: ifnull +62 -> 135
    //   76: aload_2
    //   77: invokevirtual 291	org/json/JSONObject:toString	()Ljava/lang/String;
    //   80: astore 4
    //   82: aload_1
    //   83: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   86: bipush 11
    //   88: aaload
    //   89: invokevirtual 430	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: istore_3
    //   93: aload 4
    //   95: astore 7
    //   97: iload_3
    //   98: ifeq +37 -> 135
    //   101: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   104: new 187	java/lang/StringBuilder
    //   107: dup
    //   108: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   111: bipush 38
    //   113: aaload
    //   114: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_2
    //   118: iconst_1
    //   119: invokevirtual 387	org/json/JSONObject:toString	(I)Ljava/lang/String;
    //   122: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 268	cn/jiguang/d/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload 4
    //   133: astore 7
    //   135: aconst_null
    //   136: astore 5
    //   138: aconst_null
    //   139: astore 6
    //   141: aconst_null
    //   142: astore_2
    //   143: aconst_null
    //   144: astore 4
    //   146: aload_0
    //   147: aload_1
    //   148: iconst_0
    //   149: invokevirtual 434	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   152: astore_0
    //   153: aload_0
    //   154: astore 4
    //   156: aload_0
    //   157: astore 5
    //   159: aload_0
    //   160: astore 6
    //   162: aload_0
    //   163: astore_2
    //   164: aload_0
    //   165: aload 7
    //   167: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   170: bipush 32
    //   172: aaload
    //   173: invokevirtual 295	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   176: invokevirtual 440	java/io/FileOutputStream:write	([B)V
    //   179: aload_0
    //   180: invokestatic 340	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   183: aload 8
    //   185: monitorexit
    //   186: iconst_1
    //   187: ireturn
    //   188: astore_2
    //   189: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   192: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   195: bipush 33
    //   197: aaload
    //   198: aload_2
    //   199: invokestatic 256	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   202: aload 4
    //   204: astore 7
    //   206: goto -71 -> 135
    //   209: astore_0
    //   210: aload 8
    //   212: monitorexit
    //   213: aload_0
    //   214: athrow
    //   215: astore_1
    //   216: aconst_null
    //   217: astore_0
    //   218: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   221: new 187	java/lang/StringBuilder
    //   224: dup
    //   225: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   228: bipush 34
    //   230: aaload
    //   231: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   234: aload 9
    //   236: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   242: bipush 41
    //   244: aaload
    //   245: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_1
    //   249: invokevirtual 344	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   252: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 225	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload_0
    //   262: invokestatic 340	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   265: aload 8
    //   267: monitorexit
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_0
    //   271: aload 4
    //   273: astore_2
    //   274: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   277: new 187	java/lang/StringBuilder
    //   280: dup
    //   281: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   284: bipush 30
    //   286: aaload
    //   287: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload 9
    //   292: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   298: bipush 40
    //   300: aaload
    //   301: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_0
    //   305: invokevirtual 307	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   308: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 225	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload 4
    //   319: invokestatic 340	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   322: aload 8
    //   324: monitorexit
    //   325: iconst_0
    //   326: ireturn
    //   327: astore_0
    //   328: aload 5
    //   330: astore_2
    //   331: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   334: new 187	java/lang/StringBuilder
    //   337: dup
    //   338: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   341: bipush 31
    //   343: aaload
    //   344: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   347: aload 9
    //   349: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   355: bipush 40
    //   357: aaload
    //   358: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload_0
    //   362: invokevirtual 345	java/io/IOException:getMessage	()Ljava/lang/String;
    //   365: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 225	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload 5
    //   376: invokestatic 340	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   379: aload 8
    //   381: monitorexit
    //   382: iconst_0
    //   383: ireturn
    //   384: astore_0
    //   385: aload 6
    //   387: astore_2
    //   388: getstatic 173	cn/jiguang/c/d/l:b	Ljava/lang/String;
    //   391: new 187	java/lang/StringBuilder
    //   394: dup
    //   395: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   398: bipush 39
    //   400: aaload
    //   401: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   404: aload 9
    //   406: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: getstatic 166	cn/jiguang/c/d/l:z	[Ljava/lang/String;
    //   412: bipush 37
    //   414: aaload
    //   415: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload_0
    //   419: invokevirtual 441	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   422: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 225	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload 6
    //   433: invokestatic 340	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   436: aload 8
    //   438: monitorexit
    //   439: iconst_0
    //   440: ireturn
    //   441: aload_1
    //   442: invokestatic 340	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   445: aload_0
    //   446: athrow
    //   447: astore_2
    //   448: aload_0
    //   449: astore_1
    //   450: aload_2
    //   451: astore_0
    //   452: goto -11 -> 441
    //   455: astore_1
    //   456: goto -238 -> 218
    //   459: astore_0
    //   460: aload_2
    //   461: astore_1
    //   462: goto -21 -> 441
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	paramContext	Context
    //   0	465	1	paramString	String
    //   0	465	2	paramJSONObject	JSONObject
    //   92	6	3	bool	boolean
    //   80	238	4	localObject1	Object
    //   136	239	5	localContext1	Context
    //   139	293	6	localContext2	Context
    //   70	135	7	localObject2	Object
    //   63	374	8	localObject3	Object
    //   25	380	9	str	String
    // Exception table:
    //   from	to	target	type
    //   101	131	188	java/lang/Exception
    //   76	93	209	finally
    //   101	131	209	finally
    //   179	186	209	finally
    //   189	202	209	finally
    //   210	213	209	finally
    //   261	268	209	finally
    //   317	325	209	finally
    //   374	382	209	finally
    //   431	439	209	finally
    //   441	447	209	finally
    //   146	153	215	java/io/FileNotFoundException
    //   146	153	270	java/io/UnsupportedEncodingException
    //   164	179	270	java/io/UnsupportedEncodingException
    //   146	153	327	java/io/IOException
    //   164	179	327	java/io/IOException
    //   146	153	384	java/lang/NullPointerException
    //   164	179	384	java/lang/NullPointerException
    //   218	261	447	finally
    //   164	179	455	java/io/FileNotFoundException
    //   146	153	459	finally
    //   164	179	459	finally
    //   274	317	459	finally
    //   331	374	459	finally
    //   388	431	459	finally
  }
  
  private static boolean a(JSONObject paramJSONObject, Context paramContext)
  {
    paramJSONObject.put(z[3], "a");
    long l = cn.jiguang.c.a.a.r();
    if (l == 0L)
    {
      d.i(b, z[6]);
      return false;
    }
    paramJSONObject.put(z[1], l);
    paramContext = cn.jiguang.f.a.k(paramContext);
    if (cn.jiguang.f.h.a(paramContext))
    {
      d.i(b, z[5]);
      return false;
    }
    paramJSONObject.put(z[8], paramContext);
    a.a().a(paramJSONObject);
    paramJSONObject.put(z[10], z[4]);
    paramContext = cn.jiguang.c.a.a.z();
    if (!cn.jiguang.f.h.a(paramContext))
    {
      paramJSONObject.put(z[7], paramContext);
      if (cn.jiguang.f.h.a(cn.jiguang.c.a.j)) {
        break label170;
      }
      paramJSONObject.put(z[0], cn.jiguang.c.a.j);
    }
    for (;;)
    {
      return true;
      d.h(b, z[2]);
      break;
      label170:
      d.h(b, z[9]);
    }
  }
  
  private static String b()
  {
    if (cn.jiguang.f.h.a(c)) {
      a(cn.jiguang.c.a.a.p());
    }
    return c;
  }
  
  private static void b(Context paramContext)
  {
    a = null;
    if (!a(paramContext, z[11], null)) {}
    try
    {
      if (paramContext.deleteFile(f(z[11]))) {
        d.i(b, z[60] + f(z[11]));
      }
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      d.i(b, z[61] + paramContext.getMessage());
      return;
    }
    catch (Exception paramContext)
    {
      d.i(b, z[61] + paramContext.getMessage());
    }
  }
  
  private static void b(Context paramContext, JSONObject paramJSONObject)
  {
    a = paramJSONObject;
    a(paramContext, z[11], paramJSONObject);
  }
  
  public static boolean b(String paramString)
  {
    c = b();
    if ((cn.jiguang.f.h.a(paramString)) || (cn.jiguang.f.h.a(c))) {
      return false;
    }
    return paramString.equals(c);
  }
  
  public static String c(String paramString)
  {
    try
    {
      InetAddress.getByName(z[42]);
      return z[43] + z[42] + paramString;
    }
    catch (Exception paramString) {}
    return b();
  }
  
  public static String d(String paramString)
  {
    try
    {
      paramString = Base64.encodeToString(paramString.getBytes(), 10);
      return paramString;
    }
    catch (Exception paramString)
    {
      d.i(z[29], z[28]);
    }
    return null;
  }
  
  private static String e(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes(z[32]);
      paramString = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(paramString);
      localGZIPOutputStream.write(arrayOfByte);
      localGZIPOutputStream.close();
      arrayOfByte = paramString.toByteArray();
      paramString.close();
      paramString = cn.jiguang.f.a.a(arrayOfByte);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static String f(String paramString)
  {
    if (cn.jiguang.f.h.a(paramString))
    {
      d.c(b, z[36]);
      return null;
    }
    if (paramString.equals(z[11])) {
      return z[64];
    }
    return z[63];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */