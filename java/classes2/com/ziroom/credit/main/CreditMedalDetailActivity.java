package com.ziroom.credit.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Environment;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.r;
import com.ziroom.commonlib.utils.s;
import com.ziroom.credit.R.drawable;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.b.a;
import com.ziroom.credit.base.CreditBaseActivity;
import com.ziroom.credit.view.MyView;
import com.ziroom.datacenter.remote.responsebody.financial.b.g;
import com.ziroom.router.activityrouter.Routers;
import com.ziroom.threelib.ziroomshare.c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class CreditMedalDetailActivity
  extends CreditBaseActivity
  implements View.OnClickListener, i.b
{
  private static long n = 0L;
  private ImageView d;
  private MyView e;
  private TextView f;
  private Button g;
  private ImageView h;
  private g i;
  private String j;
  private String k;
  private String l;
  private PlatformActionListener m = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      s.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      s.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  
  private Bitmap a(View paramView)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(-1);
    paramView.draw(localCanvas);
    return localBitmap;
  }
  
  public static boolean isFastClick()
  {
    boolean bool = false;
    long l1 = System.currentTimeMillis();
    if (l1 - n >= 1000L) {
      bool = true;
    }
    n = l1;
    return bool;
  }
  
  protected int c()
  {
    return R.layout.credit_activity_medal_detail;
  }
  
  protected void d()
  {
    this.d = ((ImageView)findViewById(R.id.credit_iv_back));
    this.e = ((MyView)findViewById(R.id.credit_ll_content));
    this.f = ((TextView)findViewById(R.id.credit_tv_message));
    this.g = ((Button)findViewById(R.id.credit_tv_get));
    this.h = ((ImageView)findViewById(R.id.credit_iv_share));
    this.d.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
  }
  
  protected i.a e()
  {
    return new j(this);
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public void imageToast()
  {
    Toast localToast;
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      View localView = ((LayoutInflater)getApplicationContext().getSystemService("layout_inflater")).inflate(R.layout.credit_layout_image_toast_dialog, null);
      localToast = Toast.makeText(getApplicationContext(), "领取成功", 0);
      ((TextView)localView.findViewById(R.id.credit_tv_message)).setText("领取成功");
      ((ImageView)localView.findViewById(R.id.credit_iv_image)).setImageResource(R.drawable.credit_zrl_ic_toastdone);
      localToast.setView(localView);
      localToast.setGravity(17, 0, 0);
      if (!(localToast instanceof Toast)) {
        localToast.show();
      }
    }
    else
    {
      return;
    }
    VdsAgent.showToast((Toast)localToast);
  }
  
  protected void initData()
  {
    int i1 = 1;
    Intent localIntent = getIntent();
    String str1;
    String str2;
    if (localIntent != null) {
      if (localIntent.getIntExtra("isGet", 0) == 1)
      {
        str1 = localIntent.getStringExtra("title");
        str2 = localIntent.getStringExtra("remark");
        this.j = localIntent.getStringExtra("medalCode");
        this.k = localIntent.getStringExtra("icon");
      }
    }
    for (;;)
    {
      this.e.setBackgroundResource(R.drawable.credit_zrk_bg_cdt_medal);
      if (i1 == 0)
      {
        this.f.setVisibility(0);
        this.g.setVisibility(4);
        this.f.setText("新的勋章等你来解锁~");
        this.g.setText("点击领取");
        this.e.setLabel(str1);
        this.e.setDes(str2);
        this.g.setBackgroundResource(R.drawable.credit_btn_check_normal_shape_selected_dddddd);
        this.g.setEnabled(false);
        this.h.setVisibility(4);
        this.e.setImageUrl(this.k, this.h);
        return;
        i1 = 0;
        break;
      }
      ((i.a)this.a).getMedalByMedalByCode(this.j);
      this.h.setVisibility(0);
      this.e.setImageUrl(this.k, this.h);
      return;
      str2 = "";
      str1 = "";
      i1 = 0;
    }
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    a.closeAcAnim(this);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i1;
    if (isFastClick())
    {
      i1 = paramView.getId();
      if (i1 != R.id.credit_iv_back) {
        break label28;
      }
      onBackPressed();
    }
    label28:
    do
    {
      do
      {
        return;
        if (i1 == R.id.credit_iv_share)
        {
          if (r.isNull(this.l))
          {
            this.e.post(new Runnable()
            {
              public void run()
              {
                CreditMedalDetailActivity.this.saveImageToGallery(CreditMedalDetailActivity.a(CreditMedalDetailActivity.this, CreditMedalDetailActivity.a(CreditMedalDetailActivity.this)));
                if (r.notNull(CreditMedalDetailActivity.b(CreditMedalDetailActivity.this))) {
                  c.getInstance().sharePic(CreditMedalDetailActivity.this, "", "", "", CreditMedalDetailActivity.b(CreditMedalDetailActivity.this), CreditMedalDetailActivity.c(CreditMedalDetailActivity.this));
                }
              }
            });
            return;
          }
          c.getInstance().sharePic(this, "", "", "", this.l, this.m);
          return;
        }
      } while ((i1 != R.id.credit_tv_get) || (this.i.getType() == 0));
      if (this.i.getIsGet() == 0)
      {
        ((i.a)this.a).getCouponByCode(this.j);
        return;
      }
    } while (this.i.getIsGet() != 1);
    Routers.open(this, "ziroomCustomer://zrRentModule/userCardCoupon");
  }
  
  public void saveImageToGallery(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    File localFile = new File(Environment.getExternalStorageDirectory(), "credit");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    localFile = new File(localFile, System.currentTimeMillis() + ".jpg");
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
      this.l = localFile.getPath();
      localFileOutputStream.flush();
      localFileOutputStream.close();
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
  
  public void setCouponByCode()
  {
    imageToast();
    ((i.a)this.a).getMedalByMedalByCode(this.j);
  }
  
  public void setMedalByMedalByCode(g paramg)
  {
    this.i = paramg;
    this.f.setVisibility(0);
    this.g.setVisibility(0);
    this.e.setLabel(this.i.getTitle());
    this.e.setDes(this.i.getRemark());
    if (this.i.getIsGet() == 0)
    {
      this.f.setText("恭喜你获得自如优惠券礼包");
      this.g.setText("去领取");
    }
    for (;;)
    {
      if (this.i.getType() == 0)
      {
        this.f.setText("正在争取更多奖励");
        this.g.setText("敬请期待");
        this.g.setBackgroundResource(R.drawable.credit_btn_check_normal_shape_selected_dddddd);
      }
      return;
      if (this.i.getIsGet() == 1)
      {
        this.f.setText("恭喜你获得自如优惠券礼包");
        this.g.setText("查看优惠券");
        this.g.setTextColor(Color.parseColor("#444444"));
        this.g.setBackgroundResource(R.drawable.credit_btn_check_normal_shape_unselected_dddddd);
      }
    }
  }
  
  public void setPresenter(i.a parama)
  {
    this.a = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditMedalDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */