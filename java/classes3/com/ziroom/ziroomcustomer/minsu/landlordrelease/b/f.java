package com.ziroom.ziroomcustomer.minsu.landlordrelease.b;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean.CoverPicListBean;
import java.util.List;

public class f
  extends RecyclerView.a<b>
{
  private Context a;
  private LandlordReleasePhotoBean.DataBean b;
  private a c;
  private String d;
  private int e = 0;
  
  public f(Context paramContext, LandlordReleasePhotoBean.DataBean paramDataBean, int paramInt, a parama)
  {
    this.a = paramContext;
    this.b = paramDataBean;
    this.c = parama;
    this.e = paramInt;
  }
  
  public f(Context paramContext, LandlordReleasePhotoBean.DataBean paramDataBean, a parama)
  {
    this.a = paramContext;
    this.b = paramDataBean;
    this.c = parama;
  }
  
  public int getItemCount()
  {
    if ((this.b == null) || (this.b.getCoverPicList() == null)) {
      return 0;
    }
    return this.b.getCoverPicList().size();
  }
  
  public void onBindViewHolder(b paramb, int paramInt)
  {
    paramb.e.setTag(this.b.getCoverPicList().get(paramInt));
    paramb.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = (LandlordReleasePhotoBean.DataBean.CoverPicListBean)paramAnonymousView.getTag();
        f.a(f.this).coverClick(paramAnonymousView.getRoomFid());
      }
    });
    if (this.e == 1) {
      paramb.d.setText("可在客厅、室外区域中选择横图为封面照片。");
    }
    paramb.b.setText(((LandlordReleasePhotoBean.DataBean.CoverPicListBean)this.b.getCoverPicList().get(paramInt)).getHouseOrRoomName());
    c.loadHolderImage(paramb.e, ((LandlordReleasePhotoBean.DataBean.CoverPicListBean)this.b.getCoverPicList().get(paramInt)).getMinPicUrl());
    if (TextUtils.isEmpty(this.d))
    {
      ((GenericDraweeHierarchy)paramb.e.getHierarchy()).setOverlayImage(new ColorDrawable(16777215));
      paramb.c.setText(null);
      return;
    }
    ((GenericDraweeHierarchy)paramb.e.getHierarchy()).setOverlayImage(new ColorDrawable(1291845632));
    paramb.c.setText(this.d);
  }
  
  public b onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.a).inflate(2130904331, paramViewGroup, false));
  }
  
  public void setDefaultPicAuditMsg(String paramString)
  {
    this.d = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void coverClick(String paramString);
  }
  
  class b
    extends RecyclerView.u
  {
    View a;
    TextView b;
    TextView c;
    TextView d;
    SimpleDraweeView e;
    
    public b(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131694290));
      this.d = ((TextView)paramView.findViewById(2131695292));
      this.e = ((SimpleDraweeView)paramView.findViewById(2131693871));
      this.c = ((TextView)paramView.findViewById(2131695291));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */