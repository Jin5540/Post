package com.jslhrd.controller;
import com.jslhrd.controller.action.Action;
import com.jslhrd.controller.action.BoardDeleteAction;
import com.jslhrd.controller.action.BoardListAction;
import com.jslhrd.controller.action.BoardUpdateAction;
import com.jslhrd.controller.action.BoardUpdateFormAction;
import com.jslhrd.controller.action.BoardViewAction;
import com.jslhrd.controller.action.BoardWriteAction;
import com.jslhrd.controller.action.BoardWriteFormAction;
import com.jslhrd.controller.action.BoardErorr;
import com.jslhrd.controller.action.Login;
public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance()
	{
		
		return instance;
	}
	
	public static Action getAction(String command)
	{
		Action action = null;
		System.out.println("getAction ::"+ command);

		if(command.equals("board_list"))
		{
			System.out.println("OK");	
			action = new BoardListAction(); //007�젣�엫�뒪蹂몃뱶
		} 
		
		
		else if(command.equals("board_view")) {
			action = new BoardViewAction();
			System.out.println("OK");				
			
		} else if(command.equals("board_write")) {
			action = new BoardWriteAction();
			System.out.println("OK");				
		} else if(command.equals("login")) {
			action = new Login();
			System.out.println("OK");

		} else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
			System.out.println("OK");
			
		} else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
			System.out.println("OK");	
			
		} else if(command.equals("board_update")) {
			action = new BoardUpdateAction();
			System.out.println("OK");		
		} else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
			System.out.println("OK");	
		}  else {
			System.out.println("board_Erorr");	
			action = new BoardErorr();
		}
		
		return action;
	}
	
}
