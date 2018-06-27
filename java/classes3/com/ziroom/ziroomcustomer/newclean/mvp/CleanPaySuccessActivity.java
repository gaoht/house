package com.ziroom.ziroomcustomer.newclean.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.commonlibrary.widget.convenientbanner.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newclean.d.q;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.ArrayList;
import java.util.List;

public class CleanPaySuccessActivity
  extends BaseActivity
{
  private String a;
  private List<String> b = new ArrayList();
  @BindView(2131690321)
  ConvenientBanner mCbBanner;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131690320)
  TextView mTvCleanOrder;
  
  private void a()
  {
    this.a = getIntent().getStringExtra("type");
    this.mIvBack.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanPaySuccessActivity.this.finish();
      }
    });
    if ("clean_store".equals(this.a))
    {
      this.mTvCleanOrder.setText("去预约保洁");
      this.mTvCleanOrder.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          CleanPaySuccessActivity.this.startActivity(new Intent(CleanPaySuccessActivity.this, CleanHomeActivity.class));
        }
      });
    }
    for (;;)
    {
      b();
      return;
      if ("clean_pay".equals(this.a))
      {
        this.mTvCleanOrder.setText("返回收银台");
        this.mTvCleanOrder.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("clean_pay_success_activity", null));
            CleanPaySuccessActivity.this.finish();
          }
        });
      }
    }
  }
  
  private void b()
  {
    n.getPaySuccessBanner(this, new d(this, new e(q.class))
    {
      public void onSuccess(int paramAnonymousInt, final List<q> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          CleanPaySuccessActivity.this.mCbBanner.setVisibility(0);
          CleanPaySuccessActivity.a(CleanPaySuccessActivity.this).clear();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < paramAnonymousList.size())
          {
            CleanPaySuccessActivity.a(CleanPaySuccessActivity.this).add(((q)paramAnonymousList.get(paramAnonymousInt)).getImg());
            paramAnonymousInt += 1;
          }
          CleanPaySuccessActivity.this.mCbBanner.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
          {
            public com.ziroom.ziroomcustomer.newServiceList.view.c createHolder()
            {
              return new com.ziroom.ziroomcustomer.newServiceList.view.c();
            }
          }, CleanPaySuccessActivity.a(CleanPaySuccessActivity.this)).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setOnItemClickListener(new b()
          {
            public void onItemClick(int paramAnonymous2Int) {}
          });
          CleanPaySuccessActivity.this.mCbBanner.startTurning(3000L);
          CleanPaySuccessActivity.this.mCbBanner.setOnItemClickListener(new b()
          {
            public void onItemClick(int paramAnonymous2Int)
            {
              if (!TextUtils.isEmpty(((q)paramAnonymousList.get(paramAnonymous2Int)).getTarget()))
              {
                String str1 = ((q)paramAnonymousList.get(paramAnonymous2Int)).getTitle();
                String str2 = ((q)paramAnonymousList.get(paramAnonymous2Int)).getTarget();
                String str3 = ((q)paramAnonymousList.get(paramAnonymous2Int)).getDescription();
                String str4 = ((q)paramAnonymousList.get(paramAnonymous2Int)).getImg();
                JsBridgeWebActivity.start(CleanPaySuccessActivity.this, str1, str2, true, str3, str4, false);
              }
            }
          });
          if ((CleanPaySuccessActivity.a(CleanPaySuccessActivity.this) != null) && (CleanPaySuccessActivity.a(CleanPaySuccessActivity.this).size() > 0))
          {
            if (CleanPaySuccessActivity.a(CleanPaySuccessActivity.this).size() == 1)
            {
              CleanPaySuccessActivity.this.mCbBanner.setPointViewVisible(false);
              CleanPaySuccessActivity.this.mCbBanner.setCanLoop(false);
            }
          }
          else {
            return;
          }
          CleanPaySuccessActivity.this.mCbBanner.setPointViewVisible(true);
          CleanPaySuccessActivity.this.mCbBanner.setCanLoop(true);
          return;
        }
        CleanPaySuccessActivity.this.mCbBanner.setVisibility(8);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903149);
    ButterKnife.bind(this);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/CleanPaySuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */