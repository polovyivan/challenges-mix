package com.ivan.polovyi.challenges.beanvalidation.hibernate.dtos;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.constraints.br.TituloEleitoral;

@Data
@Builder
public class ValidationHibernateDTO {

    @CNPJ
    private String cnpj;

    @CPF
    private String cpf;

    @TituloEleitoral
    private String tituloElectoral;

    // Todo to be continue ...

}
