package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.f;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaItemBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaItemBean.ScoreBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLEvaInfoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLEvaInfoBean.LanEvaInfoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLEvaInfoBean.LanRepInfoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLEvaInfoBean.UserEvaInfoBean;
import com.ziroom.ziroomcustomer.minsu.dialog.h;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.LandlordOrderDetailActivity;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.MinsuEvaItemView;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.List;

public class MinsuEvaluetionActivity
  extends BaseActivity
{
  private String a;
  private h b = h.b;
  private a c;
  @BindView(2131691272)
  CommonTitle commonTitle;
  @BindView(2131691578)
  MinsuEvaItemView evaItem1;
  @BindView(2131691580)
  MinsuEvaItemView evaItem2;
  @BindView(2131691574)
  SimpleDraweeView iv;
  @BindView(2131691579)
  View lineEva1;
  @BindView(2131691572)
  RelativeLayout rlOrder;
  @BindView(2131690150)
  ObservableScrollView sv_content;
  @BindView(2131691576)
  TextView tvContentPerson;
  @BindView(2131691575)
  TextView tvContentPrice;
  @BindView(2131691573)
  TextView tvContentTime;
  @BindView(2131691571)
  TextView tvInfo;
  @BindView(2131691581)
  TextView tvNext;
  @BindView(2131689837)
  TextView tvTip;
  @BindView(2131689541)
  TextView tvTitle;
  
  private void a()
  {
    this.c = new a();
    registerReceiver(this.c, new IntentFilter("minsu_eva_commitsuccess"));
  }
  
  private void a(Intent paramIntent)
  {
    if ("android.intent.action.VIEW".equals(paramIntent.getAction()))
    {
      paramIntent = paramIntent.getData();
      if (paramIntent != null)
      {
        this.a = paramIntent.getQueryParameter("orderSn");
        paramIntent = paramIntent.getQueryParameter("userType");
        if ((ae.notNull(paramIntent)) && (ad.isNumeric(paramIntent))) {
          this.b = h.valueOf(Integer.parseInt(paramIntent));
        }
        d.d("lanzhihong", "orderSn==" + this.a + "-----userType===" + paramIntent);
      }
    }
  }
  
  private void a(final MinsuLLEvaInfoBean paramMinsuLLEvaInfoBean)
  {
    String str1 = getString(2131297451) + getString(2131297451);
    this.tvTitle.setText(paramMinsuLLEvaInfoBean.titleName);
    Object localObject = "预订人:" + str1 + paramMinsuLLEvaInfoBean.userName + str1 + "共" + paramMinsuLLEvaInfoBean.peopleNum + "位入住";
    String str2 = d(paramMinsuLLEvaInfoBean.startTimeStr);
    String str3 = d(paramMinsuLLEvaInfoBean.endTimeStr);
    str1 = str2 + "-" + str3 + str1 + "共" + paramMinsuLLEvaInfoBean.housingDay + "晚";
    str2 = paramMinsuLLEvaInfoBean.houseName;
    this.tvContentTime.setText((CharSequence)localObject);
    this.tvContentPrice.setText(str1);
    this.tvContentPerson.setText(str2);
    this.iv.setController(c.frescoController(paramMinsuLLEvaInfoBean.picUrl));
    a(paramMinsuLLEvaInfoBean.titleTime, paramMinsuLLEvaInfoBean.titleTips);
    b(paramMinsuLLEvaInfoBean);
    localObject = this.tvNext;
    if (paramMinsuLLEvaInfoBean.pjStatus == 0) {}
    for (int i = 8;; i = 0)
    {
      ((TextView)localObject).setVisibility(i);
      this.tvNext.setText(paramMinsuLLEvaInfoBean.pjButton);
      this.tvNext.setTag(paramMinsuLLEvaInfoBean);
      this.tvNext.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          Object localObject = (MinsuLLEvaInfoBean)paramAnonymousView.getTag();
          if ((localObject == null) || (((MinsuLLEvaInfoBean)localObject).pjStatus == 0)) {}
          do
          {
            return;
            if (((MinsuLLEvaInfoBean)localObject).pjStatus == 1)
            {
              paramAnonymousView = MinsuEvaluetionActivity.this;
              localObject = ((MinsuLLEvaInfoBean)localObject).orderSn;
              if (MinsuEvaluetionActivity.b(MinsuEvaluetionActivity.this).isCustomer()) {}
              for (int i = 1;; i = 2)
              {
                k.toCustomerEvaCommitActivity(paramAnonymousView, (String)localObject, i);
                return;
              }
            }
          } while (((MinsuLLEvaInfoBean)localObject).pjStatus != 2);
          k.toCustomerEvaCommitActivity(MinsuEvaluetionActivity.this, ((MinsuLLEvaInfoBean)localObject).orderSn, 3);
        }
      });
      this.rlOrder.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (MinsuEvaluetionActivity.b(MinsuEvaluetionActivity.this).isCustomer())
          {
            paramAnonymousView = new Intent(MinsuEvaluetionActivity.this, MinsuSignedActivity.class);
            paramAnonymousView.putExtra("orderSn", MinsuEvaluetionActivity.c(MinsuEvaluetionActivity.this));
            MinsuEvaluetionActivity.this.startActivity(paramAnonymousView);
          }
          while ((paramMinsuLLEvaInfoBean == null) || (f.isNull(paramMinsuLLEvaInfoBean.orderDetailUrl))) {
            return;
          }
          paramAnonymousView = new Intent(MinsuEvaluetionActivity.this, LandlordOrderDetailActivity.class);
          paramAnonymousView.putExtra("orderSn", MinsuEvaluetionActivity.c(MinsuEvaluetionActivity.this));
          MinsuEvaluetionActivity.this.startActivity(paramAnonymousView);
        }
      });
      return;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    int j = 8;
    this.tvTip.setText(paramString1);
    TextView localTextView = this.tvTip;
    if (f.isNull(paramString1))
    {
      i = 8;
      localTextView.setVisibility(i);
      this.tvInfo.setText(paramString2);
      paramString1 = this.tvInfo;
      if (!f.isNull(paramString2)) {
        break label68;
      }
    }
    label68:
    for (int i = j;; i = 0)
    {
      paramString1.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  private void b()
  {
    this.commonTitle.setLeftButtonType(0);
    this.commonTitle.setBottomLineAlpha(0.0F);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuEvaluetionActivity.this.finish();
      }
    });
  }
  
  private void b(MinsuLLEvaInfoBean paramMinsuLLEvaInfoBean)
  {
    int m = 8;
    int k = 0;
    int j = 0;
    Object localObject2;
    int n;
    int i1;
    int i2;
    MinsuEvaItemBean.ScoreBean localScoreBean;
    if (this.b.isLandlord())
    {
      localObject1 = this.evaItem1;
      if (paramMinsuLLEvaInfoBean.userEvaInfo != null)
      {
        i = 0;
        ((MinsuEvaItemView)localObject1).setVisibility(i);
        localObject1 = this.lineEva1;
        if (paramMinsuLLEvaInfoBean.userEvaInfo == null) {
          break label269;
        }
      }
      label269:
      for (i = 0;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        if (paramMinsuLLEvaInfoBean.userEvaInfo == null) {
          break label323;
        }
        localObject1 = new MinsuEvaItemBean();
        ((MinsuEvaItemBean)localObject1).userName = paramMinsuLLEvaInfoBean.userName;
        ((MinsuEvaItemBean)localObject1).userTime = d(paramMinsuLLEvaInfoBean.userEvaInfo.createTime);
        ((MinsuEvaItemBean)localObject1).userContent = paramMinsuLLEvaInfoBean.userEvaInfo.content;
        ((MinsuEvaItemBean)localObject1).scoreList = new ArrayList();
        localObject2 = getResources().getStringArray(2131361822);
        k = paramMinsuLLEvaInfoBean.userEvaInfo.houseClean;
        m = paramMinsuLLEvaInfoBean.userEvaInfo.trafficPosition;
        n = paramMinsuLLEvaInfoBean.userEvaInfo.costPerformance;
        i1 = paramMinsuLLEvaInfoBean.userEvaInfo.descriptionMatch;
        i2 = paramMinsuLLEvaInfoBean.userEvaInfo.safetyDegree;
        i = 0;
        while (i < 5)
        {
          localScoreBean = new MinsuEvaItemBean.ScoreBean();
          localScoreBean.name = localObject2[i];
          localScoreBean.score = new int[] { k, m, n, i1, i2 }[i];
          ((MinsuEvaItemBean)localObject1).scoreList.add(localScoreBean);
          i += 1;
        }
        i = 8;
        break;
      }
      if (paramMinsuLLEvaInfoBean.lanRepInfo != null)
      {
        ((MinsuEvaItemBean)localObject1).replyContent = paramMinsuLLEvaInfoBean.lanRepInfo.content;
        ((MinsuEvaItemBean)localObject1).replyTime = paramMinsuLLEvaInfoBean.lanRepInfo.createTime;
        ((MinsuEvaItemBean)localObject1).replyName = "您的回复";
      }
      this.evaItem1.init((MinsuEvaItemBean)localObject1);
      label323:
      localObject1 = this.evaItem2;
      if (paramMinsuLLEvaInfoBean.lanEvaInfo != null) {}
      for (i = j;; i = 8)
      {
        ((MinsuEvaItemView)localObject1).setVisibility(i);
        if (paramMinsuLLEvaInfoBean.lanEvaInfo != null)
        {
          localObject1 = new MinsuEvaItemBean();
          ((MinsuEvaItemBean)localObject1).userName = "您的评价";
          ((MinsuEvaItemBean)localObject1).userTime = d(paramMinsuLLEvaInfoBean.lanEvaInfo.createTime);
          ((MinsuEvaItemBean)localObject1).userContent = paramMinsuLLEvaInfoBean.lanEvaInfo.content;
          ((MinsuEvaItemBean)localObject1).scoreList = new ArrayList();
          localObject2 = new MinsuEvaItemBean.ScoreBean();
          ((MinsuEvaItemBean.ScoreBean)localObject2).name = "综合评价";
          ((MinsuEvaItemBean.ScoreBean)localObject2).score = paramMinsuLLEvaInfoBean.lanEvaInfo.landlordSatisfied;
          ((MinsuEvaItemBean)localObject1).scoreList.add(localObject2);
          this.evaItem2.init((MinsuEvaItemBean)localObject1);
        }
        return;
      }
    }
    Object localObject1 = this.evaItem1;
    if (paramMinsuLLEvaInfoBean.lanEvaInfo != null)
    {
      i = 0;
      label481:
      ((MinsuEvaItemView)localObject1).setVisibility(i);
      localObject1 = this.lineEva1;
      if (paramMinsuLLEvaInfoBean.lanEvaInfo == null) {
        break label854;
      }
    }
    label854:
    for (int i = 0;; i = 8)
    {
      ((View)localObject1).setVisibility(i);
      if (paramMinsuLLEvaInfoBean.lanEvaInfo != null)
      {
        localObject1 = new MinsuEvaItemBean();
        ((MinsuEvaItemBean)localObject1).userName = paramMinsuLLEvaInfoBean.landlordName;
        ((MinsuEvaItemBean)localObject1).userTime = d(paramMinsuLLEvaInfoBean.lanEvaInfo.createTime);
        ((MinsuEvaItemBean)localObject1).userContent = paramMinsuLLEvaInfoBean.lanEvaInfo.content;
        ((MinsuEvaItemBean)localObject1).scoreList = new ArrayList();
        localObject2 = new MinsuEvaItemBean.ScoreBean();
        ((MinsuEvaItemBean.ScoreBean)localObject2).name = "综合评价";
        ((MinsuEvaItemBean.ScoreBean)localObject2).score = paramMinsuLLEvaInfoBean.lanEvaInfo.landlordSatisfied;
        ((MinsuEvaItemBean)localObject1).scoreList.add(localObject2);
        this.evaItem1.init((MinsuEvaItemBean)localObject1);
      }
      localObject1 = this.evaItem2;
      i = m;
      if (paramMinsuLLEvaInfoBean.userEvaInfo != null) {
        i = 0;
      }
      ((MinsuEvaItemView)localObject1).setVisibility(i);
      if (paramMinsuLLEvaInfoBean.userEvaInfo == null) {
        break;
      }
      localObject1 = new MinsuEvaItemBean();
      ((MinsuEvaItemBean)localObject1).userName = "您的评价";
      ((MinsuEvaItemBean)localObject1).userTime = d(paramMinsuLLEvaInfoBean.userEvaInfo.createTime);
      ((MinsuEvaItemBean)localObject1).userContent = paramMinsuLLEvaInfoBean.userEvaInfo.content;
      ((MinsuEvaItemBean)localObject1).scoreList = new ArrayList();
      localObject2 = getResources().getStringArray(2131361822);
      j = paramMinsuLLEvaInfoBean.userEvaInfo.houseClean;
      m = paramMinsuLLEvaInfoBean.userEvaInfo.trafficPosition;
      n = paramMinsuLLEvaInfoBean.userEvaInfo.costPerformance;
      i1 = paramMinsuLLEvaInfoBean.userEvaInfo.descriptionMatch;
      i2 = paramMinsuLLEvaInfoBean.userEvaInfo.safetyDegree;
      i = k;
      while (i < 5)
      {
        localScoreBean = new MinsuEvaItemBean.ScoreBean();
        localScoreBean.name = localObject2[i];
        localScoreBean.score = new int[] { j, m, n, i1, i2 }[i];
        ((MinsuEvaItemBean)localObject1).scoreList.add(localScoreBean);
        i += 1;
      }
      i = 8;
      break label481;
    }
    if (paramMinsuLLEvaInfoBean.lanRepInfo != null)
    {
      ((MinsuEvaItemBean)localObject1).replyContent = paramMinsuLLEvaInfoBean.lanRepInfo.content;
      ((MinsuEvaItemBean)localObject1).replyTime = paramMinsuLLEvaInfoBean.lanRepInfo.createTime;
      ((MinsuEvaItemBean)localObject1).replyName = "房东的回复";
    }
    this.evaItem2.init((MinsuEvaItemBean)localObject1);
  }
  
  private String d(String paramString)
  {
    if (f.isNull(paramString)) {
      return paramString;
    }
    return paramString.replace("-", "/");
  }
  
  private void e()
  {
    int i = this.b.value();
    com.ziroom.ziroomcustomer.minsu.e.a.llQueryLanEvaInfo(this, this.a, i, new s(this, new p(MinsuLLEvaInfoBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuLLEvaInfoBean paramAnonymousMinsuLLEvaInfoBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuLLEvaInfoBean);
        if (paramAnonymousMinsuLLEvaInfoBean == null) {
          return;
        }
        MinsuEvaluetionActivity.a(MinsuEvaluetionActivity.this, paramAnonymousMinsuLLEvaInfoBean);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903311);
    ButterKnife.bind(this);
    paramBundle = getIntent();
    this.a = paramBundle.getStringExtra("orderSn");
    this.b = ((h)paramBundle.getSerializableExtra("userType"));
    a(paramBundle);
    b();
    this.sv_content.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        MinsuEvaluetionActivity.this.commonTitle.setBottomLineAlpha(f);
      }
    });
    a();
  }
  
  protected void onDestroy()
  {
    unregisterReceiver(this.c);
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    e();
  }
  
  class a
    extends BroadcastReceiver
  {
    public a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      MinsuEvaluetionActivity.a(MinsuEvaluetionActivity.this);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuEvaluetionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */