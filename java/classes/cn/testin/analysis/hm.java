package cn.testin.analysis;

 enum hm
{
  private hm() {}
  
  final void a(gt paramgt, int paramInt)
  {
    int j = 0;
    while (j < paramInt)
    {
      int k = 0;
      while (k < paramInt)
      {
        if (a(j, k)) {
          paramgt.c(k, j);
        }
        k += 1;
      }
      j += 1;
    }
  }
  
  abstract boolean a(int paramInt1, int paramInt2);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/hm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */