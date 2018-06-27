package com.ziroom.ziroomcustomer.sublet.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.widget.a;
import com.ziroom.threelib.ziroomshare.f;
import com.ziroom.threelib.ziroomshare.f.c;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Share;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Sublet;
import com.ziroom.ziroomcustomer.util.z;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class SubletHouseShareView
  extends LinearLayout
{
  TextView a;
  TextView b;
  SimpleDraweeView c;
  TextView d;
  TextView e;
  TextView f;
  TextView g;
  RelativeLayout h;
  TextView i;
  TextView j;
  TextView k;
  TextView l;
  SimpleDraweeView m;
  ImageView n;
  private Context o;
  private String p;
  private Bitmap q;
  private String r = "";
  private boolean s = false;
  private Handler t = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 0: 
      case 1: 
        do
        {
          return;
          SubletHouseShareView.c(SubletHouseShareView.this);
          SubletHouseShareView.a(SubletHouseShareView.this, false);
          f.newBuilder(SubletHouseShareView.a(SubletHouseShareView.this)).setFlag(31).setShareTitle("").setShareUrl("").setShareContent("").setSharePicUrl("").setSharePicUrlLocal(SubletHouseShareView.d(SubletHouseShareView.this)).build().show();
          return;
          SubletHouseShareView.this.n.setImageBitmap(SubletHouseShareView.e(SubletHouseShareView.this));
        } while (SubletHouseShareView.e(SubletHouseShareView.this) == null);
        SubletHouseShareView.a(SubletHouseShareView.this, null);
        return;
      }
      SubletHouseShareView.a(SubletHouseShareView.this, false);
      g.textToast(SubletHouseShareView.a(SubletHouseShareView.this), "保存成功");
      SubletHouseShareView.c(SubletHouseShareView.this);
    }
  };
  
  public SubletHouseShareView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubletHouseShareView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SubletHouseShareView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.o = paramContext;
    a();
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(0.5F, 0.5F);
    return Bitmap.createBitmap(paramBitmap, 0, 0, (int)f1, (int)f2, localMatrix, true);
  }
  
  private void a()
  {
    LayoutInflater.from(this.o).inflate(2130904800, this, true);
    this.a = ((TextView)findViewById(2131690978));
    this.b = ((TextView)findViewById(2131696276));
    this.c = ((SimpleDraweeView)findViewById(2131696277));
    this.d = ((TextView)findViewById(2131696278));
    this.e = ((TextView)findViewById(2131690979));
    this.f = ((TextView)findViewById(2131696097));
    this.g = ((TextView)findViewById(2131696475));
    this.h = ((RelativeLayout)findViewById(2131696476));
    this.i = ((TextView)findViewById(2131696477));
    this.j = ((TextView)findViewById(2131696478));
    this.k = ((TextView)findViewById(2131695093));
    this.l = ((TextView)findViewById(2131696068));
    this.m = ((SimpleDraweeView)findViewById(2131696279));
    this.n = ((ImageView)findViewById(2131696282));
  }
  
  private void b()
  {
    if ((a.getDialog() != null) && (a.isShowing())) {
      a.dismiss();
    }
  }
  
  public Bitmap getViewBitmap()
  {
    int i1 = this.o.getResources().getDisplayMetrics().widthPixels;
    int i2 = getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(-1);
    layout(0, 0, i1, i2);
    draw(localCanvas);
    return a(localBitmap);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    getChildAt(0).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    measureChildren(paramInt1, paramInt2);
    setMeasuredDimension(this.o.getResources().getDisplayMetrics().widthPixels, getChildAt(0).getMeasuredHeight());
  }
  
  public void saveImage(Bitmap paramBitmap)
  {
    File localFile = new File(Environment.getExternalStorageDirectory(), "ziroom");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    localFile = new File(localFile, "ziroom_house_" + this.r + ".jpg");
    this.p = localFile.getPath();
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      if (localFileOutputStream != null)
      {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
      }
      paramBitmap = Uri.fromFile(localFile);
      this.o.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", paramBitmap));
      return;
    }
    catch (FileNotFoundException paramBitmap)
    {
      paramBitmap.printStackTrace();
      return;
    }
    catch (IOException paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public void setContent(RentHouseDetail paramRentHouseDetail)
  {
    if (paramRentHouseDetail == null) {
      return;
    }
    this.r = paramRentHouseDetail.getHouse_code();
    this.a.setText(paramRentHouseDetail.getName());
    this.b.setText(paramRentHouseDetail.getSubway_primary());
    String str = "";
    final Object localObject = str;
    if (paramRentHouseDetail != null)
    {
      localObject = str;
      if (paramRentHouseDetail.getPhotos_big().size() > 0) {
        localObject = (String)paramRentHouseDetail.getPhotos_big().get(0);
      }
    }
    this.c.setController(c.frescoController((String)localObject));
    this.e.setText(paramRentHouseDetail.getPrice());
    this.d.setText(paramRentHouseDetail.getPrice_unit());
    this.f.setText(paramRentHouseDetail.getPrice_desc());
    if ((paramRentHouseDetail.getTurn() != null) && (!TextUtils.isEmpty(paramRentHouseDetail.getTurn().getCheckin_date())))
    {
      this.h.setVisibility(0);
      this.g.setVisibility(0);
      localObject = "预计" + paramRentHouseDetail.getTurn().getCheckin_date() + "可入住，需签约至" + paramRentHouseDetail.getTurn().getSigning_max_date();
      this.g.setText((CharSequence)localObject);
      this.i.setText("转租者：" + paramRentHouseDetail.getTurn().getCustomer_name());
      this.j.setText("联系方式：" + paramRentHouseDetail.getTurn().getCustomer_phone());
      this.l.setText(paramRentHouseDetail.getTurn().getDescribe());
    }
    for (;;)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramRentHouseDetail.getArea()).append("㎡").append(" | ").append(paramRentHouseDetail.getBedroom()).append("室").append(paramRentHouseDetail.getParlor()).append("厅").append(" | ").append(paramRentHouseDetail.getFloor()).append("/").append(paramRentHouseDetail.getFloor_total()).append("层").append(" | ").append("朝").append(paramRentHouseDetail.getFace());
      this.k.setText(((StringBuilder)localObject).toString());
      str = "";
      localObject = str;
      if (paramRentHouseDetail.getHx_photos_big() != null)
      {
        localObject = str;
        if (paramRentHouseDetail.getHx_photos_big().size() > 0) {
          localObject = (String)paramRentHouseDetail.getHx_photos_big().get(0);
        }
      }
      this.m.setController(c.frescoController((String)localObject));
      localObject = "m.ziroom.com";
      if (paramRentHouseDetail.getWechat_share() != null) {
        localObject = paramRentHouseDetail.getWechat_share().getUrl();
      }
      new Thread(new Runnable()
      {
        public void run()
        {
          SubletHouseShareView.a(SubletHouseShareView.this, z.createQRImage(SubletHouseShareView.a(SubletHouseShareView.this), localObject, null));
          SubletHouseShareView.b(SubletHouseShareView.this).sendEmptyMessage(1);
        }
      }).start();
      return;
      this.h.setVisibility(8);
      this.g.setVisibility(8);
      this.l.setText(paramRentHouseDetail.getIntroduction());
    }
  }
  
  public void toSave()
  {
    if (this.s) {
      return;
    }
    this.s = true;
    new Thread(new Runnable()
    {
      public void run()
      {
        SubletHouseShareView.this.saveImage(this.a);
        SubletHouseShareView.b(SubletHouseShareView.this).sendEmptyMessage(2);
      }
    }).start();
  }
  
  public void toShare()
  {
    if (this.s) {
      return;
    }
    this.s = true;
    new Thread(new Runnable()
    {
      public void run()
      {
        SubletHouseShareView.this.saveImage(this.a);
        SubletHouseShareView.b(SubletHouseShareView.this).sendEmptyMessage(0);
      }
    }).start();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/widget/SubletHouseShareView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */