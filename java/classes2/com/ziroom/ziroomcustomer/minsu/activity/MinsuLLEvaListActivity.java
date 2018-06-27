package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.u;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
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
import java.util.List;

public class MinsuLLEvaListActivity
  extends BaseActivity
{
  private int a = 1;
  private int b = 10;
  private List<MinsuLLEvaBean.RowsBean> c = new ArrayList();
  @BindView(2131691272)
  CommonTitle commonTitle;
  private com.ziroom.ziroomcustomer.minsu.view.b.a<MinsuLLEvaBean.RowsBean> d;
  @BindView(2131689522)
  RecyclerView swipeTarget;
  @BindView(2131691285)
  SwipeToLoadLayout swipeToLoadLayout;
  
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
        MinsuLLEvaListActivity.a(MinsuLLEvaListActivity.this);
        MinsuLLEvaListActivity.b(MinsuLLEvaListActivity.this);
      }
    });
  }
  
  private void b()
  {
    this.swipeToLoadLayout.setRefreshing(false);
    this.swipeToLoadLayout.setLoadingMore(false);
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
    this.d = new com.ziroom.ziroomcustomer.minsu.view.b.a(this, 2130904333, this.c)
    {
      public void convert(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramAnonymousc, MinsuLLEvaBean.RowsBean paramAnonymousRowsBean, int paramAnonymousInt)
      {
        int i = 8;
        String str1 = MinsuLLEvaListActivity.a(MinsuLLEvaListActivity.this, paramAnonymousRowsBean.startTimeStr) + "-" + MinsuLLEvaListActivity.a(MinsuLLEvaListActivity.this, paramAnonymousRowsBean.endTimeStr) + "  共" + paramAnonymousRowsBean.housingDay + "天";
        String str2 = "预订人: " + paramAnonymousRowsBean.userName + "  共" + paramAnonymousRowsBean.peopleNum + "位入住";
        paramAnonymousc.setText(2131689541, paramAnonymousRowsBean.houseName);
        paramAnonymousc.setText(2131690407, paramAnonymousRowsBean.evaTips);
        paramAnonymousc.setText(2131691573, str1);
        paramAnonymousc.setText(2131691575, str2);
        paramAnonymousc.setText(2131691575, str2);
        paramAnonymousc.setText(2131695243, paramAnonymousRowsBean.pjButton);
        ((SimpleDraweeView)paramAnonymousc.getView(2131691574)).setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousRowsBean.userPicUrl));
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
              paramAnonymous2View = (MinsuLLEvaBean.RowsBean)paramAnonymous2View.getTag();
              if ((paramAnonymous2View == null) || (paramAnonymous2View.pjStatus == 0)) {}
              do
              {
                return;
                if (paramAnonymous2View.pjStatus == 1)
                {
                  k.toCustomerEvaCommitActivity(MinsuLLEvaListActivity.3.a(MinsuLLEvaListActivity.3.this), paramAnonymous2View.orderSn, 2);
                  return;
                }
              } while (paramAnonymous2View.pjStatus != 2);
              k.toEvaActivity(MinsuLLEvaListActivity.3.b(MinsuLLEvaListActivity.3.this), paramAnonymous2View.orderSn, h.a);
            }
          });
          return;
          paramAnonymousInt = 0;
          break;
        }
      }
    };
    this.d.setOnItemClickListener(new e.a()
    {
      public void onItemClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
      {
        if ((com.ziroom.ziroomcustomer.minsu.f.c.isNullList(MinsuLLEvaListActivity.c(MinsuLLEvaListActivity.this))) || (paramAnonymousInt >= MinsuLLEvaListActivity.c(MinsuLLEvaListActivity.this).size())) {
          return;
        }
        k.toEvaActivity(MinsuLLEvaListActivity.this, ((MinsuLLEvaBean.RowsBean)MinsuLLEvaListActivity.c(MinsuLLEvaListActivity.this).get(paramAnonymousInt)).orderSn, h.a);
      }
      
      public boolean onItemLongClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
      {
        return false;
      }
    });
    this.swipeTarget.setAdapter(this.d);
  }
  
  private void f()
  {
    int i = h.a.value();
    com.ziroom.ziroomcustomer.minsu.e.a.queryEvaluate(this, this.b, this.a, i, 0, new s(this, new p(MinsuLLEvaBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        g.textToast(ApplicationEx.c, paramAnonymousThrowable.getMessage());
        MinsuLLEvaListActivity.d(MinsuLLEvaListActivity.this);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuLLEvaBean paramAnonymousMinsuLLEvaBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuLLEvaBean);
        if (paramAnonymousMinsuLLEvaBean != null)
        {
          MinsuLLEvaListActivity.d(MinsuLLEvaListActivity.this);
          if ((com.ziroom.ziroomcustomer.minsu.f.c.isNullList(paramAnonymousMinsuLLEvaBean.rows)) && (MinsuLLEvaListActivity.e(MinsuLLEvaListActivity.this) > 1)) {
            g.textToast(ApplicationEx.c, "没有更多数据");
          }
        }
        else
        {
          return;
        }
        MinsuLLEvaListActivity.c(MinsuLLEvaListActivity.this).addAll(paramAnonymousMinsuLLEvaBean.rows);
        MinsuLLEvaListActivity.f(MinsuLLEvaListActivity.this);
      }
    });
  }
  
  public void initTitle()
  {
    this.commonTitle.setMiddleText("我的评价");
    this.commonTitle.showRightText(false, null);
    this.commonTitle.setLeftButtonType(0);
    this.commonTitle.setBottomLineVisible(true);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLLEvaListActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903312);
    ButterKnife.bind(this);
    a();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.c.clear();
    this.a = 1;
    f();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuLLEvaListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */