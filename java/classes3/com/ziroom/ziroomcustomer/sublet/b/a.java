package com.ziroom.ziroomcustomer.sublet.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.AccountMainActivity;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.dialog.c.a;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.e.q;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.InfoItem;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.sublet.activity.LeaseSubletInfoActivity;
import com.ziroom.ziroomcustomer.sublet.activity.LeaseSubletInfomationActivity;
import com.ziroom.ziroomcustomer.sublet.activity.ReservationTermsActivity;
import com.ziroom.ziroomcustomer.sublet.activity.SubletHouseShareActivity;
import com.ziroom.ziroomcustomer.sublet.activity.SubletInitiatorDetailActivity;
import com.ziroom.ziroomcustomer.sublet.model.ButtonBean;
import com.ziroom.ziroomcustomer.sublet.model.SubletProgressStepModel;
import com.ziroom.ziroomcustomer.sublet.model.SubletTurnDetailBean;
import com.ziroom.ziroomcustomer.sublet.model.SubletTurnDetailBean.ButtonBean;
import com.ziroom.ziroomcustomer.sublet.model.SubletTurnDetailBean.LinksBean;
import com.ziroom.ziroomcustomer.sublet.model.SubletTurnDetailBean.ProcessBean;
import com.ziroom.ziroomcustomer.sublet.model.SubletTurnDetailBean.ShareBean;
import com.ziroom.ziroomcustomer.sublet.model.SubletTurnDetailBean.TurnBean;
import com.ziroom.ziroomcustomer.sublet.widget.SubletBookcodeDialog;
import com.ziroom.ziroomcustomer.termination.ConfirmTerminationActivity;
import com.ziroom.ziroomcustomer.termination.InitiateTerminationActivity;
import com.ziroom.ziroomcustomer.termination.PaymentInformationActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
{
  View.OnClickListener a = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      SubletInitiatorDetailActivity localSubletInitiatorDetailActivity = a.a(a.this);
      StringBuilder localStringBuilder = new StringBuilder();
      if (a.p(a.this)) {}
      for (paramAnonymousView = "关闭";; paramAnonymousView = "接受")
      {
        af.showToast(localSubletInitiatorDetailActivity, paramAnonymousView + "咨询");
        return;
      }
    }
  };
  private SubletInitiatorDetailActivity b;
  private SubletTurnDetailBean c;
  private boolean d = true;
  private String e;
  private b f;
  private f<com.alibaba.fastjson.e> g = new f(this.b, new com.ziroom.ziroomcustomer.findhouse.b.c())
  {
    public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if ((a.a(a.this) != null) || (!a.a(a.this).isFinishing()))
      {
        a.a(a.this).refreshView();
        if (!"success".equals(paramAnonymouse.getString("status"))) {}
      }
      else
      {
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(a.a(a.this), paramAnonymouse.getString("error_message"));
    }
  };
  private RentHouseDetail h;
  
  public a(SubletInitiatorDetailActivity paramSubletInitiatorDetailActivity)
  {
    this.b = paramSubletInitiatorDetailActivity;
  }
  
  private void a()
  {
    if (this.c == null) {
      return;
    }
    this.b.showTitleButton(this.c.getMore());
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {}
    for (String str = com.ziroom.ziroomcustomer.e.q.Q + e.q.j;; str = com.ziroom.ziroomcustomer.e.q.Q + e.q.k)
    {
      com.freelxl.baselibrary.d.a.isLog(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(this.b));
      localHashMap.put("contract_code", this.e);
      com.freelxl.baselibrary.d.a.post(str).tag(this).params(com.ziroom.ziroomcustomer.e.g.getCommonHouseSign(localHashMap)).enqueue(new f(this.b, new com.ziroom.ziroomcustomer.e.c.q(com.alibaba.fastjson.e.class))
      {
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          u.d("OKHttp", "===" + paramAnonymouse.toString());
          af.showToast(a.a(a.this), "修改成功");
          a.this.initData(a.c(a.this));
        }
      });
      return;
    }
  }
  
  private void a(ButtonBean paramButtonBean)
  {
    if (this.c == null) {
      return;
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.b).setContent(paramButtonBean.getPromptText()).setTitle(paramButtonBean.getPromptTitle()).setButtonText("再想想").setSecondButtonText("确认").setOnSecondClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        a.a(a.this, 1);
      }
    }).build().show();
  }
  
  private void a(ButtonBean paramButtonBean, String paramString1, String paramString2)
  {
    if ((this.c == null) || (paramButtonBean == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramButtonBean.getPromptText()))
    {
      j.subletInitiatorCancelTenant(this.b, com.ziroom.commonlibrary.login.a.getUid(this.b), this.c.getReserve_code(), this.c.getReserve_status() + "", this.g);
      return;
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.b).setContent(paramButtonBean.getPromptText()).setTitle(paramButtonBean.getPromptTitle()).setButtonText(paramString1).setSecondButtonText(paramString2).setOnSecondClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        j.subletInitiatorCancelTenant(a.a(a.this), com.ziroom.commonlibrary.login.a.getUid(a.a(a.this)), a.b(a.this).getReserve_code(), a.b(a.this).getReserve_status() + "", a.w(a.this));
      }
    }).build().show();
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((this.b == null) || (this.b.isFinishing())) {
      return;
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.b).setTitle(paramString1).setContent(paramString2).setButtonText(paramString3).setCanceledOnBackPressed(false).setCanceledOnTouchOutside(false).setOnButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        a.a(a.this).refreshView();
      }
    }).build().show();
  }
  
  private void b()
  {
    int j = 0;
    if (this.c == null) {
      return;
    }
    int k = this.b.getResources().getColor(2131624417);
    int i = this.b.getResources().getColor(2131624588);
    switch (this.c.getStatus())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      this.b.showStatusTag(this.c.getStatus_text(), i, j);
      return;
      i = k;
      continue;
      j = 2130840471;
    }
  }
  
  private void b(ButtonBean paramButtonBean)
  {
    if (this.c == null) {
      return;
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.b).setContent(paramButtonBean.getPromptText()).setTitle(paramButtonBean.getPromptTitle()).setButtonText("再想想").setSecondButtonText("确认").setOnSecondClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        a.a(a.this, 2);
      }
    }).build().show();
  }
  
  private void c()
  {
    if (this.c == null) {
      return;
    }
    String str2 = this.c.getPrice() + " " + this.c.getPrice_unit();
    SubletInitiatorDetailActivity localSubletInitiatorDetailActivity = this.b;
    String str3 = this.c.getPhoto();
    String str4 = this.c.getTitle();
    if (ae.isNull(this.c.getReserve_code())) {}
    for (String str1 = "修改转租房源详情";; str1 = "查看转租房源详情")
    {
      localSubletInitiatorDetailActivity.showHouseInfo(str3, str4, str2, str1, new a("initiator_house_detail"));
      return;
    }
  }
  
  private void c(ButtonBean paramButtonBean)
  {
    if (this.c == null) {
      return;
    }
    if (TextUtils.isEmpty(paramButtonBean.getPromptText()))
    {
      p();
      w.onEvent(this.b, "change_lease_off");
      return;
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.b).setContent(paramButtonBean.getPromptText()).setTitle(paramButtonBean.getPromptTitle()).setButtonText("再想想").setSecondButtonText("确认退租").setOnSecondClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        a.v(a.this);
        w.onEvent(a.a(a.this), "change_lease_off");
      }
    }).build().show();
  }
  
  private void d()
  {
    if (this.c == null) {
      return;
    }
    this.b.showChangeTime(this.c.getReserve_code());
  }
  
  private void d(ButtonBean paramButtonBean)
  {
    if (this.c == null) {
      return;
    }
    if (TextUtils.isEmpty(paramButtonBean.getPromptText()))
    {
      j.subletInitiatorInvalidCancelReserve(this.b, com.ziroom.commonlibrary.login.a.getUid(this.b), this.c.getReserve_code(), this.g);
      return;
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.b).setContent(paramButtonBean.getPromptText()).setTitle(paramButtonBean.getPromptTitle()).setButtonText("再想想").setSecondButtonText("确认作废").setOnSecondClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        j.subletInitiatorInvalidCancelReserve(a.a(a.this), com.ziroom.commonlibrary.login.a.getUid(a.a(a.this)), a.b(a.this).getReserve_code(), a.w(a.this));
      }
    }).build().show();
  }
  
  private void e()
  {
    if ((this.c == null) || (this.c.getTurn() == null)) {
      return;
    }
    if ((this.c.getStatus() != 3) && (this.c.getStatus() != 4))
    {
      this.b.showBookCode(null, null, null, null);
      return;
    }
    SubletTurnDetailBean.TurnBean localTurnBean = this.c.getTurn();
    this.b.showBookCode(localTurnBean.getBook_code(), localTurnBean.getDays() + "天", localTurnBean.getRemaining_days() + "天", new a("refresh_book_code"));
  }
  
  private void e(ButtonBean paramButtonBean)
  {
    if (this.c == null) {
      return;
    }
    if (TextUtils.isEmpty(paramButtonBean.getPromptText()))
    {
      j.subletInitiatorConfirmTenantCancel(this.b, com.ziroom.commonlibrary.login.a.getUid(this.b), this.c.getReserve_code(), this.c.getReserve_status() + "", this.g);
      return;
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.b).setContent(paramButtonBean.getPromptText()).setTitle(paramButtonBean.getPromptTitle()).setButtonText("再想想").setSecondButtonText("确认取消").setOnSecondClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        j.subletInitiatorConfirmTenantCancel(a.a(a.this), com.ziroom.commonlibrary.login.a.getUid(a.a(a.this)), a.b(a.this).getReserve_code(), a.b(a.this).getReserve_status() + "", a.w(a.this));
      }
    }).build().show();
  }
  
  private void f()
  {
    if ((this.c == null) || (this.c.getTurn() == null)) {
      return;
    }
    this.b.showRentoutDay(this.c.getTurn().getDeparture_date());
  }
  
  private void f(final ButtonBean paramButtonBean)
  {
    if (this.c == null) {
      return;
    }
    j.checkExistReserveOrder(this.b, com.ziroom.commonlibrary.login.a.getUid(this.b), this.c.getTurn_id() + "", "2", new f(this.b, new com.ziroom.ziroomcustomer.findhouse.b.c())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ("success".equals(paramAnonymouse.get("status")))
        {
          if (paramAnonymouse.getJSONObject("data").getBoolean("isHas").booleanValue())
          {
            a.a(a.this, "取消转租", "您需要在取消预订后方可取消转租", "我知道了");
            return;
          }
          a.g(a.this, paramButtonBean);
          return;
        }
        af.showToast(a.a(a.this), paramAnonymouse.getString("error_message"));
      }
    });
  }
  
  private void g()
  {
    if ((this.c == null) || (this.c.getTurn() == null)) {}
    int i;
    do
    {
      return;
      if (this.c.getTurn().getSurplus_pay_time() < 1)
      {
        this.b.showPayTime(0, 0, 0);
        return;
      }
      i = this.c.getTurn().getSurplus_pay_time();
    } while (i < 0);
    int j = i / 3600;
    int k = i / 60;
    this.b.showPayTime(j, k, i % 60);
    this.f = new b(i * 1000, 1000L);
    this.f.start();
  }
  
  private void g(ButtonBean paramButtonBean)
  {
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.b).setTitle(paramButtonBean.getPromptTitle()).setContent(paramButtonBean.getPromptText()).setButtonText("再想想").setSecondButtonText("确认取消").setOnSecondClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        a.x(a.this);
      }
    }).build().show();
  }
  
  private void h()
  {
    if ((this.c == null) || (this.c.getTurn() == null)) {
      return;
    }
    if (TextUtils.isEmpty(this.c.getTurn().getRenter()))
    {
      this.b.showTenant("");
      return;
    }
    this.b.showTenant("租客姓名：" + this.c.getTurn().getRenter());
  }
  
  private void i()
  {
    if ((this.c == null) || (this.c.getTurn() == null) || (this.c.getTurn().getLinks() == null))
    {
      this.b.showTurnLinks("", null);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.c.getTurn().getLinks().size())
    {
      InfoItem localInfoItem = new InfoItem();
      SubletTurnDetailBean.LinksBean localLinksBean = (SubletTurnDetailBean.LinksBean)this.c.getTurn().getLinks().get(i);
      localInfoItem.title = localLinksBean.getText();
      localInfoItem.useH5Title = true;
      localInfoItem.value = " ";
      localInfoItem.url = localLinksBean.getUrl();
      localInfoItem.listener = new a("H5");
      localArrayList.add(localInfoItem);
      i += 1;
    }
    this.b.showTurnLinks("", localArrayList);
  }
  
  private void j()
  {
    if ((this.c == null) || (this.c.getProcess() == null) || (this.c.getProcess().size() < 1))
    {
      this.b.showProcess(null);
      return;
    }
    List localList = this.c.getProcess();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      Object localObject = (SubletTurnDetailBean.ProcessBean)localList.get(i);
      SubletProgressStepModel localSubletProgressStepModel = new SubletProgressStepModel();
      localSubletProgressStepModel.title = ((SubletTurnDetailBean.ProcessBean)localObject).getTitle();
      localSubletProgressStepModel.desc = ((SubletTurnDetailBean.ProcessBean)localObject).getContents();
      switch (((SubletTurnDetailBean.ProcessBean)localObject).getActive())
      {
      }
      for (;;)
      {
        if ((((SubletTurnDetailBean.ProcessBean)localObject).getButtons() != null) && (((SubletTurnDetailBean.ProcessBean)localObject).getButtons().size() > 0))
        {
          localObject = (SubletTurnDetailBean.ButtonBean)((SubletTurnDetailBean.ProcessBean)localObject).getButtons().get(0);
          localSubletProgressStepModel.buttonText = ((SubletTurnDetailBean.ButtonBean)localObject).getText();
          localSubletProgressStepModel.listener = new a(new ButtonBean((SubletTurnDetailBean.ButtonBean)localObject));
        }
        localArrayList.add(localSubletProgressStepModel);
        i += 1;
        break;
        localSubletProgressStepModel.status = 2;
        continue;
        localSubletProgressStepModel.status = 1;
        continue;
        localSubletProgressStepModel.status = 0;
      }
    }
    this.b.showProcess(new com.ziroom.ziroomcustomer.sublet.a.a(this.b, localArrayList));
  }
  
  private void k()
  {
    if ((this.c == null) || (this.c.getLinks() == null) || (this.c.getLinks().size() < 1))
    {
      this.b.showLinks("", null);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    InfoItem localInfoItem;
    if (ae.notNull(this.c.getReserve_contract_pdf()))
    {
      localInfoItem = new InfoItem();
      localInfoItem.title = "转租预订协议";
      localInfoItem.value = "查看详情";
      localInfoItem.isTitle444444 = true;
      localInfoItem.listener = new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(a.a(a.this), ReservationTermsActivity.class);
          paramAnonymousView.putExtra("reserveCode", a.b(a.this).getReserve_code());
          a.a(a.this).startActivity(paramAnonymousView);
        }
      };
      localArrayList.add(localInfoItem);
    }
    int i = 0;
    while (i < this.c.getLinks().size())
    {
      localInfoItem = new InfoItem();
      SubletTurnDetailBean.LinksBean localLinksBean = (SubletTurnDetailBean.LinksBean)this.c.getLinks().get(i);
      localInfoItem.title = localLinksBean.getText();
      localInfoItem.value = "查看详情";
      localInfoItem.isTitle444444 = true;
      localInfoItem.url = localLinksBean.getUrl();
      localInfoItem.listener = new a("H5");
      localArrayList.add(localInfoItem);
      i += 1;
    }
    this.b.showLinks("", localArrayList);
  }
  
  private void l()
  {
    if ((this.c == null) || (this.c.getButtons() == null) || (this.c.getButtons().size() < 1))
    {
      this.b.showBottomButtons(null);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.c.getButtons().size())
    {
      SubletTurnDetailBean.ButtonBean localButtonBean = (SubletTurnDetailBean.ButtonBean)this.c.getButtons().get(i);
      TextView localTextView = new TextView(this.b);
      localTextView.setText(localButtonBean.getText());
      localTextView.setOnClickListener(new a(new ButtonBean(localButtonBean)));
      localArrayList.add(localTextView);
      i += 1;
    }
    this.b.showBottomButtons(localArrayList);
  }
  
  private void m()
  {
    if (this.c.getBack_rent_view() == 0)
    {
      localIntent = new Intent(this.b, ConfirmTerminationActivity.class);
      localIntent.putExtra("contractCode", this.e);
      localIntent.putExtra("mode", "0");
      this.b.startActivity(localIntent);
    }
    do
    {
      return;
      if (1 == this.c.getBack_rent_view())
      {
        localIntent = new Intent(this.b, ConfirmTerminationActivity.class);
        localIntent.putExtra("contractCode", this.e);
        localIntent.putExtra("mode", "1");
        this.b.startActivity(localIntent);
        return;
      }
    } while (2 != this.c.getBack_rent_view());
    Intent localIntent = new Intent(this.b, PaymentInformationActivity.class);
    localIntent.putExtra("contractCode", this.e);
    this.b.startActivity(localIntent);
  }
  
  private void n()
  {
    if (this.c == null) {
      return;
    }
    Intent localIntent = new Intent(this.b, HouseBillInfoActivity.class);
    localIntent.putExtra("uniqueCode", this.c.getReserve_code());
    localIntent.putExtra("period", "");
    localIntent.putExtra("contract_code", this.c.getContract_code());
    localIntent.putExtra("mContentText", "倒计时结束之前，您可以在个人中心\"我的合同\"列表里进入转租详情进行支付。");
    localIntent.putExtra("payType", "QRYD");
    this.b.startActivityAndFinish(localIntent);
  }
  
  private void o()
  {
    if (this.c == null) {
      return;
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.b).setContent("您确认预定协议吗？").setButtonText("取消").setSecondButtonText("确定").setOnSecondClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new HouseDetail();
        Object localObject = new ArrayList();
        ((List)localObject).add(a.b(a.this).getPhoto());
        paramAnonymousView.setHouse_photos_small((List)localObject);
        paramAnonymousView.setHouse_name(a.b(a.this).getTitle());
        paramAnonymousView.setHouse_price(a.b(a.this).getPrice());
        paramAnonymousView.setHouse_price_desc(a.b(a.this).getPrice_unit());
        paramAnonymousView.setHouse_id(a.b(a.this).getHouse_id());
        paramAnonymousView.setHouse_code(a.b(a.this).getRoom_id());
        paramAnonymousView.setHouse_number("-1");
        paramAnonymousView.setFrom(1);
        localObject = new com.alibaba.fastjson.e();
        ((com.alibaba.fastjson.e)localObject).put("reserveCode", a.b(a.this).getReserve_code());
        ((com.alibaba.fastjson.e)localObject).put("confirmType", "QRYD");
        ((com.alibaba.fastjson.e)localObject).put("contract_code", a.b(a.this).getContract_code());
        paramAnonymousView.setSubletReserveCode(((com.alibaba.fastjson.e)localObject).toJSONString());
        new o(a.a(a.this)).toSign(paramAnonymousView, 3);
      }
    }).build().show();
  }
  
  private void p()
  {
    Intent localIntent = new Intent(this.b, InitiateTerminationActivity.class);
    localIntent.putExtra("contractCode", this.e);
    localIntent.putExtra("from", "1");
    this.b.startActivity(localIntent);
    ApplicationEx.c.finishAllActivity();
  }
  
  private void q()
  {
    if (this.c == null) {
      return;
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.b).setTitle("重新生成预订码").setContent("重新生成预订码后，原有预订码将会失效，确认重新生成么？").setButtonText("取消").setSecondButtonText("重新生成").setOnSecondClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        j.refreshSubletBookCode(a.a(a.this), com.ziroom.commonlibrary.login.a.getToken(a.a(a.this)), a.b(a.this).getTurn_id() + "", new f(a.a(a.this), new com.ziroom.ziroomcustomer.findhouse.b.c())
        {
          public void onFailure(Throwable paramAnonymous2Throwable)
          {
            super.onFailure(paramAnonymous2Throwable);
            if ((a.a(a.this) != null) && (!a.a(a.this).isFinishing())) {
              a.a(a.this).refreshView();
            }
          }
          
          public void onSuccess(int paramAnonymous2Int, com.alibaba.fastjson.e paramAnonymous2e)
          {
            super.onSuccess(paramAnonymous2Int, paramAnonymous2e);
            if ((a.a(a.this) != null) && (!a.a(a.this).isFinishing())) {
              a.a(a.this).refreshView();
            }
          }
        });
      }
    }).build().show();
  }
  
  private void r()
  {
    if ((this.c == null) || (this.b == null) || (this.b.isFinishing())) {
      return;
    }
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(this.b));
    localHashMap.put("turn_id", this.c.getTurn_id() + "");
    com.freelxl.baselibrary.d.a.post(com.ziroom.ziroomcustomer.e.q.Q + e.q.d).tag(this.b).params(com.ziroom.ziroomcustomer.e.g.getCommonHouseSign(localHashMap)).enqueue(new f(this.b, new com.ziroom.ziroomcustomer.findhouse.b.c())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ((a.a(a.this) != null) && (!a.a(a.this).isFinishing())) {
          a.a(a.this).finish();
        }
        if ("success".equals(paramAnonymouse.get("status")))
        {
          a.a(a.this).finish();
          return;
        }
        if (400011 == paramAnonymouse.getInteger("error_code").intValue())
        {
          a.a(a.this, "取消转租", "您需要先取消预订协议后，方可取消转租哦", "知道了");
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(a.a(a.this), paramAnonymouse.getString("error_message"));
      }
    });
  }
  
  private void s()
  {
    if (this.h == null)
    {
      t();
      return;
    }
    Intent localIntent = new Intent(this.b, SubletHouseShareActivity.class);
    localIntent.putExtra("houseDetail", this.h);
    this.b.startActivity(localIntent);
  }
  
  private void t()
  {
    j.getRentHouseDetail(this.b, this.c.getRoom_id(), this.c.getHouse_id(), new f(this.b, new com.ziroom.ziroomcustomer.e.c.q(RentHouseDetail.class))
    {
      public void onSuccess(int paramAnonymousInt, RentHouseDetail paramAnonymousRentHouseDetail)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousRentHouseDetail);
        a.a(a.this, paramAnonymousRentHouseDetail);
        paramAnonymousRentHouseDetail = new Intent(a.a(a.this), SubletHouseShareActivity.class);
        paramAnonymousRentHouseDetail.putExtra("houseDetail", a.y(a.this));
        a.a(a.this).startActivity(paramAnonymousRentHouseDetail);
      }
    });
  }
  
  public void dettachView()
  {
    if (this.f != null) {
      this.f.cancel();
    }
    this.b = null;
  }
  
  public void initData(String paramString)
  {
    if ((this.b == null) || (this.b.isFinishing()) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (this.f != null) {
      this.f.cancel();
    }
    this.e = paramString;
    j.getSubletInitiatorDetail(this.b, com.ziroom.commonlibrary.login.a.getToken(this.b), this.e, new com.ziroom.ziroomcustomer.findhouse.b.a(this.b, new com.ziroom.ziroomcustomer.findhouse.b.e(SubletTurnDetailBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        if ((a.a(a.this) == null) || (a.a(a.this).isFinishing())) {
          return;
        }
        a.a(a.this).showError();
      }
      
      public void onSuccess(int paramAnonymousInt, SubletTurnDetailBean paramAnonymousSubletTurnDetailBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousSubletTurnDetailBean);
        if ((a.a(a.this) == null) || (a.a(a.this).isFinishing())) {
          return;
        }
        if (paramAnonymousSubletTurnDetailBean == null)
        {
          a.a(a.this).showError();
          return;
        }
        a.a(a.this).closeError();
        a.a(a.this, paramAnonymousSubletTurnDetailBean);
        if (a.b(a.this).getVersion() != 2)
        {
          paramAnonymousSubletTurnDetailBean = new Intent(a.a(a.this), LeaseSubletInfoActivity.class);
          paramAnonymousSubletTurnDetailBean.putExtra("contract_code", a.c(a.this));
          paramAnonymousSubletTurnDetailBean.putExtra("version", a.b(a.this).getVersion());
          a.a(a.this).startActivity(paramAnonymousSubletTurnDetailBean);
          a.a(a.this).finish();
          return;
        }
        a.d(a.this);
        a.e(a.this);
        a.f(a.this);
        a.g(a.this);
        a.h(a.this);
        a.i(a.this);
        a.j(a.this);
        a.k(a.this);
        a.this.initTurnButtons();
        a.l(a.this);
        a.m(a.this);
        a.n(a.this);
        a.o(a.this);
      }
    });
  }
  
  public void initTurnButtons()
  {
    if ((this.c == null) || (this.c.getTurn() == null) || (this.c.getTurn().getButtons() == null))
    {
      this.b.showTurnButtons(null);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    List localList = this.c.getTurn().getButtons();
    int i = 0;
    while (i < localList.size())
    {
      SubletTurnDetailBean.ButtonBean localButtonBean = (SubletTurnDetailBean.ButtonBean)localList.get(i);
      TextView localTextView = new TextView(this.b);
      localTextView.setText(localButtonBean.getText());
      localTextView.setOnClickListener(new a(new ButtonBean(localButtonBean)));
      localArrayList.add(localTextView);
      i += 1;
    }
    this.b.showTurnButtons(localArrayList);
  }
  
  public void showBookcodeShare()
  {
    if ((this.c == null) || (this.c.getTurn() == null) || (this.c.getWechat_share() == null)) {
      return;
    }
    SubletBookcodeDialog localSubletBookcodeDialog = SubletBookcodeDialog.getInstance(this.c.getPhoto(), this.c.getTitle(), this.c.getTurn().getBook_code(), this.c.getWechat_share().getUrl());
    FragmentManager localFragmentManager = this.b.getSupportFragmentManager();
    if (!(localSubletBookcodeDialog instanceof DialogFragment))
    {
      localSubletBookcodeDialog.show(localFragmentManager, "bookcodeShare");
      return;
    }
    VdsAgent.showDialogFragment((DialogFragment)localSubletBookcodeDialog, localFragmentManager, "bookcodeShare");
  }
  
  public class a
    implements View.OnClickListener
  {
    private ButtonBean b;
    
    public a(ButtonBean paramButtonBean)
    {
      this.b = paramButtonBean;
    }
    
    public a(String paramString)
    {
      this.b = new ButtonBean();
      this.b.setType(paramString);
    }
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
      if ((a.a(a.this) == null) || (a.a(a.this).isFinishing()) || (this.b == null)) {
        return;
      }
      paramView = this.b.getType();
      int i = -1;
      switch (paramView.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return;
        case 0: 
          JsBridgeWebActivity.start(a.a(a.this), this.b.getText(), this.b.getValue());
          return;
          if (paramView.equals("H5"))
          {
            i = 0;
            continue;
            if (paramView.equals("phone"))
            {
              i = 1;
              continue;
              if (paramView.equals("cancel"))
              {
                i = 2;
                continue;
                if (paramView.equals("initiator_house_detail"))
                {
                  i = 3;
                  continue;
                  if (paramView.equals("refresh_book_code"))
                  {
                    i = 4;
                    continue;
                    if (paramView.equals("cancel_reserve"))
                    {
                      i = 5;
                      continue;
                      if (paramView.equals("refuse_reserve"))
                      {
                        i = 6;
                        continue;
                        if (paramView.equals("confirm_cancel"))
                        {
                          i = 7;
                          continue;
                          if (paramView.equals("invalid_apply"))
                          {
                            i = 8;
                            continue;
                            if (paramView.equals("quit"))
                            {
                              i = 9;
                              continue;
                              if (paramView.equals("share"))
                              {
                                i = 10;
                                continue;
                                if (paramView.equals("confirm_reserve"))
                                {
                                  i = 11;
                                  continue;
                                  if (paramView.equals("sublet_pay"))
                                  {
                                    i = 12;
                                    continue;
                                    if (paramView.equals("check_agreement"))
                                    {
                                      i = 13;
                                      continue;
                                      if (paramView.equals("app_zone"))
                                      {
                                        i = 14;
                                        continue;
                                        if (paramView.equals("reserved"))
                                        {
                                          i = 15;
                                          continue;
                                          if (paramView.equals("unreserved")) {
                                            i = 16;
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      ah.callPhone(a.a(a.this), this.b.getValue());
      return;
      a.a(a.this, this.b);
      return;
      if (ae.isNull(a.b(a.this).getReserve_code()))
      {
        paramView = new Intent(a.a(a.this), LeaseSubletInfomationActivity.class);
        paramView.putExtra("lease", a.c(a.this));
        paramView.putExtra("version", a.b(a.this).getVersion());
        paramView.putExtra("isNewSublet", false);
        a.a(a.this).startActivity(paramView);
        return;
      }
      paramView = new Intent(a.a(a.this), LeaseSubletInfomationActivity.class);
      paramView.putExtra("lease", a.c(a.this));
      paramView.putExtra("version", a.b(a.this).getVersion());
      paramView.putExtra("isNewSublet", false);
      paramView.putExtra("isShow", true);
      a.a(a.this).startActivity(paramView);
      return;
      a.q(a.this);
      return;
      a.a(a.this, this.b, "再想想", "确认取消");
      return;
      a.a(a.this, this.b, "再想想", "确认拒绝");
      return;
      a.b(a.this, this.b);
      return;
      a.c(a.this, this.b);
      return;
      a.d(a.this, this.b);
      return;
      a.r(a.this);
      return;
      a.s(a.this);
      return;
      a.t(a.this);
      return;
      a.u(a.this);
      return;
      paramView = new Intent(a.a(a.this), AccountMainActivity.class);
      a.a(a.this).startActivity(paramView);
      return;
      a.e(a.this, this.b);
      return;
      a.f(a.this, this.b);
    }
  }
  
  class b
    extends CountDownTimer
  {
    public b(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      if ((a.a(a.this) != null) && (!a.a(a.this).isFinishing())) {
        a.a(a.this).refreshView();
      }
    }
    
    public void onTick(long paramLong)
    {
      if ((a.a(a.this) != null) && (!a.a(a.this).isFinishing()))
      {
        int i = (int)(paramLong / 1000L);
        if (i >= 0)
        {
          int j = i / 3600;
          int k = i / 60;
          a.a(a.this).showPayTime(j, k, i % 60);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */