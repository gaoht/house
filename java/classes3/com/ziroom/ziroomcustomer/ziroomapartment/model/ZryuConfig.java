package com.ziroom.ziroomcustomer.ziroomapartment.model;

public class ZryuConfig
{
  public static final String CODE_BJ_CSZG = "10";
  public static final String CODE_BJ_HLG_QHGC = "04";
  public static final String CODE_BJ_JXQ_JFGY = "01";
  public static final String CODE_BJ_SD_LY = "06";
  public static final String CODE_BJ_WJ_YG = "05";
  public static final String CODE_BJ_XZM_WT = "03";
  public static final String CODE_BJ_YYC_15 = "02";
  public static final String CODE_BJ_ZBJD = "09";
  public static final String CODE_SH_JDQL = "08";
  public static final String CODE_SH_QBXK = "07";
  
  public static int getIconResource(String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return getNotOpenIconResource(paramString);
    case 0: 
    case 1: 
    case 2: 
      return getOpenIconResource(paramString);
    }
    return getNotOpenIconResource(paramString);
  }
  
  public static int getNotOpenIconResource(String paramString)
  {
    return 2130840384;
  }
  
  public static int getOpenIconResource(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      case 9: 
      default: 
        return 2130840381;
        if (paramString.equals("01"))
        {
          i = 0;
          continue;
          if (paramString.equals("02"))
          {
            i = 1;
            continue;
            if (paramString.equals("03"))
            {
              i = 2;
              continue;
              if (paramString.equals("04"))
              {
                i = 3;
                continue;
                if (paramString.equals("05"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("06"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("07"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("08"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("09"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("10")) {
                            i = 9;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return 2130840374;
    return 2130840378;
    return 2130840377;
    return 2130840373;
    return 2130840376;
    return 2130840375;
    return 2130840383;
    return 2130840382;
    return 2130840379;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */