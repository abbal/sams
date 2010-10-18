package example.regseam.session;

import javax.ejb.Local;

@Local
public interface Registration
{
    public String register();
    public String confirm();
    public void destroy();

}
