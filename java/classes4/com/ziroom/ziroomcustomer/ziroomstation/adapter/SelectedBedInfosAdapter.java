package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoSelectedInfos.RoomBedInfos;
import com.ziroom.ziroomcustomer.ziroomstation.widget.MyGridView;
import java.util.List;

public class SelectedBedInfosAdapter
  extends BaseAdapter
{
  private LayoutInflater a;
  private List<IntoSelectedInfos.RoomBedInfos> b;
  private Context c;
  
  public SelectedBedInfosAdapter(Context paramContext, List<IntoSelectedInfos.RoomBedInfos> paramList)
  {
    this.a = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.b = paramList;
    this.c = paramContext;
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.a.inflate(2130904262, null);
    paramViewGroup = new ViewHolder(paramView);
    paramViewGroup.tvRoomNameInto.setText(((IntoSelectedInfos.RoomBedInfos)this.b.get(paramInt)).roomName);
    int i = ((IntoSelectedInfos.RoomBedInfos)this.b.get(paramInt)).beds.size();
    int j = i / 4;
    int k = i % 4;
    if (k != 0)
    {
      i = 0;
      while (i < 4 - k)
      {
        ((IntoSelectedInfos.RoomBedInfos)this.b.get(paramInt)).beds.add(j * 4 + i, "");
        i += 1;
      }
    }
    paramViewGroup.gvRoomBedsInto.setAdapter(new a(this.c, ((IntoSelectedInfos.RoomBedInfos)this.b.get(paramInt)).beds));
    return paramView;
  }
  
  static class ViewHolder
  {
    @BindView(2131695120)
    MyGridView gvRoomBedsInto;
    @BindView(2131695119)
    TextView tvRoomNameInto;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  class a
    extends BaseAdapter
  {
    Context a;
    List<String> b;
    
    public a(List<String> paramList)
    {
      this.a = paramList;
      List localList;
      this.b = localList;
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
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = (TextView)SelectedBedInfosAdapter.a(SelectedBedInfosAdapter.this).inflate(2130904261, null).findViewById(2131695118);
      paramView.setText((CharSequence)this.b.get(paramInt));
      return paramView;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/SelectedBedInfosAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */