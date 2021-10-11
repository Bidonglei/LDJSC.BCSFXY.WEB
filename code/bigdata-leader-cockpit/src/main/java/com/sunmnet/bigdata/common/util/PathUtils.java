package com.sunmnet.bigdata.common.util;

import java.io.File;

/**
 * 资源路径工具类
 */
public final class PathUtils {
    private PathUtils() {
    }

    /**
     * 将多个子路径连接为一个全路径
     * @param paths 子路径
     * @return 全路径
     */
    public static String join(String... paths) {
        String fullPath = "";

        for (String path : paths) {
            if (fullPath.equals("")) {
                fullPath += path;
                continue;
            }

            if (!fullPath.endsWith(File.separator) && !path.startsWith(File.separator)) {
                fullPath += (File.separator + path);
            } else if (fullPath.endsWith(File.separator) && path.startsWith(File.separator)) {
                fullPath += path.substring(1);
            } else {
                fullPath += path;
            }
        }

        return fullPath;
    }
}