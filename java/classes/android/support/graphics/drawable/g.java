package android.support.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public class g
  implements Interpolator
{
  private float[] a;
  private float[] b;
  
  public g(Context paramContext, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    this(paramContext.getResources(), paramContext.getTheme(), paramAttributeSet, paramXmlPullParser);
  }
  
  public g(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, a.l);
    a(paramResources, paramXmlPullParser);
    paramResources.recycle();
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.quadTo(paramFloat1, paramFloat2, 1.0F, 1.0F);
    a(localPath);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0F, 1.0F);
    a(localPath);
  }
  
  private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
  {
    if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData"))
    {
      paramTypedArray = TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "pathData", 4);
      paramXmlPullParser = PathParser.createPathFromPathData(paramTypedArray);
      if (paramXmlPullParser == null) {
        throw new InflateException("The path is null, which is created from " + paramTypedArray);
      }
      a(paramXmlPullParser);
      return;
    }
    if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "controlX1")) {
      throw new InflateException("pathInterpolator requires the controlX1 attribute");
    }
    if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "controlY1")) {
      throw new InflateException("pathInterpolator requires the controlY1 attribute");
    }
    float f1 = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "controlX1", 0, 0.0F);
    float f2 = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "controlY1", 1, 0.0F);
    boolean bool = TypedArrayUtils.hasAttribute(paramXmlPullParser, "controlX2");
    if (bool != TypedArrayUtils.hasAttribute(paramXmlPullParser, "controlY2")) {
      throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
    }
    if (!bool)
    {
      a(f1, f2);
      return;
    }
    a(f1, f2, TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "controlX2", 2, 0.0F), TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "controlY2", 3, 0.0F));
  }
  
  private void a(Path paramPath)
  {
    int j = 0;
    paramPath = new PathMeasure(paramPath, false);
    float f1 = paramPath.getLength();
    int k = Math.min(3000, (int)(f1 / 0.002F) + 1);
    if (k <= 0) {
      throw new IllegalArgumentException("The Path has a invalid length " + f1);
    }
    this.a = new float[k];
    this.b = new float[k];
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < k)
    {
      paramPath.getPosTan(i * f1 / (k - 1), arrayOfFloat, null);
      this.a[i] = arrayOfFloat[0];
      this.b[i] = arrayOfFloat[1];
      i += 1;
    }
    if ((Math.abs(this.a[0]) > 1.0E-5D) || (Math.abs(this.b[0]) > 1.0E-5D) || (Math.abs(this.a[(k - 1)] - 1.0F) > 1.0E-5D) || (Math.abs(this.b[(k - 1)] - 1.0F) > 1.0E-5D)) {
      throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.a[0] + "," + this.b[0] + " end:" + this.a[(k - 1)] + "," + this.b[(k - 1)]);
    }
    f1 = 0.0F;
    i = 0;
    while (j < k)
    {
      float f2 = this.a[i];
      if (f2 < f1) {
        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
      }
      this.a[j] = f2;
      j += 1;
      f1 = f2;
      i += 1;
    }
    if (paramPath.nextContour()) {
      throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
    }
  }
  
  public float getInterpolation(float paramFloat)
  {
    float f = 1.0F;
    if (paramFloat <= 0.0F) {
      f = 0.0F;
    }
    while (paramFloat >= 1.0F) {
      return f;
    }
    int j = 0;
    int i = this.a.length - 1;
    if (i - j > 1)
    {
      int k = (j + i) / 2;
      if (paramFloat < this.a[k]) {
        i = k;
      }
      for (;;)
      {
        break;
        j = k;
      }
    }
    f = this.a[i] - this.a[j];
    if (f == 0.0F) {
      return this.b[j];
    }
    paramFloat = (paramFloat - this.a[j]) / f;
    f = this.b[j];
    return paramFloat * (this.b[i] - f) + f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/graphics/drawable/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */