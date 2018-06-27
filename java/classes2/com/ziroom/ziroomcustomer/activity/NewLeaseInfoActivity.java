package com.ziroom.ziroomcustomer.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.c.a;
import com.ziroom.ziroomcustomer.e.c.a.b;
import com.ziroom.ziroomcustomer.e.c.i;
import com.ziroom.ziroomcustomer.e.c.k;
import com.ziroom.ziroomcustomer.e.e.e;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.MainFragmentActivity;
import com.ziroom.ziroomcustomer.living.LeaseAllBillActivity;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.LeaseCaseRecordEntity;
import com.ziroom.ziroomcustomer.model.LeaseCaseRecordEntity.BackUpmsg;
import com.ziroom.ziroomcustomer.model.LeaseInfo;
import com.ziroom.ziroomcustomer.model.LeasePayPlan;
import com.ziroom.ziroomcustomer.my.FriendlyInvoiceListActivity;
import com.ziroom.ziroomcustomer.signed.LeaseWebActivity;
import com.ziroom.ziroomcustomer.signed.LoanInfoActivity;
import com.ziroom.ziroomcustomer.signed.NewZZItemsActivity;
import com.ziroom.ziroomcustomer.signed.SharerInformationActivity;
import com.ziroom.ziroomcustomer.signed.WaitDeliveryActivity;
import com.ziroom.ziroomcustomer.signed.ZxingActivity;
import com.ziroom.ziroomcustomer.termination.ConfirmTerminationActivity;
import com.ziroom.ziroomcustomer.termination.PaymentInformationActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NewLeaseInfoActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private String c;
  private boolean d;
  private String e;
  private String f;
  private boolean g = true;
  @BindView(2131691948)
  RelativeLayout leaseInfoApplyInvoice;
  @BindView(2131691923)
  TextView lease_contract_code;
  @BindView(2131691924)
  TextView lease_contract_state;
  @BindView(2131691943)
  LinearLayout lease_info_all_pay_ll;
  @BindView(2131691942)
  RelativeLayout lease_info_all_pay_rl;
  @BindView(2131691944)
  TextView lease_info_all_pay_tv;
  @BindView(2131691953)
  LinearLayout lease_info_cert_info_lin1;
  @BindView(2131691956)
  LinearLayout lease_info_cert_info_lin2;
  @BindView(2131691955)
  LinearLayout lease_info_cert_info_ll1;
  @BindView(2131691958)
  LinearLayout lease_info_cert_info_ll2;
  @BindView(2131691954)
  TextView lease_info_cert_info_tv1;
  @BindView(2131691957)
  TextView lease_info_cert_info_tv2;
  @BindView(2131691917)
  TextView lease_info_goods_delivery_btn;
  @BindView(2131691938)
  ImageView lease_info_goods_delivery_iv;
  @BindView(2131691936)
  LinearLayout lease_info_goods_delivery_ll;
  @BindView(2131691935)
  RelativeLayout lease_info_goods_delivery_rl;
  @BindView(2131691937)
  TextView lease_info_goods_delivery_tv;
  @BindView(2131691930)
  TextView lease_info_house_area;
  @BindView(2131691929)
  TextView lease_info_house_content;
  @BindView(2131691927)
  SimpleDraweeView lease_info_house_image;
  @BindView(2131691928)
  TextView lease_info_house_title;
  @BindView(2131691932)
  TextView lease_info_lease_date_tv;
  @BindView(2131691919)
  TextView lease_info_pay_conut_money_tv;
  @BindView(2131691934)
  TextView lease_info_pay_type_tv;
  @BindView(2131691949)
  RelativeLayout lease_info_record;
  @BindView(2131691952)
  ImageView lease_info_record_img;
  @BindView(2131691951)
  TextView lease_info_record_tv;
  @BindView(2131691945)
  RelativeLayout lease_info_sharer_rl;
  @BindView(2131691940)
  LinearLayout lease_info_show_contract_ll;
  @BindView(2131691939)
  RelativeLayout lease_info_show_contract_rl;
  @BindView(2131691915)
  TextView lease_info_title_call;
  @BindView(2131691918)
  RelativeLayout lease_info_to_pay_rl;
  @BindView(2131691922)
  LinearLayout lease_title_hint_ll;
  private PopupWindow r;
  private String s;
  private LeaseInfo t;
  private String u;
  private Handler v = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      NewLeaseInfoActivity.this.dismissProgress();
      if (locall.getSuccess().booleanValue())
      {
        paramAnonymousMessage = new Intent(NewLeaseInfoActivity.d(NewLeaseInfoActivity.this), MainActivity.class);
        NewLeaseInfoActivity.this.startActivity(paramAnonymousMessage);
        NewLeaseInfoActivity.this.finish();
      }
      for (;;)
      {
        NewLeaseInfoActivity.this.dismissProgress();
        return;
        NewLeaseInfoActivity.this.showToast(locall.getMessage());
      }
    }
  };
  
  private void a()
  {
    this.lease_contract_code.setText(this.t.getContractCode());
    Object localObject = "";
    label209:
    label244:
    label294:
    label388:
    label431:
    label476:
    String str;
    if (!"isInvalid".equals(this.c))
    {
      if (("gjjgz".equals(this.t.getPropertyState())) && ("0".equals(this.t.getIsRenew())))
      {
        localObject = "管家正在录入物业交割";
        if (!"1".equals(this.t.getContractStrategy())) {
          break label844;
        }
        this.lease_info_sharer_rl.setVisibility(0);
        if ((!"dzf".equals(this.t.getContractState())) || (!"0".equals(this.t.getIsRenew())) || (this.t.getPayPlan() == null) || (this.t.getPayPlan().size() <= 0)) {
          break label779;
        }
        if ((!ae.notNull(((LeasePayPlan)this.t.getPayPlan().get(0)).getPayFee())) || (0.0F != Float.parseFloat(((LeasePayPlan)this.t.getPayPlan().get(0)).getPayFee()))) {
          break label714;
        }
        this.lease_info_title_call.setText("关闭合同");
        this.lease_info_title_call.setVisibility(0);
      }
    }
    else
    {
      this.lease_contract_state.setText((CharSequence)localObject);
      if (!ae.notNull(this.t.getAddress())) {
        break label1014;
      }
      this.lease_info_house_title.setText(this.t.getAddress());
      if (!ae.notNull(this.t.getPriceUnit())) {
        break label1026;
      }
      this.lease_info_house_content.setText(this.t.getPrice() + this.t.getPriceUnit());
      if ((!ae.notNull(this.t.getEffectDate())) || (ae.notNull(this.t.getStopDate()))) {
        this.lease_info_lease_date_tv.setText(this.t.getEffectDate() + "至" + this.t.getStopDate());
      }
      if (!"1".equals(this.t.getIsBlank())) {
        break label1061;
      }
      this.lease_info_pay_type_tv.setText("自如白条");
      setPropertyStatus(this.lease_info_goods_delivery_tv, this.t);
      b();
      if (!ae.notNull(this.t.getWaitingPayRemind())) {
        break label1116;
      }
      this.lease_info_all_pay_tv.setText(this.t.getWaitingPayRemind());
      this.lease_info_cert_info_ll1.removeAllViews();
      if ((this.t.getContractStayManStrList() == null) || (this.t.getContractStayManStrList().size() <= 0)) {
        break label1140;
      }
      localObject = this.t.getContractStayManStrList().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        str = (String)((Iterator)localObject).next();
      } while (!ae.notNull(str));
      if (!ae.notNull(this.t.getStayManDesc())) {
        break label1128;
      }
      this.lease_info_cert_info_tv1.setText(this.t.getStayManDesc());
    }
    for (;;)
    {
      this.lease_info_cert_info_lin1.setVisibility(0);
      this.lease_info_cert_info_tv1.setVisibility(0);
      this.lease_info_cert_info_ll1.setVisibility(0);
      this.lease_info_cert_info_ll1.addView(e(str));
      break label476;
      if (("yzf".equals(this.t.getContractState())) && ("yqr".equals(this.t.getPropertyState())))
      {
        localObject = "已支付";
        break;
      }
      if (("dsh".equals(this.t.getContractState())) || ("ybh".equals(this.t.getContractState())))
      {
        localObject = "合同审核中";
        break;
      }
      if (("yqy".equals(this.t.getContractState())) || ("ysh".equals(this.t.getContractState())))
      {
        localObject = "履行中";
        break;
      }
      if ("ytz".equals(this.t.getContractState()))
      {
        localObject = "已退租";
        break;
      }
      localObject = "";
      break;
      label714:
      if ((!"djg".equals(this.t.getPropertyState())) && (!"wjg".equals(this.t.getPropertyState())))
      {
        this.lease_info_title_call.setText("联系管家");
        this.lease_info_title_call.setVisibility(0);
        break label209;
      }
      this.lease_info_title_call.setVisibility(8);
      break label209;
      label779:
      if ((!"djg".equals(this.t.getPropertyState())) && (!"wjg".equals(this.t.getPropertyState())))
      {
        this.lease_info_title_call.setText("联系管家");
        this.lease_info_title_call.setVisibility(0);
        break label209;
      }
      this.lease_info_title_call.setVisibility(8);
      break label209;
      label844:
      if ("2".equals(this.t.getContractStrategy()))
      {
        this.lease_info_sharer_rl.setVisibility(8);
        if (("dgjjg".equals(this.t.getContractState())) && (("djg".equals(this.t.getPropertyState())) || ("wjg".equals(this.t.getPropertyState()))))
        {
          this.lease_info_title_call.setText("关闭合同");
          this.lease_info_title_call.setVisibility(0);
          break label209;
        }
        if ((!"djg".equals(this.t.getPropertyState())) && (!"wjg".equals(this.t.getPropertyState())))
        {
          this.lease_info_title_call.setText("联系管家");
          this.lease_info_title_call.setVisibility(0);
          break label209;
        }
        this.lease_info_title_call.setVisibility(8);
        break label209;
      }
      this.lease_info_title_call.setVisibility(8);
      break label209;
      label1014:
      this.lease_info_house_title.setText("");
      break label244;
      label1026:
      this.lease_info_house_content.setText(this.t.getPrice() + "");
      break label294;
      label1061:
      if (1 == this.t.getIsZWhite())
      {
        this.lease_info_pay_type_tv.setText("自如分期");
        break label388;
      }
      if (this.t.getPaymentType() == null) {
        break label388;
      }
      this.lease_info_pay_type_tv.setText(f(this.t.getPaymentType()));
      break label388;
      label1116:
      this.lease_info_all_pay_tv.setText("");
      break label431;
      label1128:
      this.lease_info_cert_info_tv1.setText("");
    }
    label1140:
    this.lease_info_cert_info_ll2.removeAllViews();
    if ((this.t.getSignSubjectStrList() != null) && (this.t.getSignSubjectStrList().size() > 0))
    {
      localObject = this.t.getSignSubjectStrList().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        if (ae.notNull(str))
        {
          if (ae.notNull(this.t.getSubjectDesc())) {
            this.lease_info_cert_info_tv2.setText(this.t.getSubjectDesc());
          }
          for (;;)
          {
            this.lease_info_cert_info_lin2.setVisibility(0);
            this.lease_info_cert_info_tv2.setVisibility(0);
            this.lease_info_cert_info_ll2.setVisibility(0);
            this.lease_info_cert_info_ll2.addView(e(str));
            break;
            this.lease_info_cert_info_tv2.setText("");
          }
        }
      }
    }
    this.lease_title_hint_ll.removeAllViews();
    if ((this.t.getTips() != null) && (this.t.getTips().size() > 0))
    {
      localObject = this.t.getTips().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        this.lease_title_hint_ll.setVisibility(0);
        this.lease_title_hint_ll.addView(d(str));
      }
    }
    if ((this.t.getCaseRecord() != null) && (this.t.getCaseRecord().getIsViewCaseRecord() == 1))
    {
      this.lease_info_record.setVisibility(0);
      this.lease_info_record_tv.setText(this.t.getCaseRecord().getBackUpText());
      if (this.t.getCaseRecord().getBackUpcode() == 2)
      {
        this.lease_info_record_tv.setTextColor(Color.parseColor("#FF961E"));
        this.lease_info_record_img.setVisibility(8);
        return;
      }
      if (this.t.getCaseRecord().getBackUpcode() == 1)
      {
        this.lease_info_record_tv.setTextColor(Color.parseColor("#999999"));
        this.lease_info_record_img.setVisibility(0);
        this.lease_info_record_img.setImageResource(2130840201);
        this.lease_info_record_tv.setText(this.t.getCaseRecord().getBackUpNo());
        return;
      }
      this.lease_info_record_tv.setTextColor(Color.parseColor("#999999"));
      this.lease_info_record_img.setVisibility(0);
      this.lease_info_record_img.setImageResource(2130840219);
      return;
    }
    this.lease_info_record.setVisibility(8);
  }
  
  private void b()
  {
    String str = this.t.getPropertyState();
    if ((this.t.getIsRentback() == 1) || ("yqy".equals(this.t.getContractState())) || ("ysh".equals(this.t.getContractState())))
    {
      this.lease_info_show_contract_rl.setVisibility(0);
      this.lease_info_all_pay_rl.setVisibility(0);
      if (!"1".equals(this.t.getContractStrategy())) {
        break label511;
      }
      if (this.t.getIsRentback() != 1) {
        break label196;
      }
      this.lease_info_goods_delivery_btn.setVisibility(0);
      this.lease_info_to_pay_rl.setVisibility(8);
      if (this.t.getIsView() != 0) {
        break label152;
      }
      this.lease_info_goods_delivery_btn.setText("查看解约申请");
    }
    label152:
    label196:
    label492:
    label511:
    label620:
    label829:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                this.lease_info_show_contract_rl.setVisibility(8);
                this.lease_info_all_pay_rl.setVisibility(8);
                break;
                if (this.t.getIsView() == 1)
                {
                  this.lease_info_goods_delivery_btn.setText("办理解约");
                  return;
                }
              } while (this.t.getIsView() != 2);
              this.lease_info_goods_delivery_btn.setText("查看解约信息");
              return;
              if ("dzf".equals(this.t.getContractState()))
              {
                this.lease_info_goods_delivery_btn.setVisibility(8);
                this.lease_info_to_pay_rl.setVisibility(0);
                if (this.t.getFirstLeftFee() != null)
                {
                  this.lease_info_pay_conut_money_tv.setText("首次款项 ￥" + this.t.getFirstLeftFee());
                  return;
                }
                this.lease_info_pay_conut_money_tv.setText("首次款项 ￥");
                return;
              }
              if (!"yzf".equals(this.t.getContractState())) {
                break label492;
              }
              if ((str.equals("djg")) || (str.equals("ygq")))
              {
                this.lease_info_goods_delivery_btn.setVisibility(0);
                this.lease_info_goods_delivery_btn.setText("和管家做物业交割");
                this.lease_info_to_pay_rl.setVisibility(8);
                this.lease_info_goods_delivery_iv.setVisibility(0);
                return;
              }
              if (str.equals("gjjgz"))
              {
                this.lease_info_goods_delivery_btn.setVisibility(0);
                this.lease_info_goods_delivery_btn.setText("查看物业交割");
                this.lease_info_to_pay_rl.setVisibility(8);
                this.lease_info_goods_delivery_iv.setVisibility(0);
                return;
              }
              if (str.equals("bbh"))
              {
                this.lease_info_goods_delivery_btn.setVisibility(0);
                this.lease_info_goods_delivery_btn.setText("查看物业交割");
                this.lease_info_to_pay_rl.setVisibility(8);
                this.lease_info_goods_delivery_iv.setVisibility(0);
                return;
              }
            } while (!str.equals("jgdqr"));
            this.lease_info_goods_delivery_btn.setVisibility(0);
            this.lease_info_goods_delivery_btn.setText("去确认物业交割");
            this.lease_info_to_pay_rl.setVisibility(8);
            this.lease_info_goods_delivery_iv.setVisibility(0);
            return;
            this.lease_info_goods_delivery_btn.setVisibility(8);
            this.lease_info_to_pay_rl.setVisibility(8);
            return;
          } while (!"2".equals(this.t.getContractStrategy()));
          if (this.t.getIsRentback() != 1) {
            break label620;
          }
          this.lease_info_goods_delivery_btn.setVisibility(0);
          this.lease_info_to_pay_rl.setVisibility(8);
          if (this.t.getIsView() == 0)
          {
            this.lease_info_goods_delivery_btn.setText("查看解约申请");
            return;
          }
          if (this.t.getIsView() == 1)
          {
            this.lease_info_goods_delivery_btn.setText("办理解约");
            return;
          }
        } while (this.t.getIsView() != 2);
        this.lease_info_goods_delivery_btn.setText("查看解约信息");
        return;
        if (!"dgjjg".equals(this.t.getContractState())) {
          break label829;
        }
        if ((str.equals("djg")) || (str.equals("ygq")))
        {
          this.lease_info_goods_delivery_btn.setVisibility(0);
          this.lease_info_goods_delivery_btn.setText("和管家做物业交割");
          this.lease_info_to_pay_rl.setVisibility(8);
          this.lease_info_goods_delivery_iv.setVisibility(0);
          return;
        }
        if (str.equals("gjjgz"))
        {
          this.lease_info_goods_delivery_btn.setVisibility(0);
          this.lease_info_goods_delivery_btn.setText("查看物业交割");
          this.lease_info_to_pay_rl.setVisibility(8);
          this.lease_info_goods_delivery_iv.setVisibility(0);
          return;
        }
        if (str.equals("bbh"))
        {
          this.lease_info_goods_delivery_btn.setVisibility(0);
          this.lease_info_goods_delivery_btn.setText("查看物业交割");
          this.lease_info_to_pay_rl.setVisibility(8);
          this.lease_info_goods_delivery_iv.setVisibility(0);
          return;
        }
      } while (!str.equals("jgdqr"));
      this.lease_info_goods_delivery_btn.setVisibility(0);
      this.lease_info_goods_delivery_btn.setText("去确认物业交割");
      this.lease_info_to_pay_rl.setVisibility(8);
      this.lease_info_goods_delivery_iv.setVisibility(0);
      return;
    } while (!"dzf".equals(this.t.getContractState()));
    this.lease_info_goods_delivery_btn.setVisibility(8);
    this.lease_info_to_pay_rl.setVisibility(0);
    this.lease_info_pay_conut_money_tv.setText("首次款项 ￥" + this.t.getFirstLeftFee());
  }
  
  private void back()
  {
    Intent localIntent;
    if ("ConfirmContractActivity".equals(this.u))
    {
      localIntent = new Intent(this, MainActivity.class);
      localIntent.putExtra("FRAGMENT_TYPE", 7);
      startActivity(localIntent);
    }
    for (;;)
    {
      finish();
      return;
      if ("EnterprisePaySuccessActivity".equals(this.u))
      {
        localIntent = new Intent(this, MainActivity.class);
        localIntent.putExtra("FRAGMENT_TYPE", 7);
        startActivity(localIntent);
      }
      else if ("NewZZLivingsActivity".equals(this.u))
      {
        localIntent = new Intent(this, MainActivity.class);
        localIntent.putExtra("FRAGMENT_TYPE", 7);
        startActivity(localIntent);
      }
    }
  }
  
  private View d(String paramString)
  {
    View localView = View.inflate(this.b, 2130905208, null);
    ((TextView)localView.findViewById(2131697718)).setText(paramString);
    return localView;
  }
  
  private View e(String paramString)
  {
    View localView = View.inflate(this.b, 2130905207, null);
    ((TextView)localView.findViewById(2131697717)).setText(paramString);
    return localView;
  }
  
  private void e()
  {
    View localView1 = View.inflate(this, 2130905076, null);
    TextView localTextView1 = (TextView)localView1.findViewById(2131697360);
    TextView localTextView2 = (TextView)localView1.findViewById(2131697359);
    TextView localTextView3 = (TextView)localView1.findViewById(2131697361);
    Object localObject;
    View localView2;
    if (this.g)
    {
      this.r = new PopupWindow(localView1, -1, -1, true);
      this.r.setContentView(localView1);
      this.r.setOutsideTouchable(false);
      this.r.setFocusable(true);
      localObject = new ColorDrawable(-1342177280);
      this.r.setBackgroundDrawable((Drawable)localObject);
      localObject = this.r;
      localView2 = findViewById(2131691913);
      if (!(localObject instanceof PopupWindow)) {
        ((PopupWindow)localObject).showAtLocation(localView2, 81, 0, 0);
      }
    }
    for (this.g = false;; this.g = true)
    {
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          NewLeaseInfoActivity.a(NewLeaseInfoActivity.this);
        }
      });
      localTextView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          NewLeaseInfoActivity.b(NewLeaseInfoActivity.this);
        }
      });
      localTextView3.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          NewLeaseInfoActivity.c(NewLeaseInfoActivity.this).dismiss();
          NewLeaseInfoActivity.a(NewLeaseInfoActivity.this, true);
        }
      });
      localView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          NewLeaseInfoActivity.c(NewLeaseInfoActivity.this).dismiss();
          NewLeaseInfoActivity.a(NewLeaseInfoActivity.this, true);
        }
      });
      return;
      VdsAgent.showAtLocation((PopupWindow)localObject, localView2, 81, 0, 0);
      break;
      this.r.dismiss();
    }
  }
  
  private String f(String paramString)
  {
    if (paramString.equals("1")) {
      return "月付";
    }
    if (paramString.equals("2")) {
      return "月付";
    }
    if (paramString.equals("3")) {
      return "季付";
    }
    if (paramString.equals("6")) {
      return "半年付";
    }
    if (paramString.equals("12")) {
      return "年付";
    }
    if (paramString.equals("99")) {
      return "一次性付清";
    }
    return "";
  }
  
  private void f()
  {
    if (this.t.getIsZWhite() == 1)
    {
      j.checkContractHasPay(this.b, this.t.getContractCode(), new com.ziroom.commonlibrary.a.a(this.b, new k(new b()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          com.freelxl.baselibrary.f.g.textToast(this.b, "获取支付状态失败！");
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("hasPay")))
          {
            if (!paramAnonymouse.getBoolean("hasPay").booleanValue())
            {
              paramAnonymouse = ApplicationEx.c.getUser();
              if ((ApplicationEx.c.isLoginState()) && (paramAnonymouse != null))
              {
                paramAnonymouse = new Intent(NewLeaseInfoActivity.d(NewLeaseInfoActivity.this), LoanInfoActivity.class);
                paramAnonymouse.putExtra("detail", new HouseDetail("", NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getHouseCode() + "", NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getHouseId()));
                paramAnonymouse.putExtra("is_back_pre", true);
                paramAnonymouse.putExtra("contract_code", NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getContractCode());
                if ("1".equals(NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getIsRenew())) {
                  paramAnonymouse.putExtra("old_contract_code", "old_contract_code");
                }
                NewLeaseInfoActivity.d(NewLeaseInfoActivity.this).startActivity(paramAnonymouse);
              }
              return;
            }
            paramAnonymouse = new Intent(NewLeaseInfoActivity.d(NewLeaseInfoActivity.this), HouseBillInfoActivity.class);
            paramAnonymouse.putExtra("uniqueCode", NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getContractCode());
            paramAnonymouse.putExtra("period", "1");
            paramAnonymouse.putExtra("payType", "fz");
            String str = NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getPropertyState();
            if ((str != null) && ("yqr".equals(str))) {
              paramAnonymouse.putExtra("wystate", "wystate");
            }
            if ("1".equals(NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getIsRenew())) {
              paramAnonymouse.putExtra("old_contract_code", "old_contract_code");
            }
            NewLeaseInfoActivity.this.startActivity(paramAnonymouse);
            return;
          }
          com.freelxl.baselibrary.f.g.textToast(this.b, "获取支付状态失败！");
        }
      });
      return;
    }
    Intent localIntent = new Intent(this.b, HouseBillInfoActivity.class);
    localIntent.putExtra("uniqueCode", this.t.getContractCode());
    localIntent.putExtra("period", "1");
    localIntent.putExtra("payType", "fz");
    String str = this.t.getPropertyState();
    if ((str != null) && ("yqr".equals(str))) {
      localIntent.putExtra("wystate", "wystate");
    }
    if ("1".equals(this.t.getIsRenew())) {
      localIntent.putExtra("old_contract_code", "old_contract_code");
    }
    startActivity(localIntent);
  }
  
  private void g()
  {
    Intent localIntent;
    if ((this.t.getPropertyState().equals("djg")) || (this.t.getPropertyState().equals("ygq")))
    {
      localIntent = new Intent(this, ZxingActivity.class);
      localIntent.putExtra("contract_part_code", this.t.getContractCode());
      localIntent.putExtra("lease", "lease");
      startActivity(localIntent);
    }
    do
    {
      return;
      if (this.t.getPropertyState().equals("gjjgz"))
      {
        localIntent = new Intent(this, WaitDeliveryActivity.class);
        localIntent.putExtra("wuyewaitdone", "wuyewaitdone");
        localIntent.putExtra("contract_part_code", this.t.getContractCode());
        startActivity(localIntent);
        return;
      }
      if (this.t.getPropertyState().equals("bbh"))
      {
        localIntent = new Intent(this, WaitDeliveryActivity.class);
        localIntent.putExtra("wuyewaitdone", "wuyewaitdone");
        localIntent.putExtra("contract_part_code", this.t.getContractCode());
        startActivity(localIntent);
        return;
      }
    } while (!this.t.getPropertyState().equals("jgdqr"));
    if (("5".equals(this.t.getHouseType())) || ("8".equals(this.t.getHouseType() + "")))
    {
      localIntent = new Intent(this, NewZZItemsActivity.class);
      ApplicationEx.c.addActivity(this);
    }
    for (;;)
    {
      localIntent.putExtra("wuyesure", "wuyesure");
      localIntent.putExtra("contract_part_code", this.t.getContractCode());
      localIntent.putExtra("lease", "lease");
      startActivity(localIntent);
      return;
      localIntent = new Intent(this, MainFragmentActivity.class);
    }
  }
  
  private void h()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setContent("线下打款需要联系管家确认打款账户。").setTitle("提示").setButtonText("知道了", "联系管家").setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        if (NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getContactKeeperInfo() != null)
        {
          if (NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getContactKeeperInfo().get("phone") != null)
          {
            ah.callPhone(NewLeaseInfoActivity.d(NewLeaseInfoActivity.this), NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getContactKeeperInfo().get("phone").toString());
            return;
          }
          NewLeaseInfoActivity.this.showToast("获取管家手机号失败");
          return;
        }
        NewLeaseInfoActivity.this.showToast("获取管家手机号失败");
      }
    }).show();
  }
  
  private void i()
  {
    j.putCaseRecord(this, this.t.getContractCode(), new com.ziroom.ziroomcustomer.e.a.c(this, new i())
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        paramAnonymousString = (LeaseCaseRecordEntity)com.alibaba.fastjson.a.parseObject(paramAnonymousString, LeaseCaseRecordEntity.class);
        if (paramAnonymousString != null)
        {
          paramAnonymousString = paramAnonymousString.getBackUpmsg();
          if (paramAnonymousString != null) {
            com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(NewLeaseInfoActivity.this).setTitle(paramAnonymousString.getBackUpmsgTitle()).setContent(paramAnonymousString.getBackUpmsgContext()).setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                NewLeaseInfoActivity.f(NewLeaseInfoActivity.this);
              }
            }).build().show();
          }
        }
      }
    });
  }
  
  private void j()
  {
    this.s = (q.s + e.e.c);
    Map localMap = com.ziroom.ziroomcustomer.e.g.buildLeaseInfo(this.f, this.e);
    com.freelxl.baselibrary.f.d.e("url", this.s + localMap.toString());
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.d.a.post(this.s).params(ah.ConvertObjMap2String(localMap)).tag(this).enqueue(new com.ziroom.commonlibrary.a.a(this.b, new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
        u.e("LeaseHistoryLivingActivity", paramAnonymousThrowable.getMessage() + "");
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        com.freelxl.baselibrary.f.d.e("jsonObject", paramAnonymouse.toJSONString());
        if ("success".equals(paramAnonymouse.get("status")))
        {
          NewLeaseInfoActivity.a(NewLeaseInfoActivity.this, (LeaseInfo)com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data").toString(), LeaseInfo.class));
          NewLeaseInfoActivity.h(NewLeaseInfoActivity.this);
        }
        for (;;)
        {
          dismissProgress();
          return;
          NewLeaseInfoActivity.this.showToast(paramAnonymouse.get("error_message") + "");
        }
      }
    });
  }
  
  private void k()
  {
    this.c = getIntent().getStringExtra("isInvalid");
    this.f = getIntent().getStringExtra("contract_code");
    this.e = (getIntent().getIntExtra("sysContractId", 0) + "");
    this.u = getIntent().getStringExtra("className");
  }
  
  public void onBackPressed()
  {
    back();
  }
  
  @OnClick({2131691940, 2131691942, 2131691945, 2131691920, 2131691917, 2131691936, 2131691914, 2131691915, 2131691948, 2131691950})
  public void onClic(View paramView)
  {
    if (paramView.getId() == 2131691948) {
      if (this.t != null) {}
    }
    label623:
    do
    {
      do
      {
        return;
        paramView = new Intent(this, FriendlyInvoiceListActivity.class);
        paramView.putExtra("contractCode", this.t.getContractCode());
        startActivity(paramView);
        return;
        switch (paramView.getId())
        {
        }
        while (((!"isInvalid".equals(this.c)) || (paramView.getId() == 2131691940)) && (this.t != null)) {
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131691917: 
            if (!"和管家做物业交割".equals(((TextView)paramView).getText().toString())) {
              break label623;
            }
            paramView = new Intent(this, ZxingActivity.class);
            paramView.putExtra("contract_part_code", this.t.getContractCode());
            paramView.putExtra("lease", "lease");
            startActivity(paramView);
            return;
            if (this.t.getCaseRecord().getBackUpcode() == 1)
            {
              if (ae.notNull(this.lease_info_record_tv.getText() + ""))
              {
                ((ClipboardManager)getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", this.lease_info_record_tv.getText().toString()));
                com.freelxl.baselibrary.f.g.textToast(this.b, "已复制备案编号");
              }
            }
            else if (this.t.getCaseRecord().getBackUpcode() == 2)
            {
              i();
            }
            else if (this.t.getCaseRecord().getBackUpmsg() != null)
            {
              com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(this).setTitle(this.t.getCaseRecord().getBackUpmsg().getBackUpmsgTitle()).setContent(this.t.getCaseRecord().getBackUpmsg().getBackUpmsgContext()).setOnClickListener(new View.OnClickListener()
              {
                @Instrumented
                public void onClick(View paramAnonymousView)
                {
                  VdsAgent.onClick(this, paramAnonymousView);
                }
              }).build().show();
              continue;
              back();
              continue;
              if ("关闭合同".equals(((TextView)paramView).getText().toString()))
              {
                if (this.t == null)
                {
                  showToast("获取合同失败");
                  return;
                }
                com.ziroom.ziroomcustomer.dialog.c.newBuilder(this).setTitle("").setContent("确定要关闭合同吗？").setButtonText("取消").setSecondButtonText("确定").setCanceledOnTouchOutside(true).setOnSecondClickListener(new View.OnClickListener()
                {
                  @Instrumented
                  public void onClick(View paramAnonymousView)
                  {
                    VdsAgent.onClick(this, paramAnonymousView);
                    NewLeaseInfoActivity.this.showProgress("");
                    com.ziroom.ziroomcustomer.e.d.getModifyContractState(NewLeaseInfoActivity.g(NewLeaseInfoActivity.this), NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getContractCode(), NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getHouseId(), NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getHouseCode(), NewLeaseInfoActivity.e(NewLeaseInfoActivity.this).getHouseType(), "OPT001");
                  }
                }).build().show();
              }
              else if ("联系管家".equals(((TextView)paramView).getText().toString()))
              {
                if ((this.t != null) && (this.t.getContactKeeperInfo() != null))
                {
                  if (this.t.getContactKeeperInfo().get("phone") != null) {
                    ah.callPhone(this.b, this.t.getContactKeeperInfo().get("phone").toString());
                  } else {
                    showToast("获取管家手机号失败");
                  }
                }
                else {
                  showToast("获取管家手机号失败");
                }
              }
            }
            break;
          }
        }
        g();
        return;
        if ("查看物业交割".equals(((TextView)paramView).getText().toString()))
        {
          paramView = new Intent(this, WaitDeliveryActivity.class);
          paramView.putExtra("wuyewaitdone", "wuyewaitdone");
          paramView.putExtra("contract_part_code", this.t.getContractCode());
          startActivity(paramView);
          return;
        }
        if ("去确认物业交割".equals(((TextView)paramView).getText().toString()))
        {
          if (("5".equals(this.t.getHouseType())) || ("8".equals(this.t.getHouseType() + "")))
          {
            paramView = new Intent(this, NewZZItemsActivity.class);
            ApplicationEx.c.addActivity(this);
          }
          for (;;)
          {
            paramView.putExtra("wuyesure", "wuyesure");
            paramView.putExtra("contract_part_code", this.t.getContractCode());
            paramView.putExtra("lease", "lease");
            startActivity(paramView);
            return;
            paramView = new Intent(this, MainFragmentActivity.class);
          }
        }
        if ("查看解约申请".equals(((TextView)paramView).getText().toString()))
        {
          paramView = new Intent(this, ConfirmTerminationActivity.class);
          paramView.putExtra("contractCode", this.t.getContractCode());
          paramView.putExtra("mode", "0");
          startActivity(paramView);
          return;
        }
        if ("办理解约".equals(((TextView)paramView).getText().toString()))
        {
          paramView = new Intent(this, ConfirmTerminationActivity.class);
          paramView.putExtra("contractCode", this.t.getContractCode());
          paramView.putExtra("mode", "1");
          startActivity(paramView);
          return;
        }
        if ("查看解约信息".equals(((TextView)paramView).getText().toString()))
        {
          paramView = new Intent(this, PaymentInformationActivity.class);
          paramView.putExtra("contractCode", this.t.getContractCode());
          startActivity(paramView);
          return;
        }
      } while (!"变更租约".equals(((TextView)paramView).getText().toString()));
      paramView = new Intent(this, LeaseUpdataActivity.class);
      paramView.putExtra("lease", this.t.getContractCode());
      startActivity(paramView);
      w.onEvent(this.b, "contract_evaluate,");
      return;
      if ("1".equals(this.t.getContractStrategy()))
      {
        f();
        return;
      }
      if (!"2".equals(this.t.getContractStrategy())) {
        break;
      }
      if ("0".equals(this.t.getPayFeeSource()))
      {
        e();
        return;
      }
      if ("1".equals(this.t.getPayFeeSource()))
      {
        f();
        return;
      }
    } while (!"2".equals(this.t.getPayFeeSource()));
    h();
    return;
    f();
    return;
    if ("dzf".equals(this.t.getContractState()))
    {
      showToast("您的合同为待支付状态，支付完成才可以填写合租人信息");
      return;
    }
    if ((ae.isNull(this.t.getHaveJointRent())) || ("0".equals(this.t.getHaveJointRent())))
    {
      showToast("您已选择了无合租人信息，无法再进行更改");
      return;
    }
    selectShare();
    return;
    paramView = new Intent(this, LeaseAllBillActivity.class);
    paramView.putExtra("sysContractId", this.t.getSysContractId());
    paramView.putExtra("mContractCode", this.t.getContractCode());
    paramView.putExtra("mInvalid", this.d);
    startActivity(paramView);
    w.onEvent(this.b, "mycontract_detail_allbill");
    return;
    w.onEvent(this.b, "mycontract_detail_more_contract");
    paramView = new Intent(this, LeaseWebActivity.class);
    if (!checkNet(this))
    {
      showToast("连接服务器失败，请检查网络连接");
      return;
    }
    paramView.putExtra("houseCode", this.t.getHouseCode());
    paramView.putExtra("houseId", this.t.getHouseId());
    paramView.putExtra("houseType", this.t.getHouseType());
    paramView.putExtra("contractCode", this.t.getContractCode());
    paramView.putExtra("sysContractId", this.t.getSysContractId());
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903391);
    this.b = this;
    this.a = ButterKnife.bind(this);
    k();
    j();
  }
  
  protected void onRestart()
  {
    j();
    super.onRestart();
  }
  
  public void selectShare()
  {
    Intent localIntent = new Intent(this.b, SharerInformationActivity.class);
    localIntent.putExtra("lease", this.t.getContractCode());
    localIntent.putExtra("paycontract_code", this.t.getContractCode());
    startActivity(localIntent);
  }
  
  public void setPropertyStatus(TextView paramTextView, LeaseInfo paramLeaseInfo)
  {
    if ("1".equals(paramLeaseInfo.getIsRenew())) {
      paramTextView.setText("已确认");
    }
    do
    {
      return;
      if (paramLeaseInfo.getPropertyState() == null)
      {
        paramTextView.setText("");
        return;
      }
      if (paramLeaseInfo.getPropertyState().equals("wjg"))
      {
        paramTextView.setText("未交割");
        return;
      }
      if (paramLeaseInfo.getPropertyState().equals("djg"))
      {
        paramTextView.setText("去交割");
        return;
      }
      if (paramLeaseInfo.getPropertyState().equals("gjjgz"))
      {
        paramTextView.setText("管家交割中");
        return;
      }
      if (paramLeaseInfo.getPropertyState().equals("ygq"))
      {
        paramTextView.setText("已过期");
        return;
      }
      if (paramLeaseInfo.getPropertyState().equals("bbh"))
      {
        paramTextView.setText("被驳回");
        return;
      }
      if (paramLeaseInfo.getPropertyState().equals("jgdqr"))
      {
        paramTextView.setText("交割待确认");
        return;
      }
    } while (!paramLeaseInfo.getPropertyState().equals("yqr"));
    paramTextView.setText("已确认");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/NewLeaseInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */