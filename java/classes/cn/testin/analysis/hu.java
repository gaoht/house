package cn.testin.analysis;

 enum hu
{
  hu()
  {
    super(paramString, paramInt, null);
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2 + paramInt1 * paramInt2 % 3 & 0x1) == 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/hu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */