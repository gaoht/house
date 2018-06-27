package com.ziroom.ziroomcustomer.account.sortlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;
import java.util.List;

public class c
  extends BaseAdapter
  implements SectionIndexer
{
  private List<d> a = null;
  private Context b;
  
  public c(Context paramContext, List<d> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getPositionForSection(int paramInt)
  {
    int i = 0;
    while (i < getCount())
    {
      if (((d)this.a.get(i)).getSortLetters().toUpperCase().charAt(0) == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getSectionForPosition(int paramInt)
  {
    return ((d)this.a.get(paramInt)).getSortLetters().charAt(0);
  }
  
  public Object[] getSections()
  {
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    d locald = (d)this.a.get(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = LayoutInflater.from(this.b).inflate(2130903073, null);
      paramView.b = ((TextView)localView.findViewById(2131689533));
      paramView.a = ((TextView)localView.findViewById(2131689786));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      if (paramInt != getPositionForSection(getSectionForPosition(paramInt))) {
        break label151;
      }
      paramViewGroup.a.setVisibility(0);
      paramViewGroup.a.setText(locald.getSortLetters());
    }
    for (;;)
    {
      paramViewGroup.b.setText(((d)this.a.get(paramInt)).getName());
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label151:
      paramViewGroup.a.setVisibility(8);
    }
  }
  
  public void updateListView(List<d> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  static final class a
  {
    TextView a;
    TextView b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/sortlistview/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */