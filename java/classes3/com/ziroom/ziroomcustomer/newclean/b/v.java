package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newclean.d.au.a;
import java.text.DecimalFormat;
import java.util.List;

public class v
  extends BaseAdapter
{
  private Context a;
  private List<au.a> b;
  private boolean c;
  
  public v(Context paramContext, List<au.a> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = this.c;
  }
  
  public int getCount()
  {
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
    Object localObject;
    DecimalFormat localDecimalFormat;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904375, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690084));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689912));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131690724));
      paramView.setTag(paramViewGroup);
      localObject = (au.a)this.b.get(paramInt);
      paramViewGroup.a.setText(((au.a)localObject).getItemName());
      localDecimalFormat = new DecimalFormat("######0.00");
      if (!"优惠金额".equals(((au.a)localObject).getItemName())) {
        break label202;
      }
      paramViewGroup.b.setText("-" + localDecimalFormat.format(((au.a)localObject).getItemAmount()) + "元");
    }
    for (;;)
    {
      localObject = (RelativeLayout.LayoutParams)paramViewGroup.b.getLayoutParams();
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label202:
      paramViewGroup.b.setText(localDecimalFormat.format(((au.a)localObject).getItemAmount()) + "元");
    }
  }
  
  public void setMoveFeeArrow(boolean paramBoolean)
  {
    this.c = paramBoolean;
    notifyDataSetChanged();
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    public ImageView c;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */