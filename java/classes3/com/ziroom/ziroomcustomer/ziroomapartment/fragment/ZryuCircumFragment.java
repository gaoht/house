package com.ziroom.ziroomcustomer.ziroomapartment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.webview.ScrollBridgeWebView;
import com.ziroom.ziroomcustomer.webview.ScrollBridgeWebView.a;
import com.ziroom.ziroomcustomer.webview.d;

@Instrumented
public class ZryuCircumFragment
  extends BaseFragment
  implements ScrollBridgeWebView.a
{
  protected ScrollBridgeWebView a;
  boolean b = true;
  public boolean c = false;
  private View d;
  private d e;
  private String f = "http://www.ziroom.com/zhuanti/zr_inn/";
  private int g = 0;
  
  public ZryuCircumFragment() {}
  
  public ZryuCircumFragment(String paramString)
  {
    this.f = paramString;
  }
  
  private void c()
  {
    this.a = ((ScrollBridgeWebView)this.d.findViewById(2131689545));
    this.a.setOnScrollChangedCallback(this);
    this.e = new d(getActivity());
    ScrollBridgeWebView localScrollBridgeWebView = this.a;
    d locald = this.e;
    if (!(localScrollBridgeWebView instanceof WebView))
    {
      localScrollBridgeWebView.setWebChromeClient(locald);
      return;
    }
    VdsAgent.setWebChromeClient((WebView)localScrollBridgeWebView, locald);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = paramLayoutInflater.inflate(2130905253, paramViewGroup, false);
    c();
    return this.d;
  }
  
  public void onResume()
  {
    a("zinn_detail_spe_duration");
    super.onResume();
  }
  
  public void onScroll(MotionEvent paramMotionEvent) {}
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (this.b) {
        this.b = false;
      }
    }
    else {
      return;
    }
    ScrollBridgeWebView localScrollBridgeWebView = this.a;
    String str = this.f;
    if (!(localScrollBridgeWebView instanceof WebView))
    {
      localScrollBridgeWebView.loadUrl(str);
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)localScrollBridgeWebView, str);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/fragment/ZryuCircumFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */