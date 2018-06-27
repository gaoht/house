package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class FriendlyInvoiceOpenActivity_ViewBinding<T extends FriendlyInvoiceOpenActivity>
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
  
  public FriendlyInvoiceOpenActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690078, "field 'mBtnBack' and method 'onClick'");
    paramT.mBtnBack = ((ImageView)Utils.castView(localView, 2131690078, "field 'mBtnBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'mTvTitle'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131690624, "field 'mTvTopRight' and method 'onClick'");
    paramT.mTvTopRight = ((TextView)Utils.castView(localView, 2131690624, "field 'mTvTopRight'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mTvInvoiceSubjectTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690625, "field 'mTvInvoiceSubjectTitle'", TextView.class));
    paramT.mRgInvoiceSubject = ((RadioGroup)Utils.findRequiredViewAsType(paramView, 2131690626, "field 'mRgInvoiceSubject'", RadioGroup.class));
    paramT.mRbSubjectService = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690627, "field 'mRbSubjectService'", RadioButton.class));
    paramT.mRbSubjectRent = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690628, "field 'mRbSubjectRent'", RadioButton.class));
    paramT.mTvInvoiceTypeTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690630, "field 'mTvInvoiceTypeTitle'", TextView.class));
    paramT.mFlInvoiceType = ((RadioGroup)Utils.findRequiredViewAsType(paramView, 2131690631, "field 'mFlInvoiceType'", RadioGroup.class));
    paramT.mLlInvoiceType = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690629, "field 'mLlInvoiceType'", LinearLayout.class));
    paramT.mTvInvoiceDetailDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690609, "field 'mTvInvoiceDetailDesc'", TextView.class));
    paramT.mLlAddressContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695977, "field 'mLlAddressContainer'", LinearLayout.class));
    paramT.mLlInvoiceDetail = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690634, "field 'mLlInvoiceDetail'", LinearLayout.class));
    paramT.mCbCompany = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690636, "field 'mCbCompany'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131690635, "field 'mLlCompany' and method 'onClick'");
    paramT.mLlCompany = ((LinearLayout)Utils.castView(localView, 2131690635, "field 'mLlCompany'", LinearLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mCbPersonal = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690638, "field 'mCbPersonal'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131690637, "field 'mLlPersonal' and method 'onClick'");
    paramT.mLlPersonal = ((LinearLayout)Utils.castView(localView, 2131690637, "field 'mLlPersonal'", LinearLayout.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mTvInvoiceTopName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690639, "field 'mTvInvoiceTopName'", TextView.class));
    paramT.mEtInvoiceIdentityNum = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690641, "field 'mEtInvoiceIdentityNum'", EditText.class));
    paramT.mTvInvoiceIdentityNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690642, "field 'mTvInvoiceIdentityNum'", TextView.class));
    paramT.mLlInvoiceIdentityContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690640, "field 'mLlInvoiceIdentityContainer'", LinearLayout.class));
    paramT.mLlInvoiceDetailPriceShow = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690643, "field 'mLlInvoiceDetailPriceShow'", LinearLayout.class));
    paramT.mTvInvoicePrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690644, "field 'mTvInvoicePrice'", TextView.class));
    paramT.mRlInvoiceCertification = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690632, "field 'mRlInvoiceCertification'", RelativeLayout.class));
    paramT.mtvInvoiceCertification = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690633, "field 'mtvInvoiceCertification'", TextView.class));
    paramT.mTvInvoiceAddresseeTips = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695978, "field 'mTvInvoiceAddresseeTips'", TextView.class));
    paramT.mLlInvoiceAddressee = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695979, "field 'mLlInvoiceAddressee'", LinearLayout.class));
    paramT.mEtInvoiceAddressee = ((EditText)Utils.findRequiredViewAsType(paramView, 2131695980, "field 'mEtInvoiceAddressee'", EditText.class));
    paramT.mLlInvoiceAddressSelect = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131695981, "field 'mLlInvoiceAddressSelect'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131695982, "field 'mTvInvoiceAddressSelect' and method 'onClick'");
    paramT.mTvInvoiceAddressSelect = ((TextView)Utils.castView(localView, 2131695982, "field 'mTvInvoiceAddressSelect'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mEtInvoiceAddress = ((EditText)Utils.findRequiredViewAsType(paramView, 2131695983, "field 'mEtInvoiceAddress'", EditText.class));
    paramT.mEtInvoicePhoneNum = ((EditText)Utils.findRequiredViewAsType(paramView, 2131692010, "field 'mEtInvoicePhoneNum'", EditText.class));
    localView = Utils.findRequiredView(paramView, 2131689997, "field 'mTvSubmit' and method 'onClick'");
    paramT.mTvSubmit = ((TextView)Utils.castView(localView, 2131689997, "field 'mTvSubmit'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mLlContentContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690608, "field 'mLlContentContainer'", LinearLayout.class));
    paramT.mStubError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690620, "field 'mStubError'", ViewStub.class));
    paramT.mLlInvoiceMonth = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696254, "field 'mLlInvoiceMonth'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131696255, "field 'mTvMonthDesc' and method 'onClick'");
    paramT.mTvMonthDesc = ((TextView)Utils.castView(localView, 2131696255, "field 'mTvMonthDesc'", TextView.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mTvMonthCount = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696256, "field 'mTvMonthCount'", TextView.class));
    paramT.mTvInvoiceMonthPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696257, "field 'mTvInvoiceMonthPrice'", TextView.class));
    paramT.mTvInvoiceMonthTax = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696258, "field 'mTvInvoiceMonthTax'", TextView.class));
  }
  
  public void unbind()
  {
    FriendlyInvoiceOpenActivity localFriendlyInvoiceOpenActivity = this.a;
    if (localFriendlyInvoiceOpenActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localFriendlyInvoiceOpenActivity.mBtnBack = null;
    localFriendlyInvoiceOpenActivity.mTvTitle = null;
    localFriendlyInvoiceOpenActivity.mTvTopRight = null;
    localFriendlyInvoiceOpenActivity.mTvInvoiceSubjectTitle = null;
    localFriendlyInvoiceOpenActivity.mRgInvoiceSubject = null;
    localFriendlyInvoiceOpenActivity.mRbSubjectService = null;
    localFriendlyInvoiceOpenActivity.mRbSubjectRent = null;
    localFriendlyInvoiceOpenActivity.mTvInvoiceTypeTitle = null;
    localFriendlyInvoiceOpenActivity.mFlInvoiceType = null;
    localFriendlyInvoiceOpenActivity.mLlInvoiceType = null;
    localFriendlyInvoiceOpenActivity.mTvInvoiceDetailDesc = null;
    localFriendlyInvoiceOpenActivity.mLlAddressContainer = null;
    localFriendlyInvoiceOpenActivity.mLlInvoiceDetail = null;
    localFriendlyInvoiceOpenActivity.mCbCompany = null;
    localFriendlyInvoiceOpenActivity.mLlCompany = null;
    localFriendlyInvoiceOpenActivity.mCbPersonal = null;
    localFriendlyInvoiceOpenActivity.mLlPersonal = null;
    localFriendlyInvoiceOpenActivity.mTvInvoiceTopName = null;
    localFriendlyInvoiceOpenActivity.mEtInvoiceIdentityNum = null;
    localFriendlyInvoiceOpenActivity.mTvInvoiceIdentityNum = null;
    localFriendlyInvoiceOpenActivity.mLlInvoiceIdentityContainer = null;
    localFriendlyInvoiceOpenActivity.mLlInvoiceDetailPriceShow = null;
    localFriendlyInvoiceOpenActivity.mTvInvoicePrice = null;
    localFriendlyInvoiceOpenActivity.mRlInvoiceCertification = null;
    localFriendlyInvoiceOpenActivity.mtvInvoiceCertification = null;
    localFriendlyInvoiceOpenActivity.mTvInvoiceAddresseeTips = null;
    localFriendlyInvoiceOpenActivity.mLlInvoiceAddressee = null;
    localFriendlyInvoiceOpenActivity.mEtInvoiceAddressee = null;
    localFriendlyInvoiceOpenActivity.mLlInvoiceAddressSelect = null;
    localFriendlyInvoiceOpenActivity.mTvInvoiceAddressSelect = null;
    localFriendlyInvoiceOpenActivity.mEtInvoiceAddress = null;
    localFriendlyInvoiceOpenActivity.mEtInvoicePhoneNum = null;
    localFriendlyInvoiceOpenActivity.mTvSubmit = null;
    localFriendlyInvoiceOpenActivity.mLlContentContainer = null;
    localFriendlyInvoiceOpenActivity.mStubError = null;
    localFriendlyInvoiceOpenActivity.mLlInvoiceMonth = null;
    localFriendlyInvoiceOpenActivity.mTvMonthDesc = null;
    localFriendlyInvoiceOpenActivity.mTvMonthCount = null;
    localFriendlyInvoiceOpenActivity.mTvInvoiceMonthPrice = null;
    localFriendlyInvoiceOpenActivity.mTvInvoiceMonthTax = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/FriendlyInvoiceOpenActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */