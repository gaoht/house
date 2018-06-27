package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.newServiceList.model.y;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RentEvalActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private List<String> A = new ArrayList();
  private ImageView a;
  private Context b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private Button r;
  private EditText s;
  private int t = 0;
  private TextView u;
  private FlowLayout v;
  private String w;
  private String x;
  private String y;
  private Handler z = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69955: 
        if (locall.getSuccess().booleanValue())
        {
          paramAnonymousMessage = (y)locall.getObject();
          RentEvalActivity.a(RentEvalActivity.this, paramAnonymousMessage.getSign());
        }
        for (;;)
        {
          RentEvalActivity.this.dismissProgress();
          return;
          af.showToast(RentEvalActivity.a(RentEvalActivity.this), locall.getMessage());
        }
      }
      if (locall.getSuccess().booleanValue()) {
        RentEvalActivity.this.finish();
      }
      for (;;)
      {
        RentEvalActivity.this.dismissProgress();
        return;
        af.showToast(RentEvalActivity.a(RentEvalActivity.this), locall.getMessage());
      }
    }
  };
  
  private void a()
  {
    this.x = getIntent().getStringExtra("workOrderId");
    String str = getIntent().getStringExtra("dealPeople");
    this.y = getIntent().getStringExtra("dealPhone");
    if (TextUtils.isEmpty(this.y)) {
      this.a.setVisibility(8);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        this.u.setText(str);
      }
      return;
      this.a.setVisibility(0);
      this.a.setOnClickListener(this);
    }
  }
  
  private void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        d((String)paramList.next());
      }
    }
  }
  
  private void b()
  {
    this.a = ((ImageView)findViewById(2131691963));
    this.c = ((ImageView)findViewById(2131690054));
    this.d = ((ImageView)findViewById(2131690055));
    this.e = ((ImageView)findViewById(2131690056));
    this.f = ((ImageView)findViewById(2131690057));
    this.g = ((ImageView)findViewById(2131690058));
    this.r = ((Button)findViewById(2131689843));
    this.s = ((EditText)findViewById(2131690002));
    this.u = ((TextView)findViewById(2131690371));
    this.v = ((FlowLayout)findViewById(2131691964));
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.r.setOnClickListener(this);
    findViewById(2131689492).setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    this.t = paramInt;
    this.w = "";
    this.A.clear();
    this.v.removeAllViews();
    o.getRentStarTag(this.b, this.z, paramInt);
    showProgress("");
    if (paramInt == 1)
    {
      this.c.setImageResource(2130839757);
      this.d.setImageResource(2130839753);
      this.e.setImageResource(2130839753);
      this.f.setImageResource(2130839753);
      this.g.setImageResource(2130839753);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        this.c.setImageResource(2130839757);
        this.d.setImageResource(2130839757);
        this.e.setImageResource(2130839753);
        this.f.setImageResource(2130839753);
        this.g.setImageResource(2130839753);
        return;
      }
      if (paramInt == 3)
      {
        this.c.setImageResource(2130839757);
        this.d.setImageResource(2130839757);
        this.e.setImageResource(2130839757);
        this.f.setImageResource(2130839753);
        this.g.setImageResource(2130839753);
        return;
      }
      if (paramInt == 4)
      {
        this.c.setImageResource(2130839757);
        this.d.setImageResource(2130839757);
        this.e.setImageResource(2130839757);
        this.f.setImageResource(2130839757);
        this.g.setImageResource(2130839753);
        return;
      }
    } while (paramInt != 5);
    this.c.setImageResource(2130839757);
    this.d.setImageResource(2130839757);
    this.e.setImageResource(2130839757);
    this.f.setImageResource(2130839757);
    this.g.setImageResource(2130839757);
  }
  
  private void d(String paramString)
  {
    Button localButton = new Button(this);
    localButton.setText(paramString);
    localButton.setTag(Boolean.valueOf(false));
    localButton.setTextColor(getResources().getColor(2131624516));
    localButton.setTextSize(12.0F);
    localButton.setPadding(20, 10, 20, 10);
    localButton.setBackgroundResource(2130839371);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(10, 10, 10, 10);
    localButton.setLayoutParams(paramString);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = (Button)paramAnonymousView;
        String str = paramAnonymousView.getText().toString();
        if (!((Boolean)paramAnonymousView.getTag()).booleanValue())
        {
          paramAnonymousView.setBackgroundResource(2130839376);
          paramAnonymousView.setTextColor(RentEvalActivity.this.getResources().getColor(2131624583));
          paramAnonymousView.setTag(Boolean.valueOf(true));
          RentEvalActivity.a(RentEvalActivity.this, str);
          return;
        }
        paramAnonymousView.setBackgroundResource(2130839371);
        paramAnonymousView.setTextColor(RentEvalActivity.this.getResources().getColor(2131624516));
        paramAnonymousView.setTag(Boolean.valueOf(false));
        RentEvalActivity.b(RentEvalActivity.this, str);
      }
    });
    this.v.addView(localButton);
  }
  
  private void e()
  {
    String str = VdsAgent.trackEditTextSilent(this.s).toString();
    if (this.t == 0)
    {
      showToast("评分不能空");
      return;
    }
    this.w = "";
    if ((this.A != null) && (this.A.size() > 0))
    {
      if (this.A.size() != 1) {
        break label137;
      }
      this.w = ((String)this.A.get(0));
    }
    for (;;)
    {
      str = this.w + "^$" + str;
      o.setRentEvaluate(this.b, this.z, this.x, this.t, str);
      showProgress("");
      return;
      label137:
      int i = 0;
      while (i < this.A.size())
      {
        this.w = (this.w + (String)this.A.get(i) + "|#");
        i += 1;
      }
    }
  }
  
  private void e(String paramString)
  {
    this.A.add(paramString);
  }
  
  private void f(String paramString)
  {
    if ((this.A != null) && (this.A.size() > 0) && (this.A.contains(paramString))) {
      this.A.remove(paramString);
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691963: 
      ah.callPhone(this.b, this.y);
      return;
    case 2131690054: 
      b(1);
      return;
    case 2131690055: 
      b(2);
      return;
    case 2131690056: 
      b(3);
      return;
    case 2131690057: 
      b(4);
      return;
    case 2131690058: 
      b(5);
      return;
    case 2131689492: 
      finish();
      return;
    }
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903394);
    this.b = this;
    b();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RentEvalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */