package com.ziroom.ziroomcustomer.minsu.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuHouseDetailActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuTopHouseDetailActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean.TonightDiscountInfoVoBean;
import com.ziroom.ziroomcustomer.minsu.f.ac;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.searchlist.BrowsingHistoryActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.List;

public class MinsuHouseDetailBottomFragment
  extends BaseFragment
{
  private MinsuHouseBean.DataBean.ListBean a;
  private View b;
  @BindView(2131691394)
  ImageView btn_collect;
  private Unbinder c;
  @BindView(2131694749)
  LinearLayout count_down_area;
  private int d;
  private int e;
  @BindView(2131695270)
  View include_today_special;
  @BindView(2131695341)
  LinearLayout ll_tag_container;
  @BindView(2131694754)
  RelativeLayout ongonging_area;
  @BindView(2131695258)
  RelativeLayout rl_common_content;
  @BindView(2131695263)
  View rl_ll_icon;
  @BindView(2131695337)
  SimpleDraweeView sdv_house;
  @BindView(2131695295)
  SimpleDraweeView sdv_landlord;
  @BindView(2131694746)
  RelativeLayout ts_price_area;
  @BindView(2131691378)
  TextView tv_house_address;
  @BindView(2131695340)
  TextView tv_house_evaluate_count;
  @BindView(2131695339)
  TextView tv_house_evaluate_score;
  @BindView(2131694215)
  TextView tv_house_type;
  @BindView(2131694755)
  TextView tv_list_tips;
  @BindView(2131691316)
  TextView tv_originalPrice;
  @BindView(2131689912)
  TextView tv_price;
  @BindView(2131695261)
  TextView tv_price_privilege;
  @BindView(2131694747)
  TextView tv_ts_price;
  @BindView(2131694748)
  TextView tv_ts_price_dsc;
  
  private void a(MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    MinsuHouseBean.DataBean.ListBean.TonightDiscountInfoVoBean localTonightDiscountInfoVoBean = paramListBean.tonightDiscountInfoVo;
    if (localTonightDiscountInfoVoBean == null)
    {
      this.include_today_special.setVisibility(8);
      return;
    }
    this.include_today_special.setVisibility(0);
    this.tv_ts_price.setText(localTonightDiscountInfoVoBean.getTonightDiscount() * 10.0F + "折");
    this.tv_ts_price_dsc.setText(localTonightDiscountInfoVoBean.getTipsNname());
    this.tv_price.setText("¥ " + ad.getPriceInt(localTonightDiscountInfoVoBean.tonightPrice) + "/晚");
    this.tv_originalPrice.setPaintFlags(17);
    if (paramListBean.tonightDiscountInfoVo.remainTime > 1000L)
    {
      this.count_down_area.setVisibility(8);
      this.ongonging_area.setVisibility(0);
      this.ts_price_area.setBackgroundColor(getActivity().getResources().getColor(2131624495));
      this.tv_list_tips.setText(localTonightDiscountInfoVoBean.getOpenTimeListTips());
      this.tv_originalPrice.setText("¥ " + ad.getPriceInt(paramListBean.price) + "/晚");
      return;
    }
    this.count_down_area.setVisibility(8);
    this.ongonging_area.setVisibility(0);
    this.ts_price_area.setBackgroundColor(getActivity().getResources().getColor(2131624497));
    this.tv_list_tips.setText(localTonightDiscountInfoVoBean.getDeadlineTimeListTips());
    if (paramListBean.originalPrice > 0)
    {
      this.tv_originalPrice.setText("¥" + ad.getPriceInt(paramListBean.originalPrice) + "/晚");
      return;
    }
    this.tv_originalPrice.setText("¥ " + ad.getPriceInt(paramListBean.price) + "/晚");
  }
  
  public static MinsuHouseDetailBottomFragment newInstance(MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    MinsuHouseDetailBottomFragment localMinsuHouseDetailBottomFragment = new MinsuHouseDetailBottomFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("MinsuHouseBean", paramListBean);
    localMinsuHouseDetailBottomFragment.setArguments(localBundle);
    return localMinsuHouseDetailBottomFragment;
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
    this.b = paramLayoutInflater.inflate(2130904349, paramViewGroup, false);
    this.c = ButterKnife.bind(this, this.b);
    return this.b;
  }
  
  public void onDestroy()
  {
    if (this.c != null) {
      this.c.unbind();
    }
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.d = n.dip2px(getActivity(), 10.0F);
    this.e = n.dip2px(getActivity(), 30.0F);
    this.rl_common_content.setPadding(0, 0, 0, 0);
    paramView = (RelativeLayout.LayoutParams)this.sdv_landlord.getLayoutParams();
    paramView.width = this.e;
    paramView.height = this.e;
    this.sdv_landlord.setLayoutParams(paramView);
    paramView = (RelativeLayout.LayoutParams)this.sdv_house.getLayoutParams();
    paramView.setMargins(0, 0, 0, 0);
    this.sdv_house.setLayoutParams(paramView);
    paramView = new RelativeLayout.LayoutParams(-2, -2);
    paramView.addRule(11);
    paramView.addRule(8, 2131694215);
    this.rl_ll_icon.setLayoutParams(paramView);
    com.freelxl.baselibrary.f.c.loadHolderImage(this.sdv_house, this.a.picUrl);
    this.sdv_landlord.setHierarchy(d.getRoundingHierarchy(getActivity()));
    com.freelxl.baselibrary.f.c.loadHolderImage(this.sdv_landlord, this.a.landlordUrl);
    this.sdv_landlord.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        k.toLandlordDetailActivty(MinsuHouseDetailBottomFragment.this.getActivity(), MinsuHouseDetailBottomFragment.a(MinsuHouseDetailBottomFragment.this).landlordUid);
      }
    });
    this.tv_house_address.setText(this.a.houseName);
    paramBundle = new ArrayList();
    if (((getActivity() instanceof BrowsingHistoryActivity)) || ((ae.isNull(com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getCityCode())) && (!ae.isNull(this.a.cityName)))) {
      paramBundle.add(this.a.cityName);
    }
    paramBundle.add(this.a.rentWayName);
    if (this.a.personCount > 0) {
      paramBundle.add("可住" + this.a.personCount + "人");
    }
    for (;;)
    {
      paramView = new StringBuilder();
      int j = paramBundle.size();
      int i = 0;
      while (i < j)
      {
        paramView.append((String)paramBundle.get(i));
        if (i < j - 1)
        {
          paramView.append(getActivity().getString(2131297451));
          paramView.append(getActivity().getString(2131297451));
          paramView.append("|");
          paramView.append(getActivity().getString(2131297451));
          paramView.append(getActivity().getString(2131297451));
        }
        i += 1;
      }
      if (this.a.personCount == 0) {
        paramBundle.add("不限人数");
      }
    }
    paramBundle = (RelativeLayout.LayoutParams)this.tv_house_type.getLayoutParams();
    paramBundle.setMargins(0, this.d, 0, 0);
    this.tv_house_type.setLayoutParams(paramBundle);
    ac.colorMulti(this.tv_house_type, paramView.toString(), "|", getActivity().getResources().getColor(2131624046));
    if (this.a.evaluateCount == 0)
    {
      this.tv_house_evaluate_count.setVisibility(8);
      this.tv_house_evaluate_score.setVisibility(8);
      this.tv_price.setText("¥ " + ad.getPriceInt(this.a.price) + "/晚");
      this.tv_price.getPaint().setFakeBoldText(true);
      if (this.a.isToNightDiscount != 1) {
        break label767;
      }
      this.tv_originalPrice.setVisibility(0);
      a(this.a);
    }
    for (;;)
    {
      this.ll_tag_container.setVisibility(8);
      this.tv_price_privilege.setVisibility(8);
      this.btn_collect.setVisibility(8);
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (MinsuHouseDetailBottomFragment.a(MinsuHouseDetailBottomFragment.this).isTop50Online == 1) {}
          for (paramAnonymousView = new Intent(MinsuHouseDetailBottomFragment.this.getActivity(), MinsuTopHouseDetailActivity.class);; paramAnonymousView = new Intent(MinsuHouseDetailBottomFragment.this.getActivity(), MinsuHouseDetailActivity.class))
          {
            paramAnonymousView.putExtra("fid", MinsuHouseDetailBottomFragment.a(MinsuHouseDetailBottomFragment.this).fid);
            paramAnonymousView.putExtra("rentWay", MinsuHouseDetailBottomFragment.a(MinsuHouseDetailBottomFragment.this).rentWay);
            paramAnonymousView.putExtra("startTime", com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getStartTime());
            paramAnonymousView.putExtra("endTime", com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getEndTime());
            paramAnonymousView.putExtra("image", MinsuHouseDetailBottomFragment.a(MinsuHouseDetailBottomFragment.this).picUrl);
            MinsuHouseDetailBottomFragment.this.getActivity().startActivityForResult(paramAnonymousView, 119);
            return;
          }
        }
      });
      return;
      this.tv_house_evaluate_count.setVisibility(0);
      this.tv_house_evaluate_score.setVisibility(0);
      this.tv_house_evaluate_count.setText("评价 " + this.a.evaluateCount);
      this.tv_house_evaluate_score.setText(this.a.realEvaluateScore + "分");
      break;
      label767:
      this.tv_originalPrice.setVisibility(8);
      this.include_today_special.setVisibility(8);
      this.tv_price.setTextColor(Color.parseColor("#444444"));
      this.tv_price.setPaintFlags(1312);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/fragment/MinsuHouseDetailBottomFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */