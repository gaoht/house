package cn.testin.analysis;

class bh
  implements Runnable
{
  bh(bd parambd, int paramInt) {}
  
  public void run()
  {
    if (this.a == 6001) {
      bd.a(this.b, "web管理端未进入可视化模式！");
    }
    for (;;)
    {
      bd.a(this.b, 0);
      return;
      if (bd.b(this.b) == 1) {
        bd.a(this.b, "连接失败，请检查网络后重试！");
      } else {
        bd.a(this.b, "连接已断开！");
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */