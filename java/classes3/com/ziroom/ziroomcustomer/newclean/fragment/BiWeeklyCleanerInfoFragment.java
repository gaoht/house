package com.ziroom.ziroomcustomer.newclean.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.a;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.newclean.activity.BiWeeklyCleanerInfoActivity;
import com.ziroom.ziroomcustomer.newclean.activity.BiWeeklyCleanerInfoActivity.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import java.util.List;

public class BiWeeklyCleanerInfoFragment
  extends BaseFragment
  implements BiWeeklyCleanerInfoActivity.b
{
  private BiWeeklyCleanerInfoActivity a;
  @BindView(2131690332)
  FlowLayout fl_like;
  @BindView(2131690052)
  TextView tv_age;
  @BindView(2131693963)
  TextView tv_constellation;
  @BindView(2131693964)
  TextView tv_fond;
  @BindView(2131693961)
  TextView tv_hiredate;
  @BindView(2131693962)
  TextView tv_native_place;
  @BindView(2131690003)
  TextView tv_num;
  @BindView(2131693960)
  TextView tv_service_place;
  
  private void c()
  {
    this.a = ((BiWeeklyCleanerInfoActivity)getActivity());
    this.a.setOnHasDataClickListener(this);
    w.onEventToZiroomAndUmeng("biweeklyclean_cleanner_info_personal_uv");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903897, paramViewGroup, false);
    ButterKnife.bind(this, paramLayoutInflater);
    c();
    return paramLayoutInflater;
  }
  
  public void onHasData()
  {
    Object localObject = this.a.getmCleanerInfo();
    u.d("djg", "======  " + a.toJSONString(localObject));
    if (localObject != null)
    {
      this.tv_service_place.setText(((com.ziroom.ziroomcustomer.newclean.d.j)localObject).getServiceHouses());
      this.tv_num.setText(((com.ziroom.ziroomcustomer.newclean.d.j)localObject).getServeNum());
      this.tv_hiredate.setText(((com.ziroom.ziroomcustomer.newclean.d.j)localObject).getHireDate());
      this.tv_native_place.setText(((com.ziroom.ziroomcustomer.newclean.d.j)localObject).getNativePlace());
      this.tv_age.setText(((com.ziroom.ziroomcustomer.newclean.d.j)localObject).getAge());
      this.tv_constellation.setText(((com.ziroom.ziroomcustomer.newclean.d.j)localObject).getConstellation());
      this.tv_fond.setText(((com.ziroom.ziroomcustomer.newclean.d.j)localObject).getInterest());
      if (!TextUtils.isEmpty(((com.ziroom.ziroomcustomer.newclean.d.j)localObject).getTags()))
      {
        localObject = com.ziroom.ziroomcustomer.newServiceList.utils.j.getCutApart(((com.ziroom.ziroomcustomer.newclean.d.j)localObject).getTags(), ";");
        com.ziroom.ziroomcustomer.newServiceList.utils.j.addComFlke(getActivity(), (List)localObject, this.fl_like);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/BiWeeklyCleanerInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */