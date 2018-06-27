package com.ziroom.ziroomcustomer.newclean.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.activity.CleanCouponActivity;
import com.ziroom.ziroomcustomer.newclean.b.x;
import com.ziroom.ziroomcustomer.newclean.b.x.b;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanStoredCardBuyActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.LeftMoney;
import com.ziroom.ziroomcustomer.newclean.d.bc;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralDetailBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveChargeInfo;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveFeeBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveFeeBean.ChargesBean;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.u;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PeriodCleanPayWidght
  extends LinearLayout
{
  private String A;
  private x B;
  private String C;
  private boolean D;
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
  private PeriodGeneralDetailBean r;
  private a s;
  private String t;
  private long u;
  private boolean v = true;
  private String w = "";
  private int x = 0;
  private LinearLayout y;
  private String z;
  
  public PeriodCleanPayWidght(Context paramContext)
  {
    super(paramContext);
    this.q = paramContext;
  }
  
  public PeriodCleanPayWidght(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.q = paramContext;
  }
  
  public PeriodCleanPayWidght(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.q = paramContext;
  }
  
  private void a()
  {
    setOrientation(1);
    View localView = LayoutInflater.from(this.q).inflate(2130904763, null);
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
    com.ziroom.ziroomcustomer.e.n.requestServicePayment(this.q, (String)localObject, paramString, 1, 1, paramLong, this.z, this.A, new d(this.q, new f(bc.class))
    {
      public void onSuccess(int paramAnonymousInt, bc paramAnonymousbc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousbc);
        if (PeriodCleanPayWidght.a(PeriodCleanPayWidght.this) != null) {
          PeriodCleanPayWidght.a(PeriodCleanPayWidght.this).payInfo(paramAnonymousbc);
        }
      }
    });
  }
  
  private void b()
  {
    if (this.r == null) {
      return;
    }
    this.C = this.r.getAppointDateTime();
    this.t = this.r.getOrderNum();
    getCleanFeeInfo();
    this.B = new x(this.q, this.a);
    this.o.setAdapter(this.B);
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (PeriodCleanPayWidght.a(PeriodCleanPayWidght.this) != null) {
          PeriodCleanPayWidght.a(PeriodCleanPayWidght.this).dialogCancel(true);
        }
      }
    });
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
        PeriodCleanPayWidght.a(PeriodCleanPayWidght.this, "pay_wechat");
      }
    });
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (TextUtils.isEmpty(PeriodCleanPayWidght.b(PeriodCleanPayWidght.this))) {
          g.textToast(PeriodCleanPayWidght.c(PeriodCleanPayWidght.this), "请先选择支付方式");
        }
        do
        {
          return;
          if ("pay_wechat".equals(PeriodCleanPayWidght.b(PeriodCleanPayWidght.this)))
          {
            long l = PeriodCleanPayWidght.d(PeriodCleanPayWidght.this);
            u.d("sjdkgj", "=========  money=" + l);
            PeriodCleanPayWidght.a(PeriodCleanPayWidght.this, PeriodCleanPayWidght.e(PeriodCleanPayWidght.this), 1, 5, l);
          }
        } while (!"pay_card".equals(PeriodCleanPayWidght.b(PeriodCleanPayWidght.this)));
        PeriodCleanPayWidght.f(PeriodCleanPayWidght.this);
      }
    });
    this.k.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        PeriodCleanPayWidght.a(PeriodCleanPayWidght.this, true);
      }
    });
  }
  
  private void c()
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
          PeriodCleanPayWidght.this.setDialogInfo(paramAnonymousLeftMoney);
        }
      }
    });
  }
  
  private void d()
  {
    c.newBuilder(this.q).setTitle("提示").setContent("您将使用自如保洁卡支付").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          PeriodCleanPayWidght.k(PeriodCleanPayWidght.this);
        }
      }
    }).build().show();
  }
  
  private void e()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    com.ziroom.ziroomcustomer.e.n.requestCleanCardPay(this.q, localUserInfo.getUid(), this.t, (float)this.u, this.z, this.A, 5, new com.ziroom.ziroomcustomer.e.a.a(this.q, new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        af.showToast(PeriodCleanPayWidght.c(PeriodCleanPayWidght.this), "支付成功!");
        if (PeriodCleanPayWidght.a(PeriodCleanPayWidght.this) != null) {
          PeriodCleanPayWidght.a(PeriodCleanPayWidght.this).payStatus(true);
        }
      }
    });
  }
  
  private void getCleanFeeInfo()
  {
    if (this.r == null) {
      return;
    }
    String str2 = this.r.getOrderNum();
    if (this.D) {}
    for (String str1 = "2";; str1 = "1")
    {
      com.ziroom.ziroomcustomer.e.n.getMoveCouponFeeInfo(this.q, str2, this.A, str1, this.r.getAddressId(), new d(this.q, new f(MoveFeeBean.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, MoveFeeBean paramAnonymousMoveFeeBean)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousMoveFeeBean);
          if (paramAnonymousMoveFeeBean != null) {
            if (paramAnonymousMoveFeeBean.getCharges() != null) {
              PeriodCleanPayWidght.a(PeriodCleanPayWidght.this, paramAnonymousMoveFeeBean.getCharges().getNeedPay().intValue());
            }
          }
          try
          {
            DecimalFormat localDecimalFormat = new DecimalFormat("######0.00");
            PeriodCleanPayWidght.g(PeriodCleanPayWidght.this).setText("¥" + localDecimalFormat.format(PeriodCleanPayWidght.d(PeriodCleanPayWidght.this) / 100L) + "");
            PeriodCleanPayWidght.h(PeriodCleanPayWidght.this);
            if (TextUtils.isEmpty(paramAnonymousMoveFeeBean.getCouponCode()))
            {
              PeriodCleanPayWidght.b(PeriodCleanPayWidght.this, "");
              if (!TextUtils.isEmpty(paramAnonymousMoveFeeBean.getCouponId())) {
                break label308;
              }
              PeriodCleanPayWidght.c(PeriodCleanPayWidght.this, "");
              PeriodCleanPayWidght.this.a.clear();
              PeriodCleanPayWidght.a(PeriodCleanPayWidght.this, 0);
              PeriodCleanPayWidght.this.a = j.getMoveFeeChargeList(paramAnonymousMoveFeeBean, PeriodCleanPayWidght.this.a);
              paramAnonymousInt = PeriodCleanPayWidght.this.a.size();
              PeriodCleanPayWidght.a(PeriodCleanPayWidght.this, paramAnonymousInt * com.ziroom.ziroomcustomer.util.n.dip2px(PeriodCleanPayWidght.c(PeriodCleanPayWidght.this), 24.0F) + com.ziroom.ziroomcustomer.util.n.dip2px(PeriodCleanPayWidght.c(PeriodCleanPayWidght.this), 11.0F) + com.ziroom.ziroomcustomer.util.n.dip2px(PeriodCleanPayWidght.c(PeriodCleanPayWidght.this), 20.0F));
              PeriodCleanPayWidght.i(PeriodCleanPayWidght.this).notifyDataSetChanged();
              PeriodCleanPayWidght.a(PeriodCleanPayWidght.this, false);
              PeriodCleanPayWidght.this.invalidate();
              PeriodCleanPayWidght.i(PeriodCleanPayWidght.this).setOnChargeCouponLinstener(new x.b()
              {
                public void couponClick(int paramAnonymous2Int)
                {
                  if (PeriodCleanPayWidght.a(PeriodCleanPayWidght.this) != null) {
                    PeriodCleanPayWidght.a(PeriodCleanPayWidght.this).payToCoupon(true);
                  }
                  Intent localIntent = new Intent(PeriodCleanPayWidght.10.a(PeriodCleanPayWidght.10.this), CleanCouponActivity.class);
                  localIntent.putExtra("serviceInfoId", "2c9084454b7835b0014b7841269101a9");
                  localIntent.putExtra("addressId", PeriodCleanPayWidght.j(PeriodCleanPayWidght.this).getAddressId());
                  localIntent.putExtra("serviceItemCode", "");
                  localIntent.putExtra("startTime", PeriodCleanPayWidght.j(PeriodCleanPayWidght.this).getAppointDateTime());
                  localIntent.putExtra("isFrom", "from_period_pay");
                  ((Activity)PeriodCleanPayWidght.c(PeriodCleanPayWidght.this)).startActivityForResult(localIntent, 11111);
                }
              });
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              continue;
              PeriodCleanPayWidght.b(PeriodCleanPayWidght.this, paramAnonymousMoveFeeBean.getCouponCode());
              continue;
              label308:
              PeriodCleanPayWidght.c(PeriodCleanPayWidght.this, paramAnonymousMoveFeeBean.getCouponId());
            }
          }
        }
      });
      return;
    }
  }
  
  private void setChareInfo(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.a.size() > 0)
      {
        if (!this.v) {
          break label49;
        }
        this.v = false;
        j.setShowPartTran(true, this.p, this.x);
        j.showSameArrow(true, this.c);
      }
    }
    label49:
    while ((this.a.size() <= 0) || (!this.v))
    {
      return;
      this.v = true;
      j.setShowPartTran(false, this.p, this.x);
      j.showSameArrow(false, this.c);
      return;
    }
    this.v = false;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.p.getLayoutParams();
    localLayoutParams.height = this.x;
    this.p.setLayoutParams(localLayoutParams);
    j.showSameArrow(true, this.c);
  }
  
  private void setCleanPayType(String paramString)
  {
    this.w = paramString;
    u.d("sdjgkld", "========setCleanPayType    " + paramString);
    if ("pay_card".equals(paramString))
    {
      this.e.setBackgroundResource(2130840184);
      this.d.setBackgroundResource(2130840183);
    }
    while (!"pay_wechat".equals(paramString)) {
      return;
    }
    u.d("sdjgkld", "========setCleanPayType    1111");
    this.e.setBackgroundResource(2130840183);
    this.d.setBackgroundResource(2130840184);
  }
  
  public void setCleanDetail(PeriodGeneralDetailBean paramPeriodGeneralDetailBean, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    this.r = paramPeriodGeneralDetailBean;
    this.z = paramString1;
    this.A = paramString2;
    this.D = paramBoolean2;
    if (paramBoolean1) {
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
    long l2 = this.u / 100L;
    DecimalFormat localDecimalFormat = new DecimalFormat("######0.00");
    this.g.setText("自如保洁卡支付(余额" + localDecimalFormat.format(l1) + "元)");
    this.h.setText(paramLeftMoney.getPromotionReminderDocument());
    if (l1 < l2)
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
          if (PeriodCleanPayWidght.a(PeriodCleanPayWidght.this) != null) {
            PeriodCleanPayWidght.a(PeriodCleanPayWidght.this).payToCard(true);
          }
          new Thread()
          {
            public void run()
            {
              super.run();
              try
              {
                Thread.sleep(300L);
                Intent localIntent = new Intent(PeriodCleanPayWidght.c(PeriodCleanPayWidght.this), CleanStoredCardBuyActivity.class);
                PeriodCleanPayWidght.c(PeriodCleanPayWidght.this).startActivity(localIntent);
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
    }
    for (;;)
    {
      invalidate();
      return;
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
          PeriodCleanPayWidght.a(PeriodCleanPayWidght.this, "pay_card");
        }
      });
    }
  }
  
  public static abstract interface a
  {
    public abstract void dialogCancel(boolean paramBoolean);
    
    public abstract void payInfo(bc parambc);
    
    public abstract void payStatus(boolean paramBoolean);
    
    public abstract void payToCard(boolean paramBoolean);
    
    public abstract void payToCoupon(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/view/PeriodCleanPayWidght.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */