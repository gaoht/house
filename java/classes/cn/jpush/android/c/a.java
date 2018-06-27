package cn.jpush.android.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.text.TextUtils;
import android.webkit.WebSettings;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.a.b;
import cn.jpush.android.data.c;
import cn.jpush.android.e;
import cn.jpush.android.service.DaemonService;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static final ArrayList<String> a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[71];
    int j = 0;
    Object localObject2 = "E\035rQ@A\001l\\@\\\033!Ｃ";
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
        i = 96;
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
        localObject2 = "[\007uP\006\\\013`M\tZ\006^\\\016T\nm\\\004";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "[\007!M\tX\r!U\tX\001u\\\004";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "{\007uP\006\\\013`M\tZ\006!N\001FHeP\023T\nm\\\004\025\nx\031*e\035rQ)[\034dK\006T\013d\027\023P\034QL\023]<hT\005\025I";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "v\035sK\005[\034!M\tX\r!P\023\025\007tM@Z\016!M\bPHqL\023]HuP\rPH,\031";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "i6";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "t\006eK\017\\\fTM\tY";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "x\thW@V\004`J\023\025\001r\031";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "V\006/S\020@\033i\027\001[\fsV\tQFDa4g)";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "T\006eK\017\\\f/P\016A\roMNV\tu\\\007Z\032x\027,t=Oz(p:";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "T\006eK\017\\\f/P\016A\roMNT\013uP\017[FLx){";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "f,BX\022QHhJ@[\007u\031\rZ\035oM\005Q";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "X\007tW\024P\f";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "F\ruM\t[\017^J\tY\roZ\005j\030tJ\bj\034hT\005";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "v\035sK\005[\034!M\tX\r!P\023\025\001o\031\024]\r!K\001[\017d\031\017SHrP\fP\006b\\@A\001l\\@\030H";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "\031HrM\001G\034LP\016\017";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "P\006eq\017@\032";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "T\013uP\017[H,\031\tF!oj\tY\roZ\005e\035rQ4\\\005d";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "\031HrM\001G\034IV\025GR";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "F\034`K\024}\007tK";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "\031HdW\004x\001o\003";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "\025\026!";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "[\007vq\017@\032;";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "\031HoV\027x\001o\003";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "F\034`K\024x\001oJ";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "\031HdW\004}\007tKZ";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "P\006eM-\\\006r";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "P\005qM\031\025\030`K\001X\033";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "V\006/S\020@\033i\027\001[\fsV\tQFL|3f)F|";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        j = 29;
        localObject2 = "f\ro]@W\032nX\004V\trM@A\007!X\020ER!";
        i = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i4] = localObject1;
        j = 30;
        localObject2 = "F\ro]\"G\007`]\003T\033um\017t\030q\031\005G\032nKZ";
        i = 29;
        localObject1 = arrayOfString;
        break;
      case 29: 
        localObject3[i4] = localObject1;
        j = 31;
        localObject2 = "V\006/S\020@\033i\027\001[\fsV\tQF@i0~-X";
        i = 30;
        localObject1 = arrayOfString;
        break;
      case 30: 
        localObject3[i4] = localObject1;
        j = 32;
        localObject2 = "V\006/S\020@\033i\027\001[\fsV\tQFhW\024P\006u\027-p;Rx'p7S|#p!W|$";
        i = 31;
        localObject1 = arrayOfString;
        break;
      case 31: 
        localObject3[i4] = localObject1;
        j = 33;
        localObject2 = "V\006/S\020@\033i\027\001[\fsV\tQFGp,p7Qx4}";
        i = 32;
        localObject1 = arrayOfString;
        break;
      case 32: 
        localObject3[i4] = localObject1;
        j = 34;
        localObject2 = "V\006/S\020@\033i\027\001[\fsV\tQFBv.a-Om?a1Q|";
        i = 33;
        localObject1 = arrayOfString;
        break;
      case 33: 
        localObject3[i4] = localObject1;
        j = 35;
        localObject2 = "\020\033/I\005G\005hJ\023\\\007o\027*e=Rq?x-Rj!r-";
        i = 34;
        localObject1 = arrayOfString;
        break;
      case 34: 
        localObject3[i4] = localObject1;
        j = 36;
        localObject2 = "V\006/S\020@\033i\027\001[\fsV\tQFUp4y-";
        i = 35;
        localObject1 = arrayOfString;
        break;
      case 35: 
        localObject3[i4] = localObject1;
        j = 37;
        localObject2 = "V\006/S\020@\033i\027\001[\fsV\tQFLj'j!E";
        i = 36;
        localObject1 = arrayOfString;
        break;
      case 36: 
        localObject3[i4] = localObject1;
        j = 38;
        localObject2 = "[\ruN\017G\003";
        i = 37;
        localObject1 = arrayOfString;
        break;
      case 37: 
        localObject3[i4] = localObject1;
        j = 39;
        localObject2 = "W\tr\\\002T\006e";
        i = 38;
        localObject1 = arrayOfString;
        break;
      case 38: 
        localObject3[i4] = localObject1;
        j = 40;
        localObject2 = "T\006eK\017\\\fR]\013c\rsJ\tZ\006";
        i = 39;
        localObject1 = arrayOfString;
        break;
      case 39: 
        localObject3[i4] = localObject1;
        j = 41;
        localObject2 = "Q\rwP\003P";
        i = 40;
        localObject1 = arrayOfString;
        break;
      case 40: 
        localObject3[i4] = localObject1;
        j = 42;
        localObject2 = "R\033l\027\026P\032rP\017[FcX\023P\n`W\004";
        i = 41;
        localObject1 = arrayOfString;
        break;
      case 41: 
        localObject3[i4] = localObject1;
        j = 43;
        localObject2 = "X\007e\\\f";
        i = 42;
        localObject1 = arrayOfString;
        break;
      case 42: 
        localObject3[i4] = localObject1;
        j = 44;
        localObject2 = "V\000`W\016P\004";
        i = 43;
        localObject1 = arrayOfString;
        break;
      case 43: 
        localObject3[i4] = localObject1;
        j = 45;
        localObject2 = "@\032m";
        i = 44;
        localObject1 = arrayOfString;
        break;
      case 44: 
        localObject3[i4] = localObject1;
        j = 46;
        localObject2 = "`<G\024X";
        i = 45;
        localObject1 = arrayOfString;
        break;
      case 45: 
        localObject3[i4] = localObject1;
        j = 47;
        localObject2 = "V\007oW\005V\034hO\tA\021";
        i = 46;
        localObject1 = arrayOfString;
        break;
      case 46: 
        localObject3[i4] = localObject1;
        j = 48;
        localObject2 = "t\006eK\017\\\fLX\016\\\016dJ\024\033\020lU@X\001rJ\t[\017!K\005D\035hK\005QHr\\\022C\001b\\Z\025";
        i = 47;
        localObject1 = arrayOfString;
        break;
      case 47: 
        localObject3[i4] = localObject1;
        j = 49;
        localObject2 = "t\006eK\017\\\fLX\016\\\016dJ\024\033\020lU@X\001rJ\t[\017!K\005D\035hK\005QH`Z\024\\\036hM\031\017H";
        i = 48;
        localObject1 = arrayOfString;
        break;
      case 48: 
        localObject3[i4] = localObject1;
        j = 50;
        localObject2 = "t\006eK\017\\\fLX\016\\\016dJ\024\033\020lU@X\001rJ\t[\017!X\003A\001wP\024LR!";
        i = 49;
        localObject1 = arrayOfString;
        break;
      case 49: 
        localObject3[i4] = localObject1;
        j = 51;
        localObject2 = "V\006/S\020@\033i\027\001[\fsV\tQFhW\024P\006u\027$T\rlV\016f\rsO\tV\r";
        i = 50;
        localObject1 = arrayOfString;
        break;
      case 50: 
        localObject3[i4] = localObject1;
        j = 52;
        localObject2 = "T\013uP\017[RbQ\005V\003WX\f\\\fLX\016\\\016dJ\024";
        i = 51;
        localObject1 = arrayOfString;
        break;
      case 51: 
        localObject3[i4] = localObject1;
        j = 53;
        localObject2 = "V\006/S\020@\033i\027\001[\fsV\tQFtPNe\035rQ!V\034hO\tA\021";
        i = 52;
        localObject1 = arrayOfString;
        break;
      case 52: 
        localObject3[i4] = localObject1;
        j = 54;
        localObject2 = "l\007t\031\027\\\004m\031\025[\tcU\005\025\034n\031\025F\r!I\017EEvP\016Q\007v\031\022\\\013i\031\020@\033i\031\024L\030d\027";
        i = 53;
        localObject1 = arrayOfString;
        break;
      case 53: 
        localObject3[i4] = localObject1;
        j = 55;
        localObject2 = "t\006eK\017\\\fLX\016\\\016dJ\024\033\020lU@X\001rJ\t[\017!P\016A\roM@S\001mM\005GHgV\022\025,`\\\rZ\006R\\\022C\001b\\Z\025\013o\027\nE\035rQNT\006eK\017\\\f/P\016A\roMNq\tdT\017[;dK\026\\\013d";
        i = 54;
        localObject1 = arrayOfString;
        break;
      case 54: 
        localObject3[i4] = localObject1;
        j = 56;
        localObject2 = "t\006eK\017\\\fLX\016\\\016dJ\024\033\020lU@X\001rJ\t[\017!K\005D\035hK\005QHhW\024P\006u\031\006\\\004u\\\022\025\016nK@e\035rQ!V\034hO\tA\021;\031\003[FkI\025F\000/X\016Q\032nP\004\033\035h\0270@\033ix\003A\001wP\024L";
        i = 55;
        localObject1 = arrayOfString;
        break;
      case 55: 
        localObject3[i4] = localObject1;
        j = 57;
        localObject2 = "W\007e@";
        i = 56;
        localObject1 = arrayOfString;
        break;
      case 56: 
        localObject3[i4] = localObject1;
        j = 58;
        localObject2 = "`\006jW\017B\006";
        i = 57;
        localObject1 = arrayOfString;
        break;
      case 57: 
        localObject3[i4] = localObject1;
        j = 59;
        localObject2 = "V\007l\027\001[\fsV\tQFmX\025[\013i\\\022\033\tbM\tZ\006/p.f<@u,j;Iv2a+Tm";
        i = 58;
        localObject1 = arrayOfString;
        break;
      case 58: 
        localObject3[i4] = localObject1;
        j = 60;
        localObject2 = "T\006eK\017\\\f/P\016A\roMNT\013uP\017[FWp%b";
        i = 59;
        localObject1 = arrayOfString;
        break;
      case 59: 
        localObject3[i4] = localObject1;
        j = 61;
        localObject2 = "`\006dA\020P\013u\\\004\017HhW\026T\004h]@@\032m\031M\025";
        i = 60;
        localObject1 = arrayOfString;
        break;
      case 60: 
        localObject3[i4] = localObject1;
        j = 62;
        localObject2 = "T\006eK\017\\\f/P\016A\roMNP\020uK\001\033\033iV\022A\013tMN|&U|.a";
        i = 61;
        localObject1 = arrayOfString;
        break;
      case 61: 
        localObject3[i4] = localObject1;
        j = 63;
        localObject2 = "T\006eK\017\\\f/P\016A\roMNP\020uK\001\033\033iV\022A\013tMN{)L|";
        i = 62;
        localObject1 = arrayOfString;
        break;
      case 62: 
        localObject3[i4] = localObject1;
        j = 64;
        localObject2 = "Q\035qU\tV\tu\\";
        i = 63;
        localObject1 = arrayOfString;
        break;
      case 63: 
        localObject3[i4] = localObject1;
        j = 65;
        localObject2 = "V\032dX\024P;iV\022A+tM@P\032sV\022\017";
        i = 64;
        localObject1 = arrayOfString;
        break;
      case 64: 
        localObject3[i4] = localObject1;
        j = 66;
        localObject2 = "T\006eK\017\\\f/P\016A\roMNP\020uK\001\033\033iV\022A\013tMN|+Nw?g-Rv5g+D";
        i = 65;
        localObject1 = arrayOfString;
        break;
      case 65: 
        localObject3[i4] = localObject1;
        j = 67;
        localObject2 = "\\\033TI\004T\034do\005G\033hV\016";
        i = 66;
        localObject1 = arrayOfString;
        break;
      case 66: 
        localObject3[i4] = localObject1;
        j = 68;
        localObject2 = "F\ro]\"G\007`]\003T\033u\031\005G\032nKZ";
        i = 67;
        localObject1 = arrayOfString;
        break;
      case 67: 
        localObject3[i4] = localObject1;
        j = 69;
        localObject2 = "w\035o]\fPHrQ\017@\004e\031\016Z\034![\005\025\006tU\f\025\016nK@F\ro]\"G\007`]\003T\033u\027";
        i = 68;
        localObject1 = arrayOfString;
        break;
      case 68: 
        localObject3[i4] = localObject1;
        j = 70;
        localObject2 = "\031\tbM\tZ\006;";
        i = 69;
        localObject1 = arrayOfString;
        break;
      case 69: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = new ArrayList();
        return;
        i = 53;
        continue;
        i = 104;
        continue;
        i = 1;
        continue;
        i = 57;
      }
    }
  }
  
  public static Intent a(Context paramContext, c paramc)
  {
    paramContext = new Intent(paramContext, PopWinActivity.class);
    paramContext.putExtra(z[57], paramc);
    paramContext.addFlags(335544320);
    return paramContext;
  }
  
  public static Intent a(Context paramContext, c paramc, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra(z[67], false);
    localIntent.putExtra(z[57], paramc);
    localIntent.setAction(z[53]);
    localIntent.addCategory(paramContext.getPackageName());
    localIntent.addFlags(536870912);
    return localIntent;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str3 = Build.VERSION.RELEASE + "," + Integer.toString(Build.VERSION.SDK_INT);
    String str4 = Build.MODEL;
    String str5 = i.a(paramContext, z[42], z[39]);
    String str6 = Build.DEVICE;
    String str2 = JCoreInterface.getChannel();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = " ";
    }
    str2 = f(paramContext);
    paramContext = new JSONObject();
    try
    {
      paramContext.put(z[40], str3);
      paramContext.put(z[43], str4);
      paramContext.put(z[39], str5);
      paramContext.put(z[41], str6);
      paramContext.put(z[44], str1);
      paramContext.put(z[38], str2);
      paramContext.put(z[45], paramString);
      return paramContext.toString();
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
  }
  
  private static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      f.j(z[6], z[69]);
      return;
    }
    try
    {
      Intent localIntent = new Intent(paramString);
      paramBundle.putString(z[31], JCoreInterface.getAppKey());
      localIntent.putExtras(paramBundle);
      paramBundle = paramContext.getPackageName();
      localIntent.addCategory(paramBundle);
      paramContext.sendBroadcast(localIntent, String.format(z[35], new Object[] { paramBundle }));
      return;
    }
    catch (Exception paramContext)
    {
      f.h(z[6], z[68] + paramContext.getMessage() + z[70] + paramString);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    String str = z[8];
    Bundle localBundle = new Bundle();
    if (str != null) {
      localBundle.putString(str, paramString2);
    }
    a(paramContext, paramString1, localBundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = Uri.parse(paramString2);
    if (localObject == null)
    {
      f.c(z[6], z[61] + paramString2);
      return;
    }
    paramString2 = new Intent(z[60], (Uri)localObject);
    paramString2.setFlags(335544320);
    try
    {
      localObject = Intent.ShortcutIconResource.fromContext(paramContext, paramInt);
      Intent localIntent = new Intent(z[59]);
      localIntent.putExtra(z[64], false);
      localIntent.putExtra(z[63], paramString1);
      localIntent.putExtra(z[62], paramString2);
      localIntent.putExtra(z[66], (Parcelable)localObject);
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      f.h(z[6], z[65] + paramContext.getMessage());
    }
  }
  
  public static void a(WebSettings paramWebSettings)
  {
    paramWebSettings.setUseWideViewPort(true);
    paramWebSettings.setLoadWithOverviewMode(true);
    paramWebSettings.setDomStorageEnabled(true);
    paramWebSettings.setJavaScriptEnabled(true);
    paramWebSettings.setDefaultTextEncodingName(z[46]);
    paramWebSettings.setSupportZoom(true);
    paramWebSettings.setBuiltInZoomControls(true);
    if (Build.VERSION.SDK_INT >= 11) {
      paramWebSettings.setDisplayZoomControls(false);
    }
    paramWebSettings.setCacheMode(2);
    paramWebSettings.setSaveFormData(false);
    paramWebSettings.setSavePassword(false);
  }
  
  public static boolean a()
  {
    boolean bool = Environment.getExternalStorageState().equals(z[12]);
    if (!bool) {
      f.c(z[6], z[11]);
    }
    return bool;
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService(z[47])).getActiveNetworkInfo();
      if (paramContext != null)
      {
        boolean bool = paramContext.isConnected();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean a(Context paramContext, Class<?> paramClass)
  {
    return !paramContext.getPackageManager().queryIntentActivities(new Intent(paramContext, paramClass), 0).isEmpty();
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramString = new Intent(paramString);
    paramString.addCategory(paramContext.getPackageName());
    return !localPackageManager.queryBroadcastReceivers(paramString, 0).isEmpty();
  }
  
  public static void b(Context paramContext)
  {
    d(paramContext, null);
  }
  
  public static void b(Context paramContext, c paramc)
  {
    try
    {
      Intent localIntent = new Intent(z[32]);
      localIntent.putExtra(z[31], paramc.n);
      localIntent.putExtra(z[28], paramc.i);
      localIntent.putExtra(z[34], paramc.j);
      localIntent.putExtra(z[36], paramc.k);
      localIntent.putExtra(z[8], paramc.l);
      localIntent.putExtra(z[37], paramc.c);
      if (paramc.a()) {
        localIntent.putExtra(z[33], paramc.G);
      }
      localIntent.addCategory(paramc.m);
      paramContext.sendBroadcast(localIntent, String.format(z[35], new Object[] { paramc.m }));
      f.e(z[6], z[29] + String.format(z[35], new Object[] { paramc.m }));
      b.a(paramc.c, 1018, paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      f.i(z[6], z[30] + paramContext.getMessage());
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if (paramContext != null) {}
    int i;
    do
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          throw new IllegalArgumentException(z[27]);
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
    } while (i != 0);
    return true;
  }
  
  public static boolean c(Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        if (!MultiSpHelper.getBoolean(paramContext, z[1], true))
        {
          f.f(z[6], z[3]);
          return false;
        }
        paramContext = e.b(paramContext);
        if (TextUtils.isEmpty(paramContext))
        {
          f.e(z[6], z[2]);
          return true;
        }
        f.e(z[6], z[0] + paramContext);
        Object localObject = paramContext.split("_");
        char[] arrayOfChar = localObject[0];
        localObject = localObject[1];
        arrayOfChar = arrayOfChar.toCharArray();
        localObject = ((String)localObject).split(z[5]);
        Calendar localCalendar = Calendar.getInstance();
        int j = localCalendar.get(7);
        int k = localCalendar.get(11);
        int m = arrayOfChar.length;
        i = 0;
        if (i < m)
        {
          if (j == Integer.valueOf(String.valueOf(arrayOfChar[i])).intValue() + 1)
          {
            int n = Integer.valueOf(localObject[0]).intValue();
            int i1 = Integer.valueOf(localObject[1]).intValue();
            if ((k >= n) && (k <= i1)) {
              return true;
            }
          }
        }
        else
        {
          f.f(z[6], z[4] + paramContext);
          return false;
        }
      }
      catch (Exception paramContext)
      {
        return true;
      }
      i += 1;
    }
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = new ComponentName(paramContext.getPackageName(), paramString);
    try
    {
      localPackageManager.getReceiverInfo(paramContext, 128);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static void d(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(z[10]);
    String str = paramContext.getPackageName();
    localIntent.setPackage(str);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra(z[8], paramString);
    }
    localIntent.addCategory(z[9]);
    paramString = paramContext.getPackageManager().resolveActivity(localIntent, 0);
    f.e(z[6], z[7] + paramString.activityInfo.name);
    localIntent.setClassName(str, paramString.activityInfo.name);
    localIntent.setFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean d(Context paramContext)
  {
    f.c(z[6], z[17]);
    paramContext = MultiSpHelper.getString(paramContext, z[13], "");
    if (TextUtils.isEmpty(paramContext)) {
      return false;
    }
    for (;;)
    {
      int i;
      int j;
      int k;
      int m;
      int n;
      int i1;
      try
      {
        paramContext = new JSONObject(paramContext);
        i = paramContext.optInt(z[19], -1);
        j = paramContext.optInt(z[24], -1);
        k = paramContext.optInt(z[16], -1);
        m = paramContext.optInt(z[26], -1);
        if ((i < 0) || (j < 0) || (k < 0) || (m < 0) || (j > 59) || (m > 59) || (k > 23) || (i > 23)) {
          break;
        }
        paramContext = Calendar.getInstance();
        n = paramContext.get(11);
        i1 = paramContext.get(12);
        f.a(z[6], z[22] + n + z[23] + i1 + z[18] + i + z[15] + j + z[25] + k + z[20] + m);
        if (i < k)
        {
          if ((n > i) && (n < k))
          {
            f.f(z[6], z[14] + i + ":" + j + z[21] + k + ":" + m);
            return true;
          }
        }
        else
        {
          if (i == k)
          {
            if (j >= m)
            {
              if ((n != i) || (i1 <= m) || (i1 >= j)) {
                continue;
              }
              return false;
            }
            if ((n != i) || (i1 < j)) {
              break;
            }
            if (i1 <= m) {
              continue;
            }
            return false;
          }
          if (i <= k) {
            break;
          }
          if (((n > i) && (n <= 23)) || ((n >= 0) && (n < k)) || ((n == i) && (i1 >= j))) {
            continue;
          }
          if (n != k) {
            break;
          }
          if (i1 <= m) {
            continue;
          }
          return false;
        }
      }
      catch (JSONException paramContext)
      {
        return false;
      }
      if ((n != i) || (i1 < j)) {
        if ((n != k) || (i1 > m)) {
          break;
        }
      }
    }
  }
  
  public static boolean e(Context paramContext)
  {
    f.d(z[6], z[52]);
    if (paramContext.getPackageManager().queryIntentServices(new Intent(paramContext, DaemonService.class), 0).isEmpty())
    {
      i = 0;
      if (i != 0) {
        break label137;
      }
      f.h(z[6], z[48] + DaemonService.class.getCanonicalName());
      JCoreInterface.setCanLaunchedStoppedService(false);
    }
    for (;;)
    {
      if (a(paramContext, PushActivity.class)) {
        break label221;
      }
      f.j(z[6], z[49] + PushActivity.class.getCanonicalName());
      return false;
      i = 1;
      break;
      label137:
      localObject = z[51];
      localPackageManager = paramContext.getPackageManager();
      localObject = new Intent((String)localObject);
      ((Intent)localObject).addCategory(paramContext.getPackageName());
      if (localPackageManager.queryIntentServices((Intent)localObject, 0).isEmpty()) {}
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label214;
        }
        f.h(z[6], z[55]);
        JCoreInterface.setCanLaunchedStoppedService(false);
        break;
      }
      label214:
      JCoreInterface.setCanLaunchedStoppedService(true);
    }
    label221:
    if (!a(paramContext, PopWinActivity.class))
    {
      f.h(z[6], z[50] + PopWinActivity.class.getCanonicalName());
      f.h(z[6], z[54]);
    }
    Object localObject = z[53];
    PackageManager localPackageManager = paramContext.getPackageManager();
    localObject = new Intent((String)localObject);
    ((Intent)localObject).addCategory(paramContext.getPackageName());
    if (localPackageManager.queryIntentActivities((Intent)localObject, 0).isEmpty()) {}
    for (int i = 0; i == 0; i = 1)
    {
      f.j(z[6], z[56]);
      return false;
    }
    return true;
  }
  
  private static String f(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService(z[47])).getActiveNetworkInfo();
      if (paramContext == null) {
        return z[58];
      }
      String str1 = paramContext.getTypeName();
      String str2 = paramContext.getSubtypeName();
      if (str1 == null) {
        return z[58];
      }
      paramContext = str1;
      if (!TextUtils.isEmpty(str2))
      {
        paramContext = str1 + "," + str2;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = z[58];
    }
    return paramContext;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */