package com.ziroom.ziroomcustomer.newchat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.hyphenate.util.ImageUtils;

public class j
  extends AsyncTask<Void, Void, Bitmap>
{
  private ProgressBar a;
  private ImageView b;
  private String c;
  private int d;
  private int e;
  private Context f;
  
  public j(Context paramContext, String paramString, ImageView paramImageView, ProgressBar paramProgressBar, int paramInt1, int paramInt2)
  {
    this.f = paramContext;
    this.c = paramString;
    this.b = paramImageView;
    this.a = paramProgressBar;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  protected Bitmap a(Void... paramVarArgs)
  {
    return ImageUtils.decodeScaleImage(this.c, this.d, this.e);
  }
  
  protected void a(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    this.a.setVisibility(4);
    this.b.setVisibility(0);
    if (paramBitmap != null) {
      g.getInstance().put(this.c, paramBitmap);
    }
    for (;;)
    {
      this.b.setImageBitmap(paramBitmap);
      return;
      paramBitmap = BitmapFactory.decodeResource(this.f.getResources(), 2130839725);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    if (ImageUtils.readPictureDegree(this.c) != 0)
    {
      this.a.setVisibility(0);
      this.b.setVisibility(4);
      return;
    }
    this.a.setVisibility(4);
    this.b.setVisibility(0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */