package cn.jiguang.a.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import cn.jiguang.a.c.c;
import cn.jiguang.api.MultiSpHelper;
import cn.jiguang.d.d;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends Thread
{
  private static ExecutorService a;
  private static Object b;
  private static AtomicInteger c;
  private static CookieManager j;
  private static final String[] z;
  private String d;
  private String e;
  private String f;
  private Context g;
  private int h = 0;
  private String i;
  
  static
  {
    String[] arrayOfString = new String[124];
    int m = 0;
    Object localObject2 = "L\007Af";
    int k = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int n = arrayOfChar.length;
    int i3 = 0;
    int i1 = 0;
    int i5 = k;
    localObject2 = arrayOfChar;
    int i6 = m;
    Object localObject3 = localObject1;
    int i2 = n;
    Object localObject4;
    int i4;
    if (n <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i4 = k;
      label68:
      i2 = i1;
      label71:
      localObject2 = localObject1;
      i3 = localObject2[i1];
      switch (i2 % 5)
      {
      default: 
        k = 102;
      }
    }
    for (;;)
    {
      localObject2[i1] = ((char)(k ^ i3));
      i2 += 1;
      if (n == 0)
      {
        i1 = n;
        break label71;
      }
      i3 = i2;
      i2 = n;
      localObject3 = localObject4;
      i6 = m;
      localObject2 = localObject1;
      i5 = i4;
      i4 = i5;
      localObject1 = localObject2;
      m = i6;
      localObject4 = localObject3;
      n = i2;
      i1 = i3;
      if (i2 > i3) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i5)
      {
      default: 
        localObject3[i6] = localObject1;
        m = 1;
        localObject2 = "W\000@>\003K*[9\024J\034B2";
        k = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i6] = localObject1;
        m = 2;
        localObject2 = "X\005]\003\017]";
        k = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i6] = localObject1;
        m = 3;
        localObject2 = "Z\032I9";
        k = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i6] = localObject1;
        m = 4;
        localObject2 = "P\026N5\002";
        k = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i6] = localObject1;
        m = 5;
        localObject2 = "K\020^,HK\024Z";
        k = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i6] = localObject1;
        m = 6;
        localObject2 = "J\034J2";
        k = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i6] = localObject1;
        m = 7;
        localObject2 = "P\030H5";
        k = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i6] = localObject1;
        m = 8;
        localObject2 = "K\020\\\003\022P\030H";
        k = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i6] = localObject1;
        m = 9;
        localObject2 = "\031\034N?\017]O";
        k = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i6] = localObject1;
        m = 10;
        localObject2 = "J\001L(\017J\001D?IH\000H.\037\006";
        k = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i6] = localObject1;
        m = 11;
        localObject2 = "\031\006Y=\022L\006n3\002\\O";
        k = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i6] = localObject1;
        m = 12;
        localObject2 = "x\026Y5\tWU\000|\001\\\001}4\tW\020c)\013[\020_|\017T\020Df";
        k = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i6] = localObject1;
        m = 13;
        localObject2 = "\031\034@/\017\003";
        k = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i6] = localObject1;
        m = 14;
        localObject2 = "O\020_/\017V\033";
        k = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i6] = localObject1;
        m = 15;
        localObject2 = "\b[\036rV";
        k = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i6] = localObject1;
        m = 16;
        localObject2 = "W\000@";
        k = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i6] = localObject1;
        m = 17;
        localObject2 = "P\030^5";
        k = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i6] = localObject1;
        m = 18;
        localObject2 = "W\000@>\003K*L,\026P\021";
        k = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i6] = localObject1;
        m = 19;
        localObject2 = "K\020^,HC\034]";
        k = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i6] = localObject1;
        m = 20;
        localObject2 = "l!kq^";
        k = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i6] = localObject1;
        m = 21;
        localObject2 = "i\035B2\003w\000@>\003K Y5\n";
        k = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i6] = localObject1;
        m = 22;
        localObject2 = "\031\007^,\"X\001Lf";
        k = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i6] = localObject1;
        m = 23;
        localObject2 = "K\020].\tMUN3\bM\020C(\\";
        k = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i6] = localObject1;
        m = 24;
        localObject2 = "L\033H$\005\\\005Y5\tW";
        k = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i6] = localObject1;
        m = 25;
        localObject2 = "\\\033n.\026M\fn3\bM\020C(\\";
        k = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i6] = localObject1;
        m = 26;
        localObject2 = "W\000@>\003K*C)\013";
        k = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i6] = localObject1;
        m = 27;
        localObject2 = "M\f]9";
        k = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i6] = localObject1;
        m = 28;
        localObject2 = "P\001D1\003";
        k = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i6] = localObject1;
        m = 29;
        localObject2 = "W\027";
        k = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i6] = localObject1;
        m = 30;
        localObject2 = "Z\032C(\003W\001";
        k = 29;
        localObject1 = arrayOfString;
        break;
      case 29: 
        localObject3[i6] = localObject1;
        m = 31;
        localObject2 = "x\026Y3\b\031X\r3\b}\020Y?\016i\035B2\003w\000@>\003KU]4\tW\020c)\013[\020_f";
        k = 30;
        localObject1 = arrayOfString;
        break;
      case 30: 
        localObject3[i6] = localObject1;
        m = 32;
        localObject2 = "W\027r)\026U\032L8";
        k = 31;
        localObject1 = arrayOfString;
        break;
      case 31: 
        localObject3[i6] = localObject1;
        m = 33;
        localObject2 = "]\020N3\002\\%E3\b\\;X1\004\\\007\r8\003Z\007T,\022\031\021L(\007\003";
        k = 32;
        localObject1 = arrayOfString;
        break;
      case 32: 
        localObject3[i6] = localObject1;
        m = 34;
        localObject2 = "P\033[=\nP\021H|\026Q\032C9FW\000@>\003K";
        k = 33;
        localObject1 = arrayOfString;
        break;
      case 33: 
        localObject3[i6] = localObject1;
        m = 35;
        localObject2 = "X\023Y9\024\031\021H?\024@\005Y9\002\025U]4\tW\020c)\013[\020_|\017JUC)\nU";
        k = 34;
        localObject1 = arrayOfString;
        break;
      case 34: 
        localObject3[i6] = localObject1;
        m = 36;
        localObject2 = "K\020\\)\003J\001\r(\017T\020B)\022\003A\035dF\024U";
        k = 35;
        localObject1 = arrayOfString;
        break;
      case 35: 
        localObject3[i6] = localObject1;
        m = 37;
        localObject2 = "J\020_*\003KUK=\017U";
        k = 36;
        localObject1 = arrayOfString;
        break;
      case 36: 
        localObject3[i6] = localObject1;
        m = 38;
        localObject2 = "k\020\\)\003J\001\r,\007M\035\r8\t\\\006\r2\tMUH$\017J\001\027|R\tA\rqF";
        k = 37;
        localObject1 = arrayOfString;
        break;
      case 37: 
        localObject3[i6] = localObject1;
        m = 39;
        localObject2 = "\033N:\017U\020C=\013\\H\017";
        k = 38;
        localObject1 = arrayOfString;
        break;
      case 38: 
        localObject3[i6] = localObject1;
        m = 40;
        localObject2 = "\002\027B)\b]\024_%[";
        k = 39;
        localObject1 = arrayOfString;
        break;
      case 39: 
        localObject3[i6] = localObject1;
        m = 41;
        localObject2 = "\005IK=\017U\020I\003\021P\001E\003\024\\\001_5\003JK\023";
        k = 40;
        localObject1 = arrayOfString;
        break;
      case 40: 
        localObject3[i6] = localObject1;
        m = 42;
        localObject2 = "l\006H.Kx\022H2\022";
        k = 41;
        localObject1 = arrayOfString;
        break;
      case 41: 
        localObject3[i6] = localObject1;
        m = 43;
        localObject2 = "i:~\b";
        k = 42;
        localObject1 = arrayOfString;
        break;
      case 42: 
        localObject3[i6] = localObject1;
        m = 44;
        localObject2 = "j\020_*\003KUH.\024V\007\rqF";
        k = 43;
        localObject1 = arrayOfString;
        break;
      case 43: 
        localObject3[i6] = localObject1;
        m = 45;
        localObject2 = "\024X";
        k = 44;
        localObject1 = arrayOfString;
        break;
      case 44: 
        localObject3[i6] = localObject1;
        m = 46;
        localObject2 = "t\032W5\nU\024\002iH\tU\005\020\017W\000UgFx\033I.\tP\021\riH\b[\034gFw\020U)\025\031C\r\036\023P\031Is*`/\037d#\020Ul,\026U\020z9\004r\034YsS\nB\003oP\031]f\0242t9\001|\nP\036H|!\\\026F3O\0316E.\tT\020\002h^\027E\003nS\017A\003nU\0318B>\017U\020\r\017\007_\024_5I\fF\032rU\017";
        k = 45;
        localObject1 = arrayOfString;
        break;
      case 45: 
        localObject3[i6] = localObject1;
        m = 47;
        localObject2 = "Q\001Y,HR\020H,'U\034[9";
        k = 46;
        localObject1 = arrayOfString;
        break;
      case 46: 
        localObject3[i6] = localObject1;
        m = 48;
        localObject2 = "v\001E9\024\031\002_3\b^U_9\025I\032C/\003\031\006Y=\022L\006\rqF";
        k = 47;
        localObject1 = arrayOfString;
        break;
      case 47: 
        localObject3[i6] = localObject1;
        m = 49;
        localObject2 = "\005IH.\024V\007\023b";
        k = 48;
        localObject1 = arrayOfString;
        break;
      case 48: 
        localObject3[i6] = localObject1;
        m = 50;
        localObject2 = "z\024Y?\016\0314^/\003K\001D3\b|\007_3\024\031\001B|\007O\032D8FQ\001Y,FZ\031B/\003\031\026_=\025QU\000|";
        k = 49;
        localObject1 = arrayOfString;
        break;
      case 49: 
        localObject3[i6] = localObject1;
        m = 51;
        localObject2 = "u\032N=\022P\032C";
        k = 50;
        localObject1 = arrayOfString;
        break;
      case 50: 
        localObject3[i6] = localObject1;
        m = 52;
        localObject2 = "x\026Y5\tWU\000|\016M\001]\f\tJ\001k5\n\\U";
        k = 51;
        localObject1 = arrayOfString;
        break;
      case 51: 
        localObject3[i6] = localObject1;
        m = 53;
        localObject2 = "T\000A(\017I\024_(I_\032_1K]\024Y=";
        k = 52;
        localObject1 = arrayOfString;
        break;
      case 52: 
        localObject3[i6] = localObject1;
        m = 54;
        localObject2 = "j\020_*\003KU_9\025I\032C/\003\031\023L5\nL\007HfR\tE\rqF";
        k = 53;
        localObject1 = arrayOfString;
        break;
      case 53: 
        localObject3[i6] = localObject1;
        m = 55;
        localObject2 = "4";
        k = 54;
        localObject1 = arrayOfString;
        break;
      case 54: 
        localObject3[i6] = localObject1;
        m = 56;
        localObject2 = "\031UK5\n\\\033L1\003\003";
        k = 55;
        localObject1 = arrayOfString;
        break;
      case 55: 
        localObject3[i6] = localObject1;
        m = 57;
        localObject2 = "3UK5\n\\O";
        k = 56;
        localObject1 = arrayOfString;
        break;
      case 56: 
        localObject3[i6] = localObject1;
        m = 58;
        localObject2 = "Z\032C:\nP\026YfR\tL\rqF";
        k = 57;
        localObject1 = arrayOfString;
        break;
      case 57: 
        localObject3[i6] = localObject1;
        m = 59;
        localObject2 = "_\034A9\\";
        k = 58;
        localObject1 = arrayOfString;
        break;
      case 58: 
        localObject3[i6] = localObject1;
        m = 60;
        localObject2 = "W\032Y|\007Z\026H,\022X\027A9\\\rE\033|K\031";
        k = 59;
        localObject1 = arrayOfString;
        break;
      case 59: 
        localObject3[i6] = localObject1;
        m = 61;
        localObject2 = "z\032B7\017\\";
        k = 60;
        localObject1 = arrayOfString;
        break;
      case 60: 
        localObject3[i6] = localObject1;
        m = 62;
        localObject2 = "z\024Y?\016\031&~\0206\\\020_\t\bO\020_5\000P\020I\031\036Z\020](\017V\033\001|\016M\001]|\005U\034H2\022\031\020U9\005L\001H|\003K\007B.G";
        k = 61;
        localObject1 = arrayOfString;
        break;
      case 61: 
        localObject3[i6] = localObject1;
        m = 63;
        localObject2 = "K\006]\037\t]\020\027";
        k = 62;
        localObject1 = arrayOfString;
        break;
      case 62: 
        localObject3[i6] = localObject1;
        m = 64;
        localObject2 = "z\035L.\025\\\001";
        k = 63;
        localObject1 = arrayOfString;
        break;
      case 63: 
        localObject3[i6] = localObject1;
        m = 65;
        localObject2 = "l\033H$\026\\\026Y9\002\003U^9\024O\020_|\024\\\006]3\bJ\020I|(l9a";
        k = 64;
        localObject1 = arrayOfString;
        break;
      case 64: 
        localObject3[i6] = localObject1;
        m = 66;
        localObject2 = "z\032C(\003W\001\000\b\037I\020";
        k = 65;
        localObject1 = arrayOfString;
        break;
      case 65: 
        localObject3[i6] = localObject1;
        m = 67;
        localObject2 = "L\007A/\\";
        k = 66;
        localObject1 = arrayOfString;
        break;
      case 66: 
        localObject3[i6] = localObject1;
        m = 68;
        localObject2 = "I\024_/\003\031\020C(\017M\f\r9\024K\032_";
        k = 67;
        localObject1 = arrayOfString;
        break;
      case 67: 
        localObject3[i6] = localObject1;
        m = 69;
        localObject2 = "z\032C(\003W\001\000\030\017J\005B/\017M\034B2\\\023B.\013\024\021L(\007\002ÕC=\013\\H\017";
        k = 68;
        localObject1 = arrayOfString;
        break;
      case 68: 
        localObject3[i6] = localObject1;
        m = 70;
        localObject2 = "\031\036H%\025\\\001\027";
        k = 69;
        localObject1 = arrayOfString;
        break;
      case 69: 
        localObject3[i6] = localObject1;
        m = 71;
        localObject2 = "U\032N=\022P\032Cf";
        k = 70;
        localObject1 = arrayOfString;
        break;
      case 70: 
        localObject3[i6] = localObject1;
        m = 72;
        localObject2 = "z\032C(\003W\001\000\b\037I\020\027ü\007I\005A5\005X\001D3\b\026\032N(\003MX^(\024\\\024@gÆZ\035L.\025\\\001\020\t2X\025";
        k = 71;
        localObject1 = arrayOfString;
        break;
      case 71: 
        localObject3[i6] = localObject1;
        m = 73;
        localObject2 = "Q\001Y,FZ\031D9\bMUH$\003Z\000Y9F\\\007_3\024";
        k = 72;
        localObject1 = arrayOfString;
        break;
      case 72: 
        localObject3[i6] = localObject1;
        m = 74;
        localObject2 = "_\024A/\003";
        k = 73;
        localObject1 = arrayOfString;
        break;
      case 73: 
        localObject3[i6] = localObject1;
        m = 75;
        localObject2 = "k\020\\)\003J\001\r2\tMUL)\022Q\032_5\034\\\021\027hV\bU\000|";
        k = 74;
        localObject1 = arrayOfString;
        break;
      case 74: 
        localObject3[i6] = localObject1;
        m = 76;
        localObject2 = "\025UX.\n\003";
        k = 75;
        localObject1 = arrayOfString;
        break;
      case 75: 
        localObject3[i6] = localObject1;
        m = 77;
        localObject2 = "\031\034^\b\003T\005B.\007K\f9\002P\007H?\022\003";
        k = 76;
        localObject1 = arrayOfString;
        break;
      case 76: 
        localObject3[i6] = localObject1;
        m = 78;
        localObject2 = "K\020Yf";
        k = 77;
        localObject1 = arrayOfString;
        break;
      case 77: 
        localObject3[i6] = localObject1;
        m = 79;
        localObject2 = "Z\032C(\003A\001\r5\025\031\033X0\n";
        k = 78;
        localObject1 = arrayOfString;
        break;
      case 78: 
        localObject3[i6] = localObject1;
        m = 80;
        localObject2 = "X\005]\017\003Z\007H(\\";
        k = 79;
        localObject1 = arrayOfString;
        break;
      case 79: 
        localObject3[i6] = localObject1;
        m = 81;
        localObject2 = "J\034J2\\";
        k = 80;
        localObject1 = arrayOfString;
        break;
      case 80: 
        localObject3[i6] = localObject1;
        m = 82;
        localObject2 = "M\007H9+X\005\r5\025\031\033X0\n";
        k = 81;
        localObject1 = arrayOfString;
        break;
      case 81: 
        localObject3[i6] = localObject1;
        m = 83;
        localObject2 = "M\007H9+X\005{=\nL\020\027";
        k = 82;
        localObject1 = arrayOfString;
        break;
      case 82: 
        localObject3[i6] = localObject1;
        m = 84;
        localObject2 = "L\007A|\017JUH1\026M\f";
        k = 83;
        localObject1 = arrayOfString;
        break;
      case 83: 
        localObject3[i6] = localObject1;
        m = 85;
        localObject2 = "K\020^,9]\024Y=";
        k = 84;
        localObject1 = arrayOfString;
        break;
      case 84: 
        localObject3[i6] = localObject1;
        m = 86;
        localObject2 = "x\026Y5\tWU\000|\001\\\001}4\tW\020c)\013[\020_\013\017M\035l2\007U\f^5\025l\007A|\023K\031\027";
        k = 85;
        localObject1 = arrayOfString;
        break;
      case 85: 
        localObject3[i6] = localObject1;
        m = 87;
        localObject2 = "l\033H$\026\\\026Y9\002\031X\r:\007P\031H8FM\032\r\035#jUI9\005K\f](H\\O";
        k = 86;
        localObject1 = arrayOfString;
        break;
      case 86: 
        localObject3[i6] = localObject1;
        m = 88;
        localObject2 = "z\035D2\007m\020A9\005V\030";
        k = 87;
        localObject1 = arrayOfString;
        break;
      case 87: 
        localObject3[i6] = localObject1;
        m = 89;
        localObject2 = "z\035D2\007t\032O5\n\\";
        k = 88;
        localObject1 = arrayOfString;
        break;
      case 88: 
        localObject3[i6] = localObject1;
        m = 90;
        localObject2 = "z\035D2\007l\033D?\tT";
        k = 89;
        localObject1 = arrayOfString;
        break;
      case 89: 
        localObject3[i6] = localObject1;
        m = 91;
        localObject2 = "x\026Y5\tWU\000|\nV\024I\f\016V\033H\022\023T\027H.";
        k = 90;
        localObject1 = arrayOfString;
        break;
      case 90: 
        localObject3[i6] = localObject1;
        m = 92;
        localObject2 = "T\032_9FM\035L2FV\033H|\nV\024I|\026Q\032C9\bL\030O9\024\031\001E.\003X\021\r5\025\031\007X2\bP\033J";
        k = 91;
        localObject1 = arrayOfString;
        break;
      case 91: 
        localObject3[i6] = localObject1;
        m = 93;
        localObject2 = "\025U";
        k = 92;
        localObject1 = arrayOfString;
        break;
      case 92: 
        localObject3[i6] = localObject1;
        m = 94;
        localObject2 = "Z\032C(\003A\001\r8\017]UC3\022\031\034C5\022\025U_9\022L\007C";
        k = 93;
        localObject1 = arrayOfString;
        break;
      case 93: 
        localObject3[i6] = localObject1;
        m = 95;
        localObject2 = "dU\001|\001P\003H|\023IU^=\020\\U\027";
        k = 94;
        localObject1 = arrayOfString;
        break;
      case 94: 
        localObject3[i6] = localObject1;
        m = 96;
        localObject2 = "\034A9\026X\001E|\003K\007B.FV\023\r\007";
        k = 95;
        localObject1 = arrayOfString;
        break;
      case 95: 
        localObject3[i6] = localObject1;
        m = 97;
        localObject2 = "4 V";
        k = 96;
        localObject1 = arrayOfString;
        break;
      case 96: 
        localObject3[i6] = localObject1;
        m = 98;
        localObject2 = "\031\032X(\026L\001~(\024\\\024@pF^\034[9FL\005\r/\007O\020\rf";
        k = 97;
        localObject1 = arrayOfString;
        break;
      case 97: 
        localObject3[i6] = localObject1;
        m = 99;
        localObject2 = "Z\024C{\022\031\002_5\022\\U";
        k = 98;
        localObject1 = arrayOfString;
        break;
      case 98: 
        localObject3[i6] = localObject1;
        m = 100;
        localObject2 = "Z\024C{\022\031\032]9\b\031";
        k = 99;
        localObject1 = arrayOfString;
        break;
      case 99: 
        localObject3[i6] = localObject1;
        m = 101;
        localObject2 = "J\024[9FU\032J|\017WUZ.\017M\020e5\025M\032_%*V\022\027V";
        k = 100;
        localObject1 = arrayOfString;
        break;
      case 100: 
        localObject3[i6] = localObject1;
        m = 102;
        localObject2 = "\031Y\r;\017O\020\r)\026\031\006L*\003\031O";
        k = 101;
        localObject1 = arrayOfString;
        break;
      case 101: 
        localObject3[i6] = localObject1;
        m = 103;
        localObject2 = "Z\024C{\022\031\020C?\t]\034C;F";
        k = 102;
        localObject1 = arrayOfString;
        break;
      case 102: 
        localObject3[i6] = localObject1;
        m = 104;
        localObject2 = "J\024[9FU\032J|\017WUZ.\017M\020e5\025M\032_%*V\022";
        k = 103;
        localObject1 = arrayOfString;
        break;
      case 103: 
        localObject3[i6] = localObject1;
        m = 105;
        localObject2 = "\003U";
        k = 104;
        localObject1 = arrayOfString;
        break;
      case 104: 
        localObject3[i6] = localObject1;
        m = 106;
        localObject2 = "W\000@>\003K*X.\n";
        k = 105;
        localObject1 = arrayOfString;
        break;
      case 105: 
        localObject3[i6] = localObject1;
        m = 107;
        localObject2 = "Q\001Y,\\\026Z\034dT\027L\037rT\t[\034d_\003L\035e_\026";
        k = 106;
        localObject1 = arrayOfString;
        break;
      case 106: 
        localObject3[i6] = localObject1;
        m = 108;
        localObject2 = "[\024^9FL\007Af";
        k = 107;
        localObject1 = arrayOfString;
        break;
      case 107: 
        localObject3[i6] = localObject1;
        m = 109;
        localObject2 = "I\007B*\017]\020_//W\021H$\\";
        k = 108;
        localObject1 = arrayOfString;
        break;
      case 108: 
        localObject3[i6] = localObject1;
        m = 110;
        localObject2 = "\rC\035lW";
        k = 109;
        localObject1 = arrayOfString;
        break;
      case 109: 
        localObject3[i6] = localObject1;
        m = 111;
        localObject2 = "X\031A|\026X\007L1FP\006\r5\bO\024A5\002\\";
        k = 110;
        localObject1 = arrayOfString;
        break;
      case 110: 
        localObject3[i6] = localObject1;
        m = 112;
        localObject2 = "\rC\035l^";
        k = 111;
        localObject1 = arrayOfString;
        break;
      case 111: 
        localObject3[i6] = localObject1;
        m = 113;
        localObject2 = "\rC\035lU";
        k = 112;
        localObject1 = arrayOfString;
        break;
      case 112: 
        localObject3[i6] = localObject1;
        m = 114;
        localObject2 = "\rC\035lQ";
        k = 113;
        localObject1 = arrayOfString;
        break;
      case 113: 
        localObject3[i6] = localObject1;
        m = 115;
        localObject2 = "\rC\035lT";
        k = 114;
        localObject1 = arrayOfString;
        break;
      case 114: 
        localObject3[i6] = localObject1;
        m = 116;
        localObject2 = "J\024@9FN\034Y4FU\024^(\003]UL?\005\\\006^|\023K\031";
        k = 115;
        localObject1 = arrayOfString;
        break;
      case 115: 
        localObject3[i6] = localObject1;
        m = 117;
        localObject2 = "\rC\035lS";
        k = 116;
        localObject1 = arrayOfString;
        break;
      case 116: 
        localObject3[i6] = localObject1;
        m = 118;
        localObject2 = "\rC\035l_";
        k = 117;
        localObject1 = arrayOfString;
        break;
      case 117: 
        localObject3[i6] = localObject1;
        m = 119;
        localObject2 = "W\027r0\007J\001Y5\013\\";
        k = 118;
        localObject1 = arrayOfString;
        break;
      case 118: 
        localObject3[i6] = localObject1;
        m = 120;
        localObject2 = "\rC\035lP";
        k = 119;
        localObject1 = arrayOfString;
        break;
      case 119: 
        localObject3[i6] = localObject1;
        m = 121;
        localObject2 = "\rC\035mW";
        k = 120;
        localObject1 = arrayOfString;
        break;
      case 120: 
        localObject3[i6] = localObject1;
        m = 122;
        localObject2 = "\rC\035lV";
        k = 121;
        localObject1 = arrayOfString;
        break;
      case 121: 
        localObject3[i6] = localObject1;
        m = 123;
        localObject2 = "j\020Yq%V\032F5\003";
        k = 122;
        localObject1 = arrayOfString;
        break;
      case 122: 
        localObject3[i6] = localObject1;
        z = arrayOfString;
        a = Executors.newSingleThreadExecutor();
        b = new Object();
        c = new AtomicInteger();
        return;
        k = 57;
        continue;
        k = 117;
        continue;
        k = 45;
        continue;
        k = 92;
      }
    }
  }
  
  private g() {}
  
  private g(Context paramContext)
  {
    String str1 = cn.jiguang.f.a.e(paramContext, this.d);
    String str2 = cn.jiguang.f.a.d(paramContext, this.e);
    String str3 = cn.jiguang.f.a.f(paramContext, this.f);
    CookieManager localCookieManager = new CookieManager();
    j = localCookieManager;
    localCookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
    CookieHandler.setDefault(j);
    this.g = paramContext;
    this.d = str1;
    this.e = str2;
    this.f = str3;
  }
  
  public static int a(String paramString)
  {
    if (cn.jiguang.f.h.a(paramString)) {}
    do
    {
      return -1;
      if (paramString.equalsIgnoreCase(z[88])) {
        return 2;
      }
      if (paramString.equalsIgnoreCase(z[89])) {
        return 0;
      }
    } while (!paramString.equalsIgnoreCase(z[90]));
    return 1;
  }
  
  /* Error */
  private h a(Context paramContext, String paramString1, int paramInt, long paramLong, boolean paramBoolean, File paramFile, String paramString2)
  {
    // Byte code:
    //   0: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   3: bipush 21
    //   5: aaload
    //   6: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   9: bipush 52
    //   11: aaload
    //   12: invokestatic 376	cn/jiguang/d/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   18: bipush 21
    //   20: aaload
    //   21: astore 15
    //   23: new 378	java/lang/StringBuilder
    //   26: dup
    //   27: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   30: bipush 67
    //   32: aaload
    //   33: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_2
    //   37: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   43: bipush 57
    //   45: aaload
    //   46: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: astore 16
    //   51: aload 7
    //   53: ifnull +927 -> 980
    //   56: aload 7
    //   58: invokevirtual 390	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   61: astore 14
    //   63: aload 16
    //   65: aload 14
    //   67: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   73: bipush 70
    //   75: aaload
    //   76: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 8
    //   81: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   87: bipush 56
    //   89: aaload
    //   90: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: astore 16
    //   95: aload 7
    //   97: ifnull +890 -> 987
    //   100: aload 7
    //   102: invokevirtual 396	java/io/File:getName	()Ljava/lang/String;
    //   105: astore 14
    //   107: aload 15
    //   109: aload 16
    //   111: aload 14
    //   113: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   116: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   119: bipush 77
    //   121: aaload
    //   122: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: iload 6
    //   127: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   130: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 376	cn/jiguang/d/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: lload 4
    //   138: ldc2_w 403
    //   141: lcmp
    //   142: iflt +16 -> 158
    //   145: lload 4
    //   147: lstore 12
    //   149: lload 4
    //   151: ldc2_w 405
    //   154: lcmp
    //   155: ifle +8 -> 163
    //   158: ldc2_w 407
    //   161: lstore 12
    //   163: invokestatic 414	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   166: invokevirtual 415	java/util/UUID:toString	()Ljava/lang/String;
    //   169: astore 20
    //   171: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   174: bipush 45
    //   176: aaload
    //   177: astore 21
    //   179: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   182: bipush 55
    //   184: aaload
    //   185: astore 22
    //   187: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   190: bipush 53
    //   192: aaload
    //   193: astore 23
    //   195: aconst_null
    //   196: astore 15
    //   198: aconst_null
    //   199: astore 16
    //   201: iconst_m1
    //   202: istore 9
    //   204: getstatic 333	cn/jiguang/a/a/b/g:j	Ljava/net/CookieManager;
    //   207: ifnonnull +13 -> 220
    //   210: new 330	java/net/CookieManager
    //   213: dup
    //   214: invokespecial 331	java/net/CookieManager:<init>	()V
    //   217: putstatic 333	cn/jiguang/a/a/b/g:j	Ljava/net/CookieManager;
    //   220: iconst_0
    //   221: istore 11
    //   223: aconst_null
    //   224: astore 14
    //   226: aload_1
    //   227: aload_2
    //   228: invokestatic 421	cn/jiguang/net/HttpUtils:getHttpURLConnectionWithProxy	(Landroid/content/Context;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   231: astore 17
    //   233: aload 17
    //   235: astore 14
    //   237: aload 15
    //   239: astore 19
    //   241: aload 14
    //   243: astore 18
    //   245: aload 14
    //   247: sipush 30000
    //   250: invokevirtual 427	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   253: aload 15
    //   255: astore 19
    //   257: aload 14
    //   259: astore 18
    //   261: aload 14
    //   263: sipush 30000
    //   266: invokevirtual 430	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   269: aload 15
    //   271: astore 19
    //   273: aload 14
    //   275: astore 18
    //   277: aload 14
    //   279: iconst_1
    //   280: invokevirtual 434	java/net/HttpURLConnection:setDoInput	(Z)V
    //   283: aload 15
    //   285: astore 19
    //   287: aload 14
    //   289: astore 18
    //   291: aload 14
    //   293: iconst_1
    //   294: invokevirtual 437	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   297: aload 15
    //   299: astore 19
    //   301: aload 14
    //   303: astore 18
    //   305: aload 14
    //   307: iconst_0
    //   308: invokevirtual 440	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   311: aload 15
    //   313: astore 19
    //   315: aload 14
    //   317: astore 18
    //   319: aload 14
    //   321: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   324: bipush 43
    //   326: aaload
    //   327: invokevirtual 443	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   330: aload 15
    //   332: astore 19
    //   334: aload 14
    //   336: astore 18
    //   338: aload 14
    //   340: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   343: bipush 64
    //   345: aaload
    //   346: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   349: bipush 20
    //   351: aaload
    //   352: invokevirtual 446	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload 15
    //   357: astore 19
    //   359: aload 14
    //   361: astore 18
    //   363: aload 14
    //   365: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   368: bipush 42
    //   370: aaload
    //   371: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   374: bipush 46
    //   376: aaload
    //   377: invokevirtual 449	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: aload 15
    //   382: astore 19
    //   384: aload 14
    //   386: astore 18
    //   388: getstatic 454	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   391: invokestatic 459	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   394: bipush 8
    //   396: if_icmpge +27 -> 423
    //   399: aload 15
    //   401: astore 19
    //   403: aload 14
    //   405: astore 18
    //   407: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   410: bipush 47
    //   412: aaload
    //   413: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   416: bipush 74
    //   418: aaload
    //   419: invokestatic 465	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   422: pop
    //   423: aload 15
    //   425: astore 19
    //   427: aload 14
    //   429: astore 18
    //   431: getstatic 333	cn/jiguang/a/a/b/g:j	Ljava/net/CookieManager;
    //   434: invokevirtual 469	java/net/CookieManager:getCookieStore	()Ljava/net/CookieStore;
    //   437: invokeinterface 475 1 0
    //   442: invokeinterface 481 1 0
    //   447: ifle +39 -> 486
    //   450: aload 15
    //   452: astore 19
    //   454: aload 14
    //   456: astore 18
    //   458: aload 14
    //   460: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   463: bipush 61
    //   465: aaload
    //   466: ldc_w 483
    //   469: getstatic 333	cn/jiguang/a/a/b/g:j	Ljava/net/CookieManager;
    //   472: invokevirtual 469	java/net/CookieManager:getCookieStore	()Ljava/net/CookieStore;
    //   475: invokeinterface 475 1 0
    //   480: invokestatic 489	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   483: invokevirtual 446	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: aload 15
    //   488: astore 19
    //   490: aload 14
    //   492: astore 18
    //   494: aload 14
    //   496: iload 6
    //   498: invokevirtual 492	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   501: aload 15
    //   503: astore 19
    //   505: aload 14
    //   507: astore 18
    //   509: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   512: bipush 21
    //   514: aaload
    //   515: new 378	java/lang/StringBuilder
    //   518: dup
    //   519: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   522: bipush 59
    //   524: aaload
    //   525: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   528: aload 7
    //   530: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   533: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 376	cn/jiguang/d/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: aload 7
    //   541: ifnull +556 -> 1097
    //   544: aload 15
    //   546: astore 19
    //   548: aload 14
    //   550: astore 18
    //   552: aload 14
    //   554: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   557: bipush 66
    //   559: aaload
    //   560: new 378	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 493	java/lang/StringBuilder:<init>	()V
    //   567: aload 23
    //   569: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   575: bipush 40
    //   577: aaload
    //   578: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 20
    //   583: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokevirtual 446	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   592: aload 15
    //   594: astore 19
    //   596: aload 14
    //   598: astore 18
    //   600: new 495	java/io/DataOutputStream
    //   603: dup
    //   604: aload 14
    //   606: invokevirtual 499	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   609: invokespecial 502	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   612: astore 17
    //   614: aload 15
    //   616: astore 19
    //   618: aload 14
    //   620: astore 18
    //   622: new 504	java/lang/StringBuffer
    //   625: dup
    //   626: invokespecial 505	java/lang/StringBuffer:<init>	()V
    //   629: astore 24
    //   631: aload 15
    //   633: astore 19
    //   635: aload 14
    //   637: astore 18
    //   639: aload 24
    //   641: aload 21
    //   643: invokevirtual 508	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   646: pop
    //   647: aload 15
    //   649: astore 19
    //   651: aload 14
    //   653: astore 18
    //   655: aload 24
    //   657: aload 20
    //   659: invokevirtual 508	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   662: pop
    //   663: aload 15
    //   665: astore 19
    //   667: aload 14
    //   669: astore 18
    //   671: aload 24
    //   673: aload 22
    //   675: invokevirtual 508	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   678: pop
    //   679: aload 15
    //   681: astore 19
    //   683: aload 14
    //   685: astore 18
    //   687: aload 24
    //   689: new 378	java/lang/StringBuilder
    //   692: dup
    //   693: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   696: bipush 69
    //   698: aaload
    //   699: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   702: aload 8
    //   704: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   710: bipush 39
    //   712: aaload
    //   713: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: aload 7
    //   718: invokevirtual 396	java/io/File:getName	()Ljava/lang/String;
    //   721: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: ldc_w 510
    //   727: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: aload 22
    //   732: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokevirtual 508	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   741: pop
    //   742: aload 15
    //   744: astore 19
    //   746: aload 14
    //   748: astore 18
    //   750: aload 24
    //   752: new 378	java/lang/StringBuilder
    //   755: dup
    //   756: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   759: bipush 72
    //   761: aaload
    //   762: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   765: aload 22
    //   767: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokevirtual 508	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   776: pop
    //   777: aload 15
    //   779: astore 19
    //   781: aload 14
    //   783: astore 18
    //   785: aload 24
    //   787: aload 22
    //   789: invokevirtual 508	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   792: pop
    //   793: aload 15
    //   795: astore 19
    //   797: aload 14
    //   799: astore 18
    //   801: aload 17
    //   803: aload 24
    //   805: invokevirtual 511	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   808: invokevirtual 515	java/lang/String:getBytes	()[B
    //   811: invokevirtual 519	java/io/DataOutputStream:write	([B)V
    //   814: aload 15
    //   816: astore 19
    //   818: aload 14
    //   820: astore 18
    //   822: new 521	java/io/FileInputStream
    //   825: dup
    //   826: aload 7
    //   828: invokespecial 524	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   831: astore 24
    //   833: aload 15
    //   835: astore 19
    //   837: aload 14
    //   839: astore 18
    //   841: sipush 1024
    //   844: newarray <illegal type>
    //   846: astore 25
    //   848: aload 15
    //   850: astore 19
    //   852: aload 14
    //   854: astore 18
    //   856: aload 24
    //   858: aload 25
    //   860: invokevirtual 530	java/io/InputStream:read	([B)I
    //   863: istore 10
    //   865: iload 10
    //   867: iconst_m1
    //   868: if_icmpeq +126 -> 994
    //   871: aload 15
    //   873: astore 19
    //   875: aload 14
    //   877: astore 18
    //   879: aload 17
    //   881: aload 25
    //   883: iconst_0
    //   884: iload 10
    //   886: invokevirtual 533	java/io/DataOutputStream:write	([BII)V
    //   889: goto -41 -> 848
    //   892: astore 17
    //   894: aload 15
    //   896: astore 17
    //   898: aload 14
    //   900: astore 15
    //   902: aload 17
    //   904: astore 14
    //   906: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   909: bipush 21
    //   911: aaload
    //   912: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   915: bipush 62
    //   917: aaload
    //   918: invokestatic 535	cn/jiguang/d/d:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   921: aload 14
    //   923: ifnull +8 -> 931
    //   926: aload 14
    //   928: invokevirtual 538	java/io/InputStream:close	()V
    //   931: aload 15
    //   933: ifnull +1489 -> 2422
    //   936: aload 15
    //   938: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   941: aload 14
    //   943: astore 17
    //   945: aload 15
    //   947: astore 14
    //   949: aload 17
    //   951: astore 15
    //   953: iload 9
    //   955: sipush 404
    //   958: if_icmpeq +18 -> 976
    //   961: iload 9
    //   963: sipush 200
    //   966: if_icmpeq +789 -> 1755
    //   969: aload_1
    //   970: invokestatic 544	cn/jiguang/f/a:b	(Landroid/content/Context;)Z
    //   973: ifne +782 -> 1755
    //   976: aconst_null
    //   977: astore_2
    //   978: aload_2
    //   979: areturn
    //   980: aload 7
    //   982: astore 14
    //   984: goto -921 -> 63
    //   987: aload 7
    //   989: astore 14
    //   991: goto -884 -> 107
    //   994: aload 15
    //   996: astore 19
    //   998: aload 14
    //   1000: astore 18
    //   1002: aload 24
    //   1004: invokevirtual 538	java/io/InputStream:close	()V
    //   1007: aload 15
    //   1009: astore 19
    //   1011: aload 14
    //   1013: astore 18
    //   1015: aload 17
    //   1017: aload 22
    //   1019: invokevirtual 515	java/lang/String:getBytes	()[B
    //   1022: invokevirtual 519	java/io/DataOutputStream:write	([B)V
    //   1025: aload 15
    //   1027: astore 19
    //   1029: aload 14
    //   1031: astore 18
    //   1033: aload 17
    //   1035: new 378	java/lang/StringBuilder
    //   1038: dup
    //   1039: invokespecial 493	java/lang/StringBuilder:<init>	()V
    //   1042: aload 21
    //   1044: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: aload 20
    //   1049: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: aload 21
    //   1054: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: aload 22
    //   1059: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1065: invokevirtual 515	java/lang/String:getBytes	()[B
    //   1068: invokevirtual 519	java/io/DataOutputStream:write	([B)V
    //   1071: aload 15
    //   1073: astore 19
    //   1075: aload 14
    //   1077: astore 18
    //   1079: aload 17
    //   1081: invokevirtual 547	java/io/DataOutputStream:flush	()V
    //   1084: aload 15
    //   1086: astore 19
    //   1088: aload 14
    //   1090: astore 18
    //   1092: aload 17
    //   1094: invokevirtual 548	java/io/DataOutputStream:close	()V
    //   1097: aload 15
    //   1099: astore 19
    //   1101: aload 14
    //   1103: astore 18
    //   1105: aload 14
    //   1107: invokevirtual 551	java/net/HttpURLConnection:getResponseCode	()I
    //   1110: istore 10
    //   1112: iload 10
    //   1114: istore 9
    //   1116: aload 15
    //   1118: astore 19
    //   1120: aload 14
    //   1122: astore 18
    //   1124: aload 14
    //   1126: invokevirtual 555	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   1129: invokestatic 558	cn/jiguang/a/a/b/g:a	(Ljava/util/Map;)V
    //   1132: aload 15
    //   1134: astore 19
    //   1136: aload 14
    //   1138: astore 18
    //   1140: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1143: bipush 21
    //   1145: aaload
    //   1146: new 378	java/lang/StringBuilder
    //   1149: dup
    //   1150: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1153: bipush 63
    //   1155: aaload
    //   1156: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1159: iload 9
    //   1161: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1164: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1167: invokestatic 376	cn/jiguang/d/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1170: iload 9
    //   1172: sipush 302
    //   1175: if_icmpne +156 -> 1331
    //   1178: aload 15
    //   1180: astore 19
    //   1182: aload 14
    //   1184: astore 18
    //   1186: aload 14
    //   1188: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1191: bipush 51
    //   1193: aaload
    //   1194: invokevirtual 565	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1197: astore 17
    //   1199: aload 15
    //   1201: astore 19
    //   1203: aload 14
    //   1205: astore 18
    //   1207: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1210: bipush 21
    //   1212: aaload
    //   1213: new 378	java/lang/StringBuilder
    //   1216: dup
    //   1217: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1220: bipush 71
    //   1222: aaload
    //   1223: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1226: aload 17
    //   1228: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1234: invokestatic 376	cn/jiguang/d/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1237: iload_3
    //   1238: iflt +63 -> 1301
    //   1241: aload 15
    //   1243: astore 19
    //   1245: aload 14
    //   1247: astore 18
    //   1249: aload_0
    //   1250: aload_1
    //   1251: aload 17
    //   1253: iload_3
    //   1254: iconst_1
    //   1255: isub
    //   1256: lconst_0
    //   1257: iload 6
    //   1259: aconst_null
    //   1260: aconst_null
    //   1261: invokespecial 567	cn/jiguang/a/a/b/g:a	(Landroid/content/Context;Ljava/lang/String;IJZLjava/io/File;Ljava/lang/String;)Lcn/jiguang/a/a/b/h;
    //   1264: astore 17
    //   1266: aload 17
    //   1268: astore_1
    //   1269: aload 15
    //   1271: ifnull +8 -> 1279
    //   1274: aload 15
    //   1276: invokevirtual 538	java/io/InputStream:close	()V
    //   1279: aload_1
    //   1280: astore_2
    //   1281: aload 14
    //   1283: ifnull -305 -> 978
    //   1286: aload 14
    //   1288: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   1291: aload_1
    //   1292: areturn
    //   1293: astore_2
    //   1294: aload_2
    //   1295: invokevirtual 570	java/io/IOException:printStackTrace	()V
    //   1298: goto -19 -> 1279
    //   1301: aload 15
    //   1303: ifnull +8 -> 1311
    //   1306: aload 15
    //   1308: invokevirtual 538	java/io/InputStream:close	()V
    //   1311: aload 14
    //   1313: ifnull +8 -> 1321
    //   1316: aload 14
    //   1318: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   1321: aconst_null
    //   1322: areturn
    //   1323: astore_1
    //   1324: aload_1
    //   1325: invokevirtual 570	java/io/IOException:printStackTrace	()V
    //   1328: goto -17 -> 1311
    //   1331: iload 9
    //   1333: sipush 200
    //   1336: if_icmpne +133 -> 1469
    //   1339: aload 15
    //   1341: astore 19
    //   1343: aload 14
    //   1345: astore 18
    //   1347: aload 14
    //   1349: invokevirtual 574	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1352: astore 17
    //   1354: aload 14
    //   1356: invokevirtual 555	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   1359: astore 15
    //   1361: new 27	java/lang/String
    //   1364: dup
    //   1365: aload 17
    //   1367: invokestatic 579	cn/jiguang/f/g:a	(Ljava/io/InputStream;)[B
    //   1370: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1373: bipush 20
    //   1375: aaload
    //   1376: invokespecial 582	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1379: astore 16
    //   1381: aload 17
    //   1383: ifnull +8 -> 1391
    //   1386: aload 17
    //   1388: invokevirtual 538	java/io/InputStream:close	()V
    //   1391: aload 14
    //   1393: ifnull +8 -> 1401
    //   1396: aload 14
    //   1398: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   1401: iload 9
    //   1403: sipush 200
    //   1406: if_icmplt +418 -> 1824
    //   1409: iload 9
    //   1411: sipush 300
    //   1414: if_icmpge +410 -> 1824
    //   1417: aload 16
    //   1419: astore_1
    //   1420: aload 16
    //   1422: ifnonnull +26 -> 1448
    //   1425: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1428: bipush 21
    //   1430: aaload
    //   1431: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1434: bipush 65
    //   1436: aaload
    //   1437: aconst_null
    //   1438: invokestatic 585	cn/jiguang/d/d:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1441: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1444: bipush 49
    //   1446: aaload
    //   1447: astore_1
    //   1448: new 587	cn/jiguang/a/a/b/h
    //   1451: dup
    //   1452: iload 9
    //   1454: aload 15
    //   1456: aload_1
    //   1457: invokespecial 590	cn/jiguang/a/a/b/h:<init>	(ILjava/util/Map;Ljava/lang/String;)V
    //   1460: areturn
    //   1461: astore_1
    //   1462: aload_1
    //   1463: invokevirtual 570	java/io/IOException:printStackTrace	()V
    //   1466: goto -75 -> 1391
    //   1469: aload 15
    //   1471: ifnull +8 -> 1479
    //   1474: aload 15
    //   1476: invokevirtual 538	java/io/InputStream:close	()V
    //   1479: iload 9
    //   1481: istore 10
    //   1483: aload 16
    //   1485: astore 18
    //   1487: aload 15
    //   1489: astore 17
    //   1491: aload 14
    //   1493: astore 19
    //   1495: aload 14
    //   1497: ifnull +906 -> 2403
    //   1500: aload 14
    //   1502: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   1505: goto -552 -> 953
    //   1508: astore 17
    //   1510: aload 17
    //   1512: invokevirtual 570	java/io/IOException:printStackTrace	()V
    //   1515: goto -36 -> 1479
    //   1518: astore 17
    //   1520: aload 17
    //   1522: invokevirtual 570	java/io/IOException:printStackTrace	()V
    //   1525: goto -594 -> 931
    //   1528: astore 18
    //   1530: aload 15
    //   1532: astore 16
    //   1534: aload 17
    //   1536: astore 15
    //   1538: aload 18
    //   1540: astore 17
    //   1542: aload 15
    //   1544: astore 19
    //   1546: aload 14
    //   1548: astore 18
    //   1550: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1553: bipush 21
    //   1555: aaload
    //   1556: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1559: bipush 73
    //   1561: aaload
    //   1562: aload 17
    //   1564: invokestatic 585	cn/jiguang/d/d:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1567: aload 15
    //   1569: ifnull +8 -> 1577
    //   1572: aload 15
    //   1574: invokevirtual 538	java/io/InputStream:close	()V
    //   1577: iload 9
    //   1579: istore 10
    //   1581: aload 16
    //   1583: astore 18
    //   1585: aload 15
    //   1587: astore 17
    //   1589: aload 14
    //   1591: astore 19
    //   1593: aload 14
    //   1595: ifnull +808 -> 2403
    //   1598: aload 14
    //   1600: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   1603: goto -650 -> 953
    //   1606: astore 17
    //   1608: aload 17
    //   1610: invokevirtual 570	java/io/IOException:printStackTrace	()V
    //   1613: goto -36 -> 1577
    //   1616: astore 18
    //   1618: aload 15
    //   1620: astore 16
    //   1622: aload 17
    //   1624: astore 15
    //   1626: aload 18
    //   1628: astore 17
    //   1630: aload 15
    //   1632: astore 19
    //   1634: aload 14
    //   1636: astore 18
    //   1638: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1641: bipush 21
    //   1643: aaload
    //   1644: new 378	java/lang/StringBuilder
    //   1647: dup
    //   1648: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1651: bipush 50
    //   1653: aaload
    //   1654: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1657: aload 17
    //   1659: invokevirtual 591	java/lang/AssertionError:toString	()Ljava/lang/String;
    //   1662: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1668: invokestatic 535	cn/jiguang/d/d:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1671: aload 15
    //   1673: ifnull +8 -> 1681
    //   1676: aload 15
    //   1678: invokevirtual 538	java/io/InputStream:close	()V
    //   1681: iload 9
    //   1683: istore 10
    //   1685: aload 16
    //   1687: astore 18
    //   1689: aload 15
    //   1691: astore 17
    //   1693: aload 14
    //   1695: astore 19
    //   1697: aload 14
    //   1699: ifnull +704 -> 2403
    //   1702: aload 14
    //   1704: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   1707: goto -754 -> 953
    //   1710: astore 17
    //   1712: aload 17
    //   1714: invokevirtual 570	java/io/IOException:printStackTrace	()V
    //   1717: goto -36 -> 1681
    //   1720: astore_1
    //   1721: aload 17
    //   1723: astore 15
    //   1725: aload 15
    //   1727: ifnull +8 -> 1735
    //   1730: aload 15
    //   1732: invokevirtual 538	java/io/InputStream:close	()V
    //   1735: aload 14
    //   1737: ifnull +8 -> 1745
    //   1740: aload 14
    //   1742: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   1745: aload_1
    //   1746: athrow
    //   1747: astore_2
    //   1748: aload_2
    //   1749: invokevirtual 570	java/io/IOException:printStackTrace	()V
    //   1752: goto -17 -> 1735
    //   1755: iload 11
    //   1757: iconst_3
    //   1758: if_icmplt +20 -> 1778
    //   1761: new 587	cn/jiguang/a/a/b/h
    //   1764: dup
    //   1765: iconst_m1
    //   1766: aload 16
    //   1768: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1771: bipush 41
    //   1773: aaload
    //   1774: invokespecial 590	cn/jiguang/a/a/b/h:<init>	(ILjava/util/Map;Ljava/lang/String;)V
    //   1777: areturn
    //   1778: iload 11
    //   1780: iconst_1
    //   1781: iadd
    //   1782: istore 11
    //   1784: lload 12
    //   1786: invokestatic 595	java/lang/Thread:sleep	(J)V
    //   1789: goto -1563 -> 226
    //   1792: astore 17
    //   1794: goto -1568 -> 226
    //   1797: astore_1
    //   1798: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1801: bipush 21
    //   1803: aaload
    //   1804: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1807: bipush 68
    //   1809: aaload
    //   1810: aload_1
    //   1811: invokestatic 597	cn/jiguang/d/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1814: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1817: bipush 49
    //   1819: aaload
    //   1820: astore_1
    //   1821: goto -373 -> 1448
    //   1824: iload 9
    //   1826: sipush 400
    //   1829: if_icmplt +293 -> 2122
    //   1832: iload 9
    //   1834: sipush 500
    //   1837: if_icmpge +285 -> 2122
    //   1840: sipush 400
    //   1843: iload 9
    //   1845: if_icmpne +42 -> 1887
    //   1848: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1851: bipush 21
    //   1853: aaload
    //   1854: new 378	java/lang/StringBuilder
    //   1857: dup
    //   1858: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1861: bipush 54
    //   1863: aaload
    //   1864: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1867: aload_2
    //   1868: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1874: invokestatic 599	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1877: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1880: bipush 37
    //   1882: aaload
    //   1883: astore_1
    //   1884: goto -436 -> 1448
    //   1887: sipush 401
    //   1890: iload 9
    //   1892: if_icmpne +42 -> 1934
    //   1895: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1898: bipush 21
    //   1900: aaload
    //   1901: new 378	java/lang/StringBuilder
    //   1904: dup
    //   1905: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1908: bipush 75
    //   1910: aaload
    //   1911: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1914: aload_2
    //   1915: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1918: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1921: invokestatic 599	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1924: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1927: bipush 49
    //   1929: aaload
    //   1930: astore_1
    //   1931: goto -483 -> 1448
    //   1934: sipush 404
    //   1937: iload 9
    //   1939: if_icmpne +42 -> 1981
    //   1942: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1945: bipush 21
    //   1947: aaload
    //   1948: new 378	java/lang/StringBuilder
    //   1951: dup
    //   1952: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1955: bipush 38
    //   1957: aaload
    //   1958: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1961: aload_2
    //   1962: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1968: invokestatic 599	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1971: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1974: bipush 49
    //   1976: aaload
    //   1977: astore_1
    //   1978: goto -530 -> 1448
    //   1981: sipush 406
    //   1984: iload 9
    //   1986: if_icmpne +42 -> 2028
    //   1989: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   1992: bipush 21
    //   1994: aaload
    //   1995: new 378	java/lang/StringBuilder
    //   1998: dup
    //   1999: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2002: bipush 60
    //   2004: aaload
    //   2005: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2008: aload_2
    //   2009: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2012: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2015: invokestatic 599	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   2018: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2021: bipush 49
    //   2023: aaload
    //   2024: astore_1
    //   2025: goto -577 -> 1448
    //   2028: sipush 408
    //   2031: iload 9
    //   2033: if_icmpne +42 -> 2075
    //   2036: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2039: bipush 21
    //   2041: aaload
    //   2042: new 378	java/lang/StringBuilder
    //   2045: dup
    //   2046: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2049: bipush 36
    //   2051: aaload
    //   2052: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2055: aload_2
    //   2056: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2059: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2062: invokestatic 599	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   2065: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2068: bipush 49
    //   2070: aaload
    //   2071: astore_1
    //   2072: goto -624 -> 1448
    //   2075: sipush 409
    //   2078: iload 9
    //   2080: if_icmpne +318 -> 2398
    //   2083: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2086: bipush 21
    //   2088: aaload
    //   2089: new 378	java/lang/StringBuilder
    //   2092: dup
    //   2093: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2096: bipush 58
    //   2098: aaload
    //   2099: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2102: aload_2
    //   2103: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2106: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2109: invokestatic 599	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   2112: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2115: bipush 49
    //   2117: aaload
    //   2118: astore_1
    //   2119: goto -671 -> 1448
    //   2122: iload 9
    //   2124: sipush 500
    //   2127: if_icmplt +64 -> 2191
    //   2130: iload 9
    //   2132: sipush 600
    //   2135: if_icmpge +56 -> 2191
    //   2138: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2141: bipush 21
    //   2143: aaload
    //   2144: new 378	java/lang/StringBuilder
    //   2147: dup
    //   2148: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2151: bipush 44
    //   2153: aaload
    //   2154: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2157: iload 9
    //   2159: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2162: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2165: bipush 76
    //   2167: aaload
    //   2168: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2171: aload_2
    //   2172: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2175: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2178: invokestatic 599	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   2181: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2184: bipush 49
    //   2186: aaload
    //   2187: astore_1
    //   2188: goto -740 -> 1448
    //   2191: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2194: bipush 21
    //   2196: aaload
    //   2197: new 378	java/lang/StringBuilder
    //   2200: dup
    //   2201: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2204: bipush 48
    //   2206: aaload
    //   2207: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2210: iload 9
    //   2212: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2215: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2218: bipush 76
    //   2220: aaload
    //   2221: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2224: aload_2
    //   2225: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2228: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2231: invokestatic 599	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   2234: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   2237: bipush 49
    //   2239: aaload
    //   2240: astore_1
    //   2241: goto -793 -> 1448
    //   2244: astore_1
    //   2245: aload 15
    //   2247: astore_2
    //   2248: aload 14
    //   2250: astore 15
    //   2252: aload_2
    //   2253: astore 14
    //   2255: goto -530 -> 1725
    //   2258: astore_1
    //   2259: aload 19
    //   2261: astore 15
    //   2263: aload 18
    //   2265: astore 14
    //   2267: goto -542 -> 1725
    //   2270: astore_1
    //   2271: goto -546 -> 1725
    //   2274: astore 17
    //   2276: goto -646 -> 1630
    //   2279: astore 17
    //   2281: goto -651 -> 1630
    //   2284: astore 17
    //   2286: goto -656 -> 1630
    //   2289: astore 18
    //   2291: aload 17
    //   2293: astore 15
    //   2295: aload 18
    //   2297: astore 17
    //   2299: goto -669 -> 1630
    //   2302: astore 17
    //   2304: goto -762 -> 1542
    //   2307: astore 17
    //   2309: goto -767 -> 1542
    //   2312: astore 17
    //   2314: goto -772 -> 1542
    //   2317: astore 18
    //   2319: aload 17
    //   2321: astore 15
    //   2323: aload 18
    //   2325: astore 17
    //   2327: goto -785 -> 1542
    //   2330: astore 16
    //   2332: aload 14
    //   2334: astore 18
    //   2336: aload 17
    //   2338: astore 14
    //   2340: aload 15
    //   2342: astore 16
    //   2344: aload 18
    //   2346: astore 15
    //   2348: goto -1442 -> 906
    //   2351: astore 17
    //   2353: aload 14
    //   2355: astore 17
    //   2357: aload 15
    //   2359: astore 14
    //   2361: aload 17
    //   2363: astore 15
    //   2365: goto -1459 -> 906
    //   2368: astore 17
    //   2370: aload 14
    //   2372: astore 17
    //   2374: aload 15
    //   2376: astore 14
    //   2378: aload 17
    //   2380: astore 15
    //   2382: goto -1476 -> 906
    //   2385: astore 15
    //   2387: aload 14
    //   2389: astore 15
    //   2391: aload 17
    //   2393: astore 14
    //   2395: goto -1489 -> 906
    //   2398: aconst_null
    //   2399: astore_1
    //   2400: goto -952 -> 1448
    //   2403: iload 10
    //   2405: istore 9
    //   2407: aload 19
    //   2409: astore 14
    //   2411: aload 18
    //   2413: astore 16
    //   2415: aload 17
    //   2417: astore 15
    //   2419: goto -1466 -> 953
    //   2422: aload 14
    //   2424: astore 17
    //   2426: aload 15
    //   2428: astore 14
    //   2430: aload 17
    //   2432: astore 15
    //   2434: goto -1481 -> 953
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2437	0	this	g
    //   0	2437	1	paramContext	Context
    //   0	2437	2	paramString1	String
    //   0	2437	3	paramInt	int
    //   0	2437	4	paramLong	long
    //   0	2437	6	paramBoolean	boolean
    //   0	2437	7	paramFile	File
    //   0	2437	8	paramString2	String
    //   202	2204	9	k	int
    //   863	1541	10	m	int
    //   221	1562	11	n	int
    //   147	1638	12	l	long
    //   61	2368	14	localObject1	Object
    //   21	2360	15	localObject2	Object
    //   2385	1	15	localSSLPeerUnverifiedException1	javax.net.ssl.SSLPeerUnverifiedException
    //   2389	44	15	localObject3	Object
    //   49	1718	16	localObject4	Object
    //   2330	1	16	localSSLPeerUnverifiedException2	javax.net.ssl.SSLPeerUnverifiedException
    //   2342	72	16	localObject5	Object
    //   231	649	17	localObject6	Object
    //   892	1	17	localSSLPeerUnverifiedException3	javax.net.ssl.SSLPeerUnverifiedException
    //   896	594	17	localObject7	Object
    //   1508	3	17	localIOException1	java.io.IOException
    //   1518	17	17	localIOException2	java.io.IOException
    //   1540	48	17	localObject8	Object
    //   1606	17	17	localIOException3	java.io.IOException
    //   1628	64	17	localObject9	Object
    //   1710	12	17	localIOException4	java.io.IOException
    //   1792	1	17	localInterruptedException	InterruptedException
    //   2274	1	17	localAssertionError1	AssertionError
    //   2279	1	17	localAssertionError2	AssertionError
    //   2284	8	17	localAssertionError3	AssertionError
    //   2297	1	17	localObject10	Object
    //   2302	1	17	localException1	Exception
    //   2307	1	17	localException2	Exception
    //   2312	8	17	localException3	Exception
    //   2325	12	17	localObject11	Object
    //   2351	1	17	localSSLPeerUnverifiedException4	javax.net.ssl.SSLPeerUnverifiedException
    //   2355	7	17	localObject12	Object
    //   2368	1	17	localSSLPeerUnverifiedException5	javax.net.ssl.SSLPeerUnverifiedException
    //   2372	59	17	localObject13	Object
    //   243	1243	18	localObject14	Object
    //   1528	11	18	localException4	Exception
    //   1548	36	18	localObject15	Object
    //   1616	11	18	localAssertionError4	AssertionError
    //   1636	628	18	localObject16	Object
    //   2289	7	18	localAssertionError5	AssertionError
    //   2317	7	18	localException5	Exception
    //   2334	78	18	localObject17	Object
    //   239	2169	19	localObject18	Object
    //   169	879	20	str1	String
    //   177	876	21	str2	String
    //   185	873	22	str3	String
    //   193	375	23	str4	String
    //   629	374	24	localObject19	Object
    //   846	36	25	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   245	253	892	javax/net/ssl/SSLPeerUnverifiedException
    //   261	269	892	javax/net/ssl/SSLPeerUnverifiedException
    //   277	283	892	javax/net/ssl/SSLPeerUnverifiedException
    //   291	297	892	javax/net/ssl/SSLPeerUnverifiedException
    //   305	311	892	javax/net/ssl/SSLPeerUnverifiedException
    //   319	330	892	javax/net/ssl/SSLPeerUnverifiedException
    //   338	355	892	javax/net/ssl/SSLPeerUnverifiedException
    //   363	380	892	javax/net/ssl/SSLPeerUnverifiedException
    //   388	399	892	javax/net/ssl/SSLPeerUnverifiedException
    //   407	423	892	javax/net/ssl/SSLPeerUnverifiedException
    //   431	450	892	javax/net/ssl/SSLPeerUnverifiedException
    //   458	486	892	javax/net/ssl/SSLPeerUnverifiedException
    //   494	501	892	javax/net/ssl/SSLPeerUnverifiedException
    //   509	539	892	javax/net/ssl/SSLPeerUnverifiedException
    //   552	592	892	javax/net/ssl/SSLPeerUnverifiedException
    //   600	614	892	javax/net/ssl/SSLPeerUnverifiedException
    //   622	631	892	javax/net/ssl/SSLPeerUnverifiedException
    //   639	647	892	javax/net/ssl/SSLPeerUnverifiedException
    //   655	663	892	javax/net/ssl/SSLPeerUnverifiedException
    //   671	679	892	javax/net/ssl/SSLPeerUnverifiedException
    //   687	742	892	javax/net/ssl/SSLPeerUnverifiedException
    //   750	777	892	javax/net/ssl/SSLPeerUnverifiedException
    //   785	793	892	javax/net/ssl/SSLPeerUnverifiedException
    //   801	814	892	javax/net/ssl/SSLPeerUnverifiedException
    //   822	833	892	javax/net/ssl/SSLPeerUnverifiedException
    //   841	848	892	javax/net/ssl/SSLPeerUnverifiedException
    //   856	865	892	javax/net/ssl/SSLPeerUnverifiedException
    //   879	889	892	javax/net/ssl/SSLPeerUnverifiedException
    //   1002	1007	892	javax/net/ssl/SSLPeerUnverifiedException
    //   1015	1025	892	javax/net/ssl/SSLPeerUnverifiedException
    //   1033	1071	892	javax/net/ssl/SSLPeerUnverifiedException
    //   1079	1084	892	javax/net/ssl/SSLPeerUnverifiedException
    //   1092	1097	892	javax/net/ssl/SSLPeerUnverifiedException
    //   1105	1112	892	javax/net/ssl/SSLPeerUnverifiedException
    //   1274	1279	1293	java/io/IOException
    //   1306	1311	1323	java/io/IOException
    //   1386	1391	1461	java/io/IOException
    //   1474	1479	1508	java/io/IOException
    //   926	931	1518	java/io/IOException
    //   1361	1381	1528	java/lang/Exception
    //   1572	1577	1606	java/io/IOException
    //   1361	1381	1616	java/lang/AssertionError
    //   1676	1681	1710	java/io/IOException
    //   1354	1361	1720	finally
    //   1361	1381	1720	finally
    //   1730	1735	1747	java/io/IOException
    //   1784	1789	1792	java/lang/InterruptedException
    //   1425	1448	1797	java/lang/Exception
    //   906	921	2244	finally
    //   245	253	2258	finally
    //   261	269	2258	finally
    //   277	283	2258	finally
    //   291	297	2258	finally
    //   305	311	2258	finally
    //   319	330	2258	finally
    //   338	355	2258	finally
    //   363	380	2258	finally
    //   388	399	2258	finally
    //   407	423	2258	finally
    //   431	450	2258	finally
    //   458	486	2258	finally
    //   494	501	2258	finally
    //   509	539	2258	finally
    //   552	592	2258	finally
    //   600	614	2258	finally
    //   622	631	2258	finally
    //   639	647	2258	finally
    //   655	663	2258	finally
    //   671	679	2258	finally
    //   687	742	2258	finally
    //   750	777	2258	finally
    //   785	793	2258	finally
    //   801	814	2258	finally
    //   822	833	2258	finally
    //   841	848	2258	finally
    //   856	865	2258	finally
    //   879	889	2258	finally
    //   1002	1007	2258	finally
    //   1015	1025	2258	finally
    //   1033	1071	2258	finally
    //   1079	1084	2258	finally
    //   1092	1097	2258	finally
    //   1105	1112	2258	finally
    //   1124	1132	2258	finally
    //   1140	1170	2258	finally
    //   1186	1199	2258	finally
    //   1207	1237	2258	finally
    //   1249	1266	2258	finally
    //   1347	1354	2258	finally
    //   1550	1567	2258	finally
    //   1638	1671	2258	finally
    //   226	233	2270	finally
    //   226	233	2274	java/lang/AssertionError
    //   245	253	2279	java/lang/AssertionError
    //   261	269	2279	java/lang/AssertionError
    //   277	283	2279	java/lang/AssertionError
    //   291	297	2279	java/lang/AssertionError
    //   305	311	2279	java/lang/AssertionError
    //   319	330	2279	java/lang/AssertionError
    //   338	355	2279	java/lang/AssertionError
    //   363	380	2279	java/lang/AssertionError
    //   388	399	2279	java/lang/AssertionError
    //   407	423	2279	java/lang/AssertionError
    //   431	450	2279	java/lang/AssertionError
    //   458	486	2279	java/lang/AssertionError
    //   494	501	2279	java/lang/AssertionError
    //   509	539	2279	java/lang/AssertionError
    //   552	592	2279	java/lang/AssertionError
    //   600	614	2279	java/lang/AssertionError
    //   622	631	2279	java/lang/AssertionError
    //   639	647	2279	java/lang/AssertionError
    //   655	663	2279	java/lang/AssertionError
    //   671	679	2279	java/lang/AssertionError
    //   687	742	2279	java/lang/AssertionError
    //   750	777	2279	java/lang/AssertionError
    //   785	793	2279	java/lang/AssertionError
    //   801	814	2279	java/lang/AssertionError
    //   822	833	2279	java/lang/AssertionError
    //   841	848	2279	java/lang/AssertionError
    //   856	865	2279	java/lang/AssertionError
    //   879	889	2279	java/lang/AssertionError
    //   1002	1007	2279	java/lang/AssertionError
    //   1015	1025	2279	java/lang/AssertionError
    //   1033	1071	2279	java/lang/AssertionError
    //   1079	1084	2279	java/lang/AssertionError
    //   1092	1097	2279	java/lang/AssertionError
    //   1105	1112	2279	java/lang/AssertionError
    //   1124	1132	2284	java/lang/AssertionError
    //   1140	1170	2284	java/lang/AssertionError
    //   1186	1199	2284	java/lang/AssertionError
    //   1207	1237	2284	java/lang/AssertionError
    //   1249	1266	2284	java/lang/AssertionError
    //   1347	1354	2284	java/lang/AssertionError
    //   1354	1361	2289	java/lang/AssertionError
    //   226	233	2302	java/lang/Exception
    //   245	253	2307	java/lang/Exception
    //   261	269	2307	java/lang/Exception
    //   277	283	2307	java/lang/Exception
    //   291	297	2307	java/lang/Exception
    //   305	311	2307	java/lang/Exception
    //   319	330	2307	java/lang/Exception
    //   338	355	2307	java/lang/Exception
    //   363	380	2307	java/lang/Exception
    //   388	399	2307	java/lang/Exception
    //   407	423	2307	java/lang/Exception
    //   431	450	2307	java/lang/Exception
    //   458	486	2307	java/lang/Exception
    //   494	501	2307	java/lang/Exception
    //   509	539	2307	java/lang/Exception
    //   552	592	2307	java/lang/Exception
    //   600	614	2307	java/lang/Exception
    //   622	631	2307	java/lang/Exception
    //   639	647	2307	java/lang/Exception
    //   655	663	2307	java/lang/Exception
    //   671	679	2307	java/lang/Exception
    //   687	742	2307	java/lang/Exception
    //   750	777	2307	java/lang/Exception
    //   785	793	2307	java/lang/Exception
    //   801	814	2307	java/lang/Exception
    //   822	833	2307	java/lang/Exception
    //   841	848	2307	java/lang/Exception
    //   856	865	2307	java/lang/Exception
    //   879	889	2307	java/lang/Exception
    //   1002	1007	2307	java/lang/Exception
    //   1015	1025	2307	java/lang/Exception
    //   1033	1071	2307	java/lang/Exception
    //   1079	1084	2307	java/lang/Exception
    //   1092	1097	2307	java/lang/Exception
    //   1105	1112	2307	java/lang/Exception
    //   1124	1132	2312	java/lang/Exception
    //   1140	1170	2312	java/lang/Exception
    //   1186	1199	2312	java/lang/Exception
    //   1207	1237	2312	java/lang/Exception
    //   1249	1266	2312	java/lang/Exception
    //   1347	1354	2312	java/lang/Exception
    //   1354	1361	2317	java/lang/Exception
    //   1361	1381	2330	javax/net/ssl/SSLPeerUnverifiedException
    //   226	233	2351	javax/net/ssl/SSLPeerUnverifiedException
    //   1124	1132	2368	javax/net/ssl/SSLPeerUnverifiedException
    //   1140	1170	2368	javax/net/ssl/SSLPeerUnverifiedException
    //   1186	1199	2368	javax/net/ssl/SSLPeerUnverifiedException
    //   1207	1237	2368	javax/net/ssl/SSLPeerUnverifiedException
    //   1249	1266	2368	javax/net/ssl/SSLPeerUnverifiedException
    //   1347	1354	2368	javax/net/ssl/SSLPeerUnverifiedException
    //   1354	1361	2385	javax/net/ssl/SSLPeerUnverifiedException
  }
  
  private String a(int paramInt)
  {
    Object localObject = this.g;
    if ((paramInt < 0) || (paramInt >= 3)) {}
    for (localObject = z[107];; localObject = cn.jiguang.c.a.a.b((Context)localObject, z[106] + paramInt, z[107]))
    {
      this.i = ((String)localObject);
      d.a(z[21], z[108] + this.i);
      return this.i;
    }
  }
  
  private String a(String paramString, h paramh)
  {
    if (a(this.g, paramh)) {
      return d(paramString);
    }
    return null;
  }
  
  private String a(TreeMap<String, String> paramTreeMap)
  {
    if (paramTreeMap.size() == 0)
    {
      d.g(z[21], z[82]);
      return null;
    }
    Object localObject = paramTreeMap.entrySet().iterator();
    paramTreeMap = new StringBuilder();
    while (((Iterator)localObject).hasNext()) {
      paramTreeMap.append(((Map.Entry)((Iterator)localObject).next()).getValue());
    }
    localObject = cn.jiguang.a.b.a.a(this.g);
    d.a(z[21], z[80] + (String)localObject);
    localObject = cn.jiguang.f.a.a(paramTreeMap.toString() + (String)localObject).toUpperCase();
    d.a(z[21], z[83] + paramTreeMap);
    d.a(z[21], z[81] + (String)localObject);
    return (String)localObject;
  }
  
  public static void a(Context paramContext)
  {
    d.a(z[21], z[91]);
    if (c.get() >= 2)
    {
      d.a(z[21], z[92]);
      return;
    }
    a.execute(new g(paramContext));
  }
  
  private static void a(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get(z[123]);
    if (paramMap != null)
    {
      paramMap = paramMap.iterator();
      while (paramMap.hasNext())
      {
        String str = (String)paramMap.next();
        j.getCookieStore().add(null, (HttpCookie)HttpCookie.parse(str).get(0));
      }
    }
  }
  
  /* Error */
  private static boolean a(Context paramContext, h paramh)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +20 -> 21
    //   4: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   7: bipush 21
    //   9: aaload
    //   10: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   13: bipush 94
    //   15: aaload
    //   16: invokestatic 619	cn/jiguang/d/d:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_1
    //   22: ifnull -3 -> 19
    //   25: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   28: bipush 21
    //   30: aaload
    //   31: new 378	java/lang/StringBuilder
    //   34: dup
    //   35: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   38: bipush 101
    //   40: aaload
    //   41: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: aload_1
    //   45: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 376	cn/jiguang/d/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   57: iconst_5
    //   58: aaload
    //   59: astore 4
    //   61: new 378	java/lang/StringBuilder
    //   64: dup
    //   65: ldc_w 695
    //   68: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: astore 5
    //   73: aload_1
    //   74: getfield 698	cn/jiguang/a/a/b/h:c	Ljava/util/Map;
    //   77: ifnull +198 -> 275
    //   80: aload_1
    //   81: getfield 698	cn/jiguang/a/a/b/h:c	Ljava/util/Map;
    //   84: invokeinterface 699 1 0
    //   89: ifle +186 -> 275
    //   92: aload_1
    //   93: getfield 698	cn/jiguang/a/a/b/h:c	Ljava/util/Map;
    //   96: invokeinterface 700 1 0
    //   101: invokeinterface 629 1 0
    //   106: astore_3
    //   107: aload_3
    //   108: invokeinterface 635 1 0
    //   113: ifeq +162 -> 275
    //   116: aload_3
    //   117: invokeinterface 639 1 0
    //   122: checkcast 641	java/util/Map$Entry
    //   125: astore 6
    //   127: aload 6
    //   129: invokeinterface 703 1 0
    //   134: ifnull +28 -> 162
    //   137: aload 5
    //   139: aload 6
    //   141: invokeinterface 703 1 0
    //   146: checkcast 27	java/lang/String
    //   149: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   155: bipush 105
    //   157: aaload
    //   158: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 6
    //   164: invokeinterface 644 1 0
    //   169: checkcast 477	java/util/List
    //   172: invokeinterface 673 1 0
    //   177: astore 6
    //   179: aload 6
    //   181: invokeinterface 635 1 0
    //   186: ifeq +77 -> 263
    //   189: aload 5
    //   191: aload 6
    //   193: invokeinterface 639 1 0
    //   198: checkcast 27	java/lang/String
    //   201: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 6
    //   207: invokeinterface 635 1 0
    //   212: ifeq +51 -> 263
    //   215: aload 5
    //   217: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   220: bipush 93
    //   222: aaload
    //   223: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 6
    //   228: invokeinterface 639 1 0
    //   233: checkcast 27	java/lang/String
    //   236: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: goto -35 -> 205
    //   243: astore_3
    //   244: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   247: bipush 21
    //   249: aaload
    //   250: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   253: bipush 104
    //   255: aaload
    //   256: aload_3
    //   257: invokestatic 705	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   260: goto -206 -> 54
    //   263: aload 5
    //   265: ldc_w 707
    //   268: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: goto -165 -> 107
    //   275: aload 5
    //   277: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   280: bipush 97
    //   282: aaload
    //   283: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_1
    //   288: getfield 709	cn/jiguang/a/a/b/h:b	Ljava/lang/String;
    //   291: invokestatic 713	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   294: ifne +13 -> 307
    //   297: aload 5
    //   299: aload_1
    //   300: getfield 709	cn/jiguang/a/a/b/h:b	Ljava/lang/String;
    //   303: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_0
    //   308: aload 4
    //   310: invokevirtual 718	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   313: pop
    //   314: aload_0
    //   315: aload 4
    //   317: iconst_0
    //   318: invokevirtual 722	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   321: astore_3
    //   322: aload_3
    //   323: astore_1
    //   324: aload_3
    //   325: aload 5
    //   327: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   333: bipush 20
    //   335: aaload
    //   336: invokevirtual 725	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   339: invokevirtual 728	java/io/FileOutputStream:write	([B)V
    //   342: aload_3
    //   343: invokestatic 733	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   346: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   349: bipush 19
    //   351: aaload
    //   352: astore_1
    //   353: aload_0
    //   354: aload_1
    //   355: invokevirtual 718	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   358: pop
    //   359: new 378	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 493	java/lang/StringBuilder:<init>	()V
    //   366: aload_0
    //   367: invokevirtual 737	android/content/Context:getFilesDir	()Ljava/io/File;
    //   370: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   373: getstatic 740	java/io/File:separator	Ljava/lang/String;
    //   376: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: astore_0
    //   383: new 742	java/util/ArrayList
    //   386: dup
    //   387: invokespecial 743	java/util/ArrayList:<init>	()V
    //   390: astore_3
    //   391: aload_3
    //   392: new 387	java/io/File
    //   395: dup
    //   396: new 378	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 493	java/lang/StringBuilder:<init>	()V
    //   403: aload_0
    //   404: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   410: iconst_5
    //   411: aaload
    //   412: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokespecial 744	java/io/File:<init>	(Ljava/lang/String;)V
    //   421: invokeinterface 747 2 0
    //   426: pop
    //   427: aload_3
    //   428: new 387	java/io/File
    //   431: dup
    //   432: new 378	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 493	java/lang/StringBuilder:<init>	()V
    //   439: aload_0
    //   440: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload_1
    //   444: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokespecial 744	java/io/File:<init>	(Ljava/lang/String;)V
    //   453: invokestatic 752	cn/jiguang/f/d:a	(Ljava/util/Collection;Ljava/io/File;)V
    //   456: iconst_1
    //   457: istore_2
    //   458: iload_2
    //   459: ireturn
    //   460: astore_0
    //   461: aconst_null
    //   462: astore_3
    //   463: aload_3
    //   464: astore_1
    //   465: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   468: bipush 21
    //   470: aaload
    //   471: new 378	java/lang/StringBuilder
    //   474: dup
    //   475: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   478: bipush 100
    //   480: aaload
    //   481: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   484: aload 4
    //   486: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   492: bipush 98
    //   494: aaload
    //   495: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_0
    //   499: invokevirtual 755	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   502: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 599	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: aload_3
    //   512: invokestatic 733	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   515: iconst_0
    //   516: ireturn
    //   517: astore_0
    //   518: aconst_null
    //   519: astore_3
    //   520: aload_3
    //   521: astore_1
    //   522: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   525: bipush 21
    //   527: aaload
    //   528: new 378	java/lang/StringBuilder
    //   531: dup
    //   532: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   535: bipush 103
    //   537: aaload
    //   538: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   541: aload 4
    //   543: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   549: bipush 102
    //   551: aaload
    //   552: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_0
    //   556: invokevirtual 756	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   559: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 599	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: aload_3
    //   569: invokestatic 733	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   572: iconst_0
    //   573: ireturn
    //   574: astore_0
    //   575: aconst_null
    //   576: astore_3
    //   577: aload_3
    //   578: astore_1
    //   579: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   582: bipush 21
    //   584: aaload
    //   585: new 378	java/lang/StringBuilder
    //   588: dup
    //   589: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   592: bipush 99
    //   594: aaload
    //   595: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   598: aload 4
    //   600: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   606: bipush 102
    //   608: aaload
    //   609: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: aload_0
    //   613: invokevirtual 757	java/io/IOException:getMessage	()Ljava/lang/String;
    //   616: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokestatic 599	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   625: aload_3
    //   626: invokestatic 733	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   629: iconst_0
    //   630: ireturn
    //   631: astore_0
    //   632: aconst_null
    //   633: astore_3
    //   634: aload_3
    //   635: astore_1
    //   636: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   639: bipush 21
    //   641: aaload
    //   642: new 378	java/lang/StringBuilder
    //   645: dup
    //   646: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   649: bipush 96
    //   651: aaload
    //   652: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   655: aload 4
    //   657: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: getstatic 289	cn/jiguang/a/a/b/g:z	[Ljava/lang/String;
    //   663: bipush 95
    //   665: aaload
    //   666: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: aload_0
    //   670: invokevirtual 758	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   673: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 402	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokestatic 599	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   682: aload_3
    //   683: invokestatic 733	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   686: iconst_0
    //   687: ireturn
    //   688: astore_0
    //   689: aconst_null
    //   690: astore_1
    //   691: aload_1
    //   692: invokestatic 733	cn/jiguang/c/d/l:a	(Ljava/io/Closeable;)V
    //   695: aload_0
    //   696: athrow
    //   697: astore_0
    //   698: aload_0
    //   699: invokevirtual 570	java/io/IOException:printStackTrace	()V
    //   702: iconst_0
    //   703: istore_2
    //   704: goto -246 -> 458
    //   707: astore_0
    //   708: goto -17 -> 691
    //   711: astore_0
    //   712: goto -78 -> 634
    //   715: astore_0
    //   716: goto -139 -> 577
    //   719: astore_0
    //   720: goto -200 -> 520
    //   723: astore_0
    //   724: goto -261 -> 463
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	727	0	paramContext	Context
    //   0	727	1	paramh	h
    //   457	247	2	bool	boolean
    //   106	11	3	localIterator	Iterator
    //   243	14	3	localException	Exception
    //   321	362	3	localObject1	Object
    //   59	597	4	str	String
    //   71	255	5	localStringBuilder	StringBuilder
    //   125	102	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	54	243	java/lang/Exception
    //   307	322	460	java/io/FileNotFoundException
    //   307	322	517	java/io/UnsupportedEncodingException
    //   307	322	574	java/io/IOException
    //   307	322	631	java/lang/NullPointerException
    //   307	322	688	finally
    //   346	456	697	java/io/IOException
    //   324	342	707	finally
    //   465	511	707	finally
    //   522	568	707	finally
    //   579	625	707	finally
    //   636	682	707	finally
    //   324	342	711	java/lang/NullPointerException
    //   324	342	715	java/io/IOException
    //   324	342	719	java/io/UnsupportedEncodingException
    //   324	342	723	java/io/FileNotFoundException
  }
  
  private boolean a(String paramString1, String arg2, String paramString3)
  {
    d.a(z[21], z[12] + paramString1 + z[9] + ??? + z[13] + paramString3);
    TreeMap localTreeMap = new TreeMap();
    if (!cn.jiguang.f.h.a(paramString1)) {
      localTreeMap.put(z[7], paramString1);
    }
    if (!cn.jiguang.f.h.a(???)) {
      localTreeMap.put(z[4], ???);
    }
    if (!cn.jiguang.f.h.a(paramString3)) {
      localTreeMap.put(z[17], paramString3);
    }
    localTreeMap.put(z[14], cn.jiguang.c.a.a.b(this.g, z[1], z[15]));
    localTreeMap.put(z[2], cn.jiguang.c.a.a.b(this.g, z[18], "7"));
    localTreeMap.put(z[8], cn.jiguang.c.f.a.b());
    localTreeMap.put(z[6], a(localTreeMap));
    paramString3 = localTreeMap.entrySet().iterator();
    paramString1 = "";
    for (;;)
    {
      if (paramString3.hasNext()) {
        ??? = (Map.Entry)paramString3.next();
      }
      try
      {
        ??? = paramString1 + "&" + (String)???.getKey() + "=" + URLEncoder.encode((String)???.getValue(), z[20]);
        paramString1 = ???;
      }
      catch (UnsupportedEncodingException ???) {}
    }
    d.a(z[21], z[0] + paramString1);
    try
    {
      paramString3 = a(this.g, this.i + z[10] + paramString1, 10, 30000L, false, null, null);
      d.a(z[21], z[11] + paramString3.a + z[22] + paramString3.b);
      if (paramString3.a != 200) {
        return false;
      }
    }
    catch (Throwable paramString1)
    {
      return false;
    }
    ??? = c(paramString3.b);
    if (??? != null) {
      if (???.optInt(z[3], -1) != 200) {
        return false;
      }
    }
    label593:
    for (paramString1 = b(???.optString(z[16]));; paramString1 = null)
    {
      for (;;)
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          e(paramString1);
          return true;
          if ((paramString3.c == null) && (TextUtils.isEmpty(paramString3.b))) {
            break label593;
          }
          synchronized (b)
          {
            this.h = 0;
          }
          try
          {
            paramString1 = a(paramString1, paramString3);
            this.g.deleteFile(z[5]);
            this.g.deleteFile(z[19]);
            continue;
            paramString1 = finally;
            throw paramString1;
          }
          catch (Throwable paramString1)
          {
            for (;;)
            {
              paramString1 = null;
            }
          }
        }
      }
      return false;
      break;
    }
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null)
    {
      d.g(z[21], z[79]);
      return "";
    }
    String str1 = cn.jiguang.f.a.e(paramContext, "");
    String str2 = cn.jiguang.f.a.d(paramContext, "");
    paramContext = cn.jiguang.f.a.f(paramContext, "");
    paramContext = cn.jiguang.f.a.a(str1 + str2 + paramContext);
    d.a(z[21], z[78] + paramContext);
    return paramContext;
  }
  
  private String b(String paramString)
  {
    paramString = f(paramString);
    d.a(z[21], z[33] + paramString);
    if (cn.jiguang.f.h.a(paramString))
    {
      d.g(z[21], z[35]);
      return null;
    }
    if (!Patterns.PHONE.matcher(paramString).matches())
    {
      d.g(z[21], z[34]);
      return null;
    }
    return paramString;
  }
  
  private static JSONObject c(String paramString)
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new JSONObject(paramString);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      catch (JSONException paramString)
      {
        return null;
      }
      paramString = null;
    }
  }
  
  private String d(String paramString)
  {
    d.c(z[21], z[86] + paramString);
    if (TextUtils.isEmpty(paramString)) {
      d.g(z[21], z[84]);
    }
    for (;;)
    {
      return null;
      try
      {
        h localh = a(this.g, this.i + z[10] + paramString, 10, 30000L, false, new File(this.g.getFilesDir() + File.separator + z[19]), z[85]);
        d.a(z[21], z[11] + localh.a + z[22] + localh.b);
        if (localh.a != 200) {
          continue;
        }
        JSONObject localJSONObject = c(localh.b);
        if (localJSONObject != null) {
          if (localJSONObject.optInt(z[3], -1) != 200) {
            continue;
          }
        }
        for (paramString = b(localJSONObject.optString(z[16]));; paramString = null) {
          for (;;)
          {
            return paramString;
            if ((localh.c != null) || (!TextUtils.isEmpty(localh.b)))
            {
              if (this.h > 4) {
                break;
              }
              this.h += 1;
              try
              {
                paramString = a(paramString, localh);
              }
              catch (Throwable paramString) {}
            }
          }
        }
        return null;
      }
      catch (Throwable paramString) {}
    }
  }
  
  private void e(String paramString)
  {
    d.a(z[21], z[31] + paramString);
    Context localContext = this.g;
    String str = b(localContext);
    Object localObject = str;
    if (cn.jiguang.f.h.a(str)) {
      localObject = z[26];
    }
    cn.jiguang.c.a.a.a(localContext, (String)localObject, paramString);
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put(z[16], paramString);
      if (!cn.jiguang.f.h.a(this.d)) {
        ((JSONObject)localObject).put(z[7], this.d);
      }
      if (!cn.jiguang.f.h.a(this.f)) {
        ((JSONObject)localObject).put(z[17], this.f);
      }
      if (!cn.jiguang.f.h.a(this.e)) {
        ((JSONObject)localObject).put(z[4], this.e);
      }
      paramString = ((JSONObject)localObject).toString();
      try
      {
        localObject = cn.jiguang.c.a.a.getEncryptedString(paramString);
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      if (!cn.jiguang.f.h.a(paramString))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put(z[30], paramString);
        ((JSONObject)localObject).put(z[28], cn.jiguang.c.a.a.g());
        ((JSONObject)localObject).put(z[27], z[29]);
        d.a(z[21], z[25] + paramString);
        d.a(z[21], z[23] + ((JSONObject)localObject).toString());
        c.a(this.g, (JSONObject)localObject);
        MultiSpHelper.commitBoolean(this.g, z[32], false);
        return;
      }
    }
    catch (JSONException paramString)
    {
      d.e(z[21], z[24], paramString);
    }
  }
  
  private String f(String paramString)
  {
    try
    {
      paramString = cn.jiguang.c.f.a.a.b(paramString, cn.jiguang.a.b.a.a(this.g).substring(0, 16));
      return paramString;
    }
    catch (Exception paramString)
    {
      d.g(z[21], z[87] + paramString.getMessage());
    }
    return null;
  }
  
  public final void run()
  {
    int m = 0;
    c.incrementAndGet();
    try
    {
      if ((cn.jiguang.f.h.a(this.d)) && (cn.jiguang.f.h.a(this.e)) && (cn.jiguang.f.h.a(this.f)))
      {
        d.g(z[21], z[111]);
        return;
      }
      str = cn.jiguang.a.b.a.b(this.g);
      if ((!cn.jiguang.f.h.a(str)) && (!MultiSpHelper.getBoolean(this.g, z[32], false))) {
        break label438;
      }
      MultiSpHelper.commitLong(cn.jiguang.c.a.e, z[119], System.currentTimeMillis());
      str = this.f;
      if (cn.jiguang.f.h.a(str)) {
        break label461;
      }
      if ((str.startsWith(z[122])) || (str.startsWith(z[115])) || (str.startsWith(z[114]))) {
        break label446;
      }
      if (!str.startsWith(z[112])) {
        break label244;
      }
    }
    catch (Exception localException)
    {
      String str;
      int k;
      label236:
      label244:
      label438:
      label446:
      label456:
      label461:
      label473:
      for (;;) {}
    }
    d.a(z[21], z[109] + k);
    if (k != -1)
    {
      a(k);
      if (!cn.jiguang.f.h.a(this.i)) {
        a(this.d, this.e, this.f);
      }
    }
    for (;;)
    {
      c.decrementAndGet();
      return;
      if ((!str.startsWith(z[110])) && (!str.startsWith(z[120])) && (!str.startsWith(z[118])))
      {
        if ((str.startsWith(z[113])) || (str.startsWith(z[117]))) {
          break label456;
        }
        if (!str.startsWith(z[121])) {
          break label461;
        }
      }
      for (;;)
      {
        if (k >= 3) {
          break label473;
        }
        a(k);
        d.a(z[21], z[109] + k);
        k += 1;
        if ((cn.jiguang.f.h.a(this.i)) || (str.equals(this.i)))
        {
          d.a(z[21], z[116]);
        }
        else
        {
          str = this.i;
          if (a(this.d, this.e, this.f))
          {
            break label236;
            e(str);
            break label236;
            k = 0;
            break;
            k = 1;
            break;
            k = 2;
            break;
            k = -1;
            break;
            str = "";
            k = m;
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */