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

import jp.co.realsys.util.CUIClear;
import jp.co.realsys.util.ConfigUtil;

/**
 * �R���\�[���}�l�[�W���N���X
 * 
 * @author Realsys
 */
public class ConsoleManager {
	
    /** �o�^�A�X�V�A�폜�A�����A����̋敪 */
    private int option;
    
    /** ���[�U�[�̓��͒l */
    private String getStr;

    /**
     * �又��
     * 
     */
	public void mainProcess() throws Exception{
        
        StudentView studentView = new StudentView();
        
        // ��ʂ̓��e���N���A����
        CUIClear.printBlank();

        while(true){
            
            // ���[�����j���[�̕\��
            showMainMenu();

            try{
                BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
                getStr = bin.readLine();

                // �����A�����̃`�F�b�N
                if(getStr.length() != 1 || !Character.isDigit(getStr.charAt(0))){
                    // ��ʂ̓��e���N���A����
                    CUIClear.printBlank();
                    System.out.println(ConfigUtil.getValue("label.one.number.input"));
                    continue;
                }
    
                option = Integer.parseInt(getStr); 
                
                // �o�^�A�X�V�A�폜�A�����A����̋敪
                switch(option){
                    case 1:
                        studentView.addStudent();
                        break;
                    case 2:
                        studentView.queryStudent();
                        break;
                    case 3:
                        studentView.deleteStudent();
                        break;
                    case 4:
                        studentView.updateStudent();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        CUIClear.printBlank();
                        System.out.println(ConfigUtil.getValue("label.one.five.input"));
                        break;
                }
            
            } catch (Exception e){

            }

        }   
	}
	
    /**
     * ��֐�
     * 
     * @param arg ���͒l
     */
    public static void main(String[] arg) throws Exception{
        ConsoleManager consoleManager = new ConsoleManager();
        try{
            consoleManager.mainProcess();
        } catch (Exception e){
            System.out.println(ConfigUtil.getValue("label.one.three.input"));
        }
        
    }
    
    /**
     * ���[�����j���[
     */
	private void showMainMenu() throws Exception{
        
        // �V�X�e�����̃��x��
        String studentSystem = ConfigUtil.getValue("label.system.student");
        
        // ���j���[�̃��x��
        String menu = ConfigUtil.getValue("label.menu.student");
        
        // �V�K�o�^�̃��x��
        String addStudent = ConfigUtil.getValue("label.add.student");
        
        // �����̃��x��
        String queryStudent = ConfigUtil.getValue("label.query.student");
        
        // �폜�̃��x��
        String deleteStudent = ConfigUtil.getValue("label.delete.student");
        
        // �X�V�̃��x��
        String updateStudent = ConfigUtil.getValue("label.update.student");
        
        // ����̃��x��
        String studentExit = ConfigUtil.getValue("label.exit.student");
        
        // �I�v�V�����̃��x��
        String optionStudent = ConfigUtil.getValue("label.option.student");
        
        // ���[�����j���[�̕\��
        System.out.println("================================================");
        System.out.println("==          " + studentSystem + "              ==");
        System.out.println("================================================");
        System.out.println("==          " + menu + "                  ==");
        System.out.println("==          ----------------                  ==");
        System.out.println(addStudent);
        System.out.println(queryStudent);
        System.out.println(deleteStudent);
        System.out.println(updateStudent);
        System.out.println(studentExit);
        System.out.println("================================================");
        System.out.println(optionStudent);
        System.out.print(">");
	}

}

