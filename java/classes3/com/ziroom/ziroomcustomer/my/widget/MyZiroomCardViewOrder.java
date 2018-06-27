package com.ziroom.ziroomcustomer.my.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.dialog.c;
import com.ziroom.ziroomcustomer.dialog.c.a;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.a.d;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.e.m;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.KeeperInfo;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.model.ReserveBean;
import com.ziroom.ziroomcustomer.reserve.BookingOrderListActivity;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MyZiroomCardViewOrder
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
  private ReserveBean n;
  private String o = "";
  
  public MyZiroomCardViewOrder(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MyZiroomCardViewOrder(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MyZiroomCardViewOrder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }
  
  private void b()
  {
    c.newBuilder(this.l).setButtonText("我再想想").setSecondButtonText("确认").setContent("好房不等人，确认要关闭预订单么？").setOnSecondClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MyZiroomCardViewOrder.a(MyZiroomCardViewOrder.this, q.s + e.m.j);
        paramAnonymousView = com.ziroom.ziroomcustomer.e.g.buildGetreserveCloseOrder(MyZiroomCardViewOrder.a(MyZiroomCardViewOrder.this).getServeCode());
        j.getReservationOrderText(MyZiroomCardViewOrder.b(MyZiroomCardViewOrder.this), new MyZiroomCardViewOrder.a(MyZiroomCardViewOrder.this), paramAnonymousView, true, MyZiroomCardViewOrder.c(MyZiroomCardViewOrder.this));
      }
    }).build().show();
  }
  
  private void c()
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(this.n.getHousePhoto());
    localObject = new HouseDetail(this.n.getHouseType(), (List)localObject, this.n.getHousePrice() + "", this.n.getHouseAddress(), this.n.getIsShort(), this.n.getHouseCode(), this.n.getHouseId());
    ((HouseDetail)localObject).setCityCode(b.d);
    new o(this.l).toSign((HouseDetail)localObject, 1);
  }
  
  private void d()
  {
    if ((this.n == null) || (this.n.getResblockId() == null)) {
      return;
    }
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null)
    {
      localUserInfo.getUid();
      localUserInfo.getPhone();
      localUserInfo.getRealName();
    }
    new f(this.l, new m(KeeperInfo.class, new d()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, KeeperInfo paramAnonymousKeeperInfo)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousKeeperInfo);
        if (!TextUtils.isEmpty(paramAnonymousKeeperInfo.getKeeperPhone()))
        {
          ah.callPhone(MyZiroomCardViewOrder.b(MyZiroomCardViewOrder.this), paramAnonymousKeeperInfo.getKeeperPhone());
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(MyZiroomCardViewOrder.b(MyZiroomCardViewOrder.this), "未获取到管家电话！");
      }
    };
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
    case 2131691838: 
      paramView = new Intent(this.l, RentHouseDetailActivity.class);
      paramView.putExtra("house_id", this.n.getHouseId());
      paramView.putExtra("id", this.n.getHouseCode());
      this.l.startActivity(paramView);
      return;
    case 2131695426: 
      b();
      return;
    }
    switch (this.n.getOrderStatus())
    {
    default: 
      return;
    case 2: 
      paramView = new Intent(this.l, HouseBillInfoActivity.class);
      paramView.putExtra("uniqueCode", this.n.getServeCode());
      paramView.putExtra("period", "");
      paramView.putExtra("payType", "pzyd");
      paramView.putExtra("mContentText", "倒计时结束之前，您可以在“我的订单”里找到待支付的长租预订单进行支付。");
      this.l.startActivity(paramView);
      return;
    case 3: 
      d();
      return;
    }
    if (1 == this.n.getCanSign())
    {
      c();
      return;
    }
    d();
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
  
  public void setReserveBean(ReserveBean paramReserveBean)
  {
    if (paramReserveBean == null)
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    this.n = paramReserveBean;
    setCount(paramReserveBean.getReserveCount());
    this.e.setText(paramReserveBean.getHouseAddress());
    SpannableString localSpannableString;
    try
    {
      Object localObject = new Date(Long.parseLong(paramReserveBean.getCanSignDate() + "000"));
      localObject = new SimpleDateFormat("yyyy-MM-dd").format((Date)localObject);
      this.f.setText("预计可入住时间：" + (String)localObject);
      if (this.n.getCanClose() == 1) {
        this.i.setVisibility(0);
      }
      setCount(paramReserveBean.getReserveCount());
      if (TextUtils.isEmpty(paramReserveBean.getPromptTag()))
      {
        this.k.setVisibility(8);
        switch (this.n.getOrderStatus())
        {
        default: 
          return;
        case 2: 
          this.j.setText("去支付");
          try
          {
            paramReserveBean = new Date(Long.parseLong(paramReserveBean.getLastPayTime() + "000"));
            paramReserveBean = new SimpleDateFormat("MM月dd日HH:mm").format(paramReserveBean);
            localObject = new SpannableString("请在" + paramReserveBean + "前完成支付");
            ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#FFC743")), 2, paramReserveBean.length() + 2, 18);
            this.g.setText((CharSequence)localObject);
            return;
          }
          catch (Exception paramReserveBean)
          {
            setVisibility(8);
            paramReserveBean.printStackTrace();
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        setVisibility(8);
        localException.printStackTrace();
        continue;
        this.k.setVisibility(0);
        this.k.setText(paramReserveBean.getPromptTag());
      }
      this.j.setText("联系管家");
      try
      {
        paramReserveBean = new Date(Long.parseLong(paramReserveBean.getCanSignDate() + "000"));
        paramReserveBean = new SimpleDateFormat("MM月dd日").format(paramReserveBean);
        localSpannableString = new SpannableString("预计" + paramReserveBean + "可签约");
        localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFC743")), 2, paramReserveBean.length() + 2, 18);
        this.g.setText(localSpannableString);
        return;
      }
      catch (Exception paramReserveBean)
      {
        setVisibility(8);
        paramReserveBean.printStackTrace();
        return;
      }
      if (1 != paramReserveBean.getCanSign()) {
        break label658;
      }
    }
    this.j.setText("签约");
    for (;;)
    {
      try
      {
        paramReserveBean = new Date(Long.parseLong(paramReserveBean.getLastSignTime() + "000"));
        paramReserveBean = new SimpleDateFormat("MM月dd日HH:mm").format(paramReserveBean);
        localSpannableString = new SpannableString("请在" + paramReserveBean + "前完成签约");
        localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFC743")), 2, paramReserveBean.length() + 2, 18);
        this.g.setText(localSpannableString);
        return;
      }
      catch (Exception paramReserveBean)
      {
        setVisibility(8);
        paramReserveBean.printStackTrace();
        return;
      }
      label658:
      this.j.setText("联系管家");
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (MyZiroomCardViewOrder.c(MyZiroomCardViewOrder.this).equals(paramk.getUrl()))
        {
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(null);
        }
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      paramk = paramk.getMessage();
      if (!ae.isNull(paramk)) {
        com.freelxl.baselibrary.f.g.textToast(MyZiroomCardViewOrder.b(MyZiroomCardViewOrder.this), "" + paramk, 0);
      }
      paramk = new Intent(MyZiroomCardViewOrder.b(MyZiroomCardViewOrder.this), MainActivity.class);
      paramk.putExtra("FRAGMENT_TYPE", 7);
      MyZiroomCardViewOrder.b(MyZiroomCardViewOrder.this).startActivity(paramk);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/MyZiroomCardViewOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */