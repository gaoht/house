package com.ziroom.ziroomcustomer.signed.education;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.SignerInfoItemView;

public class EducationActivity_ViewBinding<T extends EducationActivity>
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
  
  public EducationActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131695948, "field 'commonTitleIvBack' and method 'onViewClicked'");
    paramT.commonTitleIvBack = ((ImageView)Utils.castView(localView, 2131695948, "field 'commonTitleIvBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.commonTitleTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695949, "field 'commonTitleTvTitle'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131695950, "field 'commonTitleTvRightButton' and method 'onViewClicked'");
    paramT.commonTitleTvRightButton = ((TextView)Utils.castView(localView, 2131695950, "field 'commonTitleTvRightButton'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.commonTitleDivideLine = Utils.findRequiredView(paramView, 2131695951, "field 'commonTitleDivideLine'");
    paramT.tvEducationSignStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697543, "field 'tvEducationSignStatus'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131697544, "field 'sivSchoolingDegree' and method 'onViewClicked'");
    paramT.sivSchoolingDegree = ((SignerInfoItemView)Utils.castView(localView, 2131697544, "field 'sivSchoolingDegree'", SignerInfoItemView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131697545, "field 'sivSchoolName' and method 'onViewClicked'");
    paramT.sivSchoolName = ((SignerInfoItemView)Utils.castView(localView, 2131697545, "field 'sivSchoolName'", SignerInfoItemView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131697546, "field 'sivInYear' and method 'onViewClicked'");
    paramT.sivInYear = ((SignerInfoItemView)Utils.castView(localView, 2131697546, "field 'sivInYear'", SignerInfoItemView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131697547, "field 'sivOutYear' and method 'onViewClicked'");
    paramT.sivOutYear = ((SignerInfoItemView)Utils.castView(localView, 2131697547, "field 'sivOutYear'", SignerInfoItemView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131697548, "field 'sivEducationType' and method 'onViewClicked'");
    paramT.sivEducationType = ((SignerInfoItemView)Utils.castView(localView, 2131697548, "field 'sivEducationType'", SignerInfoItemView.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvEducationHint = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697549, "field 'tvEducationHint'", TextView.class));
  }
  
  public void unbind()
  {
    EducationActivity localEducationActivity = this.a;
    if (localEducationActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localEducationActivity.commonTitleIvBack = null;
    localEducationActivity.commonTitleTvTitle = null;
    localEducationActivity.commonTitleTvRightButton = null;
    localEducationActivity.commonTitleDivideLine = null;
    localEducationActivity.tvEducationSignStatus = null;
    localEducationActivity.sivSchoolingDegree = null;
    localEducationActivity.sivSchoolName = null;
    localEducationActivity.sivInYear = null;
    localEducationActivity.sivOutYear = null;
    localEducationActivity.sivEducationType = null;
    localEducationActivity.tvEducationHint = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/education/EducationActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */