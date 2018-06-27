package com.ziroom.ziroomcustomer.minsu.landlordrelease.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordFifthRoomBean.LandlordFifthPicBean;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuPhotoPreviewActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h
  extends BaseAdapter
{
  private Context a;
  private List<LandlordFifthRoomBean.LandlordFifthPicBean> b;
  private a c;
  private ArrayList<String> d;
  
  public h(Context paramContext, List<LandlordFifthRoomBean.LandlordFifthPicBean> paramList, a parama)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = parama;
    this.d = new ArrayList();
    if (this.b != null)
    {
      paramContext = this.b.iterator();
      while (paramContext.hasNext())
      {
        paramList = (LandlordFifthRoomBean.LandlordFifthPicBean)paramContext.next();
        this.d.add(paramList.maxUrl);
      }
    }
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
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a).inflate(2130904327, paramViewGroup, false);
      paramView = new b(null);
      paramView.a = ((SimpleDraweeView)localView.findViewById(2131693871));
      paramView.b = localView.findViewById(2131695286);
      paramView.c = ((TextView)localView.findViewById(2131695285));
      localView.setTag(paramView);
    }
    paramView = (b)localView.getTag();
    c.loadHolderImage(paramView.a, ((LandlordFifthRoomBean.LandlordFifthPicBean)this.b.get(paramInt)).minUrl);
    paramView.b.setTag(this.b.get(paramInt));
    paramView.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = (LandlordFifthRoomBean.LandlordFifthPicBean)paramAnonymousView.getTag();
        if (paramAnonymousView != null)
        {
          if (paramAnonymousView.isDefault == 1) {
            af.showToast(h.a(h.this), "封面照片不允许删除");
          }
        }
        else {
          return;
        }
        h.b(h.this).delete(paramAnonymousView.houseBaseFid, paramAnonymousView.picFid, paramAnonymousView.picType, paramAnonymousView.roomFid);
      }
    });
    paramView.a.setTag(Integer.valueOf(paramInt));
    if (!TextUtils.isEmpty(((LandlordFifthRoomBean.LandlordFifthPicBean)this.b.get(paramInt)).picAuditMsg))
    {
      paramView.c.setText(((LandlordFifthRoomBean.LandlordFifthPicBean)this.b.get(paramInt)).picAuditMsg);
      ((GenericDraweeHierarchy)paramView.a.getHierarchy()).setOverlayImage(new ColorDrawable(1291845632));
    }
    for (;;)
    {
      paramView.a.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = new Intent(h.a(h.this), ZryuPhotoPreviewActivity.class);
          paramAnonymousView.putStringArrayListExtra("urlList", h.c(h.this));
          paramAnonymousView.putExtra("position", i);
          paramAnonymousView.putExtra("isDeleteable", false);
          h.a(h.this).startActivity(paramAnonymousView);
        }
      });
      return localView;
      paramView.c.setText(null);
      ((GenericDraweeHierarchy)paramView.a.getHierarchy()).setOverlayImage(new ColorDrawable(16777215));
    }
  }
  
  public static abstract interface a
  {
    public abstract void delete(String paramString1, String paramString2, int paramInt, String paramString3);
  }
  
  private class b
  {
    SimpleDraweeView a;
    View b;
    TextView c;
    
    private b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */