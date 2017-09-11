/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.dao.memory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.co.realsys.dao.StudentDao;
import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.StudentModel;

/**
 * �w����񃁃����[�̃C���^�t�F�[�X�̎����N���X
 * 
 * @author Realsys
 */
public class StudentMemoryDaoImpl implements StudentDao {
    
    /** �w�����X�g */
    List<StudentModel> studentList = new ArrayList<StudentModel>();
    
    /**
     * �w������o�^����
     * 
     * @param student �w����񃂃f��
     * @return ���R�[�h��
     */
    public int doRegisterStduent(StudentModel student) throws TaskException {
        studentList.add(student);
        return 1;
    }

    /**
     * �w�������X�V����
     * 
     * @param student �w����񃂃f��
     * @return ���R�[�h��
     */
    public int doUpdateStduent(StudentModel student) throws TaskException {
        
        Iterator<StudentModel> it = studentList.iterator();
        // �w�������폜����
        while(it.hasNext()){
            StudentModel studentModel = (StudentModel)it.next();
            if(studentModel.getId().equals(student.getId())){
                it.remove();
            }
        }
        // �w������o�^����
        int recode = doRegisterStduent(student);
        return recode;
    }

    /**
     * �w�������폜����
     * 
     * @param studentId �w��ID
     * @return ���R�[�h��
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
     * �w��������������
     * 
     * @param name ���O
     * @return �w�����
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
