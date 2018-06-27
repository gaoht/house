package com.megvii.zhimasdk;

import android.app.Activity;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.megvii.livenessdetection.DetectionConfig.Builder;
import com.megvii.livenessdetection.DetectionFrame;
import com.megvii.livenessdetection.Detector;
import com.megvii.livenessdetection.Detector.DetectionFailedType;
import com.megvii.livenessdetection.Detector.DetectionListener;
import com.megvii.livenessdetection.Detector.DetectionType;
import com.megvii.livenessdetection.FaceQualityManager;
import com.megvii.livenessdetection.FaceQualityManager.FaceQualityErrorType;
import com.megvii.zhimasdk.d.d;
import com.megvii.zhimasdk.d.f;
import com.megvii.zhimasdk.d.g;
import com.megvii.zhimasdk.d.h;
import com.megvii.zhimasdk.d.i;
import com.megvii.zhimasdk.d.j;
import com.megvii.zhimasdk.d.k;
import com.megvii.zhimasdk.d.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class MGLivenessDetectActivity
  extends Activity
  implements Camera.PreviewCallback, TextureView.SurfaceTextureListener, Detector.DetectionListener
{
  public i a;
  private TextureView b;
  private ProgressBar c;
  private LinearLayout d;
  private Detector e;
  private com.megvii.zhimasdk.d.e f;
  private Handler g;
  private h h;
  private f i;
  private d j;
  private TextView k;
  private boolean l;
  private FaceQualityManager m;
  private l n;
  private ImageView[] o;
  private LinearLayout p;
  private int q = 3;
  private boolean r;
  private int s = -1;
  private Runnable t = new Runnable()
  {
    public void run()
    {
      MGLivenessDetectActivity.c(MGLivenessDetectActivity.this);
      if (MGLivenessDetectActivity.b(MGLivenessDetectActivity.this).c != null) {
        MGLivenessDetectActivity.this.a((Detector.DetectionType)MGLivenessDetectActivity.b(MGLivenessDetectActivity.this).c.get(0), 10L);
      }
    }
  };
  private int u = 0;
  private int v = 0;
  private boolean w = false;
  private byte[] x;
  private boolean y = false;
  
  private void a()
  {
    this.a = ((i)getIntent().getSerializableExtra("infobean"));
    a(this.a.s);
    this.n = new l(this);
    k.a(this);
    this.g = new Handler();
    this.h = new h(this);
    this.j = new d(this);
    this.i = new f(this, (RelativeLayout)findViewById(R.id.liveness_layout_rootRel));
    this.f = new com.megvii.zhimasdk.d.e();
    this.k = ((TextView)findViewById(R.id.liveness_layout_promptText));
    this.b = ((TextureView)findViewById(R.id.liveness_layout_textureview));
    this.b.setSurfaceTextureListener(this);
    this.c = ((ProgressBar)findViewById(R.id.liveness_layout_progressbar));
    this.c.setVisibility(4);
    this.d = ((LinearLayout)findViewById(R.id.liveness_layout_bottom_tips_head));
    this.d.setVisibility(0);
    findViewById(R.id.liveness_layout_cancle).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MGLivenessDetectActivity.a(MGLivenessDetectActivity.this);
      }
    });
    this.p = ((LinearLayout)findViewById(R.id.liveness_layout_pageNumLinear));
    b();
    this.o = new ImageView[] { (ImageView)findViewById(R.id.liveness_layout_num_image0), (ImageView)findViewById(R.id.liveness_layout_num_image1), (ImageView)findViewById(R.id.liveness_layout_num_image2), (ImageView)findViewById(R.id.liveness_layout_num_image3) };
    this.i.b();
  }
  
  private void a(DetectionFrame paramDetectionFrame)
  {
    this.u += 1;
    if (paramDetectionFrame != null)
    {
      com.megvii.livenessdetection.a.b localb = paramDetectionFrame.getFaceInfo();
      if (localb != null)
      {
        if ((localb.x > 0.5D) || (localb.y > 0.5D)) {
          if (this.u > 10)
          {
            this.u = 0;
            this.k.setText("请勿用手遮挡眼睛");
          }
        }
        do
        {
          return;
          if (localb.z <= 0.5D) {
            break;
          }
        } while (this.u <= 10);
        this.u = 0;
        this.k.setText("请勿用手遮挡嘴巴");
        return;
      }
    }
    a(this.m.feedFrame(paramDetectionFrame));
  }
  
  private void a(String paramString)
  {
    try
    {
      this.q = new JSONObject(paramString).getInt("action_number");
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(String paramString, int paramInt)
  {
    this.y = true;
    com.megvii.zhimasdk.d.c.a(this.a, paramString, paramInt, 1);
    i();
  }
  
  private void a(boolean paramBoolean, String paramString, Map<String, byte[]> paramMap)
  {
    if (!com.megvii.zhimasdk.c.a.a(this))
    {
      this.a.j = "network_error";
      a("failed", 8);
    }
    while (this.a.q) {
      return;
    }
    this.c.setVisibility(0);
    com.megvii.zhimasdk.c.b.a().a(this, this.a.h, this.a.o, paramBoolean, paramString, paramMap, new com.megvii.zhimasdk.b.c()
    {
      public void a(int paramAnonymousInt, com.megvii.zhimasdk.b.a.e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte)
      {
        MGLivenessDetectActivity.f(MGLivenessDetectActivity.this).setVisibility(8);
        try
        {
          paramAnonymousArrayOfe = new JSONObject(new String(paramAnonymousArrayOfByte));
          g.a("verify onSuccess: successJson", paramAnonymousInt + ", " + paramAnonymousArrayOfe);
          boolean bool = paramAnonymousArrayOfe.getBoolean("passed");
          MGLivenessDetectActivity.this.a.k = paramAnonymousArrayOfe.getInt("remaining_retry_count");
          if (bool)
          {
            com.megvii.zhimasdk.d.a.a(MGLivenessDetectActivity.this.a, "PASS_LIVENESS");
            MGLivenessDetectActivity.a(MGLivenessDetectActivity.this, "success", 0);
            return;
          }
          MGLivenessDetectActivity.this.a.j = paramAnonymousArrayOfe.getString("failure_reason");
          MGLivenessDetectActivity.a(MGLivenessDetectActivity.this, MGLivenessDetectActivity.this.a.j);
          return;
        }
        catch (Exception paramAnonymousArrayOfe)
        {
          paramAnonymousArrayOfe.printStackTrace();
          MGLivenessDetectActivity.this.a.j = "DATA_SOURCE_ERROR";
          MGLivenessDetectActivity.a(MGLivenessDetectActivity.this, "failed", 11);
        }
      }
      
      public void a(int paramAnonymousInt, com.megvii.zhimasdk.b.a.e[] paramAnonymousArrayOfe, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable)
      {
        g.a("verify networkResultError: statusCode", paramAnonymousInt + "");
        MGLivenessDetectActivity.f(MGLivenessDetectActivity.this).setVisibility(8);
        if (paramAnonymousInt >= 500)
        {
          MGLivenessDetectActivity.this.a.j = "INTERNAL_SERVER_ERROR";
          MGLivenessDetectActivity.a(MGLivenessDetectActivity.this, "failed", 12);
          return;
        }
        if ((paramAnonymousInt >= 400) && (paramAnonymousInt < 500)) {
          try
          {
            paramAnonymousArrayOfe = new JSONObject(new String(paramAnonymousArrayOfByte)).getString("err_msg");
            MGLivenessDetectActivity.this.a.j = paramAnonymousArrayOfe;
            MGLivenessDetectActivity.a(MGLivenessDetectActivity.this, paramAnonymousArrayOfe);
            return;
          }
          catch (Exception paramAnonymousArrayOfe)
          {
            paramAnonymousArrayOfe.printStackTrace();
            return;
          }
        }
        MGLivenessDetectActivity.this.a.j = "NETWORK_ERROR";
        MGLivenessDetectActivity.a(MGLivenessDetectActivity.this, "failed", 8);
      }
    });
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout1 = (RelativeLayout)findViewById(R.id.liveness_layout_num_0);
    localRelativeLayout1 = (RelativeLayout)findViewById(R.id.liveness_layout_num_1);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)findViewById(R.id.liveness_layout_num_2);
    RelativeLayout localRelativeLayout3 = (RelativeLayout)findViewById(R.id.liveness_layout_num_3);
    if (this.q <= 3) {
      localRelativeLayout3.setVisibility(8);
    }
    if (this.q <= 2) {
      localRelativeLayout2.setVisibility(8);
    }
    if (this.q <= 1) {
      localRelativeLayout1.setVisibility(8);
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt >= this.o.length) {
      return;
    }
    this.s = paramInt;
    int i1 = 0;
    while (i1 < this.o.length)
    {
      this.o[i1].setImageResource(R.drawable.mg_liveness_num_gry);
      i1 += 1;
    }
    this.o[paramInt].setImageResource(R.drawable.mg_liveness_num_green);
  }
  
  private void b(String paramString)
  {
    if ((paramString.equals("DATA_SOURCE_ERROR")) || (paramString.startsWith("NO_FACE_FOUND")) || (paramString.equals("IDCARD_NO_PHOTO")))
    {
      a("failed", 11);
      return;
    }
    if ((paramString.equals("FAKE_FACE")) || (paramString.equals("CONFIDENCE_TOO_LOW")) || (paramString.equals("TOO_MANY_RETRIES")) || (paramString.equals("LIVENESS_FAILED")))
    {
      a("failed", 1);
      return;
    }
    if (paramString.equals("INVALID_BUNDLEID"))
    {
      a("failed", 10);
      return;
    }
    if (paramString.equals("CANNOT_GET_MERCHANT_INFO"))
    {
      a("failed", 9);
      return;
    }
    if (paramString.startsWith("VERIFY_INTERNAL_ERROR"))
    {
      a("failed", 12);
      return;
    }
    if (paramString.equals("UNKNOWN_BIZNO"))
    {
      a("failed", 9);
      return;
    }
    if (paramString.equals("USERINFO_FORMAT_ERROR"))
    {
      a("failed", 15);
      return;
    }
    a("failed", 1);
  }
  
  private void c()
  {
    this.e = new Detector(this, new DetectionConfig.Builder().build());
    if (!this.e.init(this, com.megvii.zhimasdk.d.b.a(this), "")) {
      this.j.a("检测器初始化失败", false);
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        MGLivenessDetectActivity.b(MGLivenessDetectActivity.this).a();
      }
    }).start();
    if (this.a.r) {
      this.g.postDelayed(new Runnable()
      {
        public void run()
        {
          MGLivenessDetectActivity.a(MGLivenessDetectActivity.this, true);
        }
      }, 2500L);
    }
  }
  
  private void d()
  {
    if (this.l) {
      return;
    }
    this.l = true;
    com.megvii.zhimasdk.d.a.a(this.a, "PASS_MIRROR");
    Animation localAnimation1 = AnimationUtils.loadAnimation(this, R.anim.mg_liveness_rightin);
    Animation localAnimation2 = AnimationUtils.loadAnimation(this, R.anim.mg_liveness_leftout);
    this.d.startAnimation(localAnimation2);
    this.p.setVisibility(0);
    this.i.a[0].setVisibility(0);
    this.i.a[0].startAnimation(localAnimation1);
    this.g.post(this.t);
  }
  
  private void e()
  {
    if (this.f.a == null) {
      return;
    }
    this.c.setVisibility(4);
    this.i.a(this.a.s);
    this.v = 0;
    this.e.reset();
    this.e.changeDetectionType((Detector.DetectionType)this.i.c.get(0));
  }
  
  private void f()
  {
    if (j.a()) {
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          if (MGLivenessDetectActivity.d(MGLivenessDetectActivity.this) == null) {
            MGLivenessDetectActivity.e(MGLivenessDetectActivity.this).a("打开摄像头失败", true);
          }
        }
      }, 500L);
    }
  }
  
  private void g()
  {
    if (!this.w) {
      return;
    }
    this.f.a(this.b.getSurfaceTexture());
  }
  
  private void h()
  {
    if ((!this.y) && (this.c.getVisibility() != 0))
    {
      this.y = true;
      this.a.q = true;
      this.a.b = 0;
      com.megvii.zhimasdk.d.a.a(this.a, "CANCEL_LIVENESS");
      i();
    }
  }
  
  private void i()
  {
    startActivity(new Intent(this, MGWebViewActivity.class).putExtra("infobean", this.a));
    overridePendingTransition(R.anim.mg_slide_in_right, R.anim.mg_slide_out_right);
    finish();
  }
  
  public void a(int paramInt)
  {
    a("failed", paramInt);
  }
  
  public void a(final long paramLong)
  {
    if (paramLong > 0L) {
      this.g.post(new Runnable()
      {
        public void run()
        {
          MGLivenessDetectActivity.b(MGLivenessDetectActivity.this).a(paramLong);
        }
      });
    }
  }
  
  public void a(Detector.DetectionType paramDetectionType, long paramLong)
  {
    this.i.a(paramDetectionType, paramLong);
    int i1 = this.s + 1;
    this.s = i1;
    b(i1);
    if (this.v == 0)
    {
      this.h.a(this.h.b(paramDetectionType));
      return;
    }
    this.h.a(R.raw.meglive_well_done);
    this.h.a(paramDetectionType);
  }
  
  public void a(List<FaceQualityManager.FaceQualityErrorType> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      d();
    }
    for (;;)
    {
      return;
      paramList = (FaceQualityManager.FaceQualityErrorType)paramList.get(0);
      if (paramList == FaceQualityManager.FaceQualityErrorType.FACE_NOT_FOUND) {
        paramList = "请让我看到您的正脸";
      }
      while (this.u > 10)
      {
        this.u = 0;
        this.k.setText(paramList);
        return;
        if (paramList == FaceQualityManager.FaceQualityErrorType.FACE_POS_DEVIATED) {
          paramList = "请让我看到您的正脸";
        } else if (paramList == FaceQualityManager.FaceQualityErrorType.FACE_NONINTEGRITY) {
          paramList = "请让我看到您的正脸";
        } else if (paramList == FaceQualityManager.FaceQualityErrorType.FACE_TOO_DARK) {
          paramList = "请让光线再亮点";
        } else if (paramList == FaceQualityManager.FaceQualityErrorType.FACE_TOO_BRIGHT) {
          paramList = "请让光线再暗点";
        } else if (paramList == FaceQualityManager.FaceQualityErrorType.FACE_TOO_SMALL) {
          paramList = "请再靠近一些";
        } else if (paramList == FaceQualityManager.FaceQualityErrorType.FACE_TOO_LARGE) {
          paramList = "请再离远一些";
        } else if (paramList == FaceQualityManager.FaceQualityErrorType.FACE_TOO_BLURRY) {
          paramList = "请避免侧光和背光";
        } else if (paramList == FaceQualityManager.FaceQualityErrorType.FACE_OUT_OF_RECT) {
          paramList = "请保持脸在人脸框中";
        } else {
          paramList = "";
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    setContentView(R.layout.mg_livenessdetect_layout);
    a();
    c();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.e != null) {
      this.e.release();
    }
    this.j.a();
    this.i.c();
    this.n.a();
  }
  
  public void onDetectionFailed(Detector.DetectionFailedType paramDetectionFailedType)
  {
    com.megvii.zhimasdk.d.a.a(this.a, com.megvii.zhimasdk.d.a.b(this.v + 1, this.i.a((Detector.DetectionType)this.i.c.get(this.v)) + ":" + paramDetectionFailedType.toString()));
    paramDetectionFailedType = this.e.getFaceIDDataStruct();
    a(false, paramDetectionFailedType.a, paramDetectionFailedType.b);
  }
  
  public Detector.DetectionType onDetectionSuccess(DetectionFrame paramDetectionFrame)
  {
    this.h.b();
    this.v += 1;
    if (this.v >= this.i.c.size())
    {
      this.c.setVisibility(0);
      paramDetectionFrame = this.e.getFaceIDDataStruct();
      a(true, paramDetectionFrame.a, paramDetectionFrame.b);
    }
    for (;;)
    {
      if (this.v <= this.i.c.size()) {
        com.megvii.zhimasdk.d.a.a(this.a, com.megvii.zhimasdk.d.a.a(this.v, this.i.a((Detector.DetectionType)this.i.c.get(this.v - 1))));
      }
      if (this.v < this.i.c.size()) {
        break;
      }
      return Detector.DetectionType.DONE;
      a((Detector.DetectionType)this.i.c.get(this.v), 10L);
    }
    return (Detector.DetectionType)this.i.c.get(this.v);
  }
  
  public void onFrameDetected(long paramLong, DetectionFrame paramDetectionFrame)
  {
    if ((this.r) || (this.n.b()))
    {
      a(paramDetectionFrame);
      a(paramLong);
      return;
    }
    if (this.n.a == 0.0F)
    {
      this.k.setText("请打开手机读取运动数据权限");
      return;
    }
    this.k.setText("请竖直握紧手机");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      h();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.g.removeCallbacksAndMessages(null);
    this.f.b();
    this.h.a();
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.x = paramArrayOfByte;
    paramCamera = paramCamera.getParameters().getPreviewSize();
    int i2 = 360 - this.f.a(this);
    int i1 = i2;
    if (this.f.d == 0) {
      i1 = i2 - 180;
    }
    this.e.doDetection(paramArrayOfByte, paramCamera.width, paramCamera.height, i1);
  }
  
  protected void onResume()
  {
    int i1 = 0;
    super.onResume();
    this.l = false;
    if (!com.megvii.zhimasdk.d.e.c()) {}
    for (;;)
    {
      if (this.f.a(this, i1) != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = this.f.a();
        this.b.setLayoutParams(localLayoutParams);
        this.m = new FaceQualityManager(0.5F, 0.5F);
        this.i.b = -1;
        com.megvii.zhimasdk.d.a.a(this.a, "ENTER_LIVENESS");
        return;
      }
      this.j.a("打开摄像头失败", true);
      return;
      i1 = 1;
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    h();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.w = true;
    g();
    this.e.setDetectionListener(this);
    this.f.a(this);
    f();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.w = false;
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/MGLivenessDetectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */