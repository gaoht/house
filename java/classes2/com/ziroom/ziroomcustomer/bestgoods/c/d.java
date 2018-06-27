package com.ziroom.ziroomcustomer.bestgoods.c;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinShoppingCartActivity;
import com.ziroom.ziroomcustomer.bestgoods.model.i.c;
import com.ziroom.ziroomcustomer.bestgoods.model.r;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
{
  public static List<com.ziroom.ziroomcustomer.bestgoods.model.c> getRoomList()
  {
    ArrayList localArrayList = new ArrayList();
    com.ziroom.ziroomcustomer.bestgoods.model.c localc1 = new com.ziroom.ziroomcustomer.bestgoods.model.c();
    localc1.setName("全部");
    com.ziroom.ziroomcustomer.bestgoods.model.c localc2 = new com.ziroom.ziroomcustomer.bestgoods.model.c();
    localc2.setName("客厅");
    com.ziroom.ziroomcustomer.bestgoods.model.c localc3 = new com.ziroom.ziroomcustomer.bestgoods.model.c();
    localc3.setName("卧室");
    com.ziroom.ziroomcustomer.bestgoods.model.c localc4 = new com.ziroom.ziroomcustomer.bestgoods.model.c();
    localc4.setName("书卧");
    localArrayList.add(localc1);
    localArrayList.add(localc2);
    localArrayList.add(localc3);
    localArrayList.add(localc4);
    return localArrayList;
  }
  
  public static List<com.ziroom.ziroomcustomer.bestgoods.model.d> getStyleList()
  {
    ArrayList localArrayList = new ArrayList();
    com.ziroom.ziroomcustomer.bestgoods.model.d locald1 = new com.ziroom.ziroomcustomer.bestgoods.model.d();
    locald1.setName("全部");
    com.ziroom.ziroomcustomer.bestgoods.model.d locald2 = new com.ziroom.ziroomcustomer.bestgoods.model.d();
    locald2.setName("优格");
    com.ziroom.ziroomcustomer.bestgoods.model.d locald3 = new com.ziroom.ziroomcustomer.bestgoods.model.d();
    locald3.setName("清语");
    com.ziroom.ziroomcustomer.bestgoods.model.d locald4 = new com.ziroom.ziroomcustomer.bestgoods.model.d();
    locald4.setName("友家");
    localArrayList.add(locald1);
    localArrayList.add(locald2);
    localArrayList.add(locald3);
    localArrayList.add(locald4);
    return localArrayList;
  }
  
  public static List<r> getYouPinPromiseTtileData()
  {
    ArrayList localArrayList = new ArrayList();
    r localr1 = new r();
    localr1.setContent("材质保真");
    localr1.setPicRes(2130839813);
    r localr2 = new r();
    localr2.setContent("免费送装入户");
    localr2.setPicRes(2130838481);
    r localr3 = new r();
    localr3.setContent("免费上门退货");
    localr3.setPicRes(2130838479);
    localArrayList.add(localr1);
    localArrayList.add(localr2);
    localArrayList.add(localr3);
    return localArrayList;
  }
  
  public static boolean isAllCheck(List<Boolean> paramList)
  {
    int i = 0;
    boolean bool = true;
    while (i < paramList.size())
    {
      if (!((Boolean)paramList.get(i)).booleanValue()) {
        bool = false;
      }
      i += 1;
    }
    return bool;
  }
  
  public static List<r> mockPromiseData()
  {
    ArrayList localArrayList = new ArrayList();
    r localr1 = new r();
    localr1.setContent("如遇到材质描述不一致，买家可申请退货。");
    localr1.setPicRes(2130839813);
    r localr2 = new r();
    localr2.setContent("我们承诺从签收日起一年内，对商品提供维修、补寄零配件或更换全新商品的服务。");
    localr2.setPicRes(2130838480);
    r localr3 = new r();
    localr3.setContent("在我们承诺区域内，将向买家免费提供送货到买家收货地址并安装（包括但不限于长途干线运输、同城配送、搬楼、入户安装）的特殊服务。若因地址中的学校、单位或住宅小区不允许送货安装人员入内导致无法送货入户的，自如将不承担未提供送货入户服务的责任。");
    localr3.setPicRes(2130838481);
    r localr4 = new r();
    localr4.setContent("如因产品质量问题，签收后7天内，买家与客服协商申请退货，我们将在48小时内提供免费上门退货服务。");
    localr4.setPicRes(2130838479);
    localArrayList.add(localr1);
    localArrayList.add(localr2);
    localArrayList.add(localr3);
    localArrayList.add(localr4);
    return localArrayList;
  }
  
  public static String secToTime(int paramInt)
  {
    if (paramInt <= 0) {
      return "00:00";
    }
    int j = paramInt / 60;
    if (j < 60) {
      return unitFormat(j) + ":" + unitFormat(paramInt % 60);
    }
    int i = j / 60;
    j %= 60;
    return unitFormat(i) + ":" + unitFormat(j) + ":" + unitFormat(paramInt - i * 3600 - j * 60);
  }
  
  public static void setFlPromise(Context paramContext, List<i.c> paramList, FlowLayout paramFlowLayout)
  {
    int i = 0;
    while (i < paramList.size())
    {
      View localView = LayoutInflater.from(paramContext).inflate(2130903885, null);
      Object localObject = (SimpleDraweeView)localView.findViewById(2131693178);
      TextView localTextView = (TextView)localView.findViewById(2131693945);
      localTextView.setText(((i.c)paramList.get(i)).getServiceText());
      localTextView.setTextColor(-12303292);
      ((SimpleDraweeView)localObject).setController(com.freelxl.baselibrary.f.c.frescoController(((i.c)paramList.get(i)).getServiceUrl()));
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramFlowLayout.addView(localView);
      i += 1;
    }
  }
  
  public static void setFlowLayoutData(Context paramContext, List<String> paramList, FlowLayout paramFlowLayout)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      Button localButton = new Button(paramContext);
      localButton.setText((CharSequence)localObject);
      localButton.setTag(Boolean.valueOf(false));
      localButton.setTextColor(-12303292);
      localButton.setTextSize(12.0F);
      int i = n.dip2px(paramContext, 8.0F);
      localButton.setPadding(i, i, i, i);
      localButton.setBackgroundResource(2130840000);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, n.dip2px(paramContext, 10.0F), n.dip2px(paramContext, 10.0F));
      localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramFlowLayout.addView(localButton);
    }
  }
  
  public static void toYouPinShoppingCart(Context paramContext)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      a.startLoginActivity(paramContext);
      return;
    }
    paramContext.startActivity(new Intent(paramContext, YouPinShoppingCartActivity.class));
  }
  
  public static String unitFormat(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 10)) {
      return "0" + Integer.toString(paramInt);
    }
    return "" + paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */