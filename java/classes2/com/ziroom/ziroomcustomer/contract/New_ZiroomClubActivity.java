package com.ziroom.ziroomcustomer.contract;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.home.c;
import com.ziroom.ziroomcustomer.model.HomeIndex;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.MyListView;
import com.ziroom.ziroomcustomer.widget.MyListView.a;
import java.util.ArrayList;
import java.util.List;

public class New_ZiroomClubActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private MyListView a;
  private Context b;
  private ArrayList<HomeIndex> c = new ArrayList();
  private c d;
  private ImageView e;
  private LinearLayout f;
  private String g;
  private Handler r = new Handler()
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
        paramAnonymousMessage = new ArrayList();
        paramAnonymousMessage.clear();
        New_ZiroomClubActivity.g(New_ZiroomClubActivity.this).clear();
        New_ZiroomClubActivity.a(New_ZiroomClubActivity.this, (ArrayList)locall.getObject());
        if ((New_ZiroomClubActivity.g(New_ZiroomClubActivity.this) != null) && (New_ZiroomClubActivity.g(New_ZiroomClubActivity.this).size() > 0))
        {
          int i = 0;
          while (i < New_ZiroomClubActivity.g(New_ZiroomClubActivity.this).size())
          {
            paramAnonymousMessage.add(New_ZiroomClubActivity.g(New_ZiroomClubActivity.this).get(i));
            i += 1;
          }
          New_ZiroomClubActivity.d(New_ZiroomClubActivity.this).setData(paramAnonymousMessage);
          New_ZiroomClubActivity.d(New_ZiroomClubActivity.this).notifyDataSetChanged();
        }
      }
      for (;;)
      {
        New_ZiroomClubActivity.f(New_ZiroomClubActivity.this).onRefreshComplete();
        return;
        New_ZiroomClubActivity.this.showEmpty(New_ZiroomClubActivity.e(New_ZiroomClubActivity.this), "目前没有最新的活动");
        continue;
        New_ZiroomClubActivity.this.showToast(locall.getMessage());
      }
    }
  };
  
  private void a()
  {
    com.freelxl.baselibrary.d.a.get("http://contentful.ziroom.com/online/combine/f7177163c833dff4b38fc8d2872f1ec6.json").tag(this).enqueue(new com.ziroom.ziroomcustomer.findhouse.b.b(this, new com.ziroom.ziroomcustomer.findhouse.b.d(HomeIndex.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        New_ZiroomClubActivity.f(New_ZiroomClubActivity.this).onRefreshComplete();
      }
      
      public void onSuccess(int paramAnonymousInt, List paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        New_ZiroomClubActivity.a(New_ZiroomClubActivity.this, (ArrayList)paramAnonymousList);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          New_ZiroomClubActivity.d(New_ZiroomClubActivity.this).setData(paramAnonymousList);
          New_ZiroomClubActivity.d(New_ZiroomClubActivity.this).notifyDataSetChanged();
        }
        for (;;)
        {
          New_ZiroomClubActivity.f(New_ZiroomClubActivity.this).onRefreshComplete();
          return;
          New_ZiroomClubActivity.this.showEmpty(New_ZiroomClubActivity.e(New_ZiroomClubActivity.this), "目前没有最新的活动");
        }
      }
    });
  }
  
  public void initView()
  {
    this.f = ((LinearLayout)findViewById(2131697090));
    this.e = ((ImageView)findViewById(2131689492));
    this.a = ((MyListView)findViewById(2131697091));
    this.d = new c(this.b, this.c);
    this.a.setAdapter(this.d);
    this.e.setOnClickListener(this);
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
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904982);
    this.b = this;
    initView();
    if (!ah.checkNet(this.b))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 0);
      return;
    }
    this.g = getIntent().getStringExtra("isZryu");
    this.a.setonRefreshListener(new MyListView.a()
    {
      public void onRefresh()
      {
        if (!TextUtils.isEmpty(New_ZiroomClubActivity.a(New_ZiroomClubActivity.this)))
        {
          New_ZiroomClubActivity.b(New_ZiroomClubActivity.this);
          return;
        }
        com.ziroom.ziroomcustomer.e.d.getIndex(New_ZiroomClubActivity.c(New_ZiroomClubActivity.this));
      }
    });
    if (!TextUtils.isEmpty(this.g))
    {
      a();
      return;
    }
    com.ziroom.ziroomcustomer.e.d.getIndex(this.r);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/contract/New_ZiroomClubActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */