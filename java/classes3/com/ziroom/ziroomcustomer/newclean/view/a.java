package com.ziroom.ziroomcustomer.newclean.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.activity.BedroomCleaningActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.ValidateBean;

public class a
{
  public static void StartBedroomCleanActivity(final Activity paramActivity, final String paramString1, final String paramString2)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramActivity);
      g.textToast(paramActivity, "请先登录");
      return;
    }
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getValidateCustomerPermission(paramActivity, paramString1, new d(paramActivity, new f(ValidateBean.class))
    {
      public void onSuccess(int paramAnonymousInt, ValidateBean paramAnonymousValidateBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousValidateBean);
        if ("0".equals(paramAnonymousValidateBean.getValidState()))
        {
          paramAnonymousValidateBean = new Intent(paramActivity, BedroomCleaningActivity.class);
          paramAnonymousValidateBean.putExtra("ServiceInfoId", paramString1);
          paramAnonymousValidateBean.putExtra("ServiceInfoName", paramString2);
          paramActivity.startActivity(paramAnonymousValidateBean);
        }
        do
        {
          return;
          if ("1".equals(paramAnonymousValidateBean.getValidState()))
          {
            c.newBuilder(paramActivity).setTitle("提示").setBtnConfirmText("去支付").setBtnCancelText("我知道了").setContent(paramAnonymousValidateBean.getMessage()).setOnConfirmClickListener(new c.b()
            {
              public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
              {
                if (paramAnonymous2Boolean)
                {
                  paramAnonymous2View = new Intent(a.1.this.c, ZiroomOrderListActivity.class);
                  paramAnonymous2View.putExtra("order_status_type", "onlyPay");
                  a.1.this.c.startActivity(paramAnonymous2View);
                }
              }
            }).build().show();
            return;
          }
        } while (!"2".equals(paramAnonymousValidateBean.getValidState()));
        c.newBuilder(paramActivity).setTitle("提示").setBtnConfirmText("联系客服").setBtnCancelText("我知道了").setContent(paramAnonymousValidateBean.getMessage()).setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
          {
            if (paramAnonymous2Boolean)
            {
              j.toChat((BaseActivity)a.1.this.c);
              return;
            }
            a.1.this.c.finish();
          }
        }).build().show();
      }
    });
  }
  
  public static String[] getSpaceTar(String paramString)
  {
    return paramString.split(",");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */