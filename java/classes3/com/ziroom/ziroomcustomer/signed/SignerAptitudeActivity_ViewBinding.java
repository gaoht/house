package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.signed.widget.SignerLabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.SignerInfoView;

public class SignerAptitudeActivity_ViewBinding<T extends SignerAptitudeActivity>
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
  
  public SignerAptitudeActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tv_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695949, "field 'tv_title'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131695950, "field 'tv_rightButton' and method 'onClick'");
    paramT.tv_rightButton = ((TextView)Utils.castView(localView, 2131695950, "field 'tv_rightButton'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.signerIvStatus = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692454, "field 'signerIvStatus'", ImageView.class));
    paramT.signerTvStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692455, "field 'signerTvStatus'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692456, "field 'sif_signerTradeDirect' and method 'onClick'");
    paramT.sif_signerTradeDirect = ((SignerInfoView)Utils.castView(localView, 2131692456, "field 'sif_signerTradeDirect'", SignerInfoView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692457, "field 'sif_signerPlace' and method 'onClick'");
    paramT.sif_signerPlace = ((SignerInfoView)Utils.castView(localView, 2131692457, "field 'sif_signerPlace'", SignerInfoView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692463, "field 'singer_relate' and method 'onClick'");
    paramT.singer_relate = ((SignerInfoView)Utils.castView(localView, 2131692463, "field 'singer_relate'", SignerInfoView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.signer_let_schoolName = ((SignerLabeledEditText)Utils.findRequiredViewAsType(paramView, 2131692458, "field 'signer_let_schoolName'", SignerLabeledEditText.class));
    localView = Utils.findRequiredView(paramView, 2131692460, "field 'sif_signerAddress' and method 'onClick'");
    paramT.sif_signerAddress = ((SignerInfoView)Utils.castView(localView, 2131692460, "field 'sif_signerAddress'", SignerInfoView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692468, "field 'sif_linkLingYin' and method 'onClick'");
    paramT.sif_linkLingYin = ((SignerInfoView)Utils.castView(localView, 2131692468, "field 'sif_linkLingYin'", SignerInfoView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.let_signerEmergencyContactName = ((SignerLabeledEditText)Utils.findRequiredViewAsType(paramView, 2131692461, "field 'let_signerEmergencyContactName'", SignerLabeledEditText.class));
    paramT.let_signerEmergencyContactPhone = ((SignerLabeledEditText)Utils.findRequiredViewAsType(paramView, 2131692462, "field 'let_signerEmergencyContactPhone'", SignerLabeledEditText.class));
    paramT.let_signerEmergencyContactRelate = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131692464, "field 'let_signerEmergencyContactRelate'", LabeledEditText.class));
    paramT.signerDetail_ll_status = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692453, "field 'signerDetail_ll_status'", LinearLayout.class));
    paramT.v_divideLine = Utils.findRequiredView(paramView, 2131692459, "field 'v_divideLine'");
    paramT.ll_photo = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692465, "field 'll_photo'", LinearLayout.class));
    paramT.tv_photo = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691446, "field 'tv_photo'", TextView.class));
    paramT.sdv_photo = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131692467, "field 'sdv_photo'", SimpleDraweeView.class));
    paramT.iv_photo_help = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692466, "field 'iv_photo_help'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131692470, "field 'signer_btn_next' and method 'onClick'");
    paramT.signer_btn_next = ((Button)Utils.castView(localView, 2131692470, "field 'signer_btn_next'", Button.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.signer_tv_hint = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692469, "field 'signer_tv_hint'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131695948, "method 'onClick'");
    this.i = paramView;
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
    SignerAptitudeActivity localSignerAptitudeActivity = this.a;
    if (localSignerAptitudeActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSignerAptitudeActivity.tv_title = null;
    localSignerAptitudeActivity.tv_rightButton = null;
    localSignerAptitudeActivity.signerIvStatus = null;
    localSignerAptitudeActivity.signerTvStatus = null;
    localSignerAptitudeActivity.sif_signerTradeDirect = null;
    localSignerAptitudeActivity.sif_signerPlace = null;
    localSignerAptitudeActivity.singer_relate = null;
    localSignerAptitudeActivity.signer_let_schoolName = null;
    localSignerAptitudeActivity.sif_signerAddress = null;
    localSignerAptitudeActivity.sif_linkLingYin = null;
    localSignerAptitudeActivity.let_signerEmergencyContactName = null;
    localSignerAptitudeActivity.let_signerEmergencyContactPhone = null;
    localSignerAptitudeActivity.let_signerEmergencyContactRelate = null;
    localSignerAptitudeActivity.signerDetail_ll_status = null;
    localSignerAptitudeActivity.v_divideLine = null;
    localSignerAptitudeActivity.ll_photo = null;
    localSignerAptitudeActivity.tv_photo = null;
    localSignerAptitudeActivity.sdv_photo = null;
    localSignerAptitudeActivity.iv_photo_help = null;
    localSignerAptitudeActivity.signer_btn_next = null;
    localSignerAptitudeActivity.signer_tv_hint = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */