package servicio;

import datos.UsuarioDao;
import domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
public class UsuarioServiceImpl implements UsuarioService, UsuarioServiceRemote{
    
    @Inject
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAllUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
        return usuarioDao.findUsuarioById(usuario);
    }

    @Override
    public Usuario encontrarUsuarioPorUsername(Usuario usuario) {
        return usuarioDao.findUsuarioByUsername(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDao.insertUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioDao.updateUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.deleteUsuario(usuario);
    }

}
