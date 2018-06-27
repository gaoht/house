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
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.FacilitiesChildDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomAmenitiesBean;
import java.util.List;

public class i
  extends BaseExpandableListAdapter
{
  boolean a;
  private Context b;
  private List<LLReleaseRoomAmenitiesBean> c;
  private a d;
  
  public i(Context paramContext, List<LLReleaseRoomAmenitiesBean> paramList, a parama)
  {
    this.b = paramContext;
    this.c = paramList;
    this.d = parama;
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
      paramViewGroup = new b.c();
      paramView = LayoutInflater.from(this.b).inflate(2130904276, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131695199));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131695200));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a.setText(((FacilitiesChildDataBean)((LLReleaseRoomAmenitiesBean)this.c.get(paramInt1)).getChildList().get(paramInt2)).getText());
      this.a = ((FacilitiesChildDataBean)((LLReleaseRoomAmenitiesBean)this.c.get(paramInt1)).getChildList().get(paramInt2)).isSelect();
      if (!this.a) {
        break;
      }
      paramViewGroup.b.setImageResource(2130838660);
      paramViewGroup.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ((FacilitiesChildDataBean)((LLReleaseRoomAmenitiesBean)i.a(i.this).get(paramInt1)).getChildList().get(paramInt2)).setSelect(false);
          i.b(i.this).setAmenitiesChosen(i.a(i.this));
          i.this.notifyDataSetChanged();
        }
      });
      return paramView;
      paramViewGroup = (b.c)paramView.getTag();
    }
    paramViewGroup.b.setImageResource(2130838661);
    paramViewGroup.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ((FacilitiesChildDataBean)((LLReleaseRoomAmenitiesBean)i.a(i.this).get(paramInt1)).getChildList().get(paramInt2)).setSelect(true);
        i.b(i.this).setAmenitiesChosen(i.a(i.this));
        i.this.notifyDataSetChanged();
      }
    });
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    return ((LLReleaseRoomAmenitiesBean)this.c.get(paramInt)).getChildList().size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public int getGroupCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
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
      paramView = new b.a();
      localView = View.inflate(this.b, 2130904277, null);
      paramView.a = ((TextView)localView.findViewById(2131695201));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText(((LLReleaseRoomAmenitiesBean)this.c.get(paramInt)).getGroupTitle());
      return localView;
      paramViewGroup = (b.a)paramView.getTag();
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
  
  public void setmAmenitiesChosenListener(a parama)
  {
    this.d = parama;
  }
  
  public static abstract interface a
  {
    public abstract void setAmenitiesChosen(List<LLReleaseRoomAmenitiesBean> paramList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */