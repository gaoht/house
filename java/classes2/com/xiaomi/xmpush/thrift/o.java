package com.xiaomi.xmpush.thrift;

import java.util.Map;

public enum o
{
  public static Map<String, o> O = null;
  public final String N;
  
  static
  {
    A = new o("SyncMIID", 26, "sync_miid");
    B = new o("UploadTinyData", 27, "upload");
    C = new o("GeoUpdateLoc", 28, "geo_update_loc");
    D = new o("GeoRegsiter", 29, "geo_reg");
    E = new o("GeoRegsiterResult", 30, "geo_reg_result");
    F = new o("GeoUnregsiter", 31, "geo_unreg");
    G = new o("GeoUnregsiterResult", 32, "geo_unreg_result");
    H = new o("GeoSync", 33, "geo_sync");
    I = new o("GeoUpload", 34, "geo_upload");
    J = new o("GeoPackageUninstalled", 35, "geo_package_uninstalled");
    K = new o("CancelPushMessage", 36, "clear_push_message");
    L = new o("DisablePushMessage", 37, "disable_push");
    M = new o("EnablePushMessage", 38, "enable_push");
    P = new o[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M };
  }
  
  private o(String paramString)
  {
    this.N = paramString;
  }
  
  public String toString()
  {
    return this.N;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */