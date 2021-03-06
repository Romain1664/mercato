package fr.formation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Le joueur n'a pu etre sélectionné")
public class JoueurValidationException extends RuntimeException  {

	
	private static final long serialVersionUID = 1L;
}
