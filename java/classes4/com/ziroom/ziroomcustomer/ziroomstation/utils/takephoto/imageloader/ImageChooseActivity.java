package com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.imageloader;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.ziroomstation.utils.i;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ImageChooseActivity
  extends BaseActivity
  implements View.OnClickListener, a.a, b.a
{
  private a A;
  private int B;
  private Handler C = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      ImageChooseActivity.a(ImageChooseActivity.this).dismiss();
      ImageChooseActivity.b(ImageChooseActivity.this);
      ImageChooseActivity.c(ImageChooseActivity.this);
    }
  };
  int a = 0;
  private ProgressDialog b;
  private List<String> c;
  private int d;
  private File e;
  private List<String> f;
  private GridView g;
  private b r;
  private TextView s;
  private TextView t;
  private HashSet<String> u = new HashSet();
  private List<com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.a> v = new ArrayList();
  private RelativeLayout w;
  private TextView x;
  private TextView y;
  private int z;
  
  private void a()
  {
    if (this.e == null)
    {
      g.textToast(getApplicationContext(), "擦，一张图片没扫描到");
      return;
    }
    this.f = Arrays.asList(this.e.list());
    this.r = new b(getApplicationContext(), this.B, this.f, 2130904013, this.e.getAbsolutePath());
    this.r.setImgSelectesListener(this);
    this.g.setAdapter(this.r);
    this.y.setText(this.a + "张");
  }
  
  private void b()
  {
    this.A = new a(-1, (int)(this.z * 0.7D), this.v, LayoutInflater.from(getApplicationContext()).inflate(2130904850, null));
    this.A.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        WindowManager.LayoutParams localLayoutParams = ImageChooseActivity.this.getWindow().getAttributes();
        localLayoutParams.alpha = 1.0F;
        ImageChooseActivity.this.getWindow().setAttributes(localLayoutParams);
      }
    });
    this.A.setOnImageDirSelected(this);
  }
  
  private void e()
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      g.textToast(this, "暂无外部存储");
      return;
    }
    this.b = ProgressDialog.show(this, null, "正在加载...");
    new Thread(new Runnable()
    {
      public void run()
      {
        Object localObject1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor localCursor = ImageChooseActivity.this.getContentResolver().query((Uri)localObject1, null, "mime_type=? or mime_type=?", new String[] { "image/jpeg", "image/png" }, "date_modified");
        Log.e("TAG", localCursor.getCount() + "");
        Object localObject2 = null;
        while (localCursor.moveToNext())
        {
          Object localObject3 = localCursor.getString(localCursor.getColumnIndex("_data"));
          Log.e("TAG", (String)localObject3);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = localObject3;
          }
          File localFile = new File((String)localObject3).getParentFile();
          localObject2 = localObject1;
          if (localFile != null)
          {
            String str = localFile.getAbsolutePath();
            localObject2 = localObject1;
            if (!ImageChooseActivity.d(ImageChooseActivity.this).contains(str))
            {
              ImageChooseActivity.d(ImageChooseActivity.this).add(str);
              localObject2 = new com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.a();
              ((com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.a)localObject2).setDir(str);
              ((com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.a)localObject2).setFirstImagePath((String)localObject3);
              int i = localFile.list(new FilenameFilter()
              {
                public boolean accept(File paramAnonymous2File, String paramAnonymous2String)
                {
                  return (paramAnonymous2String.endsWith(".jpg")) || (paramAnonymous2String.endsWith(".png")) || (paramAnonymous2String.endsWith(".jpeg"));
                }
              }).length;
              localObject3 = ImageChooseActivity.this;
              ((ImageChooseActivity)localObject3).a += i;
              ((com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.a)localObject2).setCount(i);
              ImageChooseActivity.e(ImageChooseActivity.this).add(localObject2);
              localObject2 = localObject1;
              if (i > ImageChooseActivity.f(ImageChooseActivity.this))
              {
                ImageChooseActivity.a(ImageChooseActivity.this, i);
                ImageChooseActivity.a(ImageChooseActivity.this, localFile);
                localObject2 = localObject1;
              }
            }
          }
        }
        localCursor.close();
        ImageChooseActivity.a(ImageChooseActivity.this, null);
        ImageChooseActivity.g(ImageChooseActivity.this).sendEmptyMessage(272);
      }
    }).start();
  }
  
  private void f()
  {
    this.B = getIntent().getIntExtra("maxImgCount", Integer.MAX_VALUE);
    this.s = ((TextView)findViewById(2131690962));
    this.s.setText("(0/" + this.B + ")");
    this.t = ((TextView)findViewById(2131690963));
    this.t.setOnClickListener(this);
    this.g = ((GridView)findViewById(2131690964));
    this.x = ((TextView)findViewById(2131690966));
    this.y = ((TextView)findViewById(2131690967));
    this.w = ((RelativeLayout)findViewById(2131690965));
  }
  
  private void g()
  {
    this.w.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ImageChooseActivity.h(ImageChooseActivity.this).setAnimationStyle(2131427782);
        paramAnonymousView = ImageChooseActivity.h(ImageChooseActivity.this);
        RelativeLayout localRelativeLayout = ImageChooseActivity.i(ImageChooseActivity.this);
        if (!(paramAnonymousView instanceof PopupWindow)) {
          paramAnonymousView.showAsDropDown(localRelativeLayout, 0, 0);
        }
        for (;;)
        {
          paramAnonymousView = ImageChooseActivity.this.getWindow().getAttributes();
          paramAnonymousView.alpha = 0.3F;
          ImageChooseActivity.this.getWindow().setAttributes(paramAnonymousView);
          return;
          VdsAgent.showAsDropDown((PopupWindow)paramAnonymousView, localRelativeLayout, 0, 0);
        }
      }
    });
  }
  
  private void h()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("photoAlbumPaths", (String[])this.c.toArray(new String[this.c.size()]));
    setResult(-1, localIntent);
    finish();
    System.gc();
  }
  
  public void onBackPressed()
  {
    h();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903219);
    paramBundle = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
    this.z = paramBundle.heightPixels;
    f();
    e();
    g();
  }
  
  public void onImgSelected(List<String> paramList)
  {
    this.c = paramList;
    if ((i.isLegal(paramList)) && (paramList.size() <= this.B)) {
      this.s.setText("(" + paramList.size() + "/" + this.B + ")");
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void selected(com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.a parama)
  {
    this.e = new File(parama.getDir());
    this.f = Arrays.asList(this.e.list(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return (paramAnonymousString.endsWith(".jpg")) || (paramAnonymousString.endsWith(".png")) || (paramAnonymousString.endsWith(".jpeg"));
      }
    }));
    this.r = new b(getApplicationContext(), this.B, this.f, 2130904013, this.e.getAbsolutePath());
    this.r.setImgSelectesListener(this);
    this.g.setAdapter(this.r);
    this.y.setText(parama.getCount() + "张");
    this.x.setText(parama.getName());
    this.A.dismiss();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/imageloader/ImageChooseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */