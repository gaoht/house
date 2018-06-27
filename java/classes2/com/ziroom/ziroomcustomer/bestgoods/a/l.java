package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.bestgoods.model.g;
import java.text.DecimalFormat;
import java.util.List;

public class l
  extends BaseAdapter
{
  private Context a;
  private List<g> b;
  
  public l(Context paramContext, List<g> paramList)
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
      paramView = LayoutInflater.from(this.a).inflate(2130904585, null);
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131695825));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695827));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695828));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131695826));
      paramView.setTag(paramViewGroup);
      paramViewGroup.a.setController(c.frescoController(((g)this.b.get(paramInt)).getImgUrl()));
      paramViewGroup.b.setText(((g)this.b.get(paramInt)).getTitle() + "");
      if (TextUtils.isEmpty(((g)this.b.get(paramInt)).getDesc())) {
        break label266;
      }
      paramViewGroup.c.setText(((g)this.b.get(paramInt)).getDesc());
    }
    for (;;)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
      paramViewGroup.d.setText(localDecimalFormat.format(((g)this.b.get(paramInt)).getSkuPrice()) + "");
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label266:
      paramViewGroup.c.setText("");
    }
  }
  
  class a
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
    
    a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */