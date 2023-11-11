package GreenGrow.API.controllers;

import GreenGrow.API.Shared.Config.MapperConfig;
import GreenGrow.API.entities.Dto.MessageRequestDto;
import GreenGrow.API.entities.Dto.Response.MessageResponseDto;
import GreenGrow.API.entities.Message;
import GreenGrow.API.services.MessageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/messages")
public class MessageController {


    private MessageService messageService;



    public MessageController(MessageService messageService) {
        this.messageService = messageService;

    }




    //metodo guardar mensaje
    @PostMapping("/save/{userId}")
    public ResponseEntity<MessageResponseDto> save(@Valid @RequestBody MessageRequestDto message, @PathVariable("userId") Long userId) {
        try {
            return new ResponseEntity<>(messageService.save(message, userId), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //obtener todos los mensajes

    @GetMapping("/all")
    public ResponseEntity<Iterable<MessageResponseDto>> getAll() {
        try {
            return new ResponseEntity<>(messageService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
