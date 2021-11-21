package com.zjq.gatewayservice.filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @author zjq
 *  全局过滤器必须实现两个接口：GlobalFilter、Ordered
 *  GlobalFilter是全局过滤器接口，实现类要实现filter()方法进行功能扩展
 *  Ordered接口用于排序，通过实现getOrder()方法返回整数代表执行当前过滤器的前后顺序
 */
@Component //自动实例化并被Spring IOC容器管理
public class ElapsedFilter implements GlobalFilter, Ordered {
    /**基于slf4j.Logger实现日志输出*/
    private static final Logger logger = LoggerFactory.getLogger(ElapsedFilter.class);
    /**
     * 起始时间属性名
     */
    private static final String ELAPSED_TIME_BEGIN = "elapsedTimeBegin";

    /**
     * 实现filter()方法记录处理时间
     * @param exchange 用于获取与当前请求、响应相关的数据，以及设置过滤器间传递的上下文数据
     * @param chain Gateway过滤器链对象
     * @return Mono对应一个异步任务，因为Gateway是基于Netty Server异步处理的,Mono对就代表异步处理完毕的情况。
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //Pre前置处理部分
        //在请求到达时，往ServerWebExchange上下文环境中放入了一个属性elapsedTimeBegin，保存请求执行前的时间戳
        exchange.getAttributes().put(ELAPSED_TIME_BEGIN, System.currentTimeMillis());


        //chain.filter(exchange).then()对应Post后置处理部分
        //当响应产生后，记录结束与elapsedTimeBegin起始时间比对，获取RESTful API的实际执行时间
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> { //当前过滤器得到响应时，计算并打印时间
                    Long startTime = exchange.getAttribute(ELAPSED_TIME_BEGIN);
                    if (startTime != null) {
                        logger.info(exchange.getRequest().getRemoteAddress() //远程访问的用户地址
                                + " | " +  exchange.getRequest().getPath()  //Gateway URI
                                + " | cost " + (System.currentTimeMillis() - startTime) + "ms"); //处理时间
                    }
                })
        );
    }

    //设置为最高优先级，最先执行ElapsedFilter过滤器
    //return Ordered.LOWEST_PRECEDENCE; 代表设置为最低优先级
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
