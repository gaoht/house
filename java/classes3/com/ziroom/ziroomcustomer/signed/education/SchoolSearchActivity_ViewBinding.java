package com.ziroom.ziroomcustomer.signed.education;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class SchoolSearchActivity_ViewBinding<T extends SchoolSearchActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public SchoolSearchActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.commonTitleTvRightButton = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695950, "field 'commonTitleTvRightButton'", TextView.class));
    paramT.commonTitleDivideLine = Utils.findRequiredView(paramView, 2131695951, "field 'commonTitleDivideLine'");
    paramT.etSchoolNameKey = ((EditText)Utils.findRequiredViewAsType(paramView, 2131692471, "field 'etSchoolNameKey'", EditText.class));
    localView = Utils.findRequiredView(paramView, 2131692472, "field 'ivDeleteInput' and method 'onViewClicked'");
    paramT.ivDeleteInput = ((ImageView)Utils.castView(localView, 2131692472, "field 'ivDeleteInput'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.lvSchoolNames = ((ListView)Utils.findRequiredViewAsType(paramView, 2131692474, "field 'lvSchoolNames'", ListView.class));
    paramView = Utils.findRequiredView(paramView, 2131692473, "field 'llClickAdd' and method 'onViewClicked'");
    paramT.llClickAdd = ((LinearLayout)Utils.castView(paramView, 2131692473, "field 'llClickAdd'", LinearLayout.class));
    this.d = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    SchoolSearchActivity localSchoolSearchActivity = this.a;
    if (localSchoolSearchActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSchoolSearchActivity.commonTitleIvBack = null;
    localSchoolSearchActivity.commonTitleTvTitle = null;
    localSchoolSearchActivity.commonTitleTvRightButton = null;
    localSchoolSearchActivity.commonTitleDivideLine = null;
    localSchoolSearchActivity.etSchoolNameKey = null;
    localSchoolSearchActivity.ivDeleteInput = null;
    localSchoolSearchActivity.lvSchoolNames = null;
    localSchoolSearchActivity.llClickAdd = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/education/SchoolSearchActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */