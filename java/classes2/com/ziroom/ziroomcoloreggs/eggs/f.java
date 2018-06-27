package com.ziroom.ziroomcoloreggs.eggs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.ziroom.ziroomcoloreggs.R.id;
import com.ziroom.ziroomcoloreggs.R.layout;
import java.util.List;

public class f
  extends BaseAdapter
{
  private List<e> a;
  private Context b;
  private a c;
  
  public f(List<e> paramList, Context paramContext)
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
      paramView = View.inflate(this.b, R.layout.web_log_http_item, null);
      this.c = new a(paramView);
      paramView.setTag(this.c);
    }
    for (;;)
    {
      this.c.a.setText(((e)this.a.get(paramInt)).get("url").toString().replace(" ", "").replace("\n", ""));
      if (paramInt == this.a.size()) {
        this.c.b.setVisibility(8);
      }
      return paramView;
      this.c = ((a)paramView.getTag());
    }
  }
  
  public List<e> getmList()
  {
    return this.a;
  }
  
  public void setmList(List<e> paramList)
  {
    this.a = paramList;
  }
  
  class a
  {
    TextView a;
    View b;
    
    a(View paramView)
    {
      this.a = ((TextView)paramView.findViewById(R.id.web_log_http_item_tv));
      this.b = paramView.findViewById(R.id.web_log_http_item_line);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcoloreggs/eggs/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */