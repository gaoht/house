package com.ziroom.ziroomcustomer.newclean.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanStoredCardBuyActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.LeftMoney;
import com.ziroom.ziroomcustomer.newclean.d.au;
import com.ziroom.ziroomcustomer.newclean.d.bc;
import com.ziroom.ziroomcustomer.newclean.d.bh;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveChargeInfo;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CleanPayWidght
  extends LinearLayout
{
  List<MoveChargeInfo> a = new ArrayList();
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private RelativeLayout k;
  private RelativeLayout l;
  private RelativeLayout m;
  private RelativeLayout n;
  private ListViewForScrollView o;
  private LinearLayout p;
  private Context q;
  private au r;
  private a s;
  private String t;
  private long u;
  private boolean v = true;
  private String w = "";
  private int x = 0;
  private LinearLayout y;
  private boolean z;
  
  public CleanPayWidght(Context paramContext)
  {
    super(paramContext);
    this.q = paramContext;
  }
  
  public CleanPayWidght(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.q = paramContext;
  }
  
  public CleanPayWidght(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.q = paramContext;
  }
  
  private void a()
  {
    setOrientation(1);
    View localView = LayoutInflater.from(this.q).inflate(2130904673, null);
    this.b = ((ImageView)localView.findViewById(2131689492));
    this.f = ((TextView)localView.findViewById(2131693764));
    this.o = ((ListViewForScrollView)localView.findViewById(2131696011));
    this.p = ((LinearLayout)localView.findViewById(2131696010));
    this.k = ((RelativeLayout)localView.findViewById(2131696012));
    this.c = ((ImageView)localView.findViewById(2131690724));
    this.l = ((RelativeLayout)localView.findViewById(2131693695));
    this.g = ((TextView)localView.findViewById(2131696016));
    this.h = ((TextView)localView.findViewById(2131696017));
    this.i = ((TextView)localView.findViewById(2131696019));
    this.d = ((ImageView)localView.findViewById(2131696018));
    this.m = ((RelativeLayout)localView.findViewById(2131693701));
    this.e = ((ImageView)localView.findViewById(2131696022));
    this.j = ((TextView)localView.findViewById(2131696023));
    this.n = ((RelativeLayout)localView.findViewById(2131696014));
    this.y = ((LinearLayout)localView.findViewById(2131696009));
    addView(localView);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getUid();
    com.ziroom.ziroomcustomer.e.n.requestServicePayment(this.q, (String)localObject, paramString, 1, 1, paramLong, null, null, new com.ziroom.ziroomcustomer.e.a.d(this.q, new f(bc.class))
    {
      public void onSuccess(int paramAnonymousInt, bc paramAnonymousbc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousbc);
        if (CleanPayWidght.f(CleanPayWidght.this) != null) {
          CleanPayWidght.f(CleanPayWidght.this).payInfo(paramAnonymousbc);
        }
      }
    });
  }
  
  private void b()
  {
    this.t = this.r.getCleanId();
    this.u = this.r.getOrderPrice().intValue();
    this.f.setText("￥" + this.u + ".00");
    d();
    getCleanFeeInfo();
    this.y.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
      }
    });
    this.m.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanPayWidght.a(CleanPayWidght.this, "pay_wechat");
      }
    });
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (TextUtils.isEmpty(CleanPayWidght.a(CleanPayWidght.this))) {
          g.textToast(CleanPayWidght.b(CleanPayWidght.this), "请先选择支付方式");
        }
        do
        {
          return;
          if ("pay_wechat".equals(CleanPayWidght.a(CleanPayWidght.this)))
          {
            long l = CleanPayWidght.c(CleanPayWidght.this);
            CleanPayWidght.a(CleanPayWidght.this, CleanPayWidght.d(CleanPayWidght.this), 1, 1, 100L * l);
          }
        } while (!"pay_card".equals(CleanPayWidght.a(CleanPayWidght.this)));
        CleanPayWidght.e(CleanPayWidght.this);
      }
    });
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (CleanPayWidght.f(CleanPayWidght.this) != null) {
          CleanPayWidght.f(CleanPayWidght.this).dialogCancel(true);
        }
      }
    });
    this.k.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanPayWidght.g(CleanPayWidght.this);
      }
    });
  }
  
  private void c()
  {
    if (this.a.size() > 0)
    {
      if (this.v)
      {
        this.v = false;
        j.setShowPartTran(true, this.p, this.x);
        j.showSameArrow(true, this.c);
      }
    }
    else {
      return;
    }
    this.v = true;
    j.setShowPartTran(false, this.p, this.x);
    j.showSameArrow(false, this.c);
  }
  
  private void d()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    com.ziroom.ziroomcustomer.e.n.requestLeftCardMoney(this.q, localUserInfo.getUid(), "2c9085f24af1d728014b004be6b50d3b", new com.ziroom.ziroomcustomer.e.a.a(this.q, new m(LeftMoney.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, LeftMoney paramAnonymousLeftMoney)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousLeftMoney);
        if (paramAnonymousLeftMoney != null) {
          CleanPayWidght.this.setDialogInfo(paramAnonymousLeftMoney);
        }
      }
    });
  }
  
  private void e()
  {
    f();
  }
  
  private void f()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    com.ziroom.ziroomcustomer.e.n.setGeneralCleanCardPay(this.q, localUserInfo.getUid(), this.t, (float)(this.u * 100L), new com.ziroom.ziroomcustomer.e.a.a(this.q, new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        g.textToast(CleanPayWidght.b(CleanPayWidght.this), "支付成功!");
        if (CleanPayWidght.f(CleanPayWidght.this) != null) {
          CleanPayWidght.f(CleanPayWidght.this).payStatus(true);
        }
      }
    });
  }
  
  private void getCleanFeeInfo()
  {
    if (this.r == null) {
      return;
    }
    com.ziroom.ziroomcustomer.e.n.getGeneralCleanFeeInfo(this.q, this.r.getOrderNum(), new com.ziroom.ziroomcustomer.e.a.a(this.q, new m(bh.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, bh paramAnonymousbh)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousbh);
        if (paramAnonymousbh != null)
        {
          CleanPayWidght.this.a.clear();
          CleanPayWidght.this.a = j.getServeChareList(paramAnonymousbh, CleanPayWidght.this.a);
          paramAnonymousInt = CleanPayWidght.this.a.size();
          CleanPayWidght.a(CleanPayWidght.this, paramAnonymousInt * com.ziroom.ziroomcustomer.util.n.dip2px(CleanPayWidght.b(CleanPayWidght.this), 24.0F) + com.ziroom.ziroomcustomer.util.n.dip2px(CleanPayWidght.b(CleanPayWidght.this), 11.0F) + com.ziroom.ziroomcustomer.util.n.dip2px(CleanPayWidght.b(CleanPayWidght.this), 20.0F));
          paramAnonymousbh = new com.ziroom.ziroomcustomer.newmovehouse.b.d(CleanPayWidght.b(CleanPayWidght.this), CleanPayWidght.this.a);
          CleanPayWidght.h(CleanPayWidght.this).setAdapter(paramAnonymousbh);
        }
      }
    });
  }
  
  private void setCleanPayType(String paramString)
  {
    this.w = paramString;
    if ("pay_card".equals(paramString))
    {
      this.e.setBackgroundResource(2130840184);
      this.d.setBackgroundResource(2130840183);
    }
    while (!"pay_wechat".equals(paramString)) {
      return;
    }
    this.e.setBackgroundResource(2130840183);
    this.d.setBackgroundResource(2130840184);
  }
  
  public void setCleanDetail(au paramau, boolean paramBoolean)
  {
    this.r = paramau;
    this.z = paramBoolean;
    if (!this.z) {
      a();
    }
    b();
  }
  
  public void setCleanPayListener(a parama)
  {
    this.s = parama;
  }
  
  public void setDialogInfo(LeftMoney paramLeftMoney)
  {
    long l1 = Long.parseLong(paramLeftMoney.getAmount()) / 100L;
    int i1 = this.r.getOrderPrice().intValue();
    DecimalFormat localDecimalFormat = new DecimalFormat("######0.00");
    this.g.setText("自如保洁卡支付(余额" + localDecimalFormat.format(l1) + "元)");
    this.h.setText(paramLeftMoney.getPromotionReminderDocument());
    if (l1 < i1)
    {
      setCleanPayType("pay_wechat");
      this.i.setVisibility(0);
      this.d.setVisibility(8);
      this.n.setAlpha(0.5F);
      this.l.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
        }
      });
      this.i.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (CleanPayWidght.f(CleanPayWidght.this) != null) {
            CleanPayWidght.f(CleanPayWidght.this).payToCard(true);
          }
          new Thread()
          {
            public void run()
            {
              super.run();
              try
              {
                Thread.sleep(300L);
                Intent localIntent = new Intent(CleanPayWidght.b(CleanPayWidght.this), CleanStoredCardBuyActivity.class);
                CleanPayWidght.b(CleanPayWidght.this).startActivity(localIntent);
                return;
              }
              catch (InterruptedException localInterruptedException)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }.start();
        }
      });
      return;
    }
    setCleanPayType("pay_card");
    this.g.setTextColor(-12303292);
    this.i.setVisibility(8);
    this.d.setVisibility(0);
    this.n.setAlpha(1.0F);
    this.l.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanPayWidght.a(CleanPayWidght.this, "pay_card");
      }
    });
  }
  
  public static abstract interface a
  {
    public abstract void dialogCancel(boolean paramBoolean);
    
    public abstract void payInfo(bc parambc);
    
    public abstract void payStatus(boolean paramBoolean);
    
    public abstract void payToCard(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/view/CleanPayWidght.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */