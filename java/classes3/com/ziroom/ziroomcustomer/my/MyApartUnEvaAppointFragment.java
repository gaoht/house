package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
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
import com.ziroom.ziroomcustomer.model.MyAppoint;
import com.ziroom.ziroomcustomer.widget.HouseListXListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyApartUnEvaAppointFragment
  extends BaseFragment
  implements MyAppointAdapter.b
{
  private Context a;
  private List<MyAppoint> b = new ArrayList();
  private HouseListXListView c;
  private ViewStub d;
  private View e;
  private int f = 0;
  private final String g = "您暂无自如寓评价哦~";
  private MyAppointAdapter h;
  
  public static MyApartUnEvaAppointFragment getInstance()
  {
    return new MyApartUnEvaAppointFragment();
  }
  
  public void loadData()
  {
    showProgress("");
    this.b.clear();
    this.f = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", ApplicationEx.c.getUserId(getActivity()));
    com.ziroom.ziroomcustomer.ziroomapartment.a.b.convertor(this.a, localHashMap);
    com.ziroom.ziroomcustomer.ziroomapartment.a.e.getZryuUnEvaAppointList(this.a, new a(), localHashMap, false);
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
    this.h = new MyAppointAdapter(this.a, this.b, null, 1);
    this.h.setDataRefresher(this);
    this.c.setAdapter(this.h);
    loadData();
    return this.e;
  }
  
  public void showError(String paramString)
  {
    this.d.setVisibility(0);
    ((TextView)this.e.findViewById(2131690822)).setText(paramString);
    ((ImageView)this.e.findViewById(2131690082)).setImageResource(2130840088);
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
      MyApartUnEvaAppointFragment.a(MyApartUnEvaAppointFragment.this);
      if (paramk.getSuccess().booleanValue())
      {
        MyApartUnEvaAppointFragment.this.dismissProgress();
        MyApartUnEvaAppointFragment.b(MyApartUnEvaAppointFragment.this).addAll((List)paramk.getObject());
        if ((MyApartUnEvaAppointFragment.b(MyApartUnEvaAppointFragment.this) == null) || (MyApartUnEvaAppointFragment.b(MyApartUnEvaAppointFragment.this).size() < 1))
        {
          MyApartUnEvaAppointFragment.this.showError("您暂无自如寓评价哦~");
          MyApartUnEvaAppointFragment.c(MyApartUnEvaAppointFragment.this).setVisibility(8);
          return;
        }
        MyApartUnEvaAppointFragment.c(MyApartUnEvaAppointFragment.this).setVisibility(0);
        Collections.sort(MyApartUnEvaAppointFragment.b(MyApartUnEvaAppointFragment.this));
        MyApartUnEvaAppointFragment.d(MyApartUnEvaAppointFragment.this).notifyDataSetChanged();
        return;
      }
      MyApartUnEvaAppointFragment.e(MyApartUnEvaAppointFragment.this).setVisibility(0);
      MyApartUnEvaAppointFragment.c(MyApartUnEvaAppointFragment.this).setVisibility(8);
      MyApartUnEvaAppointFragment.this.showError("服务器异常，正在努力抢修中，请稍后再试!");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyApartUnEvaAppointFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */