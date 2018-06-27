package com.ziroom.ziroomcustomer.sublet.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.text.TextPaint;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.d.b.b;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.q;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.my.CreditWebActivity;
import com.ziroom.ziroomcustomer.sublet.model.LeaseSubletInfoEntity;
import com.ziroom.ziroomcustomer.sublet.model.LeaseSubletReserveEntity;
import com.ziroom.ziroomcustomer.sublet.widget.LeaseSubletTextView;
import com.ziroom.ziroomcustomer.termination.InitiateTerminationActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaseSubletInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Context a;
  private String b;
  private int c;
  private Unbinder d;
  private LeaseSubletInfoEntity e;
  private int f;
  private View g;
  @BindView(2131691914)
  ImageView iv_lease_back;
  @BindView(2131696683)
  TextView lease_sublet_checkin_date;
  @BindView(2131696680)
  TextView lease_sublet_estimate_price;
  @BindView(2131696684)
  TextView lease_sublet_info_name;
  @BindView(2131696685)
  TextView lease_sublet_info_phone;
  @BindView(2131696686)
  TextView lease_sublet_srequest_date;
  @BindView(2131696677)
  TextView lease_sublet_status;
  @BindView(2131696676)
  ImageView lease_sublet_status_img;
  @BindView(2131696675)
  LinearLayout lease_sublet_status_ll;
  @BindView(2131696673)
  ViewGroup lease_sublet_viewgroup;
  @BindView(2131696678)
  TextView lease_sublet_why;
  @BindView(2131696619)
  TextView lease_way;
  private TextView r;
  private TextView s;
  @BindView(2131692417)
  TextView signed_address;
  @BindView(2131692416)
  SimpleDraweeView signed_image_shade;
  private TextView t;
  @BindView(2131692414)
  RelativeLayout to_see_rl;
  @BindView(2131696682)
  TextView tv_date_title;
  private TextView u;
  private Dialog v;
  
  private void a()
  {
    com.freelxl.baselibrary.d.a.isLog(true);
    Object localObject = new HashMap();
    ((Map)localObject).put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    ((Map)localObject).put("contract_code", this.b + "");
    localObject = ah.encodeGetParams(g.getCommonHouseSign((Map)localObject));
    com.freelxl.baselibrary.d.a.get(com.ziroom.ziroomcustomer.e.q.Q + e.q.c + "?" + (String)localObject).tag(this).enqueue(new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        LeaseSubletInfoActivity.a(LeaseSubletInfoActivity.this, (LeaseSubletInfoEntity)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString(), LeaseSubletInfoEntity.class));
        if (LeaseSubletInfoActivity.a(LeaseSubletInfoActivity.this) != null)
        {
          LeaseSubletInfoActivity.b(LeaseSubletInfoActivity.this, LeaseSubletInfoActivity.a(LeaseSubletInfoActivity.this));
          return;
        }
        LeaseSubletInfoActivity.this.showToast("您暂时没有可变更操作");
      }
    });
  }
  
  private void a(LeaseSubletInfoEntity paramLeaseSubletInfoEntity)
  {
    int i = 3;
    if (paramLeaseSubletInfoEntity == null)
    {
      showToast("信息获取失败");
      return;
    }
    if (this.c != 2)
    {
      this.tv_date_title.setText("预计入住时间");
      if (ae.notNull(paramLeaseSubletInfoEntity.getArea())) {
        this.lease_way.setText(paramLeaseSubletInfoEntity.getArea() + "m²");
      }
      if (ae.notNull(paramLeaseSubletInfoEntity.getFloor()))
      {
        if (!ae.notNull(paramLeaseSubletInfoEntity.getArea())) {
          break label594;
        }
        if (!ae.notNull(paramLeaseSubletInfoEntity.getFloor_total())) {
          break label547;
        }
        this.lease_way.setText(this.lease_way.getText() + "|" + paramLeaseSubletInfoEntity.getFloor() + "/" + paramLeaseSubletInfoEntity.getFloor_total() + "层");
      }
      label155:
      if (ae.notNull(paramLeaseSubletInfoEntity.getTitle())) {
        this.signed_address.setText(paramLeaseSubletInfoEntity.getTitle() + "");
      }
      if (ae.notNull(paramLeaseSubletInfoEntity.getCustomer_phone())) {
        this.lease_sublet_info_phone.setText(paramLeaseSubletInfoEntity.getCustomer_phone() + "");
      }
      if (ae.notNull(paramLeaseSubletInfoEntity.getCustomer_name())) {
        this.lease_sublet_info_name.setText(paramLeaseSubletInfoEntity.getCustomer_name() + "");
      }
      if (ae.notNull(paramLeaseSubletInfoEntity.getCheckin_date())) {
        this.lease_sublet_checkin_date.setText(paramLeaseSubletInfoEntity.getCheckin_date() + "");
      }
      if (ae.notNull(paramLeaseSubletInfoEntity.getRequest_date())) {
        this.lease_sublet_srequest_date.setText(paramLeaseSubletInfoEntity.getRequest_date() + "");
      }
      if (ae.notNull(paramLeaseSubletInfoEntity.getEstimate_price())) {
        this.lease_sublet_estimate_price.setText(paramLeaseSubletInfoEntity.getEstimate_price() + "");
      }
      if (ae.notNull(paramLeaseSubletInfoEntity.getStatus_text())) {
        this.lease_sublet_status.setText(paramLeaseSubletInfoEntity.getStatus_text() + "");
      }
      if (!ae.notNull(paramLeaseSubletInfoEntity.getStatus_reason())) {
        break label680;
      }
      this.lease_sublet_why.setText("查看原因");
      this.lease_sublet_why.getPaint().setFlags(8);
      label460:
      if (paramLeaseSubletInfoEntity.getStatus() != 1) {
        break label692;
      }
      this.lease_sublet_status.setTextColor(Color.parseColor("#999999"));
      this.lease_sublet_status_img.setVisibility(8);
      label490:
      if (paramLeaseSubletInfoEntity.getButtons() == null) {
        break label819;
      }
      if (paramLeaseSubletInfoEntity.getButtons().size() <= 3) {
        break label806;
      }
      label510:
      a(paramLeaseSubletInfoEntity.getButtons(), i);
    }
    for (;;)
    {
      this.signed_image_shade.setController(com.freelxl.baselibrary.f.c.frescoController(paramLeaseSubletInfoEntity.getPhoto()));
      return;
      this.tv_date_title.setText("预计退租日期");
      break;
      label547:
      this.lease_way.setText(this.lease_way.getText() + "|" + paramLeaseSubletInfoEntity.getFloor() + "层");
      break label155;
      label594:
      if (ae.notNull(paramLeaseSubletInfoEntity.getFloor_total()))
      {
        this.lease_way.setText(paramLeaseSubletInfoEntity.getFloor() + "/" + paramLeaseSubletInfoEntity.getFloor_total() + "层");
        break label155;
      }
      this.lease_way.setText(paramLeaseSubletInfoEntity.getFloor() + "层");
      break label155;
      label680:
      this.lease_sublet_why.setVisibility(8);
      break label460;
      label692:
      if (paramLeaseSubletInfoEntity.getStatus() == 2)
      {
        this.lease_sublet_status.setTextColor(Color.parseColor("#FFA000"));
        this.lease_sublet_status_img.setVisibility(0);
        this.lease_sublet_status_img.setImageResource(2130838934);
        break label490;
      }
      if (paramLeaseSubletInfoEntity.getStatus() == -1)
      {
        this.lease_sublet_status.setTextColor(Color.parseColor("#999999"));
        this.lease_sublet_status_img.setVisibility(0);
        this.lease_sublet_status_img.setImageResource(2130838931);
        break label490;
      }
      this.lease_sublet_status_img.setVisibility(8);
      this.lease_sublet_status.setVisibility(8);
      this.lease_sublet_why.setVisibility(8);
      break label490;
      label806:
      i = paramLeaseSubletInfoEntity.getButtons().size();
      break label510;
      label819:
      this.lease_sublet_viewgroup.setVisibility(8);
    }
  }
  
  @SuppressLint({"NewApi"})
  private void a(List<LeaseSubletReserveEntity> paramList, int paramInt)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      int j = getWindowManager().getDefaultDisplay().getWidth();
      Object localObject1 = new ViewPager.LayoutParams();
      ((ViewPager.LayoutParams)localObject1).width = -2;
      ((ViewPager.LayoutParams)localObject1).height = -2;
      localObject1 = getLayoutInflater();
      ArrayList localArrayList = new ArrayList();
      this.lease_sublet_viewgroup.removeAllViews();
      int i = 0;
      while (i < paramList.size())
      {
        String str = ((LeaseSubletReserveEntity)paramList.get(i)).getText();
        Object localObject2 = ((LayoutInflater)localObject1).inflate(2130903664, null);
        ((TextView)((View)localObject2).findViewById(2131691097)).setText(str);
        localArrayList.add(localObject2);
        localObject2 = new LeaseSubletTextView(this);
        int k = (int)((LeaseSubletTextView)localObject2).getPaint().measureText(str);
        ((LeaseSubletTextView)localObject2).setEntity((LeaseSubletReserveEntity)paramList.get(i));
        ((LeaseSubletTextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(j / paramInt, -1));
        ((LeaseSubletTextView)localObject2).setTextSize(16.0F);
        ((LeaseSubletTextView)localObject2).setText(str);
        ((LeaseSubletTextView)localObject2).setGravity(17);
        ((LeaseSubletTextView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            int i = 0;
            for (;;)
            {
              LeaseSubletTextView localLeaseSubletTextView;
              if (i < LeaseSubletInfoActivity.this.lease_sublet_viewgroup.getChildCount())
              {
                localLeaseSubletTextView = (LeaseSubletTextView)LeaseSubletInfoActivity.this.lease_sublet_viewgroup.getChildAt(i);
                if (localLeaseSubletTextView != paramAnonymousView) {
                  break label236;
                }
                if (!"cancel".equals(localLeaseSubletTextView.getEntity().getType())) {
                  break label86;
                }
                LeaseSubletInfoActivity.this.showDialog("", localLeaseSubletTextView.getEntity().getPrompt_title(), 2);
                w.onEvent(LeaseSubletInfoActivity.c(LeaseSubletInfoActivity.this), "sublet_cancel");
              }
              label86:
              do
              {
                return;
                if ("quit".equals(localLeaseSubletTextView.getEntity().getType()))
                {
                  w.onEvent(LeaseSubletInfoActivity.c(LeaseSubletInfoActivity.this), "change_to_retreat");
                  LeaseSubletInfoActivity.this.showDialog(localLeaseSubletTextView.getEntity().getPrompt_text(), localLeaseSubletTextView.getEntity().getPrompt_title(), 1);
                  return;
                }
                if ("reserved".equals(localLeaseSubletTextView.getEntity().getType()))
                {
                  LeaseSubletInfoActivity.this.showDialog(localLeaseSubletTextView.getEntity().getPrompt_text(), localLeaseSubletTextView.getEntity().getPrompt_title(), 4);
                  w.onEvent(LeaseSubletInfoActivity.c(LeaseSubletInfoActivity.this), "subletdetail_close_advice");
                  return;
                }
              } while (!"unreserved".equals(localLeaseSubletTextView.getEntity().getType()));
              LeaseSubletInfoActivity.this.showDialog(localLeaseSubletTextView.getEntity().getPrompt_text(), localLeaseSubletTextView.getEntity().getPrompt_title(), 5);
              w.onEvent(LeaseSubletInfoActivity.c(LeaseSubletInfoActivity.this), "subletdetail_receive_consultation");
              return;
              label236:
              i += 1;
            }
          }
        });
        ((LeaseSubletTextView)localObject2).setTextColor(Color.parseColor("#444444"));
        ((LeaseSubletTextView)localObject2).setIsHorizontaline(false);
        ((LeaseSubletTextView)localObject2).setIsVerticalLine(true);
        this.lease_sublet_viewgroup.addView((View)localObject2);
        i += 1;
      }
    }
  }
  
  private void b()
  {
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("turn_id", this.e.getTurn_id() + "");
    com.freelxl.baselibrary.d.a.post(com.ziroom.ziroomcustomer.e.q.Q + e.q.e).tag(this).params(g.getCommonHouseSign(localHashMap)).enqueue(new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        paramAnonymouse = new Intent(LeaseSubletInfoActivity.c(LeaseSubletInfoActivity.this), InitiateTerminationActivity.class);
        paramAnonymouse.putExtra("contractCode", LeaseSubletInfoActivity.e(LeaseSubletInfoActivity.this));
        LeaseSubletInfoActivity.this.startActivity(paramAnonymouse);
        LeaseSubletInfoActivity.this.finish();
        ApplicationEx.c.finishAllActivity();
      }
    });
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 1) {}
    for (String str = com.ziroom.ziroomcustomer.e.q.Q + e.q.j;; str = com.ziroom.ziroomcustomer.e.q.Q + e.q.k)
    {
      com.freelxl.baselibrary.d.a.isLog(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
      localHashMap.put("contract_code", this.b + "");
      com.freelxl.baselibrary.d.a.post(str).tag(this).params(g.getCommonHouseSign(localHashMap)).enqueue(new f(this, new com.ziroom.ziroomcustomer.e.c.q(e.class))
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          u.d("OKHttp", "===" + paramAnonymouse.toString());
          LeaseSubletInfoActivity.b(LeaseSubletInfoActivity.this);
        }
      });
      return;
    }
  }
  
  private void e()
  {
    if (this.e == null) {
      return;
    }
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("turn_id", this.e.getTurn_id() + "");
    com.freelxl.baselibrary.d.a.post(com.ziroom.ziroomcustomer.e.q.Q + e.q.d).tag(this).params(g.getCommonHouseSign(localHashMap)).enqueue(new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        LeaseSubletInfoActivity.this.finish();
        ApplicationEx.c.finishAllActivity();
      }
    });
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    finish();
    ApplicationEx.c.finishAllActivity();
  }
  
  @OnClick({2131691914, 2131696669, 2131696670, 2131696667, 2131696675, 2131692414, 2131696678, 2131696665})
  public void onClic(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131696669: 
    default: 
    case 2131696665: 
    case 2131692414: 
    case 2131696675: 
    case 2131696678: 
    case 2131696670: 
      do
      {
        do
        {
          do
          {
            return;
            paramView = new Intent(this.a, CreditWebActivity.class);
            paramView.putExtra("url", "http://zhuanti.ziroom.com/zhuanti/2017/zrk/zhuanzu/index.html");
            paramView.putExtra("title", "详细转租流程");
            startActivity(paramView);
            return;
            if (this.e.getDetail() == 1)
            {
              paramView = new Intent(this.a, RentHouseDetailActivity.class);
              paramView.putExtra("house_id", this.e.getHouse_id());
              paramView.putExtra("id", this.e.getRoom_id());
              startActivity(paramView);
              w.onEvent(this.a, "subletdetail_housedetail ");
              return;
            }
            if (this.e.getStatus() == -1)
            {
              showToast("审核未通过，无法查看房源详情");
              return;
            }
            showToast("审核通过后预计需要30分钟可以查看详情");
            return;
          } while (!ae.notNull(this.e.getStatus_reason()));
          showDialog(this.e.getStatus_reason(), "", 3);
          return;
        } while (!ae.notNull(this.e.getStatus_reason()));
        showDialog(this.e.getStatus_reason(), "", 3);
        return;
      } while ((this.e == null) || (!ae.notNull(this.e.getQuit_text())));
      return;
    case 2131691914: 
      finish();
      ApplicationEx.c.finishAllActivity();
      return;
    }
    paramView = new Intent(this.a, LeaseSubletSelectTimeActivity.class);
    paramView.putExtra("lease", this.b);
    paramView.putExtra("version", this.c);
    startActivity(paramView);
    ApplicationEx.c.addActivity(this);
    w.onEvent(this.a, "subletdetail_modify ");
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131697639: 
      if (this.f == 1)
      {
        b();
        w.onEvent(this.a, "change_to_retreat_yes");
      }
      while (this.v != null)
      {
        this.v.dismiss();
        return;
        if (this.f == 2)
        {
          w.onEvent(this.a, "sublet_cancel_yes");
          e();
        }
        else if (this.f == 3)
        {
          this.v.dismiss();
        }
        else if (this.f == 4)
        {
          w.onEvent(this.a, "subletdetail_close_advice_sure");
          b(1);
        }
        else if (this.f == 5)
        {
          w.onEvent(this.a, "subletdetail_receive_consultation_sure");
          b(2);
        }
      }
    }
    this.v.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904839);
    this.a = this;
    this.d = ButterKnife.bind(this);
    this.b = getIntent().getStringExtra("contract_code");
    this.c = getIntent().getIntExtra("version", 0);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.d.unbind();
    if (this.v != null)
    {
      this.v.dismiss();
      this.v = null;
    }
  }
  
  public void showDialog(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString1;
    if (ae.isNull(paramString1)) {
      str = "";
    }
    paramString1 = paramString2;
    if (ae.isNull(paramString2)) {
      paramString1 = "";
    }
    this.g = View.inflate(this.a, 2130905165, null);
    this.r = ((TextView)this.g.findViewById(2131697639));
    this.u = ((TextView)this.g.findViewById(2131697638));
    this.t = ((TextView)this.g.findViewById(2131697637));
    this.s = ((TextView)this.g.findViewById(2131697634));
    this.r.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.s.setVisibility(8);
    this.r.setVisibility(0);
    this.u.setVisibility(0);
    this.t.setGravity(17);
    this.f = paramInt;
    if (paramInt == 1)
    {
      this.r.setText("确定");
      this.u.setText("我在想想");
      this.t.setText(str);
      this.s.setText(paramString1);
      this.s.setVisibility(0);
    }
    if (paramInt == 2)
    {
      this.u.setVisibility(0);
      this.u.setText("我再想想");
      this.r.setText("确定");
      this.t.setText(paramString1);
      this.t.setVisibility(0);
    }
    if (paramInt == 3)
    {
      this.s.setVisibility(0);
      this.s.setText("未通过原因");
      this.r.setVisibility(8);
      this.u.setText("知道了");
      this.t.setText(str);
    }
    if (paramInt == 4)
    {
      this.u.setVisibility(0);
      this.u.setText("我再想想");
      this.r.setText("确定");
      this.t.setText(str);
      this.s.setText(paramString1);
      this.s.setVisibility(0);
    }
    if (paramInt == 5)
    {
      this.u.setVisibility(0);
      this.u.setText("我再想想");
      this.r.setText("确定");
      this.t.setText(paramString1);
      this.s.setVisibility(8);
    }
    if (this.v == null)
    {
      this.v = new Dialog(this.a, 2131427781);
      this.v.setContentView(this.g);
      this.v.setCanceledOnTouchOutside(false);
      this.v.setCancelable(false);
      paramString1 = this.v;
      if ((paramString1 instanceof Dialog)) {
        break label510;
      }
      paramString1.show();
    }
    for (;;)
    {
      ApplicationEx.g = 2;
      this.v.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          LeaseSubletInfoActivity.a(LeaseSubletInfoActivity.this, null);
          if (LeaseSubletInfoActivity.d(LeaseSubletInfoActivity.this) != null) {
            LeaseSubletInfoActivity.d(LeaseSubletInfoActivity.this).dismiss();
          }
          LeaseSubletInfoActivity.a(LeaseSubletInfoActivity.this, null);
        }
      });
      return;
      label510:
      VdsAgent.showDialog((Dialog)paramString1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/LeaseSubletInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */