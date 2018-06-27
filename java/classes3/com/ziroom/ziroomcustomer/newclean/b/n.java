package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.newclean.d.bb;
import java.util.List;

public class n
  extends BaseAdapter
{
  private Context a;
  private List<bb> b;
  
  public n(Context paramContext, List<bb> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public SpannableStringBuilder getMyString(String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramString);
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFA000")), 0, i, 33);
    return localSpannableStringBuilder;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.a).inflate(2130904166, null);
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694945));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690371));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131694948));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131694950));
      paramViewGroup.e = ((RelativeLayout)paramView.findViewById(2131694947));
      paramView.setTag(paramViewGroup);
      paramViewGroup.a.setController(c.frescoController(((bb)this.b.get(paramInt)).getPicUrl()));
      paramViewGroup.b.setText(((bb)this.b.get(paramInt)).getServiceInfoName());
      str = ((bb)this.b.get(paramInt)).getPriceRemark();
      if (!TextUtils.isEmpty(str)) {
        break label217;
      }
      paramViewGroup.e.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.d.setText(((bb)this.b.get(paramInt)).getRemark());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label217:
      paramViewGroup.e.setVisibility(0);
      paramViewGroup.c.setText(str);
    }
  }
  
  class a
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
    RelativeLayout e;
    
    a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */