/*******************************************************************************
 *  システム名 : 学生情報管理
 *  著作権    : Copyright (C)　2002-2008　Realsys Co. Ltd. 　All Rights Reserved.
 *  会社名    : リアルシス株式会社
 *  ****************************************************************************
 *  変更履歴
 *  2008/03/20  作成　
 */
package jp.co.realsys.dao.memory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.co.realsys.dao.StudentDao;
import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.StudentModel;

/**
 * 学生情報メモリーのインタフェースの実装クラス
 * 
 * @author Realsys
 */
public class StudentMemoryDaoImpl implements StudentDao {
    
    /** 学生リスト */
    List<StudentModel> studentList = new ArrayList<StudentModel>();
    
    /**
     * 学生情報を登録する
     * 
     * @param student 学生情報モデル
     * @return レコード数
     */
    public int doRegisterStduent(StudentModel student) throws TaskException {
        studentList.add(student);
        return 1;
    }

    /**
     * 学生情報を更新する
     * 
     * @param student 学生情報モデル
     * @return レコード数
     */
    public int doUpdateStduent(StudentModel student) throws TaskException {
        
        Iterator<StudentModel> it = studentList.iterator();
        // 学生情報を削除する
        while(it.hasNext()){
            StudentModel studentModel = (StudentModel)it.next();
            if(studentModel.getId().equals(student.getId())){
                it.remove();
            }
        }
        // 学生情報を登録する
        int recode = doRegisterStduent(student);
        return recode;
    }

    /**
     * 学生情報を削除する
     * 
     * @param studentId 学生ID
     * @return レコード数
     */
    public int doDeleteStduent(String studentId) throws TaskException {
        
        Iterator<StudentModel> it = studentList.iterator();
        boolean findStudent = false;
        
        while(it.hasNext()){
            if(((StudentModel)it.next()).getId().equals(studentId)){
                findStudent = true;
                it.remove();
                break;
            }
        }
        if (findStudent) {
            return 1;
        }
        return 0;
    }

    /**
     * 学生情報を検索する
     * 
     * @param name 名前
     * @return 学生情報
     */
    public List<StudentModel> doQueryStduentList(String name) throws TaskException {
        
        Iterator<StudentModel> it = studentList.iterator();
        List<StudentModel> findList = new ArrayList<StudentModel>();

        while(it.hasNext()){
            
            StudentModel studentModel = (StudentModel)it.next();
            
            if(studentModel.getName().equals(name)){
                findList.add(studentModel);
            } 
        }
        return findList;
    }

}
