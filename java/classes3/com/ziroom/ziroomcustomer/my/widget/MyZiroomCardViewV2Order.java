package com.ziroom.ziroomcustomer.my.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.AccountMainActivity;
import com.ziroom.ziroomcustomer.my.model.ReserveV2Bean;
import com.ziroom.ziroomcustomer.my.model.ReserveV2Bean.BtnBean;
import com.ziroom.ziroomcustomer.reserve.BookingOrderListActivity;
import com.ziroom.ziroomcustomer.sublet.activity.SubletReservationDetailActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.List;

public class MyZiroomCardViewV2Order
  extends LinearLayout
  implements View.OnClickListener
{
  View a;
  TextView b;
  TextView c;
  ImageView d;
  TextView e;
  TextView f;
  TextView g;
  LinearLayout h;
  TextView i;
  TextView j;
  TextView k;
  private Context l;
  private float m;
  private ReserveV2Bean n;
  
  public MyZiroomCardViewV2Order(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MyZiroomCardViewV2Order(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MyZiroomCardViewV2Order(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.l = paramContext;
    this.m = this.l.getResources().getDisplayMetrics().density;
    a();
  }
  
  private void a()
  {
    setOrientation(1);
    inflate(this.l, 2130904394, this);
    setBackgroundColor(Color.parseColor("#ffffff"));
    this.a = findViewById(2131695422);
    this.b = ((TextView)findViewById(2131689541));
    this.c = ((TextView)findViewById(2131690326));
    this.d = ((ImageView)findViewById(2131690724));
    this.e = ((TextView)findViewById(2131695423));
    this.f = ((TextView)findViewById(2131695424));
    this.g = ((TextView)findViewById(2131695425));
    this.h = ((LinearLayout)findViewById(2131691838));
    this.i = ((TextView)findViewById(2131695426));
    this.j = ((TextView)findViewById(2131695427));
    this.k = ((TextView)findViewById(2131689835));
    this.a.setBackgroundColor(Color.parseColor("#FFC743"));
    this.b.setText("预订单");
    this.i.setText("关闭订单");
    this.i.setVisibility(8);
    this.i.setTextColor(this.l.getResources().getColor(2131624415));
    this.i.setBackgroundResource(2130837969);
    this.j.setTextColor(Color.parseColor("#E8AC1E"));
    this.j.setBackgroundResource(2130837973);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.h.setOnClickListener(this);
  }
  
  private void a(TextView paramTextView, final ReserveV2Bean.BtnBean paramBtnBean)
  {
    if (paramTextView.getVisibility() != 0) {
      paramTextView.setVisibility(0);
    }
    paramTextView.setText(paramBtnBean.title);
    paramTextView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = paramBtnBean.type;
        int i = -1;
        switch (paramAnonymousView.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            return;
            if (paramAnonymousView.equals("phone"))
            {
              i = 0;
              continue;
              if (paramAnonymousView.equals("reserveDetail"))
              {
                i = 1;
                continue;
                if (paramAnonymousView.equals("draw")) {
                  i = 2;
                }
              }
            }
            break;
          }
        }
        ah.callPhone(MyZiroomCardViewV2Order.a(MyZiroomCardViewV2Order.this), paramBtnBean.buttonValue);
        return;
        paramAnonymousView = new Intent(MyZiroomCardViewV2Order.a(MyZiroomCardViewV2Order.this), SubletReservationDetailActivity.class);
        paramAnonymousView.putExtra("reserveCode", paramBtnBean.buttonValue);
        MyZiroomCardViewV2Order.a(MyZiroomCardViewV2Order.this).startActivity(paramAnonymousView);
        return;
        paramAnonymousView = new Intent(MyZiroomCardViewV2Order.a(MyZiroomCardViewV2Order.this), AccountMainActivity.class);
        MyZiroomCardViewV2Order.a(MyZiroomCardViewV2Order.this).startActivity(paramAnonymousView);
      }
    });
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (ae.notNull(paramString))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText(paramString);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void b()
  {
    this.i.setVisibility(8);
    if ((this.n != null) && (this.n.buttons != null) && (this.n.buttons.size() > 0))
    {
      if (this.n.buttons.size() == 1) {
        a(this.j, (ReserveV2Bean.BtnBean)this.n.buttons.get(0));
      }
    }
    else {
      return;
    }
    a(this.i, (ReserveV2Bean.BtnBean)this.n.buttons.get(0));
    a(this.j, (ReserveV2Bean.BtnBean)this.n.buttons.get(1));
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.n == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690326: 
    case 2131690724: 
      paramView = new Intent(this.l, BookingOrderListActivity.class);
      paramView.putExtra("from", "orders");
      this.l.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.l, SubletReservationDetailActivity.class);
    paramView.putExtra("reserveCode", this.n.serveCode);
    this.l.startActivity(paramView);
  }
  
  public void setCount(int paramInt)
  {
    if (paramInt > 1)
    {
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  public void setReserveBean(ReserveV2Bean paramReserveV2Bean)
  {
    if (paramReserveV2Bean == null)
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    this.n = paramReserveV2Bean;
    setCount(paramReserveV2Bean.reserveCount);
    a(this.e, paramReserveV2Bean.firstTitle);
    a(this.f, paramReserveV2Bean.secondTitle);
    a(this.g, paramReserveV2Bean.thirdTitle);
    if (TextUtils.isEmpty(paramReserveV2Bean.promptTag)) {
      this.k.setVisibility(8);
    }
    for (;;)
    {
      b();
      return;
      this.k.setVisibility(0);
      this.k.setText(paramReserveV2Bean.promptTag);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/MyZiroomCardViewV2Order.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */