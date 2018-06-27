package com.ziroom.ziroomcustomer.minsu.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.freelxl.baselibrary.a.b;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.a.a;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImReplyCommonBean.DataBean.ListMsgBean;
import com.ziroom.ziroomcustomer.minsu.f.k;
import java.util.List;

public class g
  extends a<MinsuImReplyCommonBean.DataBean.ListMsgBean>
{
  private Context d;
  
  public g(Context paramContext, List<MinsuImReplyCommonBean.DataBean.ListMsgBean> paramList)
  {
    super(paramContext, paramList, 2130904292);
    this.d = paramContext;
  }
  
  public void convert(b paramb, MinsuImReplyCommonBean.DataBean.ListMsgBean paramListMsgBean)
  {
    if (paramListMsgBean.msgType == -1)
    {
      paramb.setVisibility(2131690825, 0);
      paramb.setVisibility(2131694579, 8);
      paramb.getView(2131690041).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          k.toEditCommonReply((Activity)g.a(g.this), null);
        }
      });
      return;
    }
    paramb.setVisibility(2131694579, 0);
    paramb.setVisibility(2131690825, 8);
    paramb.setText(2131694579, paramListMsgBean.content);
    if (paramListMsgBean.msgType == 1)
    {
      paramb.setTextColor(2131694579, this.d.getResources().getColor(2131624097));
      return;
    }
    paramb.setTextColor(2131694579, this.d.getResources().getColor(2131624091));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */