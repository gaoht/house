package com.ziroom.ziroomcustomer.newmovehouse.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveChargeInfo;
import java.util.List;

public class d
  extends BaseAdapter
{
  private List<MoveChargeInfo> a;
  private Context b;
  
  public d(Context paramContext, List<MoveChargeInfo> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    return this.a.size();
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
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904364, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689846));
      paramViewGroup.c = paramView.findViewById(2131690279);
      paramView.setTag(paramViewGroup);
      if (paramInt != this.a.size() - 1) {
        break label140;
      }
      paramViewGroup.c.setVisibility(0);
    }
    for (;;)
    {
      MoveChargeInfo localMoveChargeInfo = (MoveChargeInfo)this.a.get(paramInt);
      paramViewGroup.a.setText(localMoveChargeInfo.getName());
      paramViewGroup.b.setText(localMoveChargeInfo.getMoney());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label140:
      paramViewGroup.c.setVisibility(8);
    }
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    public View c;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */