package com.freelxl.baselibrary.widget.imgpicker.ui;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import com.freelxl.baselibrary.R.id;
import com.freelxl.baselibrary.R.layout;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.widget.imgpicker.c.d;
import com.growingio.android.sdk.agent.VdsAgent;
import java.io.File;

public class PickerActivity
  extends FragmentActivity
  implements ImageFolderListFragment.c, ImageListFragment.c
{
  CheckBox a;
  FrameLayout b;
  FragmentManager c;
  ImageListFragment d;
  ImageFolderListFragment e;
  private final int f = 1;
  private final int g = 2;
  private boolean h;
  private int i;
  private boolean j;
  private int k;
  private int l;
  private int m = 1;
  private int n = 1;
  private Uri o;
  private Uri p;
  
  private void a()
  {
    this.a = ((CheckBox)findViewById(R.id.cb_title));
    this.b = ((FrameLayout)findViewById(R.id.fl));
  }
  
  private void a(String paramString)
  {
    Log.d("Picker", "====path:" + paramString);
    paramString = Uri.fromFile(new File(paramString));
    this.o = b();
    Intent localIntent = new Intent("com.android.camera.action.CROP");
    localIntent.setDataAndType(paramString, "image/*");
    localIntent.putExtra("crop", "true");
    localIntent.putExtra("aspectX", this.m);
    localIntent.putExtra("aspectY", this.n);
    localIntent.putExtra("outputX", this.k);
    localIntent.putExtra("outputY", this.l);
    localIntent.putExtra("scale", true);
    localIntent.putExtra("scaleUpIfNeeded", true);
    localIntent.putExtra("return-data", false);
    localIntent.putExtra("output", this.o);
    localIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
    localIntent.putExtra("noFaceDetection", true);
    startActivityForResult(localIntent, 1);
  }
  
  private Uri b()
  {
    File localFile = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "picker_temp" + ".jpg");
    if (localFile.exists()) {
      localFile.delete();
    }
    return Uri.fromFile(localFile);
  }
  
  private Uri c()
  {
    File localFile = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "picker_camera_temp" + ".jpg");
    if (localFile.exists()) {
      localFile.delete();
    }
    return Uri.fromFile(localFile);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = getIntent();
    }
    if (-1 == paramInt2) {}
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      if (this.o != null) {
        localIntent.putExtra("path", this.o.getPath());
      }
      setResult(-1, localIntent);
      finish();
      return;
    }
    if (this.j)
    {
      a(this.p.getPath());
      return;
    }
    if (this.p != null) {
      localIntent.putExtra("path", this.p.getPath());
    }
    setResult(-1, localIntent);
    finish();
  }
  
  public void onCameraSelect()
  {
    this.p = c();
    if (d.isCameraCanUse())
    {
      Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      localIntent.putExtra("output", this.p);
      startActivityForResult(localIntent, 2);
      return;
    }
    g.textToast(this, "相机权限未开启");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(R.layout.activity_picker);
    paramBundle = getIntent();
    this.h = paramBundle.getBooleanExtra("isMulti", false);
    this.i = paramBundle.getIntExtra("multiNum", 1);
    this.j = paramBundle.getBooleanExtra("isCrop", false);
    this.k = paramBundle.getIntExtra("cropWidth", 1);
    this.l = paramBundle.getIntExtra("cropHeight", 1);
    this.m = paramBundle.getIntExtra("aspectWidth", 1);
    this.n = paramBundle.getIntExtra("aspectHeight", 1);
    a();
    this.c = getSupportFragmentManager();
    this.d = ImageListFragment.getInstance("", "");
    this.c.beginTransaction().add(R.id.fl, this.d).commit();
  }
  
  public void onFolderDismiss()
  {
    this.a.setChecked(false);
  }
  
  public void onFolderSelected(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.e != null) {
      this.e.dismiss();
    }
    paramString3 = this.c.beginTransaction();
    this.a.setText(paramString1);
    if ((this.d != null) && (this.d.isVisible())) {
      this.d.setImageListInfo(paramString2, paramString1);
    }
    for (;;)
    {
      paramString3.commit();
      return;
      this.d = ImageListFragment.getInstance("", "");
      paramString3.add(R.id.fl, this.d);
    }
  }
  
  public void onImageSelect(String paramString)
  {
    if (this.h) {
      return;
    }
    if (this.j)
    {
      a(paramString);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("path", paramString);
    setResult(-1, localIntent);
    finish();
  }
  
  public void onViewClick(View paramView)
  {
    if (paramView.getId() == R.id.cb_title) {
      if (!this.c.executePendingTransactions()) {}
    }
    while (paramView.getId() != R.id.tv_cancel)
    {
      return;
      if (this.e == null) {
        this.e = ImageFolderListFragment.getInstance();
      }
      if (this.e.isAdded())
      {
        this.e.dismiss();
        return;
      }
      paramView = this.e;
      FragmentManager localFragmentManager = this.c;
      if (!(paramView instanceof DialogFragment))
      {
        paramView.show(localFragmentManager, "folder");
        return;
      }
      VdsAgent.showDialogFragment((DialogFragment)paramView, localFragmentManager, "folder");
      return;
    }
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/imgpicker/ui/PickerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */