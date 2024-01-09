package prac_mini_project_01Model;

import java.sql.ResultSet;

public interface DAOService {
	
	public boolean verifycredentials(String email,String password);
	public void saveregistrations(String name,String city,String mobile,String email);
	public void connectDB();
	public ResultSet listAllreg();
	public void deleteBYEmail(String email);
    public void updatreg(String email, String mobile);

}
