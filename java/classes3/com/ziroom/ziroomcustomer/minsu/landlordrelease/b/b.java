package com.ziroom.ziroomcustomer.minsu.landlordrelease.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseAmenitiesBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.FacilitiesListDataBean;
import java.util.List;

public class b
  extends BaseExpandableListAdapter
{
  private Context a;
  private List<LandlordReleaseAmenitiesBean> b;
  private b c;
  
  public b(Context paramContext, List<LandlordReleaseAmenitiesBean> paramList, b paramb)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramb;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(final int paramInt1, final int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new c();
      paramView = LayoutInflater.from(this.a).inflate(2130904276, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131695199));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131695200));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a.setText(((FacilitiesListDataBean)((LandlordReleaseAmenitiesBean)this.b.get(paramInt1)).getChildList().get(paramInt2)).getText());
      if (!((FacilitiesListDataBean)((LandlordReleaseAmenitiesBean)this.b.get(paramInt1)).getChildList().get(paramInt2)).isSelect()) {
        break;
      }
      paramViewGroup.b.setImageResource(2130838660);
      paramViewGroup.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ((FacilitiesListDataBean)((LandlordReleaseAmenitiesBean)b.a(b.this).get(paramInt1)).getChildList().get(paramInt2)).setSelect(false);
          b.b(b.this).setAmenitiesChosen(b.a(b.this));
          b.this.notifyDataSetChanged();
        }
      });
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    paramViewGroup.b.setImageResource(2130838661);
    paramViewGroup.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ((FacilitiesListDataBean)((LandlordReleaseAmenitiesBean)b.a(b.this).get(paramInt1)).getChildList().get(paramInt2)).setSelect(true);
        b.b(b.this).setAmenitiesChosen(b.a(b.this));
        b.this.notifyDataSetChanged();
      }
    });
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    return ((LandlordReleaseAmenitiesBean)this.b.get(paramInt)).getChildList().size();
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
      localView = View.inflate(this.a, 2130904277, null);
      paramView.a = ((TextView)localView.findViewById(2131695201));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText(((LandlordReleaseAmenitiesBean)this.b.get(paramInt)).getGroupTitle());
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
  
  public void setmAmenitiesChosenListener(b paramb)
  {
    this.c = paramb;
  }
  
  public static class a
  {
    TextView a;
  }
  
  public static abstract interface b
  {
    public abstract void setAmenitiesChosen(List<LandlordReleaseAmenitiesBean> paramList);
  }
  
  public static class c
  {
    TextView a;
    ImageView b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */