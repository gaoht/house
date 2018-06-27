package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.g;
import com.ziroom.ziroomcustomer.bestgoods.model.QualifcationProofMo;
import java.util.ArrayList;

public class QualificationProofAc
  extends BaseActivity
  implements View.OnClickListener
{
  private Context a;
  private RecyclerView b;
  private View c;
  private ArrayList<QualifcationProofMo> d;
  
  private void a()
  {
    this.c = findViewById(2131689492);
    this.b = ((RecyclerView)findViewById(2131692111));
    this.b.setLayoutManager(new LinearLayoutManager(this, 1, false));
    this.b.setAdapter(new g(this.a, this.d));
  }
  
  private void b()
  {
    this.c.setOnClickListener(this);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903436);
    this.a = this;
    this.d = getIntent().getParcelableArrayListExtra("qualityInspection");
    a();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/QualificationProofAc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */