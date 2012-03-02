package scidy.ejb;
import java.io.IOException;

import javax.ejb.Remote;

@Remote
public interface GenerationEjb {
	public String bonjour(); 
	public void generer(Integer id) throws IOException;
}
