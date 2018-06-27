package com.megvii.zhimasdk.d;

import com.megvii.zhimasdk.c.b;

public class c
{
  public static final String[] a = { "恭喜你，已经完成了芝麻认证", "您还剩", "无法启动相机，请确认摄像头功能完好", "缺少手机权限，请开启权限后重试", "没有联网权限，请开启APP的网络权限重试", "没有打开相机的权限，请开启权限后重试", "无法读取运动数据的权限，请开启权限后重试", "无法启动人脸识别，请稍后重试", "连不上互联网，请连接上互联网后重试", "请稍后重试", "信息验证失败，请重启程序或设备后重试", "请稍后重试", "请稍后重试", "请稍后重试", "APP需升级，请更新APP后重试", "身份信息错误，请修正后重试", "今天的认证次数达到上限，请明天再试", "取消" };
  
  public static void a(i parami, String paramString, int paramInt1, int paramInt2)
  {
    parami.a = paramString;
    parami.b = paramInt2;
    parami.c = paramInt1;
    parami.e = a[paramInt1];
    if (paramInt1 == 0) {
      parami.d = "认证成功";
    }
    do
    {
      return;
      parami.d = "认证失败";
    } while (paramInt1 != 1);
    parami.e = (parami.e + parami.k + "次认证机会");
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      g.a = bool;
      b.a(paramBoolean);
      a.a(paramBoolean);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */