package com.ziroom.ziroomcustomer.sublet.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.account.AccountMainActivity;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.activity.NewLeaseInfoActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.r;
import com.ziroom.ziroomcustomer.e.e.m;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.InfoItem;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.sublet.model.SubletProgressStepModel;
import com.ziroom.ziroomcustomer.sublet.model.SubletReservationDetail;
import com.ziroom.ziroomcustomer.sublet.model.SubletReservationDetail.DataBean;
import com.ziroom.ziroomcustomer.sublet.model.SubletReservationDetail.DataBean.BtnBean;
import com.ziroom.ziroomcustomer.sublet.model.SubletReservationDetail.DataBean.FlowBean;
import com.ziroom.ziroomcustomer.sublet.model.SubletReservationDetail.DataBean.HouseInfoBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.InfoBlockLayout;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubletReservationDetailActivity
  extends BaseActivity
{
  String A;
  int B;
  f<e> C = new f(this, new r())
  {
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if (paramAnonymouse != null)
      {
        u.logBigData("OKHttp_ymq", "===" + paramAnonymouse.toString());
        paramAnonymousInt = paramAnonymouse.getInteger("error_code").intValue();
        String str = paramAnonymouse.getString("status");
        paramAnonymouse.getString("data");
        paramAnonymouse = paramAnonymouse.getString("error_message");
        if ((!"success".equals(str)) || (paramAnonymousInt != 0)) {
          break label89;
        }
      }
      for (;;)
      {
        SubletReservationDetailActivity.e(SubletReservationDetailActivity.this);
        return;
        label89:
        af.showToast(SubletReservationDetailActivity.this.z, paramAnonymouse);
      }
    }
  };
  String a;
  String b;
  String c;
  String d;
  String e;
  String f;
  int g;
  @BindView(2131697617)
  InfoBlockLayout iblReservationInfo;
  @BindView(2131697618)
  InfoBlockLayout iblZuKeInfo;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131697615)
  LinearLayout llProgressContainer;
  @BindView(2131697616)
  ListViewForScrollView lvfsvReservatingProgress;
  List<InfoItem> r;
  @BindView(2131696456)
  RelativeLayout rlHouseInfoContainer;
  List<InfoItem> s;
  @BindView(2131696457)
  SimpleDraweeView sdvHouseInfoPic;
  List<SubletProgressStepModel> t;
  @BindView(2131697619)
  TextView tvBtnLeft;
  @BindView(2131697620)
  TextView tvBtnRight;
  @BindView(2131697614)
  TextView tvConfirmDesc;
  @BindView(2131691990)
  TextView tvContactKeeper;
  @BindView(2131696460)
  TextView tvHouseInfoNumber;
  @BindView(2131696459)
  TextView tvHouseInfoPrice;
  @BindView(2131696458)
  TextView tvHouseInfoTitle;
  @BindView(2131697613)
  TextView tvReservationStatus;
  String u;
  com.ziroom.ziroomcustomer.sublet.a.a v;
  @BindView(2131696461)
  View viewBelowContainer;
  String w;
  String x;
  SubletReservationDetail y;
  Context z;
  
  private void a()
  {
    this.viewBelowContainer.setVisibility(8);
    this.w = getIntent().getStringExtra("reserveCode");
    this.B = getIntent().getIntExtra("isPaySuccess", 0);
    this.v = new com.ziroom.ziroomcustomer.sublet.a.a(this, this.t);
    this.lvfsvReservatingProgress.setAdapter(this.v);
  }
  
  private void a(final SubletReservationDetail.DataBean.BtnBean paramBtnBean)
  {
    String str = paramBtnBean.type;
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        d.newBuilder(this.z).setOnConfirmClickListener(new d.b()
        {
          public void onLeftClick(View paramAnonymousView) {}
          
          public void onRightClick(View paramAnonymousView)
          {
            paramAnonymousView = com.ziroom.ziroomcustomer.e.g.buildZkCancel(SubletReservationDetailActivity.this.w, SubletReservationDetailActivity.this.x);
            String str = paramBtnBean.type;
            int i = -1;
            switch (str.hashCode())
            {
            }
            for (;;)
            {
              switch (i)
              {
              default: 
                return;
                if (str.equals("cancel"))
                {
                  i = 0;
                  continue;
                  if (str.equals("confirm"))
                  {
                    i = 1;
                    continue;
                    if (str.equals("delete_cancel")) {
                      i = 2;
                    }
                  }
                }
                break;
              }
            }
            if (2 == SubletReservationDetailActivity.this.g)
            {
              j.zkCancelReservation(SubletReservationDetailActivity.this.z, paramAnonymousView, SubletReservationDetailActivity.this.C);
              return;
            }
            com.ziroom.ziroomcustomer.minsu.b.c.d = q.s + e.m.j;
            paramAnonymousView = com.ziroom.ziroomcustomer.e.g.buildGetreserveCloseOrder(SubletReservationDetailActivity.this.w);
            j.getReservationOrderText(SubletReservationDetailActivity.this.z, new SubletReservationDetailActivity.a(SubletReservationDetailActivity.this), paramAnonymousView, true, com.ziroom.ziroomcustomer.minsu.b.c.d);
            return;
            j.zkConfirmCancel(SubletReservationDetailActivity.this.z, paramAnonymousView, SubletReservationDetailActivity.this.C);
            return;
            j.zkInvalidCancel(SubletReservationDetailActivity.this.z, paramAnonymousView, SubletReservationDetailActivity.this.C);
          }
        }).setTitle(paramBtnBean.promptTitle).setContent(paramBtnBean.promptText).setButtonText("取消", "确定").show();
      }
      break;
    }
    do
    {
      return;
      if (!str.equals("pay")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("sign")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("show_contract_code")) {
        break;
      }
      i = 2;
      break;
      paramBtnBean = new Intent(this.z, HouseBillInfoActivity.class);
      paramBtnBean.putExtra("uniqueCode", this.w);
      paramBtnBean.putExtra("period", "");
      paramBtnBean.putExtra("payType", "ZZYD");
      paramBtnBean.putExtra("mContentText", "倒计时结束之前，您可以在“我的订单”里找到待支付的长租预订单进行支付。");
      startActivityAndFinish(paramBtnBean);
      return;
    } while ((this.y == null) || (this.y.data == null) || (this.y.data.houseInfo == null));
    paramBtnBean = com.ziroom.ziroomcustomer.e.g.buildGetreserveData(this.w);
    j.checkReserveCanSign(this.z, paramBtnBean, new f(this.z, new r())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp_ymq", "===" + paramAnonymouse.toString());
        paramAnonymouse.getInteger("error_code").intValue();
        String str = paramAnonymouse.getString("status");
        paramAnonymouse.getString("data");
        paramAnonymouse = paramAnonymouse.getString("error_message");
        if ("success".equals(str))
        {
          paramAnonymouse = new ArrayList();
          paramAnonymouse.add(SubletReservationDetailActivity.this.y.data.houseInfo.picUrl);
          paramAnonymouse = new HouseDetail(SubletReservationDetailActivity.this.y.data.houseType, paramAnonymouse, SubletReservationDetailActivity.this.y.data.houseInfo.housePrice, SubletReservationDetailActivity.this.y.data.houseInfo.houseAddress, SubletReservationDetailActivity.this.y.data.isShort, SubletReservationDetailActivity.this.y.data.houseCode, SubletReservationDetailActivity.this.y.data.houseId);
          paramAnonymouse.setCityCode(com.ziroom.ziroomcustomer.minsu.b.c.a);
          new o(SubletReservationDetailActivity.this.z).toSign(paramAnonymouse, 1);
          return;
        }
        af.showToast(SubletReservationDetailActivity.this.z, paramAnonymouse);
      }
    });
    return;
    paramBtnBean = new Intent(this.z, NewLeaseInfoActivity.class);
    paramBtnBean.putExtra("contract_code", this.A);
    paramBtnBean.putExtra("className", SubletReservationDetailActivity.class.getSimpleName());
    startActivity(paramBtnBean);
  }
  
  private void b()
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.z);
      return;
    }
    j.getSubletReservationDetail(this, com.ziroom.ziroomcustomer.e.g.buildGetreserveData(this.w), new f(this, new r())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse != null)
        {
          u.logBigData("OKHttp_ymq", "===" + paramAnonymouse.toString());
          SubletReservationDetailActivity.this.y = ((SubletReservationDetail)e.parseObject(paramAnonymouse.toString(), SubletReservationDetail.class));
          if (SubletReservationDetailActivity.this.y != null)
          {
            if (!"success".equals(SubletReservationDetailActivity.this.y.status)) {
              break label478;
            }
            if (SubletReservationDetailActivity.this.y.data != null)
            {
              SubletReservationDetailActivity.this.x = (SubletReservationDetailActivity.this.y.data.reserveStatus + "");
              SubletReservationDetailActivity.this.A = SubletReservationDetailActivity.this.y.data.contractCode;
              SubletReservationDetailActivity.this.g = SubletReservationDetailActivity.this.y.data.reserveType;
              SubletReservationDetailActivity.this.r = new ArrayList();
              SubletReservationDetailActivity.this.s = new ArrayList();
              SubletReservationDetailActivity.a(SubletReservationDetailActivity.this);
              SubletReservationDetailActivity.b(SubletReservationDetailActivity.this);
              SubletReservationDetailActivity.c(SubletReservationDetailActivity.this);
              SubletReservationDetailActivity.d(SubletReservationDetailActivity.this);
              if ((SubletReservationDetailActivity.this.y.data.buttons == null) || (SubletReservationDetailActivity.this.y.data.buttons.size() <= 0)) {
                break label451;
              }
              if (1 != SubletReservationDetailActivity.this.y.data.buttons.size()) {
                break label356;
              }
              SubletReservationDetailActivity.this.tvBtnLeft.setVisibility(8);
              SubletReservationDetailActivity.this.tvBtnRight.setVisibility(0);
              SubletReservationDetailActivity.this.tvBtnRight.setText(((SubletReservationDetail.DataBean.BtnBean)SubletReservationDetailActivity.this.y.data.buttons.get(0)).title);
            }
          }
        }
        for (;;)
        {
          SubletReservationDetailActivity.this.updateView();
          return;
          label356:
          SubletReservationDetailActivity.this.tvBtnLeft.setVisibility(0);
          SubletReservationDetailActivity.this.tvBtnLeft.setText(((SubletReservationDetail.DataBean.BtnBean)SubletReservationDetailActivity.this.y.data.buttons.get(0)).title);
          SubletReservationDetailActivity.this.tvBtnRight.setVisibility(0);
          SubletReservationDetailActivity.this.tvBtnRight.setText(((SubletReservationDetail.DataBean.BtnBean)SubletReservationDetailActivity.this.y.data.buttons.get(1)).title);
          continue;
          label451:
          SubletReservationDetailActivity.this.tvBtnLeft.setVisibility(8);
          SubletReservationDetailActivity.this.tvBtnRight.setVisibility(8);
        }
        label478:
        af.showToast(SubletReservationDetailActivity.this.z, SubletReservationDetailActivity.this.y.error_message);
      }
    });
  }
  
  private void e()
  {
    this.f = this.y.data.remindDesc;
    this.u = this.y.data.keeperPhone;
    this.a = this.y.data.reserveStatusStr;
    this.d = this.y.data.reserveCode;
    if (this.y.data.houseInfo != null)
    {
      this.b = this.y.data.houseInfo.picUrl;
      this.c = this.y.data.houseInfo.houseAddress;
      this.e = (this.y.data.houseInfo.housePrice + this.y.data.houseInfo.priceUnit);
    }
  }
  
  private void f()
  {
    this.t = new ArrayList();
    if ((this.y.data.flowList != null) && (this.y.data.flowList.size() > 0))
    {
      int i = 0;
      int j = 0;
      if (i < this.y.data.flowList.size())
      {
        SubletProgressStepModel localSubletProgressStepModel = new SubletProgressStepModel();
        final SubletReservationDetail.DataBean.FlowBean localFlowBean = (SubletReservationDetail.DataBean.FlowBean)this.y.data.flowList.get(i);
        localSubletProgressStepModel.title = localFlowBean.title;
        localSubletProgressStepModel.desc = localFlowBean.contents;
        if (1 == localFlowBean.isLight)
        {
          localSubletProgressStepModel.status = 1;
          j = 1;
        }
        for (;;)
        {
          localSubletProgressStepModel.buttonText = localFlowBean.buttonTitle;
          if (!ae.isNull(localSubletProgressStepModel.buttonText)) {
            localSubletProgressStepModel.listener = new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                paramAnonymousView = localFlowBean.type;
                int i = -1;
                switch (paramAnonymousView.hashCode())
                {
                }
                for (;;)
                {
                  switch (i)
                  {
                  default: 
                    return;
                    if (paramAnonymousView.equals("phone"))
                    {
                      i = 0;
                      continue;
                      if (paramAnonymousView.equals("draw")) {
                        i = 1;
                      }
                    }
                    break;
                  }
                }
                ah.callPhone(SubletReservationDetailActivity.this.z, localFlowBean.buttonValue);
                return;
                paramAnonymousView = new Intent(SubletReservationDetailActivity.this.z, AccountMainActivity.class);
                SubletReservationDetailActivity.this.startActivity(paramAnonymousView);
              }
            };
          }
          this.t.add(localSubletProgressStepModel);
          i += 1;
          break;
          if (j == 0) {
            localSubletProgressStepModel.status = 0;
          } else {
            localSubletProgressStepModel.status = 2;
          }
        }
      }
    }
  }
  
  private void g()
  {
    int i = 0;
    if (i < 3)
    {
      InfoItem localInfoItem = new InfoItem();
      switch (i)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localInfoItem.title = "预计可入住日期";
        localInfoItem.value = this.y.data.canAdmittedTime;
        this.r.add(localInfoItem);
        continue;
        localInfoItem.title = "预订金";
        localInfoItem.value = this.y.data.reserveDepositStr;
        this.r.add(localInfoItem);
        continue;
        if (ae.notNull(this.y.data.reserveContractUrl))
        {
          localInfoItem.title = "预订合同";
          localInfoItem.value = "查看合约文本详情";
          localInfoItem.listener = new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              paramAnonymousView = new Intent(SubletReservationDetailActivity.this.z, ReservationTermsActivity.class);
              paramAnonymousView.putExtra("reserveCode", SubletReservationDetailActivity.this.w);
              SubletReservationDetailActivity.this.z.startActivity(paramAnonymousView);
            }
          };
          this.r.add(localInfoItem);
        }
      }
    }
  }
  
  private void h()
  {
    int i = 0;
    if (i < 2)
    {
      InfoItem localInfoItem = new InfoItem();
      switch (i)
      {
      }
      for (;;)
      {
        this.s.add(localInfoItem);
        i += 1;
        break;
        localInfoItem.title = "姓名";
        localInfoItem.value = this.y.data.reserveUserName;
        continue;
        localInfoItem.title = "证件号码";
        localInfoItem.value = c(this.y.data.reserveUserCertNum);
        continue;
        localInfoItem.title = "实名认证";
        localInfoItem.value = "已认证";
        localInfoItem.listener = new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            af.showToast(SubletReservationDetailActivity.this.z, "到认证信息页");
          }
        };
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905160);
    ButterKnife.bind(this);
    this.z = this;
    a();
    b();
  }
  
  @OnClick({2131689492, 2131691990, 2131697619, 2131697620, 2131696456})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      paramView = new Intent(this.z, RentHouseDetailActivity.class);
      paramView.putExtra("house_id", this.y.data.houseId);
      paramView.putExtra("id", this.y.data.houseCode);
      this.z.startActivity(paramView);
      return;
      if (1 == this.B)
      {
        paramView = new Intent(this, MainActivity.class);
        paramView.putExtra("FRAGMENT_TYPE", 7);
        startActivity(paramView);
        return;
      }
      finish();
      return;
      ah.callPhone(this, this.u);
      return;
      a((SubletReservationDetail.DataBean.BtnBean)this.y.data.buttons.get(0));
      return;
      if (1 == this.y.data.buttons.size())
      {
        a((SubletReservationDetail.DataBean.BtnBean)this.y.data.buttons.get(0));
        return;
      }
    } while (this.y.data.buttons.size() < 2);
    a((SubletReservationDetail.DataBean.BtnBean)this.y.data.buttons.get(1));
  }
  
  public void updateView()
  {
    this.tvReservationStatus.setText(this.a);
    this.sdvHouseInfoPic.setController(com.freelxl.baselibrary.f.c.frescoController(this.b));
    this.tvHouseInfoTitle.setText(this.c);
    this.tvHouseInfoNumber.setText(this.d);
    this.tvHouseInfoPrice.setText(this.e);
    this.tvHouseInfoPrice.setCompoundDrawables(null, null, null, null);
    switch (this.y.data.reserveStatus)
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    default: 
      this.tvReservationStatus.setTextColor(getResources().getColor(2131624599));
      this.iblReservationInfo.initData("预订单信息", this.r);
      this.iblZuKeInfo.initData("预订人信息", this.s);
      if (ae.isNull(this.f))
      {
        this.tvConfirmDesc.setVisibility(8);
        label196:
        if (!ae.isNull(this.u)) {
          break label296;
        }
        this.tvContactKeeper.setVisibility(8);
      }
      break;
    }
    for (;;)
    {
      if ((this.t == null) || (this.t.size() <= 0)) {
        break label307;
      }
      this.llProgressContainer.setVisibility(0);
      this.v.setDatas(this.t);
      return;
      this.tvReservationStatus.setTextColor(getResources().getColor(2131624609));
      break;
      this.tvConfirmDesc.setVisibility(0);
      this.tvConfirmDesc.setText(this.f);
      break label196;
      label296:
      this.tvContactKeeper.setVisibility(0);
    }
    label307:
    this.llProgressContainer.setVisibility(8);
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (com.ziroom.ziroomcustomer.minsu.b.c.d.equals(paramk.getUrl()))
        {
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(null);
        }
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        af.showToast(SubletReservationDetailActivity.this, "取消预订成功");
        return;
      }
      paramk = paramk.getMessage();
      com.freelxl.baselibrary.f.g.textToast(SubletReservationDetailActivity.this.z, "" + paramk, 0);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/SubletReservationDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */