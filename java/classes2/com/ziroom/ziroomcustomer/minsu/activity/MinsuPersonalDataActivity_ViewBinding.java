package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;

public class MinsuPersonalDataActivity_ViewBinding<T extends MinsuPersonalDataActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  
  public MinsuPersonalDataActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.etNickname = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131691057, "field 'etNickname'", LabeledEditText.class));
    View localView = Utils.findRequiredView(paramView, 2131696311, "field 'btnGender' and method 'onClick'");
    paramT.btnGender = ((LabeledEditText)Utils.castView(localView, 2131696311, "field 'btnGender'", LabeledEditText.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696312, "field 'btnBirthDay' and method 'onClick'");
    paramT.btnBirthDay = ((LabeledEditText)Utils.castView(localView, 2131696312, "field 'btnBirthDay'", LabeledEditText.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696313, "field 'btnTel' and method 'onClick'");
    paramT.btnTel = ((LabeledEditText)Utils.castView(localView, 2131696313, "field 'btnTel'", LabeledEditText.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.etEmail = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131696314, "field 'etEmail'", LabeledEditText.class));
    paramT.etAddress = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131696315, "field 'etAddress'", LabeledEditText.class));
    localView = Utils.findRequiredView(paramView, 2131696316, "field 'btnEducate' and method 'onClick'");
    paramT.btnEducate = ((LabeledEditText)Utils.castView(localView, 2131696316, "field 'btnEducate'", LabeledEditText.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.etJob = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131696317, "field 'etJob'", LabeledEditText.class));
    localView = Utils.findRequiredView(paramView, 2131696318, "field 'btnIntroduce' and method 'onClick'");
    paramT.btnIntroduce = ((LabeledEditText)Utils.castView(localView, 2131696318, "field 'btnIntroduce'", LabeledEditText.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689816, "field 'btnSubmit' and method 'onClick'");
    paramT.btnSubmit = ((TextView)Utils.castView(localView, 2131689816, "field 'btnSubmit'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_nickname_review = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696310, "field 'tv_nickname_review'", TextView.class));
    paramT.tv_introduce_review = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696319, "field 'tv_introduce_review'", TextView.class));
  }
  
  public void unbind()
  {
    MinsuPersonalDataActivity localMinsuPersonalDataActivity = this.a;
    if (localMinsuPersonalDataActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuPersonalDataActivity.etNickname = null;
    localMinsuPersonalDataActivity.btnGender = null;
    localMinsuPersonalDataActivity.btnBirthDay = null;
    localMinsuPersonalDataActivity.btnTel = null;
    localMinsuPersonalDataActivity.etEmail = null;
    localMinsuPersonalDataActivity.etAddress = null;
    localMinsuPersonalDataActivity.btnEducate = null;
    localMinsuPersonalDataActivity.etJob = null;
    localMinsuPersonalDataActivity.btnIntroduce = null;
    localMinsuPersonalDataActivity.btnSubmit = null;
    localMinsuPersonalDataActivity.tv_nickname_review = null;
    localMinsuPersonalDataActivity.tv_introduce_review = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuPersonalDataActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */