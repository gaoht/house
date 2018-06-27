package com.ziroom.ziroomcustomer.my;

import android.content.Context;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAppointingFragment
  extends BaseFragment
  implements MyAppointAdapter.b
{
  private Context a;
  private List<MyAppoint> b = new ArrayList();
  private HouseListXListView c;
  private ViewStub d;
  private View e;
  private int f = 0;
  private final String g = "您暂无约看哦~";
  private MyAppointAdapter h;
  
  public static MyAppointingFragment getInstance()
  {
    return new MyAppointingFragment();
  }
  
  public void loadData()
  {
    showProgress("");
    this.b.clear();
    this.f = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", ApplicationEx.c.getUserId(getActivity()));
    g.appendCommenParams(localHashMap);
    j.getMyAppointingList(this.a, new a(), localHashMap, false);
    localHashMap = new HashMap();
    localHashMap.put("uid", ApplicationEx.c.getUserId(getActivity()));
    localHashMap.put("state", Integer.valueOf(0));
    com.ziroom.ziroomcustomer.ziroomapartment.a.b.convertor(this.a, localHashMap);
    com.ziroom.ziroomcustomer.ziroomapartment.a.e.getZryuAppointList(this.a, new b(), localHashMap, false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.e = paramLayoutInflater.inflate(2130903889, paramViewGroup, false);
    this.d = ((ViewStub)this.e.findViewById(2131690620));
    this.c = ((HouseListXListView)this.e.findViewById(2131693946));
    this.c.setPullLoadEnable(false);
    this.c.setPullRefreshEnable(false);
    this.c.setHeaderDividersEnabled(false);
    this.a = getActivity();
    this.h = new MyAppointAdapter(this.a, this.b, null, 0);
    this.h.setDataRefresher(this);
    this.c.setAdapter(this.h);
    loadData();
    return this.e;
  }
  
  public void showError(String paramString)
  {
    this.d.setVisibility(0);
    ((TextView)this.e.findViewById(2131690822)).setText(paramString);
    ((LinearLayout)this.e.findViewById(2131694408)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
      }
    });
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      try
      {
        Object localObject = a.parseObject(paramString);
        String str = (String)((com.alibaba.fastjson.e)localObject).get("status");
        d.i("myappoint====", "====" + paramString);
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
      MyAppointingFragment.a(MyAppointingFragment.this);
      if (paramk.getSuccess().booleanValue())
      {
        if (MyAppointingFragment.b(MyAppointingFragment.this) % 2 == 0) {
          MyAppointingFragment.this.dismissProgress();
        }
        MyAppointingFragment.c(MyAppointingFragment.this).addAll((List)paramk.getObject());
        if (((MyAppointingFragment.c(MyAppointingFragment.this) == null) || (MyAppointingFragment.c(MyAppointingFragment.this).size() < 1)) && (MyAppointingFragment.b(MyAppointingFragment.this) % 2 == 0))
        {
          MyAppointingFragment.this.showError("您暂无约看哦~");
          return;
        }
        Collections.sort(MyAppointingFragment.c(MyAppointingFragment.this));
        MyAppointingFragment.d(MyAppointingFragment.this).notifyDataSetChanged();
        return;
      }
      MyAppointingFragment.e(MyAppointingFragment.this).setVisibility(0);
      MyAppointingFragment.this.showError("服务器异常，正在努力抢修中，请稍后再试!");
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
      MyAppointingFragment.a(MyAppointingFragment.this);
      if (paramk.getSuccess().booleanValue())
      {
        if (MyAppointingFragment.b(MyAppointingFragment.this) % 2 == 0) {
          MyAppointingFragment.this.dismissProgress();
        }
        MyAppointingFragment.c(MyAppointingFragment.this).addAll((List)paramk.getObject());
        if (((MyAppointingFragment.c(MyAppointingFragment.this) == null) || (MyAppointingFragment.c(MyAppointingFragment.this).size() < 1)) && (MyAppointingFragment.b(MyAppointingFragment.this) % 2 == 0))
        {
          MyAppointingFragment.this.showError("您暂无约看哦~");
          return;
        }
        Collections.sort(MyAppointingFragment.c(MyAppointingFragment.this));
        MyAppointingFragment.d(MyAppointingFragment.this).notifyDataSetChanged();
        return;
      }
      MyAppointingFragment.e(MyAppointingFragment.this).setVisibility(0);
      MyAppointingFragment.this.showError("服务器异常，正在努力抢修中，请稍后再试!");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyAppointingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */