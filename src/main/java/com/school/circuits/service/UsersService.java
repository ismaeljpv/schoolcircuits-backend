package com.school.circuits.service;

import com.school.circuits.dto.PersonDto;
import com.school.circuits.dto.UserDto;
import com.school.circuits.entities.Person;
import com.school.circuits.entities.Users;
import com.school.circuits.exception.EntityNotFound;
import com.school.circuits.repository.PersonRepository;
import com.school.circuits.repository.UsersRepository;
import com.school.circuits.util.MailSender;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PersonRepository personRepository;


    private static final Logger logger = LoggerFactory.getLogger(UsersService.class);

    private MailSender mail = new MailSender();

    public Optional<Users> findOnlyUser(int idUser){
        Optional<Users> User = usersRepository.findById(idUser);
        if (!User.isPresent())
            throw new EntityNotFound("No hay resultado por el valor: " + idUser);
            return User;

    }

    public HashMap<String, Object> finfUser(int idUser){
        HashMap<String ,Object> Map = new HashMap<>();

        Users usuario = usersRepository.findById(idUser).get();
        Person persona = personRepository.findById(usuario.getIdpersona()).get();
        UserDto userDto = new UserDto(usuario.getIdusuario(), usuario.getNombreusuario(), usuario.getCorreo(), usuario.getIdpersona(), usuario.getPerfil());

        Map.put("User", userDto);
        Map.put("Person", persona);

        return Map;
    }

    public Users updateUser(Integer idUser, Users user){
        Optional<Users> updateUser = usersRepository.findById(idUser);
        if (!updateUser.isPresent()){
            throw new EntityNotFound("No hay resultado por el valor: " + idUser);
        }else{
            usersRepository.save(user);
            return user;
        }
    }

    public ArrayList findUsers(){

        ArrayList FullUsers = new ArrayList();
        List<Users> usuarios = usersRepository.findAll();

        for(int i=0; i< usuarios.size(); i++){
            Users user = usuarios.get(i);
            Integer idpersona = user.getIdpersona();
            Person persona = personRepository.findById(idpersona).get();
            UserDto userDto = new UserDto(user.getIdusuario(), user.getNombreusuario(), user.getCorreo(), user.getIdpersona(), user.getPerfil());
            PersonDto personDto = new PersonDto(persona.getIdpersona(), persona.getCedula(), persona.getNacionalidad(), persona.getApellido1(), persona.getNombre1());
            HashMap<String ,Object> Map = new HashMap<>();
            Map.put("User", userDto);
            Map.put("Person", personDto);

            FullUsers.add(i, Map);

        }
        return FullUsers;
    }

    public Users saveUser (Users user){
        return usersRepository.save(user);
    }

    public void deleteUser(Integer id){
        Optional<Users> deletedUser = usersRepository.findById(id);
        if (!deletedUser.isPresent()) {
            throw new EntityNotFound("No hay resultado por el valor: " + id);
        }else {

            usersRepository.deleteById(id);
        }
    }

      public boolean mailSender(String correo, String nombre, String asunto, String mensaje){
        return mail.send(correo, nombre, asunto, mensaje);
      }


    // Coversion a PersonDto
    private UserDto convertToUsersDto(Users user) {
        return new ModelMapper().map(user, UserDto.class);
    }

}
