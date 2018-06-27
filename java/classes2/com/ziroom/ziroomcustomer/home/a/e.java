package com.ziroom.ziroomcustomer.home.a;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class e
  extends BaseAdapter
{
  private Context a;
  private List<ContentBean> b;
  
  public e(Context paramContext, List<ContentBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
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
      paramViewGroup = new a(null);
      paramView = ((Activity)this.a).getLayoutInflater().inflate(2130904417, null);
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695500));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695501));
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131695499));
      c.frescoHierarchyController(paramViewGroup.a, 2130840479);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      String str = x.makeUrl(((ContentBean)this.b.get(paramInt)).getPic(), 0.5F);
      paramViewGroup.a.setController(c.frescoController(str));
      paramViewGroup.c.setText(((ContentBean)this.b.get(paramInt)).getTitle());
      paramViewGroup.b.setText(((ContentBean)this.b.get(paramInt)).getSubtitle());
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!ae.isNull(((ContentBean)e.a(e.this).get(paramInt)).getLink())) {
            JsBridgeWebActivity.start(e.b(e.this), ((ContentBean)e.a(e.this).get(paramInt)).getTitle(), ((ContentBean)e.a(e.this).get(paramInt)).getLink(), false, "", "", false);
          }
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  private class a
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */