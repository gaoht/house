package com.ziroom.ziroomcustomer.signed.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ziroom.ziroomcustomer.model.Fees;
import com.ziroom.ziroomcustomer.termination.a.h;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.List;

public class NewZZLivingsAdapter
  extends BaseAdapter
{
  private Context a;
  private List<Fees> b;
  private viewHolder c;
  private String d;
  private List<h> e;
  
  public NewZZLivingsAdapter(Context paramContext, String paramString, List<h> paramList)
  {
    this.a = paramContext;
    this.d = paramString;
    this.e = paramList;
  }
  
  public NewZZLivingsAdapter(Context paramContext, List<Fees> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.d = null;
  }
  
  public static void setTextColor(TextView paramTextView, String paramString, int paramInt1, int paramInt2)
  {
    paramString = new SpannableStringBuilder(paramString);
    paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#DDDDDD")), paramInt1, paramInt1 + paramInt2, 33);
    if (paramTextView != null) {
      paramTextView.setText(paramString);
    }
  }
  
  public int getCount()
  {
    if (ae.isNull(this.d)) {
      return this.b.size();
    }
    return this.e.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (ae.isNull(this.d)) {
      return this.b.get(paramInt);
    }
    return this.e.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str3;
    String str2;
    String str1;
    if (paramView == null)
    {
      paramViewGroup = View.inflate(this.a, 2130904989, null);
      this.c = new viewHolder(paramViewGroup);
      paramViewGroup.setTag(this.c);
      if (!ae.isNull(this.d)) {
        break label336;
      }
      str3 = ((Fees)this.b.get(paramInt)).getType();
      paramView = ((Fees)this.b.get(paramInt)).getPrice();
      str2 = ((Fees)this.b.get(paramInt)).getBalance();
      localObject = ((Fees)this.b.get(paramInt)).getDisplayNums();
      str1 = ((Fees)this.b.get(paramInt)).getPrice_unit();
      label135:
      this.c.livings_item_name.setText(str3);
      if (!ae.notNull(str2)) {
        break label446;
      }
      str2 = "卡显示余额" + str2 + "";
      label182:
      paramInt = (str2 + "  ").length();
      if (!ae.notNull((String)localObject)) {
        break label453;
      }
    }
    label336:
    label446:
    label453:
    for (Object localObject = str2 + "  |  表底示数" + (String)localObject;; localObject = str2 + "  |  表底示数0.00")
    {
      this.c.livings_item_content.setText((CharSequence)localObject);
      setTextColor(this.c.livings_item_content, (String)localObject, paramInt, 1);
      if (ae.notNull(paramView))
      {
        localObject = paramView;
        if (ae.notNull(str1)) {
          localObject = paramView + str1;
        }
        this.c.livings_item_size.setText((CharSequence)localObject);
      }
      return paramViewGroup;
      this.c = ((viewHolder)paramView.getTag());
      paramViewGroup = paramView;
      break;
      str3 = ((h)this.e.get(paramInt)).getName();
      paramView = ((h)this.e.get(paramInt)).getPrice() + "";
      str2 = ((h)this.e.get(paramInt)).getBalance();
      localObject = ((h)this.e.get(paramInt)).getDisplayNums();
      str1 = ((h)this.e.get(paramInt)).getPriceUnit();
      break label135;
      str2 = "卡显示余额0.00";
      break label182;
    }
  }
  
  class viewHolder
  {
    @BindView(2131697118)
    TextView livings_item_content;
    @BindView(2131697117)
    TextView livings_item_name;
    @BindView(2131697119)
    TextView livings_item_size;
    
    viewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/adapter/NewZZLivingsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */