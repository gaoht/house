package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption.DrivingPolicy;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.dialog.g.a;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceLoginActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.newclean.d.al;
import com.ziroom.ziroomcustomer.newclean.d.ba;
import com.ziroom.ziroomcustomer.newmovehouse.c.a.a;
import com.ziroom.ziroomcustomer.newmovehouse.model.Address;
import com.ziroom.ziroomcustomer.newmovehouse.model.EstimateItem;
import com.ziroom.ziroomcustomer.newmovehouse.model.IsHaveGoingOrderModel;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanGoodsNum;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanIsCanBean;
import com.ziroom.ziroomcustomer.newmovehouse.mvp.OrderDetailActivity;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import java.util.ArrayList;
import java.util.List;

public class MovingVanActivity
  extends BaseFluxActivity
  implements OnGetGeoCoderResultListener, OnGetRoutePlanResultListener
{
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  private LayoutInflater D;
  private int E;
  private List<String> F;
  private String G;
  private String H;
  private String I = "";
  private BaseAdapter J = new BaseAdapter()
  {
    public int getCount()
    {
      if ((MovingVanActivity.this.c == null) || (MovingVanActivity.this.c.getEstimateList() == null)) {
        return 0;
      }
      return MovingVanActivity.this.c.getEstimateList().size();
    }
    
    public Object getItem(int paramAnonymousInt)
    {
      return MovingVanActivity.this.c.getEstimateList().get(paramAnonymousInt);
    }
    
    public long getItemId(int paramAnonymousInt)
    {
      return paramAnonymousInt;
    }
    
    public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
    {
      Object localObject;
      if (paramAnonymousView == null)
      {
        localObject = new a();
        paramAnonymousView = MovingVanActivity.c(MovingVanActivity.this).inflate(2130904496, paramAnonymousViewGroup, false);
        ((a)localObject).a = ((TextView)paramAnonymousView.findViewById(2131690049));
        ((a)localObject).b = ((TextView)paramAnonymousView.findViewById(2131691546));
        paramAnonymousView.setTag(localObject);
      }
      for (paramAnonymousViewGroup = (ViewGroup)localObject;; paramAnonymousViewGroup = (a)paramAnonymousView.getTag())
      {
        localObject = (EstimateItem)getItem(paramAnonymousInt);
        paramAnonymousViewGroup.a.setText(((EstimateItem)localObject).getName());
        paramAnonymousViewGroup.b.setText(((EstimateItem)localObject).getValue());
        return paramAnonymousView;
      }
    }
    
    class a
    {
      TextView a;
      TextView b;
      
      a() {}
    }
  };
  Unbinder b;
  com.ziroom.ziroomcustomer.newmovehouse.d.e c;
  com.ziroom.ziroomcustomer.newmovehouse.a.a d;
  private final int e = 1;
  private final int f = 2;
  private final int g = 3;
  @BindView(2131691725)
  ImageView img_end;
  @BindView(2131691726)
  ImageView img_end_other;
  @BindView(2131691724)
  ImageView img_start;
  @BindView(2131690588)
  ImageView iv_close;
  @BindView(2131691723)
  ImageView iv_line;
  @BindView(2131691732)
  LabeledEditText let_in_add_lift;
  @BindView(2131691728)
  LabeledEditText let_out_add_lift;
  @BindView(2131691803)
  View line_moving_goods;
  @BindView(2131691810)
  TextView mAllLine;
  @BindView(2131689816)
  Button mBtnSubmit;
  @BindView(2131691807)
  ImageView mIvPrice;
  @BindView(2131691800)
  LabeledEditText mLetBulky;
  @BindView(2131691805)
  LabeledEditText mLetCoupon;
  @BindView(2131691798)
  LabeledEditText mLetInAdd;
  @BindView(2131691802)
  LabeledEditText mLetMovingGoods;
  @BindView(2131691797)
  LabeledEditText mLetOutAdd;
  @BindView(2131689983)
  LabeledEditText mLetPhone;
  @BindView(2131691804)
  LabeledEditText mLetRequirement;
  @BindView(2131691796)
  LabeledEditText mLetTime;
  @BindView(2131691808)
  LinearLayout mLlEstimate;
  @BindView(2131689817)
  ListView mLv;
  @BindView(2131690814)
  MapView mMapView;
  @BindView(2131691801)
  RelativeLayout mRlBulkyTip;
  @BindView(2131689912)
  TextView mTvPrice;
  @BindView(2131691809)
  TextView mTvTotal;
  private final int r = 4;
  private final int s = 5;
  private final int t = 6;
  private final int u = 7;
  private BaiduMap v;
  @BindView(2131691731)
  View view_in_add_lift;
  @BindView(2131691729)
  View view_out_add_lift;
  private GeoCoder w;
  private RoutePlanSearch x;
  private boolean y;
  private boolean z = false;
  
  private void a()
  {
    w.onEvent("truck_appointment_uv");
    e();
    this.mLetPhone.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() > 11)
        {
          MovingVanActivity.this.mLetPhone.setText(paramAnonymousEditable.toString().substring(0, 11));
          MovingVanActivity.this.mLetPhone.setSelection(MovingVanActivity.this.mLetPhone.getText().length());
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if ((paramAnonymousCharSequence.length() == 11) && (MovingVanActivity.this.c.isCanSubmit()))
        {
          MovingVanActivity.this.mBtnSubmit.setEnabled(true);
          return;
        }
        MovingVanActivity.this.mBtnSubmit.setEnabled(false);
      }
    });
    this.D = getLayoutInflater();
    this.v = this.mMapView.getMap();
    this.mMapView.showScaleControl(false);
    this.mMapView.showZoomControls(false);
    this.mMapView.removeViewAt(1);
    this.mMapView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        int i = MovingVanActivity.this.mMapView.getWidth();
        ViewGroup.LayoutParams localLayoutParams = MovingVanActivity.this.mMapView.getLayoutParams();
        localLayoutParams.height = (i / 2);
        MovingVanActivity.this.mMapView.setLayoutParams(localLayoutParams);
      }
    });
    this.mLv.setAdapter(this.J);
  }
  
  private void a(ImageView paramImageView, boolean paramBoolean)
  {
    float f2 = 180.0F;
    float f3 = paramImageView.getWidth() / 2.0F;
    float f4 = paramImageView.getHeight() / 2.0F;
    if (paramBoolean) {}
    for (float f1 = 360.0F;; f1 = 180.0F)
    {
      RotateAnimation localRotateAnimation = new RotateAnimation(f2, f1, f3, f4);
      localRotateAnimation.setDuration(100L);
      localRotateAnimation.setFillAfter(true);
      paramImageView.startAnimation(localRotateAnimation);
      return;
      f2 = 0.0F;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = new com.ziroom.ziroomcustomer.newmovehouse.c.a(this, this.c.getAppointmentDate(), this.c.getAppointmentTime(), this.I);
      ((com.ziroom.ziroomcustomer.newmovehouse.c.a)localObject).show();
      ((com.ziroom.ziroomcustomer.newmovehouse.c.a)localObject).setmListener(new a.a()
      {
        public void showSelect(long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
        {
          MovingVanActivity.a(MovingVanActivity.this, paramAnonymousString);
          if ((paramAnonymousLong1 > 0L) && (paramAnonymousLong2 > 0L)) {
            MovingVanActivity.this.d.updateMovingVanTime(MovingVanActivity.this, MovingVanActivity.this.c.getProductCode(), MovingVanActivity.this.c.getMvToken(), paramAnonymousLong1, paramAnonymousLong2, MovingVanActivity.this.getIntent().getStringExtra("productCategoryCode"), paramAnonymousString);
          }
        }
      });
      return;
    }
    Object localObject = new Intent(this, MovingServiceTimeActivity.class);
    ((Intent)localObject).putExtra("serviceTypeCode", this.c.getProductCode());
    ((Intent)localObject).putExtra("moveTime", this.c.getAppointmentTime());
    ((Intent)localObject).putExtra("selectDate", this.c.getAppointmentDate());
    startActivityForResult((Intent)localObject, 1);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1 == true) && (!paramBoolean2))
    {
      this.let_out_add_lift.setVisibility(0);
      this.view_out_add_lift.setVisibility(0);
      this.let_in_add_lift.setVisibility(8);
      this.view_in_add_lift.setVisibility(8);
      this.iv_line.setVisibility(4);
      this.img_end.setVisibility(0);
      this.img_end_other.setVisibility(8);
    }
    for (;;)
    {
      this.let_out_add_lift.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MovingVanActivity.a(MovingVanActivity.this, 1);
        }
      });
      this.let_in_add_lift.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MovingVanActivity.a(MovingVanActivity.this, 2);
        }
      });
      return;
      if ((!paramBoolean1) && (paramBoolean2 == true))
      {
        this.let_out_add_lift.setVisibility(8);
        this.view_out_add_lift.setVisibility(8);
        this.let_in_add_lift.setVisibility(8);
        this.view_in_add_lift.setVisibility(8);
        this.iv_line.setVisibility(4);
        this.img_end.setVisibility(4);
        this.img_end_other.setVisibility(0);
      }
      else
      {
        this.let_out_add_lift.setVisibility(8);
        this.view_out_add_lift.setVisibility(8);
        this.let_in_add_lift.setVisibility(8);
        this.view_in_add_lift.setVisibility(8);
        this.iv_line.setVisibility(0);
        this.img_end.setVisibility(0);
        this.img_end_other.setVisibility(8);
      }
    }
  }
  
  private void b()
  {
    this.G = getIntent().getStringExtra("recommendCode");
    this.H = getIntent().getStringExtra("channelCode");
    this.w = GeoCoder.newInstance();
    this.w.setOnGetGeoCodeResultListener(this);
    this.x = RoutePlanSearch.newInstance();
    this.x.setOnGetRoutePlanResultListener(this);
    this.d.initMvData(this, "8a90a5f8593e65b501593e65b5200000", getIntent().getStringExtra("productCategoryCode"), getIntent().getStringExtra("token"));
    this.d.initMvTool(this, "8a90a5f8593e65b501593e65b5200000");
  }
  
  private void b(int paramInt)
  {
    this.F = new ArrayList();
    this.F.clear();
    this.F.add("有电梯—无楼层费");
    int i = 1;
    while (i < 9)
    {
      this.F.add("无电梯住" + i + "层");
      i += 1;
    }
    u.e("sdjgkls", "======  " + com.alibaba.fastjson.a.toJSONString(this.F));
    this.E = paramInt;
    com.ziroom.ziroomcustomer.dialog.g localg = new com.ziroom.ziroomcustomer.dialog.g(this, new a(), this.F, null);
    localg.setCanceledOnTouchOutside(true);
    Window localWindow = localg.getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
    localg.show();
    localg.getTv_choose().setText("请选择楼层");
  }
  
  private void e()
  {
    findViewById(2131689492).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        j.setFinishDialog(MovingVanActivity.this);
      }
    });
    findViewById(2131690023).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MovingVanActivity.this.startActivity(new Intent(MovingVanActivity.this, ChatWebViewActivity.class));
      }
    });
  }
  
  private void f()
  {
    n.getMovingVanTimeCityIsCan(this, new com.ziroom.ziroomcustomer.e.a.d(this, new f(MovingVanIsCanBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        MovingVanActivity.a(MovingVanActivity.this, false);
      }
      
      public void onSuccess(int paramAnonymousInt, MovingVanIsCanBean paramAnonymousMovingVanIsCanBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMovingVanIsCanBean);
        if (paramAnonymousMovingVanIsCanBean != null)
        {
          if (paramAnonymousMovingVanIsCanBean.getIsTimeBlock() != null)
          {
            if (paramAnonymousMovingVanIsCanBean.getIsTimeBlock().intValue() == 1) {
              MovingVanActivity.a(MovingVanActivity.this, true);
            }
          }
          else {
            return;
          }
          MovingVanActivity.a(MovingVanActivity.this, false);
          return;
        }
        MovingVanActivity.a(MovingVanActivity.this, false);
      }
    });
  }
  
  private void g()
  {
    if ((this.c.getAppointmentTime() > 0L) && (this.c.getAppointmentDate() > 0L) && (this.c.isHasUpdateAddToServer())) {
      this.d.getEstimateCost(this, this.c.getProductCode(), this.c.getMvToken());
    }
  }
  
  private void h()
  {
    if (!TextUtils.isEmpty(this.c.getDateTimeText()))
    {
      this.mLetTime.setText(this.c.getDateTimeText());
      return;
    }
    this.mLetTime.setText("");
  }
  
  private void i()
  {
    Address localAddress = this.c.getOutAddress();
    if ((localAddress != null) && (localAddress.orderAddress != null))
    {
      if (TextUtils.isEmpty(localAddress.orderDoorplate))
      {
        this.mLetOutAdd.setText(localAddress.orderAddress);
        return;
      }
      this.mLetOutAdd.setText(localAddress.orderAddress + localAddress.orderDoorplate);
      return;
    }
    this.mLetOutAdd.setText("");
  }
  
  private void j()
  {
    Address localAddress = this.c.getInAddress();
    if ((localAddress != null) && (localAddress.orderAddress != null))
    {
      if (TextUtils.isEmpty(localAddress.orderDoorplate))
      {
        this.mLetInAdd.setText(localAddress.orderAddress);
        return;
      }
      this.mLetInAdd.setText(localAddress.orderAddress + localAddress.orderDoorplate);
      return;
    }
    this.mLetInAdd.setText("");
  }
  
  private void k()
  {
    String str = this.c.getPhone();
    if (!TextUtils.isEmpty(str))
    {
      this.mLetPhone.setText(str + "");
      return;
    }
    this.mLetPhone.setText("");
  }
  
  private void l()
  {
    this.mLetBulky.setVisibility(8);
    this.mRlBulkyTip.setVisibility(0);
    if (TextUtils.isEmpty(this.c.getBulkyText()))
    {
      this.mLetBulky.setText("");
      return;
    }
    this.mLetBulky.setVisibility(0);
    this.mRlBulkyTip.setVisibility(8);
    this.mLetBulky.setText(this.c.getBulkyText());
  }
  
  private void m()
  {
    if (TextUtils.isEmpty(this.c.getGoodsText()))
    {
      this.mLetMovingGoods.setText("");
      return;
    }
    this.mLetMovingGoods.setText(this.c.getGoodsText());
  }
  
  private void n()
  {
    this.mLetRequirement.setText(this.c.getRequirement());
  }
  
  private void o()
  {
    this.mLetCoupon.setText(this.c.getCouponsText());
  }
  
  private void p()
  {
    boolean bool = true;
    this.J.notifyDataSetChanged();
    Object localObject;
    if ((this.c.getEstimateCost() != null) && (this.c.getAppointmentTime() > 0L) && (this.c.getAppointmentDate() > 0L) && (this.c.getInAddress() != null) && (this.c.getOutAddress() != null))
    {
      this.mIvPrice.setVisibility(0);
      this.mTvPrice.setTextColor(Color.parseColor("#FF6262"));
      if (TextUtils.isEmpty(this.c.getTotalPriceText())) {
        break label307;
      }
      localObject = new SpannableString(this.c.getTotalPriceText());
      ((Spannable)localObject).setSpan(new AbsoluteSizeSpan(14, true), 0, 1, 18);
      ((Spannable)localObject).setSpan(new AbsoluteSizeSpan(18, true), 1, ((Spannable)localObject).length(), 18);
      this.mTvPrice.setText((CharSequence)localObject);
      label165:
      localObject = this.mBtnSubmit;
      if ((!this.c.isCanSubmit()) || (this.mLetPhone.getText().length() != 11)) {
        break label324;
      }
    }
    for (;;)
    {
      ((Button)localObject).setEnabled(bool);
      if ((this.c.getEstimateCost() != null) && (this.c.getEstimateCost().getInteger("totalDistance").intValue() > 0)) {
        this.mAllLine.setText("预估里程根据以下路线进行计算(共计" + this.c.getEstimateCost().getInteger("totalDistance") + "公里)");
      }
      return;
      this.mIvPrice.clearAnimation();
      this.mIvPrice.setVisibility(8);
      this.mTvPrice.setTextColor(Color.parseColor("#DDDDDD"));
      break;
      label307:
      this.mTvPrice.setText(this.c.getTotalPriceText());
      break label165;
      label324:
      bool = false;
    }
  }
  
  private void q()
  {
    if ((this.c.getOutAddress() == null) || (this.c.getInAddress() == null)) {
      return;
    }
    try
    {
      double d1 = Double.parseDouble(this.c.getOutAddress().addressLat);
      double d2 = Double.parseDouble(this.c.getOutAddress().addressLon);
      double d3 = Double.parseDouble(this.c.getInAddress().addressLat);
      double d4 = Double.parseDouble(this.c.getInAddress().addressLon);
      this.v.clear();
      PlanNode localPlanNode1 = PlanNode.withLocation(new LatLng(d1, d2));
      PlanNode localPlanNode2 = PlanNode.withLocation(new LatLng(d3, d4));
      this.x.drivingSearch(new DrivingRoutePlanOption().policy(DrivingRoutePlanOption.DrivingPolicy.ECAR_DIS_FIRST).from(localPlanNode1).to(localPlanNode2));
      return;
    }
    catch (Exception localException) {}
  }
  
  private void r()
  {
    if (ApplicationEx.c.isLoginState())
    {
      if (ApplicationEx.c.getUser() == null) {}
      for (String str = "";; str = ApplicationEx.c.getUser().getUid())
      {
        n.requestIsHaveGoingOrder(this, str, new com.ziroom.ziroomcustomer.e.a.d(this, new f(IsHaveGoingOrderModel.class))
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            super.onFailure(paramAnonymousThrowable);
            MovingVanActivity.d(MovingVanActivity.this);
          }
          
          public void onSuccess(int paramAnonymousInt, final IsHaveGoingOrderModel paramAnonymousIsHaveGoingOrderModel)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousIsHaveGoingOrderModel);
            if ((paramAnonymousIsHaveGoingOrderModel == null) || ("0".equals(paramAnonymousIsHaveGoingOrderModel.isHave)))
            {
              MovingVanActivity.d(MovingVanActivity.this);
              return;
            }
            com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(MovingVanActivity.this).setContent(paramAnonymousIsHaveGoingOrderModel.content).setTitle("提示").setButtonText("查看订单", "继续下单").setOnConfirmClickListener(new d.b()
            {
              public void onLeftClick(View paramAnonymous2View)
              {
                paramAnonymous2View = new Intent(MovingVanActivity.this, OrderDetailActivity.class);
                paramAnonymous2View.putExtra("orderId", paramAnonymousIsHaveGoingOrderModel.logicCode);
                if ("8a908eb161d66afc0161fa59fd210009".equals(paramAnonymousIsHaveGoingOrderModel.productCode)) {
                  paramAnonymous2View.putExtra("moveOrderType", "move_xiaomian");
                }
                for (;;)
                {
                  MovingVanActivity.this.startActivity(paramAnonymous2View);
                  return;
                  if ("2c9085f248ba3f3a0148bb156f6e0004".equals(paramAnonymousIsHaveGoingOrderModel.productCode)) {
                    paramAnonymous2View.putExtra("moveOrderType", "move_small");
                  } else if ("8a90a5f8593e65b501593e65b5200000".equals(paramAnonymousIsHaveGoingOrderModel.productCode)) {
                    paramAnonymous2View.putExtra("moveOrderType", "move_van");
                  }
                }
              }
              
              public void onRightClick(View paramAnonymous2View)
              {
                MovingVanActivity.d(MovingVanActivity.this);
              }
            }).show();
          }
        });
        return;
      }
    }
    startActivity(new Intent(this, ServiceLoginActivity.class));
  }
  
  private void s()
  {
    if (((this.z == true) || (this.A == true)) && (this.c.getAddFloors() == null))
    {
      com.freelxl.baselibrary.f.g.textToast(getApplicationContext(), "请先选择楼层");
      return;
    }
    if (h.isMobile(this.mLetPhone.getText()))
    {
      this.d.createMvOrder(this, this.c.getProductCode(), this.c.getMvToken(), this.mLetPhone.getText(), this.c.getRequirementTags(), this.H, this.G);
      return;
    }
    com.freelxl.baselibrary.f.g.textToast(getApplicationContext(), "请输入正确的手机号！");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 1111) {}
    switch (paramInt1)
    {
    default: 
      if (paramInt2 == -1) {
        switch (paramInt1)
        {
        }
      }
      break;
    }
    long l1;
    long l2;
    do
    {
      return;
      localObject = new al();
      ((al)localObject).setPromoId("");
      ((al)localObject).setPromoPrice(0.0F);
      this.d.updateMovingVanCoupons(this, this.c.getProductCode(), this.c.getMvToken(), (al)localObject);
      break;
      l1 = paramIntent.getLongExtra("selectDate", 0L);
      l2 = paramIntent.getLongExtra("moveTime", 0L);
    } while ((l1 <= 0L) || (l2 <= 0L));
    this.d.updateMovingVanTime(this, this.c.getProductCode(), this.c.getMvToken(), l1, l2, getIntent().getStringExtra("productCategoryCode"), "");
    return;
    Object localObject = new Address();
    ((Address)localObject).orderAddress = paramIntent.getStringExtra("address_location");
    ((Address)localObject).orderDoorplate = paramIntent.getStringExtra("address_detail");
    ((Address)localObject).addressLat = Double.toString(paramIntent.getDoubleExtra("latlng_map_lat", 0.0D));
    ((Address)localObject).addressLon = Double.toString(paramIntent.getDoubleExtra("latlng_map_lng", 0.0D));
    ((Address)localObject).isElevator = paramIntent.getIntExtra("elevator", 1);
    ((Address)localObject).floors = paramIntent.getIntExtra("floors", 0);
    ad.saveMovingVanStartAddressData(this, paramIntent.getStringExtra("address_location"), paramIntent.getStringExtra("address_detail"), paramIntent.getDoubleExtra("latlng_map_lat", 0.0D), paramIntent.getDoubleExtra("latlng_map_lng", 0.0D), paramIntent.getIntExtra("elevator", 1), paramIntent.getIntExtra("floors", 0));
    this.B = true;
    if (this.z == true)
    {
      this.z = false;
      a(this.z, this.A);
    }
    this.d.updateMovingVanAddLocal(this, this.c.getProductCode(), this.c.getMvToken(), (Address)localObject, null);
    return;
    localObject = new Address();
    ((Address)localObject).orderAddress = paramIntent.getStringExtra("address_location");
    ((Address)localObject).orderDoorplate = paramIntent.getStringExtra("address_detail");
    ((Address)localObject).addressLat = Double.toString(paramIntent.getDoubleExtra("latlng_map_lat", 0.0D));
    ((Address)localObject).addressLon = Double.toString(paramIntent.getDoubleExtra("latlng_map_lng", 0.0D));
    ((Address)localObject).isElevator = paramIntent.getIntExtra("elevator", 1);
    ((Address)localObject).floors = paramIntent.getIntExtra("floors", 0);
    ad.saveMovingVanEndAddressData(this, paramIntent.getStringExtra("address_location"), paramIntent.getStringExtra("address_detail"), paramIntent.getDoubleExtra("latlng_map_lat", 0.0D), paramIntent.getDoubleExtra("latlng_map_lng", 0.0D), paramIntent.getIntExtra("elevator", 1), paramIntent.getIntExtra("floors", 0));
    this.C = true;
    if (this.A == true)
    {
      this.A = false;
      a(this.z, this.A);
    }
    this.d.updateMovingVanAddLocal(this, this.c.getProductCode(), this.c.getMvToken(), null, (Address)localObject);
    return;
    paramIntent = paramIntent.getParcelableArrayListExtra("servicess");
    this.d.updateMovingVanServices(this, paramIntent);
    return;
    paramIntent = paramIntent.getParcelableArrayListExtra("goods");
    this.d.updateMovingVanGoods(this, paramIntent);
    return;
    localObject = paramIntent.getStringExtra("TagStr");
    String str = paramIntent.getStringExtra("Remark");
    paramIntent = paramIntent.getStringExtra("NeedTagId");
    this.d.updateMovingVanRequirements(this, (String)localObject, paramIntent, str);
    return;
    paramIntent = (al)paramIntent.getExtras().getSerializable("couponItem");
    this.d.updateMovingVanCoupons(this, this.c.getProductCode(), this.c.getMvToken(), paramIntent);
  }
  
  public void onBackPressed()
  {
    if (this.mLlEstimate != null)
    {
      if (this.mLlEstimate.getVisibility() == 0)
      {
        this.mLlEstimate.setVisibility(8);
        return;
      }
      j.setFinishDialog(this);
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903357);
    this.b = ButterKnife.bind(this);
    this.c = new com.ziroom.ziroomcustomer.newmovehouse.d.e(this);
    this.a.register(this.c);
    this.d = com.ziroom.ziroomcustomer.newmovehouse.a.a.getInstance(this.a);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.b.unbind();
    this.a.unregister(this.c);
    if (this.w != null) {
      this.w.destroy();
    }
    if (this.mMapView != null) {
      this.mMapView.onDestroy();
    }
    if (this.v != null) {
      this.v.clear();
    }
    if (this.x != null) {
      this.x.destroy();
    }
    super.onDestroy();
  }
  
  public void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
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
    label695:
    do
    {
      return;
      if (!parama.equals("service_mv_van_init")) {
        break;
      }
      i = 0;
      break;
      if (!parama.equals("service_mv_van_update_time")) {
        break;
      }
      i = 1;
      break;
      if (!parama.equals("service_mv_van_update_add")) {
        break;
      }
      i = 2;
      break;
      if (!parama.equals("service_mv_van_update_out_add")) {
        break;
      }
      i = 3;
      break;
      if (!parama.equals("service_mv_van_update_in_add")) {
        break;
      }
      i = 4;
      break;
      if (!parama.equals("service_mv_van_update_service")) {
        break;
      }
      i = 5;
      break;
      if (!parama.equals("service_mv_van_update_goods")) {
        break;
      }
      i = 6;
      break;
      if (!parama.equals("service_mv_van_update_coupons")) {
        break;
      }
      i = 7;
      break;
      if (!parama.equals("service_mv_van_update_requirement")) {
        break;
      }
      i = 8;
      break;
      if (!parama.equals("service_mv_van_update_phone")) {
        break;
      }
      i = 9;
      break;
      if (!parama.equals("service_mv_van_get_estimate_cost")) {
        break;
      }
      i = 10;
      break;
      if (!parama.equals("service_mv_van_submit")) {
        break;
      }
      i = 11;
      break;
      if (!parama.equals("service_mv_van_get_mode_coupon")) {
        break;
      }
      i = 12;
      break;
      if (!parama.equals("service_mv_van_update_address_floor")) {
        break;
      }
      i = 13;
      break;
      if (!parama.equals("service_mv_van_get_goods_num")) {
        break;
      }
      i = 14;
      break;
      this.z = false;
      this.A = false;
      a(this.z, this.A);
      if (this.c.getOutKeepAddress() != null)
      {
        parama = this.c.getOutKeepAddress();
        this.B = true;
        if (this.z == true)
        {
          this.z = false;
          a(this.z, this.A);
        }
        this.d.updateMovingVanAddLocal(this, this.c.getProductCode(), this.c.getMvToken(), parama, null);
        if (this.c.getInKeepAddress() == null) {
          break label695;
        }
        parama = this.c.getInKeepAddress();
        this.C = true;
        if (this.A == true)
        {
          this.A = false;
          a(this.z, this.A);
        }
        this.d.updateMovingVanAddLocal(this, this.c.getProductCode(), this.c.getMvToken(), null, parama);
      }
      for (;;)
      {
        k();
        p();
        return;
        if (this.c.getOutAddressContract() == null) {
          break;
        }
        this.y = false;
        this.z = true;
        a(this.z, this.A);
        this.w.geocode(new GeoCodeOption().city(com.ziroom.ziroomcustomer.base.b.c).address(this.c.getOutAddressContract().orderAddress));
        break;
        if (this.c.getInAddressContract() != null)
        {
          this.y = true;
          this.A = true;
          a(this.z, this.A);
          this.w.geocode(new GeoCodeOption().city(com.ziroom.ziroomcustomer.base.b.c).address(this.c.getInAddressContract().orderAddress));
        }
      }
      h();
      return;
      g();
      return;
      q();
      i();
      return;
      q();
      j();
      return;
      l();
      g();
      return;
      m();
      g();
      return;
      o();
      g();
      return;
      n();
      return;
      k();
      p();
      return;
      p();
      return;
      parama = new Intent(this, MovingVanSuccessActivity.class);
      parama.putExtra("move_from", "moving_van");
      parama.putExtra("orderId", this.c.getOrderCode());
      startActivityAndFinish(parama);
      return;
      parama = new al();
      if (this.c.getModeCoupon() != null)
      {
        parama.setPromoId(this.c.getModeCoupon().getPromoId());
        parama.setPromoPrice((float)this.c.getModeCoupon().getPromoPrice());
      }
      for (;;)
      {
        this.d.updateMovingVanCoupons(this, this.c.getProductCode(), this.c.getMvToken(), parama);
        return;
        parama.setPromoId("");
        parama.setPromoPrice(0.0F);
      }
      q();
      return;
      parama = this.c.getMovingVanGoodsNum();
    } while (parama == null);
    if (parama.getMaterielNum() != null)
    {
      if (parama.getMaterielNum().intValue() > 0)
      {
        this.line_moving_goods.setVisibility(0);
        this.mLetMovingGoods.setVisibility(0);
        return;
      }
      this.line_moving_goods.setVisibility(8);
      this.mLetMovingGoods.setVisibility(8);
      return;
    }
    this.line_moving_goods.setVisibility(8);
    this.mLetMovingGoods.setVisibility(8);
  }
  
  public void onGetBikingRouteResult(BikingRouteResult paramBikingRouteResult) {}
  
  public void onGetDrivingRouteResult(DrivingRouteResult paramDrivingRouteResult)
  {
    if ((paramDrivingRouteResult == null) || (paramDrivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR))
    {
      com.freelxl.baselibrary.f.g.textToast(this, "抱歉，未能成功规划路线，请重新填写搬出搬入地址");
      this.d.updateMovingVanAddLocal(this, this.c.getProductCode(), this.c.getMvToken(), null, null);
      return;
    }
    b localb = new b(this.v);
    this.v.setOnMarkerClickListener(localb);
    paramDrivingRouteResult = (DrivingRouteLine)paramDrivingRouteResult.getRouteLines().get(0);
    localb.setData(paramDrivingRouteResult);
    localb.addToMap();
    localb.zoomToSpan();
    int i = paramDrivingRouteResult.getDistance() / 1000;
    this.d.updateMovingVanAdd(this, this.c.getProductCode(), this.c.getMvToken(), this.c.getOutAddress(), this.c.getInAddress(), i);
  }
  
  public void onGetGeoCodeResult(GeoCodeResult paramGeoCodeResult)
  {
    if ((paramGeoCodeResult == null) || (paramGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR)) {}
    Address localAddress;
    do
    {
      do
      {
        return;
        if (!this.y) {
          break;
        }
        localAddress = this.c.getInAddressContract();
      } while ((this.c.getInAddress() != null) || (localAddress == null));
      localAddress.addressLat = (paramGeoCodeResult.getLocation().latitude + "");
      localAddress.addressLon = (paramGeoCodeResult.getLocation().longitude + "");
      this.d.updateMovingVanAddLocal(this, this.c.getProductCode(), this.c.getMvToken(), null, localAddress);
      return;
      localAddress = this.c.getOutAddressContract();
    } while ((this.c.getOutAddress() != null) || (localAddress == null));
    localAddress.addressLat = (paramGeoCodeResult.getLocation().latitude + "");
    localAddress.addressLon = (paramGeoCodeResult.getLocation().longitude + "");
    this.d.updateMovingVanAddLocal(this, this.c.getProductCode(), this.c.getMvToken(), localAddress, null);
  }
  
  public void onGetReverseGeoCodeResult(ReverseGeoCodeResult paramReverseGeoCodeResult) {}
  
  public void onGetTransitRouteResult(TransitRouteResult paramTransitRouteResult) {}
  
  public void onGetWalkingRouteResult(WalkingRouteResult paramWalkingRouteResult) {}
  
  protected void onPause()
  {
    this.mMapView.onPause();
    super.onPause();
  }
  
  protected void onResume()
  {
    this.mMapView.onResume();
    super.onResume();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (checkNet(this))
      {
        f();
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(this, "请求失败，请检查网络连接");
      return;
      paramView = new Intent(this, MHEnterAddressActivity.class);
      paramView.putExtra("type", "start");
      paramView.putExtra("serviceInfoId", this.c.getProductCode());
      paramView.putExtra("is_moving_van", true);
      paramView.putExtra("isStartFloor", this.z);
      Address localAddress;
      if ((this.c.getOutAddress() != null) && (this.B))
      {
        localAddress = this.c.getOutAddress();
        paramView.putExtra("latlng_map_lat", Double.parseDouble(localAddress.addressLat));
        paramView.putExtra("latlng_map_lng", Double.parseDouble(localAddress.addressLon));
        paramView.putExtra("address_location", localAddress.orderAddress);
        paramView.putExtra("address_detail", localAddress.orderDoorplate);
        paramView.putExtra("elevator", localAddress.isElevator);
        paramView.putExtra("floors", localAddress.floors);
      }
      startActivityForResult(paramView, 2);
      return;
      paramView = new Intent(this, MHEnterAddressActivity.class);
      paramView.putExtra("type", "end");
      paramView.putExtra("serviceInfoId", this.c.getProductCode());
      paramView.putExtra("is_moving_van", true);
      if ((this.c.getInAddress() != null) && (this.C))
      {
        localAddress = this.c.getInAddress();
        paramView.putExtra("latlng_map_lat", Double.parseDouble(localAddress.addressLat));
        paramView.putExtra("latlng_map_lng", Double.parseDouble(localAddress.addressLon));
        paramView.putExtra("address_location", localAddress.orderAddress);
        paramView.putExtra("address_detail", localAddress.orderDoorplate);
        paramView.putExtra("elevator", localAddress.isElevator);
        paramView.putExtra("floors", localAddress.floors);
      }
      startActivityForResult(paramView, 3);
      return;
      w.onEvent("truck_hugegoods");
      paramView = new Intent(this, MovingVanBulkyActivity.class);
      paramView.putParcelableArrayListExtra("services", (ArrayList)this.c.getVanServices());
      paramView.putExtra("productCode", this.c.getProductCode());
      paramView.putExtra("token", this.c.getMvToken());
      startActivityForResult(paramView, 4);
      return;
      paramView = new Intent(this, MovingVanGoodsActivity.class);
      paramView.putParcelableArrayListExtra("goods", (ArrayList)this.c.getGoods());
      paramView.putExtra("productCode", this.c.getProductCode());
      paramView.putExtra("token", this.c.getMvToken());
      startActivityForResult(paramView, 5);
      return;
      paramView = new Intent(this, MoveSpecialActivity.class);
      paramView.putExtra("cityCode", com.ziroom.ziroomcustomer.base.b.d);
      paramView.putExtra("lastInput", this.c.getRequirementMsg());
      paramView.putExtra("lastTag", this.c.getRequirementTag());
      paramView.putExtra("isMovingVan", true);
      startActivityForResult(paramView, 6);
      return;
      if ((this.c.getAppointmentDate() > 0L) && (this.c.getAppointmentTime() > 0L))
      {
        if (ApplicationEx.c.getUser() != null)
        {
          paramView = new Intent(this, MHPrivilegeActivity.class);
          paramView.putExtra("serviceInfoId", this.c.getProductCategoryCode());
          paramView.putExtra("startTime", this.c.getMvStartTime());
          startActivityForResult(paramView, 7);
          return;
        }
        startActivity(new Intent(this, ServiceLoginActivity.class));
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(this, "请先选择服务时间");
      return;
      if ((this.c.getEstimateCost() != null) && (this.c.getAppointmentTime() > 0L) && (this.c.getAppointmentDate() > 0L) && (this.c.getInAddress() != null) && (this.c.getOutAddress() != null))
      {
        paramView = (InputMethodManager)getSystemService("input_method");
        if (paramView != null) {
          paramView.hideSoftInputFromWindow(this.mLetPhone.getWindowToken(), 0);
        }
        this.mTvTotal.setText(this.c.getTotalPriceTextWithoutIcon());
        this.mLlEstimate.setVisibility(0);
        a(this.mIvPrice, false);
        w.onEvent("truck_pricedetail");
        return;
      }
      this.mLlEstimate.setVisibility(8);
      return;
      this.mLlEstimate.setVisibility(8);
      a(this.mIvPrice, true);
      this.J.notifyDataSetChanged();
      this.mTvTotal.setText(this.c.getTotalPriceTextWithoutIcon());
      return;
    } while (com.freelxl.baselibrary.f.e.isShakeClick());
    r();
  }
  
  class a
    implements g.a
  {
    a() {}
    
    public void showHour(String paramString, int paramInt)
    {
      if (MovingVanActivity.a(MovingVanActivity.this) == 1)
      {
        MovingVanActivity.this.d.updateMvAddressFloor(MovingVanActivity.this, MovingVanActivity.a(MovingVanActivity.this), paramInt, MovingVanActivity.this.c.getOutAddressContract());
        MovingVanActivity.this.let_out_add_lift.setText((String)MovingVanActivity.b(MovingVanActivity.this).get(paramInt));
      }
      while (MovingVanActivity.a(MovingVanActivity.this) != 2) {
        return;
      }
      MovingVanActivity.this.d.updateMvAddressFloor(MovingVanActivity.this, MovingVanActivity.a(MovingVanActivity.this), paramInt, MovingVanActivity.this.c.getInAddressContract());
      MovingVanActivity.this.let_in_add_lift.setText((String)MovingVanActivity.b(MovingVanActivity.this).get(paramInt));
    }
  }
  
  private class b
    extends com.ziroom.ziroomcustomer.util.b.a
  {
    public b(BaiduMap paramBaiduMap)
    {
      super();
    }
    
    public BitmapDescriptor getStartMarker()
    {
      return BitmapDescriptorFactory.fromResource(2130838844);
    }
    
    public BitmapDescriptor getTerminalMarker()
    {
      return BitmapDescriptorFactory.fromResource(2130838784);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MovingVanActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */