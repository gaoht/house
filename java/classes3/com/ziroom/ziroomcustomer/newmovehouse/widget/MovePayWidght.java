package com.ziroom.ziroomcustomer.newmovehouse.widget;

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
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.b.x;
import com.ziroom.ziroomcustomer.newclean.b.x.b;
import com.ziroom.ziroomcustomer.newclean.d.bc;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MHPrivilegeActivity;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveChargeInfo;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveFeeBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveFeeBean.ChargesBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.u;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MovePayWidght
  extends LinearLayout
{
  List<MoveChargeInfo> a = new ArrayList();
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private RelativeLayout g;
  private RelativeLayout h;
  private ListViewForScrollView i;
  private LinearLayout j;
  private LinearLayout k;
  private Context l;
  private MovingVanDetail m;
  private a n;
  private boolean o = true;
  private String p = "pay_wechat";
  private String q;
  private int r = 0;
  private x s;
  private String t;
  private String u;
  private long v = -100L;
  private boolean w;
  
  public MovePayWidght(Context paramContext)
  {
    super(paramContext);
    this.l = paramContext;
  }
  
  public MovePayWidght(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.l = paramContext;
  }
  
  public MovePayWidght(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.l = paramContext;
  }
  
  private void a()
  {
    setOrientation(1);
    View localView = LayoutInflater.from(this.l).inflate(2130904747, null);
    this.b = ((ImageView)localView.findViewById(2131689492));
    this.e = ((TextView)localView.findViewById(2131693764));
    this.i = ((ListViewForScrollView)localView.findViewById(2131696011));
    this.j = ((LinearLayout)localView.findViewById(2131696010));
    this.g = ((RelativeLayout)localView.findViewById(2131696012));
    this.c = ((ImageView)localView.findViewById(2131690724));
    this.h = ((RelativeLayout)localView.findViewById(2131693701));
    this.d = ((ImageView)localView.findViewById(2131696022));
    this.f = ((TextView)localView.findViewById(2131696023));
    this.k = ((LinearLayout)localView.findViewById(2131696009));
    addView(localView);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getUid();
    com.ziroom.ziroomcustomer.e.n.requestServicePayment(this.l, (String)localObject, paramString, 1, paramInt2, paramLong, this.u, this.t, new d(this.l, new f(bc.class))
    {
      public void onSuccess(int paramAnonymousInt, bc paramAnonymousbc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousbc);
        if (MovePayWidght.f(MovePayWidght.this) != null) {
          MovePayWidght.f(MovePayWidght.this).payInfo(paramAnonymousbc);
        }
      }
    });
  }
  
  private void b()
  {
    this.s = new x(this.l, this.a);
    this.i.setAdapter(this.s);
    getMoveFeeInfo();
    this.k.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
      }
    });
    this.h.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MovePayWidght.a(MovePayWidght.this, "pay_wechat");
        MovePayWidght.a(MovePayWidght.this).setBackgroundResource(2130840183);
      }
    });
    this.f.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (MovePayWidght.b(MovePayWidght.this) == -100L) {
          af.showToast(MovePayWidght.c(MovePayWidght.this), "数据请求中");
        }
        long l;
        do
        {
          return;
          paramAnonymousView = MovePayWidght.d(MovePayWidght.this).getEmployeeOrderCode();
          l = MovePayWidght.b(MovePayWidght.this);
          if ("move_xiaomian".equals(MovePayWidght.e(MovePayWidght.this))) {
            MovePayWidght.a(MovePayWidght.this, paramAnonymousView, 1, 6, l);
          }
          if ("move_small".equals(MovePayWidght.e(MovePayWidght.this))) {
            MovePayWidght.a(MovePayWidght.this, paramAnonymousView, 1, 2, l);
          }
        } while (!"move_van".equals(MovePayWidght.e(MovePayWidght.this)));
        MovePayWidght.a(MovePayWidght.this, paramAnonymousView, 1, 4, l);
      }
    });
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (MovePayWidght.f(MovePayWidght.this) != null) {
          MovePayWidght.f(MovePayWidght.this).dialogCancel(true);
        }
      }
    });
    this.g.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MovePayWidght.a(MovePayWidght.this, true);
      }
    });
  }
  
  private void getMoveFeeInfo()
  {
    if (ApplicationEx.c.getUser() == null) {
      return;
    }
    String str2 = this.m.getLogicCode();
    if (this.w) {}
    for (String str1 = "2";; str1 = "1")
    {
      com.ziroom.ziroomcustomer.e.n.getMoveCouponFeeInfo(this.l, str2, this.t, str1, "", new d(this.l, new f(MoveFeeBean.class))
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
              MovePayWidght.a(MovePayWidght.this, paramAnonymousMoveFeeBean.getCharges().getNeedPay().intValue());
            }
          }
          try
          {
            DecimalFormat localDecimalFormat = new DecimalFormat("######0.00");
            MovePayWidght.g(MovePayWidght.this).setText("￥" + localDecimalFormat.format(paramAnonymousMoveFeeBean.getCharges().getNeedPay().intValue() / 100.0D) + "");
            if (TextUtils.isEmpty(paramAnonymousMoveFeeBean.getCouponCode()))
            {
              MovePayWidght.b(MovePayWidght.this, "");
              if (!TextUtils.isEmpty(paramAnonymousMoveFeeBean.getCouponId())) {
                break label316;
              }
              MovePayWidght.c(MovePayWidght.this, "");
              MovePayWidght.this.a.clear();
              MovePayWidght.this.a = j.getMoveFeeChargeList(paramAnonymousMoveFeeBean, MovePayWidght.this.a);
              u.d("sdjdsfdg", "=======  " + com.alibaba.fastjson.a.toJSONString(MovePayWidght.this.a));
              paramAnonymousInt = MovePayWidght.this.a.size();
              MovePayWidght.a(MovePayWidght.this, paramAnonymousInt * com.ziroom.ziroomcustomer.util.n.dip2px(MovePayWidght.c(MovePayWidght.this), 24.0F) + com.ziroom.ziroomcustomer.util.n.dip2px(MovePayWidght.c(MovePayWidght.this), 11.0F));
              MovePayWidght.h(MovePayWidght.this).notifyDataSetChanged();
              MovePayWidght.a(MovePayWidght.this, false);
              MovePayWidght.this.invalidate();
              MovePayWidght.h(MovePayWidght.this).setOnChargeCouponLinstener(new x.b()
              {
                public void couponClick(int paramAnonymous2Int)
                {
                  Intent localIntent = new Intent(MovePayWidght.c(MovePayWidght.this), MHPrivilegeActivity.class);
                  if ("move_xiaomian".equals(MovePayWidght.e(MovePayWidght.this))) {
                    localIntent.putExtra("serviceInfoId", "8a908eb161d66afc0161fa59fd210009");
                  }
                  if ("move_small".equals(MovePayWidght.e(MovePayWidght.this))) {
                    localIntent.putExtra("serviceInfoId", "2c9085f248ba3f3a0148bb156f6e0004");
                  }
                  if ("move_van".equals(MovePayWidght.e(MovePayWidght.this))) {
                    localIntent.putExtra("serviceInfoId", "8a90a5f8593e65b501593e65b5200000");
                  }
                  localIntent.putExtra("code_from", "move_pay");
                  localIntent.putExtra("startTime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(MovePayWidght.d(MovePayWidght.this).getAppointmentTime())));
                  ((Activity)MovePayWidght.c(MovePayWidght.this)).startActivityForResult(localIntent, 22222);
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
              MovePayWidght.b(MovePayWidght.this, paramAnonymousMoveFeeBean.getCouponCode());
              continue;
              label316:
              MovePayWidght.c(MovePayWidght.this, paramAnonymousMoveFeeBean.getCouponId());
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
        if (!this.o) {
          break label49;
        }
        this.o = false;
        j.setShowPartTran(true, this.j, this.r);
        j.showSameArrow(true, this.c);
      }
    }
    label49:
    while ((this.a.size() <= 0) || (!this.o))
    {
      return;
      this.o = true;
      j.setShowPartTran(false, this.j, this.r);
      j.showSameArrow(false, this.c);
      return;
    }
    this.o = false;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.j.getLayoutParams();
    localLayoutParams.height = this.r;
    this.j.setLayoutParams(localLayoutParams);
    j.showSameArrow(true, this.c);
  }
  
  public void setMoveDetailInfo(MovingVanDetail paramMovingVanDetail, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.m = paramMovingVanDetail;
    this.q = paramString1;
    this.t = paramString2;
    this.u = paramString3;
    this.w = paramBoolean2;
    if (paramBoolean1) {
      a();
    }
    b();
  }
  
  public void setMoveSmallPayListener(a parama)
  {
    this.n = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dialogCancel(boolean paramBoolean);
    
    public abstract void payInfo(bc parambc);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/widget/MovePayWidght.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */