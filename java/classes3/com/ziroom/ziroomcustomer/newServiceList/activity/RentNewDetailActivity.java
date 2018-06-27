package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.newServiceList.a.q;
import com.ziroom.ziroomcustomer.newServiceList.model.ac;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newServiceList.view.ElasticScrollView;
import com.ziroom.ziroomcustomer.newServiceList.view.ElasticScrollView.a;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RentNewDetailActivity
  extends BaseActivity
  implements View.OnClickListener, ElasticScrollView.a
{
  private View A;
  private View B;
  private View C;
  private TextView D;
  private ImageView E;
  private RelativeLayout F;
  private TextView G;
  private ImageView H;
  private LinearLayout I;
  private ImageView J;
  private ImageView K;
  private ImageView L;
  private ImageView M;
  private ImageView N;
  private FlowLayout O;
  private ListView P;
  private String Q;
  private ac R;
  private RelativeLayout S;
  private int T = -1;
  private TextView U;
  private TextView V;
  private TextView W;
  private TextView X;
  private RelativeLayout Y;
  private TextView Z;
  private Context a;
  private RelativeLayout aa;
  private Handler ab = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69953: 
        if (locall.getSuccess().booleanValue())
        {
          RentNewDetailActivity.a(RentNewDetailActivity.this, (ac)locall.getObject());
          if (RentNewDetailActivity.a(RentNewDetailActivity.this) != null) {
            RentNewDetailActivity.b(RentNewDetailActivity.this, RentNewDetailActivity.a(RentNewDetailActivity.this));
          }
        }
        for (;;)
        {
          RentNewDetailActivity.c(RentNewDetailActivity.this).onRefreshComplete();
          RentNewDetailActivity.this.dismissProgress();
          return;
          af.showToast(RentNewDetailActivity.b(RentNewDetailActivity.this), locall.getMessage());
        }
      }
      if (locall.getSuccess().booleanValue())
      {
        paramAnonymousMessage = (String)locall.getObject();
        if (TextUtils.isEmpty(paramAnonymousMessage)) {
          af.showToast(RentNewDetailActivity.b(RentNewDetailActivity.this), locall.getMessage());
        }
      }
      for (;;)
      {
        RentNewDetailActivity.c(RentNewDetailActivity.this).onRefreshComplete();
        RentNewDetailActivity.this.dismissProgress();
        return;
        af.showToast(RentNewDetailActivity.b(RentNewDetailActivity.this), paramAnonymousMessage);
        continue;
        af.showToast(RentNewDetailActivity.b(RentNewDetailActivity.this), locall.getMessage());
      }
    }
  };
  private Button b;
  private ImageView c;
  private ElasticScrollView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private ImageView u;
  private ImageView v;
  private ImageView w;
  private ImageView x;
  private View y;
  private View z;
  
  private void a()
  {
    this.Q = getIntent().getStringExtra("serviceProjectId");
    o.getRentNewDetailInfo(this.a, this.ab, this.Q);
    showProgress("");
  }
  
  private void a(final ac paramac)
  {
    this.e.setText("生活服务订单");
    int i = paramac.getBillStatus();
    if (i == 1)
    {
      this.f.setText("受理中");
      if (i != 3) {
        break label376;
      }
      this.Y.setVisibility(0);
      this.Z.setText(paramac.getLittleTime());
      label52:
      this.g.setText(i.getSysData(paramac.getAcceptTime()));
      this.r.setText(paramac.getOrderPlace());
      this.s.setText(paramac.getOrderNo());
      this.t.setText(paramac.getContent());
      if (!TextUtils.isEmpty(paramac.getDealer())) {
        break label388;
      }
      this.S.setVisibility(8);
      label118:
      Object localObject = paramac.getFollowUpRecord();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = new q(this.a, (List)localObject);
        this.P.setAdapter((ListAdapter)localObject);
      }
      if (paramac.getBillStatus() != 4) {
        break label584;
      }
      this.b.setBackgroundResource(2130838026);
      this.b.setClickable(true);
      this.b.setVisibility(0);
      this.b.setText("去评价");
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(RentNewDetailActivity.b(RentNewDetailActivity.this), RentEvalActivity.class);
          paramAnonymousView.putExtra("workOrderId", paramac.getBillNum());
          if (paramac.getIsTelShow() == 1) {
            paramAnonymousView.putExtra("dealPhone", paramac.getDealerTel());
          }
          for (;;)
          {
            paramAnonymousView.putExtra("dealPeople", paramac.getDealer());
            RentNewDetailActivity.this.startActivity(paramAnonymousView);
            return;
            paramAnonymousView.putExtra("dealPhone", "");
          }
        }
      });
    }
    for (;;)
    {
      c(paramac.getBillStatus());
      return;
      if (i == 2)
      {
        this.f.setText("派单中");
        break;
      }
      if (i == 3)
      {
        this.f.setText("办结中");
        break;
      }
      if (i == 4)
      {
        this.f.setText("待评价");
        break;
      }
      if (i == 5)
      {
        this.f.setText("一结束");
        break;
      }
      if (i == 6)
      {
        this.f.setText("已撤销");
        break;
      }
      if (i == 7)
      {
        this.f.setText("退回待审批");
        break;
      }
      if (i == 8)
      {
        this.f.setText("已退回");
        break;
      }
      if (i == 9)
      {
        this.f.setText("已评价");
        break;
      }
      this.f.setText("");
      break;
      label376:
      this.Y.setVisibility(8);
      break label52;
      label388:
      this.S.setVisibility(0);
      this.D.setText(paramac.getDealer());
      if (paramac.getIsTelShow() == 1) {
        if (TextUtils.isEmpty(paramac.getDealerTel())) {
          this.E.setVisibility(8);
        }
      }
      for (;;)
      {
        if (paramac.getEvaluateStar() != -1) {
          break label493;
        }
        this.F.setVisibility(8);
        break;
        this.E.setVisibility(0);
        this.E.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            ah.callPhone(RentNewDetailActivity.b(RentNewDetailActivity.this), paramac.getDealerTel());
          }
        });
        continue;
        this.E.setVisibility(8);
      }
      label493:
      this.F.setVisibility(0);
      b(paramac.getEvaluateStar());
      if ((!TextUtils.isEmpty(paramac.getEvaluateSign())) && (paramac.getEvaluateSign().length() > 0))
      {
        this.aa.setVisibility(0);
        if ("^$".equals(paramac.getEvaluateSign())) {
          break label118;
        }
        this.O.removeAllViews();
        a(e(paramac.getEvaluateSign()));
        break label118;
      }
      this.aa.setVisibility(8);
      break label118;
      label584:
      if (paramac.getBillStatus() == 3)
      {
        this.b.setVisibility(0);
        this.b.setText("催单");
        this.b.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            RentNewDetailActivity.d(RentNewDetailActivity.this);
            RentNewDetailActivity.e(RentNewDetailActivity.this).setBackgroundColor(-2236963);
            RentNewDetailActivity.e(RentNewDetailActivity.this).setClickable(false);
          }
        });
      }
      else
      {
        this.b.setVisibility(8);
      }
    }
  }
  
  private void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        d((String)paramList.next());
      }
    }
  }
  
  private void b()
  {
    this.b = ((Button)findViewById(2131690461));
    this.c = ((ImageView)findViewById(2131689492));
    this.d = ((ElasticScrollView)findViewById(2131691910));
    View localView = LayoutInflater.from(this).inflate(2130904769, null);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    localView.requestFocus();
    localView.requestFocusFromTouch();
    this.e = ((TextView)localView.findViewById(2131690367));
    this.f = ((TextView)localView.findViewById(2131689848));
    this.g = ((TextView)localView.findViewById(2131690423));
    this.r = ((TextView)localView.findViewById(2131690053));
    this.s = ((TextView)localView.findViewById(2131690048));
    this.t = ((TextView)localView.findViewById(2131690424));
    this.u = ((ImageView)localView.findViewById(2131692114));
    this.v = ((ImageView)localView.findViewById(2131692115));
    this.w = ((ImageView)localView.findViewById(2131692117));
    this.x = ((ImageView)localView.findViewById(2131692119));
    this.y = localView.findViewById(2131692113);
    this.z = localView.findViewById(2131690395);
    this.A = localView.findViewById(2131692116);
    this.B = localView.findViewById(2131692118);
    this.C = localView.findViewById(2131692120);
    this.S = ((RelativeLayout)localView.findViewById(2131690369));
    this.D = ((TextView)localView.findViewById(2131690371));
    this.E = ((ImageView)localView.findViewById(2131691963));
    this.F = ((RelativeLayout)localView.findViewById(2131695988));
    this.G = ((TextView)localView.findViewById(2131695989));
    this.H = ((ImageView)localView.findViewById(2131695990));
    this.I = ((LinearLayout)localView.findViewById(2131695991));
    this.J = ((ImageView)localView.findViewById(2131690054));
    this.K = ((ImageView)localView.findViewById(2131690055));
    this.L = ((ImageView)localView.findViewById(2131690056));
    this.M = ((ImageView)localView.findViewById(2131690057));
    this.N = ((ImageView)localView.findViewById(2131690058));
    this.U = ((TextView)localView.findViewById(2131690909));
    this.V = ((TextView)localView.findViewById(2131692121));
    this.W = ((TextView)localView.findViewById(2131692122));
    this.X = ((TextView)localView.findViewById(2131692123));
    this.O = ((FlowLayout)localView.findViewById(2131690332));
    this.P = ((ListView)localView.findViewById(2131695992));
    this.Y = ((RelativeLayout)localView.findViewById(2131695391));
    this.Z = ((TextView)localView.findViewById(2131695393));
    this.aa = ((RelativeLayout)localView.findViewById(2131696388));
    this.b.setVisibility(8);
    this.d.addChild(localView);
    this.T = 0;
    this.d.setonRefreshListener(this);
    this.c.setOnClickListener(this);
    this.F.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 1)
    {
      this.J.setVisibility(0);
      this.K.setVisibility(4);
      this.L.setVisibility(4);
      this.M.setVisibility(4);
      this.N.setVisibility(4);
      return;
    }
    if (paramInt == 2)
    {
      this.J.setVisibility(0);
      this.K.setVisibility(0);
      this.L.setVisibility(4);
      this.M.setVisibility(4);
      this.N.setVisibility(4);
      return;
    }
    if (paramInt == 3)
    {
      this.J.setVisibility(0);
      this.K.setVisibility(0);
      this.L.setVisibility(0);
      this.M.setVisibility(4);
      this.N.setVisibility(4);
      return;
    }
    if (paramInt == 4)
    {
      this.J.setVisibility(0);
      this.K.setVisibility(0);
      this.L.setVisibility(0);
      this.M.setVisibility(0);
      this.N.setVisibility(4);
      return;
    }
    if (paramInt == 5)
    {
      this.J.setVisibility(0);
      this.K.setVisibility(0);
      this.L.setVisibility(0);
      this.M.setVisibility(0);
      this.N.setVisibility(0);
      return;
    }
    this.J.setVisibility(4);
    this.K.setVisibility(4);
    this.L.setVisibility(4);
    this.M.setVisibility(4);
    this.N.setVisibility(4);
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 1)
    {
      this.y.setBackgroundColor(Color.parseColor("#F56400"));
      this.u.setImageResource(2130838940);
      this.U.setTextColor(Color.parseColor("#F56400"));
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        this.y.setBackgroundColor(Color.parseColor("#F56400"));
        this.z.setBackgroundColor(Color.parseColor("#F56400"));
        this.u.setImageResource(2130838940);
        this.v.setImageResource(2130838940);
        this.U.setTextColor(Color.parseColor("#F56400"));
        this.V.setTextColor(Color.parseColor("#F56400"));
        return;
      }
      if (paramInt == 3)
      {
        this.y.setBackgroundColor(Color.parseColor("#F56400"));
        this.z.setBackgroundColor(Color.parseColor("#F56400"));
        this.A.setBackgroundColor(Color.parseColor("#F56400"));
        this.u.setImageResource(2130838940);
        this.v.setImageResource(2130838940);
        this.w.setImageResource(2130838940);
        this.U.setTextColor(Color.parseColor("#F56400"));
        this.V.setTextColor(Color.parseColor("#F56400"));
        this.W.setTextColor(Color.parseColor("#F56400"));
        return;
      }
    } while ((paramInt != 4) && (paramInt != 5) && (paramInt != 9));
    this.y.setBackgroundColor(Color.parseColor("#F56400"));
    this.z.setBackgroundColor(Color.parseColor("#F56400"));
    this.A.setBackgroundColor(Color.parseColor("#F56400"));
    this.B.setBackgroundColor(Color.parseColor("#F56400"));
    this.C.setBackgroundColor(Color.parseColor("#F56400"));
    this.u.setImageResource(2130838940);
    this.v.setImageResource(2130838940);
    this.w.setImageResource(2130838940);
    this.x.setImageResource(2130838940);
    this.U.setTextColor(Color.parseColor("#F56400"));
    this.V.setTextColor(Color.parseColor("#F56400"));
    this.W.setTextColor(Color.parseColor("#F56400"));
    this.X.setTextColor(Color.parseColor("#F56400"));
  }
  
  private void d(String paramString)
  {
    Button localButton = new Button(this);
    localButton.setText(paramString);
    localButton.setTag(Boolean.valueOf(false));
    localButton.setTextColor(getResources().getColor(2131624516));
    localButton.setTextSize(12.0F);
    localButton.setPadding(10, 0, 10, 0);
    localButton.setBackgroundResource(2130839371);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(10, 10, 10, 0);
    localButton.setLayoutParams(paramString);
    this.O.addView(localButton);
  }
  
  private List<String> e(String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    if (!"#^$".equals(paramString))
    {
      paramString = paramString.split("\\^\\$")[0];
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split("\\|#");
        while (i < paramString.length)
        {
          localArrayList.add(paramString[i]);
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  private void e()
  {
    o.setReminder(this.a, this.ab, this.Q);
    showProgress("");
  }
  
  private void f()
  {
    if (this.T == 0)
    {
      this.T = 1;
      this.I.setVisibility(0);
      this.H.setImageResource(2130839909);
    }
    while (this.T != 1) {
      return;
    }
    this.T = 0;
    this.I.setVisibility(8);
    this.H.setImageResource(2130839906);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903393);
    this.a = this;
    b();
    a();
  }
  
  public void onRefresh()
  {
    o.getRentNewDetailInfo(this.a, this.ab, this.Q);
    showProgress("");
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.Q = getIntent().getStringExtra("serviceProjectId");
    o.getRentNewDetailInfo(this.a, this.ab, this.Q);
    showProgress("");
  }
  
  public void onScroll(int paramInt) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RentNewDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */