package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuDelHousePicBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuDelHousePicBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHousePicBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHousePicListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHousePicListBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.n;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.DragPicturesView;
import com.ziroom.ziroomcustomer.minsu.view.DragPicturesView.a;
import com.ziroom.ziroomcustomer.minsu.view.widget.DragPictureImageView;
import com.ziroom.ziroomcustomer.minsu.view.widget.a.a.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MinsuAddPicturesActivity
  extends BaseActivity
{
  private List<String> A = new ArrayList();
  DragPicturesView a;
  Handler b = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if (MinsuAddPicturesActivity.n(MinsuAddPicturesActivity.this).size() == 0) {
        return;
      }
      paramAnonymousMessage = (File)MinsuAddPicturesActivity.n(MinsuAddPicturesActivity.this).get(0);
      com.ziroom.ziroomcustomer.minsu.e.a.uploadHousePic(MinsuAddPicturesActivity.this, MinsuAddPicturesActivity.o(MinsuAddPicturesActivity.this), MinsuAddPicturesActivity.p(MinsuAddPicturesActivity.this), MinsuAddPicturesActivity.q(MinsuAddPicturesActivity.this), paramAnonymousMessage.getAbsolutePath(), paramAnonymousMessage.getName(), new com.ziroom.ziroomcustomer.minsu.e.a.a()
      {
        public void onError(final MinsuDelHousePicBean paramAnonymous2MinsuDelHousePicBean, String paramAnonymous2String)
        {
          if (ae.notNull(paramAnonymous2String))
          {
            Iterator localIterator = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().iterator();
            while (localIterator.hasNext())
            {
              com.ziroom.ziroomcustomer.minsu.view.widget.a.a locala = (com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localIterator.next();
              if ((locala.getPicType() != a.a.a.a) && (paramAnonymous2String.equals(ad.getRealFilePath2(MinsuAddPicturesActivity.this, Uri.parse(locala.getOriginalUri())))))
              {
                locala.setIsUpload(1);
                locala.setPicType(a.a.a.b);
                MinsuAddPicturesActivity.n(MinsuAddPicturesActivity.this).remove(new File(paramAnonymous2String));
                localIterator.remove();
              }
            }
            MinsuAddPicturesActivity.this.runOnUiThread(new Runnable()
            {
              public void run()
              {
                af.showToast(ApplicationEx.c, paramAnonymous2MinsuDelHousePicBean.message, 1);
              }
            });
          }
          if (MinsuAddPicturesActivity.n(MinsuAddPicturesActivity.this).size() > 0)
          {
            MinsuAddPicturesActivity.this.b.sendEmptyMessage(MinsuAddPicturesActivity.r(MinsuAddPicturesActivity.this));
            return;
          }
          MinsuAddPicturesActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              MinsuAddPicturesActivity.k(MinsuAddPicturesActivity.this);
              MinsuAddPicturesActivity.a(MinsuAddPicturesActivity.this, "upload onerr 709");
              MinsuAddPicturesActivity.this.dismissProgress();
            }
          });
        }
        
        public void onSuccess(MinsuDelHousePicBean paramAnonymous2MinsuDelHousePicBean, String paramAnonymous2String)
        {
          if (ae.notNull(paramAnonymous2String))
          {
            if (MinsuAddPicturesActivity.m(MinsuAddPicturesActivity.this) == null) {
              MinsuAddPicturesActivity.a(MinsuAddPicturesActivity.this, new HashMap());
            }
            MinsuAddPicturesActivity.m(MinsuAddPicturesActivity.this).put(((MinsuDelHousePicBean.DataBean)paramAnonymous2MinsuDelHousePicBean.data.get(0)).fid, ((MinsuDelHousePicBean.DataBean)paramAnonymous2MinsuDelHousePicBean.data.get(0)).fid);
            Iterator localIterator = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().iterator();
            while (localIterator.hasNext())
            {
              com.ziroom.ziroomcustomer.minsu.view.widget.a.a locala = (com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localIterator.next();
              if ((locala.getPicType() != a.a.a.a) && (paramAnonymous2String.equals(ad.getRealFilePath2(MinsuAddPicturesActivity.this, Uri.parse(locala.getOriginalUri())))))
              {
                locala.setIsUpload(1);
                locala.setPicType(a.a.a.a);
                locala.setHousePicType(((MinsuDelHousePicBean.DataBean)paramAnonymous2MinsuDelHousePicBean.data.get(0)).picType + "");
                locala.setFid(((MinsuDelHousePicBean.DataBean)paramAnonymous2MinsuDelHousePicBean.data.get(0)).fid);
                locala.setPicUrl(((MinsuDelHousePicBean.DataBean)paramAnonymous2MinsuDelHousePicBean.data.get(0)).picUrl);
                MinsuAddPicturesActivity.n(MinsuAddPicturesActivity.this).remove(new File(paramAnonymous2String));
              }
            }
          }
          if (MinsuAddPicturesActivity.n(MinsuAddPicturesActivity.this).size() > 0)
          {
            MinsuAddPicturesActivity.this.b.sendEmptyMessage(MinsuAddPicturesActivity.r(MinsuAddPicturesActivity.this));
            return;
          }
          MinsuAddPicturesActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              MinsuAddPicturesActivity.s(MinsuAddPicturesActivity.this);
              MinsuAddPicturesActivity.a(MinsuAddPicturesActivity.this, "upload succ 666");
              MinsuAddPicturesActivity.this.dismissProgress();
            }
          });
        }
      });
    }
  };
  private CommonTitle c;
  private TextView d;
  private Boolean e = Boolean.valueOf(true);
  private i f;
  private List<String> g;
  private int r;
  private String s;
  private List<File> t = new ArrayList();
  private int u = 1;
  private String v;
  private String w;
  private int x;
  private HashMap<String, String> y;
  private int z;
  
  private void a()
  {
    this.c = ((CommonTitle)findViewById(2131691272));
    CommonTitle localCommonTitle = this.c;
    String str;
    if (this.r == 0)
    {
      str = "添加照片";
      localCommonTitle.setMiddleText(str);
      this.c.setLeftButtonType(2);
      if (this.r != 0) {
        break label95;
      }
      this.c.showRightText(true, "编辑");
      this.c.setOnRightButtonClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          boolean bool = true;
          VdsAgent.onClick(this, paramAnonymousView);
          if (MinsuAddPicturesActivity.a(MinsuAddPicturesActivity.this).booleanValue())
          {
            MinsuAddPicturesActivity.this.a.setEditType(2);
            MinsuAddPicturesActivity.b(MinsuAddPicturesActivity.this).showRightText(true, "完成");
            if (MinsuAddPicturesActivity.a(MinsuAddPicturesActivity.this).booleanValue()) {
              break label152;
            }
            MinsuAddPicturesActivity.c(MinsuAddPicturesActivity.this);
            MinsuAddPicturesActivity.d(MinsuAddPicturesActivity.this).setEnabled(true);
            MinsuAddPicturesActivity.d(MinsuAddPicturesActivity.this).setBackgroundColor(MinsuAddPicturesActivity.this.getResources().getColor(2131624475));
            label97:
            paramAnonymousView = MinsuAddPicturesActivity.this;
            if (MinsuAddPicturesActivity.a(MinsuAddPicturesActivity.this).booleanValue()) {
              break label181;
            }
          }
          for (;;)
          {
            MinsuAddPicturesActivity.a(paramAnonymousView, Boolean.valueOf(bool));
            return;
            MinsuAddPicturesActivity.this.a.setEditType(0);
            MinsuAddPicturesActivity.b(MinsuAddPicturesActivity.this).showRightText(true, "编辑");
            break;
            label152:
            MinsuAddPicturesActivity.d(MinsuAddPicturesActivity.this).setEnabled(false);
            MinsuAddPicturesActivity.d(MinsuAddPicturesActivity.this).setBackgroundColor(Color.parseColor("#e2e2e2"));
            break label97;
            label181:
            bool = false;
          }
        }
      });
    }
    for (;;)
    {
      this.c.setOnLeftButtonClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuAddPicturesActivity.e(MinsuAddPicturesActivity.this);
        }
      });
      return;
      str = "设置封面照片";
      break;
      label95:
      this.a.setEditType(1);
      this.c.showRightText(false, "");
    }
  }
  
  private void b()
  {
    this.d = ((TextView)findViewById(2131691208));
    TextView localTextView = this.d;
    if (this.r == 0) {}
    for (String str = "添加照片";; str = "确认")
    {
      localTextView.setText(str);
      this.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (MinsuAddPicturesActivity.f(MinsuAddPicturesActivity.this) == 0)
          {
            if (com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().size() < MinsuAddPicturesActivity.g(MinsuAddPicturesActivity.this))
            {
              MinsuAddPicturesActivity.h(MinsuAddPicturesActivity.this);
              return;
            }
            af.showToast(MinsuAddPicturesActivity.this, "最多上传" + MinsuAddPicturesActivity.g(MinsuAddPicturesActivity.this) + "张图片", 1);
            return;
          }
          MinsuAddPicturesActivity.i(MinsuAddPicturesActivity.this);
        }
      });
      this.a = new DragPicturesView(this);
      this.a.setHouseStatus(this.x);
      this.a.setGetUrls(new DragPicturesView.a()
      {
        public List<String> getPicUrls()
        {
          d.e("error", "picUrls = " + MinsuAddPicturesActivity.j(MinsuAddPicturesActivity.this).size());
          return MinsuAddPicturesActivity.j(MinsuAddPicturesActivity.this);
        }
      });
      ((RelativeLayout)findViewById(2131691207)).addView(this.a);
      return;
    }
  }
  
  private void d(String paramString)
  {
    this.A.clear();
    Iterator localIterator = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().iterator();
    while (localIterator.hasNext())
    {
      com.ziroom.ziroomcustomer.minsu.view.widget.a.a locala = (com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localIterator.next();
      locala.getHousePicType();
      this.A.add(locala.getPicUrl());
    }
    d.e("error", paramString + " picUrls = " + this.A.size());
  }
  
  private void e()
  {
    this.a.RemoveAllViews();
    Iterator localIterator = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().iterator();
    if (localIterator.hasNext())
    {
      com.ziroom.ziroomcustomer.minsu.view.widget.a.a locala = (com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localIterator.next();
      View localView = LayoutInflater.from(this).inflate(2130904342, null, false);
      final DragPictureImageView localDragPictureImageView = (DragPictureImageView)localView.findViewById(2131695333);
      localDragPictureImageView.setFid(locala.getFid());
      localDragPictureImageView.setHousePicType(locala.getHousePicType());
      localDragPictureImageView.setPicType(locala.getPicType());
      localDragPictureImageView.setPicType(locala.getPicType());
      localDragPictureImageView.setIsDefault(locala.getIsDefault());
      if (locala.getPicType() == a.a.a.a) {}
      for (String str = locala.getPicUrl();; str = locala.getThumbnailUri())
      {
        localDragPictureImageView.setController(com.freelxl.baselibrary.f.c.frescoController(str, new ControllerListener()
        {
          public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable) {}
          
          public void onFinalImageSet(String paramAnonymousString, Object paramAnonymousObject, Animatable paramAnonymousAnimatable)
          {
            paramAnonymousString = (ImageInfo)paramAnonymousObject;
            if (paramAnonymousObject == null) {
              return;
            }
            localDragPictureImageView.setOriginWidth(paramAnonymousString.getWidth());
            localDragPictureImageView.setOriginHeight(paramAnonymousString.getHeight());
          }
          
          public void onIntermediateImageFailed(String paramAnonymousString, Throwable paramAnonymousThrowable) {}
          
          public void onIntermediateImageSet(String paramAnonymousString, Object paramAnonymousObject) {}
          
          public void onRelease(String paramAnonymousString) {}
          
          public void onSubmit(String paramAnonymousString, Object paramAnonymousObject) {}
        }));
        localView.setTag(locala);
        localView.setTag(2131689523, locala.getPicUrl());
        this.a.AddView(localView);
        break;
      }
    }
    this.a.redraw();
  }
  
  private void f()
  {
    Iterator localIterator = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().iterator();
    while (localIterator.hasNext())
    {
      com.ziroom.ziroomcustomer.minsu.view.widget.a.a locala = (com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localIterator.next();
      if ((locala.getPicType() != a.a.a.a) && (ae.notNull(locala.getOriginalUri())))
      {
        Object localObject = ad.getRealFilePath2(this, Uri.parse(locala.getOriginalUri()));
        if (ae.notNull((String)localObject))
        {
          int i = com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.readPictureDegree((String)localObject);
          if (Math.abs(i) > 0)
          {
            localObject = com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.rotaingImageView(i, n.getBitmap((String)localObject));
            String str = ad.createFileName();
            n.saveBitmap((Bitmap)localObject, com.ziroom.ziroomcustomer.minsu.b.c.e, str, 100);
            locala.setOriginalUri(Uri.fromFile(new File(com.ziroom.ziroomcustomer.minsu.b.c.e + "/" + str)).toString());
            ((Bitmap)localObject).recycle();
          }
        }
      }
    }
  }
  
  private void g()
  {
    if ((this.g == null) || (this.f == null))
    {
      this.g = new ArrayList();
      this.g.add("拍照");
      this.g.add("相册选择");
      this.f = new i(this, new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          MinsuAddPicturesActivity.l(MinsuAddPicturesActivity.this).dismiss();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousAdapterView = new Intent("android.media.action.IMAGE_CAPTURE");
            if (paramAnonymousAdapterView.resolveActivity(MinsuAddPicturesActivity.this.getPackageManager()) != null)
            {
              paramAnonymousView = new ContentValues(2);
              com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().setCameraImgPath();
              paramAnonymousView.put("_data", com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCameraImgPath());
              paramAnonymousView.put("mime_type", "image/jpeg");
              paramAnonymousAdapterView.putExtra("output", MinsuAddPicturesActivity.this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, paramAnonymousView));
            }
            MinsuAddPicturesActivity.this.startActivityForResult(paramAnonymousAdapterView, 2);
          }
          while (paramAnonymousInt != 1) {
            return;
          }
          paramAnonymousAdapterView = new Intent(MinsuAddPicturesActivity.this, MinsuLocalAlbumDetailActivity.class);
          paramAnonymousAdapterView.putExtra("local_folder_name", "所有图片");
          if (MinsuAddPicturesActivity.j(MinsuAddPicturesActivity.this) == null) {}
          for (paramAnonymousInt = 0;; paramAnonymousInt = MinsuAddPicturesActivity.g(MinsuAddPicturesActivity.this) - MinsuAddPicturesActivity.j(MinsuAddPicturesActivity.this).size())
          {
            paramAnonymousAdapterView.putExtra("picMaxNum", paramAnonymousInt);
            MinsuAddPicturesActivity.this.startActivityForResult(paramAnonymousAdapterView, 1);
            return;
          }
        }
      }, this.g);
    }
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        i locali = MinsuAddPicturesActivity.l(MinsuAddPicturesActivity.this);
        View localView = MinsuAddPicturesActivity.this.getWindow().getDecorView();
        if (!(locali instanceof PopupWindow))
        {
          locali.showAtLocation(localView, 80, 0, 0);
          return;
        }
        VdsAgent.showAtLocation((PopupWindow)locali, localView, 80, 0, 0);
      }
    }, 250L);
  }
  
  private void h()
  {
    try
    {
      showProgressNoCancel("请稍后...", 100000L);
      Iterator localIterator = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localIterator.next();
        if ((((com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localObject2).getPicType() != a.a.a.a) && (((com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localObject2).getIsUpload() == 0))
        {
          localObject2 = new File(ad.getRealFilePath2(this, Uri.parse(((com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localObject2).getOriginalUri())));
          if (((File)localObject2).exists()) {
            this.t.add(localObject2);
          }
        }
      }
      if (this.t == null) {
        break label137;
      }
    }
    finally {}
    if (this.t.size() > 0) {
      this.b.sendEmptyMessage(0);
    }
    for (;;)
    {
      return;
      label137:
      d("addpic 417");
      dismissProgress();
    }
  }
  
  private void i()
  {
    MinsuHousePicBean localMinsuHousePicBean = new MinsuHousePicBean();
    localMinsuHousePicBean.houseBaseFid = this.s;
    localMinsuHousePicBean.houseRoomFid = this.v;
    localMinsuHousePicBean.picType = this.w;
    com.ziroom.ziroomcustomer.minsu.e.a.housePicList(this, localMinsuHousePicBean, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk)
      {
        d.d("lanzhihong", paramAnonymousString);
      }
      
      public void onSuccess(k paramAnonymousk)
      {
        MinsuHousePicListBean localMinsuHousePicListBean = (MinsuHousePicListBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHousePicListBean != null) && (localMinsuHousePicListBean.checkSuccess(MinsuAddPicturesActivity.this)))
        {
          com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().clear();
          Object localObject = localMinsuHousePicListBean.data.iterator();
          while (((Iterator)localObject).hasNext())
          {
            paramAnonymousk = (MinsuHousePicListBean.DataBean)((Iterator)localObject).next();
            if ((paramAnonymousk != null) && (paramAnonymousk.isDefault == 1))
            {
              localObject = new com.ziroom.ziroomcustomer.minsu.view.widget.a.a();
              ((com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localObject).setPicType(a.a.a.a);
              ((com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localObject).setPicUrl(paramAnonymousk.picUrl);
              ((com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localObject).setFid(paramAnonymousk.fid);
              ((com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localObject).setIsDefault(paramAnonymousk.isDefault);
              ((com.ziroom.ziroomcustomer.minsu.view.widget.a.a)localObject).setHousePicType(paramAnonymousk.picType + "");
              com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().add(localObject);
              com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().setResultOk(true);
            }
          }
          paramAnonymousk = localMinsuHousePicListBean.data.iterator();
          while (paramAnonymousk.hasNext())
          {
            localObject = (MinsuHousePicListBean.DataBean)paramAnonymousk.next();
            if ((localObject != null) && (((MinsuHousePicListBean.DataBean)localObject).isDefault == 0))
            {
              com.ziroom.ziroomcustomer.minsu.view.widget.a.a locala = new com.ziroom.ziroomcustomer.minsu.view.widget.a.a();
              locala.setPicType(a.a.a.a);
              locala.setPicUrl(((MinsuHousePicListBean.DataBean)localObject).picUrl);
              locala.setFid(((MinsuHousePicListBean.DataBean)localObject).fid);
              locala.setHousePicType(((MinsuHousePicListBean.DataBean)localObject).picType + "");
              com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().add(locala);
              com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().setResultOk(true);
            }
          }
          if (MinsuAddPicturesActivity.j(MinsuAddPicturesActivity.this) != null) {
            MinsuAddPicturesActivity.j(MinsuAddPicturesActivity.this).clear();
          }
          paramAnonymousk = localMinsuHousePicListBean.data.iterator();
          while (paramAnonymousk.hasNext())
          {
            localObject = (MinsuHousePicListBean.DataBean)paramAnonymousk.next();
            MinsuAddPicturesActivity.j(MinsuAddPicturesActivity.this).add(((MinsuHousePicListBean.DataBean)localObject).picUrl);
          }
          d.e("error", "picUrls = " + MinsuAddPicturesActivity.j(MinsuAddPicturesActivity.this).size());
          MinsuAddPicturesActivity.k(MinsuAddPicturesActivity.this);
          d.e("lanzhihong", "ro======" + localMinsuHousePicListBean.toString());
          return;
        }
        if (localMinsuHousePicListBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuHousePicListBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void j()
  {
    DragPictureImageView localDragPictureImageView = this.a.getDefaultView();
    if ((this.a == null) || (localDragPictureImageView == null)) {
      return;
    }
    MinsuHousePicBean localMinsuHousePicBean = new MinsuHousePicBean();
    localMinsuHousePicBean.houseBaseFid = this.s;
    localMinsuHousePicBean.houseRoomFid = this.v;
    localMinsuHousePicBean.housePicFid = localDragPictureImageView.getFid();
    localMinsuHousePicBean.picType = localDragPictureImageView.getHousePicType();
    com.ziroom.ziroomcustomer.minsu.e.a.setDefaultPic(this, localMinsuHousePicBean, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk)
      {
        d.d("lanzhihong", paramAnonymousString);
      }
      
      public void onSuccess(k paramAnonymousk)
      {
        MinsuBaseJson localMinsuBaseJson = (MinsuBaseJson)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuBaseJson != null) && (localMinsuBaseJson.checkSuccess(MinsuAddPicturesActivity.this)))
        {
          MinsuAddPicturesActivity.this.showToast("设置封面照片成功");
          MinsuAddPicturesActivity.this.setResult(-1);
          MinsuAddPicturesActivity.this.finish();
          d.e("lanzhihong", "ro======" + localMinsuBaseJson.toString());
          return;
        }
        if (localMinsuBaseJson == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuBaseJson.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void k()
  {
    if ((this.a == null) || (this.a.getDelViews().size() < 1)) {
      return;
    }
    d.e("error", "删除前 picUrls " + this.A.size() + " 要删除数 " + this.a.getDelUrls().size());
    this.A.removeAll(this.a.getDelUrls());
    d.e("error", "删除后 picUrls " + this.A.size());
    Iterator localIterator = this.a.getDelViews().iterator();
    while (localIterator.hasNext())
    {
      MinsuHousePicBean localMinsuHousePicBean = (MinsuHousePicBean)localIterator.next();
      localMinsuHousePicBean.houseRoomFid = this.v;
      localMinsuHousePicBean.houseBaseFid = this.s;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.delHousePicList(this, this.a.getDelViews(), new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk)
      {
        d.d("lanzhihong", paramAnonymousString);
      }
      
      public void onSuccess(k paramAnonymousk)
      {
        MinsuBaseJson localMinsuBaseJson = (MinsuBaseJson)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuBaseJson != null) && (localMinsuBaseJson.checkSuccess(MinsuAddPicturesActivity.this)))
        {
          paramAnonymousk = MinsuAddPicturesActivity.this.a.getDelViews().iterator();
          while (paramAnonymousk.hasNext())
          {
            MinsuHousePicBean localMinsuHousePicBean = (MinsuHousePicBean)paramAnonymousk.next();
            if ((MinsuAddPicturesActivity.m(MinsuAddPicturesActivity.this) != null) && (MinsuAddPicturesActivity.m(MinsuAddPicturesActivity.this).containsKey(localMinsuHousePicBean.housePicFid))) {
              MinsuAddPicturesActivity.m(MinsuAddPicturesActivity.this).remove(localMinsuHousePicBean.housePicFid);
            }
          }
          MinsuAddPicturesActivity.this.showToast("删除成功");
          MinsuAddPicturesActivity.this.a.removeDelView();
          d.e("lanzhihong", "ro======" + localMinsuBaseJson.toString());
          return;
        }
        if (localMinsuBaseJson == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuBaseJson.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void l()
  {
    if ((this.x == 40) && (this.y != null) && (!this.y.isEmpty()))
    {
      e.newBuilder(this).setTitle("提示").setContent("添加的房源照片需要审核后才能在房源详情页显示").setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuAddPicturesActivity.this.setResult(-1);
          MinsuAddPicturesActivity.this.finish();
        }
      }).build().show();
      return;
    }
    setResult(-1);
    finish();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0)) {
      l();
    }
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
    case 1: 
      do
      {
        return;
      } while (!com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().isResultOk());
      com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().setResultOk(false);
      f();
      e();
      h();
      return;
    }
    paramIntent = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCameraImgPath();
    if (TextUtils.isEmpty(paramIntent))
    {
      showToast("图片获取失败");
      return;
    }
    Object localObject = new File(paramIntent);
    if (((File)localObject).exists())
    {
      localObject = Uri.fromFile((File)localObject);
      com.ziroom.ziroomcustomer.minsu.view.widget.a.a locala = new com.ziroom.ziroomcustomer.minsu.view.widget.a.a();
      locala.setThumbnailUri(((Uri)localObject).toString());
      locala.setOriginalUri(((Uri)localObject).toString());
      locala.setOrientation(ad.getBitmapDegree(paramIntent));
      com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().add(locala);
      com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().setResultOk(true);
      h();
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          MinsuAddPicturesActivity.k(MinsuAddPicturesActivity.this);
        }
      }, 1000L);
      return;
    }
    showToast("图片获取失败");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903259);
    this.r = getIntent().getIntExtra("type", 0);
    this.s = getIntent().getStringExtra("houseBaseFid");
    this.v = getIntent().getStringExtra("houseRoomFid");
    this.w = getIntent().getStringExtra("picType");
    this.x = getIntent().getIntExtra("houseStatus", 0);
    this.z = getIntent().getIntExtra("picMaxNum", 8);
    b();
    a();
    com.ziroom.ziroomcustomer.minsu.view.widget.a.init(getApplicationContext());
    i();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuAddPicturesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */