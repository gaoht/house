package com.ziroom.ziroomcustomer.living;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.e;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.List;
import java.util.Map;

public class LeaseHistoryLivingActivity
  extends BaseActivity
{
  private Context a;
  private Unbinder b;
  private String c;
  private String d;
  private View e;
  @BindView(2131696600)
  ListView history_living_list;
  @BindView(2131696599)
  RelativeLayout living_history_linear;
  @BindView(2131691914)
  ImageView mBack;
  
  private void a()
  {
    this.c = (q.G + e.e.n);
    Map localMap = g.buildGroupPayMonth(this.d);
    com.freelxl.baselibrary.d.a.post(this.c).params(ah.ConvertObjMap2String(localMap)).tag(this).enqueue(new com.ziroom.commonlibrary.a.a(this.a, new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
        LeaseHistoryLivingActivity.this.showEmptyView(paramAnonymousThrowable.getMessage() + "");
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        dismissProgress();
        u.d("===", "OK====" + paramAnonymouse.toString());
        if (((Integer)paramAnonymouse.get("error_code")).intValue() == 0)
        {
          paramAnonymouse = com.alibaba.fastjson.a.parseArray(paramAnonymouse.get("data").toString(), b.class);
          if (paramAnonymouse.size() >= 1)
          {
            paramAnonymouse = new LeaseHistoryLivingAdapter(LeaseHistoryLivingActivity.a(LeaseHistoryLivingActivity.this), paramAnonymouse);
            LeaseHistoryLivingActivity.this.history_living_list.setAdapter(paramAnonymouse);
            LeaseHistoryLivingActivity.this.closeEmpty(LeaseHistoryLivingActivity.this.living_history_linear);
            return;
          }
          LeaseHistoryLivingActivity.this.showEmptyView("您还没有支付记录");
          return;
        }
        LeaseHistoryLivingActivity.this.showEmptyView(paramAnonymouse.get("error_message") + "");
      }
    });
  }
  
  private void b()
  {
    this.d = getIntent().getStringExtra("ContractCode");
  }
  
  @OnClick({2131691914})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904828);
    this.b = ButterKnife.bind(this);
    this.a = this;
    b();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.b.unbind();
  }
  
  public void showEmptyView(String paramString)
  {
    if (this.living_history_linear == null) {
      return;
    }
    this.e = showLivingEmptyView(this.living_history_linear, paramString);
    TextView localTextView = (TextView)this.e.findViewById(2131690822);
    ((FrameLayout)this.e.findViewById(2131696745)).setVisibility(8);
    localTextView.setText(paramString);
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LeaseHistoryLivingActivity.b(LeaseHistoryLivingActivity.this);
      }
    });
  }
  
  public View showLivingEmptyView(ViewGroup paramViewGroup, String paramString)
  {
    if (paramViewGroup == null) {
      return null;
    }
    paramString = paramViewGroup.findViewById(2131694408);
    if (paramString != null) {
      paramViewGroup.removeView(paramString);
    }
    paramString = LayoutInflater.from(this);
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramViewGroup.getChildAt(i).setVisibility(8);
      i += 1;
    }
    return paramString.inflate(2130904855, paramViewGroup, true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LeaseHistoryLivingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */