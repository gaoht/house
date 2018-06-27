package com.ziroom.ziroomcustomer.newchat.chatcenter.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<com.ziroom.ziroomcustomer.newchat.chatcenter.b.a> b;
  
  public a(Context paramContext, List<com.ziroom.ziroomcustomer.newchat.chatcenter.b.a> paramList)
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
  
  public com.ziroom.ziroomcustomer.newchat.chatcenter.b.a getItem(int paramInt)
  {
    return (com.ziroom.ziroomcustomer.newchat.chatcenter.b.a)this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.a, 2130904494, null);
      paramView = new a();
      paramView.a = ((TextView)localView.findViewById(2131689752));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText(((com.ziroom.ziroomcustomer.newchat.chatcenter.b.a)this.b.get(paramInt)).getValue());
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public class a
  {
    public TextView a;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */