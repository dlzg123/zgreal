/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import jp.co.realsys.error.TaskException;

/**
 * �R���t�B�M�����[�V�����N���X
 * 
 * @author Realsys
 */
public class ConfigUtil {

    /** �C���X�^���X */
    private static ConfigUtil instance = null;

    /** �v���p�e�B */
    private Properties prop = null;
    
    /**
     * �C���X�^���X���擾����
     * 
     * @return ConfigUtil �C���X�^���X
     */
    public static ConfigUtil getInstance() {

        if (instance == null) {
            instance = new ConfigUtil();
            instance.init();
        }
        return instance;
    }

    /**
     * �C���X�^���X������
     * 
     * @param path �t�F�C���p�[�X
     */
    public void init() {
        try {
            InputStream inMessage = new BufferedInputStream(new FileInputStream("conf\\MessageResources_ja.properties"));
            
            prop = new Properties();
            prop.load(inMessage);
            inMessage.close();
        } catch (Exception e) {
            System.out.println("�v���p�b�e�B�t�@�C�������݂��܂���B");
        }
    }
    
    /**
     * �l���擾����
     * 
     * @param key �L�[
     * @return �l
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
