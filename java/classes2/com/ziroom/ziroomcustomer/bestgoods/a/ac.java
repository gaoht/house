package com.ziroom.ziroomcustomer.bestgoods.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGroupListActivity_New;
import com.ziroom.ziroomcustomer.bestgoods.dialog.d;
import com.ziroom.ziroomcustomer.bestgoods.model.u.a;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import java.text.DecimalFormat;
import java.util.List;

public class ac
  extends BaseExpandableListAdapter
{
  private YouPinGroupListActivity_New a;
  private List<u.a> b;
  
  public ac(YouPinGroupListActivity_New paramYouPinGroupListActivity_New, List<u.a> paramList)
  {
    this.a = paramYouPinGroupListActivity_New;
    this.b = paramList;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = View.inflate(this.a, 2130904578, null);
    }
    for (;;)
    {
      paramViewGroup = (MyGridView)paramView;
      List localList = ((u.a)this.b.get(paramInt1)).getGroupDetail();
      paramViewGroup.setAdapter(new ao(this.a, localList));
      return paramView;
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    return 1;
  }
  
  public Object getGroup(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public int getGroupCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(final int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = View.inflate(this.a, 2130904579, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131695810));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695812));
      paramViewGroup.c = ((Button)paramView.findViewById(2131692701));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a.setText(((u.a)this.b.get(paramInt)).getGroupName());
      Double localDouble = ((u.a)this.b.get(paramInt)).getGroupPrice();
      DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
      paramViewGroup.b.setText(localDecimalFormat.format(localDouble) + "");
      paramViewGroup.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = ((u.a)ac.a(ac.this).get(paramInt)).getGroupName();
          String str = ((u.a)ac.a(ac.this).get(paramInt)).getGroupCode();
          new d(ac.b(ac.this), str, paramAnonymousView).show();
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public static class a
  {
    TextView a;
    TextView b;
    Button c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */