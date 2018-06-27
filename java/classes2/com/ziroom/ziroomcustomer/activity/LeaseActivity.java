package com.ziroom.ziroomcustomer.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.adapter.f.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.k;
import com.ziroom.ziroomcustomer.e.e.e;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.MainFragmentActivity;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.LeaseListEntity;
import com.ziroom.ziroomcustomer.my.MyStewardInfoActivity;
import com.ziroom.ziroomcustomer.signed.LoanInfoActivity;
import com.ziroom.ziroomcustomer.signed.NewZZItemsActivity;
import com.ziroom.ziroomcustomer.signed.WaitDeliveryActivity;
import com.ziroom.ziroomcustomer.signed.ZxingActivity;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.BadgeView;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuLeaseInfoActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuContactList;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuContractItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class LeaseActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView A;
  private String B;
  private String C = null;
  private String D = null;
  private String E = null;
  private int F;
  private String G = LeaseActivity.class.getSimpleName();
  private boolean H = true;
  private boolean I = true;
  private Handler J = new Handler()
  {
    @SuppressLint({"InlinedApi"})
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 69926: 
        do
        {
          return;
        } while (!((l)localObject).getSuccess().booleanValue());
        ApplicationEx.setPackState(0, "MZCL_badge");
        ApplicationEx.setPackState(0, "MAC_badge");
        ApplicationEx.setPackState(0, "MZFC_badge");
        ApplicationEx.setPackState(0, "MZCLI_badge");
        ApplicationEx.f = false;
        new o(LeaseActivity.a(LeaseActivity.this)).toDownloadCertificate(4);
        LeaseActivity.d(LeaseActivity.this).notifyDataSetChanged();
        return;
      case 4102: 
        if (((l)localObject).getSuccess().booleanValue())
        {
          LeaseActivity.a(LeaseActivity.this, (List)((l)localObject).getObject());
          if ((LeaseActivity.e(LeaseActivity.this) != null) && (LeaseActivity.e(LeaseActivity.this).size() >= 1)) {
            if (((ApplicationEx.g == 1) || (ApplicationEx.g == 2)) && (ApplicationEx.f))
            {
              ApplicationEx.setPackState(1, "MZCL_badge");
              ApplicationEx.setPackState(1, "MZCLI_badge");
            }
          }
        }
        for (;;)
        {
          LeaseActivity.f(LeaseActivity.this);
          return;
          LeaseActivity.b(LeaseActivity.this, false);
          continue;
          LeaseActivity.b(LeaseActivity.this, false);
        }
      case 69927: 
        if (((l)localObject).getSuccess().booleanValue())
        {
          LeaseActivity.a(LeaseActivity.this, (e)((l)localObject).getObject());
          if (ae.notNull(LeaseActivity.g(LeaseActivity.this).getText())) {
            LeaseActivity.h(LeaseActivity.this).setText(LeaseActivity.g(LeaseActivity.this).getText());
          }
        }
        for (;;)
        {
          LeaseActivity.this.dismissProgress();
          return;
          LeaseActivity.h(LeaseActivity.this).setVisibility(8);
          continue;
          paramAnonymousMessage = ((l)localObject).getMessage();
          LeaseActivity.this.showToast(paramAnonymousMessage);
        }
      case 69712: 
        LeaseActivity.this.dismissProgress();
        localObject = (l)paramAnonymousMessage.obj;
        if (((l)localObject).getSuccess().booleanValue()) {
          try
          {
            JSONObject localJSONObject = new JSONObject(((l)localObject).getObject().toString()).getJSONObject("data");
            String str = localJSONObject.optString("type");
            if (!TextUtils.isEmpty(str))
            {
              if (!"2".equals(LeaseActivity.i(LeaseActivity.this))) {
                break label480;
              }
              LeaseActivity.c(LeaseActivity.this, "fwgj");
              LeaseActivity.d(LeaseActivity.this, "XYPJ2");
            }
            for (;;)
            {
              LeaseActivity.e(LeaseActivity.this, localJSONObject.optString("userAccount"));
              if (!TextUtils.isEmpty(LeaseActivity.j(LeaseActivity.this))) {
                break label571;
              }
              LeaseActivity.this.showToast("未找到当前管家信息,无法评价!");
              return;
              label480:
              if ("1".equals(LeaseActivity.i(LeaseActivity.this)))
              {
                LeaseActivity localLeaseActivity = LeaseActivity.this;
                if (!"网络管家".equals(str)) {
                  break;
                }
                paramAnonymousMessage = "salesZO";
                LeaseActivity.c(localLeaseActivity, paramAnonymousMessage);
                if ("网络管家".equals(str)) {
                  break label558;
                }
                LeaseActivity.d(LeaseActivity.this, "ZOASE2");
              }
            }
          }
          catch (Exception paramAnonymousMessage)
          {
            for (;;)
            {
              paramAnonymousMessage.printStackTrace();
              continue;
              paramAnonymousMessage = "zo";
              continue;
              label558:
              LeaseActivity.d(LeaseActivity.this, "SZOASE2");
            }
            label571:
            LeaseActivity.this.showProgress("");
            com.ziroom.ziroomcustomer.e.d.checkHasEvaluate(LeaseActivity.b(LeaseActivity.this), LeaseActivity.a(LeaseActivity.this), ApplicationEx.c.getUserId(LeaseActivity.this), "ziroomer", LeaseActivity.j(LeaseActivity.this), LeaseActivity.k(LeaseActivity.this), LeaseActivity.l(LeaseActivity.this), ((l)localObject).getCode());
            return;
          }
        }
        LeaseActivity.this.showToast(((l)localObject).getMessage());
        return;
      }
      ((BaseActivity)LeaseActivity.a(LeaseActivity.this)).dismissProgress();
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        ((BaseActivity)LeaseActivity.a(LeaseActivity.this)).showToast("您已经评价过了!");
        return;
      }
      if ("2".equals(LeaseActivity.i(LeaseActivity.this)))
      {
        localObject = new Intent(LeaseActivity.a(LeaseActivity.this), EvaluateActivity.class);
        ((Intent)localObject).putExtra("old_contract_code", paramAnonymousMessage.getCode());
        ((Intent)localObject).putExtra("questionType", LeaseActivity.l(LeaseActivity.this));
        ((Intent)localObject).putExtra("uid", LeaseActivity.j(LeaseActivity.this));
        ((Intent)localObject).putExtra("stewardType", LeaseActivity.k(LeaseActivity.this));
        ((Intent)localObject).putExtra("type", 0);
        LeaseActivity.a(LeaseActivity.this).startActivity((Intent)localObject);
        return;
      }
      localObject = new Intent(LeaseActivity.a(LeaseActivity.this), EvaluateSignActivity.class);
      ((Intent)localObject).putExtra("contractCode", paramAnonymousMessage.getCode());
      LeaseActivity.a(LeaseActivity.this).startActivity((Intent)localObject);
    }
  };
  private e K;
  private ZryuContactList L;
  private List<LeaseListEntity> a = new ArrayList();
  private ListView b;
  private LinearLayout c;
  private LinearLayout d;
  private com.ziroom.ziroomcustomer.adapter.f e;
  private Context f;
  private List<String> g;
  private ListView r;
  private boolean s = true;
  private PopupWindow t;
  private View u;
  private ImageView v;
  private ImageView w;
  private View x;
  private ImageView y;
  private BadgeView z;
  
  private void a()
  {
    this.A = ((TextView)findViewById(2131696611));
    this.d = ((LinearLayout)findViewById(2131692381));
    this.v = ((ImageView)findViewById(2131693303));
    this.u = findViewById(2131689863);
    this.w = ((ImageView)findViewById(2131691914));
    this.b = ((ListView)findViewById(2131696612));
    this.c = ((LinearLayout)findViewById(2131689818));
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.y = ((ImageView)findViewById(2131696610));
    this.z = new BadgeView(this.f, this.y, n.dip2px(this.f, 3.0F), 1);
    this.z.setBadgeMargin(0, 0);
    this.z.setBadgeBackgroundColor(Color.parseColor("#FF2914"));
    ApplicationEx.setBadgeView(this.z, "MZCL_badge");
    this.e = new com.ziroom.ziroomcustomer.adapter.f(this.a, this, false);
    this.b.setAdapter(this.e);
    this.e.setSetOnItemClick(new f.b()
    {
      public void onItem(LeaseListEntity paramAnonymousLeaseListEntity)
      {
        if (paramAnonymousLeaseListEntity.getZryuContractInfo() == null)
        {
          localIntent = new Intent(LeaseActivity.a(LeaseActivity.this), NewLeaseInfoActivity.class);
          localIntent.putExtra("contract_code", paramAnonymousLeaseListEntity.getContractCode());
          localIntent.putExtra("sysContractId", paramAnonymousLeaseListEntity.getSysContractId());
          LeaseActivity.this.startActivity(localIntent);
          return;
        }
        Intent localIntent = new Intent(LeaseActivity.this, ZryuLeaseInfoActivity.class);
        localIntent.putExtra("contractId", paramAnonymousLeaseListEntity.getZryuContractInfo().getContractId());
        localIntent.putExtra("deCode", "XQ");
        LeaseActivity.this.startActivity(localIntent);
      }
      
      public void showHousekeeper(String paramAnonymousString)
      {
        Intent localIntent = new Intent(LeaseActivity.this, MyStewardInfoActivity.class);
        localIntent.putExtra("contractCode", paramAnonymousString);
        LeaseActivity.this.startActivity(localIntent);
      }
      
      public void toEvaluatePage(String paramAnonymousString1, String paramAnonymousString2)
      {
        LeaseActivity.a(LeaseActivity.this, paramAnonymousString2);
        com.ziroom.ziroomcustomer.e.d.getRentAgentCode(LeaseActivity.b(LeaseActivity.this), LeaseActivity.a(LeaseActivity.this), paramAnonymousString1);
      }
      
      public void toIntent(final LeaseListEntity paramAnonymousLeaseListEntity, Class paramAnonymousClass)
      {
        final Intent localIntent = new Intent(LeaseActivity.a(LeaseActivity.this), paramAnonymousClass);
        localIntent.putExtra("contract_code", paramAnonymousLeaseListEntity.getContractCode());
        localIntent.putExtra("sysContractId", paramAnonymousLeaseListEntity.getSysContractId());
        localIntent.putExtra("lease", paramAnonymousLeaseListEntity.getContractCode());
        if (paramAnonymousLeaseListEntity.getIsView() == 0) {
          localIntent.putExtra("mode", "0");
        }
        while (paramAnonymousClass == LeaseConfirmPayActivity.class) {
          if (paramAnonymousLeaseListEntity.getIsZWhite() == 1)
          {
            j.checkContractHasPay(LeaseActivity.this, paramAnonymousLeaseListEntity.getContractCode(), new com.ziroom.commonlibrary.a.a(LeaseActivity.this, new k(new com.ziroom.ziroomcustomer.e.c.a.b()))
            {
              public void onFailure(Throwable paramAnonymous2Throwable)
              {
                super.onFailure(paramAnonymous2Throwable);
                com.freelxl.baselibrary.f.g.textToast(LeaseActivity.this, "获取支付状态失败！");
              }
              
              public void onSuccess(int paramAnonymous2Int, com.alibaba.fastjson.e paramAnonymous2e)
              {
                super.onSuccess(paramAnonymous2Int, paramAnonymous2e);
                if ((paramAnonymous2e != null) && (paramAnonymous2e.containsKey("hasPay")))
                {
                  if (!paramAnonymous2e.getBoolean("hasPay").booleanValue())
                  {
                    paramAnonymous2e = ApplicationEx.c.getUser();
                    if ((ApplicationEx.c.isLoginState()) && (paramAnonymous2e != null))
                    {
                      paramAnonymous2e = new HouseDetail(paramAnonymousLeaseListEntity.getHouseType() + "", paramAnonymousLeaseListEntity.getHouseCode(), paramAnonymousLeaseListEntity.getHouseId());
                      localObject = new Intent(LeaseActivity.this, LoanInfoActivity.class);
                      ((Intent)localObject).putExtra("contract_code", paramAnonymousLeaseListEntity.getContractCode());
                      if ("1".equals(paramAnonymousLeaseListEntity.getIsRenew())) {
                        ((Intent)localObject).putExtra("old_contract_code", "old_contract_code");
                      }
                      ((Intent)localObject).putExtra("is_back_pre", true);
                      ((Intent)localObject).putExtra("detail", paramAnonymous2e);
                      LeaseActivity.this.startActivity((Intent)localObject);
                    }
                    return;
                  }
                  paramAnonymous2e = paramAnonymousLeaseListEntity.getPropertyState();
                  if ((paramAnonymous2e != null) && ("yqr".equals(paramAnonymous2e))) {
                    localIntent.putExtra("wystate", "wystate");
                  }
                  if ("1".equals(paramAnonymousLeaseListEntity.getIsRenew())) {
                    localIntent.putExtra("old_contract_code", "old_contract_code");
                  }
                  paramAnonymous2e = new HouseDetail(paramAnonymousLeaseListEntity.getHouseType() + "", paramAnonymousLeaseListEntity.getHouseCode(), paramAnonymousLeaseListEntity.getHouseId());
                  localIntent.putExtra("detail", paramAnonymous2e);
                  localIntent.putExtra("contract_code", paramAnonymousLeaseListEntity.getContractCode());
                  localIntent.putExtra("cityCode", com.ziroom.ziroomcustomer.base.b.d);
                  localIntent.putExtra("contractCode", paramAnonymousLeaseListEntity.getContractCode());
                  paramAnonymous2e = paramAnonymousLeaseListEntity.getSignDate();
                  Object localObject = paramAnonymousLeaseListEntity.getStopDate();
                  localIntent.putExtra("beginData", paramAnonymous2e + "");
                  localIntent.putExtra("endData", (String)localObject + "");
                  localIntent.putExtra("sharedate", "sharedate");
                  localIntent.putExtra("signData", "signData");
                  LeaseActivity.a(LeaseActivity.this).startActivity(localIntent);
                  return;
                }
                com.freelxl.baselibrary.f.g.textToast(LeaseActivity.this, "获取支付状态失败！");
              }
            });
            return;
            if (paramAnonymousLeaseListEntity.getIsView() == 1) {
              localIntent.putExtra("mode", "1");
            }
          }
          else
          {
            paramAnonymousClass = paramAnonymousLeaseListEntity.getPropertyState();
            if ((paramAnonymousClass != null) && ("yqr".equals(paramAnonymousClass))) {
              localIntent.putExtra("wystate", "wystate");
            }
            if ("1".equals(paramAnonymousLeaseListEntity.getIsRenew())) {
              localIntent.putExtra("old_contract_code", "old_contract_code");
            }
            localIntent.putExtra("detail", new HouseDetail(paramAnonymousLeaseListEntity.getHouseType() + "", paramAnonymousLeaseListEntity.getHouseCode(), paramAnonymousLeaseListEntity.getHouseId()));
            localIntent.putExtra("contract_code", paramAnonymousLeaseListEntity.getContractCode());
            localIntent.putExtra("cityCode", com.ziroom.ziroomcustomer.base.b.d);
            localIntent.putExtra("contractCode", paramAnonymousLeaseListEntity.getContractCode());
            paramAnonymousClass = paramAnonymousLeaseListEntity.getSignDate();
            paramAnonymousLeaseListEntity = paramAnonymousLeaseListEntity.getStopDate();
            localIntent.putExtra("beginData", paramAnonymousClass + "");
            localIntent.putExtra("endData", paramAnonymousLeaseListEntity + "");
            localIntent.putExtra("sharedate", "sharedate");
            localIntent.putExtra("signData", "signData");
            LeaseActivity.a(LeaseActivity.this).startActivity(localIntent);
            return;
          }
        }
        localIntent.putExtra("contractCode", paramAnonymousLeaseListEntity.getContractCode());
        paramAnonymousClass = paramAnonymousLeaseListEntity.getSignDate();
        paramAnonymousLeaseListEntity = paramAnonymousLeaseListEntity.getStopDate();
        localIntent.putExtra("beginData", paramAnonymousClass + "");
        localIntent.putExtra("endData", paramAnonymousLeaseListEntity + "");
        localIntent.putExtra("sharedate", "sharedate");
        localIntent.putExtra("signData", "signData");
        LeaseActivity.a(LeaseActivity.this).startActivity(localIntent);
      }
      
      public void toPay(LeaseListEntity paramAnonymousLeaseListEntity)
      {
        if ("1".equals(paramAnonymousLeaseListEntity.getContractStrategy())) {
          LeaseActivity.b(LeaseActivity.this, paramAnonymousLeaseListEntity);
        }
        do
        {
          return;
          if (!"2".equals(paramAnonymousLeaseListEntity.getContractStrategy())) {
            break;
          }
          if ("0".equals(paramAnonymousLeaseListEntity.getPayFeeSource()))
          {
            LeaseActivity.c(LeaseActivity.this, paramAnonymousLeaseListEntity);
            return;
          }
          if ("1".equals(paramAnonymousLeaseListEntity.getPayFeeSource()))
          {
            LeaseActivity.b(LeaseActivity.this, paramAnonymousLeaseListEntity);
            return;
          }
        } while (!"2".equals(paramAnonymousLeaseListEntity.getPayFeeSource()));
        LeaseActivity.d(LeaseActivity.this, paramAnonymousLeaseListEntity);
        return;
        LeaseActivity.b(LeaseActivity.this, paramAnonymousLeaseListEntity);
      }
      
      public void toPropertyState(LeaseListEntity paramAnonymousLeaseListEntity)
      {
        LeaseActivity.a(LeaseActivity.this, paramAnonymousLeaseListEntity);
      }
    });
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.A.setOnClickListener(this);
  }
  
  private void a(final LeaseListEntity paramLeaseListEntity)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setContent("线下打款需要联系管家确认打款账户。").setTitle("提示").setButtonText("知道了", "联系管家").setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        LeaseActivity.b(LeaseActivity.this, paramLeaseListEntity.getContractCode());
      }
    }).show();
  }
  
  private void b()
  {
    this.g = new ArrayList();
    this.g.add("查看失效合同");
    if ((ApplicationEx.g == 1) || (ApplicationEx.g == 2)) {
      this.g.add("申请合同转签");
    }
  }
  
  private void b(final LeaseListEntity paramLeaseListEntity)
  {
    View localView1 = View.inflate(this, 2130905076, null);
    TextView localTextView1 = (TextView)localView1.findViewById(2131697360);
    TextView localTextView2 = (TextView)localView1.findViewById(2131697359);
    TextView localTextView3 = (TextView)localView1.findViewById(2131697361);
    Object localObject;
    View localView2;
    if (this.s)
    {
      this.t = new PopupWindow(localView1, -1, -1, true);
      this.t.setContentView(localView1);
      this.t.setOutsideTouchable(false);
      this.t.setFocusable(true);
      localObject = new ColorDrawable(-1342177280);
      this.t.setBackgroundDrawable((Drawable)localObject);
      localObject = this.t;
      localView2 = findViewById(2131696609);
      if (!(localObject instanceof PopupWindow)) {
        ((PopupWindow)localObject).showAtLocation(localView2, 81, 0, 0);
      }
    }
    for (this.s = false;; this.s = true)
    {
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          LeaseActivity.b(LeaseActivity.this, paramLeaseListEntity);
        }
      });
      localTextView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          LeaseActivity.d(LeaseActivity.this, paramLeaseListEntity);
        }
      });
      localTextView3.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          LeaseActivity.c(LeaseActivity.this).dismiss();
          LeaseActivity.a(LeaseActivity.this, true);
        }
      });
      localView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          LeaseActivity.c(LeaseActivity.this).dismiss();
          LeaseActivity.a(LeaseActivity.this, true);
        }
      });
      return;
      VdsAgent.showAtLocation((PopupWindow)localObject, localView2, 81, 0, 0);
      break;
      this.t.dismiss();
    }
  }
  
  private void c(final LeaseListEntity paramLeaseListEntity)
  {
    if (paramLeaseListEntity.getIsZWhite() == 1)
    {
      j.checkContractHasPay(this, paramLeaseListEntity.getContractCode(), new com.ziroom.commonlibrary.a.a(this, new k(new com.ziroom.ziroomcustomer.e.c.a.b()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          com.freelxl.baselibrary.f.g.textToast(LeaseActivity.this, "获取支付状态失败！");
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
                paramAnonymouse = new HouseDetail(paramLeaseListEntity.getHouseType() + "", paramLeaseListEntity.getHouseCode(), paramLeaseListEntity.getHouseId());
                localObject = new Intent(LeaseActivity.this, LoanInfoActivity.class);
                ((Intent)localObject).putExtra("contract_code", paramLeaseListEntity.getContractCode());
                if ("1".equals(paramLeaseListEntity.getIsRenew())) {
                  ((Intent)localObject).putExtra("old_contract_code", "old_contract_code");
                }
                ((Intent)localObject).putExtra("is_back_pre", true);
                ((Intent)localObject).putExtra("detail", paramAnonymouse);
                LeaseActivity.this.startActivity((Intent)localObject);
              }
              return;
            }
            paramAnonymouse = new Intent(LeaseActivity.a(LeaseActivity.this), HouseBillInfoActivity.class);
            paramAnonymouse.putExtra("uniqueCode", paramLeaseListEntity.getContractCode());
            paramAnonymouse.putExtra("period", "1");
            paramAnonymouse.putExtra("payType", "fz");
            Object localObject = paramLeaseListEntity.getPropertyState();
            if ((localObject != null) && ("yqr".equals(localObject))) {
              paramAnonymouse.putExtra("wystate", "wystate");
            }
            if ("1".equals(paramLeaseListEntity.getIsRenew())) {
              paramAnonymouse.putExtra("old_contract_code", "old_contract_code");
            }
            LeaseActivity.this.startActivity(paramAnonymouse);
            return;
          }
          com.freelxl.baselibrary.f.g.textToast(LeaseActivity.this, "获取支付状态失败！");
        }
      });
      return;
    }
    Intent localIntent = new Intent(this.f, HouseBillInfoActivity.class);
    localIntent.putExtra("uniqueCode", paramLeaseListEntity.getContractCode());
    localIntent.putExtra("period", "1");
    localIntent.putExtra("payType", "fz");
    String str = paramLeaseListEntity.getPropertyState();
    if ((str != null) && ("yqr".equals(str))) {
      localIntent.putExtra("wystate", "wystate");
    }
    if ("1".equals(paramLeaseListEntity.getIsRenew())) {
      localIntent.putExtra("old_contract_code", "old_contract_code");
    }
    startActivity(localIntent);
  }
  
  private void d(LeaseListEntity paramLeaseListEntity)
  {
    Intent localIntent;
    if ((paramLeaseListEntity.getPropertyState().equals("djg")) || (paramLeaseListEntity.getPropertyState().equals("ygq")))
    {
      localIntent = new Intent(this, ZxingActivity.class);
      localIntent.putExtra("contract_part_code", paramLeaseListEntity.getContractCode());
      localIntent.putExtra("lease", "lease");
      startActivity(localIntent);
    }
    do
    {
      return;
      if (paramLeaseListEntity.getPropertyState().equals("gjjgz"))
      {
        localIntent = new Intent(this, WaitDeliveryActivity.class);
        localIntent.putExtra("wuyewaitdone", "wuyewaitdone");
        localIntent.putExtra("contract_part_code", paramLeaseListEntity.getContractCode());
        startActivity(localIntent);
        return;
      }
      if (paramLeaseListEntity.getPropertyState().equals("bbh"))
      {
        localIntent = new Intent(this, WaitDeliveryActivity.class);
        localIntent.putExtra("wuyewaitdone", "wuyewaitdone");
        localIntent.putExtra("contract_part_code", paramLeaseListEntity.getContractCode());
        startActivity(localIntent);
        return;
      }
    } while (!paramLeaseListEntity.getPropertyState().equals("jgdqr"));
    if (("5".equals(paramLeaseListEntity.getHouseType() + "")) || ("8".equals(paramLeaseListEntity.getHouseType() + "")))
    {
      localIntent = new Intent(this, NewZZItemsActivity.class);
      ApplicationEx.c.addActivity(this);
    }
    for (;;)
    {
      localIntent.putExtra("wuyesure", "wuyesure");
      localIntent.putExtra("contract_part_code", paramLeaseListEntity.getContractCode());
      localIntent.putExtra("lease", "lease");
      startActivity(localIntent);
      return;
      localIntent = new Intent(this, MainFragmentActivity.class);
    }
  }
  
  private void d(String paramString)
  {
    String str = q.s + e.e.q;
    paramString = com.ziroom.ziroomcustomer.e.g.buildGetPhone(paramString);
    com.freelxl.baselibrary.f.d.e("url", str + paramString.toString());
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.d.a.post(str).params(ah.ConvertObjMap2String(paramString)).tag(this).enqueue(new com.ziroom.commonlibrary.a.a(this.f, new com.freelxl.baselibrary.d.f.c())
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
          paramAnonymouse = com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data") + "");
          if (paramAnonymouse == null) {
            break label100;
          }
          if (paramAnonymouse.get("phone") == null) {
            break label88;
          }
          ah.callPhone(LeaseActivity.a(LeaseActivity.this), paramAnonymouse.get("phone").toString());
        }
        for (;;)
        {
          dismissProgress();
          return;
          label88:
          LeaseActivity.this.showToast("获取管家手机号失败");
          continue;
          label100:
          LeaseActivity.this.showToast("获取管家手机号失败");
        }
      }
    });
  }
  
  private void e()
  {
    b();
    View localView1 = View.inflate(this, 2130905075, null);
    this.r = ((ListView)localView1.findViewById(2131691156));
    final com.ziroom.ziroomcustomer.adapter.e locale = new com.ziroom.ziroomcustomer.adapter.e(this.f, this.g);
    this.r.setAdapter(locale);
    PopupWindow localPopupWindow;
    View localView2;
    if (this.s)
    {
      this.t = new PopupWindow(localView1, -1, -2, true);
      this.t.setContentView(localView1);
      this.t.setOutsideTouchable(false);
      this.t.setFocusable(true);
      localPopupWindow = this.t;
      localView2 = this.u;
      if (!(localPopupWindow instanceof PopupWindow)) {
        localPopupWindow.showAsDropDown(localView2);
      }
    }
    for (this.s = false;; this.s = true)
    {
      localView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          LeaseActivity.c(LeaseActivity.this).dismiss();
          LeaseActivity.a(LeaseActivity.this, true);
        }
      });
      this.r.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          if ("查看失效合同".equals(locale.getmList().get(paramAnonymousInt)))
          {
            paramAnonymousAdapterView = new Intent(LeaseActivity.a(LeaseActivity.this), LeaseInvalidActivity.class);
            LeaseActivity.this.startActivity(paramAnonymousAdapterView);
            LeaseActivity.c(LeaseActivity.this).dismiss();
          }
          while (!"申请合同转签".equals(locale.getmList().get(paramAnonymousInt))) {
            return;
          }
          LeaseActivity.this.showProgress("");
          if (ApplicationEx.f)
          {
            ApplicationEx.setPackState(0, "MZCL_badge");
            ApplicationEx.setPackState(0, "MAC_badge");
            ApplicationEx.setPackState(0, "MZFC_badge");
            ApplicationEx.setPackState(0, "MZCLI_badge");
            locale.notifyDataSetChanged();
            com.ziroom.ziroomcustomer.e.d.setTurnSignStyle(LeaseActivity.b(LeaseActivity.this), "", "2", LeaseActivity.a(LeaseActivity.this));
            return;
          }
          ApplicationEx.setPackState(0, "MZCL_badge");
          ApplicationEx.setPackState(0, "MAC_badge");
          ApplicationEx.setPackState(0, "MZFC_badge");
          ApplicationEx.setPackState(0, "MZCLI_badge");
          locale.notifyDataSetChanged();
          new o(LeaseActivity.a(LeaseActivity.this)).toDownloadCertificate(4);
        }
      });
      return;
      VdsAgent.showAsDropDown((PopupWindow)localPopupWindow, localView2);
      break;
      this.t.dismiss();
    }
  }
  
  private void f()
  {
    if (checkNet(this))
    {
      j.zryuContractList(this, new com.ziroom.ziroomcustomer.e.a.c(this, new com.ziroom.ziroomcustomer.e.c.f(ZryuContactList.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          LeaseActivity.c(LeaseActivity.this, false);
          LeaseActivity.n(LeaseActivity.this);
        }
        
        public void onSuccess(int paramAnonymousInt, ZryuContactList paramAnonymousZryuContactList)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousZryuContactList);
          LeaseActivity.a(LeaseActivity.this, paramAnonymousZryuContactList);
          if ((paramAnonymousZryuContactList == null) || (paramAnonymousZryuContactList.getContractList() == null) || (paramAnonymousZryuContactList.getContractList().size() < 1)) {
            LeaseActivity.c(LeaseActivity.this, false);
          }
          LeaseActivity.n(LeaseActivity.this);
        }
      });
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  private void g()
  {
    if ((this.L != null) && (this.L.getContractList() != null) && (this.L.getContractList().size() > 0))
    {
      if (this.a == null) {
        this.a = new ArrayList();
      }
      int i = 0;
      while (i < this.L.getContractList().size())
      {
        LeaseListEntity localLeaseListEntity = new LeaseListEntity();
        localLeaseListEntity.setZryuContractInfo((ZryuContractItem)this.L.getContractList().get(i));
        this.a.add(localLeaseListEntity);
        i += 1;
      }
    }
    if ((this.a != null) && (this.a.size() >= 1))
    {
      if (this.d != null)
      {
        closeEmpty(this.d);
        this.d = null;
      }
      u.e("adapter   === ", "   =======       设置数据   ===");
      this.e.setLeaseList(this.a);
      this.e.notifyDataSetChanged();
    }
    for (;;)
    {
      dismissProgress();
      return;
      if ((!this.H) && (!this.I)) {
        this.b.setEmptyView(this.c);
      }
    }
  }
  
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
      e();
      w.onEvent(this.f, "mycontract_more");
      return;
      finish();
      return;
    } while ((this.K == null) || (!ae.notNull(this.K.getUrl())));
    startActivity(new Intent(this, TurnSignWebActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904832);
    this.f = this;
    showProgress("");
    this.F = getIntent().getIntExtra("type", 0);
    if ((this.F != 1) && (this.F != 2)) {
      this.F = 0;
    }
    com.ziroom.ziroomcustomer.e.d.getLease(this.f, this.J, "0", this.F);
    a();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if ((this.t != null) && (this.t.isShowing()))
    {
      this.t.dismiss();
      this.s = true;
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    com.ziroom.ziroomcustomer.e.d.getLease(this.f, this.J, "0", this.F);
  }
  
  public void showEmptyView(String paramString)
  {
    if (this.d == null) {}
    do
    {
      return;
      this.x = showEmptyView(this.d, paramString);
    } while (this.x == null);
    this.x.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LeaseActivity.this.showProgress("");
        com.ziroom.ziroomcustomer.e.d.getLease(LeaseActivity.a(LeaseActivity.this), LeaseActivity.b(LeaseActivity.this), "0", LeaseActivity.m(LeaseActivity.this));
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/LeaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */