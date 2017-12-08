package com.ssm.elasticsearch;

import java.util.Properties;

import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class ESTransportClient implements FactoryBean<TransportClient>, InitializingBean, DisposableBean {

	private static final Logger logger = LoggerFactory.getLogger( ESTransportClient.class );

	private String clusterNodes = "127.0.0.1:9300";

	private String clusterName = "elasticsearch";

	private Boolean clientTransportSniff = true;

	private Boolean clientIgnoreClusterName = Boolean.FALSE;

	private String clientPingTimeout = "5s";

	private String clientNodesSamplerInterval = "5s";

	private TransportClient client;

	private Properties properties;

	static final String COLON = ":";

	static final String COMMA = ",";

	@Override
	public TransportClient getObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}
}
