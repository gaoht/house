package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.a.e;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuContractDetailModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuContractDetailModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.baidumap.StationHouseMapLocationActivity;
import java.util.Map;

public class ZryuContractDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  Unbinder a;
  private String b;
  @BindView(2131690078)
  ImageView btnBack;
  @BindView(2131690459)
  ImageView btnCall;
  private String c = ZryuContractDetailActivity.class.getSimpleName();
  private ZryuContractDetailModel d;
  private String e;
  private String f;
  @BindView(2131692842)
  FrameLayout flZryuContractDetailImgContainer;
  @BindView(2131692843)
  SimpleDraweeView ivIvZryuContractDetail;
  @BindView(2131692844)
  ImageView ivZryuContractDetailShadow;
  @BindView(2131692855)
  LinearLayout llCheckAllBills;
  @BindView(2131692853)
  LinearLayout llCheckContractContainer;
  @BindView(2131692851)
  LinearLayout llIconContractAddress;
  @BindView(2131690426)
  View topLine;
  @BindView(2131692850)
  TextView tvContractAddress;
  @BindView(2131692815)
  TextView tvContractNum;
  @BindView(2131692852)
  TextView tvPayWayInfo;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131692845)
  TextView tvZryuContractDetailHouseName;
  @BindView(2131692849)
  TextView tvZryuContractDetailPrice;
  @BindView(2131692848)
  TextView tvZryuContractDetailRoomName;
  @BindView(2131692846)
  TextView tvZryuContractDetailStatus;
  @BindView(2131692847)
  TextView tvZryuContractDetailTime;
  
  private void a()
  {
    this.btnBack.setOnClickListener(this);
    this.btnCall.setOnClickListener(this);
    this.llIconContractAddress.setOnClickListener(this);
    this.llCheckAllBills.setOnClickListener(this);
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "月付";
    case 3: 
      return "季付";
    case 6: 
      return "半年付";
    case 12: 
      return "年付";
    }
    return "一次性付清";
  }
  
  private void b()
  {
    this.e = getIntent().getStringExtra("startDateStr");
    this.f = getIntent().getStringExtra("endDateStr");
    this.b = getIntent().getStringExtra("contractId");
    u.i(this.c, "contractId:" + this.b);
    if (checkNet(this))
    {
      Map localMap = com.ziroom.ziroomcustomer.ziroomapartment.a.c.buildGetContractDetail(this, this.b);
      e.getContractDetail(this, new a(), localMap, true);
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  private String d(String paramString)
  {
    if ("yqy".equals(paramString)) {
      return "已签约";
    }
    if ("ytz".equals(paramString)) {
      return "已退租";
    }
    if ("ydq".equals(paramString)) {
      return "已到期";
    }
    if ("yzf".equals(paramString)) {
      return "已作废";
    }
    return "";
  }
  
  private void e()
  {
    this.ivIvZryuContractDetail.setController(com.freelxl.baselibrary.f.c.frescoController(this.d.data.projectImg, new BaseControllerListener()
    {
      public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousString, paramAnonymousThrowable);
        ZryuContractDetailActivity.this.ivZryuContractDetailShadow.setVisibility(0);
      }
      
      public void onFinalImageSet(String paramAnonymousString, Object paramAnonymousObject, Animatable paramAnonymousAnimatable)
      {
        super.onFinalImageSet(paramAnonymousString, paramAnonymousObject, paramAnonymousAnimatable);
        ZryuContractDetailActivity.this.ivZryuContractDetailShadow.setVisibility(8);
      }
    }));
    this.tvZryuContractDetailHouseName.setText(this.d.data.projectName);
    this.tvZryuContractDetailStatus.setText(d(this.d.data.status));
    this.tvZryuContractDetailTime.setText(this.e + " 至 " + this.f);
    this.tvZryuContractDetailRoomName.setText(this.d.data.houseTypeName + "房型 " + this.d.data.roomNum + "房间");
    this.tvZryuContractDetailPrice.setText("¥" + this.d.data.roomPriceStr + "/月");
    this.tvContractNum.setText(this.d.data.contractCode);
    this.tvContractAddress.setText(this.d.data.projectAddress);
    this.tvPayWayInfo.setText(b(Integer.parseInt(this.d.data.payType)));
    if (ae.isNull(this.d.data.contactTel)) {
      this.btnCall.setVisibility(4);
    }
    while (ae.isNull(this.d.data.viewUrl))
    {
      this.llCheckContractContainer.setVisibility(8);
      return;
      this.btnCall.setVisibility(0);
    }
    this.llCheckContractContainer.setVisibility(0);
    this.llCheckContractContainer.setOnClickListener(this);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131690078: 
    case 2131690459: 
    case 2131692851: 
    case 2131692853: 
      do
      {
        do
        {
          return;
          finish();
          return;
        } while ((this.d == null) || (this.d.data == null));
        startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.d.data.contactTel)));
        return;
        toBaiduMap();
        return;
      } while ((this.d == null) || (this.d.data == null));
      paramView = new Intent(this, HomeWebActivity.class);
      paramView.putExtra("url", this.d.data.viewUrl);
      paramView.putExtra("title", "合同说明");
      startActivity(paramView);
      return;
    }
    paramView = new Intent(this, ZryuBillListActivity.class);
    paramView.putExtra("contractId", this.d.data.contractId);
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903580);
    this.a = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
  }
  
  public void toBaiduMap()
  {
    if ((this.d != null) && (this.d.data != null))
    {
      String str = this.d.data.lon + "," + this.d.data.lat;
      Intent localIntent = new Intent(this, StationHouseMapLocationActivity.class);
      localIntent.putExtra("search_location", str);
      localIntent.putExtra("resblock_name", this.d.data.projectAddress);
      startActivity(localIntent);
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      u.i(ZryuContractDetailActivity.c(ZryuContractDetailActivity.this), "接口返回：" + paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        ZryuContractDetailActivity.a(ZryuContractDetailActivity.this, (ZryuContractDetailModel)paramk.getObject());
        if (ZryuContractDetailActivity.a(ZryuContractDetailActivity.this) != null)
        {
          if (200 == ZryuContractDetailActivity.a(ZryuContractDetailActivity.this).error_code) {
            ZryuContractDetailActivity.b(ZryuContractDetailActivity.this);
          }
        }
        else {
          return;
        }
        ZryuContractDetailActivity.this.showToast(ZryuContractDetailActivity.a(ZryuContractDetailActivity.this).error_message);
        return;
      }
      ZryuContractDetailActivity.this.showToast(paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuContractDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */