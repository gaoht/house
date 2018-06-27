package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newclean.d.l;
import java.util.List;

public class d
  extends BaseAdapter
{
  private Context a;
  private List<l> b;
  
  public d(Context paramContext, List<l> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904141, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131694874));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131694875));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131694876));
      paramViewGroup.d = paramView.findViewById(2131690678);
      paramView.setTag(paramViewGroup);
    }
    Object localObject;
    for (;;)
    {
      l locall = (l)this.b.get(paramInt);
      String str = locall.getOperateStepsName() + "·";
      localObject = locall.getProgressLog();
      localObject = new SpannableString(str + (String)localObject);
      ForegroundColorSpan localForegroundColorSpan1 = new ForegroundColorSpan(-12303292);
      ForegroundColorSpan localForegroundColorSpan2 = new ForegroundColorSpan(-6710887);
      ((SpannableString)localObject).setSpan(localForegroundColorSpan1, 0, str.length(), 34);
      ((SpannableString)localObject).setSpan(localForegroundColorSpan2, str.length(), ((SpannableString)localObject).length(), 34);
      paramViewGroup.b.setText((CharSequence)localObject);
      paramViewGroup.c.setText(locall.getOperateTime());
      if (this.b.size() > 0)
      {
        if (this.b.size() != 1) {
          break;
        }
        paramViewGroup.d.setVisibility(8);
        paramViewGroup.a.setBackgroundResource(2130839520);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(40960), 0, ((SpannableString)localObject).length(), 34);
        paramViewGroup.b.setText((CharSequence)localObject);
      }
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    if (paramInt == this.b.size() - 1)
    {
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.a.setBackgroundResource(2130839520);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(40960), 0, ((SpannableString)localObject).length(), 34);
      paramViewGroup.b.setText((CharSequence)localObject);
      return paramView;
    }
    paramViewGroup.d.setVisibility(0);
    paramViewGroup.a.setBackgroundResource(2130839519);
    return paramView;
  }
  
  public class a
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public View d;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */