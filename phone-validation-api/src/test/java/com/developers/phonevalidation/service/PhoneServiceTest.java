package com.developers.phonevalidation.service;

import com.developers.phonevalidation.repository.CustomerRepository;
import com.developers.phonevalidation.validator.PhoneValidator;
import com.developers.phonevalidation.util.PhoneTestSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PhoneServiceTest extends PhoneTestSetup {

    @InjectMocks
    private PhoneService phoneService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private PhoneValidator phoneValidator;

    @BeforeEach
    public void setUp() {
            super.setUp();
    }


    @Test
    public void getAllValidPhoneNumbers() {
        when(customerRepository.findAll()).thenReturn(customerList);
        when(phoneValidator.validate(anyString())).thenReturn(true);
        Assertions.assertEquals(phoneService.getAllValidPhoneNumbers().size(),2);
    }


}
