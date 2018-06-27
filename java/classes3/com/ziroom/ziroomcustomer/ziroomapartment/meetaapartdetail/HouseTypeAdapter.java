package com.ziroom.ziroomcustomer.ziroomapartment.meetaapartdetail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.HouseTypeInfoVo;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.HousingTypeInfoActivity;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;
import com.ziroom.ziroomcustomer.ziroomstation.widget.IntoTagTextView;
import java.util.ArrayList;

public class HouseTypeAdapter
  extends RecyclerView.a<MyViewHolder>
{
  private ArrayList<ProjectDetailForAppVo.HouseTypeInfoVo> a;
  private Context b;
  private boolean c = false;
  private boolean d = false;
  private String e;
  private String f;
  
  public HouseTypeAdapter(Context paramContext, ArrayList<ProjectDetailForAppVo.HouseTypeInfoVo> paramArrayList, String paramString1, String paramString2)
  {
    this.b = paramContext;
    this.a = paramArrayList;
    this.e = paramString1;
    this.f = paramString2;
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
      localIntoTagTextView.setTextAppearance(this.b, 2131428055);
      localIntoTagTextView.setBackgroundResource(2130837909);
      localObject = new ViewGroup.MarginLayoutParams(-2, n.dip2px(this.b, 16.0F));
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(0, 0, n.dip2px(this.b, 5.0F), 0);
      localIntoTagTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int k = n.dip2px(this.b, 5.0F);
      localIntoTagTextView.setPadding(k, 0, k, 0);
      paramFlowLayout.addView(localIntoTagTextView);
      paramFlowLayout.requestLayout();
    }
  }
  
  public int getItemCount()
  {
    if (this.a != null)
    {
      if (!this.c)
      {
        if (this.a.size() > 2)
        {
          this.d = true;
          return 2;
        }
        return this.a.size();
      }
      return this.a.size();
    }
    return 0;
  }
  
  public void onBindViewHolder(MyViewHolder paramMyViewHolder, int paramInt)
  {
    final ProjectDetailForAppVo.HouseTypeInfoVo localHouseTypeInfoVo = (ProjectDetailForAppVo.HouseTypeInfoVo)this.a.get(paramInt);
    if (paramInt == 0)
    {
      paramMyViewHolder.viewLineTop.setVisibility(4);
      paramMyViewHolder.img.setTag(localHouseTypeInfoVo.pic);
      paramMyViewHolder.img.setController(c.frescoController(localHouseTypeInfoVo.pic));
      paramMyViewHolder.roomType.setText(localHouseTypeInfoVo.name);
      paramMyViewHolder.roomPrice.setText(localHouseTypeInfoVo.priceRange);
      if ((paramInt != 1) || (!this.d) || (this.c)) {
        break label176;
      }
      paramMyViewHolder.viewDividerBottom.setVisibility(0);
      paramMyViewHolder.viewDividerBottom.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          HouseTypeAdapter.a(HouseTypeAdapter.this, true);
          HouseTypeAdapter.this.notifyDataSetChanged();
        }
      });
    }
    for (;;)
    {
      paramMyViewHolder.a.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(HouseTypeAdapter.a(HouseTypeAdapter.this), HousingTypeInfoActivity.class);
          paramAnonymousView.putExtra("projectId", HouseTypeAdapter.b(HouseTypeAdapter.this));
          paramAnonymousView.putExtra("projectName", HouseTypeAdapter.c(HouseTypeAdapter.this));
          paramAnonymousView.putExtra("htId", localHouseTypeInfoVo.houseTypeId);
          HouseTypeAdapter.a(HouseTypeAdapter.this).startActivity(paramAnonymousView);
        }
      });
      if (localHouseTypeInfoVo.isRoomFull != 0) {
        break label188;
      }
      paramMyViewHolder.flTagHouseTypeStatus.setVisibility(8);
      paramMyViewHolder.tvRoomTypeFull.setVisibility(0);
      paramMyViewHolder.tvRoomTypeFull.setText(localHouseTypeInfoVo.roomFulTag);
      return;
      paramMyViewHolder.viewLineTop.setVisibility(0);
      break;
      label176:
      paramMyViewHolder.viewDividerBottom.setVisibility(8);
    }
    label188:
    paramMyViewHolder.flTagHouseTypeStatus.setVisibility(0);
    paramMyViewHolder.tvRoomTypeFull.setVisibility(8);
    a(localHouseTypeInfoVo.roomTags, paramMyViewHolder.flTagHouseTypeStatus);
  }
  
  public MyViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new MyViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130904619, paramViewGroup, false));
  }
  
  public void setHouseTypeInfoVos(ArrayList<ProjectDetailForAppVo.HouseTypeInfoVo> paramArrayList, String paramString1, String paramString2)
  {
    this.a = paramArrayList;
    this.e = paramString1;
    this.f = paramString2;
    notifyDataSetChanged();
  }
  
  static class MyViewHolder
    extends RecyclerView.u
  {
    public View a;
    @BindView(2131695022)
    FlowLayout flTagHouseTypeStatus;
    @BindView(2131689744)
    SimpleDraweeView img;
    @BindView(2131695012)
    TextView roomPrice;
    @BindView(2131694996)
    TextView roomType;
    @BindView(2131695023)
    TextView tvRoomTypeFull;
    @BindView(2131695018)
    LinearLayout viewDividerBottom;
    @BindView(2131695019)
    View viewLineTop;
    
    MyViewHolder(View paramView)
    {
      super();
      this.a = paramView;
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/meetaapartdetail/HouseTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */