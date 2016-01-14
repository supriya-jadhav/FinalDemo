package com.psl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.psl.bean.Users;
import com.psl.util.DataManager;

public class GetData {

	public List<Users> getAllUsers()
	{
		Connection conn = DataManager.getConnection();
		List<Users> list = new ArrayList<Users>();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("select * from login");
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			String uname = rs.getString(1);
			String pass = rs.getString(2);
			Users u = new Users(uname, pass);
			list.add(u);
		}
	}
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
}
	
}
