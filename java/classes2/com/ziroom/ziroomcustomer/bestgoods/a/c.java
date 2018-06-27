package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.bestgoods.model.SKUMo;
import java.util.List;

public class c
  extends BaseAdapter
{
  private List<SKUMo> a;
  private Context b;
  
  public c(Context paramContext, List<SKUMo> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
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
      paramView = LayoutInflater.from(this.b).inflate(2130904176, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((RelativeLayout)paramView.findViewById(2131692167));
      paramViewGroup.b = ((SimpleDraweeView)paramView.findViewById(2131694859));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131689912));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131689995));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      SKUMo localSKUMo = (SKUMo)this.a.get(paramInt);
      paramInt = localSKUMo.getCount();
      String str = localSKUMo.getSkuImg();
      paramViewGroup.c.setText(localSKUMo.getSkuName());
      paramViewGroup.e.setText("x" + paramInt);
      paramViewGroup.d.setText(String.format("%.2f", new Object[] { localSKUMo.getPrice() }));
      if (TextUtils.isEmpty(str)) {
        break;
      }
      paramViewGroup.b.setController(com.freelxl.baselibrary.f.c.frescoController(str));
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.b.setController(com.freelxl.baselibrary.f.c.frescoController(null));
    return paramView;
  }
  
  public void setData(List<SKUMo> paramList)
  {
    this.a = paramList;
  }
  
  public static class a
  {
    RelativeLayout a;
    SimpleDraweeView b;
    TextView c;
    TextView d;
    TextView e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */