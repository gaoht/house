package com.ziroom.ziroomcustomer.minsu.dialog;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponListShowBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponListShowBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponListShowBean.DataBean.CouponListBean;
import com.ziroom.ziroomcustomer.minsu.f.ac;
import com.ziroom.ziroomcustomer.minsu.view.b.a;
import com.ziroom.ziroomcustomer.minsu.view.b.a.c;
import com.ziroom.ziroomcustomer.minsu.view.b.c.a;
import java.util.List;

public class e
  extends PopupWindow
{
  private View a;
  private TextView b;
  private TextView c;
  private ImageView d;
  private RecyclerView e;
  private a f;
  private Activity g;
  private MinsuCouponListShowBean h;
  private a i;
  
  public e(Activity paramActivity, a parama, MinsuCouponListShowBean paramMinsuCouponListShowBean)
  {
    super(paramActivity);
    this.g = paramActivity;
    this.i = parama;
    this.h = paramMinsuCouponListShowBean;
    this.a = ((LayoutInflater)paramActivity.getSystemService("layout_inflater")).inflate(2130904899, null);
    a(paramActivity);
    a(paramActivity, parama, paramMinsuCouponListShowBean.data.couponList);
    setWidth(-1);
    setHeight(-1);
    setContentView(this.a);
    setFocusable(true);
    setAnimationStyle(2131427507);
    setBackgroundDrawable(new ColorDrawable(Color.parseColor("#99000000")));
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        e.this.dismiss();
      }
    });
    this.a.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        e.this.dismiss();
        return true;
      }
    });
  }
  
  private void a(Activity paramActivity)
  {
    this.b = ((TextView)this.a.findViewById(2131689541));
    this.c = ((TextView)this.a.findViewById(2131690071));
    this.d = ((ImageView)this.a.findViewById(2131690588));
    this.e = ((RecyclerView)this.a.findViewById(2131691217));
    this.e.setLayoutManager(new LinearLayoutManager(paramActivity, 1, false));
    this.e.addItemDecoration(((c.a)((c.a)new c.a(paramActivity).colorResId(2131624576)).sizeResId(2131231171)).build());
  }
  
  private void a(Activity paramActivity, a parama, List<MinsuCouponListShowBean.DataBean.CouponListBean> paramList)
  {
    this.b.setText(this.h.data.title);
    this.c.setText(this.h.data.subTitle);
    this.f = new a(paramActivity, 2130904313, this.h.data.couponList)
    {
      protected void a(c paramAnonymousc, MinsuCouponListShowBean.DataBean.CouponListBean paramAnonymousCouponListBean, int paramAnonymousInt)
      {
        ac.relaSize((TextView)paramAnonymousc.getView(2131689541), paramAnonymousCouponListBean.symbol + paramAnonymousCouponListBean.money, paramAnonymousCouponListBean.money, 2.0F);
        paramAnonymousc.setText(2131690071, paramAnonymousCouponListBean.desc);
        if (paramAnonymousCouponListBean.isCan == 1)
        {
          paramAnonymousc.getConvertView().setEnabled(true);
          paramAnonymousc.getView(2131690043).setEnabled(true);
          paramAnonymousc.setText(2131690043, this.b.getString(2131297077));
          paramAnonymousc.setTextColor(2131690043, this.b.getResources().getColor(2131624475));
          paramAnonymousc.setTextColor(2131689541, this.b.getResources().getColor(2131624475));
        }
        for (;;)
        {
          paramAnonymousc.getView(2131690043).setBackgroundResource(2130839474);
          return;
          paramAnonymousc.getConvertView().setEnabled(false);
          paramAnonymousc.getView(2131690043).setEnabled(false);
          paramAnonymousc.setText(2131690043, this.b.getString(2131297078));
          paramAnonymousc.setTextColor(2131690043, this.b.getResources().getColor(2131624583));
          paramAnonymousc.setTextColor(2131689541, this.b.getResources().getColor(2131624482));
        }
      }
    };
    this.f.setOnItemClickListener(parama);
    this.e.setAdapter(this.f);
  }
  
  public void updateData(MinsuCouponListShowBean paramMinsuCouponListShowBean)
  {
    this.h = paramMinsuCouponListShowBean;
    a(this.g, this.i, this.h.data.couponList);
  }
  
  public static abstract class a
    implements com.ziroom.ziroomcustomer.minsu.view.b.e.a
  {
    public boolean onItemLongClick(View paramView, RecyclerView.u paramu, int paramInt)
    {
      return false;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/dialog/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */