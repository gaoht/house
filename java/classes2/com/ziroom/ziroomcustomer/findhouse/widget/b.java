package com.ziroom.ziroomcustomer.findhouse.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint.Style;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

public class b
  extends CharacterStyle
  implements UpdateAppearance
{
  private int[] a;
  private String b = "";
  
  public b(Context paramContext)
  {
    this.a = paramContext.getResources().getIntArray(2131361818);
  }
  
  public b(Context paramContext, String paramString, int[] paramArrayOfInt)
  {
    this.a = paramArrayOfInt;
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "";
    }
    this.b = paramContext;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setStyle(Paint.Style.FILL);
    LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, paramTextPaint.measureText(this.b), this.a, null, Shader.TileMode.MIRROR);
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(90.0F);
    localLinearGradient.setLocalMatrix(localMatrix);
    paramTextPaint.setShader(localLinearGradient);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */