package com.winter.app.test;

import com.winter.app.util.DBCconnection;

public class AppMain {

	public static void main(String[] args) {
		DBCconnection connector = new DBCconnection();
		connector.getConnector();
	}

}
