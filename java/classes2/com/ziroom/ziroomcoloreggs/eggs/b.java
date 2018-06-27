package com.ziroom.ziroomcoloreggs.eggs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcoloreggs.R.id;
import com.ziroom.ziroomcoloreggs.R.layout;
import java.io.File;
import java.util.List;

public class b
  extends BaseAdapter
{
  private List<File> a;
  private Context b;
  private a c;
  
  public b(List<File> paramList, Context paramContext)
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
      paramView = View.inflate(this.b, R.layout.error_log_list_item, null);
      this.c = new a(paramView);
      paramView.setTag(this.c);
    }
    for (;;)
    {
      this.c.a.setText(((File)this.a.get(paramInt)).getName());
      return paramView;
      this.c = ((a)paramView.getTag());
    }
  }
  
  public List<File> getmFile()
  {
    return this.a;
  }
  
  public void setmFile(List<File> paramList)
  {
    this.a = paramList;
  }
  
  public void updateDataSet(int paramInt)
  {
    if (((File)this.a.get(paramInt)).exists())
    {
      ((File)this.a.get(paramInt)).delete();
      this.a.remove(paramInt);
      notifyDataSetChanged();
    }
  }
  
  class a
  {
    TextView a;
    
    a(View paramView)
    {
      this.a = ((TextView)paramView.findViewById(R.id.error_log_list_tv));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcoloreggs/eggs/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */