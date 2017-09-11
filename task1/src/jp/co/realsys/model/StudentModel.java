/*******************************************************************************
 *  システム名 : 学生情報管理
 *  著作権    : Copyright (C)　2002-2008　Realsys Co. Ltd. 　All Rights Reserved.
 *  会社名    : リアルシス株式会社
 *  ****************************************************************************
 *  変更履歴
 *  2008/03/20  作成　
 */

package jp.co.realsys.model;

/**
 * 学生Modelクラス
 * 
 * @author Realsys
 */
public class StudentModel {

	/** ID */
	private String	id;
	/** 名前 */
	private String	name;
	/** 生年月日 */
	private String	birthDate;
	/** 住所 */
	private String	address;

	/**
	 * IDを取得する。
	 * 
	 * @return
	 */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 生年月日を取得する。
     * 
     * @return
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * 
     * @param birthDate
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * IDを取得する。
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }



}

