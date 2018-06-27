package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.bestgoods.model.t;
import com.ziroom.ziroomcustomer.bestgoods.model.v;
import java.text.DecimalFormat;
import java.util.List;

public class u
  extends BaseExpandableListAdapter
{
  private Context a;
  private List<v> b;
  private DecimalFormat c = new DecimalFormat("0.00");
  
  public u(Context paramContext, List<v> paramList)
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
    List localList;
    Double localDouble;
    if (paramView == null)
    {
      paramViewGroup = new b();
      paramView = LayoutInflater.from(this.a).inflate(2130904580, null);
      paramViewGroup.a = paramView.findViewById(2131695814);
      paramViewGroup.b = ((SimpleDraweeView)paramView.findViewById(2131695815));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695794));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131695816));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131695817));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131695818));
      paramView.setTag(paramViewGroup);
      localList = ((v)this.b.get(paramInt1)).getShoppingCartEntityList();
      if (!((t)localList.get(paramInt2)).isChildSelect()) {
        break label610;
      }
      paramViewGroup.a.setVisibility(0);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.f.setVisibility(0);
      paramViewGroup.e.setVisibility(0);
      if (((t)localList.get(paramInt2)).getActivityType() != null) {
        break label492;
      }
      localDouble = ((t)localList.get(paramInt2)).getPrice();
      if (this.c != null) {
        paramViewGroup.e.setText("￥" + this.c.format(localDouble));
      }
      label287:
      if (((t)localList.get(paramInt2)).getAmount().intValue() != 0) {
        break label553;
      }
      paramViewGroup.a.setVisibility(8);
      paramViewGroup.b.setVisibility(8);
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.f.setVisibility(8);
      paramViewGroup.e.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.b.setController(c.frescoController(((t)localList.get(paramInt2)).getUrl()));
      paramViewGroup.c.setText(((t)localList.get(paramInt2)).getName());
      paramViewGroup.d.setText(((t)localList.get(paramInt2)).getSpecificationName());
      paramViewGroup.f.setText("x" + ((t)localList.get(paramInt2)).getAmount());
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label492:
      localDouble = ((t)localList.get(paramInt2)).getActivityPrice();
      if (this.c == null) {
        break label287;
      }
      paramViewGroup.e.setText("￥" + this.c.format(localDouble));
      break label287;
      label553:
      paramViewGroup.a.setVisibility(0);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.f.setVisibility(0);
      paramViewGroup.e.setVisibility(0);
    }
    label610:
    paramViewGroup.a.setVisibility(8);
    paramViewGroup.b.setVisibility(8);
    paramViewGroup.c.setVisibility(8);
    paramViewGroup.d.setVisibility(8);
    paramViewGroup.f.setVisibility(8);
    paramViewGroup.e.setVisibility(8);
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (((v)this.b.get(paramInt)).getShoppingCartEntityList() == null) {
      return 0;
    }
    return ((v)this.b.get(paramInt)).getShoppingCartEntityList().size();
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
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = View.inflate(this.a, 2130904581, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690739));
      paramView.setTag(paramViewGroup);
      List localList = ((v)this.b.get(paramInt)).getShoppingCartEntityList();
      i = 0;
      label65:
      if (i >= localList.size()) {
        break label171;
      }
      if (!((t)localList.get(i)).isChildSelect()) {
        break label150;
      }
    }
    label150:
    label171:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramViewGroup.a.setVisibility(0);
        paramViewGroup.a.setText(((v)this.b.get(paramInt)).getProviderName());
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        i += 1;
        break label65;
      }
      paramViewGroup.a.setVisibility(8);
      return paramView;
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
  }
  
  public static class b
  {
    View a;
    SimpleDraweeView b;
    TextView c;
    TextView d;
    TextView e;
    TextView f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */