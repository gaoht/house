package com.ziroom.ziroomcustomer.newchat.chatcenter.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.Map;

public class e
  extends BaseExpandableListAdapter
{
  private Context a;
  private List<String> b;
  private Map<Integer, List<String>> c;
  
  public e(Context paramContext, List<String> paramList, Map<Integer, List<String>> paramMap)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramMap;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    if ((this.c.get(Integer.valueOf(paramInt1)) != null) && (((List)this.c.get(Integer.valueOf(paramInt1))).size() > 0)) {
      return ((List)this.c.get(Integer.valueOf(paramInt1))).get(paramInt2);
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a).inflate(2130904193, null);
      paramView = new a(null);
      paramView.a = ((TextView)localView.findViewById(2131694980));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText((CharSequence)((List)this.c.get(Integer.valueOf(paramInt1))).get(paramInt2));
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    if ((this.c.get(Integer.valueOf(paramInt)) != null) && (((List)this.c.get(Integer.valueOf(paramInt))).size() > 0)) {
      return ((List)this.c.get(Integer.valueOf(paramInt))).size();
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
      localView = LayoutInflater.from(this.a).inflate(2130904194, null);
      paramView = new b(null);
      paramView.a = ((ImageView)localView.findViewById(2131690408));
      paramView.b = ((TextView)localView.findViewById(2131694981));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      if (!paramBoolean) {
        break label119;
      }
      paramViewGroup.a.setBackgroundResource(2130839790);
    }
    for (;;)
    {
      paramViewGroup.b.setText((CharSequence)this.b.get(paramInt));
      return localView;
      paramViewGroup = (b)paramView.getTag();
      localView = paramView;
      break;
      label119:
      paramViewGroup.a.setBackgroundResource(2130839793);
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
  
  private class a
  {
    TextView a;
    
    private a() {}
  }
  
  private class b
  {
    ImageView a;
    TextView b;
    
    private b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */