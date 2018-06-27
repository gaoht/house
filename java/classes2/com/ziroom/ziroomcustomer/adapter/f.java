package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.activity.LeaseUpdataActivity;
import com.ziroom.ziroomcustomer.activity.NewLeaseInfoActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.LeaseListEntity;
import com.ziroom.ziroomcustomer.signed.SharerInformationActivity;
import com.ziroom.ziroomcustomer.sublet.activity.SubletInitiatorDetailActivity;
import com.ziroom.ziroomcustomer.termination.ConfirmTerminationActivity;
import com.ziroom.ziroomcustomer.termination.PaymentInformationActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.ziroomapartment.b;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuContractItem;
import java.util.Iterator;
import java.util.List;

public class f
  extends BaseAdapter
  implements View.OnClickListener
{
  private List<LeaseListEntity> a;
  private Context b;
  private a c;
  private b d;
  private boolean e;
  
  public f(List<LeaseListEntity> paramList, Context paramContext, boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.a = paramList;
    this.b = paramContext;
  }
  
  private View a(String paramString)
  {
    if (ae.isNull(paramString)) {
      return null;
    }
    View localView = View.inflate(this.b, 2130904834, null);
    ((TextView)localView.findViewById(2131696626)).setText(paramString);
    return localView;
  }
  
  private String b(String paramString)
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
  
  public void contractType(a parama, int paramInt)
  {
    Object localObject;
    if (((LeaseListEntity)this.a.get(paramInt)).getZryuContractInfo() != null)
    {
      localObject = ((LeaseListEntity)this.a.get(paramInt)).getZryuContractInfo();
      if ((((ZryuContractItem)localObject).getConstatusCode() != null) && ((((ZryuContractItem)localObject).getConstatusCode().intValue() == 1) || (((ZryuContractItem)localObject).getConstatusCode().intValue() == 4)))
      {
        a.n(parama).setTextColor(Color.parseColor("#ffa000"));
        a.n(parama).setText(((ZryuContractItem)localObject).getConstatus());
        a.n(parama).setVisibility(0);
        if ((((ZryuContractItem)localObject).getShowContactZO() == null) || (((ZryuContractItem)localObject).getShowContactZO().intValue() != 1)) {
          break label185;
        }
        a.a(parama).setVisibility(0);
        label122:
        if (TextUtils.isEmpty(((ZryuContractItem)localObject).getOperation())) {
          break label197;
        }
        a.d(parama).setVisibility(0);
        a.d(parama).setText(((ZryuContractItem)localObject).getOperation());
      }
      for (;;)
      {
        a.c(parama).setVisibility(8);
        a.b(parama).setVisibility(8);
        return;
        a.n(parama).setTextColor(Color.parseColor("#999999"));
        break;
        label185:
        a.a(parama).setVisibility(8);
        break label122;
        label197:
        a.d(parama).setVisibility(8);
      }
    }
    a.d(parama).setVisibility(8);
    if (((ApplicationEx.g == 3) && ("yqy".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) && (((LeaseListEntity)this.a.get(paramInt)).getIsZiroom() == 0)) || (("ysh".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) && (ApplicationEx.g == 3) && (((LeaseListEntity)this.a.get(paramInt)).getIsZiroom() == 0)) || (("ydq".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) && (ApplicationEx.g == 3) && (((LeaseListEntity)this.a.get(paramInt)).getIsZiroom() == 0)))
    {
      a.n(parama).setText("转签办理中");
      a.n(parama).setTextColor(Color.parseColor("#999999"));
      a.n(parama).setVisibility(0);
    }
    while ("1".equals(((LeaseListEntity)this.a.get(paramInt)).getContractStrategy())) {
      if (1 == ((LeaseListEntity)this.a.get(paramInt)).getIsSublet())
      {
        a.c(parama).setVisibility(8);
        a.b(parama).setText("查看转租详情");
        a.b(parama).setTextColor(Color.parseColor("#666666"));
        a.b(parama).setBackgroundResource(2130837969);
        a.a(parama).setVisibility(0);
        a.b(parama).setVisibility(0);
        return;
        if (("gjjgz".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
        {
          a.n(parama).setText("管家正在录入物业交割");
          a.n(parama).setTextColor(Color.parseColor("#999999"));
          a.n(parama).setVisibility(0);
        }
        else if (("yzf".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) && ("yqr".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())))
        {
          a.n(parama).setText("已支付");
          a.n(parama).setTextColor(Color.parseColor("#999999"));
          a.n(parama).setVisibility(0);
        }
        else if (("dsh".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("dtjsh".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ybh".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())))
        {
          a.n(parama).setText("合同审核中");
          a.n(parama).setTextColor(Color.parseColor("#999999"));
          a.n(parama).setVisibility(0);
        }
        else if (("yqy".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ysh".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())))
        {
          a.n(parama).setText("履行中");
          a.n(parama).setTextColor(Color.parseColor("#ffa000"));
          a.n(parama).setVisibility(0);
        }
        else if ("dzf".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState()))
        {
          a.n(parama).setText("待支付");
          a.n(parama).setTextColor(Color.parseColor("#ffa000"));
          a.n(parama).setVisibility(0);
        }
        else if ("ytz".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState()))
        {
          a.n(parama).setText("已退租");
          a.n(parama).setTextColor(Color.parseColor("#ffa000"));
          a.n(parama).setVisibility(0);
        }
        else if ("ydq".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState()))
        {
          a.n(parama).setText("已到期");
          a.n(parama).setTextColor(Color.parseColor("#ffa000"));
          a.n(parama).setVisibility(0);
        }
        else
        {
          a.n(parama).setTextColor(Color.parseColor("#999999"));
          a.n(parama).setVisibility(8);
        }
      }
      else
      {
        if (((LeaseListEntity)this.a.get(paramInt)).getIsRentback() == 1)
        {
          if (((LeaseListEntity)this.a.get(paramInt)).getIsView() == 0)
          {
            a.b(parama).setText("查看解约申请");
            a.b(parama).setTextColor(Color.parseColor("#666666"));
            a.b(parama).setBackgroundResource(2130837969);
            a.b(parama).setVisibility(0);
          }
          for (;;)
          {
            a.a(parama).setVisibility(8);
            a.c(parama).setVisibility(8);
            return;
            if (((LeaseListEntity)this.a.get(paramInt)).getIsView() == 1)
            {
              a.b(parama).setText("办理解约");
              a.b(parama).setTextColor(Color.parseColor("#666666"));
              a.b(parama).setBackgroundResource(2130837969);
              a.b(parama).setVisibility(0);
            }
            else if (((LeaseListEntity)this.a.get(paramInt)).getIsView() == 2)
            {
              a.b(parama).setText("查看解约信息");
              a.b(parama).setVisibility(0);
              a.b(parama).setTextColor(Color.parseColor("#666666"));
              a.b(parama).setBackgroundResource(2130837969);
            }
            else
            {
              a.b(parama).setVisibility(8);
            }
          }
        }
        if ("dzf".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState()))
        {
          a.b(parama).setText("去支付");
          a.b(parama).setVisibility(0);
          a.b(parama).setTextColor(Color.parseColor("#ffa000"));
          a.b(parama).setBackgroundResource(2130837973);
          if (((LeaseListEntity)this.a.get(paramInt)).getPayOutTimeType() == 1) {
            a.b(parama).setVisibility(8);
          }
          for (;;)
          {
            a.a(parama).setVisibility(8);
            a.c(parama).setVisibility(8);
            return;
            if (((LeaseListEntity)this.a.get(paramInt)).getPayOutTimeType() == 2) {
              a.b(parama).setVisibility(8);
            }
          }
        }
        if (("djg".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
        {
          a.b(parama).setText("去交割");
          a.b(parama).setTextColor(Color.parseColor("#666666"));
          a.b(parama).setBackgroundResource(2130837969);
          a.b(parama).setVisibility(0);
          a.a(parama).setVisibility(8);
          a.c(parama).setVisibility(8);
          return;
        }
        if (("gjjgz".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
        {
          a.b(parama).setText("查看物业交割");
          a.b(parama).setTextColor(Color.parseColor("#666666"));
          a.b(parama).setBackgroundResource(2130837969);
          a.b(parama).setVisibility(0);
          a.a(parama).setVisibility(8);
          a.c(parama).setVisibility(8);
          return;
        }
        if (("jgdqr".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
        {
          a.b(parama).setText("去确认");
          a.b(parama).setTextColor(Color.parseColor("#666666"));
          a.b(parama).setBackgroundResource(2130837969);
          a.b(parama).setVisibility(0);
          a.a(parama).setVisibility(8);
          a.c(parama).setVisibility(8);
          return;
        }
        if (("bbh".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
        {
          a.b(parama).setText("查看物业交割");
          a.b(parama).setTextColor(Color.parseColor("#666666"));
          a.b(parama).setBackgroundResource(2130837969);
          a.b(parama).setVisibility(0);
          a.a(parama).setVisibility(8);
          a.c(parama).setVisibility(8);
          return;
        }
        if (("ygq".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
        {
          a.b(parama).setText("去交割");
          a.b(parama).setTextColor(Color.parseColor("#666666"));
          a.b(parama).setBackgroundResource(2130837969);
          a.b(parama).setVisibility(0);
          a.a(parama).setVisibility(8);
          a.c(parama).setVisibility(8);
          return;
        }
        if (((LeaseListEntity)this.a.get(paramInt)).getJointRentFlag() == 0)
        {
          a.b(parama).setText("合租人信息");
          a.b(parama).setTextColor(Color.parseColor("#666666"));
          a.b(parama).setBackgroundResource(2130837969);
          a.b(parama).setVisibility(0);
          if (("yqy".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ysh".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ydq".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState()))) {
            a.a(parama).setVisibility(0);
          }
          for (;;)
          {
            a.c(parama).setVisibility(8);
            return;
            a.a(parama).setVisibility(8);
          }
        }
        if (("1".equals(((LeaseListEntity)this.a.get(paramInt)).getIsEvaluate())) && ("1".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
        {
          a.b(parama).setText("去评价");
          a.b(parama).setTextColor(Color.parseColor("#666666"));
          a.b(parama).setBackgroundResource(2130837969);
          if (("yqy".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ysh".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ydq".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState()))) {
            a.c(parama).setVisibility(0);
          }
          for (;;)
          {
            a.a(parama).setVisibility(8);
            a.b(parama).setVisibility(0);
            return;
            a.c(parama).setVisibility(8);
          }
        }
        if (("yqy".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ysh".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ydq".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())))
        {
          if ((((LeaseListEntity)this.a.get(paramInt)).getIsRentback() != 1) && (1 != ((LeaseListEntity)this.a.get(paramInt)).getIsSublet())) {
            a.c(parama).setVisibility(0);
          }
          for (;;)
          {
            a.a(parama).setVisibility(0);
            a.b(parama).setVisibility(8);
            return;
            a.c(parama).setVisibility(8);
          }
        }
        a.c(parama).setVisibility(8);
        a.b(parama).setVisibility(8);
        a.a(parama).setVisibility(8);
        return;
      }
    }
    if ("2".equals(((LeaseListEntity)this.a.get(paramInt)).getContractStrategy()))
    {
      localObject = (LeaseListEntity)this.a.get(paramInt);
      if (((LeaseListEntity)this.a.get(paramInt)).getIsRentback() == 1)
      {
        a.c(parama).setVisibility(8);
        a.a(parama).setVisibility(8);
        if (((LeaseListEntity)this.a.get(paramInt)).getIsView() == 0)
        {
          a.b(parama).setText("查看解约申请");
          a.b(parama).setVisibility(0);
          return;
        }
        if (((LeaseListEntity)this.a.get(paramInt)).getIsView() == 1)
        {
          a.b(parama).setText("办理解约");
          a.b(parama).setVisibility(0);
          return;
        }
        if (((LeaseListEntity)this.a.get(paramInt)).getIsView() == 2)
        {
          a.b(parama).setText("查看解约信息");
          a.b(parama).setVisibility(0);
          return;
        }
        a.b(parama).setVisibility(8);
        return;
      }
      if (1 == ((LeaseListEntity)this.a.get(paramInt)).getIsSublet())
      {
        a.a(parama).setVisibility(0);
        a.c(parama).setVisibility(8);
        a.b(parama).setText("查看转租详情");
        a.b(parama).setVisibility(0);
        return;
      }
      if ("dgjjg".equals(((LeaseListEntity)localObject).getContractState()))
      {
        if (("djg".equals(((LeaseListEntity)localObject).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
        {
          a.b(parama).setText("去交割");
          a.a(parama).setVisibility(8);
          a.b(parama).setTextColor(Color.parseColor("#666666"));
          a.b(parama).setBackgroundResource(2130837969);
          a.b(parama).setVisibility(0);
        }
        for (;;)
        {
          a.c(parama).setVisibility(8);
          return;
          if (("gjjgz".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
          {
            a.b(parama).setText("查看物业交割");
            a.a(parama).setVisibility(8);
            a.b(parama).setTextColor(Color.parseColor("#666666"));
            a.b(parama).setBackgroundResource(2130837969);
            a.b(parama).setVisibility(0);
          }
          else if (("jgdqr".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
          {
            a.b(parama).setText("去确认");
            a.a(parama).setVisibility(8);
            a.b(parama).setTextColor(Color.parseColor("#666666"));
            a.b(parama).setBackgroundResource(2130837969);
            a.b(parama).setVisibility(0);
          }
          else if (("bbh".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
          {
            a.b(parama).setText("查看物业交割");
            a.a(parama).setVisibility(8);
            a.b(parama).setTextColor(Color.parseColor("#666666"));
            a.b(parama).setBackgroundResource(2130837969);
            a.b(parama).setVisibility(0);
          }
          else if (("ygq".equals(((LeaseListEntity)localObject).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
          {
            a.a(parama).setVisibility(8);
            a.b(parama).setText("去交割");
            a.b(parama).setTextColor(Color.parseColor("#666666"));
            a.b(parama).setBackgroundResource(2130837969);
            a.b(parama).setVisibility(0);
          }
        }
      }
      if ("dzf".equals(((LeaseListEntity)localObject).getContractState()))
      {
        a.b(parama).setText("去支付");
        a.a(parama).setVisibility(8);
        a.b(parama).setVisibility(0);
        a.b(parama).setTextColor(Color.parseColor("#ffa000"));
        a.b(parama).setBackgroundResource(2130837973);
        a.c(parama).setVisibility(8);
        return;
      }
      if ("yzf".equals(((LeaseListEntity)localObject).getContractState()))
      {
        a.a(parama).setVisibility(8);
        a.b(parama).setVisibility(8);
        a.c(parama).setVisibility(8);
        return;
      }
      if (("yqy".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ysh".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ydq".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())))
      {
        if (("1".equals(((LeaseListEntity)this.a.get(paramInt)).getIsEvaluate())) && ("1".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
        {
          a.b(parama).setText("去评价");
          a.a(parama).setVisibility(8);
          a.b(parama).setVisibility(0);
        }
        for (;;)
        {
          a.c(parama).setVisibility(0);
          return;
          a.a(parama).setVisibility(0);
          a.b(parama).setVisibility(8);
        }
      }
      a.a(parama).setVisibility(8);
      a.c(parama).setVisibility(8);
      a.b(parama).setVisibility(8);
      return;
    }
    if (1 == ((LeaseListEntity)this.a.get(paramInt)).getIsSublet())
    {
      a.c(parama).setVisibility(8);
      a.b(parama).setText("查看转租详情");
      a.b(parama).setTextColor(Color.parseColor("#666666"));
      a.b(parama).setBackgroundResource(2130837969);
      a.a(parama).setVisibility(0);
      a.b(parama).setVisibility(0);
      a.c(parama).setVisibility(8);
      return;
    }
    if (((LeaseListEntity)this.a.get(paramInt)).getIsRentback() == 1)
    {
      a.c(parama).setVisibility(8);
      if (((LeaseListEntity)this.a.get(paramInt)).getIsView() == 0)
      {
        a.b(parama).setText("查看解约申请");
        a.b(parama).setTextColor(Color.parseColor("#666666"));
        a.b(parama).setBackgroundResource(2130837969);
        a.b(parama).setVisibility(0);
      }
      for (;;)
      {
        a.a(parama).setVisibility(8);
        a.c(parama).setVisibility(8);
        return;
        if (((LeaseListEntity)this.a.get(paramInt)).getIsView() == 1)
        {
          a.b(parama).setText("办理解约");
          a.b(parama).setTextColor(Color.parseColor("#666666"));
          a.b(parama).setBackgroundResource(2130837969);
          a.b(parama).setVisibility(0);
        }
        else if (((LeaseListEntity)this.a.get(paramInt)).getIsView() == 2)
        {
          a.b(parama).setText("查看解约信息");
          a.b(parama).setVisibility(0);
          a.b(parama).setTextColor(Color.parseColor("#666666"));
          a.b(parama).setBackgroundResource(2130837969);
        }
        else
        {
          a.b(parama).setVisibility(8);
        }
      }
    }
    if ("dzf".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState()))
    {
      a.b(parama).setText("去支付");
      a.b(parama).setVisibility(0);
      a.b(parama).setTextColor(Color.parseColor("#ffa000"));
      a.b(parama).setBackgroundResource(2130837973);
      if (((LeaseListEntity)this.a.get(paramInt)).getPayOutTimeType() == 1) {
        a.b(parama).setVisibility(8);
      }
      for (;;)
      {
        a.a(parama).setVisibility(8);
        a.c(parama).setVisibility(8);
        return;
        if (((LeaseListEntity)this.a.get(paramInt)).getPayOutTimeType() == 2) {
          a.b(parama).setVisibility(8);
        }
      }
    }
    if (("djg".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
    {
      a.b(parama).setText("去交割");
      a.b(parama).setTextColor(Color.parseColor("#666666"));
      a.b(parama).setBackgroundResource(2130837969);
      a.b(parama).setVisibility(0);
      a.a(parama).setVisibility(8);
      a.c(parama).setVisibility(8);
      return;
    }
    if (("gjjgz".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
    {
      a.b(parama).setText("查看物业交割");
      a.b(parama).setTextColor(Color.parseColor("#666666"));
      a.b(parama).setBackgroundResource(2130837969);
      a.b(parama).setVisibility(0);
      a.a(parama).setVisibility(8);
      a.c(parama).setVisibility(8);
      return;
    }
    if (("jgdqr".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
    {
      a.b(parama).setText("去确认");
      a.b(parama).setTextColor(Color.parseColor("#666666"));
      a.b(parama).setBackgroundResource(2130837969);
      a.b(parama).setVisibility(0);
      a.a(parama).setVisibility(8);
      a.c(parama).setVisibility(8);
      return;
    }
    if (("bbh".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
    {
      a.b(parama).setText("查看物业交割");
      a.b(parama).setTextColor(Color.parseColor("#666666"));
      a.b(parama).setBackgroundResource(2130837969);
      a.b(parama).setVisibility(0);
      a.a(parama).setVisibility(8);
      a.c(parama).setVisibility(8);
      return;
    }
    if (("ygq".equals(((LeaseListEntity)this.a.get(paramInt)).getPropertyState())) && ("0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
    {
      a.b(parama).setText("去交割");
      a.b(parama).setTextColor(Color.parseColor("#666666"));
      a.b(parama).setBackgroundResource(2130837969);
      a.b(parama).setVisibility(0);
      a.a(parama).setVisibility(8);
      a.c(parama).setVisibility(8);
      return;
    }
    if (((LeaseListEntity)this.a.get(paramInt)).getJointRentFlag() == 0)
    {
      a.b(parama).setText("合租人信息");
      a.b(parama).setTextColor(Color.parseColor("#666666"));
      a.b(parama).setBackgroundResource(2130837969);
      a.b(parama).setVisibility(0);
      if (("yqy".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ysh".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ydq".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState()))) {
        a.a(parama).setVisibility(0);
      }
      for (;;)
      {
        a.c(parama).setVisibility(8);
        return;
        a.a(parama).setVisibility(8);
      }
    }
    if (("1".equals(((LeaseListEntity)this.a.get(paramInt)).getIsEvaluate())) && ("1".equals(((LeaseListEntity)this.a.get(paramInt)).getIsRenew())))
    {
      a.b(parama).setText("去评价");
      a.b(parama).setTextColor(Color.parseColor("#666666"));
      a.b(parama).setBackgroundResource(2130837969);
      if (("yqy".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ysh".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ydq".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState()))) {
        a.c(parama).setVisibility(0);
      }
      for (;;)
      {
        a.a(parama).setVisibility(8);
        a.b(parama).setVisibility(0);
        return;
        a.c(parama).setVisibility(8);
      }
    }
    if (("yqy".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ysh".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())) || ("ydq".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState())))
    {
      if ((((LeaseListEntity)this.a.get(paramInt)).getIsRentback() != 1) && (1 != ((LeaseListEntity)this.a.get(paramInt)).getIsSublet())) {
        a.c(parama).setVisibility(0);
      }
      for (;;)
      {
        a.a(parama).setVisibility(0);
        a.b(parama).setVisibility(8);
        return;
        a.c(parama).setVisibility(8);
      }
    }
    a.c(parama).setVisibility(8);
    a.b(parama).setVisibility(8);
    a.a(parama).setVisibility(8);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2130904833, null);
      this.c = new a(null);
      a.a(this.c, (TextView)paramView.findViewById(2131696615));
      a.b(this.c, (TextView)paramView.findViewById(2131692417));
      a.c(this.c, (TextView)paramView.findViewById(2131696617));
      a.d(this.c, (TextView)paramView.findViewById(2131696619));
      a.e(this.c, (TextView)paramView.findViewById(2131696618));
      a.f(this.c, (TextView)paramView.findViewById(2131696625));
      a.a(this.c, (LinearLayout)paramView.findViewById(2131696613));
      a.a(this.c, (SimpleDraweeView)paramView.findViewById(2131692416));
      a.g(this.c, (TextView)paramView.findViewById(2131696614));
      a.h(this.c, (TextView)paramView.findViewById(2131692418));
      a.i(this.c, (TextView)paramView.findViewById(2131696623));
      a.j(this.c, (TextView)paramView.findViewById(2131696624));
      a.b(this.c, (LinearLayout)paramView.findViewById(2131696620));
      a.k(this.c, (TextView)paramView.findViewById(2131696622));
      a.c(this.c, (LinearLayout)paramView.findViewById(2131696621));
      paramView.setTag(this.c);
      a.a(this.c).setTag(Integer.valueOf(paramInt));
      a.b(this.c).setTag(Integer.valueOf(paramInt));
      a.c(this.c).setTag(Integer.valueOf(paramInt));
      a.d(this.c).setTag(Integer.valueOf(paramInt));
      a.e(this.c).setTag(Integer.valueOf(paramInt));
      if (this.e) {
        break label563;
      }
      contractType(this.c, paramInt);
    }
    for (;;)
    {
      if (((LeaseListEntity)this.a.get(paramInt)).getZryuContractInfo() == null)
      {
        if (((LeaseListEntity)this.a.get(paramInt)).getTips() != null)
        {
          if (((LeaseListEntity)this.a.get(paramInt)).getTips().size() > 0)
          {
            a.f(this.c).setVisibility(0);
            a.f(this.c).removeAllViews();
            paramViewGroup = ((LeaseListEntity)this.a.get(paramInt)).getTips().iterator();
            while (paramViewGroup.hasNext())
            {
              str = (String)paramViewGroup.next();
              if (a(str) != null) {
                a.f(this.c).addView(a(str));
              }
            }
            this.c = ((a)paramView.getTag());
            break;
            label563:
            invalidContractType(paramInt);
            continue;
          }
          a.f(this.c).setVisibility(8);
          a.g(this.c).setText(((LeaseListEntity)this.a.get(paramInt)).getAddress());
          a.h(this.c).setVisibility(0);
          a.h(this.c).setText(((LeaseListEntity)this.a.get(paramInt)).getContractCode());
          paramViewGroup = ((LeaseListEntity)this.a.get(paramInt)).getSignDate();
          a.i(this.c).setText(((LeaseListEntity)this.a.get(paramInt)).getMoneyUnit());
          String str = ((LeaseListEntity)this.a.get(paramInt)).getStopDate();
          a.j(this.c).setText(paramViewGroup.replaceAll("-", "/") + "至" + str.replaceAll("-", "/"));
          if ((!"0".equals(((LeaseListEntity)this.a.get(paramInt)).getIsBlank())) || (((LeaseListEntity)this.a.get(paramInt)).getIsZWhite() != 0)) {
            break label992;
          }
          a.k(this.c).setText(b(((LeaseListEntity)this.a.get(paramInt)).getPaymentType()));
        }
        for (;;)
        {
          a.l(this.c).setText(((LeaseListEntity)this.a.get(paramInt)).getPrice() + "");
          a.e(this.c).setOnClickListener(this);
          a.c(this.c).setOnClickListener(this);
          a.a(this.c).setOnClickListener(this);
          a.b(this.c).setOnClickListener(this);
          a.e(this.c).setTag(Integer.valueOf(paramInt));
          a.m(this.c).setController(com.freelxl.baselibrary.f.c.frescoController(((LeaseListEntity)this.a.get(paramInt)).getHousePic()));
          a.d(this.c).setOnClickListener(null);
          return paramView;
          a.f(this.c).setVisibility(8);
          break;
          label992:
          if ("1".equals(((LeaseListEntity)this.a.get(paramInt)).getIsBlank())) {
            a.k(this.c).setText("自如白条");
          } else if (1 == ((LeaseListEntity)this.a.get(paramInt)).getIsZWhite()) {
            a.k(this.c).setText("自如分期");
          }
        }
      }
    }
    paramViewGroup = ((LeaseListEntity)this.a.get(paramInt)).getZryuContractInfo();
    a.g(this.c).setText(paramViewGroup.getRentTitle());
    if (TextUtils.isEmpty(paramViewGroup.getContractCode())) {
      if (TextUtils.isEmpty(paramViewGroup.getContractCodeInfo())) {
        a.h(this.c).setVisibility(8);
      }
    }
    for (;;)
    {
      a.i(this.c).setText("");
      a.j(this.c).setText(paramViewGroup.getRentTime());
      a.k(this.c).setText("");
      a.l(this.c).setText(paramViewGroup.getRoomSalesPrice());
      a.e(this.c).setOnClickListener(this);
      a.a(this.c).setText("联系管家");
      a.a(this.c).setOnClickListener(this);
      a.d(this.c).setOnClickListener(this);
      a.m(this.c).setController(com.freelxl.baselibrary.f.c.frescoController(paramViewGroup.getProHeadFigureUrl()));
      return paramView;
      a.h(this.c).setVisibility(0);
      a.h(this.c).setText(paramViewGroup.getContractCodeInfo());
      continue;
      a.h(this.c).setVisibility(0);
      a.h(this.c).setText(paramViewGroup.getContractCode());
    }
  }
  
  public void invalidContractType(int paramInt)
  {
    if (((LeaseListEntity)this.a.get(paramInt)).getZryuContractInfo() != null)
    {
      ZryuContractItem localZryuContractItem = ((LeaseListEntity)this.a.get(paramInt)).getZryuContractInfo();
      a.n(this.c).setTextColor(Color.parseColor("#999999"));
      a.n(this.c).setText(localZryuContractItem.getConstatus());
      a.n(this.c).setVisibility(0);
      if ((localZryuContractItem.getShowContactZO() != null) && (localZryuContractItem.getShowContactZO().intValue() == 1))
      {
        a.a(this.c).setVisibility(0);
        if (TextUtils.isEmpty(localZryuContractItem.getOperation())) {
          break label191;
        }
        a.d(this.c).setVisibility(0);
        a.o(this.c).setVisibility(0);
        a.d(this.c).setText(localZryuContractItem.getOperation());
      }
      for (;;)
      {
        a.c(this.c).setVisibility(8);
        a.b(this.c).setVisibility(8);
        return;
        a.a(this.c).setVisibility(8);
        break;
        label191:
        a.d(this.c).setVisibility(8);
        a.o(this.c).setVisibility(8);
      }
    }
    if ("ydq".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState()))
    {
      a.n(this.c).setText("已到期");
      a.n(this.c).setVisibility(0);
    }
    for (;;)
    {
      a.b(this.c).setVisibility(8);
      a.o(this.c).setVisibility(8);
      a.a(this.c).setVisibility(8);
      return;
      if ("ygb".equals(((LeaseListEntity)this.a.get(paramInt)).getContractState()))
      {
        a.n(this.c).setText("已关闭");
        a.n(this.c).setVisibility(0);
      }
      else
      {
        a.n(this.c).setVisibility(8);
      }
    }
  }
  
  public boolean isNewContract(String paramString)
  {
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      if ('-' == paramString[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @Instrumented
  public void onClick(final View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView == null) {}
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              return;
              switch (paramView.getId())
              {
              default: 
                return;
              case 2131696613: 
                i = ((Integer)paramView.getTag()).intValue();
                this.d.onItem((LeaseListEntity)this.a.get(i));
                return;
              case 2131696625: 
                i = ((Integer)paramView.getTag()).intValue();
                if ("合租人信息".equals(((TextView)paramView).getText().toString()))
                {
                  this.d.toIntent((LeaseListEntity)this.a.get(i), SharerInformationActivity.class);
                  return;
                }
                if ("查看解约申请".equals(((TextView)paramView).getText().toString()))
                {
                  this.d.toIntent((LeaseListEntity)this.a.get(i), ConfirmTerminationActivity.class);
                  return;
                }
                if ("办理解约".equals(((TextView)paramView).getText().toString()))
                {
                  this.d.toIntent((LeaseListEntity)this.a.get(i), ConfirmTerminationActivity.class);
                  return;
                }
                if ("查看解约信息".equals(((TextView)paramView).getText().toString()))
                {
                  this.d.toIntent((LeaseListEntity)this.a.get(i), PaymentInformationActivity.class);
                  return;
                }
                if ("去评价".equals(((TextView)paramView).getText().toString()))
                {
                  this.d.toEvaluatePage(((LeaseListEntity)this.a.get(i)).getContractCode(), ((LeaseListEntity)this.a.get(i)).getEvaluateType());
                  w.onEvent(this.b, "contract_evaluate,");
                  return;
                }
                if ("查看转租详情".equals(((TextView)paramView).getText().toString()))
                {
                  this.d.toIntent((LeaseListEntity)this.a.get(i), SubletInitiatorDetailActivity.class);
                  w.onEvent(this.b, "subletdetail ");
                  return;
                }
                if ("去支付".equals(((TextView)paramView).getText().toString()))
                {
                  this.d.toPay((LeaseListEntity)this.a.get(i));
                  return;
                }
                if ("去交割".equals(((TextView)paramView).getText().toString()))
                {
                  this.d.toPropertyState((LeaseListEntity)this.a.get(i));
                  return;
                }
                if ("查看物业交割".equals(((TextView)paramView).getText().toString()))
                {
                  this.d.toPropertyState((LeaseListEntity)this.a.get(i));
                  return;
                }
                if ("去确认".equals(((TextView)paramView).getText().toString()))
                {
                  this.d.toPropertyState((LeaseListEntity)this.a.get(i));
                  return;
                }
                this.d.toIntent((LeaseListEntity)this.a.get(i), NewLeaseInfoActivity.class);
                w.onEvent(this.b, "mycontract_detail");
                return;
              case 2131696624: 
                i = ((Integer)paramView.getTag()).intValue();
                if (((LeaseListEntity)this.a.get(i)).getZryuContractInfo() == null)
                {
                  if (("ysh".equals(((LeaseListEntity)this.a.get(i)).getContractState())) || ("yqy".equals(((LeaseListEntity)this.a.get(i)).getContractState())) || ("ydq".equals(((LeaseListEntity)this.a.get(i)).getContractState())))
                  {
                    this.d.showHousekeeper(((LeaseListEntity)this.a.get(i)).getContractCode());
                    w.onEvent(this.b, "change_lease");
                    return;
                  }
                  if ("ydq".equals(((LeaseListEntity)this.a.get(i)).getContractState()))
                  {
                    ((BaseActivity)this.b).showToast("合同已过期，如有疑问请咨询客服热线400-100-1111");
                    return;
                  }
                  ((BaseActivity)this.b).showToast("合同未生效，还未分配管家");
                  return;
                }
                break;
              }
            } while (TextUtils.isEmpty(((LeaseListEntity)this.a.get(i)).getZryuContractInfo().getHandleZOPhone()));
            ah.callPhone(this.b, ((LeaseListEntity)this.a.get(i)).getZryuContractInfo().getHandleZOPhone());
            return;
            i = ((Integer)paramView.getTag()).intValue();
          } while (((LeaseListEntity)this.a.get(i)).getZryuContractInfo() != null);
          i = ((Integer)paramView.getTag()).intValue();
          this.d.toIntent((LeaseListEntity)this.a.get(i), LeaseUpdataActivity.class);
          w.onEvent(this.b, "contract_evaluate,");
          return;
          i = ((Integer)paramView.getTag()).intValue();
        } while (((LeaseListEntity)this.a.get(i)).getZryuContractInfo() == null);
        paramView = ((LeaseListEntity)this.a.get(i)).getZryuContractInfo();
      } while (paramView.getOperationCode() == null);
      if (paramView.getOperationCode().intValue() == 0)
      {
        b.toSign(this.b, paramView.getContractId(), paramView.getHandleZOPhone());
        return;
      }
      if (paramView.getOperationCode().intValue() == 1)
      {
        b.toBillsInfo(this.b, paramView.getContractId(), paramView.getContractCode(), "1007", "1");
        return;
      }
      if (paramView.getOperationCode().intValue() == 2)
      {
        b.toDelivery(this.b, paramView.getContractId());
        return;
      }
      if (paramView.getOperationCode().intValue() == 3)
      {
        if (TextUtils.isEmpty(paramView.getRenewContractId()))
        {
          com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.b).setContent("管家还未发起续约通知，请及时联系管家！").setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("联系管家").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
            {
              if (paramAnonymousBoolean) {
                ah.callPhone(f.a(f.this), paramView.getHandleZOPhone());
              }
            }
          }).build().show();
          return;
        }
        b.toContractInfo(this.b, paramView.getRenewContractId(), "XQ");
        return;
      }
      if (paramView.getOperationCode().intValue() == 5)
      {
        b.toBillsList(this.b, paramView.getContractId(), 1, 1);
        return;
      }
    } while (paramView.getOperationCode().intValue() != 6);
    b.toBillsList(this.b, paramView.getContractId(), 2, 1);
  }
  
  public void setLeaseList(List<LeaseListEntity> paramList)
  {
    this.a = paramList;
    u.e("adapter   === ", "   =======          赋值了");
  }
  
  public void setSetOnItemClick(b paramb)
  {
    this.d = paramb;
  }
  
  private class a
  {
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private LinearLayout m;
    private LinearLayout n;
    private LinearLayout o;
    private SimpleDraweeView p;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onItem(LeaseListEntity paramLeaseListEntity);
    
    public abstract void showHousekeeper(String paramString);
    
    public abstract void toEvaluatePage(String paramString1, String paramString2);
    
    public abstract void toIntent(LeaseListEntity paramLeaseListEntity, Class paramClass);
    
    public abstract void toPay(LeaseListEntity paramLeaseListEntity);
    
    public abstract void toPropertyState(LeaseListEntity paramLeaseListEntity);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */