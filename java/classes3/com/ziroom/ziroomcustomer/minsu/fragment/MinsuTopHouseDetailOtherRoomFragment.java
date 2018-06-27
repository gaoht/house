package com.ziroom.ziroomcustomer.minsu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.ziroom.ziroomcustomer.minsu.activity.MinsuTopHouseDetailLiteActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.util.ac;

public class MinsuTopHouseDetailOtherRoomFragment
  extends BaseFragment
{
  private MinsuHouseBean.DataBean.ListBean a;
  
  public static MinsuTopHouseDetailOtherRoomFragment newInstance(MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    MinsuTopHouseDetailOtherRoomFragment localMinsuTopHouseDetailOtherRoomFragment = new MinsuTopHouseDetailOtherRoomFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("MinsuHouseBean", paramListBean);
    localMinsuTopHouseDetailOtherRoomFragment.setArguments(localBundle);
    return localMinsuTopHouseDetailOtherRoomFragment;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null) {
      this.a = ((MinsuHouseBean.DataBean.ListBean)getArguments().getSerializable("MinsuHouseBean"));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130904358, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = (SimpleDraweeView)paramView.findViewById(2131695249);
    paramBundle.setHierarchy(d.getHierarchy(getContext()));
    paramBundle.getLayoutParams().height = (ac.getScreenWidth(getContext()) / 16 * 9);
    paramBundle.setController(c.frescoController(this.a.picUrl));
    ((TextView)paramView.findViewById(2131695250)).setText(this.a.houseName);
    if (this.a.personCount > 0) {
      paramBundle = this.a.rentWayName + " | 可住" + this.a.personCount + "人";
    }
    for (;;)
    {
      ((TextView)paramView.findViewById(2131695251)).setText(paramBundle);
      ((TextView)paramView.findViewById(2131689912)).setText("¥ " + ad.getPriceInt(this.a.price) + "/晚");
      if (this.a.evaluateCount > 0)
      {
        ((TextView)paramView.findViewById(2131695252)).setText("评价  " + this.a.evaluateCount);
        paramView.findViewById(2131695252).setVisibility(0);
      }
      for (;;)
      {
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(MinsuTopHouseDetailOtherRoomFragment.this.getActivity(), MinsuTopHouseDetailLiteActivity.class);
            paramAnonymousView.putExtra("fid", MinsuTopHouseDetailOtherRoomFragment.a(MinsuTopHouseDetailOtherRoomFragment.this).fid);
            paramAnonymousView.putExtra("rentWay", MinsuTopHouseDetailOtherRoomFragment.a(MinsuTopHouseDetailOtherRoomFragment.this).rentWay);
            MinsuTopHouseDetailOtherRoomFragment.this.getActivity().startActivity(paramAnonymousView);
          }
        });
        return;
        if (this.a.personCount != 0) {
          break label312;
        }
        paramBundle = this.a.rentWayName + " | 不限人数";
        break;
        paramView.findViewById(2131695252).setVisibility(8);
      }
      label312:
      paramBundle = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/fragment/MinsuTopHouseDetailOtherRoomFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */