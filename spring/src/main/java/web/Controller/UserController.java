package web.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.entities.Empleado;
import web.repository.ClienteRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@RestController
@RequestMapping({"/user"})
public class UserController {

	@Autowired
	ClienteRepository clienterepository;
	
	@GetMapping("/hola")
	public String index(){
		return "Hola Mundo con Spring Boot por GET";
	}
	
	@GetMapping("/adios")
	public String adios(){
		
		Optional<Empleado> clienteOpt = clienterepository.findById("17374");
		
		Empleado cliente = clienteOpt.get();
		return "Adios con Spring Boot por GET "+ cliente.getNombre();
	}
	
	@GetMapping("/get/{codigo}")
	public String ver(@PathVariable String codigo){
		
		Optional<Empleado> clienteOpt = clienterepository.findById(codigo);
		if(!clienteOpt.isPresent()) {
			return "El Código "+codigo+" de Cliente - No Existe";
		}else {
		Empleado cliente = clienteOpt.get();
		return "Adios con Spring Boot por GET "+ cliente.getNombre();
		}
	}
	
	@PostMapping("/hola")
	public String post(){
		return "Hola Mundo con Spring Boot por POST";
	}
	
	@PutMapping("/hola")
	public String put(){
		return "Hola Mundo con Spring Boot por PUT";
	}
}
