package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.ab;
import com.ziroom.ziroomcustomer.bestgoods.dialog.d;
import com.ziroom.ziroomcustomer.bestgoods.model.ai;
import com.ziroom.ziroomcustomer.bestgoods.model.ai.a;
import com.ziroom.ziroomcustomer.bestgoods.model.ai.a.a;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.List;

@com.maa.android.agent.instrumentation.Instrumented
public class YouPinCombinationInfoActivity
  extends BaseActivity
  implements View.OnClickListener, ObservableScrollView.a
{
  private WebView A;
  private String B;
  private ObservableScrollView a;
  private SimpleDraweeView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private ListViewForScrollView g;
  private TextView r;
  private Button s;
  private RelativeLayout t;
  private ImageView u;
  private TextView v;
  private View w;
  private Context x;
  private ai y;
  private String z;
  
  private void a()
  {
    this.x = this;
    this.a = ((ObservableScrollView)findViewById(2131692684));
    this.b = ((SimpleDraweeView)findViewById(2131692685));
    this.c = ((TextView)findViewById(2131692690));
    this.d = ((TextView)findViewById(2131692691));
    this.A = ((WebView)findViewById(2131692692));
    this.e = ((TextView)findViewById(2131692693));
    this.f = ((TextView)findViewById(2131692695));
    this.g = ((ListViewForScrollView)findViewById(2131692696));
    this.r = ((TextView)findViewById(2131692699));
    this.s = ((Button)findViewById(2131692701));
    this.t = ((RelativeLayout)findViewById(2131692702));
    this.u = ((ImageView)findViewById(2131692703));
    this.v = ((TextView)findViewById(2131692704));
    this.w = findViewById(2131692705);
  }
  
  private void b()
  {
    this.u.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.a.setOnScrollChangedCallback(this);
  }
  
  private void e()
  {
    String str = getIntent().getStringExtra("groupCode");
    com.ziroom.ziroomcustomer.e.n.getYouPinCombinationInfo(this.x, str, new com.ziroom.ziroomcustomer.e.a.a(this.x, new m(ai.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, ai paramAnonymousai)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousai);
        YouPinCombinationInfoActivity.a(YouPinCombinationInfoActivity.this, paramAnonymousai);
        if (YouPinCombinationInfoActivity.a(YouPinCombinationInfoActivity.this) != null) {
          YouPinCombinationInfoActivity.b(YouPinCombinationInfoActivity.this);
        }
      }
    });
  }
  
  private void f()
  {
    final List localList = this.y.getList();
    Object localObject2;
    String str1;
    Object localObject1;
    String str2;
    if ((localList != null) && (!localList.isEmpty()))
    {
      localObject2 = ((ai.a)localList.get(0)).getGroupTitle();
      this.B = ((ai.a)localList.get(0)).getGroupName();
      str1 = ((ai.a)localList.get(0)).getGroupImgUrl();
      String str3 = ((ai.a)localList.get(0)).getGroupSubTitle();
      localObject1 = ((ai.a)localList.get(0)).getGroupDesc();
      str2 = ((ai.a)localList.get(0)).getGroupPrice();
      this.z = ((ai.a)localList.get(0)).getGroupCode();
      this.v.setText((CharSequence)localObject2);
      this.f.setText(this.B);
      this.c.setVisibility(8);
      this.c.setText(str3);
      this.A.setVerticalScrollBarEnabled(false);
      this.A.setHorizontalScrollBarEnabled(false);
      localObject2 = this.A.getSettings();
      ((WebSettings)localObject2).setDefaultTextEncodingName("utf-8");
      ((WebSettings)localObject2).setDisplayZoomControls(false);
      ((WebSettings)localObject2).setSupportZoom(false);
      ((WebSettings)localObject2).setBuiltInZoomControls(false);
      ((WebSettings)localObject2).setDomStorageEnabled(true);
      ((WebSettings)localObject2).setUseWideViewPort(true);
      ((WebSettings)localObject2).setLoadWithOverviewMode(true);
      ((WebSettings)localObject2).setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
      ((WebSettings)localObject2).setAppCacheEnabled(true);
      ((WebSettings)localObject2).setCacheMode(1);
      localObject2 = this.A;
      if ((localObject2 instanceof WebView)) {
        break label357;
      }
      ((WebView)localObject2).loadDataWithBaseURL("about:blank", (String)localObject1, "text/html", "utf-8", null);
    }
    for (;;)
    {
      localList = ((ai.a)localList.get(0)).getGroupDetail();
      localObject1 = new ab(this.x, localList);
      this.g.setAdapter((ListAdapter)localObject1);
      this.g.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramAnonymousAdapterView = new Intent(YouPinCombinationInfoActivity.c(YouPinCombinationInfoActivity.this), GoodsDetailAc.class);
          paramAnonymousAdapterView.putExtra("productCode", ((ai.a.a)localList.get(paramAnonymousInt)).getProductCode());
          paramAnonymousAdapterView.putExtra("skuCode", ((ai.a.a)localList.get(paramAnonymousInt)).getDefaultSkuCode());
          YouPinCombinationInfoActivity.this.startActivity(paramAnonymousAdapterView);
        }
      });
      this.b.setController(c.frescoController(str1));
      this.r.setText(str2);
      return;
      label357:
      WebviewInstrumentation.loadDataWithBaseURL((WebView)localObject2, "about:blank", (String)localObject1, "text/html", "utf-8", null);
    }
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131692702: 
    default: 
      return;
    case 2131692703: 
      finish();
      return;
    }
    if (ApplicationEx.c.getUser() == null)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.x);
      return;
    }
    new d(this.x, this.z, this.B).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903551);
    a();
    b();
    e();
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    float f2 = paramInt2 / com.ziroom.ziroomcustomer.util.n.dip2px(this.x, 100.0F);
    if (f2 > 1.0F) {}
    for (;;)
    {
      this.t.setAlpha(f1);
      this.v.setAlpha(f1);
      this.w.setAlpha(f1);
      if (f1 > 0.6D)
      {
        this.u.setImageResource(2130840141);
        return;
      }
      this.u.setImageResource(2130840142);
      return;
      f1 = f2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinCombinationInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */