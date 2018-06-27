package com.ziroom.ziroomcustomer.ziroomstation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.BaseFragment;

public class StationServiceFragment
  extends BaseFragment
{
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new TextView(getActivity());
    paramLayoutInflater.setText("驿服务");
    paramLayoutInflater.setGravity(17);
    paramLayoutInflater.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    return paramLayoutInflater;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/fragment/StationServiceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */