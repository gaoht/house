package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseManagerBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseManagerBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseManagerBean.DataBean.TitleListBean;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LandlordReleaseManagerActivity
  extends BaseFluxActivity
{
  private String b;
  @BindView(2131690043)
  Button btn;
  @BindView(2131691099)
  FrameLayout btnArea;
  @BindView(2131691101)
  Button btnBottom;
  @BindView(2131691100)
  FrameLayout btn_bottom_area;
  private String c;
  @BindView(2131691272)
  CommonTitle commonTitle;
  @BindView(2131691097)
  ViewGroup content;
  private int d;
  private int e;
  private LLReleaseManagerBean f;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c g;
  @BindView(2131690955)
  ListViewForScrollView listview;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b r;
  @BindView(2131689506)
  ViewGroup scrollview;
  @BindView(2131691098)
  SimpleDraweeView sdv;
  @BindView(2131689822)
  TextView tvStatus;
  
  private void a()
  {
    this.commonTitle.setMiddleText(getString(2131297135));
    this.commonTitle.setLeftButtonType(0);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LandlordReleaseManagerActivity.this.setResult(-1);
        LandlordReleaseManagerActivity.this.finish();
      }
    });
    this.commonTitle.showRightText(true, getString(2131297151));
    this.commonTitle.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LandlordReleaseManagerActivity localLandlordReleaseManagerActivity = LandlordReleaseManagerActivity.this;
        if (LandlordReleaseManagerActivity.a(LandlordReleaseManagerActivity.this) == 0) {}
        for (paramAnonymousView = LandlordReleaseManagerActivity.b(LandlordReleaseManagerActivity.this);; paramAnonymousView = LandlordReleaseManagerActivity.c(LandlordReleaseManagerActivity.this))
        {
          k.toHouseDetail(localLandlordReleaseManagerActivity, paramAnonymousView, LandlordReleaseManagerActivity.a(LandlordReleaseManagerActivity.this) + "", false);
          return;
        }
      }
    });
  }
  
  private void b()
  {
    this.r.getHouseManagerBase(this, this, this.b, this.c, Integer.valueOf(this.d));
  }
  
  private void b(int paramInt)
  {
    int i = 3;
    Object localObject1 = (LLReleaseManagerBean.DataBean.TitleListBean)this.f.data.titleList.get(paramInt);
    if (((LLReleaseManagerBean.DataBean.TitleListBean)localObject1).isEdit)
    {
      localObject2 = new Bundle();
      switch (paramInt)
      {
      }
    }
    while (paramInt == this.f.data.titleList.size() - 1)
    {
      return;
      ((Bundle)localObject2).putInt("type", 3);
      ((Bundle)localObject2).putString("houseBaseFid", this.b);
      ((Bundle)localObject2).putString("roomFid", this.c);
      ((Bundle)localObject2).putInt("rentWay", this.d);
      ((Bundle)localObject2).putInt("roomType", this.e);
      ((Bundle)localObject2).putInt("status", j());
      k.toFragmengWraperActivity(this, (Bundle)localObject2, paramInt);
      return;
      if (this.d == 0) {
        ((Bundle)localObject2).putInt("type", 4);
      }
      for (;;)
      {
        ((Bundle)localObject2).putString("houseBaseFid", this.b);
        ((Bundle)localObject2).putString("roomFid", this.c);
        ((Bundle)localObject2).putInt("rentWay", this.d);
        ((Bundle)localObject2).putInt("roomType", this.e);
        ((Bundle)localObject2).putInt("status", j());
        k.toFragmengWraperActivity(this, (Bundle)localObject2, paramInt);
        return;
        ((Bundle)localObject2).putInt("type", 5);
      }
      localObject1 = this.b;
      Object localObject2 = this.c;
      int j = this.d;
      if (this.d == 0) {}
      for (;;)
      {
        k.toHouseRelease(this, (String)localObject1, (String)localObject2, j, i, "manager", paramInt, this.e);
        return;
        i = 4;
      }
      localObject1 = this.b;
      localObject2 = this.c;
      j = this.d;
      if (this.d == 0) {}
      for (i = 4;; i = 5)
      {
        k.toHouseRelease(this, (String)localObject1, (String)localObject2, j, i, "manager", paramInt, this.e);
        return;
      }
      k.toSetPrice(this, this.b, this.c, this.d, "from_manager_release");
      return;
      localObject2 = new HashMap();
      ((Map)localObject2).put("houseBaseFid", this.b);
      k.goWeb(this, com.ziroom.ziroomcustomer.minsu.e.d.map2GetUrl((Map)localObject2, ((LLReleaseManagerBean.DataBean.TitleListBean)localObject1).value));
      return;
    }
    g.textToast(this, "审核中的房源无法修改信息，修改请先取消发布");
  }
  
  private void d(String paramString)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        switch (LandlordReleaseManagerActivity.d(LandlordReleaseManagerActivity.this).data.houseStatus)
        {
        default: 
          return;
        case 40: 
          LandlordReleaseManagerActivity.e(LandlordReleaseManagerActivity.this);
          return;
        }
        LandlordReleaseManagerActivity.f(LandlordReleaseManagerActivity.this);
      }
    }).setContent(paramString).setButtonText("取消", "确定").show();
  }
  
  private void e()
  {
    this.g = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c(this);
    this.a.register(this.g);
    this.r = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void f()
  {
    if (!TextUtils.isEmpty(this.f.data.defaultPic))
    {
      this.sdv.setController(com.freelxl.baselibrary.f.c.frescoController(this.f.data.defaultPic));
      this.sdv.getLayoutParams().width = com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(this);
      this.sdv.getLayoutParams().height = (com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(this) * 2 / 3);
    }
    if (!TextUtils.isEmpty(this.f.data.houseStatusName))
    {
      this.tvStatus.setVisibility(0);
      this.tvStatus.setText(this.f.data.houseStatusName);
    }
    if (!TextUtils.isEmpty(this.f.data.labelColor)) {}
    try
    {
      int i = Color.parseColor(this.f.data.labelColor);
      localObject1 = Integer.valueOf(i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        localException.printStackTrace();
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("wz", localException.getMessage());
        Object localObject2 = null;
        continue;
        this.btnArea.setVisibility(0);
        this.btn_bottom_area.setVisibility(8);
        this.content.setPadding(0, 0, 0, 0);
        this.btn.setTextColor(Color.parseColor("#FFA000"));
        this.btn.setBackgroundResource(2130837816);
      }
    }
    if (localObject1 != null) {
      this.tvStatus.setBackgroundColor(((Integer)localObject1).intValue());
    }
    localObject1 = new com.freelxl.baselibrary.a.a(this, this.f.data.titleList, 2130904380)
    {
      public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, LLReleaseManagerBean.DataBean.TitleListBean paramAnonymousTitleListBean)
      {
        paramAnonymousb.setText(2131689541, paramAnonymousTitleListBean.title);
        paramAnonymousb.setText(2131690071, paramAnonymousTitleListBean.text);
        if (paramAnonymousTitleListBean.isEdit)
        {
          paramAnonymousb.setVisibility(2131690724, 0);
          return;
        }
        paramAnonymousb.setVisibility(2131690724, 8);
      }
    };
    this.listview.setAdapter((ListAdapter)localObject1);
    this.listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        LandlordReleaseManagerActivity.a(LandlordReleaseManagerActivity.this, paramAnonymousInt);
      }
    });
    if ("1".equals(this.f.data.buttonColor))
    {
      this.btnArea.setVisibility(8);
      this.btn_bottom_area.setVisibility(0);
      this.content.setPadding(0, 0, 0, ab.dp2px(this, 96.0F));
      this.btn.setText(this.f.data.buttonStr);
      this.btnBottom.setText(this.f.data.buttonStr);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          LandlordReleaseManagerActivity.this.sdv.setFocusable(true);
          LandlordReleaseManagerActivity.this.sdv.setFocusableInTouchMode(true);
          LandlordReleaseManagerActivity.this.sdv.requestFocus();
        }
      }, 40L);
      return;
    }
  }
  
  private void g()
  {
    this.r.releaseHouse(this, this, this.b, this.c, this.d);
  }
  
  private void h()
  {
    this.r.cancelReleaseHouse(this, this, this.b, this.c, this.d);
  }
  
  private void i()
  {
    this.r.downReleaseHouse(this, this, this.b, this.c, this.d);
  }
  
  private int j()
  {
    switch (this.f.data.houseStatus)
    {
    default: 
      return -2;
    case 40: 
      return 1;
    case 11: 
    case 21: 
      return 2;
    }
    return 3;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903248);
    ButterKnife.bind(this);
    this.b = getIntent().getStringExtra("houseBaseFid");
    this.c = getIntent().getStringExtra("roomFid");
    this.d = getIntent().getIntExtra("rentWay", 0);
    this.e = getIntent().getIntExtra("roomType", 0);
    a();
    e();
    this.content.setVisibility(8);
    b();
  }
  
  protected void onDestroy()
  {
    this.a.unregister(this.g);
    super.onDestroy();
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i = -1;
    switch (parama.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      case 1: 
      case 3: 
      case 5: 
      default: 
        return;
        if (parama.equals("ll_manager_release"))
        {
          i = 0;
          continue;
          if (parama.equals("ll_manager_release_error"))
          {
            i = 1;
            continue;
            if (parama.equals("ll_r_manager_release_house"))
            {
              i = 2;
              continue;
              if (parama.equals("ll_r_manager_release_house_error"))
              {
                i = 3;
                continue;
                if (parama.equals("ll_r_manager_cancel_release"))
                {
                  i = 4;
                  continue;
                  if (parama.equals("ll_r_manager_cancel_release_error"))
                  {
                    i = 5;
                    continue;
                    if (parama.equals("ll_r_manager_down_release"))
                    {
                      i = 6;
                      continue;
                      if (parama.equals("ll_r_manager_down_release_error")) {
                        i = 7;
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
    this.f = this.g.getLLReleaseManagerBean();
    if ((this.f != null) && (this.f.data != null))
    {
      this.content.setVisibility(0);
      f();
      return;
    }
    if (this.f == null) {}
    for (parama = "";; parama = this.f.message)
    {
      ad.shouErrorMessage(parama);
      return;
    }
    parama = this.g.getReleaseHouseResult();
    if (parama.checkSuccess(this))
    {
      g.textToast(this, "发布房源成功");
      b();
      return;
    }
    if (parama == null) {}
    for (parama = "";; parama = parama.message)
    {
      g.textToast(this, parama);
      return;
    }
    parama = this.g.getCancelReleaseHouseResult();
    if (parama.checkSuccess(this))
    {
      g.textToast(this, "取消发布房源成功");
      b();
      return;
    }
    if (parama == null) {}
    for (parama = "";; parama = parama.message)
    {
      g.textToast(this, parama);
      return;
    }
    parama = this.g.getDownReleaseHouseResult();
    if (parama.checkSuccess(this))
    {
      g.textToast(this, "下架房源成功");
      b();
      return;
    }
    if (parama == null) {}
    for (parama = "";; parama = parama.message)
    {
      g.textToast(this, parama);
      return;
    }
  }
  
  @OnClick({2131691098, 2131690043, 2131691101})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691098: 
      if ((this.f.data.houseStatus == 11) || (this.f.data.houseStatus == 21))
      {
        g.textToast(this, "审核中的房源无法修改信息，修改请先取消发布");
        return;
      }
      paramView = this.b;
      String str = this.c;
      int j = this.d;
      if (this.d == 0) {}
      for (int i = 5;; i = 6)
      {
        k.toHouseRelease(this, paramView, str, j, i, "manager", 5, this.e);
        return;
      }
    }
    switch (this.f.data.houseStatus)
    {
    default: 
      return;
    case 10: 
    case 20: 
    case 30: 
    case 41: 
    case 50: 
      g();
      return;
    case 40: 
      d("下架房源仍然需要对已支付订单负责，且无法继续接受订单，请确认是否继续下架房源？");
      return;
    }
    d("取消发布后无法上架房源，请确认是否继续取消发布么？");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseManagerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */