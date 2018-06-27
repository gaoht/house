package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.MySwipeMenuListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class LandlordOrderDetailActivity_ViewBinding<T extends LandlordOrderDetailActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  private View k;
  private View l;
  private View m;
  
  public LandlordOrderDetailActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691493, "field 'btnLeftImg' and method 'onViewClicked'");
    paramT.btnLeftImg = ((ImageView)Utils.castView(localView, 2131691493, "field 'btnLeftImg'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.vLineBottom = Utils.findRequiredView(paramView, 2131691494, "field 'vLineBottom'");
    paramT.svContent = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'svContent'", ObservableScrollView.class));
    paramT.tvTitleName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689771, "field 'tvTitleName'", TextView.class));
    paramT.tvRoomStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691496, "field 'tvRoomStatus'", TextView.class));
    paramT.tvAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690053, "field 'tvAddress'", TextView.class));
    paramT.tvOrderCode = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691497, "field 'tvOrderCode'", TextView.class));
    paramT.tvRoomReserveTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691498, "field 'tvRoomReserveTime'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691499, "field 'sdvUserTitleIcon' and method 'onViewClicked'");
    paramT.sdvUserTitleIcon = ((SimpleDraweeView)Utils.castView(localView, 2131691499, "field 'sdvUserTitleIcon'", SimpleDraweeView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690049, "field 'tvName' and method 'onViewClicked'");
    paramT.tvName = ((TextView)Utils.castView(localView, 2131690049, "field 'tvName'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvEvaluation = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691502, "field 'tvEvaluation'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691506, "field 'vPhone' and method 'onViewClicked'");
    paramT.vPhone = ((SimpleDraweeView)Utils.castView(localView, 2131691506, "field 'vPhone'", SimpleDraweeView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691505, "field 'vMessage' and method 'onViewClicked'");
    paramT.vMessage = ((SimpleDraweeView)Utils.castView(localView, 2131691505, "field 'vMessage'", SimpleDraweeView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvPeopleLabel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691508, "field 'tvPeopleLabel'", TextView.class));
    paramT.tvPeopleCount = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691509, "field 'tvPeopleCount'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691507, "field 'llPeopleMessage' and method 'onViewClicked'");
    paramT.llPeopleMessage = ((LinearLayout)Utils.castView(localView, 2131691507, "field 'llPeopleMessage'", LinearLayout.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvComingLabel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691510, "field 'tvComingLabel'", TextView.class));
    paramT.tvComingTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691511, "field 'tvComingTime'", TextView.class));
    paramT.tvLeaveLabel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691512, "field 'tvLeaveLabel'", TextView.class));
    paramT.tvLeaveTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691513, "field 'tvLeaveTime'", TextView.class));
    paramT.tvIncomeLabel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691514, "field 'tvIncomeLabel'", TextView.class));
    paramT.tvIncomeMoney = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691515, "field 'tvIncomeMoney'", TextView.class));
    paramT.tvIncomeDes = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691516, "field 'tvIncomeDes'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691517, "field 'tvIncomeDetail' and method 'onViewClicked'");
    paramT.tvIncomeDetail = ((TextView)Utils.castView(localView, 2131691517, "field 'tvIncomeDetail'", TextView.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvPenaltyLabel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691524, "field 'tvPenaltyLabel'", TextView.class));
    paramT.tvPenaltyMoney = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691525, "field 'tvPenaltyMoney'", TextView.class));
    paramT.llPenalty = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691523, "field 'llPenalty'", LinearLayout.class));
    paramT.tvOtherMoneyLabel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691528, "field 'tvOtherMoneyLabel'", TextView.class));
    paramT.tvOtherMoneyDes = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691529, "field 'tvOtherMoneyDes'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691527, "field 'rlOtherMoney' and method 'onViewClicked'");
    paramT.rlOtherMoney = ((RelativeLayout)Utils.castView(localView, 2131691527, "field 'rlOtherMoney'", RelativeLayout.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691533, "field 'tvUnsubscribe' and method 'onViewClicked'");
    paramT.tvUnsubscribe = ((TextView)Utils.castView(localView, 2131691533, "field 'tvUnsubscribe'", TextView.class));
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvObjectDetail = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691536, "field 'tvObjectDetail'", TextView.class));
    paramT.tvRemarkLabel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691539, "field 'tvRemarkLabel'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691540, "field 'tvAddRemark' and method 'onViewClicked'");
    paramT.tvAddRemark = ((TextView)Utils.castView(localView, 2131691540, "field 'tvAddRemark'", TextView.class));
    this.k = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llRemark = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691538, "field 'llRemark'", LinearLayout.class));
    paramT.listRemark = ((MySwipeMenuListView)Utils.findRequiredViewAsType(paramView, 2131691541, "field 'listRemark'", MySwipeMenuListView.class));
    localView = Utils.findRequiredView(paramView, 2131691542, "field 'rbRefuse' and method 'onViewClicked'");
    paramT.rbRefuse = ((RadioButton)Utils.castView(localView, 2131691542, "field 'rbRefuse'", RadioButton.class));
    this.l = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691543, "field 'rbMakeSure' and method 'onViewClicked'");
    paramT.rbMakeSure = ((RadioButton)Utils.castView(localView, 2131691543, "field 'rbMakeSure'", RadioButton.class));
    this.m = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvUnsubscribeLabel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691532, "field 'tvUnsubscribeLabel'", TextView.class));
    paramT.tvObjectLabel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691535, "field 'tvObjectLabel'", TextView.class));
    paramT.vEvaluation = Utils.findRequiredView(paramView, 2131691503, "field 'vEvaluation'");
    paramT.tvEvaluationCount = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691504, "field 'tvEvaluationCount'", TextView.class));
    paramT.rlUser = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691500, "field 'rlUser'", RelativeLayout.class));
    paramT.vIncome = Utils.findRequiredView(paramView, 2131691518, "field 'vIncome'");
    paramT.vPenalty = Utils.findRequiredView(paramView, 2131691526, "field 'vPenalty'");
    paramT.vOtherMoney = Utils.findRequiredView(paramView, 2131691531, "field 'vOtherMoney'");
    paramT.vUnsubscribe = Utils.findRequiredView(paramView, 2131691534, "field 'vUnsubscribe'");
    paramT.vObject = Utils.findRequiredView(paramView, 2131691537, "field 'vObject'");
    paramT.imgOtherMoney = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691530, "field 'imgOtherMoney'", ImageView.class));
    paramT.tv_security_deposit_money = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691521, "field 'tv_security_deposit_money'", TextView.class));
    paramT.tv_security_deposit_label = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691520, "field 'tv_security_deposit_label'", TextView.class));
    paramT.ll_security_deposit_container = Utils.findRequiredView(paramView, 2131691519, "field 'll_security_deposit_container'");
    paramT.v_security_deposit = Utils.findRequiredView(paramView, 2131691522, "field 'v_security_deposit'");
  }
  
  public void unbind()
  {
    LandlordOrderDetailActivity localLandlordOrderDetailActivity = this.a;
    if (localLandlordOrderDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordOrderDetailActivity.btnLeftImg = null;
    localLandlordOrderDetailActivity.vLineBottom = null;
    localLandlordOrderDetailActivity.svContent = null;
    localLandlordOrderDetailActivity.tvTitleName = null;
    localLandlordOrderDetailActivity.tvRoomStatus = null;
    localLandlordOrderDetailActivity.tvAddress = null;
    localLandlordOrderDetailActivity.tvOrderCode = null;
    localLandlordOrderDetailActivity.tvRoomReserveTime = null;
    localLandlordOrderDetailActivity.sdvUserTitleIcon = null;
    localLandlordOrderDetailActivity.tvName = null;
    localLandlordOrderDetailActivity.tvEvaluation = null;
    localLandlordOrderDetailActivity.vPhone = null;
    localLandlordOrderDetailActivity.vMessage = null;
    localLandlordOrderDetailActivity.tvPeopleLabel = null;
    localLandlordOrderDetailActivity.tvPeopleCount = null;
    localLandlordOrderDetailActivity.llPeopleMessage = null;
    localLandlordOrderDetailActivity.tvComingLabel = null;
    localLandlordOrderDetailActivity.tvComingTime = null;
    localLandlordOrderDetailActivity.tvLeaveLabel = null;
    localLandlordOrderDetailActivity.tvLeaveTime = null;
    localLandlordOrderDetailActivity.tvIncomeLabel = null;
    localLandlordOrderDetailActivity.tvIncomeMoney = null;
    localLandlordOrderDetailActivity.tvIncomeDes = null;
    localLandlordOrderDetailActivity.tvIncomeDetail = null;
    localLandlordOrderDetailActivity.tvPenaltyLabel = null;
    localLandlordOrderDetailActivity.tvPenaltyMoney = null;
    localLandlordOrderDetailActivity.llPenalty = null;
    localLandlordOrderDetailActivity.tvOtherMoneyLabel = null;
    localLandlordOrderDetailActivity.tvOtherMoneyDes = null;
    localLandlordOrderDetailActivity.rlOtherMoney = null;
    localLandlordOrderDetailActivity.tvUnsubscribe = null;
    localLandlordOrderDetailActivity.tvObjectDetail = null;
    localLandlordOrderDetailActivity.tvRemarkLabel = null;
    localLandlordOrderDetailActivity.tvAddRemark = null;
    localLandlordOrderDetailActivity.llRemark = null;
    localLandlordOrderDetailActivity.listRemark = null;
    localLandlordOrderDetailActivity.rbRefuse = null;
    localLandlordOrderDetailActivity.rbMakeSure = null;
    localLandlordOrderDetailActivity.tvUnsubscribeLabel = null;
    localLandlordOrderDetailActivity.tvObjectLabel = null;
    localLandlordOrderDetailActivity.vEvaluation = null;
    localLandlordOrderDetailActivity.tvEvaluationCount = null;
    localLandlordOrderDetailActivity.rlUser = null;
    localLandlordOrderDetailActivity.vIncome = null;
    localLandlordOrderDetailActivity.vPenalty = null;
    localLandlordOrderDetailActivity.vOtherMoney = null;
    localLandlordOrderDetailActivity.vUnsubscribe = null;
    localLandlordOrderDetailActivity.vObject = null;
    localLandlordOrderDetailActivity.imgOtherMoney = null;
    localLandlordOrderDetailActivity.tv_security_deposit_money = null;
    localLandlordOrderDetailActivity.tv_security_deposit_label = null;
    localLandlordOrderDetailActivity.ll_security_deposit_container = null;
    localLandlordOrderDetailActivity.v_security_deposit = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.f.setOnClickListener(null);
    this.f = null;
    this.g.setOnClickListener(null);
    this.g = null;
    this.h.setOnClickListener(null);
    this.h = null;
    this.i.setOnClickListener(null);
    this.i = null;
    this.j.setOnClickListener(null);
    this.j = null;
    this.k.setOnClickListener(null);
    this.k = null;
    this.l.setOnClickListener(null);
    this.l = null;
    this.m.setOnClickListener(null);
    this.m = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/LandlordOrderDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */