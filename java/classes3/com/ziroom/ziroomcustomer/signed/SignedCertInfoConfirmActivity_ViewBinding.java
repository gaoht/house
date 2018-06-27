package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;

public class SignedCertInfoConfirmActivity_ViewBinding<T extends SignedCertInfoConfirmActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public SignedCertInfoConfirmActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690105, "field 'btn_menu' and method 'onClic'");
    paramT.btn_menu = ((ImageView)Utils.castView(localView, 2131690105, "field 'btn_menu'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.cert_info_confirm_img = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131692427, "field 'cert_info_confirm_img'", SimpleDraweeView.class));
    paramT.signed_house_address = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692428, "field 'signed_house_address'", TextView.class));
    paramT.signed_house_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692429, "field 'signed_house_price'", TextView.class));
    paramT.signed_house_area = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692430, "field 'signed_house_area'", TextView.class));
    paramT.signed_cert_info_name_left = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692431, "field 'signed_cert_info_name_left'", TextView.class));
    paramT.signed_cert_info_name_right = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692432, "field 'signed_cert_info_name_right'", TextView.class));
    paramT.signed_cert_info_sex_left = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692434, "field 'signed_cert_info_sex_left'", TextView.class));
    paramT.signed_cert_info_sex_right = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692435, "field 'signed_cert_info_sex_right'", TextView.class));
    paramT.signed_cert_info_id_left = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692436, "field 'signed_cert_info_id_left'", TextView.class));
    paramT.signed_cert_info_id_right = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692437, "field 'signed_cert_info_id_right'", TextView.class));
    paramT.signed_cert_info_phone_left = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692439, "field 'signed_cert_info_phone_left'", TextView.class));
    paramT.signed_cert_info_phone_right = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692440, "field 'signed_cert_info_phone_right'", TextView.class));
    paramT.signed_cert_info_phone_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692438, "field 'signed_cert_info_phone_rl'", RelativeLayout.class));
    paramT.signed_cert_info_sex_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692433, "field 'signed_cert_info_sex_rl'", RelativeLayout.class));
    paramT.signed_person_cert_info_sex = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131692445, "field 'signed_person_cert_info_sex'", LabeledEditText.class));
    paramT.signed_person_cert_info_cert_type = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131692447, "field 'signed_person_cert_info_cert_type'", LabeledEditText.class));
    paramT.signed_person_cert_info_cert_id = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131692448, "field 'signed_person_cert_info_cert_id'", LabeledEditText.class));
    paramT.signed_person_cert_info_phone = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131692449, "field 'signed_person_cert_info_phone'", LabeledEditText.class));
    paramT.signed_person_cert_info_name = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131692443, "field 'signed_person_cert_info_name'", LabeledEditText.class));
    paramT.cert_info_confirm_btn = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692450, "field 'cert_info_confirm_btn'", TextView.class));
    paramT.ll_house_info_signed_cert = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692426, "field 'll_house_info_signed_cert'", LinearLayout.class));
    paramT.signed_person_cert_info_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692442, "field 'signed_person_cert_info_ll'", LinearLayout.class));
    paramT.signed_cert_info_tip = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692441, "field 'signed_cert_info_tip'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692444, "method 'onClic'");
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131692446, "method 'onClic'");
    this.d = paramView;
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
    SignedCertInfoConfirmActivity localSignedCertInfoConfirmActivity = this.a;
    if (localSignedCertInfoConfirmActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSignedCertInfoConfirmActivity.btn_menu = null;
    localSignedCertInfoConfirmActivity.cert_info_confirm_img = null;
    localSignedCertInfoConfirmActivity.signed_house_address = null;
    localSignedCertInfoConfirmActivity.signed_house_price = null;
    localSignedCertInfoConfirmActivity.signed_house_area = null;
    localSignedCertInfoConfirmActivity.signed_cert_info_name_left = null;
    localSignedCertInfoConfirmActivity.signed_cert_info_name_right = null;
    localSignedCertInfoConfirmActivity.signed_cert_info_sex_left = null;
    localSignedCertInfoConfirmActivity.signed_cert_info_sex_right = null;
    localSignedCertInfoConfirmActivity.signed_cert_info_id_left = null;
    localSignedCertInfoConfirmActivity.signed_cert_info_id_right = null;
    localSignedCertInfoConfirmActivity.signed_cert_info_phone_left = null;
    localSignedCertInfoConfirmActivity.signed_cert_info_phone_right = null;
    localSignedCertInfoConfirmActivity.signed_cert_info_phone_rl = null;
    localSignedCertInfoConfirmActivity.signed_cert_info_sex_rl = null;
    localSignedCertInfoConfirmActivity.signed_person_cert_info_sex = null;
    localSignedCertInfoConfirmActivity.signed_person_cert_info_cert_type = null;
    localSignedCertInfoConfirmActivity.signed_person_cert_info_cert_id = null;
    localSignedCertInfoConfirmActivity.signed_person_cert_info_phone = null;
    localSignedCertInfoConfirmActivity.signed_person_cert_info_name = null;
    localSignedCertInfoConfirmActivity.cert_info_confirm_btn = null;
    localSignedCertInfoConfirmActivity.ll_house_info_signed_cert = null;
    localSignedCertInfoConfirmActivity.signed_person_cert_info_ll = null;
    localSignedCertInfoConfirmActivity.signed_cert_info_tip = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignedCertInfoConfirmActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */