package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;

public class MinsuAppointmentPhotographerActivity_ViewBinding<T extends MinsuAppointmentPhotographerActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public MinsuAppointmentPhotographerActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tv_remark_count = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691245, "field 'tv_remark_count'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131691248, "field 'btn_appointment' and method 'onClick'");
    paramT.btn_appointment = localView;
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691241, "field 'let_appointment_time' and method 'onClick'");
    paramT.let_appointment_time = ((LabeledEditText)Utils.castView(localView, 2131691241, "field 'let_appointment_time'", LabeledEditText.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.et_remark = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690002, "field 'et_remark'", EditText.class));
    paramView = Utils.findRequiredView(paramView, 2131691493, "method 'onClick'");
    this.d = paramView;
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
    MinsuAppointmentPhotographerActivity localMinsuAppointmentPhotographerActivity = this.a;
    if (localMinsuAppointmentPhotographerActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuAppointmentPhotographerActivity.tv_remark_count = null;
    localMinsuAppointmentPhotographerActivity.btn_appointment = null;
    localMinsuAppointmentPhotographerActivity.let_appointment_time = null;
    localMinsuAppointmentPhotographerActivity.et_remark = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuAppointmentPhotographerActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */