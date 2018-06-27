package com.ziroom.ziroomcoloreggs.eggs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import com.ziroom.ziroomcoloreggs.R.id;
import com.ziroom.ziroomcoloreggs.R.layout;
import com.ziroom.ziroomcoloreggs.eggs.a.a;
import java.util.List;

public class g
  extends BaseAdapter
{
  private List<String> a;
  private Context b;
  private a c;
  
  public g(List<String> paramList, Context paramContext)
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
      paramView = View.inflate(this.b, R.layout.web_log_http_info_item, null);
      this.c = new a(paramView);
      paramView.setTag(this.c);
    }
    for (;;)
    {
      this.c.a.setText(a.format(((String)this.a.get(paramInt)).toString()));
      return paramView;
      this.c = ((a)paramView.getTag());
    }
  }
  
  public List<String> getmList()
  {
    return this.a;
  }
  
  public void setmList(List<String> paramList)
  {
    this.a = paramList;
  }
  
  class a
  {
    EditText a;
    
    a(View paramView)
    {
      this.a = ((EditText)paramView.findViewById(R.id.web_log_http_info_item_edit));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcoloreggs/eggs/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */