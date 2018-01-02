package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import model.Teacher;

public class TeacherDAO {

	private static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/crud","root","");
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
	
	public static int save(Teacher t){
        int status=0;  
        try{  
            Connection con=TeacherDAO.getConnection();  
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(  
                         "insert into teacher (id,name,address) values (?,?,?)");
            ps.setInt(1,t.getId());
            ps.setString(2,t.getName());
            ps.setString(3,t.getAddress());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
	
	 public static int update(Teacher e){  
	        int status=0;  
	        try{  
	            Connection con=TeacherDAO.getConnection();  
	            PreparedStatement ps=(PreparedStatement) con.prepareStatement(  
	                         "update teacher set id=?, name=?,address=? where id=?");
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getAddress()); 
	            ps.setInt(3,e.getId());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	 
	 public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=TeacherDAO.getConnection();  
	            PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from teacher where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	 
	 public static Teacher getEmployeeById(int id){  
	        Teacher t = new Teacher();  
	          
	        try{  
	            Connection con=TeacherDAO.getConnection();  
	            PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from teacher where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                t.setId(rs.getInt(1));  
	                t.setName(rs.getString(2));  
	                t.setAddress(rs.getString(3));  
	                  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return t;  
	    }  
	 
	 public static List<Teacher> getAllEmployees(){
	        List<Teacher> list=new ArrayList<Teacher>();
	          
	        try{  
	            Connection con=TeacherDAO.getConnection();  
	            PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from teacher");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Teacher t = new Teacher();  
	                t.setId(rs.getInt(1));  
	                t.setName(rs.getString(2));  
	                t.setAddress(rs.getString(3));  
	                 
	                list.add(t);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }


}
