package br.com.lhsribas.cqrs.infra.eventsourcing;

import io.quarkus.redis.client.RedisClient;
import io.quarkus.redis.client.reactive.ReactiveRedisClient;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
final class PaymentIncremenService {

    @Inject
    RedisClient redisClient;

    @Inject
    ReactiveRedisClient reactiveRedisClient;

    public void increment(String key, byte[] incrementBy) {

        redisClient.setbit(key, "customer1", incrementBy.toString());
    }
}
