package com.ziroom.ziroomcustomer.minsu.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.a.a;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationListBean.DataBean.RowsBean;
import com.ziroom.ziroomcustomer.util.u;
import java.util.List;

public class k
  extends a<MinsuEvaluationListBean.DataBean.RowsBean>
{
  private Activity d;
  
  public k(Activity paramActivity, List<MinsuEvaluationListBean.DataBean.RowsBean> paramList, int paramInt)
  {
    super(paramActivity, paramList, paramInt);
    this.d = paramActivity;
  }
  
  public void convert(b paramb, MinsuEvaluationListBean.DataBean.RowsBean paramRowsBean)
  {
    ((SimpleDraweeView)paramb.getView(2131695239)).setController(c.frescoController(paramRowsBean.userPicUrl));
    paramb.setText(2131695240, String.format(this.a.getString(2131297058), new Object[] { paramRowsBean.startTimeStr, paramRowsBean.endTimeStr, Integer.valueOf(paramRowsBean.housingDay) }));
    paramb.setText(2131695241, String.format(this.a.getString(2131296773), new Object[] { paramRowsBean.userName, Integer.valueOf(paramRowsBean.peopleNum) }));
    paramb.setText(2131695238, paramRowsBean.evaTips);
    paramb.setText(2131695237, paramRowsBean.houseName);
    u.e("xlv", "position = " + paramb.getPosition());
    paramb.setText(2131695243, paramRowsBean.pjButton);
    paramb.getView(2131695242).setTag(2131689523, paramRowsBean);
    paramb.getView(2131695243).setTag(2131689523, paramRowsBean);
    if (paramRowsBean.pjStatus == 1)
    {
      paramb.getView(2131695242).setVisibility(0);
      paramb.getView(2131695242).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
        }
      });
      paramb.getView(2131695243).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = (MinsuEvaluationListBean.DataBean.RowsBean)paramAnonymousView.getTag(2131689523);
          com.ziroom.ziroomcustomer.minsu.f.k.toCustomerEvaCommitActivity(k.a(k.this), paramAnonymousView.orderSn, 1);
        }
      });
      return;
    }
    paramb.getView(2131695242).setVisibility(8);
  }
  
  public void initView(View paramView)
  {
    super.initView(paramView);
    paramView = (TextView)paramView.findViewById(2131695237);
    int i = paramView.getLineHeight();
    Drawable localDrawable = this.d.getResources().getDrawable(2130838633);
    localDrawable.setBounds(0, 0, i, i);
    paramView.setCompoundDrawablesRelative(null, null, localDrawable, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */