package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.d;
import com.ziroom.ziroomcustomer.e.c.i;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmContractBean;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.lang.ref.WeakReference;
import okhttp3.Callback;

public class g
  implements f.a
{
  private WeakReference<f.b> a;
  private OwnerConfirmContractBean b;
  private String c;
  private String d;
  private String e;
  
  public g(f.b paramb)
  {
    this.a = new WeakReference(paramb);
    paramb = getView();
    if (paramb != null) {
      paramb.setPresenter(this);
    }
  }
  
  public void detachView() {}
  
  public void getData(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
    if (getView() == null) {
      return;
    }
    paramString1 = com.ziroom.ziroomcustomer.e.g.buildOCLoanContractNeedConfirm(getView().getViewContext(), this.c);
    j.getOCLoanContractNeedConfirm(getView().getViewContext(), paramString1, new f(getView().getViewContext(), new d())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        g.this.getView().showError(true, "网络请求失败");
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse != null)
        {
          g.a(g.this, (OwnerConfirmContractBean)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toJSONString(), OwnerConfirmContractBean.class));
          if (g.a(g.this) != null) {
            g.this.getView().initView(g.a(g.this));
          }
          return;
        }
        g.this.getView().showError(true, "数据请求失败");
      }
    });
  }
  
  public String getPhone()
  {
    if (this.b != null) {
      return this.b.managerPhone;
    }
    return null;
  }
  
  public f.b getView()
  {
    if (this.a == null) {
      return null;
    }
    return (f.b)this.a.get();
  }
  
  public void start() {}
  
  public void submitContract()
  {
    if (getView() == null) {}
    while (this.b == null) {
      return;
    }
    final Object localObject = new com.ziroom.commonlibrary.a.a(getView().getViewContext(), new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
        u.e("BoundCardActivity", paramAnonymousThrowable.getMessage() + "");
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ("200".equals(paramAnonymouse.get("code") + "")) {
          g.this.getView().showPop(g.b(g.this), g.a(g.this).getHireCommissionerPhone(), g.c(g.this));
        }
        dismissProgress();
      }
    };
    localObject = new com.ziroom.ziroomcustomer.e.a.c(getView().getViewContext(), new com.ziroom.ziroomcustomer.e.c.a(IkeyRaConfig.class))
    {
      public void onSuccess(int paramAnonymousInt, IkeyRaConfig paramAnonymousIkeyRaConfig)
      {
        if ((paramAnonymousIkeyRaConfig != null) && (ApplicationEx.c.getUser() != null))
        {
          paramAnonymousIkeyRaConfig = new com.ziroom.ziroomcustomer.util.a.c(new com.ziroom.ziroomcustomer.util.a.a(ApplicationEx.c.getUser().getUid(), g.a(g.this).ownerName, g.a(g.this).idType, g.a(g.this).idNo), paramAnonymousIkeyRaConfig);
          paramAnonymousIkeyRaConfig.setListener(new com.ziroom.ziroomcustomer.util.a.b()
          {
            public void onError(String paramAnonymous2String)
            {
              super.onError(paramAnonymous2String);
              if (g.this.getView() == null) {}
              do
              {
                return;
                j.zryuSignatureErrorLog(g.this.getView().getViewContext(), g.b(g.this), paramAnonymous2String, new com.ziroom.ziroomcustomer.e.a.b(g.this.getView().getViewContext(), new com.freelxl.baselibrary.d.f.e())
                {
                  public void onFailure(Throwable paramAnonymous3Throwable) {}
                });
                g.3.this.dismissProgress();
              } while (TextUtils.isEmpty(g.this.getPhone()));
              com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(g.3.b(g.3.this)).setContent("获取电子签章失败，无法继续确认，请及时联系管家！").setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("联系管家").setOnConfirmClickListener(new c.b()
              {
                public void onClick(View paramAnonymous3View, boolean paramAnonymous3Boolean)
                {
                  if (paramAnonymous3Boolean) {
                    ah.callPhone(g.3.a(g.3.this), g.this.getPhone());
                  }
                }
              }).build().show();
            }
            
            public void onSignEnd(String paramAnonymous2String)
            {
              super.onSignEnd(paramAnonymous2String);
              if (g.this.getView() == null) {}
              while (TextUtils.isEmpty(paramAnonymous2String)) {
                return;
              }
              j.ownerLoanSignatureVerify(g.this.getView().getViewContext(), g.a(g.this).getLoanContractCode(), paramAnonymous2String, g.3.this.c);
            }
            
            public void onSignStart()
            {
              super.onSignStart();
            }
          });
          paramAnonymousIkeyRaConfig.sign(g.d(g.this));
        }
      }
    };
    localObject = new com.ziroom.ziroomcustomer.e.a.c(getView().getViewContext(), new i())
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        if (g.this.getView() == null) {}
        while (TextUtils.isEmpty(paramAnonymousString)) {
          return;
        }
        paramAnonymousString = com.alibaba.fastjson.a.parseObject(paramAnonymousString);
        g.a(g.this, paramAnonymousString.getString("initialParam"));
        j.iTrusRaConfig(g.this.getView().getViewContext(), localObject);
      }
    };
    j.ownerLoanSignatureQuery(getView().getViewContext(), this.c, (Callback)localObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */