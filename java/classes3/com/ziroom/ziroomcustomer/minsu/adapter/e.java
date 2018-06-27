package com.ziroom.ziroomcustomer.minsu.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.HouseRoomListBean;
import java.util.List;

public class e
  extends BaseAdapter
{
  private Context a;
  private List<HouseRoomListBean> b;
  private b c;
  private a d;
  
  public e(Context paramContext, b paramb, a parama, List<HouseRoomListBean> paramList)
  {
    this.a = paramContext;
    this.c = paramb;
    this.d = parama;
    this.b = paramList;
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
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new c();
      paramView = LayoutInflater.from(this.a).inflate(2130904280, null);
      paramViewGroup.a = ((RelativeLayout)paramView.findViewById(2131691423));
      paramViewGroup.b = ((LinearLayout)paramView.findViewById(2131695206));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695207));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131695208));
      paramView.setTag(paramViewGroup);
      String str = ((HouseRoomListBean)this.b.get(paramInt)).getText();
      if (TextUtils.isEmpty(str)) {
        break label217;
      }
      paramViewGroup.c.setText(str);
      label119:
      if ((TextUtils.isEmpty(((HouseRoomListBean)this.b.get(paramInt)).getText())) || (TextUtils.isEmpty(((HouseRoomListBean)this.b.get(paramInt)).getValue()))) {
        break label248;
      }
      paramViewGroup.d.setText("已完成");
    }
    for (;;)
    {
      paramViewGroup.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          e.a(e.this).onRoomHaveItemClickListener(paramInt);
        }
      });
      paramViewGroup.b.setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          if (e.b(e.this) != null) {
            e.b(e.this).OnItemLongClickListener(paramInt);
          }
          return true;
        }
      });
      return paramView;
      paramViewGroup = (c)paramView.getTag();
      break;
      label217:
      paramViewGroup.c.setText("房间" + (paramInt + 1));
      break label119;
      label248:
      paramViewGroup.d.setHint("请填写房间" + (paramInt + 1) + "的信息");
    }
  }
  
  public void setmRoomHaveItemClickListener(b paramb)
  {
    this.c = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void OnItemLongClickListener(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void onRoomHaveItemClickListener(int paramInt);
  }
  
  public class c
  {
    RelativeLayout a;
    LinearLayout b;
    TextView c;
    TextView d;
    
    public c() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */