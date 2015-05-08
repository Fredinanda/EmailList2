package com.sds.icto.emaillist.action;

import com.sds.icto.web.Action;

public class ActionFactory {
	private static ActionFactory instance;
	static {
		instance = new ActionFactory(); 
	}
	
	private ActionFactory(){
	}
	
	public static ActionFactory getInstance() {
//		if( instance == null ) {
//			instance = new ActionFactory(); 
//		}
		
		return instance;
	}
	
	public Action getAction( String a ) {
		Action action = null;
		
		if( "form".equals( a ) ) {
			action = new formAction();
		} else if( "insert".equals( a ) ) {
			action = new insertAction();
		} 
		
		if( action == null ) {
			action = new indexAction();
		}
		
		return action;
	}
}

