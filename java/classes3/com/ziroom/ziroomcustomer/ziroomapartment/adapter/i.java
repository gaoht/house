package com.ziroom.ziroomcustomer.ziroomapartment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignKvItem;
import java.util.List;

public class i
  extends BaseAdapter
{
  private Context a;
  private List<ZryuSignKvItem> b;
  private LayoutInflater c;
  
  public i(Context paramContext, List<ZryuSignKvItem> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = LayoutInflater.from(paramContext);
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
      paramView = this.c.inflate(2130904639, paramViewGroup, false);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131689857));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131691546));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      ZryuSignKvItem localZryuSignKvItem = (ZryuSignKvItem)getItem(paramInt);
      paramViewGroup.a.setText(localZryuSignKvItem.getName());
      paramViewGroup.b.setText(localZryuSignKvItem.getValue());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  private class a
  {
    public TextView a;
    public TextView b;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/adapter/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */