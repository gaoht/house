package com.megvii.livenessdetection.a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
{
  public PointF[] A;
  public boolean B = false;
  public Rect a;
  public RectF b;
  public float c = 0.0F;
  public float d = 0.0F;
  public float e = 0.0F;
  public float f = 0.0F;
  public float g = 0.0F;
  public float h = 0.0F;
  public float i = 0.0F;
  public float j = 0.0F;
  public float k = 0.0F;
  public float l = 0.0F;
  public float m = 0.0F;
  public boolean n = false;
  public boolean o = false;
  public boolean p = false;
  public boolean q = false;
  public float r = 0.0F;
  public float s = 0.0F;
  public float t = 0.0F;
  public float u = 0.0F;
  public float v = 0.0F;
  public float w = 0.0F;
  public float x = 0.0F;
  public float y = 0.0F;
  public float z = 0.0F;
  
  public String toString()
  {
    return "FaceInfo{faceSize=" + this.a.toShortString() + ", position=" + this.b.toShortString() + ", yaw=" + this.c + ", pitch=" + this.d + ", gaussianBlur=" + this.e + ", motionBlur=" + this.f + ", brightness=" + this.g + ", wearGlass=" + this.h + ", faceQuality=" + this.i + ", leftEyeHWRatio=" + this.j + ", rightEyeHWRatio=" + this.k + ", mouthHWRatio=" + this.l + '}';
  }
  
  public static class a
  {
    public static b a(String paramString)
    {
      int i = 0;
      try
      {
        paramString = new JSONObject(paramString);
        if ((paramString.has("has_face")) && (paramString.getBoolean("has_face")))
        {
          b localb = new b();
          Object localObject1 = paramString.getJSONObject("pos");
          localb.d = ((float)((JSONObject)localObject1).getDouble("pitch"));
          localb.c = ((float)((JSONObject)localObject1).getDouble("yaw"));
          localObject1 = paramString.getJSONArray("facerect");
          Object localObject2 = new RectF();
          ((RectF)localObject2).left = ((float)((JSONArray)localObject1).getDouble(0));
          ((RectF)localObject2).top = ((float)((JSONArray)localObject1).getDouble(1));
          ((RectF)localObject2).right = ((float)((JSONArray)localObject1).getDouble(2));
          ((RectF)localObject2).bottom = ((float)((JSONArray)localObject1).getDouble(3));
          localb.b = ((RectF)localObject2);
          localb.g = ((float)paramString.getDouble("brightness"));
          localb.f = ((float)paramString.getJSONObject("blurness").getDouble("motion"));
          localb.e = ((float)paramString.getJSONObject("blurness").getDouble("gaussian"));
          localb.h = ((float)paramString.getDouble("wearglass"));
          localb.n = paramString.getBoolean("pitch3d");
          paramString.getDouble("eye_hwratio");
          localb.l = ((float)paramString.getDouble("mouth_hwratio"));
          localb.j = ((float)paramString.getDouble("eye_left_hwratio"));
          localb.k = ((float)paramString.getDouble("eye_right_hwratio"));
          localb.m = ((float)paramString.getDouble("integrity"));
          localObject1 = new Rect();
          ((Rect)localObject1).left = 0;
          ((Rect)localObject1).top = 0;
          ((Rect)localObject1).right = ((int)paramString.getDouble("real_width"));
          ((Rect)localObject1).bottom = ((int)paramString.getDouble("real_height"));
          localb.a = ((Rect)localObject1);
          localb.r = ((float)paramString.getDouble("smooth_yaw"));
          localb.s = ((float)paramString.getDouble("smooth_pitch"));
          localb.o = paramString.getBoolean("not_video");
          localb.q = paramString.getBoolean("eye_blink");
          localb.p = paramString.getBoolean("mouth_open");
          localb.t = ((float)paramString.getDouble("eye_left_det"));
          localb.u = ((float)paramString.getDouble("eye_right_det"));
          localb.v = ((float)paramString.getDouble("mouth_det"));
          localb.i = ((float)paramString.getDouble("quality"));
          localb.x = ((float)paramString.getDouble("eye_left_occlusion"));
          localb.y = ((float)paramString.getDouble("eye_right_occlusion"));
          localb.z = ((float)paramString.getDouble("mouth_occlusion"));
          localObject1 = paramString.getJSONArray("landmark");
          if (((JSONArray)localObject1).length() % 2 == 0)
          {
            localb.A = new PointF[((JSONArray)localObject1).length() / 2];
            while (i < ((JSONArray)localObject1).length() / 2)
            {
              localObject2 = new PointF();
              ((PointF)localObject2).x = ((float)((JSONArray)localObject1).getDouble(i << 1));
              ((PointF)localObject2).y = ((float)((JSONArray)localObject1).getDouble((i << 1) + 1));
              localb.A[i] = localObject2;
              i += 1;
            }
          }
          localb.B = paramString.getBoolean("face_too_large");
          return localb;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      return null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/livenessdetection/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */