package com.ziroom.ziroomcustomer.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.c.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.adapter.m;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.a.c;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.model.SysMessageOnlineModel.DataBean;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.service.d;
import com.ziroom.ziroomcustomer.service.f;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysMessageActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  ViewStub a;
  BasicZiroomToolBar b;
  public UserInfo c;
  private XListView d;
  private m e;
  private List<b> f = new ArrayList();
  private List<List<b>> g = new ArrayList();
  private SysMessReceiver r;
  private long s;
  private int t = 1;
  private String u = SysMessageActivity.class.getSimpleName();
  
  private void a()
  {
    this.d.stopRefresh();
    this.d.stopLoadMore();
    this.d.setRefreshTime(new Date().toLocaleString());
  }
  
  private void a(List<b> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.g.clear();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        List localList = d(localb.k);
        paramList = localList;
        if (localList == null)
        {
          paramList = new ArrayList();
          this.g.add(paramList);
        }
        paramList.add(localb);
      }
      this.e.setData(this.g);
      this.e.notifyDataSetChanged();
    }
    refreshView();
  }
  
  private List<b> b(List<SysMessageOnlineModel.DataBean> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      if (i < paramList.size())
      {
        b localb = new b();
        localb.b = this.c.getUid();
        localb.d = ((SysMessageOnlineModel.DataBean)paramList.get(i)).content;
        localb.e = ((SysMessageOnlineModel.DataBean)paramList.get(i)).title;
        localb.f = ((SysMessageOnlineModel.DataBean)paramList.get(i)).extras;
        com.alibaba.fastjson.e locale = com.alibaba.fastjson.e.parseObject(localb.f);
        for (;;)
        {
          try
          {
            localb.g = locale.getString("msg_body_type");
            localb.h = locale.getString("msg_sub_type");
            if (!ae.isNull(locale.getString("msg_tag_type"))) {
              continue;
            }
            j = 0;
            localb.i = j;
            localb.j = locale.getString("msg_backup");
            localb.k = locale.getString("push_time");
            localb.c = locale.getString("msgId");
          }
          catch (Exception localException)
          {
            int j;
            continue;
          }
          localb.m = ((SysMessageOnlineModel.DataBean)paramList.get(i)).isRead;
          localb.o = ((SysMessageOnlineModel.DataBean)paramList.get(i)).sendTime;
          if (localb.m == 0) {
            localArrayList2.add(localb.c);
          }
          localArrayList1.add(localb);
          i += 1;
          break;
          j = Integer.parseInt(locale.getString("msg_tag_type"));
        }
      }
    }
    return localArrayList1;
  }
  
  private void b()
  {
    this.s = Calendar.getInstance().getTimeInMillis();
    if (this.c == null) {
      this.c = ApplicationEx.c.getUser();
    }
    if (this.c != null) {
      f.syncMessages(this, new com.freelxl.baselibrary.d.c.a(new l(SysMessageOnlineModel.DataBean.class, new c()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          SysMessageActivity.this.refreshView();
        }
        
        public void onSuccess(int paramAnonymousInt, List<SysMessageOnlineModel.DataBean> paramAnonymousList)
        {
          com.ziroom.ziroomcustomer.service.e.putLastSyncTime(SysMessageActivity.this, SysMessageActivity.a(SysMessageActivity.this));
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          {
            SysMessageActivity.b(SysMessageActivity.this, SysMessageActivity.a(SysMessageActivity.this, paramAnonymousList));
            return;
          }
          if (1 == SysMessageActivity.b(SysMessageActivity.this))
          {
            SysMessageActivity.this.refreshView();
            return;
          }
          af.showToast(SysMessageActivity.this, "已加载全部消息");
          SysMessageActivity.c(SysMessageActivity.this);
        }
      }, d.buildSyncMessages(this, d.a, ah.toMd5(this.c.getUid().getBytes()), this.t, 5));
    }
  }
  
  private void c(List<b> paramList)
  {
    u.e(this.u, "refreshUI datalist--" + paramList);
    this.f.addAll(paramList);
    a(this.f);
    this.t += 1;
  }
  
  private List<b> d(String paramString)
  {
    List localList;
    b localb;
    do
    {
      do
      {
        Iterator localIterator1 = this.g.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localList = (List)localIterator1.next();
          localIterator2 = localList.iterator();
        }
        localb = (b)localIterator2.next();
        if (!ae.isNull(localb.l)) {
          break;
        }
      } while (!ae.isNull(paramString));
      return localList;
    } while (!localb.l.equals(paramString));
    return localList;
    return null;
  }
  
  public void initData()
  {
    b();
  }
  
  public void initView()
  {
    this.d = ((XListView)findViewById(2131692600));
    this.a = ((ViewStub)findViewById(2131690894));
    this.b = ((BasicZiroomToolBar)findViewById(2131689787));
    this.e = new m(this, this.g);
    this.d.setAdapter(this.e);
    this.d.setPullLoadEnable(true);
    this.d.setPullRefreshEnable(false);
    this.d.setXListViewListener(this);
    this.c = ApplicationEx.c.getUser();
    registerMessageReceiver();
    JPushInterface.clearAllNotifications(this);
    this.b.setTitle("系统消息");
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView.getId();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903530);
    initView();
    initData();
  }
  
  public void onDestroy()
  {
    unregisterReceiver(this.r);
    super.onDestroy();
  }
  
  public void onLoadMore()
  {
    b();
  }
  
  public void onRefresh()
  {
    a();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void refreshView()
  {
    if (this.g.size() > 0)
    {
      this.a.setVisibility(8);
      this.d.setVisibility(0);
      return;
    }
    this.a.setVisibility(0);
    ((ImageView)findViewById(2131690082)).setImageResource(2130840091);
    ((TextView)findViewById(2131690822)).setText("暂无消息");
    this.d.setVisibility(8);
  }
  
  public void registerMessageReceiver()
  {
    this.r = new SysMessReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.setPriority(1000);
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.MESSAGE_RECEIVED_ACTION");
    registerReceiver(this.r, localIntentFilter);
  }
  
  public class SysMessReceiver
    extends BroadcastReceiver
  {
    public SysMessReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("com.ziroom.ziroomcustomer.MESSAGE_RECEIVED_ACTION".equals(paramIntent.getAction()))
      {
        SysMessageActivity.a(SysMessageActivity.this, 1);
        SysMessageActivity.d(SysMessageActivity.this).removeAll(SysMessageActivity.d(SysMessageActivity.this));
        SysMessageActivity.e(SysMessageActivity.this).removeAll(SysMessageActivity.e(SysMessageActivity.this));
        SysMessageActivity.f(SysMessageActivity.this);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/SysMessageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */