package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion
  extends PathMotion
{
  private Path a;
  private final Path b = new Path();
  private final Matrix c = new Matrix();
  
  public PatternPathMotion()
  {
    this.b.lineTo(1.0F, 0.0F);
    this.a = this.b;
  }
  
  public PatternPathMotion(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ab.k);
    try
    {
      paramAttributeSet = TypedArrayUtils.getNamedString(paramContext, (XmlPullParser)paramAttributeSet, "patternPathData", 0);
      if (paramAttributeSet == null) {
        throw new RuntimeException("pathData must be supplied for patternPathMotion");
      }
    }
    finally
    {
      paramContext.recycle();
    }
    setPatternPath(PathParser.createPathFromPathData(paramAttributeSet));
    paramContext.recycle();
  }
  
  public PatternPathMotion(Path paramPath)
  {
    setPatternPath(paramPath);
  }
  
  private static float a(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat3 -= paramFloat1;
    paramFloat4 -= paramFloat2;
    float f = a(paramFloat3, paramFloat4);
    double d = Math.atan2(paramFloat4, paramFloat3);
    this.c.setScale(f, f);
    this.c.postRotate((float)Math.toDegrees(d));
    this.c.postTranslate(paramFloat1, paramFloat2);
    Path localPath = new Path();
    this.b.transform(this.c, localPath);
    return localPath;
  }
  
  public Path getPatternPath()
  {
    return this.a;
  }
  
  public void setPatternPath(Path paramPath)
  {
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f1 = localPathMeasure.getLength();
    float[] arrayOfFloat = new float[2];
    localPathMeasure.getPosTan(f1, arrayOfFloat, null);
    float f3 = arrayOfFloat[0];
    f1 = arrayOfFloat[1];
    localPathMeasure.getPosTan(0.0F, arrayOfFloat, null);
    float f4 = arrayOfFloat[0];
    float f2 = arrayOfFloat[1];
    if ((f4 == f3) && (f2 == f1)) {
      throw new IllegalArgumentException("pattern must not end at the starting point");
    }
    this.c.setTranslate(-f4, -f2);
    f3 -= f4;
    f1 -= f2;
    f2 = 1.0F / a(f3, f1);
    this.c.postScale(f2, f2);
    double d = Math.atan2(f1, f3);
    this.c.postRotate((float)Math.toDegrees(-d));
    paramPath.transform(this.c, this.b);
    this.a = paramPath;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/PatternPathMotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */