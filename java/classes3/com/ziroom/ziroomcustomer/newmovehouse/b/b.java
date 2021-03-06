package com.ziroom.ziroomcustomer.newmovehouse.b;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceDate.DataBean.MoveOrderDateBean;
import java.text.SimpleDateFormat;
import java.util.List;

public class b
  extends BaseAdapter
{
  private Context a;
  private List<MHServiceDate.DataBean.MoveOrderDateBean> b;
  private int c = -1;
  private SimpleDateFormat d = new SimpleDateFormat("MM/dd");
  
  public b(Context paramContext, List<MHServiceDate.DataBean.MoveOrderDateBean> paramList)
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = (WindowManager)this.a.getSystemService("window");
      paramView = new DisplayMetrics();
      ((WindowManager)localObject).getDefaultDisplay().getRealMetrics(paramView);
      localObject = LayoutInflater.from(this.a).inflate(2130904371, paramViewGroup, false);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((View)localObject).findViewById(2131693860);
      paramViewGroup.c = ((TextView)((View)localObject).findViewById(2131695368));
      paramViewGroup.d = ((TextView)((View)localObject).findViewById(2131695369));
      paramViewGroup.b = ((View)localObject).findViewById(2131690425);
      ViewGroup.LayoutParams localLayoutParams = paramViewGroup.b.getLayoutParams();
      localLayoutParams.width = ((int)(paramView.widthPixels / 4.5D));
      paramViewGroup.b.setLayoutParams(localLayoutParams);
      ((View)localObject).setTag(paramViewGroup);
    }
    paramView = (a)((View)localObject).getTag();
    if (this.c == paramInt)
    {
      paramView.a.setBackgroundColor(Color.parseColor("#ffa000"));
      paramView.c.setTextColor(Color.parseColor("#ffa000"));
      paramView.d.setTextColor(Color.parseColor("#ffa000"));
    }
    for (;;)
    {
      paramView.c.setText(((MHServiceDate.DataBean.MoveOrderDateBean)this.b.get(paramInt)).getDateValue());
      paramView.d.setText(this.d.format(Long.valueOf(((MHServiceDate.DataBean.MoveOrderDateBean)this.b.get(paramInt)).getDateKey())));
      return (View)localObject;
      paramView.a.setBackgroundColor(Color.parseColor("#00ffffff"));
      paramView.c.setTextColor(Color.parseColor("#444444"));
      paramView.d.setTextColor(Color.parseColor("#999999"));
    }
  }
  
  public void setData(List<MHServiceDate.DataBean.MoveOrderDateBean> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public void setSelectPosition(int paramInt)
  {
    this.c = paramInt;
    notifyDataSetChanged();
  }
  
  private class a
  {
    View a;
    View b;
    TextView c;
    TextView d;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */