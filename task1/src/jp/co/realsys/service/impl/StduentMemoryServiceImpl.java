/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.service.impl;

import java.util.List;

import jp.co.realsys.dao.StudentDao;
import jp.co.realsys.dao.memory.StudentMemoryDaoImpl;
import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.StudentModel;
import jp.co.realsys.service.StudentService;

/**
 * �w����񃁃����[�̋Ɩ��w�̎����N���X
 * 
 * @author Realsys
 */
public class StduentMemoryServiceImpl implements StudentService {

    /** �w������DAO */
    private StudentDao studentDao = new StudentMemoryDaoImpl();
    
    /**
     * �w������o�^����
     * 
     * @param student �w����񃂃f��
     * @return ���R�[�h��
     */
    public int doRegisterStduent(StudentModel student) throws TaskException {
        return studentDao.doRegisterStduent(student);
        
    }

    /**
     * �w�������X�V����
     * 
     * @param student �w����񃂃f��
     * @return ���R�[�h��
     */
    public int doUpdateStduent(StudentModel student) throws TaskException {
        return studentDao.doUpdateStduent(student);
        
    }

    /**
     * �w�������폜����
     * 
     * @param studentId �w��ID
     * @return ���R�[�h��
     */
    public int doDeleteStduent(String studentId) throws TaskException {
        return studentDao.doDeleteStduent(studentId);
        
    }

    /**
     * �w��������������
     * 
     * @param name ���O
     * @return �w�����
     */
    public List<StudentModel> doQueryStduentList(String name) throws TaskException {
        List<StudentModel> studentList = studentDao.doQueryStduentList(name);
        return studentList;
    }

}
