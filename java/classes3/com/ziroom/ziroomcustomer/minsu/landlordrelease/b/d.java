package com.ziroom.ziroomcustomer.minsu.landlordrelease.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.HouseBedListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.HouseGroupListBean;
import java.util.List;

public class d
  extends BaseExpandableListAdapter
{
  private Context a;
  private List<HouseGroupListBean> b;
  private int c;
  private b d;
  
  public d(Context paramContext, List<HouseGroupListBean> paramList)
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
    View localView;
    if (paramView == null)
    {
      paramView = new c();
      localView = LayoutInflater.from(this.a).inflate(2130904278, null);
      paramView.a = ((TextView)localView.findViewById(2131695202));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText(((HouseBedListBean)((HouseGroupListBean)this.b.get(paramInt1)).getHouseBedList().get(paramInt2)).getHouseBedTitile() + "x" + ((HouseBedListBean)((HouseGroupListBean)this.b.get(paramInt1)).getHouseBedList().get(paramInt2)).getHouseBedNum());
      if (paramInt2 != ((HouseGroupListBean)this.b.get(paramInt1)).getHouseBedList().size() - 1) {
        break;
      }
      localView.findViewById(2131689578).setVisibility(0);
      return localView;
      paramViewGroup = (c)paramView.getTag();
      localView = paramView;
    }
    localView.findViewById(2131689578).setVisibility(8);
    return localView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (paramInt >= this.b.size()) {
      return 0;
    }
    List localList = ((HouseGroupListBean)this.b.get(paramInt)).getHouseBedList();
    if (localList == null) {
      return 0;
    }
    return localList.size();
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
      paramView = View.inflate(this.a, 2130904279, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131694290));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695205));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695204));
      paramViewGroup.d = paramView.findViewById(2131689578);
      paramViewGroup.e = paramView.findViewById(2131695203);
      paramView.setTag(paramViewGroup);
      paramViewGroup.a.setText(((HouseGroupListBean)this.b.get(paramInt)).getHouseGroupTitle());
      List localList = ((HouseGroupListBean)this.b.get(paramInt)).getHouseBedList();
      if ((localList == null) || (localList.size() <= 0)) {
        break label212;
      }
      paramViewGroup.b.setVisibility(8);
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.c.setText("修改");
    }
    for (;;)
    {
      paramViewGroup.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          d.a(d.this, paramInt);
          d.b(d.this).onGroupClickPosition(d.a(d.this));
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label212:
      paramViewGroup.b.setVisibility(0);
      paramView.findViewById(2131689578).setVisibility(0);
      paramViewGroup.b.setText("如果房间内有床，请添加床位信息");
      paramViewGroup.c.setText("添加");
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
  
  public void setmGroupItemClickListener(b paramb)
  {
    this.d = paramb;
  }
  
  public static class a
  {
    TextView a;
    TextView b;
    TextView c;
    View d;
    View e;
  }
  
  public static abstract interface b
  {
    public abstract void onGroupClickPosition(int paramInt);
  }
  
  public static class c
  {
    TextView a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */