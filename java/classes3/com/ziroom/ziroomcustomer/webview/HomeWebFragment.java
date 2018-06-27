package com.ziroom.ziroomcustomer.webview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.home.bean.HouseDetailJs.ParamBean;
import com.ziroom.ziroomcustomer.util.ah;

@com.maa.android.agent.instrumentation.Instrumented
public class HomeWebFragment
  extends BaseFragment
{
  protected ScrollBridgeWebView a;
  protected RelativeLayout b;
  protected LinearLayout c;
  boolean d = true;
  public boolean e = false;
  private View f;
  private d g;
  private String h;
  private int i = 0;
  
  private void c()
  {
    this.a = ((ScrollBridgeWebView)this.f.findViewById(2131689545));
    this.b = ((RelativeLayout)this.f.findViewById(2131689768));
    this.c = ((LinearLayout)this.f.findViewById(2131690589));
    this.g = new d(getActivity());
    ScrollBridgeWebView localScrollBridgeWebView = this.a;
    d locald = this.g;
    if (!(localScrollBridgeWebView instanceof WebView)) {
      localScrollBridgeWebView.setWebChromeClient(locald);
    }
    for (;;)
    {
      ((ImageView)this.f.findViewById(2131690751)).setOnClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(HomeWebFragment.this.getActivity(), MainActivity.class);
          paramAnonymousView.putExtra("FRAGMENT_TYPE", 7);
          HomeWebFragment.this.startActivity(paramAnonymousView);
        }
      });
      return;
      VdsAgent.setWebChromeClient((WebView)localScrollBridgeWebView, locald);
    }
  }
  
  private void d()
  {
    new b().toGoodsShelf(this.a, new b.a()
    {
      public void onJsLinkCallBack(HouseDetailJs.ParamBean paramAnonymousParamBean)
      {
        Intent localIntent = new Intent(HomeWebFragment.this.getActivity(), HomeWebActivity.class);
        localIntent.putExtra("ziru", "ziroomupin");
        localIntent.putExtra("title", "自如优品");
        if (paramAnonymousParamBean.getOutsidePage() == 1) {
          if (paramAnonymousParamBean.getUrl().contains("?")) {
            localIntent.putExtra("url", paramAnonymousParamBean.getUrl() + "&app_version=" + ah.getVersion(ApplicationEx.c) + "&os=android");
          }
        }
        for (;;)
        {
          HomeWebFragment.this.startActivity(localIntent);
          return;
          localIntent.putExtra("url", paramAnonymousParamBean.getUrl() + "?app_version=" + ah.getVersion(ApplicationEx.c) + "&os=android");
          continue;
          localIntent.putExtra("url", paramAnonymousParamBean.getUrl());
        }
      }
    });
  }
  
  private void e()
  {
    if (!checkNet(getActivity()))
    {
      showEmpty(this.c, "可能网络不佳,请稍后再试");
      return;
    }
    closeEmpty(this.c);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = paramLayoutInflater.inflate(2130904011, null);
    c();
    d();
    return this.f;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    ScrollBridgeWebView localScrollBridgeWebView;
    String str;
    if ((paramBoolean) && (this.d))
    {
      e();
      localScrollBridgeWebView = this.a;
      str = this.h;
      if ((localScrollBridgeWebView instanceof WebView)) {
        break label48;
      }
      localScrollBridgeWebView.loadUrl(str);
    }
    for (;;)
    {
      this.d = false;
      return;
      label48:
      WebviewInstrumentation.loadUrl((WebView)localScrollBridgeWebView, str);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/webview/HomeWebFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */