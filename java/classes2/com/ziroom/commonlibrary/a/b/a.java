package com.ziroom.commonlibrary.a.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.freelxl.baselibrary.f.d;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class a
  extends com.freelxl.baselibrary.d.f.a<Bitmap>
{
  protected Bitmap a(Response paramResponse)
    throws Exception
  {
    d.d("BitmapParser", "=====url:" + paramResponse.request().url().toString());
    if (paramResponse.isSuccessful()) {
      return BitmapFactory.decodeStream(paramResponse.body().byteStream());
    }
    throw new com.freelxl.baselibrary.d.d.a(paramResponse.code());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */