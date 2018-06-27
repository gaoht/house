package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.RepairScore;
import com.ziroom.ziroomcustomer.model.RepairScoreResult;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.newServiceList.model.al;
import com.ziroom.ziroomcustomer.newrepair.a.n;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepairEvaluationsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView a;
  private LinearLayout b;
  private ListView c;
  private EditText d;
  private Button e;
  private n f;
  private List<RepairScore> g = new ArrayList();
  private al r;
  private boolean s = false;
  private Context t;
  private Handler u = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage == null) || (paramAnonymousMessage.obj == null)) {
        return;
      }
      Object localObject = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 4130: 
        if (((l)localObject).getSuccess().booleanValue())
        {
          paramAnonymousMessage = (List)((l)localObject).getObject();
          RepairEvaluationsActivity.a(RepairEvaluationsActivity.this).clear();
          RepairEvaluationsActivity.a(RepairEvaluationsActivity.this).addAll(paramAnonymousMessage);
          RepairEvaluationsActivity.b(RepairEvaluationsActivity.this).notifyDataSetChanged();
          if (RepairEvaluationsActivity.c(RepairEvaluationsActivity.this)) {
            o.getRepairScore(RepairEvaluationsActivity.this, RepairEvaluationsActivity.d(RepairEvaluationsActivity.this), RepairEvaluationsActivity.e(RepairEvaluationsActivity.this).getFid());
          }
        }
        for (;;)
        {
          RepairEvaluationsActivity.this.dismissProgress();
          return;
          g.textToast(RepairEvaluationsActivity.f(RepairEvaluationsActivity.this), ((l)localObject).getMessage());
        }
      case 4131: 
        RepairEvaluationsActivity.this.dismissProgress();
        if (((l)localObject).getSuccess().booleanValue())
        {
          g.textToast(RepairEvaluationsActivity.f(RepairEvaluationsActivity.this), "评价提交成功！");
          paramAnonymousMessage = new Intent(RepairEvaluationsActivity.this, ZiroomOrderListActivity.class);
          localObject = RepairEvaluationsActivity.this.getIntent().getExtras();
          ((Bundle)localObject).putInt("query_index_contract", ((Bundle)localObject).getInt("query_index_contract"));
          paramAnonymousMessage.putExtra("ServiceList", "repair");
          paramAnonymousMessage.putExtras((Bundle)localObject);
          RepairEvaluationsActivity.this.startActivity(paramAnonymousMessage);
          RepairEvaluationsActivity.this.finish();
          return;
        }
        g.textToast(RepairEvaluationsActivity.f(RepairEvaluationsActivity.this), ((l)localObject).getMessage());
        return;
      }
      if (((l)localObject).getSuccess().booleanValue())
      {
        paramAnonymousMessage = (RepairScoreResult)((l)localObject).getObject();
        RepairEvaluationsActivity.a(RepairEvaluationsActivity.this, paramAnonymousMessage);
        return;
      }
      g.textToast(RepairEvaluationsActivity.f(RepairEvaluationsActivity.this), ((l)localObject).getMessage());
    }
  };
  
  private void a()
  {
    this.b = ((LinearLayout)findViewById(2131689918));
    this.a = ((ImageView)findViewById(2131689492));
    this.a.setOnClickListener(this);
    if (!checkNet(getApplicationContext()))
    {
      this.b.setVisibility(8);
      g.textToast(this.t, "网络请求失败，请检查您的网络设置");
      return;
    }
    this.c = ((ListView)findViewById(2131697384));
    this.d = ((EditText)findViewById(2131697385));
    this.e = ((Button)findViewById(2131689843));
    this.f = new n(this, this.g);
    this.c.setAdapter(this.f);
    this.e.setOnClickListener(this);
    if (this.s)
    {
      this.c.setEnabled(false);
      this.d.setEnabled(false);
      this.e.setVisibility(8);
      this.f.setOnlyRead();
    }
    showProgress("加载中...");
    o.getRepairScoreItem(this, this.u);
  }
  
  private void a(RepairScoreResult paramRepairScoreResult)
  {
    if (paramRepairScoreResult != null)
    {
      this.d.setText(paramRepairScoreResult.getRemark());
      Iterator localIterator1 = this.g.iterator();
      while (localIterator1.hasNext())
      {
        RepairScore localRepairScore1 = (RepairScore)localIterator1.next();
        Iterator localIterator2 = paramRepairScoreResult.getList().iterator();
        while (localIterator2.hasNext())
        {
          RepairScore localRepairScore2 = (RepairScore)localIterator2.next();
          if (localRepairScore1.getFID().equals(localRepairScore2.getFID())) {
            localRepairScore1.setVALUE(localRepairScore2.getVALUE());
          }
        }
      }
      this.f.notifyDataSetChanged();
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
    case 2131689843: 
      onCommit();
      return;
    }
    finish();
  }
  
  public void onCommit()
  {
    Object localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (ae.isNull(((RepairScore)((Iterator)localObject).next()).getVALUE()))
      {
        g.textToast(this.t, "请完整评价后，再提交哦！");
        return;
      }
    }
    showProgress("提交中...");
    localObject = ((ApplicationEx)getApplication()).getUser();
    o.setRepairScore(this, this.u, m.GetNowDate(), this.r.getFid(), ((UserInfo)localObject).getLogin_name_mobile(), this.r.getCName(), VdsAgent.trackEditTextSilent(this.d).toString(), 3, this.r.getRNo(), this.g);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905089);
    this.t = this;
    this.r = ((al)getIntent().getSerializableExtra("repair_info"));
    this.s = getIntent().getBooleanExtra("only_read", false);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/RepairEvaluationsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */