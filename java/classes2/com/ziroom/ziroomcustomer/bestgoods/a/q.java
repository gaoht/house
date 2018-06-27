package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.bestgoods.model.af.a;
import com.ziroom.ziroomcustomer.bestgoods.model.af.a.a;
import java.util.List;

public class q
  extends BaseExpandableListAdapter
{
  private Context a;
  private List<af.a> b;
  
  public q(Context paramContext, List<af.a> paramList)
  {
    this.a = paramContext;
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
    if (paramView == null)
    {
      paramViewGroup = new b();
      paramView = LayoutInflater.from(this.a).inflate(2130904571, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131695794));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695795));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a.setText(((af.a.a)((af.a)this.b.get(paramInt1)).getReplacementDetailList().get(paramInt2)).getTitle());
      paramViewGroup.b.setText(((af.a.a)((af.a)this.b.get(paramInt1)).getReplacementDetailList().get(paramInt2)).getDescription());
      return paramView;
      paramViewGroup = (b)paramView.getTag();
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (((af.a)this.b.get(paramInt)).getReplacementDetailList() == null) {
      return 0;
    }
    return ((af.a)this.b.get(paramInt)).getReplacementDetailList().size();
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
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = View.inflate(this.a, 2130904572, null);
      paramView.a = ((TextView)localView.findViewById(2131690739));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText(((af.a)this.b.get(paramInt)).getTypeName());
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public static class a
  {
    TextView a;
  }
  
  public static class b
  {
    TextView a;
    TextView b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */