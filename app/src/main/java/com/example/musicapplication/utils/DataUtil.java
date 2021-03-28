package com.example.musicapplication.utils;

import android.content.Context;
import android.content.res.AssetManager;

import com.blankj.utilcode.util.ToastUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author choosezzz
 * @date 3/28/21 7:21 PM
 */
public class DataUtil {

    private static final LoggerFactory.Logger logger = LoggerFactory.getLogger(DataUtil.class);

    public static String readFileFromAsset(Context context, String fileName) {

        StringBuilder sb = new StringBuilder();
        AssetManager assets = context.getAssets();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(assets.open(fileName)));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            ToastUtils.showLong("文件读取失败: " + fileName);
            logger.error("读取文件失败, fileName = " + fileName, e);
        }finally {
            assets.close();
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return sb.toString();
    }
}
