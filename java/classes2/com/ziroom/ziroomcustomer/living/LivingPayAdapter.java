package com.ziroom.ziroomcustomer.living;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.List;

public class LivingPayAdapter
  extends BaseAdapter
{
  private List<String> a;
  private Context b;
  private ViewHolder c;
  private a d;
  
  public LivingPayAdapter(List<String> paramList, Context paramContext)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904856, null);
      this.c = new ViewHolder(paramView);
      paramView.setTag(this.c);
      if (!"yl_make_order".equals(this.a.get(paramInt))) {
        break label124;
      }
      paramView.setVisibility(0);
      this.c.living_pay_title.setText("银联信用卡支付");
      this.c.living_pay_img.setImageResource(2130839921);
      this.c.living_pay_content.setText("支付服务由银联提供(不支持交通、招商)");
    }
    for (;;)
    {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          LivingPayAdapter.b(LivingPayAdapter.this).toPay((String)LivingPayAdapter.a(LivingPayAdapter.this).get(paramInt));
        }
      });
      return paramView;
      this.c = ((ViewHolder)paramView.getTag());
      break;
      label124:
      if ("wxpay_make_order_v2".equals(this.a.get(paramInt)))
      {
        paramView.setVisibility(0);
        this.c.living_pay_title.setText("微信支付");
        this.c.living_pay_img.setImageResource(2130839918);
        this.c.living_pay_content.setText("推荐已安装微信客户端的用户使用");
      }
      else if ("jd_m_pay".equals(this.a.get(paramInt)))
      {
        paramView.setVisibility(0);
        this.c.living_pay_title.setText("京东支付");
        this.c.living_pay_img.setImageResource(2130838902);
        this.c.living_pay_content.setText("支付服务由京东提供");
      }
      else if ("yl_cashCard_make_order".equals(this.a.get(paramInt)))
      {
        this.c.living_pay_title.setText("银联储蓄卡支付");
        this.c.living_pay_img.setImageResource(2130839921);
        this.c.living_pay_content.setText("支付服务由银联提供");
      }
      else
      {
        paramView.setVisibility(8);
      }
    }
  }
  
  public a getmTopay()
  {
    return this.d;
  }
  
  public void setmTopay(a parama)
  {
    this.d = parama;
  }
  
  class ViewHolder
  {
    @BindView(2131696749)
    TextView living_pay_content;
    @BindView(2131696747)
    ImageView living_pay_img;
    @BindView(2131696748)
    TextView living_pay_title;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  static abstract interface a
  {
    public abstract void toPay(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LivingPayAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */