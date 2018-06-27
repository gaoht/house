package com.ziroom.ziroomcustomer.ziroomapartment;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.e;
import com.ziroom.commonlibrary.login.a.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.CreditsBean;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.d.a;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuLeaseInfoActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSignBillsInfoActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSignBillsListActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSignCertInformationActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSignCertificationInfoActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSignPropertyDeliveryActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSignSignatoryInfoActivity;

public class b
{
  public static void toBillsInfo(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    toBillsInfo(paramContext, paramString1, paramString2, paramString3, paramString4, true);
  }
  
  public static void toBillsInfo(Context paramContext, final String paramString1, String paramString2, final String paramString3, final String paramString4, final boolean paramBoolean)
  {
    if ("1007".equals(paramString3))
    {
      j.zryuCheckHasLivingBill(paramContext, paramString2, new com.ziroom.ziroomcustomer.e.a.c(paramContext, new com.ziroom.ziroomcustomer.e.c.d())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if (this.b != null)
          {
            paramAnonymouse = new Intent(this.b, ZryuSignBillsInfoActivity.class);
            paramAnonymouse.putExtra("contractId", paramString1);
            if (!TextUtils.isEmpty("period")) {
              paramAnonymouse.putExtra("period", paramString4);
            }
            paramAnonymouse.putExtra("type", paramString3);
            paramAnonymouse.putExtra("isBack", paramBoolean);
            this.b.startActivity(paramAnonymouse);
          }
        }
      });
      return;
    }
    paramString2 = new Intent(paramContext, ZryuSignBillsInfoActivity.class);
    paramString2.putExtra("contractId", paramString1);
    if (!TextUtils.isEmpty("period")) {
      paramString2.putExtra("period", paramString4);
    }
    paramString2.putExtra("isBack", paramBoolean);
    paramString2.putExtra("type", paramString3);
    paramContext.startActivity(paramString2);
  }
  
  public static void toBillsList(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, ZryuSignBillsListActivity.class);
    localIntent.putExtra("contractId", paramString);
    localIntent.putExtra("type", paramInt1);
    localIntent.putExtra("flag", paramInt2);
    paramContext.startActivity(localIntent);
  }
  
  public static void toContractInfo(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, ZryuLeaseInfoActivity.class);
    localIntent.putExtra("contractId", paramString1);
    localIntent.putExtra("deCode", paramString2);
    paramContext.startActivity(localIntent);
  }
  
  public static void toDelivery(Context paramContext, final String paramString)
  {
    j.zryuItemDeliveryCheck(paramContext, paramString, new com.ziroom.ziroomcustomer.e.a.c(paramContext, new com.ziroom.ziroomcustomer.e.c.d())
    {
      public void onSuccess(int paramAnonymousInt, final e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("isEnter")) && (paramAnonymouse.getInteger("isEnter") != null) && (paramAnonymouse.getInteger("isEnter").intValue() == 1))
        {
          paramAnonymouse = new Intent(this.b, ZryuSignPropertyDeliveryActivity.class);
          paramAnonymouse.putExtra("contractId", paramString);
          this.b.startActivity(paramAnonymouse);
          ApplicationEx.c.finishZryuSign();
        }
        while ((paramAnonymouse == null) || (TextUtils.isEmpty(paramAnonymouse.getString("msg"))) || (TextUtils.isEmpty(paramAnonymouse.getString("telephoneNum")))) {
          return;
        }
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.b).setContent(paramAnonymouse.getString("msg")).setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("联系管家").setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
          {
            if (paramAnonymous2Boolean) {
              ah.callPhone(b.3.a(b.3.this), paramAnonymouse.getString("telephoneNum"));
            }
          }
        }).build().show();
      }
    });
  }
  
  public static void toSign(Context paramContext, final String paramString1, final String paramString2)
  {
    if (paramContext != null)
    {
      if (ApplicationEx.c.isLoginState()) {
        com.ziroom.commonlibrary.login.a.getUserInfo(paramContext, new a.b()
        {
          public void onUserInfo(final e paramAnonymouse)
          {
            if (paramAnonymouse == null) {}
            do
            {
              return;
              paramAnonymouse = paramAnonymouse.getString("phone");
              if ((this.a != null) && (!TextUtils.isEmpty(paramAnonymouse)))
              {
                j.zryuContractsignValid(this.a, paramString1, new com.ziroom.commonlibrary.a.a(this.a, new com.ziroom.ziroomcustomer.e.c.d())
                {
                  public void onFailure(Throwable paramAnonymous2Throwable)
                  {
                    super.onFailure(paramAnonymous2Throwable);
                    if (((paramAnonymous2Throwable instanceof com.ziroom.ziroomcustomer.e.b.a)) && (b.1.this.a != null)) {
                      com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(b.1.this.a).setContent(paramAnonymous2Throwable.getMessage()).setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("联系管家").setOnConfirmClickListener(new c.b()
                      {
                        public void onClick(View paramAnonymous3View, boolean paramAnonymous3Boolean)
                        {
                          if (paramAnonymous3Boolean) {
                            ah.callPhone(b.1.this.a, b.1.this.c);
                          }
                        }
                      }).build().show();
                    }
                  }
                  
                  public void onSuccess(int paramAnonymous2Int, e paramAnonymous2e)
                  {
                    super.onSuccess(paramAnonymous2Int, paramAnonymous2e);
                    if (this.b != null) {
                      new com.ziroom.ziroomcustomer.util.d(this.b, new d.a()
                      {
                        public void onAuthenticate(String paramAnonymous3String, CertInfoEntity paramAnonymous3CertInfoEntity)
                        {
                          if ((paramAnonymous3CertInfoEntity != null) && (b.1.1.a(b.1.1.this) != null))
                          {
                            if ((TextUtils.isEmpty(paramAnonymous3CertInfoEntity.getUser_type())) || (!paramAnonymous3CertInfoEntity.getUser_type().equals("2"))) {
                              break label84;
                            }
                            com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(b.1.1.c(b.1.1.this)).setContent("您已完成或正在进行企业认证，无法以个人身份继续签约，如需签约请联系管家！").setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("联系管家").setOnConfirmClickListener(new c.b()
                            {
                              public void onClick(View paramAnonymous4View, boolean paramAnonymous4Boolean)
                              {
                                if (paramAnonymous4Boolean) {
                                  ah.callPhone(b.1.1.b(b.1.1.this), b.1.this.c);
                                }
                              }
                            }).build().show();
                          }
                          label84:
                          while ((paramAnonymous3CertInfoEntity.credits == null) || (paramAnonymous3CertInfoEntity.credits.realNameStatus == 0)) {
                            return;
                          }
                          Intent localIntent = new Intent();
                          localIntent.putExtra("fromUtil", true);
                          switch (paramAnonymous3CertInfoEntity.credits.realNameStatus)
                          {
                          default: 
                            return;
                          case 1: 
                            if ("1".equals(paramAnonymous3CertInfoEntity.getCert_type()))
                            {
                              localIntent.setClass(b.1.1.d(b.1.1.this), ZryuSignCertInformationActivity.class);
                              localIntent.putExtra("cert_info", paramAnonymous3CertInfoEntity);
                              localIntent.putExtra("phone", paramAnonymous3String);
                              b.1.1.e(b.1.1.this).startActivity(localIntent);
                              return;
                            }
                            localIntent.setClass(b.1.1.f(b.1.1.this), ZryuSignCertificationInfoActivity.class);
                            localIntent.putExtra("cert_info", paramAnonymous3CertInfoEntity);
                            localIntent.putExtra("phone", paramAnonymous3String);
                            b.1.1.g(b.1.1.this).startActivity(localIntent);
                            return;
                          case 2: 
                          case 3: 
                            localIntent.setClass(b.1.1.h(b.1.1.this), ZryuSignCertificationInfoActivity.class);
                            localIntent.putExtra("cert_info", paramAnonymous3CertInfoEntity);
                            localIntent.putExtra("phone", paramAnonymous3String);
                            b.1.1.i(b.1.1.this).startActivity(localIntent);
                            return;
                          case 4: 
                            localIntent.setClass(b.1.1.j(b.1.1.this), ZryuSignSignatoryInfoActivity.class);
                            localIntent.putExtra("contractId", b.1.this.b);
                            b.1.1.k(b.1.1.this).startActivity(localIntent);
                            return;
                          }
                          localIntent.setClass(b.1.1.l(b.1.1.this), ZryuSignCertInformationActivity.class);
                          localIntent.putExtra("cert_info", paramAnonymous3CertInfoEntity);
                          localIntent.putExtra("phone", paramAnonymous3String);
                          b.1.1.m(b.1.1.this).startActivity(localIntent);
                        }
                      }).authenticate(paramAnonymouse);
                    }
                  }
                });
                return;
              }
            } while (this.a == null);
            com.ziroom.commonlibrary.login.a.startBindPhoneActivity(this.a);
          }
        });
      }
    }
    else {
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */