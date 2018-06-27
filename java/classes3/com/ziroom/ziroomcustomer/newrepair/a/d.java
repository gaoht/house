package com.ziroom.ziroomcustomer.newrepair.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.fastjson.b;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.n;

public class d
  extends BaseAdapter
{
  private Context a;
  private b b;
  private a c;
  
  public d(Context paramContext, b paramb, a parama)
  {
    this.a = paramContext;
    this.b = paramb;
    this.c = parama;
  }
  
  public int getCount()
  {
    if (this.b.size() == 4) {
      return 4;
    }
    return this.b.size() + 1;
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
      paramViewGroup = new b();
      paramView = View.inflate(this.a, 2130904475, null);
      paramViewGroup.a = ((FrameLayout)paramView.findViewById(2131695583));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131691648));
      paramViewGroup.b = ((SimpleDraweeView)paramView.findViewById(2131695584));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject = paramViewGroup.a.getLayoutParams();
      int i = ac.getScreenWidth(this.a);
      ((ViewGroup.LayoutParams)localObject).width = ((i - n.dip2px(this.a, 64.0F)) / 4);
      ((ViewGroup.LayoutParams)localObject).height = ((i - n.dip2px(this.a, 64.0F)) / 4);
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramInt < this.b.size()) {
        break;
      }
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.b.setController(c.frescoController(""));
      paramViewGroup.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          d.a(d.this).onSelectPhoto();
        }
      });
      return paramView;
      paramViewGroup = (b)paramView.getTag();
    }
    paramViewGroup.c.setVisibility(0);
    paramViewGroup.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        d.b(d.this).remove(paramInt);
        d.this.notifyDataSetChanged();
      }
    });
    final Object localObject = this.b.getString(paramInt);
    paramViewGroup.b.setController(c.frescoController((String)localObject));
    paramViewGroup.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        d.a(d.this).onShowBigDialog(localObject, paramInt + 1, d.b(d.this).size());
      }
    });
    return paramView;
  }
  
  public static abstract interface a
  {
    public abstract void onSelectPhoto();
    
    public abstract void onShowBigDialog(String paramString, int paramInt1, int paramInt2);
  }
  
  class b
  {
    FrameLayout a;
    SimpleDraweeView b;
    ImageView c;
    
    b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */