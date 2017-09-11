/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.view.cui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import jp.co.realsys.model.StudentModel;
import jp.co.realsys.service.StudentService;
import jp.co.realsys.service.impl.StduentMemoryServiceImpl;
import jp.co.realsys.util.CUIClear;
import jp.co.realsys.util.ConfigUtil;

/**
 * �r���[�N���X
 * 
 * @author Realsys
 */
public class StudentView {

    /** �w����񃂃f�� */
    private StudentModel studentModel;

    /** �w�����̋Ɩ��w */
    StudentService studentService = null;;

    /**
     * �R���X�g���N�^
     * 
     */
    public StudentView() {
        studentService = new StduentMemoryServiceImpl();
    }

    /**
     * �o�^�����w������ݒ肷��
     */
    public void addStudent() throws Exception {

        studentModel = new StudentModel();

        CUIClear.printBlank();

        System.out.println(ConfigUtil.getValue("label.add.student.information"));
        System.out.println("=====================            ");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));

        // ID�̐ݒ�
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.id"));
            System.out.print(">");
            studentModel.setId(bin.readLine());

            if (checkChar(studentModel.getId(), 20))
                break;
        }

        // ���O�̐ݒ�
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.name"));
            System.out.print(">");
            studentModel.setName(bin.readLine());
            if (checkChar(studentModel.getName(), 256))
                break;

        }

        // ���N�����̐ݒ�
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.birthdate"));
            System.out.print(">");
            studentModel.setBirthDate(bin.readLine());
            boolean b = Pattern.matches("[0-9]{4}/[0-9]{2}/[0-9]{2}", studentModel.getBirthDate());
            if (checkChar(studentModel.getBirthDate(), 10) && b)
                break;

        }

        // �Z���̐ݒ�
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.address"));
            System.out.print(">");
            studentModel.setAddress(bin.readLine());
            if (checkChar(studentModel.getAddress(), 256))
                break;
        }

        // �w�����̓o�^
        int count = studentService.doRegisterStduent(studentModel);
        CUIClear.printBlank();
        
        if (count > 0) {
            System.out.println(ConfigUtil.getValue("label.add.student.complete"));
            System.out.println("");
        } else {
            System.out.println(ConfigUtil.getValue("label.add.student.error"));
            System.out.println("");
        }

    }

    /**
     * �폜�����w������ݒ肷��
     */
    public void deleteStudent() throws Exception {

        String studentId = "";

        CUIClear.printBlank();
        System.out.println(ConfigUtil.getValue("label.delete.student.information"));
        System.out.println("====================");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(ConfigUtil.getValue("label.input.student.id"));
        System.out.print(">");

        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        studentId = bin.readLine();

        // �w�����̍폜
        int deleteFlg = studentService.doDeleteStduent(studentId);
        CUIClear.printBlank();
        
        if (deleteFlg < 1) {
            System.out.println(ConfigUtil.getValue("label.student.not.find"));
        } else {
            System.out.println(ConfigUtil.getValue("label.delete.student.complete"));
        }
        System.out.println("");

    }

    /**
     * �w��������������
     */
    public void queryStudent() throws Exception {
        studentModel = new StudentModel();
        String studentName = "";

        CUIClear.printBlank();
        System.out.println(ConfigUtil.getValue("label.query.student.information"));
        System.out.println("=========================================");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(ConfigUtil.getValue("label.input.student.name"));
        System.out.print(">");

        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        studentName = bin.readLine();

        // �w�����̌���
        List<StudentModel> studentList = studentService.doQueryStduentList(studentName);

        Iterator<StudentModel> it = studentList.iterator();

        // �w�����̕\��
        while (it.hasNext()) {
            studentModel = (StudentModel) it.next();
            CUIClear.printBlank();
            System.out.println(ConfigUtil.getValue("label.student.id") + studentModel.getId());
            System.out.println(ConfigUtil.getValue("label.student.name") + studentModel.getName());
            System.out.println(ConfigUtil.getValue("label.student.birthdate") + studentModel.getBirthDate());
            System.out.println(ConfigUtil.getValue("label.student.address") + studentModel.getAddress());

        }
        if (studentList.size() == 0) {
            CUIClear.printBlank();
            System.out.println(ConfigUtil.getValue("label.student.not.find"));
        }
        System.out.println("");

    }

    /**
     * �X�V�����w������ݒ肷��
     */
    public void updateStudent() throws Exception {

        studentModel = new StudentModel();

        CUIClear.printBlank();

        System.out.println(ConfigUtil.getValue("label.update.student.information"));
        System.out.println("=====================            ");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));

        // ID�̐ݒ�
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.id"));
            System.out.print(">");
            studentModel.setId(bin.readLine());
            if (checkChar(studentModel.getId(), 20))
                break;
        }

        // ���O�̐ݒ�
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.name"));
            System.out.print(">");
            studentModel.setName(bin.readLine());
            if (checkChar(studentModel.getName(), 256))
                break;

        }

        // ���N�����̐ݒ�
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.birthdate"));
            System.out.print(">");
            studentModel.setBirthDate(bin.readLine());
            boolean b = Pattern.matches("[0-9]{4}/[0-9]{2}/[0-9]{2}", studentModel.getBirthDate());
            if (checkChar(studentModel.getBirthDate(), 10) && b)
                break;

        }

        // �Z���̐ݒ�
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.address"));
            System.out.print(">");
            studentModel.setAddress(bin.readLine());
            if (checkChar(studentModel.getAddress(), 256))
                break;
        }

        // �w�����̍X�V
        int updateFlg = studentService.doUpdateStduent(studentModel);
        CUIClear.printBlank();
        
        if (updateFlg < 1) {
            System.out.println(ConfigUtil.getValue("label.student.not.find"));
        } else {
            System.out.println(ConfigUtil.getValue("label.update.student.complete"));
        }
        System.out.println("");

    }

    /**
     * ��������`�F�b�N����
     * 
     * @param str �`�F�b�N�̕�����
     * @param strL ������̌���
     * @return true�Afalse
     */
    public boolean checkChar(String str, int strL) throws Exception {
        if (str.length() > strL || str.length() < 1) {
            System.out.println("");
            System.out.println(ConfigUtil.getValue("label.string.too.long"));
            return false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ';' || str.charAt(i) == '*' || str.charAt(i) == '\\'
                        || str.charAt(i) == '#') {
                    System.out.println("");
                    System.out.println("\"" + str.charAt(i) + "\"" + ConfigUtil.getValue("label.not.input.char"));
                    return false;
                }
            }
        }
        return true;
    }

}