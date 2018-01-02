package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import model.Student;

public class StudentDAO {

	private static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/crud","root","");
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
	
	public static int save(Student t){
        int status=0;  
        try{  
            Connection con=StudentDAO.getConnection();
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(  
                         "insert into student (id,name,address) values (?,?,?,?)");
            ps.setInt(1,t.getId());
            ps.setString(2,t.getName());
            ps.setString(3,t.getDept());
            ps.setInt(4,t.getProf_id());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
	
	 public static int update(Student e){
	        int status=0;  
	        try{  
	            Connection con=StudentDAO.getConnection();
	            PreparedStatement ps=(PreparedStatement) con.prepareStatement(  
	                         "update student set name=?,dept=?, prof_id=? where id=?");
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getDept());
	            ps.setInt(3,e.getProf_id());
	            ps.setInt(4,e.getId());
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	 
	 public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=StudentDAO.getConnection();
	            PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from student where id=?");
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	 
	 public static Student getEmployeeById(int id){
	        Student t = new Student();
	          
	        try{  
	            Connection con=StudentDAO.getConnection();
	            PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from student where id=?");
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                t.setId(rs.getInt(1));  
	                t.setName(rs.getString(2));  
	                t.setDept(rs.getString(3));
	                t.setProf_id(rs.getInt(4));
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return t;  
	    }  
	 
	 public static List<Student> getAllEmployees(){
	        List<Student> list=new ArrayList<>();
	          
	        try{  
	            Connection con=StudentDAO.getConnection();
	            PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from student");
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Student t = new Student();
	                t.setId(rs.getInt(1));  
	                t.setName(rs.getString(2));  
	                t.setDept(rs.getString(3));
	                t.setProf_id(rs.getInt(4));
	                 
	                list.add(t);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	 
	 
}
