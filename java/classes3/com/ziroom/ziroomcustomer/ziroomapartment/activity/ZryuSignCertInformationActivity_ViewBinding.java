package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.inputmethodservice.KeyboardView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class ZryuSignCertInformationActivity_ViewBinding<T extends ZryuSignCertInformationActivity>
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
  
  public ZryuSignCertInformationActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.personal_ll = Utils.findRequiredView(paramView, 2131690119, "field 'personal_ll'");
    paramT.cert_title_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690109, "field 'cert_title_tv'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131693018, "field 'cert_information_personal_image1' and method 'onClic'");
    paramT.cert_information_personal_image1 = ((SimpleDraweeView)Utils.castView(localView, 2131693018, "field 'cert_information_personal_image1'", SimpleDraweeView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693019, "field 'cert_information_personal_image2' and method 'onClic'");
    paramT.cert_information_personal_image2 = ((SimpleDraweeView)Utils.castView(localView, 2131693019, "field 'cert_information_personal_image2'", SimpleDraweeView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693020, "field 'cert_information_personal_image3' and method 'onClic'");
    paramT.cert_information_personal_image3 = ((SimpleDraweeView)Utils.castView(localView, 2131693020, "field 'cert_information_personal_image3'", SimpleDraweeView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693009, "field 'cert_information_personal_cert_type' and method 'onClic'");
    paramT.cert_information_personal_cert_type = ((TextView)Utils.castView(localView, 2131693009, "field 'cert_information_personal_cert_type'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693015, "field 'cert_information_personal_sex' and method 'onClic'");
    paramT.cert_information_personal_sex = ((TextView)Utils.castView(localView, 2131693015, "field 'cert_information_personal_sex'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.cert_information_personal_name = ((EditText)Utils.findRequiredViewAsType(paramView, 2131693006, "field 'cert_information_personal_name'", EditText.class));
    paramT.cert_information_personal_cert_id = ((EditText)Utils.findRequiredViewAsType(paramView, 2131693010, "field 'cert_information_personal_cert_id'", EditText.class));
    paramT.cert_information_personal_image_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131693016, "field 'cert_information_personal_image_ll'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131690121, "field 'cert_information_btn' and method 'onClic'");
    paramT.cert_information_btn = ((TextView)Utils.castView(localView, 2131690121, "field 'cert_information_btn'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.cert_information_personal_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693021, "field 'cert_information_personal_tv'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131693017, "field 'cert_information_personal_audit' and method 'onClic'");
    paramT.cert_information_personal_audit = ((LinearLayout)Utils.castView(localView, 2131693017, "field 'cert_information_personal_audit'", LinearLayout.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.keyboard_view = ((KeyboardView)Utils.findRequiredViewAsType(paramView, 2131690124, "field 'keyboard_view'", KeyboardView.class));
    paramT.cert_information_personal_cert_id_line = Utils.findRequiredView(paramView, 2131693012, "field 'cert_information_personal_cert_id_line'");
    paramT.cert_information_personal_sex_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131693013, "field 'cert_information_personal_sex_ll'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131690105, "method 'onClic'");
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690110, "method 'onClic'");
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131690123, "method 'onClic'");
    this.k = paramView;
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
    ZryuSignCertInformationActivity localZryuSignCertInformationActivity = this.a;
    if (localZryuSignCertInformationActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuSignCertInformationActivity.personal_ll = null;
    localZryuSignCertInformationActivity.cert_title_tv = null;
    localZryuSignCertInformationActivity.cert_information_personal_image1 = null;
    localZryuSignCertInformationActivity.cert_information_personal_image2 = null;
    localZryuSignCertInformationActivity.cert_information_personal_image3 = null;
    localZryuSignCertInformationActivity.cert_information_personal_cert_type = null;
    localZryuSignCertInformationActivity.cert_information_personal_sex = null;
    localZryuSignCertInformationActivity.cert_information_personal_name = null;
    localZryuSignCertInformationActivity.cert_information_personal_cert_id = null;
    localZryuSignCertInformationActivity.cert_information_personal_image_ll = null;
    localZryuSignCertInformationActivity.cert_information_btn = null;
    localZryuSignCertInformationActivity.cert_information_personal_tv = null;
    localZryuSignCertInformationActivity.cert_information_personal_audit = null;
    localZryuSignCertInformationActivity.keyboard_view = null;
    localZryuSignCertInformationActivity.cert_information_personal_cert_id_line = null;
    localZryuSignCertInformationActivity.cert_information_personal_sex_ll = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignCertInformationActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */