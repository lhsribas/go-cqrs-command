package br.com.lhsribas.cqrs.infra.eventsourcing;

import io.quarkus.redis.client.RedisClient;
import io.quarkus.redis.client.reactive.ReactiveRedisClient;

import javax.inject.Inject;
import javax.inject.Singleton;
import org.jboss.logging.Logger;

import java.util.Arrays;

@Singleton
final class PaymentIncremenService {

    private static final Logger LOG = Logger.getLogger(PaymentIncremenService.class);

    @Inject
    RedisClient redisClient;

    @Inject
    ReactiveRedisClient reactiveRedisClient;

    public void increment(String key, String incrementBy) {
        LOG.info("Content >> "+incrementBy+", Key >> "+key);
        try{
            redisClient.set(Arrays.asList(key, incrementBy ));
        }catch (Exception e){
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
