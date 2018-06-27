package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class FriendlyCompetencyApplyActivity_ViewBinding<T extends FriendlyCompetencyApplyActivity>
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
  
  public FriendlyCompetencyApplyActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690078, "field 'btnBack' and method 'onClick'");
    paramT.btnBack = ((ImageView)Utils.castView(localView, 2131690078, "field 'btnBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131689997, "field 'tvSubmit' and method 'onClick'");
    paramT.tvSubmit = ((TextView)Utils.castView(localView, 2131689997, "field 'tvSubmit'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.llContentContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690608, "field 'llContentContainer'", LinearLayout.class));
    paramT.etCompetencyApplyName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690647, "field 'etCompetencyApplyName'", TextView.class));
    paramT.et_competency_apply_identification_code = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690648, "field 'et_competency_apply_identification_code'", EditText.class));
    paramT.et_competency_apply_address = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690649, "field 'et_competency_apply_address'", EditText.class));
    paramT.et_competency_apply_phone = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690650, "field 'et_competency_apply_phone'", EditText.class));
    paramT.et_competency_apply_bank_name = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690651, "field 'et_competency_apply_bank_name'", EditText.class));
    paramT.et_competency_apply_bank_number = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690652, "field 'et_competency_apply_bank_number'", EditText.class));
    localView = Utils.findRequiredView(paramView, 2131690653, "field 'sdv_competency_apply_pic1' and method 'onClick'");
    paramT.sdv_competency_apply_pic1 = ((SimpleDraweeView)Utils.castView(localView, 2131690653, "field 'sdv_competency_apply_pic1'", SimpleDraweeView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690654, "field 'sdv_competency_apply_pic2' and method 'onClick'");
    paramT.sdv_competency_apply_pic2 = ((SimpleDraweeView)Utils.castView(localView, 2131690654, "field 'sdv_competency_apply_pic2'", SimpleDraweeView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690655, "field 'sdv_competency_apply_pic3' and method 'onClick'");
    paramT.sdv_competency_apply_pic3 = ((SimpleDraweeView)Utils.castView(localView, 2131690655, "field 'sdv_competency_apply_pic3'", SimpleDraweeView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690656, "field 'sdv_competency_apply_pic4' and method 'onClick'");
    paramT.sdv_competency_apply_pic4 = ((SimpleDraweeView)Utils.castView(localView, 2131690656, "field 'sdv_competency_apply_pic4'", SimpleDraweeView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.stubError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690620, "field 'stubError'", ViewStub.class));
    localView = Utils.findRequiredView(paramView, 2131690576, "field 'tv_help' and method 'onClick'");
    paramT.tv_help = ((TextView)Utils.castView(localView, 2131690576, "field 'tv_help'", TextView.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_invoice_status = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690646, "field 'tv_invoice_status'", TextView.class));
  }
  
  public void unbind()
  {
    FriendlyCompetencyApplyActivity localFriendlyCompetencyApplyActivity = this.a;
    if (localFriendlyCompetencyApplyActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localFriendlyCompetencyApplyActivity.btnBack = null;
    localFriendlyCompetencyApplyActivity.tvTitle = null;
    localFriendlyCompetencyApplyActivity.tvSubmit = null;
    localFriendlyCompetencyApplyActivity.llContentContainer = null;
    localFriendlyCompetencyApplyActivity.etCompetencyApplyName = null;
    localFriendlyCompetencyApplyActivity.et_competency_apply_identification_code = null;
    localFriendlyCompetencyApplyActivity.et_competency_apply_address = null;
    localFriendlyCompetencyApplyActivity.et_competency_apply_phone = null;
    localFriendlyCompetencyApplyActivity.et_competency_apply_bank_name = null;
    localFriendlyCompetencyApplyActivity.et_competency_apply_bank_number = null;
    localFriendlyCompetencyApplyActivity.sdv_competency_apply_pic1 = null;
    localFriendlyCompetencyApplyActivity.sdv_competency_apply_pic2 = null;
    localFriendlyCompetencyApplyActivity.sdv_competency_apply_pic3 = null;
    localFriendlyCompetencyApplyActivity.sdv_competency_apply_pic4 = null;
    localFriendlyCompetencyApplyActivity.stubError = null;
    localFriendlyCompetencyApplyActivity.tv_help = null;
    localFriendlyCompetencyApplyActivity.tv_invoice_status = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/FriendlyCompetencyApplyActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */