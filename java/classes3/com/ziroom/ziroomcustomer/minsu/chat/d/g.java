package com.ziroom.ziroomcustomer.minsu.chat.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.TextView;
import com.hyphenate.util.ImageUtils;
import com.ziroom.ziroomcustomer.minsu.chat.photoview.MinsuChatPhotoView;

public class g
  extends AsyncTask<Void, Void, Bitmap>
{
  private TextView a;
  private MinsuChatPhotoView b;
  private String c;
  private int d;
  private int e;
  private Context f;
  
  public g(Context paramContext, String paramString, MinsuChatPhotoView paramMinsuChatPhotoView, TextView paramTextView, int paramInt1, int paramInt2)
  {
    this.f = paramContext;
    this.c = paramString;
    this.b = paramMinsuChatPhotoView;
    this.a = paramTextView;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  protected Bitmap a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = ImageUtils.decodeScaleImage(this.c, this.d, this.e);
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    Object localObject = this.b.getTag(2131689523);
    if ((localObject == null) || ((localObject != null) && (String.valueOf(localObject).equals(this.c))))
    {
      this.a.setVisibility(4);
      this.b.setVisibility(0);
      if (paramBitmap == null) {
        break label78;
      }
      e.getInstance().put(this.c, paramBitmap);
    }
    for (;;)
    {
      this.b.setImageBitmap(paramBitmap);
      return;
      label78:
      paramBitmap = BitmapFactory.decodeResource(this.f.getResources(), 2130838350);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */