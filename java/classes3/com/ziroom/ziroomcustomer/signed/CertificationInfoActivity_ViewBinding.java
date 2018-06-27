package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class CertificationInfoActivity_ViewBinding<T extends CertificationInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public CertificationInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.certification_img = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690125, "field 'certification_img'", ImageView.class));
    paramT.certification_type = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690126, "field 'certification_type'", TextView.class));
    paramT.certification_why = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690127, "field 'certification_why'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131690128, "field 'certification_btn' and method 'onClic'");
    paramT.certification_btn = ((TextView)Utils.castView(localView, 2131690128, "field 'certification_btn'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.certification_img_right = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690140, "field 'certification_img_right'", TextView.class));
    paramT.certification_img_hint_left = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690139, "field 'certification_img_hint_left'", TextView.class));
    paramT.certification_img_left = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690138, "field 'certification_img_left'", TextView.class));
    paramT.certification_id_right = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690136, "field 'certification_id_right'", TextView.class));
    paramT.certification_id_left = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690135, "field 'certification_id_left'", TextView.class));
    paramT.certification_name_right = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690131, "field 'certification_name_right'", TextView.class));
    paramT.certification_name_left = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690130, "field 'certification_name_left'", TextView.class));
    paramT.certification_sex_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690132, "field 'certification_sex_rl'", RelativeLayout.class));
    paramT.certification_sex_left = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690133, "field 'certification_sex_left'", TextView.class));
    paramT.certification_sex_right = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690134, "field 'certification_sex_right'", TextView.class));
    paramT.cert_title_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690109, "field 'cert_title_tv'", TextView.class));
    paramT.certification_data_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690129, "field 'certification_data_title'", TextView.class));
    paramT.certification_img_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690137, "field 'certification_img_rl'", RelativeLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131690105, "method 'onClic'");
    this.c = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    CertificationInfoActivity localCertificationInfoActivity = this.a;
    if (localCertificationInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localCertificationInfoActivity.certification_img = null;
    localCertificationInfoActivity.certification_type = null;
    localCertificationInfoActivity.certification_why = null;
    localCertificationInfoActivity.certification_btn = null;
    localCertificationInfoActivity.certification_img_right = null;
    localCertificationInfoActivity.certification_img_hint_left = null;
    localCertificationInfoActivity.certification_img_left = null;
    localCertificationInfoActivity.certification_id_right = null;
    localCertificationInfoActivity.certification_id_left = null;
    localCertificationInfoActivity.certification_name_right = null;
    localCertificationInfoActivity.certification_name_left = null;
    localCertificationInfoActivity.certification_sex_rl = null;
    localCertificationInfoActivity.certification_sex_left = null;
    localCertificationInfoActivity.certification_sex_right = null;
    localCertificationInfoActivity.cert_title_tv = null;
    localCertificationInfoActivity.certification_data_title = null;
    localCertificationInfoActivity.certification_img_rl = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/CertificationInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */