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
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectDetailModel.DataBean.HouseTypeListBean;
import com.ziroom.ziroomcustomer.ziroomstation.PhotoPreviewActivity;
import com.ziroom.ziroomcustomer.ziroomstation.a.b;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;
import com.ziroom.ziroomcustomer.ziroomstation.widget.IntoTagTextView;
import java.util.ArrayList;
import java.util.List;

public class e
  extends BaseAdapter
{
  private List<ZryuProjectDetailModel.DataBean.HouseTypeListBean> a;
  private Context b;
  private LayoutInflater c;
  private boolean d = false;
  private boolean e = false;
  private String f;
  private String g;
  private String h;
  private String i;
  private b j = new b()
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
      paramAnonymousView = new Intent(e.a(e.this), PhotoPreviewActivity.class);
      paramAnonymousView.putStringArrayListExtra("photoDescription", localArrayList);
      paramAnonymousView.putExtra("position", 0);
      paramAnonymousView.putExtra("isDeleteable", false);
      ((Activity)e.a(e.this)).startActivityForResult(paramAnonymousView, 257);
    }
  };
  
  public e(Context paramContext, List<ZryuProjectDetailModel.DataBean.HouseTypeListBean> paramList, String paramString1, String paramString2)
  {
    this.b = paramContext;
    this.a = paramList;
    this.c = LayoutInflater.from(paramContext);
    this.f = paramString1;
    this.g = paramString2;
  }
  
  private String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.endsWith(".0"));
    return paramString.substring(0, paramString.length() - 2);
  }
  
  private void a(String[] paramArrayOfString, FlowLayout paramFlowLayout)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return;
    }
    paramFlowLayout.removeAllViews();
    int m = paramArrayOfString.length;
    int k = 0;
    label20:
    Object localObject;
    if (k < m)
    {
      localObject = paramArrayOfString[k];
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label46;
      }
    }
    for (;;)
    {
      k += 1;
      break label20;
      break;
      label46:
      IntoTagTextView localIntoTagTextView = new IntoTagTextView(this.b);
      localIntoTagTextView.setTagBean((String)localObject);
      localIntoTagTextView.setGravity(16);
      localIntoTagTextView.setTextAppearance(this.b, 2131428055);
      localIntoTagTextView.setBackgroundResource(2130837909);
      localObject = new ViewGroup.MarginLayoutParams(-2, n.dip2px(this.b, 16.0F));
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(0, 0, n.dip2px(this.b, 5.0F), 0);
      localIntoTagTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int n = n.dip2px(this.b, 5.0F);
      localIntoTagTextView.setPadding(n, 0, n, 0);
      paramFlowLayout.addView(localIntoTagTextView);
      paramFlowLayout.requestLayout();
    }
  }
  
  public int getCount()
  {
    if (this.a != null)
    {
      if (!this.d)
      {
        if (this.a.size() > 5)
        {
          this.e = true;
          return 5;
        }
        return this.a.size();
      }
      return this.a.size();
    }
    return 0;
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
        break label473;
      }
      paramView.i.setVisibility(4);
      label30:
      paramView.b.setTag(((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htImgUrl);
      paramView.b.setController(c.frescoController(((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htImgUrl));
      paramView.c.setText(((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htName);
      ((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMinPrice = a(((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMinPrice);
      ((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMaxPrice = a(((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMaxPrice);
      if ((((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMinPrice == null) || (!((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMinPrice.equals(((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMaxPrice))) {
        break label484;
      }
      paramView.e.setText("¥" + ((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMinPrice);
      label272:
      paramView.f.setText("可选房间数: " + ((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htAvaRoomAcc + "间");
      paramView.g.setText("");
      if ((paramInt != 4) || (!this.e) || (this.d)) {
        break label553;
      }
      paramView.h.setVisibility(0);
      paramView.h.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          e.a(e.this, true);
          e.this.notifyDataSetChanged();
        }
      });
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(e.a(e.this), HousingTypeInfoActivity.class);
          paramAnonymousView.putExtra("projectId", e.b(e.this));
          paramAnonymousView.putExtra("projectName", e.c(e.this));
          paramAnonymousView.putExtra("htId", ((ZryuProjectDetailModel.DataBean.HouseTypeListBean)e.d(e.this).get(paramInt)).htId);
          paramAnonymousView.putExtra("isRoomful", ((ZryuProjectDetailModel.DataBean.HouseTypeListBean)e.d(e.this).get(paramInt)).isRoomful);
          paramAnonymousView.putExtra("roomFulTag", ((ZryuProjectDetailModel.DataBean.HouseTypeListBean)e.d(e.this).get(paramInt)).roomFulTag);
          e.a(e.this).startActivity(paramAnonymousView);
        }
      });
      if (((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).isRoomful != 0) {
        break label565;
      }
      paramView.j.setVisibility(8);
      paramView.k.setVisibility(0);
      paramView.k.setText(((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).roomFulTag);
      return paramViewGroup;
      paramViewGroup = this.c.inflate(2130904429, paramViewGroup, false);
      paramView = new a(paramViewGroup);
      paramViewGroup.setTag(paramView);
      break;
      label473:
      paramView.i.setVisibility(0);
      break label30;
      label484:
      paramView.e.setText("¥" + ((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMinPrice + " - " + ((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).htMaxPrice);
      break label272;
      label553:
      paramView.h.setVisibility(8);
    }
    label565:
    paramView.j.setVisibility(0);
    paramView.k.setVisibility(8);
    a(((ZryuProjectDetailModel.DataBean.HouseTypeListBean)this.a.get(paramInt)).roomTags, paramView.j);
    return paramViewGroup;
  }
  
  public void setData(List<ZryuProjectDetailModel.DataBean.HouseTypeListBean> paramList, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramList;
    notifyDataSetChanged();
    this.f = paramString1;
    this.g = paramString2;
    this.h = paramString3;
    this.i = paramString4;
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
    public View h;
    public View i;
    public FlowLayout j;
    public TextView k;
    
    public a(View paramView)
    {
      this.a = paramView;
      this.b = ((SimpleDraweeView)paramView.findViewById(2131689744));
      this.c = ((TextView)paramView.findViewById(2131694996));
      this.d = ((TextView)paramView.findViewById(2131695010));
      this.e = ((TextView)paramView.findViewById(2131695012));
      this.f = ((TextView)paramView.findViewById(2131695021));
      this.g = ((TextView)paramView.findViewById(2131694289));
      this.h = paramView.findViewById(2131695018);
      this.i = paramView.findViewById(2131695019);
      this.j = ((FlowLayout)paramView.findViewById(2131695022));
      this.k = ((TextView)paramView.findViewById(2131695023));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/adapter/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */