package com.school.circuits.resource;


import com.school.circuits.dto.UserDto;
import com.school.circuits.entities.Users;
import com.school.circuits.service.UsersService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {

    private UsersService usersService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsersResource(UsersService usersService, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.usersService = usersService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public Users signUp(@RequestBody Users user) {
        user.setClave(bCryptPasswordEncoder.encode(user.getClave()));
        return usersService.saveUser(user);
    }

    @GetMapping( value = "/getAllInfo")
    public ArrayList findUsers(){
        return usersService.findUsers();
    }

    @GetMapping( value ="/getOnlyUser/{idUser}")
    public Optional<Users> findOnlyUser(@PathVariable int idUser){
        return usersService.findOnlyUser(idUser);
    }

    @GetMapping( value="/getUser/{idUser}")
    public HashMap<String, Object> findUser(@PathVariable int idUser){
        return usersService.finfUser(idUser);
    }

    @PutMapping(value = "/updateUser/{idUser}")
    public Users updateUser(@RequestBody Users user,
                            @PathVariable Integer idUser){
        user.setClave(bCryptPasswordEncoder.encode(user.getClave()));
        return usersService.updateUser(idUser, user);
    }

    @DeleteMapping(value = "/deleteUser/{idUser}")
    public void deleteUser(@PathVariable Integer idUser){
        usersService.deleteUser(idUser);
    }

  @PostMapping(value ="/sendMail")
  public boolean sendMail (@RequestBody Map<String, Object> json){
    String correo = (String) json.get("correo");
    String nombre = (String) json.get("nombre");
    String asunto = (String) json.get("asunto");
    String mensaje = (String) json.get("mensaje");
    return usersService.mailSender(correo,nombre,asunto, mensaje);
  }


}
