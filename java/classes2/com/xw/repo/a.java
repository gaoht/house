package com.xw.repo;

public class a
{
  int A;
  int B;
  boolean C;
  private BubbleSeekBar D;
  float a;
  float b;
  float c;
  boolean d;
  int e;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  int l;
  boolean m;
  boolean n;
  boolean o;
  int p;
  int q;
  int r;
  int s;
  boolean t;
  int u;
  int v;
  boolean w;
  boolean x;
  boolean y;
  int z;
  
  a(BubbleSeekBar paramBubbleSeekBar)
  {
    this.D = paramBubbleSeekBar;
  }
  
  public a alwaysShowBubble()
  {
    this.C = true;
    return this;
  }
  
  public a autoAdjustSectionMark()
  {
    this.n = true;
    return this;
  }
  
  public a bubbleColor(int paramInt)
  {
    this.z = paramInt;
    return this;
  }
  
  public a bubbleTextColor(int paramInt)
  {
    this.B = paramInt;
    return this;
  }
  
  public a bubbleTextSize(int paramInt)
  {
    this.A = b.b(paramInt);
    return this;
  }
  
  public void build()
  {
    this.D.a(this);
  }
  
  public a floatType()
  {
    this.d = true;
    return this;
  }
  
  public int getBubbleColor()
  {
    return this.z;
  }
  
  public int getBubbleTextColor()
  {
    return this.B;
  }
  
  public int getBubbleTextSize()
  {
    return this.A;
  }
  
  public float getMax()
  {
    return this.b;
  }
  
  public float getMin()
  {
    return this.a;
  }
  
  public float getProgress()
  {
    return this.c;
  }
  
  public int getSecondTrackColor()
  {
    return this.j;
  }
  
  public int getSecondTrackSize()
  {
    return this.f;
  }
  
  public int getSectionCount()
  {
    return this.l;
  }
  
  public int getSectionTextColor()
  {
    return this.q;
  }
  
  public int getSectionTextInterval()
  {
    return this.s;
  }
  
  public int getSectionTextPosition()
  {
    return this.r;
  }
  
  public int getSectionTextSize()
  {
    return this.p;
  }
  
  public int getThumbColor()
  {
    return this.k;
  }
  
  public int getThumbRadius()
  {
    return this.g;
  }
  
  public int getThumbRadiusOnDragging()
  {
    return this.h;
  }
  
  public int getThumbTextColor()
  {
    return this.v;
  }
  
  public int getThumbTextSize()
  {
    return this.u;
  }
  
  public int getTrackColor()
  {
    return this.i;
  }
  
  public int getTrackSize()
  {
    return this.e;
  }
  
  public boolean isAlwaysShowBubble()
  {
    return this.C;
  }
  
  public boolean isAutoAdjustSectionMark()
  {
    return this.n;
  }
  
  public boolean isFloatType()
  {
    return this.d;
  }
  
  public boolean isSeekBySection()
  {
    return this.y;
  }
  
  public boolean isShowProgressInFloat()
  {
    return this.w;
  }
  
  public boolean isShowSectionMark()
  {
    return this.m;
  }
  
  public boolean isShowSectionText()
  {
    return this.o;
  }
  
  public boolean isShowThumbText()
  {
    return this.t;
  }
  
  public boolean isTouchToSeek()
  {
    return this.x;
  }
  
  public a max(float paramFloat)
  {
    this.b = paramFloat;
    return this;
  }
  
  public a min(float paramFloat)
  {
    this.a = paramFloat;
    this.c = paramFloat;
    return this;
  }
  
  public a progress(float paramFloat)
  {
    this.c = paramFloat;
    return this;
  }
  
  public a secondTrackColor(int paramInt)
  {
    this.j = paramInt;
    this.k = paramInt;
    this.v = paramInt;
    this.z = paramInt;
    return this;
  }
  
  public a secondTrackSize(int paramInt)
  {
    this.f = b.a(paramInt);
    return this;
  }
  
  public a sectionCount(int paramInt)
  {
    this.l = paramInt;
    return this;
  }
  
  public a sectionTextColor(int paramInt)
  {
    this.q = paramInt;
    return this;
  }
  
  public a sectionTextInterval(int paramInt)
  {
    this.s = paramInt;
    return this;
  }
  
  public a sectionTextPosition(int paramInt)
  {
    this.r = paramInt;
    return this;
  }
  
  public a sectionTextSize(int paramInt)
  {
    this.p = b.b(paramInt);
    return this;
  }
  
  public a seekBySection()
  {
    this.y = true;
    return this;
  }
  
  public a showProgressInFloat()
  {
    this.w = true;
    return this;
  }
  
  public a showSectionMark()
  {
    this.m = true;
    return this;
  }
  
  public a showSectionText()
  {
    this.o = true;
    return this;
  }
  
  public a showThumbText()
  {
    this.t = true;
    return this;
  }
  
  public a thumbColor(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
  
  public a thumbRadius(int paramInt)
  {
    this.g = b.a(paramInt);
    return this;
  }
  
  public a thumbRadiusOnDragging(int paramInt)
  {
    this.h = b.a(paramInt);
    return this;
  }
  
  public a thumbTextColor(int paramInt)
  {
    this.v = paramInt;
    return this;
  }
  
  public a thumbTextSize(int paramInt)
  {
    this.u = b.b(paramInt);
    return this;
  }
  
  public a touchToSeek()
  {
    this.x = true;
    return this;
  }
  
  public a trackColor(int paramInt)
  {
    this.i = paramInt;
    this.q = paramInt;
    return this;
  }
  
  public a trackSize(int paramInt)
  {
    this.e = b.a(paramInt);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xw/repo/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */