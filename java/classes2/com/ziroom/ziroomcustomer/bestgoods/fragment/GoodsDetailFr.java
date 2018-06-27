package com.ziroom.ziroomcustomer.bestgoods.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.bestgoods.activity.GoodsDetailAc;
import com.ziroom.ziroomcustomer.bestgoods.activity.QualificationProofAc;
import com.ziroom.ziroomcustomer.bestgoods.model.QualifcationProofMo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@com.maa.android.agent.instrumentation.Instrumented
public class GoodsDetailFr
  extends BaseFragment
  implements View.OnClickListener
{
  public boolean a = true;
  private Context b;
  private WeakReference<GoodsDetailAc> c;
  private LinearLayout d;
  private WebView e;
  private TextView f;
  private String g;
  private ArrayList<QualifcationProofMo> h = new ArrayList();
  private LinearLayout i;
  private boolean j;
  
  private void a(View paramView)
  {
    this.f = ((TextView)paramView.findViewById(2131694038));
    this.d = ((LinearLayout)paramView.findViewById(2131691838));
    this.i = ((LinearLayout)paramView.findViewById(2131694039));
  }
  
  private void c()
  {
    Object localObject;
    String str;
    if (!TextUtils.isEmpty(this.g))
    {
      if (this.e == null)
      {
        this.e = new WebView(this.b);
        this.d.addView(this.e, 0);
      }
      this.e.setVisibility(0);
      this.e.setVerticalScrollBarEnabled(false);
      this.e.setHorizontalScrollBarEnabled(false);
      localObject = this.e.getSettings();
      ((WebSettings)localObject).setDefaultTextEncodingName("utf-8");
      ((WebSettings)localObject).setDisplayZoomControls(false);
      ((WebSettings)localObject).setSupportZoom(false);
      ((WebSettings)localObject).setBuiltInZoomControls(false);
      ((WebSettings)localObject).setDomStorageEnabled(true);
      ((WebSettings)localObject).setUseWideViewPort(true);
      ((WebSettings)localObject).setLoadWithOverviewMode(true);
      ((WebSettings)localObject).setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
      ((WebSettings)localObject).setAppCacheEnabled(true);
      ((WebSettings)localObject).setCacheMode(1);
      localObject = this.e;
      str = this.g;
      if (!(localObject instanceof WebView))
      {
        ((WebView)localObject).loadDataWithBaseURL("about:blank", str, "text/html", "utf-8", null);
        if ((this.h != null) && (this.h.size() != 0)) {
          break label236;
        }
        this.f.setClickable(false);
      }
    }
    for (;;)
    {
      if (!this.j) {
        break label247;
      }
      this.i.setVisibility(0);
      return;
      WebviewInstrumentation.loadDataWithBaseURL((WebView)localObject, "about:blank", str, "text/html", "utf-8", null);
      break;
      if (this.e == null) {
        break;
      }
      this.e.setVisibility(8);
      break;
      label236:
      this.f.setClickable(true);
    }
    label247:
    this.i.setVisibility(8);
  }
  
  private void d()
  {
    this.f.setOnClickListener(this);
  }
  
  public static GoodsDetailFr newInstance(String paramString, ArrayList<QualifcationProofMo> paramArrayList, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isShowSafeCheck", paramBoolean);
    localBundle.putParcelableArrayList("qualityInspection", paramArrayList);
    localBundle.putString("detailContent", paramString);
    paramString = new GoodsDetailFr();
    paramString.setArguments(localBundle);
    Log.e("fragment", paramString.hashCode() + "");
    return paramString;
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent(this.b, QualificationProofAc.class);
    paramView.putParcelableArrayListExtra("qualityInspection", this.h);
    startActivity(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getActivity();
    this.c = new WeakReference((GoodsDetailAc)getActivity());
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.h = paramBundle.getParcelableArrayList("qualityInspection");
      this.g = paramBundle.getString("detailContent");
      this.j = paramBundle.getBoolean("isShowSafeCheck");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903913, paramViewGroup, false);
    a(paramLayoutInflater);
    d();
    c();
    if ((!isResumed()) || ((this.c != null) && (this.c.get() != null))) {
      ((GoodsDetailAc)this.c.get()).setObjectForPosition(paramLayoutInflater, 0);
    }
    return paramLayoutInflater;
  }
  
  public void setData(String paramString, ArrayList<QualifcationProofMo> paramArrayList)
  {
    this.g = paramString;
    this.h = paramArrayList;
    c();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((this.a) && (paramBoolean))
    {
      this.a = false;
      if (!isResumed()) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/fragment/GoodsDetailFr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */