package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.ziroomstation.model.DaysPrice;
import com.ziroom.ziroomcustomer.ziroomstation.model.TypePrice;
import java.util.List;

public class h
  extends BaseExpandableListAdapter
{
  private LayoutInflater a;
  private List<DaysPrice> b;
  private Context c;
  
  public h(Context paramContext, List<DaysPrice> paramList)
  {
    this.a = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.b = paramList;
    this.c = paramContext;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((DaysPrice)this.b.get(paramInt1)).typePriceList.get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    LinearLayout.LayoutParams localLayoutParams;
    if (paramView == null)
    {
      paramView = this.a.inflate(2130904561, null);
      paramViewGroup = new a();
      a.a(paramViewGroup, (TextView)paramView.findViewById(2131695766));
      a.b(paramViewGroup, (TextView)paramView.findViewById(2131695767));
      a.c(paramViewGroup, (TextView)paramView.findViewById(2131695768));
      a.a(paramViewGroup, (ImageView)paramView.findViewById(2131695769));
      paramView.setTag(paramViewGroup);
      localLayoutParams = (LinearLayout.LayoutParams)a.a(paramViewGroup).getLayoutParams();
      if (paramInt2 != 0) {
        break label383;
      }
      localLayoutParams.setMargins(0, ab.dp2px(this.c, 12.0F), 0, 0);
    }
    for (;;)
    {
      a.a(paramViewGroup).setText(((TypePrice)((DaysPrice)this.b.get(paramInt1)).typePriceList.get(paramInt2)).roomName + " / " + ((TypePrice)((DaysPrice)this.b.get(paramInt1)).typePriceList.get(paramInt2)).typeName);
      a.b(paramViewGroup).setText("¥ " + (int)((TypePrice)((DaysPrice)this.b.get(paramInt1)).typePriceList.get(paramInt2)).typePrice);
      a.c(paramViewGroup).setText("x" + ((TypePrice)((DaysPrice)this.b.get(paramInt1)).typePriceList.get(paramInt2)).num);
      if (2 != ((TypePrice)((DaysPrice)this.b.get(paramInt1)).typePriceList.get(paramInt2)).isPreferential) {
        break label403;
      }
      a.d(paramViewGroup).setVisibility(0);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label383:
      localLayoutParams.setMargins(0, ab.dp2px(this.c, 8.0F), 0, 0);
    }
    label403:
    a.d(paramViewGroup).setVisibility(8);
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (((DaysPrice)this.b.get(paramInt)).typePriceList == null) {
      return 0;
    }
    return ((DaysPrice)this.b.get(paramInt)).typePriceList.size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public int getGroupCount()
  {
    if ((this.b == null) || (this.b.size() == 0) || (((DaysPrice)this.b.get(0)).typePriceList == null) || (((DaysPrice)this.b.get(0)).typePriceList.size() == 0)) {
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
      localView = this.a.inflate(2130904542, null);
      paramView = new b();
      b.a(paramView, (TextView)localView.findViewById(2131695693));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      b.a(paramViewGroup).setText(m.getFormatDate(((DaysPrice)this.b.get(paramInt)).dayDate, m.l) + "房费");
      return localView;
      paramViewGroup = (b)paramView.getTag();
      localView = paramView;
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  class a
  {
    private TextView b;
    private TextView c;
    private TextView d;
    private ImageView e;
    
    a() {}
  }
  
  class b
  {
    private TextView b;
    
    b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */