package com.ziroom.ziroomcustomer.ziroomstation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.webview.ScrollBridgeWebView;
import com.ziroom.ziroomcustomer.webview.ScrollBridgeWebView.a;
import com.ziroom.ziroomcustomer.webview.d;
import com.ziroom.ziroomcustomer.ziroomstation.ProjectDetailActivity;
import com.ziroom.ziroomcustomer.ziroomstation.model.ProjectDetailDto;
import com.ziroom.ziroomcustomer.ziroomstation.model.ProjectDetailDto.ProjectDetailData;

@Instrumented
public class StationWebViewFragment
  extends BaseFragment
  implements ScrollBridgeWebView.a
{
  protected ScrollBridgeWebView a;
  protected RelativeLayout b;
  protected LinearLayout c;
  boolean d = true;
  public boolean e = false;
  private View f;
  private d g;
  private String h = "http://www.ziroom.com/zhuanti/zr_inn/";
  private int i = 0;
  
  private void c()
  {
    this.a = ((ScrollBridgeWebView)this.f.findViewById(2131689545));
    this.b = ((RelativeLayout)this.f.findViewById(2131689768));
    this.b.setVisibility(8);
    this.c = ((LinearLayout)this.f.findViewById(2131690589));
    this.a.setOnScrollChangedCallback(this);
    this.g = new d(getActivity());
    ScrollBridgeWebView localScrollBridgeWebView = this.a;
    d locald = this.g;
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
    this.f = paramLayoutInflater.inflate(2130905156, paramViewGroup, false);
    c();
    return this.f;
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
      if (!this.d) {
        break label22;
      }
      this.d = false;
    }
    label22:
    do
    {
      return;
      localObject = ((ProjectDetailActivity)getActivity()).r;
    } while ((localObject == null) || (((ProjectDetailDto)localObject).data == null) || (ae.isNull(((ProjectDetailDto)localObject).data.showHouseUrl)));
    ScrollBridgeWebView localScrollBridgeWebView = this.a;
    Object localObject = ((ProjectDetailDto)localObject).data.showHouseUrl;
    if (!(localScrollBridgeWebView instanceof WebView))
    {
      localScrollBridgeWebView.loadUrl((String)localObject);
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)localScrollBridgeWebView, (String)localObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/fragment/StationWebViewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */