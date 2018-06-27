package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.newServiceList.model.an;
import java.util.List;

public class i
  extends BaseAdapter
{
  private Context a;
  private List<an> b;
  private int c = -1;
  
  public i(Context paramContext, List<an> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
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
  
  public an getRepairItem(int paramInt)
  {
    if (this.b == null) {
      return null;
    }
    return (an)this.b.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.a).inflate(2130904474, null);
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131695582));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690049));
      paramView.setTag(paramViewGroup);
      if (((an)this.b.get(paramInt)).isSelected()) {
        break label139;
      }
      paramViewGroup.a.setController(c.frescoController(((an)this.b.get(paramInt)).getOffImgUrl()));
    }
    for (;;)
    {
      paramViewGroup.b.setText(((an)this.b.get(paramInt)).getProductName());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label139:
      paramViewGroup.a.setController(c.frescoController(((an)this.b.get(paramInt)).getOnImgUrl()));
    }
  }
  
  public void setItemSelected(int paramInt)
  {
    if (this.c == -1)
    {
      this.c = paramInt;
      ((an)this.b.get(paramInt)).setSelected(true);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      ((an)this.b.get(this.c)).setSelected(false);
      ((an)this.b.get(paramInt)).setSelected(true);
      this.c = paramInt;
    }
  }
  
  public class a
  {
    SimpleDraweeView a;
    TextView b;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */