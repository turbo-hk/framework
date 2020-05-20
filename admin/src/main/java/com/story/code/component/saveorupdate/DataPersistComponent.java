package com.story.code.component.saveorupdate;

import java.util.Objects;
import lombok.Getter;

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

    public DataPersistComponent(T command, Long id) {
        this.command = command;
        this.id = id;
    }

    private PersistStrategyFunction createPersistStrategyFunction;
    private PersistStrategyFunction updatePersistStrategyFunction;
    private ValidatorFunction<T> validatorFunction;

    public DataPersistComponent addCreatePersistStrategyFunction(PersistStrategyFunction function) {
        this.createPersistStrategyFunction = function;
        return this;
    }

    public DataPersistComponent addUpdatePersistStrategyFunction(PersistStrategyFunction function) {
        this.updatePersistStrategyFunction = function;
        return this;
    }

    public void addValidatorFunction(ValidatorFunction<T> function) {
        this.validatorFunction = function;
    }

    public DataPersistComponent validate(ValidatorFunction function) {
        function.validate(command);
        return this;
    }

    public int persist() {
        if (Objects.nonNull(validatorFunction)) {
            validatorFunction.validate(this.command);
        }
        if (Objects.isNull(id)) {
            return this.createPersistStrategyFunction.persist();
        }
        return this.updatePersistStrategyFunction.persist();
    }

}
