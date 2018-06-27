package com.ziroom.ziroomcustomer.ziroomapartment.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryHousetypeInfo.LabBean;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<ZryHousetypeInfo.LabBean> b;
  
  public a(Context paramContext, List<ZryHousetypeInfo.LabBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = LayoutInflater.from(this.a).inflate(2130904243, null, false);
    paramViewGroup = (SimpleDraweeView)paramView.findViewById(2131690097);
    TextView localTextView = (TextView)paramView.findViewById(2131695091);
    ImageView localImageView = (ImageView)paramView.findViewById(2131690724);
    final ZryHousetypeInfo.LabBean localLabBean = (ZryHousetypeInfo.LabBean)this.b.get(paramInt);
    if (localLabBean == null) {
      return paramView;
    }
    paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.a.getResources().getDisplayMetrics().density * 56.0F)));
    paramViewGroup.setController(c.frescoController(localLabBean.getImgUrl()));
    localTextView.setText(localLabBean.getContent());
    if (TextUtils.isEmpty(localLabBean.gethUrl())) {
      localImageView.setVisibility(8);
    }
    for (;;)
    {
      return paramView;
      localImageView.setVisibility(0);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          JsBridgeWebActivity.start(a.a(a.this), localLabBean.getContent(), localLabBean.gethUrl());
        }
      });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */