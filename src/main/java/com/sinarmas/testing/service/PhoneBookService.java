package com.sinarmas.testing.service;

import com.sinarmas.testing.dto.PhoneBookRequestDto;
import com.sinarmas.testing.dto.PhoneBookResponseDto;
import com.sinarmas.testing.entity.PhoneBook;
import com.sinarmas.testing.repository.PhoneBookRepository;
import lombok.*;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneBookService {

    private final PhoneBookRepository phoneBookRepository;
    private final MapperFacade mapperFacade;
    public List<PhoneBook> getAllPhoneBookData(){
        return phoneBookRepository.findAll();
    }
    public PhoneBook savePhoneBookData(PhoneBook phoneBook){
        return phoneBookRepository.save(phoneBook);
    }

    public void deletePhoneBookDataById(Long id){
        phoneBookRepository.deleteById(id);
    }

    public PhoneBookResponseDto updatePhoneBookDataById(Long id, PhoneBookRequestDto phoneBook){
        PhoneBook currentPhoneBookData = phoneBookRepository.findById(id).orElseGet(null);
        mapperFacade.map(phoneBook,currentPhoneBookData);
        PhoneBook newPhoneBookData = phoneBookRepository.save(currentPhoneBookData);
        return mapperFacade.map(newPhoneBookData,PhoneBookResponseDto.class);
    }

}
