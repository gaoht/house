package com.ziroom.ziroomcustomer.findhouse.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Config;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Space;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryHousetypeInfo.HouseConfigDtoListBean;
import java.util.Iterator;
import java.util.List;

public class RentHouseDetailSpacePop
  extends PopupWindow
  implements View.OnClickListener
{
  private ImageView a;
  private LinearLayout b;
  private View c;
  private Context d;
  private ObservableScrollView e;
  private View f;
  
  public RentHouseDetailSpacePop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RentHouseDetailSpacePop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RentHouseDetailSpacePop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    setAnimationStyle(2131427507);
    this.c = LayoutInflater.from(paramContext).inflate(2130905040, null);
    this.d = paramContext;
    a();
  }
  
  private void a()
  {
    this.a = ((ImageView)this.c.findViewById(2131697275));
    this.b = ((LinearLayout)this.c.findViewById(2131697286));
    this.e = ((ObservableScrollView)this.c.findViewById(2131689709));
    this.f = this.c.findViewById(2131692780);
    this.a.setOnClickListener(this);
    this.e.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        paramAnonymousInt1 = paramAnonymousInt2;
        if (paramAnonymousInt2 > 100) {
          paramAnonymousInt1 = 100;
        }
        RentHouseDetailSpacePop.a(RentHouseDetailSpacePop.this).setAlpha(paramAnonymousInt1 / 100.0F);
      }
    });
    setContentView(this.c);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
  
  public void show(View paramView, List<RentHouseDetail.Space> paramList)
  {
    if (!s.isEmpty(paramList))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (RentHouseDetail.Space)localIterator.next();
        LinearLayout localLinearLayout1 = (LinearLayout)LayoutInflater.from(this.d).inflate(2130905042, null);
        Object localObject2 = (TextView)localLinearLayout1.findViewById(2131697289);
        if (!TextUtils.isEmpty(((RentHouseDetail.Space)localObject1).getFace())) {
          paramList = ((RentHouseDetail.Space)localObject1).getName() + "（" + ((RentHouseDetail.Space)localObject1).getArea() + "㎡ ，" + ((RentHouseDetail.Space)localObject1).getFace() + "）";
        }
        for (;;)
        {
          ((TextView)localObject2).setText(paramList);
          paramList = (LinearLayout)localLinearLayout1.findViewById(2131697290);
          localObject1 = ((RentHouseDetail.Space)localObject1).getConfig();
          if (s.isEmpty((List)localObject1)) {
            break;
          }
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (RentHouseDetail.Config)((Iterator)localObject1).next();
            LinearLayout localLinearLayout2 = (LinearLayout)LayoutInflater.from(this.d).inflate(2130905041, null);
            TextView localTextView = (TextView)localLinearLayout2.findViewById(2131697287);
            SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)localLinearLayout2.findViewById(2131697288);
            localTextView.setText(((RentHouseDetail.Config)localObject2).getName());
            c.frescoHierarchyController(localSimpleDraweeView, 2130839305);
            localSimpleDraweeView.setController(c.frescoController(((RentHouseDetail.Config)localObject2).getIcon()));
            paramList.addView(localLinearLayout2);
          }
          if (!TextUtils.isEmpty(((RentHouseDetail.Space)localObject1).getArea())) {
            paramList = ((RentHouseDetail.Space)localObject1).getName() + "（" + ((RentHouseDetail.Space)localObject1).getArea() + "㎡）";
          } else {
            paramList = ((RentHouseDetail.Space)localObject1).getName();
          }
        }
        this.b.addView(localLinearLayout1);
      }
      if (!(this instanceof PopupWindow)) {
        super.showAtLocation(paramView, 0, 0, 0);
      }
    }
    else
    {
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, 0, 0);
  }
  
  public void showZryApartment(View paramView, List<ZryHousetypeInfo.HouseConfigDtoListBean> paramList)
  {
    showZryApartment(paramView, paramList, "房屋配置");
  }
  
  public void showZryApartment(View paramView, List<ZryHousetypeInfo.HouseConfigDtoListBean> paramList, String paramString)
  {
    LinearLayout localLinearLayout1 = (LinearLayout)LayoutInflater.from(this.d).inflate(2130905042, null);
    ((TextView)localLinearLayout1.findViewById(2131697289)).setText(paramString);
    paramString = (LinearLayout)localLinearLayout1.findViewById(2131697290);
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ZryHousetypeInfo.HouseConfigDtoListBean localHouseConfigDtoListBean = (ZryHousetypeInfo.HouseConfigDtoListBean)paramList.next();
      LinearLayout localLinearLayout2 = (LinearLayout)LayoutInflater.from(this.d).inflate(2130905041, null);
      TextView localTextView = (TextView)localLinearLayout2.findViewById(2131697287);
      SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)localLinearLayout2.findViewById(2131697288);
      localTextView.setText(localHouseConfigDtoListBean.getItemName());
      c.frescoHierarchyController(localSimpleDraweeView, 2130839305);
      localSimpleDraweeView.setController(c.frescoController(localHouseConfigDtoListBean.getImgUrl()));
      paramString.addView(localLinearLayout2);
    }
    this.b.addView(localLinearLayout1);
    if (!(this instanceof PopupWindow))
    {
      super.showAtLocation(paramView, 0, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, 0, 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/RentHouseDetailSpacePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */