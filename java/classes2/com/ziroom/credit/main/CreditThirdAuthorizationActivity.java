package com.ziroom.credit.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.r;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.b.a;
import com.ziroom.credit.base.CreditBaseActivity;
import com.ziroom.datacenter.remote.f.b;
import com.ziroom.datacenter.remote.responsebody.financial.b.j;
import com.ziroom.router.activityrouter.Routers;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class CreditThirdAuthorizationActivity
  extends CreditBaseActivity
  implements View.OnClickListener, aa.b
{
  com.ziroom.credit.a.c d;
  List<j> e;
  private ImageView f;
  private ListView g;
  private Context h;
  
  protected int c()
  {
    return R.layout.credit_activity_third_authorization;
  }
  
  protected void d()
  {
    this.h = this;
    this.f = ((ImageView)findViewById(R.id.credit_iv_close));
    this.g = ((ListView)findViewById(R.id.credit_list_credit));
    this.f.setOnClickListener(this);
    this.g.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (j)CreditThirdAuthorizationActivity.this.e.get(paramAnonymousInt);
        if (paramAnonymousAdapterView.getStatus() == 1) {}
        do
        {
          return;
          if (paramAnonymousAdapterView.getKey() != 0) {
            break;
          }
          if (paramAnonymousAdapterView.getStatus() == 2)
          {
            com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(CreditThirdAuthorizationActivity.a(CreditThirdAuthorizationActivity.this)).setTitle("提示").setBtnConfirmText("确定").setContent("很抱歉，非身份证用户暂不支持授权").build().show();
            return;
          }
          if (paramAnonymousAdapterView.getStatus() == 3)
          {
            com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(CreditThirdAuthorizationActivity.a(CreditThirdAuthorizationActivity.this)).setTitle("提示").setBtnConfirmText("去认证").setContent("授权芝麻信用，请先完成实名认证").setOnConfirmClickListener(new c.b()
            {
              public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
              {
                if (paramAnonymous2Boolean) {
                  Routers.open(CreditThirdAuthorizationActivity.this, "ziroomCustomer://zrRentModule/nameAuthenticationMethod");
                }
              }
            }).build().show();
            return;
          }
        } while (paramAnonymousAdapterView.getStatus() != 0);
        paramAnonymousAdapterView = CreditThirdAuthorizationActivity.this.toURLencoded(paramAnonymousAdapterView.getUrl());
        Routers.open(CreditThirdAuthorizationActivity.this, "ziroomCustomer://zrCreditModule/zmAuthorizationView?ZiMaUrl=" + paramAnonymousAdapterView);
        return;
        if (paramAnonymousAdapterView.getKey() == 2)
        {
          paramAnonymousView = com.ziroom.datacenter.c.c.buildUid();
          paramAnonymousView = String.format(b.x + "credits/linkedin?uid=%s&sign=%s&timestamp=%s", new Object[] { paramAnonymousView.get("uid"), paramAnonymousView.get("sign"), paramAnonymousView.get("timestamp") });
          paramAnonymousView = CreditThirdAuthorizationActivity.this.toURLencoded(paramAnonymousView);
          Routers.open(CreditThirdAuthorizationActivity.this, "ziroomCustomer://zrRentModule/h5WJFunction?url=" + paramAnonymousView + "&title=" + paramAnonymousAdapterView.getType() + "&isUniCode=1");
          return;
        }
        if (paramAnonymousAdapterView.getIsSkip() == 0)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("title", paramAnonymousAdapterView.getType());
          paramAnonymousView.putString("logo", paramAnonymousAdapterView.getLogo());
          paramAnonymousView.putInt("status", paramAnonymousAdapterView.getStatus());
          paramAnonymousView.putString("desc", paramAnonymousAdapterView.getDesc());
          paramAnonymousView.putString("link", paramAnonymousAdapterView.getUrl());
          paramAnonymousView.putString("maimaiClass", CreditThirdAuthorizationActivity.class.getName());
          Routers.open(CreditThirdAuthorizationActivity.this, "ziroomCustomer://zrRentModule/OccupationBinding", paramAnonymousView);
          return;
        }
        paramAnonymousView = CreditThirdAuthorizationActivity.this.toURLencoded(paramAnonymousAdapterView.getUrl());
        Routers.open(CreditThirdAuthorizationActivity.this, "ziroomCustomer://zrCreditModule/zmAuthorizationView?ZiMaUrl=" + paramAnonymousView + "&title=" + paramAnonymousAdapterView.getType());
      }
    });
  }
  
  protected aa.a e()
  {
    return new ab(this);
  }
  
  public void getThirdAuthoizationInfo(List<j> paramList)
  {
    this.e = paramList;
    this.d = new com.ziroom.credit.a.c(this, this.e);
    this.g.setAdapter(this.d);
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  protected void initData() {}
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    a.closeAcAnim(this);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView.getId() == R.id.credit_iv_close)
    {
      finish();
      a.closeAcAnim(this);
    }
  }
  
  public void setPresenter(aa.a parama)
  {
    this.a = parama;
  }
  
  public String toURLencoded(String paramString)
  {
    if (r.isNull(paramString)) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(new String(paramString.getBytes(), "UTF-8"), "UTF-8");
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditThirdAuthorizationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */