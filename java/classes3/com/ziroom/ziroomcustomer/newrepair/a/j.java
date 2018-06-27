package com.ziroom.ziroomcustomer.newrepair.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newrepair.b.d;
import com.ziroom.ziroomcustomer.newrepair.widget.DashLineView;
import com.ziroom.ziroomcustomer.util.n;
import java.util.List;

public class j
  extends BaseAdapter
{
  private Context a;
  private List<d> b;
  private String c;
  
  public j(Context paramContext, List<d> paramList, String paramString)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramString;
  }
  
  private void a(a parama, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    Object localObject = "";
    if (!TextUtils.isEmpty(paramString1)) {
      localObject = paramString1;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {}
    for (paramString1 = (String)localObject + "·";; paramString1 = (String)localObject)
    {
      localObject = (RelativeLayout.LayoutParams)parama.f.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, n.dip2px(this.a, 12.0F), 0, n.dip2px(this.a, 0.0F));
      if (paramInt2 == 0)
      {
        parama.a.setVisibility(4);
        parama.g.setVisibility(0);
        if (paramInt1 == 2) {
          parama.g.FileLine();
        }
      }
      for (;;)
      {
        paramString2 = paramString1 + paramString2;
        paramString2 = paramString2 + this.c;
        parama.d.setText(paramString1);
        if (paramInt1 != 1) {
          break;
        }
        parama.e.setText(paramString2);
        parama.e.setTextColor(this.a.getResources().getColor(2131624516));
        parama.c.setBackgroundResource(2130838907);
        return;
        parama.g.setDash();
        continue;
        if ((paramInt2 > 0) && (paramInt2 < this.b.size() - 1) && (paramInt1 == 2))
        {
          parama.a.setVisibility(0);
          parama.g.setVisibility(0);
          parama.a.FileLine();
          parama.g.FileLine();
        }
        else if ((paramInt2 > 0) && (paramInt2 < this.b.size() - 1) && (paramInt1 == 1))
        {
          parama.a.setVisibility(0);
          parama.g.setVisibility(0);
          parama.a.FileLine();
          parama.g.setDash();
        }
        else if ((paramInt2 > 0) && (paramInt2 < this.b.size() - 1) && (paramInt1 == 0))
        {
          parama.a.setVisibility(0);
          parama.g.setVisibility(0);
          parama.a.setDash();
          parama.g.setDash();
        }
        else
        {
          parama.a.setVisibility(0);
          parama.g.setVisibility(8);
          ((RelativeLayout.LayoutParams)localObject).setMargins(0, n.dip2px(this.a, 12.0F), 0, n.dip2px(this.a, 48.0F));
          if ((paramInt1 == 2) || (paramInt1 == 1)) {
            parama.a.FileLine();
          } else {
            parama.a.setDash();
          }
        }
      }
      if (paramInt1 == 2)
      {
        parama.e.setTextColor(this.a.getResources().getColor(2131624097));
        parama.c.setBackgroundResource(2130838908);
        paramString2 = new SpannableString(paramString2);
        paramString2.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(2131624039)), 0, paramString1.length(), 33);
        parama.e.setText(paramString2);
        return;
      }
      parama.e.setText(paramString2);
      parama.c.setBackgroundResource(2130838909);
      parama.e.setTextColor(this.a.getResources().getColor(2131624097));
      return;
    }
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
      paramView = LayoutInflater.from(this.a).inflate(2130904252, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((DashLineView)paramView.findViewById(2131695115));
      paramViewGroup.b = ((RelativeLayout)paramView.findViewById(2131689808));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131694874));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131690407));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131693265));
      paramViewGroup.g = ((DashLineView)paramView.findViewById(2131691738));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = (d)this.b.get(paramInt);
      a(paramViewGroup, ((d)localObject).getStatusName(), ((d)localObject).getProgress(), ((d)localObject).getRemark(), paramInt);
      localObject = ((d)localObject).getTime();
      paramViewGroup.f.setText((CharSequence)localObject);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public static class a
  {
    public DashLineView a;
    public RelativeLayout b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public DashLineView g;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */