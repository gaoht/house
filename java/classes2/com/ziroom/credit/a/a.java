package com.ziroom.credit.a;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.datacenter.remote.responsebody.financial.b.f;
import com.ziroom.router.activityrouter.Routers;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<f> b;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a(f paramf, View paramView)
  {
    paramf = "ziroomCustomer://zrCreditModule/medalDetailView?medalCode=" + paramf.getMedalCode() + "&icon=" + paramf.getIcon() + "&isGet=" + paramf.getIsGet() + "&title=" + paramf.getTitle() + "&remark=" + paramf.getRemark();
    Routers.open(this.a, paramf);
    com.ziroom.credit.b.a.startAcAnim((Activity)this.a);
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
  
  public int getItemViewType(int paramInt)
  {
    return ((f)this.b.get(paramInt)).getType();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = null;
    Object localObject1 = null;
    int i = getItemViewType(paramInt);
    Object localObject2;
    if (paramView == null) {
      switch (i)
      {
      default: 
        localObject2 = null;
        paramViewGroup = paramView;
        paramView = (View)localObject2;
        label48:
        localObject2 = paramView;
        paramView = paramViewGroup;
        paramViewGroup = (ViewGroup)localObject2;
      }
    }
    for (;;)
    {
      localObject2 = (f)this.b.get(paramInt);
      switch (i)
      {
      default: 
        return paramView;
        localObject1 = new a();
        paramViewGroup = LayoutInflater.from(this.a).inflate(R.layout.credit_item_medal_label, null);
        ((a)localObject1).a = ((TextView)paramViewGroup.findViewById(R.id.credit_textView));
        paramViewGroup.setTag(localObject1);
        paramView = null;
        break label48;
        paramView = new b();
        paramViewGroup = LayoutInflater.from(this.a).inflate(R.layout.credit_item_medal_grid, null);
        paramView.b = ((SimpleDraweeView)paramViewGroup.findViewById(R.id.credit_img1));
        paramView.a = ((TextView)paramViewGroup.findViewById(R.id.credit_textView1));
        paramView.d = ((SimpleDraweeView)paramViewGroup.findViewById(R.id.credit_img2));
        paramView.c = ((TextView)paramViewGroup.findViewById(R.id.credit_textView2));
        paramView.f = ((SimpleDraweeView)paramViewGroup.findViewById(R.id.credit_img3));
        paramView.e = ((TextView)paramViewGroup.findViewById(R.id.credit_textView3));
        paramView.g = ((LinearLayout)paramViewGroup.findViewById(R.id.credit_ll_1));
        paramView.h = ((LinearLayout)paramViewGroup.findViewById(R.id.credit_ll_2));
        paramView.i = ((LinearLayout)paramViewGroup.findViewById(R.id.credit_ll_3));
        paramViewGroup.setTag(paramView);
        break label48;
        switch (i)
        {
        default: 
          localObject2 = null;
          localObject1 = paramViewGroup;
          paramViewGroup = (ViewGroup)localObject2;
          break;
        case 0: 
          localObject1 = (a)paramView.getTag();
          paramViewGroup = null;
          break;
        case 1: 
          localObject2 = (b)paramView.getTag();
          localObject1 = paramViewGroup;
          paramViewGroup = (ViewGroup)localObject2;
        }
        break;
      }
    }
    ((a)localObject1).a.setText(((f)localObject2).getmName());
    return paramView;
    if (((f)localObject2).getMedalList().size() > 0)
    {
      paramViewGroup.g.setVisibility(0);
      paramViewGroup.g.setTag(((f)localObject2).getMedalList().get(0));
      paramViewGroup.a.setText(((f)((f)localObject2).getMedalList().get(0)).getmName());
      paramViewGroup.b.setController(c.frescoController(((f)((f)localObject2).getMedalList().get(0)).getIcon()));
      paramViewGroup.g.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          f localf = (f)paramAnonymousView.getTag();
          a.a(a.this, localf, paramAnonymousView.findViewById(R.id.credit_img1));
        }
      });
      if (((f)localObject2).getMedalList().size() <= 1) {
        break label737;
      }
      paramViewGroup.h.setVisibility(0);
      paramViewGroup.h.setTag(((f)localObject2).getMedalList().get(1));
      paramViewGroup.c.setText(((f)((f)localObject2).getMedalList().get(1)).getmName());
      paramViewGroup.d.setController(c.frescoController(((f)((f)localObject2).getMedalList().get(1)).getIcon()));
      paramViewGroup.h.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          f localf = (f)paramAnonymousView.getTag();
          a.a(a.this, localf, paramAnonymousView.findViewById(R.id.credit_img2));
        }
      });
    }
    for (;;)
    {
      if (((f)localObject2).getMedalList().size() <= 2) {
        break label756;
      }
      paramViewGroup.i.setVisibility(0);
      paramViewGroup.i.setTag(((f)localObject2).getMedalList().get(2));
      paramViewGroup.e.setText(((f)((f)localObject2).getMedalList().get(2)).getmName());
      paramViewGroup.f.setController(c.frescoController(((f)((f)localObject2).getMedalList().get(2)).getIcon()));
      paramViewGroup.i.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          f localf = (f)paramAnonymousView.getTag();
          a.a(a.this, localf, paramAnonymousView.findViewById(R.id.credit_img3));
        }
      });
      return paramView;
      paramViewGroup.g.setVisibility(4);
      paramViewGroup.h.setVisibility(4);
      paramViewGroup.i.setVisibility(4);
      break;
      label737:
      paramViewGroup.h.setVisibility(4);
      paramViewGroup.i.setVisibility(4);
    }
    label756:
    paramViewGroup.i.setVisibility(4);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void setData(List<f> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public class a
  {
    public TextView a;
    
    public a() {}
  }
  
  public class b
  {
    public TextView a;
    public SimpleDraweeView b;
    public TextView c;
    public SimpleDraweeView d;
    public TextView e;
    public SimpleDraweeView f;
    public LinearLayout g;
    public LinearLayout h;
    public LinearLayout i;
    
    public b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */