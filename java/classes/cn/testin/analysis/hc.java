package cn.testin.analysis;

public final class hc
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  private final float e;
  private final float f;
  private final float g;
  private final float h;
  private final float i;
  
  private hc(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.a = paramFloat1;
    this.b = paramFloat4;
    this.c = paramFloat7;
    this.d = paramFloat2;
    this.e = paramFloat5;
    this.f = paramFloat8;
    this.g = paramFloat3;
    this.h = paramFloat6;
    this.i = paramFloat9;
  }
  
  public static hc a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    float f1 = paramFloat1 - paramFloat3 + paramFloat5 - paramFloat7;
    float f2 = paramFloat2 - paramFloat4 + paramFloat6 - paramFloat8;
    if ((f1 == 0.0F) && (f2 == 0.0F)) {
      return new hc(paramFloat3 - paramFloat1, paramFloat5 - paramFloat3, paramFloat1, paramFloat4 - paramFloat2, paramFloat6 - paramFloat4, paramFloat2, 0.0F, 0.0F, 1.0F);
    }
    float f3 = paramFloat3 - paramFloat5;
    float f4 = paramFloat7 - paramFloat5;
    paramFloat5 = paramFloat4 - paramFloat6;
    float f5 = paramFloat8 - paramFloat6;
    paramFloat6 = f3 * f5 - f4 * paramFloat5;
    f4 = (f5 * f1 - f4 * f2) / paramFloat6;
    paramFloat5 = (f2 * f3 - f1 * paramFloat5) / paramFloat6;
    return new hc(paramFloat3 - paramFloat1 + f4 * paramFloat3, paramFloat7 - paramFloat1 + paramFloat5 * paramFloat7, paramFloat1, f4 * paramFloat4 + (paramFloat4 - paramFloat2), paramFloat5 * paramFloat8 + (paramFloat8 - paramFloat2), paramFloat2, f4, paramFloat5, 1.0F);
  }
  
  public static hc a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16)
  {
    hc localhc = b(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8);
    return a(paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16).a(localhc);
  }
  
  public static hc b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    return a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8).a();
  }
  
  hc a()
  {
    return new hc(this.e * this.i - this.f * this.h, this.f * this.g - this.d * this.i, this.d * this.h - this.e * this.g, this.c * this.h - this.b * this.i, this.a * this.i - this.c * this.g, this.b * this.g - this.a * this.h, this.b * this.f - this.c * this.e, this.c * this.d - this.a * this.f, this.a * this.e - this.b * this.d);
  }
  
  hc a(hc paramhc)
  {
    return new hc(this.a * paramhc.a + this.d * paramhc.b + this.g * paramhc.c, this.a * paramhc.d + this.d * paramhc.e + this.g * paramhc.f, this.a * paramhc.g + this.d * paramhc.h + this.g * paramhc.i, this.b * paramhc.a + this.e * paramhc.b + this.h * paramhc.c, this.b * paramhc.d + this.e * paramhc.e + this.h * paramhc.f, this.b * paramhc.g + this.e * paramhc.h + this.h * paramhc.i, this.c * paramhc.a + this.f * paramhc.b + this.i * paramhc.c, this.c * paramhc.d + this.f * paramhc.e + this.i * paramhc.f, this.c * paramhc.g + this.f * paramhc.h + this.i * paramhc.i);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    int k = paramArrayOfFloat.length;
    float f1 = this.a;
    float f2 = this.b;
    float f3 = this.c;
    float f4 = this.d;
    float f5 = this.e;
    float f6 = this.f;
    float f7 = this.g;
    float f8 = this.h;
    float f9 = this.i;
    int j = 0;
    while (j < k)
    {
      float f10 = paramArrayOfFloat[j];
      float f11 = paramArrayOfFloat[(j + 1)];
      float f12 = f3 * f10 + f6 * f11 + f9;
      paramArrayOfFloat[j] = ((f1 * f10 + f4 * f11 + f7) / f12);
      paramArrayOfFloat[(j + 1)] = ((f10 * f2 + f11 * f5 + f8) / f12);
      j += 2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/hc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */