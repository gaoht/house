package com.airbnb.lottie;

import org.json.JSONArray;

class bq
{
  private final float a;
  private final float b;
  
  bq()
  {
    this(1.0F, 1.0F);
  }
  
  bq(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  float a()
  {
    return this.a;
  }
  
  float b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return a() + "x" + b();
  }
  
  static class a
    implements k.a<bq>
  {
    static final a a = new a();
    
    public bq valueFromObject(Object paramObject, float paramFloat)
    {
      paramObject = (JSONArray)paramObject;
      return new bq((float)((JSONArray)paramObject).optDouble(0, 1.0D) / 100.0F * paramFloat, (float)((JSONArray)paramObject).optDouble(1, 1.0D) / 100.0F * paramFloat);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */