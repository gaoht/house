package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationListModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.StationProjectDetailActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class k
  extends BaseAdapter
{
  private List<StationListModel.DataBean> a;
  private int b;
  private Context c;
  private LayoutInflater d;
  
  public k(Context paramContext, List<StationListModel.DataBean> paramList)
  {
    this.c = paramContext;
    this.a = paramList;
    this.d = LayoutInflater.from(paramContext);
    this.b = (((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth() / 3 * 2);
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      a locala = (a)paramView.getTag();
      paramViewGroup = paramView;
      paramView = locala;
    }
    for (;;)
    {
      paramView.a.getLayoutParams().height = this.b;
      paramView.a.setTag(((StationListModel.DataBean)this.a.get(paramInt)).url);
      paramView.a.setController(c.frescoController(((StationListModel.DataBean)this.a.get(paramInt)).url));
      paramView.b.setText("¥" + (int)((StationListModel.DataBean)this.a.get(paramInt)).minPrice);
      paramView.c.setText(((StationListModel.DataBean)this.a.get(paramInt)).projectName);
      paramView.d.setText(((StationListModel.DataBean)this.a.get(paramInt)).projectAddress);
      paramViewGroup.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!TextUtils.isEmpty(((StationListModel.DataBean)k.a(k.this).get(paramInt)).projectBid))
          {
            paramAnonymousView = new HashMap();
            paramAnonymousView.put("pid", ((StationListModel.DataBean)k.a(k.this).get(paramInt)).projectBid);
            w.onEventValueToZiroomAndUmeng("zinn_list_num", paramAnonymousView);
          }
          paramAnonymousView = new Intent(k.b(k.this), StationProjectDetailActivity.class);
          paramAnonymousView.putExtra("projectBid", ((StationListModel.DataBean)k.a(k.this).get(paramInt)).projectBid);
          paramAnonymousView.putExtra("projectIndex", paramInt);
          k.b(k.this).startActivity(paramAnonymousView);
        }
      });
      return paramViewGroup;
      paramViewGroup = this.d.inflate(2130904202, paramViewGroup, false);
      paramView = a.a(paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
  }
  
  public void setData(List<StationListModel.DataBean> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  static class a
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
    
    public a(SimpleDraweeView paramSimpleDraweeView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
    {
      this.a = paramSimpleDraweeView;
      this.b = paramTextView1;
      this.c = paramTextView2;
      this.d = paramTextView3;
    }
    
    private static a b(View paramView)
    {
      return new a((SimpleDraweeView)paramView.findViewById(2131689744), (TextView)paramView.findViewById(2131695007), (TextView)paramView.findViewById(2131695008), (TextView)paramView.findViewById(2131695009));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */