package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.a.f;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanCard;
import com.ziroom.ziroomcustomer.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class RepairOverdueCardActivity
  extends BaseActivity
{
  private ImageView a;
  private XListView b;
  private f c;
  private RelativeLayout d;
  private TextView e;
  private Context f;
  private List<CleanCard> g = new ArrayList();
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((XListView)findViewById(2131690240));
    this.d = ((RelativeLayout)findViewById(2131690202));
    this.e = ((TextView)findViewById(2131690203));
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RepairOverdueCardActivity.this.finish();
      }
    });
    ((TextView)findViewById(2131689541)).setText("无效自如维修卡");
    this.g = ((List)getIntent().getSerializableExtra("overdueCardList"));
    if ((this.g != null) && (this.g.size() > 0))
    {
      this.d.setVisibility(8);
      this.c = new f(this.f, this.g);
      this.b.setAdapter(this.c);
    }
    for (;;)
    {
      this.b.setPullLoadEnable(false);
      this.b.setPullRefreshEnable(false);
      return;
      this.d.setVisibility(0);
      this.e.setText("您没有无效自如维修卡");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903141);
    this.f = this;
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairOverdueCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */