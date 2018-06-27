package com.ziroom.ziroomcustomer.minsu.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCRemarkBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLOrderListBean.DataBean.OrderListBean;
import com.ziroom.ziroomcustomer.minsu.dialog.h;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.LandlordOrderDetailActivity;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.CommonSaveDescInfoActivity;
import java.util.List;

public class p
  extends com.ziroom.ziroomcustomer.minsu.a.a<MinsuLLOrderListBean.DataBean.OrderListBean>
{
  private Activity d;
  
  public p(Activity paramActivity, List<MinsuLLOrderListBean.DataBean.OrderListBean> paramList)
  {
    super(paramActivity, paramList, 2130904337);
    this.d = paramActivity;
  }
  
  public void convert(b paramb, final MinsuLLOrderListBean.DataBean.OrderListBean paramOrderListBean)
  {
    Object localObject = (SimpleDraweeView)paramb.getView(2131695297);
    ((SimpleDraweeView)localObject).setController(c.frescoController(paramOrderListBean.housePicUrl));
    ((SimpleDraweeView)localObject).setHierarchy(d.getHierarchy(this.a));
    paramb.setText(2131691319, paramOrderListBean.houseName);
    paramb.setText(2131695321, paramOrderListBean.orderStatusShowName);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramOrderListBean.startTimeStr.replaceAll("-", "/")).append("-").append(paramOrderListBean.endTimeStr.replaceAll("-", "/")).append(" 共").append(paramOrderListBean.housingDay).append("晚");
    paramb.setText(2131695322, ((StringBuilder)localObject).toString());
    paramb.setText(2131695323, paramOrderListBean.userName + "，共" + paramOrderListBean.contactsNum + "人入住");
    paramb.setText(2131695324, "共计" + paramOrderListBean.needMoney + "元");
    paramb.getView(2131695325).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        com.ziroom.ziroomcustomer.minsu.e.a.checkRemarkCount(p.a(p.this), paramOrderListBean.orderSn, true, new com.freelxl.baselibrary.d.c.a(new r(MinsuCRemarkBean.class))
        {
          public void onFailure(Throwable paramAnonymous2Throwable) {}
          
          public void onSuccess(int paramAnonymous2Int, MinsuCRemarkBean paramAnonymous2MinsuCRemarkBean)
          {
            if ("0".equals(paramAnonymous2MinsuCRemarkBean.status))
            {
              com.ziroom.ziroomcustomer.minsu.activity.MinsuLandLordMainActivity.c = p.1.this.a.orderSn;
              paramAnonymous2MinsuCRemarkBean = new Intent();
              paramAnonymous2MinsuCRemarkBean.setClass(p.b(p.this), CommonSaveDescInfoActivity.class);
              paramAnonymous2MinsuCRemarkBean.putExtra("titleName", "添加备注");
              paramAnonymous2MinsuCRemarkBean.putExtra("editTextHint", "请填写您的订单备注信息，例如，是否需要接机、是否需要准备其他物品等，50字以内。");
              paramAnonymous2MinsuCRemarkBean.putExtra("saveDescText", "");
              paramAnonymous2MinsuCRemarkBean.putExtra("editMaxNum", 50);
              paramAnonymous2MinsuCRemarkBean.putExtra("editMinNum", 1);
              paramAnonymous2MinsuCRemarkBean.putExtra("nullable", false);
              ((Activity)p.c(p.this)).startActivityForResult(paramAnonymous2MinsuCRemarkBean, 17);
              return;
            }
            if (paramAnonymous2MinsuCRemarkBean == null) {}
            for (paramAnonymous2MinsuCRemarkBean = null;; paramAnonymous2MinsuCRemarkBean = paramAnonymous2MinsuCRemarkBean.message)
            {
              ad.shouErrorMessage(paramAnonymous2MinsuCRemarkBean);
              return;
            }
          }
        });
      }
    });
    localObject = (TextView)paramb.getView(2131695326);
    if (paramOrderListBean.pjStatus == 0) {}
    for (int i = 8;; i = 0)
    {
      ((TextView)localObject).setVisibility(i);
      ((TextView)localObject).setText(paramOrderListBean.pjButton);
      ((TextView)localObject).setTag(paramOrderListBean);
      ((TextView)localObject).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = (MinsuLLOrderListBean.DataBean.OrderListBean)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (paramAnonymousView.pjStatus == 0)) {}
          do
          {
            return;
            if (paramAnonymousView.pjStatus == 1)
            {
              k.toCustomerEvaCommitActivity(p.a(p.this), paramAnonymousView.orderSn, 2);
              return;
            }
          } while (paramAnonymousView.pjStatus != 2);
          k.toEvaActivity(p.a(p.this), paramAnonymousView.orderSn, h.a);
        }
      });
      paramb.setOnClickListener(2131695215, new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = paramOrderListBean.orderSn;
          Intent localIntent = new Intent(p.d(p.this), LandlordOrderDetailActivity.class);
          localIntent.putExtra("orderSn", paramAnonymousView);
          p.e(p.this).startActivity(localIntent);
        }
      });
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */