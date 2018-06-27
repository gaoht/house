package com.ziroom.ziroomcustomer.minsu.landlordrelease.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordFifthRoomBean;
import com.ziroom.ziroomcustomer.util.n;
import java.util.List;

public class g
  extends RecyclerView.a<b>
{
  private Context a;
  private List<LandlordFifthRoomBean> b;
  private h.a c;
  private a d;
  private int e;
  
  public g(Context paramContext, List<LandlordFifthRoomBean> paramList, h.a parama, a parama1)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = parama;
    this.d = parama1;
    this.e = n.dip2px(paramContext, 90.0F);
  }
  
  public int getItemCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public void onBindViewHolder(b paramb, int paramInt)
  {
    LandlordFifthRoomBean localLandlordFifthRoomBean = (LandlordFifthRoomBean)this.b.get(paramInt);
    paramb.d.setTag(localLandlordFifthRoomBean);
    Object localObject;
    if ((localLandlordFifthRoomBean.picList != null) && (localLandlordFifthRoomBean.maxNum <= localLandlordFifthRoomBean.picList.size()))
    {
      paramb.d.setImageResource(2130839064);
      paramb.d.setOnClickListener(null);
      paramb.b.setText(localLandlordFifthRoomBean.picTypeName);
      localObject = new StringBuilder();
      if (localLandlordFifthRoomBean.minNum > 0) {
        ((StringBuilder)localObject).append("至少").append(localLandlordFifthRoomBean.minNum).append("张照片，");
      }
      ((StringBuilder)localObject).append("最多").append(localLandlordFifthRoomBean.maxNum).append("张照片");
      paramb.c.setText(((StringBuilder)localObject).toString());
      localObject = new h(this.a, localLandlordFifthRoomBean.picList, this.c);
      paramb.e.setAdapter((ListAdapter)localObject);
      paramInt = (localLandlordFifthRoomBean.picList.size() - 1) / 4;
      localObject = paramb.e.getLayoutParams();
      if (localLandlordFifthRoomBean.picList.size() != 0) {
        break label251;
      }
    }
    label251:
    for (paramInt = 0;; paramInt = this.e * (paramInt + 1))
    {
      ((ViewGroup.LayoutParams)localObject).height = paramInt;
      paramb.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      paramb.d.setImageResource(2130839063);
      paramb.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = (LandlordFifthRoomBean)paramAnonymousView.getTag();
          g.a locala = g.a(g.this);
          int j = paramAnonymousView.picType;
          if (paramAnonymousView.picList == null) {}
          for (int i = 0;; i = paramAnonymousView.maxNum - paramAnonymousView.picList.size())
          {
            locala.add(j, i, paramAnonymousView.roomFid);
            return;
          }
        }
      });
      break;
    }
  }
  
  public b onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.a).inflate(2130904330, paramViewGroup, false));
  }
  
  public void setData(List<LandlordFifthRoomBean> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract void add(int paramInt1, int paramInt2, String paramString);
  }
  
  class b
    extends RecyclerView.u
  {
    View a;
    TextView b;
    TextView c;
    ImageView d;
    GridView e;
    
    public b(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131694290));
      this.c = ((TextView)paramView.findViewById(2131695289));
      this.d = ((ImageView)paramView.findViewById(2131695288));
      this.e = ((GridView)paramView.findViewById(2131695290));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */