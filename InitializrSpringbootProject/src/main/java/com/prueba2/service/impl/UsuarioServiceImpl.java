package com.prueba2.service.impl;

import com.prueba2.dao.RolDao;
import com.prueba2.dao.UsuarioDao;
import com.prueba2.domain.Rol;
import com.prueba2.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.prueba2.service.UsuarioService;
import jakarta.persistence.EntityManager;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private RolDao rolDao;
    
     private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario().toString()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.existsByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional
    public void save(Usuario usuario, int i) {
        usuario.setActivo(1);
        usuario=usuarioDao.save(usuario);
        
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public void save2(Usuario usuario, int i) {
        usuario.setActivo(1);
        usuario=usuarioDao.save(usuario);
        Long idUsuario = usuario.getIdUsuario(); 
        if (i == 1 && idUsuario != null) { 
        Rol rol = new Rol();
        rol.setNombre("ROLE_USER");
        rol.setIdUsuario(idUsuario);
        rolDao.save(rol); 
        }
    }
  
}
