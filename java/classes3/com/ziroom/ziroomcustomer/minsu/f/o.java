package com.ziroom.ziroomcustomer.minsu.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseDetailBean.HouseTopInfoVoBean.HouseTopColumnVoListBean;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.n;

public class o
{
  private static View a(Context paramContext, String paramString, double paramDouble)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 18.0F), 0);
    localSimpleDraweeView.setLayoutParams(localLayoutParams);
    if (paramDouble > 0.0D) {
      localSimpleDraweeView.setAspectRatio((float)paramDouble);
    }
    for (;;)
    {
      localSimpleDraweeView.setController(c.frescoController(paramString));
      return localSimpleDraweeView;
      localSimpleDraweeView.setAspectRatio(1.5F);
    }
  }
  
  private static View a(Context paramContext, String paramString, int paramInt)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130904888, null, false);
    TextView localTextView = (TextView)localView.findViewById(2131689541);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localTextView.setText(str);
    paramString = localView.findViewById(2131693860);
    if (paramInt == 0) {}
    for (int i = 8;; i = 0)
    {
      paramString.setVisibility(i);
      if (paramInt > 0)
      {
        paramString = new LinearLayout.LayoutParams(-1, -2);
        paramString.setMargins(0, n.dip2px(paramContext, 30.0F), 0, 0);
        localView.setLayoutParams(paramString);
      }
      return localView;
    }
  }
  
  private static View a(Context paramContext, String paramString1, final String paramString2, double paramDouble)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 30.0F), n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 40.0F));
    localSimpleDraweeView.setLayoutParams(localLayoutParams);
    if (paramDouble > 0.0D) {
      localSimpleDraweeView.setAspectRatio((float)paramDouble);
    }
    for (;;)
    {
      localSimpleDraweeView.setController(c.frescoController(paramString1));
      localSimpleDraweeView.setTag(paramString2);
      localSimpleDraweeView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          Object localObject = ad.getBrowserPackageName(this.a);
          PackageManager localPackageManager = this.a.getPackageManager();
          paramAnonymousView = (View)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            paramAnonymousView = "com.android.browser";
            ah.getBrowserPackageName(this.a);
          }
          localObject = localPackageManager.getLaunchIntentForPackage(paramAnonymousView);
          paramAnonymousView = (View)localObject;
          if (localObject == null)
          {
            paramAnonymousView = new Intent();
            ah.getBrowserPackageName(this.a);
          }
          paramAnonymousView.setData(Uri.parse(paramString2));
          paramAnonymousView.setAction("android.intent.action.VIEW");
          this.a.startActivity(paramAnonymousView);
        }
      });
      return localSimpleDraweeView;
      localSimpleDraweeView.setAspectRatio(1.5F);
    }
  }
  
  private static View b(Context paramContext, String paramString, int paramInt)
  {
    TextView localTextView = new TextView(paramContext);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localTextView.setText(str);
    localTextView.setGravity(paramInt);
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 40.0F), n.dip2px(paramContext, 18.0F), 0);
    localTextView.setLayoutParams(paramString);
    localTextView.setPadding(0, 0, 0, 0);
    localTextView.getPaint().setFakeBoldText(true);
    localTextView.setTextSize(18.0F);
    localTextView.setTextColor(Color.parseColor("#444444"));
    return localTextView;
  }
  
  private static View c(Context paramContext, String paramString, int paramInt)
  {
    TextView localTextView = new TextView(paramContext);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localTextView.setText(str);
    localTextView.setGravity(paramInt);
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 40.0F), n.dip2px(paramContext, 18.0F), 0);
    localTextView.setLayoutParams(paramString);
    localTextView.setPadding(0, 0, 0, 0);
    localTextView.getPaint().setFakeBoldText(true);
    localTextView.setTextSize(16.0F);
    localTextView.setTextColor(Color.parseColor("#444444"));
    return localTextView;
  }
  
  private static View d(Context paramContext, String paramString, int paramInt)
  {
    TextView localTextView = new TextView(paramContext);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localTextView.setText(str);
    localTextView.setGravity(paramInt);
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 40.0F), n.dip2px(paramContext, 18.0F), 0);
    localTextView.setLayoutParams(paramString);
    localTextView.setPadding(0, 0, 0, 0);
    localTextView.getPaint().setFakeBoldText(true);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(Color.parseColor("#444444"));
    return localTextView;
  }
  
  private static View e(Context paramContext, String paramString, int paramInt)
  {
    TextView localTextView = new TextView(paramContext);
    if (paramString == null) {}
    for (paramString = "";; paramString = paramString.replace("·", "• "))
    {
      localTextView.setText(paramString);
      localTextView.setGravity(paramInt);
      localTextView.setLineSpacing(n.dip2px(paramContext, 26.0F), 0.0F);
      paramString = new LinearLayout.LayoutParams(-1, -2);
      paramString.setMargins(n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 24.0F), n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 20.0F));
      localTextView.setLayoutParams(paramString);
      localTextView.setPadding(0, 0, 0, 0);
      localTextView.setTextSize(14.0F);
      localTextView.setTextColor(Color.parseColor("#444444"));
      return localTextView;
    }
  }
  
  private static View f(Context paramContext, String paramString, int paramInt)
  {
    TextView localTextView = new TextView(paramContext);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localTextView.setText(str);
    localTextView.setGravity(paramInt);
    localTextView.setLineSpacing(n.dip2px(paramContext, 24.0F), 0.0F);
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 18.0F), 0);
    localTextView.setLayoutParams(paramString);
    localTextView.setPadding(0, 0, 0, 0);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(Color.parseColor("#666666"));
    return localTextView;
  }
  
  private static View g(Context paramContext, String paramString, int paramInt)
  {
    TextView localTextView = new TextView(paramContext);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localTextView.setText(str);
    localTextView.setGravity(paramInt);
    localTextView.setLineSpacing(n.dip2px(paramContext, 20.0F), 0.0F);
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 12.0F), n.dip2px(paramContext, 18.0F), 0);
    localTextView.setLayoutParams(paramString);
    localTextView.setPadding(0, 0, 0, 0);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(Color.parseColor("#666666"));
    return localTextView;
  }
  
  public static View generateView(Context paramContext, MinsuTopHouseDetailBean.HouseTopInfoVoBean.HouseTopColumnVoListBean paramHouseTopColumnVoListBean, int paramInt)
  {
    int j = 8388611;
    int i = j;
    switch (paramHouseTopColumnVoListBean.getColumnStyle())
    {
    default: 
      i = j;
    }
    for (;;)
    {
      switch (paramHouseTopColumnVoListBean.getColumnType())
      {
      default: 
        return null;
        i = 8388613;
        continue;
        i = 17;
      }
    }
    return a(paramContext, paramHouseTopColumnVoListBean.getColumnContent(), paramInt);
    return a(paramContext, paramHouseTopColumnVoListBean.getColumnContent(), paramInt);
    return b(paramContext, paramHouseTopColumnVoListBean.getColumnContent(), i);
    return c(paramContext, paramHouseTopColumnVoListBean.getColumnContent(), i);
    return d(paramContext, paramHouseTopColumnVoListBean.getColumnContent(), i);
    return e(paramContext, paramHouseTopColumnVoListBean.getColumnContent(), i);
    return f(paramContext, paramHouseTopColumnVoListBean.getColumnContent(), i);
    return h(paramContext, paramHouseTopColumnVoListBean.getColumnContent(), i);
    return g(paramContext, paramHouseTopColumnVoListBean.getColumnContent(), i);
    return a(paramContext, paramHouseTopColumnVoListBean.getPicUrl(), paramHouseTopColumnVoListBean.getImageAspectratio());
    return a(paramContext, paramHouseTopColumnVoListBean.getPicUrl(), paramHouseTopColumnVoListBean.getVideoUrl(), paramHouseTopColumnVoListBean.getImageAspectratio());
  }
  
  private static View h(Context paramContext, String paramString, int paramInt)
  {
    TextView localTextView = new TextView(paramContext);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localTextView.setText(str);
    localTextView.setGravity(paramInt);
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 12.0F), n.dip2px(paramContext, 18.0F), n.dip2px(paramContext, 12.0F));
    localTextView.setLayoutParams(paramString);
    localTextView.setPadding(0, 0, 0, 0);
    localTextView.setTextSize(12.0F);
    localTextView.setGravity(1);
    localTextView.setTextColor(Color.parseColor("#bebebe"));
    return localTextView;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */