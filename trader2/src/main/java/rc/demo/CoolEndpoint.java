package rc.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoolEndpoint {
	
	@GetMapping("/doIt")
	public List<Trade> doIt() throws IOException, ClassNotFoundException {
		FileReaderWriter fwr = new FileReaderWriter("my.name.txt");
		return fwr.read();
	}
	

}
