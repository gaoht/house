package com.ziroom.ziroomcustomer.ziroomstation;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;

public class IntoFillBedInfoActivity_ViewBinding<T extends IntoFillBedInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public IntoFillBedInfoActivity_ViewBinding(final T paramT, View paramView)
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
    localView = Utils.findRequiredView(paramView, 2131692803, "field 'tvCompleted' and method 'onClick'");
    paramT.tvCompleted = ((TextView)Utils.castView(localView, 2131692803, "field 'tvCompleted'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692804, "field 'ziIntoFillBedName' and method 'onClick'");
    paramT.ziIntoFillBedName = ((LabeledEditText)Utils.castView(localView, 2131692804, "field 'ziIntoFillBedName'", LabeledEditText.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692805, "field 'ziIntoFillBedSex' and method 'onClick'");
    paramT.ziIntoFillBedSex = ((LabeledEditText)Utils.castView(localView, 2131692805, "field 'ziIntoFillBedSex'", LabeledEditText.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.flTagGroupIntroYourself = ((FlowLayout)Utils.findRequiredViewAsType(paramView, 2131692806, "field 'flTagGroupIntroYourself'", FlowLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131692807, "field 'etTagAddIntroYourself' and method 'onClick'");
    paramT.etTagAddIntroYourself = ((EditText)Utils.castView(paramView, 2131692807, "field 'etTagAddIntroYourself'", EditText.class));
    this.f = paramView;
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
    IntoFillBedInfoActivity localIntoFillBedInfoActivity = this.a;
    if (localIntoFillBedInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localIntoFillBedInfoActivity.btnBack = null;
    localIntoFillBedInfoActivity.tvTitle = null;
    localIntoFillBedInfoActivity.tvCompleted = null;
    localIntoFillBedInfoActivity.ziIntoFillBedName = null;
    localIntoFillBedInfoActivity.ziIntoFillBedSex = null;
    localIntoFillBedInfoActivity.flTagGroupIntroYourself = null;
    localIntoFillBedInfoActivity.etTagAddIntroYourself = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/IntoFillBedInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */