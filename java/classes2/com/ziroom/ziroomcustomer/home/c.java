package com.ziroom.ziroomcustomer.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.d.a.a;
import com.ziroom.ziroomcustomer.life.LifeDetailsActivity;
import com.ziroom.ziroomcustomer.model.HomeIndex;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class c
  extends BaseAdapter
{
  a a = null;
  private Context b;
  private List<HomeIndex> c;
  
  public c(Context paramContext, List<HomeIndex> paramList)
  {
    this.b = paramContext;
    this.c = paramList;
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
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      this.a = new a();
      paramView = LayoutInflater.from(this.b).inflate(2130904969, null);
      this.a.c = ((SimpleDraweeView)paramView.findViewById(2131694494));
      this.a.b = ((TextView)paramView.findViewById(2131694496));
      this.a.d = ((TextView)paramView.findViewById(2131694495));
      this.a.a = ((FrameLayout)paramView.findViewById(2131697034));
      paramViewGroup = this.b.getResources().getDisplayMetrics();
      paramViewGroup = new RelativeLayout.LayoutParams(paramViewGroup.widthPixels, paramViewGroup.widthPixels / 4 * 3);
      this.a.a.setLayoutParams(paramViewGroup);
      paramView.setTag(this.a);
    }
    for (;;)
    {
      paramViewGroup = (HomeIndex)this.c.get(paramInt);
      if (paramViewGroup != null)
      {
        if (!TextUtils.isEmpty(paramViewGroup.getPic()))
        {
          ((GenericDraweeHierarchy)this.a.c.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
          ((GenericDraweeHierarchy)this.a.c.getHierarchy()).setPlaceholderImage(a.a.b);
          this.a.c.setController(com.freelxl.baselibrary.f.c.frescoController(paramViewGroup.getPic()));
        }
        this.a.d.setText(paramViewGroup.getTitle());
        this.a.b.setText(paramViewGroup.getSubtitle());
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        private Intent c;
        
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ("1".equals(((HomeIndex)c.a(c.this).get(paramInt)).getTypes()))
          {
            JsBridgeWebActivity.start(c.b(c.this), ((HomeIndex)c.a(c.this).get(paramInt)).getTitle(), ((HomeIndex)c.a(c.this).get(paramInt)).getUrl(), true, ((HomeIndex)c.a(c.this).get(paramInt)).getSubtitle(), ((HomeIndex)c.a(c.this).get(paramInt)).getPic(), false);
            return;
          }
          this.c = new Intent(c.b(c.this), LifeDetailsActivity.class);
          this.c.putExtra("activity_id", ((HomeIndex)c.a(c.this).get(paramInt)).getId());
          this.c.putExtra("title", ((HomeIndex)c.a(c.this).get(paramInt)).getTitle());
          c.b(c.this).startActivity(this.c);
        }
      });
      return paramView;
      this.a = ((a)paramView.getTag());
    }
  }
  
  public void setData(List<HomeIndex> paramList)
  {
    this.c = paramList;
  }
  
  static class a
  {
    FrameLayout a;
    TextView b;
    SimpleDraweeView c;
    TextView d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */