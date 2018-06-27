package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.l;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaCommitBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaCommitBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLEvaBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLEvaBean.RowsBean;
import com.ziroom.ziroomcustomer.minsu.dialog.h;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.b.c.a;
import com.ziroom.ziroomcustomer.minsu.view.b.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinsuEvaSuccessActivity
  extends BaseActivity
{
  private TextView a;
  private TextView b;
  private TextView c;
  @BindView(2131691272)
  CommonTitle commonTitle;
  private TextView d;
  private View e;
  private RelativeLayout f;
  private com.ziroom.ziroomcustomer.minsu.view.b.c.a g;
  private int r = 1;
  private int s = 20;
  @BindView(2131689522)
  RecyclerView swipeTarget;
  @BindView(2131691285)
  SwipeToLoadLayout swipeToLoadLayout;
  private List<MinsuLLEvaBean.RowsBean> t = new ArrayList();
  private com.ziroom.ziroomcustomer.minsu.view.b.a<MinsuLLEvaBean.RowsBean> u;
  private h v;
  private MinsuEvaCommitBean w;
  private PlatformActionListener x = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      l.d("#########MeeT分享完成回调:平台", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功" + getClass().getSimpleName());
      MinsuEvaSuccessActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      l.d("######### 1分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败" + getClass().getSimpleName());
      paramAnonymousThrowable.printStackTrace();
      MinsuEvaSuccessActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  
  private void a()
  {
    initTitle();
    this.swipeTarget.setLayoutManager(new LinearLayoutManager(this));
    this.swipeTarget.addItemDecoration(((c.a)((c.a)new c.a(this).color(0)).sizeResId(2131231173)).build());
    this.swipeToLoadLayout.setLoadMoreEnabled(true);
    this.swipeToLoadLayout.setRefreshEnabled(false);
    this.swipeToLoadLayout.setOnLoadMoreListener(new com.aspsine.swipetoloadlayout.a()
    {
      public void onLoadMore()
      {
        MinsuEvaSuccessActivity.a(MinsuEvaSuccessActivity.this);
        MinsuEvaSuccessActivity.b(MinsuEvaSuccessActivity.this);
      }
    });
    e();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    com.ziroom.threelib.ziroomshare.c localc = com.ziroom.threelib.ziroomshare.c.getInstance();
    if (localc != null) {
      if (!paramString4.contains("?")) {
        break label58;
      }
    }
    label58:
    for (paramString4 = paramString4 + "&shareFlag=2";; paramString4 = paramString4 + "?shareFlag=2")
    {
      localc.shareFromCenter(this, paramString4, paramString1, paramString2, paramString3, this.x);
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = getResources();
    int i;
    if (paramBoolean) {
      if (this.v.isCustomer()) {
        i = 2131297072;
      }
    }
    for (;;)
    {
      localObject = ((Resources)localObject).getString(i);
      this.b.setText((CharSequence)localObject);
      return;
      i = 2131297073;
      continue;
      if (this.v.isCustomer()) {
        i = 2131297067;
      } else {
        i = 2131297068;
      }
    }
  }
  
  private void b()
  {
    int i = 1;
    int j = this.v.value();
    if (this.v == h.b) {}
    for (;;)
    {
      com.ziroom.ziroomcustomer.minsu.e.a.queryEvaluate(this, this.s, this.r, j, i, new s(this, new p(MinsuLLEvaBean.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          g.textToast(ApplicationEx.c, paramAnonymousThrowable.getMessage());
          MinsuEvaSuccessActivity.a(MinsuEvaSuccessActivity.this, true);
          MinsuEvaSuccessActivity.c(MinsuEvaSuccessActivity.this);
        }
        
        public void onSuccess(int paramAnonymousInt, MinsuLLEvaBean paramAnonymousMinsuLLEvaBean)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousMinsuLLEvaBean);
          if (paramAnonymousMinsuLLEvaBean != null)
          {
            MinsuEvaSuccessActivity.c(MinsuEvaSuccessActivity.this);
            if ((com.ziroom.ziroomcustomer.minsu.f.c.isNullList(paramAnonymousMinsuLLEvaBean.rows)) && (MinsuEvaSuccessActivity.d(MinsuEvaSuccessActivity.this) > 1)) {
              return;
            }
            MinsuEvaSuccessActivity.e(MinsuEvaSuccessActivity.this).addAll(paramAnonymousMinsuLLEvaBean.rows);
            MinsuEvaSuccessActivity.f(MinsuEvaSuccessActivity.this).notifyDataSetChanged();
            MinsuEvaSuccessActivity.g(MinsuEvaSuccessActivity.this).notifyDataSetChanged();
            MinsuEvaSuccessActivity.a(MinsuEvaSuccessActivity.this, com.ziroom.ziroomcustomer.minsu.f.c.isNullList(MinsuEvaSuccessActivity.e(MinsuEvaSuccessActivity.this)));
            return;
          }
          MinsuEvaSuccessActivity.a(MinsuEvaSuccessActivity.this, true);
        }
      });
      return;
      if (this.v == h.a) {
        i = 10;
      }
    }
  }
  
  private String d(String paramString)
  {
    if (f.isNull(paramString)) {
      return paramString;
    }
    return paramString.replace("-", "/");
  }
  
  private void e()
  {
    this.u = new com.ziroom.ziroomcustomer.minsu.view.b.a(this, 2130904333, this.t)
    {
      public void convert(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramAnonymousc, MinsuLLEvaBean.RowsBean paramAnonymousRowsBean, int paramAnonymousInt)
      {
        int i = 8;
        String str1 = MinsuEvaSuccessActivity.a(MinsuEvaSuccessActivity.this, paramAnonymousRowsBean.startTimeStr) + "-" + MinsuEvaSuccessActivity.a(MinsuEvaSuccessActivity.this, paramAnonymousRowsBean.endTimeStr) + "  共" + paramAnonymousRowsBean.housingDay + "天";
        String str2 = "预订人: " + paramAnonymousRowsBean.userName + "  共" + paramAnonymousRowsBean.peopleNum + "位入住";
        paramAnonymousc.setText(2131689541, paramAnonymousRowsBean.houseName);
        paramAnonymousc.setText(2131690407, paramAnonymousRowsBean.evaTips);
        paramAnonymousc.setText(2131691573, str1);
        paramAnonymousc.setText(2131691575, str2);
        paramAnonymousc.setText(2131691575, str2);
        paramAnonymousc.setText(2131695243, paramAnonymousRowsBean.pjButton);
        ((SimpleDraweeView)paramAnonymousc.getView(2131691574)).setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousRowsBean.picUrl));
        if (paramAnonymousRowsBean.pjStatus == 0)
        {
          paramAnonymousInt = 8;
          paramAnonymousc.setVisibility(2131695243, paramAnonymousInt);
          if (paramAnonymousRowsBean.pjStatus != 0) {
            break label251;
          }
        }
        label251:
        for (paramAnonymousInt = i;; paramAnonymousInt = 0)
        {
          paramAnonymousc.setVisibility(2131691343, paramAnonymousInt);
          paramAnonymousc.setTag(2131695243, paramAnonymousRowsBean);
          paramAnonymousc.setOnClickListener(2131695243, new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              if (paramAnonymous2View.getTag() != null)
              {
                paramAnonymous2View = (MinsuLLEvaBean.RowsBean)paramAnonymous2View.getTag();
                if (paramAnonymous2View != null) {}
              }
              else
              {
                return;
              }
              if (MinsuEvaSuccessActivity.h(MinsuEvaSuccessActivity.this).isCustomer()) {}
              for (int i = 1;; i = 2)
              {
                k.toEvaCommitActivity(MinsuEvaSuccessActivity.this, paramAnonymous2View.orderSn, i);
                MinsuEvaSuccessActivity.this.finish();
                return;
              }
            }
          });
          return;
          paramAnonymousInt = 0;
          break;
        }
      }
    };
    this.u.setOnItemClickListener(new e.a()
    {
      public void onItemClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
      {
        if ((com.ziroom.ziroomcustomer.minsu.f.c.isNullList(MinsuEvaSuccessActivity.e(MinsuEvaSuccessActivity.this))) || (paramAnonymousInt - 1 >= MinsuEvaSuccessActivity.e(MinsuEvaSuccessActivity.this).size())) {
          return;
        }
        k.toEvaActivity(MinsuEvaSuccessActivity.this, ((MinsuLLEvaBean.RowsBean)MinsuEvaSuccessActivity.e(MinsuEvaSuccessActivity.this).get(paramAnonymousInt - 1)).orderSn, MinsuEvaSuccessActivity.h(MinsuEvaSuccessActivity.this));
      }
      
      public boolean onItemLongClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
      {
        return false;
      }
    });
    this.g = new com.ziroom.ziroomcustomer.minsu.view.b.c.a(this.u);
    View localView = LayoutInflater.from(this).inflate(2130904059, null);
    this.a = ((TextView)localView.findViewById(2131691571));
    this.b = ((TextView)localView.findViewById(2131689835));
    this.c = ((TextView)localView.findViewById(2131694603));
    this.d = ((TextView)localView.findViewById(2131689826));
    this.e = localView.findViewById(2131694602);
    this.f = ((RelativeLayout)localView.findViewById(2131694601));
    Object localObject = getResources();
    if (this.v.isCustomer()) {}
    localObject = ((Resources)localObject).getString(2131297075);
    this.a.setText((CharSequence)localObject);
    a(true);
    if (this.v.isCustomer())
    {
      this.f.setVisibility(0);
      this.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (MinsuEvaSuccessActivity.i(MinsuEvaSuccessActivity.this) == null) {
            return;
          }
          MinsuEvaSuccessActivity.a(MinsuEvaSuccessActivity.this, MinsuEvaSuccessActivity.i(MinsuEvaSuccessActivity.this).data.mainTitle, MinsuEvaSuccessActivity.i(MinsuEvaSuccessActivity.this).data.subTitle, MinsuEvaSuccessActivity.i(MinsuEvaSuccessActivity.this).data.picUrl, MinsuEvaSuccessActivity.i(MinsuEvaSuccessActivity.this).data.shareUrl);
        }
      });
    }
    this.g.addHeaderView(localView);
    this.swipeTarget.setAdapter(this.g);
    this.g.notifyDataSetChanged();
  }
  
  private void f()
  {
    this.swipeToLoadLayout.setRefreshing(false);
    this.swipeToLoadLayout.setLoadingMore(false);
  }
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  public void initTitle()
  {
    this.commonTitle.setMiddleText("评价成功");
    this.commonTitle.showRightText(false, null);
    this.commonTitle.setLeftButtonType(4);
    this.commonTitle.setBottomLineVisible(true);
    this.commonTitle.setBackgroundColor(getResources().getColor(2131624583));
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuEvaSuccessActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903273);
    ButterKnife.bind(this);
    this.v = ((h)getIntent().getSerializableExtra("userType"));
    this.w = ((MinsuEvaCommitBean)getIntent().getSerializableExtra("shareInfo"));
    a();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.t.clear();
    this.r = 1;
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuEvaSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */