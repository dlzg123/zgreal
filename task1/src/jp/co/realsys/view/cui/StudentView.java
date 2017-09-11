/*******************************************************************************
 *  システム名 : 学生情報管理
 *  著作権    : Copyright (C)　2002-2008　Realsys Co. Ltd. 　All Rights Reserved.
 *  会社名    : リアルシス株式会社
 *  ****************************************************************************
 *  変更履歴
 *  2008/03/20  作成　
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
 * ビュークラス
 * 
 * @author Realsys
 */
public class StudentView {

    /** 学生情報モデル */
    private StudentModel studentModel;

    /** 学生情報の業務層 */
    StudentService studentService = null;;

    /**
     * コンストラクタ
     * 
     */
    public StudentView() {
        studentService = new StduentMemoryServiceImpl();
    }

    /**
     * 登録される学生情報を設定する
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

        // IDの設定
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.id"));
            System.out.print(">");
            studentModel.setId(bin.readLine());

            if (checkChar(studentModel.getId(), 20))
                break;
        }

        // 名前の設定
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.name"));
            System.out.print(">");
            studentModel.setName(bin.readLine());
            if (checkChar(studentModel.getName(), 256))
                break;

        }

        // 生年月日の設定
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.birthdate"));
            System.out.print(">");
            studentModel.setBirthDate(bin.readLine());
            boolean b = Pattern.matches("[0-9]{4}/[0-9]{2}/[0-9]{2}", studentModel.getBirthDate());
            if (checkChar(studentModel.getBirthDate(), 10) && b)
                break;

        }

        // 住所の設定
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.address"));
            System.out.print(">");
            studentModel.setAddress(bin.readLine());
            if (checkChar(studentModel.getAddress(), 256))
                break;
        }

        // 学生情報の登録
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
     * 削除される学生情報を設定する
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

        // 学生情報の削除
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
     * 学生情報を検索する
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

        // 学生情報の検索
        List<StudentModel> studentList = studentService.doQueryStduentList(studentName);

        Iterator<StudentModel> it = studentList.iterator();

        // 学生情報の表示
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
     * 更新される学生情報を設定する
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

        // IDの設定
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.id"));
            System.out.print(">");
            studentModel.setId(bin.readLine());
            if (checkChar(studentModel.getId(), 20))
                break;
        }

        // 名前の設定
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.name"));
            System.out.print(">");
            studentModel.setName(bin.readLine());
            if (checkChar(studentModel.getName(), 256))
                break;

        }

        // 生年月日の設定
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.birthdate"));
            System.out.print(">");
            studentModel.setBirthDate(bin.readLine());
            boolean b = Pattern.matches("[0-9]{4}/[0-9]{2}/[0-9]{2}", studentModel.getBirthDate());
            if (checkChar(studentModel.getBirthDate(), 10) && b)
                break;

        }

        // 住所の設定
        while (true) {
            System.out.println(ConfigUtil.getValue("label.input.student.address"));
            System.out.print(">");
            studentModel.setAddress(bin.readLine());
            if (checkChar(studentModel.getAddress(), 256))
                break;
        }

        // 学生情報の更新
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
     * 文字列をチェックする
     * 
     * @param str チェックの文字列
     * @param strL 文字列の桁数
     * @return true、false
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