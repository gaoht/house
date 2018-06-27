package com.ziroom.ziroomcoloreggs.eggs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcoloreggs.R.color;
import com.ziroom.ziroomcoloreggs.R.drawable;
import com.ziroom.ziroomcoloreggs.R.id;
import com.ziroom.ziroomcoloreggs.R.layout;
import java.util.List;

public class e
  extends BaseAdapter
{
  private List<com.alibaba.fastjson.e> a;
  private Context b;
  private a c;
  
  public e(List<com.alibaba.fastjson.e> paramList, Context paramContext)
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
      paramView = View.inflate(this.b, R.layout.test_web_item, null);
      this.c = new a(paramView);
      paramView.setTag(this.c);
    }
    for (;;)
    {
      this.c.a.setText(((com.alibaba.fastjson.e)this.a.get(paramInt)).get("name") + "");
      if (!"1".equals(((com.alibaba.fastjson.e)this.a.get(paramInt)).get("isChecked"))) {
        break;
      }
      this.c.b.setImageResource(R.drawable.dir_choose);
      return paramView;
      this.c = ((a)paramView.getTag());
    }
    this.c.b.setImageResource(R.color.transparent);
    return paramView;
  }
  
  public List<com.alibaba.fastjson.e> getmList()
  {
    return this.a;
  }
  
  public void setmList(List<com.alibaba.fastjson.e> paramList)
  {
    this.a = paramList;
  }
  
  class a
  {
    TextView a;
    ImageView b;
    
    a(View paramView)
    {
      this.a = ((TextView)paramView.findViewById(R.id.test_web_tv));
      this.b = ((ImageView)paramView.findViewById(R.id.test_web_iv));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcoloreggs/eggs/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */