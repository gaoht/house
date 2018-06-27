package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.i;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuLeaseInfo;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuLeaseInfoBill;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuLeaseInfoInlet;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuOldContractInfo;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignPerson;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignProject;
import java.util.ArrayList;
import java.util.List;

public class ZryuLeaseInfoActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private String c;
  private String d;
  private ZryuLeaseInfo e;
  private ZryuSignPerson f;
  private String g;
  @BindView(2131692878)
  TextView house_data_content;
  @BindView(2131692876)
  LinearLayout house_data_ll;
  @BindView(2131692888)
  TextView lease_all_bill_btn_tv;
  @BindView(2131692887)
  TextView lease_all_bill_hint_tv;
  @BindView(2131692885)
  RelativeLayout lease_all_bill_rl;
  @BindView(2131692881)
  TextView lease_date_content;
  @BindView(2131692879)
  LinearLayout lease_date_ll;
  @BindView(2131692899)
  TextView lease_old_contract_hint_tv;
  @BindView(2131692900)
  TextView old_contract_btn_tv;
  @BindView(2131692897)
  RelativeLayout old_contract_rl;
  private com.ziroom.ziroomcustomer.e.a.c<String> r = new com.ziroom.ziroomcustomer.e.a.c(this, new i())
  {
    public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousString);
      if (!TextUtils.isEmpty(paramAnonymousString))
      {
        ZryuLeaseInfoActivity.a(ZryuLeaseInfoActivity.this, paramAnonymousString);
        j.iTrusRaConfig(ZryuLeaseInfoActivity.this, ZryuLeaseInfoActivity.a(ZryuLeaseInfoActivity.this));
      }
    }
  };
  @BindView(2131696578)
  RelativeLayout rl_house_info;
  private com.ziroom.ziroomcustomer.e.a.c s = new com.ziroom.ziroomcustomer.e.a.c(this, new com.ziroom.ziroomcustomer.e.c.a(IkeyRaConfig.class))
  {
    public void onSuccess(int paramAnonymousInt, IkeyRaConfig paramAnonymousIkeyRaConfig)
    {
      if ((paramAnonymousIkeyRaConfig != null) && (ApplicationEx.c.getUser() != null) && (ZryuLeaseInfoActivity.b(ZryuLeaseInfoActivity.this) != null))
      {
        paramAnonymousIkeyRaConfig = new com.ziroom.ziroomcustomer.util.a.c(new com.ziroom.ziroomcustomer.util.a.a(ApplicationEx.c.getUser().getUid(), ZryuLeaseInfoActivity.b(ZryuLeaseInfoActivity.this).getName(), ZryuLeaseInfoActivity.b(ZryuLeaseInfoActivity.this).getCertTypeName(), ZryuLeaseInfoActivity.b(ZryuLeaseInfoActivity.this).getCertNo()), paramAnonymousIkeyRaConfig);
        paramAnonymousIkeyRaConfig.setListener(new com.ziroom.ziroomcustomer.util.a.b()
        {
          public void onError(String paramAnonymous2String)
          {
            super.onError(paramAnonymous2String);
            j.zryuSignatureErrorLog(ZryuLeaseInfoActivity.this, ZryuLeaseInfoActivity.c(ZryuLeaseInfoActivity.this), paramAnonymous2String, new com.ziroom.ziroomcustomer.e.a.b(ZryuLeaseInfoActivity.this, new com.freelxl.baselibrary.d.f.e())
            {
              public void onFailure(Throwable paramAnonymous3Throwable) {}
            });
            ZryuLeaseInfoActivity.4.this.dismissProgress();
            if ((ZryuLeaseInfoActivity.d(ZryuLeaseInfoActivity.this) != null) && (!TextUtils.isEmpty(ZryuLeaseInfoActivity.d(ZryuLeaseInfoActivity.this).getHandleZOPhone()))) {
              com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(ZryuLeaseInfoActivity.4.b(ZryuLeaseInfoActivity.4.this)).setContent("获取电子签章失败，无法继续签约，请及时联系管家！").setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("联系管家").setOnConfirmClickListener(new c.b()
              {
                public void onClick(View paramAnonymous3View, boolean paramAnonymous3Boolean)
                {
                  if (paramAnonymous3Boolean) {
                    ah.callPhone(ZryuLeaseInfoActivity.4.a(ZryuLeaseInfoActivity.4.this), ZryuLeaseInfoActivity.d(ZryuLeaseInfoActivity.this).getHandleZOPhone());
                  }
                }
              }).build().show();
            }
          }
          
          public void onSignEnd(String paramAnonymous2String)
          {
            super.onSignEnd(paramAnonymous2String);
            if (!TextUtils.isEmpty(paramAnonymous2String)) {
              j.zryuSignatureVerify(ZryuLeaseInfoActivity.this, ZryuLeaseInfoActivity.c(ZryuLeaseInfoActivity.this), paramAnonymous2String, ZryuLeaseInfoActivity.e(ZryuLeaseInfoActivity.this));
            }
          }
          
          public void onSignStart()
          {
            super.onSignStart();
          }
        });
        paramAnonymousIkeyRaConfig.sign(ZryuLeaseInfoActivity.f(ZryuLeaseInfoActivity.this));
      }
    }
  };
  @BindView(2131691098)
  SimpleDraweeView sdv;
  @BindView(2131692874)
  TextView sign_data_card_id_tv;
  @BindView(2131692871)
  LinearLayout sign_data_ll;
  @BindView(2131692872)
  TextView sign_data_name_tv;
  @BindView(2131692875)
  TextView sign_data_phone_tv;
  @BindView(2131692873)
  TextView sign_data_sex_tv;
  @BindView(2131692884)
  TextView sign_pay_type_content;
  @BindView(2131692882)
  LinearLayout sign_pay_type_ll;
  private com.ziroom.ziroomcustomer.findhouse.b.b<Object> t = new com.ziroom.ziroomcustomer.findhouse.b.b(this, new com.ziroom.ziroomcustomer.findhouse.b.e(Object.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      ZryuLeaseInfoActivity.this.dismissProgress();
    }
    
    public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousObject);
      ZryuLeaseInfoActivity.g(ZryuLeaseInfoActivity.this);
    }
  };
  @BindView(2131692863)
  TextView tv_delete_contract;
  @BindView(2131696579)
  TextView tv_house_info_add;
  @BindView(2131696404)
  TextView tv_house_info_name;
  @BindView(2131696402)
  TextView tv_house_info_price;
  @BindView(2131692869)
  ImageView zryu_lease_contract_code_img;
  @BindView(2131692867)
  RelativeLayout zryu_lease_contract_code_rl;
  @BindView(2131692868)
  TextView zryu_lease_contract_code_tv;
  @BindView(2131692870)
  TextView zryu_lease_contract_status_tv;
  @BindView(2131692892)
  ImageView zryu_lease_delivery_img;
  @BindView(2131692889)
  RelativeLayout zryu_lease_delivery_rl;
  @BindView(2131692891)
  TextView zryu_lease_delivery_status;
  @BindView(2131692890)
  TextView zryu_lease_delivery_tv;
  @BindView(2131692901)
  TextView zryu_lease_hint_tv;
  @BindView(2131692896)
  ImageView zryu_lease_roommates_img;
  @BindView(2131692893)
  RelativeLayout zryu_lease_roommates_rl;
  @BindView(2131692895)
  TextView zryu_lease_roommates_status;
  @BindView(2131692894)
  TextView zryu_lease_roommates_tv;
  @BindView(2131692866)
  TextView zryu_leasse_info_btn;
  @BindView(2131692865)
  TextView zryu_leasse_info_call;
  
  private void a()
  {
    this.c = getIntent().getStringExtra("deCode");
    if (com.freelxl.baselibrary.f.f.isNull(this.c)) {
      this.c = "XQ";
    }
    this.d = getIntent().getStringExtra("contractId");
    if (!TextUtils.isEmpty(this.d)) {
      j.zryuContractSign(this, this.d, this.c, new com.ziroom.ziroomcustomer.e.a.c(this, new com.ziroom.ziroomcustomer.e.c.f(ZryuLeaseInfo.class))
      {
        public void onSuccess(int paramAnonymousInt, ZryuLeaseInfo paramAnonymousZryuLeaseInfo)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousZryuLeaseInfo);
          if (paramAnonymousZryuLeaseInfo != null)
          {
            ZryuLeaseInfoActivity.a(ZryuLeaseInfoActivity.this, paramAnonymousZryuLeaseInfo.getSignPerson());
            ZryuLeaseInfoActivity.a(ZryuLeaseInfoActivity.this, paramAnonymousZryuLeaseInfo);
          }
        }
      });
    }
  }
  
  private void a(ZryuLeaseInfo paramZryuLeaseInfo)
  {
    if (paramZryuLeaseInfo == null) {
      return;
    }
    this.e = paramZryuLeaseInfo;
    label59:
    label99:
    Object localObject;
    if ("1".equals(paramZryuLeaseInfo.getCloseContract()))
    {
      this.tv_delete_contract.setVisibility(0);
      if (!com.freelxl.baselibrary.f.f.notNull(paramZryuLeaseInfo.getContactZO())) {
        break label369;
      }
      this.zryu_leasse_info_call.setText(paramZryuLeaseInfo.getContactZO());
      this.zryu_leasse_info_call.setVisibility(0);
      if (!com.freelxl.baselibrary.f.f.notNull(paramZryuLeaseInfo.getContractCode())) {
        break label381;
      }
      this.zryu_lease_contract_code_tv.setText("合同编号 " + paramZryuLeaseInfo.getContractCode());
      if (com.freelxl.baselibrary.f.f.notNull(paramZryuLeaseInfo.getConStatus())) {
        this.zryu_lease_contract_status_tv.setText(paramZryuLeaseInfo.getConStatus());
      }
      if ((com.freelxl.baselibrary.f.f.isNull(paramZryuLeaseInfo.getConStatus())) && (com.freelxl.baselibrary.f.f.isNull(paramZryuLeaseInfo.getContractCode()))) {
        this.zryu_lease_contract_code_rl.setVisibility(8);
      }
      localObject = paramZryuLeaseInfo.getProjectInfo();
      if (localObject == null) {
        break label461;
      }
      this.tv_house_info_name.setText(((ZryuSignProject)localObject).getProName());
      this.tv_house_info_add.setText(((ZryuSignProject)localObject).getProAddress());
      this.tv_house_info_price.setText(((ZryuSignProject)localObject).getRoomSalesPrice() + "");
      this.sdv.setController(com.freelxl.baselibrary.f.c.frescoController(((ZryuSignProject)localObject).getProHeadFigureUrl()));
      this.rl_house_info.setVisibility(0);
      label232:
      if (paramZryuLeaseInfo.getSignPerson() != null) {
        break label473;
      }
      this.sign_data_ll.setVisibility(8);
      label248:
      if ((!"0".equals(paramZryuLeaseInfo.getConStatusCode())) && (!com.freelxl.baselibrary.f.f.isNull(paramZryuLeaseInfo.getContractLinkType())) && (!"0".equals(paramZryuLeaseInfo.getContractLinkType()))) {
        break label592;
      }
      this.zryu_lease_contract_code_img.setVisibility(8);
    }
    for (;;)
    {
      label293:
      if (com.freelxl.baselibrary.f.f.notNull(paramZryuLeaseInfo.getRoomInfo()))
      {
        localObject = new ArrayList();
        int i = -1;
        for (;;)
        {
          if (i <= paramZryuLeaseInfo.getRoomInfo().lastIndexOf("|"))
          {
            i = paramZryuLeaseInfo.getRoomInfo().indexOf("|", i);
            ((List)localObject).add(Integer.valueOf(i));
            i += 1;
            continue;
            this.tv_delete_contract.setVisibility(8);
            break;
            label369:
            this.zryu_leasse_info_call.setVisibility(8);
            break label59;
            label381:
            if (!com.freelxl.baselibrary.f.f.notNull(paramZryuLeaseInfo.getHeadCarefulInfo())) {
              break label99;
            }
            if (com.freelxl.baselibrary.f.f.notNull(paramZryuLeaseInfo.getHeadCarefulDate()))
            {
              localObject = paramZryuLeaseInfo.getHeadCarefulInfo().replace("{1}", paramZryuLeaseInfo.getHeadCarefulDate());
              ah.setTextColor(this.zryu_lease_contract_code_tv, (String)localObject, paramZryuLeaseInfo.getHeadCarefulInfo().indexOf("{1}"), paramZryuLeaseInfo.getHeadCarefulDate().length(), "#000000");
              break label99;
            }
            this.zryu_lease_contract_code_tv.setText(paramZryuLeaseInfo.getHeadCarefulInfo());
            break label99;
            label461:
            this.rl_house_info.setVisibility(8);
            break label232;
            label473:
            this.sign_data_ll.setVisibility(0);
            if (ae.notNull(paramZryuLeaseInfo.getSignPerson().getName())) {
              this.sign_data_name_tv.setText(paramZryuLeaseInfo.getSignPerson().getName());
            }
            if (ae.notNull(paramZryuLeaseInfo.getSignPerson().getCertNo())) {
              this.sign_data_card_id_tv.setText(paramZryuLeaseInfo.getSignPerson().getCertNo());
            }
            if (ae.notNull(paramZryuLeaseInfo.getSignPerson().getPhone())) {
              this.sign_data_phone_tv.setText(paramZryuLeaseInfo.getSignPerson().getPhone());
            }
            if (!ae.notNull(paramZryuLeaseInfo.getSignPerson().getSex())) {
              break label248;
            }
            this.sign_data_sex_tv.setText(paramZryuLeaseInfo.getSignPerson().getSex());
            break label248;
            label592:
            this.zryu_lease_contract_code_img.setVisibility(0);
            break label293;
          }
        }
        ah.setTextColor(this.house_data_content, paramZryuLeaseInfo.getRoomInfo(), (List)localObject, 1, "#dddddd");
        this.house_data_ll.setVisibility(0);
        if (!com.freelxl.baselibrary.f.f.notNull(paramZryuLeaseInfo.getRentTime())) {
          break label1111;
        }
        this.lease_date_content.setText(paramZryuLeaseInfo.getRentTime());
        this.lease_date_ll.setVisibility(0);
        label656:
        if (!com.freelxl.baselibrary.f.f.notNull(paramZryuLeaseInfo.getPayItem())) {
          break label1123;
        }
        this.sign_pay_type_content.setText(paramZryuLeaseInfo.getPayItem());
        this.sign_pay_type_ll.setVisibility(0);
        label685:
        if (paramZryuLeaseInfo.getBillInfo() == null) {
          break label1147;
        }
        this.lease_all_bill_rl.setVisibility(0);
        if (!ae.notNull(paramZryuLeaseInfo.getBillInfo().getDesc())) {
          break label1135;
        }
        this.lease_all_bill_hint_tv.setText(paramZryuLeaseInfo.getBillInfo().getDesc());
        this.lease_all_bill_hint_tv.setVisibility(0);
        label735:
        if (ae.notNull(paramZryuLeaseInfo.getBillInfo().getName())) {
          this.lease_all_bill_btn_tv.setText(paramZryuLeaseInfo.getBillInfo().getName());
        }
        label762:
        if (paramZryuLeaseInfo.getDeliveryInfo() == null) {
          break label1171;
        }
        this.zryu_lease_delivery_rl.setVisibility(0);
        if (com.freelxl.baselibrary.f.f.notNull(paramZryuLeaseInfo.getDeliveryInfo().getName())) {
          this.zryu_lease_delivery_tv.setText(paramZryuLeaseInfo.getDeliveryInfo().getName());
        }
        if (!ae.notNull(paramZryuLeaseInfo.getDeliveryInfo().getValue())) {
          break label1159;
        }
        this.zryu_lease_delivery_status.setText(paramZryuLeaseInfo.getDeliveryInfo().getValue());
        this.zryu_lease_delivery_status.setVisibility(0);
        label839:
        if (paramZryuLeaseInfo.getSharePerson() == null) {
          break label1195;
        }
        this.zryu_lease_roommates_rl.setVisibility(0);
        if (com.freelxl.baselibrary.f.f.notNull(paramZryuLeaseInfo.getSharePerson().getName())) {
          this.zryu_lease_roommates_tv.setText(paramZryuLeaseInfo.getSharePerson().getName());
        }
        if (!ae.notNull(paramZryuLeaseInfo.getSharePerson().getValue())) {
          break label1183;
        }
        this.zryu_lease_roommates_status.setText(paramZryuLeaseInfo.getSharePerson().getValue());
        this.zryu_lease_roommates_status.setVisibility(0);
        label916:
        if (!ae.notNull(paramZryuLeaseInfo.getTailCarefulInfo())) {
          break label1207;
        }
        this.zryu_lease_hint_tv.setVisibility(0);
        this.zryu_lease_hint_tv.setText(paramZryuLeaseInfo.getTailCarefulInfo());
        label945:
        if (!ae.notNull(paramZryuLeaseInfo.getContactZO())) {
          break label1219;
        }
        this.zryu_leasse_info_call.setVisibility(0);
        this.zryu_leasse_info_call.setText(paramZryuLeaseInfo.getContactZO());
        label974:
        if (!com.freelxl.baselibrary.f.f.notNull(paramZryuLeaseInfo.getOperation())) {
          break label1243;
        }
        if ((!ae.notNull(paramZryuLeaseInfo.getOperation())) || (!com.freelxl.baselibrary.f.f.notNull(paramZryuLeaseInfo.getOperationCode()))) {
          break label1231;
        }
        this.zryu_leasse_info_btn.setText(paramZryuLeaseInfo.getOperation());
        this.zryu_leasse_info_btn.setVisibility(0);
        label1023:
        paramZryuLeaseInfo = paramZryuLeaseInfo.getPreContractInfo();
        if (paramZryuLeaseInfo == null) {
          break label1277;
        }
        this.old_contract_rl.setVisibility(0);
        if (!com.freelxl.baselibrary.f.f.notNull(paramZryuLeaseInfo.getPreContractCode())) {
          break label1255;
        }
        this.lease_old_contract_hint_tv.setText(paramZryuLeaseInfo.getPreContractCode());
        this.lease_old_contract_hint_tv.setVisibility(0);
      }
    }
    for (;;)
    {
      if (!ae.notNull(paramZryuLeaseInfo.getText())) {
        break label1267;
      }
      this.old_contract_btn_tv.setVisibility(0);
      this.old_contract_btn_tv.setText(paramZryuLeaseInfo.getText());
      return;
      this.house_data_ll.setVisibility(8);
      break;
      label1111:
      this.lease_date_ll.setVisibility(8);
      break label656;
      label1123:
      this.sign_pay_type_ll.setVisibility(8);
      break label685;
      label1135:
      this.lease_all_bill_hint_tv.setVisibility(8);
      break label735;
      label1147:
      this.lease_all_bill_rl.setVisibility(8);
      break label762;
      label1159:
      this.zryu_lease_delivery_status.setVisibility(8);
      break label839;
      label1171:
      this.zryu_lease_delivery_rl.setVisibility(8);
      break label839;
      label1183:
      this.zryu_lease_roommates_status.setVisibility(8);
      break label916;
      label1195:
      this.zryu_lease_roommates_rl.setVisibility(8);
      break label916;
      label1207:
      this.zryu_lease_hint_tv.setVisibility(8);
      break label945;
      label1219:
      this.zryu_leasse_info_call.setVisibility(8);
      break label974;
      label1231:
      this.zryu_leasse_info_btn.setVisibility(8);
      break label1023;
      label1243:
      this.zryu_leasse_info_btn.setVisibility(8);
      break label1023;
      label1255:
      this.lease_old_contract_hint_tv.setVisibility(8);
    }
    label1267:
    this.old_contract_btn_tv.setVisibility(8);
    return;
    label1277:
    this.old_contract_rl.setVisibility(8);
  }
  
  private void b()
  {
    j.deleteContract(this, this.d, "1", new com.ziroom.ziroomcustomer.e.a.c(this, new com.ziroom.ziroomcustomer.e.c.f(ZryuLeaseInfo.class))
    {
      public void onSuccess(int paramAnonymousInt, ZryuLeaseInfo paramAnonymousZryuLeaseInfo)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousZryuLeaseInfo);
        ZryuLeaseInfoActivity.this.finish();
      }
    });
  }
  
  private void e()
  {
    j.zryuSignatureQuery(this, this.d, this.r);
  }
  
  private void f()
  {
    j.zryuContractsignValid(this, this.d, new com.ziroom.commonlibrary.a.a(this, new com.ziroom.ziroomcustomer.e.c.d())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        if (((paramAnonymousThrowable instanceof com.ziroom.ziroomcustomer.e.b.a)) && (this != null)) {
          com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(ZryuLeaseInfoActivity.h(ZryuLeaseInfoActivity.this)).setContent(paramAnonymousThrowable.getMessage()).setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("联系管家").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
            {
              if (paramAnonymous2Boolean) {
                ah.callPhone(ZryuLeaseInfoActivity.h(ZryuLeaseInfoActivity.this), ZryuLeaseInfoActivity.d(ZryuLeaseInfoActivity.this).getHandleZOPhone());
              }
            }
          }).build().show();
        }
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        j.submitContract(ZryuLeaseInfoActivity.this, ZryuLeaseInfoActivity.c(ZryuLeaseInfoActivity.this), ZryuLeaseInfoActivity.d(ZryuLeaseInfoActivity.this).getBillInfo().getValue(), new com.ziroom.ziroomcustomer.e.a.c(ZryuLeaseInfoActivity.this, new com.ziroom.ziroomcustomer.e.c.f(ZryuLeaseInfo.class))
        {
          public void onSuccess(int paramAnonymous2Int, ZryuLeaseInfo paramAnonymous2ZryuLeaseInfo)
          {
            super.onSuccess(paramAnonymous2Int, paramAnonymous2ZryuLeaseInfo);
            paramAnonymous2ZryuLeaseInfo = new Intent(ZryuLeaseInfoActivity.h(ZryuLeaseInfoActivity.this), ZryuSignBillsInfoActivity.class);
            paramAnonymous2ZryuLeaseInfo.putExtra("contractId", ZryuLeaseInfoActivity.c(ZryuLeaseInfoActivity.this));
            paramAnonymous2ZryuLeaseInfo.putExtra("isBack", false);
            paramAnonymous2ZryuLeaseInfo.putExtra("type", "1007");
            paramAnonymous2ZryuLeaseInfo.putExtra("period", "1");
            ZryuLeaseInfoActivity.this.startActivity(paramAnonymous2ZryuLeaseInfo);
            ApplicationEx.c.finishZryuSign();
          }
        });
      }
    });
  }
  
  @OnClick({2131689492, 2131692865, 2131692893, 2131696578, 2131692885, 2131692866, 2131692867, 2131692863, 2131692889, 2131692900})
  public void OnClick(View paramView)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    switch (paramView.getId())
    {
    case 2131696578: 
    default: 
    case 2131692900: 
    case 2131692889: 
    case 2131692863: 
    case 2131692867: 
    case 2131692866: 
    case 2131692885: 
    case 2131692893: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (com.freelxl.baselibrary.f.f.isNull(this.e.getPreContractInfo().getPreContractID()))
                  {
                    showToast("获取数据失败");
                    return;
                  }
                  paramView = new Intent(this.b, ZryuLeaseInfoActivity.class);
                  paramView.putExtra("contractId", this.e.getPreContractInfo().getPreContractID());
                  startActivity(paramView);
                  return;
                  com.ziroom.ziroomcustomer.ziroomapartment.b.toDelivery(this.b, this.d);
                  return;
                  com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setContent("关闭合同后将无法继续签约，如有已支付金额将退至您的账户空间，请确认是否继续关闭合同？").setTitle("确认关闭合同").setButtonText("取消", "关闭").setOnConfirmClickListener(new d.b()
                  {
                    public void onLeftClick(View paramAnonymousView) {}
                    
                    public void onRightClick(View paramAnonymousView)
                    {
                      ZryuLeaseInfoActivity.i(ZryuLeaseInfoActivity.this);
                    }
                  }).show();
                  return;
                } while ((this.zryu_lease_contract_code_img.getVisibility() != 0) || (this.e == null));
                paramView = "0";
                UserInfo localUserInfo = ApplicationEx.c.getUser();
                if (localUserInfo != null) {
                  paramView = localUserInfo.getUid();
                }
                if ("2".equals(this.e.getContractLinkType()))
                {
                  ah.downloadPdf(this, q.E + "contractsign/provision/pdf/v1?contractId=" + this.e.getContractId() + "&uid=" + paramView);
                  return;
                }
                if ("1".equals(this.e.getContractLinkType()))
                {
                  paramView = new Intent(this.b, ZryuTextWebActivity.class);
                  paramView.putExtra("contractId", this.e.getContractId());
                  startActivity(paramView);
                  return;
                }
              } while (!"3".equals(this.e.getContractLinkType()));
              showToast("您已签署纸质合同，所有信息均以纸质合同为准");
              return;
            } while ((this.e == null) || (com.freelxl.baselibrary.f.f.isNull(this.e.getOperationCode())));
            if ("0".equals(this.e.getOperationCode()))
            {
              com.ziroom.ziroomcustomer.ziroomapartment.b.toSign(this.b, this.d, this.e.getHandleZOPhone());
              ApplicationEx.c.addToZryuSign(this);
              return;
            }
            if ("1".equals(this.e.getOperationCode()))
            {
              com.ziroom.ziroomcustomer.ziroomapartment.b.toBillsInfo(this.b, this.d, this.e.getContractCode(), "1007", "1");
              ApplicationEx.c.addToZryuSign(this);
              return;
            }
            if ("2".equals(this.e.getOperationCode()))
            {
              com.ziroom.ziroomcustomer.ziroomapartment.b.toDelivery(this.b, this.d);
              return;
            }
            if ("3".equals(this.e.getOperationCode()))
            {
              if (com.freelxl.baselibrary.f.f.notNull(this.e.getRenewContractId()))
              {
                com.ziroom.ziroomcustomer.ziroomapartment.b.toSign(this.b, this.e.getRenewContractId(), this.e.getHandleZOPhone());
                ApplicationEx.c.addToZryuSign(this);
                return;
              }
              com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setContent("管家还未发起续约通知，请及时联系管家").setTitle("提示").setButtonText("取消", "联系管家").setOnConfirmClickListener(new d.b()
              {
                public void onLeftClick(View paramAnonymousView) {}
                
                public void onRightClick(View paramAnonymousView)
                {
                  if (ZryuLeaseInfoActivity.d(ZryuLeaseInfoActivity.this) == null)
                  {
                    ZryuLeaseInfoActivity.this.showToast("管家手机号获取失败");
                    return;
                  }
                  if (com.freelxl.baselibrary.f.f.isNull(ZryuLeaseInfoActivity.d(ZryuLeaseInfoActivity.this).getHandleZOPhone()))
                  {
                    ZryuLeaseInfoActivity.this.showToast("管家手机号获取失败");
                    return;
                  }
                  ah.callPhone(ZryuLeaseInfoActivity.this, ZryuLeaseInfoActivity.d(ZryuLeaseInfoActivity.this).getHandleZOPhone());
                }
              }).show();
              return;
            }
            if ("4".equals(this.e.getOperationCode()))
            {
              com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setContent("您确认签订此合同么？").setTitle("确认合同").setButtonText("取消", "确定").setOnConfirmClickListener(new d.b()
              {
                public void onLeftClick(View paramAnonymousView) {}
                
                public void onRightClick(View paramAnonymousView)
                {
                  ZryuLeaseInfoActivity.this.showProgressNoCancel("", 30000L);
                  ZryuLeaseInfoActivity.j(ZryuLeaseInfoActivity.this);
                }
              }).show();
              return;
            }
            if ("5".equals(this.e.getOperationCode()))
            {
              if ("0".equals(this.e.getConStatusCode())) {}
              for (;;)
              {
                com.ziroom.ziroomcustomer.ziroomapartment.b.toBillsList(this.b, this.d, 1, i);
                return;
                i = 1;
              }
            }
          } while (!"6".equals(this.e.getOperationCode()));
          if ("0".equals(this.e.getConStatusCode())) {}
          for (i = j;; i = 1)
          {
            com.ziroom.ziroomcustomer.ziroomapartment.b.toBillsList(this.b, this.d, 2, i);
            return;
          }
          if ("0".equals(this.e.getConStatusCode())) {}
          for (i = k;; i = 1)
          {
            com.ziroom.ziroomcustomer.ziroomapartment.b.toBillsList(this.b, this.d, 1, i);
            return;
          }
        } while ((this.e == null) || (this.e.getSharePerson() == null));
        if ("0".equals(this.e.getSharePerson().getLinkType()))
        {
          showToast(this.e.getSharePerson().getDesc() + "");
          return;
        }
      } while (!"1".equals(this.e.getSharePerson().getLinkType()));
      paramView = new Intent(this.b, ZryuSignCotenantActivity.class);
      paramView.putExtra("isShow", true);
      paramView.putExtra("contractId", this.d);
      startActivity(paramView);
      return;
    case 2131689492: 
      finish();
      return;
    }
    if (this.e == null)
    {
      showToast("管家手机号获取失败");
      return;
    }
    if (com.freelxl.baselibrary.f.f.isNull(this.e.getHandleZOPhone()))
    {
      showToast("管家手机号获取失败");
      return;
    }
    ah.callPhone(this, this.e.getHandleZOPhone());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903585);
    this.a = ButterKnife.bind(this);
    this.b = this;
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeFromZryuSign(this);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuLeaseInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */