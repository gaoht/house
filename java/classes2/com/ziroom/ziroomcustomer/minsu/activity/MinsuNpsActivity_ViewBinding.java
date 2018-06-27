package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MinsuNpsActivity_ViewBinding<T extends MinsuNpsActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public MinsuNpsActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tvPrompt = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691629, "field 'tvPrompt'", TextView.class));
    paramT.back = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691627, "field 'back'", ImageView.class));
    paramT.mListView = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691630, "field 'mListView'", ListView.class));
    paramView = Utils.findRequiredView(paramView, 2131691628, "field 'nps_submit_done' and method 'onClick'");
    paramT.nps_submit_done = ((TextView)Utils.castView(paramView, 2131691628, "field 'nps_submit_done'", TextView.class));
    this.b = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick();
      }
    });
  }
  
  public void unbind()
  {
    MinsuNpsActivity localMinsuNpsActivity = this.a;
    if (localMinsuNpsActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuNpsActivity.tvPrompt = null;
    localMinsuNpsActivity.back = null;
    localMinsuNpsActivity.mListView = null;
    localMinsuNpsActivity.nps_submit_done = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuNpsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */