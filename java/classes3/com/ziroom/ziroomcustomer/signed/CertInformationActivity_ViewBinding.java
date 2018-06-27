package com.ziroom.ziroomcustomer.signed;

import android.inputmethodservice.KeyboardView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.signed.widget.TextLineView;

public class CertInformationActivity_ViewBinding<T extends CertInformationActivity>
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
  private View n;
  private View o;
  private View p;
  private View q;
  private View r;
  private View s;
  private View t;
  private View u;
  
  public CertInformationActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.enterprise_ll = Utils.findRequiredView(paramView, 2131690120, "field 'enterprise_ll'");
    paramT.personal_ll = Utils.findRequiredView(paramView, 2131690119, "field 'personal_ll'");
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
    paramT.pay_terms_scroll = ((PayTermsScrollView)Utils.findRequiredViewAsType(paramView, 2131690114, "field 'pay_terms_scroll'", PayTermsScrollView.class));
    paramT.cert_title_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690109, "field 'cert_title_tv'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131690117, "field 'personal_tab' and method 'onClic'");
    paramT.personal_tab = ((TextLineView)Utils.castView(localView, 2131690117, "field 'personal_tab'", TextLineView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690118, "field 'enterprise_tab' and method 'onClic'");
    paramT.enterprise_tab = ((TextLineView)Utils.castView(localView, 2131690118, "field 'enterprise_tab'", TextLineView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.cert_information_title_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690115, "field 'cert_information_title_ll'", LinearLayout.class));
    paramT.cert_information_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690116, "field 'cert_information_ll'", LinearLayout.class));
    paramT.cert_information_title_tab_ll = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690111, "field 'cert_information_title_tab_ll'", RelativeLayout.class));
    localView = Utils.findRequiredView(paramView, 2131690112, "field 'personal_title_tab' and method 'onClic'");
    paramT.personal_title_tab = ((TextLineView)Utils.castView(localView, 2131690112, "field 'personal_title_tab'", TextLineView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690113, "field 'enterprise_title_tab' and method 'onClic'");
    paramT.enterprise_title_tab = ((TextLineView)Utils.castView(localView, 2131690113, "field 'enterprise_title_tab'", TextLineView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693018, "field 'cert_information_personal_image1' and method 'onClic'");
    paramT.cert_information_personal_image1 = ((SimpleDraweeView)Utils.castView(localView, 2131693018, "field 'cert_information_personal_image1'", SimpleDraweeView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693019, "field 'cert_information_personal_image2' and method 'onClic'");
    paramT.cert_information_personal_image2 = ((SimpleDraweeView)Utils.castView(localView, 2131693019, "field 'cert_information_personal_image2'", SimpleDraweeView.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693020, "field 'cert_information_personal_image3' and method 'onClic'");
    paramT.cert_information_personal_image3 = ((SimpleDraweeView)Utils.castView(localView, 2131693020, "field 'cert_information_personal_image3'", SimpleDraweeView.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131694544, "field 'cert_information_enterpiese_image1' and method 'onClic'");
    paramT.cert_information_enterpiese_image1 = ((SimpleDraweeView)Utils.castView(localView, 2131694544, "field 'cert_information_enterpiese_image1'", SimpleDraweeView.class));
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131694545, "field 'cert_information_enterpiese_image2' and method 'onClic'");
    paramT.cert_information_enterpiese_image2 = ((SimpleDraweeView)Utils.castView(localView, 2131694545, "field 'cert_information_enterpiese_image2'", SimpleDraweeView.class));
    this.k = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131694546, "field 'cert_information_enterpiese_image3' and method 'onClic'");
    paramT.cert_information_enterpiese_image3 = ((SimpleDraweeView)Utils.castView(localView, 2131694546, "field 'cert_information_enterpiese_image3'", SimpleDraweeView.class));
    this.l = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693009, "field 'cert_information_personal_cert_type' and method 'onClic'");
    paramT.cert_information_personal_cert_type = ((TextView)Utils.castView(localView, 2131693009, "field 'cert_information_personal_cert_type'", TextView.class));
    this.m = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.cert_information_personal_cert_type_hint = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694743, "field 'cert_information_personal_cert_type_hint'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131693015, "field 'cert_information_personal_sex' and method 'onClic'");
    paramT.cert_information_personal_sex = ((TextView)Utils.castView(localView, 2131693015, "field 'cert_information_personal_sex'", TextView.class));
    this.n = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131694539, "field 'cert_information_enterprise_cert_type' and method 'onClic'");
    paramT.cert_information_enterprise_cert_type = ((TextView)Utils.castView(localView, 2131694539, "field 'cert_information_enterprise_cert_type'", TextView.class));
    this.o = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.cert_information_enterprise_cert_type_hint = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694538, "field 'cert_information_enterprise_cert_type_hint'", TextView.class));
    paramT.cert_information_personal_name = ((EditText)Utils.findRequiredViewAsType(paramView, 2131693006, "field 'cert_information_personal_name'", EditText.class));
    paramT.cert_information_personal_cert_id = ((EditText)Utils.findRequiredViewAsType(paramView, 2131693010, "field 'cert_information_personal_cert_id'", EditText.class));
    paramT.cert_information_enterprise_name = ((EditText)Utils.findRequiredViewAsType(paramView, 2131694536, "field 'cert_information_enterprise_name'", EditText.class));
    paramT.cert_information_enterprise_cert_id = ((EditText)Utils.findRequiredViewAsType(paramView, 2131694542, "field 'cert_information_enterprise_cert_id'", EditText.class));
    paramT.cert_information_personal_image_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131693016, "field 'cert_information_personal_image_ll'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131690121, "field 'cert_information_btn' and method 'onClic'");
    paramT.cert_information_btn = ((TextView)Utils.castView(localView, 2131690121, "field 'cert_information_btn'", TextView.class));
    this.p = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.cert_information_personal_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693021, "field 'cert_information_personal_tv'", TextView.class));
    paramT.cert_information_enterpiese_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694547, "field 'cert_information_enterpiese_tv'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131694543, "field 'cert_information_enterprise_audit' and method 'onClic'");
    paramT.cert_information_enterprise_audit = ((LinearLayout)Utils.castView(localView, 2131694543, "field 'cert_information_enterprise_audit'", LinearLayout.class));
    this.q = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131693017, "field 'cert_information_personal_audit' and method 'onClic'");
    paramT.cert_information_personal_audit = ((LinearLayout)Utils.castView(localView, 2131693017, "field 'cert_information_personal_audit'", LinearLayout.class));
    this.r = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.cert_information_enterprise_image_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131694540, "field 'cert_information_enterprise_image_ll'", LinearLayout.class));
    paramT.cert_information_enterprise_cert_id_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694541, "field 'cert_information_enterprise_cert_id_name'", TextView.class));
    paramT.keyboard_view = ((KeyboardView)Utils.findRequiredViewAsType(paramView, 2131690124, "field 'keyboard_view'", KeyboardView.class));
    paramT.cert_information_personal_cert_id_line = Utils.findRequiredView(paramView, 2131693012, "field 'cert_information_personal_cert_id_line'");
    paramT.cert_information_personal_sex_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131693013, "field 'cert_information_personal_sex_ll'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131694537, "field 'cert_information_enterprise_user_type' and method 'onClic'");
    paramT.cert_information_enterprise_user_type = ((TextView)Utils.castView(localView, 2131694537, "field 'cert_information_enterprise_user_type'", TextView.class));
    this.s = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690110, "method 'onClic'");
    this.t = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131690123, "method 'onClic'");
    this.u = paramView;
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
    CertInformationActivity localCertInformationActivity = this.a;
    if (localCertInformationActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localCertInformationActivity.enterprise_ll = null;
    localCertInformationActivity.personal_ll = null;
    localCertInformationActivity.btn_menu = null;
    localCertInformationActivity.pay_terms_scroll = null;
    localCertInformationActivity.cert_title_tv = null;
    localCertInformationActivity.personal_tab = null;
    localCertInformationActivity.enterprise_tab = null;
    localCertInformationActivity.cert_information_title_ll = null;
    localCertInformationActivity.cert_information_ll = null;
    localCertInformationActivity.cert_information_title_tab_ll = null;
    localCertInformationActivity.personal_title_tab = null;
    localCertInformationActivity.enterprise_title_tab = null;
    localCertInformationActivity.cert_information_personal_image1 = null;
    localCertInformationActivity.cert_information_personal_image2 = null;
    localCertInformationActivity.cert_information_personal_image3 = null;
    localCertInformationActivity.cert_information_enterpiese_image1 = null;
    localCertInformationActivity.cert_information_enterpiese_image2 = null;
    localCertInformationActivity.cert_information_enterpiese_image3 = null;
    localCertInformationActivity.cert_information_personal_cert_type = null;
    localCertInformationActivity.cert_information_personal_cert_type_hint = null;
    localCertInformationActivity.cert_information_personal_sex = null;
    localCertInformationActivity.cert_information_enterprise_cert_type = null;
    localCertInformationActivity.cert_information_enterprise_cert_type_hint = null;
    localCertInformationActivity.cert_information_personal_name = null;
    localCertInformationActivity.cert_information_personal_cert_id = null;
    localCertInformationActivity.cert_information_enterprise_name = null;
    localCertInformationActivity.cert_information_enterprise_cert_id = null;
    localCertInformationActivity.cert_information_personal_image_ll = null;
    localCertInformationActivity.cert_information_btn = null;
    localCertInformationActivity.cert_information_personal_tv = null;
    localCertInformationActivity.cert_information_enterpiese_tv = null;
    localCertInformationActivity.cert_information_enterprise_audit = null;
    localCertInformationActivity.cert_information_personal_audit = null;
    localCertInformationActivity.cert_information_enterprise_image_ll = null;
    localCertInformationActivity.cert_information_enterprise_cert_id_name = null;
    localCertInformationActivity.keyboard_view = null;
    localCertInformationActivity.cert_information_personal_cert_id_line = null;
    localCertInformationActivity.cert_information_personal_sex_ll = null;
    localCertInformationActivity.cert_information_enterprise_user_type = null;
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
    this.n.setOnClickListener(null);
    this.n = null;
    this.o.setOnClickListener(null);
    this.o = null;
    this.p.setOnClickListener(null);
    this.p = null;
    this.q.setOnClickListener(null);
    this.q = null;
    this.r.setOnClickListener(null);
    this.r = null;
    this.s.setOnClickListener(null);
    this.s = null;
    this.t.setOnClickListener(null);
    this.t = null;
    this.u.setOnClickListener(null);
    this.u = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/CertInformationActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */