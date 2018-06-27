package com.ziroom.ziroomcustomer.minsu.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.a.a;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderBean.DataBean.OrderListBean;
import com.ziroom.ziroomcustomer.minsu.dialog.h;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ac;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.util.n;
import java.util.List;

public class q
  extends a<MinsuOrderBean.DataBean.OrderListBean>
  implements View.OnClickListener
{
  private Activity d;
  
  public q(Activity paramActivity, int paramInt, List<MinsuOrderBean.DataBean.OrderListBean> paramList)
  {
    super(paramActivity, paramList, paramInt);
    this.d = paramActivity;
  }
  
  private int a(int paramInt)
  {
    return ab.dp2px(this.a, 12.0F) + paramInt * 2 - paramInt * 11 / 10 / 2;
  }
  
  private String a(MinsuOrderBean.DataBean.OrderListBean paramOrderListBean)
  {
    return this.a.getString(2131296810).replace("in", paramOrderListBean.startTimeStr).replace("out", paramOrderListBean.endTimeStr).replace("count", "" + paramOrderListBean.housingDay);
  }
  
  private String b(MinsuOrderBean.DataBean.OrderListBean paramOrderListBean)
  {
    return this.a.getString(2131297344).replace("sum", "" + ad.getPriceFormat(paramOrderListBean.needPay));
  }
  
  public void convert(b paramb, MinsuOrderBean.DataBean.OrderListBean paramOrderListBean)
  {
    Object localObject = (SimpleDraweeView)paramb.getView(2131691574);
    ((SimpleDraweeView)localObject).setController(c.frescoController(paramOrderListBean.picUrl));
    ((SimpleDraweeView)localObject).setHierarchy(d.getHierarchy(this.a));
    paramb.setText(2131689541, paramOrderListBean.houseName);
    localObject = ad.getPriceFormat(paramOrderListBean.needPay) + this.a.getString(2131297550);
    TextView localTextView1 = (TextView)paramb.getView(2131691573);
    TextView localTextView2 = (TextView)paramb.getView(2131691575);
    TextView localTextView3 = (TextView)paramb.getView(2131695331);
    if (paramOrderListBean.isLock == 0)
    {
      localTextView2.setVisibility(8);
      localTextView3.setTextColor(Color.parseColor("#666666"));
      ac.color(localTextView3, b(paramOrderListBean), (String)localObject, Color.parseColor("#FDA937"));
      localTextView3.setPadding(localTextView3.getPaddingLeft(), n.dip2px(this.a, 15.0F), localTextView3.getPaddingRight(), n.dip2px(this.a, 15.0F));
      localTextView1.setPadding(localTextView1.getPaddingLeft(), n.dip2px(this.a, 15.0F), localTextView1.getPaddingRight(), n.dip2px(this.a, 15.0F));
      localTextView1.setText(a(paramOrderListBean));
      paramb.setText(2131690407, "" + paramOrderListBean.orderStatusName);
      paramb.setText(2131695243, "" + paramOrderListBean.pjButton);
      if ((paramOrderListBean.pjStatus != 1) && (paramOrderListBean.pjStatus != 3)) {
        break label504;
      }
      paramb.setVisibility(2131693139, 0);
      paramb.setVisibility(2131695243, 0);
      paramb.setTag(2131695242, paramOrderListBean.orderSn);
      paramb.setTag(2131695243, paramOrderListBean.orderSn);
      paramb.setTag(2131695243, 2131689527, Integer.valueOf(paramOrderListBean.pjStatus));
      paramb.setOnClickListener(2131695242, this);
      paramb.setOnClickListener(2131695243, new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = Integer.parseInt(paramAnonymousView.getTag(2131689527) + "");
          if (i == 1) {
            k.toCustomerEvaCommitActivity(q.a(q.this), paramAnonymousView.getTag().toString(), 1);
          }
          while (i != 3) {
            return;
          }
          k.toEvaActivity(q.b(q.this), paramAnonymousView.getTag().toString(), h.b);
        }
      });
    }
    for (;;)
    {
      paramb.getConvertView().setTag(2131689523, paramOrderListBean);
      return;
      localTextView2.setVisibility(0);
      localTextView3.setTextColor(Color.parseColor("#ff7070"));
      ac.color(localTextView2, b(paramOrderListBean), (String)localObject, Color.parseColor("#FDA937"));
      localTextView3.setVisibility(0);
      localTextView3.setText(this.a.getString(2131296798));
      localTextView3.setPadding(localTextView3.getPaddingLeft(), n.dip2px(this.a, 0.0F), localTextView3.getPaddingRight(), n.dip2px(this.a, 0.0F));
      localTextView1.setPadding(localTextView1.getPaddingLeft(), n.dip2px(this.a, 0.0F), localTextView1.getPaddingRight(), n.dip2px(this.a, 0.0F));
      break;
      label504:
      paramb.setVisibility(2131693139, 8);
      paramb.setVisibility(2131695243, 8);
    }
  }
  
  public void initView(View paramView)
  {
    int i = ((TextView)paramView.findViewById(2131689541)).getLineHeight();
    Object localObject = (RelativeLayout.LayoutParams)paramView.findViewById(2131691574).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (i * 4);
    ((RelativeLayout.LayoutParams)localObject).width = (i * 4 * 4 / 3);
    localObject = (RelativeLayout.LayoutParams)paramView.findViewById(2131694102).getLayoutParams();
    int j = i * 11 / 10;
    ((RelativeLayout.LayoutParams)localObject).width = j;
    ((RelativeLayout.LayoutParams)localObject).height = j;
    ((RelativeLayout.LayoutParams)localObject).topMargin = a(i);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
    paramView = (TextView)paramView.findViewById(2131689541);
    i = paramView.getLineHeight();
    localObject = this.d.getResources().getDrawable(2130838633);
    ((Drawable)localObject).setBounds(0, 0, i, i);
    paramView.setCompoundDrawablesRelative(null, null, (Drawable)localObject, null);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */