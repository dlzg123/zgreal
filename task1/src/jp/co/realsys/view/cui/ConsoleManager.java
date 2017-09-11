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

import jp.co.realsys.util.CUIClear;
import jp.co.realsys.util.ConfigUtil;

/**
 * コンソールマネージャクラス
 * 
 * @author Realsys
 */
public class ConsoleManager {
	
    /** 登録、更新、削除、検索、閉じるの区分 */
    private int option;
    
    /** ユーザーの入力値 */
    private String getStr;

    /**
     * 主処理
     * 
     */
	public void mainProcess() throws Exception{
        
        StudentView studentView = new StudentView();
        
        // 画面の内容をクリアする
        CUIClear.printBlank();

        while(true){
            
            // メーンメニューの表示
            showMainMenu();

            try{
                BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
                getStr = bin.readLine();

                // 桁数、数字のチェック
                if(getStr.length() != 1 || !Character.isDigit(getStr.charAt(0))){
                    // 画面の内容をクリアする
                    CUIClear.printBlank();
                    System.out.println(ConfigUtil.getValue("label.one.number.input"));
                    continue;
                }
    
                option = Integer.parseInt(getStr); 
                
                // 登録、更新、削除、検索、閉じるの区分
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
     * 主関数
     * 
     * @param arg 入力値
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
     * メーンメニュー
     */
	private void showMainMenu() throws Exception{
        
        // システム名のラベル
        String studentSystem = ConfigUtil.getValue("label.system.student");
        
        // メニューのラベル
        String menu = ConfigUtil.getValue("label.menu.student");
        
        // 新規登録のラベル
        String addStudent = ConfigUtil.getValue("label.add.student");
        
        // 検索のラベル
        String queryStudent = ConfigUtil.getValue("label.query.student");
        
        // 削除のラベル
        String deleteStudent = ConfigUtil.getValue("label.delete.student");
        
        // 更新のラベル
        String updateStudent = ConfigUtil.getValue("label.update.student");
        
        // 閉じるのラベル
        String studentExit = ConfigUtil.getValue("label.exit.student");
        
        // オプションのラベル
        String optionStudent = ConfigUtil.getValue("label.option.student");
        
        // メーンメニューの表示
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

