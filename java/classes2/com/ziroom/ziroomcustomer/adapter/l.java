package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.model.ServerDetail;
import com.ziroom.ziroomcustomer.morepage.BaseServerActivity;
import java.util.List;

public class l
  extends BaseAdapter
{
  private Context a;
  private List<ServerDetail> b;
  
  public l(Context paramContext, List<ServerDetail> paramList)
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
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.a, 2130904363, null);
      paramView = new a(null);
      paramView.a = ((TextView)localView.findViewById(2131689533));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText(((ServerDetail)this.b.get(paramInt)).getTitle());
      localView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(l.a(l.this), BaseServerActivity.class);
          paramAnonymousView.putExtra("title", ((ServerDetail)l.b(l.this).get(paramInt)).getTitle());
          paramAnonymousView.putExtra("url", ((ServerDetail)l.b(l.this).get(paramInt)).getUrl());
          paramAnonymousView.putExtra("isSharedShow", false);
          l.a(l.this).startActivity(paramAnonymousView);
        }
      });
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  private class a
  {
    public TextView a;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */