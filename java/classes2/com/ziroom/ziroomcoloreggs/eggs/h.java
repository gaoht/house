package com.ziroom.ziroomcoloreggs.eggs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcoloreggs.R.id;
import com.ziroom.ziroomcoloreggs.R.layout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class h
  extends BaseAdapter
{
  private List<File> a;
  private Context b;
  private a c;
  
  public h(List<File> paramList, Context paramContext)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public String FormetFileSize(long paramLong)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("#.00");
    if (paramLong < 1024L) {
      return localDecimalFormat.format(paramLong) + "B";
    }
    if (paramLong < 1048576L) {
      return localDecimalFormat.format(paramLong / 1024.0D) + "K";
    }
    if (paramLong < 1073741824L) {
      return localDecimalFormat.format(paramLong / 1048576.0D) + "M";
    }
    return localDecimalFormat.format(paramLong / 1.073741824E9D) + "G";
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
      paramView = View.inflate(this.b, R.layout.web_log_time_list_item, null);
      this.c = new a(paramView);
      paramView.setTag(this.c);
    }
    try
    {
      for (;;)
      {
        int i = new FileInputStream((File)this.a.get(paramInt)).available();
        this.c.b.setText(FormetFileSize(i));
        this.c.a.setText(((File)this.a.get(paramInt)).getName());
        return paramView;
        this.c = ((a)paramView.getTag());
      }
    }
    catch (FileNotFoundException paramViewGroup)
    {
      for (;;)
      {
        paramViewGroup.printStackTrace();
      }
    }
    catch (IOException paramViewGroup)
    {
      for (;;)
      {
        paramViewGroup.printStackTrace();
      }
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
    TextView b;
    
    a(View paramView)
    {
      this.a = ((TextView)paramView.findViewById(R.id.web_log_time_list_tv));
      this.b = ((TextView)paramView.findViewById(R.id.web_log_time_list_size));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcoloreggs/eggs/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */