package com.ziroom.ziroomcustomer.newchat.chatcenter.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.f;
import java.util.List;

public class b
  extends BaseAdapter
{
  private Context a;
  private List<f> b;
  
  public b(Context paramContext, List<f> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private SpannableStringBuilder a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    paramString = new SpannableStringBuilder(localStringBuilder);
    paramString.setSpan(new ForegroundColorSpan(-16777216), 0, 5, 34);
    paramString.setSpan(new AbsoluteSizeSpan(sp2px(this.a, 12.0F)), 0, 5, 34);
    return paramString;
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
    f localf;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904175, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131690047));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690666));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131694958));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131694959));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131694960));
      paramView.setTag(paramViewGroup);
      localf = (f)this.b.get(paramInt);
      paramViewGroup.b.setText(localf.getCustName());
      paramViewGroup.c.setText(localf.getCustMobile());
      paramViewGroup.d.setText(localf.getContent());
      if (!TextUtils.isEmpty(localf.getSolution())) {
        break label211;
      }
      paramViewGroup.e.setVisibility(8);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localf.getPromise())) {
        break label230;
      }
      paramViewGroup.f.setVisibility(8);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label211:
      paramViewGroup.e.setText(a(localf.getSolution()));
    }
    label230:
    paramViewGroup.f.setText(a(localf.getPromise()));
    return paramView;
  }
  
  public int sp2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */