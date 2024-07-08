package com.Spring;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@CrossOrigin(value = "http://localhost:4200")
//@RequestMapping("/todos")
public class HomeController {

	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private MyUserDetailsService userAuthService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	/* Todo Crud operations once the JWT generated  */
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	
	@GetMapping("/addTask")
	public String add()
	{
		return "Task Added. !!";		
	}
	
	
	@GetMapping("/updateTask")
	public String update()
	{
		return "Task Updated. !!";
	}
	@GetMapping("/deleteTask")
	public String delete()
	{
		return "Task deleted. !!";
	}
	
	/* 
	@Autowired
	ToDoService todo_serv;
	@GetMapping("listTodo")
    public List<ToDo> getAllTodo()
    {
        return todo_serv.getAllTodo();
    }
    
    
    @PostMapping("addTodo")
    public String addTodo(@RequestBody ToDo c)
    {
        todo_serv.addTodo(c);
        return "Record Added !";
    }

    @PutMapping("updateTodo")
    public String updateCart(@RequestBody ToDo c)
    {
        todo_serv.updateTodo(c);
        return "Record Updated !";
    }
	*/
	
	@PostMapping("/signin")
	public ResponseEntity<Response> generateJwtToken(@RequestBody Request request) throws Exception {
		Authentication authentication = null;
		try {
			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		} catch (Exception e) {
			System.out.println("Not a Valid Information");
		}

		MyUserInfo user = (MyUserInfo) authentication.getPrincipal();
		List<String> roles = user.getAuthorities().stream().map(r->r.getAuthority()).collect(Collectors.toList());

		String token = jwtUtil.generateToken(authentication);

		Response response = new Response();
		response.setToken(token);
		response.setRoles(roles.stream().collect(Collectors.toList()));

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody Request request) {
		userAuthService.saveUser(request);

		return new ResponseEntity<String>("User successfully registered", HttpStatus.OK);
	}
	
	
		
	
}
