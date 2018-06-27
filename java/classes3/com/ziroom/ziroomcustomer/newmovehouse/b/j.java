package com.ziroom.ziroomcustomer.newmovehouse.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanTimePeriodBean.MoveOrderTimeBean;
import com.ziroom.ziroomcustomer.util.n;
import java.util.List;

public class j
  extends BaseAdapter
{
  protected int a = -1;
  private Context b;
  private List<MovingVanTimePeriodBean.MoveOrderTimeBean> c;
  private b d;
  
  public j(Context paramContext, List<MovingVanTimePeriodBean.MoveOrderTimeBean> paramList)
  {
    this.b = paramContext;
    this.c = paramList;
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2130904377, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.a = ((RelativeLayout)paramView.findViewById(2131690425));
      paramViewGroup.b = ((RelativeLayout)paramView.findViewById(2131693331));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131689852));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131695377));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695378));
      paramView.setTag(paramViewGroup);
      localObject = paramViewGroup.a.getLayoutParams();
      float f1 = (com.ziroom.ziroomcustomer.newServiceList.utils.j.getDisplayWidth(this.b) - n.dip2px(this.b, 16.0F) - n.dip2px(this.b, 24.0F) * 2) / 2.0F;
      float f2 = 48.0F * f1 / 155.0F;
      ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f2);
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (MovingVanTimePeriodBean.MoveOrderTimeBean)this.c.get(paramInt);
      paramViewGroup.d.setText(((MovingVanTimePeriodBean.MoveOrderTimeBean)localObject).getTimePointValue());
      paramViewGroup.c.setText(((MovingVanTimePeriodBean.MoveOrderTimeBean)localObject).getTimePointValue());
      if (((MovingVanTimePeriodBean.MoveOrderTimeBean)localObject).getHaveCapacity() != 1) {
        break label445;
      }
      if (!TextUtils.isEmpty(((MovingVanTimePeriodBean.MoveOrderTimeBean)localObject).getRemark())) {
        break label321;
      }
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.d.setTextColor(-12303292);
      paramViewGroup.b.setVisibility(8);
      if (this.a != paramInt) {
        break label301;
      }
      paramViewGroup.d.setTextColor(40960);
      paramViewGroup.a.setBackgroundResource(2130840419);
    }
    label301:
    label321:
    label445:
    while (((MovingVanTimePeriodBean.MoveOrderTimeBean)localObject).getHaveCapacity() != 0)
    {
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      paramViewGroup.d.setTextColor(-12303292);
      paramViewGroup.a.setBackgroundResource(2130840415);
      return paramView;
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.e.setTextColor(-12303292);
      paramViewGroup.c.setTextColor(-12303292);
      paramViewGroup.e.setText(((MovingVanTimePeriodBean.MoveOrderTimeBean)localObject).getRemark());
      paramViewGroup.a.setBackgroundResource(2130840415);
      if (this.a == paramInt)
      {
        paramViewGroup.e.setTextColor(40960);
        paramViewGroup.c.setTextColor(40960);
        paramViewGroup.a.setBackgroundResource(2130840419);
        return paramView;
      }
      paramViewGroup.e.setTextColor(-12303292);
      paramViewGroup.c.setTextColor(-12303292);
      paramViewGroup.a.setBackgroundResource(2130840415);
      return paramView;
    }
    paramViewGroup.d.setVisibility(8);
    paramViewGroup.b.setVisibility(0);
    paramViewGroup.e.setTextColor(-2236963);
    paramViewGroup.c.setTextColor(-2236963);
    paramViewGroup.e.setText(((MovingVanTimePeriodBean.MoveOrderTimeBean)localObject).getRemark());
    paramViewGroup.a.setBackgroundResource(2130840415);
    return paramView;
  }
  
  public void setData(List<MovingVanTimePeriodBean.MoveOrderTimeBean> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public void setOnTimeClickListener(b paramb)
  {
    this.d = paramb;
  }
  
  public void setmSelectPosition(int paramInt)
  {
    this.a = paramInt;
    notifyDataSetChanged();
  }
  
  public class a
  {
    public RelativeLayout a;
    public RelativeLayout b;
    public TextView c;
    public TextView d;
    public TextView e;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void selectItem(MovingVanTimePeriodBean.MoveOrderTimeBean paramMoveOrderTimeBean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */