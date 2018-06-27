package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.AppointmentPhotographerResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuAppointmentPhotographerTimeBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuAppointmentPhotographerTimeBean.TimesBean;
import com.ziroom.ziroomcustomer.minsu.dialog.c;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.a;
import java.util.List;

public class MinsuAppointmentPhotographerActivity
  extends BaseActivity
{
  private Context a;
  private MinsuAppointmentPhotographerTimeBean b;
  @BindView(2131691248)
  View btn_appointment;
  private String c;
  private String d;
  @BindView(2131690002)
  EditText et_remark;
  @BindView(2131691241)
  LabeledEditText let_appointment_time;
  @BindView(2131691245)
  TextView tv_remark_count;
  
  private void a()
  {
    findViewById(2131696484).setVisibility(8);
    ((TextView)findViewById(2131689541)).setText(2131297030);
    this.et_remark.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 200)
        {
          MinsuAppointmentPhotographerActivity.this.tv_remark_count.setText(2131297032);
          af.showToast(MinsuAppointmentPhotographerActivity.a(MinsuAppointmentPhotographerActivity.this), 2131297168);
          MinsuAppointmentPhotographerActivity.this.et_remark.setText(paramAnonymousCharSequence.subSequence(0, 200));
          MinsuAppointmentPhotographerActivity.this.et_remark.setSelection(MinsuAppointmentPhotographerActivity.this.et_remark.length());
          return;
        }
        MinsuAppointmentPhotographerActivity.this.tv_remark_count.setText(Integer.toString(paramAnonymousCharSequence.length()));
      }
    });
    this.let_appointment_time.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  private void b()
  {
    this.c = getIntent().getStringExtra("houseFid");
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if ((localUserInfo != null) && (!TextUtils.isEmpty(localUserInfo.getUid()))) {
      com.ziroom.ziroomcustomer.minsu.e.a.getAppointmentPhotographerTime(this, localUserInfo.getUid(), new s(this, new p(MinsuAppointmentPhotographerTimeBean.class))
      {
        public void onSuccess(int paramAnonymousInt, MinsuAppointmentPhotographerTimeBean paramAnonymousMinsuAppointmentPhotographerTimeBean)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousMinsuAppointmentPhotographerTimeBean);
          if ((paramAnonymousMinsuAppointmentPhotographerTimeBean != null) && (paramAnonymousMinsuAppointmentPhotographerTimeBean.getTimes() != null) && (paramAnonymousMinsuAppointmentPhotographerTimeBean.getTimes().size() > 0)) {
            MinsuAppointmentPhotographerActivity.a(MinsuAppointmentPhotographerActivity.this, paramAnonymousMinsuAppointmentPhotographerTimeBean);
          }
        }
      });
    }
  }
  
  @OnClick({2131691493, 2131691248, 2131691241})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        finish();
        return;
        if (TextUtils.isEmpty(this.d))
        {
          af.showToast(this.a, "请选择预约时间！");
          return;
        }
        paramView = ApplicationEx.c.getUser();
      } while ((paramView == null) || (TextUtils.isEmpty(paramView.getUid())));
      com.ziroom.ziroomcustomer.minsu.e.a.appointmentPhotographer(this, paramView.getUid(), this.c, this.d, VdsAgent.trackEditTextSilent(this.et_remark).toString(), new s(this, new p(AppointmentPhotographerResultBean.class))
      {
        public void onSuccess(int paramAnonymousInt, AppointmentPhotographerResultBean paramAnonymousAppointmentPhotographerResultBean)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousAppointmentPhotographerResultBean);
          e.a locala;
          if ((paramAnonymousAppointmentPhotographerResultBean != null) && ("1".equals(paramAnonymousAppointmentPhotographerResultBean.getOk())))
          {
            locala = e.newBuilder(MinsuAppointmentPhotographerActivity.a(MinsuAppointmentPhotographerActivity.this)).setTitle(MinsuAppointmentPhotographerActivity.this.getResources().getString(2131297033));
            if (!TextUtils.isEmpty(paramAnonymousAppointmentPhotographerResultBean.getOkMsg())) {
              break label109;
            }
          }
          label109:
          for (paramAnonymousAppointmentPhotographerResultBean = MinsuAppointmentPhotographerActivity.this.getResources().getString(2131297033);; paramAnonymousAppointmentPhotographerResultBean = paramAnonymousAppointmentPhotographerResultBean.getOkMsg())
          {
            locala.setContent(paramAnonymousAppointmentPhotographerResultBean).setButtonText(MinsuAppointmentPhotographerActivity.this.getResources().getString(2131297056)).setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                MinsuAppointmentPhotographerActivity.this.finish();
              }
            }).build().show();
            return;
          }
        }
      });
      return;
    } while (this.b == null);
    new c(this.a, "", new a.a()
    {
      public void callback(int[] paramAnonymousArrayOfInt)
      {
        MinsuAppointmentPhotographerActivity.a(MinsuAppointmentPhotographerActivity.this, ((MinsuAppointmentPhotographerTimeBean.TimesBean)MinsuAppointmentPhotographerActivity.b(MinsuAppointmentPhotographerActivity.this).getTimes().get(paramAnonymousArrayOfInt[0])).getYear() + "-" + ((MinsuAppointmentPhotographerTimeBean.TimesBean)MinsuAppointmentPhotographerActivity.b(MinsuAppointmentPhotographerActivity.this).getTimes().get(paramAnonymousArrayOfInt[0])).getMonthAndDay() + " " + (String)((MinsuAppointmentPhotographerTimeBean.TimesBean)MinsuAppointmentPhotographerActivity.b(MinsuAppointmentPhotographerActivity.this).getTimes().get(paramAnonymousArrayOfInt[0])).getTime().get(paramAnonymousArrayOfInt[1]));
        MinsuAppointmentPhotographerActivity.this.let_appointment_time.setText(MinsuAppointmentPhotographerActivity.c(MinsuAppointmentPhotographerActivity.this));
      }
    }, this.b).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903261);
    ButterKnife.bind(this);
    this.a = this;
    a();
    b();
  }
  
  protected void onDestroy()
  {
    com.freelxl.baselibrary.d.a.cancel(this);
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuAppointmentPhotographerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */