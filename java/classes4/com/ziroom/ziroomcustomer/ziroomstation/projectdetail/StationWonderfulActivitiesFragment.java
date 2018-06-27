package com.ziroom.ziroomcustomer.ziroomstation.projectdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b.a.a;

public class StationWonderfulActivitiesFragment
  extends BaseFragment
{
  private b.a.a a;
  
  public static StationWonderfulActivitiesFragment newInstance(b.a.a parama)
  {
    StationWonderfulActivitiesFragment localStationWonderfulActivitiesFragment = new StationWonderfulActivitiesFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("StationActivityBean", parama);
    localStationWonderfulActivitiesFragment.setArguments(localBundle);
    return localStationWonderfulActivitiesFragment;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null) {
      this.a = ((b.a.a)getArguments().getSerializable("StationActivityBean"));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130904556, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = (SimpleDraweeView)paramView.findViewById(2131695249);
    paramBundle.setHierarchy(d.getHierarchy(getContext()));
    paramBundle.getLayoutParams().height = (ac.getScreenWidth(getContext()) / 16 * 9);
    paramBundle.setController(c.frescoController(this.a.getActivityUrl()));
    ((TextView)paramView.findViewById(2131695250)).setText(this.a.getActivityName());
    paramView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        JsBridgeWebActivity.start(StationWonderfulActivitiesFragment.this.getActivity(), StationWonderfulActivitiesFragment.a(StationWonderfulActivitiesFragment.this).getActivityName(), StationWonderfulActivitiesFragment.a(StationWonderfulActivitiesFragment.this).getLinkUrl(), true, StationWonderfulActivitiesFragment.this.getString(2131297158), StationWonderfulActivitiesFragment.a(StationWonderfulActivitiesFragment.this).getActivityUrl(), false);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/projectdetail/StationWonderfulActivitiesFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */