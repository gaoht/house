package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.signed.SignerAptitudeActivity;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignContractSubject;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignPerson;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignProject;

public class ZryuSignSignatoryInfoActivity
  extends BaseActivity
{
  private SimpleDraweeView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private LabeledEditText e;
  private LabeledEditText f;
  private LabeledEditText g;
  private LabeledEditText r;
  private String s;
  private ZryuSignPerson t;
  private String u;
  private com.ziroom.ziroomcustomer.e.a.c v = new com.ziroom.ziroomcustomer.e.a.c(this, new f(ZryuSignContractSubject.class))
  {
    public void onSuccess(int paramAnonymousInt, ZryuSignContractSubject paramAnonymousZryuSignContractSubject)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousZryuSignContractSubject);
      if (paramAnonymousZryuSignContractSubject != null)
      {
        ZryuSignSignatoryInfoActivity.a(ZryuSignSignatoryInfoActivity.this, paramAnonymousZryuSignContractSubject.getHandleZOPhone());
        ZryuSignProject localZryuSignProject = paramAnonymousZryuSignContractSubject.getProjectInfo();
        if (localZryuSignProject != null)
        {
          ZryuSignSignatoryInfoActivity.a(ZryuSignSignatoryInfoActivity.this).setText(localZryuSignProject.getProName());
          ZryuSignSignatoryInfoActivity.b(ZryuSignSignatoryInfoActivity.this).setText(localZryuSignProject.getProAddress());
          ZryuSignSignatoryInfoActivity.c(ZryuSignSignatoryInfoActivity.this).setText(localZryuSignProject.getRoomSalesPrice() + "");
          ZryuSignSignatoryInfoActivity.d(ZryuSignSignatoryInfoActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(localZryuSignProject.getProHeadFigureUrl()));
        }
        ZryuSignSignatoryInfoActivity.a(ZryuSignSignatoryInfoActivity.this, paramAnonymousZryuSignContractSubject.getSignPerson());
        if (ZryuSignSignatoryInfoActivity.e(ZryuSignSignatoryInfoActivity.this) != null)
        {
          ZryuSignSignatoryInfoActivity.f(ZryuSignSignatoryInfoActivity.this).setText(ZryuSignSignatoryInfoActivity.e(ZryuSignSignatoryInfoActivity.this).getName());
          ZryuSignSignatoryInfoActivity.g(ZryuSignSignatoryInfoActivity.this).setText(ZryuSignSignatoryInfoActivity.e(ZryuSignSignatoryInfoActivity.this).getSex());
          ZryuSignSignatoryInfoActivity.h(ZryuSignSignatoryInfoActivity.this).setTopHint(ZryuSignSignatoryInfoActivity.e(ZryuSignSignatoryInfoActivity.this).getCertTypeName());
          ZryuSignSignatoryInfoActivity.h(ZryuSignSignatoryInfoActivity.this).setText(ZryuSignSignatoryInfoActivity.e(ZryuSignSignatoryInfoActivity.this).getCertNo());
          ZryuSignSignatoryInfoActivity.i(ZryuSignSignatoryInfoActivity.this).setText(ZryuSignSignatoryInfoActivity.e(ZryuSignSignatoryInfoActivity.this).getPhone());
        }
      }
    }
  };
  private com.ziroom.ziroomcustomer.e.a.c w = new com.ziroom.ziroomcustomer.e.a.c(this, new d())
  {
    public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      j.iTrusRaConfig(ZryuSignSignatoryInfoActivity.this, ZryuSignSignatoryInfoActivity.j(ZryuSignSignatoryInfoActivity.this));
    }
  };
  private com.ziroom.ziroomcustomer.e.a.c x = new com.ziroom.ziroomcustomer.e.a.c(this, new com.ziroom.ziroomcustomer.e.c.a(IkeyRaConfig.class))
  {
    public void onSuccess(int paramAnonymousInt, IkeyRaConfig paramAnonymousIkeyRaConfig)
    {
      if ((paramAnonymousIkeyRaConfig != null) && (ApplicationEx.c.getUser() != null) && (ZryuSignSignatoryInfoActivity.e(ZryuSignSignatoryInfoActivity.this) != null))
      {
        paramAnonymousIkeyRaConfig = new com.ziroom.ziroomcustomer.util.a.c(new com.ziroom.ziroomcustomer.util.a.a(ApplicationEx.c.getUser().getUid(), ZryuSignSignatoryInfoActivity.e(ZryuSignSignatoryInfoActivity.this).getName(), ZryuSignSignatoryInfoActivity.e(ZryuSignSignatoryInfoActivity.this).getCertTypeName(), ZryuSignSignatoryInfoActivity.e(ZryuSignSignatoryInfoActivity.this).getCertNo()), paramAnonymousIkeyRaConfig);
        paramAnonymousIkeyRaConfig.setListener(new com.ziroom.ziroomcustomer.util.a.b()
        {
          public void onCertInitEnd(String paramAnonymous2String)
          {
            super.onCertInitEnd(paramAnonymous2String);
            ZryuSignSignatoryInfoActivity.3.this.dismissProgress();
            if (!TextUtils.isEmpty(paramAnonymous2String))
            {
              paramAnonymous2String = new Intent(ZryuSignSignatoryInfoActivity.this, SignerAptitudeActivity.class);
              paramAnonymous2String.putExtra("contractId", ZryuSignSignatoryInfoActivity.k(ZryuSignSignatoryInfoActivity.this));
              paramAnonymous2String.putExtra("zraType", "zra");
              ZryuSignSignatoryInfoActivity.this.startActivity(paramAnonymous2String);
            }
          }
          
          public void onCertInitStart()
          {
            super.onCertInitStart();
            ZryuSignSignatoryInfoActivity.3.this.showProgress();
          }
          
          public void onError(String paramAnonymous2String)
          {
            super.onError(paramAnonymous2String);
            j.zryuSignatureErrorLog(ZryuSignSignatoryInfoActivity.this, ZryuSignSignatoryInfoActivity.k(ZryuSignSignatoryInfoActivity.this), paramAnonymous2String, new com.ziroom.ziroomcustomer.e.a.b(ZryuSignSignatoryInfoActivity.this, new com.freelxl.baselibrary.d.f.e())
            {
              public void onFailure(Throwable paramAnonymous3Throwable) {}
            });
            ZryuSignSignatoryInfoActivity.3.this.dismissProgress();
            if (!TextUtils.isEmpty(ZryuSignSignatoryInfoActivity.l(ZryuSignSignatoryInfoActivity.this))) {
              com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(ZryuSignSignatoryInfoActivity.3.b(ZryuSignSignatoryInfoActivity.3.this)).setContent("下载电子签章证书失败，无法继续签约，请及时联系管家！").setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("联系管家").setOnConfirmClickListener(new c.b()
              {
                public void onClick(View paramAnonymous3View, boolean paramAnonymous3Boolean)
                {
                  if (paramAnonymous3Boolean) {
                    ah.callPhone(ZryuSignSignatoryInfoActivity.3.a(ZryuSignSignatoryInfoActivity.3.this), ZryuSignSignatoryInfoActivity.l(ZryuSignSignatoryInfoActivity.this));
                  }
                }
              }).build().show();
            }
          }
        });
        paramAnonymousIkeyRaConfig.certInit();
      }
    }
  };
  
  private void a()
  {
    this.a = ((SimpleDraweeView)findViewById(2131691098));
    this.b = ((TextView)findViewById(2131696404));
    this.c = ((TextView)findViewById(2131696579));
    this.d = ((TextView)findViewById(2131696402));
    this.e = ((LabeledEditText)findViewById(2131689982));
    this.f = ((LabeledEditText)findViewById(2131693040));
    this.g = ((LabeledEditText)findViewById(2131693041));
    this.r = ((LabeledEditText)findViewById(2131689983));
  }
  
  private void b()
  {
    this.s = getIntent().getStringExtra("contractId");
    if (!TextUtils.isEmpty(this.s)) {
      j.zryuContractSubject(this, this.s, this.v);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903619);
    ApplicationEx.c.addToZryuSign(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeFromZryuSign(this);
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    j.zryuSignSignatoryVerify(this, this.s, this.w);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignSignatoryInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */