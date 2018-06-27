package com.ziroom.ziroomcustomer.bestgoods.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.e.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.bestgoods.a.ai;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinBackChangeGoodsInfoActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinBackOrderDetailsActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinEvaluationActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinOrderDetailsActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinOrderDetailsActivity.a;
import com.ziroom.ziroomcustomer.bestgoods.model.ae;
import com.ziroom.ziroomcustomer.bestgoods.model.ao;
import com.ziroom.ziroomcustomer.bestgoods.model.ao.a;
import com.ziroom.ziroomcustomer.bestgoods.model.ao.b;
import com.ziroom.ziroomcustomer.bestgoods.model.ao.e;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.newServiceList.model.ap;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.d;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YouPinOrderDetailFragment
  extends BaseFragment
  implements View.OnClickListener, YouPinOrderDetailsActivity.a
{
  private TextView A;
  private RelativeLayout B;
  private RelativeLayout C;
  private TextView D;
  private RelativeLayout E;
  private Button F;
  private Button G;
  private Button H;
  private Button I;
  private String J;
  private List<ao.a> K;
  private d L;
  private int M;
  private ao N;
  private String O;
  private BroadcastReceiver P = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("com.ziroom.ziroomcustomer.activity_1"))
      {
        ((YouPinOrderDetailsActivity)YouPinOrderDetailFragment.this.getActivity()).getServerData();
        new Thread()
        {
          public void run()
          {
            super.run();
            try
            {
              Thread.sleep(3000L);
              org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("refresh_service_order_list", null));
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }.start();
        return;
      }
      YouPinOrderDetailFragment.this.showToast("支付失败，请重试");
    }
  };
  private String a;
  private String b;
  private YouPinOrderDetailsActivity c;
  private PullToRefreshScrollView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private ListViewForScrollView h;
  private LinearLayout i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private LinearLayout n;
  private TextView o;
  private TextView p;
  private TextView q;
  private TextView r;
  private View s;
  private Button t;
  private LinearLayout u;
  private TextView v;
  private TextView w;
  private TextView x;
  private View y;
  private TextView z;
  
  private void a(View paramView)
  {
    this.d = ((PullToRefreshScrollView)paramView.findViewById(2131690468));
    this.e = ((TextView)paramView.findViewById(2131694379));
    this.f = ((TextView)paramView.findViewById(2131694380));
    this.g = ((TextView)paramView.findViewById(2131694381));
    this.h = ((ListViewForScrollView)paramView.findViewById(2131694382));
    this.i = ((LinearLayout)paramView.findViewById(2131694383));
    this.j = ((TextView)paramView.findViewById(2131696537));
    this.k = ((TextView)paramView.findViewById(2131696539));
    this.l = ((TextView)paramView.findViewById(2131696541));
    this.m = ((TextView)paramView.findViewById(2131696543));
    this.n = ((LinearLayout)paramView.findViewById(2131694384));
    this.o = ((TextView)paramView.findViewById(2131696511));
    this.p = ((TextView)paramView.findViewById(2131696513));
    this.q = ((TextView)paramView.findViewById(2131696515));
    this.r = ((TextView)paramView.findViewById(2131696518));
    this.t = ((Button)paramView.findViewById(2131696519));
    this.s = paramView.findViewById(2131694385);
    this.u = ((LinearLayout)paramView.findViewById(2131694386));
    this.v = ((TextView)paramView.findViewById(2131696545));
    this.w = ((TextView)paramView.findViewById(2131696547));
    this.x = ((TextView)paramView.findViewById(2131696550));
    this.B = ((RelativeLayout)paramView.findViewById(2131696551));
    this.A = ((TextView)paramView.findViewById(2131696552));
    this.z = ((TextView)paramView.findViewById(2131696553));
    this.y = paramView.findViewById(2131694387);
    this.C = ((RelativeLayout)paramView.findViewById(2131694388));
    this.D = ((TextView)paramView.findViewById(2131694389));
    this.E = ((RelativeLayout)paramView.findViewById(2131694390));
    this.F = ((Button)paramView.findViewById(2131694391));
    this.G = ((Button)paramView.findViewById(2131694393));
    this.H = ((Button)paramView.findViewById(2131694392));
    this.I = ((Button)paramView.findViewById(2131690461));
  }
  
  private void a(ap paramap)
  {
    if (TextUtils.isEmpty(paramap.getPartnerid()))
    {
      this.L.doStartWXPay(this.c, paramap.getTrans_id(), paramap.getMerorder_id(), paramap.getTimestamp(), paramap.get_package(), paramap.getSign(), "1248814701");
      return;
    }
    this.L.doStartWXPay(this.c, paramap.getTrans_id(), paramap.getMerorder_id(), paramap.getTimestamp(), paramap.get_package(), paramap.getSign(), paramap.getPartnerid());
  }
  
  private void c()
  {
    this.t.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.I.setOnClickListener(this);
  }
  
  private void d()
  {
    this.d.setMode(PullToRefreshBase.b.b);
    this.d.setOnRefreshListener(new PullToRefreshBase.d()
    {
      public void onRefresh(PullToRefreshBase<ScrollView> paramAnonymousPullToRefreshBase)
      {
        YouPinOrderDetailFragment.a(YouPinOrderDetailFragment.this).getServerData();
      }
    });
  }
  
  private void e()
  {
    if ((this.d != null) && (this.d.isRefreshing())) {
      this.d.onRefreshComplete();
    }
  }
  
  private void f()
  {
    if (("mounted".equals(Environment.getExternalStorageState())) && (this.c.getExternalFilesDir(null) != null))
    {
      final File localFile = new File(Environment.getExternalStorageDirectory() + "/" + this.c.getPackageName());
      if (!localFile.mkdir()) {
        localFile.mkdirs();
      }
      localFile = new File(localFile, "invoice.pdf");
      com.ziroom.ziroomcustomer.bestgoods.c.b.download(this.c, localFile, this.J, new com.ziroom.ziroomcustomer.bestgoods.b.a()
      {
        public void callback(Boolean paramAnonymousBoolean)
        {
          if (!paramAnonymousBoolean.booleanValue())
          {
            paramAnonymousBoolean = Toast.makeText(YouPinOrderDetailFragment.a(YouPinOrderDetailFragment.this), "下载失败", 0);
            if (!(paramAnonymousBoolean instanceof Toast)) {
              paramAnonymousBoolean.show();
            }
          }
          while (YouPinOrderDetailFragment.a(YouPinOrderDetailFragment.this).isFinishing())
          {
            return;
            VdsAgent.showToast((Toast)paramAnonymousBoolean);
            return;
          }
          paramAnonymousBoolean = Uri.fromFile(localFile);
          Intent localIntent = new Intent("android.intent.action.VIEW");
          localIntent.setDataAndType(paramAnonymousBoolean, "application/pdf");
          localIntent.setFlags(67108864);
          YouPinOrderDetailFragment.this.startActivity(localIntent);
        }
      });
    }
  }
  
  private void g()
  {
    this.L = new d();
    this.L.initWXAPI(this.c);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.activity_1");
    this.c.registerReceiver(this.P, localIntentFilter);
  }
  
  public static YouPinOrderDetailFragment newInstance(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("maintainOrderCode", paramString1);
    localBundle.putString("imgUrl", paramString2);
    paramString1 = new YouPinOrderDetailFragment();
    paramString1.setArguments(localBundle);
    return paramString1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    YouPinOrderDetailsActivity localYouPinOrderDetailsActivity;
    if (paramInt1 == 666)
    {
      localYouPinOrderDetailsActivity = this.c;
      if ((paramInt2 != -1) || (!paramIntent.getBooleanExtra("eval", false))) {
        break label48;
      }
      this.c.getServerData();
      new Thread()
      {
        public void run()
        {
          super.run();
          try
          {
            Thread.sleep(3000L);
            org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("refresh_service_order_list", null));
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }.start();
    }
    label48:
    do
    {
      return;
      localYouPinOrderDetailsActivity = this.c;
    } while ((paramInt2 != -1) || (paramIntent.getBooleanExtra("eval", false)));
    this.c.getServerData();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        f();
        return;
        startActivity(new Intent(this.c, YouPinBackChangeGoodsInfoActivity.class));
        return;
        if ((this.M == 15) || (this.M == 20) || (this.M == 25))
        {
          com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.c).setTitle("提示").setContent("您确认已经收到该订单商品了吗？其中家具类商品需确认安装完成哦~").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
            {
              if (paramAnonymousBoolean) {
                com.ziroom.ziroomcustomer.e.n.getYouPinAcceptConfirm(YouPinOrderDetailFragment.a(YouPinOrderDetailFragment.this), YouPinOrderDetailFragment.b(YouPinOrderDetailFragment.this).getLogicCode(), "2", new com.ziroom.ziroomcustomer.e.a.a(YouPinOrderDetailFragment.a(YouPinOrderDetailFragment.this), new m(ae.class, new e()))
                {
                  public void onSuccess(int paramAnonymous2Int, ae paramAnonymous2ae)
                  {
                    super.onSuccess(paramAnonymous2Int, paramAnonymous2ae);
                    if ((paramAnonymous2ae != null) && (!TextUtils.isEmpty(paramAnonymous2ae.getMaintainOrderCode())))
                    {
                      YouPinOrderDetailFragment.this.showToast("验收完成");
                      paramAnonymous2ae = new Intent(YouPinOrderDetailFragment.a(YouPinOrderDetailFragment.this), YouPinEvaluationActivity.class);
                      paramAnonymous2ae.putExtra("maintainOrderCode", YouPinOrderDetailFragment.b(YouPinOrderDetailFragment.this).getLogicCode());
                      paramAnonymous2ae.putExtra("productCode", YouPinOrderDetailFragment.b(YouPinOrderDetailFragment.this).getProductCode());
                      paramAnonymous2ae.putExtra("imgUrl", YouPinOrderDetailFragment.c(YouPinOrderDetailFragment.this));
                      YouPinOrderDetailFragment.this.startActivityForResult(paramAnonymous2ae, 666);
                    }
                  }
                });
              }
            }
          }).build().show();
          return;
        }
      } while (this.M != 27);
      paramView = new Intent(this.c, YouPinEvaluationActivity.class);
      paramView.putExtra("maintainOrderCode", this.N.getLogicCode());
      paramView.putExtra("productCode", this.N.getProductCode());
      paramView.putExtra("imgUrl", this.b);
      startActivityForResult(paramView, 666);
      return;
      com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.c).setTitle("提示").setContent("如有任何售后需求，请致电我们的客服电话400-100-1111，自如会第一时间为您排忧解难~").setBtnConfirmText("呼叫").setOnConfirmClickListener(new c.b()
      {
        public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {
            ah.callPhone(YouPinOrderDetailFragment.a(YouPinOrderDetailFragment.this), "4001001111");
          }
        }
      }).build().show();
      return;
      paramView = new Intent(this.c, YouPinBackOrderDetailsActivity.class);
      paramView.putExtra("retreatOrderCode", this.O);
      startActivity(paramView);
      return;
    } while (this.M != 0);
    Object localObject = new com.ziroom.ziroomcustomer.bestgoods.model.n();
    paramView = new ArrayList();
    ((com.ziroom.ziroomcustomer.bestgoods.model.n)localObject).setGoodsOrderCode(this.N.getLogicCode());
    ((com.ziroom.ziroomcustomer.bestgoods.model.n)localObject).setOrderPrice(this.N.getOrderPrice());
    paramView.add(localObject);
    localObject = new HashMap();
    ((Map)localObject).put("money", this.N.getOrderPrice() + "");
    ((Map)localObject).put("payKind", "1");
    ((Map)localObject).put("couponCode", "");
    ((Map)localObject).put("strGoodsOrderPrices", com.alibaba.fastjson.a.toJSONString(paramView));
    j.PayGoodsOrder(this.c, (Map)localObject, new a(new com.ziroom.ziroomcustomer.newrepair.utils.b(ap.class)));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    this.a = paramBundle.getString("maintainOrderCode");
    this.b = paramBundle.getString("imgUrl");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903994, null);
    this.c = ((YouPinOrderDetailsActivity)getActivity());
    this.c.addOnYouPinOrderDetailsDataListener(this);
    a(paramLayoutInflater);
    c();
    d();
    return paramLayoutInflater;
  }
  
  public void onYpDetailsData(ao paramao)
  {
    e();
    this.N = paramao;
    if (this.N == null) {
      return;
    }
    paramao = this.N.getConnectionName();
    Object localObject1 = this.N.getConnectionPhone();
    Object localObject2 = this.N.getAddress();
    this.e.setText(paramao);
    this.f.setText((CharSequence)localObject1);
    this.g.setText((CharSequence)localObject2);
    this.K = this.N.getGoodsList();
    if ((this.K != null) && (!this.K.isEmpty()))
    {
      paramao = new ai(this.c, this.K);
      this.h.setAdapter(paramao);
    }
    this.M = this.N.getOrderStatus();
    paramao = this.N.getOrderStatusName();
    localObject1 = this.N.getCreateTime();
    localObject2 = this.N.getLogicCode();
    Object localObject3 = this.N.getUserMessage();
    this.j.setText(paramao);
    this.k.setText((CharSequence)localObject1);
    this.l.setText((CharSequence)localObject2);
    this.m.setText((CharSequence)localObject3);
    paramao = this.N.getRetreatInfo();
    label352:
    label369:
    label422:
    Double localDouble;
    if (paramao != null)
    {
      this.O = paramao.getRetreatOrderCode();
      this.H.setVisibility(0);
      if ((this.M == 15) || (this.M == 20) || (this.M == 25))
      {
        this.I.setVisibility(8);
        this.F.setVisibility(0);
        this.F.setText("确认收货");
        this.E.setVisibility(0);
        paramao = this.N.getInvoiceInfo();
        if (paramao == null) {
          break label1076;
        }
        this.n.setVisibility(0);
        this.s.setVisibility(0);
        localObject1 = Integer.valueOf(paramao.getInvoiceStatus());
        localObject2 = paramao.getInvoiceStatusName();
        this.o.setText((CharSequence)localObject2);
        if (((Integer)localObject1).intValue() != 1) {
          break label1023;
        }
        this.t.setVisibility(8);
        if (paramao.getPayerType() != 0) {
          break label1063;
        }
        this.p.setText("个人");
        localObject1 = paramao.getInvoiceTitle();
        this.q.setText((CharSequence)localObject1);
        localObject1 = paramao.getInvoiceContent();
        this.r.setText((String)localObject1 + "");
        this.J = paramao.getShowUrl();
        paramao = this.N.getIsPay();
        this.u.setVisibility(0);
        this.y.setVisibility(0);
        localObject1 = new DecimalFormat("0.00");
        localObject2 = this.N.getTotalOrderPrice();
        localObject3 = this.N.getOrderPrice();
        localDouble = this.N.getTotalCouponPrice();
        if (paramao.intValue() != 0) {
          break label1097;
        }
        this.B.setVisibility(0);
        this.A.setText("需支付");
      }
    }
    for (;;)
    {
      this.v.setText("￥" + ((DecimalFormat)localObject1).format(localObject2));
      this.w.setText("￥" + ((DecimalFormat)localObject1).format(0L));
      this.x.setText("-￥" + ((DecimalFormat)localObject1).format(localDouble));
      this.z.setText("￥" + ((DecimalFormat)localObject1).format(localObject3));
      return;
      if (this.M == 27)
      {
        this.I.setVisibility(8);
        this.F.setVisibility(0);
        this.F.setText("去评价");
        this.E.setVisibility(0);
        break;
      }
      if (this.M == 30)
      {
        this.I.setVisibility(8);
        this.E.setVisibility(0);
        this.F.setVisibility(8);
        break;
      }
      if (this.M != 35) {
        break;
      }
      this.I.setVisibility(8);
      this.E.setVisibility(0);
      break;
      this.H.setVisibility(8);
      if (this.M == 0)
      {
        this.I.setVisibility(0);
        this.E.setVisibility(8);
        g();
        break;
      }
      if ((this.M == 1) || (this.M == 5) || (this.M == 10))
      {
        this.I.setVisibility(8);
        this.E.setVisibility(0);
        this.F.setVisibility(8);
        break;
      }
      if ((this.M == 15) || (this.M == 20) || (this.M == 25))
      {
        this.I.setVisibility(8);
        this.F.setVisibility(0);
        this.F.setText("确认收货");
        this.E.setVisibility(0);
        break;
      }
      if (this.M == 27)
      {
        this.I.setVisibility(8);
        this.F.setVisibility(0);
        this.F.setText("去评价");
        this.E.setVisibility(0);
        break;
      }
      if (this.M == 30)
      {
        this.I.setVisibility(8);
        this.E.setVisibility(0);
        this.F.setVisibility(8);
        break;
      }
      if (this.M != 35) {
        break;
      }
      this.I.setVisibility(8);
      this.E.setVisibility(8);
      break;
      label1023:
      if (((Integer)localObject1).intValue() == 5)
      {
        this.t.setVisibility(8);
        break label352;
      }
      if (((Integer)localObject1).intValue() != 10) {
        break label352;
      }
      this.t.setVisibility(0);
      break label352;
      label1063:
      this.p.setText("公司");
      break label369;
      label1076:
      this.n.setVisibility(8);
      this.s.setVisibility(8);
      break label422;
      label1097:
      this.B.setVisibility(0);
      this.A.setText("实付款");
    }
  }
  
  class a
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public a(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      YouPinOrderDetailFragment.this.dismissProgress();
      YouPinOrderDetailFragment.this.showToast("支付失败，请重试");
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        paraml = (ap)paraml.getObject();
        if (paraml != null) {
          YouPinOrderDetailFragment.a(YouPinOrderDetailFragment.this, paraml);
        }
      }
      for (;;)
      {
        YouPinOrderDetailFragment.this.dismissProgress();
        return;
        if ((paraml == null) && (YouPinOrderDetailFragment.b(YouPinOrderDetailFragment.this).getOrderPrice().doubleValue() == 0.0D))
        {
          Object localObject = new com.ziroom.ziroomcustomer.bestgoods.model.n();
          paraml = new ArrayList();
          ((com.ziroom.ziroomcustomer.bestgoods.model.n)localObject).setGoodsOrderCode(YouPinOrderDetailFragment.b(YouPinOrderDetailFragment.this).getLogicCode());
          ((com.ziroom.ziroomcustomer.bestgoods.model.n)localObject).setOrderPrice(YouPinOrderDetailFragment.b(YouPinOrderDetailFragment.this).getOrderPrice());
          paraml.add(localObject);
          localObject = new HashMap();
          ((Map)localObject).put("money", YouPinOrderDetailFragment.b(YouPinOrderDetailFragment.this).getOrderPrice() + "");
          ((Map)localObject).put("payKind", "1");
          ((Map)localObject).put("couponCode", "");
          ((Map)localObject).put("strGoodsOrderPrices", com.alibaba.fastjson.a.toJSONString(paraml));
          j.PayGoodsOrder(YouPinOrderDetailFragment.a(YouPinOrderDetailFragment.this), (Map)localObject, new YouPinOrderDetailFragment.b(YouPinOrderDetailFragment.this, new com.ziroom.ziroomcustomer.newrepair.utils.b(ap.class)));
          continue;
          paraml = paraml.getMessage();
          if (paraml != null) {
            YouPinOrderDetailFragment.this.showToast(paraml);
          } else {
            YouPinOrderDetailFragment.this.showToast("支付失败，请重试");
          }
        }
      }
    }
  }
  
  class b
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public b(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      YouPinOrderDetailFragment.this.dismissProgress();
      YouPinOrderDetailFragment.this.showToast("支付失败，请重试");
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        YouPinOrderDetailFragment.a(YouPinOrderDetailFragment.this).getServerData();
        new Thread()
        {
          public void run()
          {
            super.run();
            try
            {
              Thread.sleep(3000L);
              org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("refresh_service_order_list", null));
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }.start();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/fragment/YouPinOrderDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */