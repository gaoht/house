package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.data.h;
import cn.jpush.android.service.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import java.io.File;

@Instrumented
public class PopWinActivity
  extends Activity
{
  public static cn.jpush.android.d.a.f a;
  private static final String[] z;
  private String b;
  private WebView c;
  private cn.jpush.android.data.c d = null;
  
  static
  {
    String[] arrayOfString = new String[18];
    int j = 0;
    Object localObject2 = "tVo!";
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
        i = 90;
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
        localObject2 = "pKd5\005aXr";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "SA*;6]j,;6Pxx4yM++?dPj43lXi4?7";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "aO[7*aPe";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "|I~+2IId(-WT4;oV~,";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "FLx0\033uMb.3b@+??b\031E\r\026Z\031b6.sWy";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\\i~+2A\\i";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "]";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "FUn9)s\031j<>6Uj!5cM+*?eV~*9s\031a(/eQT(5fNb6\005zXr7/b\027s566Mdx(sJ$4;oV~,z7";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "AXy63x^＇6/zU+5?eJj??6\\e,3b@*x\031zVx=zFLx0\033uMb.3b@*";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "zXr7/b";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "UXex4yM+??b\031|=8@Pn/zW+4;oV~,zpPg={";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "pPg=`9\026";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "e\\j*9~{d \020wOj\032(]l=\005";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "FLx0\033uMb.3b@";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "FUn9)s\031~+?6]n>;cUx9y]nx3x\031a(/eQT(5fNb6\005zXr7/b\027s567";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "JE7._b;;bPd6";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "eQd/\017dU+ez";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = null;
        return;
        i = 22;
        continue;
        i = 57;
        continue;
        i = 11;
        continue;
        i = 88;
      }
    }
  }
  
  public final void a(String paramString)
  {
    if ((this.d != null) && (this.c != null) && ((this.d instanceof h)))
    {
      if (!TextUtils.isEmpty(paramString))
      {
        ((h)this.d).a = paramString;
        paramString = new Intent(this, PushActivity.class);
        paramString.putExtra(z[0], this.d);
        paramString.putExtra(z[1], true);
        paramString.setFlags(335544320);
        startActivity(paramString);
      }
      finish();
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    cn.jpush.android.a.b.a(this.b, 1006, this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() != null)
    {
      for (;;)
      {
        Object localObject;
        try
        {
          if (getIntent().getBooleanExtra(z[16], false))
          {
            d.a();
            d.a(getApplicationContext(), getIntent());
            finish();
            return;
          }
          this.d = ((cn.jpush.android.data.c)getIntent().getSerializableExtra(z[0]));
          if (this.d == null) {
            break;
          }
          this.b = this.d.c;
          i = getResources().getIdentifier(z[4], z[10], getPackageName());
          if (i == 0)
          {
            cn.jpush.android.c.f.j(z[14], z[8]);
            finish();
            localObject = (h)this.d;
            paramBundle = ((h)localObject).O;
            localObject = ((h)localObject).a;
            cn.jpush.android.c.f.c(z[14], z[17] + (String)localObject);
            if ((TextUtils.isEmpty(paramBundle)) || (!new File(paramBundle.replace(z[12], "")).exists())) {
              break label522;
            }
            localObject = this.c;
            if ((localObject instanceof WebView)) {
              break label511;
            }
            ((WebView)localObject).loadUrl(paramBundle);
            cn.jpush.android.a.b.a(this.b, 1000, this);
            return;
          }
        }
        catch (Exception paramBundle)
        {
          cn.jpush.android.c.f.j(z[14], z[2]);
          paramBundle.printStackTrace();
          finish();
          return;
        }
        setContentView(i);
        int i = getResources().getIdentifier(z[3], z[7], getPackageName());
        if (i == 0)
        {
          cn.jpush.android.c.f.j(z[14], z[15]);
          finish();
        }
        else
        {
          this.c = ((WebView)findViewById(i));
          if (this.c == null)
          {
            cn.jpush.android.c.f.j(z[14], z[11]);
            finish();
          }
          else
          {
            this.c.setScrollbarFadingEnabled(true);
            this.c.setScrollBarStyle(33554432);
            paramBundle = this.c.getSettings();
            paramBundle.setDomStorageEnabled(true);
            cn.jpush.android.c.a.a(paramBundle);
            this.c.setBackgroundColor(0);
            a = new cn.jpush.android.d.a.f(this, this.d);
            if (Build.VERSION.SDK_INT >= 11) {
              this.c.removeJavascriptInterface(z[13]);
            }
            paramBundle = this.c;
            localObject = new cn.jpush.android.d.a.a(z[6], cn.jpush.android.d.a.b.class, null, null);
            if (!(paramBundle instanceof WebView)) {
              paramBundle.setWebChromeClient((WebChromeClient)localObject);
            }
            for (;;)
            {
              this.c.setWebViewClient(new c(this.d));
              cn.jpush.android.d.a.b.setWebViewHelper(a);
              break;
              VdsAgent.setWebChromeClient((WebView)paramBundle, (WebChromeClient)localObject);
            }
            label511:
            WebviewInstrumentation.loadUrl((WebView)localObject, paramBundle);
            continue;
            label522:
            paramBundle = this.c;
            if (!(paramBundle instanceof WebView)) {
              paramBundle.loadUrl((String)localObject);
            } else {
              WebviewInstrumentation.loadUrl((WebView)paramBundle, (String)localObject);
            }
          }
        }
      }
      cn.jpush.android.c.f.h(z[14], z[9]);
      finish();
      return;
    }
    cn.jpush.android.c.f.h(z[14], z[5]);
    finish();
  }
  
  protected void onDestroy()
  {
    if (this.c != null)
    {
      this.c.removeAllViews();
      this.c.destroy();
      this.c = null;
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    if ((this.c != null) && (Build.VERSION.SDK_INT >= 11)) {
      this.c.onPause();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.c != null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        this.c.onResume();
      }
      cn.jpush.android.d.a.b.setWebViewHelper(a);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/ui/PopWinActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */