package cn.jiguang.c.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.jiguang.api.JResponse;
import cn.jiguang.api.SdkType;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.c.b.e;
import cn.jiguang.c.b.g;
import cn.jiguang.c.c.p;
import cn.jiguang.f.h;
import cn.jiguang.service.Protocol;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static final List<String> a;
  private static final String[] z;
  
  static
  {
    Object localObject2 = new String[85];
    int j = 0;
    Object localObject3 = "\0210#tr=\033\023?x;\031P y'\033\02101=\037\003ts0\033\036tx;\n\025&c \016\0041uu_";
    int i = -1;
    Object localObject1 = localObject2;
    int i1;
    int i4;
    Object localObject4;
    int n;
    Object localObject5;
    int i2;
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
            i = 17;
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
        localObject3 = "\026\021\036:t6\n\031:v\035\033\034$t'";
        i = 0;
        localObject1 = localObject2;
        break;
      case 0: 
        localObject4[i4] = localObject1;
        j = 2;
        localObject3 = "\031\021\0235}u\033\002&~'^\0241b6\f\031$e<\021\036n1";
        i = 1;
        localObject1 = localObject2;
        break;
      case 1: 
        localObject4[i4] = localObject1;
        j = 3;
        localObject3 = "卐味Jt";
        i = 2;
        localObject1 = localObject2;
        break;
      case 2: 
        localObject4[i4] = localObject1;
        j = 4;
        localObject3 = "u霠\021:u'\021\03101\024\016\000\037t,";
        i = 3;
        localObject1 = localObject2;
        break;
      case 3: 
        localObject4[i4] = localObject1;
        j = 5;
        localObject3 = "\000\020\03051\022\02501&\033\002\"t'^\0021b%\021\036'tu\033\002&~'^\023;u0^]t";
        i = 4;
        localObject1 = localObject2;
        break;
      case 4: 
        localObject4[i4] = localObject1;
        j = 6;
        localObject3 = "u杔坘9p;\027\0261b!乓鄽缺P%\016;1h";
        i = 5;
        localObject1 = localObject2;
        break;
      case 5: 
        localObject4[i4] = localObject1;
        j = 7;
        localObject3 = "u乳嬨坼";
        i = 6;
        localObject1 = localObject2;
        break;
      case 6: 
        localObject4[i4] = localObject1;
        j = 8;
        localObject3 = "\007\033\027=b!\033\002tW4\027\0341uu\t\031 yu\r\025&g0\fP1c'\021\002t<u\035\0370to";
        i = 7;
        localObject1 = localObject2;
        break;
      case 7: 
        localObject4[i4] = localObject1;
        j = 9;
        localObject3 = "\03435\0351<\rP0d%\022\0317p!\033\024tc0\016\037&e0\032P6hu\r\025&g0\f^tV<\b\025td%^\036;f{^";
        i = 8;
        localObject1 = localObject2;
        break;
      case 8: 
        localObject4[i4] = localObject1;
        j = 10;
        localObject3 = "乘升鄽";
        i = 9;
        localObject1 = localObject2;
        break;
      case 9: 
        localObject4[i4] = localObject1;
        j = 11;
        localObject3 = "u晑斐攜皕\024\016\000\037t,R讇砺讵乛4 !b=^\0071s窺盺1$a\036\033\t乔臥";
        i = 10;
        localObject1 = localObject2;
        break;
      case 10: 
        localObject4[i4] = localObject1;
        j = 12;
        localObject3 = "u买P\025a%5\025-+";
        i = 11;
        localObject1 = localObject2;
        break;
      case 11: 
        localObject4[i4] = localObject1;
        j = 13;
        localObject3 = "u?\000$Z0\007J";
        i = 12;
        localObject1 = localObject2;
        break;
      case 12: 
        localObject4[i4] = localObject1;
        j = 14;
        localObject3 = "\034\020\0065}<\032P0t3\037\0058eu\035\037:{";
        i = 13;
        localObject1 = localObject2;
        break;
      case 13: 
        localObject4[i4] = localObject1;
        j = 15;
        localObject3 = "\020\006\0231a!\027\037:1!\021P7~;\020\0257eu\026\037'euSP=|cJ^>a \r\030zr;";
        i = 14;
        localObject1 = localObject2;
        break;
      case 14: 
        localObject4[i4] = localObject1;
        j = 16;
        localObject3 = "\032\016\025:16\021\036:t6\n\031;u\t\031 yu\032\0252p \022\004t<u\027\000n";
        i = 15;
        localObject1 = localObject2;
        break;
      case 15: 
        localObject4[i4] = localObject1;
        j = 17;
        localObject3 = "\n\027\035b%{!\0047a{\024\000!b=P\023:";
        i = 16;
        localObject1 = localObject2;
        break;
      case 16: 
        localObject4[i4] = localObject1;
        j = 18;
        localObject3 = "\032\016\025:16\021\036:t6\n\031;u\t\031 yu\026\021&u6\021\0241uu\026\037'euSP=ao";
        i = 17;
        localObject1 = localObject2;
        break;
      case 17: 
        localObject4[i4] = localObject1;
        j = 19;
        localObject3 = "\006\013\0237t0\032P ~u\021\0001u\035\037:0\035\004=~;^]tx%D";
        i = 18;
        localObject1 = localObject2;
        break;
      case 18: 
        localObject4[i4] = localObject1;
        j = 20;
        localObject3 = "y^\000;c!D";
        i = 19;
        localObject1 = localObject2;
        break;
      case 19: 
        localObject4[i4] = localObject1;
        j = 21;
        localObject3 = "%\026\037:t";
        i = 20;
        localObject1 = localObject2;
        break;
      case 20: 
        localObject4[i4] = localObject1;
        j = 22;
        localObject3 = "dPAz!";
        i = 21;
        localObject1 = localObject2;
        break;
      case 21: 
        localObject4[i4] = localObject1;
        j = 23;
        localObject3 = "y^\0268p2D";
        i = 22;
        localObject1 = localObject2;
        break;
      case 22: 
        localObject4[i4] = localObject1;
        j = 24;
        localObject3 = "9\021\027=uSP>d<\032J";
        i = 23;
        localObject1 = localObject2;
        break;
      case 23: 
        localObject4[i4] = localObject1;
        j = 25;
        localObject3 = "y^\0030z\003\033\002'x:\020J";
        i = 24;
        localObject1 = localObject2;
        break;
      case 24: 
        localObject4[i4] = localObject1;
        j = 26;
        localObject3 = "\031\021\027=u\030\021=}0\032P#x!\026P't'\b\025&10\f\002;cuSP7~1\033J";
        i = 25;
        localObject1 = localObject2;
        break;
      case 25: 
        localObject4[i4] = localObject1;
        j = 27;
        localObject3 = "\031\021\027=u\t\031 yuSP>d<\032J";
        i = 26;
        localObject1 = localObject2;
        break;
      case 26: 
        localObject4[i4] = localObject1;
        j = 28;
        localObject3 = "?\r\037:T-\035\025$e<\021\036t<u";
        i = 27;
        localObject1 = localObject2;
        break;
      case 27: 
        localObject4[i4] = localObject1;
        j = 29;
        localObject3 = "\031\021\027=u\030\021=}0\032P#x!\026P\030~6\037\034tt'\f\037&1x^\023;u0D";
        i = 28;
        localObject1 = localObject2;
        break;
      case 28: 
        localObject4[i4] = localObject1;
        j = 30;
        localObject3 = "u\022\0373x;,\025'a:\020\00311<\rP:d9\022";
        i = 29;
        localObject1 = localObject2;
        break;
      case 29: 
        localObject4[i4] = localObject1;
        j = 31;
        localObject3 = "6\020^>a \r\030zx8P\021:u'\021\0310?4\035\004=~;P9\031N\007;#\004^\033-5";
        i = 30;
        localObject1 = localObject2;
        break;
      case 30: 
        localObject4[i4] = localObject1;
        j = 32;
        localObject3 = "uR\003<p'\033&1c&\027\037:+";
        i = 31;
        localObject1 = localObject2;
        break;
      case 31: 
        localObject4[i4] = localObject1;
        j = 33;
        localObject3 = "\005+#\034";
        i = 32;
        localObject1 = localObject2;
        break;
      case 32: 
        localObject4[i4] = localObject1;
        j = 34;
        localObject3 = "%\013\003<N9\021\027=\n\r\025&g0\f/ x8\033";
        i = 33;
        localObject1 = localObject2;
        break;
      case 33: 
        localObject4[i4] = localObject1;
        j = 35;
        localObject3 = "y^\021:p9\007\004=r&(\025&b<\021\036n";
        i = 34;
        localObject1 = localObject2;
        break;
      case 34: 
        localObject4[i4] = localObject1;
        j = 36;
        localObject3 = "\024\035\004=~;^]tb0\020\024\007t'\b\025&E<\023\025&";
        i = 35;
        localObject1 = localObject2;
        break;
      case 35: 
        localObject4[i4] = localObject1;
        j = 37;
        localObject3 = "\031\021\027=u\r\0057r0\033\024t<u\r\0310+";
        i = 36;
        localObject1 = localObject2;
        break;
      case 36: 
        localObject4[i4] = localObject1;
        j = 38;
        localObject3 = "\031\021\027=u\030\021=}0\032P#x!\026P&t!\013\002:16\021\0241+";
        i = 37;
        localObject1 = localObject2;
        break;
      case 37: 
        localObject4[i4] = localObject1;
        j = 39;
        localObject3 = "y^\0031c#\033\002\000x8\033K";
        i = 38;
        localObject1 = localObject2;
        break;
      case 38: 
        localObject4[i4] = localObject1;
        j = 40;
        localObject3 = "y^\021$a\036\033\tn";
        i = 39;
        localObject1 = localObject2;
        break;
      case 39: 
        localObject4[i4] = localObject1;
        j = 41;
        localObject3 = "%\013\003<N!\021/=|\n\032\021 p";
        i = 40;
        localObject1 = localObject2;
        break;
      case 40: 
        localObject4[i4] = localObject1;
        j = 42;
        localObject3 = "%\013\003<N9\021\027=\n\022\0377p9!\004=|0";
        i = 41;
        localObject1 = localObject2;
        break;
      case 41: 
        localObject4[i4] = localObject1;
        j = 43;
        localObject3 = "%\037\002't\006\027\003\0353\021P7c4\r\030n";
        i = 42;
        localObject1 = localObject2;
        break;
      case 42: 
        localObject4[i4] = localObject1;
        j = 44;
        localObject3 = "\032\016\025:16\021\036:t6\n\031;u\030\021=}0\032Py1'\033\004n";
        i = 43;
        localObject1 = localObject2;
        break;
      case 43: 
        localObject4[i4] = localObject1;
        j = 45;
        localObject3 = "4\035\004=~;^]tx;\024\0257e\026\021\036:t6\n\031;y^\005:t-\016\0257e0\032^z?";
        i = 44;
        localObject1 = localObject2;
        break;
      case 44: 
        localObject4[i4] = localObject1;
        j = 46;
        localObject3 = "\024\035\004=~;DP&t&\n\037&t\007\n\023\003y0\020\"1v<\r\0041c\006\013\0237t0\032";
        i = 45;
        localObject1 = localObject2;
        break;
      case 45: 
        localObject4[i4] = localObject1;
        j = 47;
        localObject3 = "6\021\036:t6\n\0250";
        i = 46;
        localObject1 = localObject2;
        break;
      case 46: 
        localObject4[i4] = localObject1;
        j = 48;
        localObject3 = "6\020^>a \r\030zp;\032\002;x1P3\033_\033;3\000X\0320/\027Y\02407\021";
        i = 47;
        localObject1 = localObject2;
        break;
      case 47: 
        localObject4[i4] = localObject1;
        j = 49;
        localObject3 = "6\020^>a \r\030zp;\032\002;x1P\031:e0\020\004zR\0320>\021R\0017?\032";
        i = 48;
        localObject1 = localObject2;
        break;
      case 48: 
        localObject4[i4] = localObject1;
        j = 50;
        localObject3 = "&\n\021 tu\027\003t:\nP7y4\020\0271uuSP";
        i = 49;
        localObject1 = localObject2;
        break;
      case 49: 
        localObject4[i4] = localObject1;
        j = 51;
        localObject3 = "\024\035\004=~;^]tb0\020\024\027~;\020\0257e<\021\036\027y4\020\0271u";
        i = 50;
        localObject1 = localObject2;
        break;
      case 50: 
        localObject4[i4] = localObject1;
        j = 52;
        localObject3 = "\007\033\027=b!\033\002tw4\027\0341uuSP!>\020\037#u\035\0379|4\020\024";
        i = 51;
        localObject1 = localObject2;
        break;
      case 51: 
        localObject4[i4] = localObject1;
        j = 53;
        localObject3 = "6\020^>a \r\030zp;\032\002;x1P\"\021V\034-$\006P\0017?\032N\034:";
        i = 52;
        localObject1 = localObject2;
        break;
      case 52: 
        localObject4[i4] = localObject1;
        j = 54;
        localObject3 = "y^\021$z\003\033\002'x:\020J";
        i = 53;
        localObject1 = localObject2;
        break;
      case 53: 
        localObject4[i4] = localObject1;
        j = 55;
        localObject3 = "\007\033\027=b!\033\002tw4\027\0341uuSP=eu\027\003t:\nP&t2\027\003 t'^\0021b%\021\036't{";
        i = 54;
        localObject1 = localObject2;
        break;
      case 54: 
        localObject4[i4] = localObject1;
        j = 56;
        localObject3 = "y^\0021v<\r\004&p!\027\037:X1D";
        i = 55;
        localObject1 = localObject2;
        break;
      case 55: 
        localObject4[i4] = localObject1;
        j = 57;
        localObject3 = "6\020^>a \r\030zp;\032\002;x1P\031:e0\020\004zC\02099\007E\007?$\035^\033";
        i = 56;
        localObject1 = localObject2;
        break;
      case 56: 
        localObject4[i4] = localObject1;
        j = 58;
        localObject3 = "%\037\003'f:\f\024n";
        i = 57;
        localObject1 = localObject2;
        break;
      case 57: 
        localObject4[i4] = localObject1;
        j = 59;
        localObject3 = "y^\025,e\036\033\tn";
        i = 58;
        localObject1 = localObject2;
        break;
      case 58: 
        localObject4[i4] = localObject1;
        j = 60;
        localObject3 = "\007\033\027=b!\033\002tw4\027\0341uuSP&t!D";
        i = 59;
        localObject1 = localObject2;
        break;
      case 59: 
        localObject4[i4] = localObject1;
        j = 61;
        localObject3 = "\000\020\025,a0\035\0041uo^\0021v<\r\004&p!\027\037:X1Q\032!x1^\003<~ \022\024t:\nP6tu\033\035$e,PP";
        i = 60;
        localObject1 = localObject2;
        break;
      case 60: 
        localObject4[i4] = localObject1;
        j = 62;
        localObject3 = "y^\0238x0\020\004\0353\021J";
        i = 61;
        localObject1 = localObject2;
        break;
      case 61: 
        localObject4[i4] = localObject1;
        j = 63;
        localObject3 = "y^\0241g<\035\025\035uo";
        i = 62;
        localObject1 = localObject2;
        break;
      case 62: 
        localObject4[i4] = localObject1;
        j = 64;
        localObject3 = "\007\033\027=b!\033\002tf<\n\030n1>\033\tn";
        i = 63;
        localObject1 = localObject2;
        break;
      case 63: 
        localObject4[i4] = localObject1;
        j = 65;
        localObject3 = "y\f\025317\013\003=0\r\003n";
        i = 64;
        localObject1 = localObject2;
        break;
      case 64: 
        localObject4[i4] = localObject1;
        j = 66;
        localObject3 = "\007\033\027=b!\033\002tb \035\0231t1^]t{ \027\024n";
        i = 65;
        localObject1 = localObject2;
        break;
      case 65: 
        localObject4[i4] = localObject1;
        j = 67;
        localObject3 = "\022\033\004tb<\rP=3\021P'd6\035\0251uu\t\031 yu\026\037'eo^";
        i = 66;
        localObject1 = localObject2;
        break;
      case 66: 
        localObject4[i4] = localObject1;
        j = 68;
        localObject3 = "\020\006\0231a!\027\037:1\"\026\025:16\022\037'tu\013\024$1&\021\023?t!^]t";
        i = 67;
        localObject1 = localObject2;
        break;
      case 67: 
        localObject4[i4] = localObject1;
        j = 69;
        localObject3 = "y^\0031}0\035\004=~;D";
        i = 68;
        localObject1 = localObject2;
        break;
      case 68: 
        localObject4[i4] = localObject1;
        j = 70;
        localObject3 = "\0067#tC0\035\025=g0\032P\007e'\027\0363+u";
        i = 69;
        localObject1 = localObject2;
        break;
      case 69: 
        localObject4[i4] = localObject1;
        j = 71;
        localObject3 = "\001\021P3t!^\003=buSP<~&\nJ";
        i = 70;
        localObject1 = localObject2;
        break;
      case 70: 
        localObject4[i4] = localObject1;
        j = 72;
        localObject3 = "\0067#tC0\035\025=g<\020\027z?{";
        i = 71;
        localObject1 = localObject2;
        break;
      case 71: 
        localObject4[i4] = localObject1;
        j = 73;
        localObject3 = "\023\037\0318t1^\004;1'\033\003;}#\033P<~&\nP0&^]t";
        i = 72;
        localObject1 = localObject2;
        break;
      case 72: 
        localObject4[i4] = localObject1;
        j = 74;
        localObject3 = "\022\033\004tb<\rP=3\021P1c'\021\002t<u\r\031'Y:\r\004n";
        i = 73;
        localObject1 = localObject2;
        break;
      case 73: 
        localObject4[i4] = localObject1;
        j = 75;
        localObject3 = "\021\021P:~!^\0361t1^#\035Bu\037\0275x;^\007=e=\027\036t\"u\023\031:b{^%'tu\022\021'eu\031\037;uu\r\031'1'\033\003$~;\r\025z1";
        i = 74;
        localObject1 = localObject2;
        break;
      case 74: 
        localObject4[i4] = localObject1;
        j = 76;
        localObject3 = "\026\037\036t:\nP3t!^\003=bu\027\0362~u\030\002;|u\026\037'eo^";
        i = 75;
        localObject1 = localObject2;
        break;
      case 75: 
        localObject4[i4] = localObject1;
        j = 77;
        localObject3 = "6\021\036:t6\n\031;";
        i = 76;
        localObject1 = localObject2;
        break;
      case 76: 
        localObject4[i4] = localObject1;
        j = 78;
        localObject3 = "\032\016\025:16\021\036:t6\n\031;u\t\031 yu\021\000 x:\020\003t<u\027\000n";
        i = 77;
        localObject1 = localObject2;
        break;
      case 77: 
        localObject4[i4] = localObject1;
        j = 79;
        localObject3 = "\032\016\025:16\021\036:t6\n\031;u\t\031 yu\023\021=uSP=ao";
        i = 78;
        localObject1 = localObject2;
        break;
      case 78: 
        localObject4[i4] = localObject1;
        j = 80;
        localObject3 = "y^\031:u0\006J";
        i = 79;
        localObject1 = localObject2;
        break;
      case 79: 
        localObject4[i4] = localObject1;
        j = 81;
        localObject3 = "\023\037\0318t1^\007=e=^\0218}u\035\037:&P";
        i = 80;
        localObject1 = localObject2;
        break;
      case 80: 
        localObject4[i4] = localObject1;
        j = 82;
        localObject3 = "\034\020\0065}<\032P9p<\020P7~;\020";
        i = 81;
        localObject1 = localObject2;
        break;
      case 81: 
        localObject4[i4] = localObject1;
        j = 83;
        localObject3 = "\032\016\025:16\021\036:t6\n\031;u\t\031 yu\022\021'eu\031\037;uuSP=ao";
        i = 82;
        localObject1 = localObject2;
        break;
      case 82: 
        localObject4[i4] = localObject1;
        j = 84;
        localObject3 = "\024\035\004=~;DP't!,\0047E::\021-E<\023\025'F=\033\036\006t2\027\003 t'8\021=}0\032";
        i = 83;
        localObject1 = localObject2;
      }
    }
    localObject4[i4] = localObject1;
    z = (String[])localObject2;
    localObject3 = new ArrayList();
    a = (List)localObject3;
    localObject1 = "&P\032$d&\026^7".toCharArray();
    j = localObject1.length;
    int m = 0;
    i = 0;
    localObject2 = localObject1;
    int k = j;
    if (j <= 1) {}
    label2621:
    label2737:
    do
    {
      m = i;
      k = i;
      localObject2 = localObject1;
      n = localObject2[k];
      switch (m % 5)
      {
      default: 
        i = 17;
      }
      for (;;)
      {
        localObject2[k] = ((char)(i ^ n));
        m += 1;
        if (j != 0) {
          break label2737;
        }
        k = j;
        break label2621;
        i = 85;
        break;
        i = 126;
        break;
        i = 112;
        break;
        i = 84;
        break;
        i = 85;
        continue;
        i = 126;
        continue;
        i = 112;
        continue;
        i = 84;
      }
      k = j;
      localObject2 = localObject1;
      localObject1 = localObject2;
      j = k;
      i = m;
    } while (k > m);
    ((List)localObject3).add(new String((char[])localObject2).intern());
    localObject1 = a;
    localObject2 = "&\027\003z{%\013\003<?<\021";
    i = -1;
    for (;;)
    {
      localObject5 = ((String)localObject2).toCharArray();
      j = localObject5.length;
      n = 0;
      k = 0;
      i2 = i;
      localObject2 = localObject5;
      localObject3 = localObject1;
      m = j;
      if (j <= 1)
      {
        localObject4 = localObject1;
        localObject1 = localObject5;
        i1 = i;
      }
      label2925:
      do
      {
        m = k;
        localObject2 = localObject1;
        n = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 17;
        }
        for (;;)
        {
          localObject2[k] = ((char)(i ^ n));
          m += 1;
          if (j != 0) {
            break label2925;
          }
          k = j;
          break;
          i = 85;
          continue;
          i = 126;
          continue;
          i = 112;
          continue;
          i = 84;
        }
        n = m;
        m = j;
        localObject3 = localObject4;
        localObject2 = localObject1;
        i2 = i1;
        i1 = i2;
        localObject1 = localObject2;
        localObject4 = localObject3;
        j = m;
        k = n;
      } while (m > n);
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        ((List)localObject3).add(localObject1);
        localObject1 = a;
        localObject2 = "0\037\003-e:\023\025'b4\031\025zr:\023";
        i = 0;
        break;
      case 0: 
        ((List)localObject3).add(localObject1);
        localObject1 = a;
        localObject2 = "dOCz\"dPAc?dNH";
        i = 1;
      }
    }
    ((List)localObject3).add(localObject1);
  }
  
  private static int a(g paramg, long paramLong)
  {
    k = 0;
    j = 0;
    localObject2 = null;
    str = null;
    try
    {
      localIterator = cn.jiguang.c.c.f.a(z[17]).iterator();
      i = -1;
    }
    catch (Exception localException1)
    {
      try
      {
        InetAddress localInetAddress;
        do
        {
          do
          {
            Iterator localIterator;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = str;
            k = j;
            localObject3 = (p)localIterator.next();
            localObject2 = str;
            k = j;
          } while (TextUtils.isEmpty(((p)localObject3).i().toString()));
          localObject2 = str;
          k = j;
          localInetAddress = InetAddress.getByName(((p)localObject3).i().toString());
        } while (localInetAddress == null);
        localObject2 = str;
        k = j;
        str = localInetAddress.getHostAddress();
        localObject2 = str;
        k = j;
        j = ((p)localObject3).h();
        localObject2 = str;
        k = j;
        cn.jiguang.d.d.c(z[1], z[18] + str + z[20] + j);
        localObject2 = str;
        k = j;
        if ((h.a(str)) || (j == 0)) {
          break label476;
        }
        localObject2 = str;
        k = j;
        m = a(paramg, paramLong, str, j);
        i = m;
        if (i == 0) {
          break label469;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i;
          int n;
          Object localObject3;
          int m;
          Object localObject1;
          continue;
          k = j;
        }
      }
      localException1 = localException1;
      i = -1;
      cn.jiguang.d.d.c(z[1], z[15]);
      m = k;
      localObject3 = localObject2;
      n = i;
      i = n;
      localObject1 = localObject3;
      k = m;
      j = i;
      if (i == 0) {
        break label400;
      }
      localObject1 = cn.jiguang.c.a.a.n();
      k = cn.jiguang.c.a.a.o();
      cn.jiguang.d.d.d(z[1], z[16] + (String)localObject1 + z[20] + k);
      if ((!h.a((String)localObject1)) && (k != 0)) {
        break label389;
      }
      cn.jiguang.d.d.d(z[1], z[14]);
      i = -1;
      do
      {
        return i;
        j = a(paramg, paramLong, (String)localObject1, k);
        i = j;
      } while (j != 0);
      cn.jiguang.c.a.a.a((String)localObject1);
      cn.jiguang.c.a.a.a(k);
      cn.jiguang.d.d.f(z[1], z[19] + (String)localObject1 + z[20] + k);
      return j;
    }
    n = i;
    localObject3 = str;
    m = j;
    localObject2 = str;
    k = j;
  }
  
  private static int a(g paramg, long paramLong, String paramString, int paramInt)
  {
    if (paramg.b())
    {
      cn.jiguang.d.d.g(z[1], z[45]);
      paramInt = 64545;
    }
    int i;
    do
    {
      return paramInt;
      i = Protocol.InitPush(paramLong, paramString, paramInt);
      paramInt = i;
    } while (i == 0);
    if (paramg.b())
    {
      cn.jiguang.d.d.a(z[1], z[44] + i);
      return i;
    }
    cn.jiguang.d.d.d(z[1], z[44] + i);
    return i;
  }
  
  public static cn.jiguang.c.b.j a(Context paramContext)
  {
    try
    {
      paramContext = a(paramContext, false, 0, 19000);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  private static cn.jiguang.c.b.j a(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 343	cn/jiguang/f/j:a	(Landroid/content/Context;)Ljava/lang/String;
    //   4: invokestatic 345	cn/jiguang/c/a/a:b	(Ljava/lang/String;)Z
    //   7: istore 5
    //   9: iload_1
    //   10: ifne +35 -> 45
    //   13: iload 5
    //   15: ifne +30 -> 45
    //   18: invokestatic 348	cn/jiguang/c/a/a:e	()Z
    //   21: ifne +24 -> 45
    //   24: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   27: iconst_1
    //   28: aaload
    //   29: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   32: bipush 75
    //   34: aaload
    //   35: invokestatic 350	cn/jiguang/d/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: invokestatic 353	cn/jiguang/c/a/a:q	()Ljava/lang/String;
    //   41: invokestatic 356	cn/jiguang/c/d/b:a	(Ljava/lang/String;)Lcn/jiguang/c/b/j;
    //   44: areturn
    //   45: ldc_w 358
    //   48: astore 9
    //   50: aconst_null
    //   51: astore 8
    //   53: new 360	java/net/DatagramSocket
    //   56: dup
    //   57: invokespecial 361	java/net/DatagramSocket:<init>	()V
    //   60: astore 6
    //   62: aload 6
    //   64: astore 7
    //   66: sipush 1024
    //   69: newarray <illegal type>
    //   71: astore 11
    //   73: aload 6
    //   75: astore 7
    //   77: getstatic 203	cn/jiguang/c/d/b:a	Ljava/util/List;
    //   80: iload_2
    //   81: invokeinterface 365 2 0
    //   86: checkcast 13	java/lang/String
    //   89: astore 8
    //   91: aload 6
    //   93: astore 7
    //   95: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   98: iconst_1
    //   99: aaload
    //   100: new 272	java/lang/StringBuilder
    //   103: dup
    //   104: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   107: bipush 71
    //   109: aaload
    //   110: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: aload 8
    //   115: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   121: bipush 20
    //   123: aaload
    //   124: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: iload_3
    //   128: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   134: bipush 69
    //   136: aaload
    //   137: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload_2
    //   141: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 308	cn/jiguang/d/d:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: iload_2
    //   151: iconst_2
    //   152: if_icmpgt +120 -> 272
    //   155: aload 6
    //   157: astore 7
    //   159: aload 8
    //   161: invokestatic 367	cn/jiguang/c/d/b:b	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   164: astore 10
    //   166: aload 10
    //   168: astore 9
    //   170: aload 10
    //   172: ifnonnull +111 -> 283
    //   175: aload 6
    //   177: astore 7
    //   179: new 221	java/lang/Exception
    //   182: dup
    //   183: new 272	java/lang/StringBuilder
    //   186: dup
    //   187: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   190: bipush 73
    //   192: aaload
    //   193: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   196: aload 8
    //   198: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokespecial 368	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   207: athrow
    //   208: astore 7
    //   210: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   213: iconst_1
    //   214: aaload
    //   215: new 272	java/lang/StringBuilder
    //   218: dup
    //   219: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   222: bipush 74
    //   224: aaload
    //   225: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: aload 8
    //   230: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: aload 7
    //   238: invokestatic 371	cn/jiguang/d/d:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: iload_2
    //   242: iconst_1
    //   243: iadd
    //   244: istore 4
    //   246: iload 4
    //   248: istore_2
    //   249: aload 6
    //   251: ifnull +11 -> 262
    //   254: aload 6
    //   256: invokevirtual 374	java/net/DatagramSocket:close	()V
    //   259: iload 4
    //   261: istore_2
    //   262: iload_2
    //   263: iconst_4
    //   264: if_icmpge +540 -> 804
    //   267: iconst_1
    //   268: istore_1
    //   269: goto -269 -> 0
    //   272: aload 6
    //   274: astore 7
    //   276: aload 8
    //   278: invokestatic 263	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   281: astore 9
    //   283: aload 6
    //   285: astore 7
    //   287: new 376	java/net/DatagramPacket
    //   290: dup
    //   291: aload_0
    //   292: getstatic 381	cn/jiguang/c/a:f	Ljava/lang/String;
    //   295: invokestatic 385	cn/jiguang/c/a/a:r	()J
    //   298: invokestatic 388	cn/jiguang/c/d/b:a	(Landroid/content/Context;Ljava/lang/String;J)[B
    //   301: sipush 128
    //   304: aload 9
    //   306: iload_3
    //   307: invokespecial 391	java/net/DatagramPacket:<init>	([BILjava/net/InetAddress;I)V
    //   310: astore 9
    //   312: aload 6
    //   314: astore 7
    //   316: aload 6
    //   318: sipush 6000
    //   321: invokevirtual 394	java/net/DatagramSocket:setSoTimeout	(I)V
    //   324: aload 6
    //   326: astore 7
    //   328: aload 6
    //   330: aload 9
    //   332: invokevirtual 398	java/net/DatagramSocket:send	(Ljava/net/DatagramPacket;)V
    //   335: aload 6
    //   337: astore 7
    //   339: new 376	java/net/DatagramPacket
    //   342: dup
    //   343: aload 11
    //   345: sipush 1024
    //   348: invokespecial 401	java/net/DatagramPacket:<init>	([BI)V
    //   351: astore 9
    //   353: aload 6
    //   355: astore 7
    //   357: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   360: iconst_1
    //   361: aaload
    //   362: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   365: bipush 72
    //   367: aaload
    //   368: invokestatic 308	cn/jiguang/d/d:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload 6
    //   373: astore 7
    //   375: aload 6
    //   377: aload 9
    //   379: invokevirtual 404	java/net/DatagramSocket:receive	(Ljava/net/DatagramPacket;)V
    //   382: aload 6
    //   384: astore 7
    //   386: aload 9
    //   388: invokevirtual 407	java/net/DatagramPacket:getLength	()I
    //   391: newarray <illegal type>
    //   393: astore 10
    //   395: aload 6
    //   397: astore 7
    //   399: aload 9
    //   401: invokevirtual 411	java/net/DatagramPacket:getData	()[B
    //   404: iconst_0
    //   405: aload 10
    //   407: iconst_0
    //   408: aload 10
    //   410: arraylength
    //   411: invokestatic 417	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   414: aload 6
    //   416: astore 7
    //   418: new 13	java/lang/String
    //   421: dup
    //   422: aload 10
    //   424: invokespecial 420	java/lang/String:<init>	([B)V
    //   427: astore 9
    //   429: aload 6
    //   431: astore 7
    //   433: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   436: iconst_1
    //   437: aaload
    //   438: new 272	java/lang/StringBuilder
    //   441: dup
    //   442: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   445: bipush 70
    //   447: aaload
    //   448: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   451: aload 9
    //   453: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 350	cn/jiguang/d/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: aload 6
    //   464: astore 7
    //   466: aload 9
    //   468: invokestatic 356	cn/jiguang/c/d/b:a	(Ljava/lang/String;)Lcn/jiguang/c/b/j;
    //   471: astore 9
    //   473: aload 9
    //   475: ifnull +56 -> 531
    //   478: aload 6
    //   480: astore 7
    //   482: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   485: iconst_1
    //   486: aaload
    //   487: new 272	java/lang/StringBuilder
    //   490: dup
    //   491: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   494: bipush 67
    //   496: aaload
    //   497: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   500: aload 8
    //   502: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 316	cn/jiguang/d/d:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: aload 6
    //   513: astore 7
    //   515: invokestatic 422	cn/jiguang/c/a/a:f	()V
    //   518: aload 6
    //   520: ifnull +8 -> 528
    //   523: aload 6
    //   525: invokevirtual 374	java/net/DatagramSocket:close	()V
    //   528: aload 9
    //   530: areturn
    //   531: aload 6
    //   533: astore 7
    //   535: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   538: iconst_1
    //   539: aaload
    //   540: new 272	java/lang/StringBuilder
    //   543: dup
    //   544: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   547: bipush 76
    //   549: aaload
    //   550: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   553: aload 8
    //   555: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 424	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: goto -46 -> 518
    //   567: astore 7
    //   569: aload 8
    //   571: astore 9
    //   573: aload 7
    //   575: astore 8
    //   577: aload 6
    //   579: astore 7
    //   581: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   584: iconst_1
    //   585: aaload
    //   586: new 272	java/lang/StringBuilder
    //   589: dup
    //   590: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   593: bipush 74
    //   595: aaload
    //   596: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   599: aload 9
    //   601: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: aload 8
    //   609: invokestatic 371	cn/jiguang/d/d:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   612: iload_2
    //   613: iconst_1
    //   614: iadd
    //   615: istore 4
    //   617: iload 4
    //   619: istore_2
    //   620: aload 6
    //   622: ifnull -360 -> 262
    //   625: aload 6
    //   627: invokevirtual 374	java/net/DatagramSocket:close	()V
    //   630: iload 4
    //   632: istore_2
    //   633: goto -371 -> 262
    //   636: astore 6
    //   638: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   641: iconst_1
    //   642: aaload
    //   643: new 272	java/lang/StringBuilder
    //   646: dup
    //   647: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   650: bipush 68
    //   652: aaload
    //   653: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   656: aload 6
    //   658: invokevirtual 425	java/lang/AssertionError:toString	()Ljava/lang/String;
    //   661: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokestatic 427	cn/jiguang/d/d:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   670: iload 4
    //   672: istore_2
    //   673: goto -411 -> 262
    //   676: astore_0
    //   677: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   680: iconst_1
    //   681: aaload
    //   682: new 272	java/lang/StringBuilder
    //   685: dup
    //   686: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   689: bipush 68
    //   691: aaload
    //   692: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   695: aload_0
    //   696: invokevirtual 425	java/lang/AssertionError:toString	()Ljava/lang/String;
    //   699: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 427	cn/jiguang/d/d:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   708: goto -180 -> 528
    //   711: astore 6
    //   713: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   716: iconst_1
    //   717: aaload
    //   718: new 272	java/lang/StringBuilder
    //   721: dup
    //   722: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   725: bipush 68
    //   727: aaload
    //   728: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   731: aload 6
    //   733: invokevirtual 425	java/lang/AssertionError:toString	()Ljava/lang/String;
    //   736: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokestatic 427	cn/jiguang/d/d:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   745: iload 4
    //   747: istore_2
    //   748: goto -486 -> 262
    //   751: astore_0
    //   752: aconst_null
    //   753: astore 7
    //   755: aload 7
    //   757: ifnull +8 -> 765
    //   760: aload 7
    //   762: invokevirtual 374	java/net/DatagramSocket:close	()V
    //   765: aload_0
    //   766: athrow
    //   767: astore 6
    //   769: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   772: iconst_1
    //   773: aaload
    //   774: new 272	java/lang/StringBuilder
    //   777: dup
    //   778: getstatic 197	cn/jiguang/c/d/b:z	[Ljava/lang/String;
    //   781: bipush 68
    //   783: aaload
    //   784: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   787: aload 6
    //   789: invokevirtual 425	java/lang/AssertionError:toString	()Ljava/lang/String;
    //   792: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 427	cn/jiguang/d/d:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: goto -36 -> 765
    //   804: aconst_null
    //   805: areturn
    //   806: astore_0
    //   807: goto -52 -> 755
    //   810: astore_0
    //   811: aload 6
    //   813: astore 7
    //   815: goto -60 -> 755
    //   818: astore 8
    //   820: aconst_null
    //   821: astore 6
    //   823: goto -246 -> 577
    //   826: astore 8
    //   828: goto -251 -> 577
    //   831: astore 7
    //   833: ldc_w 358
    //   836: astore 9
    //   838: aload 8
    //   840: astore 6
    //   842: aload 9
    //   844: astore 8
    //   846: goto -636 -> 210
    //   849: astore 7
    //   851: ldc_w 358
    //   854: astore 8
    //   856: goto -646 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	859	0	paramContext	Context
    //   0	859	1	paramBoolean	boolean
    //   0	859	2	paramInt1	int
    //   0	859	3	paramInt2	int
    //   244	502	4	i	int
    //   7	7	5	bool	boolean
    //   60	566	6	localDatagramSocket1	java.net.DatagramSocket
    //   636	21	6	localAssertionError1	AssertionError
    //   711	21	6	localAssertionError2	AssertionError
    //   767	45	6	localAssertionError3	AssertionError
    //   821	20	6	localException1	Exception
    //   64	114	7	localDatagramSocket2	java.net.DatagramSocket
    //   208	29	7	localAssertionError4	AssertionError
    //   274	260	7	localDatagramSocket3	java.net.DatagramSocket
    //   567	7	7	localException2	Exception
    //   579	235	7	localObject1	Object
    //   831	1	7	localAssertionError5	AssertionError
    //   849	1	7	localAssertionError6	AssertionError
    //   51	557	8	localObject2	Object
    //   818	1	8	localException3	Exception
    //   826	13	8	localException4	Exception
    //   844	11	8	localObject3	Object
    //   48	795	9	localObject4	Object
    //   164	259	10	localObject5	Object
    //   71	273	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   95	150	208	java/lang/AssertionError
    //   159	166	208	java/lang/AssertionError
    //   179	208	208	java/lang/AssertionError
    //   276	283	208	java/lang/AssertionError
    //   287	312	208	java/lang/AssertionError
    //   316	324	208	java/lang/AssertionError
    //   328	335	208	java/lang/AssertionError
    //   339	353	208	java/lang/AssertionError
    //   357	371	208	java/lang/AssertionError
    //   375	382	208	java/lang/AssertionError
    //   386	395	208	java/lang/AssertionError
    //   399	414	208	java/lang/AssertionError
    //   418	429	208	java/lang/AssertionError
    //   433	462	208	java/lang/AssertionError
    //   466	473	208	java/lang/AssertionError
    //   482	511	208	java/lang/AssertionError
    //   515	518	208	java/lang/AssertionError
    //   535	564	208	java/lang/AssertionError
    //   95	150	567	java/lang/Exception
    //   159	166	567	java/lang/Exception
    //   179	208	567	java/lang/Exception
    //   276	283	567	java/lang/Exception
    //   287	312	567	java/lang/Exception
    //   316	324	567	java/lang/Exception
    //   328	335	567	java/lang/Exception
    //   339	353	567	java/lang/Exception
    //   357	371	567	java/lang/Exception
    //   375	382	567	java/lang/Exception
    //   386	395	567	java/lang/Exception
    //   399	414	567	java/lang/Exception
    //   418	429	567	java/lang/Exception
    //   433	462	567	java/lang/Exception
    //   466	473	567	java/lang/Exception
    //   482	511	567	java/lang/Exception
    //   515	518	567	java/lang/Exception
    //   535	564	567	java/lang/Exception
    //   625	630	636	java/lang/AssertionError
    //   523	528	676	java/lang/AssertionError
    //   254	259	711	java/lang/AssertionError
    //   53	62	751	finally
    //   760	765	767	java/lang/AssertionError
    //   66	73	806	finally
    //   77	91	806	finally
    //   95	150	806	finally
    //   159	166	806	finally
    //   179	208	806	finally
    //   276	283	806	finally
    //   287	312	806	finally
    //   316	324	806	finally
    //   328	335	806	finally
    //   339	353	806	finally
    //   357	371	806	finally
    //   375	382	806	finally
    //   386	395	806	finally
    //   399	414	806	finally
    //   418	429	806	finally
    //   433	462	806	finally
    //   466	473	806	finally
    //   482	511	806	finally
    //   515	518	806	finally
    //   535	564	806	finally
    //   581	612	806	finally
    //   210	241	810	finally
    //   53	62	818	java/lang/Exception
    //   66	73	826	java/lang/Exception
    //   77	91	826	java/lang/Exception
    //   53	62	831	java/lang/AssertionError
    //   66	73	849	java/lang/AssertionError
    //   77	91	849	java/lang/AssertionError
  }
  
  private static cn.jiguang.c.b.j a(String paramString)
  {
    try
    {
      cn.jiguang.c.b.j localj = new cn.jiguang.c.b.j();
      localj.a(paramString);
      localj.b(paramString);
      boolean bool = localj.e();
      if (!bool) {
        return localj;
      }
    }
    catch (Exception paramString)
    {
      cn.jiguang.d.d.d(z[1], z[43], paramString);
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      cn.jiguang.d.d.j(z[1], z[8] + paramInt);
      String str = cn.jiguang.f.f.a(paramInt);
      if (!TextUtils.isEmpty(str)) {
        cn.jiguang.d.d.h(z[1], z[2] + str);
      }
    }
    if (1006 == paramInt)
    {
      cn.jiguang.f.a.a(paramContext, z[3] + cn.jiguang.c.a.c + z[7], -1);
      c();
      return;
    }
    if (1007 == paramInt)
    {
      cn.jiguang.d.d.e(z[1], z[9]);
      return;
    }
    if (1005 == paramInt)
    {
      cn.jiguang.f.a.a(paramContext, z[3] + cn.jiguang.c.a.c + z[12] + cn.jiguang.c.a.f + z[10], -1);
      c();
      return;
    }
    if (1009 == paramInt)
    {
      cn.jiguang.f.a.a(paramContext, z[13] + cn.jiguang.c.a.f + z[4], -1);
      c();
      return;
    }
    if (1008 == paramInt)
    {
      cn.jiguang.f.a.a(paramContext, z[13] + cn.jiguang.c.a.f + z[11], -1);
      return;
    }
    if (10001 == paramInt)
    {
      cn.jiguang.f.a.a(paramContext, z[6], -1);
      return;
    }
    cn.jiguang.d.d.e(z[1], z[5] + paramInt);
  }
  
  public static void a(Context paramContext, cn.jiguang.c.b.a parama)
  {
    cn.jiguang.d.d.d(z[1], z[51]);
    if (parama == cn.jiguang.c.a.a.c(paramContext))
    {
      cn.jiguang.d.d.a(z[1], z[50] + parama);
      return;
    }
    cn.jiguang.c.a.a.a(paramContext, parama);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean(z[48], parama.name().equals(z[47]));
    cn.jiguang.f.a.a(paramContext, z[49], localBundle);
  }
  
  public static void a(Message paramMessage, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong(z[77], paramLong);
    paramMessage.setData(localBundle);
    paramMessage.sendToTarget();
  }
  
  public static boolean a()
  {
    return cn.jiguang.c.a.a.m();
  }
  
  public static boolean a(Context paramContext, long paramLong)
  {
    Object localObject1 = new byte[''];
    Object localObject2 = cn.jiguang.c.f.b.e().a();
    Object localObject3 = cn.jiguang.c.f.b.e().d();
    String str1 = cn.jiguang.c.f.b.e().b();
    String str2 = cn.jiguang.c.f.b.e().c();
    int i = d.a().d();
    cn.jiguang.d.d.c(z[1], z[64] + (String)localObject2 + z[54] + (String)localObject3 + z[62] + str1 + z[59] + str2 + z[65] + i);
    long l = cn.jiguang.c.a.a.i();
    int j = Math.abs(new Random().nextInt());
    cn.jiguang.c.f.a.a.a(j);
    OutputDataUtil localOutputDataUtil = new OutputDataUtil(20480);
    localOutputDataUtil.writeU16(0);
    localOutputDataUtil.writeU8(13);
    localOutputDataUtil.writeU8(0);
    localOutputDataUtil.writeU64(l);
    localOutputDataUtil.writeU32(j);
    localOutputDataUtil.writeU64(0L);
    localOutputDataUtil.writeByteArrayincludeLength(((String)localObject2).getBytes());
    localOutputDataUtil.writeByteArrayincludeLength(((String)localObject3).getBytes());
    localOutputDataUtil.writeByteArrayincludeLength(str1.getBytes());
    localOutputDataUtil.writeU8(0);
    localOutputDataUtil.writeByteArrayincludeLength(str2.getBytes());
    d.a().e();
    localOutputDataUtil.writeU8(i);
    localOutputDataUtil.writeU16At(localOutputDataUtil.current(), 0);
    localObject2 = cn.jiguang.c.e.a.a.b.a(localOutputDataUtil.toByteArray(), 0);
    if (localObject2 == null) {
      return false;
    }
    if (Protocol.SendData(paramLong, (byte[])localObject2, 0) == 64545) {
      return false;
    }
    i = Protocol.RecvPush(paramLong, (byte[])localObject1, 30);
    if (i > 0)
    {
      localObject1 = cn.jiguang.c.e.a.a.a.a((byte[])localObject1);
      if (localObject1 == null)
      {
        cn.jiguang.d.d.i(z[1], z[52]);
        return false;
      }
      cn.jiguang.d.d.c(z[1], ((JResponse)localObject1).toString());
      if (((JResponse)localObject1).getCommand() != 0)
      {
        cn.jiguang.d.d.i(z[1], z[55]);
        return false;
      }
      localObject3 = (cn.jiguang.c.e.a.d)localObject1;
      i = ((cn.jiguang.c.e.a.d)localObject3).code;
      cn.jiguang.c.a.a.a(paramContext, i);
      e.a().b(i);
      if (i == 0)
      {
        paramLong = ((cn.jiguang.c.e.a.d)localObject3).getJuid();
        localObject1 = ((cn.jiguang.c.e.a.d)localObject3).a();
        localObject2 = ((cn.jiguang.c.e.a.d)localObject3).b();
        localObject3 = ((cn.jiguang.c.e.a.d)localObject3).c();
        cn.jiguang.d.d.f(z[1], z[66] + paramLong + z[56] + (String)localObject2 + z[63] + (String)localObject3);
        cn.jiguang.d.d.a(z[1], z[58] + (String)localObject1);
        if ((h.a((String)localObject2)) || (0L == paramLong)) {
          cn.jiguang.d.d.j(z[1], z[61]);
        }
        cn.jiguang.f.a.g(paramContext, (String)localObject3);
        cn.jiguang.c.a.a.a(paramLong, (String)localObject1, (String)localObject2, (String)localObject3, cn.jiguang.c.a.f);
        cn.jiguang.c.a.g = paramLong;
        cn.jiguang.c.a.h = (String)localObject1;
        cn.jiguang.f.a.a(paramContext, z[57], z[53], (String)localObject2);
        return true;
      }
      a(paramContext, i, true);
    }
    for (;;)
    {
      return false;
      cn.jiguang.d.d.j(z[1], z[60] + i);
    }
  }
  
  public static boolean a(g paramg, long paramLong, cn.jiguang.c.b.j paramj)
  {
    if (paramj == null) {}
    for (;;)
    {
      int j;
      try
      {
        paramj = cn.jiguang.c.a.a.c();
        int i = cn.jiguang.c.a.a.d();
        if (paramj != null)
        {
          cn.jiguang.d.d.d(z[1], z[83] + paramj + z[20] + i);
          i = a(paramg, paramLong, paramj, i);
          if (i == 0)
          {
            bool = true;
            return bool;
          }
        }
        if (a(paramg, paramLong) != 0) {
          break label471;
        }
        bool = true;
        continue;
        String str2 = paramj.a();
        int n = paramj.b();
        cn.jiguang.d.d.d(z[1], z[79] + str2 + z[20] + n);
        int k;
        String str1;
        if ((str2 == null) || (n == 0))
        {
          j = -1;
          cn.jiguang.d.d.h(z[1], z[82]);
          i = j;
          k = n;
          str1 = str2;
          if (j != 0)
          {
            Iterator localIterator = paramj.c().iterator();
            int m = 0;
            str1 = str2;
            k = n;
            i = j;
            if (localIterator.hasNext())
            {
              str1 = (String)localIterator.next();
              k = ((Integer)paramj.d().get(m)).intValue();
              cn.jiguang.d.d.d(z[1], z[78] + str1 + z[20] + k + z[80] + m);
              i = a(paramg, paramLong, str1, k);
              if (i == 0) {
                break label477;
              }
              m += 1;
              continue;
            }
          }
        }
        else
        {
          j = a(paramg, paramLong, str2, n);
          continue;
        }
        if (i == 0)
        {
          cn.jiguang.c.a.a.a(str1);
          cn.jiguang.c.a.a.a(k);
          cn.jiguang.d.d.f(z[1], z[19] + str1 + z[20] + k);
          bool = true;
          continue;
        }
        j = i;
        if (i == 0) {
          break label480;
        }
        j = a(paramg, paramLong);
      }
      finally {}
      cn.jiguang.d.d.h(z[1], z[81]);
      boolean bool = false;
      continue;
      label471:
      bool = false;
      continue;
      label477:
      continue;
      label480:
      if (j == 0) {
        bool = true;
      }
    }
  }
  
  private static byte[] a(Context paramContext, String paramString, long paramLong)
  {
    String str = cn.jiguang.f.a.c(paramContext);
    paramContext = (TelephonyManager)paramContext.getSystemService(z[21]);
    try
    {
      paramContext = paramContext.getNetworkOperator();
      localObject = d.a().b();
      str = (String)localObject + str;
    }
    catch (Exception paramContext)
    {
      try
      {
        i = Integer.valueOf(paramContext).intValue();
        Object localObject = new byte[''];
        System.arraycopy(new byte[] { 0, -128 }, 0, localObject, 0, 2);
        ProtocolUtil.fillStringData((byte[])localObject, str, 2);
        ProtocolUtil.fillIntData((byte[])localObject, i, 34);
        ProtocolUtil.fillIntData((byte[])localObject, Integer.parseInt((int)(0x7FFFFFFF & paramLong)), 38);
        paramContext = paramString;
        if (paramString.length() > 50) {
          paramContext = paramString.substring(0, 49);
        }
        ProtocolUtil.fillStringData((byte[])localObject, paramContext, 42);
        ProtocolUtil.fillStringData((byte[])localObject, z[22], 92);
        ProtocolUtil.fillIntData((byte[])localObject, 0, 102);
        return (byte[])localObject;
        paramContext = paramContext;
        paramContext.printStackTrace();
        paramContext = "";
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
  }
  
  public static int b(Context paramContext, long paramLong)
  {
    Object localObject1 = new byte[''];
    long l2 = cn.jiguang.c.a.a.r();
    Object localObject2 = h.b(cn.jiguang.c.a.a.u());
    String str = cn.jiguang.c.a.a.y();
    int i = 0;
    int j = 0;
    int k = 0;
    a.a();
    Object localObject3 = a.c(SdkType.JPUSH.name(), "");
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      i = cn.jiguang.f.a.c((String)localObject3);
    }
    a.a();
    localObject3 = a.c(SdkType.JANALYTICS.name(), "");
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      j = cn.jiguang.f.a.c((String)localObject3);
    }
    a.a();
    localObject3 = a.c(SdkType.JSHARE.name(), "");
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      k = cn.jiguang.f.a.c((String)localObject3);
    }
    cn.jiguang.d.d.f(z[1], z[27] + l2 + z[40] + str + z[25] + i + z[35] + j + z[32] + k);
    long l1 = System.currentTimeMillis();
    int m = d.a().e();
    cn.jiguang.d.d.c(z[1], z[24] + l2 + z[23] + m);
    long l3 = cn.jiguang.c.a.a.i();
    long l4 = i;
    long l5 = j;
    long l6 = k;
    localObject3 = new OutputDataUtil(20480);
    ((OutputDataUtil)localObject3).writeU16(0);
    ((OutputDataUtil)localObject3).writeU8(15);
    ((OutputDataUtil)localObject3).writeU8(1);
    ((OutputDataUtil)localObject3).writeU64(l3);
    ((OutputDataUtil)localObject3).writeU32(0L);
    ((OutputDataUtil)localObject3).writeU64(l2);
    ((OutputDataUtil)localObject3).writeByteArray(z[33].getBytes());
    ((OutputDataUtil)localObject3).writeByteArrayincludeLength(((String)localObject2).getBytes());
    ((OutputDataUtil)localObject3).writeU32(l4);
    ((OutputDataUtil)localObject3).writeU32(l5);
    ((OutputDataUtil)localObject3).writeU32(l6);
    ((OutputDataUtil)localObject3).writeByteArrayincludeLength(str.getBytes());
    ((OutputDataUtil)localObject3).writeU8(0);
    ((OutputDataUtil)localObject3).writeU8(m);
    ((OutputDataUtil)localObject3).writeU16At(((OutputDataUtil)localObject3).current(), 0);
    localObject2 = cn.jiguang.c.e.a.a.b.a(((OutputDataUtil)localObject3).toByteArray(), 1);
    if ((localObject2 == null) || (localObject2.length <= 0)) {
      return -1;
    }
    j = Protocol.LogPush(paramLong, (byte[])localObject1, (byte[])localObject2, 0);
    paramLong = System.currentTimeMillis();
    if ((j == 0) || (j == 9999))
    {
      localObject2 = cn.jiguang.c.e.a.a.a.a((byte[])localObject1);
      localObject1 = null;
      if ((localObject2 instanceof cn.jiguang.c.e.a.c)) {
        localObject1 = (cn.jiguang.c.e.a.c)localObject2;
      }
      if (localObject1 == null)
      {
        cn.jiguang.d.d.h(z[1], z[38] + j + z[30]);
        cn.jiguang.c.f.c.a(paramContext, j, paramLong - l1, 1);
        return -1;
      }
      cn.jiguang.d.d.c(z[1], ((cn.jiguang.c.e.a.c)localObject1).toString());
      j = ((cn.jiguang.c.e.a.c)localObject1).code;
      e.a().a(j);
      if (j == 0)
      {
        i = ((cn.jiguang.c.e.a.c)localObject1).getSid();
        l2 = ((cn.jiguang.c.e.a.c)localObject1).a() * 1000L;
        cn.jiguang.c.a.a.c(i);
        cn.jiguang.c.a.a.b(l2);
        cn.jiguang.d.d.f(z[1], z[37] + i + z[39] + l2);
        cn.jiguang.d.d.d(z[1], z[36]);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new Bundle();
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put(z[34], l2);
        ((JSONObject)localObject2).put(z[42], System.currentTimeMillis());
        ((Bundle)localObject1).putString(z[41], ((JSONObject)localObject2).toString());
        cn.jiguang.f.a.a(paramContext, z[31], (Bundle)localObject1);
        i = 0;
      }
      catch (JSONException localJSONException)
      {
        cn.jiguang.d.d.g(z[1], z[28] + localJSONException.getMessage());
        i = 0;
        continue;
      }
      cn.jiguang.c.f.c.a(paramContext, j, paramLong - l1, i);
      return j;
      if (j == 10000)
      {
        cn.jiguang.d.d.h(z[1], z[29] + j);
        i = 1;
        j = -1;
      }
      else
      {
        cn.jiguang.d.d.h(z[1], z[26] + cn.jiguang.f.f.a(j));
        continue;
        i = 1;
        cn.jiguang.d.d.h(z[1], z[38] + j);
      }
    }
  }
  
  private static InetAddress b(String paramString)
  {
    paramString = new c(paramString);
    try
    {
      paramString.start();
      paramString.join(3000L);
      paramString = paramString.a();
      return paramString;
    }
    catch (InterruptedException paramString)
    {
      cn.jiguang.d.d.i(z[1], z[0]);
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void b()
  {
    cn.jiguang.d.d.c(z[1], z[46]);
    cn.jiguang.c.a.a.k();
  }
  
  private static void c()
  {
    cn.jiguang.d.d.c(z[1], z[84]);
    cn.jiguang.c.a.a.l();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */