package GreenGrow.API.repositories;

import GreenGrow.API.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    //obtener todos los mensjes
    List<Message> findAll();



}
