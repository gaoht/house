package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.SysMessageActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.a.c;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.service.f;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.SwipeListView;
import java.util.ArrayList;
import java.util.List;

public class m
  extends BaseAdapter
{
  private String a = "SysMessageAdapter";
  private Context b;
  private List<List<com.ziroom.commonlibrary.c.b>> c;
  
  public m(Context paramContext, List<List<com.ziroom.commonlibrary.c.b>> paramList)
  {
    this.b = paramContext;
    setData(paramList);
  }
  
  private void a(com.ziroom.commonlibrary.c.b paramb)
  {
    int i;
    if ((!ae.isNull(paramb.f)) && (!ae.isNull(com.alibaba.fastjson.a.parseObject(paramb.f).getString("msg_has_response")))) {
      i = 0;
    }
    try
    {
      int j = Integer.parseInt(com.alibaba.fastjson.a.parseObject(paramb.f).getString("msg_has_response"));
      i = j;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (i == 0) {
      return;
    }
    if ("minsu_notify".equals(paramb.g))
    {
      com.ziroom.ziroomcustomer.minsu.d.d.getInstance(this.b).link(paramb);
      return;
    }
    if (com.ziroom.commonlibrary.g.a.getInstance().getjPushListener() != null)
    {
      com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().onClickNotiInSysMess(this.b, paramb);
      return;
    }
    com.ziroom.commonlibrary.g.a.getInstance().setjPushListener(new com.ziroom.ziroomcustomer.service.b());
    com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().onClickNotiInSysMess(this.b, paramb);
  }
  
  private void a(String paramString, List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      f.deleteMsgs(this.b, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.m(e.class, new c()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          u.d("OKHttp", "Push deleteMsgs failure,detail as below:" + paramAnonymousThrowable.getMessage());
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          u.d("OKHttp", "Push deleteMsgs success,detail as below");
          if (paramAnonymouse != null) {
            u.d("OKHttp", "Push deleteMsgs resp: : " + paramAnonymouse.toString());
          }
        }
      }, com.ziroom.ziroomcustomer.service.d.buildDeleteMsgs(this.b, paramString, paramList));
    }
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2130904564, null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131695774));
      paramViewGroup.b = ((SwipeListView)paramView.findViewById(2131695214));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      final List localList = (List)this.c.get(paramInt);
      final com.ziroom.commonlibrary.c.b localb;
      if (localList.size() > 0) {
        localb = (com.ziroom.commonlibrary.c.b)localList.get(0);
      }
      try
      {
        if (!ae.isNull(localb.o)) {
          paramViewGroup.a.setText(com.ziroom.ziroomcustomer.util.m.TimeL2S(com.ziroom.ziroomcustomer.util.m.TimeS2L(localb.o, com.ziroom.ziroomcustomer.util.m.c)));
        }
        for (;;)
        {
          n localn = new n(this.b, localList, paramViewGroup.b.getRightViewWidth());
          localn.setOnRightItemClickListener(new n.b()
          {
            public void onRightItemClick(View paramAnonymousView, int paramAnonymousInt)
            {
              if (paramAnonymousInt < localList.size())
              {
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(localb.c);
                String str = "";
                paramAnonymousView = str;
                if (ApplicationEx.c.getUser() != null)
                {
                  paramAnonymousView = str;
                  if (!ae.isNull(ApplicationEx.c.getUser().getUid())) {
                    paramAnonymousView = ah.toMd5(ApplicationEx.c.getUser().getUid().getBytes());
                  }
                }
                m.a(m.this, paramAnonymousView, localArrayList);
                localList.remove(paramAnonymousInt);
              }
              if (localList.size() == 0) {
                m.a(m.this).remove(paramInt);
              }
              m.this.notifyDataSetChanged();
              if ((m.b(m.this) instanceof SysMessageActivity)) {
                ((SysMessageActivity)m.b(m.this)).refreshView();
              }
            }
          });
          paramViewGroup.b.setAdapter(localn);
          paramViewGroup.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            @Instrumented
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
              m.a(m.this, localb);
            }
          });
          return paramView;
          paramViewGroup = (a)paramView.getTag();
          break;
          paramViewGroup.a.setText(com.ziroom.ziroomcustomer.util.m.TimeL2S(Long.parseLong(localb.l)));
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public void setData(List<List<com.ziroom.commonlibrary.c.b>> paramList)
  {
    this.c = paramList;
  }
  
  private class a
  {
    TextView a;
    SwipeListView b;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */