package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuLocalAlbumDetailActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuDelHousePicBean;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.b.f;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.b.f.a;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.b.g;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.b.g.a;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.b.h.a;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.base.BaseLandlordReleaseFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordFifthRoomBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordFifthRoomBean.LandlordFifthPicBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean.CoverPicListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean.PicTypeListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean.RoomPicListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseResultBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.minsu.view.widget.a.a.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.widget.ReMeasureRecyclerView;
import com.ziroom.ziroomcustomer.ziroomstation.StationWebActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LandlordReleaseFifthFragment
  extends BaseLandlordReleaseFragment
{
  Handler b = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if (LandlordReleaseFifthFragment.n(LandlordReleaseFifthFragment.this).size() == 0) {
        return;
      }
      paramAnonymousMessage = (File)LandlordReleaseFifthFragment.n(LandlordReleaseFifthFragment.this).get(0);
      com.ziroom.ziroomcustomer.minsu.e.a.uploadHousePic(LandlordReleaseFifthFragment.this.getActivity(), LandlordReleaseFifthFragment.o(LandlordReleaseFifthFragment.this), LandlordReleaseFifthFragment.p(LandlordReleaseFifthFragment.this), LandlordReleaseFifthFragment.q(LandlordReleaseFifthFragment.this) + "", paramAnonymousMessage.getAbsolutePath(), paramAnonymousMessage.getName(), new com.ziroom.ziroomcustomer.minsu.e.a.a()
      {
        public void onError(MinsuDelHousePicBean paramAnonymous2MinsuDelHousePicBean, String paramAnonymous2String)
        {
          if (ae.notNull(paramAnonymous2String))
          {
            Iterator localIterator = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().iterator();
            while (localIterator.hasNext())
            {
              com.ziroom.ziroomcustomer.minsu.view.widget.a.a locala = (com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localIterator.next();
              if ((locala.getPicType() != a.a.a.a) && (paramAnonymous2String.equals(ad.getRealFilePath2(LandlordReleaseFifthFragment.f(LandlordReleaseFifthFragment.this), Uri.parse(locala.getOriginalUri())))))
              {
                locala.setIsUpload(1);
                locala.setPicType(a.a.a.b);
                LandlordReleaseFifthFragment.n(LandlordReleaseFifthFragment.this).remove(new File(paramAnonymous2String));
                localIterator.remove();
              }
            }
            af.showToast(ApplicationEx.c, paramAnonymous2MinsuDelHousePicBean.message);
          }
          if (LandlordReleaseFifthFragment.n(LandlordReleaseFifthFragment.this).size() > 0) {
            LandlordReleaseFifthFragment.this.b.sendEmptyMessage(LandlordReleaseFifthFragment.r(LandlordReleaseFifthFragment.this));
          }
          while ((LandlordReleaseFifthFragment.this.getActivity() == null) || (LandlordReleaseFifthFragment.this.getActivity().isFinishing())) {
            return;
          }
          LandlordReleaseFifthFragment.this.getActivity().runOnUiThread(new Runnable()
          {
            public void run()
            {
              LandlordReleaseFifthFragment.d(LandlordReleaseFifthFragment.this).getPhotoList(LandlordReleaseFifthFragment.this, LandlordReleaseFifthFragment.this.getActivity(), LandlordReleaseFifthFragment.v(LandlordReleaseFifthFragment.this), LandlordReleaseFifthFragment.w(LandlordReleaseFifthFragment.this), LandlordReleaseFifthFragment.c(LandlordReleaseFifthFragment.this));
              LandlordReleaseFifthFragment.u(LandlordReleaseFifthFragment.this);
              LandlordReleaseFifthFragment.this.dismissProgress();
            }
          });
        }
        
        public void onSuccess(MinsuDelHousePicBean paramAnonymous2MinsuDelHousePicBean, String paramAnonymous2String)
        {
          LandlordReleaseFifthFragment.n(LandlordReleaseFifthFragment.this).remove(new File(paramAnonymous2String));
          if (LandlordReleaseFifthFragment.n(LandlordReleaseFifthFragment.this).size() > 0)
          {
            LandlordReleaseFifthFragment.this.b.sendEmptyMessage(LandlordReleaseFifthFragment.r(LandlordReleaseFifthFragment.this));
            return;
          }
          LandlordReleaseFifthFragment.this.getActivity().runOnUiThread(new Runnable()
          {
            public void run()
            {
              LandlordReleaseFifthFragment.d(LandlordReleaseFifthFragment.this).getPhotoList(LandlordReleaseFifthFragment.this, LandlordReleaseFifthFragment.this.getActivity(), LandlordReleaseFifthFragment.s(LandlordReleaseFifthFragment.this), LandlordReleaseFifthFragment.t(LandlordReleaseFifthFragment.this), LandlordReleaseFifthFragment.c(LandlordReleaseFifthFragment.this));
              LandlordReleaseFifthFragment.u(LandlordReleaseFifthFragment.this);
              LandlordReleaseFifthFragment.this.dismissProgress();
            }
          });
        }
      });
    }
  };
  @BindView(2131690078)
  View btn_back;
  @BindView(2131691234)
  View btn_landlord_rules;
  @BindView(2131691233)
  View btn_platform_rules;
  @BindView(2131694244)
  View btn_preview;
  @BindView(2131694243)
  View btn_release;
  private Context c;
  @BindView(2131694241)
  CheckBox cb_photo_rules;
  private Unbinder d;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c e;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b f;
  private LandlordReleasePhotoBean g;
  private g h;
  private f i;
  private List<LandlordFifthRoomBean> j;
  private String k;
  private String l;
  @BindView(2131694234)
  View ll_hz_cover_container;
  private String m;
  private List<String> n;
  private i o;
  @BindView(2131691557)
  ObservableScrollView osv_content;
  private List<String> p = new ArrayList();
  private int q;
  private List<File> r = new ArrayList();
  @BindView(2131694236)
  View rl_zz_cover_container;
  @BindView(2131689893)
  ReleaseUsageAndTipsView ruatv_tip;
  @BindView(2131694233)
  ReMeasureRecyclerView rv_picture;
  @BindView(2131694235)
  ReMeasureRecyclerView rv_select_cover_picture;
  private int s = 1;
  @BindView(2131694238)
  SimpleDraweeView sdv_zz_cover;
  @BindView(2131694232)
  TextView tv_picture_upload_info;
  @BindView(2131694240)
  TextView tv_room_ph_hint;
  @BindView(2131694239)
  TextView tv_zz_cover_review;
  @BindView(2131689863)
  View v_divider;
  
  private void a(final int paramInt1, int paramInt2)
  {
    this.q = paramInt2;
    com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().clear();
    if (this.r == null) {
      this.r = new ArrayList();
    }
    for (;;)
    {
      n();
      this.n = new ArrayList();
      this.n.add("拍照");
      this.n.add("相册选择");
      this.o = new i(getActivity(), new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          LandlordReleaseFifthFragment.j(LandlordReleaseFifthFragment.this).dismiss();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousAdapterView = new Intent("android.media.action.IMAGE_CAPTURE");
            if (paramAnonymousAdapterView.resolveActivity(LandlordReleaseFifthFragment.f(LandlordReleaseFifthFragment.this).getPackageManager()) != null)
            {
              paramAnonymousView = new ContentValues(2);
              com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().setCameraImgPath();
              paramAnonymousView.put("_data", com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCameraImgPath());
              paramAnonymousView.put("mime_type", "image/jpeg");
              paramAnonymousAdapterView.putExtra("output", LandlordReleaseFifthFragment.f(LandlordReleaseFifthFragment.this).getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, paramAnonymousView));
            }
            LandlordReleaseFifthFragment.this.startActivityForResult(paramAnonymousAdapterView, 2);
          }
          while (paramAnonymousInt != 1) {
            return;
          }
          paramAnonymousAdapterView = new Intent(LandlordReleaseFifthFragment.f(LandlordReleaseFifthFragment.this), MinsuLocalAlbumDetailActivity.class);
          paramAnonymousAdapterView.putExtra("local_folder_name", "所有图片");
          if (LandlordReleaseFifthFragment.k(LandlordReleaseFifthFragment.this) == null) {}
          for (paramAnonymousInt = 0;; paramAnonymousInt = paramInt1 - LandlordReleaseFifthFragment.k(LandlordReleaseFifthFragment.this).size())
          {
            paramAnonymousAdapterView.putExtra("picMaxNum", paramAnonymousInt);
            LandlordReleaseFifthFragment.this.startActivityForResult(paramAnonymousAdapterView, 1);
            return;
          }
        }
      }, this.n);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          i locali = LandlordReleaseFifthFragment.j(LandlordReleaseFifthFragment.this);
          View localView = LandlordReleaseFifthFragment.this.getActivity().getWindow().getDecorView();
          if (!(locali instanceof PopupWindow))
          {
            locali.showAtLocation(localView, 80, 0, 0);
            return;
          }
          VdsAgent.showAtLocation((PopupWindow)locali, localView, 80, 0, 0);
        }
      }, 250L);
      return;
      this.r.clear();
    }
  }
  
  private void d()
  {
    int i1;
    if (this.j == null)
    {
      this.j = new ArrayList();
      Collections.sort(this.g.getData().getRoomPicList());
      localIterator = this.g.getData().getRoomPicList().iterator();
      i1 = 1;
    }
    Object localObject1;
    LandlordFifthRoomBean localLandlordFifthRoomBean;
    Object localObject2;
    LandlordFifthRoomBean.LandlordFifthPicBean localLandlordFifthPicBean;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label357;
      }
      localObject1 = (LandlordReleasePhotoBean.DataBean.RoomPicListBean)localIterator.next();
      localLandlordFifthRoomBean = new LandlordFifthRoomBean();
      localLandlordFifthRoomBean.maxNum = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject1).getPicMaxNum();
      localLandlordFifthRoomBean.minNum = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject1).getPicMinNum();
      localLandlordFifthRoomBean.picType = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject1).getPicType();
      localLandlordFifthRoomBean.roomFid = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject1).getRoomFid();
      if (h() == 0) {
        if (((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject1).getPicType() == 0)
        {
          localLandlordFifthRoomBean.picTypeName = (((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject1).getPicTypeName() + i1);
          i1 += 1;
        }
      }
      for (;;)
      {
        localLandlordFifthRoomBean.picList = new ArrayList();
        localObject1 = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject1).getPicList().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)((Iterator)localObject1).next();
          localLandlordFifthPicBean = new LandlordFifthRoomBean.LandlordFifthPicBean();
          localLandlordFifthPicBean.isDefault = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject2).getIsDefault();
          localLandlordFifthPicBean.maxUrl = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject2).getMaxPicUrl();
          localLandlordFifthPicBean.minUrl = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject2).getMinPicUrl();
          localLandlordFifthPicBean.picFid = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject2).getFid();
          localLandlordFifthPicBean.houseBaseFid = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject2).getHouseBaseFid();
          localLandlordFifthPicBean.roomFid = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject2).getRoomFid();
          localLandlordFifthPicBean.picType = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject2).getPicType();
          localLandlordFifthPicBean.picAuditMsg = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean.PicListBeanX)localObject2).getPicAuditMsg();
          localLandlordFifthRoomBean.picList.add(localLandlordFifthPicBean);
        }
        this.j.clear();
        break;
        localLandlordFifthRoomBean.picTypeName = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject1).getPicTypeName();
        continue;
        localLandlordFifthRoomBean.picTypeName = ((LandlordReleasePhotoBean.DataBean.RoomPicListBean)localObject1).getRoomName();
      }
      this.j.add(localLandlordFifthRoomBean);
    }
    label357:
    Iterator localIterator = this.g.getData().getPicTypeList().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (LandlordReleasePhotoBean.DataBean.PicTypeListBean)localIterator.next();
      localLandlordFifthRoomBean = new LandlordFifthRoomBean();
      localLandlordFifthRoomBean.maxNum = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean)localObject1).getPicMaxNum();
      localLandlordFifthRoomBean.minNum = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean)localObject1).getPicMinNum();
      localLandlordFifthRoomBean.picType = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean)localObject1).getPicType();
      localLandlordFifthRoomBean.picTypeName = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean)localObject1).getPicTypeName();
      localLandlordFifthRoomBean.picList = new ArrayList();
      localObject1 = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean)localObject1).getPicList().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)((Iterator)localObject1).next();
        localLandlordFifthPicBean = new LandlordFifthRoomBean.LandlordFifthPicBean();
        localLandlordFifthPicBean.isDefault = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject2).getIsDefault();
        localLandlordFifthPicBean.maxUrl = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject2).getMaxPicUrl();
        localLandlordFifthPicBean.minUrl = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject2).getMinPicUrl();
        localLandlordFifthPicBean.picFid = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject2).getFid();
        localLandlordFifthPicBean.houseBaseFid = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject2).getHouseBaseFid();
        localLandlordFifthPicBean.roomFid = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject2).getRoomFid();
        localLandlordFifthPicBean.picType = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject2).getPicType();
        localLandlordFifthPicBean.picAuditMsg = ((LandlordReleasePhotoBean.DataBean.PicTypeListBean.PicListBean)localObject2).getPicAuditMsg();
        localLandlordFifthRoomBean.picList.add(localLandlordFifthPicBean);
      }
      this.j.add(localLandlordFifthRoomBean);
    }
  }
  
  private void e()
  {
    this.e = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c(this);
    this.a.register(this.e);
    this.f = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void m()
  {
    try
    {
      ((BaseActivity)getActivity()).showProgressNoCancel("请稍后...", 100000L);
      Iterator localIterator = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localIterator.next();
        localObject2 = new File(ad.getRealFilePath2(this.c, Uri.parse(((com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localObject2).getOriginalUri())));
        if (((File)localObject2).exists()) {
          this.r.add(localObject2);
        }
      }
      if (this.r == null) {
        break label129;
      }
    }
    finally {}
    if (this.r.size() > 0) {
      this.b.sendEmptyMessage(0);
    }
    for (;;)
    {
      return;
      label129:
      n();
      dismissProgress();
    }
  }
  
  private void n()
  {
    this.p.clear();
    Iterator localIterator = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().iterator();
    while (localIterator.hasNext())
    {
      com.ziroom.ziroomcustomer.minsu.view.widget.a.a locala = (com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localIterator.next();
      locala.getHousePicType();
      this.p.add(locala.getPicUrl());
    }
  }
  
  public static LandlordReleaseFifthFragment newInstance()
  {
    Bundle localBundle = new Bundle();
    LandlordReleaseFifthFragment localLandlordReleaseFifthFragment = new LandlordReleaseFifthFragment();
    localLandlordReleaseFifthFragment.setArguments(localBundle);
    return localLandlordReleaseFifthFragment;
  }
  
  @OnClick({2131690078, 2131694244, 2131694243, 2131694236, 2131691234, 2131691233, 2131694242})
  public void OnClick(View paramView)
  {
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
    case 2131690078: 
    case 2131694243: 
    case 2131694244: 
    case 2131694236: 
      do
      {
        do
        {
          do
          {
            return;
            g();
            return;
            if (!this.cb_photo_rules.isChecked())
            {
              af.showToast(this.c, "请阅读并同意服务协议");
              return;
            }
          } while (!l());
          this.f.releaseFirstHouse(this, getActivity(), k(), "", h());
          return;
          if (h() == 0)
          {
            k.toHouseDetail(this.c, k(), h() + "", false);
            return;
          }
          if (i() != 1) {
            break;
          }
        } while ((this.g == null) || (this.g.getData() == null));
        k.toHouseDetail(this.c, this.g.getData().getHouseRoomFid() + "", "1", false);
        return;
        paramView = new Intent(this.c, LandlordReleasePreviewSelectActivity.class);
        paramView.putExtra("data", this.g);
        startActivity(paramView);
        return;
      } while (!l());
      paramView = new Intent(this.c, LandlordReleaseSelectCoverPictureActivity.class);
      paramView.putExtra("data", this.g.getData());
      paramView.putExtra("rentWay", h());
      startActivityForResult(paramView, 1281);
      return;
    case 2131691234: 
      paramView = new Intent(getActivity(), StationWebActivity.class);
      paramView.putExtra("url", com.ziroom.ziroomcustomer.minsu.landlordrelease.c.a.c);
      paramView.putExtra("title", "服务协议");
      startActivity(paramView);
      return;
    case 2131691233: 
      paramView = new Intent(getActivity(), StationWebActivity.class);
      paramView.putExtra("url", com.ziroom.ziroomcustomer.minsu.landlordrelease.c.a.a);
      paramView.putExtra("title", "服务协议");
      startActivity(paramView);
      return;
    }
    paramView = new Intent(getActivity(), StationWebActivity.class);
    paramView.putExtra("url", com.ziroom.ziroomcustomer.minsu.landlordrelease.c.a.b);
    paramView.putExtra("title", "房东经营行为管理规范");
    startActivity(paramView);
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i1 = -1;
    switch (parama.hashCode())
    {
    default: 
      switch (i1)
      {
      }
      break;
    }
    label474:
    do
    {
      do
      {
        do
        {
          return;
          if (!parama.equals("get_photo_list")) {
            break;
          }
          i1 = 0;
          break;
          if (!parama.equals("get_photo_list_error")) {
            break;
          }
          i1 = 1;
          break;
          if (!parama.equals("release_house")) {
            break;
          }
          i1 = 2;
          break;
          if (!parama.equals("release_house_error")) {
            break;
          }
          i1 = 3;
          break;
          if (!parama.equals("delete_picture")) {
            break;
          }
          i1 = 4;
          break;
          if (!parama.equals("delete_picture_error")) {
            break;
          }
          i1 = 5;
          break;
          if (!parama.equals("select_cover_picture")) {
            break;
          }
          i1 = 6;
          break;
          if (!parama.equals("select_cover_picture_error")) {
            break;
          }
          i1 = 7;
          break;
          this.g = this.e.getLandlordReleasePhotoList();
        } while ((this.g == null) || (this.g.getData() == null));
        d();
        this.tv_picture_upload_info.setText(this.g.getData().getRemindMsg());
        this.h.setData(this.j);
        if (h() != 0) {
          break label474;
        }
        this.ll_hz_cover_container.setVisibility(8);
        this.rl_zz_cover_container.setVisibility(0);
      } while (this.g.getData().getCoverPicList().size() <= 0);
      this.sdv_zz_cover.setController(com.freelxl.baselibrary.f.c.frescoController(((LandlordReleasePhotoBean.DataBean.CoverPicListBean)this.g.getData().getCoverPicList().get(0)).getMinPicUrl()));
      if (!TextUtils.isEmpty(this.g.getData().getDefaultPicAuditMsg()))
      {
        this.tv_zz_cover_review.setText(this.g.getData().getDefaultPicAuditMsg());
        ((GenericDraweeHierarchy)this.sdv_zz_cover.getHierarchy()).setOverlayImage(new ColorDrawable(1291845632));
        return;
      }
      this.tv_zz_cover_review.setText(null);
      ((GenericDraweeHierarchy)this.sdv_zz_cover.getHierarchy()).setOverlayImage(new ColorDrawable(16777215));
      return;
    } while (h() != 1);
    this.ll_hz_cover_container.setVisibility(0);
    this.rl_zz_cover_container.setVisibility(8);
    this.i = new f(this.c, this.g.getData(), i(), new f.a()
    {
      public void coverClick(String paramAnonymousString)
      {
        if (LandlordReleaseFifthFragment.g(LandlordReleaseFifthFragment.this))
        {
          Intent localIntent = new Intent(LandlordReleaseFifthFragment.f(LandlordReleaseFifthFragment.this), LandlordReleaseSelectCoverPictureActivity.class);
          localIntent.putExtra("data", LandlordReleaseFifthFragment.h(LandlordReleaseFifthFragment.this).getData());
          localIntent.putExtra("rentWay", LandlordReleaseFifthFragment.i(LandlordReleaseFifthFragment.this));
          localIntent.putExtra("roomFid", paramAnonymousString);
          LandlordReleaseFifthFragment.this.startActivityForResult(localIntent, 1281);
        }
      }
    });
    this.i.setDefaultPicAuditMsg(this.g.getData().getDefaultPicAuditMsg());
    this.rv_select_cover_picture.setAdapter(this.i);
    return;
    this.ll_hz_cover_container.setVisibility(8);
    this.rl_zz_cover_container.setVisibility(8);
    return;
    Object localObject = this.e.getReleaseResult();
    if (((LandlordReleaseResultBean)localObject).checkSuccess(getActivity()))
    {
      parama = new Intent(this.c, LandlordReleaseSuccessActivity.class);
      if (((LandlordReleaseResultBean)localObject).getData() != null)
      {
        parama.putExtra("successInfo", ((LandlordReleaseResultBean)localObject).getData().getRemindMsg());
        ArrayList localArrayList = new ArrayList();
        localObject = ((LandlordReleaseResultBean)localObject).getData().getNameList().iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add((String)((Iterator)localObject).next());
        }
        parama.putExtra("houseName", localArrayList);
      }
      startActivity(parama);
      f();
      return;
    }
    af.showToast(this.c, ((LandlordReleaseResultBean)localObject).message);
    return;
    af.showToast(this.c, this.e.getReleaseHouseErrorMsg());
    return;
    parama = this.e.getDeletePictureResult();
    if (parama.checkSuccess(getActivity()))
    {
      this.f.getPhotoList(this, getActivity(), k(), h(), this.k);
      return;
    }
    af.showToast(this.c, parama.message);
    return;
    parama = this.e.getSetCoverPictureResult();
    if (parama.checkSuccess(getActivity()))
    {
      this.f.getPhotoList(this, getActivity(), k(), h(), this.k);
      return;
    }
    af.showToast(this.c, parama.message);
  }
  
  protected View c()
  {
    if (h() == 1) {
      this.k = j();
    }
    this.c = getActivity();
    View localView = LayoutInflater.from(this.c).inflate(2130903949, null, false);
    this.d = ButterKnife.bind(this, localView);
    this.rv_picture.setLayoutManager(new LinearLayoutManager(this.c, 1, false));
    this.rv_select_cover_picture.setLayoutManager(new LinearLayoutManager(this.c, 1, false));
    this.h = new g(this.c, null, new h.a()new g.a
    {
      public void delete(final String paramAnonymousString1, final String paramAnonymousString2, final int paramAnonymousInt, final String paramAnonymousString3)
      {
        d.a locala = d.newBuilder(LandlordReleaseFifthFragment.f(LandlordReleaseFifthFragment.this)).setButtonText("取消", "确定");
        String str;
        if (LandlordReleaseFifthFragment.e(LandlordReleaseFifthFragment.this) == 0) {
          str = "删除照片后无法恢复，请确认是否继续删除？";
        }
        for (;;)
        {
          locala.setContent(str).setOnConfirmClickListener(new d.b()
          {
            public void onLeftClick(View paramAnonymous2View) {}
            
            public void onRightClick(View paramAnonymous2View)
            {
              if (LandlordReleaseFifthFragment.a(LandlordReleaseFifthFragment.this))
              {
                if ("manager".equals(LandlordReleaseFifthFragment.b(LandlordReleaseFifthFragment.this))) {
                  LandlordReleaseFifthFragment.d(LandlordReleaseFifthFragment.this).deletePicture(LandlordReleaseFifthFragment.this, LandlordReleaseFifthFragment.this.getActivity(), paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, LandlordReleaseFifthFragment.c(LandlordReleaseFifthFragment.this));
                }
              }
              else {
                return;
              }
              LandlordReleaseFifthFragment.d(LandlordReleaseFifthFragment.this).deletePicture(LandlordReleaseFifthFragment.this, LandlordReleaseFifthFragment.this.getActivity(), paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousString3);
            }
          }).show();
          return;
          if (paramAnonymousInt == 0) {
            str = "删除照片后无法恢复，请确认是否继续删除？";
          } else {
            str = "您的操作将同时删除此房源下其他房间的同张照片，请确认是否继续删除？";
          }
        }
      }
    }, new g.a()
    {
      public void add(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        LandlordReleaseFifthFragment.a(LandlordReleaseFifthFragment.this, paramAnonymousString);
        LandlordReleaseFifthFragment.a(LandlordReleaseFifthFragment.this, paramAnonymousInt2, paramAnonymousInt1);
      }
    });
    this.rv_picture.setAdapter(this.h);
    com.ziroom.ziroomcustomer.minsu.view.widget.a.init(this.c);
    this.f.getPhotoList(this, getActivity(), k(), h(), this.k);
    this.m = getActivity().getIntent().getStringExtra("from");
    if ("manager".equals(this.m))
    {
      this.btn_preview.setVisibility(8);
      this.btn_release.setVisibility(8);
      ((TextView)localView.findViewById(2131694231)).setText("房源照片");
      this.cb_photo_rules.setChecked(true);
      this.cb_photo_rules.setClickable(false);
    }
    if (i() == 1) {
      this.tv_room_ph_hint.setText("可在客厅、室外区域中选择横图为封面照片。");
    }
    this.osv_content.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LandlordReleaseFifthFragment.this.v_divider.setAlpha(f);
      }
    });
    return localView;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    Fresco.getImagePipeline().clearMemoryCaches();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (!com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().isResultOk());
        com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().setResultOk(false);
        this.f.getPhotoList(this, getActivity(), k(), h(), this.k);
        m();
        return;
        paramIntent = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCameraImgPath();
        if (TextUtils.isEmpty(paramIntent))
        {
          af.showToast(this.c, "图片获取失败");
          return;
        }
        localObject = new File(paramIntent);
        if (((File)localObject).exists())
        {
          localObject = Uri.fromFile((File)localObject);
          com.ziroom.ziroomcustomer.minsu.view.widget.a.a locala = new com.ziroom.ziroomcustomer.minsu.view.widget.a.a();
          locala.setThumbnailUri(((Uri)localObject).toString());
          locala.setOriginalUri(((Uri)localObject).toString());
          locala.setOrientation(ad.getBitmapDegree(paramIntent));
          com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().add(locala);
          com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().setResultOk(true);
          m();
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              LandlordReleaseFifthFragment.d(LandlordReleaseFifthFragment.this).getPhotoList(LandlordReleaseFifthFragment.this, LandlordReleaseFifthFragment.this.getActivity(), LandlordReleaseFifthFragment.l(LandlordReleaseFifthFragment.this), LandlordReleaseFifthFragment.m(LandlordReleaseFifthFragment.this), LandlordReleaseFifthFragment.c(LandlordReleaseFifthFragment.this));
            }
          }, 1000L);
          return;
        }
        af.showToast(this.c, "图片获取失败");
        return;
      } while (-1 != paramInt2);
      localObject = paramIntent.getStringExtra("picFid");
      paramInt1 = paramIntent.getIntExtra("picType", -1);
      paramIntent = paramIntent.getStringExtra("roomFid");
    } while ((paramInt1 < 0) || (TextUtils.isEmpty((CharSequence)localObject)));
    this.f.setCoverPicture(this, getActivity(), k(), (String)localObject, paramInt1, 1, paramIntent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    e();
    return c();
  }
  
  public void onDestroy()
  {
    this.d.unbind();
    Fresco.getImagePipeline().clearMemoryCaches();
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.e);
    super.onDestroyView();
  }
  
  public void onLoginBack(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onStart()
  {
    super.onStart();
    this.ruatv_tip.setCode("TIP_HOW_UPLOAD_HOUSE_PIC");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseFifthFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */