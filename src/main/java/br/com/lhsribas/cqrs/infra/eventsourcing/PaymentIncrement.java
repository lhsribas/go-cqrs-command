package br.com.lhsribas.cqrs.infra.eventsourcing;

final class PaymentIncrement {

    public String key;
    public String value;

    public PaymentIncrement(final String key, final String value) {
        this.key = key;
        this.value = value;
    }

    public PaymentIncrement() {
    }

}
