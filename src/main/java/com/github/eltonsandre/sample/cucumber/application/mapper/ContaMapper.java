package com.github.eltonsandre.sample.cucumber.application.mapper;

import com.github.eltonsandre.sample.cucumber.application.dto.ContaDTO;
import com.github.eltonsandre.sample.cucumber.domain.model.Conta;
import org.mapstruct.Mapper;

@Mapper
public interface ContaMapper {

    Conta toModel(ContaDTO contaDTO);

    //    @Mapping(target = "saque", source = "")
//    @Mapping(target = "deposito", source = "")
    ContaDTO toDto(Conta conta);

}
