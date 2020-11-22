package com.reply.stream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class StreamController {
	private static Map<String, User> userMap =new HashMap<String, User>();

	@PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public User registerUser(@RequestBody @Valid User newUser) {
		
		if(null != userMap && (null != userMap.get(newUser.getUserName()))) 
			throw new UserAlreadyExistsException(newUser.getUserName());
		
		if(LocalDate.now().minusYears(18).isBefore(newUser.getBirthDate()))
			throw new UnderAgeExecption();
		
		userMap.put(newUser.getUserName(),newUser);
		return newUser;
	}
	
	@GetMapping("/users")
	@ResponseBody
	public List<User> getUsers(@RequestParam(value = "creditCard", required = false) String creditCard) {
		if (null==creditCard)
			return new ArrayList<User>(userMap.values());
		else if (("YES").equalsIgnoreCase(creditCard))
			return userMap.entrySet().stream().filter(map -> map.getValue().getCreditCardNo()!=null).map(Map.Entry::getValue).collect(Collectors.toList());
		else if (("NO").equalsIgnoreCase(creditCard))
			return userMap.entrySet().stream().filter(map -> map.getValue().getCreditCardNo()==null).map(Map.Entry::getValue).collect(Collectors.toList());
		else 
			return Collections.emptyList();		
	}
	
	@PostMapping(value = "/payments", consumes = "application/json", produces = "application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> processPayment(@RequestBody @Valid Payment payment) {
		Optional<User> creditCardUser = userMap.values().stream().filter(u -> payment.getCreditCardNum().equals(u.getCreditCardNo())).findFirst();
		if(!creditCardUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
