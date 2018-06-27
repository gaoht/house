package com.ziroom.ziroomcustomer.newclean.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.ziroomstation.widget.StickyNavLayout;

public class BiWeeklyCleanerInfoActivity_ViewBinding<T extends BiWeeklyCleanerInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public BiWeeklyCleanerInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.myStickyNavLayout = ((StickyNavLayout)Utils.findRequiredViewAsType(paramView, 2131690044, "field 'myStickyNavLayout'", StickyNavLayout.class));
    paramT.view_title_line = Utils.findRequiredView(paramView, 2131689836, "field 'view_title_line'");
    paramT.viewpager_content = ((ViewPager)Utils.findRequiredViewAsType(paramView, 2131690064, "field 'viewpager_content'", ViewPager.class));
    paramT.mIndicator = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690026, "field 'mIndicator'", ImageView.class));
    View localView = Utils.findRequiredView(paramView, 2131690061, "field 'tv_customer_eval' and method 'onClick'");
    paramT.tv_customer_eval = ((TextView)Utils.castView(localView, 2131690061, "field 'tv_customer_eval'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690062, "field 'tv_ziru_identification' and method 'onClick'");
    paramT.tv_ziru_identification = ((TextView)Utils.castView(localView, 2131690062, "field 'tv_ziru_identification'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690063, "field 'tv_personal_info' and method 'onClick'");
    paramT.tv_personal_info = ((TextView)Utils.castView(localView, 2131690063, "field 'tv_personal_info'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.ci_cleaner_header = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131690047, "field 'ci_cleaner_header'", SimpleDraweeView.class));
    paramT.tv_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690049, "field 'tv_name'", TextView.class));
    paramT.tv_age = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690052, "field 'tv_age'", TextView.class));
    paramT.tv_address = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690053, "field 'tv_address'", TextView.class));
    paramT.iv_star1 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690054, "field 'iv_star1'", ImageView.class));
    paramT.iv_star2 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690055, "field 'iv_star2'", ImageView.class));
    paramT.iv_star3 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690056, "field 'iv_star3'", ImageView.class));
    paramT.iv_star4 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690057, "field 'iv_star4'", ImageView.class));
    paramT.iv_star5 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690058, "field 'iv_star5'", ImageView.class));
    paramT.tv_score = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690059, "field 'tv_score'", TextView.class));
    paramT.tv_num = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690003, "field 'tv_num'", TextView.class));
    paramT.tv_order = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690048, "field 'tv_order'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131689492, "method 'onClick'");
    this.e = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    BiWeeklyCleanerInfoActivity localBiWeeklyCleanerInfoActivity = this.a;
    if (localBiWeeklyCleanerInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localBiWeeklyCleanerInfoActivity.myStickyNavLayout = null;
    localBiWeeklyCleanerInfoActivity.view_title_line = null;
    localBiWeeklyCleanerInfoActivity.viewpager_content = null;
    localBiWeeklyCleanerInfoActivity.mIndicator = null;
    localBiWeeklyCleanerInfoActivity.tv_customer_eval = null;
    localBiWeeklyCleanerInfoActivity.tv_ziru_identification = null;
    localBiWeeklyCleanerInfoActivity.tv_personal_info = null;
    localBiWeeklyCleanerInfoActivity.ci_cleaner_header = null;
    localBiWeeklyCleanerInfoActivity.tv_name = null;
    localBiWeeklyCleanerInfoActivity.tv_age = null;
    localBiWeeklyCleanerInfoActivity.tv_address = null;
    localBiWeeklyCleanerInfoActivity.iv_star1 = null;
    localBiWeeklyCleanerInfoActivity.iv_star2 = null;
    localBiWeeklyCleanerInfoActivity.iv_star3 = null;
    localBiWeeklyCleanerInfoActivity.iv_star4 = null;
    localBiWeeklyCleanerInfoActivity.iv_star5 = null;
    localBiWeeklyCleanerInfoActivity.tv_score = null;
    localBiWeeklyCleanerInfoActivity.tv_num = null;
    localBiWeeklyCleanerInfoActivity.tv_order = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BiWeeklyCleanerInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */