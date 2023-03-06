package com.sinarmas.testing.controller;

import com.sinarmas.testing.dto.PhoneBookRequestDto;
import com.sinarmas.testing.dto.PhoneBookResponseDto;
import com.sinarmas.testing.entity.PhoneBook;
import com.sinarmas.testing.service.PhoneBookService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone-book")
@RequiredArgsConstructor
public class PhoneBookController {

    private final PhoneBookService phoneBookService;
    private final MapperFacade mapperFacade;

    @GetMapping
    public ResponseEntity<List<PhoneBook>> getAllPhoneBookData(){
        List<PhoneBook> response = phoneBookService.getAllPhoneBookData();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveNewPhoneBookData(@RequestBody PhoneBookRequestDto phoneBookRequestDto){
        phoneBookService.savePhoneBookData(mapperFacade.map(phoneBookRequestDto,PhoneBook.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{phoneBookId}")
    public ResponseEntity<String> deletePhoneBookDataById(@PathVariable Long phoneBookId){
        phoneBookService.deletePhoneBookDataById(phoneBookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{phoneBookId}")
    public ResponseEntity<PhoneBookResponseDto> updatePhoneBookDataById(@PathVariable Long phoneBookId,
                                                                        @RequestBody PhoneBookRequestDto phoneBookRequestDto){
        return new ResponseEntity<>(phoneBookService.updatePhoneBookDataById(phoneBookId,phoneBookRequestDto),HttpStatus.OK);
    }
}
