package cn.jiguang.f;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import cn.jiguang.c.f.e;
import cn.jpush.android.service.AlarmReceiver;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.service.PushService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static int a;
  private static List<String> b;
  private static long c;
  private static final ArrayList<String> d;
  private static final ArrayList<String> e;
  private static final ArrayList<String> f;
  private static PushReceiver g;
  private static final String[] z;
  
  static
  {
    Object localObject2 = new String[''];
    int j = 0;
    Object localObject3 = "M\034\022_\025NLF\032*x\026\024";
    int i = -1;
    Object localObject1 = localObject2;
    int k;
    int i1;
    int m;
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
            i = 88;
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
        localObject3 = "K\027\002\r7c\0353\0131f";
        i = 0;
        localObject1 = localObject2;
        break;
      case 0: 
        localObject4[i4] = localObject1;
        j = 2;
        localObject3 = "G=S";
        i = 1;
        localObject1 = localObject2;
        break;
      case 1: 
        localObject4[i4] = localObject1;
        j = 3;
        localObject3 = "\r\000R`";
        i = 2;
        localObject1 = localObject2;
        break;
      case 2: 
        localObject4[i4] = localObject1;
        j = 4;
        localObject3 = "\035\017\033xl\020\n\032xz\030\022\027xc\nF\021-f\025";
        i = 3;
        localObject1 = localObject2;
        break;
      case 3: 
        localObject4[i4] = localObject1;
        j = 5;
        localObject3 = "Y\030\020\032<*\f\002\026<*\020\b\0137*\037\017\023=";
        i = 4;
        localObject1 = localObject2;
        break;
      case 4: 
        localObject4[i4] = localObject1;
        j = 6;
        localObject3 = "I\013\003\036,oY\000\0264oY\017\021xy\035\005\036*nY\003\r*e\013";
        i = 5;
        localObject1 = localObject2;
        break;
      case 5: 
        localObject4[i4] = localObject1;
        j = 7;
        localObject3 = "M\026\022_+n\032\007\r<*\037\017\023=*\n\007\t=nY\023\0331nYK_";
        i = 6;
        localObject1 = localObject2;
        break;
      case 6: 
        localObject4[i4] = localObject1;
        j = 8;
        localObject3 = "$\t\023\f0U\f\002\026<";
        i = 7;
        localObject1 = localObject2;
        break;
      case 7: 
        localObject4[i4] = localObject1;
        j = 9;
        localObject3 = "}\013\017\013=*\037\017\023=*\034\024\r7x";
        i = 8;
        localObject1 = localObject2;
        break;
      case 8: 
        localObject4[i4] = localObject1;
        j = 10;
        localObject3 = "k\027\002\r7c\035H\017=x\024\017\f+c\026\bQ\nO8\" \bB6(:\007Y-'+\035";
        i = 9;
        localObject1 = localObject2;
        break;
      case 9: 
        localObject4[i4] = localObject1;
        j = 11;
        localObject3 = "z\021\t\021=";
        i = 10;
        localObject1 = localObject2;
        break;
      case 10: 
        localObject4[i4] = localObject1;
        j = 12;
        localObject3 = "k\027\002\r7c\035H\0266~\034\b\013vk\032\022\0267dW6>\033A8!:\007X<+0\016O=";
        i = 11;
        localObject1 = localObject2;
        break;
      case 11: 
        localObject4[i4] = localObject1;
        j = 13;
        localObject3 = "i\027H\025(\n\016Q9d\035\024\0201nW\017\021,o\027\022Q\026E-/9\021I826\027D&4:\033O00:\034U)40\000S";
        i = 12;
        localObject1 = localObject2;
        break;
      case 12: 
        localObject4[i4] = localObject1;
        j = 14;
        localObject3 = "k\027\002\r7c\035H\0266~\034\b\013vk\032\022\0267dW6>\033A8!:\007K=\":\034";
        i = 13;
        localObject1 = localObject2;
        break;
      case 13: 
        localObject4[i4] = localObject1;
        j = 15;
        localObject3 = "N\026F\0217~Y\016\036.oY6\n+b+\003\034=c\017\003\rt*+\003\0301y\r\003\rxc\rF\0266*\032\t\033=";
        i = 14;
        localObject1 = localObject2;
        break;
      case 14: 
        localObject4[i4] = localObject1;
        j = 16;
        localObject3 = "X\034\001\026+~\034\024_\b\n\016-=i\034\017\t=xY\017\021xi\026\002\032x*\037\007\0264o\035\\";
        i = 15;
        localObject1 = localObject2;
        break;
      case 15: 
        localObject4[i4] = localObject1;
        j = 17;
        localObject3 = "z\030\005\0249m\034";
        i = 16;
        localObject1 = localObject2;
        break;
      case 16: 
        localObject4[i4] = localObject1;
        j = 18;
        localObject3 = "k\027\002\r7c\035H\0266~\034\b\013vk\032\022\0267dW3,\035X&6-\035Y<(+";
        i = 17;
        localObject1 = localObject2;
        break;
      case 17: 
        localObject4[i4] = localObject1;
        j = 19;
        localObject3 = "k\027\002\r7c\035H\021=~W\005\0206dW%0\026D<%+\021\\02&\007I1'1\037O";
        i = 18;
        localObject1 = localObject2;
        break;
      case 18: 
        localObject4[i4] = localObject1;
        j = 20;
        localObject3 = "a\034\037";
        i = 19;
        localObject1 = localObject2;
        break;
      case 19: 
        localObject4[i4] = localObject1;
        j = 21;
        localObject3 = "Z\013\003\031+L\020\n\032";
        i = 20;
        localObject1 = localObject2;
        break;
      case 20: 
        localObject4[i4] = localObject1;
        j = 22;
        localObject3 = "_\027\003\007(o\032\022\032<0Y\005\0366d\026\022_?o\rF\0173*\020\b\f,k\025\n\032<*\t\007\0130";
        i = 21;
        localObject1 = localObject2;
        break;
      case 21: 
        localObject4[i4] = localObject1;
        j = 23;
        localObject3 = "h\030\025\032:k\027\002";
        i = 22;
        localObject1 = localObject2;
        break;
      case 22: 
        localObject4[i4] = localObject1;
        j = 24;
        localObject3 = "%\035\007\0139%\030\026\017w";
        i = 23;
        localObject1 = localObject2;
        break;
      case 23: 
        localObject4[i4] = localObject1;
        j = 25;
        localObject3 = "%\n\037\f,o\024I\036(zV";
        i = 24;
        localObject1 = localObject2;
        break;
      case 24: 
        localObject4[i4] = localObject1;
        j = 26;
        localObject3 = "D62:b*\r\016\032xz\022F\0337o\nF\0217~Y\017\021+~\030\n\023=nY\017\021xy\000\025\013=gV\002\036,kWF";
        i = 25;
        localObject1 = localObject2;
        break;
      case 25: 
        localObject4[i4] = localObject1;
        j = 27;
        localObject3 = "I\f\024\r=d\rF\0173*\020\b\f,k\025\n\032<*\t\007\01300Y";
        i = 26;
        localObject1 = localObject2;
        break;
      case 26: 
        localObject4[i4] = localObject1;
        j = 28;
        localObject3 = ".]";
        i = 27;
        localObject1 = localObject2;
        break;
      case 27: 
        localObject4[i4] = localObject1;
        j = 29;
        localObject3 = "m\n\013Q.o\013\025\0267dW\004\036+o\033\007\021<";
        i = 28;
        localObject1 = localObject2;
        break;
      case 28: 
        localObject4[i4] = localObject1;
        j = 30;
        localObject3 = "X\034\n\0329y\034\002_/k\022\003_4e\032\r_u*\024\017\0234c\n\003\0347d\035\025E";
        i = 29;
        localObject1 = localObject2;
        break;
      case 29: 
        localObject4[i4] = localObject1;
        j = 31;
        localObject3 = "K\027\002\r7c\0353\0131fY\024\0324o\030\025\032\017k\022\003\0237i\022F64f\034\001\0364Y\r\007\013=O\001\005\032(~\020\t\021xo\013\024\0217";
        i = 30;
        localObject1 = localObject2;
        break;
      case 30: 
        localObject4[i4] = localObject1;
        j = 32;
        localObject3 = "K\027\002\r7c\0353\0131fY\024\0324o\030\025\032\017k\022\003\0237i\022F\032*x\027\t";
        i = 31;
        localObject1 = localObject2;
        break;
      case 31: 
        localObject4[i4] = localObject1;
        j = 33;
        localObject3 = "X\034\n\0329y\034F\b9a\034F\0237i\022F\032 i\034\026\0131e\027";
        i = 32;
        localObject1 = localObject2;
        break;
      case 32: 
        localObject4[i4] = localObject1;
        j = 34;
        localObject3 = "]\030\r\0324e\032\r_1yY\b\020,*\021\003\023<$Y(\020xd\034\003\033x~\026F\r=f\034\007\f=$";
        i = 33;
        localObject1 = localObject2;
        break;
      case 33: 
        localObject4[i4] = localObject1;
        j = 35;
        localObject3 = "$\t\023\f0U\035\003\t1i\034\017\033";
        i = 34;
        localObject1 = localObject2;
        break;
      case 34: 
        localObject4[i4] = localObject1;
        j = 36;
        localObject3 = "_\027\r\0217}\027";
        i = 35;
        localObject1 = localObject2;
        break;
      case 35: 
        localObject4[i4] = localObject1;
        j = 37;
        localObject3 = "i\026\b\021=i\r\017\t1~\000";
        i = 36;
        localObject1 = localObject2;
        break;
      case 36: 
        localObject4[i4] = localObject1;
        j = 38;
        localObject3 = "k\027\002\r7c\035H\036(zW(\020,c\037\017\0349~\020\t\021";
        i = 37;
        localObject1 = localObject2;
        break;
      case 37: 
        localObject4[i4] = localObject1;
        j = 39;
        localObject3 = "k\032\022\0267dC\025\0277})\003\r5k\027\003\021,D\026\022\026>c\032\007\0131e\027";
        i = 38;
        localObject1 = localObject2;
        break;
      case 38: 
        localObject4[i4] = localObject1;
        j = 40;
        localObject3 = "d\026\022\026>c\032\007\0131e\027";
        i = 39;
        localObject1 = localObject2;
        break;
      case 39: 
        localObject4[i4] = localObject1;
        j = 41;
        localObject3 = "i\027H\025(\n\016Q9d\035\024\0201nW\017\021,o\027\022Q\026E-/9\021I826\027D&)/\035D<\" \bX6>&";
        i = 40;
        localObject1 = localObject2;
        break;
      case 40: 
        localObject4[i4] = localObject1;
        j = 42;
        localObject3 = "d\026\022_<o\033\023\030?k\033\n\032";
        i = 41;
        localObject1 = localObject2;
        break;
      case 41: 
        localObject4[i4] = localObject1;
        j = 43;
        localObject3 = "y\034\02239~\034\025\013\035|\034\b\013\021d\037\t";
        i = 42;
        localObject1 = localObject2;
        break;
      case 42: 
        localObject4[i4] = localObject1;
        j = 44;
        localObject3 = "@\020\001\n9d\036掶祅ｂ匏呴哪>(z2\003\006乕匳鄴";
        i = 43;
        localObject1 = localObject2;
        break;
      case 43: 
        localObject4[i4] = localObject1;
        j = 45;
        localObject3 = "诽剉F/7x\r\007\023x一菎厰惗盜匏呴哪>(z2\003\006帮曾旉'\021<x\026\017\033\025k\027\017\031=y\r皞廫嬏殿";
        i = 44;
        localObject1 = localObject2;
        break;
      case 44: 
        localObject4[i4] = localObject1;
        j = 46;
        localObject3 = "l\030\017\023=nY\022\020xm\034\022_9z\t\n\026;k\r\017\0206*\020\b\0317*\030\b\033xc\032\t\021v";
        i = 45;
        localObject1 = localObject2;
        break;
      case 45: 
        localObject4[i4] = localObject1;
        j = 47;
        localObject3 = "n\034\004\n?U\027\t\0131l\020\005\036,c\026\b";
        i = 46;
        localObject1 = localObject2;
        break;
      case 46: 
        localObject4[i4] = localObject1;
        j = 48;
        localObject3 = "~\000\026\032";
        i = 47;
        localObject1 = localObject2;
        break;
      case 47: 
        localObject4[i4] = localObject1;
        j = 49;
        localObject3 = "~\026\007\f,^\034\036\013";
        i = 48;
        localObject1 = localObject2;
        break;
      case 48: 
        localObject4[i4] = localObject1;
        j = 50;
        localObject3 = "k\027\002\r7c\035H\017=x\024\017\f+c\026\bQ\031I:#,\013U./9\021U*2>\fO";
        i = 49;
        localObject1 = localObject2;
        break;
      case 49: 
        localObject4[i4] = localObject1;
        j = 51;
        localObject3 = "G8%_9n\035\024_1d\037\tRu'TF";
        i = 50;
        localObject1 = localObject2;
        break;
      case 50: 
        localObject4[i4] = localObject1;
        j = 52;
        localObject3 = ":SV";
        i = 51;
        localObject1 = localObject2;
        break;
      case 51: 
        localObject4[i4] = localObject1;
        j = 53;
        localObject3 = "%\t\024\020;%\032\026\n1d\037\t";
        i = 52;
        localObject1 = localObject2;
        break;
      case 52: 
        localObject4[i4] = localObject1;
        j = 54;
        localObject3 = "Z\013\t\034=y\n\t\r";
        i = 53;
        localObject1 = localObject2;
        break;
      case 53: 
        localObject4[i4] = localObject1;
        j = 55;
        localObject3 = "QIKF\005qHS\002";
        i = 54;
        localObject1 = localObject2;
        break;
      case 54: 
        localObject4[i4] = localObject1;
        j = 56;
        localObject3 = "M\034\022_5o\020\002_9yY\007_1g\034\017_y";
        i = 55;
        localObject1 = localObject2;
        break;
      case 55: 
        localObject4[i4] = localObject1;
        j = 57;
        localObject3 = "QI;U";
        i = 56;
        localObject1 = localObject2;
        break;
      case 56: 
        localObject4[i4] = localObject1;
        j = 58;
        localObject3 = "M\034\022_1g\034\017_1yY\007\0234*IF^";
        i = 57;
        localObject1 = localObject2;
        break;
      case 57: 
        localObject4[i4] = localObject1;
        j = 59;
        localObject3 = "^\021\003_1g\034\017_1yY\003\022(~\000G";
        i = 58;
        localObject1 = localObject2;
        break;
      case 58: 
        localObject4[i4] = localObject1;
        j = 60;
        localObject3 = "Q\030K\031h'@'R\036W\002WK%";
        i = 59;
        localObject1 = localObject2;
        break;
      case 59: 
        localObject4[i4] = localObject1;
        j = 61;
        localObject3 = "M\034\022_1g\034\017_7aYG";
        i = 60;
        localObject1 = localObject2;
        break;
      case 60: 
        localObject4[i4] = localObject1;
        j = 62;
        localObject3 = "g\026\023\021,o\035";
        i = 61;
        localObject1 = localObject2;
        break;
      case 61: 
        localObject4[i4] = localObject1;
        j = 63;
        localObject3 = "Y=%\036*nY\017\fxd\026\022_5e\f\b\013=n";
        i = 62;
        localObject1 = localObject2;
        break;
      case 62: 
        localObject4[i4] = localObject1;
        j = 64;
        localObject3 = "*\035\013Q0o\020\001\027,Z\020\036\0324yC";
        i = 63;
        localObject1 = localObject2;
        break;
      case 63: 
        localObject4[i4] = localObject1;
        j = 65;
        localObject3 = "*\035\013Q!n\t\017E";
        i = 64;
        localObject1 = localObject2;
        break;
      case 64: 
        localObject4[i4] = localObject1;
        j = 66;
        localObject3 = "z\026\017\021,$\001\\";
        i = 65;
        localObject1 = localObject2;
        break;
      case 65: 
        localObject4[i4] = localObject1;
        j = 67;
        localObject3 = "Y\032\024\032=dY\017\021;b\034\025_b*";
        i = 66;
        localObject1 = localObject2;
        break;
      case 66: 
        localObject4[i4] = localObject1;
        j = 68;
        localObject3 = "n\024H\b1n\r\016/1r\034\n\fx0Y";
        i = 67;
        localObject1 = localObject2;
        break;
      case 67: 
        localObject4[i4] = localObject1;
        j = 69;
        localObject3 = "n\024H\007<z\020FEx";
        i = 68;
        localObject1 = localObject2;
        break;
      case 68: 
        localObject4[i4] = localObject1;
        j = 70;
        localObject3 = "z\026\017\021,$\000";
        i = 69;
        localObject1 = localObject2;
        break;
      case 69: 
        localObject4[i4] = localObject1;
        j = 71;
        localObject3 = "b\030\025,=x\017\017\034=C\027\022\0326~?\017\023,o\013F\032*x\026\024E";
        i = 70;
        localObject1 = localObject2;
        break;
      case 70: 
        localObject4[i4] = localObject1;
        j = 72;
        localObject3 = "o\024\026\013!*\t\007\r9g\n";
        i = 71;
        localObject1 = localObject2;
        break;
      case 71: 
        localObject4[i4] = localObject1;
        j = 73;
        localObject3 = "k\025\007\r5";
        i = 72;
        localObject1 = localObject2;
        break;
      case 72: 
        localObject4[i4] = localObject1;
        j = 74;
        localObject3 = "X\034\025\032,*\021\003\036*~\033\003\036,*\030\n\036*gW";
        i = 73;
        localObject1 = localObject2;
        break;
      case 73: 
        localObject4[i4] = localObject1;
        j = 75;
        localObject3 = "g\nH";
        i = 74;
        localObject1 = localObject2;
        break;
      case 74: 
        localObject4[i4] = localObject1;
        j = 76;
        localObject3 = "B\034\007\r,h\034\007\013xc\027\022\032*|\030\n_e*";
        i = 75;
        localObject1 = localObject2;
        break;
      case 75: 
        localObject4[i4] = localObject1;
        j = 77;
        localObject3 = "i\030\bX,*\r\024\026?m\034\024_9f\030\024\022xi\030\023\f=*\033\037_=r\032\003\017,c\026\bE";
        i = 76;
        localObject1 = localObject2;
        break;
      case 76: 
        localObject4[i4] = localObject1;
        j = 78;
        localObject3 = "3NQK<?O\002I`8\034SKai";
        i = 77;
        localObject1 = localObject2;
        break;
      case 77: 
        localObject4[i4] = localObject1;
        j = 79;
        localObject3 = "K\032\027\n1x\034\002_\017k\022\003\0237i\022";
        i = 78;
        localObject1 = localObject2;
        break;
      case 78: 
        localObject4[i4] = localObject1;
        j = 80;
        localObject3 = "U36\n+b";
        i = 79;
        localObject1 = localObject2;
        break;
      case 79: 
        localObject4[i4] = localObject1;
        j = 81;
        localObject3 = "K\027\002\r7c\0353\0131fY\007\034)\020\024\032<]\030\r\0324e\032\r_\021f\025\003\0309f*\022\036,o<\036\034=z\r\017\0206*\034\024\r6e";
        i = 80;
        localObject1 = localObject2;
        break;
      case 80: 
        localObject4[i4] = localObject1;
        j = 82;
        localObject3 = "K\027\002\r7c\0353\0131fY\007\034)\020\024\032<]\030\r\0324e\032\r_=x\013\b\020";
        i = 81;
        localObject1 = localObject2;
        break;
      case 81: 
        localObject4[i4] = localObject1;
        j = 83;
        localObject3 = "]\030\r\0324e\032\r_1yY\007\023*o\030\002\006xb\034\n\033v*7\t_6o\034\002_,eY\007\034)\020\024\032v";
        i = 82;
        localObject1 = localObject2;
        break;
      case 82: 
        localObject4[i4] = localObject1;
        j = 84;
        localObject3 = "z\026\021\032*";
        i = 83;
        localObject1 = localObject2;
        break;
      case 83: 
        localObject4[i4] = localObject1;
        j = 85;
        localObject3 = "VW";
        i = 84;
        localObject1 = localObject2;
        break;
      case 84: 
        localObject4[i4] = localObject1;
        j = 86;
        localObject3 = "k\027\002\r7c\035H\017=x\024\017\f+c\026\bQ\nO8\" \035R-#-\026K59,\fE+'8\035";
        i = 85;
        localObject1 = localObject2;
        break;
      case 85: 
        localObject4[i4] = localObject1;
        j = 87;
        localObject3 = "k\027\002\r7c\035H\017=x\024\017\f+c\026\bQ\017X02:\007O!2:\nD8* \013^64>\037O";
        i = 86;
        localObject1 = localObject2;
        break;
      case 86: 
        localObject4[i4] = localObject1;
        j = 88;
        localObject3 = "K\032\022\0267dC\001\032,Y\030\020\032<_\f\017\033";
        i = 87;
        localObject1 = localObject2;
        break;
      case 87: 
        localObject4[i4] = localObject1;
        j = 89;
        localObject3 = "\\NHN";
        i = 88;
        localObject1 = localObject2;
        break;
      case 88: 
        localObject4[i4] = localObject1;
        j = 90;
        localObject3 = "h\013\007\021<*DF";
        i = 89;
        localObject1 = localObject2;
        break;
      case 89: 
        localObject4[i4] = localObject1;
        j = 91;
        localObject3 = "x\026H\017*e\035\023\034,$\033\024\0366n";
        i = 90;
        localObject1 = localObject2;
        break;
      case 90: 
        localObject4[i4] = localObject1;
        j = 92;
        localObject3 = "R\020\007\0205c";
        i = 91;
        localObject1 = localObject2;
        break;
      case 91: 
        localObject4[i4] = localObject1;
        j = 93;
        localObject3 = "x\026H\035-c\025\002Q.o\013\025\0267dW\017\021;x\034\013\0326~\030\n";
        i = 92;
        localObject1 = localObject2;
        break;
      case 92: 
        localObject4[i4] = localObject1;
        j = 94;
        localObject3 = "=WW_/c\025\n_6e\rF\030=~Y\021\026>cY\n\026+~";
        i = 93;
        localObject1 = localObject2;
        break;
      case 93: 
        localObject4[i4] = localObject1;
        j = 95;
        localObject3 = "x\026H\0221\020H\n1$\017\003\r+c\026\bQ6k\024\003";
        i = 94;
        localObject1 = localObject2;
        break;
      case 94: 
        localObject4[i4] = localObject1;
        j = 96;
        localObject3 = "^\021\003_(o\013\013\026+y\020\t\021xy\021\t\n4nY\004\032xn\034\000\0266o\035FRx";
        i = 95;
        localObject1 = localObject2;
        break;
      case 95: 
        localObject4[i4] = localObject1;
        j = 97;
        localObject3 = "^\021\003_(o\013\013\026+y\026\017\021xc\nF\r={\f\017\r=nYK_9d\035\024\0201nW\026\032*g\020\025\f1e\027H(\nC-# \035R-#-\026K59,\fE+'8\035";
        i = 96;
        localObject1 = localObject2;
        break;
      case 96: 
        localObject4[i4] = localObject1;
        j = 98;
        localObject3 = "k\027\002\r7c\035H\0266~\034\b\013vk\032\022\0267dW$0\027^&%0\025Z5#+\035N";
        i = 97;
        localObject1 = localObject2;
        break;
      case 97: 
        localObject4[i4] = localObject1;
        j = 99;
        localObject3 = "k\032\022\0267dC\005\027=i\0220\0364c\035+\0366c\037\003\f,";
        i = 98;
        localObject1 = localObject2;
        break;
      case 98: 
        localObject4[i4] = localObject1;
        j = 100;
        localObject3 = "K\027\002\r7c\035+\0366c\037\003\f,$\001\013\023xg\020\025\f1d\036F\r={\f\017\r=nY\024\032;o\020\020\032*0Y";
        i = 99;
        localObject1 = localObject2;
        break;
      case 99: 
        localObject4[i4] = localObject1;
        j = 101;
        localObject3 = "K\027\002\r7c\035+\0366c\037\003\f,$\001\013\023xg\020\025\f1d\036F\r={\f\017\r=nY\025\032*|\020\005\032b*";
        i = 100;
        localObject1 = localObject2;
        break;
      case 100: 
        localObject4[i4] = localObject1;
        j = 102;
        localObject3 = "Z\f\025\027\013o\013\020\026;oY\017\021xg\030\017\021xz\013\t\034=y\n";
        i = 101;
        localObject1 = localObject2;
        break;
      case 101: 
        localObject4[i4] = localObject1;
        j = 103;
        localObject3 = "k\027\002\r7c\035H\017=x\024\017\f+c\026\bQ\017X02:\007Y<2+\021D>5";
        i = 102;
        localObject1 = localObject2;
        break;
      case 102: 
        localObject4[i4] = localObject1;
        j = 104;
        localObject3 = "]\034F\r=i\026\013\022=d\035F\0067Y\007\033<*\r\016\032xz\034\024\0221y\n\017\0206*TF";
        i = 103;
        localObject1 = localObject2;
        break;
      case 103: 
        localObject4[i4] = localObject1;
        j = 105;
        localObject3 = "Z\f\025\027\no\032\003\026.o\013F\f0e\f\n\033xd\026\022_0k\017\003_1d\r\003\021,*\037\017\023,o\013FRu*\030\b\033*e\020\002Q1d\r\003\021,$\030\005\0131e\027H=\027E-9<\027G)*:\fO=J_\bf\034\007\f=*\013\003\0227|\034F\0130oY\017\021,o\027\022_>c\025\022\032**\020\b_\031d\035\024\0201n4\007\0211l\034\025\013vr\024\n";
        i = 104;
        localObject1 = localObject2;
        break;
      case 104: 
        localObject4[i4] = localObject1;
        j = 106;
        localObject3 = "&Y\t\0130o\013\021\026+oY\037\020-*\032\007\021xd\026\022_4e\032\007\013=*\r\016\032xn\034\020\026;o\nH";
        i = 105;
        localObject1 = localObject2;
        break;
      case 105: 
        localObject4[i4] = localObject1;
        j = 107;
        localObject3 = "K\027\002\r7c\035+\0366c\037\003\f,$\001\013\023xg\020\025\f1d\036F\r={\f\017\r=nY\017\021,o\027\022_>c\025\022\032**\037\t\rxZ\f\025\027\013o\013\020\026;oCF\0346$\023\026\n+bW\007\021<x\026\017\033vc\027\022\0326~W4:\037C*2:\n";
        i = 106;
        localObject1 = localObject2;
        break;
      case 106: 
        localObject4[i4] = localObject1;
        j = 108;
        localObject3 = "^\021\003_(o\013\013\026+y\026\017\021xc\nF\r={\f\017\r=nYK_";
        i = 107;
        localObject1 = localObject2;
        break;
      case 107: 
        localObject4[i4] = localObject1;
        j = 109;
        localObject3 = "Z\f\025\027\013o\013\020\026;oY\017\021xe\r\016\032**\t\024\020;o\n\025";
        i = 108;
        localObject1 = localObject2;
        break;
      case 108: 
        localObject4[i4] = localObject1;
        j = 110;
        localObject3 = "$\t\003\r5c\n\025\0267dW,/\rY192\035Y*'8\035";
        i = 109;
        localObject1 = localObject2;
        break;
      case 109: 
        localObject4[i4] = localObject1;
        j = 111;
        localObject3 = "i\027H\025(\n\016Q9d\035\024\0201nW\017\021,o\027\022Q\nO>/,\fO+";
        i = 110;
        localObject1 = localObject2;
        break;
      case 110: 
        localObject4[i4] = localObject1;
        j = 112;
        localObject3 = "^\021\003_(o\013\013\026+y\026\017\021xc\nF\r={\f\017\r=nYK_9d\035\024\0201nW\026\032*g\020\025\f1e\027H(\nC-# \013O-26\026M*";
        i = 111;
        localObject1 = localObject2;
        break;
      case 111: 
        localObject4[i4] = localObject1;
        j = 113;
        localObject3 = "b\030\025,=x\017\017\034=X\034\025\0204|\034\025_=x\013\t\rb";
        i = 112;
        localObject1 = localObject2;
        break;
      case 112: 
        localObject4[i4] = localObject1;
        j = 114;
        localObject3 = "Y\030\020\032<*\035\003\t1i\034\017\033xc\027\022\020xl\020\n\032";
        i = 113;
        localObject1 = localObject2;
        break;
      case 113: 
        localObject4[i4] = localObject1;
        j = 115;
        localObject3 = "}\013\017\013=*\035\003\t1i\034\017\033xo\013\024\020*";
        i = 114;
        localObject1 = localObject2;
        break;
      case 114: 
        localObject4[i4] = localObject1;
        j = 116;
        localObject3 = "m\034\022_+n\032\007\r<*\035\007\0139*\t\007\0130*\037\017\0364";
        i = 115;
        localObject1 = localObject2;
        break;
      case 115: 
        localObject4[i4] = localObject1;
        j = 117;
        localObject3 = "g\022\002\026**\020\b_+n\032\007\r<*\034\024\r7x";
        i = 116;
        localObject1 = localObject2;
        break;
      case 116: 
        localObject4[i4] = localObject1;
        j = 118;
        localObject3 = "m\034\022_<o\017\017\034=*\020\002_xy\035F\0349x\035F\0311f\034F\0179~\021F\0319c\025";
        i = 117;
        localObject1 = localObject2;
        break;
      case 117: 
        localObject4[i4] = localObject1;
        j = 119;
        localObject3 = "b\030\025-=i\034\017\t=x+\003\f7f\017\003\fxo\013\024\020*0";
        i = 118;
        localObject1 = localObject2;
        break;
      case 118: 
        localObject4[i4] = localObject1;
        j = 120;
        localObject3 = "M\026\022_+n\032\007\r<*\037\017\023=*\n\007\t=nY\002\032.c\032\0036<*TF";
        i = 119;
        localObject1 = localObject2;
        break;
      case 119: 
        localObject4[i4] = localObject1;
        j = 121;
        localObject3 = "I\025\003\036**\013\003\0301y\r\003\r=nY\002\036,kY\007\021<*\035\003\t1i\034F\026<*";
        i = 120;
        localObject1 = localObject2;
        break;
      case 120: 
        localObject4[i4] = localObject1;
        j = 122;
        localObject3 = "%\035\007\0139%";
        i = 121;
        localObject1 = localObject2;
        break;
      case 121: 
        localObject4[i4] = localObject1;
        j = 123;
        localObject3 = "k\027\002\r7c\0359\026<";
        i = 122;
        localObject1 = localObject2;
        break;
      case 122: 
        localObject4[i4] = localObject1;
        j = 124;
        localObject3 = "c\r\017\022=";
        i = 123;
        localObject1 = localObject2;
        break;
      case 123: 
        localObject4[i4] = localObject1;
        j = 125;
        localObject3 = "n\030\022\036";
        i = 124;
        localObject1 = localObject2;
        break;
      case 124: 
        localObject4[i4] = localObject1;
        j = 126;
        localObject3 = "m\034\022(1l\020+\036;*\034\024\r7xC";
        i = 125;
        localObject1 = localObject2;
        break;
      case 125: 
        localObject4[i4] = localObject1;
        j = 127;
        localObject3 = "}\020\000\026";
        i = 126;
        localObject1 = localObject2;
        break;
      case 126: 
        localObject4[i4] = localObject1;
        j = 128;
        localObject3 = "k\027\002\r7c\035F\0229iY\007\033<x\034\025\fb";
        i = 127;
        localObject1 = localObject2;
        break;
      case 127: 
        localObject4[i4] = localObject1;
        j = 129;
        localObject3 = "i\030\022_wy\000\025P;f\030\025\fwd\034\022P/f\030\bOwk\035\002\r=y\n";
        i = 128;
        localObject1 = localObject2;
        break;
      case 128: 
        localObject4[i4] = localObject1;
        j = 130;
        localObject3 = "b\030\025-=i\034\017\t=x0\b\013=d\r \0264~\034\024/9i\022\007\030=*\034\024\r7xC";
        i = 129;
        localObject1 = localObject2;
        break;
      case 129: 
        localObject4[i4] = localObject1;
        j = 131;
        localObject3 = "m\034\022/0e\027\0036(0";
        i = 130;
        localObject1 = localObject2;
        break;
      case 130: 
        localObject4[i4] = localObject1;
        j = 132;
        localObject3 = "b\030\025/=x\024\017\f+c\026\b;=l\020\b\032<*\034\024\r7xC";
        i = 131;
        localObject1 = localObject2;
        break;
      case 131: 
        localObject4[i4] = localObject1;
        j = 133;
        localObject3 = "I\030\b\034=fY\016\0329x\r\004\0329~Y\007\0239x\024F\0319c\025\003\033v";
        i = 132;
        localObject1 = localObject2;
        break;
      case 132: 
        localObject4[i4] = localObject1;
        j = 134;
        localObject3 = "ED'\021<x\026\017\033";
        i = 133;
        localObject1 = localObject2;
        break;
      case 133: 
        localObject4[i4] = localObject1;
        j = 135;
        localObject3 = "ID3,";
        i = 134;
        localObject1 = localObject2;
        break;
      case 134: 
        localObject4[i4] = localObject1;
        j = 136;
        localObject3 = "RWSOa";
        i = 135;
        localObject1 = localObject2;
        break;
      case 135: 
        localObject4[i4] = localObject1;
        j = 137;
        localObject3 = "I7[>6n\013\t\026<*=\003\035-mU)B\031d\035\024\0201nU%B\rY";
        i = 136;
        localObject1 = localObject2;
        break;
      case 136: 
        localObject4[i4] = localObject1;
        j = 138;
        localObject3 = "I7[>6n\013\t\026<*=\003\035-m";
        i = 137;
        localObject1 = localObject2;
        break;
      case 137: 
        localObject4[i4] = localObject1;
        j = 139;
        localObject3 = "k\027\002\r7c\035H\0266~\034\b\013vk\032\022\0267dW$>\f^<4&\007I1'1\037O=";
        i = 138;
        localObject1 = localObject2;
        break;
      case 138: 
        localObject4[i4] = localObject1;
        j = 140;
        localObject3 = "y\r\007\013-y";
        i = 139;
        localObject1 = localObject2;
        break;
      case 139: 
        localObject4[i4] = localObject1;
        j = 141;
        localObject3 = "z\025\023\030?o\035";
        i = 140;
        localObject1 = localObject2;
        break;
      case 140: 
        localObject4[i4] = localObject1;
        j = 142;
        localObject3 = "I\030\b_6e\rF\b*c\r\003_+o\r\022\0266m\n";
        i = 141;
        localObject1 = localObject2;
        break;
      case 141: 
        localObject4[i4] = localObject1;
        j = 143;
        localObject3 = "n\034\020\0341o&\017\033\007m\034\b\032*k\r\003\033";
        i = 142;
        localObject1 = localObject2;
        break;
      case 142: 
        localObject4[i4] = localObject1;
        j = 144;
        localObject3 = "i\030\b_6e\rF\0311d\035F";
        i = 143;
        localObject1 = localObject2;
        break;
      case 143: 
        localObject4[i4] = localObject1;
        j = 145;
        localObject3 = "z\013\t\034=y\nF\0219g\034\\";
        i = 144;
        localObject1 = localObject2;
        break;
      case 144: 
        localObject4[i4] = localObject1;
        j = 146;
        localObject3 = "H\f\b\0334oY\025\0277\025\002_6e\rF\035=*\027\023\0234*\037\t\rxy\034\b\033\032x\026\007\033;k\n\022Q";
        i = 145;
        localObject1 = localObject2;
        break;
      case 145: 
        localObject4[i4] = localObject1;
        j = 147;
        localObject3 = "&\030\005\0131e\027\\";
        i = 146;
        localObject1 = localObject2;
        break;
      case 146: 
        localObject4[i4] = localObject1;
        j = 148;
        localObject3 = "y\034\b\033\032x\026\007\033;k\n\022_=x\013\t\rb";
        i = 147;
        localObject1 = localObject2;
        break;
      case 147: 
        localObject4[i4] = localObject1;
        j = 149;
        localObject3 = "i\027H\025(\n\016Q9d\035\024\0201nW'/\bA<?";
        i = 148;
        localObject1 = localObject2;
        break;
      case 148: 
        localObject4[i4] = localObject1;
        j = 150;
        localObject3 = "I\030\b_6e\rF\n+oY\003\007,o\013\b\0364*\n\022\020*o\036\003";
        i = 149;
        localObject1 = localObject2;
        break;
      case 149: 
        localObject4[i4] = localObject1;
        j = 151;
        localObject3 = "@)3,\020U86/\023O ";
        i = 150;
        localObject1 = localObject2;
        break;
      case 150: 
        localObject4[i4] = localObject1;
        j = 152;
        localObject3 = "I\030\b_6e\rF\r=k\035F\031*e\024F\f=~\r\017\021?y";
        i = 151;
        localObject1 = localObject2;
      }
    }
    localObject4[i4] = localObject1;
    z = (String[])localObject2;
    a = 1;
    localObject1 = new ArrayList();
    b = (List)localObject1;
    localObject2 = "9L^Io9IWLo3L^Fm";
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
      label4646:
      label4761:
      do
      {
        m = k;
        localObject2 = localObject1;
        n = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 88;
        }
        for (;;)
        {
          localObject2[k] = ((char)(i ^ n));
          m += 1;
          if (j != 0) {
            break label4761;
          }
          k = j;
          break label4646;
          i = 10;
          break;
          i = 121;
          break;
          i = 102;
          break;
          i = 127;
          break;
          i = 10;
          continue;
          i = 121;
          continue;
          i = 102;
          continue;
          i = 127;
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
        localObject1 = b;
        localObject2 = ":IRFa3IWOn>IVOh";
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
          do
          {
            m = k;
            localObject2 = localObject1;
            n = localObject2[k];
            switch (m % 5)
            {
            default: 
              i = 88;
            }
            for (;;)
            {
              localObject2[k] = ((char)(i ^ n));
              m += 1;
              if (j != 0) {
                break label5025;
              }
              k = j;
              break;
              i = 10;
              continue;
              i = 121;
              continue;
              i = 102;
              continue;
              i = 127;
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
            localObject1 = b;
            localObject2 = ":IVOh:IVOh:IVO";
            i = 0;
            break;
          case 0: 
            ((List)localObject3).add(localObject1);
            localObject1 = b;
            localObject2 = ":IVOh:IVOh:IVOh";
            i = 1;
          }
        }
        ((List)localObject3).add(localObject1);
        c = 0L;
        d = new ArrayList();
        e = new ArrayList();
        localObject1 = d;
        localObject2 = "k\027\002\r7c\035H\017=x\024\017\f+c\026\bQ\021D-#-\026O-";
        i = 0;
        break;
      case 0: 
        ((ArrayList)localObject3).add(localObject1);
        localObject1 = d;
        localObject2 = "k\027\002\r7c\035H\017=x\024\017\f+c\026\bQ\017K2# \024E:-";
        i = 1;
        break;
      case 1: 
        ((ArrayList)localObject3).add(localObject1);
        localObject1 = d;
        localObject2 = "k\027\002\r7c\035H\017=x\024\017\f+c\026\bQ\031I:#,\013U7#+\017E+- \013^82:";
        i = 2;
        break;
      case 2: 
        ((ArrayList)localObject3).add(localObject1);
        localObject1 = e;
        localObject2 = "k\027\002\r7c\035H\017=x\024\017\f+c\026\bQ\016C;4>\fO";
        i = 3;
        break;
      case 3: 
        ((ArrayList)localObject3).add(localObject1);
        localObject1 = e;
        localObject2 = "k\027\002\r7c\035H\017=x\024\017\f+c\026\bQ\033B8(8\035U./9\021U*2>\fO";
        i = 4;
        break;
      case 4: 
        ((ArrayList)localObject3).add(localObject1);
        localObject1 = new ArrayList();
        f = (ArrayList)localObject1;
        localObject2 = "k\027\002\r7c\035H\017=x\024\017\f+c\026\bQ\031I:#,\013U?/1\035U5)<\031^0)1";
        i = 5;
        break;
      case 5: 
        ((ArrayList)localObject3).add(localObject1);
        localObject1 = f;
        localObject2 = "k\027\002\r7c\035H\017=x\024\017\f+c\026\bQ\031I:#,\013U:)>\nY<93\027I826\027D";
        i = 6;
        break;
      case 6: 
        label5025:
        ((ArrayList)localObject3).add(localObject1);
        localObject1 = f;
        localObject2 = "k\027\002\r7c\035H\017=x\024\017\f+c\026\bQ\031I:#,\013U5)<\031^0)1\007O!2-\031U:)2\025K7\",";
        i = 7;
      }
    }
    ((ArrayList)localObject3).add(localObject1);
    f.add(z[50]);
  }
  
  public static int a(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (paramContext == null) {
      return z[52];
    }
    int i = paramContext.widthPixels;
    int j = paramContext.heightPixels;
    return i + "*" + j;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str2 = Build.VERSION.RELEASE + "," + Integer.toString(Build.VERSION.SDK_INT);
    Object localObject2 = Build.MODEL;
    Object localObject4 = i.a(paramContext, z[29], z[23]);
    Object localObject3 = Build.DEVICE;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = " ";
    }
    localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = " ";
    }
    localObject3 = localObject4;
    if (TextUtils.isEmpty((CharSequence)localObject4)) {
      localObject3 = " ";
    }
    String str1 = cn.jiguang.c.a.a.z();
    localObject4 = str1;
    if (h.a(str1)) {
      localObject4 = " ";
    }
    paramString = new StringBuilder().append(str2).append(z[28]).append((String)localObject1).append(z[28]).append((String)localObject3).append(z[28]).append((String)localObject2).append(z[28]).append((String)localObject4).append(z[28]).append(paramString).append(z[28]);
    localObject1 = paramContext.getApplicationInfo().sourceDir;
    if (h.a((String)localObject1))
    {
      cn.jiguang.d.d.i(z[1], z[22]);
      i = 0;
      if (i == 0) {
        break label367;
      }
    }
    label367:
    for (int i = 1;; i = 0)
    {
      return i + z[28] + a(paramContext);
      cn.jiguang.d.d.c(z[1], z[27] + (String)localObject1);
      if (((String)localObject1).startsWith(z[25]))
      {
        i = 1;
        break;
      }
      if (((String)localObject1).startsWith(z[24]))
      {
        i = 0;
        break;
      }
      cn.jiguang.d.d.e(z[1], z[26]);
      i = 0;
      break;
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance(z[2]);
      paramString = paramString.toCharArray();
      byte[] arrayOfByte = new byte[paramString.length];
      int i = 0;
      while (i < paramString.length)
      {
        arrayOfByte[i] = ((byte)paramString[i]);
        i += 1;
      }
      paramString = ((MessageDigest)localObject).digest(arrayOfByte);
      localObject = new StringBuffer();
      i = 0;
      while (i < paramString.length)
      {
        int j = paramString[i] & 0xFF;
        if (j < 16) {
          ((StringBuffer)localObject).append("0");
        }
        ((StringBuffer)localObject).append(Integer.toHexString(j));
        i += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      cn.jiguang.d.d.c(z[1], z[0]);
    }
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = MessageDigest.getInstance(z[2]).digest(paramArrayOfByte);
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i] & 0xFF;
        if (j < 16) {
          localStringBuffer.append("0");
        }
        localStringBuffer.append(Integer.toHexString(j));
        i += 1;
      }
      paramArrayOfByte = localStringBuffer.toString();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      cn.jiguang.d.d.c(z[1], z[0]);
    }
    return "";
  }
  
  public static JSONObject a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(z[125], paramString2);
      localJSONObject.put(z[48], paramString1);
      localJSONObject.put(z[124], cn.jiguang.c.a.a.g());
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      cn.jiguang.d.d.i(z[1], paramString1.getMessage());
    }
    return null;
  }
  
  public static JSONObject a(String paramString, JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(z[125], paramJSONArray);
      localJSONObject.put(z[48], paramString);
      localJSONObject.put(z[124], cn.jiguang.c.a.a.g());
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      cn.jiguang.d.d.i(z[1], paramString.getMessage());
    }
    return null;
  }
  
  public static void a()
  {
    try
    {
      PowerManager.WakeLock localWakeLock = e.a().b();
      if (localWakeLock != null)
      {
        boolean bool = localWakeLock.isHeld();
        if (!bool) {}
      }
      else
      {
        try
        {
          localWakeLock.release();
          long l1 = System.currentTimeMillis();
          long l2 = c;
          c = 0L;
          cn.jiguang.d.d.a(z[1], z[30] + (l1 - l2));
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          cn.jiguang.d.d.c(z[1], z[33], localRuntimeException);
          return;
        }
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
      cn.jiguang.d.d.c(z[1], z[31]);
      return;
      cn.jiguang.d.d.a(z[1], z[34]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      cn.jiguang.d.d.c(z[1], z[32]);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (!t(paramContext)) {
      cn.jiguang.d.d.a(z[1], z[42]);
    }
    for (;;)
    {
      return;
      if (!a(paramContext, PushReceiver.class))
      {
        new Handler(Looper.getMainLooper()).post(new b(paramContext, paramString));
        return;
      }
      cn.jiguang.d.d.c(z[1], z[39]);
      Intent localIntent = new Intent(paramContext, PushReceiver.class);
      localIntent.setAction(z[41]);
      localIntent.putExtra(z[47], true);
      localIntent.putExtra(z[49], paramString);
      localIntent.putExtra(z[48], -1);
      PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, localIntent, 134217728);
      NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService(z[40]);
      try
      {
        paramInt = paramContext.getPackageManager().getApplicationInfo(paramContext.getApplicationContext().getPackageName(), 0).icon;
        str1 = z[44];
        str2 = z[45];
        l = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 11)
        {
          paramContext = new Notification.Builder(paramContext.getApplicationContext()).setContentTitle(str1).setContentText(str2).setContentIntent(localPendingIntent).setSmallIcon(paramInt).setTicker(paramString).setWhen(l).getNotification();
          paramContext.flags = 34;
          if (paramContext == null) {
            continue;
          }
          localNotificationManager.notify(paramString.hashCode(), paramContext);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str1;
          String str2;
          long l;
          cn.jiguang.d.d.f(z[1], z[46], localException);
          paramInt = 17301586;
          continue;
          Notification localNotification = new Notification(paramInt, paramString, l);
          localNotification.flags = 34;
          try
          {
            Class.forName(z[38]).getDeclaredMethod(z[43], new Class[] { Context.class, CharSequence.class, CharSequence.class, PendingIntent.class }).invoke(localNotification, new Object[] { paramContext, str1, str2, localPendingIntent });
            paramContext = localNotification;
          }
          catch (Exception paramContext)
          {
            paramContext.printStackTrace();
            paramContext = localNotification;
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      cn.jiguang.d.d.j(z[1], z['']);
      return;
    }
    try
    {
      Intent localIntent = new Intent(paramString);
      paramBundle.putString(z[''], cn.jiguang.c.a.a.y());
      localIntent.putExtras(paramBundle);
      localIntent.addCategory(paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      cn.jiguang.d.d.h(z[1], z[''] + paramContext.getMessage() + z[''] + paramString);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    if (paramString2 != null) {
      localBundle.putString(paramString2, paramString3);
    }
    a(paramContext, paramString1, localBundle);
  }
  
  private static boolean a(Context paramContext, Class<?> paramClass)
  {
    try
    {
      boolean bool = paramContext.getPackageManager().queryBroadcastReceivers(new Intent(paramContext, paramClass), 0).isEmpty();
      return !bool;
    }
    catch (Throwable paramContext)
    {
      cn.jiguang.d.d.h(z[1], z[119] + paramContext.getMessage());
    }
    return false;
  }
  
  private static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      paramString2 = new Intent(paramString2);
      paramString2.setPackage(paramContext.getPackageName());
      paramContext = localPackageManager.queryBroadcastReceivers(paramString2, 0).iterator();
      while (paramContext.hasNext())
      {
        paramString2 = ((ResolveInfo)paramContext.next()).activityInfo;
        if (paramString2 != null)
        {
          boolean bool = paramString2.name.equals(paramString1);
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      cn.jiguang.d.d.h(z[1], z[''] + paramContext.getMessage());
    }
    return false;
  }
  
  private static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = paramContext.getPackageManager().queryIntentServices(new Intent(paramString), 0).isEmpty();
      return !paramBoolean;
    }
    catch (Throwable paramContext)
    {
      cn.jiguang.d.d.h(z[1], z[71] + paramContext.getMessage());
    }
    return false;
  }
  
  public static String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (new File(z[53]).exists()) {
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new FileReader(new File(z[53])));
        for (;;)
        {
          String str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          if (str.contains(z[54]))
          {
            int i = str.indexOf(":");
            if ((i >= 0) && (i < str.length() - 1)) {
              localStringBuffer.append(str.substring(i + 1).trim());
            }
          }
        }
        return localStringBuffer.toString();
      }
      catch (IOException localIOException) {}
    }
    for (;;)
    {
      localIOException.close();
    }
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance(z[2]).digest(paramString.getBytes(z[3]));
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < paramString.length)
      {
        int j = paramString[i] & 0xFF;
        if (j < 16) {
          localStringBuffer.append("0");
        }
        localStringBuffer.append(Integer.toHexString(j));
        i += 1;
      }
      paramString = localStringBuffer.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      cn.jiguang.d.d.c(z[1], z[0]);
    }
    return "";
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService(z[37])).getActiveNetworkInfo();
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
  
  private static boolean b(Context paramContext, Class<?> paramClass)
  {
    try
    {
      boolean bool = paramContext.getPackageManager().queryIntentServices(new Intent(paramContext, paramClass), 0).isEmpty();
      return !bool;
    }
    catch (Throwable paramContext)
    {
      cn.jiguang.d.d.h(z[1], z[113] + paramContext.getMessage());
    }
    return false;
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
          throw new IllegalArgumentException(z[72]);
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
  
  public static int c(String paramString)
  {
    paramString = paramString.split(z[85]);
    int i = Integer.parseInt(paramString[0]);
    int j = Integer.parseInt(paramString[1]);
    return Integer.parseInt(paramString[2]) + ((i << 16) + (j << 8));
  }
  
  public static String c()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
      Object localObject = localInetAddress.getHostAddress().toString();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      cn.jiguang.d.d.g(z[1], z['']);
      localException.printStackTrace();
    }
    return "";
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService(z[37])).getActiveNetworkInfo();
      if (paramContext == null) {
        return z[36];
      }
      String str1 = paramContext.getTypeName();
      String str2 = paramContext.getSubtypeName();
      if (str1 == null) {
        return z[36];
      }
      paramContext = str1;
      if (!h.a(str2))
      {
        paramContext = str1 + "," + str2;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = z[36];
    }
    return paramContext;
  }
  
  /* Error */
  public static String c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: getstatic 441	android/os/Build$VERSION:SDK_INT	I
    //   6: bipush 23
    //   8: if_icmpge +102 -> 110
    //   11: aload_0
    //   12: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   15: bipush 50
    //   17: aaload
    //   18: invokestatic 926	cn/jiguang/f/a:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   21: istore_2
    //   22: iload_2
    //   23: ifne +5 -> 28
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   32: bipush 127
    //   34: aaload
    //   35: invokevirtual 654	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   38: checkcast 928	android/net/wifi/WifiManager
    //   41: invokevirtual 932	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   44: invokevirtual 937	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   47: astore_0
    //   48: aload_0
    //   49: invokestatic 476	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   52: istore_2
    //   53: iload_2
    //   54: ifne -28 -> 26
    //   57: aload_0
    //   58: areturn
    //   59: astore_0
    //   60: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   63: iconst_1
    //   64: aaload
    //   65: ldc_w 530
    //   68: aload_0
    //   69: invokestatic 939	cn/jiguang/d/d:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: aload_1
    //   73: areturn
    //   74: astore_0
    //   75: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   78: iconst_1
    //   79: aaload
    //   80: new 416	java/lang/StringBuilder
    //   83: dup
    //   84: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   87: bipush 126
    //   89: aaload
    //   90: invokespecial 496	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: aload_0
    //   94: invokevirtual 769	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 772	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: ldc_w 530
    //   109: areturn
    //   110: new 941	java/io/InputStreamReader
    //   113: dup
    //   114: invokestatic 947	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   117: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   120: sipush 129
    //   123: aaload
    //   124: invokevirtual 951	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   127: invokevirtual 957	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   130: invokespecial 960	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   133: astore 4
    //   135: new 962	java/io/LineNumberReader
    //   138: dup
    //   139: aload 4
    //   141: invokespecial 963	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 964	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   149: astore_0
    //   150: aload_0
    //   151: invokestatic 465	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifne +205 -> 359
    //   157: aload_0
    //   158: invokevirtual 855	java/lang/String:trim	()Ljava/lang/String;
    //   161: astore_0
    //   162: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   165: iconst_1
    //   166: aaload
    //   167: new 416	java/lang/StringBuilder
    //   170: dup
    //   171: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   174: sipush 128
    //   177: aaload
    //   178: invokespecial 496	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   181: aload_0
    //   182: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 498	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 4
    //   193: invokevirtual 965	java/io/InputStreamReader:close	()V
    //   196: aload_1
    //   197: invokevirtual 966	java/io/LineNumberReader:close	()V
    //   200: aload_0
    //   201: astore_3
    //   202: aload_3
    //   203: areturn
    //   204: astore_3
    //   205: aload_3
    //   206: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   209: goto -13 -> 196
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   217: aload_0
    //   218: astore_3
    //   219: goto -17 -> 202
    //   222: astore_3
    //   223: aconst_null
    //   224: astore 4
    //   226: ldc_w 530
    //   229: astore_0
    //   230: aload 5
    //   232: astore_1
    //   233: aload_3
    //   234: invokevirtual 594	java/lang/Exception:printStackTrace	()V
    //   237: aload 4
    //   239: ifnull +8 -> 247
    //   242: aload 4
    //   244: invokevirtual 965	java/io/InputStreamReader:close	()V
    //   247: aload_0
    //   248: astore_3
    //   249: aload_1
    //   250: ifnull -48 -> 202
    //   253: aload_1
    //   254: invokevirtual 966	java/io/LineNumberReader:close	()V
    //   257: aload_0
    //   258: astore_3
    //   259: goto -57 -> 202
    //   262: astore_1
    //   263: aload_1
    //   264: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   267: aload_0
    //   268: astore_3
    //   269: goto -67 -> 202
    //   272: astore_3
    //   273: aload_3
    //   274: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   277: goto -30 -> 247
    //   280: astore_0
    //   281: aconst_null
    //   282: astore_1
    //   283: aconst_null
    //   284: astore 4
    //   286: aload 4
    //   288: ifnull +8 -> 296
    //   291: aload 4
    //   293: invokevirtual 965	java/io/InputStreamReader:close	()V
    //   296: aload_1
    //   297: ifnull +7 -> 304
    //   300: aload_1
    //   301: invokevirtual 966	java/io/LineNumberReader:close	()V
    //   304: aload_0
    //   305: athrow
    //   306: astore_3
    //   307: aload_3
    //   308: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   311: goto -15 -> 296
    //   314: astore_1
    //   315: aload_1
    //   316: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   319: goto -15 -> 304
    //   322: astore_0
    //   323: aconst_null
    //   324: astore_1
    //   325: goto -39 -> 286
    //   328: astore_0
    //   329: goto -43 -> 286
    //   332: astore_0
    //   333: goto -47 -> 286
    //   336: astore_3
    //   337: ldc_w 530
    //   340: astore_0
    //   341: aload 5
    //   343: astore_1
    //   344: goto -111 -> 233
    //   347: astore_3
    //   348: ldc_w 530
    //   351: astore_0
    //   352: goto -119 -> 233
    //   355: astore_3
    //   356: goto -123 -> 233
    //   359: ldc_w 530
    //   362: astore_0
    //   363: goto -172 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	paramContext	Context
    //   0	366	1	paramString	String
    //   21	33	2	bool	boolean
    //   201	2	3	localContext1	Context
    //   204	2	3	localIOException1	IOException
    //   218	1	3	localContext2	Context
    //   222	12	3	localException1	Exception
    //   248	21	3	localContext3	Context
    //   272	2	3	localIOException2	IOException
    //   306	2	3	localIOException3	IOException
    //   336	1	3	localException2	Exception
    //   347	1	3	localException3	Exception
    //   355	1	3	localException4	Exception
    //   133	159	4	localInputStreamReader	java.io.InputStreamReader
    //   1	341	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	53	59	java/lang/Exception
    //   3	22	74	java/lang/Throwable
    //   28	53	74	java/lang/Throwable
    //   60	72	74	java/lang/Throwable
    //   191	196	74	java/lang/Throwable
    //   196	200	74	java/lang/Throwable
    //   205	209	74	java/lang/Throwable
    //   213	217	74	java/lang/Throwable
    //   242	247	74	java/lang/Throwable
    //   253	257	74	java/lang/Throwable
    //   263	267	74	java/lang/Throwable
    //   273	277	74	java/lang/Throwable
    //   291	296	74	java/lang/Throwable
    //   300	304	74	java/lang/Throwable
    //   304	306	74	java/lang/Throwable
    //   307	311	74	java/lang/Throwable
    //   315	319	74	java/lang/Throwable
    //   191	196	204	java/io/IOException
    //   196	200	212	java/io/IOException
    //   110	135	222	java/lang/Exception
    //   253	257	262	java/io/IOException
    //   242	247	272	java/io/IOException
    //   110	135	280	finally
    //   291	296	306	java/io/IOException
    //   300	304	314	java/io/IOException
    //   135	145	322	finally
    //   145	162	328	finally
    //   162	191	328	finally
    //   233	237	332	finally
    //   135	145	336	java/lang/Exception
    //   145	162	347	java/lang/Exception
    //   162	191	355	java/lang/Exception
  }
  
  public static int d(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return -1;
      IntentFilter localIntentFilter = new IntentFilter(z['']);
      try
      {
        paramContext = paramContext.registerReceiver(null, localIntentFilter);
        if (paramContext == null) {
          continue;
        }
        i = paramContext.getIntExtra(z[''], -1);
        if ((i == 2) || (i == 5))
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          return paramContext.getIntExtra(z[''], -1);
        }
      }
      catch (SecurityException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
          continue;
          int i = 0;
        }
      }
    }
  }
  
  public static String d(Context paramContext, String paramString)
  {
    String str = paramString;
    try
    {
      if (b(paramContext, z[10])) {
        str = ((TelephonyManager)paramContext.getSystemService(z[11])).getSimSerialNumber();
      }
      return str;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return paramString;
  }
  
  private static boolean d()
  {
    boolean bool = Environment.getExternalStorageState().equals(z[62]);
    if (!bool) {
      cn.jiguang.d.d.c(z[1], z[63]);
    }
    return bool;
  }
  
  private static boolean d(String paramString)
  {
    if (h.a(paramString)) {}
    while (paramString.length() < 10) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= b.size()) {
        break label74;
      }
      if ((paramString.equals(b.get(i))) || (paramString.startsWith((String)b.get(i)))) {
        break;
      }
      i += 1;
    }
    label74:
    return true;
  }
  
  private static String e()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Environment.getExternalStorageDirectory().getPath();
      localObject1 = localObject2;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        Object localObject2;
        localArrayIndexOutOfBoundsException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    localObject2 = localObject1;
    if (!h.a((String)localObject1)) {
      localObject2 = (String)localObject1 + z[122];
    }
    return (String)localObject2;
  }
  
  public static String e(Context paramContext)
  {
    String str = cn.jiguang.c.a.a.b(paramContext);
    if ((!h.a(str)) && (d(str))) {
      return str;
    }
    str = u(paramContext);
    cn.jiguang.c.a.a.b(paramContext, str);
    return str;
  }
  
  public static String e(Context paramContext, String paramString)
  {
    String str = paramString;
    try
    {
      if (b(paramContext, z[10])) {
        str = ((TelephonyManager)paramContext.getSystemService(z[11])).getDeviceId();
      }
      return str;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return paramString;
  }
  
  /* Error */
  private static String e(String paramString)
  {
    // Byte code:
    //   0: invokestatic 1023	cn/jiguang/f/a:e	()Ljava/lang/String;
    //   3: astore_1
    //   4: aload_1
    //   5: invokestatic 476	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   8: ifeq +21 -> 29
    //   11: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   14: iconst_1
    //   15: aaload
    //   16: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   19: bipush 116
    //   21: aaload
    //   22: invokestatic 491	cn/jiguang/d/d:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aconst_null
    //   26: astore_1
    //   27: aload_1
    //   28: areturn
    //   29: new 823	java/io/File
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 824	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 827	java/io/File:exists	()Z
    //   42: ifne +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 1026	java/io/File:mkdir	()Z
    //   49: pop
    //   50: invokestatic 1028	cn/jiguang/f/a:f	()Ljava/lang/String;
    //   53: invokestatic 476	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   56: ifeq +38 -> 94
    //   59: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   62: iconst_1
    //   63: aaload
    //   64: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   67: bipush 118
    //   69: aaload
    //   70: invokestatic 748	cn/jiguang/d/d:j	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aconst_null
    //   74: areturn
    //   75: astore_2
    //   76: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   79: iconst_1
    //   80: aaload
    //   81: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   84: bipush 117
    //   86: aaload
    //   87: aload_2
    //   88: invokestatic 939	cn/jiguang/d/d:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: goto -41 -> 50
    //   94: new 823	java/io/File
    //   97: dup
    //   98: new 416	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   105: aload_1
    //   106: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   112: bipush 35
    //   114: aaload
    //   115: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokespecial 824	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 827	java/io/File:exists	()Z
    //   129: ifeq +8 -> 137
    //   132: aload_1
    //   133: invokevirtual 1031	java/io/File:delete	()Z
    //   136: pop
    //   137: aload_1
    //   138: invokevirtual 1034	java/io/File:createNewFile	()Z
    //   141: pop
    //   142: new 1036	java/io/FileOutputStream
    //   145: dup
    //   146: aload_1
    //   147: invokespecial 1037	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   150: astore_2
    //   151: aload_2
    //   152: astore_1
    //   153: aload_2
    //   154: aload_0
    //   155: invokevirtual 1040	java/lang/String:getBytes	()[B
    //   158: invokevirtual 1044	java/io/FileOutputStream:write	([B)V
    //   161: aload_2
    //   162: astore_1
    //   163: aload_2
    //   164: invokevirtual 1047	java/io/FileOutputStream:flush	()V
    //   167: aload_2
    //   168: astore_1
    //   169: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   172: iconst_1
    //   173: aaload
    //   174: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   177: bipush 114
    //   179: aaload
    //   180: invokestatic 503	cn/jiguang/d/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload_0
    //   184: astore_1
    //   185: aload_2
    //   186: ifnull -159 -> 27
    //   189: aload_2
    //   190: invokevirtual 1048	java/io/FileOutputStream:close	()V
    //   193: aload_0
    //   194: areturn
    //   195: astore_1
    //   196: aload_0
    //   197: areturn
    //   198: astore_0
    //   199: aconst_null
    //   200: areturn
    //   201: astore_0
    //   202: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   205: iconst_1
    //   206: aaload
    //   207: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   210: bipush 6
    //   212: aaload
    //   213: aload_0
    //   214: invokestatic 939	cn/jiguang/d/d:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   217: aconst_null
    //   218: areturn
    //   219: astore_3
    //   220: aconst_null
    //   221: astore_0
    //   222: aload_0
    //   223: astore_1
    //   224: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   227: iconst_1
    //   228: aaload
    //   229: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   232: bipush 115
    //   234: aaload
    //   235: aload_3
    //   236: invokestatic 939	cn/jiguang/d/d:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   239: aload_0
    //   240: ifnull +7 -> 247
    //   243: aload_0
    //   244: invokevirtual 1048	java/io/FileOutputStream:close	()V
    //   247: aconst_null
    //   248: areturn
    //   249: astore_0
    //   250: aconst_null
    //   251: astore_1
    //   252: aload_1
    //   253: ifnull +7 -> 260
    //   256: aload_1
    //   257: invokevirtual 1048	java/io/FileOutputStream:close	()V
    //   260: aload_0
    //   261: athrow
    //   262: astore_0
    //   263: goto -16 -> 247
    //   266: astore_1
    //   267: goto -7 -> 260
    //   270: astore_0
    //   271: goto -19 -> 252
    //   274: astore_3
    //   275: aload_2
    //   276: astore_0
    //   277: goto -55 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramString	String
    //   3	182	1	localObject	Object
    //   195	1	1	localIOException1	IOException
    //   223	34	1	str	String
    //   266	1	1	localIOException2	IOException
    //   37	9	2	localFile	File
    //   75	13	2	localException	Exception
    //   150	126	2	localFileOutputStream	java.io.FileOutputStream
    //   219	17	3	localIOException3	IOException
    //   274	1	3	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   45	50	75	java/lang/Exception
    //   189	193	195	java/io/IOException
    //   132	137	198	java/lang/SecurityException
    //   137	142	201	java/io/IOException
    //   142	151	219	java/io/IOException
    //   142	151	249	finally
    //   243	247	262	java/io/IOException
    //   256	260	266	java/io/IOException
    //   153	161	270	finally
    //   163	167	270	finally
    //   169	183	270	finally
    //   224	239	270	finally
    //   153	161	274	java/io/IOException
    //   163	167	274	java/io/IOException
    //   169	183	274	java/io/IOException
  }
  
  private static int f(String paramString)
  {
    if (h.a(paramString)) {
      cn.jiguang.d.d.g(z[1], z[59]);
    }
    do
    {
      return 0;
      if (Pattern.matches(z[57], paramString))
      {
        cn.jiguang.d.d.e(z[1], z[58]);
        return 0;
      }
      if (Pattern.matches(z[55], paramString))
      {
        cn.jiguang.d.d.e(z[1], z[61]);
        return 1;
      }
    } while (!Pattern.matches(z[60], paramString));
    cn.jiguang.d.d.e(z[1], z[56]);
    return 2;
  }
  
  private static String f()
  {
    String str = e();
    if (str == null) {
      return null;
    }
    return str + z[35];
  }
  
  public static String f(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), z[123]);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      return "";
    }
    catch (SecurityException paramContext) {}
    return "";
  }
  
  public static String f(Context paramContext, String paramString)
  {
    String str = paramString;
    try
    {
      if (b(paramContext, z[10])) {
        str = ((TelephonyManager)paramContext.getSystemService(z[11])).getSubscriberId();
      }
      return str;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return paramString;
  }
  
  private static String g()
  {
    Object localObject = f();
    if (h.a((String)localObject))
    {
      cn.jiguang.d.d.j(z[1], z[118]);
      return null;
    }
    localObject = new File((String)localObject);
    if (((File)localObject).exists()) {
      try
      {
        localObject = d.a(new FileInputStream((File)localObject));
        if (((ArrayList)localObject).size() > 0)
        {
          localObject = (String)((ArrayList)localObject).get(0);
          cn.jiguang.d.d.e(z[1], z[120] + (String)localObject);
          return (String)localObject;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
    }
    return null;
  }
  
  public static String g(Context paramContext)
  {
    String str1 = null;
    Object localObject = cn.jiguang.c.a.a.x();
    if (!h.a((String)localObject))
    {
      a = c.d - 1;
      return (String)localObject;
    }
    localObject = j(paramContext, (String)localObject);
    if (!h.a((String)localObject))
    {
      a = c.b - 1;
      i(paramContext, (String)localObject);
      cn.jiguang.c.a.a.g((String)localObject);
      return (String)localObject;
    }
    if (!d())
    {
      cn.jiguang.d.d.i(z[1], z['']);
      localObject = str1;
    }
    while (!h.a((String)localObject))
    {
      a = c.c - 1;
      k(paramContext, (String)localObject);
      cn.jiguang.c.a.a.g((String)localObject);
      return (String)localObject;
      localObject = str1;
      if (b(paramContext, z[87])) {
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = str1;
          if (b(paramContext, z[87]))
          {
            localObject = str1;
            if (!b(paramContext, z[86])) {}
          }
        }
        else
        {
          localObject = g();
        }
      }
    }
    if (Build.VERSION.SDK_INT < 23) {}
    for (localObject = e(paramContext, (String)localObject);; localObject = "")
    {
      String str2 = f(paramContext);
      String str3 = c(paramContext, "");
      str1 = UUID.randomUUID().toString();
      str2 = a((String)localObject + str2 + str3 + str1);
      localObject = str2;
      if (h.a(str2)) {
        localObject = str1;
      }
      cn.jiguang.c.a.a.g((String)localObject);
      a = c.a - 1;
      k(paramContext, (String)localObject);
      i(paramContext, (String)localObject);
      return (String)localObject;
    }
  }
  
  public static void g(Context paramContext, String paramString)
  {
    if (!h.a(paramString))
    {
      k(paramContext, paramString);
      i(paramContext, paramString);
      cn.jiguang.c.a.a.g(paramString);
    }
  }
  
  public static void h(Context paramContext)
  {
    cn.jiguang.d.d.c(z[1], z[74]);
    long l1 = cn.jiguang.c.a.a.j() * 1000;
    long l2 = System.currentTimeMillis() + l1;
    cn.jiguang.d.d.e(z[1], z[76] + l1 + z[75]);
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, AlarmReceiver.class), 0);
    paramContext = (AlarmManager)paramContext.getSystemService(z[73]);
    try
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        paramContext.setWindow(0, l2, 0L, localPendingIntent);
        return;
      }
      paramContext.setInexactRepeating(0, l2, l1, localPendingIntent);
      return;
    }
    catch (Exception paramContext)
    {
      cn.jiguang.d.d.h(z[1], z[77] + paramContext.getMessage());
    }
  }
  
  private static boolean h(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      throw new IllegalArgumentException(z[72]);
    }
    try
    {
      paramContext.getPackageManager().getPermissionInfo(paramString, 128);
      return true;
    }
    catch (Throwable paramContext)
    {
      cn.jiguang.d.d.h(z[1], z[''] + paramContext.getMessage());
    }
    return false;
  }
  
  private static String i(Context paramContext, String paramString)
  {
    if ((!d()) || (!b(paramContext, z[87]))) {}
    do
    {
      return null;
      if (Build.VERSION.SDK_INT < 23) {
        return e(paramString);
      }
    } while ((!b(paramContext, z[87])) || (!b(paramContext, z[86])));
    return e(paramString);
  }
  
  public static void i(Context paramContext)
  {
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, AlarmReceiver.class), 0);
    try
    {
      ((AlarmManager)paramContext.getSystemService(z[73])).cancel(localPendingIntent);
      return;
    }
    catch (Exception paramContext)
    {
      cn.jiguang.d.d.g(z[1], z['']);
    }
  }
  
  private static String j(Context paramContext, String paramString)
  {
    String str = paramString;
    if (b(paramContext, z[103])) {}
    try
    {
      str = Settings.System.getString(paramContext.getContentResolver(), z['']);
      return str;
    }
    catch (Exception paramContext)
    {
      cn.jiguang.d.d.i(z[1], z['']);
    }
    return paramString;
  }
  
  public static void j(Context paramContext)
  {
    
    try
    {
      paramContext = ((PowerManager)paramContext.getSystemService(z[84])).newWakeLock(1, cn.jiguang.c.a.c + z[80]);
      paramContext.setReferenceCounted(false);
      e.a().a(paramContext);
      if (!e.a().b().isHeld())
      {
        e.a().b().acquire();
        c = System.currentTimeMillis();
        cn.jiguang.d.d.a(z[1], z[79]);
        return;
      }
      cn.jiguang.d.d.a(z[1], z[83]);
      return;
    }
    catch (IllegalStateException paramContext)
    {
      paramContext.printStackTrace();
      cn.jiguang.d.d.c(z[1], z[81]);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      cn.jiguang.d.d.c(z[1], z[82]);
    }
  }
  
  public static String k(Context paramContext)
  {
    String str = cn.jiguang.c.a.f;
    Object localObject = str;
    if (h.a(str)) {
      localObject = paramContext.getPackageManager();
    }
    try
    {
      paramContext = ((PackageManager)localObject).getApplicationInfo(paramContext.getPackageName(), 128);
      localObject = str;
      if (paramContext != null)
      {
        localObject = str;
        if (paramContext.metaData != null) {
          localObject = paramContext.metaData.getString(z['']);
        }
      }
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return str;
  }
  
  private static String k(Context paramContext, String paramString)
  {
    if (b(paramContext, z[103])) {
      try
      {
        boolean bool = Settings.System.putString(paramContext.getContentResolver(), z[''], paramString);
        if (bool) {
          return paramString;
        }
      }
      catch (Exception paramContext)
      {
        cn.jiguang.d.d.i(z[1], z['']);
      }
    }
    return null;
  }
  
  public static void l(Context paramContext)
  {
    if (cn.jiguang.c.a.a.A()) {}
    String str2;
    String str3;
    Object localObject2;
    Object localObject1;
    int i;
    int j;
    do
    {
      return;
      str2 = e(paramContext, "");
      str3 = cn.jiguang.c.a.a.B();
      localObject2 = f(paramContext);
      localObject1 = localObject2;
      if (h.a((String)localObject2)) {
        localObject1 = " ";
      }
      String str1 = c(paramContext, "");
      localObject2 = str1;
      if (h.a(str1)) {
        localObject2 = " ";
      }
      i = f(str3);
      j = f(str2);
      if ((i != 0) && (j != 0)) {
        break;
      }
    } while (cn.jiguang.c.a.a.b((String)localObject1, (String)localObject2));
    label147:
    do
    {
      do
      {
        do
        {
          m(paramContext);
          return;
          if (((1 == i) && (2 == j)) || ((2 == i) && (1 == j))) {
            break;
          }
        } while (i != j);
        if (!str2.equals(str3)) {
          break label147;
        }
      } while (!cn.jiguang.c.a.a.a(str2, (String)localObject1));
      return;
    } while (!cn.jiguang.c.a.a.b((String)localObject1, (String)localObject2));
  }
  
  private static boolean l(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getPackageManager();
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), paramString);
    try
    {
      localObject = ((PackageManager)localObject).getServiceInfo(localComponentName, 128);
      cn.jiguang.d.d.a(z[1], z[''] + ((ServiceInfo)localObject).processName);
      boolean bool = ((ServiceInfo)localObject).processName.contains(paramContext.getPackageName() + ":");
      if (bool) {
        return true;
      }
    }
    catch (NullPointerException paramContext)
    {
      cn.jiguang.d.d.a(z[1], z[''] + paramString);
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
  }
  
  public static void m(Context paramContext)
  {
    cn.jiguang.d.d.c(z[1], z[121]);
    cn.jiguang.c.a.a.t();
    k(paramContext, "");
    i(paramContext, "");
    cn.jiguang.c.f.b.e().b(paramContext);
  }
  
  public static boolean n(Context paramContext)
  {
    boolean bool2 = true;
    String str1 = i.a(paramContext, z[91]);
    cn.jiguang.d.d.c(z[1], z[90] + str1);
    String str2 = i.a(paramContext, z[95]);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str1))
    {
      bool1 = bool2;
      if (z[92].equals(str1))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(str2))
        {
          paramContext = i.a(paramContext, z[93]);
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramContext))
          {
            bool1 = bool2;
            if (paramContext.startsWith(z[89]))
            {
              cn.jiguang.d.d.g(z[1], z[94]);
              bool1 = false;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static double o(Context paramContext)
  {
    Point localPoint = new Point();
    Object localObject;
    double d2;
    if ((paramContext instanceof Activity))
    {
      localObject = ((Activity)paramContext).getWindowManager().getDefaultDisplay();
      if (Build.VERSION.SDK_INT >= 17)
      {
        ((Display)localObject).getRealSize(localPoint);
        cn.jiguang.d.d.c(z[1], z[66] + localPoint.x + z[70] + localPoint.y);
      }
    }
    else
    {
      localObject = paramContext.getResources().getDisplayMetrics();
      cn.jiguang.d.d.c(z[1], z[69] + ((DisplayMetrics)localObject).xdpi + z[65] + ((DisplayMetrics)localObject).ydpi);
      if (!(paramContext instanceof Activity)) {
        break label277;
      }
      d2 = Math.pow(localPoint.x / ((DisplayMetrics)localObject).xdpi, 2.0D);
    }
    for (double d1 = Math.pow(localPoint.y / ((DisplayMetrics)localObject).ydpi, 2.0D);; d1 = Math.pow(((DisplayMetrics)localObject).heightPixels / ((DisplayMetrics)localObject).ydpi, 2.0D))
    {
      d1 = Math.sqrt(d1 + d2);
      cn.jiguang.d.d.c(z[1], z[67] + d1);
      return d1;
      if (Build.VERSION.SDK_INT >= 13)
      {
        ((Display)localObject).getSize(localPoint);
        break;
      }
      localPoint.x = ((Display)localObject).getWidth();
      localPoint.y = ((Display)localObject).getHeight();
      break;
      label277:
      cn.jiguang.d.d.c(z[1], z[68] + ((DisplayMetrics)localObject).widthPixels + z[64] + ((DisplayMetrics)localObject).heightPixels);
      d2 = Math.pow(((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).xdpi, 2.0D);
    }
  }
  
  public static boolean p(Context paramContext)
  {
    return b(paramContext, PushService.class);
  }
  
  public static boolean q(Context paramContext)
  {
    return a(paramContext, AlarmReceiver.class);
  }
  
  public static boolean r(Context paramContext)
  {
    cn.jiguang.d.d.d(z[1], z[99]);
    String str;
    if ((cn.jiguang.c.d.d.a().g()) || (cn.jiguang.c.d.d.a().h()))
    {
      if (!b(paramContext, PushService.class)) {
        cn.jiguang.d.d.j(z[1], z[101] + PushService.class.getCanonicalName());
      }
      for (int i = 0; i == 0; i = 1) {
        return false;
      }
      if (l(paramContext, PushService.class.getCanonicalName())) {
        cn.jiguang.d.d.a(z[1], z[109]);
      }
      for (cn.jiguang.c.a.k = true; !a(paramContext, PushReceiver.class); cn.jiguang.c.a.k = false)
      {
        cn.jiguang.d.d.j(z[1], z[100] + PushReceiver.class.getCanonicalName());
        if (y(paramContext)) {
          break;
        }
        return false;
        cn.jiguang.d.d.a(z[1], z[102]);
      }
      if (a(paramContext, PushReceiver.class.getCanonicalName(), z[98])) {
        cn.jiguang.d.d.h(z[1], z[105]);
      }
      if (!a(paramContext, z[111], false))
      {
        cn.jiguang.d.d.j(z[1], z[107]);
        return false;
      }
      if (!a(paramContext, AlarmReceiver.class))
      {
        cn.jiguang.d.d.j(z[1], z[100] + AlarmReceiver.class.getCanonicalName());
        return false;
      }
      localObject = paramContext.getPackageName() + z[110];
      if (!h(paramContext, (String)localObject))
      {
        cn.jiguang.d.d.j(z[1], z[96] + (String)localObject);
        return false;
      }
      d.add(localObject);
      localObject = d.iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if (!b(paramContext.getApplicationContext(), str))
        {
          cn.jiguang.d.d.j(z[1], z[108] + str);
          return false;
        }
      }
      if (Build.VERSION.SDK_INT < 23)
      {
        if (!b(paramContext.getApplicationContext(), z[87]))
        {
          cn.jiguang.d.d.j(z[1], z[97]);
          return false;
        }
        if (!b(paramContext.getApplicationContext(), z[103]))
        {
          cn.jiguang.d.d.j(z[1], z[112]);
          return false;
        }
      }
    }
    Object localObject = e.iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if (!b(paramContext.getApplicationContext(), str)) {
        cn.jiguang.d.d.g(z[1], z[104] + str);
      }
    }
    localObject = f.iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if (!b(paramContext.getApplicationContext(), str)) {
        cn.jiguang.d.d.g(z[1], z[104] + str + z[106]);
      }
    }
    return true;
  }
  
  private static String s(Context paramContext)
  {
    if (!b(paramContext, z[50])) {}
    for (;;)
    {
      return null;
      try
      {
        paramContext = c(paramContext, "");
        if ((paramContext != null) && (!paramContext.equals("")))
        {
          cn.jiguang.d.d.e(z[1], z[51] + paramContext);
          paramContext = a(paramContext + Build.MODEL);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        cn.jiguang.d.d.e(z[1], "", paramContext);
      }
    }
    return null;
  }
  
  /* Error */
  private static boolean t(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore_2
    //   8: iload 5
    //   10: istore_3
    //   11: iload 6
    //   13: istore 4
    //   15: new 1321	javax/security/auth/x500/X500Principal
    //   18: dup
    //   19: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   22: sipush 137
    //   25: aaload
    //   26: invokespecial 1322	javax/security/auth/x500/X500Principal:<init>	(Ljava/lang/String;)V
    //   29: astore 7
    //   31: iload 5
    //   33: istore_3
    //   34: iload 6
    //   36: istore 4
    //   38: iconst_3
    //   39: anewarray 24	java/lang/String
    //   42: astore 8
    //   44: iload 5
    //   46: istore_3
    //   47: iload 6
    //   49: istore 4
    //   51: aload 8
    //   53: iconst_0
    //   54: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   57: sipush 138
    //   60: aaload
    //   61: aastore
    //   62: iload 5
    //   64: istore_3
    //   65: iload 6
    //   67: istore 4
    //   69: aload 8
    //   71: iconst_1
    //   72: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   75: sipush 134
    //   78: aaload
    //   79: aastore
    //   80: iload 5
    //   82: istore_3
    //   83: iload 6
    //   85: istore 4
    //   87: aload 8
    //   89: iconst_2
    //   90: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   93: sipush 135
    //   96: aaload
    //   97: aastore
    //   98: iload 5
    //   100: istore_3
    //   101: iload 6
    //   103: istore 4
    //   105: aload_0
    //   106: invokevirtual 660	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   109: aload_0
    //   110: invokevirtual 667	android/content/Context:getPackageName	()Ljava/lang/String;
    //   113: bipush 64
    //   115: invokevirtual 1326	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   118: getfield 1332	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   121: astore 9
    //   123: iload 5
    //   125: istore_3
    //   126: iload 6
    //   128: istore 4
    //   130: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   133: sipush 136
    //   136: aaload
    //   137: invokestatic 1337	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   140: astore 10
    //   142: iconst_0
    //   143: istore_1
    //   144: iload_2
    //   145: istore_3
    //   146: iload_2
    //   147: istore 4
    //   149: iload_1
    //   150: aload 9
    //   152: arraylength
    //   153: if_icmpge +127 -> 280
    //   156: iload_2
    //   157: istore_3
    //   158: iload_2
    //   159: istore 4
    //   161: aload 10
    //   163: new 1339	java/io/ByteArrayInputStream
    //   166: dup
    //   167: aload 9
    //   169: iload_1
    //   170: aaload
    //   171: invokevirtual 1344	android/content/pm/Signature:toByteArray	()[B
    //   174: invokespecial 1346	java/io/ByteArrayInputStream:<init>	([B)V
    //   177: invokevirtual 1350	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   180: checkcast 1352	java/security/cert/X509Certificate
    //   183: astore_0
    //   184: iload_2
    //   185: istore_3
    //   186: iload_2
    //   187: istore 4
    //   189: aload_0
    //   190: invokevirtual 1356	java/security/cert/X509Certificate:getSubjectX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   193: aload 7
    //   195: invokevirtual 1357	javax/security/auth/x500/X500Principal:equals	(Ljava/lang/Object;)Z
    //   198: istore_2
    //   199: iload_2
    //   200: ifne +78 -> 278
    //   203: aload_0
    //   204: invokevirtual 1356	java/security/cert/X509Certificate:getSubjectX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   207: invokevirtual 1360	javax/security/auth/x500/X500Principal:getName	()Ljava/lang/String;
    //   210: astore_0
    //   211: aload_0
    //   212: ifnull +46 -> 258
    //   215: aload_0
    //   216: aload 8
    //   218: iconst_0
    //   219: aaload
    //   220: invokevirtual 843	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   223: ifeq +35 -> 258
    //   226: aload_0
    //   227: aload 8
    //   229: iconst_1
    //   230: aaload
    //   231: invokevirtual 843	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   234: ifeq +24 -> 258
    //   237: aload_0
    //   238: aload 8
    //   240: iconst_2
    //   241: aaload
    //   242: invokevirtual 843	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   245: istore_3
    //   246: iload_3
    //   247: ifeq +11 -> 258
    //   250: iconst_1
    //   251: ireturn
    //   252: astore_0
    //   253: aconst_null
    //   254: astore_0
    //   255: goto -44 -> 211
    //   258: iload_1
    //   259: iconst_1
    //   260: iadd
    //   261: istore_1
    //   262: goto -118 -> 144
    //   265: astore_0
    //   266: iload_3
    //   267: ireturn
    //   268: astore_0
    //   269: iload_2
    //   270: ireturn
    //   271: astore_0
    //   272: iload 4
    //   274: ireturn
    //   275: astore_0
    //   276: iload_2
    //   277: ireturn
    //   278: iload_2
    //   279: ireturn
    //   280: iload_2
    //   281: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramContext	Context
    //   143	119	1	i	int
    //   7	274	2	bool1	boolean
    //   10	257	3	bool2	boolean
    //   13	260	4	bool3	boolean
    //   1	123	5	bool4	boolean
    //   4	123	6	bool5	boolean
    //   29	165	7	localX500Principal	javax.security.auth.x500.X500Principal
    //   42	197	8	arrayOfString	String[]
    //   121	47	9	arrayOfSignature	android.content.pm.Signature[]
    //   140	22	10	localCertificateFactory	java.security.cert.CertificateFactory
    // Exception table:
    //   from	to	target	type
    //   203	211	252	java/lang/Exception
    //   15	31	265	java/lang/Throwable
    //   38	44	265	java/lang/Throwable
    //   51	62	265	java/lang/Throwable
    //   69	80	265	java/lang/Throwable
    //   87	98	265	java/lang/Throwable
    //   105	123	265	java/lang/Throwable
    //   130	142	265	java/lang/Throwable
    //   149	156	265	java/lang/Throwable
    //   161	184	265	java/lang/Throwable
    //   189	199	265	java/lang/Throwable
    //   203	211	268	java/lang/Throwable
    //   215	246	268	java/lang/Throwable
    //   15	31	271	android/content/pm/PackageManager$NameNotFoundException
    //   38	44	271	android/content/pm/PackageManager$NameNotFoundException
    //   51	62	271	android/content/pm/PackageManager$NameNotFoundException
    //   69	80	271	android/content/pm/PackageManager$NameNotFoundException
    //   87	98	271	android/content/pm/PackageManager$NameNotFoundException
    //   105	123	271	android/content/pm/PackageManager$NameNotFoundException
    //   130	142	271	android/content/pm/PackageManager$NameNotFoundException
    //   149	156	271	android/content/pm/PackageManager$NameNotFoundException
    //   161	184	271	android/content/pm/PackageManager$NameNotFoundException
    //   189	199	271	android/content/pm/PackageManager$NameNotFoundException
    //   203	211	275	android/content/pm/PackageManager$NameNotFoundException
    //   215	246	275	android/content/pm/PackageManager$NameNotFoundException
  }
  
  private static String u(Context paramContext)
  {
    try
    {
      Object localObject = e(paramContext, "");
      if (d((String)localObject)) {
        return (String)localObject;
      }
      String str2 = f(paramContext);
      if ((!h.a(str2)) && (d(str2)))
      {
        localObject = str2;
        if (!z[78].equals(str2.toLowerCase(Locale.getDefault()))) {}
      }
      else
      {
        str2 = s(paramContext);
        if (!h.a(str2))
        {
          localObject = str2;
          if (d(str2)) {}
        }
        else
        {
          str2 = v(paramContext);
          localObject = str2;
          if (str2 == null) {
            return " ";
          }
        }
      }
    }
    catch (Exception localException)
    {
      cn.jiguang.d.d.e(z[1], "", localException);
      String str1 = v(paramContext);
      return str1;
    }
  }
  
  private static String v(Context paramContext)
  {
    cn.jiguang.d.d.c(z[1], z[88]);
    Object localObject = paramContext.getSharedPreferences(z[21], 0).getString(z[20], null);
    if (!h.a((String)localObject)) {}
    String str;
    do
    {
      return (String)localObject;
      if (!d()) {
        return x(paramContext);
      }
      str = cn.jiguang.c.a.a.a(paramContext);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    if ((Build.VERSION.SDK_INT >= 23) && ((!b(paramContext, z[87])) || (!b(paramContext, z[86])))) {
      return x(paramContext);
    }
    return w(paramContext);
  }
  
  /* Error */
  private static String w(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 1023	cn/jiguang/f/a:e	()Ljava/lang/String;
    //   3: astore_1
    //   4: aload_1
    //   5: ifnonnull +97 -> 102
    //   8: aconst_null
    //   9: astore_1
    //   10: aload_1
    //   11: invokestatic 476	cn/jiguang/f/h:a	(Ljava/lang/String;)Z
    //   14: ifne +311 -> 325
    //   17: new 823	java/io/File
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 824	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +107 -> 134
    //   30: aload_1
    //   31: invokevirtual 827	java/io/File:exists	()Z
    //   34: ifeq +100 -> 134
    //   37: new 1069	java/io/FileInputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 1070	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokestatic 1075	cn/jiguang/f/d:a	(Ljava/io/InputStream;)Ljava/util/ArrayList;
    //   48: astore_2
    //   49: aload_2
    //   50: invokevirtual 1076	java/util/ArrayList:size	()I
    //   53: ifle +81 -> 134
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 1077	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   61: checkcast 24	java/lang/String
    //   64: astore_2
    //   65: aload_0
    //   66: aload_2
    //   67: invokestatic 1392	cn/jiguang/c/a/a:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   70: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   73: iconst_1
    //   74: aaload
    //   75: new 416	java/lang/StringBuilder
    //   78: dup
    //   79: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   82: bipush 7
    //   84: aaload
    //   85: invokespecial 496	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload_2
    //   89: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 503	cn/jiguang/d/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_2
    //   99: astore_0
    //   100: aload_0
    //   101: areturn
    //   102: new 416	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   109: aload_1
    //   110: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   116: bipush 8
    //   118: aaload
    //   119: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_1
    //   126: goto -116 -> 10
    //   129: astore_2
    //   130: aload_2
    //   131: invokevirtual 594	java/lang/Exception:printStackTrace	()V
    //   134: new 416	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   141: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   144: invokevirtual 585	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   147: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokevirtual 1040	java/lang/String:getBytes	()[B
    //   153: invokestatic 1396	java/util/UUID:nameUUIDFromBytes	([B)Ljava/util/UUID;
    //   156: invokevirtual 1114	java/util/UUID:toString	()Ljava/lang/String;
    //   159: invokestatic 1398	cn/jiguang/f/h:b	(Ljava/lang/String;)Ljava/lang/String;
    //   162: astore_3
    //   163: aload_0
    //   164: aload_3
    //   165: invokestatic 1392	cn/jiguang/c/a/a:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   168: aload_1
    //   169: ifnull +63 -> 232
    //   172: aload_1
    //   173: invokevirtual 1034	java/io/File:createNewFile	()Z
    //   176: pop
    //   177: new 1036	java/io/FileOutputStream
    //   180: dup
    //   181: aload_1
    //   182: invokespecial 1037	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   185: astore_1
    //   186: aload_1
    //   187: astore_0
    //   188: aload_1
    //   189: aload_3
    //   190: invokevirtual 1040	java/lang/String:getBytes	()[B
    //   193: invokevirtual 1044	java/io/FileOutputStream:write	([B)V
    //   196: aload_1
    //   197: astore_0
    //   198: aload_1
    //   199: invokevirtual 1047	java/io/FileOutputStream:flush	()V
    //   202: aload_1
    //   203: astore_0
    //   204: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   207: iconst_1
    //   208: aaload
    //   209: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   212: iconst_5
    //   213: aaload
    //   214: invokestatic 503	cn/jiguang/d/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_3
    //   218: astore_0
    //   219: aload_1
    //   220: ifnull -120 -> 100
    //   223: aload_1
    //   224: invokevirtual 1048	java/io/FileOutputStream:close	()V
    //   227: aload_3
    //   228: areturn
    //   229: astore_0
    //   230: aload_3
    //   231: areturn
    //   232: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   235: iconst_1
    //   236: aaload
    //   237: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   240: iconst_4
    //   241: aaload
    //   242: invokestatic 491	cn/jiguang/d/d:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_3
    //   246: areturn
    //   247: astore_0
    //   248: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   251: iconst_1
    //   252: aaload
    //   253: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   256: bipush 6
    //   258: aaload
    //   259: aload_0
    //   260: invokestatic 939	cn/jiguang/d/d:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   263: aload_3
    //   264: areturn
    //   265: astore_2
    //   266: aconst_null
    //   267: astore_1
    //   268: aload_1
    //   269: astore_0
    //   270: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   273: iconst_1
    //   274: aaload
    //   275: getstatic 344	cn/jiguang/f/a:z	[Ljava/lang/String;
    //   278: bipush 9
    //   280: aaload
    //   281: aload_2
    //   282: invokestatic 939	cn/jiguang/d/d:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   285: aload_3
    //   286: astore_0
    //   287: aload_1
    //   288: ifnull -188 -> 100
    //   291: aload_1
    //   292: invokevirtual 1048	java/io/FileOutputStream:close	()V
    //   295: aload_3
    //   296: areturn
    //   297: astore_0
    //   298: aload_3
    //   299: areturn
    //   300: astore_1
    //   301: aconst_null
    //   302: astore_0
    //   303: aload_0
    //   304: ifnull +7 -> 311
    //   307: aload_0
    //   308: invokevirtual 1048	java/io/FileOutputStream:close	()V
    //   311: aload_1
    //   312: athrow
    //   313: astore_0
    //   314: goto -3 -> 311
    //   317: astore_1
    //   318: goto -15 -> 303
    //   321: astore_2
    //   322: goto -54 -> 268
    //   325: aconst_null
    //   326: astore_1
    //   327: goto -301 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	paramContext	Context
    //   3	289	1	localObject1	Object
    //   300	12	1	localObject2	Object
    //   317	1	1	localObject3	Object
    //   326	1	1	localObject4	Object
    //   48	51	2	localObject5	Object
    //   129	2	2	localException	Exception
    //   265	17	2	localIOException1	IOException
    //   321	1	2	localIOException2	IOException
    //   162	137	3	str	String
    // Exception table:
    //   from	to	target	type
    //   30	98	129	java/lang/Exception
    //   223	227	229	java/io/IOException
    //   172	177	247	java/io/IOException
    //   232	245	247	java/io/IOException
    //   177	186	265	java/io/IOException
    //   291	295	297	java/io/IOException
    //   177	186	300	finally
    //   307	311	313	java/io/IOException
    //   188	196	317	finally
    //   198	202	317	finally
    //   204	217	317	finally
    //   270	285	317	finally
    //   188	196	321	java/io/IOException
    //   198	202	321	java/io/IOException
    //   204	217	321	java/io/IOException
  }
  
  private static String x(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(z[21], 0);
    Object localObject = localSharedPreferences.getString(z[20], null);
    paramContext = (Context)localObject;
    if (localObject == null)
    {
      paramContext = UUID.randomUUID().toString();
      localObject = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putString(z[20], paramContext);
      ((SharedPreferences.Editor)localObject).commit();
    }
    return paramContext;
  }
  
  private static boolean y(Context paramContext)
  {
    cn.jiguang.d.d.e(z[1], z[15]);
    try
    {
      if (g == null) {
        g = new PushReceiver();
      }
      paramContext.registerReceiver(g, new IntentFilter(z[18]));
      paramContext.registerReceiver(g, new IntentFilter(z[19]));
      IntentFilter localIntentFilter1 = new IntentFilter(z[14]);
      localIntentFilter1.addDataScheme(z[17]);
      IntentFilter localIntentFilter2 = new IntentFilter(z[12]);
      localIntentFilter2.addDataScheme(z[17]);
      IntentFilter localIntentFilter3 = new IntentFilter(z[13]);
      localIntentFilter3.setPriority(1000);
      localIntentFilter3.addCategory(paramContext.getPackageName());
      paramContext.registerReceiver(g, localIntentFilter1);
      paramContext.registerReceiver(g, localIntentFilter2);
      paramContext.registerReceiver(g, localIntentFilter3);
      return true;
    }
    catch (Exception paramContext)
    {
      cn.jiguang.d.d.h(z[1], z[16] + paramContext.getMessage());
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */