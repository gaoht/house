package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseCoverSelectShowBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean.PicTypeListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean.RoomPicListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LandlordReleaseSelectCoverPictureActivity
  extends BaseFluxActivity
{
  private Context b;
  @BindView(2131691043)
  BasicZiroomToolBar bztb_title;
  private List<LandlordReleaseCoverSelectShowBean> c;
  private int d;
  private String e;
  private a f;
  @BindView(2131691075)
  RecyclerView rv_pic;
  
  private void a() {}
  
  private void b()
  {
    Object localObject1 = (LandlordReleasePhotoBean.DataBean)getIntent().getSerializableExtra("data");
    this.d = getIntent().getIntExtra("rentWay", 0);
    if (this.d == 1) {
      this.e = getIntent().getStringExtra("roomFid");
    }
    this.rv_pic.setLayoutManager(new GridLayoutManager(this.b, 3, 1, false));
    this.c = new ArrayList();
    Object localObject2;
    Object localObject3;
    label155:
    Object localObject4;
    LandlordReleaseCoverSelectShowBean localLandlordReleaseCoverSelectShowBean;
    boolean bool;
    if (this.d == 0)
    {
      localObject2 = ((LandlordReleasePhotoBean.DataBean)localObject1).getRoomPicList().iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (LandlordReleasePhotoBean.DataBean.RoomPicListBean)((Iterator)localObject2).next();
      } while ((((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject3).getPicType() != 0) && (((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject3).getPicType() != 1) && (((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject3).getPicType() != 4));
      localObject3 = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject3).getPicList().iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)((Iterator)localObject3).next();
        localLandlordReleaseCoverSelectShowBean = new LandlordReleaseCoverSelectShowBean();
        if (((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getWidthPixel() <= ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getHeightPixel()) {
          break label272;
        }
      }
      label272:
      for (bool = true;; bool = false)
      {
        localLandlordReleaseCoverSelectShowBean.isAcross = bool;
        localLandlordReleaseCoverSelectShowBean.maxUrl = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getMaxPicUrl();
        localLandlordReleaseCoverSelectShowBean.minUrl = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getMinPicUrl();
        localLandlordReleaseCoverSelectShowBean.picFid = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getFid();
        localLandlordReleaseCoverSelectShowBean.roomFid = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getRoomFid();
        localLandlordReleaseCoverSelectShowBean.picType = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getPicType();
        this.c.add(localLandlordReleaseCoverSelectShowBean);
        break label155;
        break;
      }
    }
    if (this.d == 1)
    {
      localObject2 = ((LandlordReleasePhotoBean.DataBean)localObject1).getRoomPicList().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (LandlordReleasePhotoBean.DataBean.RoomPicListBean)((Iterator)localObject2).next();
        if ((((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject3).getPicType() == 1) || (((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject3).getPicType() == 4) || (((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject3).getRoomFid().equals(this.e)))
        {
          localObject3 = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject3).getPicList().iterator();
          label360:
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)((Iterator)localObject3).next();
            localLandlordReleaseCoverSelectShowBean = new LandlordReleaseCoverSelectShowBean();
            if (((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getWidthPixel() <= ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getHeightPixel()) {
              break label477;
            }
          }
          label477:
          for (bool = true;; bool = false)
          {
            localLandlordReleaseCoverSelectShowBean.isAcross = bool;
            localLandlordReleaseCoverSelectShowBean.maxUrl = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getMaxPicUrl();
            localLandlordReleaseCoverSelectShowBean.minUrl = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getMinPicUrl();
            localLandlordReleaseCoverSelectShowBean.picFid = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getFid();
            localLandlordReleaseCoverSelectShowBean.roomFid = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getRoomFid();
            localLandlordReleaseCoverSelectShowBean.picType = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject4).getPicType();
            this.c.add(localLandlordReleaseCoverSelectShowBean);
            break label360;
            break;
          }
        }
      }
    }
    localObject1 = ((LandlordReleasePhotoBean.DataBean)localObject1).getPicTypeList().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LandlordReleasePhotoBean.DataBean.PicTypeListBean)((Iterator)localObject1).next();
      if ((((LandlordReleasePhotoBean.DataBean.PicTypeListBean)localObject2).getPicType() == 0) || (((LandlordReleasePhotoBean.DataBean.PicTypeListBean)localObject2).getPicType() == 1) || (((LandlordReleasePhotoBean.DataBean.PicTypeListBean)localObject2).getPicType() == 4) || ((this.d == 1) && (((LandlordReleasePhotoBean.DataBean.PicTypeListBean)localObject2).getRoomFid() != null) && (((LandlordReleasePhotoBean.DataBean.PicTypeListBean)localObject2).getRoomFid().equals(this.e))))
      {
        localObject2 = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean)localObject2).getPicList().iterator();
        label573:
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)((Iterator)localObject2).next();
          localObject4 = new LandlordReleaseCoverSelectShowBean();
          if (((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject3).getWidthPixel() <= ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject3).getHeightPixel()) {
            break label688;
          }
        }
        label688:
        for (bool = true;; bool = false)
        {
          ((LandlordReleaseCoverSelectShowBean)localObject4).isAcross = bool;
          ((LandlordReleaseCoverSelectShowBean)localObject4).maxUrl = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject3).getMaxPicUrl();
          ((LandlordReleaseCoverSelectShowBean)localObject4).minUrl = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject3).getMinPicUrl();
          ((LandlordReleaseCoverSelectShowBean)localObject4).picFid = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject3).getFid();
          ((LandlordReleaseCoverSelectShowBean)localObject4).roomFid = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject3).getRoomFid();
          ((LandlordReleaseCoverSelectShowBean)localObject4).picType = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject3).getPicType();
          this.c.add(localObject4);
          break label573;
          break;
        }
      }
    }
    this.f = new a(null);
    this.rv_pic.setAdapter(this.f);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903243);
    this.b = this;
    ButterKnife.bind(this);
    this.bztb_title.setTitle("设置封面");
    b();
    a();
  }
  
  protected void onDestroy()
  {
    com.freelxl.baselibrary.d.a.cancel(this);
    super.onDestroy();
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama.getType().getClass();
  }
  
  private class a
    extends RecyclerView.a<a>
  {
    private a() {}
    
    public int getItemCount()
    {
      if (LandlordReleaseSelectCoverPictureActivity.b(LandlordReleaseSelectCoverPictureActivity.this) == null) {
        return 0;
      }
      return LandlordReleaseSelectCoverPictureActivity.b(LandlordReleaseSelectCoverPictureActivity.this).size();
    }
    
    public void onBindViewHolder(a parama, int paramInt)
    {
      a.a(parama).setTag(Integer.valueOf(paramInt));
      a.a(parama).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = LandlordReleaseSelectCoverPictureActivity.this.getIntent();
          if (((LandlordReleaseCoverSelectShowBean)LandlordReleaseSelectCoverPictureActivity.b(LandlordReleaseSelectCoverPictureActivity.this).get(i)).isAcross)
          {
            if (LandlordReleaseSelectCoverPictureActivity.c(LandlordReleaseSelectCoverPictureActivity.this) == 0) {
              paramAnonymousView.putExtra("roomFid", ((LandlordReleaseCoverSelectShowBean)LandlordReleaseSelectCoverPictureActivity.b(LandlordReleaseSelectCoverPictureActivity.this).get(i)).roomFid);
            }
            for (;;)
            {
              paramAnonymousView.putExtra("picType", ((LandlordReleaseCoverSelectShowBean)LandlordReleaseSelectCoverPictureActivity.b(LandlordReleaseSelectCoverPictureActivity.this).get(i)).picType);
              paramAnonymousView.putExtra("picFid", ((LandlordReleaseCoverSelectShowBean)LandlordReleaseSelectCoverPictureActivity.b(LandlordReleaseSelectCoverPictureActivity.this).get(i)).picFid);
              LandlordReleaseSelectCoverPictureActivity.this.setResult(-1, paramAnonymousView);
              LandlordReleaseSelectCoverPictureActivity.this.finish();
              return;
              if (LandlordReleaseSelectCoverPictureActivity.c(LandlordReleaseSelectCoverPictureActivity.this) == 1) {
                paramAnonymousView.putExtra("roomFid", LandlordReleaseSelectCoverPictureActivity.d(LandlordReleaseSelectCoverPictureActivity.this));
              }
            }
          }
          af.showToast(LandlordReleaseSelectCoverPictureActivity.a(LandlordReleaseSelectCoverPictureActivity.this), "请选择横图做封面照");
        }
      });
      c.loadHolderImage(a.b(parama), ((LandlordReleaseCoverSelectShowBean)LandlordReleaseSelectCoverPictureActivity.b(LandlordReleaseSelectCoverPictureActivity.this).get(paramInt)).minUrl);
    }
    
    public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(LayoutInflater.from(LandlordReleaseSelectCoverPictureActivity.a(LandlordReleaseSelectCoverPictureActivity.this)).inflate(2130904329, paramViewGroup, false));
    }
    
    class a
      extends RecyclerView.u
    {
      private View b;
      private SimpleDraweeView c;
      
      public a(View paramView)
      {
        super();
        this.b = paramView;
        this.c = ((SimpleDraweeView)paramView.findViewById(2131693871));
        paramView = (LinearLayout.LayoutParams)this.c.getLayoutParams();
        WindowManager localWindowManager = LandlordReleaseSelectCoverPictureActivity.this.getWindowManager();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        int i = (localDisplayMetrics.widthPixels - n.dip2px(LandlordReleaseSelectCoverPictureActivity.a(LandlordReleaseSelectCoverPictureActivity.this), 68.0F)) / 3;
        paramView.width = i;
        paramView.height = i;
        this.c.setLayoutParams(paramView);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseSelectCoverPictureActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */