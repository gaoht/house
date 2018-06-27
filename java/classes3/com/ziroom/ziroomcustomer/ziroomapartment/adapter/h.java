package com.ziroom.ziroomcustomer.ziroomapartment.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.HousingTypeInfoActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuProjectDetailActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuHouseTypeListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuHouseTypeListModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuHouseTypeListModel.DataBean.HouseTypeListBean;
import com.ziroom.ziroomcustomer.ziroomstation.PhotoPreviewActivity;
import com.ziroom.ziroomcustomer.ziroomstation.a.b;
import com.ziroom.ziroomcustomer.ziroomstation.fragment.StationRoomFragment.a;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;
import com.ziroom.ziroomcustomer.ziroomstation.widget.IntoTagTextView;
import java.util.ArrayList;
import java.util.List;

public class h
  extends BaseAdapter
{
  private List<ZryuHouseTypeListModel.DataBean.HouseTypeListBean> a;
  private Context b;
  private LayoutInflater c;
  private StationRoomFragment.a d;
  private b e = new b()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      if (paramAnonymousView.getTag() == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add((String)paramAnonymousView.getTag());
      paramAnonymousView = new Intent(h.a(h.this), PhotoPreviewActivity.class);
      paramAnonymousView.putStringArrayListExtra("photoDescription", localArrayList);
      paramAnonymousView.putExtra("position", 0);
      paramAnonymousView.putExtra("isDeleteable", false);
      ((Activity)h.a(h.this)).startActivityForResult(paramAnonymousView, 257);
    }
  };
  
  public h(Context paramContext, List<ZryuHouseTypeListModel.DataBean.HouseTypeListBean> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
    this.c = LayoutInflater.from(paramContext);
  }
  
  public h(Context paramContext, List<ZryuHouseTypeListModel.DataBean.HouseTypeListBean> paramList, StationRoomFragment.a parama)
  {
    this.b = paramContext;
    this.a = paramList;
    this.c = LayoutInflater.from(paramContext);
    this.d = parama;
  }
  
  private void a(String[] paramArrayOfString, FlowLayout paramFlowLayout)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return;
    }
    paramFlowLayout.removeAllViews();
    int j = paramArrayOfString.length;
    int i = 0;
    label20:
    Object localObject;
    if (i < j)
    {
      localObject = paramArrayOfString[i];
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label46;
      }
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label46:
      IntoTagTextView localIntoTagTextView = new IntoTagTextView(this.b);
      localIntoTagTextView.setTagBean((String)localObject);
      localIntoTagTextView.setGravity(16);
      localIntoTagTextView.setTextAppearance(this.b, 2131428054);
      localIntoTagTextView.setBackgroundResource(2130837908);
      localObject = new ViewGroup.MarginLayoutParams(-2, n.dip2px(this.b, 16.0F));
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(0, 0, n.dip2px(this.b, 5.0F), 0);
      localIntoTagTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int k = n.dip2px(this.b, 5.0F);
      localIntoTagTextView.setPadding(k, 0, k, 0);
      paramFlowLayout.addView(localIntoTagTextView);
      paramFlowLayout.requestLayout();
    }
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
      if (paramInt != 0) {
        break label448;
      }
      paramView.j.setVisibility(8);
      label31:
      paramView.b.setTag(((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htImgUrl);
      paramView.b.setController(c.frescoController(((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htImgUrl));
      paramView.c.setText(((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htName);
      if ((((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMinPrice == null) || (!((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMinPrice.equals(((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMaxPrice))) {
        break label459;
      }
      paramView.f.setText("¥" + ((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMinPrice);
      label201:
      paramView.g.setText("可选房间数: " + ((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htAvaRoomAcc + "间");
      if (((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htAvaRoomAcc != 0) {
        break label528;
      }
      paramView.d.setVisibility(8);
      label275:
      paramView.h.setText("面积: " + ((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htArea + "㎡起");
      if (paramInt != this.a.size() - 1) {
        break label540;
      }
      paramView.i.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(h.a(h.this), HousingTypeInfoActivity.class);
          paramAnonymousView.putExtra("projectId", ((ZryuProjectDetailActivity)h.a(h.this)).a);
          paramAnonymousView.putExtra("projectName", ((ZryuProjectDetailActivity)h.a(h.this)).b.data.projectName);
          paramAnonymousView.putExtra("htId", ((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)h.b(h.this).get(paramInt)).htId);
          paramAnonymousView.putExtra("isRoomful", ((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)h.b(h.this).get(paramInt)).isRoomful);
          paramAnonymousView.putExtra("roomFulTag", ((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)h.b(h.this).get(paramInt)).roomFulTag);
          h.a(h.this).startActivity(paramAnonymousView);
        }
      });
      if (((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).isRoomful != 0) {
        break label552;
      }
      paramView.k.setVisibility(8);
      paramView.l.setVisibility(0);
      paramView.l.setText(((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).roomFulTag);
      return paramViewGroup;
      paramViewGroup = this.c.inflate(2130904204, paramViewGroup, false);
      paramView = new a(paramViewGroup);
      paramViewGroup.setTag(paramView);
      break;
      label448:
      paramView.j.setVisibility(0);
      break label31;
      label459:
      paramView.f.setText("¥" + ((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMinPrice + " - ¥" + ((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMaxPrice);
      break label201;
      label528:
      paramView.d.setVisibility(8);
      break label275;
      label540:
      paramView.i.setVisibility(8);
    }
    label552:
    paramView.k.setVisibility(0);
    paramView.l.setVisibility(8);
    a(((ZryuHouseTypeListModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).roomTags, paramView.k);
    return paramViewGroup;
  }
  
  public void setData(List<ZryuHouseTypeListModel.DataBean.HouseTypeListBean> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public static class a
  {
    public View a;
    public SimpleDraweeView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public View i;
    public View j;
    public FlowLayout k;
    public TextView l;
    
    public a(View paramView)
    {
      this.a = paramView;
      this.b = ((SimpleDraweeView)paramView.findViewById(2131689744));
      this.c = ((TextView)paramView.findViewById(2131694996));
      this.d = ((TextView)paramView.findViewById(2131695020));
      this.e = ((TextView)paramView.findViewById(2131695010));
      this.f = ((TextView)paramView.findViewById(2131695012));
      this.g = ((TextView)paramView.findViewById(2131695021));
      this.h = ((TextView)paramView.findViewById(2131694289));
      this.i = paramView.findViewById(2131695018);
      this.j = paramView.findViewById(2131695019);
      this.k = ((FlowLayout)paramView.findViewById(2131695022));
      this.l = ((TextView)paramView.findViewById(2131695023));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/adapter/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */