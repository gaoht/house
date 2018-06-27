package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar;
import com.ziroom.ziroomcustomer.newclean.activity.GeneralOrderDetailActivity;
import com.ziroom.ziroomcustomer.newclean.activity.ModifyNewAddressActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.CleanerBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.CreateOrderBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.DatePlanListBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.FrequencyBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.NoticeBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.ServiceTimeLongBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.ValidateBean;
import com.ziroom.ziroomcustomer.payment.views.wheelview.WheelView;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.MyCleanListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeriodCleanMainActivity
  extends BaseActivity
{
  private FrequencyBean a;
  private List<ServiceTimeLongBean> b;
  @BindView(2131690043)
  Button btn;
  private ServiceTimeLongBean c;
  private String[] d;
  private com.ziroom.ziroomcustomer.newclean.d.c e;
  @BindView(2131692095)
  LabeledEditText etPeriod;
  @BindView(2131690002)
  LabeledEditText etRemark;
  @BindView(2131690987)
  LabeledEditText etTime;
  @BindView(2131692096)
  LabeledEditText etTimeLong;
  @BindView(2131692094)
  LabeledEditText etUser;
  private CleanerBean f;
  private DatePlanListBean g;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131690097)
  SimpleDraweeView ivIcon;
  @BindView(2131691228)
  MyCleanListView listNotices;
  @BindView(2131692093)
  LinearLayout llNoUser;
  @BindView(2131692089)
  LinearLayout llPlace;
  private com.freelxl.baselibrary.a.a r;
  @BindView(2131689808)
  RelativeLayout rlTitle;
  @BindView(2131691500)
  RelativeLayout rlUser;
  @BindView(2131690595)
  RatingStar rsStar;
  private List<NoticeBean> s = new ArrayList();
  @BindView(2131689506)
  ObservableScrollView scrollview;
  private String t;
  @BindView(2131690053)
  TextView tvAddress;
  @BindView(2131690666)
  TextView tvPhone;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131692090)
  TextView tvUserAge;
  @BindView(2131690912)
  TextView tvUserName;
  @BindView(2131692091)
  TextView tvUserPriace;
  @BindView(2131692092)
  TextView tvUserServiceTxt;
  private String u;
  private List<NoticeBean> v;
  @BindView(2131691501)
  View vUser;
  @BindView(2131690147)
  View view;
  private Dialog w = null;
  
  private void a()
  {
    this.r = new com.freelxl.baselibrary.a.a(this, this.s, 2130904435)
    {
      public void convert(b paramAnonymousb, NoticeBean paramAnonymousNoticeBean)
      {
        paramAnonymousb.setText(2131695534, paramAnonymousNoticeBean.getTagName());
      }
    };
    this.listNotices.setAdapter(this.r);
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodCleanMainNoticeMessage(this, new d(this, new e(NoticeBean.class))
    {
      public void onSuccess(int paramAnonymousInt, List<NoticeBean> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        PeriodCleanMainActivity.a(PeriodCleanMainActivity.this, paramAnonymousList);
        PeriodCleanMainActivity.b(PeriodCleanMainActivity.this).setDatas(PeriodCleanMainActivity.a(PeriodCleanMainActivity.this));
        PeriodCleanMainActivity.b(PeriodCleanMainActivity.this).notifyDataSetChanged();
      }
    });
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodCleanRemarkLabel(this, new d(this, new e(NoticeBean.class))
    {
      public void onSuccess(int paramAnonymousInt, List<NoticeBean> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        PeriodCleanMainActivity.b(PeriodCleanMainActivity.this, paramAnonymousList);
      }
    });
    this.scrollview.smoothScrollTo(0, 0);
    Object localObject;
    if (this.a == null)
    {
      localObject = ad.getPeriodCleanFrequency(this);
      if ((localObject != null) && ((this.a == null) || (!((FrequencyBean)localObject).getLogicCode().equals(this.a.getLogicCode()))))
      {
        this.a = ((FrequencyBean)localObject);
        this.etPeriod.setText(this.a.getName());
        this.btn.setEnabled(false);
        this.etTime.setText("");
      }
    }
    for (this.g = null;; this.g = null)
    {
      localObject = ad.getPeriodCleanTimePeriod(this);
      if (localObject != null)
      {
        this.c = ((ServiceTimeLongBean)localObject);
        this.etTimeLong.setText(this.c.getBurningTimeName());
        this.etTime.setText("");
        this.g = null;
      }
      return;
      this.etPeriod.setText(this.a.getName());
      this.btn.setEnabled(false);
      this.etTime.setText("");
    }
  }
  
  private void a(final String[] paramArrayOfString)
  {
    View localView = getLayoutInflater().inflate(2130905027, null);
    this.w = new Dialog(this, 2131427932);
    this.w.setContentView(localView, new ViewGroup.LayoutParams(-1, -2));
    final Object localObject = this.w.getWindow();
    ((Window)localObject).setWindowAnimations(2131427933);
    localObject = ((Window)localObject).getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = getWindowManager().getDefaultDisplay().getHeight();
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).height = -2;
    this.w.onWindowAttributesChanged((WindowManager.LayoutParams)localObject);
    localObject = (WheelView)localView.findViewById(2131694517);
    ((WheelView)localObject).setAdapter(new com.ziroom.ziroomcustomer.payment.views.wheelview.a(paramArrayOfString));
    ((WheelView)localObject).setVisibleItems(5);
    ((TextView)localView.findViewById(2131694514)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        PeriodCleanMainActivity.this.etTimeLong.setText(paramArrayOfString[localObject.getCurrentItem()]);
        paramAnonymousView = (ServiceTimeLongBean)PeriodCleanMainActivity.e(PeriodCleanMainActivity.this).get(localObject.getCurrentItem());
        if ((PeriodCleanMainActivity.f(PeriodCleanMainActivity.this) != null) && (!paramAnonymousView.getBurningTimeCode().equals(PeriodCleanMainActivity.f(PeriodCleanMainActivity.this).getBurningTimeCode())))
        {
          PeriodCleanMainActivity.this.btn.setEnabled(false);
          PeriodCleanMainActivity.this.etTime.setText("");
          PeriodCleanMainActivity.a(PeriodCleanMainActivity.this, null);
        }
        PeriodCleanMainActivity.a(PeriodCleanMainActivity.this, paramAnonymousView);
        ad.savePeriodCleanTimePeriod(PeriodCleanMainActivity.this, paramAnonymousView);
        PeriodCleanMainActivity.g(PeriodCleanMainActivity.this).dismiss();
      }
    });
    ((TextView)localView.findViewById(2131694513)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        PeriodCleanMainActivity.g(PeriodCleanMainActivity.this).dismiss();
      }
    });
    this.w.setCanceledOnTouchOutside(true);
    paramArrayOfString = this.w;
    if (!(paramArrayOfString instanceof Dialog))
    {
      paramArrayOfString.show();
      return;
    }
    VdsAgent.showDialog((Dialog)paramArrayOfString);
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getValidateCustomerPermission(this, new d(this, new com.ziroom.ziroomcustomer.e.c.f(ValidateBean.class))
    {
      public void onSuccess(int paramAnonymousInt, final ValidateBean paramAnonymousValidateBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousValidateBean);
        if ("0".equals(paramAnonymousValidateBean.getValidState())) {
          PeriodCleanMainActivity.c(PeriodCleanMainActivity.this);
        }
        do
        {
          return;
          if ("1".equals(paramAnonymousValidateBean.getValidState()))
          {
            com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(PeriodCleanMainActivity.this).setTitle("提示").setBtnConfirmText("去支付").setBtnCancelText("我知道了").setContent(paramAnonymousValidateBean.getMessage()).setOnConfirmClickListener(new c.b()
            {
              public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
              {
                if (paramAnonymous2Boolean)
                {
                  paramAnonymous2View = new Intent(PeriodCleanMainActivity.this, GeneralOrderDetailActivity.class);
                  paramAnonymous2View.putExtra("cleanId", paramAnonymousValidateBean.getCleanId());
                  paramAnonymous2View.putExtra("serviceInfoName", paramAnonymousValidateBean.getServiceInfoName());
                  paramAnonymous2View.putExtra("serviceInfoId", paramAnonymousValidateBean.getServiceInfoId());
                  PeriodCleanMainActivity.this.startActivity(paramAnonymous2View);
                }
              }
            }).build().show();
            return;
          }
        } while (!"2".equals(paramAnonymousValidateBean.getValidState()));
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(PeriodCleanMainActivity.this).setTitle("提示").setBtnConfirmText("联系客服").setBtnCancelText("我知道了").setContent(paramAnonymousValidateBean.getMessage()).setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
          {
            if (paramAnonymous2Boolean) {
              j.toChat(PeriodCleanMainActivity.this);
            }
          }
        }).build().show();
      }
    });
  }
  
  private void e()
  {
    String str2 = this.e.getUserName();
    String str3 = this.e.getLinkPhone();
    String str4 = this.g.getDateValue();
    String str5 = this.a.getLogicCode();
    String str6 = this.etRemark.getTag().toString();
    String str7 = this.e.getFid();
    if (this.f == null) {}
    for (String str1 = null;; str1 = this.f.getCleanerId())
    {
      com.ziroom.ziroomcustomer.newclean.periodclean.a.PeriodCleanCreateOrder(this, str2, str3, str4, str5, str6, str7, str1, this.c.getBurningTimeCode(), new d(this, new com.ziroom.ziroomcustomer.e.c.f(CreateOrderBean.class))
      {
        public void onSuccess(int paramAnonymousInt, CreateOrderBean paramAnonymousCreateOrderBean)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousCreateOrderBean);
          Intent localIntent = new Intent(PeriodCleanMainActivity.this, PeriodCleanSuccessActivity.class);
          localIntent.putExtra("orderId", paramAnonymousCreateOrderBean.getPlanOrderCode());
          PeriodCleanMainActivity.this.startActivity(localIntent);
          PeriodCleanMainActivity.this.finish();
        }
      });
      return;
    }
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getServiceTimeLong(this, new d(this, new e(ServiceTimeLongBean.class))
    {
      public void onSuccess(int paramAnonymousInt, List<ServiceTimeLongBean> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        PeriodCleanMainActivity.c(PeriodCleanMainActivity.this, paramAnonymousList);
        if (paramAnonymousList == null)
        {
          g.textToast(PeriodCleanMainActivity.this, "请求数据为空");
          return;
        }
        paramAnonymousInt = paramAnonymousList.size();
        PeriodCleanMainActivity.a(PeriodCleanMainActivity.this, new String[paramAnonymousInt]);
        while (paramAnonymousInt > 0)
        {
          PeriodCleanMainActivity.d(PeriodCleanMainActivity.this)[(paramAnonymousInt - 1)] = ((ServiceTimeLongBean)paramAnonymousList.get(paramAnonymousInt - 1)).getBurningTimeName();
          paramAnonymousInt -= 1;
        }
        PeriodCleanMainActivity.b(PeriodCleanMainActivity.this, PeriodCleanMainActivity.d(PeriodCleanMainActivity.this));
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt2)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          paramIntent = (FrequencyBean)paramIntent.getSerializableExtra("frequency");
          ad.savePeriodCleanFrequency(this, paramIntent);
        } while ((this.a != null) && (paramIntent.getLogicCode().equals(this.a.getLogicCode())));
        this.a = paramIntent;
        this.etPeriod.setText(this.a.getName());
        this.btn.setEnabled(false);
        this.etTime.setText("");
        this.g = null;
        return;
        this.t = paramIntent.getStringExtra("hotLabel");
        this.u = paramIntent.getStringExtra("otherLabel");
        if ((com.freelxl.baselibrary.f.f.isNull(this.t)) && (com.freelxl.baselibrary.f.f.isNull(this.u)))
        {
          this.etRemark.setText("");
          this.etRemark.setTag("");
          return;
        }
        if (this.t == null) {}
        for (paramIntent = "";; paramIntent = this.t.replaceAll(",", "   "))
        {
          this.etRemark.setText(paramIntent + "   " + this.u);
          this.etRemark.setTag(paramIntent + "   " + this.u);
          return;
        }
        this.g = ((DatePlanListBean)paramIntent.getSerializableExtra("datePlan"));
      } while (this.g == null);
      paramIntent = this.g.getDateName().split(" ");
      String[] arrayOfString = this.g.getDateValue().split(" ");
      if ((paramIntent.length == 2) && (arrayOfString.length == 2))
      {
        paramIntent = paramIntent[1] + arrayOfString[1] + "（" + paramIntent[0] + "开始保洁）";
        this.etTime.setText(paramIntent);
      }
      for (;;)
      {
        this.btn.setEnabled(true);
        return;
        this.etTime.setText(this.g.getDateName());
      }
      this.e = ((com.ziroom.ziroomcustomer.newclean.d.c)paramIntent.getSerializableExtra("addressList"));
    } while (this.e == null);
    this.tvPhone.setText(this.e.getLinkPhone());
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    Intent localIntent2 = getIntent();
    Intent localIntent1 = localIntent2;
    if (localIntent2 == null) {
      localIntent1 = new Intent();
    }
    localIntent1.putExtra("addressList", this.e);
    setResult(32, localIntent1);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903427);
    ButterKnife.bind(this);
    this.e = ((com.ziroom.ziroomcustomer.newclean.d.c)getIntent().getSerializableExtra("address"));
    this.a = ((FrequencyBean)getIntent().getSerializableExtra("selectFreqBean"));
    if (this.e != null)
    {
      this.tvPhone.setText(this.e.getLinkPhone());
      this.tvAddress.setText(this.e.getVillage() + this.e.getDetAddress());
    }
    this.f = ((CleanerBean)getIntent().getSerializableExtra("cleaner"));
    if (this.f == null)
    {
      this.rlUser.setVisibility(8);
      this.vUser.setVisibility(8);
      this.llNoUser.setVisibility(0);
      this.etUser.setText("系统默认推荐");
    }
    for (;;)
    {
      this.etRemark.setTag("");
      a();
      return;
      this.rlUser.setVisibility(0);
      this.llNoUser.setVisibility(8);
      this.vUser.setVisibility(0);
      this.ivIcon.setController(com.freelxl.baselibrary.f.c.frescoController(this.f.getHeadPic()));
      this.tvUserName.setText(this.f.getName());
      this.tvUserAge.setText(this.f.getAge() + "岁");
      this.tvUserPriace.setText(this.f.getNativePlace());
      this.tvUserServiceTxt.setText("共服务" + this.f.getServeNum() + "单");
      if (h.isNumber(this.f.getSocre()))
      {
        if (Math.round(Float.parseFloat(this.f.getSocre())) == 0) {}
        for (int i = 5;; i = Math.round(Float.parseFloat(this.f.getSocre())))
        {
          this.rsStar.setStarScore(i);
          break;
        }
      }
      this.rsStar.setStarScore(5);
    }
  }
  
  @OnClick({2131689492, 2131692095, 2131692096, 2131690987, 2131690002, 2131690043, 2131692089})
  public void onViewClicked(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      localObject = getIntent();
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = new Intent();
      }
      paramView.putExtra("addressList", this.e);
      setResult(32, paramView);
      finish();
      return;
    case 2131692095: 
      paramView = new Intent(this, PeriodCleanFrequencyActivity.class);
      paramView.putExtra("period", this.a);
      startActivityForResult(paramView, 16);
      return;
    case 2131692096: 
      if (this.b == null) {
        f();
      }
      for (;;)
      {
        this.btn.setEnabled(false);
        return;
        a(this.d);
      }
    case 2131690987: 
      if (this.e == null)
      {
        g.textToast(this, "未获取到地址，请重新选择地址");
        return;
      }
      if (this.a == null)
      {
        g.textToast(this, "请选择保洁周期");
        return;
      }
      if (this.c == null)
      {
        g.textToast(this, "请选择保洁时长");
        return;
      }
      localObject = new Intent(this, PeriodCleanServiceTimeSelectActivity.class);
      if (this.f == null)
      {
        paramView = "";
        ((Intent)localObject).putExtra("cleanerId", paramView);
        ((Intent)localObject).putExtra("addressId", this.e.getFid());
        if (this.f != null) {
          break label335;
        }
      }
      for (paramView = "";; paramView = this.f.getName())
      {
        ((Intent)localObject).putExtra("cleanerName", paramView);
        ((Intent)localObject).putExtra("cyclePlanFrequencyCode", this.a.getLogicCode());
        ((Intent)localObject).putExtra("ServiceTimeLong", this.c);
        startActivityForResult((Intent)localObject, 20);
        return;
        paramView = this.f.getCleanerId();
        break;
      }
    case 2131690002: 
      paramView = "";
      if (this.v != null)
      {
        localObject = this.v.iterator();
        for (paramView = ""; ((Iterator)localObject).hasNext(); paramView = paramView + ",")
        {
          NoticeBean localNoticeBean = (NoticeBean)((Iterator)localObject).next();
          paramView = paramView + localNoticeBean.getTagName();
        }
        paramView = paramView.substring(0, paramView.lastIndexOf(","));
      }
      localObject = new Intent(this, PeriodcleanMoveSpecialActivity.class);
      ((Intent)localObject).putExtra("hotLabel", paramView);
      ((Intent)localObject).putExtra("hotLabelSelect", this.t);
      ((Intent)localObject).putExtra("inputText", this.u);
      ((Intent)localObject).putExtra("inputHintText", "请输入特殊需求");
      startActivityForResult((Intent)localObject, 17);
      return;
    case 2131690043: 
      label335:
      b();
      return;
    }
    paramView = new Intent(this, ModifyNewAddressActivity.class);
    paramView.putExtra("isZhengzu", "isZhengzu");
    paramView.putExtra("modify", "modify");
    paramView.putExtra("addressList", this.e);
    startActivityForResult(paramView, 19);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */