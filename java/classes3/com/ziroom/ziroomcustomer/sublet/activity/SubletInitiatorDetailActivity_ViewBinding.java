package com.ziroom.ziroomcustomer.sublet.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.widget.InfoBlockLayout;
import com.ziroom.ziroomcustomer.widget.LinearLayoutForListView;

public class SubletInitiatorDetailActivity_ViewBinding<T extends SubletInitiatorDetailActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public SubletInitiatorDetailActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'mIvBack' and method 'onViewClicked'");
    paramT.mIvBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'mIvBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'mTvTitle'", TextView.class));
    paramT.mTvStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689822, "field 'mTvStatus'", TextView.class));
    paramT.mSdvHouseInfoPic = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131696457, "field 'mSdvHouseInfoPic'", SimpleDraweeView.class));
    paramT.mTvHouseInfoTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696458, "field 'mTvHouseInfoTitle'", TextView.class));
    paramT.mTvHouseInfoDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696460, "field 'mTvHouseInfoDesc'", TextView.class));
    paramT.mTvHouseInfoDesc2 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696459, "field 'mTvHouseInfoDesc2'", TextView.class));
    paramT.mTvBookCode = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696454, "field 'mTvBookCode'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131696463, "field 'mTvBookCodeRefresh' and method 'onViewClicked'");
    paramT.mTvBookCodeRefresh = ((TextView)Utils.castView(localView, 2131696463, "field 'mTvBookCodeRefresh'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.mTvBookCodeShare = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696464, "field 'mTvBookCodeShare'", TextView.class));
    paramT.mLlBookCode = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696462, "field 'mLlBookCode'", LinearLayout.class));
    paramT.mTvSubletDays = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696465, "field 'mTvSubletDays'", TextView.class));
    paramT.mTvSubletViewCounts = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696466, "field 'mTvSubletViewCounts'", TextView.class));
    paramT.mLlRentoutDay = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696472, "field 'mLlRentoutDay'", LinearLayout.class));
    paramT.mTvRentoutDay = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696473, "field 'mTvRentoutDay'", TextView.class));
    paramT.mVZhuanFasterTipsDivider = Utils.findRequiredView(paramView, 2131692783, "field 'mVZhuanFasterTipsDivider'");
    paramT.mLvProcess = ((LinearLayoutForListView)Utils.findRequiredViewAsType(paramView, 2131692787, "field 'mLvProcess'", LinearLayoutForListView.class));
    paramT.mTvProcessTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692786, "field 'mTvProcessTitle'", TextView.class));
    paramT.mIblLinks = ((InfoBlockLayout)Utils.findRequiredViewAsType(paramView, 2131692788, "field 'mIblLinks'", InfoBlockLayout.class));
    paramT.mTvPayTimeTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696468, "field 'mTvPayTimeTitle'", TextView.class));
    paramT.mTvPayTimeHour = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696469, "field 'mTvPayTimeHour'", TextView.class));
    paramT.mTvPayTimeMinute = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696470, "field 'mTvPayTimeMinute'", TextView.class));
    paramT.mTvPayTimeSecond = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696471, "field 'mTvPayTimeSecond'", TextView.class));
    paramT.mLlPayTime = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696467, "field 'mLlPayTime'", LinearLayout.class));
    paramT.mTvTenantName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696474, "field 'mTvTenantName'", TextView.class));
    paramT.mLLBottomButtons = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692789, "field 'mLLBottomButtons'", LinearLayout.class));
    paramT.mVBottomDivider = Utils.findRequiredView(paramView, 2131692790, "field 'mVBottomDivider'");
    paramT.mLlTurnButtons = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692784, "field 'mLlTurnButtons'", LinearLayout.class));
    paramT.mIblTurnLinks = ((InfoBlockLayout)Utils.findRequiredViewAsType(paramView, 2131692785, "field 'mIblTurnLinks'", InfoBlockLayout.class));
    paramT.mIvEmpty = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690082, "field 'mIvEmpty'", ImageView.class));
    paramT.mTvEmpty = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690822, "field 'mTvEmpty'", TextView.class));
    paramT.mLlKakaEmpty = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131694408, "field 'mLlKakaEmpty'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131692782, "field 'btnChangeSubletTime' and method 'onViewClicked'");
    paramT.btnChangeSubletTime = ((Button)Utils.castView(localView, 2131692782, "field 'btnChangeSubletTime'", Button.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.ivSubletTitleMore = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692779, "field 'ivSubletTitleMore'", ImageView.class));
    paramT.llChangeTimeContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692781, "field 'llChangeTimeContainer'", LinearLayout.class));
  }
  
  public void unbind()
  {
    SubletInitiatorDetailActivity localSubletInitiatorDetailActivity = this.a;
    if (localSubletInitiatorDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSubletInitiatorDetailActivity.mIvBack = null;
    localSubletInitiatorDetailActivity.mTvTitle = null;
    localSubletInitiatorDetailActivity.mTvStatus = null;
    localSubletInitiatorDetailActivity.mSdvHouseInfoPic = null;
    localSubletInitiatorDetailActivity.mTvHouseInfoTitle = null;
    localSubletInitiatorDetailActivity.mTvHouseInfoDesc = null;
    localSubletInitiatorDetailActivity.mTvHouseInfoDesc2 = null;
    localSubletInitiatorDetailActivity.mTvBookCode = null;
    localSubletInitiatorDetailActivity.mTvBookCodeRefresh = null;
    localSubletInitiatorDetailActivity.mTvBookCodeShare = null;
    localSubletInitiatorDetailActivity.mLlBookCode = null;
    localSubletInitiatorDetailActivity.mTvSubletDays = null;
    localSubletInitiatorDetailActivity.mTvSubletViewCounts = null;
    localSubletInitiatorDetailActivity.mLlRentoutDay = null;
    localSubletInitiatorDetailActivity.mTvRentoutDay = null;
    localSubletInitiatorDetailActivity.mVZhuanFasterTipsDivider = null;
    localSubletInitiatorDetailActivity.mLvProcess = null;
    localSubletInitiatorDetailActivity.mTvProcessTitle = null;
    localSubletInitiatorDetailActivity.mIblLinks = null;
    localSubletInitiatorDetailActivity.mTvPayTimeTitle = null;
    localSubletInitiatorDetailActivity.mTvPayTimeHour = null;
    localSubletInitiatorDetailActivity.mTvPayTimeMinute = null;
    localSubletInitiatorDetailActivity.mTvPayTimeSecond = null;
    localSubletInitiatorDetailActivity.mLlPayTime = null;
    localSubletInitiatorDetailActivity.mTvTenantName = null;
    localSubletInitiatorDetailActivity.mLLBottomButtons = null;
    localSubletInitiatorDetailActivity.mVBottomDivider = null;
    localSubletInitiatorDetailActivity.mLlTurnButtons = null;
    localSubletInitiatorDetailActivity.mIblTurnLinks = null;
    localSubletInitiatorDetailActivity.mIvEmpty = null;
    localSubletInitiatorDetailActivity.mTvEmpty = null;
    localSubletInitiatorDetailActivity.mLlKakaEmpty = null;
    localSubletInitiatorDetailActivity.btnChangeSubletTime = null;
    localSubletInitiatorDetailActivity.ivSubletTitleMore = null;
    localSubletInitiatorDetailActivity.llChangeTimeContainer = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/SubletInitiatorDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */