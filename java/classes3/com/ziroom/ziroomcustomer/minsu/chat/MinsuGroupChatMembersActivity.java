package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.u;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuChatMemberBaseInfoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuChatMemberListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuChatMemberListBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.b.e.a;
import java.util.List;

public class MinsuGroupChatMembersActivity
  extends BaseActivity
{
  private Context a;
  private int b = 1;
  private String c;
  @BindView(2131691272)
  CommonTitle commonTitle;
  private int d;
  private com.ziroom.ziroomcustomer.minsu.view.b.a<MinsuChatMemberBaseInfoBean> e;
  private List<MinsuChatMemberBaseInfoBean> f;
  @BindView(2131691285)
  SwipeToLoadLayout swipeToLoadLayout;
  @BindView(2131689522)
  RecyclerView swipe_target;
  
  private void a()
  {
    f();
  }
  
  private void b()
  {
    this.swipe_target.setLayoutManager(new GridLayoutManager(this, 5, 1, false));
    if ((this.f != null) && (this.d > this.f.size())) {
      this.swipeToLoadLayout.setLoadMoreEnabled(true);
    }
    for (;;)
    {
      this.swipeToLoadLayout.setRefreshEnabled(false);
      this.swipeToLoadLayout.setOnLoadMoreListener(new com.aspsine.swipetoloadlayout.a()
      {
        public void onLoadMore()
        {
          MinsuGroupChatMembersActivity.a(MinsuGroupChatMembersActivity.this);
          MinsuGroupChatMembersActivity.b(MinsuGroupChatMembersActivity.this);
        }
      });
      return;
      this.swipeToLoadLayout.setLoadMoreEnabled(false);
    }
  }
  
  private void e()
  {
    this.swipeToLoadLayout.setRefreshing(false);
    this.swipeToLoadLayout.setLoadingMore(false);
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.queryGroupUserInfo(this, this.c, this.b, new s(this, new r(MinsuChatMemberListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        if (MinsuGroupChatMembersActivity.h(MinsuGroupChatMembersActivity.this) >= 1) {
          MinsuGroupChatMembersActivity.i(MinsuGroupChatMembersActivity.this);
        }
        MinsuGroupChatMembersActivity.c(MinsuGroupChatMembersActivity.this);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuChatMemberListBean paramAnonymousMinsuChatMemberListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuChatMemberListBean);
        MinsuGroupChatMembersActivity.c(MinsuGroupChatMembersActivity.this);
        if ((paramAnonymousMinsuChatMemberListBean != null) && (paramAnonymousMinsuChatMemberListBean.checkSuccess(MinsuGroupChatMembersActivity.this)))
        {
          paramAnonymousMinsuChatMemberListBean = paramAnonymousMinsuChatMemberListBean.getData().getListUserInfo();
          if ((MinsuGroupChatMembersActivity.d(MinsuGroupChatMembersActivity.this) != null) && (MinsuGroupChatMembersActivity.d(MinsuGroupChatMembersActivity.this).size() > 0)) {
            if ((paramAnonymousMinsuChatMemberListBean != null) && (paramAnonymousMinsuChatMemberListBean.size() > 0))
            {
              MinsuGroupChatMembersActivity.d(MinsuGroupChatMembersActivity.this).addAll(paramAnonymousMinsuChatMemberListBean);
              MinsuGroupChatMembersActivity.e(MinsuGroupChatMembersActivity.this).notifyDataSetChanged();
            }
          }
        }
        do
        {
          do
          {
            return;
            g.textToast(MinsuGroupChatMembersActivity.this, MinsuGroupChatMembersActivity.this.getString(2131297294));
            MinsuGroupChatMembersActivity.this.swipeToLoadLayout.setLoadMoreEnabled(false);
            return;
            if ((paramAnonymousMinsuChatMemberListBean != null) && (paramAnonymousMinsuChatMemberListBean.size() > 0))
            {
              MinsuGroupChatMembersActivity.a(MinsuGroupChatMembersActivity.this, paramAnonymousMinsuChatMemberListBean);
              MinsuGroupChatMembersActivity.f(MinsuGroupChatMembersActivity.this);
              return;
            }
            g.textToast(MinsuGroupChatMembersActivity.this, MinsuGroupChatMembersActivity.this.getString(2131297294));
            MinsuGroupChatMembersActivity.this.swipeToLoadLayout.setLoadMoreEnabled(false);
            return;
            if (paramAnonymousMinsuChatMemberListBean == null) {
              break;
            }
            g.textToast(MinsuGroupChatMembersActivity.g(MinsuGroupChatMembersActivity.this), paramAnonymousMinsuChatMemberListBean.getMessage());
          } while (MinsuGroupChatMembersActivity.h(MinsuGroupChatMembersActivity.this) < 1);
          MinsuGroupChatMembersActivity.i(MinsuGroupChatMembersActivity.this);
          return;
          g.textToast(MinsuGroupChatMembersActivity.g(MinsuGroupChatMembersActivity.this), "获取成员列表失败");
        } while (MinsuGroupChatMembersActivity.h(MinsuGroupChatMembersActivity.this) < 1);
        MinsuGroupChatMembersActivity.i(MinsuGroupChatMembersActivity.this);
      }
    });
  }
  
  private void g()
  {
    this.e = new com.ziroom.ziroomcustomer.minsu.view.b.a(this, 2130904300, this.f)
    {
      public void convert(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramAnonymousc, MinsuChatMemberBaseInfoBean paramAnonymousMinsuChatMemberBaseInfoBean, int paramAnonymousInt)
      {
        paramAnonymousc.setText(2131695245, paramAnonymousMinsuChatMemberBaseInfoBean.getNickName());
        ((SimpleDraweeView)paramAnonymousc.getView(2131695244)).setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMinsuChatMemberBaseInfoBean.getHeadImg()));
        paramAnonymousc.setTag(2131690233, paramAnonymousMinsuChatMemberBaseInfoBean);
        paramAnonymousc.setOnClickListener(2131690233, new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
          }
        });
      }
    };
    this.e.setOnItemClickListener(new e.a()
    {
      public void onItemClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt) {}
      
      public boolean onItemLongClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
      {
        return false;
      }
    });
    this.swipe_target.setAdapter(this.e);
  }
  
  public void initTitle()
  {
    this.commonTitle.setLeftButtonType(0);
    CommonTitle localCommonTitle = this.commonTitle;
    if (this.d == 0) {}
    for (String str = "群成员";; str = "群成员 (" + this.d + "人)")
    {
      localCommonTitle.setMiddleText(str);
      this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuGroupChatMembersActivity.this.finish();
        }
      });
      this.commonTitle.setBottomLineVisible(true);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903277);
    this.a = this;
    ButterKnife.bind(this);
    paramBundle = getIntent();
    this.c = paramBundle.getStringExtra("groupId");
    this.d = paramBundle.getIntExtra("count", 0);
    this.f = paramBundle.getParcelableArrayListExtra("members");
    initTitle();
    b();
    if ((this.f == null) || (this.f.size() == 0))
    {
      a();
      return;
    }
    g();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuGroupChatMembersActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */