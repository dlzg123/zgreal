/*******************************************************************************
 *  システム名 : 学生情報管理
 *  著作権    : Copyright (C)　2002-2008　Realsys Co. Ltd. 　All Rights Reserved.
 *  会社名    : リアルシス株式会社
 *  ****************************************************************************
 *  変更履歴
 *  2008/03/20  作成　
 */
package jp.co.realsys.service;

import java.util.List;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.StudentModel;

/**
 * 学生情報の業務層のインタフェース
 * 
 * @author Realsys
 */
public interface StudentService {

    /**
     * 学生情報を登録する
     * 
     * @param student 学生情報モデル
     * @return レコード数
     */
    public int doRegisterStduent(StudentModel student) throws TaskException;

    /**
     * 学生情報を更新する
     * 
     * @param student 学生情報モデル
     * @return レコード数
     */
    public int doUpdateStduent(StudentModel student) throws TaskException;

    /**
     * 学生情報を削除する
     * 
     * @param studentId 学生ID
     * @return レコード数
     */
    public int doDeleteStduent(String studentId) throws TaskException;

    /**
     * 学生情報を検索する
     * 
     * @param name 名前
     * @return 学生情報
     */
    public List<StudentModel> doQueryStduentList(String name) throws TaskException;

}