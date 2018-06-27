package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.content.LocalBroadcastManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean.TonightDiscountInfoVoBean;
import com.ziroom.ziroomcustomer.minsu.c.a.a;
import com.ziroom.ziroomcustomer.minsu.c.c;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.util.u;

public class TodaySecialView
  extends RelativeLayout
{
  private final int a = 3600000;
  private final int b = 60000;
  private final int c = 1000;
  private Context d;
  private c e;
  private MinsuHouseBean.DataBean.ListBean f;
  private a.a g;
  private a.a h;
  
  public TodaySecialView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TodaySecialView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TodaySecialView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public TodaySecialView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private long a(MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    long l1 = 0L;
    if (this.e == null)
    {
      l1 = paramListBean.tonightDiscountInfoVo.getDeadlineRemainTime();
      if (l1 <= 0L) {
        a();
      }
    }
    long l2;
    do
    {
      return l1;
      l2 = this.e.getTsDeadlineRemainTime(paramListBean);
      if (l2 < 1000L) {
        a();
      }
    } while (l2 < 0L);
    return l2;
  }
  
  private void a()
  {
    Intent localIntent = new Intent("action_today_special_load_data");
    LocalBroadcastManager.getInstance(this.d).sendBroadcast(localIntent);
  }
  
  private void a(Context paramContext)
  {
    this.d = paramContext;
    LayoutInflater.from(this.d).inflate(2130904094, this);
    findViewById(2131694745).setVisibility(0);
    this.g = new a.a()
    {
      public void onCountDown(long paramAnonymousLong)
      {
        u.i("wz", " tsview id = " + TodaySecialView.this.getId());
        TodaySecialView.this.update();
        if (TodaySecialView.a(TodaySecialView.this) != null) {
          TodaySecialView.a(TodaySecialView.this).onCountDown(paramAnonymousLong);
        }
      }
    };
    setBackgroundColor(getResources().getColor(2131624501));
  }
  
  private long b(MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    if (this.e == null) {
      return paramListBean.tonightDiscountInfoVo.getRemainTime();
    }
    return this.e.getTsRemainTime(paramListBean);
  }
  
  public TodaySecialView setCallb(a.a parama)
  {
    this.h = parama;
    return this;
  }
  
  public TodaySecialView setItem(MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    this.f = paramListBean;
    return this;
  }
  
  public TodaySecialView setTsCountHelper(String paramString, c paramc)
  {
    this.e = paramc;
    paramc.addListener(paramString, this.g);
    return this;
  }
  
  public void update()
  {
    MinsuHouseBean.DataBean.ListBean.TonightDiscountInfoVoBean localTonightDiscountInfoVoBean;
    TextView localTextView1;
    TextView localTextView2;
    TextView localTextView3;
    TextView localTextView4;
    if ((this.f != null) && (this.f.tonightDiscountInfoVo != null))
    {
      localTonightDiscountInfoVoBean = this.f.tonightDiscountInfoVo;
      ((TextView)findViewById(2131694747)).setText(localTonightDiscountInfoVoBean.getTonightDiscount() * 10.0F + "折");
      ((TextView)findViewById(2131694748)).setText(localTonightDiscountInfoVoBean.getTipsNname());
      localTextView1 = (TextView)findViewById(2131694750);
      localTextView2 = (TextView)findViewById(2131694751);
      localTextView3 = (TextView)findViewById(2131694752);
      localTextView4 = (TextView)findViewById(2131694753);
      if (b(this.f) > 1000L)
      {
        findViewById(2131694749).setVisibility(0);
        findViewById(2131694754).setVisibility(8);
        findViewById(2131694746).setBackgroundColor(this.d.getResources().getColor(2131624495));
        localTextView1.setText(localTonightDiscountInfoVoBean.getOpenTime() + localTonightDiscountInfoVoBean.getOpenTimeTips());
        localTextView2.setText(ad.getTime2d(b(this.f) / 3600000L));
        localTextView3.setText(ad.getTime2d(b(this.f) % 3600000L / 60000L));
        localTextView4.setText(ad.getTime2d(b(this.f) % 60000L / 1000L));
      }
    }
    else
    {
      return;
    }
    findViewById(2131694749).setVisibility(0);
    findViewById(2131694754).setVisibility(8);
    findViewById(2131694746).setBackgroundColor(this.d.getResources().getColor(2131624497));
    localTextView1.setText(localTonightDiscountInfoVoBean.getDeadlineTimeTips());
    localTextView2.setText(ad.getTime2d(a(this.f) / 3600000L));
    localTextView3.setText(ad.getTime2d(a(this.f) % 3600000L / 60000L));
    localTextView4.setText(ad.getTime2d(a(this.f) % 60000L / 1000L));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/TodaySecialView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */