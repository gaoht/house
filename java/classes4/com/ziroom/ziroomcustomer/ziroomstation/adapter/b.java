package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.ziroomstation.model.ImageBucket;
import com.ziroom.ziroomcustomer.ziroomstation.model.ImageItem;
import com.ziroom.ziroomcustomer.ziroomstation.utils.f;
import java.util.List;

public class b
  extends BaseAdapter
{
  private List<ImageBucket> a;
  private Context b;
  
  public b(Context paramContext, List<ImageBucket> paramList)
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
    ImageBucket localImageBucket;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904142, null);
      paramViewGroup = new a();
      a.a(paramViewGroup, (ImageView)paramView.findViewById(2131694877));
      a.a(paramViewGroup, (TextView)paramView.findViewById(2131689533));
      a.b(paramViewGroup, (TextView)paramView.findViewById(2131694879));
      paramView.setTag(paramViewGroup);
      localImageBucket = (ImageBucket)this.a.get(paramInt);
      if ((localImageBucket.imageList == null) || (localImageBucket.imageList.size() <= 0)) {
        break label217;
      }
      String str1 = ((ImageItem)localImageBucket.imageList.get(0)).thumbnailPath;
      String str2 = ((ImageItem)localImageBucket.imageList.get(0)).sourcePath;
      f.getInstance(this.b).displayBmp(a.a(paramViewGroup), str1, str2);
    }
    for (;;)
    {
      a.b(paramViewGroup).setText(localImageBucket.bucketName);
      a.c(paramViewGroup).setText(localImageBucket.count + "张");
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label217:
      a.a(paramViewGroup).setImageBitmap(null);
    }
  }
  
  static class a
  {
    private ImageView a;
    private TextView b;
    private TextView c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */