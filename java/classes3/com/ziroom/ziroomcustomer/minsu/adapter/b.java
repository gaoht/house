package com.ziroom.ziroomcustomer.minsu.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCityItemBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCityKeyBean;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.widget.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
  extends BaseAdapter
{
  public HashMap<String, Integer> a;
  private Context b;
  private List<MinsuCityKeyBean> c;
  private List<MinsuCityItemBean> d;
  private List<MinsuCityItemBean> e;
  private String[] f;
  private final int g = 3;
  private a h;
  
  public b(Context paramContext, List<MinsuCityKeyBean> paramList, List<MinsuCityItemBean> paramList1, List<MinsuCityItemBean> paramList2)
  {
    this.b = paramContext;
    this.c = paramList;
    this.d = paramList1;
    this.e = paramList2;
    this.a = new HashMap();
    this.f = new String[paramList.size()];
    int i = 0;
    if (i < this.c.size())
    {
      paramList = a(((MinsuCityKeyBean)this.c.get(i)).key);
      if (i - 1 >= 0) {}
      for (paramContext = a(((MinsuCityKeyBean)this.c.get(i - 1)).key);; paramContext = " ")
      {
        if (!paramContext.equals(paramList))
        {
          paramContext = a(((MinsuCityKeyBean)this.c.get(i)).key);
          this.a.put(paramContext, Integer.valueOf(i));
          this.f[i] = paramContext;
        }
        i += 1;
        break;
      }
    }
  }
  
  private int a(int paramInt)
  {
    return ad.dp2px(this.b, paramInt);
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {
      return "#";
    }
    if (paramString.trim().length() == 0) {
      return "#";
    }
    char c1 = paramString.trim().substring(0, 1).charAt(0);
    if (Pattern.compile("^[A-Za-z]+$").matcher(c1 + "").matches()) {
      return (c1 + "").toUpperCase();
    }
    return "#";
  }
  
  private void a(View paramView, final String paramString, List<MinsuCityItemBean> paramList)
  {
    View.OnClickListener local2 = new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (b.a(b.this) != null) {
          b.a(b.this).onItmClick(paramAnonymousView.getTag() + "");
        }
        if ("最近搜索".equals(paramString)) {
          v.onClick(b.c(b.this), "M-Search_searchcookie");
        }
      }
    };
    ((TextView)paramView.findViewById(2131695352)).setText(paramString);
    paramString = new ArrayList();
    paramView = (FlowLayout)paramView.findViewById(2131695353);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MinsuCityItemBean localMinsuCityItemBean = (MinsuCityItemBean)paramList.next();
      TextView localTextView = new TextView(this.b);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
      localMarginLayoutParams.setMargins(a(18), a(24), a(12), a(0));
      localTextView.setLayoutParams(localMarginLayoutParams);
      localTextView.setPadding(a(22), a(7), a(22), a(7));
      localTextView.setTextSize(14.0F);
      localTextView.setTextColor(this.b.getResources().getColor(2131624039));
      localTextView.setTag(localMinsuCityItemBean.name);
      localTextView.setOnClickListener(local2);
      localTextView.setText(localMinsuCityItemBean.name);
      localTextView.setBackgroundResource(2130839658);
      paramString.add(Integer.valueOf((int)(ab.length(localTextView, localMinsuCityItemBean.name) + 0.5F) + a(44)));
      paramView.addView(localTextView);
    }
    int m = ac.getScreenWidth(this.b);
    int n = a(76);
    paramString = paramString.iterator();
    int i = 1;
    int k = 0;
    if (paramString.hasNext())
    {
      paramList = (Integer)paramString.next();
      int j;
      if (paramList.intValue() + k > m - n) {
        j = i + 1;
      }
      for (i = paramList.intValue();; i = k)
      {
        k = i;
        i = j;
        break;
        k = paramList.intValue() + k;
        j = i;
      }
    }
    paramView.getLayoutParams().height = (a(60) * i);
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    String str = ((MinsuCityKeyBean)this.c.get(paramInt)).key;
    if ("0".equals(str)) {
      return 0;
    }
    if ("1".equals(str)) {
      return 1;
    }
    return 2;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      paramView = View.inflate(this.b, 2130904360, null);
      a(paramView, "最近搜索", this.e);
      return paramView;
    }
    if (i == 1)
    {
      paramView = View.inflate(this.b, 2130904360, null);
      a(paramView, "热门城市", this.d);
      return paramView;
    }
    String str1;
    if (paramView == null)
    {
      paramViewGroup = new b();
      paramView = View.inflate(this.b, 2130904290, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131695221));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131694971));
      paramViewGroup.c = ((LinearLayout)paramView.findViewById(2131695220));
      paramViewGroup.d = paramView.findViewById(2131689578);
      paramView.setTag(paramViewGroup);
      str1 = ((MinsuCityKeyBean)this.c.get(paramInt)).name;
      String str2 = ((MinsuCityKeyBean)this.c.get(paramInt)).key;
      if ((!"0".equals(str2)) && (!"1".equals(str2)))
      {
        paramViewGroup.b.setText(str1);
        paramViewGroup.c.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (b.a(b.this) != null) {
              b.a(b.this).onItmClick(((MinsuCityKeyBean)b.b(b.this).get(paramInt)).name);
            }
          }
        });
        str2 = a(((MinsuCityKeyBean)this.c.get(paramInt)).key);
        if (paramInt - 2 < 0) {
          break label347;
        }
        str1 = a(((MinsuCityKeyBean)this.c.get(paramInt - 1)).key);
        label288:
        if (str1.equals(str2)) {
          break label354;
        }
        paramViewGroup.a.setVisibility(0);
        paramViewGroup.a.setText(str2);
      }
    }
    for (;;)
    {
      if (paramInt != getCount() - 1) {
        break label366;
      }
      paramViewGroup.d.setVisibility(8);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label347:
      str1 = " ";
      break label288;
      label354:
      paramViewGroup.a.setVisibility(8);
    }
    label366:
    paramViewGroup.d.setVisibility(0);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void setOnItemClickListener(a parama)
  {
    this.h = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onItmClick(String paramString);
  }
  
  class b
  {
    TextView a;
    TextView b;
    LinearLayout c;
    View d;
    
    b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */