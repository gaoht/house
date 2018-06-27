package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.model.Contract;
import java.util.List;

public class b
  extends BaseAdapter
{
  Context a;
  List<Contract> b;
  int c;
  
  public b(Context paramContext, List<Contract> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramView = new a();
      paramViewGroup = View.inflate(this.a, 2130904143, null);
      paramView.a = ((TextView)paramViewGroup.findViewById(2131693248));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131694880));
      paramView.c = ((ImageView)paramViewGroup.findViewById(2131694881));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    Contract localContract = (Contract)this.b.get(paramInt);
    paramView.a.setText(localContract.getAddress());
    paramView.b.setText(localContract.getContract_code());
    if (this.c == paramInt)
    {
      paramView.a.setTextColor(Color.parseColor("#FF8400"));
      paramView.c.setVisibility(0);
      return paramViewGroup;
    }
    paramView.a.setTextColor(Color.parseColor("#000000"));
    paramView.c.setVisibility(8);
    return paramViewGroup;
  }
  
  public void setCurLockRoomContract(int paramInt)
  {
    this.c = paramInt;
  }
  
  static class a
  {
    TextView a;
    TextView b;
    ImageView c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */