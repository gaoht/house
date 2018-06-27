package com.ziroom.ziroomcustomer.findhouse;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep.TransitRouteStepType;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import java.util.HashMap;
import java.util.List;

public class RoutePlanningDetailActivity
  extends BaseActivity
{
  private TransitRouteLine a;
  
  private void a()
  {
    ((ImageView)findViewById(2131689492)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RoutePlanningDetailActivity.this.finish();
      }
    });
    Object localObject1 = (TextView)findViewById(2131692234);
    Object localObject2 = (HashMap)getIntent().getSerializableExtra("data");
    ((TextView)findViewById(2131692236)).setText((CharSequence)((HashMap)localObject2).get("name"));
    ((TextView)findViewById(2131690567)).setText((CharSequence)((HashMap)localObject2).get("detail"));
    if (this.a == null)
    {
      g.textToast(this, "获取路线失败！");
      return;
    }
    ((TextView)findViewById(2131692239)).setText(this.a.getStarting().getTitle());
    ((TextView)findViewById(2131692245)).setText(this.a.getTerminal().getTitle());
    ((TextView)localObject1).setText(this.a.getTerminal().getTitle());
    int i;
    label220:
    LinearLayout localLinearLayout;
    label231:
    TransitRouteLine.TransitStep localTransitStep;
    View localView;
    String str;
    if ("WAKLING".equals(((TransitRouteLine.TransitStep)this.a.getAllStep().get(0)).getStepType().name()))
    {
      ((TextView)findViewById(2131692242)).setText(((TransitRouteLine.TransitStep)this.a.getAllStep().get(0)).getInstructions());
      i = 1;
      localLinearLayout = (LinearLayout)findViewById(2131692244);
      if (i < this.a.getAllStep().size())
      {
        localTransitStep = (TransitRouteLine.TransitStep)this.a.getAllStep().get(i);
        localView = getLayoutInflater().inflate(2130904483, null);
        localObject2 = localTransitStep.getInstructions();
        if (!"SUBWAY".equals(localTransitStep.getStepType().name())) {
          break label574;
        }
        localObject1 = localObject2.split(",")[0].replace("乘坐", "");
        if ((((String)localObject1).split("\\(").length <= 1) || (TextUtils.isEmpty(localObject1.split("\\(")[1].replace(")", "")))) {
          break label537;
        }
        str = localObject1.split("\\(")[1].replace(")", "") + localObject2.split(",经过")[1];
        localObject2 = localObject1;
        localObject1 = str;
      }
    }
    for (;;)
    {
      label393:
      ((TextView)localView.findViewById(2131694348)).setText((CharSequence)localObject2);
      ((TextView)localView.findViewById(2131695598)).setText((CharSequence)localObject1);
      ((TextView)localView.findViewById(2131695599)).setText(localTransitStep.getExit().getTitle());
      i += 1;
      localObject1 = (TextView)localView.findViewById(2131695600);
      if (this.a.getAllStep().size() > i) {
        ((TextView)localObject1).setText(((TransitRouteLine.TransitStep)this.a.getAllStep().get(i)).getInstructions());
      }
      for (;;)
      {
        localLinearLayout.addView(localView);
        i += 1;
        break label231;
        break;
        findViewById(2131692243).setVisibility(8);
        findViewById(2131692240).setVisibility(8);
        i = 0;
        break label220;
        label537:
        if (((String)localObject2).split(",经过").length > 1)
        {
          str = localObject2.split(",经过")[1];
          localObject2 = localObject1;
          localObject1 = str;
          break label393;
        }
        localObject2 = localObject1;
        localObject1 = "";
        break label393;
        label574:
        if (!"BUSLINE".equals(localTransitStep.getStepType().name())) {
          break label672;
        }
        if (((String)localObject2).split(",").length > 0) {}
        for (localObject1 = localObject2.split(",")[0].replace("乘坐", "");; localObject1 = "")
        {
          if (((String)localObject2).split(",经过").length <= 1) {
            break label651;
          }
          str = localObject2.split(",经过")[1];
          localObject2 = localObject1;
          localObject1 = str;
          break;
        }
        label651:
        str = "";
        localObject2 = localObject1;
        localObject1 = str;
        break label393;
        ((TextView)localObject1).setText("");
      }
      label672:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903461);
    paramBundle = getIntent().getStringExtra("key");
    this.a = ((TransitRouteLine)ApplicationEx.c.getData(paramBundle));
    ApplicationEx.c.clearData(paramBundle);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/RoutePlanningDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */