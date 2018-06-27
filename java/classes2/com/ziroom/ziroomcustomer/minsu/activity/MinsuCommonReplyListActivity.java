package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCommonResult;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactsListBean.ListUsualContactBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImReplyCommonBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImReplyCommonBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImReplyCommonBean.DataBean.ListMsgBean;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistviewForScrollView.SwipeMenuListView;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistviewForScrollView.SwipeMenuListView.a;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistviewForScrollView.b;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistviewForScrollView.e;
import java.util.ArrayList;
import java.util.List;

public class MinsuCommonReplyListActivity
  extends BaseActivity
{
  private com.ziroom.ziroomcustomer.minsu.adapter.g a;
  private List<MinsuImReplyCommonBean.DataBean.ListMsgBean> b = new ArrayList();
  private ArrayList<MinsuContactsListBean.ListUsualContactBean> c = new ArrayList();
  @BindView(2131691272)
  CommonTitle commonTitle;
  @BindView(2131689522)
  SwipeMenuListView listview;
  
  private void a()
  {
    initTitle();
    com.ziroom.ziroomcustomer.minsu.view.swipemenulistviewForScrollView.d local1 = new com.ziroom.ziroomcustomer.minsu.view.swipemenulistviewForScrollView.d()
    {
      public void create(b paramAnonymousb)
      {
        e locale = new e(MinsuCommonReplyListActivity.this.getApplicationContext());
        locale.setBackground(new ColorDrawable(Color.parseColor("#CCCCCC")));
        locale.setWidth(ab.dp2px(ApplicationEx.c, 80.0F));
        locale.setTitle("编辑");
        locale.setTitleSize(18);
        locale.setTitleColor(-1);
        paramAnonymousb.addMenuItem(locale);
        locale = new e(MinsuCommonReplyListActivity.this.getApplicationContext());
        locale.setBackground(new ColorDrawable(Color.parseColor("#FF3B30")));
        locale.setWidth(ab.dp2px(ApplicationEx.c, 80.0F));
        locale.setTitle("删除");
        locale.setTitleSize(18);
        locale.setTitleColor(-1);
        paramAnonymousb.addMenuItem(locale);
      }
    };
    this.listview.setMenuCreator(local1);
    this.listview.setOnMenuItemClickListener(new SwipeMenuListView.a()
    {
      public boolean onMenuItemClick(int paramAnonymousInt1, b paramAnonymousb, int paramAnonymousInt2)
      {
        com.freelxl.baselibrary.f.d.i("info", "== " + paramAnonymousInt1 + " " + paramAnonymousInt2);
        paramAnonymousb = (MinsuImReplyCommonBean.DataBean.ListMsgBean)MinsuCommonReplyListActivity.a(MinsuCommonReplyListActivity.this).get(paramAnonymousInt1);
        if (paramAnonymousInt2 == 0) {
          MinsuCommonReplyListActivity.a(MinsuCommonReplyListActivity.this, (MinsuImReplyCommonBean.DataBean.ListMsgBean)MinsuCommonReplyListActivity.a(MinsuCommonReplyListActivity.this).get(paramAnonymousInt1));
        }
        while (1 != paramAnonymousInt2) {
          return true;
        }
        MinsuCommonReplyListActivity.this.delAlert(MinsuCommonReplyListActivity.this.getResources().getString(2131296758), paramAnonymousInt1);
        return true;
      }
    });
    this.listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        return false;
      }
    });
    this.a = new com.ziroom.ziroomcustomer.minsu.adapter.g(this, this.b);
    this.listview.setAdapter(this.a);
    this.listview.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt2 = 0;
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousAbsListView = paramAnonymousAbsListView.getChildAt(0);
          if (paramAnonymousAbsListView == null) {}
          for (paramAnonymousInt1 = paramAnonymousInt2;; paramAnonymousInt1 = paramAnonymousAbsListView.getTop())
          {
            float f2 = Math.abs(paramAnonymousInt1) / 100.0F;
            paramAnonymousAbsListView = MinsuCommonReplyListActivity.this.commonTitle;
            float f1 = f2;
            if (f2 > 1.0F) {
              f1 = 1.0F;
            }
            paramAnonymousAbsListView.setBottomLineAlpha(f1);
            return;
          }
        }
        MinsuCommonReplyListActivity.this.commonTitle.setBottomLineAlpha(1.0F);
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
  }
  
  private void a(MinsuImReplyCommonBean.DataBean.ListMsgBean paramListMsgBean)
  {
    k.toEditCommonReply(this, paramListMsgBean);
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.imReclyCommon(this, new com.ziroom.commonlibrary.a.a(this, new com.freelxl.baselibrary.d.f.d(MinsuImReplyCommonBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuImReplyCommonBean paramAnonymousMinsuImReplyCommonBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuImReplyCommonBean);
        if ((paramAnonymousMinsuImReplyCommonBean != null) && (paramAnonymousMinsuImReplyCommonBean.checkSuccess(MinsuCommonReplyListActivity.this)))
        {
          MinsuCommonReplyListActivity.a(MinsuCommonReplyListActivity.this).clear();
          MinsuImReplyCommonBean.DataBean.ListMsgBean localListMsgBean = new MinsuImReplyCommonBean.DataBean.ListMsgBean();
          localListMsgBean.msgType = -1;
          MinsuCommonReplyListActivity.a(MinsuCommonReplyListActivity.this).add(localListMsgBean);
          MinsuCommonReplyListActivity.a(MinsuCommonReplyListActivity.this).addAll(paramAnonymousMinsuImReplyCommonBean.data.listMsg);
          MinsuCommonReplyListActivity.this.listview.setdataIn(MinsuCommonReplyListActivity.a(MinsuCommonReplyListActivity.this));
          MinsuCommonReplyListActivity.c(MinsuCommonReplyListActivity.this).setDatas(MinsuCommonReplyListActivity.a(MinsuCommonReplyListActivity.this));
          MinsuCommonReplyListActivity.c(MinsuCommonReplyListActivity.this).notifyDataSetChanged();
        }
      }
    });
  }
  
  private void d(String paramString)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.delCommonReply(this, paramString, new com.ziroom.commonlibrary.a.a(this, new com.freelxl.baselibrary.d.f.d(MinsuCommonResult.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuCommonResult paramAnonymousMinsuCommonResult)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuCommonResult);
        com.freelxl.baselibrary.f.g.textToast(MinsuCommonReplyListActivity.this, "删除成功");
        MinsuCommonReplyListActivity.b(MinsuCommonReplyListActivity.this);
      }
    });
  }
  
  public void delAlert(String paramString, final int paramInt)
  {
    c.newBuilder(this).setTitle("提示").setContent(paramString).setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          MinsuCommonReplyListActivity.a(MinsuCommonReplyListActivity.this, ((MinsuImReplyCommonBean.DataBean.ListMsgBean)MinsuCommonReplyListActivity.a(MinsuCommonReplyListActivity.this).get(paramInt)).fid);
        }
      }
    }).build().show();
  }
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  public void initTitle()
  {
    this.commonTitle = ((CommonTitle)findViewById(2131691272));
    this.commonTitle.setLeftButtonType(4);
    this.commonTitle.setBottomLineAlpha(0.0F);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuCommonReplyListActivity.this.finish();
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      this.a.setDatas(new ArrayList());
      b();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903265);
    ButterKnife.bind(this);
    a();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuCommonReplyListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */