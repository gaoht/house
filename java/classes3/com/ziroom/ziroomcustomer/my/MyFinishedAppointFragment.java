package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.adapter.MyAppointAdapter;
import com.ziroom.ziroomcustomer.adapter.MyAppointAdapter.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.MyAppoint;
import com.ziroom.ziroomcustomer.widget.HouseListXListView;
import com.ziroom.ziroomcustomer.widget.HouseListXListView.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFinishedAppointFragment
  extends BaseFragment
  implements MyAppointAdapter.b
{
  private View a;
  private HouseListXListView b;
  private MyAppointAdapter c;
  private List<MyAppoint> d = new ArrayList();
  private List<String> e;
  private ViewStub f;
  private final String g = "您暂无约看哦~";
  private final String h = "您暂无自如寓评价哦~";
  private Context i;
  private int j = 1;
  private int k = 999;
  private int l = 0;
  
  private void c()
  {
    this.c = new MyAppointAdapter(this.i, this.d, this.e, 1);
    this.c.setDataRefresher(this);
    this.b.setAdapter(this.c);
    this.b.setPullLoadEnable(false);
    this.b.setPullRefreshEnable(false);
    this.b.setXListViewListener(new HouseListXListView.a()
    {
      public void onLoadMore()
      {
        MyFinishedAppointFragment.a(MyFinishedAppointFragment.this);
        MyFinishedAppointFragment.this.loadData();
      }
      
      public void onRefresh() {}
    });
    loadData();
  }
  
  public static MyFinishedAppointFragment getInstance(ArrayList<String> paramArrayList)
  {
    MyFinishedAppointFragment localMyFinishedAppointFragment = new MyFinishedAppointFragment();
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("delList", paramArrayList);
    localMyFinishedAppointFragment.setArguments(localBundle);
    return localMyFinishedAppointFragment;
  }
  
  public void loadData()
  {
    showProgress("");
    this.d.clear();
    this.l = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", ApplicationEx.c.getUserId(getActivity()));
    localHashMap.put("pageNum", Integer.valueOf(this.j));
    localHashMap.put("pageSize", Integer.valueOf(this.k));
    g.appendCommenParams(localHashMap);
    j.getFinishedMyAppointList(this.i, new a(), localHashMap, false);
    localHashMap = new HashMap();
    localHashMap.put("uid", ApplicationEx.c.getUserId(getActivity()));
    localHashMap.put("state", Integer.valueOf(1));
    com.ziroom.ziroomcustomer.ziroomapartment.a.b.convertor(this.i, localHashMap);
    com.ziroom.ziroomcustomer.ziroomapartment.a.e.getZryuAppointList(this.i, new b(), localHashMap, false);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    loadData();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = paramLayoutInflater.inflate(2130903889, paramViewGroup, false);
    this.b = ((HouseListXListView)this.a.findViewById(2131693946));
    this.f = ((ViewStub)this.a.findViewById(2131690620));
    this.i = getActivity();
    this.e = getArguments().getStringArrayList("delList");
    c();
    return this.a;
  }
  
  public void reLoadData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", ApplicationEx.c.getUserId(getActivity()));
    localHashMap.put("pageNum", Integer.valueOf(1));
    localHashMap.put("pageSize", Integer.valueOf(this.k));
    g.appendCommenParams(localHashMap);
    j.getFinishedMyAppointList(this.i, new a(), localHashMap, true);
  }
  
  public void showError(String paramString)
  {
    this.f.setVisibility(0);
    ((TextView)this.a.findViewById(2131690822)).setText(paramString);
    ((LinearLayout)this.a.findViewById(2131694408)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
      }
    });
  }
  
  public void showSelection(boolean paramBoolean) {}
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      try
      {
        paramString = com.alibaba.fastjson.e.parseObject(paramString);
        if ("success".equals((String)paramString.get("status")))
        {
          paramk.setObject(com.alibaba.fastjson.e.parseArray(((com.alibaba.fastjson.b)paramString.get("data")).toJSONString(), MyAppoint.class));
          paramk.setSuccess(Boolean.valueOf(true));
          return;
        }
        paramk.setSuccess(Boolean.valueOf(false));
        String str = (String)paramString.get("error_message");
        paramk.setCode((String)paramString.get("error_code"));
        paramk.setMessage(str);
        return;
      }
      catch (Exception paramString)
      {
        paramk.setSuccess(Boolean.valueOf(false));
        paramk.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
      }
    }
    
    public void onSuccess(k paramk)
    {
      MyFinishedAppointFragment.b(MyFinishedAppointFragment.this);
      if (paramk.getSuccess().booleanValue())
      {
        MyFinishedAppointFragment.this.dismissProgress();
        paramk = (List)paramk.getObject();
        MyFinishedAppointFragment.c(MyFinishedAppointFragment.this).addAll(paramk);
        if ((MyFinishedAppointFragment.c(MyFinishedAppointFragment.this) == null) || (MyFinishedAppointFragment.c(MyFinishedAppointFragment.this).size() < 1))
        {
          MyFinishedAppointFragment.this.showError("您暂无约看哦~");
          MyFinishedAppointFragment.d(MyFinishedAppointFragment.this).setVisibility(8);
          return;
        }
        MyFinishedAppointFragment.d(MyFinishedAppointFragment.this).setVisibility(0);
        Collections.sort(MyFinishedAppointFragment.c(MyFinishedAppointFragment.this));
        paramk = new ArrayList(MyFinishedAppointFragment.c(MyFinishedAppointFragment.this));
        MyFinishedAppointFragment.e(MyFinishedAppointFragment.this).setList(paramk);
        MyFinishedAppointFragment.e(MyFinishedAppointFragment.this).notifyDataSetChanged();
        return;
      }
      paramk.getMessage();
      MyFinishedAppointFragment.d(MyFinishedAppointFragment.this).setVisibility(8);
      MyFinishedAppointFragment.this.showError("服务器异常，正在努力抢修中，请稍后再试!");
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk)
    {
      try
      {
        Object localObject = a.parseObject(paramString);
        String str = (String)((com.alibaba.fastjson.e)localObject).get("status");
        d.i("自如寓myappoint====", "====" + paramString);
        if ("success".equals(str))
        {
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(a.parseArray(((com.alibaba.fastjson.b)((com.alibaba.fastjson.e)localObject).get("data")).toJSONString(), MyAppoint.class));
          return;
        }
        paramk.setSuccess(Boolean.valueOf(false));
        paramString = (String)((com.alibaba.fastjson.e)localObject).get("error_code");
        localObject = (String)((com.alibaba.fastjson.e)localObject).get("error_message");
        paramk.setCode(paramString);
        paramk.setMessage((String)localObject);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramk.setSuccess(Boolean.valueOf(false));
        paramk.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
      }
    }
    
    public void onSuccess(k paramk)
    {
      MyFinishedAppointFragment.b(MyFinishedAppointFragment.this);
      if (paramk.getSuccess().booleanValue())
      {
        if (MyFinishedAppointFragment.f(MyFinishedAppointFragment.this) % 2 == 0) {
          MyFinishedAppointFragment.this.dismissProgress();
        }
        MyFinishedAppointFragment.c(MyFinishedAppointFragment.this).addAll((List)paramk.getObject());
        if (((MyFinishedAppointFragment.c(MyFinishedAppointFragment.this) == null) || (MyFinishedAppointFragment.c(MyFinishedAppointFragment.this).size() < 1)) && (MyFinishedAppointFragment.f(MyFinishedAppointFragment.this) % 2 == 0))
        {
          MyFinishedAppointFragment.this.showError("您暂无自如寓评价哦~");
          MyFinishedAppointFragment.d(MyFinishedAppointFragment.this).setVisibility(8);
          return;
        }
        MyFinishedAppointFragment.d(MyFinishedAppointFragment.this).setVisibility(0);
        Collections.sort(MyFinishedAppointFragment.c(MyFinishedAppointFragment.this));
        paramk = new ArrayList(MyFinishedAppointFragment.c(MyFinishedAppointFragment.this));
        MyFinishedAppointFragment.e(MyFinishedAppointFragment.this).setList(paramk);
        MyFinishedAppointFragment.e(MyFinishedAppointFragment.this).notifyDataSetChanged();
        return;
      }
      MyFinishedAppointFragment.g(MyFinishedAppointFragment.this).setVisibility(0);
      MyFinishedAppointFragment.d(MyFinishedAppointFragment.this).setVisibility(8);
      MyFinishedAppointFragment.this.showError("服务器异常，正在努力抢修中，请稍后再试!");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyFinishedAppointFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */