package cn.jpush.android.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.os.Build.VERSION;
import cn.jpush.android.d;

public class BasicPushNotificationBuilder
  extends DefaultPushNotificationBuilder
{
  private static final String[] z;
  protected Context a;
  public String developerArg0 = z[2];
  public int notificationDefaults = -1;
  public int notificationFlags = 16;
  public int statusBarDrawable = d.b;
  
  static
  {
    String[] arrayOfString = new String[6];
    int j = 0;
    Object localObject2 = "\034N\030Q6";
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
        i = 105;
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
        localObject2 = "\rD\013BI ~)z\f;e";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "'t1k\005,a\"|(1vw";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "!p4g\n\034N\030Q6";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = " d4z\006.";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "!p4g\n";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 67;
        continue;
        i = 17;
        continue;
        i = 71;
        continue;
        i = 14;
      }
    }
  }
  
  public BasicPushNotificationBuilder(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException(z[1]);
    }
    this.a = paramContext;
  }
  
  static PushNotificationBuilder a(String paramString)
  {
    String[] arrayOfString = paramString.split(z[0]);
    paramString = arrayOfString[0];
    if (z[5].equals(paramString)) {
      paramString = new BasicPushNotificationBuilder(d.e);
    }
    for (;;)
    {
      paramString.a(arrayOfString);
      return paramString;
      if (z[4].equals(paramString)) {
        paramString = new CustomPushNotificationBuilder(d.e);
      } else {
        paramString = new BasicPushNotificationBuilder(d.e);
      }
    }
  }
  
  String a()
  {
    return this.notificationDefaults + z[0] + this.notificationFlags + z[0] + this.statusBarDrawable + z[0] + this.developerArg0;
  }
  
  void a(String[] paramArrayOfString)
  {
    this.notificationDefaults = Integer.parseInt(paramArrayOfString[1]);
    this.notificationFlags = Integer.parseInt(paramArrayOfString[2]);
    this.statusBarDrawable = Integer.parseInt(paramArrayOfString[3]);
    if (5 == paramArrayOfString.length) {
      this.developerArg0 = paramArrayOfString[4];
    }
  }
  
  public String getDeveloperArg0()
  {
    return this.developerArg0;
  }
  
  @TargetApi(11)
  Notification getNotification(Notification.Builder paramBuilder)
  {
    paramBuilder.setDefaults(this.notificationDefaults);
    paramBuilder.setSmallIcon(this.statusBarDrawable);
    if (Build.VERSION.SDK_INT >= 16) {}
    for (paramBuilder = paramBuilder.build();; paramBuilder = paramBuilder.getNotification())
    {
      paramBuilder.flags = this.notificationFlags;
      return paramBuilder;
    }
  }
  
  void resetNotificationParams(Notification paramNotification)
  {
    paramNotification.defaults = this.notificationDefaults;
    paramNotification.flags = this.notificationFlags;
    paramNotification.icon = this.statusBarDrawable;
  }
  
  public String toString()
  {
    return z[3] + a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/api/BasicPushNotificationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */