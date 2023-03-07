package arg.com.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="usuario")
@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Rol> roles;

}

