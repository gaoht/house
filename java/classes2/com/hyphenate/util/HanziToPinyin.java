package com.hyphenate.util;

import android.text.TextUtils;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;

public class HanziToPinyin
{
  private static final Collator COLLATOR = Collator.getInstance(Locale.CHINA);
  private static final boolean DEBUG = false;
  private static final String FIRST_PINYIN_UNIHAN = "阿";
  private static final String LAST_PINYIN_UNIHAN = "鿿";
  public static final byte[][] PINYINS;
  private static final String TAG = "HanziToPinyin";
  public static final char[] UNIHANS = { -27073, 21710, 23433, -32594, 20985, 20843, 25344, 25203, -28506, 21241, -27070, 22868, 20283, 23620, -28743, 28780, 24971, 27715, 20907, 30326, 23788, 22163, 20594, 21442, 20179, 25761, 20874, 23934, 26365, 26366, 23652, 21449, -32122, -28737, 20261, 25220, -28826, 25275, 27784, 27785, -27081, 21507, 20805, 25277, 20986, 27451, 25571, 24027, 20997, 21561, 26110, -28620, 21618, 21254, 20945, 31895, 27718, 23828, -28504, 25619, 21649, 21574, 20025, 24403, 20992, 22042, 25189, 28783, 27664, 22002, 30008, 20993, 29241, 19969, 19999, 19996, 21562, 21438, -32751, -30360, 21544, 22810, 22968, -29706, 22848, -26715, 20799, 21457, 24070, 21274, -26402, 20998, 20016, -30331, 20175, 32017, 20245, 26094, 20357, 29976, 20872, 30347, 25096, 32473, 26681, 21039, 24037, 21246, 20272, 29916, 20054, 20851, 20809, 24402, 20008, 21593, 21704, 21645, 20292, 22831, -31968, -29757, -24878, 25323, 20136, 22135, 21503, -24767, 20079, -32079, 24576, 29375, 24031, 28784, 26127, 21529, 19980, 21152, 25099, 27743, -32131, -27082, 24062, 22357, 20866, 20009, 20965, 23010, 22104, 20891, 21652, 24320, 21002, 24572, 23611, 21308, -32626, 21157, 31354, 25248, 25181, 22840, -31569, 23485, 21281, 20111, 22372, 25193, 22403, 26469, 20848, 21879, 25438, -32629, 21202, 23834, 21013, 20457, 22849, -32145, 25769, 21015, 25294, 21026, 28316, 22230, -24679, 30620, 22108, 23048, 30055, 25249, 32599, 21603, 22920, 22475, 23258, 29284, 29483, 20040, 21573, -27160, 30015, 21674, 23424, 21941, 20060, 27665, 21517, -29652, 25720, 21726, 27626, 21999, 25295, -32439, 22241, 22228, 23404, 30098, 23070, 24641, -32515, 22958, 25288, 23330, -25057, 25423, 22236, 23425, 22942, 20892, 32698, 22900, 22907, 30111, -24895, -28467, 21908, -29772, 22929, 25293, 30469, 20051, 25243, 21624, 21943, 21257, 19989, 22248, 21117, 27669, 23000, 20050, -27509, 21078, 20166, 19971, 25488, 21315, 21595, 24708, 30335, 20146, 29381, -32114, 19992, 21306, 23761, 32570, 22795, 21605, 31331, 23046, 24825, 20154, 25172, 26085, -31944, 21433, -28518, 25404, 22567, 23121, 30628, 25468, 20200, 27618, 19977, 26706, 25531, -27222, 26862, 20711, 26432, 31579, 23665, 20260, 24368, 22882, 30003, -31848, 25938, 21319, 23608, 21454, 20070, 21047, -30608, -27159, 21452, -29695, 21550, -29708, 21430, 24554, 25436, -32049, 29435, 22794, 23385, 21766, 20182, 22268, 22349, 27748, 22834, 24529, 29093, 21076, 22825, 26091, 24086, 21381, 22258, 20599, 20984, 28237, 25512, 21534, 20039, 31349, 27498, 24367, 23587, 21361, 26167, 32705, 25373, 20044, 22805, -31118, 20186, 20065, 28785, 20123, 24515, 26143, 20982, 20241, 21505, 21509, 21066, 22339, 20011, 24697, 22830, 24186, 20539, 19968, 22233, 24212, 21727, 20323, 20248, 25180, 22246, 26352, 26197, 31584, 31612, 24064, 28797, 20802, 21288, 20654, 21017, -29380, 24590, 22679, 25166, 25434, 27838, 24352, -27265, -27273, 20299, -30969, -29410, 20105, 20043, 23769, 24226, 20013, 24030, 26417, 25235, 25341, 19987, 22918, -26951, 23442, 21331, 20082, 23447, -28487, 31199, -27461, 21404, 23562, 26152, 20825, -24637, -24636 };
  private static HanziToPinyin sInstance;
  private final boolean mHasChinaCollator;
  
  static
  {
    byte[] arrayOfByte1 = { 65, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte2 = { 67, 72, 65, 0, 0, 0 };
    byte[] arrayOfByte3 = { 67, 72, 65, 73, 0, 0 };
    byte[] arrayOfByte4 = { 67, 72, 65, 79, 0, 0 };
    byte[] arrayOfByte5 = { 83, 72, 69, 78, 0, 0 };
    byte[] arrayOfByte6 = { 68, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte7 = { 68, 73, 65, 78, 0, 0 };
    byte[] arrayOfByte8 = { 71, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte9 = { 71, 85, 65, 0, 0, 0 };
    byte[] arrayOfByte10 = { 74, 73, 79, 78, 71, 0 };
    byte[] arrayOfByte11 = { 74, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte12 = { 75, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte13 = { 76, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte14 = { 76, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte15 = { 76, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte16 = { 76, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte17 = { 77, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte18 = { 77, 73, 85, 0, 0, 0 };
    byte[] arrayOfByte19 = { 78, 73, 65, 79, 0, 0 };
    byte[] arrayOfByte20 = { 78, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte21 = { 81, 73, 65, 78, 0, 0 };
    byte[] arrayOfByte22 = { 81, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte23 = { 82, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte24 = { 83, 72, 69, 78, 71, 0 };
    byte[] arrayOfByte25 = { 83, 72, 85, 79, 0, 0 };
    byte[] arrayOfByte26 = { 83, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte27 = { 83, 85, 73, 0, 0, 0 };
    byte[] arrayOfByte28 = { 84, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte29 = { 84, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte30 = { 88, 73, 79, 78, 71, 0 };
    byte[] arrayOfByte31 = { 88, 85, 69, 0, 0, 0 };
    byte[] arrayOfByte32 = { 89, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte33 = { 89, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte34 = { 89, 79, 78, 71, 0, 0 };
    byte[] arrayOfByte35 = { 89, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte36 = { 90, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte37 = { 90, 72, 73, 0, 0, 0 };
    PINYINS = new byte[][] { { 65, 0, 0, 0, 0, 0 }, arrayOfByte1, { 65, 78, 0, 0, 0, 0 }, { 65, 78, 71, 0, 0, 0 }, { 65, 79, 0, 0, 0, 0 }, { 66, 65, 0, 0, 0, 0 }, { 66, 65, 73, 0, 0, 0 }, { 66, 65, 78, 0, 0, 0 }, { 66, 65, 78, 71, 0, 0 }, { 66, 65, 79, 0, 0, 0 }, { 66, 69, 73, 0, 0, 0 }, { 66, 69, 78, 0, 0, 0 }, { 66, 69, 78, 71, 0, 0 }, { 66, 73, 0, 0, 0, 0 }, { 66, 73, 65, 78, 0, 0 }, { 66, 73, 65, 79, 0, 0 }, { 66, 73, 69, 0, 0, 0 }, { 66, 73, 78, 0, 0, 0 }, { 66, 73, 78, 71, 0, 0 }, { 66, 79, 0, 0, 0, 0 }, { 66, 85, 0, 0, 0, 0 }, { 67, 65, 0, 0, 0, 0 }, { 67, 65, 73, 0, 0, 0 }, { 67, 65, 78, 0, 0, 0 }, { 67, 65, 78, 71, 0, 0 }, { 67, 65, 79, 0, 0, 0 }, { 67, 69, 0, 0, 0, 0 }, { 67, 69, 78, 0, 0, 0 }, { 67, 69, 78, 71, 0, 0 }, { 90, 69, 78, 71, 0, 0 }, { 67, 69, 78, 71, 0, 0 }, arrayOfByte2, arrayOfByte3, { 67, 72, 65, 78, 0, 0 }, { 67, 72, 65, 78, 71, 0 }, arrayOfByte4, { 67, 72, 69, 0, 0, 0 }, { 67, 72, 69, 78, 0, 0 }, arrayOfByte5, { 67, 72, 69, 78, 0, 0 }, { 67, 72, 69, 78, 71, 0 }, { 67, 72, 73, 0, 0, 0 }, { 67, 72, 79, 78, 71, 0 }, { 67, 72, 79, 85, 0, 0 }, { 67, 72, 85, 0, 0, 0 }, { 67, 72, 85, 65, 0, 0 }, { 67, 72, 85, 65, 73, 0 }, { 67, 72, 85, 65, 78, 0 }, { 67, 72, 85, 65, 78, 71 }, { 67, 72, 85, 73, 0, 0 }, { 67, 72, 85, 78, 0, 0 }, { 67, 72, 85, 79, 0, 0 }, { 67, 73, 0, 0, 0, 0 }, { 67, 79, 78, 71, 0, 0 }, { 67, 79, 85, 0, 0, 0 }, { 67, 85, 0, 0, 0, 0 }, { 67, 85, 65, 78, 0, 0 }, { 67, 85, 73, 0, 0, 0 }, { 67, 85, 78, 0, 0, 0 }, { 67, 85, 79, 0, 0, 0 }, { 68, 65, 0, 0, 0, 0 }, arrayOfByte6, { 68, 65, 78, 0, 0, 0 }, { 68, 65, 78, 71, 0, 0 }, { 68, 65, 79, 0, 0, 0 }, { 68, 69, 0, 0, 0, 0 }, { 68, 69, 78, 0, 0, 0 }, { 68, 69, 78, 71, 0, 0 }, { 68, 73, 0, 0, 0, 0 }, { 68, 73, 65, 0, 0, 0 }, arrayOfByte7, { 68, 73, 65, 79, 0, 0 }, { 68, 73, 69, 0, 0, 0 }, { 68, 73, 78, 71, 0, 0 }, { 68, 73, 85, 0, 0, 0 }, { 68, 79, 78, 71, 0, 0 }, { 68, 79, 85, 0, 0, 0 }, { 68, 85, 0, 0, 0, 0 }, { 68, 85, 65, 78, 0, 0 }, { 68, 85, 73, 0, 0, 0 }, { 68, 85, 78, 0, 0, 0 }, { 68, 85, 79, 0, 0, 0 }, { 69, 0, 0, 0, 0, 0 }, { 69, 73, 0, 0, 0, 0 }, { 69, 78, 0, 0, 0, 0 }, { 69, 78, 71, 0, 0, 0 }, { 69, 82, 0, 0, 0, 0 }, { 70, 65, 0, 0, 0, 0 }, { 70, 65, 78, 0, 0, 0 }, { 70, 65, 78, 71, 0, 0 }, { 70, 69, 73, 0, 0, 0 }, { 70, 69, 78, 0, 0, 0 }, { 70, 69, 78, 71, 0, 0 }, { 70, 73, 65, 79, 0, 0 }, { 70, 79, 0, 0, 0, 0 }, { 70, 79, 85, 0, 0, 0 }, { 70, 85, 0, 0, 0, 0 }, { 71, 65, 0, 0, 0, 0 }, { 71, 65, 73, 0, 0, 0 }, arrayOfByte8, { 71, 65, 78, 71, 0, 0 }, { 71, 65, 79, 0, 0, 0 }, { 71, 69, 0, 0, 0, 0 }, { 71, 69, 73, 0, 0, 0 }, { 71, 69, 78, 0, 0, 0 }, { 71, 69, 78, 71, 0, 0 }, { 71, 79, 78, 71, 0, 0 }, { 71, 79, 85, 0, 0, 0 }, { 71, 85, 0, 0, 0, 0 }, arrayOfByte9, { 71, 85, 65, 73, 0, 0 }, { 71, 85, 65, 78, 0, 0 }, { 71, 85, 65, 78, 71, 0 }, { 71, 85, 73, 0, 0, 0 }, { 71, 85, 78, 0, 0, 0 }, { 71, 85, 79, 0, 0, 0 }, { 72, 65, 0, 0, 0, 0 }, { 72, 65, 73, 0, 0, 0 }, { 72, 65, 78, 0, 0, 0 }, { 72, 65, 78, 71, 0, 0 }, { 72, 65, 79, 0, 0, 0 }, { 72, 69, 0, 0, 0, 0 }, { 72, 69, 73, 0, 0, 0 }, { 72, 69, 78, 0, 0, 0 }, { 72, 69, 78, 71, 0, 0 }, { 72, 77, 0, 0, 0, 0 }, { 72, 79, 78, 71, 0, 0 }, { 72, 79, 85, 0, 0, 0 }, { 72, 85, 0, 0, 0, 0 }, { 72, 85, 65, 0, 0, 0 }, { 72, 85, 65, 73, 0, 0 }, { 72, 85, 65, 78, 0, 0 }, { 72, 85, 65, 78, 71, 0 }, { 72, 85, 73, 0, 0, 0 }, { 72, 85, 78, 0, 0, 0 }, { 72, 85, 79, 0, 0, 0 }, { 74, 73, 0, 0, 0, 0 }, { 74, 73, 65, 0, 0, 0 }, { 74, 73, 65, 78, 0, 0 }, { 74, 73, 65, 78, 71, 0 }, { 74, 73, 65, 79, 0, 0 }, { 74, 73, 69, 0, 0, 0 }, { 74, 73, 78, 0, 0, 0 }, { 74, 73, 78, 71, 0, 0 }, arrayOfByte10, { 74, 73, 85, 0, 0, 0 }, { 74, 85, 0, 0, 0, 0 }, { 74, 85, 65, 78, 0, 0 }, { 74, 85, 69, 0, 0, 0 }, arrayOfByte11, { 75, 65, 0, 0, 0, 0 }, { 75, 65, 73, 0, 0, 0 }, { 75, 65, 78, 0, 0, 0 }, { 75, 65, 78, 71, 0, 0 }, arrayOfByte12, { 75, 69, 0, 0, 0, 0 }, { 75, 69, 78, 0, 0, 0 }, { 75, 69, 78, 71, 0, 0 }, { 75, 79, 78, 71, 0, 0 }, { 75, 79, 85, 0, 0, 0 }, { 75, 85, 0, 0, 0, 0 }, { 75, 85, 65, 0, 0, 0 }, { 75, 85, 65, 73, 0, 0 }, { 75, 85, 65, 78, 0, 0 }, { 75, 85, 65, 78, 71, 0 }, { 75, 85, 73, 0, 0, 0 }, { 75, 85, 78, 0, 0, 0 }, { 75, 85, 79, 0, 0, 0 }, { 76, 65, 0, 0, 0, 0 }, arrayOfByte13, { 76, 65, 78, 0, 0, 0 }, { 76, 65, 78, 71, 0, 0 }, { 76, 65, 79, 0, 0, 0 }, arrayOfByte14, { 76, 69, 73, 0, 0, 0 }, { 76, 69, 78, 71, 0, 0 }, arrayOfByte15, { 76, 73, 65, 0, 0, 0 }, { 76, 73, 65, 78, 0, 0 }, { 76, 73, 65, 78, 71, 0 }, { 76, 73, 65, 79, 0, 0 }, { 76, 73, 69, 0, 0, 0 }, { 76, 73, 78, 0, 0, 0 }, { 76, 73, 78, 71, 0, 0 }, { 76, 73, 85, 0, 0, 0 }, { 76, 79, 0, 0, 0, 0 }, { 76, 79, 78, 71, 0, 0 }, { 76, 79, 85, 0, 0, 0 }, { 76, 85, 0, 0, 0, 0 }, arrayOfByte16, { 76, 85, 69, 0, 0, 0 }, { 76, 85, 78, 0, 0, 0 }, { 76, 85, 79, 0, 0, 0 }, { 77, 0, 0, 0, 0, 0 }, { 77, 65, 0, 0, 0, 0 }, { 77, 65, 73, 0, 0, 0 }, { 77, 65, 78, 0, 0, 0 }, { 77, 65, 78, 71, 0, 0 }, { 77, 65, 79, 0, 0, 0 }, { 77, 69, 0, 0, 0, 0 }, { 77, 69, 73, 0, 0, 0 }, arrayOfByte17, { 77, 69, 78, 71, 0, 0 }, { 77, 73, 0, 0, 0, 0 }, { 77, 73, 65, 78, 0, 0 }, { 77, 73, 65, 79, 0, 0 }, { 77, 73, 69, 0, 0, 0 }, { 77, 73, 78, 0, 0, 0 }, { 77, 73, 78, 71, 0, 0 }, arrayOfByte18, { 77, 79, 0, 0, 0, 0 }, { 77, 79, 85, 0, 0, 0 }, { 77, 85, 0, 0, 0, 0 }, { 78, 0, 0, 0, 0, 0 }, { 78, 65, 0, 0, 0, 0 }, { 78, 65, 73, 0, 0, 0 }, { 78, 65, 78, 0, 0, 0 }, { 78, 65, 78, 71, 0, 0 }, { 78, 65, 79, 0, 0, 0 }, { 78, 69, 0, 0, 0, 0 }, { 78, 69, 73, 0, 0, 0 }, { 78, 69, 78, 0, 0, 0 }, { 78, 69, 78, 71, 0, 0 }, { 78, 73, 0, 0, 0, 0 }, { 78, 73, 65, 78, 0, 0 }, { 78, 73, 65, 78, 71, 0 }, arrayOfByte19, { 78, 73, 69, 0, 0, 0 }, { 78, 73, 78, 0, 0, 0 }, arrayOfByte20, { 78, 73, 85, 0, 0, 0 }, { 78, 79, 78, 71, 0, 0 }, { 78, 79, 85, 0, 0, 0 }, { 78, 85, 0, 0, 0, 0 }, { 78, 85, 65, 78, 0, 0 }, { 78, 85, 69, 0, 0, 0 }, { 78, 85, 78, 0, 0, 0 }, { 78, 85, 79, 0, 0, 0 }, { 79, 0, 0, 0, 0, 0 }, { 79, 85, 0, 0, 0, 0 }, { 80, 65, 0, 0, 0, 0 }, { 80, 65, 73, 0, 0, 0 }, { 80, 65, 78, 0, 0, 0 }, { 80, 65, 78, 71, 0, 0 }, { 80, 65, 79, 0, 0, 0 }, { 80, 69, 73, 0, 0, 0 }, { 80, 69, 78, 0, 0, 0 }, { 80, 69, 78, 71, 0, 0 }, { 80, 73, 0, 0, 0, 0 }, { 80, 73, 65, 78, 0, 0 }, { 80, 73, 65, 79, 0, 0 }, { 80, 73, 69, 0, 0, 0 }, { 80, 73, 78, 0, 0, 0 }, { 80, 73, 78, 71, 0, 0 }, { 80, 79, 0, 0, 0, 0 }, { 80, 79, 85, 0, 0, 0 }, { 80, 85, 0, 0, 0, 0 }, { 81, 73, 0, 0, 0, 0 }, { 81, 73, 65, 0, 0, 0 }, arrayOfByte21, { 81, 73, 65, 78, 71, 0 }, { 81, 73, 65, 79, 0, 0 }, { 81, 73, 69, 0, 0, 0 }, { 81, 73, 78, 0, 0, 0 }, { 81, 73, 78, 71, 0, 0 }, { 81, 73, 79, 78, 71, 0 }, { 81, 73, 85, 0, 0, 0 }, arrayOfByte22, { 81, 85, 65, 78, 0, 0 }, { 81, 85, 69, 0, 0, 0 }, { 81, 85, 78, 0, 0, 0 }, { 82, 65, 78, 0, 0, 0 }, { 82, 65, 78, 71, 0, 0 }, arrayOfByte23, { 82, 69, 0, 0, 0, 0 }, { 82, 69, 78, 0, 0, 0 }, { 82, 69, 78, 71, 0, 0 }, { 82, 73, 0, 0, 0, 0 }, { 82, 79, 78, 71, 0, 0 }, { 82, 79, 85, 0, 0, 0 }, { 82, 85, 0, 0, 0, 0 }, { 82, 85, 65, 0, 0, 0 }, { 82, 85, 65, 78, 0, 0 }, { 82, 85, 73, 0, 0, 0 }, { 82, 85, 78, 0, 0, 0 }, { 82, 85, 79, 0, 0, 0 }, { 83, 65, 0, 0, 0, 0 }, { 83, 65, 73, 0, 0, 0 }, { 83, 65, 78, 0, 0, 0 }, { 83, 65, 78, 71, 0, 0 }, { 83, 65, 79, 0, 0, 0 }, { 83, 69, 0, 0, 0, 0 }, { 83, 69, 78, 0, 0, 0 }, { 83, 69, 78, 71, 0, 0 }, { 83, 72, 65, 0, 0, 0 }, { 83, 72, 65, 73, 0, 0 }, { 83, 72, 65, 78, 0, 0 }, { 83, 72, 65, 78, 71, 0 }, { 83, 72, 65, 79, 0, 0 }, { 83, 72, 69, 0, 0, 0 }, { 83, 72, 69, 78, 0, 0 }, { 88, 73, 78, 0, 0, 0 }, { 83, 72, 69, 78, 0, 0 }, arrayOfByte24, { 83, 72, 73, 0, 0, 0 }, { 83, 72, 79, 85, 0, 0 }, { 83, 72, 85, 0, 0, 0 }, { 83, 72, 85, 65, 0, 0 }, { 83, 72, 85, 65, 73, 0 }, { 83, 72, 85, 65, 78, 0 }, { 83, 72, 85, 65, 78, 71 }, { 83, 72, 85, 73, 0, 0 }, { 83, 72, 85, 78, 0, 0 }, arrayOfByte25, { 83, 73, 0, 0, 0, 0 }, { 83, 79, 78, 71, 0, 0 }, { 83, 79, 85, 0, 0, 0 }, { 83, 85, 0, 0, 0, 0 }, arrayOfByte26, arrayOfByte27, { 83, 85, 78, 0, 0, 0 }, { 83, 85, 79, 0, 0, 0 }, { 84, 65, 0, 0, 0, 0 }, { 84, 65, 73, 0, 0, 0 }, { 84, 65, 78, 0, 0, 0 }, { 84, 65, 78, 71, 0, 0 }, arrayOfByte28, { 84, 69, 0, 0, 0, 0 }, { 84, 69, 78, 71, 0, 0 }, arrayOfByte29, { 84, 73, 65, 78, 0, 0 }, { 84, 73, 65, 79, 0, 0 }, { 84, 73, 69, 0, 0, 0 }, { 84, 73, 78, 71, 0, 0 }, { 84, 79, 78, 71, 0, 0 }, { 84, 79, 85, 0, 0, 0 }, { 84, 85, 0, 0, 0, 0 }, { 84, 85, 65, 78, 0, 0 }, { 84, 85, 73, 0, 0, 0 }, { 84, 85, 78, 0, 0, 0 }, { 84, 85, 79, 0, 0, 0 }, { 87, 65, 0, 0, 0, 0 }, { 87, 65, 73, 0, 0, 0 }, { 87, 65, 78, 0, 0, 0 }, { 87, 65, 78, 71, 0, 0 }, { 87, 69, 73, 0, 0, 0 }, { 87, 69, 78, 0, 0, 0 }, { 87, 69, 78, 71, 0, 0 }, { 87, 79, 0, 0, 0, 0 }, { 87, 85, 0, 0, 0, 0 }, { 88, 73, 0, 0, 0, 0 }, { 88, 73, 65, 0, 0, 0 }, { 88, 73, 65, 78, 0, 0 }, { 88, 73, 65, 78, 71, 0 }, { 88, 73, 65, 79, 0, 0 }, { 88, 73, 69, 0, 0, 0 }, { 88, 73, 78, 0, 0, 0 }, { 88, 73, 78, 71, 0, 0 }, arrayOfByte30, { 88, 73, 85, 0, 0, 0 }, { 88, 85, 0, 0, 0, 0 }, { 88, 85, 65, 78, 0, 0 }, arrayOfByte31, { 88, 85, 78, 0, 0, 0 }, { 89, 65, 0, 0, 0, 0 }, { 89, 65, 78, 0, 0, 0 }, arrayOfByte32, { 89, 65, 79, 0, 0, 0 }, arrayOfByte33, { 89, 73, 0, 0, 0, 0 }, { 89, 73, 78, 0, 0, 0 }, { 89, 73, 78, 71, 0, 0 }, { 89, 79, 0, 0, 0, 0 }, arrayOfByte34, { 89, 79, 85, 0, 0, 0 }, { 89, 85, 0, 0, 0, 0 }, { 89, 85, 65, 78, 0, 0 }, { 89, 85, 69, 0, 0, 0 }, { 89, 85, 78, 0, 0, 0 }, { 74, 85, 78, 0, 0, 0 }, arrayOfByte35, { 90, 65, 0, 0, 0, 0 }, { 90, 65, 73, 0, 0, 0 }, { 90, 65, 78, 0, 0, 0 }, { 90, 65, 78, 71, 0, 0 }, { 90, 65, 79, 0, 0, 0 }, { 90, 69, 0, 0, 0, 0 }, { 90, 69, 73, 0, 0, 0 }, { 90, 69, 78, 0, 0, 0 }, arrayOfByte36, { 90, 72, 65, 0, 0, 0 }, { 90, 72, 65, 73, 0, 0 }, { 90, 72, 65, 78, 0, 0 }, { 90, 72, 65, 78, 71, 0 }, { 67, 72, 65, 78, 71, 0 }, { 90, 72, 65, 78, 71, 0 }, { 90, 72, 65, 79, 0, 0 }, { 90, 72, 69, 0, 0, 0 }, { 90, 72, 69, 78, 0, 0 }, { 90, 72, 69, 78, 71, 0 }, { 90, 72, 73, 0, 0, 0 }, { 83, 72, 73, 0, 0, 0 }, arrayOfByte37, { 90, 72, 79, 78, 71, 0 }, { 90, 72, 79, 85, 0, 0 }, { 90, 72, 85, 0, 0, 0 }, { 90, 72, 85, 65, 0, 0 }, { 90, 72, 85, 65, 73, 0 }, { 90, 72, 85, 65, 78, 0 }, { 90, 72, 85, 65, 78, 71 }, { 90, 72, 85, 73, 0, 0 }, { 90, 72, 85, 78, 0, 0 }, { 90, 72, 85, 79, 0, 0 }, { 90, 73, 0, 0, 0, 0 }, { 90, 79, 78, 71, 0, 0 }, { 90, 79, 85, 0, 0, 0 }, { 90, 85, 0, 0, 0, 0 }, { 90, 85, 65, 78, 0, 0 }, { 90, 85, 73, 0, 0, 0 }, { 90, 85, 78, 0, 0, 0 }, { 90, 85, 79, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 83, 72, 65, 78, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
  }
  
  protected HanziToPinyin(boolean paramBoolean)
  {
    this.mHasChinaCollator = paramBoolean;
  }
  
  private void addToken(StringBuilder paramStringBuilder, ArrayList<Token> paramArrayList, int paramInt)
  {
    String str = paramStringBuilder.toString();
    paramArrayList.add(new Token(paramInt, str, str));
    paramStringBuilder.setLength(0);
  }
  
  private static boolean doSelfValidation()
  {
    char c1 = UNIHANS[0];
    Object localObject = Character.toString(c1);
    char[] arrayOfChar = UNIHANS;
    int j = arrayOfChar.length;
    int i = 0;
    if (i < j)
    {
      char c2 = arrayOfChar[i];
      if (c1 == c2) {}
      for (;;)
      {
        i += 1;
        break;
        String str = Character.toString(c2);
        if (COLLATOR.compare((String)localObject, str) >= 0)
        {
          EMLog.e("HanziToPinyin", "Internal error in Unihan table. The last string \"" + (String)localObject + "\" is greater than current string \"" + str + "\".");
          return false;
        }
        localObject = str;
      }
    }
    return true;
  }
  
  public static HanziToPinyin getInstance()
  {
    for (;;)
    {
      int i;
      try
      {
        if (sInstance != null)
        {
          localObject1 = sInstance;
          return (HanziToPinyin)localObject1;
        }
        Object localObject1 = Collator.getAvailableLocales();
        int j = localObject1.length;
        i = 0;
        if (i >= j) {
          break;
        }
        Object localObject3 = localObject1[i];
        if ((((Locale)localObject3).equals(Locale.CHINA)) || ((((Locale)localObject3).getLanguage().equals("zh")) && (((Locale)localObject3).getCountry().equals("HANS"))))
        {
          sInstance = new HanziToPinyin(true);
          localObject1 = sInstance;
          return (HanziToPinyin)localObject1;
        }
      }
      finally {}
      i += 1;
    }
    EMLog.w("HanziToPinyin", "There is no Chinese collator, HanziToPinyin is disabled");
    sInstance = new HanziToPinyin(true);
    HanziToPinyin localHanziToPinyin = sInstance;
    return localHanziToPinyin;
  }
  
  private Token getToken(char paramChar)
  {
    int n = 0;
    Token localToken = new Token();
    Object localObject = Character.toString(paramChar);
    localToken.source = ((String)localObject);
    int i = -1;
    if (paramChar < 'Ā')
    {
      localToken.type = 1;
      localToken.target = ((String)localObject);
      return localToken;
    }
    int j = COLLATOR.compare((String)localObject, "阿");
    if (j < 0)
    {
      localToken.type = 3;
      localToken.target = ((String)localObject);
      return localToken;
    }
    int m;
    int k;
    if (j == 0)
    {
      localToken.type = 2;
      i = 0;
      localToken.type = 2;
      if (i >= 0) {
        break label349;
      }
      m = UNIHANS.length;
      k = 0;
      m -= 1;
      label118:
      if (k > m) {
        break label346;
      }
      i = (k + m) / 2;
      String str = Character.toString(UNIHANS[i]);
      j = COLLATOR.compare((String)localObject, str);
      if (j != 0) {
        break label286;
      }
    }
    label286:
    label346:
    label349:
    for (;;)
    {
      k = i;
      if (j < 0) {
        k = i - 1;
      }
      localObject = new StringBuilder();
      i = n;
      for (;;)
      {
        if ((i < PINYINS[k].length) && (PINYINS[k][i] != 0))
        {
          ((StringBuilder)localObject).append((char)PINYINS[k][i]);
          i += 1;
          continue;
          k = COLLATOR.compare((String)localObject, "鿿");
          if (k > 0)
          {
            localToken.type = 3;
            localToken.target = ((String)localObject);
            return localToken;
          }
          j = k;
          if (k != 0) {
            break;
          }
          localToken.type = 2;
          i = UNIHANS.length - 1;
          j = k;
          break;
          if (j > 0)
          {
            k = i + 1;
            break label118;
          }
          m = i - 1;
          break label118;
        }
      }
      localToken.target = ((StringBuilder)localObject).toString();
      if (TextUtils.isEmpty(localToken.target))
      {
        localToken.type = 3;
        localToken.target = localToken.source;
      }
      return localToken;
    }
  }
  
  public ArrayList<Token> get(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((!this.mHasChinaCollator) || (TextUtils.isEmpty(paramString))) {
      return localArrayList;
    }
    int m = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    int k = 1;
    if (j < m)
    {
      char c = paramString.charAt(j);
      int i;
      if (c == ' ')
      {
        i = k;
        if (localStringBuilder.length() > 0)
        {
          addToken(localStringBuilder, localArrayList, k);
          i = k;
        }
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        if (c < 'Ā')
        {
          if ((k != 1) && (localStringBuilder.length() > 0)) {
            addToken(localStringBuilder, localArrayList, k);
          }
          localStringBuilder.append(c);
          i = 1;
        }
        else
        {
          Token localToken = getToken(c);
          if (localToken.type == 2)
          {
            if (localStringBuilder.length() > 0) {
              addToken(localStringBuilder, localArrayList, k);
            }
            localArrayList.add(localToken);
            i = 2;
          }
          else
          {
            if ((k != localToken.type) && (localStringBuilder.length() > 0)) {
              addToken(localStringBuilder, localArrayList, k);
            }
            i = localToken.type;
            localStringBuilder.append(c);
          }
        }
      }
    }
    if (localStringBuilder.length() > 0) {
      addToken(localStringBuilder, localArrayList, k);
    }
    return localArrayList;
  }
  
  public static class Token
  {
    public static final int LATIN = 1;
    public static final int PINYIN = 2;
    public static final String SEPARATOR = " ";
    public static final int UNKNOWN = 3;
    public String source;
    public String target;
    public int type;
    
    public Token() {}
    
    public Token(int paramInt, String paramString1, String paramString2)
    {
      this.type = paramInt;
      this.source = paramString1;
      this.target = paramString2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/HanziToPinyin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */