package example.regseam.entity;

import javax.ejb.Local;

@Local
public interface ZmianaHasla {
/*
	public void changePassword();

	public boolean isChanged();

	public String getVerify();

	public void setVerify(String verify);

	public void destroy();
*/
    public String getLogin();  
    public void setLogin(String login);  
  
    public String getOldPassword();  
    public void setOldPassword(String password);  
  
    public String getPassword();  
    public void setPassword(String password);  
  
    public String getRepeatedPassword();  
    public void setRepeatedPassword(String password);  
  
    public void init();  
    public void destroy();  
  
    public void changePassword(); 
}
