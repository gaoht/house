package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.adapter.i;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactsListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactsListBean.ListUsualContactBean;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.f.q;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.SwipeMenuListView;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.SwipeMenuListView.a;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.b;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.d;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.e;
import java.util.ArrayList;
import java.util.List;

public class MinsuCustomersListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ArrayList<MinsuContactsListBean.ListUsualContactBean> a = new ArrayList();
  private i b;
  private int c = 30;
  @BindView(2131691272)
  CommonTitle commonTitle;
  private int d = 1;
  private List<MinsuContactsListBean.ListUsualContactBean> e = new ArrayList();
  private ArrayList<MinsuContactsListBean.ListUsualContactBean> f = new ArrayList();
  @BindView(2131689578)
  View line;
  @BindView(2131691286)
  SwipeMenuListView listview;
  @BindView(2131691285)
  SwipeToLoadLayout swipeToLoadLayout;
  @BindView(2131690041)
  TextView tvAdd;
  @BindView(2131691284)
  TextView tvSelect;
  @BindView(2131689541)
  TextView tvTitle;
  
  private void a()
  {
    initTitle();
    d local1 = new d()
    {
      public void create(b paramAnonymousb)
      {
        e locale = new e(MinsuCustomersListActivity.this.getApplicationContext());
        locale.setBackground(new ColorDrawable(Color.parseColor("#FF3B30")));
        locale.setWidth(ab.dp2px(ApplicationEx.c, 70.0F));
        locale.setTitle("删除");
        locale.setTitleSize(16);
        locale.setTitleColor(-1);
        paramAnonymousb.addMenuItem(locale);
      }
    };
    this.listview.setMenuCreator(local1);
    this.listview.setOnMenuItemClickListener(new SwipeMenuListView.a()
    {
      public boolean onMenuItemClick(int paramAnonymousInt1, b paramAnonymousb, int paramAnonymousInt2)
      {
        MinsuCustomersListActivity.a(MinsuCustomersListActivity.this, paramAnonymousInt1);
        return false;
      }
    });
    this.listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        MinsuCustomersListActivity.a(MinsuCustomersListActivity.this, paramAnonymousInt);
        return false;
      }
    });
    this.b = new i(this, this.e);
    this.listview.setAdapter(this.b);
    this.swipeToLoadLayout.setLoadMoreEnabled(true);
    this.swipeToLoadLayout.setRefreshEnabled(false);
    this.swipeToLoadLayout.setOnLoadMoreListener(new com.aspsine.swipetoloadlayout.a()
    {
      public void onLoadMore()
      {
        MinsuCustomersListActivity.a(MinsuCustomersListActivity.this);
      }
    });
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = this.line;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void b()
  {
    this.d = 1;
    com.ziroom.ziroomcustomer.minsu.e.a.findContacts(this, this.c, this.d, new s(this, new p(MinsuContactsListBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuContactsListBean paramAnonymousMinsuContactsListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuContactsListBean);
        if ((paramAnonymousMinsuContactsListBean != null) && (paramAnonymousMinsuContactsListBean.listUsualContact != null) && (paramAnonymousMinsuContactsListBean.listUsualContact.size() > 0))
        {
          MinsuCustomersListActivity.c(MinsuCustomersListActivity.this).setDatas(paramAnonymousMinsuContactsListBean.listUsualContact);
          MinsuCustomersListActivity.c(MinsuCustomersListActivity.this).notifyDataSetChanged();
          MinsuCustomersListActivity.a(MinsuCustomersListActivity.this, true);
        }
        for (;;)
        {
          MinsuCustomersListActivity.d(MinsuCustomersListActivity.this);
          return;
          g.textToast(MinsuCustomersListActivity.this, "没有联系人");
          MinsuCustomersListActivity.a(MinsuCustomersListActivity.this, false);
        }
      }
    });
  }
  
  private void b(int paramInt)
  {
    this.e = this.b.getDatas();
    if ((this.e == null) || (c.isNullList(this.e)) || (paramInt >= this.e.size())) {
      return;
    }
    final MinsuContactsListBean.ListUsualContactBean localListUsualContactBean = (MinsuContactsListBean.ListUsualContactBean)this.e.get(paramInt);
    com.ziroom.ziroomcustomer.minsu.e.a.deleteContact(this, localListUsualContactBean.fid, new s(this, new q())
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        g.textToast(ApplicationEx.c, "删除成功");
        if (MinsuCustomersListActivity.c(MinsuCustomersListActivity.this).getSelectDatas().contains(localListUsualContactBean)) {
          MinsuCustomersListActivity.c(MinsuCustomersListActivity.this).getSelectDatas().remove(localListUsualContactBean);
        }
        MinsuCustomersListActivity.b(MinsuCustomersListActivity.this).add(localListUsualContactBean);
        MinsuCustomersListActivity.b(MinsuCustomersListActivity.this, 1);
        MinsuCustomersListActivity.e(MinsuCustomersListActivity.this);
      }
    });
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.findContacts(this, this.c, this.d, new s(this, new p(MinsuContactsListBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuContactsListBean paramAnonymousMinsuContactsListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuContactsListBean);
        if ((paramAnonymousMinsuContactsListBean != null) && (paramAnonymousMinsuContactsListBean.listUsualContact != null) && (paramAnonymousMinsuContactsListBean.listUsualContact.size() > 0))
        {
          MinsuCustomersListActivity.this.appendUI(paramAnonymousMinsuContactsListBean.listUsualContact);
          MinsuCustomersListActivity.a(MinsuCustomersListActivity.this, true);
        }
        for (;;)
        {
          MinsuCustomersListActivity.d(MinsuCustomersListActivity.this);
          return;
          ad.shouErrorMessage("没有更多联系人...");
        }
      }
    });
  }
  
  private void f()
  {
    int i = getIntent().getIntExtra("limit", Integer.MAX_VALUE);
    ArrayList localArrayList = (ArrayList)getIntent().getSerializableExtra("data");
    this.b.setLimit(i);
    this.b.setSelectDatas(localArrayList);
  }
  
  private void g()
  {
    this.d += 1;
    e();
  }
  
  private void h()
  {
    this.swipeToLoadLayout.setRefreshing(false);
    this.swipeToLoadLayout.setLoadingMore(false);
  }
  
  public void appendUI(List<MinsuContactsListBean.ListUsualContactBean> paramList)
  {
    this.b.addDatas(paramList);
    this.b.notifyDataSetChanged();
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
    this.commonTitle.setBottomLineVisible(false);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (MinsuCustomersListActivity.b(MinsuCustomersListActivity.this).size() > 0) {
          MinsuCustomersListActivity.this.setResult(0, MinsuCustomersListActivity.this.getIntent().putExtra("dataDel", MinsuCustomersListActivity.b(MinsuCustomersListActivity.this)));
        }
        MinsuCustomersListActivity.this.finish();
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (102 == paramInt1)
    {
      this.b.setDatas(new ArrayList());
      this.d = 1;
      b();
    }
  }
  
  @OnClick({2131690041, 2131691284})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690041: 
      k.toCustomerDetailsActivity(this, null);
      return;
    }
    this.f.clear();
    this.f.addAll(this.b.getSelectDatas());
    setResult(-1, getIntent().putExtra("contacts", this.f));
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903270);
    ButterKnife.bind(this);
    a();
    f();
    b();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.a.size() > 0) {
        setResult(0, getIntent().putExtra("dataDel", this.a));
      }
      finish();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    updateSelectStatus();
  }
  
  public void updateSelectStatus()
  {
    if ((this.b == null) || (this.tvSelect == null)) {
      return;
    }
    boolean bool;
    if (this.b.getSelectDatas().size() > 0)
    {
      bool = true;
      if (!bool) {
        break label69;
      }
    }
    label69:
    for (int i = 2131624475;; i = 2131624046)
    {
      this.tvSelect.setEnabled(bool);
      this.tvSelect.setBackgroundColor(ApplicationEx.c.getResources().getColor(i));
      return;
      bool = false;
      break;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuCustomersListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */