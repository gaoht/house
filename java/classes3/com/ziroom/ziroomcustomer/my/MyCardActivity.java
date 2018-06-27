package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.adapter.k;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.RentCard;
import com.ziroom.ziroomcustomer.model.RentCardDetail;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.morepage.OtherServerActivity;
import java.util.ArrayList;
import java.util.List;

public class MyCardActivity
  extends BaseActivity
  implements View.OnClickListener
{
  boolean a = false;
  private UserInfo b;
  private ApplicationEx c;
  private ListView d;
  private RentCard e;
  private List<RentCardDetail> f;
  private int g;
  private int r;
  private k s;
  private List<RentCardDetail> t;
  private int u = 0;
  private int v;
  private Context w;
  private Handler x = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (locall.getSuccess().booleanValue())
      {
        MyCardActivity.a(MyCardActivity.this, (RentCard)locall.getObject());
        if (MyCardActivity.f(MyCardActivity.this) == 1)
        {
          paramAnonymousMessage = MyCardActivity.this;
          if (MyCardActivity.g(MyCardActivity.this).getUsed_num() % MyCardActivity.h(MyCardActivity.this) > 0) {}
          for (i = MyCardActivity.g(MyCardActivity.this).getUsed_num() / MyCardActivity.h(MyCardActivity.this) + 1;; i = MyCardActivity.g(MyCardActivity.this).getUsed_num() / MyCardActivity.h(MyCardActivity.this))
          {
            MyCardActivity.a(paramAnonymousMessage, i);
            if (MyCardActivity.g(MyCardActivity.this).getDetail().size() <= 0) {
              break;
            }
            MyCardActivity.a(MyCardActivity.this, MyCardActivity.g(MyCardActivity.this).getDetail());
            MyCardActivity.j(MyCardActivity.this).addAll(MyCardActivity.i(MyCardActivity.this));
            MyCardActivity.this.a(MyCardActivity.j(MyCardActivity.this));
            return;
          }
        }
        int i = MyCardActivity.g(MyCardActivity.this).getTotal_num() - MyCardActivity.g(MyCardActivity.this).getUsed_num();
        paramAnonymousMessage = MyCardActivity.this;
        if (i % MyCardActivity.h(MyCardActivity.this) > 0) {
          i = i / MyCardActivity.h(MyCardActivity.this) + 1;
        }
        for (;;)
        {
          MyCardActivity.a(paramAnonymousMessage, i);
          break;
          i /= MyCardActivity.h(MyCardActivity.this);
        }
        MyCardActivity.this.dismissProgress();
        MyCardActivity.this.findViewById(2131696951).setVisibility(0);
        return;
      }
      MyCardActivity.this.dismissProgress();
      MyCardActivity.this.showToast(locall.getMessage());
      MyCardActivity.k(MyCardActivity.this);
    }
  };
  
  private void a()
  {
    findViewById(2131696950).setOnClickListener(this);
    if (!checkNet(getApplicationContext()))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 1);
      return;
    }
    this.d = ((ListView)findViewById(2131696953));
    this.d.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        }
        do
        {
          int i;
          do
          {
            return;
            i = paramAnonymousAbsListView.getLastVisiblePosition();
            paramAnonymousInt = 0;
            if (MyCardActivity.a(MyCardActivity.this) != null) {
              paramAnonymousInt = MyCardActivity.a(MyCardActivity.this).getCount();
            }
          } while (i != paramAnonymousInt - 1);
          MyCardActivity.b(MyCardActivity.this);
          if (MyCardActivity.c(MyCardActivity.this) > MyCardActivity.d(MyCardActivity.this))
          {
            MyCardActivity.this.showToast("已经没有更多的惠卡");
            return;
          }
        } while (MyCardActivity.this.a);
        MyCardActivity.e(MyCardActivity.this);
      }
    });
    b();
  }
  
  private void b()
  {
    this.t = new ArrayList();
    showProgress("");
    this.a = true;
    d.getRentCards(this, this.x, this.b.getUid(), this.g, this.r, this.u);
  }
  
  protected void a(List<RentCardDetail> paramList)
  {
    if (paramList != null) {
      if (this.s == null)
      {
        this.s = new k(this, paramList);
        this.d.setAdapter(this.s);
      }
    }
    for (;;)
    {
      this.a = false;
      dismissProgress();
      return;
      this.s.addMoreRentCard(paramList);
      this.s.notifyDataSetChanged();
      continue;
      showToast("获取数据失败");
    }
  }
  
  public void backZiRoom(View paramView)
  {
    setResult(1, getIntent());
    finish();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent(this, OtherServerActivity.class);
    paramView.putExtra("title", "我的惠卡");
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904949);
    this.w = this;
    this.c = ((ApplicationEx)getApplication());
    this.b = this.c.getUser();
    this.g = 1;
    this.r = 15;
    if (this.b != null)
    {
      a();
      return;
    }
    findViewById(2131696951).setVisibility(0);
    findViewById(2131696952).setVisibility(4);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */