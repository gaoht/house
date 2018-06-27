package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.newclean.d.al;
import com.ziroom.ziroomcustomer.newclean.d.ap;
import com.ziroom.ziroomcustomer.newclean.d.ap.a;
import com.ziroom.ziroomcustomer.newclean.d.d;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;

public class BedroomCleaningActivity
  extends BaseFluxActivity
{
  private String A;
  private boolean B = false;
  private String C;
  private String D;
  private String E;
  private String F;
  private d G;
  private String H;
  private double I = 0.0D;
  private String J;
  private BroadcastReceiver K = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("clean_time_info"))
      {
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("isCleanerEmptey");
        if ((TextUtils.isEmpty(paramAnonymousContext)) || (!"yes".equals(paramAnonymousContext))) {
          break label58;
        }
        BedroomCleaningActivity.a(BedroomCleaningActivity.this, "");
        BedroomCleaningActivity.this.mletCleaner.setText("");
      }
      label58:
      String str1;
      String str2;
      for (;;)
      {
        return;
        BedroomCleaningActivity.b(BedroomCleaningActivity.this, paramAnonymousIntent.getStringExtra("appointDate"));
        BedroomCleaningActivity.c(BedroomCleaningActivity.this, paramAnonymousIntent.getStringExtra("appointTime"));
        BedroomCleaningActivity.d(BedroomCleaningActivity.this, paramAnonymousIntent.getStringExtra("appointDateTime"));
        BedroomCleaningActivity.a(BedroomCleaningActivity.this, "");
        BedroomCleaningActivity.c(BedroomCleaningActivity.this).setAppointDate(BedroomCleaningActivity.b(BedroomCleaningActivity.this));
        BedroomCleaningActivity.c(BedroomCleaningActivity.this).setAppointTime(BedroomCleaningActivity.d(BedroomCleaningActivity.this));
        BedroomCleaningActivity.c(BedroomCleaningActivity.this).setAppointDateTime(BedroomCleaningActivity.e(BedroomCleaningActivity.this));
        BedroomCleaningActivity.c(BedroomCleaningActivity.this).setAppointShowTime(BedroomCleaningActivity.b(BedroomCleaningActivity.this) + " " + BedroomCleaningActivity.d(BedroomCleaningActivity.this));
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("isCleanerSchedule");
        if ((!TextUtils.isEmpty(paramAnonymousContext)) && ("yes".equals(paramAnonymousContext)))
        {
          if (!TextUtils.isEmpty(BedroomCleaningActivity.f(BedroomCleaningActivity.this))) {
            break label386;
          }
          BedroomCleaningActivity.this.mLetTime.setText(BedroomCleaningActivity.b(BedroomCleaningActivity.this) + " " + BedroomCleaningActivity.d(BedroomCleaningActivity.this));
        }
        while (!TextUtils.isEmpty(paramAnonymousIntent.getStringExtra("cleanage")))
        {
          paramAnonymousContext = paramAnonymousIntent.getStringExtra("cleanplace");
          str1 = paramAnonymousIntent.getStringExtra("cleanage");
          str2 = paramAnonymousIntent.getStringExtra("cleanname");
          BedroomCleaningActivity.a(BedroomCleaningActivity.this, paramAnonymousIntent.getStringExtra("employeeLogicCode"));
          if (TextUtils.isEmpty(paramAnonymousContext)) {
            break label441;
          }
          BedroomCleaningActivity.this.mletCleaner.setText(str2 + "  " + str1 + "岁  " + paramAnonymousContext);
          return;
          label386:
          BedroomCleaningActivity.this.mLetTime.setText(BedroomCleaningActivity.b(BedroomCleaningActivity.this) + " " + BedroomCleaningActivity.d(BedroomCleaningActivity.this), BedroomCleaningActivity.f(BedroomCleaningActivity.this));
        }
      }
      label441:
      BedroomCleaningActivity.this.mletCleaner.setText(str2 + "  " + str1 + "岁");
    }
  };
  Unbinder b;
  private BedroomCleaningActivity c;
  private com.ziroom.ziroomcustomer.newclean.e.a d;
  private com.ziroom.ziroomcustomer.newclean.a.a e;
  private Intent f;
  private int g = 111;
  @BindView(2131689843)
  Button mBtnCommit;
  @BindView(2131690373)
  LabeledEditText mLetAddress;
  @BindView(2131690390)
  LabeledEditText mLetCoupon;
  @BindView(2131690391)
  LabeledEditText mLetSpecial;
  @BindView(2131690388)
  LabeledEditText mLetTime;
  @BindView(2131690389)
  LinearLayout mLlSelectCleaner;
  @BindView(2131689841)
  TextView mTvAllPrice;
  @BindView(2131689541)
  TextView mTvTitle;
  @BindView(2131690363)
  LabeledEditText mletCleaner;
  private int r = 222;
  private int s = 333;
  private int t = 444;
  private String u;
  private String v;
  private String w;
  private String x;
  private String y;
  private String z;
  
  private void a()
  {
    this.d = new com.ziroom.ziroomcustomer.newclean.e.a(this);
    this.a.register(this.d);
    this.e = com.ziroom.ziroomcustomer.newclean.a.a.getInstance(this.a);
  }
  
  private void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("clean_time_info");
    registerReceiver(this.K, localIntentFilter);
    this.u = getIntent().getStringExtra("ServiceInfoId");
    this.v = getIntent().getStringExtra("ServiceInfoName");
    this.mTvTitle.setText(this.v);
    this.e.getCleanAddressInfo(this);
  }
  
  private void e()
  {
    double d4 = 0.0D;
    int i;
    int j;
    label35:
    int k;
    label51:
    double d2;
    double d1;
    label72:
    double d3;
    if (!TextUtils.isEmpty(this.d.getAddressId()))
    {
      i = 1;
      if (TextUtils.isEmpty(this.mLetTime.getText())) {
        break label164;
      }
      j = 1;
      if (TextUtils.isEmpty(this.mLetCoupon.getText())) {
        break label170;
      }
      k = 1;
      if (j == 0) {
        break label176;
      }
      d2 = this.G.getServicePrice().doubleValue();
      d1 = this.I;
      if (k == 0) {
        break label207;
      }
      d3 = this.d.getPromoPrice();
      label87:
      d1 = d1 + d2 - d3;
      if (d1 > 0.0D) {
        break label231;
      }
      d1 = d4;
    }
    label164:
    label170:
    label176:
    label207:
    label231:
    for (;;)
    {
      this.mTvAllPrice.setText((int)d1 + "");
      if ((i != 0) && (j != 0))
      {
        this.mBtnCommit.setBackgroundResource(2130838044);
        this.mBtnCommit.setClickable(true);
        return;
        i = 0;
        break;
        j = 0;
        break label35;
        k = 0;
        break label51;
        this.D = "0";
        this.E = "0";
        this.y = "";
        this.z = "";
        d1 = 0.0D;
        d2 = 0.0D;
        break label72;
        d3 = 0.0D;
        break label87;
      }
      this.mBtnCommit.setBackgroundColor(-2236963);
      this.mBtnCommit.setClickable(false);
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    String str;
    if ((paramInt1 == this.g) && (paramIntent != null))
    {
      localObject = paramIntent.getStringExtra("isHasModifyDate");
      str = paramIntent.getStringExtra("isSampleCity");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && ("yes".equals(localObject))) {
        this.e.setCleanAddressInfo(this.c, null, str, paramInt2, false);
      }
    }
    else
    {
      if ((paramInt1 == this.r) && (paramInt2 == -1))
      {
        this.G = ((d)com.alibaba.fastjson.a.parseObject(paramIntent.getStringExtra("bedSelectTimeBean"), d.class));
        this.y = this.G.getAppointDate();
        this.z = this.G.getAppointTime();
        this.A = this.G.getServicePmId();
        this.B = this.G.isPublicArea();
        this.H = this.G.getBillId();
        this.C = this.G.getAppointDateTime();
        this.D = this.G.getSelectDateIndex();
        this.E = this.G.getSelectTimeIndex();
        this.J = this.G.getTimeShowText();
        if (!this.B) {
          break label537;
        }
        this.F = this.G.getEmployeeLogicCode();
        this.mletCleaner.setText(this.G.getEmployeeShowContent());
        this.mLetTime.setText(this.G.getAppointShowTime(), this.G.getTimeShowText());
        this.mLetTime.getmDoubleText().setTextColor(38430);
        label269:
        if (this.G.getDispatchPrice() != null) {
          this.I = this.G.getDispatchPrice().doubleValue();
        }
        str = this.y + " " + this.z;
        this.e.getRecommondCoupon(this.c, this.d.getAddressId(), this.A, this.u, str);
        e();
      }
      if ((paramInt1 == this.s) && (paramInt2 == -1))
      {
        this.w = paramIntent.getExtras().getString("Remark", "");
        this.x = paramIntent.getStringExtra("TagStr");
        this.e.setCleanSpecialNeed(this.c, this.w, this.x);
      }
      if (paramInt1 == this.t)
      {
        if (paramInt2 != -1) {
          break label571;
        }
        paramIntent = (al)paramIntent.getSerializableExtra("couponItem");
        this.mLetCoupon.setText("优惠" + (int)paramIntent.getPromoPrice() + "元");
        this.e.setCleanCoupon(this.c, paramIntent, paramInt2);
      }
    }
    for (;;)
    {
      e();
      return;
      if (paramIntent.getSerializableExtra("addressList") == null) {
        break;
      }
      localObject = (com.ziroom.ziroomcustomer.newclean.d.c)paramIntent.getSerializableExtra("addressList");
      this.e.setCleanAddressInfo(this.c, (com.ziroom.ziroomcustomer.newclean.d.c)localObject, str, paramInt2, true);
      break;
      label537:
      this.F = "";
      this.mletCleaner.setText("");
      this.mLetTime.setText(this.G.getAppointShowTime(), "");
      break label269;
      label571:
      if (paramInt2 == 1111) {
        this.e.setCleanCoupon(this.c, null, paramInt2);
      }
    }
  }
  
  @OnClick({2131689492, 2131690023, 2131690373, 2131690388, 2131690391, 2131690390, 2131690363, 2131689843, 2131689839})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      j.setFinishDialog(this);
      return;
      startActivity(new Intent(this, ChatWebViewActivity.class));
      return;
      this.f = new Intent(this.c, BedroomAddressActivity.class);
      this.f.putExtra("addressId", this.d.getAddressId());
      startActivityForResult(this.f, this.g);
      return;
      if (TextUtils.isEmpty(this.d.getAddressId()))
      {
        g.textToast(this.c, "请先选择地址");
        return;
      }
      this.f = new Intent(this.c, BedroomSelectTimeActivity.class);
      if (this.G == null) {
        this.f.putExtra("bedSelectTimeBean", "");
      }
      for (;;)
      {
        this.f.putExtra("houseCode", this.d.getHouseCode());
        this.f.putExtra("serviceInfoId", this.u);
        this.f.putExtra("addressId", this.d.getAddressId());
        startActivityForResult(this.f, this.r);
        return;
        this.f.putExtra("bedSelectTimeBean", com.alibaba.fastjson.a.toJSONString(this.G));
      }
      this.f = new Intent(this.c, CleanSpecialActivity.class);
      this.f.putExtra("lastInput", this.w);
      this.f.putExtra("lastTag", this.x);
      startActivityForResult(this.f, this.s);
      return;
      if (TextUtils.isEmpty(this.mLetAddress.getText()))
      {
        g.textToast(this.c, "请先选择地址");
        return;
      }
      if (TextUtils.isEmpty(this.mLetTime.getText()))
      {
        g.textToast(this.c, "请先选择项目或者时间");
        return;
      }
      paramView = this.y + " " + this.z;
      this.f = new Intent(this.c, CleanCouponActivity.class);
      this.f.putExtra("serviceInfoId", this.u);
      this.f.putExtra("addressId", this.d.getAddressId());
      this.f.putExtra("serviceItemCode", this.A);
      this.f.putExtra("startTime", paramView);
      startActivityForResult(this.f, this.t);
      return;
      if (TextUtils.isEmpty(this.mLetAddress.getText()))
      {
        g.textToast(this.c, "请先选择地址");
        return;
      }
      if (TextUtils.isEmpty(this.mLetTime.getText()))
      {
        g.textToast(this.c, "请先选择时长");
        return;
      }
      if (this.B)
      {
        g.textToast(this.c, "卧室保洁将于与公区保洁一起上门，不可更改保洁员");
        return;
      }
      this.f = new Intent(this.c, SelectCleanerActivity.class);
      this.f.putExtra("appointDateTime", this.C);
      this.f.putExtra("serviceInfoId", this.u);
      this.f.putExtra("servicePmId", this.A);
      this.f.putExtra("addressId", this.d.getAddressId());
      this.f.putExtra("appointDate", this.y);
      this.f.putExtra("appointTime", this.z);
      startActivity(this.f);
      return;
      if (TextUtils.isEmpty(this.mLetAddress.getText()))
      {
        g.textToast(this.c, "请先选择地址");
        return;
      }
      if (TextUtils.isEmpty(this.mLetTime.getText()))
      {
        g.textToast(this.c, "请先选择时间");
        return;
      }
      if (this.B) {
        paramView = null;
      }
      for (int i = 1;; i = 0)
      {
        String str = this.d.getAddress();
        this.e.setCommitOrderInfo(this.c, str, this.u, this.v, this.d.getAddressId(), this.d.getLinkPhone(), this.A, this.y, this.z, this.d.getPromoCodeId(), this.d.getRemark(), this.F, paramView, i, this.H, this.d.getCityCode());
        return;
        paramView = this.G.getGoods();
      }
      if (TextUtils.isEmpty(this.mLetAddress.getText()))
      {
        g.textToast(this.c, "请先选择地址");
        return;
      }
      if (TextUtils.isEmpty(this.mLetTime.getText()))
      {
        g.textToast(this.c, "请先选择时间");
        return;
      }
    } while (this.G == null);
    new com.ziroom.ziroomcustomer.newclean.c.b(this.c, this.G.getServicePrice().doubleValue(), this.d.getPromoPrice(), this.I).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903157);
    this.c = this;
    this.b = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.b.unbind();
    this.a.unregister(this.d);
    if (this.K != null) {
      unregisterReceiver(this.K);
    }
    super.onDestroy();
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
    Object localObject;
    label439:
    do
    {
      do
      {
        return;
        if (!parama.equals("clean_get_bedroom_address")) {
          break;
        }
        i = 0;
        break;
        if (!parama.equals("clean_set_address_info")) {
          break;
        }
        i = 1;
        break;
        if (!parama.equals("clean_set_special_info")) {
          break;
        }
        i = 2;
        break;
        if (!parama.equals("clean_set_coupon_info")) {
          break;
        }
        i = 3;
        break;
        if (!parama.equals("clean_recommond_coupon")) {
          break;
        }
        i = 4;
        break;
        if (!parama.equals("clean_create_order")) {
          break;
        }
        i = 5;
        break;
        this.mLetAddress.setText(this.d.getLinkPhone(), this.d.getAddress());
        e();
        return;
        this.mLetAddress.setText(this.d.getLinkPhone(), this.d.getAddress());
        this.mLetTime.setText("");
        this.mletCleaner.setText("");
        this.mLetCoupon.setText("");
        this.G = null;
        e();
        return;
        this.mLetSpecial.setText(this.d.getShowremark());
        return;
        this.mLetCoupon.setText(this.d.getPromoContent());
        e();
        return;
        this.mLetCoupon.setText(this.d.getPromoContent());
        e();
        return;
        parama = this.d.getCreateOrderMo();
        localObject = parama.getStatus();
        if (!"0".equals(localObject)) {
          break label439;
        }
        parama = parama.getData();
      } while (parama == null);
      localObject = new Intent(this.c, CleanSuccessActivity.class);
      ((Intent)localObject).putExtra("serviceInfoId", this.u);
      ((Intent)localObject).putExtra("serviceInfoName", this.v);
      ((Intent)localObject).putExtra("cleanId", parama.getFid());
      ((Intent)localObject).putExtra("Service_Type", "generalclean");
      startActivity((Intent)localObject);
      finish();
      return;
      if ("1".equals(localObject))
      {
        g.textToast(this.c, parama.getMessage());
        return;
      }
      if ("50030001".equals(localObject))
      {
        parama = parama.getData().getMessage();
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.c).setTitle("提示").setContent(parama).setBtnCancelText("放弃预约").setBtnConfirmText("去支付").setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              paramAnonymousView = new Intent(BedroomCleaningActivity.a(BedroomCleaningActivity.this), ZiroomOrderListActivity.class);
              paramAnonymousView.putExtra("order_status_type", "onlyPay");
              BedroomCleaningActivity.this.startActivity(paramAnonymousView);
              return;
            }
            BedroomCleaningActivity.this.finish();
          }
        }).build().show();
        return;
      }
    } while (!"50030002".equals(localObject));
    parama = parama.getData().getMessage();
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.c).setTitle("提示").setContent(parama).setBtnCancelText("联系客服").setBtnConfirmText("我知道了").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          BedroomCleaningActivity.this.finish();
          return;
        }
        j.toChat(BedroomCleaningActivity.a(BedroomCleaningActivity.this));
      }
    }).build().show();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      j.setFinishDialog(this);
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BedroomCleaningActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */