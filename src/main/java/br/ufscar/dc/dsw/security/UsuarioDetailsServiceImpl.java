package br.ufscar.dc.dsw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.ufscar.dc.dsw.dao.IGenericUsuarioDAO;
import br.ufscar.dc.dsw.domain.GenericUsuario;
 
public class UsuarioDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private IGenericUsuarioDAO dao;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        GenericUsuario usuario = dao.getGenericUserByUsername(username);
         
        if (usuario == null) {
            throw new UsernameNotFoundException("Could not find user");
            
        }
         
        return new UsuarioDetails(usuario);
    }
}