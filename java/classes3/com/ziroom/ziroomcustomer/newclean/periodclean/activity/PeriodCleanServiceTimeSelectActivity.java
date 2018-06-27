package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.periodclean.a.f;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.DatePlanListBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.LabelBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.ServiceTimeLongBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.WeekBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.WeekCapacityBean;
import com.ziroom.ziroomcustomer.payment.views.wheelview.WheelView;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.MyCleanListView;
import java.util.List;

public class PeriodCleanServiceTimeSelectActivity
  extends BaseActivity
{
  private Dialog A = null;
  private SharedPreferences a;
  private boolean b;
  @BindView(2131690043)
  Button btn;
  private String c;
  private String d;
  private String e;
  private ServiceTimeLongBean f;
  private String g;
  @BindView(2131689973)
  MyGridView gvHome;
  @BindView(2131690093)
  HorizontalScrollView hScrollView;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131690376)
  ImageView ivBall;
  @BindView(2131691228)
  MyCleanListView listNotices;
  @BindView(2131692097)
  LinearLayout llFristCleanTime;
  @BindView(2131690377)
  LinearLayout llNoData;
  @BindView(2131690364)
  LinearLayout llNoticeMessage;
  private int r;
  @BindView(2131689808)
  RelativeLayout rlTitle;
  private int s;
  private WeekBean t;
  @BindView(2131692074)
  TextView tvFristTime;
  @BindView(2131689541)
  TextView tvTitle;
  private f u;
  private List<WeekCapacityBean> v;
  @BindView(2131690094)
  LinearLayout viewgroup;
  private DatePlanListBean w;
  private WeekCapacityBean x;
  private String[] y;
  private com.freelxl.baselibrary.a.a z;
  
  private void a()
  {
    this.a = getSharedPreferences("cleanTime_animation", 0);
    this.b = this.a.getBoolean("cleanTime_is_first", true);
    if (this.b)
    {
      Object localObject = this.a.edit();
      ((SharedPreferences.Editor)localObject).putBoolean("cleanTime_is_first", false);
      ((SharedPreferences.Editor)localObject).commit();
      localObject = new TranslateAnimation(0.0F, -n.dip2px(this, 100.0F), 0.0F, 0.0F);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      ((Animation)localObject).setDuration(1500L);
      localAlphaAnimation.setDuration(1500L);
      ((Animation)localObject).setRepeatCount(1);
      localAlphaAnimation.setRepeatCount(1);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setFillEnabled(true);
      this.ivBall.setAnimation(localAnimationSet);
      localAnimationSet.startNow();
    }
    for (;;)
    {
      this.u = new f(4, this.v, this);
      this.gvHome.setAdapter(this.u);
      this.gvHome.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          if ("0".equals(((WeekCapacityBean)PeriodCleanServiceTimeSelectActivity.a(PeriodCleanServiceTimeSelectActivity.this).get(paramAnonymousInt)).getFlag()))
          {
            if (PeriodCleanServiceTimeSelectActivity.b(PeriodCleanServiceTimeSelectActivity.this) != null) {
              PeriodCleanServiceTimeSelectActivity.b(PeriodCleanServiceTimeSelectActivity.this).setSelectPosition(paramAnonymousInt);
            }
            PeriodCleanServiceTimeSelectActivity.a(PeriodCleanServiceTimeSelectActivity.this, (WeekCapacityBean)PeriodCleanServiceTimeSelectActivity.a(PeriodCleanServiceTimeSelectActivity.this).get(paramAnonymousInt));
            PeriodCleanServiceTimeSelectActivity.this.llFristCleanTime.setVisibility(0);
            PeriodCleanServiceTimeSelectActivity.a(PeriodCleanServiceTimeSelectActivity.this, (DatePlanListBean)PeriodCleanServiceTimeSelectActivity.c(PeriodCleanServiceTimeSelectActivity.this).getDatePlanList().get(0));
            PeriodCleanServiceTimeSelectActivity.this.tvFristTime.setText(PeriodCleanServiceTimeSelectActivity.d(PeriodCleanServiceTimeSelectActivity.this).getDateName());
            PeriodCleanServiceTimeSelectActivity.this.btn.setEnabled(true);
            return;
          }
          g.textToast(PeriodCleanServiceTimeSelectActivity.this, "已约满，请选择其他时间");
        }
      });
      this.z = new com.freelxl.baselibrary.a.a(this, null, 2130904435)
      {
        public void convert(b paramAnonymousb, LabelBean paramAnonymousLabelBean)
        {
          paramAnonymousb.setText(2131695534, paramAnonymousLabelBean.getTagValue());
        }
      };
      this.listNotices.setAdapter(this.z);
      com.ziroom.ziroomcustomer.newclean.periodclean.a.getCycleplanWeekList(this, new d(this, new e(WeekBean.class))
      {
        public void onSuccess(int paramAnonymousInt, List<WeekBean> paramAnonymousList)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousList);
          PeriodCleanServiceTimeSelectActivity.a(PeriodCleanServiceTimeSelectActivity.this, paramAnonymousList);
          if (paramAnonymousList.size() > 1) {
            PeriodCleanServiceTimeSelectActivity.a(PeriodCleanServiceTimeSelectActivity.this, (WeekBean)paramAnonymousList.get(0));
          }
          PeriodCleanServiceTimeSelectActivity.e(PeriodCleanServiceTimeSelectActivity.this);
        }
      });
      com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodCleanTimeNoticeMessage(this, new d(this, new e(LabelBean.class))
      {
        public void onSuccess(int paramAnonymousInt, List<LabelBean> paramAnonymousList)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousList);
          PeriodCleanServiceTimeSelectActivity.f(PeriodCleanServiceTimeSelectActivity.this).setDatas(paramAnonymousList);
          PeriodCleanServiceTimeSelectActivity.f(PeriodCleanServiceTimeSelectActivity.this).notifyDataSetChanged();
        }
      });
      return;
      this.ivBall.setVisibility(8);
    }
  }
  
  private void a(final List<WeekBean> paramList)
  {
    int j = getWindowManager().getDefaultDisplay().getWidth() / 9;
    Object localObject = new ViewPager.LayoutParams();
    ((ViewPager.LayoutParams)localObject).width = -2;
    ((ViewPager.LayoutParams)localObject).height = -2;
    localObject = getLayoutInflater();
    int i = 0;
    if (i < paramList.size())
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((LayoutInflater)localObject).inflate(2130904437, null);
      TextView localTextView = (TextView)localRelativeLayout.findViewById(2131695057);
      View localView = localRelativeLayout.findViewById(2131693860);
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(j * 2, -1));
      localTextView.setText(((WeekBean)paramList.get(i)).getWeekName());
      localRelativeLayout.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = PeriodCleanServiceTimeSelectActivity.this.viewgroup.indexOfChild(paramAnonymousView);
          PeriodCleanServiceTimeSelectActivity.a(PeriodCleanServiceTimeSelectActivity.this, (WeekBean)paramList.get(i));
          PeriodCleanServiceTimeSelectActivity.e(PeriodCleanServiceTimeSelectActivity.this);
          PeriodCleanServiceTimeSelectActivity.a(PeriodCleanServiceTimeSelectActivity.this, i);
          PeriodCleanServiceTimeSelectActivity.b(PeriodCleanServiceTimeSelectActivity.this, i);
        }
      });
      if (i == this.s)
      {
        localTextView.setTextColor(40960);
        localView.setVisibility(0);
      }
      for (;;)
      {
        this.viewgroup.addView(localRelativeLayout);
        i += 1;
        break;
        localTextView.setTextColor(-12303292);
        localView.setVisibility(8);
      }
    }
  }
  
  private void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    View localView = getLayoutInflater().inflate(2130905027, null);
    this.A = new Dialog(this, 2131427932);
    this.A.setContentView(localView, new ViewGroup.LayoutParams(-1, -2));
    final Object localObject = this.A.getWindow();
    ((Window)localObject).setWindowAnimations(2131427933);
    localObject = ((Window)localObject).getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = getWindowManager().getDefaultDisplay().getHeight();
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).height = -2;
    this.A.onWindowAttributesChanged((WindowManager.LayoutParams)localObject);
    localObject = (WheelView)localView.findViewById(2131694517);
    ((WheelView)localObject).setAdapter(new com.ziroom.ziroomcustomer.payment.views.wheelview.a(paramArrayOfString));
    ((WheelView)localObject).setVisibleItems(5);
    ((TextView)localView.findViewById(2131694514)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        PeriodCleanServiceTimeSelectActivity.a(PeriodCleanServiceTimeSelectActivity.this, (DatePlanListBean)PeriodCleanServiceTimeSelectActivity.c(PeriodCleanServiceTimeSelectActivity.this).getDatePlanList().get(localObject.getCurrentItem()));
        PeriodCleanServiceTimeSelectActivity.this.tvFristTime.setText(PeriodCleanServiceTimeSelectActivity.d(PeriodCleanServiceTimeSelectActivity.this).getDateName());
        PeriodCleanServiceTimeSelectActivity.g(PeriodCleanServiceTimeSelectActivity.this).dismiss();
      }
    });
    ((TextView)localView.findViewById(2131694513)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        PeriodCleanServiceTimeSelectActivity.g(PeriodCleanServiceTimeSelectActivity.this).dismiss();
      }
    });
    this.A.setCanceledOnTouchOutside(true);
    paramArrayOfString = this.A;
    if (!(paramArrayOfString instanceof Dialog))
    {
      paramArrayOfString.show();
      return;
    }
    VdsAgent.showDialog((Dialog)paramArrayOfString);
  }
  
  private void b()
  {
    if (this.t == null) {
      return;
    }
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getCycleplanCapacityList(this, this.t.getWeekNum(), this.c, this.f.getBurningTimeCode(), this.d, this.e, new d(this, new e(WeekCapacityBean.class))
    {
      public void onSuccess(int paramAnonymousInt, List<WeekCapacityBean> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        PeriodCleanServiceTimeSelectActivity.b(PeriodCleanServiceTimeSelectActivity.this, paramAnonymousList);
        PeriodCleanServiceTimeSelectActivity.b(PeriodCleanServiceTimeSelectActivity.this).setData(paramAnonymousList);
        PeriodCleanServiceTimeSelectActivity.b(PeriodCleanServiceTimeSelectActivity.this).setSelectPosition(-1);
        PeriodCleanServiceTimeSelectActivity.a(PeriodCleanServiceTimeSelectActivity.this, null);
        PeriodCleanServiceTimeSelectActivity.this.llFristCleanTime.setVisibility(8);
        PeriodCleanServiceTimeSelectActivity.a(PeriodCleanServiceTimeSelectActivity.this, null);
        PeriodCleanServiceTimeSelectActivity.this.tvFristTime.setText("");
        PeriodCleanServiceTimeSelectActivity.this.btn.setEnabled(false);
      }
    });
  }
  
  @SuppressLint({"NewApi"})
  private void b(int paramInt)
  {
    int m = 0;
    this.viewgroup.measure(this.viewgroup.getMeasuredWidth(), -1);
    Object localObject = new FrameLayout.LayoutParams(this.viewgroup.getMeasuredWidth(), -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.viewgroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int k = 0;
    int j = 0;
    int i = 0;
    int n;
    if (k < this.viewgroup.getChildCount())
    {
      localObject = (RelativeLayout)this.viewgroup.getChildAt(k);
      n = ((RelativeLayout)localObject).getMeasuredWidth();
      if (k >= paramInt) {
        break label348;
      }
      i += n;
    }
    label318:
    label348:
    for (;;)
    {
      if (paramInt == k)
      {
        ((TextView)((RelativeLayout)localObject).findViewById(2131695057)).setTextColor(33792);
        ((RelativeLayout)localObject).findViewById(2131693860).setVisibility(0);
      }
      for (;;)
      {
        k += 1;
        j += n;
        break;
        ((TextView)((RelativeLayout)localObject).findViewById(2131695057)).setTextColor(-12303292);
        ((RelativeLayout)localObject).findViewById(2131693860).setVisibility(8);
      }
      n = this.viewgroup.getChildAt(paramInt).getMeasuredWidth();
      k = m;
      int i1;
      if (paramInt > 0)
      {
        if (paramInt == this.viewgroup.getChildCount() - 1) {
          k = m;
        }
      }
      else
      {
        m = getWindowManager().getDefaultDisplay().getWidth();
        i1 = i - (m - n) / 2 - (m - n) / 4;
        if (this.r >= paramInt) {
          break label318;
        }
        if (n + i + k >= m / 2) {
          ((HorizontalScrollView)this.viewgroup.getParent()).setScrollX(i1 * 2);
        }
      }
      for (;;)
      {
        this.r = paramInt;
        return;
        k = this.viewgroup.getChildAt(paramInt - 1).getMeasuredWidth();
        break;
        if (j - i >= m / 2) {
          ((HorizontalScrollView)this.viewgroup.getParent()).setScrollX(i1 * 2);
        }
      }
    }
  }
  
  private void e()
  {
    if (this.x == null) {
      return;
    }
    int i = this.x.getDatePlanList().size();
    this.y = new String[i];
    while (i > 0)
    {
      this.y[(i - 1)] = ((DatePlanListBean)this.x.getDatePlanList().get(i - 1)).getDateName();
      i -= 1;
    }
    a(this.y);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903429);
    ButterKnife.bind(this);
    this.c = getIntent().getStringExtra("cleanerId");
    this.d = getIntent().getStringExtra("addressId");
    this.g = getIntent().getStringExtra("cleanerName");
    this.e = getIntent().getStringExtra("cyclePlanFrequencyCode");
    this.f = ((ServiceTimeLongBean)getIntent().getSerializableExtra("ServiceTimeLong"));
    if (ae.notNull(this.g)) {
      this.tvTitle.setText(this.g + "的日程");
    }
    for (;;)
    {
      a();
      return;
      this.tvTitle.setText("保洁员的日程");
    }
  }
  
  @OnClick({2131689492, 2131692097, 2131690043})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131692097: 
      e();
      return;
    }
    if (this.w != null)
    {
      paramView = new Intent();
      paramView.putExtra("datePlan", this.w);
      setResult(20, paramView);
    }
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanServiceTimeSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */