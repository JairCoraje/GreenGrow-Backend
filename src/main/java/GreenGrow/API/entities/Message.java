package GreenGrow.API.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {
    //Hare un chat general que se llamara comunidad
    //Un chat para todos los usuarios
    //Un usuario puede enviar mensajes a la comunidad
    //un usuariop puded enviar muchos mensajes, pero un mensaje solo puede pertenecer a un usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "messagedate", nullable = false)
    private LocalDateTime messageDate; // Cambiado a LocalDateTime


    //autor del mensaje
    @Column(name = "author", nullable = false)
    private String author;


    //nombre de la columna
    @ManyToOne
    @JoinColumn(name = "user_id") // Usar @JoinColumn en lugar de @Column
    private User user;




}
