package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jiguang.a.c.c;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.c.d.i;
import cn.jiguang.d.d;
import cn.jiguang.f.f;
import cn.jiguang.f.h;
import com.growingio.android.sdk.agent.VdsAgent;

public class PushReceiver
  extends BroadcastReceiver
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[33];
    int j = 0;
    Object localObject2 = "'$>^\0240 g";
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
        i = 117;
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
        localObject2 = "%1>";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "9 )B\032%.\024[\0238";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "\005 >P\034! 9\025\0338e<V\001>*3\025\034918[\001w'/Z\0243&<F\001ye\032\\\0032e(EU'72V\020$64[\022y";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "ye\031ZU9*)]\0349\"s";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "6+9G\032>!s\\\033# 3A[6&)\\\0329k\bf0\005\032\rg0\004\000\023a";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\005 >P\034! 9\025\033\")1\025\034918[\001w'/Z\0243&<F\001ye\032\\\0032e(EU'72V\020$64[\022y";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\032\b\016\025\032%e\016`%\033e3P\001 */^U$1<A\020w&5T\0330 q\025\0018e9ZU9*)]\0349\"|";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "4+s_\005\"65\033\0249!/Z\0343k4[\0012+)\0336\030\013\023p6\003\f\013|!\016\032\036}4\031\002\030";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "$!6A\f' ";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "\031 )B\032%.}\\\006w!4F\0268+3P\026# 9\033";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "\024*3[\020414Z\033w6)T\0012e>]\0249\"8QU#*}\030U";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "4+s_\005\"65\033\0249!/Z\0343k4[\0012+)\033'\003\006";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "815P\007w+8A\002876\025\006#$)PUze";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "6+9G\032>!s\\\033# 3A[6&)\\\0329k\037z:\003\032\036z8\007\t\030a0\023";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "8+\017P\0262,+PUze";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "9*\036Z\0339 >A\034!,)L";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "\0070.]'2&8\\\00327";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "8+\017P\0262,+PUm\017\036Z\0072\f3A\020%#<V\020w,3\\\001w#<\\\0312!";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "4+s_\005\"65\033\0249!/Z\0343k4[\0012+)\033;\030\021\024s<\024\004\t|:\031\032\022e0\031\000\031j%\005\n\005l";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "3 ?@\022\b+2A\0341,>T\001>*3";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "6+9G\032>!s\\\033# 3A[6&)\\\0329k\rt6\034\004\032p*\005\000\020z#\022\001";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "\020 )\025\002%*3RU3$)TU$1/\\\0330e;G\032:e4[\0012+)\017U";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "6+9G\032>!s\\\033# 3A[6&)\\\0329k\rt6\034\004\032p*\026\001\031p1";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "\031*)\025\023803QU9 )B\032%.\024[\0238";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "\005 >P\034! 9\025\024414Z\033w,.\025\033\")1";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "\031 )B\032%.}\\\006w&2[\0332&)P\021y";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "#*<F\001\003 %A";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "4*3[\020414Z\033z6)T\0012";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        j = 29;
        localObject2 = "%1>j\0212)<L";
        i = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i4] = localObject1;
        j = 30;
        localObject2 = "me\032P\001w+2\025\02161<\025\023%*0\025\034918[\001y";
        i = 29;
        localObject1 = arrayOfString;
        break;
      case 29: 
        localObject3[i4] = localObject1;
        j = 31;
        localObject2 = "\031*}T\033.e3P\001 */^U>6}V\0329+8V\0012!";
        i = 30;
        localObject1 = arrayOfString;
        break;
      case 30: 
        localObject3[i4] = localObject1;
        j = 32;
        localObject2 = "6+9G\032>!s[\020#k>Z\0339k\036z;\031\000\036a<\001\f\tl*\024\r\034{2\022";
        i = 31;
        localObject1 = arrayOfString;
        break;
      case 31: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 87;
        continue;
        i = 69;
        continue;
        i = 93;
        continue;
        i = 53;
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      d.h(z[17], z[6]);
      return;
    }
    Object localObject2;
    try
    {
      localObject2 = paramIntent.getAction();
      d.d(z[17], z[15] + (String)localObject2);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        d.h(z[17], z[25]);
        return;
      }
    }
    catch (NullPointerException paramContext)
    {
      d.h(z[17], z[3]);
      return;
    }
    Object localObject1;
    if ((((String)localObject2).equals(z[19])) && (paramIntent.getBooleanExtra(z[20], false)))
    {
      localObject1 = paramIntent.getStringExtra(z[27]);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramContext = Toast.makeText(paramContext, (CharSequence)localObject1, 0);
      }
    }
    try
    {
      paramIntent = paramContext.getView();
      if ((paramIntent instanceof LinearLayout))
      {
        paramIntent = ((LinearLayout)paramIntent).getChildAt(0);
        if ((paramIntent instanceof TextView))
        {
          paramIntent = (TextView)paramIntent;
          if (!h.a((String)localObject1)) {
            paramIntent.setText((CharSequence)localObject1);
          }
          paramIntent.setTextSize(13.0F);
        }
      }
    }
    catch (Exception paramIntent)
    {
      int i;
      label540:
      for (;;) {}
    }
    if (!(paramContext instanceof Toast))
    {
      paramContext.show();
      return;
    }
    VdsAgent.showToast((Toast)paramContext);
    return;
    if (!JCoreInterface.init(paramContext.getApplicationContext(), false))
    {
      d.h(z[17], z[18]);
      return;
    }
    if ((((String)localObject2).equals(z[14])) || (((String)localObject2).equals(z[5])))
    {
      i = 500;
      if (((String)localObject2).equals(z[5])) {
        i = 0;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt(z[29], i);
      ((Bundle)localObject1).putString(z[1], z[1]);
      i.a().b(paramContext, z[12], (Bundle)localObject1);
    }
    for (;;)
    {
      cn.jiguang.c.d.a.a();
      cn.jiguang.c.d.a.a(paramContext, paramIntent.getStringExtra(z[9]), paramIntent);
      return;
      if ((((String)localObject2).equals(z[23])) || (((String)localObject2).equals(z[21])))
      {
        localObject1 = paramIntent.getDataString();
        if (localObject1 != null) {
          if ((((String)localObject1).trim().length() > 8) && (((String)localObject1).startsWith(z[0])))
          {
            localObject1 = ((String)localObject1).substring(8);
            if (!((String)localObject2).equals(z[23])) {
              break label540;
            }
            c.a(paramContext, f.a((String)localObject1));
          }
        }
        for (;;)
        {
          c.a(paramContext, (String)localObject1);
          break;
          d.h(z[17], z[22] + (String)localObject1);
          return;
          d.h(z[17], (String)localObject2 + z[30]);
          return;
          c.a(paramContext, f.b((String)localObject1));
        }
      }
      if (((String)localObject2).equalsIgnoreCase(z[32]))
      {
        localObject1 = (NetworkInfo)paramIntent.getParcelableExtra(z[2]);
        if (localObject1 == null)
        {
          d.g(z[17], z[24]);
          return;
        }
        d.c(z[17], z[11] + ((NetworkInfo)localObject1).toString());
        if ((2 == ((NetworkInfo)localObject1).getType()) || (3 == ((NetworkInfo)localObject1).getType()))
        {
          d.c(z[17], z[7]);
          return;
        }
        boolean bool = paramIntent.getBooleanExtra(z[16], false);
        localObject2 = paramIntent.getExtras();
        if (bool)
        {
          d.c(z[17], z[31]);
          ((Bundle)localObject2).putString(z[28], cn.jiguang.c.b.a.b.name());
        }
        for (;;)
        {
          i.a().b(paramContext, z[8], (Bundle)localObject2);
          break;
          if (NetworkInfo.State.CONNECTED == ((NetworkInfo)localObject1).getState())
          {
            d.c(z[17], z[26]);
            ((Bundle)localObject2).putString(z[28], cn.jiguang.c.b.a.a.name());
          }
          else if (NetworkInfo.State.DISCONNECTED == ((NetworkInfo)localObject1).getState())
          {
            d.c(z[17], z[10]);
            ((Bundle)localObject2).putString(z[28], cn.jiguang.c.b.a.b.name());
          }
          else
          {
            d.c(z[17], z[13] + ((NetworkInfo)localObject1).getState() + z[4]);
          }
        }
      }
      ((String)localObject2).equals(z[19]);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/service/PushReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */