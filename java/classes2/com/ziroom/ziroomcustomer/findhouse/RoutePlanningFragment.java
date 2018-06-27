package com.ziroom.ziroomcustomer.findhouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import java.util.HashMap;

public class RoutePlanningFragment
  extends BaseFragment
{
  private View a;
  private TextView b;
  private TextView c;
  private ImageView d;
  private TransitRouteLine e;
  private HashMap<String, Object> f;
  
  public RoutePlanningFragment() {}
  
  public RoutePlanningFragment(TransitRouteLine paramTransitRouteLine, HashMap<String, Object> paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("map", paramHashMap);
    localBundle.putParcelable("line", paramTransitRouteLine);
    setArguments(localBundle);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = paramLayoutInflater.inflate(2130903981, null, false);
    this.e = ((TransitRouteLine)getArguments().getParcelable("line"));
    this.f = ((HashMap)getArguments().getSerializable("map"));
    this.b = ((TextView)this.a.findViewById(2131694348));
    this.c = ((TextView)this.a.findViewById(2131694349));
    this.d = ((ImageView)this.a.findViewById(2131694350));
    if (this.f != null)
    {
      this.b.setText(this.f.get("name") + "");
      this.c.setText(this.f.get("detail") + "");
    }
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ApplicationEx.c.putData("detail_btn", RoutePlanningFragment.a(RoutePlanningFragment.this));
        paramAnonymousView = new Intent(RoutePlanningFragment.this.getActivity(), RoutePlanningDetailActivity.class);
        paramAnonymousView.putExtra("key", "detail_btn");
        paramAnonymousView.putExtra("data", RoutePlanningFragment.b(RoutePlanningFragment.this));
        RoutePlanningFragment.this.startActivity(paramAnonymousView);
      }
    });
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/RoutePlanningFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */