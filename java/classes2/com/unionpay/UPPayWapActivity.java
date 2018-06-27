package com.unionpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.unionpay.utils.e;
import com.unionpay.utils.h;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class UPPayWapActivity
  extends Activity
{
  LinearLayout a;
  private WebView b;
  private WebViewJavascriptBridge c;
  private AlertDialog d;
  
  private static String b(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject("{\"code\":\"0\",\"msg\":\"success\"}");
      if (paramString1 != null) {
        localJSONObject.put("code", paramString1);
      }
      if (paramString2 != null) {
        localJSONObject.put("msg", paramString2);
      }
      if (paramString3 != null) {
        localJSONObject.put("value", paramString3);
      }
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject1 = getIntent().getStringExtra("waptype");
    paramBundle = "";
    Object localObject2;
    if ((localObject1 != null) && (((String)localObject1).equals("new_page")))
    {
      localObject2 = getIntent().getStringExtra("wapurl");
      localObject1 = getIntent().getStringExtra("waptitle");
      if (localObject2 != null) {
        paramBundle = (Bundle)localObject2;
      }
      if (localObject1 == null) {
        break label779;
      }
    }
    for (;;)
    {
      localObject2 = new i(this);
      getWindow().requestFeature(1);
      LinearLayout localLinearLayout = new LinearLayout(this);
      localLinearLayout.setOrientation(1);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
      RelativeLayout localRelativeLayout = new RelativeLayout(this);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      int j = e.a(this, 10.0F);
      int i = e.a(this, 52.0F);
      localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, i));
      localRelativeLayout.setBackgroundColor(-10705958);
      this.a = new LinearLayout(this);
      this.a.setPadding(j, j, j, j);
      this.a.setGravity(16);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
      this.a.setOnClickListener((View.OnClickListener)localObject2);
      localRelativeLayout.addView(this.a, (ViewGroup.LayoutParams)localObject3);
      j = e.a(this, 20.0F);
      int k = e.a(this, 11.0F);
      localObject2 = new ImageView(this);
      ((ImageView)localObject2).setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeStream(getClass().getResourceAsStream("res/nav_back.png"))));
      localObject3 = new RelativeLayout.LayoutParams(k, j);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
      this.a.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RelativeLayout.LayoutParams(e.a(this, 320.0F), i);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
      localObject3 = new TextView(this);
      ((TextView)localObject3).setTextSize(20.0F);
      ((TextView)localObject3).setTextColor(-1);
      ((TextView)localObject3).setText((CharSequence)localObject1);
      ((TextView)localObject3).setGravity(17);
      ((TextView)localObject3).setSingleLine(true);
      ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
      localRelativeLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
      localLinearLayout.addView(localRelativeLayout);
      this.b = new WebView(this);
      this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localLinearLayout.addView(this.b);
      setContentView(localLinearLayout);
      this.c = new WebViewJavascriptBridge(this, this.b, null);
      localObject1 = this.b;
      if (!(localObject1 instanceof WebView))
      {
        ((WebView)localObject1).loadUrl(paramBundle);
        label506:
        this.c.registerHandler("getDeviceInfo", new p(this));
        this.c.registerHandler("saveData", new q(this));
        this.c.registerHandler("getData", new r(this));
        this.c.registerHandler("removeData", new s(this));
        this.c.registerHandler("setPageBackEnable", new t(this));
        this.c.registerHandler("payBySDK", new u(this));
        this.c.registerHandler("downloadApp", new v(this));
        this.c.registerHandler("payResult", new j(this));
        this.c.registerHandler("closePage", new k(this));
        this.c.registerHandler("openNewPage", new l(this));
        return;
        paramBundle = getIntent().getStringExtra("wapurl");
        localObject1 = getIntent().getStringExtra("paydata");
        if (localObject1 == null) {
          break label773;
        }
      }
      label773:
      for (paramBundle = paramBundle + "?s=" + (String)localObject1;; paramBundle = "")
      {
        localObject1 = h.a().e;
        localObject2 = new m(this);
        break;
        WebviewInstrumentation.loadUrl((WebView)localObject1, paramBundle);
        break label506;
      }
      label779:
      localObject1 = "";
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      onPause();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/UPPayWapActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */