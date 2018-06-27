package com.ziroom.ziroomcustomer.ziroomapartment.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryHouseTypeRoom.RoomDetailDtoListBean;
import java.util.List;

public class b
  extends BaseAdapter
{
  private Context a;
  private List<ZryHouseTypeRoom.RoomDetailDtoListBean> b;
  
  public b(Context paramContext, List<ZryHouseTypeRoom.RoomDetailDtoListBean> paramList)
  {
    this.a = paramContext;
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
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.a).inflate(2130904244, null, false);
    Object localObject = (TextView)paramViewGroup.findViewById(2131695092);
    paramView = (TextView)paramViewGroup.findViewById(2131695093);
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131695071);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131690979);
    ZryHouseTypeRoom.RoomDetailDtoListBean localRoomDetailDtoListBean = (ZryHouseTypeRoom.RoomDetailDtoListBean)this.b.get(paramInt);
    if (localRoomDetailDtoListBean == null) {
      return paramViewGroup;
    }
    ((TextView)localObject).setText(localRoomDetailDtoListBean.getRoomNumber() + "房间");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localRoomDetailDtoListBean.getFloorNumber()).append("层·朝").append(localRoomDetailDtoListBean.getDirection()).append("·使用面积").append(localRoomDetailDtoListBean.getRoomArea()).append("㎡ ");
    paramView.setText(((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(localRoomDetailDtoListBean.getStateName()))
    {
      paramView = "";
      if (!TextUtils.isEmpty(localRoomDetailDtoListBean.getAvaSignDate())) {
        break label243;
      }
      localTextView1.setText(paramView);
    }
    for (;;)
    {
      localTextView2.setText("¥" + localRoomDetailDtoListBean.getLongPrice() + "/月");
      return paramViewGroup;
      paramView = localRoomDetailDtoListBean.getStateName();
      break;
      label243:
      localTextView1.setText(paramView + "·" + m.getFormatDate(m.strToDate(localRoomDetailDtoListBean.getAvaSignDate(), m.b), m.l) + "可签约");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/adapter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */