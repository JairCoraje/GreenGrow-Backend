package GreenGrow.API.services.impl;

import GreenGrow.API.Shared.Config.MapperConfig;
import GreenGrow.API.entities.Dto.MessageRequestDto;
import GreenGrow.API.entities.Dto.Response.MessageResponseDto;
import GreenGrow.API.entities.Message;
import GreenGrow.API.entities.User;
import GreenGrow.API.repositories.MessageRepository;
import GreenGrow.API.repositories.UserRepository;
import GreenGrow.API.services.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class ImplMessageService implements MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    private ModelMapper modelMapper;

    public ImplMessageService(MessageRepository messageRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }



    //Guardar un mensaje
    @Override
    public MessageResponseDto save(MessageRequestDto message, Long userId) throws Exception {
        var user = userRepository.findById(userId);

        if(user.isEmpty()){
            throw new Exception("User not found");
        }
        //mapear del dtoreques a la entidad

        var message1= modelMapper.map(message, Message.class);


        message1.setUser(user.get());
        message1.setAuthor(user.get().getUsername());

        message1.setMessageDate(LocalDateTime.now());

        var message2 = messageRepository.save(message1);

        //mapear al repsonse
        var messageResponse = modelMapper.map(message2, MessageResponseDto.class);


        return messageResponse;
    }

    //obtener todos los mensajes

    @Override
    public List<MessageResponseDto> getAll() throws Exception {

        List<Message> messages = messageRepository.findAll();

        // Crear una lista para almacenar los resultados mapeados
        List<MessageResponseDto> messageResponseDtos = new ArrayList<>();

        // Iterar sobre cada entidad Message y mapearla a MessageResponseDto
        for (Message message : messages) {
            MessageResponseDto messageResponseDto = modelMapper.map(message, MessageResponseDto.class);
            messageResponseDtos.add(messageResponseDto);
        }

        return messageResponseDtos;
    }
}
