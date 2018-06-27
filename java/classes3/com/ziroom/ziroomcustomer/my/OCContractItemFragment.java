package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.ziroomcustomer.adapter.MyAppointAdapter.b;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.ScrollBridgeWebView;

@com.maa.android.agent.instrumentation.Instrumented
public class OCContractItemFragment
  extends BaseFragment
  implements MyAppointAdapter.b
{
  public String a = OCContractItemFragment.class.getSimpleName();
  Unbinder b;
  private Context c;
  @BindView(2131692016)
  CheckBox cbAgreeContractItems;
  private View d;
  private String e;
  @BindView(2131690620)
  ViewStub stubError;
  @BindView(2131692017)
  TextView tvAgreeContractItems;
  @BindView(2131693948)
  TextView tvDescAgreeContractItems;
  @BindView(2131693947)
  ScrollBridgeWebView wvOcContractItems;
  
  public OCContractItemFragment(String paramString)
  {
    if (paramString.contains("?")) {}
    for (paramString = paramString + "&";; paramString = paramString + "?")
    {
      this.e = (paramString + "token=" + a.getToken(this.c));
      return;
    }
  }
  
  public static OCContractItemFragment getInstance(String paramString)
  {
    return new OCContractItemFragment(paramString);
  }
  
  public void loadData()
  {
    this.wvOcContractItems.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (!(paramAnonymousWebView instanceof WebView)) {
          paramAnonymousWebView.loadUrl(paramAnonymousString);
        }
        for (;;)
        {
          return true;
          WebviewInstrumentation.loadUrl((WebView)paramAnonymousWebView, paramAnonymousString);
        }
      }
    });
    Object localObject1 = this.wvOcContractItems;
    Object localObject2 = new WebChromeClient();
    if (!(localObject1 instanceof WebView)) {
      ((ScrollBridgeWebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
    }
    for (;;)
    {
      localObject1 = this.wvOcContractItems.getSettings().getUserAgentString();
      this.wvOcContractItems.getSettings().setUserAgentString((String)localObject1 + "HybridAPP/" + "5.6.0" + "/android");
      localObject1 = this.wvOcContractItems.getSettings();
      ((WebSettings)localObject1).setJavaScriptEnabled(true);
      try
      {
        ((WebSettings)localObject1).setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        ((WebSettings)localObject1).setUseWideViewPort(true);
        ((WebSettings)localObject1).setLoadWithOverviewMode(true);
        ((WebSettings)localObject1).setSupportZoom(true);
        ((WebSettings)localObject1).setBuiltInZoomControls(true);
        ((WebSettings)localObject1).setDisplayZoomControls(false);
        u.i(this.a, "展示URL：" + this.e);
        localObject1 = this.wvOcContractItems;
        localObject2 = this.e;
        if (!(localObject1 instanceof WebView))
        {
          ((ScrollBridgeWebView)localObject1).loadUrl((String)localObject2);
          return;
          VdsAgent.setWebChromeClient((WebView)localObject1, (WebChromeClient)localObject2);
          continue;
        }
        WebviewInstrumentation.loadUrl((WebView)localObject1, (String)localObject2);
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.d = paramLayoutInflater.inflate(2130903892, paramViewGroup, false);
    this.c = getActivity();
    this.b = ButterKnife.bind(this, this.d);
    this.cbAgreeContractItems.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
        ((OwnerContractConfirmActivity)OCContractItemFragment.this.getActivity()).lightConfirmButton(paramAnonymousBoolean);
      }
    });
    this.tvAgreeContractItems.setText("我已阅读并同意" + "《资产管理服务》、《维修基金项目列表》、《标的资产配置单》");
    loadData();
    return this.d;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.b.unbind();
  }
  
  @OnClick({2131692017, 2131690620})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    }
  }
  
  public void showError(String paramString)
  {
    this.stubError.setVisibility(0);
    ((TextView)this.d.findViewById(2131690822)).setText(paramString);
    ((LinearLayout)this.d.findViewById(2131694408)).setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OCContractItemFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */