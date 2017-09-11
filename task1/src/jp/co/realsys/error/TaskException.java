/*******************************************************************************
 *  システム名 : 学生情報管理
 *  著作権    : Copyright (C)　2002-2008　Realsys Co. Ltd. 　All Rights Reserved.
 *  会社名    : リアルシス株式会社
 *  ****************************************************************************
 *  変更履歴
 *  2008/03/20  作成　
 */
package jp.co.realsys.error;


/**
 * 異常クラス
 * 
 * @author Realsys
 */
public class TaskException extends Exception {

	private static final long serialVersionUID = 58758308927251467L;

	/**
     * TaskExceptionを構築します。
     */
	public TaskException(String msg) {
		super(msg);
	}
	
	/**
     * TaskExceptionを構築します。
     */
	public TaskException(Exception msg) {
		super(msg);
	}
}
