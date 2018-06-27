package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.e.a;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuPersonInfo;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuPersonInfo.Item;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MinsuPersonalDataActivity
  extends BaseActivity
{
  private MinsuPersonInfo a;
  private List<LabeledEditText> b = new ArrayList();
  @BindView(2131696312)
  LabeledEditText btnBirthDay;
  @BindView(2131696316)
  LabeledEditText btnEducate;
  @BindView(2131696311)
  LabeledEditText btnGender;
  @BindView(2131696318)
  LabeledEditText btnIntroduce;
  @BindView(2131689816)
  TextView btnSubmit;
  @BindView(2131696313)
  LabeledEditText btnTel;
  private String c = "";
  private List<MinsuPersonInfo.Item> d;
  private int e = 0;
  @BindView(2131696315)
  LabeledEditText etAddress;
  @BindView(2131696314)
  LabeledEditText etEmail;
  @BindView(2131696317)
  LabeledEditText etJob;
  @BindView(2131691057)
  LabeledEditText etNickname;
  private int f = 2;
  private List<MinsuPersonInfo.Item> g;
  private final int r = 1;
  private final int s = 0;
  private int t = 0;
  @BindView(2131696319)
  TextView tv_introduce_review;
  @BindView(2131696310)
  TextView tv_nickname_review;
  private int u = 1988;
  private int v = 1;
  private int w = 1;
  
  private void a()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.setLeftButtonType(0);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuPersonalDataActivity.this.finish();
      }
    });
    localCommonTitle.setMiddleText("个人资料");
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getLlInfo(this, new com.ziroom.commonlibrary.a.a(this, new p(MinsuPersonInfo.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MinsuPersonalDataActivity.this.showToast(paramAnonymousThrowable.getMessage());
        MinsuPersonalDataActivity.this.showToast(Log.getStackTraceString(paramAnonymousThrowable));
        u.e("exception", Log.getStackTraceString(paramAnonymousThrowable));
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuPersonInfo paramAnonymousMinsuPersonInfo)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuPersonInfo);
        if (paramAnonymousMinsuPersonInfo == null) {
          return;
        }
        MinsuPersonalDataActivity.a(MinsuPersonalDataActivity.this, paramAnonymousMinsuPersonInfo);
        MinsuPersonalDataActivity.a(MinsuPersonalDataActivity.this, paramAnonymousMinsuPersonInfo.getEduList());
        MinsuPersonalDataActivity.b(MinsuPersonalDataActivity.this, paramAnonymousMinsuPersonInfo.getSexList());
        MinsuPersonalDataActivity localMinsuPersonalDataActivity = MinsuPersonalDataActivity.this;
        if (paramAnonymousMinsuPersonInfo == null) {}
        for (paramAnonymousInt = 0;; paramAnonymousInt = paramAnonymousMinsuPersonInfo.getIsLandlord().intValue())
        {
          MinsuPersonalDataActivity.a(localMinsuPersonalDataActivity, paramAnonymousInt);
          MinsuPersonalDataActivity.a(MinsuPersonalDataActivity.this);
          MinsuPersonalDataActivity.b(MinsuPersonalDataActivity.this);
          MinsuPersonalDataActivity.this.tv_introduce_review.setText(paramAnonymousMinsuPersonInfo.introduceAuditMsg);
          MinsuPersonalDataActivity.this.tv_nickname_review.setText(paramAnonymousMinsuPersonInfo.nickNameAuditMsg);
          return;
        }
      }
    });
  }
  
  private void e()
  {
    this.b.add(this.etNickname);
    this.b.add(this.btnGender);
    this.b.add(this.btnBirthDay);
    this.b.add(this.btnTel);
    this.b.add(this.etEmail);
    this.b.add(this.etAddress);
    this.b.add(this.btnEducate);
    this.b.add(this.etJob);
  }
  
  private void f()
  {
    this.etNickname.setText(this.a.nickName);
    this.btnGender.setText(this.a.sexName);
    if (this.a.customerBirthdayStr != null) {
      this.btnBirthDay.setText(this.a.customerBirthdayStr);
    }
    this.btnTel.setText(this.a.customerMobile);
    this.etEmail.setText(this.a.customerEmail);
    this.etAddress.setText(this.a.resideAddr);
    this.btnEducate.setText(this.a.customerEduName);
    this.etJob.setText(this.a.getCustomerJob());
  }
  
  private void g()
  {
    DatePickerDialog localDatePickerDialog = new DatePickerDialog(this, 3, new DatePickerDialog.OnDateSetListener()
    {
      public void onDateSet(DatePicker paramAnonymousDatePicker, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        MinsuPersonalDataActivity.b(MinsuPersonalDataActivity.this, paramAnonymousInt1);
        MinsuPersonalDataActivity.c(MinsuPersonalDataActivity.this, paramAnonymousInt2 + 1);
        MinsuPersonalDataActivity.d(MinsuPersonalDataActivity.this, paramAnonymousInt3);
        MinsuPersonalDataActivity.this.btnBirthDay.setText(MinsuPersonalDataActivity.c(MinsuPersonalDataActivity.this) + "-" + MinsuPersonalDataActivity.d(MinsuPersonalDataActivity.this) + "-" + MinsuPersonalDataActivity.e(MinsuPersonalDataActivity.this));
      }
    }, this.u, this.v - 1, this.w);
    if (!(localDatePickerDialog instanceof DatePickerDialog))
    {
      localDatePickerDialog.show();
      return;
    }
    VdsAgent.showDialog((DatePickerDialog)localDatePickerDialog);
  }
  
  private void h()
  {
    if (this.t == 0)
    {
      i();
      return;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      String str = ((LabeledEditText)localIterator.next()).getText();
      if ((str == null) || ("".equals(str.trim())))
      {
        showToast("请填写完整信息");
        return;
      }
    }
    i();
  }
  
  private void i()
  {
    if ((this.t == 1) && (!ah.isMobile(this.btnTel.getText())))
    {
      showToast("请填写正确的手机号");
      return;
    }
    if ((this.t == 1) && (!ah.isEmail(this.etEmail.getText().trim())))
    {
      showToast("请填写正确的邮箱格式");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.commonlibrary.login.a.getUid(this));
    localHashMap.put("customerSex", this.f + "");
    localHashMap.put("nickName", this.etNickname.getText().trim());
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String str = this.u + "-" + this.v + "-" + this.w;
    Long localLong = Long.valueOf(0L);
    try
    {
      long l = localSimpleDateFormat.parse(str).getTime();
      localLong = Long.valueOf(l);
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        localParseException.printStackTrace();
      }
    }
    localHashMap.put("customerBirthday", localLong + "");
    localHashMap.put("customerEmail", this.etEmail.getText().trim());
    localHashMap.put("resideAddr", this.etAddress.getText().trim());
    localHashMap.put("customerEdu", this.e + "");
    localHashMap.put("customerJob", this.etJob.getText().trim());
    com.ziroom.ziroomcustomer.minsu.e.a.updateLlInfo(this, localHashMap, new com.ziroom.commonlibrary.a.a(this, new p(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MinsuPersonalDataActivity.this.showToast("提交失败");
        u.e("personData", Log.getStackTraceString(paramAnonymousThrowable));
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        MinsuPersonalDataActivity.this.showToast("提交成功");
        MinsuPersonalDataActivity.this.setResult(-1, MinsuPersonalDataActivity.this.getIntent());
        MinsuPersonalDataActivity.this.finish();
      }
    });
  }
  
  private void j()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, MinsuPersonalIntroduceActivity.class);
    if (!TextUtils.isEmpty(this.c)) {
      localIntent.putExtra("introduce", this.c);
    }
    startActivityForResult(localIntent, 999);
  }
  
  private void k()
  {
    if (this.g != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((MinsuPersonInfo.Item)localIterator.next()).getName());
      }
      new com.ziroom.ziroomcustomer.dialog.e(this, new e.a()
      {
        public void showHour(String paramAnonymousString, int paramAnonymousInt)
        {
          MinsuPersonalDataActivity.this.btnGender.setText(paramAnonymousString);
          MinsuPersonalDataActivity.e(MinsuPersonalDataActivity.this, paramAnonymousInt + 1);
        }
      }, localArrayList, null).show();
    }
  }
  
  private void l()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((MinsuPersonInfo.Item)localIterator.next()).getName());
    }
    new com.ziroom.ziroomcustomer.dialog.e(this, new e.a()
    {
      public void showHour(String paramAnonymousString, int paramAnonymousInt)
      {
        MinsuPersonalDataActivity.this.btnEducate.setText(paramAnonymousString);
        MinsuPersonalDataActivity.f(MinsuPersonalDataActivity.this, paramAnonymousInt);
      }
    }, localArrayList, null).show();
  }
  
  private void m()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getIntroduce(this, null, new s(this, new r(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        Object localObject2 = com.alibaba.fastjson.a.parseObject(paramAnonymousString);
        Object localObject1 = null;
        paramAnonymousString = null;
        if (((com.alibaba.fastjson.e)localObject2).getJSONObject("data") != null)
        {
          localObject2 = ((Map)((com.alibaba.fastjson.e)localObject2).getObject("data", Map.class)).entrySet().iterator();
          for (;;)
          {
            localObject1 = paramAnonymousString;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            localObject1 = paramAnonymousString;
            if (!TextUtils.isEmpty(paramAnonymousString)) {
              break;
            }
            paramAnonymousString = (String)localEntry.getValue();
          }
        }
        if (localObject1 != null)
        {
          MinsuPersonalDataActivity.a(MinsuPersonalDataActivity.this, (String)localObject1);
          localObject1 = MinsuPersonalDataActivity.this.btnIntroduce;
          if (MinsuPersonalDataActivity.f(MinsuPersonalDataActivity.this).length() >= 10) {
            break label147;
          }
        }
        label147:
        for (paramAnonymousString = MinsuPersonalDataActivity.f(MinsuPersonalDataActivity.this);; paramAnonymousString = MinsuPersonalDataActivity.f(MinsuPersonalDataActivity.this).substring(0, 10) + "...")
        {
          ((LabeledEditText)localObject1).setText(paramAnonymousString);
          return;
        }
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    case 999: 
      paramIntent = paramIntent.getStringExtra("introduce");
      if (paramIntent != null) {
        this.c = paramIntent.trim();
      }
      if (this.c.length() < 10) {}
      for (paramIntent = this.c;; paramIntent = this.c.substring(0, 10) + "...")
      {
        this.btnIntroduce.setText(paramIntent);
        b();
        return;
      }
    }
    paramIntent = paramIntent.getStringExtra("phone");
    d.d("tag", "==========:" + paramIntent);
    this.btnTel.setText(paramIntent);
  }
  
  @OnClick({2131696311, 2131696312, 2131696313, 2131696316, 2131696318, 2131689816})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131696311: 
      k();
      return;
    case 2131696312: 
      g();
      return;
    case 2131696313: 
      startActivityForResult(new Intent(this, MinsuPhoneInputActivity.class), 1);
      return;
    case 2131696316: 
      l();
      return;
    case 2131696318: 
      j();
      return;
    }
    h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130904743);
    ButterKnife.bind(this);
    a();
    e();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuPersonalDataActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */