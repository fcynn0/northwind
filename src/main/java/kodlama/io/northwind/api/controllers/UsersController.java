package kodlama.io.northwind.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.northwind.business.abstracts.UserService;
import kodlama.io.northwind.core.entites.User;
import kodlama.io.northwind.core.utilities.ErrorDataResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users/")
@AllArgsConstructor
public class UsersController {
    private UserService userService;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody @Valid User user){
        return ResponseEntity.ok( this.userService.add(user));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors=new HashMap<String ,String >();
        for (FieldError fieldError:exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object>erros =new ErrorDataResult<Object>(validationErrors,"doğrulama hataları");
        return erros;
    }
}
