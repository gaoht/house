package com.ziroom.ziroomcustomer.home.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import java.util.List;

public class f
  extends BaseAdapter
{
  private Context a;
  private LayoutInflater b;
  private List<ContentBean> c;
  private boolean d;
  private int e;
  private int f;
  private float g;
  
  public f(Context paramContext, List<ContentBean> paramList)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a);
    paramContext = this.a.getResources().getDisplayMetrics();
    this.g = paramContext.density;
    this.e = ((int)(paramContext.widthPixels * 0.48D));
    this.f = (this.e * 2 / 3);
    this.c = paramList;
  }
  
  public f(Context paramContext, List<ContentBean> paramList, boolean paramBoolean)
  {
    this(paramContext, paramList);
    this.d = paramBoolean;
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      if (this.d)
      {
        paramView = this.b.inflate(2130904603, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131691098));
        new RelativeLayout.LayoutParams(this.e, this.f);
        paramViewGroup.a.setLayoutParams(new RelativeLayout.LayoutParams(this.e, this.f));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131689541));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131690071));
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      final ContentBean localContentBean = (ContentBean)getItem(paramInt);
      paramViewGroup.a.setController(c.frescoController(localContentBean.getPic()));
      paramViewGroup.b.setText(localContentBean.getTitle());
      paramViewGroup.c.setText(localContentBean.getSubtitle());
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(f.a(f.this), HomeWebActivity.class);
          paramAnonymousView.putExtra("url", localContentBean.getLink());
          paramAnonymousView.putExtra("title", localContentBean.getTitle());
          paramAnonymousView.putExtra("content", localContentBean.getSubtitle());
          paramAnonymousView.putExtra("pic", localContentBean.getPic());
          paramAnonymousView.putExtra("ziru", "homeService");
          f.a(f.this).startActivity(paramAnonymousView);
        }
      });
      return paramView;
      paramView = this.b.inflate(2130904602, paramViewGroup, false);
      break;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */