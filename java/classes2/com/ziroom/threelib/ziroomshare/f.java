package com.ziroom.threelib.ziroomshare;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class f
  extends b
{
  public static c.a a;
  private c b;
  private TextView c;
  private GridView d;
  private Map<Integer, b> e = new HashMap();
  private int f = 100;
  private Bitmap g;
  private Context h;
  private PlatformActionListener i = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
    {
      Log.d("#########分享取消回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享取消");
    }
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      f.this.showToast("分享成功");
      paramAnonymousHashMap = new StringBuilder();
      if (f.g(f.this) == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("#########分享完成回调: 平台  ", bool + "=====" + paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功");
        return;
      }
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      f.this.showToast("分享失败");
      Log.d("#########分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  
  public f(c paramc)
  {
    super((Context)c.a(paramc).get(), R.style.UnifiedZiroomDialogTheme);
    setContentView(R.layout.share_dialog_share_center);
    this.b = paramc;
    if (this.b == null) {
      return;
    }
    if (this.b.getOnPlatformClickListener() != null) {
      a = this.b.getOnPlatformClickListener();
    }
    this.h = ((Context)c.a(this.b).get());
    if (this.h != null)
    {
      b();
      a();
      return;
    }
    dismiss();
  }
  
  private void a()
  {
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        f.this.dismiss();
      }
    });
  }
  
  private void a(String paramString)
  {
    if (d.isNull(paramString)) {
      return;
    }
    d.getLocalOrNetBitmap(paramString, new d.a()
    {
      public void OnBitmapOver(Bitmap paramAnonymousBitmap)
      {
        if (paramAnonymousBitmap != null)
        {
          if (paramAnonymousBitmap.getRowBytes() * paramAnonymousBitmap.getHeight() > 25600) {
            f.a(f.this, d.zoomImage(paramAnonymousBitmap));
          }
        }
        else {
          return;
        }
        f.a(f.this, paramAnonymousBitmap);
      }
    });
  }
  
  private void b()
  {
    this.c = ((TextView)findViewById(R.id.btn_cancel));
    this.d = ((GridView)findViewById(R.id.gv));
    List localList = c();
    this.d.setAdapter(new a(localList));
    if (c.b(this.b)) {
      setCanceledOnTouchOutside(c.c(this.b));
    }
  }
  
  private static void b(int paramInt)
  {
    if (a != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a.onPlatformClick(ShareSDK.getPlatform(QQ.NAME));
      return;
    case 2: 
      a.onPlatformClick(ShareSDK.getPlatform(Wechat.NAME));
      return;
    case 4: 
      a.onPlatformClick(ShareSDK.getPlatform(SinaWeibo.NAME));
      return;
    case 8: 
      a.onPlatformClick(ShareSDK.getPlatform(WechatMoments.NAME));
      return;
    }
    a.onPlatformClick(ShareSDK.getPlatform(QZone.NAME));
  }
  
  private List<Integer> c()
  {
    int j = this.b.getFlag();
    if ((((j & 0x2) != 0) || ((j & 0x8) != 0)) && (!TextUtils.isEmpty(this.b.getSharePicUrl()))) {
      a(this.b.getSharePicUrl());
    }
    ArrayList localArrayList = new ArrayList();
    if ((j & 0x2) != 0) {
      localArrayList.add(Integer.valueOf(2));
    }
    if ((j & 0x8) != 0) {
      localArrayList.add(Integer.valueOf(8));
    }
    if ((j & 0x1) != 0) {
      localArrayList.add(Integer.valueOf(1));
    }
    if ((j & 0x10) != 0) {
      localArrayList.add(Integer.valueOf(16));
    }
    if ((j & 0x4) != 0) {
      localArrayList.add(Integer.valueOf(4));
    }
    return localArrayList;
  }
  
  private void d()
  {
    Platform.ShareParams localShareParams = new Platform.ShareParams();
    localShareParams.setTitle(this.b.getShareTitle());
    localShareParams.setText(this.b.getShareContent());
    Object localObject2;
    Object localObject1;
    if (TextUtils.isEmpty(this.b.getSharePicUrlLocal()))
    {
      localObject2 = null;
      if (this.g != null)
      {
        localObject1 = this.g;
        localShareParams.setImageData((Bitmap)localObject1);
        localShareParams.setShareType(4);
        localShareParams.setUrl(this.b.getShareUrl());
        label78:
        localObject1 = ShareSDK.getPlatform(Wechat.NAME);
        if (this.b.getPlatformActionListener() == null) {
          break label192;
        }
        ((Platform)localObject1).setPlatformActionListener(this.b.getPlatformActionListener());
      }
    }
    for (;;)
    {
      ((Platform)localObject1).share(localShareParams);
      return;
      localObject1 = localObject2;
      if (this.h == null) {
        break;
      }
      localObject1 = localObject2;
      if (this.b.getLocalIcon() == null) {
        break;
      }
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = BitmapFactory.decodeResource(this.h.getResources(), this.b.getLocalIcon().intValue(), (BitmapFactory.Options)localObject1);
      break;
      localShareParams.setImagePath(this.b.getSharePicUrlLocal());
      localShareParams.setShareType(2);
      break label78;
      label192:
      ((Platform)localObject1).setPlatformActionListener(this.i);
    }
  }
  
  private void e()
  {
    Platform.ShareParams localShareParams = new Platform.ShareParams();
    localShareParams.setTitle(this.b.getShareTitle());
    localShareParams.setText(this.b.getShareContent());
    Object localObject2;
    Object localObject1;
    if (TextUtils.isEmpty(this.b.getSharePicUrlLocal()))
    {
      localObject2 = null;
      if (this.g != null)
      {
        localObject1 = this.g;
        localShareParams.setUrl(this.b.getShareUrl());
        localShareParams.setImageData((Bitmap)localObject1);
        localShareParams.setShareType(4);
        label78:
        localObject1 = ShareSDK.getPlatform(WechatMoments.NAME);
        if (this.b.getPlatformActionListener() == null) {
          break label192;
        }
        ((Platform)localObject1).setPlatformActionListener(this.b.getPlatformActionListener());
      }
    }
    for (;;)
    {
      ((Platform)localObject1).share(localShareParams);
      return;
      localObject1 = localObject2;
      if (this.h == null) {
        break;
      }
      localObject1 = localObject2;
      if (this.b.getLocalIcon() == null) {
        break;
      }
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = BitmapFactory.decodeResource(this.h.getResources(), this.b.getLocalIcon().intValue(), (BitmapFactory.Options)localObject1);
      break;
      localShareParams.setImagePath(this.b.getSharePicUrlLocal());
      localShareParams.setShareType(2);
      break label78;
      label192:
      ((Platform)localObject1).setPlatformActionListener(this.i);
    }
  }
  
  private void f()
  {
    Platform.ShareParams localShareParams = new Platform.ShareParams();
    localShareParams.setTitle(this.b.getShareTitle());
    localShareParams.setTitleUrl(this.b.getShareUrl());
    localShareParams.setImageUrl(this.b.getSharePicUrl());
    localShareParams.setText(this.b.getShareContent());
    if (!TextUtils.isEmpty(this.b.getSharePicUrlLocal())) {
      localShareParams.setImagePath(this.b.getSharePicUrlLocal());
    }
    Platform localPlatform = ShareSDK.getPlatform(QQ.NAME);
    if (this.b.getPlatformActionListener() != null) {
      localPlatform.setPlatformActionListener(this.b.getPlatformActionListener());
    }
    for (;;)
    {
      localPlatform.share(localShareParams);
      return;
      localPlatform.setPlatformActionListener(this.i);
    }
  }
  
  private void g()
  {
    Platform.ShareParams localShareParams = new Platform.ShareParams();
    localShareParams.setTitle(this.b.getShareTitle());
    localShareParams.setTitleUrl(this.b.getShareUrl());
    localShareParams.setText(this.b.getShareContent());
    localShareParams.setImageUrl(this.b.getSharePicUrl());
    localShareParams.setSite("自如");
    localShareParams.setSiteUrl("www.ziroom.com");
    if (!TextUtils.isEmpty(this.b.getSharePicUrlLocal())) {
      localShareParams.setImagePath(this.b.getSharePicUrlLocal());
    }
    Platform localPlatform = ShareSDK.getPlatform(QZone.NAME);
    if (this.b.getPlatformActionListener() != null) {
      localPlatform.setPlatformActionListener(this.b.getPlatformActionListener());
    }
    for (;;)
    {
      localPlatform.share(localShareParams);
      return;
      localPlatform.setPlatformActionListener(this.i);
    }
  }
  
  private void h()
  {
    Platform.ShareParams localShareParams = new Platform.ShareParams();
    localShareParams.setText(this.b.getShareTitle() + " " + this.b.getShareContent() + " " + this.b.getShareUrl());
    localShareParams.setImageUrl(this.b.getSharePicUrl());
    if (!TextUtils.isEmpty(this.b.getSharePicUrlLocal())) {
      localShareParams.setImagePath(this.b.getSharePicUrlLocal());
    }
    Platform localPlatform = ShareSDK.getPlatform(SinaWeibo.NAME);
    if (this.b.getPlatformActionListener() != null) {
      localPlatform.setPlatformActionListener(this.b.getPlatformActionListener());
    }
    for (;;)
    {
      localPlatform.share(localShareParams);
      return;
      localPlatform.setPlatformActionListener(this.i);
    }
  }
  
  public static c newBuilder(Context paramContext)
  {
    return new c(paramContext, null);
  }
  
  public f addShareItem(int paramInt1, int paramInt2, String paramString, View.OnClickListener paramOnClickListener)
  {
    List localList = c();
    int j = this.f;
    this.f = (j + 1);
    localList.add(paramInt1, Integer.valueOf(j));
    this.e.put(Integer.valueOf(paramInt1), new b(paramInt2, paramString, paramOnClickListener));
    this.d.setAdapter(new a(localList));
    return this;
  }
  
  public f addShareItem(int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    List localList = c();
    int j = this.f;
    this.f = (j + 1);
    localList.add(Integer.valueOf(j));
    this.e.put(Integer.valueOf(localList.size() - 1), new b(paramInt, paramString, paramOnClickListener));
    this.d.setAdapter(new a(localList));
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    MobSDK.init(getContext().getApplicationContext());
  }
  
  private class a
    extends BaseAdapter
  {
    private List<Integer> b;
    private LayoutInflater c;
    
    public a()
    {
      List localList;
      this.b = localList;
      this.c = LayoutInflater.from(f.this.getContext());
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
      paramView = (TextView)this.c.inflate(R.layout.share_item_share, paramViewGroup, false);
      paramViewGroup = (Integer)getItem(paramInt);
      if (paramViewGroup != null) {}
      switch (paramViewGroup.intValue())
      {
      default: 
        paramViewGroup = (f.b)f.f(f.this).get(Integer.valueOf(paramInt));
        if (paramViewGroup != null)
        {
          paramView.setText(paramViewGroup.getIconTitle());
          Drawable localDrawable = f.this.getContext().getResources().getDrawable(((f.b)f.f(f.this).get(Integer.valueOf(paramInt))).getIconResId());
          localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
          paramView.setCompoundDrawables(null, localDrawable, null, null);
          paramView.setOnClickListener(paramViewGroup.getOnClickListener());
        }
        return paramView;
      case 2: 
        paramView.setText("微信");
        paramViewGroup = f.this.getContext().getResources().getDrawable(R.drawable.share_zrk_share_wechat);
        paramViewGroup.setBounds(0, 0, paramViewGroup.getIntrinsicWidth(), paramViewGroup.getIntrinsicHeight());
        paramView.setCompoundDrawables(null, paramViewGroup, null, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            f.a(f.this);
            f.this.dismiss();
            f.a(2);
          }
        });
        return paramView;
      case 8: 
        paramView.setText("朋友圈");
        paramViewGroup = f.this.getContext().getResources().getDrawable(R.drawable.share_zrk_share_pyq);
        paramViewGroup.setBounds(0, 0, paramViewGroup.getIntrinsicWidth(), paramViewGroup.getIntrinsicHeight());
        paramView.setCompoundDrawables(null, paramViewGroup, null, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            f.b(f.this);
            f.this.dismiss();
            f.a(8);
          }
        });
        return paramView;
      case 1: 
        paramView.setText("QQ");
        paramViewGroup = f.this.getContext().getResources().getDrawable(R.drawable.share_zrk_share_qq);
        paramViewGroup.setBounds(0, 0, paramViewGroup.getIntrinsicWidth(), paramViewGroup.getIntrinsicHeight());
        paramView.setCompoundDrawables(null, paramViewGroup, null, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            f.c(f.this);
            f.this.dismiss();
            f.a(1);
          }
        });
        return paramView;
      case 16: 
        paramView.setText("QQ空间");
        paramViewGroup = f.this.getContext().getResources().getDrawable(R.drawable.share_zrk_share_zone);
        paramViewGroup.setBounds(0, 0, paramViewGroup.getIntrinsicWidth(), paramViewGroup.getIntrinsicHeight());
        paramView.setCompoundDrawables(null, paramViewGroup, null, null);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            f.d(f.this);
            f.this.dismiss();
            f.a(16);
          }
        });
        return paramView;
      }
      paramView.setText("新浪微博");
      paramViewGroup = f.this.getContext().getResources().getDrawable(R.drawable.share_zrk_share_blog);
      paramViewGroup.setBounds(0, 0, paramViewGroup.getIntrinsicWidth(), paramViewGroup.getIntrinsicHeight());
      paramView.setCompoundDrawables(null, paramViewGroup, null, null);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          f.e(f.this);
          f.this.dismiss();
          f.a(4);
        }
      });
      return paramView;
    }
  }
  
  public static class b
  {
    private int a;
    private String b;
    private View.OnClickListener c;
    
    public b(int paramInt, String paramString, View.OnClickListener paramOnClickListener)
    {
      this.a = paramInt;
      this.b = paramString;
      this.c = paramOnClickListener;
    }
    
    public int getIconResId()
    {
      return this.a;
    }
    
    public String getIconTitle()
    {
      return this.b;
    }
    
    public View.OnClickListener getOnClickListener()
    {
      return this.c;
    }
    
    public void setIconResId(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void setIconTitle(String paramString)
    {
      this.b = paramString;
    }
    
    public void setOnClickListener(View.OnClickListener paramOnClickListener)
    {
      this.c = paramOnClickListener;
    }
  }
  
  public static class c
  {
    private WeakReference<Context> a;
    private int b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private PlatformActionListener j;
    private int k;
    private c.a l;
    
    private c(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }
    
    public f build()
    {
      return new f(this);
    }
    
    public int getFlag()
    {
      return this.b;
    }
    
    public Integer getLocalIcon()
    {
      return Integer.valueOf(this.k);
    }
    
    public c.a getOnPlatformClickListener()
    {
      return this.l;
    }
    
    public PlatformActionListener getPlatformActionListener()
    {
      return this.j;
    }
    
    public String getShareContent()
    {
      return this.e;
    }
    
    public String getSharePicUrl()
    {
      return this.f;
    }
    
    public String getSharePicUrlLocal()
    {
      return this.g;
    }
    
    public String getShareTitle()
    {
      return this.d;
    }
    
    public String getShareUrl()
    {
      return this.c;
    }
    
    public c setCanceledOnTouchOutside(boolean paramBoolean)
    {
      this.i = true;
      this.h = paramBoolean;
      return this;
    }
    
    public c setFlag(int paramInt)
    {
      this.b = paramInt;
      return this;
    }
    
    public c setLocalIcon(int paramInt)
    {
      this.k = paramInt;
      return this;
    }
    
    public c setOnPlatformClickListener(c.a parama)
    {
      this.l = parama;
      return this;
    }
    
    public c setPlatformActionListener(PlatformActionListener paramPlatformActionListener)
    {
      this.j = paramPlatformActionListener;
      return this;
    }
    
    public c setShareContent(String paramString)
    {
      this.e = paramString;
      return this;
    }
    
    public c setSharePicUrl(String paramString)
    {
      this.f = paramString;
      return this;
    }
    
    public c setSharePicUrlLocal(String paramString)
    {
      this.g = paramString;
      return this;
    }
    
    public c setShareTitle(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public c setShareUrl(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public void show()
    {
      new f(this).show();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/threelib/ziroomshare/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */