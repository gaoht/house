package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public final class BDLocation
  implements Parcelable
{
  public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
  public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
  public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
  public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
  public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
  public static final Parcelable.Creator<BDLocation> CREATOR = new a();
  public static final int GPS_ACCURACY_BAD = 3;
  public static final int GPS_ACCURACY_GOOD = 1;
  public static final int GPS_ACCURACY_MID = 2;
  public static final int GPS_ACCURACY_UNKNOWN = 0;
  public static final int INDOOR_LOCATION_NEARBY_SURPPORT_TRUE = 2;
  public static final int INDOOR_LOCATION_SOURCE_BLUETOOTH = 4;
  public static final int INDOOR_LOCATION_SOURCE_MAGNETIC = 2;
  public static final int INDOOR_LOCATION_SOURCE_SMALLCELLSTATION = 8;
  public static final int INDOOR_LOCATION_SOURCE_UNKNOWN = 0;
  public static final int INDOOR_LOCATION_SOURCE_WIFI = 1;
  public static final int INDOOR_LOCATION_SURPPORT_FALSE = 0;
  public static final int INDOOR_LOCATION_SURPPORT_TRUE = 1;
  public static final int INDOOR_NETWORK_STATE_HIGH = 2;
  public static final int INDOOR_NETWORK_STATE_LOW = 0;
  public static final int INDOOR_NETWORK_STATE_MIDDLE = 1;
  public static final int LOCATION_WHERE_IN_CN = 1;
  public static final int LOCATION_WHERE_OUT_CN = 0;
  public static final int LOCATION_WHERE_UNKNOW = 2;
  public static final int OPERATORS_TYPE_MOBILE = 1;
  public static final int OPERATORS_TYPE_TELECOMU = 3;
  public static final int OPERATORS_TYPE_UNICOM = 2;
  public static final int OPERATORS_TYPE_UNKONW = 0;
  public static final int TypeCacheLocation = 65;
  public static final int TypeCriteriaException = 62;
  public static final int TypeGpsLocation = 61;
  public static final int TypeNetWorkException = 63;
  public static final int TypeNetWorkLocation = 161;
  public static final int TypeNone = 0;
  public static final int TypeOffLineLocation = 66;
  public static final int TypeOffLineLocationFail = 67;
  public static final int TypeOffLineLocationNetworkFail = 68;
  public static final int TypeServerCheckKeyError = 505;
  public static final int TypeServerDecryptError = 162;
  public static final int TypeServerError = 167;
  public static final int USER_INDDOR_TRUE = 1;
  public static final int USER_INDOOR_FALSE = 0;
  public static final int USER_INDOOR_UNKNOW = -1;
  private String buildingid = null;
  private String floor = null;
  private boolean indoorLocMode = false;
  private boolean isCellChangeFlag = false;
  private Address mAddr = new Address.Builder().build();
  private String mAddrStr = null;
  private double mAltitude = Double.MIN_VALUE;
  private String mBuildingName = null;
  private String mCoorType = null;
  private String mCu = "";
  private float mDerect = -1.0F;
  private String mDescription = null;
  private int mGpsAccuracyStatus = 0;
  private boolean mHasAddr = false;
  private boolean mHasAltitude = false;
  private boolean mHasRadius = false;
  private boolean mHasSateNumber = false;
  private boolean mHasSpeed = false;
  private int mIndoorLocationSurpport = 0;
  private int mIndoorNetworkState = 2;
  private int mIndoorSource = 0;
  private int mIndoorState = -1;
  private String mIndoorSurpportBuildingID = null;
  private String mIndoorSurpportBuildingName = null;
  private double mLatitude = Double.MIN_VALUE;
  private int mLocType = 0;
  private int mLocationWhere = 1;
  private double mLongitude = Double.MIN_VALUE;
  private int mOperators;
  private int mParkState = 0;
  private List<Poi> mPoiList = null;
  private float mRadius = 0.0F;
  private int mSatelliteNumber = -1;
  private String mSemaAptag = null;
  private String mSemaPoiRegion = null;
  private String mSemaRegular = null;
  private float mSpeed = 0.0F;
  private String mTime = null;
  private String netWorkLocationType = null;
  
  public BDLocation() {}
  
  private BDLocation(Parcel paramParcel)
  {
    this.mLocType = paramParcel.readInt();
    this.mTime = paramParcel.readString();
    this.mLatitude = paramParcel.readDouble();
    this.mLongitude = paramParcel.readDouble();
    this.mAltitude = paramParcel.readDouble();
    this.mSpeed = paramParcel.readFloat();
    this.mRadius = paramParcel.readFloat();
    this.mSatelliteNumber = paramParcel.readInt();
    this.mDerect = paramParcel.readFloat();
    this.floor = paramParcel.readString();
    this.mParkState = paramParcel.readInt();
    this.buildingid = paramParcel.readString();
    this.mBuildingName = paramParcel.readString();
    this.netWorkLocationType = paramParcel.readString();
    Object localObject = paramParcel.readString();
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    String str4 = paramParcel.readString();
    String str5 = paramParcel.readString();
    paramParcel.readString();
    String str6 = paramParcel.readString();
    String str7 = paramParcel.readString();
    this.mAddr = new Address.Builder().country(str6).countryCode(str7).province((String)localObject).city(str1).cityCode(str5).district(str2).street(str3).streetNumber(str4).build();
    localObject = new boolean[7];
    this.mOperators = paramParcel.readInt();
    this.mCu = paramParcel.readString();
    this.mSemaAptag = paramParcel.readString();
    this.mSemaPoiRegion = paramParcel.readString();
    this.mSemaRegular = paramParcel.readString();
    this.mLocationWhere = paramParcel.readInt();
    this.mDescription = paramParcel.readString();
    this.mIndoorState = paramParcel.readInt();
    this.mIndoorLocationSurpport = paramParcel.readInt();
    this.mIndoorNetworkState = paramParcel.readInt();
    this.mIndoorSource = paramParcel.readInt();
    this.mIndoorSurpportBuildingName = paramParcel.readString();
    this.mIndoorSurpportBuildingID = paramParcel.readString();
    this.mGpsAccuracyStatus = paramParcel.readInt();
    try
    {
      paramParcel.readBooleanArray((boolean[])localObject);
      this.mHasAltitude = localObject[0];
      this.mHasSpeed = localObject[1];
      this.mHasRadius = localObject[2];
      this.mHasSateNumber = localObject[3];
      this.mHasAddr = localObject[4];
      this.isCellChangeFlag = localObject[5];
      this.indoorLocMode = localObject[6];
      localObject = new ArrayList();
      paramParcel.readList((List)localObject, Poi.class.getClassLoader());
      if (((List)localObject).size() == 0)
      {
        this.mPoiList = null;
        return;
      }
      this.mPoiList = ((List)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public BDLocation(BDLocation paramBDLocation)
  {
    this.mLocType = paramBDLocation.mLocType;
    this.mTime = paramBDLocation.mTime;
    this.mLatitude = paramBDLocation.mLatitude;
    this.mLongitude = paramBDLocation.mLongitude;
    this.mHasAltitude = paramBDLocation.mHasAltitude;
    this.mAltitude = paramBDLocation.mAltitude;
    this.mHasSpeed = paramBDLocation.mHasSpeed;
    this.mSpeed = paramBDLocation.mSpeed;
    this.mHasRadius = paramBDLocation.mHasRadius;
    this.mRadius = paramBDLocation.mRadius;
    this.mHasSateNumber = paramBDLocation.mHasSateNumber;
    this.mSatelliteNumber = paramBDLocation.mSatelliteNumber;
    this.mDerect = paramBDLocation.mDerect;
    this.mCoorType = paramBDLocation.mCoorType;
    this.mHasAddr = paramBDLocation.mHasAddr;
    this.mAddrStr = paramBDLocation.mAddrStr;
    this.isCellChangeFlag = paramBDLocation.isCellChangeFlag;
    this.mAddr = new Address.Builder().country(paramBDLocation.mAddr.country).countryCode(paramBDLocation.mAddr.countryCode).province(paramBDLocation.mAddr.province).city(paramBDLocation.mAddr.city).cityCode(paramBDLocation.mAddr.cityCode).district(paramBDLocation.mAddr.district).street(paramBDLocation.mAddr.street).streetNumber(paramBDLocation.mAddr.streetNumber).build();
    this.floor = paramBDLocation.floor;
    this.buildingid = paramBDLocation.buildingid;
    this.mBuildingName = paramBDLocation.mBuildingName;
    this.mLocationWhere = paramBDLocation.mLocationWhere;
    this.mParkState = paramBDLocation.mParkState;
    this.indoorLocMode = paramBDLocation.indoorLocMode;
    this.netWorkLocationType = paramBDLocation.netWorkLocationType;
    this.mOperators = paramBDLocation.mOperators;
    this.mCu = paramBDLocation.mCu;
    this.mSemaAptag = paramBDLocation.mSemaAptag;
    this.mSemaPoiRegion = paramBDLocation.mSemaPoiRegion;
    this.mSemaRegular = paramBDLocation.mSemaRegular;
    this.mIndoorState = paramBDLocation.mIndoorState;
    this.mIndoorLocationSurpport = paramBDLocation.mIndoorLocationSurpport;
    this.mIndoorNetworkState = paramBDLocation.mIndoorLocationSurpport;
    this.mIndoorSource = paramBDLocation.mIndoorSource;
    this.mIndoorSurpportBuildingName = paramBDLocation.mIndoorSurpportBuildingName;
    this.mIndoorSurpportBuildingID = paramBDLocation.mIndoorSurpportBuildingID;
    this.mGpsAccuracyStatus = paramBDLocation.mGpsAccuracyStatus;
    if (paramBDLocation.mPoiList == null) {}
    ArrayList localArrayList;
    for (this.mPoiList = null;; this.mPoiList = localArrayList)
    {
      this.mDescription = paramBDLocation.mDescription;
      return;
      localArrayList = new ArrayList();
      int i = 0;
      while (i < paramBDLocation.mPoiList.size())
      {
        Poi localPoi = (Poi)paramBDLocation.mPoiList.get(i);
        localArrayList.add(new Poi(localPoi.getId(), localPoi.getName(), localPoi.getRank()));
        i += 1;
      }
    }
  }
  
  /* Error */
  public BDLocation(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload_0
    //   4: invokespecial 137	java/lang/Object:<init>	()V
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 139	com/baidu/location/BDLocation:mLocType	I
    //   12: aload_0
    //   13: aconst_null
    //   14: putfield 141	com/baidu/location/BDLocation:mTime	Ljava/lang/String;
    //   17: aload_0
    //   18: ldc2_w 142
    //   21: putfield 145	com/baidu/location/BDLocation:mLatitude	D
    //   24: aload_0
    //   25: ldc2_w 142
    //   28: putfield 147	com/baidu/location/BDLocation:mLongitude	D
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 149	com/baidu/location/BDLocation:mHasAltitude	Z
    //   36: aload_0
    //   37: ldc2_w 142
    //   40: putfield 151	com/baidu/location/BDLocation:mAltitude	D
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 153	com/baidu/location/BDLocation:mHasSpeed	Z
    //   48: aload_0
    //   49: fconst_0
    //   50: putfield 155	com/baidu/location/BDLocation:mSpeed	F
    //   53: aload_0
    //   54: iconst_0
    //   55: putfield 157	com/baidu/location/BDLocation:mHasRadius	Z
    //   58: aload_0
    //   59: fconst_0
    //   60: putfield 159	com/baidu/location/BDLocation:mRadius	F
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 161	com/baidu/location/BDLocation:mHasSateNumber	Z
    //   68: aload_0
    //   69: iconst_m1
    //   70: putfield 163	com/baidu/location/BDLocation:mSatelliteNumber	I
    //   73: aload_0
    //   74: ldc -92
    //   76: putfield 166	com/baidu/location/BDLocation:mDerect	F
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 168	com/baidu/location/BDLocation:mCoorType	Ljava/lang/String;
    //   84: aload_0
    //   85: iconst_0
    //   86: putfield 170	com/baidu/location/BDLocation:mHasAddr	Z
    //   89: aload_0
    //   90: aconst_null
    //   91: putfield 172	com/baidu/location/BDLocation:mAddrStr	Ljava/lang/String;
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 174	com/baidu/location/BDLocation:mSemaAptag	Ljava/lang/String;
    //   99: aload_0
    //   100: aconst_null
    //   101: putfield 176	com/baidu/location/BDLocation:mSemaPoiRegion	Ljava/lang/String;
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield 178	com/baidu/location/BDLocation:mSemaRegular	Ljava/lang/String;
    //   109: aload_0
    //   110: iconst_0
    //   111: putfield 180	com/baidu/location/BDLocation:isCellChangeFlag	Z
    //   114: aload_0
    //   115: new 182	com/baidu/location/Address$Builder
    //   118: dup
    //   119: invokespecial 183	com/baidu/location/Address$Builder:<init>	()V
    //   122: invokevirtual 187	com/baidu/location/Address$Builder:build	()Lcom/baidu/location/Address;
    //   125: putfield 189	com/baidu/location/BDLocation:mAddr	Lcom/baidu/location/Address;
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 191	com/baidu/location/BDLocation:floor	Ljava/lang/String;
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 193	com/baidu/location/BDLocation:buildingid	Ljava/lang/String;
    //   138: aload_0
    //   139: aconst_null
    //   140: putfield 195	com/baidu/location/BDLocation:mBuildingName	Ljava/lang/String;
    //   143: aload_0
    //   144: iconst_0
    //   145: putfield 197	com/baidu/location/BDLocation:indoorLocMode	Z
    //   148: aload_0
    //   149: iconst_0
    //   150: putfield 199	com/baidu/location/BDLocation:mParkState	I
    //   153: aload_0
    //   154: iconst_1
    //   155: putfield 201	com/baidu/location/BDLocation:mLocationWhere	I
    //   158: aload_0
    //   159: aconst_null
    //   160: putfield 203	com/baidu/location/BDLocation:netWorkLocationType	Ljava/lang/String;
    //   163: aload_0
    //   164: ldc -51
    //   166: putfield 207	com/baidu/location/BDLocation:mCu	Ljava/lang/String;
    //   169: aload_0
    //   170: iconst_m1
    //   171: putfield 209	com/baidu/location/BDLocation:mIndoorState	I
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 211	com/baidu/location/BDLocation:mIndoorLocationSurpport	I
    //   179: aload_0
    //   180: iconst_2
    //   181: putfield 213	com/baidu/location/BDLocation:mIndoorNetworkState	I
    //   184: aload_0
    //   185: iconst_0
    //   186: putfield 215	com/baidu/location/BDLocation:mIndoorSource	I
    //   189: aload_0
    //   190: aconst_null
    //   191: putfield 217	com/baidu/location/BDLocation:mIndoorSurpportBuildingName	Ljava/lang/String;
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 219	com/baidu/location/BDLocation:mIndoorSurpportBuildingID	Ljava/lang/String;
    //   199: aload_0
    //   200: aconst_null
    //   201: putfield 221	com/baidu/location/BDLocation:mPoiList	Ljava/util/List;
    //   204: aload_0
    //   205: aconst_null
    //   206: putfield 223	com/baidu/location/BDLocation:mDescription	Ljava/lang/String;
    //   209: aload_0
    //   210: iconst_0
    //   211: putfield 225	com/baidu/location/BDLocation:mGpsAccuracyStatus	I
    //   214: aload_1
    //   215: ifnull +12 -> 227
    //   218: aload_1
    //   219: ldc -51
    //   221: invokevirtual 345	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   224: ifeq +4 -> 228
    //   227: return
    //   228: new 347	org/json/JSONObject
    //   231: dup
    //   232: aload_1
    //   233: invokespecial 349	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   236: astore_1
    //   237: aload_1
    //   238: ldc_w 351
    //   241: invokevirtual 355	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   244: astore 4
    //   246: aload 4
    //   248: ldc_w 357
    //   251: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   254: invokestatic 367	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   257: istore_2
    //   258: aload_0
    //   259: iload_2
    //   260: invokevirtual 371	com/baidu/location/BDLocation:setLocType	(I)V
    //   263: aload_0
    //   264: aload 4
    //   266: ldc_w 373
    //   269: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   272: invokevirtual 376	com/baidu/location/BDLocation:setTime	(Ljava/lang/String;)V
    //   275: iload_2
    //   276: bipush 61
    //   278: if_icmpne +204 -> 482
    //   281: aload_1
    //   282: ldc_w 378
    //   285: invokevirtual 355	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   288: astore_1
    //   289: aload_1
    //   290: ldc_w 380
    //   293: invokevirtual 355	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   296: astore 4
    //   298: aload_0
    //   299: aload 4
    //   301: ldc_w 382
    //   304: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   307: invokestatic 388	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   310: invokevirtual 392	com/baidu/location/BDLocation:setLatitude	(D)V
    //   313: aload_0
    //   314: aload 4
    //   316: ldc_w 394
    //   319: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   322: invokestatic 388	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   325: invokevirtual 397	com/baidu/location/BDLocation:setLongitude	(D)V
    //   328: aload_0
    //   329: aload_1
    //   330: ldc_w 399
    //   333: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   336: invokestatic 405	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   339: invokevirtual 409	com/baidu/location/BDLocation:setRadius	(F)V
    //   342: aload_0
    //   343: aload_1
    //   344: ldc_w 411
    //   347: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   350: invokestatic 405	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   353: invokevirtual 414	com/baidu/location/BDLocation:setSpeed	(F)V
    //   356: aload_0
    //   357: aload_1
    //   358: ldc_w 416
    //   361: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   364: invokestatic 405	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   367: invokevirtual 419	com/baidu/location/BDLocation:setDirection	(F)V
    //   370: aload_0
    //   371: aload_1
    //   372: ldc_w 421
    //   375: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   378: invokestatic 367	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   381: invokevirtual 424	com/baidu/location/BDLocation:setSatelliteNumber	(I)V
    //   384: aload_1
    //   385: ldc_w 426
    //   388: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   391: istore_3
    //   392: iload_3
    //   393: ifeq +14 -> 407
    //   396: aload_0
    //   397: aload_1
    //   398: ldc_w 426
    //   401: invokevirtual 433	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   404: invokevirtual 436	com/baidu/location/BDLocation:setAltitude	(D)V
    //   407: aload_1
    //   408: ldc_w 438
    //   411: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   414: ifeq +48 -> 462
    //   417: aload_0
    //   418: aload_1
    //   419: ldc_w 438
    //   422: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   425: invokestatic 367	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   428: invokevirtual 441	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   431: aload_0
    //   432: getfield 201	com/baidu/location/BDLocation:mLocationWhere	I
    //   435: ifne +39 -> 474
    //   438: aload_0
    //   439: ldc_w 443
    //   442: invokevirtual 446	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   445: return
    //   446: astore_1
    //   447: aload_1
    //   448: invokevirtual 449	java/lang/Exception:printStackTrace	()V
    //   451: aload_0
    //   452: iconst_0
    //   453: putfield 139	com/baidu/location/BDLocation:mLocType	I
    //   456: aload_0
    //   457: iconst_0
    //   458: putfield 170	com/baidu/location/BDLocation:mHasAddr	Z
    //   461: return
    //   462: aload_0
    //   463: iconst_1
    //   464: invokevirtual 441	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   467: goto -36 -> 431
    //   470: astore_1
    //   471: goto -40 -> 431
    //   474: aload_0
    //   475: ldc_w 451
    //   478: invokevirtual 446	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   481: return
    //   482: iload_2
    //   483: sipush 161
    //   486: if_icmpne +1098 -> 1584
    //   489: aload_1
    //   490: ldc_w 378
    //   493: invokevirtual 355	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   496: astore 11
    //   498: aload 11
    //   500: ldc_w 380
    //   503: invokevirtual 355	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   506: astore_1
    //   507: aload_0
    //   508: aload_1
    //   509: ldc_w 382
    //   512: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   515: invokestatic 388	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   518: invokevirtual 392	com/baidu/location/BDLocation:setLatitude	(D)V
    //   521: aload_0
    //   522: aload_1
    //   523: ldc_w 394
    //   526: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   529: invokestatic 388	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   532: invokevirtual 397	com/baidu/location/BDLocation:setLongitude	(D)V
    //   535: aload_0
    //   536: aload 11
    //   538: ldc_w 399
    //   541: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   544: invokestatic 405	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   547: invokevirtual 409	com/baidu/location/BDLocation:setRadius	(F)V
    //   550: aload 11
    //   552: ldc_w 453
    //   555: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   558: ifeq +226 -> 784
    //   561: aload 11
    //   563: ldc_w 453
    //   566: invokevirtual 355	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   569: astore_1
    //   570: aload_1
    //   571: ldc_w 455
    //   574: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   577: ifeq +26 -> 603
    //   580: aload_1
    //   581: ldc_w 455
    //   584: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   587: astore 4
    //   589: aload 4
    //   591: invokestatic 461	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   594: ifne +112 -> 706
    //   597: aload_0
    //   598: aload 4
    //   600: putfield 174	com/baidu/location/BDLocation:mSemaAptag	Ljava/lang/String;
    //   603: aload_1
    //   604: ldc_w 463
    //   607: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   610: ifeq +111 -> 721
    //   613: aload_1
    //   614: ldc_w 463
    //   617: invokevirtual 355	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   620: ldc_w 465
    //   623: invokevirtual 469	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   626: astore 4
    //   628: new 279	java/util/ArrayList
    //   631: dup
    //   632: invokespecial 280	java/util/ArrayList:<init>	()V
    //   635: astore 5
    //   637: iconst_0
    //   638: istore_2
    //   639: iload_2
    //   640: aload 4
    //   642: invokevirtual 474	org/json/JSONArray:length	()I
    //   645: if_icmpge +70 -> 715
    //   648: aload 4
    //   650: iload_2
    //   651: invokevirtual 477	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   654: astore 6
    //   656: aload 6
    //   658: ldc_w 479
    //   661: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   664: astore 7
    //   666: aload 5
    //   668: new 282	com/baidu/location/Poi
    //   671: dup
    //   672: aload 6
    //   674: ldc_w 481
    //   677: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   680: aload 7
    //   682: aload 6
    //   684: ldc_w 483
    //   687: invokevirtual 433	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   690: invokespecial 335	com/baidu/location/Poi:<init>	(Ljava/lang/String;Ljava/lang/String;D)V
    //   693: invokeinterface 339 2 0
    //   698: pop
    //   699: iload_2
    //   700: iconst_1
    //   701: iadd
    //   702: istore_2
    //   703: goto -64 -> 639
    //   706: aload_0
    //   707: ldc -51
    //   709: putfield 174	com/baidu/location/BDLocation:mSemaAptag	Ljava/lang/String;
    //   712: goto -109 -> 603
    //   715: aload_0
    //   716: aload 5
    //   718: putfield 221	com/baidu/location/BDLocation:mPoiList	Ljava/util/List;
    //   721: aload_1
    //   722: ldc_w 485
    //   725: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   728: ifeq +26 -> 754
    //   731: aload_1
    //   732: ldc_w 485
    //   735: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   738: astore 4
    //   740: aload 4
    //   742: invokestatic 461	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   745: ifne +9 -> 754
    //   748: aload_0
    //   749: aload 4
    //   751: putfield 176	com/baidu/location/BDLocation:mSemaPoiRegion	Ljava/lang/String;
    //   754: aload_1
    //   755: ldc_w 487
    //   758: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   761: ifeq +23 -> 784
    //   764: aload_1
    //   765: ldc_w 487
    //   768: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   771: astore_1
    //   772: aload_1
    //   773: invokestatic 461	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   776: ifne +8 -> 784
    //   779: aload_0
    //   780: aload_1
    //   781: putfield 178	com/baidu/location/BDLocation:mSemaRegular	Ljava/lang/String;
    //   784: aload 11
    //   786: ldc_w 489
    //   789: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   792: ifeq +480 -> 1272
    //   795: aload 11
    //   797: ldc_w 489
    //   800: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   803: ldc_w 491
    //   806: invokevirtual 495	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   809: astore 12
    //   811: aload 12
    //   813: arraylength
    //   814: istore_2
    //   815: iload_2
    //   816: ifle +682 -> 1498
    //   819: aload 12
    //   821: iconst_0
    //   822: aaload
    //   823: astore_1
    //   824: goto +676 -> 1500
    //   827: aload_0
    //   828: new 182	com/baidu/location/Address$Builder
    //   831: dup
    //   832: invokespecial 183	com/baidu/location/Address$Builder:<init>	()V
    //   835: aload 9
    //   837: invokevirtual 250	com/baidu/location/Address$Builder:country	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   840: aload 10
    //   842: invokevirtual 253	com/baidu/location/Address$Builder:countryCode	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   845: aload_1
    //   846: invokevirtual 256	com/baidu/location/Address$Builder:province	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   849: aload 4
    //   851: invokevirtual 259	com/baidu/location/Address$Builder:city	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   854: aload 8
    //   856: invokevirtual 262	com/baidu/location/Address$Builder:cityCode	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   859: aload 5
    //   861: invokevirtual 265	com/baidu/location/Address$Builder:district	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   864: aload 6
    //   866: invokevirtual 268	com/baidu/location/Address$Builder:street	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   869: aload 7
    //   871: invokevirtual 271	com/baidu/location/Address$Builder:streetNumber	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   874: invokevirtual 187	com/baidu/location/Address$Builder:build	()Lcom/baidu/location/Address;
    //   877: putfield 189	com/baidu/location/BDLocation:mAddr	Lcom/baidu/location/Address;
    //   880: aload_0
    //   881: iconst_1
    //   882: putfield 170	com/baidu/location/BDLocation:mHasAddr	Z
    //   885: aload 11
    //   887: ldc_w 496
    //   890: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   893: ifeq +30 -> 923
    //   896: aload_0
    //   897: aload 11
    //   899: ldc_w 496
    //   902: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   905: putfield 191	com/baidu/location/BDLocation:floor	Ljava/lang/String;
    //   908: aload_0
    //   909: getfield 191	com/baidu/location/BDLocation:floor	Ljava/lang/String;
    //   912: invokestatic 461	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   915: ifeq +8 -> 923
    //   918: aload_0
    //   919: aconst_null
    //   920: putfield 191	com/baidu/location/BDLocation:floor	Ljava/lang/String;
    //   923: aload 11
    //   925: ldc_w 498
    //   928: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   931: ifeq +30 -> 961
    //   934: aload 11
    //   936: ldc_w 498
    //   939: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   942: astore_1
    //   943: aload_1
    //   944: invokestatic 461	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   947: ifne +14 -> 961
    //   950: aload_0
    //   951: aload_1
    //   952: invokestatic 502	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   955: invokevirtual 505	java/lang/Integer:intValue	()I
    //   958: invokevirtual 508	com/baidu/location/BDLocation:setUserIndoorState	(I)V
    //   961: aload 11
    //   963: ldc_w 510
    //   966: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   969: ifeq +30 -> 999
    //   972: aload_0
    //   973: aload 11
    //   975: ldc_w 510
    //   978: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   981: putfield 203	com/baidu/location/BDLocation:netWorkLocationType	Ljava/lang/String;
    //   984: aload_0
    //   985: getfield 203	com/baidu/location/BDLocation:netWorkLocationType	Ljava/lang/String;
    //   988: invokestatic 461	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   991: ifeq +8 -> 999
    //   994: aload_0
    //   995: aconst_null
    //   996: putfield 203	com/baidu/location/BDLocation:netWorkLocationType	Ljava/lang/String;
    //   999: aload 11
    //   1001: ldc_w 512
    //   1004: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1007: ifeq +30 -> 1037
    //   1010: aload_0
    //   1011: aload 11
    //   1013: ldc_w 512
    //   1016: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1019: putfield 193	com/baidu/location/BDLocation:buildingid	Ljava/lang/String;
    //   1022: aload_0
    //   1023: getfield 193	com/baidu/location/BDLocation:buildingid	Ljava/lang/String;
    //   1026: invokestatic 461	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1029: ifeq +8 -> 1037
    //   1032: aload_0
    //   1033: aconst_null
    //   1034: putfield 193	com/baidu/location/BDLocation:buildingid	Ljava/lang/String;
    //   1037: aload 11
    //   1039: ldc_w 514
    //   1042: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1045: ifeq +30 -> 1075
    //   1048: aload_0
    //   1049: aload 11
    //   1051: ldc_w 514
    //   1054: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1057: putfield 195	com/baidu/location/BDLocation:mBuildingName	Ljava/lang/String;
    //   1060: aload_0
    //   1061: getfield 195	com/baidu/location/BDLocation:mBuildingName	Ljava/lang/String;
    //   1064: invokestatic 461	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1067: ifeq +8 -> 1075
    //   1070: aload_0
    //   1071: aconst_null
    //   1072: putfield 195	com/baidu/location/BDLocation:mBuildingName	Ljava/lang/String;
    //   1075: aload 11
    //   1077: ldc_w 516
    //   1080: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1083: ifeq +24 -> 1107
    //   1086: aload 11
    //   1088: ldc_w 516
    //   1091: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1094: astore_1
    //   1095: aload_1
    //   1096: invokestatic 461	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1099: ifeq +186 -> 1285
    //   1102: aload_0
    //   1103: iconst_0
    //   1104: putfield 199	com/baidu/location/BDLocation:mParkState	I
    //   1107: aload 11
    //   1109: ldc_w 518
    //   1112: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1115: istore_3
    //   1116: iload_3
    //   1117: ifeq +114 -> 1231
    //   1120: aload 11
    //   1122: ldc_w 518
    //   1125: invokevirtual 355	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1128: astore_1
    //   1129: aload_1
    //   1130: ldc_w 520
    //   1133: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1136: ifeq +26 -> 1162
    //   1139: aload_1
    //   1140: ldc_w 520
    //   1143: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1146: invokestatic 502	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1149: invokevirtual 505	java/lang/Integer:intValue	()I
    //   1152: istore_2
    //   1153: iload_2
    //   1154: ifne +163 -> 1317
    //   1157: aload_0
    //   1158: iconst_2
    //   1159: invokevirtual 523	com/baidu/location/BDLocation:setIndoorLocationSurpport	(I)V
    //   1162: aload_1
    //   1163: ldc_w 525
    //   1166: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1169: ifeq +20 -> 1189
    //   1172: aload_0
    //   1173: aload_1
    //   1174: ldc_w 525
    //   1177: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1180: invokestatic 502	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1183: invokevirtual 505	java/lang/Integer:intValue	()I
    //   1186: invokevirtual 528	com/baidu/location/BDLocation:setIndoorLocationSource	(I)V
    //   1189: aload_1
    //   1190: ldc_w 530
    //   1193: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1196: ifeq +14 -> 1210
    //   1199: aload_0
    //   1200: aload_1
    //   1201: ldc_w 530
    //   1204: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1207: putfield 217	com/baidu/location/BDLocation:mIndoorSurpportBuildingName	Ljava/lang/String;
    //   1210: aload_1
    //   1211: ldc_w 532
    //   1214: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1217: ifeq +14 -> 1231
    //   1220: aload_0
    //   1221: aload_1
    //   1222: ldc_w 532
    //   1225: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1228: putfield 219	com/baidu/location/BDLocation:mIndoorSurpportBuildingID	Ljava/lang/String;
    //   1231: aload 11
    //   1233: ldc_w 438
    //   1236: invokevirtual 430	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1239: ifeq +99 -> 1338
    //   1242: aload_0
    //   1243: aload 11
    //   1245: ldc_w 438
    //   1248: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1251: invokestatic 367	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1254: invokevirtual 441	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   1257: aload_0
    //   1258: getfield 201	com/baidu/location/BDLocation:mLocationWhere	I
    //   1261: ifne +89 -> 1350
    //   1264: aload_0
    //   1265: ldc_w 443
    //   1268: invokevirtual 446	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   1271: return
    //   1272: aload_0
    //   1273: iconst_0
    //   1274: putfield 170	com/baidu/location/BDLocation:mHasAddr	Z
    //   1277: aload_0
    //   1278: aconst_null
    //   1279: invokevirtual 535	com/baidu/location/BDLocation:setAddrStr	(Ljava/lang/String;)V
    //   1282: goto -397 -> 885
    //   1285: aload_1
    //   1286: ldc_w 537
    //   1289: invokevirtual 345	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1292: ifeq +11 -> 1303
    //   1295: aload_0
    //   1296: iconst_0
    //   1297: putfield 199	com/baidu/location/BDLocation:mParkState	I
    //   1300: goto -193 -> 1107
    //   1303: aload_0
    //   1304: aload_1
    //   1305: invokestatic 502	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1308: invokevirtual 505	java/lang/Integer:intValue	()I
    //   1311: putfield 199	com/baidu/location/BDLocation:mParkState	I
    //   1314: goto -207 -> 1107
    //   1317: iload_2
    //   1318: iconst_1
    //   1319: if_icmpne -157 -> 1162
    //   1322: aload_0
    //   1323: iconst_1
    //   1324: invokevirtual 523	com/baidu/location/BDLocation:setIndoorLocationSurpport	(I)V
    //   1327: goto -165 -> 1162
    //   1330: astore_1
    //   1331: aload_1
    //   1332: invokevirtual 449	java/lang/Exception:printStackTrace	()V
    //   1335: goto -104 -> 1231
    //   1338: aload_0
    //   1339: iconst_1
    //   1340: invokevirtual 441	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   1343: goto -86 -> 1257
    //   1346: astore_1
    //   1347: goto -90 -> 1257
    //   1350: aload_0
    //   1351: ldc_w 451
    //   1354: invokevirtual 446	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   1357: return
    //   1358: aload_1
    //   1359: ldc_w 378
    //   1362: invokevirtual 355	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1365: astore_1
    //   1366: aload_1
    //   1367: ldc_w 380
    //   1370: invokevirtual 355	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1373: astore 4
    //   1375: aload_0
    //   1376: aload 4
    //   1378: ldc_w 382
    //   1381: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1384: invokestatic 388	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   1387: invokevirtual 392	com/baidu/location/BDLocation:setLatitude	(D)V
    //   1390: aload_0
    //   1391: aload 4
    //   1393: ldc_w 394
    //   1396: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1399: invokestatic 388	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   1402: invokevirtual 397	com/baidu/location/BDLocation:setLongitude	(D)V
    //   1405: aload_0
    //   1406: aload_1
    //   1407: ldc_w 399
    //   1410: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1413: invokestatic 405	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   1416: invokevirtual 409	com/baidu/location/BDLocation:setRadius	(F)V
    //   1419: aload_0
    //   1420: aload_1
    //   1421: ldc_w 539
    //   1424: invokevirtual 361	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1427: invokestatic 544	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   1430: invokestatic 547	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1433: invokespecial 551	com/baidu/location/BDLocation:setCellChangeFlag	(Ljava/lang/Boolean;)V
    //   1436: aload_0
    //   1437: ldc_w 451
    //   1440: invokevirtual 446	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   1443: return
    //   1444: iload_2
    //   1445: sipush 167
    //   1448: if_icmpne -1221 -> 227
    //   1451: aload_0
    //   1452: iconst_2
    //   1453: invokevirtual 441	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   1456: return
    //   1457: astore 4
    //   1459: goto -1052 -> 407
    //   1462: aconst_null
    //   1463: astore 9
    //   1465: goto +103 -> 1568
    //   1468: aconst_null
    //   1469: astore 8
    //   1471: goto +84 -> 1555
    //   1474: aconst_null
    //   1475: astore 7
    //   1477: goto +67 -> 1544
    //   1480: aconst_null
    //   1481: astore 6
    //   1483: goto +50 -> 1533
    //   1486: aconst_null
    //   1487: astore 5
    //   1489: goto +33 -> 1522
    //   1492: aconst_null
    //   1493: astore 4
    //   1495: goto +16 -> 1511
    //   1498: aconst_null
    //   1499: astore_1
    //   1500: iload_2
    //   1501: iconst_1
    //   1502: if_icmple -10 -> 1492
    //   1505: aload 12
    //   1507: iconst_1
    //   1508: aaload
    //   1509: astore 4
    //   1511: iload_2
    //   1512: iconst_2
    //   1513: if_icmple -27 -> 1486
    //   1516: aload 12
    //   1518: iconst_2
    //   1519: aaload
    //   1520: astore 5
    //   1522: iload_2
    //   1523: iconst_3
    //   1524: if_icmple -44 -> 1480
    //   1527: aload 12
    //   1529: iconst_3
    //   1530: aaload
    //   1531: astore 6
    //   1533: iload_2
    //   1534: iconst_4
    //   1535: if_icmple -61 -> 1474
    //   1538: aload 12
    //   1540: iconst_4
    //   1541: aaload
    //   1542: astore 7
    //   1544: iload_2
    //   1545: iconst_5
    //   1546: if_icmple -78 -> 1468
    //   1549: aload 12
    //   1551: iconst_5
    //   1552: aaload
    //   1553: astore 8
    //   1555: iload_2
    //   1556: bipush 6
    //   1558: if_icmple -96 -> 1462
    //   1561: aload 12
    //   1563: bipush 6
    //   1565: aaload
    //   1566: astore 9
    //   1568: iload_2
    //   1569: bipush 7
    //   1571: if_icmple -744 -> 827
    //   1574: aload 12
    //   1576: bipush 7
    //   1578: aaload
    //   1579: astore 10
    //   1581: goto -754 -> 827
    //   1584: iload_2
    //   1585: bipush 66
    //   1587: if_icmpeq -229 -> 1358
    //   1590: iload_2
    //   1591: bipush 68
    //   1593: if_icmpne -149 -> 1444
    //   1596: goto -238 -> 1358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1599	0	this	BDLocation
    //   0	1599	1	paramString	String
    //   257	1337	2	i	int
    //   391	726	3	bool	boolean
    //   244	1148	4	localObject1	Object
    //   1457	1	4	localException	Exception
    //   1493	17	4	localObject2	Object
    //   635	886	5	localArrayList	ArrayList
    //   654	878	6	localJSONObject1	org.json.JSONObject
    //   664	879	7	str1	String
    //   854	700	8	str2	String
    //   835	732	9	str3	String
    //   1	1579	10	str4	String
    //   496	748	11	localJSONObject2	org.json.JSONObject
    //   809	766	12	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   228	275	446	java/lang/Exception
    //   281	392	446	java/lang/Exception
    //   431	445	446	java/lang/Exception
    //   474	481	446	java/lang/Exception
    //   489	603	446	java/lang/Exception
    //   603	637	446	java/lang/Exception
    //   639	699	446	java/lang/Exception
    //   706	712	446	java/lang/Exception
    //   715	721	446	java/lang/Exception
    //   721	754	446	java/lang/Exception
    //   754	784	446	java/lang/Exception
    //   784	815	446	java/lang/Exception
    //   827	885	446	java/lang/Exception
    //   885	923	446	java/lang/Exception
    //   923	961	446	java/lang/Exception
    //   961	999	446	java/lang/Exception
    //   999	1037	446	java/lang/Exception
    //   1037	1075	446	java/lang/Exception
    //   1075	1107	446	java/lang/Exception
    //   1107	1116	446	java/lang/Exception
    //   1257	1271	446	java/lang/Exception
    //   1272	1282	446	java/lang/Exception
    //   1285	1300	446	java/lang/Exception
    //   1303	1314	446	java/lang/Exception
    //   1331	1335	446	java/lang/Exception
    //   1350	1357	446	java/lang/Exception
    //   1358	1443	446	java/lang/Exception
    //   1451	1456	446	java/lang/Exception
    //   407	431	470	java/lang/Exception
    //   462	467	470	java/lang/Exception
    //   1120	1153	1330	java/lang/Exception
    //   1157	1162	1330	java/lang/Exception
    //   1162	1189	1330	java/lang/Exception
    //   1189	1210	1330	java/lang/Exception
    //   1210	1231	1330	java/lang/Exception
    //   1322	1327	1330	java/lang/Exception
    //   1231	1257	1346	java/lang/Exception
    //   1338	1343	1346	java/lang/Exception
    //   396	407	1457	java/lang/Exception
  }
  
  private void setCellChangeFlag(Boolean paramBoolean)
  {
    this.isCellChangeFlag = paramBoolean.booleanValue();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddrStr()
  {
    return this.mAddr.address;
  }
  
  public Address getAddress()
  {
    return this.mAddr;
  }
  
  public double getAltitude()
  {
    return this.mAltitude;
  }
  
  public String getBuildingID()
  {
    return this.buildingid;
  }
  
  public String getBuildingName()
  {
    return this.mBuildingName;
  }
  
  public String getCity()
  {
    return this.mAddr.city;
  }
  
  public String getCityCode()
  {
    return this.mAddr.cityCode;
  }
  
  public String getCoorType()
  {
    return this.mCoorType;
  }
  
  public String getCountry()
  {
    return this.mAddr.country;
  }
  
  public String getCountryCode()
  {
    return this.mAddr.countryCode;
  }
  
  @Deprecated
  public float getDerect()
  {
    return this.mDerect;
  }
  
  public float getDirection()
  {
    return this.mDerect;
  }
  
  public String getDistrict()
  {
    return this.mAddr.district;
  }
  
  public String getFloor()
  {
    return this.floor;
  }
  
  public int getGpsAccuracyStatus()
  {
    return this.mGpsAccuracyStatus;
  }
  
  public int getIndoorLocationSource()
  {
    return this.mIndoorSource;
  }
  
  public int getIndoorLocationSurpport()
  {
    return this.mIndoorLocationSurpport;
  }
  
  public String getIndoorLocationSurpportBuidlingID()
  {
    return this.mIndoorSurpportBuildingID;
  }
  
  public String getIndoorLocationSurpportBuidlingName()
  {
    return this.mIndoorSurpportBuildingName;
  }
  
  public int getIndoorNetworkState()
  {
    return this.mIndoorNetworkState;
  }
  
  public double getLatitude()
  {
    return this.mLatitude;
  }
  
  public int getLocType()
  {
    return this.mLocType;
  }
  
  public String getLocTypeDescription()
  {
    return this.mDescription;
  }
  
  public String getLocationDescribe()
  {
    return this.mSemaAptag;
  }
  
  public int getLocationWhere()
  {
    return this.mLocationWhere;
  }
  
  public double getLongitude()
  {
    return this.mLongitude;
  }
  
  public String getNetworkLocationType()
  {
    return this.netWorkLocationType;
  }
  
  public int getOperators()
  {
    return this.mOperators;
  }
  
  public List<Poi> getPoiList()
  {
    return this.mPoiList;
  }
  
  public String getProvince()
  {
    return this.mAddr.province;
  }
  
  public float getRadius()
  {
    return this.mRadius;
  }
  
  public int getSatelliteNumber()
  {
    this.mHasSateNumber = true;
    return this.mSatelliteNumber;
  }
  
  @Deprecated
  public String getSemaAptag()
  {
    return this.mSemaAptag;
  }
  
  public float getSpeed()
  {
    return this.mSpeed;
  }
  
  public String getStreet()
  {
    return this.mAddr.street;
  }
  
  public String getStreetNumber()
  {
    return this.mAddr.streetNumber;
  }
  
  public String getTime()
  {
    return this.mTime;
  }
  
  public int getUserIndoorState()
  {
    return this.mIndoorState;
  }
  
  public boolean hasAddr()
  {
    return this.mHasAddr;
  }
  
  public boolean hasAltitude()
  {
    return this.mHasAltitude;
  }
  
  public boolean hasRadius()
  {
    return this.mHasRadius;
  }
  
  public boolean hasSateNumber()
  {
    return this.mHasSateNumber;
  }
  
  public boolean hasSpeed()
  {
    return this.mHasSpeed;
  }
  
  public boolean isCellChangeFlag()
  {
    return this.isCellChangeFlag;
  }
  
  public boolean isIndoorLocMode()
  {
    return this.indoorLocMode;
  }
  
  public int isParkAvailable()
  {
    return this.mParkState;
  }
  
  public void setAddr(Address paramAddress)
  {
    if (paramAddress != null)
    {
      this.mAddr = paramAddress;
      this.mHasAddr = true;
    }
  }
  
  public void setAddrStr(String paramString)
  {
    this.mAddrStr = paramString;
    if (paramString == null)
    {
      this.mHasAddr = false;
      return;
    }
    this.mHasAddr = true;
  }
  
  public void setAltitude(double paramDouble)
  {
    this.mAltitude = paramDouble;
    this.mHasAltitude = true;
  }
  
  public void setBuildingID(String paramString)
  {
    this.buildingid = paramString;
  }
  
  public void setBuildingName(String paramString)
  {
    this.mBuildingName = paramString;
  }
  
  public void setCoorType(String paramString)
  {
    this.mCoorType = paramString;
  }
  
  public void setDirection(float paramFloat)
  {
    this.mDerect = paramFloat;
  }
  
  public void setFloor(String paramString)
  {
    this.floor = paramString;
  }
  
  public void setGpsAccuracyStatus(int paramInt)
  {
    this.mGpsAccuracyStatus = paramInt;
  }
  
  public void setIndoorLocMode(boolean paramBoolean)
  {
    this.indoorLocMode = paramBoolean;
  }
  
  public void setIndoorLocationSource(int paramInt)
  {
    this.mIndoorSource = paramInt;
  }
  
  public void setIndoorLocationSurpport(int paramInt)
  {
    this.mIndoorLocationSurpport = paramInt;
  }
  
  public void setIndoorNetworkState(int paramInt)
  {
    this.mIndoorNetworkState = paramInt;
  }
  
  public void setLatitude(double paramDouble)
  {
    this.mLatitude = paramDouble;
  }
  
  public void setLocType(int paramInt)
  {
    this.mLocType = paramInt;
    switch (paramInt)
    {
    default: 
      setLocTypeDescription("UnKnown!");
      return;
    case 62: 
      setLocTypeDescription("Location failed beacuse we can not get any loc information!");
      return;
    case 61: 
      setLocTypeDescription("GPS location successful!");
      setUserIndoorState(0);
      return;
    case 161: 
      setLocTypeDescription("NetWork location successful!");
      return;
    case 63: 
    case 67: 
      setLocTypeDescription("Offline location failed , please check the net (wifi/cell)!");
      return;
    case 66: 
      setLocTypeDescription("Offline location successful!");
      return;
    case 167: 
      setLocTypeDescription("NetWork location failed because baidu location service can not caculate the location!");
      return;
    case 162: 
      setLocTypeDescription("NetWork location failed because baidu location service can not decrypt the request query, please check the so file !");
      return;
    }
    setLocTypeDescription("NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !");
  }
  
  public void setLocTypeDescription(String paramString)
  {
    this.mDescription = paramString;
  }
  
  public void setLocationDescribe(String paramString)
  {
    this.mSemaAptag = paramString;
  }
  
  public void setLocationWhere(int paramInt)
  {
    this.mLocationWhere = paramInt;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.mLongitude = paramDouble;
  }
  
  public void setNetworkLocationType(String paramString)
  {
    this.netWorkLocationType = paramString;
  }
  
  public void setOperators(int paramInt)
  {
    this.mOperators = paramInt;
  }
  
  public void setParkAvailable(int paramInt)
  {
    this.mParkState = paramInt;
  }
  
  public void setPoiList(List<Poi> paramList)
  {
    this.mPoiList = paramList;
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
    this.mHasRadius = true;
  }
  
  public void setSatelliteNumber(int paramInt)
  {
    this.mSatelliteNumber = paramInt;
  }
  
  public void setSpeed(float paramFloat)
  {
    this.mSpeed = paramFloat;
    this.mHasSpeed = true;
  }
  
  public void setTime(String paramString)
  {
    this.mTime = paramString;
  }
  
  public void setUserIndoorState(int paramInt)
  {
    this.mIndoorState = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mLocType);
    paramParcel.writeString(this.mTime);
    paramParcel.writeDouble(this.mLatitude);
    paramParcel.writeDouble(this.mLongitude);
    paramParcel.writeDouble(this.mAltitude);
    paramParcel.writeFloat(this.mSpeed);
    paramParcel.writeFloat(this.mRadius);
    paramParcel.writeInt(this.mSatelliteNumber);
    paramParcel.writeFloat(this.mDerect);
    paramParcel.writeString(this.floor);
    paramParcel.writeInt(this.mParkState);
    paramParcel.writeString(this.buildingid);
    paramParcel.writeString(this.mBuildingName);
    paramParcel.writeString(this.netWorkLocationType);
    paramParcel.writeString(this.mAddr.province);
    paramParcel.writeString(this.mAddr.city);
    paramParcel.writeString(this.mAddr.district);
    paramParcel.writeString(this.mAddr.street);
    paramParcel.writeString(this.mAddr.streetNumber);
    paramParcel.writeString(this.mAddr.cityCode);
    paramParcel.writeString(this.mAddr.address);
    paramParcel.writeString(this.mAddr.country);
    paramParcel.writeString(this.mAddr.countryCode);
    paramParcel.writeInt(this.mOperators);
    paramParcel.writeString(this.mCu);
    paramParcel.writeString(this.mSemaAptag);
    paramParcel.writeString(this.mSemaPoiRegion);
    paramParcel.writeString(this.mSemaRegular);
    paramParcel.writeInt(this.mLocationWhere);
    paramParcel.writeString(this.mDescription);
    paramParcel.writeInt(this.mIndoorState);
    paramParcel.writeInt(this.mIndoorLocationSurpport);
    paramParcel.writeInt(this.mIndoorNetworkState);
    paramParcel.writeInt(this.mIndoorSource);
    paramParcel.writeString(this.mIndoorSurpportBuildingName);
    paramParcel.writeString(this.mIndoorSurpportBuildingID);
    paramParcel.writeInt(this.mGpsAccuracyStatus);
    paramParcel.writeBooleanArray(new boolean[] { this.mHasAltitude, this.mHasSpeed, this.mHasRadius, this.mHasSateNumber, this.mHasAddr, this.isCellChangeFlag, this.indoorLocMode });
    paramParcel.writeList(this.mPoiList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/BDLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */