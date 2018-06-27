package com.ziroom.ziroomcustomer.payment.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.a.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.account.BankcardDetailActivity;
import com.ziroom.ziroomcustomer.account.model.Card;
import com.ziroom.ziroomcustomer.account.swipemenulistview.SwipeMenuListView;
import com.ziroom.ziroomcustomer.account.swipemenulistview.SwipeMenuListView.a;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.CreditsEntity;
import com.ziroom.ziroomcustomer.model.SignedInfo;
import com.ziroom.ziroomcustomer.payment.b.p;
import com.ziroom.ziroomcustomer.payment.e.b.a;
import com.ziroom.ziroomcustomer.payment.e.d.a;
import com.ziroom.ziroomcustomer.repay.RepayInfoActivity;
import com.ziroom.ziroomcustomer.signed.SignerDataActivity;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BandCardMangeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private com.ziroom.ziroomcustomer.account.a.a A;
  private com.ziroom.ziroomcustomer.account.a.a B;
  private com.ziroom.ziroomcustomer.account.a.a C;
  private com.ziroom.ziroomcustomer.account.a.a D;
  private com.ziroom.ziroomcustomer.account.a.a E;
  private SwipeMenuListView a;
  private SwipeMenuListView b;
  private SwipeMenuListView c;
  private ListViewForScrollView d;
  private ListViewForScrollView e;
  private RelativeLayout f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private List<Card> v = new ArrayList();
  private List<Card> w = new ArrayList();
  private List<Card> x = new ArrayList();
  private List<Card> y = new ArrayList();
  private List<Card> z = new ArrayList();
  
  private void a()
  {
    j.getCertList(this, new com.ziroom.ziroomcustomer.e.a.b(this, new com.ziroom.ziroomcustomer.e.c.d())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        com.alibaba.fastjson.b localb = paramAnonymouse.getJSONArray("YLDK");
        BandCardMangeActivity.a(BandCardMangeActivity.this, localb);
        localb = paramAnonymouse.getJSONArray("HF");
        BandCardMangeActivity.b(BandCardMangeActivity.this, localb);
        localb = paramAnonymouse.getJSONArray("TX");
        BandCardMangeActivity.c(BandCardMangeActivity.this, localb);
        localb = paramAnonymouse.getJSONArray("ZRFQ");
        BandCardMangeActivity.d(BandCardMangeActivity.this, localb);
        paramAnonymouse = paramAnonymouse.getJSONArray("QSF");
        BandCardMangeActivity.e(BandCardMangeActivity.this, paramAnonymouse);
      }
    });
  }
  
  private void a(com.alibaba.fastjson.b paramb)
  {
    if (paramb == null)
    {
      this.c.setVisibility(8);
      this.t.setVisibility(8);
      return;
    }
    this.x = paramb.toJavaList(Card.class);
    if (this.x == null)
    {
      this.c.setVisibility(8);
      this.t.setVisibility(8);
      return;
    }
    if (this.x.size() == 0)
    {
      this.c.setVisibility(8);
      this.t.setVisibility(8);
      return;
    }
    this.C = new com.ziroom.ziroomcustomer.account.a.a(this, this.x);
    this.c.setAdapter(this.C);
    this.c.setVisibility(0);
    this.t.setVisibility(0);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    com.ziroom.ziroomcustomer.payment.d.b.getHuifuReBandList(this, paramString1, paramString2, paramString3, paramString4, new com.ziroom.ziroomcustomer.payment.d.i(this, new com.ziroom.ziroomcustomer.payment.d.e(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        if ("success".equals((String)com.alibaba.fastjson.e.parseObject(paramAnonymousString).get("resp_code")))
        {
          BandCardMangeActivity.m(BandCardMangeActivity.this);
          return;
        }
        BandCardMangeActivity.n(BandCardMangeActivity.this);
      }
    });
  }
  
  private void b()
  {
    setContentView(2130903210);
    ((BasicZiroomToolBar)findViewById(2131689787)).setTitle("银行卡管理");
    this.t = ((TextView)findViewById(2131690922));
    this.c = ((SwipeMenuListView)findViewById(2131690923));
    this.d = ((ListViewForScrollView)findViewById(2131690925));
    this.e = ((ListViewForScrollView)findViewById(2131690927));
    this.C = new com.ziroom.ziroomcustomer.account.a.a(this, this.x);
    Object localObject = new com.ziroom.ziroomcustomer.account.swipemenulistview.c()
    {
      public void create(com.ziroom.ziroomcustomer.account.swipemenulistview.a paramAnonymousa)
      {
        com.ziroom.ziroomcustomer.account.swipemenulistview.d locald = new com.ziroom.ziroomcustomer.account.swipemenulistview.d(BandCardMangeActivity.this.getApplicationContext());
        locald.setBackground(new ColorDrawable(Color.parseColor("#FF6262")));
        locald.setWidth(n.dip2px(BandCardMangeActivity.this, 80.0F));
        locald.setTitle("解绑");
        locald.setTitleColor(Color.parseColor("#FFFFFF"));
        locald.setTitleSize(14);
        paramAnonymousa.addMenuItem(locald);
      }
    };
    this.c.setMenuCreator((com.ziroom.ziroomcustomer.account.swipemenulistview.c)localObject);
    this.c.setOnMenuItemClickListener(new SwipeMenuListView.a()
    {
      public void onMenuItemClick(int paramAnonymousInt1, com.ziroom.ziroomcustomer.account.swipemenulistview.a paramAnonymousa, int paramAnonymousInt2)
      {
        switch (paramAnonymousInt2)
        {
        default: 
          return;
        }
        new com.ziroom.ziroomcustomer.payment.e.d(BandCardMangeActivity.this).showUnionDkPayPop(false, new d.a()
        {
          public void onSuccess(String paramAnonymous2String)
          {
            BandCardMangeActivity.a(BandCardMangeActivity.this);
          }
        });
      }
    });
    this.c.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        BandCardMangeActivity.b(BandCardMangeActivity.this).smoothOpenMenu(paramAnonymousInt);
        return false;
      }
    });
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        BandCardMangeActivity.b(BandCardMangeActivity.this).smoothOpenMenu(paramAnonymousInt);
      }
    });
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = new Intent(BandCardMangeActivity.this, RepayInfoActivity.class);
        paramAnonymousAdapterView.putExtra("contractCode", ((Card)BandCardMangeActivity.c(BandCardMangeActivity.this).getItem(paramAnonymousInt)).outcontractCode);
        BandCardMangeActivity.this.startActivityForResult(paramAnonymousAdapterView, 3);
      }
    });
    this.e.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = new Intent(BandCardMangeActivity.this, RepayInfoActivity.class);
        paramAnonymousAdapterView.putExtra("contractCode", ((Card)BandCardMangeActivity.d(BandCardMangeActivity.this).getItem(paramAnonymousInt)).outcontractCode);
        BandCardMangeActivity.this.startActivityForResult(paramAnonymousAdapterView, 3);
      }
    });
    this.g = ((TextView)findViewById(2131690920));
    this.b = ((SwipeMenuListView)findViewById(2131690921));
    this.r = ((TextView)findViewById(2131690926));
    this.s = ((TextView)findViewById(2131690924));
    this.B = new com.ziroom.ziroomcustomer.account.a.a(this, this.w);
    localObject = new com.ziroom.ziroomcustomer.account.swipemenulistview.c()
    {
      public void create(com.ziroom.ziroomcustomer.account.swipemenulistview.a paramAnonymousa)
      {
        com.ziroom.ziroomcustomer.account.swipemenulistview.d locald = new com.ziroom.ziroomcustomer.account.swipemenulistview.d(BandCardMangeActivity.this.getApplicationContext());
        locald.setBackground(new ColorDrawable(Color.parseColor("#FF6262")));
        locald.setWidth(n.dip2px(BandCardMangeActivity.this, 80.0F));
        locald.setTitle("解绑");
        locald.setTitleColor(Color.parseColor("#FFFFFF"));
        locald.setTitleSize(16);
        paramAnonymousa.addMenuItem(locald);
      }
    };
    this.b.setMenuCreator((com.ziroom.ziroomcustomer.account.swipemenulistview.c)localObject);
    this.b.setOnMenuItemClickListener(new SwipeMenuListView.a()
    {
      public void onMenuItemClick(final int paramAnonymousInt1, com.ziroom.ziroomcustomer.account.swipemenulistview.a paramAnonymousa, int paramAnonymousInt2)
      {
        switch (paramAnonymousInt2)
        {
        default: 
          return;
        }
        new com.ziroom.ziroomcustomer.payment.e.b(BandCardMangeActivity.this, Boolean.valueOf(false), null, ((Card)BandCardMangeActivity.e(BandCardMangeActivity.this).getItem(paramAnonymousInt1)).cityNum, "确定", "取消", "解除绑定", new b.a()
        {
          public void onClick(String paramAnonymous2String, com.ziroom.ziroomcustomer.payment.b.i paramAnonymous2i)
          {
            BandCardMangeActivity.a(BandCardMangeActivity.this, ((Card)BandCardMangeActivity.e(BandCardMangeActivity.this).getItem(paramAnonymousInt1)).cityNum, paramAnonymous2String, paramAnonymous2i.getOrder_id(), paramAnonymous2i.getOrder_date());
          }
        }).showMessageDialog();
      }
    });
    this.b.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        BandCardMangeActivity.f(BandCardMangeActivity.this).smoothOpenMenu(paramAnonymousInt);
        return false;
      }
    });
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        BandCardMangeActivity.f(BandCardMangeActivity.this).smoothOpenMenu(paramAnonymousInt);
      }
    });
    this.f = ((RelativeLayout)findViewById(2131690918));
    this.u = ((TextView)findViewById(2131690917));
    this.a = ((SwipeMenuListView)findViewById(2131690919));
    this.A = new com.ziroom.ziroomcustomer.account.a.a(this, this.v);
    localObject = new com.ziroom.ziroomcustomer.account.swipemenulistview.c()
    {
      public void create(com.ziroom.ziroomcustomer.account.swipemenulistview.a paramAnonymousa)
      {
        com.ziroom.ziroomcustomer.account.swipemenulistview.d locald = new com.ziroom.ziroomcustomer.account.swipemenulistview.d(BandCardMangeActivity.this.getApplicationContext());
        locald.setBackground(new ColorDrawable(Color.parseColor("#FF6262")));
        locald.setWidth(n.dip2px(BandCardMangeActivity.this, 80.0F));
        locald.setTitle("解绑");
        locald.setTitleColor(Color.parseColor("#FFFFFF"));
        locald.setTitleSize(16);
        paramAnonymousa.addMenuItem(locald);
      }
    };
    this.a.setMenuCreator((com.ziroom.ziroomcustomer.account.swipemenulistview.c)localObject);
    this.a.setOnMenuItemClickListener(new SwipeMenuListView.a()
    {
      public void onMenuItemClick(int paramAnonymousInt1, com.ziroom.ziroomcustomer.account.swipemenulistview.a paramAnonymousa, int paramAnonymousInt2)
      {
        switch (paramAnonymousInt2)
        {
        default: 
          return;
        }
        BandCardMangeActivity.g(BandCardMangeActivity.this);
      }
    });
    this.a.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        BandCardMangeActivity.h(BandCardMangeActivity.this).smoothOpenMenu(paramAnonymousInt);
        return false;
      }
    });
    this.a.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        BandCardMangeActivity.h(BandCardMangeActivity.this).smoothOpenMenu(paramAnonymousInt);
      }
    });
  }
  
  private void b(com.alibaba.fastjson.b paramb)
  {
    if (paramb == null)
    {
      this.b.setVisibility(8);
      this.g.setVisibility(8);
      return;
    }
    this.w = paramb.toJavaList(Card.class);
    if (this.w == null)
    {
      this.b.setVisibility(8);
      this.g.setVisibility(8);
      return;
    }
    if (this.w.size() == 0)
    {
      this.b.setVisibility(8);
      this.g.setVisibility(8);
      return;
    }
    this.B = new com.ziroom.ziroomcustomer.account.a.a(this, this.w);
    this.b.setAdapter(this.B);
    this.b.setVisibility(0);
    this.g.setVisibility(0);
  }
  
  private void c(com.alibaba.fastjson.b paramb)
  {
    if (paramb == null)
    {
      this.f.setVisibility(0);
      this.u.setVisibility(8);
      this.a.setVisibility(8);
      return;
    }
    this.v = paramb.toJavaList(Card.class);
    if (this.v == null)
    {
      this.f.setVisibility(0);
      this.u.setVisibility(8);
      this.a.setVisibility(8);
      return;
    }
    if (this.v.size() == 0)
    {
      this.f.setVisibility(0);
      this.u.setVisibility(8);
      this.a.setVisibility(8);
      return;
    }
    this.A = new com.ziroom.ziroomcustomer.account.a.a(this, this.v);
    this.f.setVisibility(8);
    this.u.setVisibility(0);
    this.a.setAdapter(this.A);
    this.a.setVisibility(0);
  }
  
  private void d(com.alibaba.fastjson.b paramb)
  {
    if (paramb == null)
    {
      this.d.setVisibility(8);
      this.s.setVisibility(8);
      return;
    }
    this.y = paramb.toJavaList(Card.class);
    if (this.y == null)
    {
      this.d.setVisibility(8);
      this.s.setVisibility(8);
      return;
    }
    if (this.y.size() == 0)
    {
      this.d.setVisibility(8);
      this.s.setVisibility(8);
      return;
    }
    this.D = new com.ziroom.ziroomcustomer.account.a.a(this, this.y);
    this.d.setAdapter(this.D);
    this.d.setVisibility(0);
    this.s.setVisibility(0);
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.payment.d.b.getIsBandCardResult(this, null, 2, new com.ziroom.ziroomcustomer.payment.d.i(this, new com.ziroom.ziroomcustomer.payment.d.e(p.class))
    {
      public void onSuccess(int paramAnonymousInt, p paramAnonymousp)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousp);
        if (paramAnonymousp.getIsBind() != 0)
        {
          paramAnonymousp = paramAnonymousp.getBindBanks();
          BandCardMangeActivity.i(BandCardMangeActivity.this).clear();
          paramAnonymousp = paramAnonymousp.iterator();
          while (paramAnonymousp.hasNext())
          {
            com.ziroom.ziroomcustomer.payment.b.b localb = (com.ziroom.ziroomcustomer.payment.b.b)paramAnonymousp.next();
            Card localCard = new Card();
            localCard.cardNum = localb.getBankNo();
            localCard.bankNm = localb.getBankName();
            localCard.picUrl = localb.getBankIconApp();
            localCard.cityNum = localb.getCityCode();
            BandCardMangeActivity.i(BandCardMangeActivity.this).add(localCard);
          }
          BandCardMangeActivity.a(BandCardMangeActivity.this, new com.ziroom.ziroomcustomer.account.a.a(BandCardMangeActivity.this, BandCardMangeActivity.i(BandCardMangeActivity.this)));
          BandCardMangeActivity.b(BandCardMangeActivity.this).setAdapter(BandCardMangeActivity.j(BandCardMangeActivity.this));
          BandCardMangeActivity.b(BandCardMangeActivity.this).setVisibility(0);
          BandCardMangeActivity.k(BandCardMangeActivity.this).setVisibility(0);
          return;
        }
        BandCardMangeActivity.b(BandCardMangeActivity.this).setVisibility(8);
        BandCardMangeActivity.k(BandCardMangeActivity.this).setVisibility(8);
      }
    });
  }
  
  private void e(com.alibaba.fastjson.b paramb)
  {
    if (paramb == null)
    {
      this.e.setVisibility(8);
      this.r.setVisibility(8);
      return;
    }
    this.z = paramb.toJavaList(Card.class);
    if (this.z == null)
    {
      this.e.setVisibility(8);
      this.r.setVisibility(8);
      return;
    }
    if (this.z.size() == 0)
    {
      this.e.setVisibility(8);
      this.r.setVisibility(8);
      return;
    }
    this.E = new com.ziroom.ziroomcustomer.account.a.a(this, this.z);
    this.e.setAdapter(this.E);
    this.e.setVisibility(0);
    this.r.setVisibility(0);
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.payment.d.b.getUnionPayReBandCardResult(this, new com.ziroom.ziroomcustomer.payment.d.i(this, new com.ziroom.ziroomcustomer.payment.d.e(Object.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        showProgress();
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            BandCardMangeActivity.9.this.dismissProgress();
            BandCardMangeActivity.l(BandCardMangeActivity.this);
          }
        }, 3000L);
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        BandCardMangeActivity.l(BandCardMangeActivity.this);
      }
    });
  }
  
  private void g()
  {
    showProgress("");
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        BandCardMangeActivity.this.dismissProgress();
        BandCardMangeActivity.m(BandCardMangeActivity.this);
      }
    }, 3000L);
  }
  
  private void h()
  {
    View localView = LayoutInflater.from(this).inflate(2130903834, null);
    TextView localTextView = (TextView)localView.findViewById(2131689850);
    Button localButton1 = (Button)localView.findViewById(2131692249);
    Button localButton2 = (Button)localView.findViewById(2131690460);
    final AlertDialog localAlertDialog = new AlertDialog.Builder(this, 2131427591).create();
    if (!(localAlertDialog instanceof AlertDialog)) {
      localAlertDialog.show();
    }
    for (;;)
    {
      localAlertDialog.getWindow().setContentView(localView);
      localTextView.setText("您确定解绑该银行卡吗？");
      localButton1.setText("确定");
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = com.ziroom.ziroomcustomer.e.g.buildBalance();
          j.getUnbindCards(BandCardMangeActivity.this, new BandCardMangeActivity.a(BandCardMangeActivity.this), paramAnonymousView, true);
          localAlertDialog.dismiss();
        }
      });
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          localAlertDialog.dismiss();
        }
      });
      return;
      VdsAgent.showDialog((AlertDialog)localAlertDialog);
    }
  }
  
  private void i()
  {
    this.f.setOnClickListener(this);
  }
  
  public void getData(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("is_newsign", "0");
    localHashMap.put("cert_type", paramString + "");
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.d.a.get(q.O + e.n.p).tag(this).params(com.ziroom.ziroomcustomer.e.g.getPassportSign(localHashMap)).addHeader("Accept", "application/json; version=1").enqueue(new com.ziroom.commonlibrary.a.a(this, new com.freelxl.baselibrary.d.f.c())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        dismissProgress();
        if ("success".equals(paramAnonymouse.get("status")))
        {
          paramAnonymouse = paramAnonymouse.get("data").toString();
          if ((ae.notNull(paramAnonymouse)) && (paramAnonymouse.length() > 5))
          {
            paramAnonymouse = (SignedInfo)com.alibaba.fastjson.a.parseObject(paramAnonymouse, SignedInfo.class);
            if (paramAnonymouse.getCredits().getRealNameStatus() == 4)
            {
              Intent localIntent = new Intent(BandCardMangeActivity.this, BankcardDetailActivity.class);
              localIntent.putExtra("name", paramAnonymouse.getReal_name());
              BandCardMangeActivity.this.startActivity(localIntent);
              BandCardMangeActivity.this.overridePendingTransition(2130968673, 2130968678);
              return;
            }
            new o(BandCardMangeActivity.this).toDownloadCertificate(5);
            return;
          }
          com.ziroom.commonlibrary.login.a.getUserInfo(BandCardMangeActivity.this, new a.b()
          {
            public void onUserInfo(com.alibaba.fastjson.e paramAnonymous2e)
            {
              if (paramAnonymous2e == null) {
                return;
              }
              paramAnonymous2e = (String)paramAnonymous2e.get("phone");
              if (ae.notNull(paramAnonymous2e))
              {
                Intent localIntent = new Intent(BandCardMangeActivity.this, SignerDataActivity.class);
                localIntent.putExtra("phone", paramAnonymous2e);
                localIntent.putExtra("signData", "signData");
                localIntent.putExtra("account", "account");
                BandCardMangeActivity.this.startActivity(localIntent);
                return;
              }
              com.ziroom.commonlibrary.login.a.startBindPhoneActivity(BandCardMangeActivity.this);
            }
          });
          return;
        }
        BandCardMangeActivity.this.showToast(paramAnonymouse.get("error_message") + "");
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3) {
      a();
    }
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
    getData("");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
    i();
  }
  
  protected void onResume()
  {
    super.onResume();
    a();
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (com.freelxl.baselibrary.b.b)paramk.getObject();
        BandCardMangeActivity.o(BandCardMangeActivity.this).setVisibility(0);
        BandCardMangeActivity.p(BandCardMangeActivity.this).setVisibility(8);
        BandCardMangeActivity.h(BandCardMangeActivity.this).setVisibility(8);
        com.freelxl.baselibrary.f.g.textToast(BandCardMangeActivity.this, "解绑成功");
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(BandCardMangeActivity.this, "解绑失败");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/activity/BandCardMangeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */