package cinematograf.rest.services;

import entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import persistence.interfaces.IAdminRepository;

@CrossOrigin
@RestController
@RequestMapping("cinematograf/admins")
public class AdminController {
    @Autowired
    private IAdminRepository adminRepository;

    @RequestMapping( value = "", method= RequestMethod.GET)
    public ResponseEntity<?> login(
            @RequestParam("username") String username, @RequestParam("password") String password){
        Admin admin = adminRepository.findOne(username);
        if(admin.getPassword().equals(password)){
            return new ResponseEntity<Admin>(admin, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }

    }

}
