package com.emse.spring.faircorp.service;
import com.emse.spring.faircorp.service.dto.ApiGouvAddressDto;
import com.emse.spring.faircorp.service.dto.ApiGouvFeatureDto;
import com.emse.spring.faircorp.service.dto.ApiGouvResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(AddressSearchService.class)
class AddressSearchServiceTest {
    @Autowired
    private AddressSearchService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockRestServiceServer server;

    @Test
    void shouldFindAddresses() throws JsonProcessingException {
        
        ApiGouvResponseDto expectedResponse = simulateApiResponse();

        String expectedUrl = UriComponentsBuilder
                .fromUriString("/search")
                .queryParam("q", "cours+fauriel")
                .queryParam("limit", 15)
                .build()
                .toUriString();

        this.server
                .expect(requestTo(expectedUrl))
                .andRespond(withSuccess(objectMapper.writeValueAsString(expectedResponse), MediaType.APPLICATION_JSON));
        
        List<ApiGouvAddressDto> addresses = this.service.findAddress(List.of("cours", "fauriel"));

        
        Assertions
                .assertThat(addresses)
                .hasSize(1)
                .extracting(ApiGouvAddressDto::getCity)
                .contains("Saint Etienne");
    }

    private ApiGouvResponseDto simulateApiResponse() {
        ApiGouvAddressDto expectedAddress = new ApiGouvAddressDto();
        expectedAddress.setCity("Saint Etienne");

        ApiGouvFeatureDto expectedFeature = new ApiGouvFeatureDto();
        expectedFeature.setProperties(expectedAddress);

        ApiGouvResponseDto expectedResponse = new ApiGouvResponseDto();
        expectedResponse.setFeatures(List.of(expectedFeature));

        return expectedResponse;
    }
}