/*******************************************************************************
 *  システム名 : 学生情報管理
 *  著作権    : Copyright (C)　2002-2008　Realsys Co. Ltd. 　All Rights Reserved.
 *  会社名    : リアルシス株式会社
 *  ****************************************************************************
 *  変更履歴
 *  2008/03/20  作成　
 */
package jp.co.realsys.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import jp.co.realsys.error.TaskException;

/**
 * コンフィギュレーションクラス
 * 
 * @author Realsys
 */
public class ConfigUtil {

    /** インスタンス */
    private static ConfigUtil instance = null;

    /** プロパティ */
    private Properties prop = null;
    
    /**
     * インスタンスを取得する
     * 
     * @return ConfigUtil インスタンス
     */
    public static ConfigUtil getInstance() {

        if (instance == null) {
            instance = new ConfigUtil();
            instance.init();
        }
        return instance;
    }

    /**
     * インスタンス初期化
     * 
     * @param path フェイルパース
     */
    public void init() {
        try {
            InputStream inMessage = new BufferedInputStream(new FileInputStream("conf\\MessageResources_ja.properties"));
            
            prop = new Properties();
            prop.load(inMessage);
            inMessage.close();
        } catch (Exception e) {
            System.out.println("プロパッティファイルが存在しません。");
        }
    }
    
    /**
     * 値を取得する
     * 
     * @param key キー
     * @return 値
     */
    public static String getValue(String key) throws TaskException {
        try {
            ConfigUtil instance = ConfigUtil.getInstance();
            String value = (String) instance.prop.get(key);
            return value;
        } catch (Exception e) {
            throw new TaskException(e.getMessage());
        }
    }
}
