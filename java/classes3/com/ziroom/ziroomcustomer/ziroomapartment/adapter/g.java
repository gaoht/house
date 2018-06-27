package com.ziroom.ziroomcustomer.ziroomapartment.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.d.a.a;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomapartment.a;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.HousingTypeInfoActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectListModel.DataBean.ProjectListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.IndicatorListView.a;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;
import com.ziroom.ziroomcustomer.ziroomstation.widget.IntoTagTextView;
import java.util.List;

public class g
  extends IndicatorListView.a
{
  Context a;
  List<ZryuProjectListModel.DataBean.ProjectListBean> b;
  int c;
  private String d = "ZryuProjectListAdapter";
  
  public g(Context paramContext, List<ZryuProjectListModel.DataBean.ProjectListBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = (((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth() / 2 * 1);
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
      IntoTagTextView localIntoTagTextView = new IntoTagTextView(this.a);
      localIntoTagTextView.setTagBean((String)localObject);
      localIntoTagTextView.setGravity(16);
      localIntoTagTextView.setTextAppearance(this.a, 2131428054);
      localIntoTagTextView.setBackgroundResource(2130837908);
      localObject = new ViewGroup.MarginLayoutParams(-2, n.dip2px(this.a, 16.0F));
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(0, 0, n.dip2px(this.a, 5.0F), 0);
      localIntoTagTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int k = n.dip2px(this.a, 5.0F);
      localIntoTagTextView.setPadding(k, 0, k, 0);
      paramFlowLayout.addView(localIntoTagTextView);
      paramFlowLayout.requestLayout();
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    if ((this.b != null) && (this.b.size() > 0) && (((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList != null) && (((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.size() > 0)) {
      return ((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2);
    }
    return null;
  }
  
  public int getChildCount(int paramInt)
  {
    if ((this.b != null) && (this.b.size() > 0))
    {
      if (((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt)).houseTypeList != null) {
        return ((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt)).houseTypeList.size();
      }
      return 0;
    }
    return 0;
  }
  
  public View getChildView(final int paramInt1, final int paramInt2)
  {
    View localView1 = LayoutInflater.from(this.a).inflate(2130904204, null);
    Object localObject = localView1.findViewById(2131695018);
    TextView localTextView3 = (TextView)localView1.findViewById(2131694289);
    TextView localTextView4 = (TextView)localView1.findViewById(2131695021);
    TextView localTextView1 = (TextView)localView1.findViewById(2131695012);
    TextView localTextView2 = (TextView)localView1.findViewById(2131694996);
    View localView2 = localView1.findViewById(2131695019);
    SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)localView1.findViewById(2131689744);
    FlowLayout localFlowLayout = (FlowLayout)localView1.findViewById(2131695022);
    TextView localTextView5 = (TextView)localView1.findViewById(2131695023);
    if (((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).isRoomful == 0)
    {
      localFlowLayout.setVisibility(8);
      localTextView5.setVisibility(0);
      localTextView5.setText(((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).roomFulTag);
      if (paramInt2 != 0) {
        break label656;
      }
      localView2.setVisibility(8);
      label195:
      ((View)localObject).setVisibility(8);
      localTextView3.setText("面积: " + ((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).htArea + "㎡起");
      localTextView4.setText("可选房间数: " + ((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).htAvaRoomAcc + "间");
      localObject = (TextView)localView1.findViewById(2131695020);
      if (((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).htAvaRoomAcc != 0) {
        break label665;
      }
      ((TextView)localObject).setVisibility(8);
      label363:
      if ((((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).htMinPrice == null) || (!((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).htMinPrice.equals(((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).htMaxPrice))) {
        break label675;
      }
      localTextView1.setText("¥" + ((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).htMinPrice);
    }
    for (;;)
    {
      localTextView2.setText(((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).htName);
      localSimpleDraweeView.setController(c.frescoController(((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).htImgUrl));
      ((GenericDraweeHierarchy)localSimpleDraweeView.getHierarchy()).setFailureImage(a.a.b);
      localView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(g.this.a, HousingTypeInfoActivity.class);
          paramAnonymousView.putExtra("projectId", ((ZryuProjectListModel.DataBean.ProjectListBean)g.this.b.get(paramInt1)).projectId);
          paramAnonymousView.putExtra("htId", ((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)g.this.b.get(paramInt1)).houseTypeList.get(paramInt2)).htId);
          paramAnonymousView.putExtra("projectName", ((ZryuProjectListModel.DataBean.ProjectListBean)g.this.b.get(paramInt1)).projectName);
          paramAnonymousView.putExtra("isRoomful", ((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)g.this.b.get(paramInt1)).houseTypeList.get(paramInt2)).isRoomful);
          paramAnonymousView.putExtra("roomFulTag", ((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)g.this.b.get(paramInt1)).houseTypeList.get(paramInt2)).roomFulTag);
          g.this.a.startActivity(paramAnonymousView);
        }
      });
      return localView1;
      localFlowLayout.setVisibility(0);
      localTextView5.setVisibility(8);
      a(((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).roomTags, localFlowLayout);
      break;
      label656:
      localView2.setVisibility(0);
      break label195;
      label665:
      ((TextView)localObject).setVisibility(8);
      break label363;
      label675:
      localTextView1.setText("¥" + ((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).htMinPrice + " - ¥" + ((ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean)((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt1)).houseTypeList.get(paramInt2)).htMaxPrice);
    }
  }
  
  public Object getGroup(int paramInt)
  {
    if ((this.b != null) && (this.b.size() > 0)) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public int getGroupCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public View getGroupView(final int paramInt)
  {
    View localView = LayoutInflater.from(this.a).inflate(2130904623, null);
    FrameLayout localFrameLayout = (FrameLayout)localView.findViewById(2131695894);
    TextView localTextView1 = (TextView)localView.findViewById(2131695896);
    TextView localTextView2 = (TextView)localView.findViewById(2131695008);
    TextView localTextView3 = (TextView)localView.findViewById(2131695009);
    SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)localView.findViewById(2131695895);
    localTextView1.setText(((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt)).projectMinPrice + "");
    localTextView2.setText(((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt)).projectName);
    localTextView3.setText(((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt)).projectAddr);
    localFrameLayout.getLayoutParams().height = this.c;
    u.i(this.d, "图片链接：" + ((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt)).projectImgUrl);
    localSimpleDraweeView.setController(c.frescoController(((ZryuProjectListModel.DataBean.ProjectListBean)this.b.get(paramInt)).projectImgUrl));
    ((GenericDraweeHierarchy)localSimpleDraweeView.getHierarchy()).setFailureImage(a.a.b);
    localView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        a.ToProjectInfo(g.this.a, ((ZryuProjectListModel.DataBean.ProjectListBean)g.this.b.get(paramInt)).projectId);
      }
    });
    return localView;
  }
  
  public View getLessView(int paramInt)
  {
    return LayoutInflater.from(this.a).inflate(2130904624, null);
  }
  
  public View getMoreView(int paramInt)
  {
    return LayoutInflater.from(this.a).inflate(2130904625, null);
  }
  
  public void setData(List<ZryuProjectListModel.DataBean.ProjectListBean> paramList)
  {
    this.b = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/adapter/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */