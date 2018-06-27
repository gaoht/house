package com.ziroom.ziroomcustomer.sublet.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.f.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.z;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SubletBookcodeDialog
  extends DialogFragment
  implements View.OnClickListener
{
  ControllerListener a = new BaseControllerListener()
  {
    public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousString, paramAnonymousThrowable);
      SubletBookcodeDialog.b(SubletBookcodeDialog.this, true);
    }
    
    public void onFinalImageSet(String paramAnonymousString, Object paramAnonymousObject, Animatable paramAnonymousAnimatable)
    {
      super.onFinalImageSet(paramAnonymousString, paramAnonymousObject, paramAnonymousAnimatable);
      SubletBookcodeDialog.b(SubletBookcodeDialog.this, true);
    }
  };
  private Context b;
  private View c;
  private String d;
  private String e;
  private String f;
  private String g;
  private RelativeLayout h;
  private SimpleDraweeView i;
  private TextView j;
  private TextView k;
  private ImageView l;
  private ImageView m;
  private TextView n;
  private TextView o;
  private boolean p = false;
  private Bitmap q;
  private String r;
  private boolean s = false;
  private int t;
  private Handler u = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 0: 
        SubletBookcodeDialog.e(SubletBookcodeDialog.this).setImageBitmap(SubletBookcodeDialog.d(SubletBookcodeDialog.this));
        return;
      case 1: 
        a.getInstance().sharePic((BaseActivity)SubletBookcodeDialog.a(SubletBookcodeDialog.this), "", "", "", SubletBookcodeDialog.f(SubletBookcodeDialog.this));
        SubletBookcodeDialog.a(SubletBookcodeDialog.this, false);
        return;
      }
      g.textToast(SubletBookcodeDialog.a(SubletBookcodeDialog.this), "保存成功");
      SubletBookcodeDialog.a(SubletBookcodeDialog.this, false);
    }
  };
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Object localObject = new ByteArrayOutputStream();
    int i1 = 100;
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
    for (;;)
    {
      if ((((ByteArrayOutputStream)localObject).toByteArray().length / 1024 <= 300) || (i1 == 30))
      {
        paramBitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject).toByteArray()), null, null);
        localObject = new Matrix();
        ((Matrix)localObject).setScale(0.5F, 0.5F);
        return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      }
      ((ByteArrayOutputStream)localObject).reset();
      i1 -= 10;
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, i1, (OutputStream)localObject);
    }
  }
  
  private void a()
  {
    getDialog().requestWindowFeature(1);
    getDialog().getWindow().setGravity(17);
    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getDialog().getWindow().getDecorView().setPadding(0, 0, 0, 0);
    getDialog().getWindow().setLayout(-1, -1);
    getDialog().setCanceledOnTouchOutside(true);
    getDialog().setCancelable(true);
  }
  
  private void b()
  {
    Bundle localBundle = getArguments();
    this.d = localBundle.getString("housePic");
    this.e = localBundle.getString("houseTitle");
    this.f = localBundle.getString("bookcode");
    this.g = localBundle.getString("qrCodeInfo");
    this.h = ((RelativeLayout)this.c.findViewById(2131693895));
    this.i = ((SimpleDraweeView)this.c.findViewById(2131693871));
    this.j = ((TextView)this.c.findViewById(2131690978));
    this.k = ((TextView)this.c.findViewById(2131696454));
    this.l = ((ImageView)this.c.findViewById(2131696282));
    this.n = ((TextView)this.c.findViewById(2131692590));
    this.o = ((TextView)this.c.findViewById(2131689826));
    this.m = ((ImageView)this.c.findViewById(2131690588));
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.j.setText(this.e);
    this.k.setText(this.f);
    this.i.setController(com.freelxl.baselibrary.f.c.frescoController(this.d, this.a));
    new Thread(new Runnable()
    {
      public void run()
      {
        SubletBookcodeDialog.a(SubletBookcodeDialog.this, z.createQRImage(SubletBookcodeDialog.a(SubletBookcodeDialog.this), SubletBookcodeDialog.b(SubletBookcodeDialog.this), null));
        SubletBookcodeDialog.c(SubletBookcodeDialog.this).sendEmptyMessage(0);
      }
    }).start();
  }
  
  public static SubletBookcodeDialog getInstance(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    SubletBookcodeDialog localSubletBookcodeDialog = new SubletBookcodeDialog();
    Bundle localBundle = new Bundle();
    localBundle.putString("housePic", paramString1);
    localBundle.putString("houseTitle", paramString2);
    localBundle.putString("bookcode", paramString3);
    localBundle.putString("qrCodeInfo", paramString4);
    localSubletBookcodeDialog.setArguments(localBundle);
    return localSubletBookcodeDialog;
  }
  
  public void getViewBitmap(View paramView)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(-1);
    paramView.draw(localCanvas);
    new Thread(new Runnable()
    {
      public void run()
      {
        SubletBookcodeDialog.this.saveImage(this.a);
      }
    }).start();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.s) {
      return;
    }
    if (!this.p)
    {
      g.textToast(this.b, "房间图片还未加载完毕，请稍候");
      return;
    }
    this.s = true;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689826: 
      this.t = 1;
      getViewBitmap(this.h);
      return;
    case 2131692590: 
      this.t = 2;
      getViewBitmap(this.h);
      return;
    }
    dismiss();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = getActivity();
    this.c = paramLayoutInflater.inflate(2130903857, paramViewGroup);
    a();
    b();
    return this.c;
  }
  
  public void saveImage(Bitmap paramBitmap)
  {
    File localFile = new File(Environment.getExternalStorageDirectory(), "ziroom");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    localFile = new File(localFile, "ziroom_share_bookcode_" + this.f + ".jpg");
    this.r = localFile.getPath();
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      if (localFileOutputStream != null)
      {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        paramBitmap = Uri.fromFile(localFile);
        this.b.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", paramBitmap));
      }
      this.u.sendEmptyMessage(this.t);
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/widget/SubletBookcodeDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */