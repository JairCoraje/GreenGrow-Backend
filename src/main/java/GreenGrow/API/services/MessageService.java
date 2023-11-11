package GreenGrow.API.services;

import GreenGrow.API.entities.Dto.MessageRequestDto;
import GreenGrow.API.entities.Dto.Response.MessageResponseDto;
import GreenGrow.API.entities.Message;

import java.util.List;

public interface MessageService {


    //Guardar un mensaje
    MessageResponseDto save(MessageRequestDto message, Long userId) throws Exception;


    //obtener todos los mensajes



    List<MessageResponseDto> getAll() throws Exception;
}
