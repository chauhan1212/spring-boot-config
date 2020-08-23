package com.vijay.springbootconfig.profiles;

public class SomeService {
	
	private String dbConnection;
	private String host;
	private int port;
	
	
	
	@Override
	public String toString() {
		return "SomeService [dbConnection=" + dbConnection + ", host=" + host + ", port=" + port + "]";
	}
	public String getDbConnection() {
		return dbConnection;
	}
	public void setDbConnection(String dbConnection) {
		this.dbConnection = dbConnection;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
}
