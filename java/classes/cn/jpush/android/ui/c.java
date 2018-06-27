package cn.jpush.android.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jpush.android.a.b;
import cn.jpush.android.c.f;
import cn.jpush.android.d;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;

@Instrumented
public final class c
  extends WebViewClient
{
  private static final String[] z;
  private final cn.jpush.android.data.c a;
  
  static
  {
    String[] arrayOfString = new String[25];
    int j = 0;
    Object localObject2 = "ZoyAQ\031bb\022";
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
        i = 37;
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
        localObject2 = "\035yrFJS&";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\035br]J\025h8FK\bix[\013\035obFJ\022\"@f`+";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "5b`NI\025h6ZW\020";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\f`wFKSxsWQ";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "-ys]\\/xdFK\03366";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = ")~\025\005";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\007.c]I^64\nV^q";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "\bebC@A";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "\035br]J\025h8FK\bix[\013\031tb]DRXSwq";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "Raf\033";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "\035br]J\025h8FK\bix[\013\035obFJ\022\"Ejk8";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "Raf\034";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "Zh]@\037x+ID\020s";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "\nerJJS&";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "\024xb_";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "\035br]J\025h8FK\bix[\013\031tb]DRI[nl0";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "6\\c\\M+ityL\031{UCL\031bb";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "\021mCQ\023";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "\030edJF\b1";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "\035br]J\025h8FK\bix[\013\031tb]DR_Cmo9OB";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = ")~z\017S\035yzJ\005\0256\025";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "R?q_";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "Ch]@\037x+ID\020s";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "RmfD";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 124;
        continue;
        i = 12;
        continue;
        i = 22;
        continue;
        i = 47;
      }
    }
  }
  
  public c(cn.jpush.android.data.c paramc)
  {
    this.a = paramc;
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    super.onLoadResource(paramWebView, paramString);
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Object localObject1 = paramWebView.getContext();
    f.e(z[17], z[21] + paramString);
    String str1;
    try
    {
      str1 = String.format(z[7], new Object[] { paramString });
      if (this.a.D)
      {
        ((Context)localObject1).startActivity(new Intent(z[2], Uri.parse(paramString)));
        b.a(this.a.c, 1016, str1, d.e);
        return true;
      }
      if (paramString.endsWith(z[12]))
      {
        localObject1 = new Intent(z[2]);
        ((Intent)localObject1).setDataAndType(Uri.parse(paramString), z[1]);
        paramWebView.getContext().startActivity((Intent)localObject1);
        return true;
      }
    }
    catch (Exception paramWebView)
    {
      f.i(z[17], z[3]);
      return true;
    }
    if ((paramString.endsWith(z[10])) || (paramString.endsWith(z[22])))
    {
      localObject1 = new Intent(z[2]);
      ((Intent)localObject1).setDataAndType(Uri.parse(paramString), z[14]);
      paramWebView.getContext().startActivity((Intent)localObject1);
      return true;
    }
    if (paramString.endsWith(z[24]))
    {
      paramString = new Intent(z[2], Uri.parse(paramString));
      paramWebView.getContext().startActivity(paramString);
      return true;
    }
    if (paramString.startsWith(z[15]))
    {
      if (!(paramWebView instanceof WebView)) {
        paramWebView.loadUrl(paramString);
      }
      for (;;)
      {
        b.a(this.a.c, 1016, str1, d.e);
        break;
        WebviewInstrumentation.loadUrl((WebView)paramWebView, paramString);
      }
    }
    if ((paramString != null) && (paramString.startsWith(z[18])))
    {
      paramWebView = paramString;
      if (paramString.lastIndexOf(z[19]) < 0)
      {
        paramWebView = paramString;
        if (!paramString.startsWith(z[18])) {
          if (paramString.indexOf("?") <= 0) {
            break label707;
          }
        }
      }
      label707:
      for (paramWebView = paramString + z[13];; paramWebView = paramString + z[23])
      {
        paramWebView.lastIndexOf(z[19]);
        int i = paramWebView.indexOf("?");
        Object localObject2 = paramWebView.substring(0, i);
        String str2 = paramWebView.substring(i);
        f.a(z[17], z[6] + (String)localObject2);
        f.a(z[17], z[5] + str2);
        paramString = null;
        paramWebView = paramString;
        if (((String)localObject2).startsWith(z[18]))
        {
          localObject2 = ((String)localObject2).split(":");
          paramWebView = paramString;
          if (localObject2 != null)
          {
            paramWebView = paramString;
            if (localObject2.length == 2)
            {
              i = str2.indexOf(z[8]);
              int j = str2.indexOf(z[0]);
              paramString = str2.substring(i + 6, j);
              str2 = str2.substring(j + 9);
              localObject2 = localObject2[1];
              paramWebView = new Intent(z[11]);
              paramWebView.setType(z[4]);
              paramWebView.putExtra(z[16], new String[] { localObject2 });
              paramWebView.putExtra(z[20], paramString);
              paramWebView.putExtra(z[9], str2);
            }
          }
        }
        if (paramWebView != null) {
          ((Context)localObject1).startActivity(paramWebView);
        }
        b.a(this.a.c, 1016, str1, d.e);
        return true;
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */