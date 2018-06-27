package com.ziroom.ziroomcustomer.newrepair.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newrepair.b.s.b;
import java.util.List;

public class l
  extends BaseAdapter
{
  private Context a;
  private List<s.b> b;
  private float c;
  private float d;
  
  public l(Context paramContext, List<s.b> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = (j.getDisplayWidth(this.a) * 46.0F / 375.0F);
    this.d = (j.getDisplayWidth(this.a) * 60.0F / 375.0F);
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
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904479, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694449));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.c = ((RelativeLayout)paramView.findViewById(2131690425));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      s.b localb = (s.b)this.b.get(paramInt);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(localb.getName());
      ViewGroup.LayoutParams localLayoutParams = paramViewGroup.a.getLayoutParams();
      localLayoutParams.width = ((int)this.c);
      localLayoutParams.height = ((int)this.c);
      paramViewGroup.a.setLayoutParams(localLayoutParams);
      localLayoutParams = paramViewGroup.b.getLayoutParams();
      localLayoutParams.width = ((int)this.d);
      paramViewGroup.b.setLayoutParams(localLayoutParams);
      j.setServePic(paramViewGroup.a, localb.getPicUrl());
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = (s.b)l.a(l.this).get(paramInt);
          j.setClick2RepairList(l.b(l.this), paramAnonymousView);
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public void setData(List<s.b> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    public RelativeLayout c;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */