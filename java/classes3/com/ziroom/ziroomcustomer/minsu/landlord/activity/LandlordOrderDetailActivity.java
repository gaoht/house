package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.f;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuWebActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.landlord.model.BaseItem;
import com.ziroom.ziroomcustomer.minsu.landlord.model.ContactBean;
import com.ziroom.ziroomcustomer.minsu.landlord.model.DepositMoneyBean;
import com.ziroom.ziroomcustomer.minsu.landlord.model.MoneyItem;
import com.ziroom.ziroomcustomer.minsu.landlord.model.OrderDetailBean;
import com.ziroom.ziroomcustomer.minsu.landlord.model.OrderIncome;
import com.ziroom.ziroomcustomer.minsu.landlord.model.OtherMoneyBean;
import com.ziroom.ziroomcustomer.minsu.landlord.model.OtherMoneyBean.DetailBean;
import com.ziroom.ziroomcustomer.minsu.landlord.model.RemarkBean;
import com.ziroom.ziroomcustomer.minsu.landlord.model.RemarkItem;
import com.ziroom.ziroomcustomer.minsu.landlord.model.RuleItem;
import com.ziroom.ziroomcustomer.minsu.landlord.model.TimeItem;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.CommonSaveDescInfoActivity;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.MySwipeMenuListView;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.SwipeMenuListView.a;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.d;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.e;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.List;

public class LandlordOrderDetailActivity
  extends BaseFluxActivity
{
  private com.freelxl.baselibrary.a.a<RemarkItem> b;
  @BindView(2131691493)
  ImageView btnLeftImg;
  private RemarkItem c;
  private com.ziroom.ziroomcustomer.minsu.landlord.c.a d;
  private com.ziroom.ziroomcustomer.minsu.landlord.a.a e;
  private String f;
  private String g;
  @BindView(2131691530)
  ImageView imgOtherMoney;
  @BindView(2131691541)
  MySwipeMenuListView listRemark;
  @BindView(2131691523)
  LinearLayout llPenalty;
  @BindView(2131691507)
  LinearLayout llPeopleMessage;
  @BindView(2131691538)
  LinearLayout llRemark;
  @BindView(2131691519)
  View ll_security_deposit_container;
  private String r;
  @BindView(2131691543)
  RadioButton rbMakeSure;
  @BindView(2131691542)
  RadioButton rbRefuse;
  @BindView(2131691527)
  RelativeLayout rlOtherMoney;
  @BindView(2131691500)
  RelativeLayout rlUser;
  private int s = 0;
  @BindView(2131691499)
  SimpleDraweeView sdvUserTitleIcon;
  @BindView(2131690150)
  ObservableScrollView svContent;
  private int t = 0;
  @BindView(2131691540)
  TextView tvAddRemark;
  @BindView(2131690053)
  TextView tvAddress;
  @BindView(2131691510)
  TextView tvComingLabel;
  @BindView(2131691511)
  TextView tvComingTime;
  @BindView(2131691502)
  TextView tvEvaluation;
  @BindView(2131691504)
  TextView tvEvaluationCount;
  @BindView(2131691516)
  TextView tvIncomeDes;
  @BindView(2131691517)
  TextView tvIncomeDetail;
  @BindView(2131691514)
  TextView tvIncomeLabel;
  @BindView(2131691515)
  TextView tvIncomeMoney;
  @BindView(2131691512)
  TextView tvLeaveLabel;
  @BindView(2131691513)
  TextView tvLeaveTime;
  @BindView(2131690049)
  TextView tvName;
  @BindView(2131691536)
  TextView tvObjectDetail;
  @BindView(2131691535)
  TextView tvObjectLabel;
  @BindView(2131691497)
  TextView tvOrderCode;
  @BindView(2131691529)
  TextView tvOtherMoneyDes;
  @BindView(2131691528)
  TextView tvOtherMoneyLabel;
  @BindView(2131691524)
  TextView tvPenaltyLabel;
  @BindView(2131691525)
  TextView tvPenaltyMoney;
  @BindView(2131691509)
  TextView tvPeopleCount;
  @BindView(2131691508)
  TextView tvPeopleLabel;
  @BindView(2131691539)
  TextView tvRemarkLabel;
  @BindView(2131691498)
  TextView tvRoomReserveTime;
  @BindView(2131691496)
  TextView tvRoomStatus;
  @BindView(2131689771)
  TextView tvTitleName;
  @BindView(2131691533)
  TextView tvUnsubscribe;
  @BindView(2131691532)
  TextView tvUnsubscribeLabel;
  @BindView(2131691520)
  TextView tv_security_deposit_label;
  @BindView(2131691521)
  TextView tv_security_deposit_money;
  @BindView(2131691503)
  View vEvaluation;
  @BindView(2131691518)
  View vIncome;
  @BindView(2131691494)
  View vLineBottom;
  @BindView(2131691505)
  SimpleDraweeView vMessage;
  @BindView(2131691537)
  View vObject;
  @BindView(2131691531)
  View vOtherMoney;
  @BindView(2131691526)
  View vPenalty;
  @BindView(2131691506)
  SimpleDraweeView vPhone;
  @BindView(2131691534)
  View vUnsubscribe;
  @BindView(2131691522)
  View v_security_deposit;
  
  private void a()
  {
    this.vMessage.setImageResource(2130840189);
    this.vPhone.setImageResource(2130840190);
    this.tvIncomeDetail.setText("查看明细");
    OrderDetailBean localOrderDetailBean = this.d.getmOrderDetailBean();
    this.tvTitleName.setText(localOrderDetailBean.getOrderTitle());
    this.tvRoomStatus.setText(localOrderDetailBean.getOrderStatusName());
    this.tvAddress.setText(localOrderDetailBean.getHouseName());
    this.tvOrderCode.setText("订单编号：" + localOrderDetailBean.getOrderSn());
    this.tvRoomReserveTime.setText("预订时间：" + localOrderDetailBean.getCreateTime());
    this.sdvUserTitleIcon.setImageURI(localOrderDetailBean.getUserHeadPic());
    this.tvName.setText(localOrderDetailBean.getUserName());
    Object localObject1;
    label423:
    Object localObject2;
    if (localOrderDetailBean.getUserEvaTotal() != 0)
    {
      this.tvEvaluationCount.setText(localOrderDetailBean.getUserEvaTotal() + "评价");
      localObject1 = (localOrderDetailBean.getEvaAva() + " 分").replaceAll(".0", "");
      this.tvEvaluation.setText((CharSequence)localObject1);
      this.vEvaluation.setVisibility(0);
      if (f.isNull(localOrderDetailBean.getUserTel())) {
        this.vPhone.setVisibility(8);
      }
      this.tvPeopleLabel.setText(localOrderDetailBean.getContacts().getName());
      this.tvPeopleCount.setText(localOrderDetailBean.getContacts().getValue());
      this.tvComingLabel.setText(localOrderDetailBean.getStartTime().getName());
      this.tvComingTime.setText(localOrderDetailBean.getStartTime().getDate() + "  " + localOrderDetailBean.getStartTime().getWeek());
      this.tvLeaveLabel.setText(localOrderDetailBean.getEndTime().getName());
      this.tvLeaveTime.setText(localOrderDetailBean.getEndTime().getDate() + "  " + localOrderDetailBean.getEndTime().getWeek());
      this.tvIncomeLabel.setText(localOrderDetailBean.getOrderIncome().getName());
      if (localOrderDetailBean.getOrderIncome().getSymbol() != null) {
        break label848;
      }
      localObject1 = "";
      if (localOrderDetailBean.getOrderIncome().getFeeUnit() != null) {
        break label859;
      }
      localObject2 = "";
      label437:
      this.tvIncomeMoney.setText((String)localObject1 + (String)localObject2 + localOrderDetailBean.getOrderIncome().getValue());
      this.tvIncomeDes.setText(localOrderDetailBean.getOrderIncome().getDesc());
      if (localOrderDetailBean.getOrderPenalty() != null) {
        break label870;
      }
      this.llPenalty.setVisibility(8);
      this.vPenalty.setVisibility(8);
      if (localOrderDetailBean.getOtherMoney() != null) {
        break label985;
      }
      this.rlOtherMoney.setVisibility(8);
      this.vOtherMoney.setVisibility(8);
      label536:
      if (localOrderDetailBean.getCheckOutRule() != null) {
        break label1145;
      }
      this.tvUnsubscribeLabel.setVisibility(8);
      this.tvUnsubscribe.setVisibility(8);
      this.vUnsubscribe.setVisibility(8);
      label570:
      if ((localOrderDetailBean.getTripPurpose() != null) && (!f.isNull(localOrderDetailBean.getTripPurpose().getValue()))) {
        break label1200;
      }
      this.tvObjectLabel.setVisibility(8);
      this.tvObjectDetail.setVisibility(8);
      this.vObject.setVisibility(8);
      label617:
      this.tvRemarkLabel.setText(localOrderDetailBean.getRemarks().getName());
      if (localOrderDetailBean.getRemarks().getRemarkList().size() >= 5) {
        break label1255;
      }
      this.tvAddRemark.setVisibility(0);
      label655:
      if (localOrderDetailBean.getButtonNames().length != 1) {
        break label1267;
      }
      this.rbRefuse.setVisibility(8);
      this.rbMakeSure.setVisibility(0);
      this.rbMakeSure.setText(localOrderDetailBean.getButtonNames()[0]);
      label694:
      if ((localOrderDetailBean.getDepositMoney() == null) || (TextUtils.isEmpty(localOrderDetailBean.getDepositMoney().getValue())) || ("0".equals(localOrderDetailBean.getDepositMoney().getValue()))) {
        break label1386;
      }
      this.ll_security_deposit_container.setVisibility(0);
      this.v_security_deposit.setVisibility(0);
      this.tv_security_deposit_label.setText(localOrderDetailBean.getDepositMoney().getName());
      localObject2 = this.tv_security_deposit_money;
      if (!TextUtils.isEmpty(localOrderDetailBean.getDepositMoney().getSymbol())) {
        break label1342;
      }
      localObject1 = localOrderDetailBean.getDepositMoney().getFeeUnit() + localOrderDetailBean.getDepositMoney().getValue();
      label809:
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    for (;;)
    {
      a(localOrderDetailBean.getRemarks().getRemarkList());
      this.svContent.smoothScrollTo(0, 0);
      return;
      this.tvEvaluation.setText("没有评价");
      break;
      label848:
      localObject1 = localOrderDetailBean.getOrderIncome().getSymbol();
      break label423;
      label859:
      localObject2 = localOrderDetailBean.getOrderIncome().getFeeUnit();
      break label437;
      label870:
      this.llPenalty.setVisibility(0);
      this.vPenalty.setVisibility(0);
      this.tvPenaltyLabel.setText(localOrderDetailBean.getOrderPenalty().getName());
      if (localOrderDetailBean.getOrderPenalty() == null)
      {
        localObject1 = "";
        label911:
        if (localOrderDetailBean.getOrderPenalty().getFeeUnit() != null) {
          break label974;
        }
      }
      label974:
      for (localObject2 = "";; localObject2 = localOrderDetailBean.getOrderPenalty().getFeeUnit())
      {
        this.tvPenaltyMoney.setText((String)localObject1 + (String)localObject2 + localOrderDetailBean.getOrderPenalty().getValue());
        break;
        localObject1 = localOrderDetailBean.getOrderPenalty().getSymbol();
        break label911;
      }
      label985:
      this.rlOtherMoney.setVisibility(0);
      this.vOtherMoney.setVisibility(0);
      this.tvOtherMoneyLabel.setText(localOrderDetailBean.getOtherMoney().getName());
      localObject2 = localOrderDetailBean.getOtherMoney().getDesc();
      localObject1 = localObject2;
      StringBuilder localStringBuilder;
      if (f.isNull((String)localObject2))
      {
        localObject2 = localOrderDetailBean.getOtherMoney().getDetail().getMoney();
        localStringBuilder = new StringBuilder();
        if (((MoneyItem)localObject2).getSymbol() != null) {
          break label1117;
        }
      }
      label1117:
      for (localObject1 = "";; localObject1 = ((MoneyItem)localObject2).getSymbol())
      {
        localObject1 = (String)localObject1 + ((MoneyItem)localObject2).getFeeUnit() + ((MoneyItem)localObject2).getValue();
        this.tvOtherMoneyDes.setText((CharSequence)localObject1);
        if (localOrderDetailBean.getOtherMoney().getIsShow() != 1) {
          break label1125;
        }
        this.imgOtherMoney.setVisibility(0);
        break;
      }
      label1125:
      this.rlOtherMoney.setOnClickListener(null);
      this.imgOtherMoney.setVisibility(8);
      break label536;
      label1145:
      this.tvUnsubscribeLabel.setText(localOrderDetailBean.getCheckOutRule().getName());
      this.tvUnsubscribe.setText(localOrderDetailBean.getCheckOutRule().getDesc());
      this.tvUnsubscribeLabel.setVisibility(0);
      this.tvUnsubscribe.setVisibility(0);
      this.vUnsubscribe.setVisibility(0);
      break label570;
      label1200:
      this.tvObjectLabel.setText(localOrderDetailBean.getTripPurpose().getName());
      this.tvObjectDetail.setText(localOrderDetailBean.getTripPurpose().getValue());
      this.tvObjectLabel.setVisibility(0);
      this.tvObjectDetail.setVisibility(0);
      this.vObject.setVisibility(0);
      break label617;
      label1255:
      this.tvAddRemark.setVisibility(8);
      break label655;
      label1267:
      if (localOrderDetailBean.getButtonNames().length == 2)
      {
        this.rbRefuse.setText(localOrderDetailBean.getButtonNames()[0]);
        this.rbMakeSure.setText(localOrderDetailBean.getButtonNames()[1]);
        this.rbRefuse.setVisibility(0);
        this.rbMakeSure.setVisibility(0);
        break label694;
      }
      this.rbRefuse.setVisibility(8);
      this.rbMakeSure.setVisibility(8);
      break label694;
      label1342:
      localObject1 = localOrderDetailBean.getDepositMoney().getSymbol() + localOrderDetailBean.getDepositMoney().getFeeUnit() + localOrderDetailBean.getDepositMoney().getValue();
      break label809;
      label1386:
      this.ll_security_deposit_container.setVisibility(8);
      this.v_security_deposit.setVisibility(8);
    }
  }
  
  private void a(Intent paramIntent)
  {
    if ("android.intent.action.VIEW".equals(paramIntent.getAction()))
    {
      paramIntent = paramIntent.getData();
      if (paramIntent != null) {
        this.f = paramIntent.getQueryParameter("orderSn");
      }
    }
  }
  
  private void a(List<RemarkItem> paramList)
  {
    d local2 = new d()
    {
      public void create(com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.b paramAnonymousb)
      {
        e locale = new e(LandlordOrderDetailActivity.this.getApplicationContext());
        locale.setBackground(new ColorDrawable(Color.parseColor("#FF6262")));
        locale.setWidth(n.dip2px(LandlordOrderDetailActivity.this, 80.0F));
        locale.setTitle("删除");
        locale.setTitleColor(Color.parseColor("#FFFFFF"));
        locale.setTitleSize(14);
        paramAnonymousb.addMenuItem(locale);
      }
    };
    this.listRemark.setMenuCreator(local2);
    this.listRemark.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        LandlordOrderDetailActivity.this.listRemark.smoothOpenMenu(paramAnonymousInt);
        return false;
      }
    });
    this.listRemark.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        LandlordOrderDetailActivity.this.listRemark.smoothOpenMenu(paramAnonymousInt);
      }
    });
    this.listRemark.setOnMenuItemClickListener(new SwipeMenuListView.a()
    {
      public boolean onMenuItemClick(int paramAnonymousInt1, com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.b paramAnonymousb, int paramAnonymousInt2)
      {
        switch (paramAnonymousInt2)
        {
        }
        for (;;)
        {
          return false;
          LandlordOrderDetailActivity.a(LandlordOrderDetailActivity.this, (RemarkItem)LandlordOrderDetailActivity.a(LandlordOrderDetailActivity.this).getItem(paramAnonymousInt1));
          LandlordOrderDetailActivity.d(LandlordOrderDetailActivity.this).delOrderRemark(LandlordOrderDetailActivity.this, LandlordOrderDetailActivity.this, LandlordOrderDetailActivity.b(LandlordOrderDetailActivity.this), LandlordOrderDetailActivity.c(LandlordOrderDetailActivity.this).getFid());
        }
      }
    });
    this.b = new com.freelxl.baselibrary.a.a(this, paramList, 2130904323)
    {
      public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, RemarkItem paramAnonymousRemarkItem)
      {
        paramAnonymousb.setText(2131689857, paramAnonymousRemarkItem.getContent());
      }
    };
    this.listRemark.setAdapter(this.b);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt2)
    {
    }
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("saveDesc");
      this.e.saveOrderRemark(this, this, this.f, paramIntent);
      return;
      String str = paramIntent.getStringExtra("feeUnit");
      this.g = paramIntent.getStringExtra("money");
      this.r = paramIntent.getStringExtra("money_detail");
      this.s = paramIntent.getIntExtra("money_value", 0);
      this.tvOtherMoneyDes.setText(str + this.g);
      return;
      this.e.getLandlordOrderDetail(this, this, this.f);
    } while (MinsuLandLordMainNewActivity.a == null);
    MinsuLandLordMainNewActivity.a.UpLoadData();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.t == 1) {
      setResult(-1);
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903299);
    ButterKnife.bind(this);
    paramBundle = getIntent();
    this.f = paramBundle.getStringExtra("orderSn");
    a(paramBundle);
    this.d = new com.ziroom.ziroomcustomer.minsu.landlord.c.a(this);
    this.a.register(this.d);
    this.e = new com.ziroom.ziroomcustomer.minsu.landlord.a.a(this.a);
    this.e.getLandlordOrderDetail(this, this, this.f);
    this.vLineBottom.setAlpha(0.0F);
    this.svContent.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LandlordOrderDetailActivity.this.vLineBottom.setAlpha(f);
      }
    });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.unregister(this.d);
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i = -1;
    switch (parama.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      do
      {
        return;
        if (!parama.equals("order_dtail")) {
          break;
        }
        i = 0;
        break;
        if (!parama.equals("save_order_remark")) {
          break;
        }
        i = 1;
        break;
        if (!parama.equals("accept_order")) {
          break;
        }
        i = 2;
        break;
        if (!parama.equals("confirm_other_money")) {
          break;
        }
        i = 3;
        break;
        if (!parama.equals("del_order_remark")) {
          break;
        }
        i = 4;
        break;
        if (!parama.equals("refuse_Reason")) {
          break;
        }
        i = 5;
        break;
        a();
        return;
        this.b.getDatas().add(this.d.getmRemarkItem());
        this.b.notifyDataSetChanged();
        if (this.b.getDatas().size() < 5)
        {
          this.tvAddRemark.setVisibility(0);
          return;
        }
        this.tvAddRemark.setVisibility(8);
        return;
        this.t = 1;
        this.e.getLandlordOrderDetail(this, this, this.f);
      } while (MinsuLandLordMainNewActivity.a == null);
      MinsuLandLordMainNewActivity.a.UpLoadData();
      return;
      this.t = 1;
      this.e.getLandlordOrderDetail(this, this, this.f);
    } while (MinsuLandLordMainNewActivity.a == null);
    MinsuLandLordMainNewActivity.a.UpLoadData();
    return;
    this.b.getDatas().remove(this.c);
    this.b.notifyDataSetChanged();
    if (this.b.getDatas().size() < 5)
    {
      this.tvAddRemark.setVisibility(0);
      return;
    }
    this.tvAddRemark.setVisibility(8);
    return;
    parama = new Intent(this, LandlordRefuseReasonActivity.class);
    parama.putExtra("data", this.d.getmRefuseReasonStr());
    parama.putExtra("orderSn", this.f);
    startActivityForResult(parama, 18);
  }
  
  @OnClick({2131691493, 2131691499, 2131690049, 2131691506, 2131691505, 2131691507, 2131691517, 2131691540, 2131691533, 2131691542, 2131691543, 2131691527})
  public void onViewClicked(View paramView)
  {
    Intent localIntent = new Intent();
    switch (paramView.getId())
    {
    }
    label593:
    do
    {
      return;
      if (this.t == 1) {
        setResult(-1);
      }
      finish();
      return;
      localIntent.setClass(this, LandlordOtherConsumerActivity.class);
      localIntent.putExtra("data", com.alibaba.fastjson.a.toJSONString(this.d.getmOrderDetailBean().getOtherMoney()));
      localIntent.putExtra("money", this.s);
      localIntent.putExtra("moneyStr", this.g);
      localIntent.putExtra("money_detail", this.r);
      startActivityForResult(localIntent, 16);
      return;
      localIntent.setClass(this, MinsuWebActivity.class);
      localIntent.putExtra("isLoadTitle", false);
      localIntent.putExtra("url", this.d.getmOrderDetailBean().getUserInfoUrl());
      startActivity(localIntent);
      return;
      localIntent.setAction("android.intent.action.CALL");
      localIntent.setData(Uri.parse("tel:" + this.d.getmOrderDetailBean().getUserTel()));
      startActivity(localIntent);
      return;
      if (f.isNull(this.d.getmOrderDetailBean().getRoomFid())) {}
      for (paramView = this.d.getmOrderDetailBean().getHouseFid();; paramView = this.d.getmOrderDetailBean().getRoomFid())
      {
        k.toImPage(this, this.d.getmOrderDetailBean().getUserUid(), paramView, this.d.getmOrderDetailBean().getRentWay(), 1, "MinsuOrderSigned");
        return;
      }
      localIntent.setClass(this, LandlordCustomerActivity.class);
      localIntent.putExtra("CustomerData", com.alibaba.fastjson.a.toJSONString(this.d.getmOrderDetailBean().getContacts().getSubList()));
      localIntent.putExtra("title", this.d.getmOrderDetailBean().getContacts().getSubTitle());
      startActivity(localIntent);
      return;
      localIntent.setClass(this, LandlordConsumeDetailActivity.class);
      localIntent.putExtra("data", com.alibaba.fastjson.a.toJSONString(this.d.getmOrderDetailBean().getMoneyItems()));
      localIntent.putExtra("name", this.d.getmOrderDetailBean().getOrderIncome().getName());
      if (this.d.getmOrderDetailBean().getOrderIncome().getSymbol() == null)
      {
        paramView = "";
        if (this.d.getmOrderDetailBean().getOrderIncome().getFeeUnit() != null) {
          break label593;
        }
      }
      for (String str = "";; str = this.d.getmOrderDetailBean().getOrderIncome().getFeeUnit())
      {
        localIntent.putExtra("value", paramView + str + this.d.getmOrderDetailBean().getOrderIncome().getValue());
        startActivity(localIntent);
        return;
        paramView = this.d.getmOrderDetailBean().getOrderIncome().getSymbol();
        break;
      }
      localIntent.setClass(this, CommonSaveDescInfoActivity.class);
      localIntent.putExtra("titleName", "添加备注");
      localIntent.putExtra("editTextHint", this.d.getmOrderDetailBean().getRemarks().getDesc());
      localIntent.putExtra("saveDescText", "");
      localIntent.putExtra("editMaxNum", 50);
      localIntent.putExtra("editMinNum", 1);
      localIntent.putExtra("nullable", false);
      startActivityForResult(localIntent, 17);
      return;
      k.toMinsuInfoActivity(this, Integer.parseInt(this.d.getmOrderDetailBean().getCheckOutRule().getValue()), this.d.getmOrderDetailBean().getRentWay(), this.d.getmOrderDetailBean().getHouseFid());
      return;
      this.e.getLandlordRefuseReason(null, this, this.d.getmOrderDetailBean().getHouseFid(), this.d.getmOrderDetailBean().getRoomFid(), this.d.getmOrderDetailBean().getRentWay() + "");
      return;
      if (10 == this.d.getmOrderDetailBean().getOrderStatus())
      {
        c.newBuilder(this).setTitle("提示").setBtnConfirmText("确定").setContent(this.d.getmOrderDetailBean().getAcceptConfirmMsg()).setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean) {
              LandlordOrderDetailActivity.d(LandlordOrderDetailActivity.this).setLandlordAcceptOrder(LandlordOrderDetailActivity.this, LandlordOrderDetailActivity.this, LandlordOrderDetailActivity.b(LandlordOrderDetailActivity.this));
            }
          }
        }).build().show();
        return;
      }
    } while ((50 != this.d.getmOrderDetailBean().getOrderStatus()) && (51 != this.d.getmOrderDetailBean().getOrderStatus()));
    if (this.s != 0) {}
    for (paramView = this.d.getmOrderDetailBean().getOtherHasMoneyConfirmMsg().replaceAll("Money", ah.Number(this.s * 1.0D / 100.0D));; paramView = this.d.getmOrderDetailBean().getOtherNoMoneyConfirmMsg())
    {
      c.newBuilder(this).setTitle("提示").setBtnConfirmText("确定").setContent(paramView).setOnConfirmClickListener(new c.b()
      {
        public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {
            LandlordOrderDetailActivity.d(LandlordOrderDetailActivity.this).setConfirmOtherMoney(LandlordOrderDetailActivity.this, LandlordOrderDetailActivity.this, LandlordOrderDetailActivity.b(LandlordOrderDetailActivity.this), LandlordOrderDetailActivity.e(LandlordOrderDetailActivity.this) + "", LandlordOrderDetailActivity.f(LandlordOrderDetailActivity.this));
          }
        }
      }).build().show();
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/LandlordOrderDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */