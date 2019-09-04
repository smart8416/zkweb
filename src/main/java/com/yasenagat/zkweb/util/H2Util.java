package com.yasenagat.zkweb.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.ResultSetHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class H2Util {

	//private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	@Autowired
	private static DataSource dataSource;
	public static DataSource getDataSource(){

		return dataSource;
	}
	public static void destroyDataSource() {
//		if(dataSource!=null)
//			dataSource.close();
	}
	public static ResultSetHandler<Object[]> objectHandler = rs -> {
		ResultSetMetaData meta = rs.getMetaData();
		int cols = meta.getColumnCount();
		Object[] result = new Object[cols];

		for (int i = 0; i < cols; i++) {
			result[i] = rs.getObject(i + 1);
		}

		return result;
	};

	public static ResultSetHandler<Map<String, Object>> mapHandler = rs -> {
		Map<String, Object> map = new HashMap<String, Object>();
		ResultSetMetaData meta = rs.getMetaData();
		int cols = meta.getColumnCount();
		for(int i = 0 ; i < cols ;i++){
			map.put(meta.getColumnName(i+1), rs.getObject(i+1));
		}
		return map;
	};

	public static ResultSetHandler<Integer> intHandler = rs -> rs.getInt(1);

	public static ResultSetHandler<List<Map<String, Object>>> ListHandler = rs -> {


		List<Map<String, Object>> list = new ArrayList<>();

		ResultSetMetaData meta = rs.getMetaData();
		Map<String, Object> map = null;
		int cols = meta.getColumnCount();
		while(rs.next()){
			map = new HashMap<>();
			for(int i = 0 ; i < cols ;i++){
				map.put(meta.getColumnName(i+1), rs.getObject(i+1));
			}
			list.add(map);
		}

		return list;
	};


}
