package com.ziroom.ziroomcustomer.newclean.periodclean.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.d.ar;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodCleanCancelOrderActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodCleanChangePhoneActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodGeneralDetailActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.NextOrderBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.OrderDetailBean;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.d;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.n;

public class PeriodcleanDetailFragment
  extends BaseFragment
{
  private View A;
  private LinearLayout B;
  private TextView C;
  private RelativeLayout D;
  private TextView E;
  private ImageView F;
  private PullToRefreshScrollView a;
  private View b;
  private SimpleDraweeView c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  private ImageView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private FlowLayout q;
  private TextView r;
  private TextView s;
  private TextView t;
  private LinearLayout u;
  private LinearLayout v;
  private TextView w;
  private String x;
  private Context y;
  private String z;
  
  private void a(View paramView)
  {
    this.a = ((PullToRefreshScrollView)paramView.findViewById(2131690468));
    this.b = paramView.findViewById(2131693967);
    this.c = ((SimpleDraweeView)paramView.findViewById(2131690047));
    this.d = ((TextView)paramView.findViewById(2131690371));
    this.e = ((TextView)paramView.findViewById(2131694530));
    this.f = ((ImageView)paramView.findViewById(2131690054));
    this.g = ((ImageView)paramView.findViewById(2131690055));
    this.h = ((ImageView)paramView.findViewById(2131690056));
    this.i = ((ImageView)paramView.findViewById(2131690057));
    this.j = ((ImageView)paramView.findViewById(2131690058));
    this.k = ((TextView)paramView.findViewById(2131690374));
    this.l = ((TextView)paramView.findViewById(2131690048));
    this.m = ((TextView)paramView.findViewById(2131694329));
    this.n = ((TextView)paramView.findViewById(2131690666));
    this.o = ((TextView)paramView.findViewById(2131694335));
    this.p = ((TextView)paramView.findViewById(2131690053));
    this.q = ((FlowLayout)paramView.findViewById(2131690332));
    this.r = ((TextView)paramView.findViewById(2131689837));
    this.s = ((TextView)paramView.findViewById(2131690305));
    this.t = ((TextView)paramView.findViewById(2131690307));
    this.u = ((LinearLayout)paramView.findViewById(2131694034));
    this.v = ((LinearLayout)paramView.findViewById(2131694334));
    this.w = ((TextView)paramView.findViewById(2131694332));
    this.A = paramView.findViewById(2131694336);
    this.B = ((LinearLayout)paramView.findViewById(2131694337));
    this.C = ((TextView)paramView.findViewById(2131692074));
    this.D = ((RelativeLayout)paramView.findViewById(2131694326));
    this.E = ((TextView)paramView.findViewById(2131691194));
    this.F = ((ImageView)paramView.findViewById(2131691574));
    this.u.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(PeriodcleanDetailFragment.b(PeriodcleanDetailFragment.this)).setTitle("提示").setBtnCancelText("我在看看").setBtnConfirmText("确认取消").setContent("周期预约取消后，系统将不再为您定期生成日常保洁订单").setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
          {
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2View = new Intent(PeriodcleanDetailFragment.this.getActivity(), PeriodCleanCancelOrderActivity.class);
              paramAnonymous2View.putExtra("orderCode", PeriodcleanDetailFragment.a(PeriodcleanDetailFragment.this));
              PeriodcleanDetailFragment.this.startActivityForResult(paramAnonymous2View, 17);
            }
          }
        }).build().show();
      }
    });
  }
  
  private void a(final ar paramar)
  {
    if (paramar == null) {
      return;
    }
    this.b.setVisibility(0);
    this.c.setController(com.freelxl.baselibrary.f.c.frescoController(paramar.getHeadPic()));
    this.d.setText(paramar.getName());
    this.e.setVisibility(8);
    if (!TextUtils.isEmpty(paramar.getScore()))
    {
      j.getStar((int)(Double.parseDouble(paramar.getScore()) + 0.5D), this.f, this.g, this.h, this.i, this.j);
      if (!TextUtils.isEmpty(paramar.getServeNum())) {
        break label164;
      }
      this.k.setVisibility(8);
    }
    for (;;)
    {
      this.l.setText("联系师傅");
      this.l.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ("0".equals(paramar.getCleanerIsVaild()))
          {
            j.toLeaveCleaner(PeriodcleanDetailFragment.this.getActivity(), paramar.getCleanerContactContent());
            return;
          }
          ah.callPhone(PeriodcleanDetailFragment.this.getActivity(), paramar.getPhone());
        }
      });
      return;
      j.getStar(5, this.f, this.g, this.h, this.i, this.j);
      break;
      label164:
      this.k.setVisibility(0);
      this.k.setText(paramar.getServeNum() + "单");
    }
  }
  
  private void a(OrderDetailBean paramOrderDetailBean)
  {
    if (TextUtils.isEmpty(paramOrderDetailBean.getEmployeeCode()))
    {
      this.b.setVisibility(8);
      this.m.setText(paramOrderDetailBean.getServiceTimeName() + "（" + paramOrderDetailBean.getCyclePlanName() + "）");
      this.w.setText(paramOrderDetailBean.getBurningTimeName());
      this.C.setText(paramOrderDetailBean.getFirstAppointmentTimeName());
      this.p.setText(paramOrderDetailBean.getOrderAddress());
      this.n.setText(paramOrderDetailBean.getConnectPhone());
      this.t.setText(paramOrderDetailBean.getCreateTimeName());
      this.s.setText(paramOrderDetailBean.getPlanOrderCode());
      if (!"1".equals(paramOrderDetailBean.getOrderStatus())) {
        break label265;
      }
      this.u.setVisibility(0);
      this.o.setVisibility(0);
      localObject = (LinearLayout.LayoutParams)this.n.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
      this.n.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.v.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(PeriodcleanDetailFragment.this.getActivity(), PeriodCleanChangePhoneActivity.class);
          paramAnonymousView.putExtra("phone", PeriodcleanDetailFragment.c(PeriodcleanDetailFragment.this).getText().toString());
          PeriodcleanDetailFragment.this.startActivityForResult(paramAnonymousView, 16);
        }
      });
      label196:
      paramOrderDetailBean = paramOrderDetailBean.getRemark();
      if (!TextUtils.isEmpty(paramOrderDetailBean)) {
        break label327;
      }
      this.q.setVisibility(8);
      this.r.setText("未填写特殊需求");
      this.B.setVisibility(8);
      this.A.setVisibility(8);
    }
    label265:
    label327:
    do
    {
      do
      {
        return;
        this.z = paramOrderDetailBean.getPlanOrderCode();
        b(paramOrderDetailBean.getEmployeeCode());
        break;
        localObject = (LinearLayout.LayoutParams)this.n.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).rightMargin = n.dip2px(this.y, 16.0F);
        this.n.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.u.setVisibility(8);
        this.o.setVisibility(8);
        this.v.setOnClickListener(null);
        break label196;
        this.q.removeAllViews();
        this.B.setVisibility(0);
        this.A.setVisibility(0);
        paramOrderDetailBean = j.getSpaceTar(paramOrderDetailBean, ",,");
      } while (paramOrderDetailBean.length <= 0);
      if (paramOrderDetailBean.length == 1)
      {
        this.q.setVisibility(8);
        this.r.setText(paramOrderDetailBean[0]);
      }
    } while (paramOrderDetailBean.length != 2);
    this.q.setVisibility(0);
    Object localObject = j.getSpaceTar(paramOrderDetailBean[1], ",");
    if (TextUtils.isEmpty(paramOrderDetailBean[0])) {
      this.r.setVisibility(8);
    }
    for (;;)
    {
      j.addDetailFlke(getActivity(), (String[])localObject, this.q);
      return;
      this.r.setText(paramOrderDetailBean[0]);
    }
  }
  
  private void a(String paramString, final OrderDetailBean paramOrderDetailBean)
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.nextOrderInfo(this.y, paramString, new d(this.y, new f(NextOrderBean.class))
    {
      public void onSuccess(int paramAnonymousInt, final NextOrderBean paramAnonymousNextOrderBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousNextOrderBean);
        if (paramAnonymousNextOrderBean != null)
        {
          PeriodcleanDetailFragment.f(PeriodcleanDetailFragment.this).setText(paramAnonymousNextOrderBean.getOrderDateStr());
          if (paramAnonymousNextOrderBean.getWhetherShow() == 1)
          {
            PeriodcleanDetailFragment.g(PeriodcleanDetailFragment.this).setVisibility(0);
            if (ae.notNull(paramAnonymousNextOrderBean.getUserOrderCode()))
            {
              PeriodcleanDetailFragment.g(PeriodcleanDetailFragment.this).setOnClickListener(new View.OnClickListener()
              {
                @Instrumented
                public void onClick(View paramAnonymous2View)
                {
                  VdsAgent.onClick(this, paramAnonymous2View);
                  paramAnonymous2View = new Intent(PeriodcleanDetailFragment.b(PeriodcleanDetailFragment.this), PeriodGeneralDetailActivity.class);
                  paramAnonymous2View.putExtra("cleanId", paramAnonymousNextOrderBean.getUserOrderCode());
                  paramAnonymous2View.putExtra("serviceInfoId", "2c9084454b7835b0014b7841269101a9");
                  paramAnonymous2View.putExtra("serviceInfoName", PeriodcleanDetailFragment.6.this.c.getProductName());
                  paramAnonymous2View.putExtra("orderState", PeriodcleanDetailFragment.6.this.c.getOrderStatus());
                  PeriodcleanDetailFragment.b(PeriodcleanDetailFragment.this).startActivity(paramAnonymous2View);
                }
              });
              PeriodcleanDetailFragment.h(PeriodcleanDetailFragment.this).setVisibility(0);
              return;
            }
            PeriodcleanDetailFragment.h(PeriodcleanDetailFragment.this).setVisibility(8);
            return;
          }
          PeriodcleanDetailFragment.g(PeriodcleanDetailFragment.this).setVisibility(8);
          return;
        }
        PeriodcleanDetailFragment.g(PeriodcleanDetailFragment.this).setVisibility(8);
      }
    });
  }
  
  private void b(String paramString)
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodGeneralCleanerInfo(this.y, paramString, new d(this.y, new f(ar.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
      }
      
      public void onSuccess(int paramAnonymousInt, ar paramAnonymousar)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousar);
        if (paramAnonymousar != null) {
          PeriodcleanDetailFragment.a(PeriodcleanDetailFragment.this, paramAnonymousar);
        }
      }
    });
  }
  
  private void c()
  {
    this.x = getArguments().getString("orderId");
    d();
    this.a.setMode(PullToRefreshBase.b.b);
    this.a.setOnRefreshListener(new PullToRefreshBase.d()
    {
      public void onRefresh(PullToRefreshBase<ScrollView> paramAnonymousPullToRefreshBase)
      {
        org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("period_button_refresh", null));
        PeriodcleanDetailFragment.d(PeriodcleanDetailFragment.this);
      }
    });
  }
  
  private void d()
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodCleanOrderDetail(this.y, this.x, new d(this.y, new f(OrderDetailBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        PeriodcleanDetailFragment.e(PeriodcleanDetailFragment.this);
      }
      
      public void onSuccess(int paramAnonymousInt, OrderDetailBean paramAnonymousOrderDetailBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousOrderDetailBean);
        PeriodcleanDetailFragment.a(PeriodcleanDetailFragment.this, paramAnonymousOrderDetailBean);
        PeriodcleanDetailFragment.a(PeriodcleanDetailFragment.this, paramAnonymousOrderDetailBean.getPlanOrderCode(), paramAnonymousOrderDetailBean);
        PeriodcleanDetailFragment.e(PeriodcleanDetailFragment.this);
      }
    });
  }
  
  private void e()
  {
    if ((this.a != null) && (this.a.isRefreshing())) {
      this.a.onRefreshComplete();
    }
  }
  
  public static PeriodcleanDetailFragment getInstance(String paramString)
  {
    PeriodcleanDetailFragment localPeriodcleanDetailFragment = new PeriodcleanDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("orderId", paramString);
    localPeriodcleanDetailFragment.setArguments(localBundle);
    return localPeriodcleanDetailFragment;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt2)
    {
    default: 
    case 16: 
      do
      {
        return;
      } while (paramIntent == null);
      paramIntent = paramIntent.getStringExtra("phone");
      com.ziroom.ziroomcustomer.newclean.periodclean.a.changePhoneByOrderid(this.y, this.x, paramIntent, new d(this.y, new f(Object.class))
      {
        public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousObject);
          PeriodcleanDetailFragment.c(PeriodcleanDetailFragment.this).setText(paramIntent);
        }
      });
      return;
    }
    d();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903976, paramViewGroup, false);
    this.y = getActivity();
    a(paramLayoutInflater);
    c();
    return paramLayoutInflater;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/fragment/PeriodcleanDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */