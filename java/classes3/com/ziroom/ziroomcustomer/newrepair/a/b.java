package com.ziroom.ziroomcustomer.newrepair.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newrepair.b.i;
import java.util.List;

public class b
  extends BaseAdapter
{
  private Context a;
  private List<i> b;
  
  public b(Context paramContext, List<i> paramList)
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
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.a).inflate(2130904250, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131695106));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131695107));
      paramView.setTag(paramViewGroup);
      if (!((i)this.b.get(paramInt)).isChosen()) {
        break label130;
      }
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setImageResource(2130840188);
    }
    for (;;)
    {
      paramViewGroup.a.setText(((i)this.b.get(paramInt)).getAddress());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label130:
      paramViewGroup.b.setVisibility(4);
    }
  }
  
  public class a
  {
    TextView a;
    ImageView b;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */