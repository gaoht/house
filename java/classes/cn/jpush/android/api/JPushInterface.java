package cn.jpush.android.api;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.a.b;
import cn.jpush.android.a.k;
import cn.jpush.android.c.f;
import cn.jpush.android.d;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.e;
import cn.jpush.android.service.ServiceInterface;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JPushInterface
{
  public static final String ACTION_ACTIVITY_OPENDED;
  public static final String ACTION_CONNECTION_CHANGE;
  public static final String ACTION_MESSAGE_RECEIVED;
  public static final String ACTION_NOTIFICATION_CLICK_ACTION;
  public static final String ACTION_NOTIFICATION_OPENED;
  public static final String ACTION_NOTIFICATION_RECEIVED;
  public static final String ACTION_NOTIFICATION_RECEIVED_PROXY;
  public static final String ACTION_REGISTRATION_ID;
  public static final String ACTION_RESTOREPUSH;
  public static final String ACTION_RICHPUSH_CALLBACK;
  public static final String ACTION_STATUS;
  public static final String ACTION_STOPPUSH;
  public static final String EXTRA_ACTIVITY_PARAM;
  public static final String EXTRA_ALERT;
  public static final String EXTRA_APP_KEY;
  public static final String EXTRA_BIG_PIC_PATH;
  public static final String EXTRA_BIG_TEXT;
  public static final String EXTRA_CONNECTION_CHANGE;
  public static final String EXTRA_CONTENT_TYPE;
  public static final String EXTRA_EXTRA;
  public static final String EXTRA_INBOX;
  public static final String EXTRA_MESSAGE;
  public static final String EXTRA_MSG_ID;
  public static final String EXTRA_NOTIFICATION_ACTION_EXTRA;
  public static final String EXTRA_NOTIFICATION_DEVELOPER_ARG0;
  public static final String EXTRA_NOTIFICATION_ID;
  public static final String EXTRA_NOTIFICATION_TITLE;
  public static final String EXTRA_NOTI_CATEGORY;
  public static final String EXTRA_NOTI_PRIORITY;
  public static final String EXTRA_NOTI_TYPE;
  public static final String EXTRA_PUSH_ID;
  public static final String EXTRA_REGISTRATION_ID;
  public static final String EXTRA_RICHPUSH_FILE_PATH;
  public static final String EXTRA_RICHPUSH_FILE_TYPE;
  public static final String EXTRA_RICHPUSH_HTML_PATH;
  public static final String EXTRA_RICHPUSH_HTML_RES;
  public static final String EXTRA_STATUS;
  public static final String EXTRA_TITLE;
  private static final Integer a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[54];
    int j = 0;
    Object localObject1 = ":4\005\013y,)COh7>Y\016`=te.]\020\005h ]\034\035d3P";
    int i = 53;
    Object localObject2 = arrayOfString;
    Object localObject4 = localObject2;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int i1 = 0;
    int m = 0;
    int i4 = i;
    Object localObject3 = localObject1;
    int i2 = j;
    localObject2 = localObject4;
    int n = k;
    int i3;
    if (k <= 1)
    {
      i3 = i;
      label65:
      n = m;
      label68:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 9;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label68;
        EXTRA_NOTI_CATEGORY = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=th.G\027\037h5@\026\024t\"A\030\024l$";
        i = 54;
        j = i2;
        break;
        EXTRA_CONNECTION_CHANGE = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tj\"]\020\fb5P\006\nj3H\024";
        i = 55;
        j = i2;
        break;
        EXTRA_ACTIVITY_PARAM = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=ty$N\020\t3H\r\023d/V\020\036";
        i = 56;
        j = i2;
        break;
        EXTRA_REGISTRATION_ID = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tf$Z\n\033l$";
        i = 57;
        j = i2;
        break;
        EXTRA_MESSAGE = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tB\017}<4_OD\034\tx N\034\005y$J\034\023}$M";
        i = 58;
        j = i2;
        break;
        ACTION_MESSAGE_RECEIVED = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tm(E\034\005{ ]\021";
        i = 59;
        j = i2;
        break;
        EXTRA_RICHPUSH_FILE_PATH = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=te.]\020\034b J\030\016b.G\006\033h5@\026\024t$Q\r\bj";
        i = 60;
        j = i2;
        break;
        EXTRA_NOTIFICATION_ACTION_EXTRA = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=ti(N\006\nb\"V\t\033)";
        i = 61;
        j = i2;
        break;
        EXTRA_BIG_PIC_PATH = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tm(E\034\0058Y\034";
        i = 62;
        j = i2;
        break;
        EXTRA_RICHPUSH_FILE_TYPE = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=th.G\r\037e5V\r\003{$";
        i = 63;
        j = i2;
        break;
        EXTRA_CONTENT_TYPE = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tf2N\006\023o";
        i = 64;
        j = i2;
        break;
        EXTRA_MSG_ID = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tn9]\013\033";
        i = 65;
        j = i2;
        break;
        EXTRA_EXTRA = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tB\017}<4_OJ\026\024e$J\r\023d/";
        i = 66;
        j = i2;
        break;
        ACTION_CONNECTION_CHANGE = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tB\017}<4_OG\026\016b'@\032\033(F\027\005d1L\027\037o";
        i = 67;
        j = i2;
        break;
        ACTION_NOTIFICATION_OPENED = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tB\017}<4_OH\032\016b.G\006\bb\"A\t\017x)V\032\033g-K\030\031`";
        i = 68;
        j = i2;
        break;
        ACTION_RICHPUSH_CALLBACK = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tx5H\r\017x";
        i = 69;
        j = i2;
        break;
        EXTRA_STATUS = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=te.]\020\034b\"H\r\023d/V\020\036";
        i = 70;
        j = i2;
        break;
        EXTRA_NOTIFICATION_ID = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=t{4Z\021\005b%";
        i = 71;
        j = i2;
        break;
        EXTRA_PUSH_ID = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=te.]\020\005{3@\026\bb5P";
        i = 72;
        j = i2;
        break;
        EXTRA_NOTI_PRIORITY = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=te.]\020\034b\"H\r\023d/V\035\037}$E\026\nn3V\030\blQ";
        i = 73;
        j = i2;
        break;
        EXTRA_NOTIFICATION_DEVELOPER_ARG0 = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tB\017}<4_OZ\r\0334Z";
        i = 74;
        j = i2;
        break;
        ACTION_STATUS = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tc5D\025\005y$Z";
        i = 75;
        j = i2;
        break;
        EXTRA_RICHPUSH_HTML_RES = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tB\017}<4_OH\032\016b.G\006\033h5@\017\0238V\026\nn/M\034\036";
        i = 76;
        j = i2;
        break;
        ACTION_ACTIVITY_OPENDED = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tB\017}<4_OG\026\016b'@\032\033(F\027\005y$J\034\023}$M";
        i = 77;
        j = i2;
        break;
        ACTION_NOTIFICATION_RECEIVED = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tB\017}<4_OZ\r\025{1\\\n\022";
        i = 78;
        j = i2;
        break;
        ACTION_STOPPUSH = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tb/K\026\002";
        i = 79;
        j = i2;
        break;
        EXTRA_INBOX = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=t(]\025\037";
        i = 80;
        j = i2;
        break;
        EXTRA_TITLE = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tc5D\025\005{ ]\021";
        i = 81;
        j = i2;
        break;
        EXTRA_RICHPUSH_HTML_PATH = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=te.]\020\034b\"H\r\023d/V\032\025e5L\027\016t5@\r\026n";
        i = 82;
        j = i2;
        break;
        EXTRA_NOTIFICATION_TITLE = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tB\017}<4_O[\034\t.[\034\n~2A";
        i = 83;
        j = i2;
        break;
        ACTION_RESTOREPUSH = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tj1Y\022\037r";
        i = 84;
        j = i2;
        break;
        EXTRA_APP_KEY = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=ti(N\006\016n9]";
        i = 85;
        j = i2;
        break;
        EXTRA_BIG_TEXT = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tj-L\013\016";
        i = 86;
        j = i2;
        break;
        EXTRA_ALERT = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tB\017}<4_O[\034\035b2]\013\033(F\027";
        i = 87;
        j = i2;
        break;
        ACTION_REGISTRATION_ID = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tB\017}<4_OG\026\016b'@\032\033(F\027\005h-@\032\021t J\r\023d/";
        i = 88;
        j = i2;
        break;
        ACTION_NOTIFICATION_CLICK_ACTION = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=te.]\020\034b\"H\r\023d/V\r\003{$";
        i = 89;
        j = i2;
        break;
        EXTRA_NOTI_TYPE = (String)localObject1;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tB\017}<4_OG\026\016b'@\032\033(F\027\005y$J\034\023}$M\006\ny.Q\000";
        i = 90;
        j = i2;
        break;
        ACTION_NOTIFICATION_RECEIVED_PROXY = (String)localObject1;
        localObject1 = "\n?_AZ06N\017j<z{\024z1\016B\fly\034J\be<>";
        i = -1;
        j = i2;
        break;
      }
      i1 = n;
      n = k;
      localObject2 = localObject4;
      i2 = j;
      localObject3 = localObject1;
      i4 = i3;
      i3 = i4;
      localObject1 = localObject3;
      j = i2;
      localObject4 = localObject2;
      k = n;
      m = i1;
      if (n > i1) {
        break label65;
      }
      localObject1 = new String((char[])localObject3).intern();
      switch (i4)
      {
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
      case 60: 
      case 61: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
      case 68: 
      case 69: 
      case 70: 
      case 71: 
      case 72: 
      case 73: 
      case 74: 
      case 75: 
      case 76: 
      case 77: 
      case 78: 
      case 79: 
      case 80: 
      case 81: 
      case 82: 
      case 83: 
      case 84: 
      case 85: 
      case 86: 
      case 87: 
      case 88: 
      case 89: 
      case 90: 
      default: 
        localObject2[i2] = localObject1;
        j = 1;
        localObject1 = "y`\013";
        i = 0;
        localObject2 = arrayOfString;
        break;
      case 0: 
        localObject2[i2] = localObject1;
        j = 2;
        localObject1 = "\0204]\000e0>\013\021h+;F\004}<(\013\007f+7J\025%y)_\000{-\022D\024{y;E\005)<4O)f,(\013\022a6/G\005);?_\026l<4\013Q)'z\031R%y)_\000{-\027B\017zy;E\005)<4O,`7)\013\022a6/G\005);?_\026l<4\013Q)'z\036X'y";
        i = 1;
        localObject2 = arrayOfString;
        break;
      case 1: 
        localObject2[i2] = localObject1;
        j = 3;
        localObject1 = "\023\n^\022a\0204_\004{?;H\004";
        i = 2;
        localObject2 = arrayOfString;
        break;
      case 2: 
        localObject2[i2] = localObject1;
        j = 4;
        localObject1 = "yw\006A";
        i = 3;
        localObject2 = arrayOfString;
        break;
      case 3: 
        localObject2[i2] = localObject1;
        j = 5;
        localObject1 = "\n?_AZ06N\017j<z{\024z1\016B\flyw\013";
        i = 4;
        localObject2 = arrayOfString;
        break;
      case 4: 
        localObject2[i2] = localObject1;
        j = 6;
        localObject1 = "\013?F\016<z_\tly)B\rl79NA}07N@";
        i = 5;
        localObject2 = arrayOfString;
        break;
      case 5: 
        localObject2[i2] = localObject1;
        j = 7;
        localObject1 = "89_\bf7`X\004}\t/X\tG6.B\007`:;_\bf7\030^\be=?YA$y3O[";
        i = 6;
        localObject2 = arrayOfString;
        break;
      case 6: 
        localObject2[i2] = localObject1;
        j = 8;
        localObject1 = "\027\017g-))/X\tG6.B\007`:;_\bf7\030^\be=?Y";
        i = 7;
        localObject2 = arrayOfString;
        break;
      case 7: 
        localObject2[i2] = localObject1;
        j = 9;
        localObject1 = "0>\013\022a6/G\005);?\013\rh+=N\023)-2J\017)i";
        i = 8;
        localObject2 = arrayOfString;
        break;
      case 8: 
        localObject2[i2] = localObject1;
        j = 10;
        localObject1 = "y2J\022)75_Ak<?EAz<.\013\bgy#D\024{y;[\021%y/X\004)=?M\000|5.\013\003|06O\004{x";
        i = 9;
        localObject2 = arrayOfString;
        break;
      case 9: 
        localObject2[i2] = localObject1;
        j = 11;
        localObject1 = "\r2NAk,3G\005l+z\\\b}1zB\0053";
        i = 10;
        localObject2 = arrayOfString;
        break;
      case 10: 
        localObject2[i2] = localObject1;
        j = 12;
        localObject1 = "\0309_\bf7`N\017h;6N/f-3M\bj8.B\016g";
        i = 11;
        localObject2 = arrayOfString;
        break;
      case 11: 
        localObject2[i2] = localObject1;
        j = 13;
        localObject1 = "75_\bo09J\025`64t\004g88G\004m";
        i = 12;
        localObject2 = arrayOfString;
        break;
      case 12: 
        localObject2[i2] = localObject1;
        j = 14;
        localObject1 = "q\001\033L0\004&\032:9tcv\035;\002j\006RTp\006uIRiw\022<uh\001\033L0\004&\031:9tivH";
        i = 13;
        localObject2 = arrayOfString;
        break;
      case 13: 
        localObject2[i2] = localObject1;
        j = 15;
        localObject1 = "89_\bf7`X\004}\t/X\t]07NA$y?E\000k5?O[";
        i = 14;
        localObject2 = arrayOfString;
        break;
      case 14: 
        localObject2[i2] = localObject1;
        j = 16;
        localObject1 = "ts\000I";
        i = 15;
        localObject2 = arrayOfString;
        break;
      case 15: 
        localObject2[i2] = localObject1;
        j = 17;
        localObject1 = "p&\003";
        i = 16;
        localObject2 = arrayOfString;
        break;
      case 16: 
        localObject2[i2] = localObject1;
        j = 18;
        localObject1 = "\0306Y\004h=#\0132l-\n^\022a\r3F\004%y=B\027ly/[A$y";
        i = 17;
        localObject2 = arrayOfString;
        break;
      case 17: 
        localObject2[i2] = localObject1;
        j = 19;
        localObject1 = "ps";
        i = 18;
        localObject2 = arrayOfString;
        break;
      case 18: 
        localObject2[i2] = localObject1;
        j = 20;
        localObject1 = "\0204]\000e0>\013\025`4?\013\007f+7J\025)tz";
        i = 19;
        localObject2 = arrayOfString;
        break;
      case 19: 
        localObject2[i2] = localObject1;
        j = 21;
        localObject1 = "uz[\024z1\016B\flc";
        i = 20;
        localObject2 = arrayOfString;
        break;
      case 20: 
        localObject2[i2] = localObject1;
        j = 22;
        localObject1 = "89_\bf7`X\004}\t/X\t]07NA$y9G\016z<>";
        i = 21;
        localObject2 = arrayOfString;
        break;
      case 21: 
        localObject2[i2] = localObject1;
        j = 23;
        localObject1 = "q\001\033L?\004!\033M>$stI!";
        i = 22;
        localObject2 = arrayOfString;
        break;
      case 22: 
        localObject2[i2] = localObject1;
        j = 24;
        localObject1 = "\027\017g-)75_\bo09J\025`64";
        i = 23;
        localObject2 = arrayOfString;
        break;
      case 23: 
        localObject2[i2] = localObject1;
        j = 25;
        localObject1 = ":4\005\013y,)COh7>Y\016`=tB\017}<4_OD\f\026(V\t\bd\"L\n\t";
        i = 24;
        localObject2 = arrayOfString;
        break;
      case 24: 
        localObject2[i2] = localObject1;
        j = 26;
        localObject1 = "89_\bf7";
        i = 25;
        localObject2 = arrayOfString;
        break;
      case 25: 
        localObject2[i2] = localObject1;
        j = 27;
        localObject1 = "4/G\025`\006.R\021l";
        i = 26;
        localObject2 = arrayOfString;
        break;
      case 26: 
        localObject2[i2] = localObject1;
        j = 28;
        localObject1 = "55H\000e\0064D\025`?3H\000}05E>`=";
        i = 27;
        localObject2 = arrayOfString;
        break;
      case 27: 
        localObject2[i2] = localObject1;
        j = 29;
        localObject1 = "89_\bf7`X\025f)\n^\022a";
        i = 28;
        localObject2 = arrayOfString;
        break;
      case 28: 
        localObject2[i2] = localObject1;
        j = 30;
        localObject1 = "\0275\013\005l/?G\016y<(\013\002|*.D\f`#?OAk,3G\005l+t\0134z<zO\004o8/G\025)64NO";
        i = 29;
        localObject2 = arrayOfString;
        break;
      case 29: 
        localObject2[i2] = localObject1;
        j = 31;
        localObject1 = "89_\bf7`L\004}\t/X\tG6.B\007`:;_\bf7\030^\be=?YA3y";
        i = 30;
        localObject2 = arrayOfString;
        break;
      case 30: 
        localObject2[i2] = localObject1;
        j = 32;
        localObject1 = "菮厌讛弴k,3G\005l+冠锲@";
        i = 31;
        localObject2 = arrayOfString;
        break;
      case 31: 
        localObject2[i2] = localObject1;
        j = 33;
        localObject1 = "89_\bf7`Y\004z,7N1|*2";
        i = 32;
        localObject2 = arrayOfString;
        break;
      case 32: 
        localObject2[i2] = localObject1;
        j = 34;
        localObject1 = "89_\bf7`X\004}\025;_\004z-\024D\025`?3H\000}05E/|48N\023)cz";
        i = 33;
        localObject2 = arrayOfString;
        break;
      case 33: 
        localObject2[i2] = localObject1;
        j = 35;
        localObject1 = "4;S/|4zX\tf,6OA7yj\007AN0,NA|)zJ\002}05EO'";
        i = 34;
        localObject2 = arrayOfString;
        break;
      case 34: 
        localObject2[i2] = localObject1;
        j = 36;
        localObject1 = "\027\017g-):5E\025l!.";
        i = 35;
        localObject2 = arrayOfString;
        break;
      case 35: 
        localObject2[i2] = localObject1;
        j = 37;
        localObject1 = "\0204]\000e0>\013\005h zM\016{4;_A$y";
        i = 36;
        localObject2 = arrayOfString;
        break;
      case 36: 
        localObject2[i2] = localObject1;
        j = 38;
        localObject1 = "ik\031R=lltQWki";
        i = 37;
        localObject2 = arrayOfString;
        break;
      case 37: 
        localObject2[i2] = localObject1;
        j = 39;
        localObject1 = "梙洑创弲剄泸杓罺纽》欽勲佷屧圡材缋绷斗臣勱纽细戆衅せ";
        i = 38;
        localObject2 = arrayOfString;
        break;
      case 38: 
        localObject2[i2] = localObject1;
        j = 40;
        localObject1 = "\0204]\000e0>\013\025`4?\013\007f+7J\025)tzX\025h+.c\016|+zX\tf,6OAe<)XA}1;EAl7>c\016|+";
        i = 39;
        localObject2 = arrayOfString;
        break;
      case 39: 
        localObject2[i2] = localObject1;
        j = 41;
        localObject1 = ">?_3l:5Y\005Y,)C/f-3M\bj8.B\016g\033/B\rm<(\013L)";
        i = 40;
        localObject2 = arrayOfString;
        break;
      case 40: 
        localObject2[i2] = localObject1;
        j = 42;
        localObject1 = "\032/X\025f43Q\004my8^\be=?YAo+5FAz8,N\005))(N\007l+?E\002lyw\013";
        i = 41;
        localObject2 = arrayOfString;
        break;
      case 41: 
        localObject2[i2] = localObject1;
        j = 43;
        localObject1 = ";;X\bj";
        i = 42;
        localObject2 = arrayOfString;
        break;
      case 42: 
        localObject2[i2] = localObject1;
        j = 44;
        localObject1 = ":/X\025f4";
        i = 43;
        localObject2 = arrayOfString;
        break;
      case 43: 
        localObject2[i2] = localObject1;
        j = 45;
        localObject1 = "3*^\022a\006)J\027l\0069^\022}67t\003|06O\004{";
        i = 44;
        localObject2 = arrayOfString;
        break;
      case 44: 
        localObject2[i2] = localObject1;
        j = 46;
        localObject1 = "*?X\022l05EA}07N\016|-zG\000{>?YA}1;EA8=;R";
        i = 45;
        localObject2 = arrayOfString;
        break;
      case 45: 
        localObject2[i2] = localObject1;
        j = 47;
        localObject1 = "*?X\022l05EA}07N\016|-zG\004z*z_\th7z\032Qz";
        i = 46;
        localObject2 = arrayOfString;
        break;
      case 46: 
        localObject2[i2] = localObject1;
        j = 48;
        localObject1 = "\002(N\020|<)_1l+7B\022z05E<),4N\031j<*_\004myw\013\002f7.N\031}y-J\022)7/G\r";
        i = 47;
        localObject2 = arrayOfString;
        break;
      case 47: 
        localObject2[i2] = localObject1;
        j = 49;
        localObject1 = "uzI\024`5>b\0053jh\030";
        i = 48;
        localObject2 = arrayOfString;
        break;
      case 48: 
        localObject2[i2] = localObject1;
        j = 50;
        localObject1 = "89_\bf7`B\017`-z\006Az=1}\004{*3D\0173";
        i = 49;
        localObject2 = arrayOfString;
        break;
      case 49: 
        localObject2[i2] = localObject1;
        j = 51;
        localObject1 = "75_\bo09J\025`64";
        i = 50;
        localObject2 = arrayOfString;
        break;
      case 50: 
        localObject2[i2] = localObject1;
        j = 52;
        localObject1 = "\0204]\000e0>\013\017f-3M\bj8.B\016g\020>\007AN0,NA|)zJ\002}05EO'";
        i = 51;
        localObject2 = arrayOfString;
        break;
      case 51: 
        localObject2[i2] = localObject1;
        j = 53;
        localObject1 = "\r2NAd*=b\005)0)\013\017f-z]\000e0>\013L)";
        i = 52;
        localObject2 = arrayOfString;
        break;
      case 52: 
        localObject2[i2] = localObject1;
        z = arrayOfString;
        a = Integer.valueOf(0);
        JCoreInterface.initAction(d.a, cn.jpush.android.a.a.class);
        return;
        i = 89;
        continue;
        i = 90;
        continue;
        i = 43;
        continue;
        i = 97;
      }
    }
  }
  
  private static PushNotificationBuilder a(String paramString)
  {
    f.a(z[3], z[41] + paramString);
    paramString = MultiSpHelper.getString(d.e, z[45] + paramString, "");
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    f.a(z[3], z[42] + paramString);
    if ((paramString.startsWith(z[43])) || (paramString.startsWith(z[44]))) {
      return BasicPushNotificationBuilder.a(paramString);
    }
    return MultiActionsNotificationBuilder.parseFromPreference(paramString);
  }
  
  private static void a(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException(z[36]);
    }
  }
  
  private static void a(Context paramContext, boolean paramBoolean, String paramString)
  {
    f.c(z[3], z[12]);
    MultiSpHelper.commitBoolean(paramContext, z[13], paramBoolean);
    if (!paramBoolean)
    {
      f.d(z[3], z[22]);
      return;
    }
    String str = z[14];
    if (Pattern.compile(z[23] + str + z[17] + str + z[16] + str + z[19]).matcher(paramString).matches())
    {
      str = e.b(paramContext);
      if (paramString.equals(str))
      {
        f.d(z[3], z[18] + str);
        return;
      }
      f.d(z[3], z[15] + paramBoolean + z[21] + paramString);
      e.b(paramContext, paramString, false);
      return;
    }
    f.j(z[3], z[20] + paramString);
  }
  
  static boolean a(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    if (a(paramInt) == null)
    {
      f.h(z[3], z[11] + paramInt + z[10]);
      return false;
    }
    return true;
  }
  
  public static void addLocalNotification(Context paramContext, JPushLocalNotification paramJPushLocalNotification)
  {
    a(paramContext);
    cn.jpush.android.service.a.a(paramContext).a(paramContext, paramJPushLocalNotification, false);
  }
  
  static PushNotificationBuilder b(int paramInt)
  {
    f.b(z[3], z[31] + paramInt);
    int i = paramInt;
    if (paramInt <= 0) {
      i = a.intValue();
    }
    try
    {
      PushNotificationBuilder localPushNotificationBuilder = a(i);
      Object localObject2 = localPushNotificationBuilder;
      if (localPushNotificationBuilder == null)
      {
        f.c(z[3], z[30]);
        localObject2 = new DefaultPushNotificationBuilder();
      }
      return (PushNotificationBuilder)localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        f.a(z[3], z[32], localException);
        Object localObject1 = null;
      }
    }
  }
  
  public static void clearAllNotifications(Context paramContext)
  {
    a(paramContext);
    ServiceInterface.b(paramContext);
  }
  
  public static void clearLocalNotifications(Context paramContext)
  {
    a(paramContext);
    Bundle localBundle = new Bundle();
    localBundle.putString(z[26], z[25]);
    localBundle.putInt(z[27], 8);
    JCoreInterface.sendAction(paramContext, d.a, localBundle);
  }
  
  public static void clearNotificationById(Context paramContext, int paramInt)
  {
    a(paramContext);
    if (paramInt <= 0)
    {
      f.j(z[3], z[52]);
      return;
    }
    ((NotificationManager)paramContext.getSystemService(z[51])).cancel(paramInt);
  }
  
  public static Set<String> filterValidTags(Set<String> paramSet)
  {
    return k.a(paramSet);
  }
  
  public static boolean getConnectionState(Context paramContext)
  {
    a(paramContext);
    return JCoreInterface.getConnectionState(paramContext);
  }
  
  public static String getRegistrationID(Context paramContext)
  {
    a(paramContext);
    return JCoreInterface.getRegistrationID(paramContext);
  }
  
  public static String getStringTags(Set<String> paramSet)
  {
    return k.b(paramSet);
  }
  
  public static String getUdid(Context paramContext)
  {
    a(paramContext);
    return JCoreInterface.getDeviceId(paramContext);
  }
  
  public static void init(Context paramContext)
  {
    f.d(z[3], z[50] + ServiceInterface.a() + z[49]);
    a(paramContext);
    if ((JCoreInterface.getDebugMode()) && (!cn.jpush.android.c.a.a(paramContext))) {
      f.d(z[3], z[39]);
    }
    if (!d.a(paramContext)) {
      return;
    }
    if (e.a(paramContext) == -1) {
      setLatestNotificationNumber(paramContext, 5);
    }
    ServiceInterface.a(paramContext);
  }
  
  public static void initCrashHandler(Context paramContext)
  {
    a(paramContext);
    JCoreInterface.initCrashHandler(paramContext);
  }
  
  public static boolean isPushStopped(Context paramContext)
  {
    a(paramContext);
    return ServiceInterface.c(paramContext);
  }
  
  public static void onFragmentPause(Context paramContext, String paramString)
  {
    a(paramContext);
    JCoreInterface.onFragmentPause(paramContext, paramString);
  }
  
  public static void onFragmentResume(Context paramContext, String paramString)
  {
    a(paramContext);
    JCoreInterface.onFragmentResume(paramContext, paramString);
  }
  
  public static void onKillProcess(Context paramContext)
  {
    JCoreInterface.onKillProcess(paramContext);
  }
  
  public static void onPause(Context paramContext)
  {
    a(paramContext);
    JCoreInterface.onPause(paramContext);
  }
  
  public static void onResume(Context paramContext)
  {
    a(paramContext);
    JCoreInterface.onResume(paramContext);
  }
  
  public static void removeLocalNotification(Context paramContext, long paramLong)
  {
    a(paramContext);
    Bundle localBundle = new Bundle();
    localBundle.putString(z[26], z[25]);
    localBundle.putInt(z[27], 7);
    localBundle.putLong(z[28], paramLong);
    JCoreInterface.sendAction(paramContext, d.a, localBundle);
  }
  
  public static void reportNotificationOpened(Context paramContext, String paramString)
  {
    a(paramContext);
    if (TextUtils.isEmpty(paramString)) {
      f.j(z[3], z[53] + paramString);
    }
    b.a(paramString, 1028, paramContext);
  }
  
  public static void requestPermission(Context paramContext)
  {
    if (paramContext == null)
    {
      f.h(z[3], z[48]);
      return;
    }
    JCoreInterface.requestPermission(paramContext);
  }
  
  public static void resumePush(Context paramContext)
  {
    f.d(z[3], z[33]);
    a(paramContext);
    ServiceInterface.b(paramContext, 1);
  }
  
  public static void setAlias(Context paramContext, String paramString, TagAliasCallback paramTagAliasCallback)
  {
    a(paramContext);
    setAliasAndTags(paramContext, paramString, null, paramTagAliasCallback);
  }
  
  public static void setAliasAndTags(Context paramContext, String paramString, Set<String> paramSet, TagAliasCallback paramTagAliasCallback)
  {
    a(paramContext);
    k.a(paramContext, paramString, paramSet, paramTagAliasCallback);
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    JCoreInterface.setDebugMode(paramBoolean);
  }
  
  public static void setDefaultPushNotificationBuilder(BasicPushNotificationBuilder paramBasicPushNotificationBuilder)
  {
    if (paramBasicPushNotificationBuilder == null) {
      throw new IllegalArgumentException(z[24]);
    }
    ServiceInterface.a(d.e, a, paramBasicPushNotificationBuilder);
  }
  
  public static void setLatestNotificationNumber(Context paramContext, int paramInt)
  {
    a(paramContext);
    f.d(z[3], z[34] + paramInt);
    if (paramInt <= 0)
    {
      f.j(z[3], z[35]);
      return;
    }
    ServiceInterface.c(paramContext, paramInt);
  }
  
  public static void setPushNotificationBuilder(Integer paramInteger, DefaultPushNotificationBuilder paramDefaultPushNotificationBuilder)
  {
    f.b(z[3], z[7] + paramInteger);
    if (paramDefaultPushNotificationBuilder == null) {
      throw new IllegalArgumentException(z[8]);
    }
    if (paramInteger.intValue() <= 0)
    {
      f.j(z[3], z[9]);
      return;
    }
    ServiceInterface.a(d.e, paramInteger, paramDefaultPushNotificationBuilder);
  }
  
  public static void setPushTime(Context paramContext, Set<Integer> paramSet, int paramInt1, int paramInt2)
  {
    a(paramContext);
    if ((JCoreInterface.getDebugMode()) && (!cn.jpush.android.c.a.a(paramContext))) {
      f.d(z[3], z[39]);
    }
    if (paramSet == null)
    {
      a(paramContext, true, z[38]);
      return;
    }
    if ((paramSet.size() == 0) || (paramSet.isEmpty()))
    {
      a(paramContext, false, z[38]);
      return;
    }
    if (paramInt1 > paramInt2)
    {
      f.j(z[3], z[40]);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Integer localInteger = (Integer)paramSet.next();
      if ((localInteger.intValue() > 6) || (localInteger.intValue() < 0))
      {
        f.j(z[3], z[37] + localInteger);
        return;
      }
      localStringBuilder.append(localInteger);
    }
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("^");
    localStringBuilder.append(paramInt2);
    a(paramContext, true, localStringBuilder.toString());
  }
  
  public static void setSilenceTime(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramContext);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt2 > 59) || (paramInt4 > 59) || (paramInt3 > 23) || (paramInt1 > 23))
    {
      f.j(z[3], z[2]);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0))
    {
      ServiceInterface.a(paramContext, "");
      f.d(z[3], z[6]);
      return;
    }
    if (ServiceInterface.a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      f.d(z[3], z[5] + paramInt1 + z[1] + paramInt2 + z[4] + paramInt3 + z[1] + paramInt4);
      return;
    }
    f.j(z[3], z[0]);
  }
  
  public static void setStatisticsEnable(boolean paramBoolean) {}
  
  public static void setStatisticsSessionTimeout(long paramLong)
  {
    if (paramLong < 10L) {
      f.h(z[3], z[47]);
    }
    while (paramLong <= 86400L) {
      return;
    }
    f.h(z[3], z[46]);
  }
  
  public static void setTags(Context paramContext, Set<String> paramSet, TagAliasCallback paramTagAliasCallback)
  {
    a(paramContext);
    setAliasAndTags(paramContext, null, paramSet, paramTagAliasCallback);
  }
  
  public static void stopCrashHandler(Context paramContext)
  {
    a(paramContext);
    JCoreInterface.stopCrashHandler(paramContext);
  }
  
  public static void stopPush(Context paramContext)
  {
    f.d(z[3], z[29]);
    a(paramContext);
    ServiceInterface.a(paramContext, 1);
  }
  
  @Deprecated
  public void setAliasAndTags(Context paramContext, String paramString, Set<String> paramSet)
  {
    a(paramContext);
    k.a(paramContext, paramString, paramSet, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/api/JPushInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */