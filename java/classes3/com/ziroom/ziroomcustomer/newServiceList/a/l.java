package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinOrderDetailsActivity;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.RentNewDetailActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairNewDetailActivity_New;
import com.ziroom.ziroomcustomer.newclean.activity.CleanIndexActivity;
import com.ziroom.ziroomcustomer.newclean.activity.GeneralOrderDetailActivity;
import com.ziroom.ziroomcustomer.newclean.activity.WeekCleanDetailActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodCleanerOrderDetailActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodGeneralDetailActivity;
import com.ziroom.ziroomcustomer.newmovehouse.mvp.OrderDetailActivity;
import com.ziroom.ziroomcustomer.newrepair.activity.UrgencyRepairActivity;
import com.ziroom.ziroomcustomer.util.n;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

public class l
  extends BaseAdapter
{
  private Context a;
  private List<com.ziroom.ziroomcustomer.newServiceList.model.j> b;
  private com.ziroom.ziroomcustomer.newServiceList.model.j c;
  
  public l(Context paramContext, List<com.ziroom.ziroomcustomer.newServiceList.model.j> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private String a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    String str = "";
    if (paramBoolean1) {
      str = "去支付";
    }
    if (paramBoolean2) {
      str = "去评价";
    }
    if (paramBoolean3) {
      str = "再次预约";
    }
    if (paramBoolean4) {
      str = "改约";
    }
    if (paramBoolean5) {
      str = "催单";
    }
    if (paramBoolean6) {
      str = "去确认";
    }
    if (paramBoolean7) {
      str = "去验收";
    }
    return str;
  }
  
  private void a(a parama, final com.ziroom.ziroomcustomer.newServiceList.model.j paramj)
  {
    int i;
    if (paramj.getBusiCode() == 1003)
    {
      parama.p.setVisibility(8);
      parama.u.setVisibility(0);
      if (TextUtils.isEmpty(paramj.getDeliveryMode()))
      {
        parama.v.setText("");
        i = 0;
        if (paramj.getPayStatus() != null)
        {
          if (paramj.getPayStatus().intValue() != 1) {
            break label185;
          }
          i = 0;
        }
        label68:
        if (i == 0) {
          break label264;
        }
        if (TextUtils.isEmpty(paramj.getDeliveryDetails())) {
          break label190;
        }
        parama.w.setVisibility(0);
        parama.w.setText(paramj.getDeliveryDetails() + "");
        label119:
        if (paramj.getEvaluateStatus() != null)
        {
          if (paramj.getEvaluateStatus().intValue() != 1) {
            break label202;
          }
          parama.w.setVisibility(0);
          parama.w.setText("去评价");
        }
      }
      for (;;)
      {
        parama.w.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(l.c(l.this), YouPinOrderDetailsActivity.class);
            paramAnonymousView.putExtra("orderCode", paramj.getOrderId());
            paramAnonymousView.putExtra("imgUrl", paramj.getSkuImgUrl());
            l.c(l.this).startActivity(paramAnonymousView);
          }
        });
        return;
        parama.v.setText(paramj.getDeliveryMode());
        break;
        label185:
        i = 1;
        break label68;
        label190:
        parama.w.setVisibility(8);
        break label119;
        label202:
        if (!TextUtils.isEmpty(paramj.getDeliveryDetails()))
        {
          parama.w.setVisibility(0);
          parama.w.setText(paramj.getDeliveryDetails() + "");
        }
        else
        {
          parama.w.setVisibility(8);
          continue;
          label264:
          parama.w.setVisibility(0);
          parama.w.setText("去支付");
        }
      }
    }
    parama.p.setVisibility(0);
    parama.u.setVisibility(8);
    int j;
    label326:
    boolean bool1;
    label350:
    boolean bool2;
    label374:
    boolean bool6;
    boolean bool5;
    boolean bool3;
    if (!TextUtils.isEmpty(paramj.getEmployeeName()))
    {
      i = 1;
      if (TextUtils.isEmpty(paramj.getEmployeePhone())) {
        break label824;
      }
      j = 1;
      bool1 = false;
      if (paramj.getPayStatus() != null)
      {
        if (paramj.getPayStatus().intValue() != 1) {
          break label830;
        }
        bool1 = true;
      }
      bool2 = false;
      if (paramj.getEvaluateStatus() != null)
      {
        if (paramj.getEvaluateStatus().intValue() != 1) {
          break label836;
        }
        bool2 = true;
      }
      bool6 = false;
      bool5 = false;
      if (paramj.getReminderStatus() != null)
      {
        if (paramj.getReminderStatus().intValue() != 1) {
          break label842;
        }
        bool3 = true;
        label401:
        bool5 = bool3;
      }
      if (paramj.getRescheduleStatus() != null)
      {
        if (paramj.getRescheduleStatus().intValue() != 1) {
          break label848;
        }
        bool3 = true;
        label426:
        bool6 = bool3;
      }
      if (paramj.getBusiCode() != 1004) {
        break label1105;
      }
    }
    label553:
    label577:
    label661:
    label681:
    label824:
    label830:
    label836:
    label842:
    label848:
    label860:
    label866:
    label873:
    label894:
    label906:
    label965:
    label1074:
    label1105:
    for (int k = 1;; k = 0)
    {
      if ((paramj.getBusiCode() == 1100) && ((paramj.getStatusCode() == 1005) || (paramj.getStatusCode() == 1006))) {}
      for (boolean bool7 = true;; bool7 = false)
      {
        if (((paramj.getBusiCode() == 1001) || (paramj.getBusiCode() == 1301)) && ((paramj.getStatusCode() == 1004) || (paramj.getStatusCode() == 1005) || (paramj.getStatusCode() == 1006))) {}
        for (int m = 0;; m = 1)
        {
          bool3 = false;
          boolean bool4;
          final String str;
          if (paramj.getConfirmStatus() != null)
          {
            if (paramj.getConfirmStatus().intValue() == 1) {
              bool3 = true;
            }
          }
          else
          {
            bool4 = false;
            if (paramj.getAcceptanceStatus() != null)
            {
              if (paramj.getAcceptanceStatus().intValue() != 1) {
                break label860;
              }
              bool4 = true;
            }
            if ((i == 0) && (!bool1) && (!bool2) && (!bool7) && (!bool6) && (!bool5) && (!bool3) && (!bool4)) {
              break label1074;
            }
            parama.p.setVisibility(0);
            parama.o.setVisibility(0);
            if (i == 0) {
              break label873;
            }
            parama.k.setVisibility(0);
            parama.l.setVisibility(0);
            if (k == 0) {
              break label866;
            }
            str = "处理人";
            parama.k.setText(str);
            parama.l.setText(paramj.getEmployeeName());
            if ((j == 0) || (m == 0)) {
              break label965;
            }
            if ((!bool1) && (!bool2) && (!bool7) && (!bool6) && (!bool5) && (!bool3) && (!bool4)) {
              break label906;
            }
            parama.m.setVisibility(0);
            parama.n.setVisibility(0);
            str = a(bool1, bool2, bool7, bool6, bool5, bool3, bool4);
            parama.m.setText(str);
            parama.m.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                if ((paramj.getBusiCode() == 1100) && ("再次预约".equals(str)))
                {
                  paramAnonymousView = new Intent(l.c(l.this), CleanIndexActivity.class);
                  paramAnonymousView.putExtra("ServiceInfoId", paramj.getServiceTypeCode());
                  paramAnonymousView.putExtra("ServiceInfoName", paramj.getServiceType());
                  l.c(l.this).startActivity(paramAnonymousView);
                  return;
                }
                l.b(l.this, paramj);
              }
            });
            if (k == 0) {
              break label894;
            }
            parama.n.setText("联系处理人");
          }
          for (;;)
          {
            com.ziroom.ziroomcustomer.newServiceList.utils.j.setToWorker(this.a, paramj.getEmployeePhone(), parama.n);
            return;
            i = 0;
            break;
            j = 0;
            break label326;
            bool1 = false;
            break label350;
            bool2 = false;
            break label374;
            bool3 = false;
            break label401;
            bool3 = false;
            break label426;
            bool3 = false;
            break label553;
            bool4 = false;
            break label577;
            str = "上门师傅";
            break label661;
            parama.k.setVisibility(8);
            parama.l.setVisibility(8);
            break label681;
            parama.n.setText("联系师傅");
          }
          parama.m.setVisibility(0);
          parama.n.setVisibility(8);
          if (k != 0) {
            parama.m.setText("联系处理人");
          }
          for (;;)
          {
            com.ziroom.ziroomcustomer.newServiceList.utils.j.setToWorker(this.a, paramj.getEmployeePhone(), parama.m);
            return;
            parama.m.setText("联系师傅");
          }
          if ((bool1) || (bool2) || (bool7) || (bool6) || (bool5))
          {
            parama.m.setVisibility(0);
            parama.n.setVisibility(8);
            str = a(bool1, bool2, bool7, bool6, bool5, bool3, bool4);
            parama.m.setText(str);
            parama.m.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                if ((paramj.getBusiCode() == 1100) && ("再次预约".equals(str)))
                {
                  paramAnonymousView = new Intent(l.c(l.this), CleanIndexActivity.class);
                  paramAnonymousView.putExtra("ServiceInfoId", paramj.getServiceTypeCode());
                  paramAnonymousView.putExtra("ServiceInfoName", paramj.getServiceType());
                  l.c(l.this).startActivity(paramAnonymousView);
                  return;
                }
                l.b(l.this, paramj);
              }
            });
            return;
          }
          parama.m.setVisibility(8);
          parama.n.setVisibility(8);
          return;
          parama.p.setVisibility(8);
          parama.o.setVisibility(8);
          return;
        }
      }
    }
  }
  
  private void a(a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    label24:
    label37:
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean1)
    {
      parama.q.setVisibility(0);
      if (!paramBoolean2) {
        break label152;
      }
      parama.r.setVisibility(0);
      if (!paramBoolean3) {
        break label164;
      }
      parama.s.setVisibility(0);
      if (!paramBoolean4) {
        break label176;
      }
      parama.j.setVisibility(0);
      localLayoutParams = (RelativeLayout.LayoutParams)parama.c.getLayoutParams();
      localLayoutParams.rightMargin = n.dip2px(this.a, 80.0F);
      parama.c.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      parama.d.setText(paramString1);
      parama.e.setText(paramString2);
      parama.f.setText(paramString3);
      parama.g.setText(paramString4);
      parama.h.setText(paramString5);
      parama.i.setText(paramString6);
      return;
      parama.q.setVisibility(8);
      break;
      label152:
      parama.r.setVisibility(8);
      break label24;
      label164:
      parama.s.setVisibility(8);
      break label37;
      label176:
      parama.j.setVisibility(8);
      localLayoutParams = (RelativeLayout.LayoutParams)parama.c.getLayoutParams();
      localLayoutParams.rightMargin = n.dip2px(this.a, 0.0F);
      parama.c.setLayoutParams(localLayoutParams);
    }
  }
  
  private void a(com.ziroom.ziroomcustomer.newServiceList.model.j paramj)
  {
    if (paramj.getBusiCode() == 1301) {
      if ("8a908eb161d66afc0161fa59fd210009".equals(paramj.getServiceTypeCode()))
      {
        localObject1 = new Intent(this.a, OrderDetailActivity.class);
        ((Intent)localObject1).putExtra("orderId", paramj.getOrderId());
        ((Intent)localObject1).putExtra("moveOrderType", "move_xiaomian");
        this.a.startActivity((Intent)localObject1);
      }
    }
    do
    {
      do
      {
        return;
        if (paramj.getBusiCode() != 1001) {
          break;
        }
        if ("2c9085f248ba3f3a0148bb156f6e0004".equals(paramj.getServiceTypeCode()))
        {
          localObject1 = new Intent(this.a, OrderDetailActivity.class);
          ((Intent)localObject1).putExtra("orderId", paramj.getOrderId());
          ((Intent)localObject1).putExtra("moveOrderType", "move_small");
          this.a.startActivity((Intent)localObject1);
          return;
        }
      } while (!"8a90a5f8593e65b501593e65b5200000".equals(paramj.getServiceTypeCode()));
      localObject1 = new Intent(this.a, OrderDetailActivity.class);
      ((Intent)localObject1).putExtra("orderId", paramj.getOrderId());
      ((Intent)localObject1).putExtra("moveOrderType", "move_van");
      this.a.startActivity((Intent)localObject1);
      return;
      if (paramj.getBusiCode() == 1100)
      {
        localObject1 = new Intent(this.a, GeneralOrderDetailActivity.class);
        ((Intent)localObject1).putExtra("cleanId", paramj.getOrderId());
        ((Intent)localObject1).putExtra("serviceInfoId", paramj.getServiceTypeCode());
        ((Intent)localObject1).putExtra("serviceInfoName", paramj.getServiceType());
        ((Intent)localObject1).putExtra("orderState", paramj.getStatusCode());
        this.a.startActivity((Intent)localObject1);
        return;
      }
      if (paramj.getBusiCode() == 1200)
      {
        localObject1 = new Intent(this.a, PeriodCleanerOrderDetailActivity.class);
        ((Intent)localObject1).putExtra("orderId", paramj.getOrderId());
        ((Intent)localObject1).putExtra("serviceInfoId", paramj.getServiceTypeCode());
        ((Intent)localObject1).putExtra("serviceInfoName", paramj.getServiceType());
        ((Intent)localObject1).putExtra("orderState", paramj.getStatusCode());
        this.a.startActivity((Intent)localObject1);
        return;
      }
      if (paramj.getBusiCode() == 1101)
      {
        localObject1 = new Intent(this.a, PeriodGeneralDetailActivity.class);
        ((Intent)localObject1).putExtra("cleanId", paramj.getOrderId());
        ((Intent)localObject1).putExtra("serviceInfoId", paramj.getServiceTypeCode());
        ((Intent)localObject1).putExtra("serviceInfoName", paramj.getServiceType());
        ((Intent)localObject1).putExtra("orderState", paramj.getStatusCode());
        this.a.startActivity((Intent)localObject1);
        return;
      }
      if (paramj.getBusiCode() != 1000) {
        break;
      }
    } while (TextUtils.isEmpty(paramj.getContract()));
    Intent localIntent = new Intent(this.a, WeekCleanDetailActivity.class);
    localIntent.putExtra("billId", paramj.getOrderId());
    Object localObject5 = ApplicationEx.c.getContracts();
    Object localObject1 = "";
    String str1 = "";
    Object localObject2 = "";
    Object localObject3 = localObject2;
    String str2 = str1;
    Object localObject4 = localObject1;
    if (localObject5 != null)
    {
      localObject3 = localObject2;
      str2 = str1;
      localObject4 = localObject1;
      if (((List)localObject5).size() > 0)
      {
        localObject5 = ((List)localObject5).iterator();
        label556:
        localObject3 = localObject2;
        str2 = str1;
        localObject4 = localObject1;
        if (((Iterator)localObject5).hasNext())
        {
          localObject3 = (Contract)((Iterator)localObject5).next();
          if (!paramj.getContract().equals(((Contract)localObject3).getHire_contract_code())) {
            break label963;
          }
          localObject2 = ((Contract)localObject3).getOld_contract_code();
          str1 = ((Contract)localObject3).getHire_contract_code();
          localObject1 = ((Contract)localObject3).getAddress();
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label556;
      localIntent.putExtra("rentContractCode", (String)localObject4);
      localIntent.putExtra("hireContractCode", str2);
      localIntent.putExtra("contractAddress", (String)localObject3);
      paramj = ApplicationEx.c.getUser();
      if (paramj != null)
      {
        localIntent.putExtra("uid", paramj.getUid());
        localIntent.putExtra("phone", paramj.getPhone());
        localIntent.putExtra("name", paramj.getRealName());
      }
      this.a.startActivity(localIntent);
      return;
      if (paramj.getBusiCode() == 1004)
      {
        localObject1 = new Intent(this.a, RentNewDetailActivity.class);
        ((Intent)localObject1).putExtra("serviceProjectId", paramj.getOrderId());
        this.a.startActivity((Intent)localObject1);
        return;
      }
      if (paramj.getBusiCode() == 1002)
      {
        if ("1011".equals(paramj.getServiceTypeCode()))
        {
          localObject1 = new Intent(this.a, UrgencyRepairActivity.class);
          ((Intent)localObject1).putExtra("orderCode", paramj.getOrderId());
          ((Intent)localObject1).putExtra("isReminderStatus", paramj.getReminderStatus());
          this.a.startActivity((Intent)localObject1);
          return;
        }
        if (!"1010".equals(paramj.getServiceTypeCode())) {
          break;
        }
        localObject1 = new Intent(this.a, RepairNewDetailActivity_New.class);
        ((Intent)localObject1).putExtra("serviceType", "付费维修");
        ((Intent)localObject1).putExtra("maintainOrderCode", paramj.getOrderId());
        this.a.startActivity((Intent)localObject1);
        return;
      }
      if (paramj.getBusiCode() != 1003) {
        break;
      }
      localObject1 = new Intent(this.a, YouPinOrderDetailsActivity.class);
      ((Intent)localObject1).putExtra("orderCode", paramj.getOrderId());
      ((Intent)localObject1).putExtra("imgUrl", paramj.getSkuImgUrl());
      this.a.startActivity((Intent)localObject1);
      return;
      label963:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904507, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690367));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695631));
      paramViewGroup.c = ((LinearLayout)paramView.findViewById(2131691838));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131695632));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131695633));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131695634));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131695635));
      paramViewGroup.h = ((TextView)paramView.findViewById(2131695637));
      paramViewGroup.i = ((TextView)paramView.findViewById(2131695638));
      paramViewGroup.j = ((SimpleDraweeView)paramView.findViewById(2131695639));
      paramViewGroup.k = ((TextView)paramView.findViewById(2131695641));
      paramViewGroup.l = ((TextView)paramView.findViewById(2131695642));
      paramViewGroup.m = ((TextView)paramView.findViewById(2131695643));
      paramViewGroup.n = ((TextView)paramView.findViewById(2131695644));
      paramViewGroup.o = paramView.findViewById(2131695640);
      paramViewGroup.p = ((RelativeLayout)paramView.findViewById(2131695451));
      paramViewGroup.q = ((RelativeLayout)paramView.findViewById(2131692500));
      paramViewGroup.r = ((RelativeLayout)paramView.findViewById(2131692502));
      paramViewGroup.s = ((RelativeLayout)paramView.findViewById(2131695636));
      paramViewGroup.t = paramView.findViewById(2131690379);
      paramViewGroup.u = ((RelativeLayout)paramView.findViewById(2131695645));
      paramViewGroup.v = ((TextView)paramView.findViewById(2131695646));
      paramViewGroup.w = ((TextView)paramView.findViewById(2131695647));
      paramView.setTag(paramViewGroup);
      this.c = ((com.ziroom.ziroomcustomer.newServiceList.model.j)this.b.get(paramInt));
      if (paramInt != 0) {
        break label516;
      }
      paramViewGroup.t.setVisibility(0);
      label378:
      paramViewGroup.a.setText(this.c.getServiceType());
      paramViewGroup.b.setText(this.c.getStatus());
      if (this.c.getStatusCode() != 1003) {
        break label528;
      }
      paramViewGroup.b.setTextColor(-40350);
      label429:
      if (this.c.getBusiCode() != 1301) {
        break label567;
      }
      a(paramViewGroup, true, true, true, false, "上门时间", this.c.getServerTime(), "搬出地址", this.c.getStartAddress(), "搬入地址", this.c.getEndAddress());
    }
    for (;;)
    {
      a(paramViewGroup, this.c);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          l.a(l.this, (com.ziroom.ziroomcustomer.newServiceList.model.j)l.a(l.this).get(paramInt));
          l.b(l.this, l.b(l.this));
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label516:
      paramViewGroup.t.setVisibility(8);
      break label378;
      label528:
      if (this.c.getStatusCode() == 1005)
      {
        paramViewGroup.b.setTextColor(-6710887);
        break label429;
      }
      paramViewGroup.b.setTextColor(-10066330);
      break label429;
      label567:
      if (this.c.getBusiCode() == 1001)
      {
        a(paramViewGroup, true, true, true, false, "上门时间", this.c.getServerTime(), "搬出地址", this.c.getStartAddress(), "搬入地址", this.c.getEndAddress());
      }
      else
      {
        Object localObject;
        if (this.c.getBusiCode() == 1100)
        {
          if ("2c9084454b7835b0014b7841269101a9".equals(this.c.getServiceTypeCode())) {}
          for (localObject = "服务时长";; localObject = "服务项目")
          {
            a(paramViewGroup, true, true, true, false, "上门时间", this.c.getServerTime(), "服务地址", this.c.getStartAddress(), (String)localObject, this.c.getServiceContent());
            break;
          }
        }
        if (this.c.getBusiCode() == 1200)
        {
          a(paramViewGroup, true, true, true, false, "上门时间", this.c.getServerTime(), "服务地址", this.c.getStartAddress(), "服务时长", this.c.getServiceContent());
        }
        else if (this.c.getBusiCode() == 1101)
        {
          a(paramViewGroup, true, true, true, false, "上门时间", this.c.getServerTime(), "服务地址", this.c.getStartAddress(), "服务时长", this.c.getServiceContent());
        }
        else if (this.c.getBusiCode() == 1000)
        {
          a(paramViewGroup, true, true, false, false, "上门时间", this.c.getServerTime(), "服务地址", this.c.getStartAddress(), "", "");
        }
        else if (this.c.getBusiCode() == 1002)
        {
          a(paramViewGroup, true, true, true, false, "上门时间", this.c.getServerTime(), "服务地址", this.c.getStartAddress(), "维修项目", this.c.getServiceContent());
        }
        else if (this.c.getBusiCode() == 1003)
        {
          paramViewGroup.j.setController(c.frescoController(this.c.getSkuImgUrl()));
          localObject = new DecimalFormat("######0.00");
          localObject = "¥" + ((DecimalFormat)localObject).format(this.c.getOrderAmount() / 100.0D) + "";
          a(paramViewGroup, true, true, true, true, "产品名称", this.c.getServiceContent(), "购买数量", this.c.getAmount() + "", "实付款", (String)localObject);
        }
        else if (this.c.getBusiCode() == 1004)
        {
          a(paramViewGroup, true, true, false, false, "投诉时间", this.c.getServerTime(), "投诉内容", this.c.getServiceContent(), "", "");
        }
      }
    }
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    public LinearLayout c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public SimpleDraweeView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public View o;
    public RelativeLayout p;
    public RelativeLayout q;
    public RelativeLayout r;
    public RelativeLayout s;
    public View t;
    public RelativeLayout u;
    public TextView v;
    public TextView w;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */