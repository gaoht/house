package cn.jpush.android.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import cn.jpush.android.a.b;
import cn.jpush.android.c.f;
import com.growingio.android.sdk.agent.VdsAgent;
import java.util.List;

@com.maa.android.agent.instrumentation.Instrumented
public class PushActivity
  extends Activity
{
  private static final String[] z;
  private int a = 0;
  private boolean b = false;
  private String c;
  private FullScreenView d = null;
  private Handler e = new d(this);
  
  static
  {
    String[] arrayOfString = new String[22];
    int j = 0;
    Object localObject2 = "U3\rB\036D \033";
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
        i = 65;
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
        localObject2 = "c4\021G\000P5\013Y(G8BH$Ga,z\ra\013A5V/\026\016";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "d \020A(]&ｮA4_-BB$@2\003H$\023$\f[(G8C\017\002_.\021Jac4\021G\000P5\013Y(G8C";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "v9\026] \023%\003[ \023(\021\017/\\5B\\$A(\003C(I \000C$\022";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "Q.\006V";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "c4\021G\000P5\013Y(G8";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "g)\007\0171R\"\tN&Va\025F5[a\026G$\023&\013Y$]a\fN,Va\001N/].\026\017#Va\004@4]%C";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "p \f\b5\023&\007[a_ \027A\"[a\013A5V/\026\017'\\3B[)Z2B_ P*\003H$\022";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "}4\016Ca^$\021\\ T$BJ/G(\026V`\023\002\016@2Va2Z2[\000\001[(E(\026V`";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "c-\007N2Va\003K%\023-\003V.F5B]$@.\027]\"Va\b_4@)=X$Q7\013J6l-\003V.F5LW,_a\026@aA$\021\000-R8\rZ5\023`";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "_ \033@4G";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "U(\016J{\034n";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "r\"\026F.]{B_3\\\"\007\\2`)\rX";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "c-\007N2Va\027\\$\023%\007I F-\026\017\"\\%\007\017(]a\b_4@)=X$Q7\013J6l-\003V.F5LW,_`";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "Z%";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "R\"\026F.]#\003]\rR8\rZ5z%";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "Y1\027\\)l6\007M7Z$\025p-R8\rZ5";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "z/\024N-Z%BB2Ta\026V1Va\026@a@)\rXa\036a";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "t$\026\0173F/\fF/Ta\026N2X2BI Z-\007Ko";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "G.\022n\"G(\024F5JaB\022a";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "Q \021J\000P5\013Y(G8B\017|\023";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "R\"\026F7Z5\033";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 51;
        continue;
        i = 65;
        continue;
        i = 98;
        continue;
        i = 47;
      }
    }
  }
  
  private void a(cn.jpush.android.data.c paramc)
  {
    if (paramc != null)
    {
      switch (paramc.o)
      {
      default: 
        f.g(z[5], z[17] + paramc.o);
        cn.jpush.android.api.c.a(this, paramc, 0);
        finish();
        return;
      }
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.obj = paramc;
      this.e.sendMessageDelayed(localMessage, 500L);
      return;
    }
    f.h(z[5], z[8]);
    finish();
  }
  
  private void c()
  {
    Object localObject = getPackageManager();
    String str = getApplicationContext().getPackageName();
    if (!str.isEmpty())
    {
      localObject = ((PackageManager)localObject).getLaunchIntentForPackage(str);
      if (localObject == null) {
        f.h(z[5], z[7]);
      }
    }
    else
    {
      f.h(z[5], z[6]);
      return;
    }
    ((Intent)localObject).addFlags(268468224);
    startActivity((Intent)localObject);
  }
  
  public final void a()
  {
    if (this.d != null) {
      this.d.showTitleBar();
    }
  }
  
  public final void b()
  {
    finish();
    if (1 == this.a) {}
    try
    {
      Object localObject = (ActivityManager)getSystemService(z[21]);
      ComponentName localComponentName = ((ActivityManager.RunningTaskInfo)((ActivityManager)localObject).getRunningTasks(1).get(0)).baseActivity;
      localObject = ((ActivityManager.RunningTaskInfo)((ActivityManager)localObject).getRunningTasks(1).get(0)).topActivity;
      f.c(z[5], z[20] + localComponentName.toString());
      f.c(z[5], z[19] + ((ComponentName)localObject).toString());
      if ((localComponentName != null) && (localObject != null) && (((ComponentName)localObject).toString().equals(localComponentName.toString()))) {
        c();
      }
      return;
    }
    catch (Exception localException)
    {
      f.h(z[5], z[18]);
      c();
    }
  }
  
  public void onBackPressed()
  {
    if ((this.d != null) && (this.d.webviewCanGoBack()))
    {
      this.d.webviewGoBack();
      return;
    }
    b.a(this.c, 1006, this);
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() != null) {
      try
      {
        this.b = getIntent().getBooleanExtra(z[0], false);
        paramBundle = (cn.jpush.android.data.c)getIntent().getSerializableExtra(z[4]);
        if (paramBundle != null)
        {
          this.c = paramBundle.c;
          a(paramBundle);
          return;
        }
        f.h(z[5], z[2]);
        finish();
        return;
      }
      catch (Exception paramBundle)
      {
        f.j(z[5], z[3]);
        paramBundle.printStackTrace();
        finish();
        return;
      }
    }
    f.h(z[5], z[1]);
    finish();
  }
  
  protected void onDestroy()
  {
    if (this.d != null) {
      this.d.destory();
    }
    if (this.e.hasMessages(2)) {
      this.e.removeMessages(2);
    }
    super.onDestroy();
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      setIntent(paramIntent);
      try
      {
        this.b = paramIntent.getBooleanExtra(z[0], false);
        paramIntent = (cn.jpush.android.data.c)paramIntent.getSerializableExtra(z[4]);
        if (paramIntent != null)
        {
          this.c = paramIntent.c;
          a(paramIntent);
          return;
        }
        f.h(z[5], z[2]);
        finish();
        return;
      }
      catch (Exception paramIntent)
      {
        f.j(z[5], z[3]);
        paramIntent.printStackTrace();
        finish();
        return;
      }
    }
    f.h(z[5], z[1]);
    finish();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.d != null) {
      this.d.pause();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.d != null) {
      this.d.resume();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/ui/PushActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */