package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.d.f.d;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.l;
import com.ziroom.ziroomcustomer.adapter.o;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseSupportURIActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseListBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseListBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseListInitBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseListInitBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.stickylistheaders.StickyListHeadersListView;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;
import java.util.List;

public class MinsuTopHouseListActivity
  extends BaseSupportURIActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  private o a;
  private int b = 1;
  private int c = 10;
  @BindView(2131691272)
  CommonTitle commonTitle;
  private List<MinsuTopHouseListBean.DataBean.ListBean> d;
  private View e;
  private int f = 0;
  private MinsuTopHouseListInitBean g;
  private int r;
  private PlatformActionListener s = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      l.d("#########MeeT分享完成回调:平台", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功" + getClass().getSimpleName());
      MinsuTopHouseListActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      l.d("######### 1分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败" + getClass().getSimpleName());
      paramAnonymousThrowable.printStackTrace();
      MinsuTopHouseListActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  @BindView(2131689522)
  StickyListHeadersListView stickyList;
  @BindView(2131691285)
  SwipeToLoadLayout swipeToLoadLayout;
  
  private void a()
  {
    this.commonTitle.setLeftButtonType(1);
    this.commonTitle.setBottomLineVisible(false);
    this.commonTitle.showRightIc(true, 2130840339);
    this.commonTitle.setHeaderAlpha(0.0F);
    this.commonTitle.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuTopHouseListActivity.this.shareHouse();
      }
    });
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuTopHouseListActivity.this.finish();
      }
    });
    u.e("TAG", "initTitle");
  }
  
  private void a(MinsuTopHouseListInitBean paramMinsuTopHouseListInitBean)
  {
    if (this.e == null) {
      return;
    }
    ((SimpleDraweeView)this.e.findViewById(2131690361)).setController(com.freelxl.baselibrary.f.c.frescoController(paramMinsuTopHouseListInitBean.dataX.top50ListTitleBackground));
    u.e("TAG", "updateTopView");
  }
  
  private void b()
  {
    this.e = getLayoutInflater().inflate(2130904015, null);
    this.stickyList.setOnItemClickListener(this);
    this.stickyList.setDrawingListUnderStickyHeader(true);
    this.stickyList.setAreHeadersSticky(true);
    this.stickyList.setStickyHeaderTopOffset(ab.dp2px(ApplicationEx.c, 44.0F));
    this.stickyList.setOnScrollListener(this);
    this.stickyList.addHeaderView(this.e);
    u.e("TAG", "initView");
    this.swipeToLoadLayout.setLoadMoreEnabled(true);
    this.swipeToLoadLayout.setRefreshEnabled(false);
    this.swipeToLoadLayout.setOnLoadMoreListener(new com.aspsine.swipetoloadlayout.a()
    {
      public void onLoadMore()
      {
        MinsuTopHouseListActivity.a(MinsuTopHouseListActivity.this);
        MinsuTopHouseListActivity.b(MinsuTopHouseListActivity.this);
      }
    });
    this.commonTitle.post(new Runnable()
    {
      public void run()
      {
        MinsuTopHouseListActivity.a(MinsuTopHouseListActivity.this, MinsuTopHouseListActivity.this.commonTitle.getHeight());
      }
    });
  }
  
  private void e()
  {
    if (this.a == null)
    {
      this.a = new o(this, this.d);
      this.stickyList.setAdapter(this.a);
    }
    for (;;)
    {
      u.e("TAG", "setAdapter");
      return;
      this.a.notifyDataSetChanged();
    }
  }
  
  private void f()
  {
    this.swipeToLoadLayout.setRefreshing(false);
    this.swipeToLoadLayout.setLoadingMore(false);
  }
  
  private int g()
  {
    if (this.e == null) {
      return 0;
    }
    return this.e.getHeight();
  }
  
  private void h()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.top50HosueList(this, this.b, this.c, new com.ziroom.commonlibrary.a.a(this, new d(MinsuTopHouseListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        g.textToast(ApplicationEx.c, paramAnonymousThrowable.getMessage());
        MinsuTopHouseListActivity.e(MinsuTopHouseListActivity.this);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuTopHouseListBean paramAnonymousMinsuTopHouseListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuTopHouseListBean);
        if (("0".equals(paramAnonymousMinsuTopHouseListBean.status)) && (paramAnonymousMinsuTopHouseListBean != null))
        {
          if (MinsuTopHouseListActivity.c(MinsuTopHouseListActivity.this) != null) {
            break label62;
          }
          MinsuTopHouseListActivity.a(MinsuTopHouseListActivity.this, paramAnonymousMinsuTopHouseListBean.data.list);
        }
        for (;;)
        {
          MinsuTopHouseListActivity.d(MinsuTopHouseListActivity.this);
          MinsuTopHouseListActivity.e(MinsuTopHouseListActivity.this);
          return;
          label62:
          MinsuTopHouseListActivity.c(MinsuTopHouseListActivity.this).addAll(paramAnonymousMinsuTopHouseListBean.data.list);
        }
      }
    });
    u.e("TAG", "initListData");
  }
  
  private void i()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.top50HosueListInit(this, new com.ziroom.commonlibrary.a.a(this, new d(MinsuTopHouseListInitBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        g.textToast(ApplicationEx.c, paramAnonymousThrowable.getMessage());
        MinsuTopHouseListActivity.e(MinsuTopHouseListActivity.this);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuTopHouseListInitBean paramAnonymousMinsuTopHouseListInitBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuTopHouseListInitBean);
        if (("0".equals(paramAnonymousMinsuTopHouseListInitBean.status)) && (paramAnonymousMinsuTopHouseListInitBean != null))
        {
          MinsuTopHouseListActivity.a(MinsuTopHouseListActivity.this, paramAnonymousMinsuTopHouseListInitBean);
          MinsuTopHouseListActivity.b(MinsuTopHouseListActivity.this, paramAnonymousMinsuTopHouseListInitBean);
        }
        MinsuTopHouseListActivity.e(MinsuTopHouseListActivity.this);
      }
    });
    u.e("TAG", "getTopData");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903337);
    ButterKnife.bind(this);
    b();
    a();
    i();
    h();
  }
  
  protected void onDestroy()
  {
    com.freelxl.baselibrary.d.a.cancel(this);
    super.onDestroy();
  }
  
  @Instrumented
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    if (paramInt == 0) {
      return;
    }
    paramAdapterView = (MinsuTopHouseListBean.DataBean.ListBean)this.d.get(paramInt - 1);
    paramView = new Intent(this, MinsuTopHouseDetailActivity.class);
    paramView.putExtra("fid", paramAdapterView.fid);
    paramView.putExtra("rentWay", paramAdapterView.rentWay);
    startActivity(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      paramInt2 = g();
      paramAbsListView = paramAbsListView.getChildAt(0);
      float f2;
      float f1;
      if (paramAbsListView == null)
      {
        paramInt1 = 0;
        paramInt1 = Math.abs(paramInt1);
        u.e("TAG", "onScroll->currentY" + paramInt1);
        u.e("TAG", "onScroll->headerHeight" + paramInt2);
        f2 = (paramInt1 - paramInt2 + this.r) / this.r;
        paramAbsListView = this.commonTitle;
        if (f2 >= 0.0F) {
          break label173;
        }
        f1 = 0.0F;
        label108:
        paramAbsListView.setHeaderAlpha(f1);
        if ((f2 <= 0.75D) || (this.f == 1)) {
          break label180;
        }
        this.commonTitle.setLeftButtonType(2);
        this.commonTitle.setBottomLineVisible(true);
        this.commonTitle.showRightIc(true, 2130840338);
        this.f = 1;
      }
      label173:
      label180:
      while ((f2 > 0.75D) || (this.f == 0))
      {
        return;
        paramInt1 = paramAbsListView.getTop();
        break;
        f1 = f2;
        break label108;
      }
      this.commonTitle.setBottomLineVisible(false);
      this.commonTitle.setLeftButtonType(1);
      this.commonTitle.showRightIc(true, 2130840339);
      this.f = 0;
      return;
    }
    this.commonTitle.setLeftButtonType(2);
    this.commonTitle.setBottomLineVisible(true);
    this.commonTitle.showRightIc(true, 2130840338);
    this.commonTitle.setHeaderAlpha(1.0F);
    this.f = 1;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void shareHouse()
  {
    com.ziroom.threelib.ziroomshare.c localc = com.ziroom.threelib.ziroomshare.c.getInstance();
    if ((localc != null) && (this.g != null)) {
      localc.shareFromCenter(this, this.g.dataX.top50ListShareUrl, this.g.dataX.top50ListShareTitle, this.g.dataX.top50ListShareContent, this.g.dataX.top50ListShareImgSrc, this.s);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuTopHouseListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */