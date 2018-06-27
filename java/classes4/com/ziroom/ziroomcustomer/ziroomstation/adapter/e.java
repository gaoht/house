package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.ziroomstation.c.a;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderCreateHouseEntity;
import java.util.List;

public class e
  extends BaseAdapter
{
  private Context a;
  private a b;
  
  public e(Context paramContext, a parama)
  {
    this.a = paramContext;
    this.b = parama;
  }
  
  public int getCount()
  {
    if ((this.b == null) || (this.b.getmHouseLt() == null) || (this.b.getmHouseLt().size() == 0)) {
      return 0;
    }
    return this.b.getmHouseLt().size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.getmHouseLt().get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(this.a, 2130903703, null);
    }
    paramView = paramViewGroup.findViewById(2131689578);
    ((TextView)paramViewGroup.findViewById(2131693470)).setText(((StationOrderCreateHouseEntity)this.b.getmHouseLt().get(paramInt)).getName());
    ((TextView)paramViewGroup.findViewById(2131693471)).setText(((StationOrderCreateHouseEntity)this.b.getmHouseLt().get(paramInt)).getSize() + "人");
    if (paramInt == 0) {
      paramView.setVisibility(8);
    }
    return paramViewGroup;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */