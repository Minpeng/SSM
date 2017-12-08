package com.ssm.elasticsearch.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class ESFactory {


	public static TransportClient getESClient() {
		Settings settings = Settings.builder()
		        .put( "cluster.name", "elasticsearch" ).build();
		TransportClient client = null;
		try {
			client = new PreBuiltTransportClient( settings )
			        .addTransportAddress( new InetSocketTransportAddress( InetAddress.getByName( "127.0.0.1" ), 9300 ) );
		}
		catch( UnknownHostException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		        
		
		return client;
	}

	public static void main( String[] args ) {
		TransportClient client = getESClient();
		System.err.println( client );
		// 插入数据
		String index = "test";
		String type = "article";
		String id = "3";
		addIndex( index, type, new HashMap<>() );
		// 搜索数据
		GetResponse response = client.prepareGet( "test", "article", "3" ).execute().actionGet();
		// 输出结果
		System.out.println( response.getSourceAsString() );

	}

	public static String addIndex( String index, String type, HashMap<String, Object> hashMap ) {
		hashMap.put( "id", "3" ); // 这里如果不指定id的话elasticsearch会自动创建主键id，
		hashMap.put( "title", "双宿双飞从" );
		hashMap.put( "describe", "测试123" );
		hashMap.put( "author", "测试doc" );
		TransportClient client = getESClient();
		try {
			IndexResponse response = client.prepareIndex( index, type, hashMap.get( "id" ).toString() ).setSource( hashMap )
			        .execute().actionGet();
			System.out.println( response.getId() );
			return response.getId(); // 返回主键
		}
		catch( Exception e ) {
			// TODO: handle exception
			return null;
		}
		finally {
			client.close();// 关闭连接
		}
	}
}
