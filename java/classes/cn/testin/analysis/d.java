package cn.testin.analysis;

class d
  implements OnExpUpdateListener
{
  d(TesterActivity paramTesterActivity) {}
  
  public void onUpdate(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      if (TesterActivity.b(this.a) == 0) {
        str = "加入实验成功";
      }
    }
    for (;;)
    {
      bc.a();
      TesterActivity.a(this.a, paramBoolean, str);
      return;
      str = "结束调试成功";
      continue;
      str = "更新实验配置失败";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */