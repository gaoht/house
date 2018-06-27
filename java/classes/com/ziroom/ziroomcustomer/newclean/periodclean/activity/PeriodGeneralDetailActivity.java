package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.view.widget.a.a;
import com.ziroom.ziroomcustomer.newclean.activity.GeneralCleanQuestionnaireActivity;
import com.ziroom.ziroomcustomer.newclean.activity.PeriodCleanBaseActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralButtonBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralDetailBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralDetailBean.ChargesBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralDetailBean.RecommendCoupon;
import com.ziroom.ziroomcustomer.newclean.periodclean.fragment.PeriodGeneralDetailFragment;
import com.ziroom.ziroomcustomer.newclean.periodclean.fragment.PeriodGeneralStateFragment;
import com.ziroom.ziroomcustomer.newclean.view.CleanEvalWidget;
import com.ziroom.ziroomcustomer.util.p;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class PeriodGeneralDetailActivity
  extends PeriodCleanBaseActivity
{
  Handler A = new PeriodGeneralDetailActivity.5(this);
  private String B;
  private String C;
  private PeriodGeneralDetailBean D;
  private String E = "";
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  private boolean I = true;
  private boolean J = false;
  private boolean K = false;
  private String L;
  private boolean M = false;
  private boolean N = false;
  private String O = "";
  private String P = "";
  private boolean Q = false;
  private boolean R = false;
  private boolean S = false;
  private List<String> T = new ArrayList();
  private i U;
  private PeriodGeneralDetailActivity V;
  private int W = 0;
  private String X = "";
  private List<File> Y = new ArrayList();
  private int Z = 1;
  private BroadcastReceiver aa = new PeriodGeneralDetailActivity.6(this);
  
  private void a(PeriodGeneralButtonBean paramPeriodGeneralButtonBean)
  {
    int i = paramPeriodGeneralButtonBean.getCancelShow().intValue();
    int j = paramPeriodGeneralButtonBean.getPayShow().intValue();
    int k = paramPeriodGeneralButtonBean.getEvaluateShow().intValue();
    int m = paramPeriodGeneralButtonBean.getAgainOrderShow().intValue();
    this.C = paramPeriodGeneralButtonBean.getEmployeeCode();
    this.W = paramPeriodGeneralButtonBean.getSendCouponShow();
    this.X = paramPeriodGeneralButtonBean.getCouponPromptOne();
    org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("period_general_detail_cancle_state", Integer.valueOf(i)));
    if ((j == 0) && (k == 0) && (m == 0))
    {
      this.E = "";
      this.z.setVisibility(8);
      this.e.setVisibility(8);
    }
    for (;;)
    {
      if (k == 1)
      {
        this.z.setVisibility(0);
        this.E = "status_eval";
        this.x.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setText("去评价");
        a(false);
        this.e.setOnClickListener(new PeriodGeneralDetailActivity.9(this));
      }
      if (m == 1)
      {
        this.z.setVisibility(0);
        this.x.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setText("再次预约");
        this.e.setOnClickListener(new PeriodGeneralDetailActivity.10(this));
      }
      return;
      if (j == 1)
      {
        this.E = "status_pay";
        f();
      }
    }
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
      while ((this.D == null) || (!"status_eval".equals(this.E)) || (this.F) || (this.N) || ((this.D != null) && (TextUtils.isEmpty(this.D.getEmployeeCode())))) {
        return;
      }
    }
    if (this.I)
    {
      this.I = false;
      this.r.setCleanDetailInfo(this.D.getOrderNum(), this.D.getEmployeeCode(), this.D.getOrderNum(), this.W, this.X);
    }
    this.r.setCleanEvalListener(new PeriodGeneralDetailActivity.13(this));
    this.r.getmGvCamera().setOnItemClickListener(new PeriodGeneralDetailActivity.14(this));
    com.ziroom.ziroomcustomer.newServiceList.utils.j.showChooseView(true, this.r);
    com.ziroom.ziroomcustomer.newServiceList.utils.j.showCoverAlphaAnimation(true, this.s);
    this.H = true;
    this.s.setClickable(true);
    this.s.setOnClickListener(new PeriodGeneralDetailActivity.2(this));
  }
  
  private void b()
  {
    if ((this.R) && (this.S))
    {
      this.R = false;
      p.showGuide(this, "period_general_detail_modify", 2130904687, new PeriodGeneralDetailActivity.7(this), null);
    }
  }
  
  private void d(String paramString)
  {
    this.H = false;
    this.F = true;
    com.ziroom.ziroomcustomer.newServiceList.utils.j.showChooseView(false, this.r);
    com.ziroom.ziroomcustomer.newServiceList.utils.j.showCoverAlphaAnimation(false, this.s);
    this.s.setClickable(false);
    if (this.K)
    {
      this.K = false;
      paramString = new Intent(this, GeneralCleanQuestionnaireActivity.class);
      paramString.putExtra("orderCode", this.B);
      startActivity(paramString);
    }
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodGeneralActionState(this, this.B, new PeriodGeneralDetailActivity.8(this, this, new f(PeriodGeneralButtonBean.class)));
  }
  
  private void f()
  {
    if (this.D == null) {}
    while (!"status_pay".equals(this.E)) {
      return;
    }
    this.z.setVisibility(0);
    this.x.setVisibility(0);
    this.e.setVisibility(8);
    this.y.setOnClickListener(new PeriodGeneralDetailActivity.11(this));
    this.w.setOnClickListener(new PeriodGeneralDetailActivity.12(this));
  }
  
  private void g()
  {
    if (this.D == null) {}
    while ((!"status_pay".equals(this.E)) || (this.D.getCharges() == null)) {
      return;
    }
    long l = this.D.getCharges().getNeedPay().longValue();
    Object localObject1 = "";
    String str = "";
    Object localObject2 = localObject1;
    if (this.D.getRecommandCoupon() != null)
    {
      if (!TextUtils.isEmpty(this.D.getRecommandCoupon().getCouponId())) {
        localObject1 = this.D.getRecommandCoupon().getCouponId();
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty(this.D.getRecommandCoupon().getCouponCode())) {}
    }
    for (localObject2 = this.D.getRecommandCoupon().getCouponCode();; localObject2 = str)
    {
      com.ziroom.ziroomcustomer.newServiceList.utils.j.setServicePay(this, "periodgeneral", this.B, 1, l, (String)localObject1, (String)localObject2);
      return;
      localObject1 = localObject2;
    }
  }
  
  private void h()
  {
    com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().clear();
    if (this.Y == null) {
      this.Y = new ArrayList();
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("拍照");
      localArrayList.add("相册选择");
      this.U = new i(this.V, new PeriodGeneralDetailActivity.3(this), localArrayList);
      new Handler().postDelayed(new PeriodGeneralDetailActivity.4(this), 250L);
      return;
      this.Y.clear();
    }
  }
  
  private void i()
  {
    try
    {
      showProgressNoCancel("请稍后...", 5000L);
      Iterator localIterator = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (a.a)localIterator.next();
        localObject2 = new File(ad.getRealFilePath2(this.V, Uri.parse(((a.a)localObject2).getOriginalUri())));
        if (((File)localObject2).exists()) {
          this.Y.add(localObject2);
        }
      }
      if (this.Y == null) {
        break label120;
      }
    }
    finally {}
    if (this.Y.size() > 0) {
      this.A.sendEmptyMessage(0);
    }
    label120:
  }
  
  protected void a()
  {
    super.a();
    this.V = this;
    registerReceiver(this.aa, new IntentFilter("com.ziroom.ziroomcustomer.payresult"));
    org.greenrobot.eventbus.c.getDefault().register(this);
    this.B = getIntent().getStringExtra("cleanId");
    getIntent().getStringExtra("serviceInfoName");
    this.L = getIntent().getStringExtra("serviceInfoId");
    this.b.setText("日常保洁");
    this.e.setVisibility(8);
    this.z.setVisibility(8);
    com.ziroom.ziroomcustomer.minsu.view.widget.a.init(this.V);
    this.f.add(PeriodGeneralStateFragment.getInstance(this.B));
    this.f.add(PeriodGeneralDetailFragment.getInstance(this.B));
    e();
    this.a.addOnPageChangeListener(new PeriodGeneralDetailActivity.1(this));
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
          i();
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
      i();
      return;
    } while ((paramInt2 != -1) || (paramIntent == null) || (paramIntent.getSerializableExtra("photos") == null));
    paramIntent = (ArrayList)paramIntent.getSerializableExtra("photos");
    this.T.clear();
    this.T.addAll(paramIntent);
    this.r.setCameraAdaperData(this.T);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    org.greenrobot.eventbus.c.getDefault().unregister(this);
    unregisterReceiver(this.aa);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.H) {
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
    if ("period_general_button_refresh".equals(paramc.getType())) {
      e();
    }
    if ("period_general_button_refresh_cancle".equals(paramc.getType())) {
      e();
    }
    if ("period_general_clean_detail_data".equals(paramc.getType()))
    {
      this.D = ((PeriodGeneralDetailBean)paramc.getData());
      if (this.D != null)
      {
        this.C = this.D.getEmployeeCode();
        if (!TextUtils.isEmpty(this.C)) {
          break label250;
        }
        this.t.setVisibility(8);
      }
    }
    try
    {
      for (;;)
      {
        Object localObject = new DecimalFormat("######0.00");
        this.v.setText(((DecimalFormat)localObject).format(this.D.getCharges().getNeedPay().longValue() / 100L) + "");
        this.w.setClickable(true);
        if ("status_pay".equals(this.E)) {
          f();
        }
        if ("status_eval".equals(this.E)) {
          a(false);
        }
        if (("period_general_pay_modify_coupon_info".equals(paramc.getType())) || ("period_general_pay_modify_coupon_info_not_use".equals(paramc.getType()))) {
          this.w.setClickable(false);
        }
        if ("period_general_clean_modify_show".equals(paramc.getType()))
        {
          this.R = true;
          b();
        }
        return;
        label250:
        localObject = new Bundle();
        ((Bundle)localObject).putString("thumbType", "clean");
        ((Bundle)localObject).putString("showType", "detail");
        ((Bundle)localObject).putString("orderCode", this.B);
        ((Bundle)localObject).putString("orderNum", this.D.getOrderNum());
        ((Bundle)localObject).putString("employeeCode", this.C);
        com.ziroom.ziroomcustomer.newServiceList.utils.j.setServantThumb(this, this.t, (Bundle)localObject);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodGeneralDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */