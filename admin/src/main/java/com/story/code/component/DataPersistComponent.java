package com.story.code.component;

import java.util.Objects;
import lombok.Getter;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/18 by Storys.Zhang
 */
public class DataPersistComponent<T, D> {

    /**
     * 请求参数对象
     */
    @Getter
    private T command;

    /**
     * 请求参数ID
     */
    private Long id;

    /**
     * 根据ID查询出来的数据库对象，id为null时data=null
     */
    private D data;

    public DataPersistComponent(T command, Long id) {
        this.command = command;
        this.id = id;
    }

    private PersistStrategyFunction<DataPersistComponent<T, D>> createPersistStrategyFunction;
    private PersistStrategyFunction<DataPersistComponent<T, D>> updatePersistStrategyFunction;
    private ValidatorFunction<T> validatorFunction;

    public DataPersistComponent addCreatePersistStrategyFunction(PersistStrategyFunction<DataPersistComponent<T, D>> function) {
        this.createPersistStrategyFunction = function;
        return this;
    }

    public DataPersistComponent addUpdatePersistStrategyFunction(PersistStrategyFunction<DataPersistComponent<T, D>> function) {
        this.updatePersistStrategyFunction = function;
        return this;
    }

    public void addValidatorFunction(ValidatorFunction<T> function) {
        this.validatorFunction = function;
    }

    public DataPersistComponent validate(ValidatorFunction<T> function) {
        function.validate(command);
        return this;
    }

    public Mono<Integer> persist() {
        if (Objects.nonNull(validatorFunction)) {
            validatorFunction.validate(this.command);
        }
        if (Objects.isNull(id)) {
            return this.createPersistStrategyFunction.persist();
        }
        return this.updatePersistStrategyFunction.persist();
    }

    @FunctionalInterface
    public interface PersistStrategyFunction<DataPersistComponent> {

        /**
         * 持久化
         *
         * @return
         */
        Mono<Integer> persist();
    }

    @FunctionalInterface
    public interface ValidatorFunction<T> {

        /**
         * 验证
         *
         * @param t
         */
        void validate(T t);
    }

}
