package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.b.aa;
import com.ziroom.ziroomcustomer.newclean.d.be;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.util.Map;

public class BiWeeklyQuestionnaireActivity
  extends BaseActivity
{
  private SimpleDraweeView a;
  private TextView b;
  private ListViewForScrollView c;
  private Button d;
  private String e;
  private aa f;
  private boolean g;
  private String r;
  private ImageView s;
  
  private void a()
  {
    b();
    this.a = ((SimpleDraweeView)findViewById(2131690070));
    this.b = ((TextView)findViewById(2131690049));
    this.c = ((ListViewForScrollView)findViewById(2131690077));
    this.d = ((Button)findViewById(2131689816));
  }
  
  private void b()
  {
    this.s = ((ImageView)findViewById(2131691493));
    findViewById(2131696484).setVisibility(8);
    ((ImageView)findViewById(2131696483)).setVisibility(8);
    ((TextView)findViewById(2131689541)).setText("服务质量调查");
  }
  
  private void e()
  {
    getIntent();
    this.g = getIntent().getBooleanExtra("isFormDetail", false);
    this.r = getIntent().getStringExtra("cleanerId");
    this.e = getIntent().getStringExtra("billId");
    String str1 = getIntent().getStringExtra("avatar");
    String str2 = getIntent().getStringExtra("cleanerName");
    this.s.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (BiWeeklyQuestionnaireActivity.a(BiWeeklyQuestionnaireActivity.this))
        {
          BiWeeklyQuestionnaireActivity.this.setResult(0);
          BiWeeklyQuestionnaireActivity.this.finish();
          return;
        }
        BiWeeklyQuestionnaireActivity.this.finish();
        BiWeeklyQuestionnaireActivity.b(BiWeeklyQuestionnaireActivity.this);
      }
    });
    this.a.setController(c.frescoController(str1));
    this.b.setText(str2);
    n.getQuestionnaire(this, this.e, new com.ziroom.ziroomcustomer.e.a.a(this, new m(be.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, be paramAnonymousbe)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousbe);
        if (paramAnonymousbe != null)
        {
          BiWeeklyQuestionnaireActivity.a(BiWeeklyQuestionnaireActivity.this, new aa(BiWeeklyQuestionnaireActivity.this, paramAnonymousbe));
          BiWeeklyQuestionnaireActivity.d(BiWeeklyQuestionnaireActivity.this).setAdapter(BiWeeklyQuestionnaireActivity.c(BiWeeklyQuestionnaireActivity.this));
          BiWeeklyQuestionnaireActivity.e(BiWeeklyQuestionnaireActivity.this).setEnabled(true);
        }
      }
    });
  }
  
  private void f()
  {
    if (this.f != null)
    {
      if (this.f.isAllSelected())
      {
        Map localMap = this.f.getSelectedData();
        n.postQuestionnaire(this, this.e, localMap, new com.ziroom.ziroomcustomer.e.a.a(this, new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
        {
          public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousString);
            if (BiWeeklyQuestionnaireActivity.a(BiWeeklyQuestionnaireActivity.this))
            {
              BiWeeklyQuestionnaireActivity.this.finish();
              return;
            }
            BiWeeklyQuestionnaireActivity.this.finish();
            BiWeeklyQuestionnaireActivity.b(BiWeeklyQuestionnaireActivity.this);
          }
        });
      }
    }
    else {
      return;
    }
    g.textToast(this, "您还没有填完哦~");
  }
  
  private void g()
  {
    if (ApplicationEx.c.getUser() == null) {
      return;
    }
    j.createShareOrder(this, this.e, "", "2c9094833db58ad9013db58dfe070002", this.r);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903118);
    a();
    e();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    f();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BiWeeklyQuestionnaireActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */