package com.ziroom.ziroomcustomer.findhouse.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.findhouse.model.SearchSuggestion;
import com.ziroom.ziroomcustomer.findhouse.model.SearchSuggestion.Item;
import java.util.ArrayList;
import java.util.List;

public class e
  extends BaseAdapter
{
  private Context a;
  private List<SearchSuggestion.Item> b;
  private String c = "";
  
  public e(Context paramContext, SearchSuggestion paramSearchSuggestion)
  {
    this.a = paramContext;
    if (paramSearchSuggestion == null) {
      return;
    }
    this.b = paramSearchSuggestion.getItems();
    this.c = paramSearchSuggestion.getQuery();
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      i = paramString.indexOf(this.c, i);
      if (i == -1) {
        break;
      }
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    paramString = new SpannableString(paramString);
    i = j;
    while (i < localArrayList.size())
    {
      paramString.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(2131624588)), ((Integer)localArrayList.get(i)).intValue(), ((Integer)localArrayList.get(i)).intValue() + this.c.length(), 17);
      i += 1;
    }
    paramTextView.setText(paramString);
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
      paramView = LayoutInflater.from(this.a).inflate(2130904488, null, false);
      paramViewGroup = new a();
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131690097));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690073));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131689995));
      paramView.setTag(paramViewGroup);
    }
    SearchSuggestion.Item localItem;
    for (;;)
    {
      localItem = (SearchSuggestion.Item)this.b.get(paramInt);
      if (localItem != null) {
        break;
      }
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.a.setController(c.frescoController(localItem.getIcon()));
    paramViewGroup.c.setText(localItem.getMemo());
    paramViewGroup.b.setText(localItem.getName());
    a(paramViewGroup.b, localItem.getName());
    paramViewGroup.d.setText(localItem.getHousenum());
    return paramView;
  }
  
  public void setKeyWords(String paramString)
  {
    this.c = paramString;
  }
  
  static class a
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */