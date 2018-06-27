package com.ziroom.ziroomcustomer.newmovehouse.c;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.newServiceList.utils.h;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newmovehouse.b.b;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceDate;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceDate.DataBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceDate.DataBean.MoveOrderDateBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanTimePeriodBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanTimePeriodBean.MoveOrderTimeBean;
import com.ziroom.ziroomcustomer.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class a
  extends Dialog
{
  private Context a;
  private HorizontalListView b;
  private ImageView c;
  private MyGridView d;
  private TextView e;
  private TextView f;
  private List<MHServiceDate.DataBean.MoveOrderDateBean> g;
  private b h;
  private a i;
  private List<MovingVanTimePeriodBean.MoveOrderTimeBean> j = new ArrayList();
  private com.ziroom.ziroomcustomer.newmovehouse.b.j k;
  private long l;
  private long m;
  private boolean n = false;
  private String o = "";
  
  public a(Context paramContext, long paramLong1, long paramLong2, String paramString)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.m = paramLong1;
    this.l = paramLong2;
    this.o = paramString;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903827, null);
    this.b = ((HorizontalListView)localView.findViewById(2131691794));
    this.c = ((ImageView)localView.findViewById(2131690588));
    this.d = ((MyGridView)localView.findViewById(2131693850));
    this.e = ((TextView)localView.findViewById(2131689956));
    this.f = ((TextView)localView.findViewById(2131689837));
    b();
    setContentView(localView);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.h != null)
    {
      this.h.setSelectPosition(paramInt);
      this.m = ((MHServiceDate.DataBean.MoveOrderDateBean)this.g.get(paramInt)).getDateKey();
      if (paramBoolean)
      {
        this.l = 0L;
        this.o = "";
        this.e.setBackgroundColor(Color.parseColor("#dddddd"));
      }
      this.k.setmSelectPosition(-1);
    }
    long l1 = ((MHServiceDate.DataBean.MoveOrderDateBean)this.g.get(paramInt)).getDateKey();
    com.ziroom.ziroomcustomer.e.n.getMovingVanTimePeriod(this.a, "2c9085f248ba3f3a0148bb151aca0003", "8a90a5f8593e65b501593e65b5200000", l1, new d(this.a, new f(MovingVanTimePeriodBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MovingVanTimePeriodBean paramAnonymousMovingVanTimePeriodBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMovingVanTimePeriodBean);
        if ((paramAnonymousMovingVanTimePeriodBean != null) && (paramAnonymousMovingVanTimePeriodBean.getMoveOrderTime() != null) && (paramAnonymousMovingVanTimePeriodBean.getMoveOrderTime().size() > 0))
        {
          a.b(a.this, paramAnonymousMovingVanTimePeriodBean.getMoveOrderTime());
          a.b(a.this).setData(paramAnonymousMovingVanTimePeriodBean.getMoveOrderTime());
          if (a.k(a.this)) {
            paramAnonymousInt = 0;
          }
        }
        for (;;)
        {
          if (paramAnonymousInt < a.a(a.this).size())
          {
            if (((MovingVanTimePeriodBean.MoveOrderTimeBean)a.a(a.this).get(paramAnonymousInt)).getTimePointKey() != a.e(a.this)) {
              break label188;
            }
            if (((MovingVanTimePeriodBean.MoveOrderTimeBean)a.a(a.this).get(paramAnonymousInt)).getHaveCapacity() == 1) {
              break label174;
            }
            a.a(a.this, 0L);
            a.a(a.this, "");
            a.b(a.this, 0L);
          }
          for (;;)
          {
            a.a(a.this, false);
            return;
            label174:
            a.b(a.this).setmSelectPosition(paramAnonymousInt);
          }
          label188:
          paramAnonymousInt += 1;
        }
      }
    });
  }
  
  private void b()
  {
    if ((this.m > 0L) && (this.l > 0L)) {
      this.n = true;
    }
    for (;;)
    {
      this.h = new b(this.a, this.g);
      this.b.setAdapter(this.h);
      c();
      this.k = new com.ziroom.ziroomcustomer.newmovehouse.b.j(this.a, this.j);
      this.d.setVerticalSpacing(com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 16.0F));
      this.d.setAdapter(this.k);
      com.ziroom.ziroomcustomer.newServiceList.utils.j.getServiceCalendarTip(this.a, "move", this.f);
      setListener();
      return;
      this.e.setBackgroundColor(Color.parseColor("#dddddd"));
    }
  }
  
  private void c()
  {
    o.requestMoveDates(this.a, "8a90a5f8593e65b501593e65b5200000", new com.ziroom.commonlibrary.a.a(this.a, new h(MHServiceDate.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        g.textToast(a.d(a.this), "服务器异常，正在努力抢修中，请稍后再试!");
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        paramAnonymousObject = (MHServiceDate)paramAnonymousObject;
        int i;
        if ((paramAnonymousObject != null) && ("0".equals(((MHServiceDate)paramAnonymousObject).getStatus())) && (((MHServiceDate)paramAnonymousObject).getData() != null))
        {
          a.a(a.this, ((MHServiceDate)paramAnonymousObject).getData().getMoveOrderDate());
          a.j(a.this).setData(a.i(a.this));
          if (a.k(a.this))
          {
            paramAnonymousInt = 0;
            if (paramAnonymousInt >= a.i(a.this).size()) {
              break label228;
            }
            if (((MHServiceDate.DataBean.MoveOrderDateBean)a.i(a.this).get(paramAnonymousInt)).getDateKey() == a.g(a.this))
            {
              i = 1;
              a.a(a.this, paramAnonymousInt, false);
            }
          }
        }
        label228:
        for (paramAnonymousInt = i;; paramAnonymousInt = 0)
        {
          if (paramAnonymousInt == 0) {
            a.a(a.this, 0, false);
          }
          return;
          paramAnonymousInt += 1;
          break;
          a.a(a.this, 0, false);
          return;
          if ((paramAnonymousObject != null) && (!TextUtils.isEmpty(((MHServiceDate)paramAnonymousObject).getMessage())))
          {
            g.textToast(a.d(a.this), ((MHServiceDate)paramAnonymousObject).getMessage());
            a.a(a.this, false);
            return;
          }
          g.textToast(a.d(a.this), "网络数据请求失败!");
          a.a(a.this, false);
          return;
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDefaultSetting()
  {
    setCanceledOnTouchOutside(true);
    Window localWindow = getWindow();
    localWindow.setWindowAnimations(2131427962);
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
  }
  
  public void setListener()
  {
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        a.this.dismiss();
      }
    });
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        a.a(a.this, paramAnonymousInt, true);
      }
    });
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (((MovingVanTimePeriodBean.MoveOrderTimeBean)a.a(a.this).get(paramAnonymousInt)).getHaveCapacity() == 1)
        {
          if (a.b(a.this) != null) {
            a.b(a.this).setmSelectPosition(paramAnonymousInt);
          }
          a.a(a.this, ((MovingVanTimePeriodBean.MoveOrderTimeBean)a.a(a.this).get(paramAnonymousInt)).getTimePointKey());
          a.a(a.this, ((MovingVanTimePeriodBean.MoveOrderTimeBean)a.a(a.this).get(paramAnonymousInt)).getTimePointValue());
          a.c(a.this).setBackgroundColor(Color.parseColor("#ffa000"));
          return;
        }
        g.textToast(a.d(a.this), "已约满，请选择其他时间");
      }
    });
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (a.e(a.this) == 0L) {
          g.textToast(a.d(a.this), "请先选择时间");
        }
        do
        {
          return;
          a.this.dismiss();
        } while (a.f(a.this) == null);
        a.f(a.this).showSelect(a.g(a.this), a.e(a.this), a.h(a.this));
      }
    });
  }
  
  public void setmListener(a parama)
  {
    this.i = parama;
  }
  
  public static abstract interface a
  {
    public abstract void showSelect(long paramLong1, long paramLong2, String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */