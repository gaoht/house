package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.MyAppointActivity;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import com.ziroom.ziroomcustomer.ziroomapartment.a.e;
import com.ziroom.ziroomcustomer.ziroomapartment.model.AppointmentModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.AppointmentModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ApartmentAppointmentActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private SimpleDateFormat A = new SimpleDateFormat("MM月dd日 E");
  private SimpleDateFormat B = new SimpleDateFormat("yyyy-MM-dd");
  private String C;
  private String D;
  private String E;
  private String F;
  private String G = "";
  private String H;
  private String I;
  private Context a;
  private LabeledEditText b;
  private LabeledEditText c;
  private LabeledEditText d;
  private EditText e;
  private View f;
  private View g;
  private TextView r;
  private SimpleDraweeView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private boolean x = false;
  private boolean y = false;
  private boolean z = false;
  
  private void a()
  {
    this.f = findViewById(2131689843);
    this.g = findViewById(2131691493);
    findViewById(2131696484).setVisibility(8);
    this.r = ((TextView)findViewById(2131689541));
    this.r.setText("预约看房");
    this.b = ((LabeledEditText)findViewById(2131689914));
    this.c = ((LabeledEditText)findViewById(2131689915));
    this.d = ((LabeledEditText)findViewById(2131689916));
    this.e = ((EditText)findViewById(2131689917));
    this.s = ((SimpleDraweeView)findViewById(2131689908));
    this.t = ((TextView)findViewById(2131689909));
    this.u = ((TextView)findViewById(2131689911));
    this.v = ((TextView)findViewById(2131689912));
    this.w = ((TextView)findViewById(2131689913));
  }
  
  private void b()
  {
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.b.disposeFocus(this.r);
    this.c.disposeFocus(this.r);
    this.d.setOnClickListener(this);
    this.b.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        ApartmentAppointmentActivity localApartmentAppointmentActivity = ApartmentAppointmentActivity.this;
        if (paramAnonymousCharSequence.length() > 0) {}
        for (boolean bool = true;; bool = false)
        {
          ApartmentAppointmentActivity.a(localApartmentAppointmentActivity, bool);
          ApartmentAppointmentActivity.a(ApartmentAppointmentActivity.this);
          return;
        }
      }
    });
    this.c.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() > 11)
        {
          ApartmentAppointmentActivity.b(ApartmentAppointmentActivity.this).setText(paramAnonymousEditable.toString().substring(0, 11));
          ApartmentAppointmentActivity.b(ApartmentAppointmentActivity.this).setSelection(ApartmentAppointmentActivity.b(ApartmentAppointmentActivity.this).getText().length());
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        ApartmentAppointmentActivity localApartmentAppointmentActivity = ApartmentAppointmentActivity.this;
        if (paramAnonymousCharSequence.length() == 11) {}
        for (boolean bool = true;; bool = false)
        {
          ApartmentAppointmentActivity.b(localApartmentAppointmentActivity, bool);
          ApartmentAppointmentActivity.a(ApartmentAppointmentActivity.this);
          return;
        }
      }
    });
  }
  
  private void e()
  {
    Object localObject2 = getIntent();
    this.E = ((Intent)localObject2).getExtras().getString("projectId", "");
    this.F = ((Intent)localObject2).getExtras().getString("houseTypeId", "");
    Object localObject1 = ((Intent)localObject2).getStringExtra("proAddr");
    String str1 = ((Intent)localObject2).getStringExtra("proHeadPic");
    String str2 = ((Intent)localObject2).getStringExtra("proName");
    String str3 = ((Intent)localObject2).getStringExtra("minPrice");
    String str4 = ((Intent)localObject2).getStringExtra("maxPrice");
    localObject2 = ((Intent)localObject2).getStringExtra("houseTypeName");
    this.s.setController(com.freelxl.baselibrary.f.c.frescoController(str1));
    this.t.setText(str2);
    this.u.setText((CharSequence)localObject1);
    this.v.setText("¥ " + str3 + "-" + str4);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      this.w.setVisibility(8);
      localObject1 = ApplicationEx.c.getUser();
      str1 = ad.getOther(this, this.H);
      str2 = ad.getOther(this, this.I);
      if (localObject1 != null)
      {
        if (ae.isNull(str1)) {
          break label250;
        }
        this.b.setText(str1);
        label214:
        if (ae.isNull(str2)) {
          break label274;
        }
        this.c.setText(str2);
      }
    }
    label250:
    label274:
    while (TextUtils.isEmpty(((UserInfo)localObject1).getLogin_name_mobile()))
    {
      return;
      this.w.setVisibility(0);
      this.w.setText((CharSequence)localObject2);
      break;
      if (TextUtils.isEmpty(((UserInfo)localObject1).getUser_name())) {
        break label214;
      }
      this.b.setText(((UserInfo)localObject1).getUser_name());
      break label214;
    }
    this.c.setText(((UserInfo)localObject1).getLogin_name_mobile());
  }
  
  private void f()
  {
    if ((this.x) && (this.y) && (this.z))
    {
      this.f.setBackgroundColor(Color.parseColor("#ffa000"));
      return;
    }
    this.f.setBackgroundColor(Color.parseColor("#ffa000"));
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689843: 
      if (!this.x)
      {
        af.showToast(this.a, "请输入姓名");
        return;
      }
      if (!this.y)
      {
        af.showToast(this.a, "请输入正确的手机号");
        return;
      }
      if (!this.z)
      {
        af.showToast(this.a, "请选择约看时间");
        return;
      }
      if (ApplicationEx.c.getUser() != null)
      {
        paramView = com.ziroom.ziroomcustomer.ziroomapartment.a.c.buildCommitApply(this, this.G, this.b.getText(), this.c.getText(), VdsAgent.trackEditTextSilent(this.e).toString(), this.E, this.F, this.d.getText().toString().trim());
        ad.putOther(this, this.H, this.b.getText());
        ad.putOther(this, this.I, this.c.getText());
        e.commitApply(this.a, new i.a()
        {
          public void onParse(String paramAnonymousString, k paramAnonymousk) {}
          
          public void onSuccess(k paramAnonymousk)
          {
            paramAnonymousk = (AppointmentModel)paramAnonymousk.getObject();
            if ((paramAnonymousk != null) && ("200".equals(paramAnonymousk.getError_code())))
            {
              if ((paramAnonymousk.getData() != null) && (!TextUtils.isEmpty(paramAnonymousk.getData().getMessage()))) {
                af.showToast(ApartmentAppointmentActivity.c(ApartmentAppointmentActivity.this), paramAnonymousk.getData().getMessage());
              }
              for (;;)
              {
                paramAnonymousk = new Intent(ApartmentAppointmentActivity.this, MyAppointActivity.class);
                ApartmentAppointmentActivity.this.startActivity(paramAnonymousk);
                ApartmentAppointmentActivity.this.finish();
                return;
                af.showToast(ApartmentAppointmentActivity.c(ApartmentAppointmentActivity.this), "预约成功");
              }
            }
            if ((paramAnonymousk != null) && (!TextUtils.isEmpty(paramAnonymousk.getError_message())))
            {
              af.showToast(ApartmentAppointmentActivity.c(ApartmentAppointmentActivity.this), paramAnonymousk.getError_message());
              return;
            }
            af.showToast(ApartmentAppointmentActivity.c(ApartmentAppointmentActivity.this), "服务器异常，正在努力抢修中，请稍后再试!");
          }
        }, paramView, true);
        return;
      }
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      return;
    case 2131691493: 
      finish();
      return;
    }
    paramView = new ArrayList();
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    while (i < 7)
    {
      Date localDate = new Date(System.currentTimeMillis() + 86400000 * (i + 1));
      paramView.add(this.A.format(localDate));
      localArrayList1.add(this.A.format(localDate));
      localArrayList2.add(this.B.format(localDate));
      i += 1;
    }
    i = 9;
    if (i <= 18)
    {
      if (i < 10)
      {
        localArrayList3.add("0" + i + ":00");
        localArrayList3.add("0" + i + ":30");
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList3.add(i + ":00");
        localArrayList3.add(i + ":30");
      }
    }
    localArrayList3.remove(localArrayList3.size() - 1);
    new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(this.a, "预约看房时间", new a.b()
    {
      public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
      {
        int i = 0;
        for (;;)
        {
          if (i < localArrayList1.size())
          {
            if (((String)localArrayList1.get(i)).equals(paramAnonymousHashMap.get(Integer.valueOf(0)))) {
              ApartmentAppointmentActivity.a(ApartmentAppointmentActivity.this, (String)localArrayList2.get(i));
            }
          }
          else
          {
            ApartmentAppointmentActivity.b(ApartmentAppointmentActivity.this, (String)paramAnonymousHashMap.get(Integer.valueOf(1)));
            ApartmentAppointmentActivity.f(ApartmentAppointmentActivity.this).setText(ApartmentAppointmentActivity.d(ApartmentAppointmentActivity.this) + " " + ApartmentAppointmentActivity.e(ApartmentAppointmentActivity.this));
            ApartmentAppointmentActivity.c(ApartmentAppointmentActivity.this, true);
            ApartmentAppointmentActivity.a(ApartmentAppointmentActivity.this);
            return;
          }
          i += 1;
        }
      }
    }, new List[] { paramView, localArrayList3 }).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903094);
    getWindow().setSoftInputMode(32);
    this.a = this;
    if (ApplicationEx.c.getUser() != null)
    {
      this.G = ApplicationEx.c.getUser().getUid();
      this.H = (this.G + "_" + "zryu_custom_name");
      this.I = (this.G + "_" + "zryu_custom_phone");
    }
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ApartmentAppointmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */