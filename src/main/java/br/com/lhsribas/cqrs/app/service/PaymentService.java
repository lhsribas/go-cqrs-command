package br.com.lhsribas.cqrs.app.service;

import br.com.lhsribas.cqrs.app.dto.PaymentRequest;
import br.com.lhsribas.cqrs.app.dto.PaymentResponse;
import br.com.lhsribas.cqrs.app.mapper.PaymentRequestMapper;
import br.com.lhsribas.cqrs.app.mapper.PaymentResponseMapper;
import br.com.lhsribas.cqrs.domain.usecase.SavePaymentUseCase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PaymentService {

    @Inject
    private SavePaymentUseCase savePaymentUseCase;

    public PaymentResponse save(final PaymentRequest request){
        return PaymentResponseMapper.toResponse(savePaymentUseCase.save(PaymentRequestMapper.toEntity(request)));
    }
}
