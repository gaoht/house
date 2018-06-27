package cn.jpush.android.d.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.a.b;
import cn.jpush.android.c.a;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.growingio.android.sdk.agent.VdsAgent;
import java.lang.ref.WeakReference;

public final class f
{
  private static final String[] z;
  private final WeakReference<Activity> a;
  private final cn.jpush.android.data.c b;
  
  static
  {
    String[] arrayOfString = new String[20];
    int j = 0;
    Object localObject2 = "9=\007QZ/ A\025K47[TC>}@U^?=]\025k\031\007`td\005\001`xb\n\006zsu\031\022ewh\033\020b";
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
        i = 42;
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
        localObject2 = "\r6KmC?$a^F*6[";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "vsZSE/?MxF5 L\001";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "vsZSE/?MxK40LWd5'@]C92]RE4i";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\r6K\033I;?EYK98\023XF30B\033\007z2JOC5=`_\020";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\r6K\033I;?EYK98\023XF5 L";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\r6K\033I;?EYK98\023HB5$}TK)'\t\026\n";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\r6K\033I;?EYK98\023_E-=ETK>s\004\033";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "\r6K\033I;?EYK98\023^R?0\\OO\027 NvO) H\\Oz~\t";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "\017=AZD>?L\033C4'LU^zi\t";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "9=\007QZ/ A\025K47[TC>}lc~\b\022";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "\023=_ZF37\tZI.:FUc>sOIE7s~^Hz~\t";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "30FUc>sZSE/?M\033H?s@U^z~\t";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "\r6K\033I;?EYK98\023XX?2]^y2<[OI/'\t\026\n42D^\020";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "vs\\IF`";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "\017=AZD>?L\033C4'LU^zi\tXDt9YNY2}HUN(<@_\0043=]^D.}hx~\023\034gdk\031\007`mc\016\nvtz\037\035m~n";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "\016;L\033K9'@MC.*\tUK76\tRYz:GMK6:M\027\n\035:_^\n/#\007\025";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "\016;L\033K9'@MC.*\tUK76\tRYz=\\WFz<[\033O7#]B\006z\024@MOz&Y\025\004";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = ";0]R\\3'PuK76\t\006\n";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "9=\007QZ/ A\025K47[TC>}hx~\023\005`os\005\003hik\027";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 90;
        continue;
        i = 83;
        continue;
        i = 41;
        continue;
        i = 59;
      }
    }
  }
  
  public f(Context paramContext, cn.jpush.android.data.c paramc)
  {
    this.a = new WeakReference((Activity)paramContext);
    this.b = paramc;
  }
  
  private void g(String paramString)
  {
    try
    {
      i = Integer.parseInt(paramString);
      b.a(this.b.c, i, (Context)this.a.get());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        cn.jpush.android.c.f.i(z[1], z[11] + paramString);
        int i = 1100;
      }
    }
  }
  
  public final void a()
  {
    if (this.a.get() != null)
    {
      cn.jpush.android.c.f.c(z[1], z[5]);
      ((Activity)this.a.get()).finish();
    }
  }
  
  public final void a(String paramString)
  {
    Context localContext = (Context)this.a.get();
    if (localContext == null) {
      return;
    }
    a.a(localContext, z[0], paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    cn.jpush.android.c.f.c(z[1], z[18] + paramString1);
    if (TextUtils.isEmpty(paramString1)) {
      cn.jpush.android.c.f.j(z[1], z[17]);
    }
    Context localContext = (Context)this.a.get();
    if (localContext == null) {}
    for (;;)
    {
      return;
      try
      {
        paramString1 = Class.forName(paramString1);
        if (paramString1 != null)
        {
          paramString1 = new Intent(localContext, paramString1);
          paramString1.putExtra(z[19], paramString2);
          paramString1.setFlags(268435456);
          localContext.startActivity(paramString1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        cn.jpush.android.c.f.j(z[1], z[16]);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      i = Integer.parseInt(paramString3);
      if (this.a.get() == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        cn.jpush.android.c.f.c(z[1], z[12] + paramString3);
        i = 0;
      }
      cn.jpush.android.c.f.c(z[1], z[13] + paramString1 + z[14] + paramString2);
      a.a((Context)this.a.get(), paramString1, paramString2, cn.jpush.android.api.c.a(i));
    }
  }
  
  public final void b()
  {
    if ((this.a.get() != null) && ((this.a.get() instanceof PushActivity))) {
      ((PushActivity)this.a.get()).a();
    }
  }
  
  public final void b(String paramString)
  {
    Context localContext = (Context)this.a.get();
    if (localContext == null) {
      return;
    }
    try
    {
      a.d(localContext, paramString);
      ((Activity)localContext).finish();
      return;
    }
    catch (Exception paramString)
    {
      cn.jpush.android.c.f.j(z[1], z[15]);
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    Context localContext = (Context)this.a.get();
    if (localContext == null) {
      return;
    }
    try
    {
      Intent localIntent = new Intent(paramString1);
      localIntent.addCategory(localContext.getPackageName());
      localIntent.putExtra(z[10], paramString2);
      localIntent.setFlags(268435456);
      localContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramString2)
    {
      cn.jpush.android.c.f.j(z[1], z[9] + paramString1);
    }
  }
  
  /* Error */
  public final void b(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 82	cn/jpush/android/d/a/f:a	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 104	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: ifnull +112 -> 119
    //   10: getstatic 69	cn/jpush/android/d/a/f:z	[Ljava/lang/String;
    //   13: iconst_1
    //   14: aaload
    //   15: new 113	java/lang/StringBuilder
    //   18: dup
    //   19: getstatic 69	cn/jpush/android/d/a/f:z	[Ljava/lang/String;
    //   22: iconst_4
    //   23: aaload
    //   24: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: aload_1
    //   28: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: getstatic 69	cn/jpush/android/d/a/f:z	[Ljava/lang/String;
    //   34: iconst_2
    //   35: aaload
    //   36: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_2
    //   40: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: getstatic 69	cn/jpush/android/d/a/f:z	[Ljava/lang/String;
    //   46: iconst_3
    //   47: aaload
    //   48: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_3
    //   52: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 130	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: aload_1
    //   63: invokespecial 198	cn/jpush/android/d/a/f:g	(Ljava/lang/String;)V
    //   66: aload_2
    //   67: invokestatic 204	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   70: istore 4
    //   72: aload_3
    //   73: invokestatic 204	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   76: istore 5
    //   78: iload 5
    //   80: ifeq +21 -> 101
    //   83: aload_0
    //   84: getfield 82	cn/jpush/android/d/a/f:a	Ljava/lang/ref/WeakReference;
    //   87: invokevirtual 104	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   90: checkcast 106	android/content/Context
    //   93: aload_0
    //   94: getfield 84	cn/jpush/android/d/a/f:b	Lcn/jpush/android/data/c;
    //   97: iconst_0
    //   98: invokestatic 207	cn/jpush/android/api/c:a	(Landroid/content/Context;Lcn/jpush/android/data/c;I)V
    //   101: iload 4
    //   103: ifeq +16 -> 119
    //   106: aload_0
    //   107: getfield 82	cn/jpush/android/d/a/f:a	Ljava/lang/ref/WeakReference;
    //   110: invokevirtual 104	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   113: checkcast 77	android/app/Activity
    //   116: invokevirtual 133	android/app/Activity:finish	()V
    //   119: return
    //   120: astore_1
    //   121: iconst_0
    //   122: istore 4
    //   124: iconst_0
    //   125: istore 5
    //   127: goto -49 -> 78
    //   130: astore_1
    //   131: goto -7 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	f
    //   0	134	1	paramString1	String
    //   0	134	2	paramString2	String
    //   0	134	3	paramString3	String
    //   70	53	4	bool1	boolean
    //   76	50	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   66	72	120	java/lang/Exception
    //   72	78	130	java/lang/Exception
  }
  
  public final void c(String paramString)
  {
    if (this.a.get() == null) {
      return;
    }
    cn.jpush.android.c.f.c(z[1], z[7] + paramString);
  }
  
  public final void c(String paramString1, String paramString2)
  {
    if (this.a.get() == null) {
      return;
    }
    g(paramString1);
    c(paramString2);
    cn.jpush.android.api.c.a((Context)this.a.get(), this.b, 0);
    ((Activity)this.a.get()).finish();
  }
  
  public final void d(String paramString)
  {
    if (this.a.get() != null)
    {
      cn.jpush.android.c.f.c(z[1], z[6] + paramString);
      paramString = Toast.makeText((Context)this.a.get(), paramString, 0);
      if (!(paramString instanceof Toast)) {
        paramString.show();
      }
    }
    else
    {
      return;
    }
    VdsAgent.showToast((Toast)paramString);
  }
  
  public final void e(String paramString)
  {
    if (JCoreInterface.getDebugMode())
    {
      cn.jpush.android.c.f.c(z[1], z[8] + paramString);
      if (this.a.get() != null) {}
    }
    else
    {
      return;
    }
    cn.jpush.android.a.f.a((Context)this.a.get(), paramString);
  }
  
  public final void f(String paramString)
  {
    if ((this.a.get() != null) && ((this.a.get() instanceof PopWinActivity))) {
      ((PopWinActivity)this.a.get()).a(paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/d/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */