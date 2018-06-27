package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class CertInformationAuditActivity_ViewBinding<T extends CertInformationAuditActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public CertInformationAuditActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689533, "field 'title'", TextView.class));
    paramT.content_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690106, "field 'content_text'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131690105, "method 'onClic'");
    this.b = paramView;
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
    CertInformationAuditActivity localCertInformationAuditActivity = this.a;
    if (localCertInformationAuditActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localCertInformationAuditActivity.title = null;
    localCertInformationAuditActivity.content_text = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/CertInformationAuditActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */