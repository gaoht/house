package com.ziroom.ziroomcustomer.minsu.landlord.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.LoginActivity;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.minsu.adapter.o;
import com.ziroom.ziroomcustomer.minsu.adapter.o.a;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLHouseBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLHouseListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLHouseListBean.Data;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLHouseListBean.Data.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLHouseTodayHintBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLHouseTodayHintBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.l;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CertificationBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CertificationBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.qualification.QApersonalActivity;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.List;

public class MinsuLLHouseFragment
  extends BaseFragment
{
  public String a;
  public String b;
  public int c;
  public int d;
  private int e = 1;
  private int f = 8;
  private View g;
  private CommonTitle h;
  private XListView i;
  private o j;
  private List<MinsuLLHouseListBean.Data.DataBean> k = new ArrayList();
  private boolean l = true;
  private TextView m;
  private LinearLayout n;
  private LinearLayout o;
  private boolean p = true;
  private ImageView q;
  private TextView r;
  private DeleteRoomfidRece s;
  
  private void c()
  {
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        com.ziroom.ziroomcustomer.minsu.e.a.setHouseTodayDiscountHint(MinsuLLHouseFragment.this.getActivity(), true, new s(MinsuLLHouseFragment.this.getActivity(), new r(MinsuLLHouseTodayHintBean.class))
        {
          public void onFailure(Throwable paramAnonymous2Throwable)
          {
            super.onFailure(paramAnonymous2Throwable);
            StringBuilder localStringBuilder = new StringBuilder().append(" onFailure ");
            if (paramAnonymous2Throwable == null) {}
            for (paramAnonymous2Throwable = " e = null ";; paramAnonymous2Throwable = " e.msg = " + paramAnonymous2Throwable.getMessage())
            {
              l.e("error", paramAnonymous2Throwable);
              return;
            }
          }
          
          public void onSuccess(int paramAnonymous2Int, MinsuLLHouseTodayHintBean paramAnonymous2MinsuLLHouseTodayHintBean)
          {
            super.onSuccess(paramAnonymous2Int, paramAnonymous2MinsuLLHouseTodayHintBean);
            if ((paramAnonymous2MinsuLLHouseTodayHintBean != null) && (paramAnonymous2MinsuLLHouseTodayHintBean.getData() != null)) {
              MinsuLLHouseFragment.a(MinsuLLHouseFragment.this).setHouseTodayHint(paramAnonymous2MinsuLLHouseTodayHintBean.getData().getSetHint(), paramAnonymous2MinsuLLHouseTodayHintBean.getData().getSaveHint());
            }
          }
        });
      }
    }, 300L);
    registerRece();
  }
  
  private void d()
  {
    this.n = ((LinearLayout)this.g.findViewById(2131691469));
    this.o = ((LinearLayout)this.g.findViewById(2131691471));
    this.q = ((ImageView)this.g.findViewById(2131691470));
    this.n.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.q.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ad.saveMinsuLandReleaseHint(MinsuLLHouseFragment.this.getActivity(), Boolean.valueOf(false));
        MinsuLLHouseFragment.b(MinsuLLHouseFragment.this).setVisibility(8);
      }
    });
    int i1 = ac.getScreenWidth(getActivity());
    this.r = ((TextView)this.g.findViewById(2131691472));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, ab.dp2px(getActivity(), 48.0F));
    localLayoutParams.setMargins(ab.dp2px(getActivity(), 18.0F), (int)(i1 * 1.24D), ab.dp2px(getActivity(), 18.0F), 0);
    this.r.setLayoutParams(localLayoutParams);
    this.r.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ad.saveMinsuLandReleaseHint(MinsuLLHouseFragment.this.getActivity(), Boolean.valueOf(false));
        MinsuLLHouseFragment.b(MinsuLLHouseFragment.this).setVisibility(8);
        MinsuLLHouseFragment.this.getCertification();
      }
    });
    this.m = ((TextView)this.g.findViewById(2131690175));
    this.i = ((XListView)this.g.findViewById(2131690955));
    this.i.setPullLoadEnable(true);
    this.i.setPullRefreshEnable(true);
    this.i.setXListViewListener(new XListView.a()
    {
      public void onLoadMore()
      {
        MinsuLLHouseFragment.d(MinsuLLHouseFragment.this);
      }
      
      public void onRefresh()
      {
        MinsuLLHouseFragment.c(MinsuLLHouseFragment.this);
      }
    });
    this.j = new o(getActivity(), this.k);
    this.i.setAdapter(this.j);
    this.j.setOnClickListener(new o.a()
    {
      public void onItemClick(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        MinsuLLHouseFragment.a(MinsuLLHouseFragment.this, paramAnonymousBoolean);
        MinsuLLHouseFragment.this.a = paramAnonymousString1;
        MinsuLLHouseFragment.this.b = paramAnonymousString2;
        MinsuLLHouseFragment.this.c = paramAnonymousInt1;
        MinsuLLHouseFragment.this.d = paramAnonymousInt2;
      }
    });
    this.i.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (MinsuLLHouseListBean.Data.DataBean)MinsuLLHouseFragment.e(MinsuLLHouseFragment.this).getItemAtPosition(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          if (paramAnonymousAdapterView.isIssue != 1) {
            break label115;
          }
          k.toReleaseManager(MinsuLLHouseFragment.this.getActivity(), paramAnonymousAdapterView.houseBaseFid, paramAnonymousAdapterView.houseRoomFid, paramAnonymousAdapterView.rentWay, paramAnonymousAdapterView.roomType);
          MinsuLLHouseFragment.a(MinsuLLHouseFragment.this, false);
        }
        for (;;)
        {
          MinsuLLHouseFragment.this.a = paramAnonymousAdapterView.houseBaseFid;
          MinsuLLHouseFragment.this.b = paramAnonymousAdapterView.houseRoomFid;
          MinsuLLHouseFragment.this.c = paramAnonymousAdapterView.rentWay;
          MinsuLLHouseFragment.this.d = (paramAnonymousInt - 1);
          return;
          label115:
          MinsuLLHouseFragment.a(MinsuLLHouseFragment.this, true);
          k.toHouseRelease(MinsuLLHouseFragment.this.getActivity(), paramAnonymousAdapterView.houseBaseFid, paramAnonymousAdapterView.houseRoomFid, paramAnonymousAdapterView.rentWay, paramAnonymousAdapterView.operateSeq, null, 171, paramAnonymousAdapterView.roomType);
        }
      }
    });
    this.i.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = (MinsuLLHouseListBean.Data.DataBean)MinsuLLHouseFragment.e(MinsuLLHouseFragment.this).getItemAtPosition(paramAnonymousInt);
        if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.isNoDel == 1)) {
          d.newBuilder(MinsuLLHouseFragment.this.getActivity()).setOnConfirmClickListener(new d.b()
          {
            public void onLeftClick(View paramAnonymous2View) {}
            
            public void onRightClick(View paramAnonymous2View)
            {
              MinsuLLHouseFragment.this.a = paramAnonymousAdapterView.houseBaseFid;
              MinsuLLHouseFragment.this.b = paramAnonymousAdapterView.houseRoomFid;
              MinsuLLHouseFragment.this.c = paramAnonymousAdapterView.rentWay;
              MinsuLLHouseFragment.this.d = (paramAnonymousInt - 1);
              MinsuLLHouseFragment.f(MinsuLLHouseFragment.this);
            }
          }).setContent("删除房源后无法恢复，请确认是否继续删除？").setButtonText("取消", "确定").show();
        }
        return true;
      }
    });
  }
  
  private void e()
  {
    this.h = ((CommonTitle)this.g.findViewById(2131691272));
    this.h.setMiddleText(getString(2131297098));
    this.h.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLLHouseFragment.this.getActivity().finish();
      }
    });
    this.h.showRightText(true, getString(2131297129));
    this.h.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLLHouseFragment.this.getCertification();
      }
    });
  }
  
  private void f()
  {
    this.e = 1;
    com.ziroom.ziroomcustomer.minsu.e.a.houseRoomListLL(getActivity(), this.e, this.f, true, new s(getActivity(), new r(MinsuLLHouseListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        StringBuilder localStringBuilder = new StringBuilder().append(" onFailure ");
        if (paramAnonymousThrowable == null) {}
        for (paramAnonymousThrowable = " e = null ";; paramAnonymousThrowable = " e.msg = " + paramAnonymousThrowable.getMessage())
        {
          l.e("error", paramAnonymousThrowable);
          MinsuLLHouseFragment.i(MinsuLLHouseFragment.this);
          return;
        }
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuLLHouseListBean paramAnonymousMinsuLLHouseListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuLLHouseListBean);
        if (!paramAnonymousMinsuLLHouseListBean.checkSuccess(MinsuLLHouseFragment.this.getActivity())) {
          return;
        }
        if ((paramAnonymousMinsuLLHouseListBean != null) && (paramAnonymousMinsuLLHouseListBean.data != null) && (paramAnonymousMinsuLLHouseListBean.data.list.size() > 0))
        {
          MinsuLLHouseFragment.g(MinsuLLHouseFragment.this).clear();
          MinsuLLHouseFragment.g(MinsuLLHouseFragment.this).addAll(paramAnonymousMinsuLLHouseListBean.data.list);
          MinsuLLHouseFragment.e(MinsuLLHouseFragment.this).setVisibility(0);
          MinsuLLHouseFragment.h(MinsuLLHouseFragment.this).setVisibility(8);
        }
        for (;;)
        {
          MinsuLLHouseFragment.a(MinsuLLHouseFragment.this).notifyDataSetChanged();
          MinsuLLHouseFragment.i(MinsuLLHouseFragment.this);
          return;
          MinsuLLHouseFragment.e(MinsuLLHouseFragment.this).setVisibility(8);
          MinsuLLHouseFragment.h(MinsuLLHouseFragment.this).setText(MinsuLLHouseFragment.this.getString(2131297283));
          MinsuLLHouseFragment.h(MinsuLLHouseFragment.this).setVisibility(0);
        }
      }
    });
  }
  
  private void g()
  {
    this.e += 1;
    com.ziroom.ziroomcustomer.minsu.e.a.houseRoomListLL(getActivity(), this.e, this.f, true, new com.freelxl.baselibrary.d.c.a(new r(MinsuLLHouseListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder().append(" onFailure ");
        if (paramAnonymousThrowable == null) {}
        for (paramAnonymousThrowable = " e = null ";; paramAnonymousThrowable = " e.msg = " + paramAnonymousThrowable.getMessage())
        {
          l.e("error", paramAnonymousThrowable);
          MinsuLLHouseFragment.i(MinsuLLHouseFragment.this);
          return;
        }
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuLLHouseListBean paramAnonymousMinsuLLHouseListBean)
      {
        l.e("error", " code = " + paramAnonymousInt);
        if ((paramAnonymousMinsuLLHouseListBean != null) && (paramAnonymousMinsuLLHouseListBean.data != null) && (paramAnonymousMinsuLLHouseListBean.data.list.size() > 0)) {
          MinsuLLHouseFragment.g(MinsuLLHouseFragment.this).addAll(paramAnonymousMinsuLLHouseListBean.data.list);
        }
        for (;;)
        {
          MinsuLLHouseFragment.a(MinsuLLHouseFragment.this).notifyDataSetChanged();
          MinsuLLHouseFragment.i(MinsuLLHouseFragment.this);
          return;
          g.textToast(MinsuLLHouseFragment.this.getActivity(), MinsuLLHouseFragment.this.getString(2131297294));
        }
      }
    });
  }
  
  private void h()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.deleteHouse(getActivity(), this.a, this.b, this.c, false, new s(getActivity(), new r(MinsuLLHouseBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        StringBuilder localStringBuilder = new StringBuilder().append(" onFailure ");
        if (paramAnonymousThrowable == null) {}
        for (paramAnonymousThrowable = " e = null ";; paramAnonymousThrowable = " e.msg = " + paramAnonymousThrowable.getMessage())
        {
          l.e("error", paramAnonymousThrowable);
          return;
        }
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuLLHouseBean paramAnonymousMinsuLLHouseBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuLLHouseBean);
        if ((paramAnonymousMinsuLLHouseBean == null) || (!paramAnonymousMinsuLLHouseBean.checkSuccess(MinsuLLHouseFragment.this.getActivity()))) {}
        do
        {
          return;
          MinsuLLHouseFragment.g(MinsuLLHouseFragment.this).remove(MinsuLLHouseFragment.this.d);
          MinsuLLHouseFragment.a(MinsuLLHouseFragment.this).notifyDataSetChanged();
        } while (MinsuLLHouseFragment.g(MinsuLLHouseFragment.this).size() >= 3);
        MinsuLLHouseFragment.c(MinsuLLHouseFragment.this);
      }
    });
  }
  
  private void i()
  {
    g();
  }
  
  private void j()
  {
    this.i.stopRefresh();
    this.i.stopLoadMore();
    this.i.setRefreshTime("刚刚");
  }
  
  public void checkReleaseHint()
  {
    this.p = ad.getMinsuLandReleaseHint(getActivity()).booleanValue();
    if (this.p)
    {
      this.n.setVisibility(0);
      return;
    }
    this.n.setVisibility(8);
  }
  
  public void getCertification()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getCertification(getActivity(), new s(getActivity(), new r(CertificationBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        StringBuilder localStringBuilder = new StringBuilder().append(" onFailure ");
        if (paramAnonymousThrowable == null) {}
        for (paramAnonymousThrowable = " e = null ";; paramAnonymousThrowable = " e.msg = " + paramAnonymousThrowable.getMessage())
        {
          l.e("error", paramAnonymousThrowable);
          g.textToast(MinsuLLHouseFragment.this.getActivity(), "获取认证信息失败，请稍后再试");
          return;
        }
      }
      
      public void onSuccess(int paramAnonymousInt, CertificationBean paramAnonymousCertificationBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousCertificationBean);
        if (!paramAnonymousCertificationBean.checkSuccess(MinsuLLHouseFragment.this.getActivity()))
        {
          g.textToast(MinsuLLHouseFragment.this.getActivity(), "获取认证信息失败，请稍后再试");
          return;
        }
        if ((paramAnonymousCertificationBean != null) && (paramAnonymousCertificationBean.getData() != null))
        {
          if ("1".equals(paramAnonymousCertificationBean.getData().getFullFlag()))
          {
            k.toHouseRelease(MinsuLLHouseFragment.this.getActivity());
            return;
          }
          Intent localIntent = new Intent(MinsuLLHouseFragment.this.getActivity(), QApersonalActivity.class);
          localIntent.putExtra("isCantactAuth", paramAnonymousCertificationBean.getData().getIsContactAuth());
          localIntent.putExtra("isIdentityAuth", paramAnonymousCertificationBean.getData().getIsIdentityAuth());
          localIntent.putExtra("isFinishHead", paramAnonymousCertificationBean.getData().getIsFinishHead());
          MinsuLLHouseFragment.this.startActivity(localIntent);
          return;
        }
        g.textToast(MinsuLLHouseFragment.this.getActivity(), "获取认证信息失败，请稍后再试");
      }
    });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (ApplicationEx.c.isLoginState());
        getActivity().finish();
        return;
      } while (paramInt2 != -1);
      paramIntent = paramIntent.getStringExtra("houseBaseFid");
    } while (TextUtils.isEmpty(paramIntent));
    k.toAppointmentPhotographer(getActivity(), paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.g = paramLayoutInflater.inflate(2130903952, paramViewGroup, false);
    return this.g;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unregisterRece();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.l)
    {
      f();
      checkReleaseHint();
      return;
    }
    this.l = true;
    updateSingleItem(this.a, this.b, this.c, this.d);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (ApplicationEx.c.isLoginState()) {}
    for (;;)
    {
      d();
      e();
      c();
      return;
      paramView = new Intent();
      paramView.setClass(getActivity(), LoginActivity.class);
      startActivityForResult(paramView, 121);
    }
  }
  
  public void onVisibilityChangedToUser(boolean paramBoolean)
  {
    super.onVisibilityChangedToUser(paramBoolean);
    if (paramBoolean)
    {
      if (this.l)
      {
        f();
        checkReleaseHint();
      }
    }
    else {
      return;
    }
    this.l = true;
    updateSingleItem(this.a, this.b, this.c, this.d);
  }
  
  public void registerRece()
  {
    this.s = new DeleteRoomfidRece();
    IntentFilter localIntentFilter = new IntentFilter(getString(2131296570));
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.s, localIntentFilter);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
  }
  
  public void unregisterRece()
  {
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.s);
  }
  
  public void updateSingleItem(String paramString1, String paramString2, int paramInt1, final int paramInt2)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getHouseRoom(getActivity(), paramString1, paramString2, paramInt1, false, new s(getActivity(), new r(MinsuLLHouseBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        StringBuilder localStringBuilder = new StringBuilder().append(" onFailure ");
        if (paramAnonymousThrowable == null) {}
        for (paramAnonymousThrowable = " e = null ";; paramAnonymousThrowable = " e.msg = " + paramAnonymousThrowable.getMessage())
        {
          l.e("error", paramAnonymousThrowable);
          return;
        }
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuLLHouseBean paramAnonymousMinsuLLHouseBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuLLHouseBean);
        if ((paramAnonymousMinsuLLHouseBean == null) || (!paramAnonymousMinsuLLHouseBean.checkSuccess(MinsuLLHouseFragment.this.getActivity()))) {
          return;
        }
        MinsuLLHouseFragment.g(MinsuLLHouseFragment.this).set(paramInt2, paramAnonymousMinsuLLHouseBean.getData());
        MinsuLLHouseFragment.a(MinsuLLHouseFragment.this).notifyDataSetChanged();
      }
    });
  }
  
  public class DeleteRoomfidRece
    extends BroadcastReceiver
  {
    public DeleteRoomfidRece() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      MinsuLLHouseFragment.this.b = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/fragment/MinsuLLHouseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */