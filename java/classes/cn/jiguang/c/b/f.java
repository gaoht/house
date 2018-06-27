package cn.jiguang.c.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.jiguang.a.c.c;
import cn.jiguang.c.d.b;
import java.util.concurrent.atomic.AtomicBoolean;

final class f
  extends Handler
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[15];
    int j = 0;
    Object localObject2 = "$)7\0220\024$&\017$Q*!\rn\036%8J)\002g<\0054Q\024&\030)\037 rJ2\0246'\0173\005g%\002%\037g!\017.\005g&\003-\024('\036n";
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
        i = 64;
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
        localObject2 = "\002#9\0369\001\"";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "$)7\0220\024$&\017$Kg0\037.\025+7J)\002g<\037,\035g%\002%\037g \0171\004\"!\036`\005.?\017/\0043|";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "$)7\0220\024$&\017$Qjr\0073\026g \0173\001(<\031%Q%'\004$\035\"r\0033Q)'\006,_";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\031&<\016,\024\n7\0313\020 7P";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = ";.5\037!\037 \006\t0<&<\013'\0245";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "$)7\0220\024$&\017$Qjr\035!\0373r\036/Q47\004$Q)'\006,Q57\0335\0244&D";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\022(<\004%\0223;\005.";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "\"\" \034)\022\"r\001)\035+7\016`\023>r\0034\002\">\f`\02527J4\036g!\017,\027g9\003,\035\"6J-\036#7";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "0$&\003/\037gJ(\020)6\006%2( \017\r\0244!\013'\024g~J5\037/3\004$\035\"r\0073\026j";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "\003\"#\037%\0023\r\031$\0323+\032%";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "$)7\0220\024$&\017$Q*!\rn\036%8J)\002g<\0054Q\0257\0335\0244&\003.\026g%\002%\037g!\017.\005g&\003-\024('\036n";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "\003\"#\037%\0023\r\016!\005&";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "\003\"#\037%\0023\r\036)\034\"=\0374";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "$)7\0220\024$&\017$Kg?\031'Q(0\000`\0304r\0045\035+r\035(\024)r\031%\0373r\036)\034\"=\0374_";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 113;
        continue;
        i = 71;
        continue;
        i = 82;
        continue;
        i = 106;
      }
    }
  }
  
  public f(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    cn.jiguang.d.d.a(z[5], z[4] + paramMessage.toString());
    Object localObject = "";
    try
    {
      Bundle localBundle = paramMessage.getData();
      if (localBundle != null) {
        localObject = localBundle.getString(z[1]);
      }
      if ((cn.jiguang.f.h.a((String)localObject)) || (((String)localObject).equals(cn.jiguang.c.a.a))) {
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        cn.jiguang.d.d.g(z[5], z[9] + paramMessage.what);
        return;
        cn.jiguang.d.d.c(z[5], z[8]);
        cn.jiguang.f.a.h(e.a(this.a).getApplicationContext());
        b.a(e.a(this.a), a.b);
        return;
        this.a.g();
        return;
        c.a(e.a(this.a));
        return;
        this.a.e();
        return;
        e.a(this.a, e.b(this.a));
        return;
        e.a(this.a, true);
        return;
        e.a(this.a, false);
        return;
        removeMessages(1011);
        removeMessages(1010);
        sendEmptyMessageDelayed(1011, 3000L);
        return;
        sendEmptyMessageDelayed(1010, 200L);
        return;
        e.a(this.a, paramMessage.getData().getLong(z[7]));
        return;
        e.b(this.a, paramMessage.getData().getLong(z[7]));
        return;
        e.c(this.a, paramMessage.getData().getLong(z[7]));
        return;
        e.a(this.a, paramMessage.getData().getLong(z[7]), paramMessage.arg2);
        return;
        g.b.set(false);
        return;
        e.c(this.a);
        return;
        cn.jiguang.f.a.h(e.a(this.a).getApplicationContext());
        return;
        if (paramMessage.obj != null)
        {
          if ((paramMessage.obj instanceof i))
          {
            h.a().a((i)paramMessage.obj);
            return;
          }
          cn.jiguang.d.d.g(z[5], z[0]);
          return;
        }
        cn.jiguang.d.d.g(z[5], z[14]);
        return;
        if (paramMessage.obj != null)
        {
          if ((paramMessage.obj instanceof i))
          {
            h.a().b((i)paramMessage.obj);
            return;
          }
          cn.jiguang.d.d.g(z[5], z[11]);
          return;
        }
        cn.jiguang.d.d.g(z[5], z[2]);
        return;
        localObject = paramMessage.getData();
        if (localObject == null)
        {
          cn.jiguang.d.d.h(z[5], z[6]);
          return;
        }
        int i = ((Bundle)localObject).getInt(z[13]);
        paramMessage = ((Bundle)localObject).getByteArray(z[12]);
        localObject = ((Bundle)localObject).getString(z[10]);
        h.a().b(paramMessage, (String)localObject, i);
        return;
        localObject = paramMessage.getData();
        if (localObject == null)
        {
          cn.jiguang.d.d.h(z[5], z[3]);
          return;
        }
        localObject = ((Bundle)localObject).getString(z[10]);
        h.a().a(paramMessage.getData().getLong(z[7]), (String)localObject, paramMessage.obj);
        return;
        cn.jiguang.c.d.d.a().a(e.a(this.a));
        return;
        cn.jiguang.c.d.a.a();
        cn.jiguang.c.d.a.a(e.a(this.a), (String)localObject, localBundle);
        return;
      }
      return;
    }
    catch (Exception paramMessage) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */