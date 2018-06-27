package cn.jpush.android.d.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.c.f;

public final class e
{
  private static final String[] z;
  private Context a;
  private WindowManager b;
  private WebView c;
  private ImageButton d;
  
  static
  {
    String[] arrayOfString = new String[7];
    int j = 0;
    Object localObject2 = "\004O7\033e\022Rq_t\tEk\036|\003\017X2A.wP%L8qX#T*";
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
        i = 21;
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
        localObject2 = "4Xj\005p\n`u\024g\023v|\023C\016Dn2t\013M{\020v\f";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "J\f4\\8GQx\003t\nR9K5";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "3I|Qt\004Up\007|\023X9\037t\nD9\030fGOl\035yGNkQp\nQm\b9Gfp\007pGTi_;";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\006Bm\030z\t\0014\\8GBu\036f\002";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\006Bm\030z\t\0014\\8GRm\020g\023`z\005|\021Hm\bW\036ox\034pJ\f4\\8J\f4\020v\023Ho\030a\036ox\034pG\0339";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "3I|Qt\004Up\007|\023X9\037t\nD9\030fGHw\007t\013H}]5 Ho\0245\022Q7_";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 103;
        continue;
        i = 33;
        continue;
        i = 25;
        continue;
        i = 113;
      }
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    f.c(z[1], z[5] + paramString1 + z[2] + paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      f.j(z[1], z[3]);
    }
    if (this.a == null) {}
    for (;;)
    {
      return;
      try
      {
        paramString1 = Class.forName(paramString1);
        if (paramString1 != null)
        {
          paramString1 = new Intent(this.a, paramString1);
          paramString1.putExtra(z[0], paramString2);
          paramString1.setFlags(268435456);
          this.a.startActivity(paramString1);
          f.c(z[1], z[4]);
          cn.jpush.android.api.e.a(this.b, this.c, this.d);
          return;
        }
      }
      catch (Exception paramString1)
      {
        f.j(z[1], z[6]);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/d/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */