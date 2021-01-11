package RabbitMqPublisher.RabbitMqPublisher.publisher;




import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import RabbitMqPublisher.RabbitMqPublisher.messageconfig.RabbitMqConfig;
import RabbitMqPublisher.RabbitMqPublisher.model.Traveller;
import RabbitMqPublisher.RabbitMqPublisher.model.User;



//@PostMapping("/{username}/addtraveller")
//public void  addTraveller(@PathVariable("username") String username,@RequestBody Traveller traveller)
//{
//	traveller.setUser(new User(username,"",""));
//	itravelservice.addTraveller(traveller);
//
//}
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AddTravellerPublisher {

	
	@Autowired
    RabbitTemplate template;
	
	@PostMapping("/{username}/addtraveller")
	public void addTraveller(@PathVariable("username") String username,@RequestBody Traveller traveller)
	{
		traveller.setUser(new User(username,""));
		template.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTING_KEY, traveller);
	
	}
	
}
