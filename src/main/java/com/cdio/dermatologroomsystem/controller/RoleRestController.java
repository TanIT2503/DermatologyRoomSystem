package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.entity.Role;
import com.cdio.dermatologroomsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/role")
public class RoleRestController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> findAll(){
        List<Role> roles = roleService.findAll();
        if (roles.isEmpty()){
            return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Role>>(roles,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable("id") int id){
        try{
            Role role = roleService.findById(id);
            return new ResponseEntity<Role>(role, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return new ResponseEntity<Role>(roleService.addRole(role), HttpStatus.OK);
    }
}
