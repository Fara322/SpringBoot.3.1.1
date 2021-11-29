package ru.mustafin.springBootCrud.service;

import ru.mustafin.springBootCrud.DAO.RoleRepository;
import ru.mustafin.springBootCrud.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }


    @Override
    public Set<Role> findByIdRoles(List<Long> roles) {
      return new HashSet<>(roleRepository.findAllById(roles));
    }
}
