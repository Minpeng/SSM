package com.ssm.elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EsClientBuilder {
	private static Logger logger = LoggerFactory.getLogger( EsClientBuilder.class );

	private String ip;

	private int port;

	private RestClient client;

	public RestClient init() {
		// 设置集群的名字
		try {
			this.client = RestClient.builder( new HttpHost( ip, port, "http" ) ).build();

		}
		catch( Exception e ) {
			e.printStackTrace();
			logger.error( e.getMessage() );
		}

		return client;
	}

	public String getIp() {
		return ip;
	}

	public void setIp( String ip ) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort( int port ) {
		this.port = port;
	}
}
