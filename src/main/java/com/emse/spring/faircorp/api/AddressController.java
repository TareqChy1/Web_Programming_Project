package com.emse.spring.faircorp.api;
import com.emse.spring.faircorp.service.AddressSearchService;
import com.emse.spring.faircorp.service.dto.ApiGouvAddressDto;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;



@CrossOrigin
@RestController
@RequestMapping("/api/address")
@Transactional
public class AddressController{

    private final AddressSearchService address;

    public AddressController(AddressSearchService address) {
        this.address = address;
    }

    @GetMapping
    public List<ApiGouvAddressDto> findAll(@RequestParam List<String> keys) {
        return address.findAddress(keys);
    }


}
