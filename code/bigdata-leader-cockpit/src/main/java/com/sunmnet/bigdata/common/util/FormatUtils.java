package com.sunmnet.bigdata.common.util;

import com.google.common.base.Preconditions;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 格式化工具类
 */
public final class FormatUtils {

    private FormatUtils() {}

    /**
     * 将省、直辖市、自治区、特别行政区格式化为简称
     * @param province 省、直辖市、自治区、特别行政区名称
     * @return 省、直辖市、自治区、特别行政区简称
     */
    public static String formatProvinceShorter(String province) {
        Preconditions.checkNotNull(province, "名称不能为空");
        return province.replace("省", "").replace("市", "").replace("自治区", "").
                replace("广西壮族", "广西").replace("宁夏回族", "宁夏").replace("新疆维吾尔", "新疆").
                replace("特别行政区", "");
    }

    /**
     * 将数字转换为人类可读的格式，保留两位小数
     *
     * @param number 需要转换的数字
     * @return 人类可读的数字
     */
    public static String formatNumberHumanReadable(double number) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.CHINESE);
        numberFormat.setMaximumFractionDigits(2);
        return numberFormat.format(number);
    }

    /**
     * 将数字转换为人类可读的格式，保留两位小数
     *
     * @param number 需要转换的数字
     * @param maxFractionDigits 最大小数位数
     * @return 人类可读的数字
     */
    public static String formatNumberHumanReadable(double number, int maxFractionDigits) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.CHINESE);
        numberFormat.setMaximumFractionDigits(maxFractionDigits);
        return numberFormat.format(number);
    }
}
