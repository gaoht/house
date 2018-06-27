package com.ziroom.ziroomcustomer.newchat.chatcenter.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.d.b.c;
import com.freelxl.baselibrary.d.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.p.b;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.newchat.chatcenter.MySuggestionActivity;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.p;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.p.a;

public class AcceptSuccessActivity
  extends BaseActivity
{
  private TextView a;
  private TextView b;
  private ImageView c;
  private String d;
  private String e = "非常感谢您的宝贵建议，我们将反馈给具体负责人，祝您生活自如";
  private String f = "非常抱歉给您的生活带来不便，我们已收到您的投诉，预计将在";
  private String g = "前受理您提交的投诉单，请您关注最新反馈。";
  private TextView r;
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131692599));
    this.b = ((TextView)findViewById(2131690084));
    this.c = ((ImageView)findViewById(2131689492));
    this.r = ((TextView)findViewById(2131689541));
    this.d = getIntent().getStringExtra("pageType");
    if ("suggest".equals(this.d))
    {
      e();
      return;
    }
    b();
  }
  
  private void a(p paramp)
  {
    paramp = paramp.getData().getAcceptTime();
    SpannableString localSpannableString = new SpannableString(this.f + paramp + this.g);
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131624039)), 0, this.f.length(), 34);
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131624588)), this.f.length(), (this.f + paramp).length(), 18);
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131624039)), (this.f + paramp).length(), (this.f + paramp + this.g).length(), 34);
    this.b.setText(localSpannableString);
  }
  
  private void b()
  {
    this.r.setText("投诉成功");
    f();
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(AcceptSuccessActivity.this, MySuggestionActivity.class);
        AcceptSuccessActivity.this.startActivity(paramAnonymousView);
        AcceptSuccessActivity.this.finish();
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        AcceptSuccessActivity.this.finish();
      }
    });
  }
  
  private void e()
  {
    this.a.setVisibility(8);
    this.b.setText(this.e);
    this.r.setText("提交成功");
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        AcceptSuccessActivity.this.finish();
      }
    });
  }
  
  private void f()
  {
    com.freelxl.baselibrary.d.a.post(q.k + p.b.br).tag(this).enqueue(new com.freelxl.baselibrary.d.c.a(new d(p.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        paramAnonymousObject = (p)paramAnonymousObject;
        if ((paramAnonymousObject != null) && (((p)paramAnonymousObject).getStatus() == 1)) {
          AcceptSuccessActivity.a(AcceptSuccessActivity.this, (p)paramAnonymousObject);
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903529);
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/activity/AcceptSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */