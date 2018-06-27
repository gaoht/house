package com.ziroom.ziroomcustomer.newrepair.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import java.util.List;
import java.util.Map;

public class a
  extends BaseExpandableListAdapter
{
  private Context a;
  private List<String> b;
  private Map<Integer, e> c;
  private int d = -1;
  
  public a(Context paramContext, List<String> paramList, Map<Integer, e> paramMap)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramMap;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    if (this.c.get(Integer.valueOf(paramInt1)) != null) {
      return Integer.valueOf(1);
    }
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
      paramView = LayoutInflater.from(this.a).inflate(2130904253, null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((MyGridView)paramView.findViewById(2131692359));
      paramViewGroup.b = paramView.findViewById(2131690279);
      paramView.setTag(paramViewGroup);
      if (paramViewGroup.a.getTag() != null) {
        break label128;
      }
      paramViewGroup.a.setAdapter((ListAdapter)this.c.get(Integer.valueOf(paramInt1)));
      paramViewGroup.a.setTag(Integer.valueOf(paramInt1));
    }
    label128:
    while (paramInt1 == ((Integer)paramViewGroup.a.getTag()).intValue())
    {
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
    paramViewGroup.a.setAdapter((ListAdapter)this.c.get(Integer.valueOf(paramInt1)));
    paramViewGroup.a.setTag(Integer.valueOf(paramInt1));
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (this.c.get(Integer.valueOf(paramInt)) != null) {
      return 1;
    }
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public int getGroupCount()
  {
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
      localView = LayoutInflater.from(this.a).inflate(2130904256, null);
      paramView = new b(null);
      paramView.a = ((TextView)localView.findViewById(2131695116));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText((CharSequence)this.b.get(paramInt));
      return localView;
      paramViewGroup = (b)paramView.getTag();
      localView = paramView;
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
  
  public void setSelectItem(int paramInt)
  {
    this.d = paramInt;
  }
  
  private class a
  {
    MyGridView a;
    View b;
    
    private a() {}
  }
  
  private class b
  {
    TextView a;
    
    private b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */