package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.model.Contract;
import java.util.List;

public class p
  extends BaseAdapter
{
  private List<Contract> a;
  private Context b;
  private a c;
  
  public p(Context paramContext, List<Contract> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130905176, null);
      this.c = new a();
      this.c.b = ((TextView)paramView.findViewById(2131697660));
      this.c.a = ((TextView)paramView.findViewById(2131697659));
      paramView.setTag(this.c);
    }
    for (;;)
    {
      this.c.b.setText(((Contract)this.a.get(paramInt)).getAddress());
      this.c.a.setText(((Contract)this.a.get(paramInt)).getContract_code());
      return paramView;
      this.c = ((a)paramView.getTag());
    }
  }
  
  class a
  {
    TextView a;
    TextView b;
    
    a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */