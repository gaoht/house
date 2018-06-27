package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.view.widget.a.a;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.d.au;
import com.ziroom.ziroomcustomer.newclean.d.aw;
import com.ziroom.ziroomcustomer.newclean.fragment.GeneralDetailFragment;
import com.ziroom.ziroomcustomer.newclean.fragment.GeneralStateFragment;
import com.ziroom.ziroomcustomer.newclean.view.CleanEvalWidget;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class GeneralOrderDetailActivity
  extends CleanDetailBaseActivity
{
  Handler A = new GeneralOrderDetailActivity.3(this);
  private String B;
  private String C;
  private au D;
  private String E = "";
  private boolean F = false;
  private boolean G = false;
  private boolean H = true;
  private boolean I = false;
  private String J;
  private boolean K = false;
  private List<String> L = new ArrayList();
  private i M;
  private GeneralOrderDetailActivity N;
  private int O = 0;
  private int P = 0;
  private String Q = "";
  private boolean R = false;
  private boolean S = false;
  private List<File> T = new ArrayList();
  private BroadcastReceiver U = new GeneralOrderDetailActivity.4(this);
  
  private void a(aw paramaw)
  {
    paramaw.getCancelShow();
    int i = paramaw.getPayShow();
    int j = paramaw.getEvaluateShow();
    int k = paramaw.getAgainOrderShow();
    this.P = paramaw.getSendCouponShow();
    this.Q = paramaw.getCouponPromptOne();
    this.C = paramaw.getEmployeeCode();
    org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("general_detail_cancle_state", paramaw));
    if ((i == 0) && (j == 0) && (k == 0))
    {
      this.E = "";
      this.z.setVisibility(8);
      this.e.setVisibility(8);
    }
    do
    {
      return;
      if (i == 1)
      {
        this.E = "status_pay";
        b();
      }
      if (j == 1)
      {
        this.z.setVisibility(0);
        this.x.setVisibility(8);
        this.e.setVisibility(0);
        this.E = "status_eval";
        this.e.setText("去评价");
        a(false);
        this.e.setOnClickListener(new GeneralOrderDetailActivity.5(this));
      }
    } while (k != 1);
    this.z.setVisibility(0);
    this.x.setVisibility(8);
    this.e.setVisibility(0);
    this.e.setText("再次预约");
    this.e.setOnClickListener(new GeneralOrderDetailActivity.6(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.D == null) {
        g.textToast(this, "数据刷新中...");
      }
    }
    else {
      while ((this.D == null) || (!"status_eval".equals(this.E)) || (this.F) || (this.K) || ((this.D != null) && (TextUtils.isEmpty(this.D.getCleannerId())))) {
        return;
      }
    }
    if (this.H)
    {
      this.H = false;
      this.r.setCleanDetailInfo(this.D.getCleanId(), this.D.getCleannerId(), this.D.getOrderNum(), this.P, this.Q);
    }
    this.r.setCleanEvalListener(new GeneralOrderDetailActivity.9(this));
    this.r.getmGvCamera().setOnItemClickListener(new GeneralOrderDetailActivity.10(this));
    com.ziroom.ziroomcustomer.newServiceList.utils.j.showChooseView(true, this.r);
    com.ziroom.ziroomcustomer.newServiceList.utils.j.showCoverAlphaAnimation(true, this.s);
    this.G = true;
    this.s.setClickable(true);
    this.s.setOnClickListener(new GeneralOrderDetailActivity.11(this));
  }
  
  private void b()
  {
    if (this.D == null) {}
    while (!"status_pay".equals(this.E)) {
      return;
    }
    this.z.setVisibility(0);
    this.x.setVisibility(0);
    this.e.setVisibility(8);
    this.y.setOnClickListener(new GeneralOrderDetailActivity.7(this));
    this.w.setOnClickListener(new GeneralOrderDetailActivity.8(this));
  }
  
  private void d(String paramString)
  {
    this.G = false;
    this.F = true;
    com.ziroom.ziroomcustomer.newServiceList.utils.j.showChooseView(false, this.r);
    com.ziroom.ziroomcustomer.newServiceList.utils.j.showCoverAlphaAnimation(false, this.s);
    this.s.setClickable(false);
    if (this.I)
    {
      this.I = false;
      paramString = new Intent(this, GeneralCleanQuestionnaireActivity.class);
      paramString.putExtra("orderCode", this.B);
      startActivity(paramString);
    }
  }
  
  private void e()
  {
    if ((this.R) && (this.S))
    {
      this.R = false;
      this.S = false;
      f();
    }
  }
  
  private void f()
  {
    if (this.D == null) {}
    while (!"status_pay".equals(this.E)) {
      return;
    }
    long l = this.D.getOrderPrice().intValue() * 100;
    com.ziroom.ziroomcustomer.newServiceList.utils.j.setServicePay(this, "general", this.B, 1, l, "", "");
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().clear();
    if (this.T == null) {
      this.T = new ArrayList();
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("拍照");
      localArrayList.add("相册选择");
      this.M = new i(this.N, new GeneralOrderDetailActivity.12(this), localArrayList);
      new Handler().postDelayed(new GeneralOrderDetailActivity.2(this), 250L);
      return;
      this.T.clear();
    }
  }
  
  private void h()
  {
    try
    {
      showProgressNoCancel("请稍后...", 5000L);
      Iterator localIterator = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().iterator();
      while (localIterator.hasNext())
      {
        File localFile = new File(ad.getRealFilePath2(this, Uri.parse(((a.a)localIterator.next()).getOriginalUri())));
        if (localFile.exists()) {
          this.T.add(localFile);
        }
      }
      if (this.T == null) {
        break label115;
      }
    }
    finally {}
    if (this.T.size() > 0) {
      this.A.sendEmptyMessage(0);
    }
    label115:
  }
  
  protected void a()
  {
    super.a();
    this.N = this;
    registerReceiver(this.U, new IntentFilter("com.ziroom.ziroomcustomer.payresult"));
    org.greenrobot.eventbus.c.getDefault().register(this);
    this.B = getIntent().getStringExtra("cleanId");
    String str = getIntent().getStringExtra("serviceInfoName");
    this.J = getIntent().getStringExtra("serviceInfoId");
    this.b.setText(str);
    this.z.setVisibility(8);
    this.e.setVisibility(8);
    this.f.add(GeneralStateFragment.getInstance(this.B));
    this.f.add(GeneralDetailFragment.getInstance(this.B));
    com.ziroom.ziroomcustomer.minsu.view.widget.a.init(this);
    getGeneralButtonState();
  }
  
  public void getGeneralButtonState()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getUid();
    n.getGeneralOrderControl(this, this.B, (String)localObject, new GeneralOrderDetailActivity.1(this, new m(aw.class, new com.ziroom.ziroomcustomer.e.c.a.a())));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.ziroom.ziroomcustomer.payment.a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (!com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().isResultOk());
          com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().setResultOk(false);
          h();
          return;
          paramIntent = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCameraImgPath();
        } while (TextUtils.isEmpty(paramIntent));
        localObject = new File(paramIntent);
      } while (!((File)localObject).exists());
      Object localObject = Uri.fromFile((File)localObject);
      a.a locala = new a.a();
      locala.setThumbnailUri(((Uri)localObject).toString());
      locala.setOriginalUri(((Uri)localObject).toString());
      locala.setOrientation(ad.getBitmapDegree(paramIntent));
      com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().add(locala);
      com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().setResultOk(true);
      h();
      return;
    } while ((paramInt2 != -1) || (paramIntent == null) || (paramIntent.getSerializableExtra("photos") == null));
    paramIntent = (ArrayList)paramIntent.getSerializableExtra("photos");
    this.L.clear();
    this.L.addAll(paramIntent);
    this.r.setCameraAdaperData(this.L);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    org.greenrobot.eventbus.c.getDefault().unregister(this);
    unregisterReceiver(this.U);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.G) {
        d("");
      }
      for (;;)
      {
        return true;
        finish();
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  @org.greenrobot.eventbus.j(threadMode=ThreadMode.MAIN)
  public void onShowMessageEvent(com.ziroom.ziroomcustomer.newServiceList.utils.c paramc)
  {
    if ("clean_pay_success_activity".equals(paramc.getType()))
    {
      this.R = true;
      e();
    }
    if ("general_button_refresh".equals(paramc.getType())) {
      getGeneralButtonState();
    }
    if ("general_button_refresh_cancle".equals(paramc.getType())) {
      getGeneralButtonState();
    }
    if ("general_clean_detail_data".equals(paramc.getType()))
    {
      this.D = ((au)paramc.getData());
      if (this.D != null)
      {
        this.C = this.D.getCleannerId();
        if (!TextUtils.isEmpty(this.C)) {
          break label231;
        }
        this.t.setVisibility(8);
      }
    }
    try
    {
      for (;;)
      {
        paramc = new DecimalFormat("######0.00");
        float f = Float.valueOf(this.D.getPayAmount()).floatValue();
        this.v.setText(paramc.format(f) + "");
        if (TextUtils.isEmpty(this.J)) {
          this.b.setText(this.D.getSerInfoName());
        }
        if ("status_pay".equals(this.E)) {
          b();
        }
        if ("status_eval".equals(this.E)) {
          a(false);
        }
        return;
        label231:
        paramc = new Bundle();
        paramc.putString("thumbType", "clean");
        paramc.putString("showType", "detail");
        paramc.putString("orderCode", this.B);
        paramc.putString("orderNum", this.D.getOrderNum());
        paramc.putString("employeeCode", this.C);
        com.ziroom.ziroomcustomer.newServiceList.utils.j.setServantThumb(this, this.t, paramc);
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        paramc.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/GeneralOrderDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */