package com.ziroom.ziroomcustomer.ziroomstation.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.ziroomstation.widget.MyListView;

public class IntoCashPledgeDetailsPop_ViewBinding<T extends IntoCashPledgeDetailsPop>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public IntoCashPledgeDetailsPop_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131697591, "field 'ivIntoCashPledgeClose' and method 'onClick'");
    paramT.ivIntoCashPledgeClose = ((ImageView)Utils.castView(localView, 2131697591, "field 'ivIntoCashPledgeClose'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick();
      }
    });
    paramT.tvIntoPeopleNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697594, "field 'tvIntoPeopleNum'", TextView.class));
    paramT.lvCashPledgeDetail = ((MyListView)Utils.findRequiredViewAsType(paramView, 2131697595, "field 'lvCashPledgeDetail'", MyListView.class));
    paramT.tvIntoDateStartEnd = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697598, "field 'tvIntoDateStartEnd'", TextView.class));
    paramT.tvIntoPeopleNumRen = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697599, "field 'tvIntoPeopleNumRen'", TextView.class));
    paramT.tvCashPledgeSingle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697600, "field 'tvCashPledgeSingle'", TextView.class));
    paramT.tvCashPledgeNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131697601, "field 'tvCashPledgeNum'", TextView.class));
    paramT.tvCashPledgeTotal = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692800, "field 'tvCashPledgeTotal'", TextView.class));
    paramT.viewDivider0 = Utils.findRequiredView(paramView, 2131697592, "field 'viewDivider0'");
    paramT.llArea0 = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131697593, "field 'llArea0'", LinearLayout.class));
    paramT.viewDivider1 = Utils.findRequiredView(paramView, 2131697596, "field 'viewDivider1'");
    paramT.llArea1 = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131697597, "field 'llArea1'", LinearLayout.class));
    paramT.viewDivider2 = Utils.findRequiredView(paramView, 2131697602, "field 'viewDivider2'");
  }
  
  public void unbind()
  {
    IntoCashPledgeDetailsPop localIntoCashPledgeDetailsPop = this.a;
    if (localIntoCashPledgeDetailsPop == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localIntoCashPledgeDetailsPop.ivIntoCashPledgeClose = null;
    localIntoCashPledgeDetailsPop.tvIntoPeopleNum = null;
    localIntoCashPledgeDetailsPop.lvCashPledgeDetail = null;
    localIntoCashPledgeDetailsPop.tvIntoDateStartEnd = null;
    localIntoCashPledgeDetailsPop.tvIntoPeopleNumRen = null;
    localIntoCashPledgeDetailsPop.tvCashPledgeSingle = null;
    localIntoCashPledgeDetailsPop.tvCashPledgeNum = null;
    localIntoCashPledgeDetailsPop.tvCashPledgeTotal = null;
    localIntoCashPledgeDetailsPop.viewDivider0 = null;
    localIntoCashPledgeDetailsPop.llArea0 = null;
    localIntoCashPledgeDetailsPop.viewDivider1 = null;
    localIntoCashPledgeDetailsPop.llArea1 = null;
    localIntoCashPledgeDetailsPop.viewDivider2 = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/dialog/IntoCashPledgeDetailsPop_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */