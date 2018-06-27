package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.UIHandler;
import java.lang.ref.WeakReference;
import java.util.Random;

public class AsyncImageView
  extends ImageView
  implements Handler.Callback, BitmapProcessor.BitmapCallback
{
  private static final int MSG_IMG_GOT = 1;
  private static final Random RND = new Random();
  private Bitmap defaultBm;
  private int defaultRes;
  private int desiredHeight = 0;
  private int desiredWidth = 0;
  private long diskCacheTime = 0L;
  private Bitmap errorBm = null;
  private int errorRes = 0;
  private boolean lastReqIsOk;
  private long maxBytes = 0L;
  private Path path;
  private int quality = 0;
  private float[] rect;
  private WeakReference<AsyncImageView> refAiv = null;
  private Bitmap result;
  private boolean scaleToCrop;
  private String url;
  private boolean useDiskCache = true;
  private boolean useRamCache = true;
  
  public AsyncImageView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private BitmapProcessor.BitmapDesiredOptions getBitmapDesiredOptions()
  {
    BitmapProcessor.BitmapDesiredOptions localBitmapDesiredOptions = null;
    if (((this.desiredWidth > 1) && (this.desiredHeight > 1)) || (this.maxBytes >= 10240L) || (this.quality > 0))
    {
      localBitmapDesiredOptions = new BitmapProcessor.BitmapDesiredOptions();
      localBitmapDesiredOptions.desiredWidth = this.desiredWidth;
      localBitmapDesiredOptions.desiredHeight = this.desiredHeight;
      localBitmapDesiredOptions.maxBytes = this.maxBytes;
      localBitmapDesiredOptions.quality = this.quality;
    }
    return localBitmapDesiredOptions;
  }
  
  private int[] getSize()
  {
    int k = getWidth();
    int m = getHeight();
    int i;
    int j;
    if (k != 0)
    {
      i = m;
      j = k;
      if (m != 0) {}
    }
    else
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      i = m;
      j = k;
      if (localLayoutParams != null)
      {
        j = localLayoutParams.width;
        i = localLayoutParams.height;
      }
    }
    if (j != 0)
    {
      k = i;
      if (i != 0) {}
    }
    else
    {
      measure(0, 0);
      j = getMeasuredWidth();
      k = getMeasuredHeight();
    }
    return new int[] { j, k };
  }
  
  private Bitmap goCrop(Bitmap paramBitmap)
  {
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if ((f1 == 0.0F) || (f2 == 0.0F)) {}
    Object localObject;
    float f3;
    do
    {
      do
      {
        return paramBitmap;
        localObject = getSize();
      } while ((localObject[0] == 0) || (localObject[1] == 0));
      f3 = localObject[1] * f1 / localObject[0];
    } while (f3 == f2);
    int[] arrayOfInt = new int[4];
    if (f3 < f2)
    {
      arrayOfInt[1] = ((int)((f2 - f3) / 2.0F));
      arrayOfInt[3] = arrayOfInt[1];
    }
    for (;;)
    {
      try
      {
        localObject = BitmapHelper.cropBitmap(paramBitmap, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
        return (Bitmap)localObject;
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().w(localThrowable);
      }
      arrayOfInt[0] = ((int)((f1 - f2 * localObject[0] / localObject[1]) / 2.0F));
      arrayOfInt[2] = arrayOfInt[0];
    }
    return paramBitmap;
  }
  
  private void init(Context paramContext)
  {
    if (isInEditMode())
    {
      setBackgroundColor(-16777216);
      return;
    }
    BitmapProcessor.prepare(paramContext);
  }
  
  private void myClip(Canvas paramCanvas)
  {
    if (this.rect != null)
    {
      if (this.path == null)
      {
        int i = getWidth();
        int j = getHeight();
        this.path = new Path();
        RectF localRectF = new RectF(0.0F, 0.0F, i, j);
        this.path.addRoundRect(localRectF, this.rect, Path.Direction.CW);
      }
      paramCanvas.clipPath(this.path);
    }
  }
  
  public void deleteCachedFile(String paramString)
  {
    BitmapProcessor.deleteCachedFile(paramString, getBitmapDesiredOptions());
  }
  
  public void execute(String paramString, int paramInt)
  {
    execute(paramString, paramInt, 0);
  }
  
  public void execute(String paramString, int paramInt1, int paramInt2)
  {
    if (((this.useRamCache) || (this.useDiskCache)) && (this.lastReqIsOk) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.url))) {
      return;
    }
    this.lastReqIsOk = false;
    this.url = paramString;
    this.result = null;
    this.defaultRes = paramInt1;
    this.errorRes = paramInt2;
    if (TextUtils.isEmpty(paramString))
    {
      if (paramInt2 == 0) {}
      for (;;)
      {
        setImageResource(paramInt1);
        return;
        paramInt1 = paramInt2;
      }
    }
    BitmapProcessor.BitmapDesiredOptions localBitmapDesiredOptions = getBitmapDesiredOptions();
    if (this.useRamCache)
    {
      Bitmap localBitmap = BitmapProcessor.getBitmapFromCache(paramString, localBitmapDesiredOptions);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        setBitmap(localBitmap);
        this.lastReqIsOk = true;
        return;
      }
    }
    if (paramInt1 > 0) {
      setImageResource(paramInt1);
    }
    if ((this.refAiv == null) || (this.refAiv.get() == null)) {
      this.refAiv = new WeakReference(this);
    }
    BitmapProcessor.process(paramString, localBitmapDesiredOptions, this.useRamCache, this.useDiskCache, this.diskCacheTime, this);
  }
  
  public void execute(String paramString, Bitmap paramBitmap)
  {
    execute(paramString, paramBitmap, null);
  }
  
  public void execute(String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (((this.useRamCache) || (this.useDiskCache)) && (this.lastReqIsOk) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.url))) {
      return;
    }
    this.lastReqIsOk = false;
    this.url = paramString;
    this.result = null;
    this.defaultBm = paramBitmap1;
    this.errorBm = paramBitmap2;
    if (TextUtils.isEmpty(paramString))
    {
      if (paramBitmap2 == null) {}
      for (;;)
      {
        setImageBitmap(paramBitmap1);
        return;
        paramBitmap1 = paramBitmap2;
      }
    }
    paramBitmap2 = getBitmapDesiredOptions();
    if (this.useRamCache)
    {
      Bitmap localBitmap = BitmapProcessor.getBitmapFromCache(paramString, paramBitmap2);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        setBitmap(localBitmap);
        this.lastReqIsOk = true;
        return;
      }
    }
    if ((paramBitmap1 != null) && (!paramBitmap1.isRecycled())) {
      setImageBitmap(paramBitmap1);
    }
    if ((this.refAiv == null) || (this.refAiv.get() == null)) {
      this.refAiv = new WeakReference(this);
    }
    BitmapProcessor.process(paramString, paramBitmap2, this.useRamCache, this.useDiskCache, this.diskCacheTime, this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what != 1) || (this.refAiv == null) || (this.refAiv.get() == null)) {
      return false;
    }
    try
    {
      Object localObject = ((Object[])(Object[])paramMessage.obj)[0];
      paramMessage = ((Object[])(Object[])paramMessage.obj)[1];
      if ((paramMessage != null) && (localObject != null) && (localObject.equals(this.url)))
      {
        this.result = ((Bitmap)paramMessage);
        ((AsyncImageView)this.refAiv.get()).setImageBitmap(this.result);
        this.lastReqIsOk = true;
        return false;
      }
    }
    catch (Throwable paramMessage)
    {
      MobLog.getInstance().d(paramMessage);
      return false;
    }
    if (this.errorRes > 0)
    {
      ((AsyncImageView)this.refAiv.get()).setImageResource(this.errorRes);
      return false;
    }
    if ((this.errorBm != null) && (!this.errorBm.isRecycled()))
    {
      ((AsyncImageView)this.refAiv.get()).setImageBitmap(this.errorBm);
      return false;
    }
    if ((this.defaultBm != null) && (!this.defaultBm.isRecycled()))
    {
      ((AsyncImageView)this.refAiv.get()).setImageBitmap(this.defaultBm);
      return false;
    }
    ((AsyncImageView)this.refAiv.get()).setImageResource(this.defaultRes);
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {}
    while ((getDrawable().getIntrinsicWidth() == 0) || (getDrawable().getIntrinsicHeight() == 0)) {
      return;
    }
    Matrix localMatrix = getImageMatrix();
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = paramCanvas.getSaveCount();
    paramCanvas.save();
    if (this.result != null)
    {
      myClip(paramCanvas);
      paramCanvas.drawBitmap(this.result, localMatrix, new Paint(6));
    }
    for (;;)
    {
      paramCanvas.restoreToCount(k);
      return;
      if ((localMatrix != null) || (i != 0) || (j != 0))
      {
        if ((Build.VERSION.SDK_INT >= 16) && (getCropToPadding()))
        {
          int m = getScrollX();
          int n = getScrollY();
          paramCanvas.clipRect(m + i, n + j, m + getRight() - getLeft() - getPaddingRight(), n + getBottom() - getTop() - getPaddingBottom());
        }
        paramCanvas.translate(i, j);
        if (localMatrix != null) {
          paramCanvas.concat(localMatrix);
        }
      }
      getDrawable().draw(paramCanvas);
    }
  }
  
  public void onImageGot(String paramString, Bitmap paramBitmap)
  {
    if ((this.refAiv == null) || (this.refAiv.get() == null)) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.trim().length() > 0)
      {
        localObject1 = localObject2;
        if (paramString.equals(this.url)) {
          localObject1 = paramBitmap;
        }
      }
    }
    paramBitmap = (Bitmap)localObject1;
    if (localObject1 != null)
    {
      paramBitmap = (Bitmap)localObject1;
      if (this.scaleToCrop) {
        paramBitmap = goCrop((Bitmap)localObject1);
      }
    }
    localObject1 = new Message();
    ((Message)localObject1).what = 1;
    ((Message)localObject1).obj = new Object[] { paramString, paramBitmap };
    UIHandler.sendMessageDelayed((Message)localObject1, RND.nextInt(300), this);
  }
  
  public void removeRamCache(String paramString)
  {
    if (this.useRamCache) {
      BitmapProcessor.removeBitmapFromRamCache(paramString, getBitmapDesiredOptions());
    }
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (this.scaleToCrop) {
      localBitmap = goCrop(paramBitmap);
    }
    setImageBitmap(localBitmap);
    this.result = localBitmap;
  }
  
  public void setCompressOptions(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.desiredWidth = paramInt1;
    this.desiredHeight = paramInt2;
    this.quality = paramInt3;
    this.maxBytes = paramLong;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    MobLog.getInstance().w(new RuntimeException("Not Support"));
  }
  
  public void setRound(float paramFloat)
  {
    setRound(paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public void setRound(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.rect = new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, paramFloat4, paramFloat4 };
  }
  
  public void setScaleToCropCenter(boolean paramBoolean)
  {
    this.scaleToCrop = paramBoolean;
  }
  
  public void setUseCacheOption(boolean paramBoolean1, boolean paramBoolean2)
  {
    setUseCacheOption(paramBoolean1, paramBoolean2, 0L);
  }
  
  public void setUseCacheOption(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    this.useRamCache = paramBoolean1;
    this.useDiskCache = paramBoolean2;
    if (paramBoolean2) {
      this.diskCacheTime = paramLong;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/gui/AsyncImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */