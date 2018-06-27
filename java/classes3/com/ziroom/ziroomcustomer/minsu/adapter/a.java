package com.ziroom.ziroomcustomer.minsu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.AloneRoomBedTypeListDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomBedTypeMsgListBean;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<AloneRoomBedTypeListDataBean> b;
  private List<AloneRoomBedTypeMsgListBean> c;
  
  public a(Context paramContext, List<AloneRoomBedTypeListDataBean> paramList, List<AloneRoomBedTypeMsgListBean> paramList1)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramList1;
    if (paramList1 == null) {}
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.a).inflate(2130904122, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131694827));
      paramView.setTag(paramViewGroup);
    }
    while (((AloneRoomBedTypeMsgListBean)this.c.get(paramInt)).getNum() != 0)
    {
      paramViewGroup.a.setVisibility(0);
      paramViewGroup.a.setText(((AloneRoomBedTypeListDataBean)this.b.get(paramInt)).getText() + "x" + ((AloneRoomBedTypeMsgListBean)this.c.get(paramInt)).getNum());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.a.setVisibility(8);
    return paramView;
  }
  
  public class a
  {
    TextView a;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */